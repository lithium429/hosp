package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class MeetingUser extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * meeting_id
	 */
	private java.lang.Integer meeting_id;

	/**
	 * user_id
	 */
	private java.lang.Integer user_id;

	/**
	 * user_id
	 */
	private java.lang.String user_name;
	
	/**
	 * 用户号码
	 */
	private java.lang.String user_mobile;

	public MeetingUser() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setMeeting_id(java.lang.Integer meeting_id) {
		this.meeting_id = meeting_id;
	}

	public java.lang.Integer getMeeting_id() {
		return this.meeting_id;
	}
	
	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public java.lang.Integer getUser_id() {
		return this.user_id;
	}
	
	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}

	public java.lang.String getUser_name() {
		return this.user_name;
	}

	public java.lang.String getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(java.lang.String user_mobile) {
		this.user_mobile = user_mobile;
	}
 
}