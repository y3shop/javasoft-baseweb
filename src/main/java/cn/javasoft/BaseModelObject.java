/**
 * 此代码由黄雄星独立完成，如需使用请经过本人同意。版权所有，侵权必究
 */
package cn.javasoft;

import java.util.Date;

/**
 * @author huangxiongxing
 * 
 *         2013-1-9 下午10:47:00
 */
public abstract class BaseModelObject extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3431847092975165086L;

	public static final String ON_SAVE_METHOD_NAME = "onSave";// "保存"方法名称
	public static final String ON_UPDATE_METHOD_NAME = "onUpdate";// "更新"方法名称

	/** ID **/
	private String id;

	/** 创建时间 **/
	private Date createTime;

	/** 修改时间 **/
	private Date updateTime;

	/** 创建者 **/
	private String creator;

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
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @return the creator
	 */
	public String getCreator() {
		return creator;
	}

	/**
	 * @param creator the creator to set
	 */
	public void setCreator(String creator) {
		this.creator = creator;
	}

	/**
	 * @return the updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public abstract void onSave();

	public abstract void onUpdate();

}
