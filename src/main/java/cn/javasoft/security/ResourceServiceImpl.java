/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-7-25 下午9:02:32
 * Copyright (c) 2013 - 2014.JAVASOF.CN公司版权所有
 * 注意：本内容仅限JAVASOFT.CN公司内部使用或者具有JAVASOFT.CN公司授权才可使用
 ******************************************************************************/
package cn.javasoft.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cn.javasoft.security.mapper.ResourceMapper;
import cn.javasoft.security.mapper.UserMapper;
import cn.javasoft.security.model.ResourceModel;
import cn.javasoft.security.model.UserModel;

/**
 * <P>TODO</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public class ResourceServiceImpl extends JdbcDaoSupport implements ResourceService {

	@Autowired
	@Qualifier("UserService")
	private transient UserMapper userMapper;

	@Autowired
	@Qualifier("ResourceMapper")
	private transient ResourceMapper resourceMapper;

	/**
	 * @see cn.javasoft.security.ResourceService#selectAllResource()
	 */
	@Override
	public List<ResourceModel> selectAllResource() {
		return resourceMapper.queryModel();
	}

	/**
	 * @see cn.javasoft.security.ResourceService#selectAllByUserId(java.lang.String)
	 */
	@Override
	public List<ResourceModel> selectAllByUserId(String userId) {
		return resourceMapper.queryModelByUserId(userId);
	}

	/**
	 * @see cn.javasoft.security.ResourceService#selectRolesModelByUserId(java.lang.String)
	 */
	@Override
	public List<ResourceModel> selectRolesModelByUserId(String userId) {
		return resourceMapper.queryRolesModelByUserId(userId);
	}

	/**
	 * @see cn.javasoft.security.ResourceService#selectAllByUsername(java.lang.String)
	 */
	@Override
	public UserModel selectAllByUsername(String userName) {
		return userMapper.queryAllByUsername(userName);
	}

}
