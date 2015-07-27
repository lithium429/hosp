package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import java.util.List;

import com.xz.base.domain.BaseEntity;

public class ForumPost extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * plate_id
	 */
	private java.lang.Integer plate_id;

	/**
	 * 所属主题id
	 */
	private java.lang.Integer thread_id;

	/**
	 * 内容
	 */
	private java.lang.String content;

	/**
	 * 是否被屏蔽
	 */
	private java.lang.Boolean is_close;

	/**
	 * 是否删除
	 */
	private java.lang.Boolean is_delete;

	/**
	 * is_first
	 */
	private java.lang.Boolean is_first;

	/**
	 * flayer
	 */
	private java.lang.Integer flayer;

	/**
	 * 被回复的帖子id
	 */
	private java.lang.Integer replyed_id;
	
	/**
	 * 被回复的帖子url
	 */
	private java.lang.String replyed_url;
	
	/**
	 * 是否包含附件
	 */
	private java.lang.Boolean has_file;

	/**
	 * 创建者
	 */
	private java.lang.Integer creator_id;
	
	/**
	 * 创建者姓名
	 */
	private java.lang.String creator_name;

	/**
	 * 创建时间
	 */
	private java.util.Date create_time;
	
	/**
	 * 论坛用户
	 */
	private ForumUser user;
	
	/**
	 * 被回复的帖子
	 */
	private ForumPost replyed_post;
	
	/**
	 * 附件
	 */
	private List<ForumFile> files; 

	public ForumPost() {
	}
	
	public ForumPost(Integer threadId){
		this.thread_id = threadId;
	}
	
	public ForumPost(Integer threadId, Integer plateId){
		this.thread_id = threadId;
		this.plate_id = plateId;
	}
	
	public ForumPost(Integer threadId, Boolean isDelete){
		this.thread_id = threadId;
		this.is_delete = isDelete;
	}
	
	public ForumPost(ForumThread thread) {
		this.plate_id = thread.getPlate_id();
		this.thread_id = thread.getId();
		this.content = thread.getContent();
		this.is_first = true;
		this.creator_id = thread.getCreator_id();
		this.create_time = thread.getCreate_time();
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setPlate_id(java.lang.Integer plate_id) {
		this.plate_id = plate_id;
	}

	public java.lang.Integer getPlate_id() {
		return this.plate_id;
	}
	
	public void setThread_id(java.lang.Integer thread_id) {
		this.thread_id = thread_id;
	}

	public java.lang.Integer getThread_id() {
		return this.thread_id;
	}
	
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setIs_close(java.lang.Boolean is_close) {
		this.is_close = is_close;
	}

	public java.lang.Boolean getIs_close() {
		return this.is_close;
	}
	
	public void setIs_delete(java.lang.Boolean is_delete) {
		this.is_delete = is_delete;
	}

	public java.lang.Boolean getIs_delete() {
		return this.is_delete;
	}
	
	public void setIs_first(java.lang.Boolean is_first) {
		this.is_first = is_first;
	}

	public java.lang.Boolean getIs_first() {
		return this.is_first;
	}
	
	public void setFlayer(java.lang.Integer flayer) {
		this.flayer = flayer;
	}

	public java.lang.Integer getFlayer() {
		return this.flayer;
	}
	
	public void setReplyed_id(java.lang.Integer replyed_id) {
		this.replyed_id = replyed_id;
	}

	public java.lang.Integer getReplyed_id() {
		return this.replyed_id;
	} 
	
	public java.lang.String getReplyed_url() {
		return replyed_url;
	}

	public void setReplyed_url(java.lang.String replyed_url) {
		this.replyed_url = replyed_url;
	} 

	public java.lang.Boolean getHas_file() {
		return has_file;
	}

	public void setHas_file(java.lang.Boolean has_file) {
		this.has_file = has_file;
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

	public ForumUser getUser() {
		return user;
	}

	public void setUser(ForumUser user) {
		this.user = user;
	}

	public ForumPost getReplyed_post() {
		return replyed_post;
	}

	public void setReplyed_post(ForumPost replyed_post) {
		this.replyed_post = replyed_post;
	}

	public List<ForumFile> getFiles() {
		return files;
	}

	public void setFiles(List<ForumFile> files) {
		this.files = files;
	}   
}