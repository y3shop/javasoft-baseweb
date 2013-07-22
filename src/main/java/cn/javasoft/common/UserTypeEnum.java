/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-7-22 下午3:20:33
 * Copyright (c) 2013 - 2014.JAVASOF.CN公司版权所有
 * 注意：本内容仅限JAVASOFT.CN公司内部使用或者具有JAVASOFT.CN公司授权才可使用
 ******************************************************************************/
package cn.javasoft.common;

/**
 * <P>用户类型</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public enum UserTypeEnum {

	ADMIN(1, "管理员"), MERCHANT(2, "商户"), SUPERADMIN(3, "超级管理员");

	private int type;
	private String describe;

	private UserTypeEnum(int type, String describe) {
		this.type = type;
		this.describe = describe;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the describe
	 */
	public String getDescribe() {
		return describe;
	}

	/**
	 * @param describe the describe to set
	 */
	public void setDescribe(String describe) {
		this.describe = describe;
	}

}
