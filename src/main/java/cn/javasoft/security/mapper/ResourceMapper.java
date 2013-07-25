/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-2-24 下午04:05:33
 * Copyright (c) 2013 - 2014.版权所有
 * 代码由黄雄星独立完成。注意：如需使用项目代码需经本人同意方可使用。
 ******************************************************************************/
package cn.javasoft.security.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.javasoft.BaseMapper;
import cn.javasoft.security.model.ResourceModel;

/**
 * <P>TODO</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
@Repository("ResourceMapper")
public interface ResourceMapper extends BaseMapper<ResourceModel> {

	List<ResourceModel> queryModelByUserId(@Param("userId") String userId);

	List<ResourceModel> queryRolesModelByUserId(@Param("userId") String userId);

}
