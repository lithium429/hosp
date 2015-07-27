package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class MealUser extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 订购人id
	 */
	private java.lang.Integer user_id;

	/**
	 * 菜单id
	 */
	private java.lang.Integer menu_id;

	/**
	 * 订购数量
	 */
	private java.lang.Integer order_count;

	public MealUser() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public java.lang.Integer getUser_id() {
		return this.user_id;
	}
	
	public void setMenu_id(java.lang.Integer menu_id) {
		this.menu_id = menu_id;
	}

	public java.lang.Integer getMenu_id() {
		return this.menu_id;
	}
	
	public void setOrder_count(java.lang.Integer order_count) {
		this.order_count = order_count;
	}

	public java.lang.Integer getOrder_count() {
		return this.order_count;
	}


}