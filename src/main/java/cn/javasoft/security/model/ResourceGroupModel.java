/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-3-9 上午11:04:44
 * Copyright (c) 2013 - 2014.版权所有
 * 代码由黄雄星独立完成。注意：如需使用项目代码需经本人同意方可使用。
 ******************************************************************************/
package cn.javasoft.security.model;

import java.util.List;

import cn.javasoft.BaseModelObject;

/**
 * <P>TODO</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public class ResourceGroupModel extends BaseModelObject {

	/**
	 * TODO
	 */
	private static final long serialVersionUID = -8425413667000210161L;

	/** 资源组名称 **/
	private String groupName;

	/** 资源组描述 **/
	private String groupDes;

	/** 资源集合 **/
	private List<ResourceModel> resourceModels;

	/**
	 * @return the resourceModels
	 */
	public List<ResourceModel> getResourceModels() {
		return resourceModels;
	}

	/**
	 * @param resourceModels the resourceModels to set
	 */
	public void setResourceModels(List<ResourceModel> resourceModels) {
		this.resourceModels = resourceModels;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the groupDes
	 */
	public String getGroupDes() {
		return groupDes;
	}

	/**
	 * @param groupDes the groupDes to set
	 */
	public void setGroupDes(String groupDes) {
		this.groupDes = groupDes;
	}

	/**
	 * @see com.roki.model.base.BaseModelObject#onSave()
	 */
	@Override
	public void onSave() {
	}

	/**
	 * @see com.roki.model.base.BaseModelObject#onUpdate()
	 */
	@Override
	public void onUpdate() {
	}

}
