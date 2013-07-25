/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft.security.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import cn.javasoft.BaseModelObject;
import cn.javasoft.common.UserTypeEnum;

/**
 * @author huangxiongxing
 * 
 *         2013-1-3 下午1:23:25
 */
public class UserModel extends BaseModelObject implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6737595771460061065L;

	/** 权限集合 **/
	private Collection<? extends GrantedAuthority> authorities;

	/** 密码 **/
	private String password;

	/** 用户名 **/
	private String username;

	/** 商户ID **/
	private String merchantId;

	/** 登陆IP **/
	private String loginIp;

	/** 最后登录时间 **/
	private Date loginTime;

	/** 电子邮箱 **/
	private String email;

	/** 用户类型 @see UserTypeEnum **/
	private Integer userType;

	/** 是否账号没有过期 **/
	private Boolean isAccountNonExpired;

	/** 是否账号没有锁 **/
	private Boolean isAccountNonLocked;

	/** 是否 证书没过期 **/
	private Boolean isCredentialsNonExpired;

	/** 是否激活有效 **/
	private Boolean isEnabled;

	/** 角色集合 **/
	private List<String> roleIds;

	/** 角色集合 **/
	private List<UserRoleModel> userRoleModels;

	public List<UserRoleModel> getUserRoleModels() {
		return userRoleModels;
	}

	public void setUserRoleModels(List<UserRoleModel> userRoleModels) {
		this.userRoleModels = userRoleModels;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return isAccountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return isEnabled;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	/**
	 * @return the isAccountNonExpired
	 */
	public Boolean getIsAccountNonExpired() {
		return isAccountNonExpired;
	}

	/**
	 * @param isAccountNonExpired the isAccountNonExpired to set
	 */
	public void setIsAccountNonExpired(Boolean isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	/**
	 * @return the isAccountNonLocked
	 */
	public Boolean getIsAccountNonLocked() {
		return isAccountNonLocked;
	}

	/**
	 * @param isAccountNonLocked the isAccountNonLocked to set
	 */
	public void setIsAccountNonLocked(Boolean isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	/**
	 * @return the isCredentialsNonExpired
	 */
	public Boolean getIsCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	/**
	 * @param isCredentialsNonExpired the isCredentialsNonExpired to set
	 */
	public void setIsCredentialsNonExpired(Boolean isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	/**
	 * @param isEnabled the isEnabled to set
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	@Override
	public void onSave() {
		if (isAccountNonExpired == null)
			isAccountNonExpired = true;
		if (isAccountNonLocked == null)
			isAccountNonLocked = true;
		if (isCredentialsNonExpired == null)
			isCredentialsNonExpired = true;
		if (isEnabled == null)
			isEnabled = false;
		if (userType.intValue() != UserTypeEnum.MERCHANT.getType())
			merchantId = "0";
	}

	@Override
	public void onUpdate() {
		if (userType.intValue() != UserTypeEnum.MERCHANT.getType())
			merchantId = "0";
	}

}
