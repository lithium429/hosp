package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class EmailContent extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * content
	 */
	private java.lang.String content;

	/**
	 * email_id
	 */
	private java.lang.Integer email_id;

	public EmailContent() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setEmail_id(java.lang.Integer email_id) {
		this.email_id = email_id;
	}

	public java.lang.Integer getEmail_id() {
		return this.email_id;
	}


}