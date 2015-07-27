package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class MeetingRoom extends BaseEntity implements Serializable {

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
	 * address
	 */
	private java.lang.String address;

	/**
	 * 备注
	 */
	private java.lang.String remark;

	/**
	 * 创建用户id
	 */
	private java.lang.Integer creator_id;

	/**
	 * 创建用户
	 */
	private java.lang.String creator_name;

	/**
	 * 创建时间
	 */
	private java.util.Date create_time;

	public MeetingRoom() {
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
	
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getAddress() {
		return this.address;
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
	
	public void setCreator_name(java.lang.String creator_name) {
		this.creator_name = creator_name;
	}

	public java.lang.String getCreator_name() {
		return this.creator_name;
	}
	
	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}


}