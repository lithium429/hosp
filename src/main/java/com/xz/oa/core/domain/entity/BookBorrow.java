package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class BookBorrow extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * return_time
	 */
	private java.util.Date return_time;

	/**
	 * 审核状态：1.待审核，2.通过，3.不通过
	 */
	private java.lang.Integer verify_state;

	/**
	 * 所借图书id
	 */
	private java.lang.Integer book_id;

	/**
	 * 借书人id
	 */
	private java.lang.Integer creator_id;

	/**
	 * 借书人名称
	 */
	private java.lang.String creator_name;

	/**
	 * create_time
	 */
	private java.util.Date create_time;
	
	public java.lang.String book_ids;

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
	 * 审核用户id
	 */
	private java.lang.Integer verify_user_id;
	
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

	public BookBorrow() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setReturn_time(java.util.Date return_time) {
		this.return_time = return_time;
	}

	public java.util.Date getReturn_time() {
		return this.return_time;
	}
	
	public void setVerify_state(java.lang.Integer verify_state) {
		this.verify_state = verify_state;
	}

	public java.lang.Integer getVerify_state() {
		return this.verify_state;
	}
	
	public void setBook_id(java.lang.Integer book_id) {
		this.book_id = book_id;
	}

	public java.lang.Integer getBook_id() {
		return this.book_id;
	}
	
	public void setCreator_id(java.lang.Integer creator_id) {
		this.creator_id = creator_id;
	}

	public java.lang.Integer getCreator_id() {
		return this.creator_id;
	}

	public java.lang.String getCreator_name() {
		return creator_name;
	}

	public void setCreator_name(java.lang.String creator_name) {
		this.creator_name = creator_name;
	}
	
	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}

	public java.lang.String getBook_ids() {
		return book_ids;
	}

	public void setBook_ids(java.lang.String book_ids) {
		this.book_ids = book_ids;
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

	public java.lang.Integer getVerify_user_id() {
		return verify_user_id;
	}

	public void setVerify_user_id(java.lang.Integer verify_user_id) {
		this.verify_user_id = verify_user_id;
	}

	public java.lang.String getVerify_user_name() {
		return verify_user_name;
	}

	public void setVerify_user_name(java.lang.String verify_user_name) {
		this.verify_user_name = verify_user_name;
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