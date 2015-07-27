package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class AnnouncementType extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 名称
	 */
	private java.lang.String name;

	/**
	 * sort
	 */
	private java.lang.Integer sort;

	/**
	 * remark
	 */
	private java.lang.String remark;

	/**
	 * 创建人id
	 */
	private java.lang.Integer creator_id;

	/**
	 * 创建时间
	 */
	private java.util.Date create_time;

	public AnnouncementType() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return this.name;
	}
	
	public void setSort(java.lang.Integer sort) {
		this.sort = sort;
	}

	public java.lang.Integer getSort() {
		return this.sort;
	}
	
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getRemark() {
		return this.remark;
	}
	
	public void setCreator_id(java.lang.Integer creator_id) {
		this.creator_id = creator_id;
	}

	public java.lang.Integer getCreator_id() {
		return this.creator_id;
	}
	
	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}


}