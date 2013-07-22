/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft.security;

import cn.javasoft.BaseModelObject;

/**
 * 
 * <P>资源</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public class ResourceModel extends BaseModelObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1202739072340783949L;

	/** 资源名称 **/
	private String recName;

	/** 资源URL **/
	private String recURL;

	/** 资源CODE **/
	private String recCode;

	/** 资源组id **/
	private String resourceGroupId;

	/** 资源组名称 **/
	private String resourceGroupName;

	/**
	 * @return the resourceGroupName
	 */
	public String getResourceGroupName() {
		return resourceGroupName;
	}

	/**
	 * @param resourceGroupName the resourceGroupName to set
	 */
	public void setResourceGroupName(String resourceGroupName) {
		this.resourceGroupName = resourceGroupName;
	}

	/**
	 * @return the resourceGroupId
	 */
	public String getResourceGroupId() {
		return resourceGroupId;
	}

	/**
	 * @param resourceGroupId the resourceGroupId to set
	 */
	public void setResourceGroupId(String resourceGroupId) {
		this.resourceGroupId = resourceGroupId;
	}

	/**
	 * @return the recName
	 */
	public String getRecName() {
		return recName;
	}

	/**
	 * @param recName the recName to set
	 */
	public void setRecName(String recName) {
		this.recName = recName;
	}

	/**
	 * @return the recURL
	 */
	public String getRecURL() {
		return recURL;
	}

	/**
	 * @param recURL the recURL to set
	 */
	public void setRecURL(String recURL) {
		this.recURL = recURL;
	}

	/**
	 * @return the recCode
	 */
	public String getRecCode() {
		return recCode;
	}

	/**
	 * @param recCode the recCode to set
	 */
	public void setRecCode(String recCode) {
		this.recCode = recCode;
	}

	@Override
	public void onSave() {
	}

	@Override
	public void onUpdate() {
	}
}
