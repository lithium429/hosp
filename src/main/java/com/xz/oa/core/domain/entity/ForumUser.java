package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class ForumUser extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 头像地址(大)
	 */
	private java.lang.String bicon_url;

	/**
	 * 头像地址(中）
	 */
	private java.lang.String micon_url;

	/**
	 * 头像地址(小)
	 */
	private java.lang.String sicon_url;

	/**
	 * 主题数
	 */
	private java.lang.Integer thread_count;

	/**
	 * 帖子数
	 */
	private java.lang.Integer post_count;

	/**
	 * 关联系统用户
	 */
	private java.lang.Integer user_id;
	
	/**
	 * 用户姓名
	 */
	private java.lang.String user_name;

	public ForumUser() {
	}
	
	public ForumUser(Integer userId) {
		this.user_id = userId;
	}
	
	public ForumUser(Integer userId, String biconUrl, String miconUrl, String siconUrl) {
		this.user_id = userId;
		this.bicon_url = biconUrl;
		this.micon_url = miconUrl;
		this.sicon_url = siconUrl;
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setBicon_url(java.lang.String bicon_url) {
		this.bicon_url = bicon_url;
	}

	public java.lang.String getBicon_url() {
		return this.bicon_url;
	}
	
	public void setMicon_url(java.lang.String micon_url) {
		this.micon_url = micon_url;
	}

	public java.lang.String getMicon_url() {
		return this.micon_url;
	}
	
	public void setSicon_url(java.lang.String sicon_url) {
		this.sicon_url = sicon_url;
	}

	public java.lang.String getSicon_url() {
		return this.sicon_url;
	}
	
	public void setThread_count(java.lang.Integer thread_count) {
		this.thread_count = thread_count;
	}

	public java.lang.Integer getThread_count() {
		return this.thread_count;
	}
	
	public void setPost_count(java.lang.Integer post_count) {
		this.post_count = post_count;
	}

	public java.lang.Integer getPost_count() {
		return this.post_count;
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