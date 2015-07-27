package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class FileUser extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * file_id
	 */
	private java.lang.Integer file_id;

	/**
	 * user_id
	 */
	private java.lang.Integer user_id;

	/**
	 * 用户名
	 */
	private java.lang.String user_name;

	public FileUser() {
	}
	
	public FileUser(Integer fileId) {
		this.file_id = fileId;
	}

	public FileUser(Integer fileId, Integer userId) {
		this.file_id = fileId;
		this.user_id = userId;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setFile_id(java.lang.Integer file_id) {
		this.file_id = file_id;
	}

	public java.lang.Integer getFile_id() {
		return this.file_id;
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
}