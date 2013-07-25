/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-3-18 下午10:28:30
 * Copyright (c) 2013 - 2014.版权所有
 * 代码由黄雄星独立完成。注意：如需使用项目代码需经本人同意方可使用。
 ******************************************************************************/
package cn.javasoft.cache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import cn.javasoft.common.Constant;
import cn.javasoft.security.ResourceService;
import cn.javasoft.security.model.ResourceModel;
import cn.javasoft.security.model.UserModel;

/**
 * <P>TODO</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public class UserResourcesCache {

	@Autowired
	private transient ResourceService resourceService;

	@Cacheable(value = Constant.CACHE_NAME, key = "#userModel.getId()")
	public List<GrantedAuthority> getAllResourcesById(UserModel userModel) {
		// System.out.println("测试缓存是否成功");
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// 依据用户id得到所有资源
		List<ResourceModel> resourceModels = resourceService.selectAllByUserId(userModel.getId());
		// 依据用户id得到所有角色
		List<ResourceModel> resourceModels2 = resourceService.selectRolesModelByUserId(userModel.getId());
		Set<String> set = new HashSet<String>();
		for (ResourceModel resourceModel : resourceModels2) {
			set.add(resourceModel.getRecCode());
		}
		for (ResourceModel resourceModel : resourceModels) {
			set.add(resourceModel.getRecCode());
		}
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			authorities.add(new GrantedAuthorityImpl(iterator.next()));
		}
		return authorities;
	}

	@CacheEvict(value = Constant.CACHE_NAME, key = "#userModel.getId()")
	public void clearAllResourcesById(UserModel userModel) {
	}

	@CacheEvict(value = Constant.CACHE_NAME, allEntries = true)
	public void clearAllCache() {
	}
}
