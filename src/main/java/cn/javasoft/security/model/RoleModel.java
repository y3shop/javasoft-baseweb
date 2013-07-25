/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft.security.model;

import java.util.List;

import cn.javasoft.BaseModelObject;

/**
 * @author huangxiongxing
 * 
 *         2013-1-9 下午10:33:04
 */
public class RoleModel extends BaseModelObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1202739072340783949L;

	/** 角色名称 **/
	private String roleName;

	/** 角色编码 **/
	private String roleCode;

	/** 角色描述 **/
	private String roleDescirbe;

	/** 权限资源 **/
	private List<String> resourceList;

	/** 权限资源 **/
	private List<ResourceRoleModel> resourceRoleModels;

	/**
	 * @return the resourceRoleModels
	 */
	public List<ResourceRoleModel> getResourceRoleModels() {
		return resourceRoleModels;
	}

	/**
	 * @param resourceRoleModels the resourceRoleModels to set
	 */
	public void setResourceRoleModels(List<ResourceRoleModel> resourceRoleModels) {
		this.resourceRoleModels = resourceRoleModels;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleDescirbe() {
		return roleDescirbe;
	}

	public void setRoleDescirbe(String roleDescirbe) {
		this.roleDescirbe = roleDescirbe;
	}

	/**
	 * @return the resourceList
	 */
	public List<String> getResourceList() {
		return resourceList;
	}

	/**
	 * @param resourceList the resourceList to set
	 */
	public void setResourceList(List<String> resourceList) {
		this.resourceList = resourceList;
	}

	@Override
	public void onSave() {

	}

	@Override
	public void onUpdate() {
	}

}
