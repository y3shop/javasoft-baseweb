/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import cn.javasoft.common.Pager;
import cn.javasoft.common.WebCommonUtils;
import cn.javasoft.security.model.UserModel;

/**
 * @author huangxiongxing
 * 
 *         2013-1-11 下午10:51:32
 */
public class BaseDBService<T extends BaseModelObject> {

	private static final Logger log = LoggerFactory.getLogger(BaseDBService.class);

	private BaseMapper<T> baseMapper;

	/**
	 * @param baseMapper the baseMapper to set
	 */
	protected void setBaseMapper(BaseMapper<T> baseMapper) {
		this.baseMapper = baseMapper;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 3)
	public T selectAllById(String id) {
		Assert.isTrue(StringUtils.isNotBlank(id), "调用selectAllById,请检查id是否为null或者空");
		return baseMapper.queryModelById(id);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 3)
	public List<T> selectAll() {
		return baseMapper.queryModel();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 3)
	public Pager<T> selectByPager(Pager<T> pager) {
		pager.setTotalCount(baseMapper.queryCount());
		pager.setResult(baseMapper.queryByPager((pager.getPageNumber() - 1) * pager.getPageSize(), pager.getPageSize()));
		return pager;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 3)
	public Pager<T> selectByPagerAndUserId(Pager<T> pager) {
		UserModel userModel = getUsermodel();
		if (userModel == null)
			return pager;
		pager.setTotalCount(baseMapper.queryCountByUserId(userModel.getId()));
		pager.setResult(baseMapper.queryByPagerAndUserId((pager.getPageNumber() - 1) * pager.getPageSize(),
				pager.getPageSize(), userModel.getId()));
		return pager;
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 3)
	public int selectCount() {
		return baseMapper.queryCount();
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 3, rollbackFor = Exception.class)
	public int save(T t) {
		Assert.notNull(t, "调用save，请检查对象是否为空");
		t.setCreateTime(new Date());
		if (StringUtils.isBlank(t.getId()))
			t.setId(WebCommonUtils.getSequence());
		UserModel user = getUsermodel();
		if (user != null) {
			t.setCreator(user.getId());
		}
		if (log.isDebugEnabled()) {
			log.debug("save model[{}]", t.toString());
		}
		Method method;
		try {
			method = t.getClass().getMethod(BaseModelObject.ON_SAVE_METHOD_NAME);
			method.invoke(t);
		} catch (Exception e) {
			log.error(String.format("model[%s]onSave异常", t.toString()), e);
		}
		return baseMapper.insertSelector(t);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 3, rollbackFor = Exception.class)
	public int update(T t) {
		Assert.notNull(t, "调用update，请检查对象是否为空");
		t.setUpdateTime(new Date());
		if (log.isDebugEnabled()) {
			log.debug("update model[{}]", t.toString());
		}
		Method method;
		try {
			method = t.getClass().getMethod(BaseModelObject.ON_UPDATE_METHOD_NAME);
			method.invoke(t);
		} catch (Exception e) {
			log.error(String.format("model[%s]onUpdate异常", t.toString()), e);
		}
		return baseMapper.updateSelectorById(t);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 3, rollbackFor = Exception.class)
	public void deleteList(List<String> ids) {
		Assert.notNull(ids, "调用deleteList，请检查对象是否为空");
		if (log.isDebugEnabled()) {
			log.debug("deleteList model[{}]", ids.toString());
		}
		for (String id : ids) {
			baseMapper.deleteById(id);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED, timeout = 3, rollbackFor = Exception.class)
	public void delete(String id) {
		Assert.notNull(id, "调用delete，请检查对象是否为空");
		if (log.isDebugEnabled()) {
			log.debug("delete model[{}]", id.toString());
		}
		baseMapper.deleteById(id);
	}

	/**
	 * 
	 * <p>得到用户信息</p>
	 * 
	 * @return
	 * 
	 */
	public UserModel getUsermodel() {
		Authentication authentication = SecurityContextHolder.getContextHolderStrategy().getContext()
				.getAuthentication();
		if (authentication != null) {
			Object object = authentication.getPrincipal();
			if (object != null && object instanceof UserModel) {
				return (UserModel) object;
			}
		}
		return null;
	}
}
