/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-03-09 12:08:193
 * Copyright (c) 2013 - 2014.版权所有
 * 代码由黄雄星独立完成。注意：如需使用项目代码需经本人同意方可使用。
 ******************************************************************************/
package cn.javasoft.security.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.javasoft.BaseMapper;
import cn.javasoft.security.model.ResourceGroupModel;

/**
 * * <P>TODO</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
@Repository("ResourceGroupMapper")
public interface ResourceGroupMapper extends BaseMapper<ResourceGroupModel> {

	List<ResourceGroupModel> queryAllResourceGroupAndResource();

}
