/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft.security.model;

import cn.javasoft.BaseObject;

/**
 * @author huangxiongxing
 * 
 *         2013-1-9 下午10:44:39
 */
public class ResourceRoleModel extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4070193912518025670L;

	/** ID **/
	private String id;

	/** 资源ID **/
	private String resourceId;

	/** 角色ID **/
	private String roleId;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the resourceId
	 */
	public String getResourceId() {
		return resourceId;
	}

	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the roleId
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

}
