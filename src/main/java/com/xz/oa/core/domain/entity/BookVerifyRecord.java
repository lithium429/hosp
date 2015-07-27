package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class BookVerifyRecord extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 借阅申请id
	 */
	private java.lang.Integer borrow_id;

	/**
	 * 审核状态：2.通过，3.不通过
	 */
	private java.lang.Integer borrow_vstate;

	/**
	 * content
	 */
	private java.lang.String content;

	/**
	 * 审核人
	 */
	private java.lang.Integer creator_id;

	/**
	 * 审核时间
	 */
	private java.util.Date create_time;

	public BookVerifyRecord() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setBorrow_id(java.lang.Integer borrow_id) {
		this.borrow_id = borrow_id;
	}

	public java.lang.Integer getBorrow_id() {
		return this.borrow_id;
	}
	
	public void setBorrow_vstate(java.lang.Integer borrow_vstate) {
		this.borrow_vstate = borrow_vstate;
	}

	public java.lang.Integer getBorrow_vstate() {
		return this.borrow_vstate;
	}
	
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
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