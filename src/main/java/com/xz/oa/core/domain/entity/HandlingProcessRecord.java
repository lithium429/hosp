package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class HandlingProcessRecord extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * handling_id
	 */
	private java.lang.Integer handling_id;

	/**
	 * user_id
	 */
	private java.lang.Integer user_id;

	/**
	 * 负责人
	 */
	private java.lang.String user_name;

	/**
	 * content
	 */
	private java.lang.String content;

	/**
	 * create_time
	 */
	private java.util.Date create_time;

	public HandlingProcessRecord() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setHandling_id(java.lang.Integer handling_id) {
		this.handling_id = handling_id;
	}

	public java.lang.Integer getHandling_id() {
		return this.handling_id;
	}
	
	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public java.lang.Integer getUser_id() {
		return this.user_id;
	}
	
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}
	
	public java.lang.String getUser_name() {
		return user_name;
	}

	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}


}