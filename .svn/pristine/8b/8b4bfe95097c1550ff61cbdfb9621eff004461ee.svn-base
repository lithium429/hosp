package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class ForumUserFav extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 关联主题id
	 */
	private java.lang.Integer thread_id;

	/**
	 * 关联用户id
	 */
	private java.lang.Integer user_id; 

	public ForumUserFav() {
	}
	
	public ForumUserFav(Integer userId) {
		this.user_id = userId;
	}
	
	public ForumUserFav(Integer threadId, Integer userId){
		this.thread_id = threadId;
		this.user_id = userId;
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setThread_id(java.lang.Integer thread_id) {
		this.thread_id = thread_id;
	}

	public java.lang.Integer getThread_id() {
		return this.thread_id;
	}
	
	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public java.lang.Integer getUser_id() {
		return this.user_id;
	} 
}