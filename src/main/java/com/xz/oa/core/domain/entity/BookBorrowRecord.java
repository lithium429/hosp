package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class BookBorrowRecord extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 所借图书id
	 */
	private java.lang.Integer book_id;

	/**
	 * 借阅申请id
	 */
	private java.lang.Integer borrow_id;

	/**
	 * 领取状态：1.未领取，2.已领取，3.已归还
	 */
	private java.lang.Integer borrow_state;

	/**
	 * create_time
	 */
	private java.util.Date create_time;

	/**
	 * 借书人名称
	 */
	private java.lang.String creator_name;

	/**
	 * return_time
	 */
	private java.util.Date return_time;

	/**
	 * create_time
	 */
	private java.util.Date borrow_time;

	/**
	 * 名称
	 */
	private java.lang.String name;

	/**
	 * 类型名称
	 */
	private java.lang.String type_name;

	/**
	 * 一维码编码
	 */
	private java.lang.String code;

	/**
	 * image_url
	 */
	private java.lang.String image_url;

	/**
	 * 审核状态：1.待审核，2.通过，3.不通过
	 */
	private java.lang.Integer verify_state;
	
	/**
	 * 审核用户名称
	 */
	private java.lang.String verify_user_name;
	
	/**
	 * 审核时间
	 */
	private java.util.Date verify_time;
	
	/**
	 * 审核用户名称
	 */
	private java.lang.String verify_content;

	public BookBorrowRecord() {
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setBook_id(java.lang.Integer book_id) {
		this.book_id = book_id;
	}

	public java.lang.Integer getBook_id() {
		return this.book_id;
	}

	public void setBorrow_id(java.lang.Integer borrow_id) {
		this.borrow_id = borrow_id;
	}

	public java.lang.Integer getBorrow_id() {
		return this.borrow_id;
	}

	public void setBorrow_state(java.lang.Integer borrow_state) {
		this.borrow_state = borrow_state;
	}

	public java.lang.Integer getBorrow_state() {
		return this.borrow_state;
	}

	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}

	public java.lang.String getCreator_name() {
		return creator_name;
	}

	public void setCreator_name(java.lang.String creator_name) {
		this.creator_name = creator_name;
	}

	public java.util.Date getReturn_time() {
		return return_time;
	}

	public void setReturn_time(java.util.Date return_time) {
		this.return_time = return_time;
	}

	public java.util.Date getBorrow_time() {
		return borrow_time;
	}

	public void setBorrow_time(java.util.Date borrow_time) {
		this.borrow_time = borrow_time;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getType_name() {
		return type_name;
	}

	public void setType_name(java.lang.String type_name) {
		this.type_name = type_name;
	}

	public java.lang.String getCode() {
		return code;
	}

	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.lang.String getImage_url() {
		return image_url;
	}

	public void setImage_url(java.lang.String image_url) {
		this.image_url = image_url;
	}

	public java.lang.String getVerify_user_name() {
		return verify_user_name;
	}

	public void setVerify_user_name(java.lang.String verify_user_name) {
		this.verify_user_name = verify_user_name;
	}

	public java.lang.Integer getVerify_state() {
		return verify_state;
	}

	public void setVerify_state(java.lang.Integer verify_state) {
		this.verify_state = verify_state;
	}

	public java.util.Date getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(java.util.Date verify_time) {
		this.verify_time = verify_time;
	}

	public java.lang.String getVerify_content() {
		return verify_content;
	}

	public void setVerify_content(java.lang.String verify_content) {
		this.verify_content = verify_content;
	}

	
}