package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class Book extends BaseEntity implements Serializable {

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
	 * 类型id
	 */
	private java.lang.Integer type_id;

	/**
	 * 类型名称
	 */
	private java.lang.String type_name;

	/**
	 * image_url
	 */
	private java.lang.String image_url;

	/**
	 * 作者
	 */
	private java.lang.String author;

	/**
	 * 购买日期
	 */
	private java.util.Date buy_time;

	/**
	 * 出版日期
	 */
	private java.util.Date publish_time;

	/**
	 * 页数
	 */
	private java.lang.Integer page_count;

	/**
	 * 出版社
	 */
	private java.lang.String publisher;

	/**
	 * 是否借出
	 */
	private java.lang.Boolean is_borrow;

	/**
	 * 一维码编码
	 */
	private java.lang.String code;

	/**
	 * 备注
	 */
	private java.lang.String remark;

	/**
	 * 排序
	 */
	private java.lang.Integer sort;

	/**
	 * 创建人
	 */
	private java.lang.Integer creator_id;

	/**
	 * 创建时间
	 */
	private java.util.Date create_time;
	/**
	 * id
	 */
	private java.lang.Integer state;

	public Book() {
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
	
	public void setType_id(java.lang.Integer type_id) {
		this.type_id = type_id;
	}

	public java.lang.Integer getType_id() {
		return this.type_id;
	}

	public java.lang.String getType_name() {
		return type_name;
	}

	public void setType_name(java.lang.String type_name) {
		this.type_name = type_name;
	}
	
	public void setImage_url(java.lang.String image_url) {
		this.image_url = image_url;
	}

	public java.lang.String getImage_url() {
		return this.image_url;
	}
	
	public void setAuthor(java.lang.String author) {
		this.author = author;
	}

	public java.lang.String getAuthor() {
		return this.author;
	}
	
	public void setBuy_time(java.util.Date buy_time) {
		this.buy_time = buy_time;
	}

	public java.util.Date getBuy_time() {
		return this.buy_time;
	}
	
	public void setPublish_time(java.util.Date publish_time) {
		this.publish_time = publish_time;
	}

	public java.util.Date getPublish_time() {
		return this.publish_time;
	}
	
	public void setPage_count(java.lang.Integer page_count) {
		this.page_count = page_count;
	}

	public java.lang.Integer getPage_count() {
		return this.page_count;
	}
	
	public void setPublisher(java.lang.String publisher) {
		this.publisher = publisher;
	}

	public java.lang.String getPublisher() {
		return this.publisher;
	}
	
	public void setIs_borrow(java.lang.Boolean is_borrow) {
		this.is_borrow = is_borrow;
	}

	public java.lang.Boolean getIs_borrow() {
		return this.is_borrow;
	}
	
	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getRemark() {
		return this.remark;
	}
	
	public void setSort(java.lang.Integer sort) {
		this.sort = sort;
	}

	public java.lang.Integer getSort() {
		return this.sort;
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

	public java.lang.Integer getState() {
		return state;
	}

	public void setState(java.lang.Integer state) {
		this.state = state;
	}


}