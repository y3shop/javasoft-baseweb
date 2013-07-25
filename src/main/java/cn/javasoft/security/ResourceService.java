/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-7-22 下午2:57:14
 * Copyright (c) 2013 - 2014.JAVASOF.CN公司版权所有
 * 注意：本内容仅限JAVASOFT.CN公司内部使用或者具有JAVASOFT.CN公司授权才可使用
 ******************************************************************************/
package cn.javasoft.security;

import java.util.List;

import cn.javasoft.security.model.ResourceModel;
import cn.javasoft.security.model.UserModel;

/**
 * <P>TODO</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public interface ResourceService {

	List<ResourceModel> selectAllResource();

	List<ResourceModel> selectAllByUserId(String userId);

	List<ResourceModel> selectRolesModelByUserId(String userId);

	UserModel selectAllByUsername(String userName);

}
