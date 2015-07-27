package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class SchedulingUser extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * scheduling_id
	 */
	private java.lang.Integer scheduling_id;

	/**
	 * user_id
	 */
	private java.lang.Integer user_id;
	
	/**
	 * 用户名
	 */
	private java.lang.String user_name;
	
	/**
	 * 用户手机
	 */
	private java.lang.String user_mobile;

	public SchedulingUser() {
	}
	
	public SchedulingUser(java.lang.Integer scheduling_id) {
		this.scheduling_id = scheduling_id;
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setScheduling_id(java.lang.Integer scheduling_id) {
		this.scheduling_id = scheduling_id;
	}

	public java.lang.Integer getScheduling_id() {
		return this.scheduling_id;
	}
	
	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public java.lang.Integer getUser_id() {
		return this.user_id;
	}

	public java.lang.String getUser_name() {
		return user_name;
	}

	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}

	public java.lang.String getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(java.lang.String user_mobile) {
		this.user_mobile = user_mobile;
	}   
}