package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.xz.base.domain.BaseEntity;

public class ForumThread extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 所属板块id
	 */
	private java.lang.Integer plate_id;
	
	/**
	 * 所属板块名称
	 */
	private java.lang.String plate_name;

	/**
	 * 主题
	 */
	private java.lang.String subject;

	/**
	 * 内容
	 */
	private java.lang.String content;

	/**
	 * 是否置顶
	 */
	private java.lang.Boolean is_top;

	/**
	 * 是否被屏蔽
	 */
	private java.lang.Boolean is_close;

	/**
	 * 是否删除
	 */
	private java.lang.Boolean is_delete;

	/**
	 * 查看次数
	 */
	private java.lang.Integer view_count;

	/**
	 * 回复次数
	 */
	private java.lang.Integer reply_count;

	/**
	 * 最后回复人id
	 */
	private java.lang.Integer last_poster_id;
	
	/**
	 * 最后回复人姓名
	 */
	private java.lang.String last_poster_name;

	/**
	 * 最后回复时间
	 */
	private java.util.Date last_post_time;

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
	 * 跟帖
	 */
	private List<ForumPost> posts;
	
	/**
	 * 附件
	 */
	private List<ForumFile> files;

	public ForumThread() {
	}
	
	public ForumThread(java.lang.Integer plateId) {
		this.plate_id = plateId;
	}
	
	public ForumThread(java.lang.Boolean isDelete) {
		this.is_delete = isDelete;
	}
	
	public ForumThread(java.lang.Integer plateId, boolean isDelete) {
		this.plate_id = plateId;
		this.is_delete = isDelete;
	}
	
	public ForumThread(String[] ids, boolean isDelete) {
		super.getMap().put("ids", ids);
		this.is_delete = isDelete;
	}
	
	public ForumThread(List<Integer> idList, Integer userId, boolean isDelete) {
		super.getMap().put("ids", idList);
		super.getMap().put("creator_id", userId);
		this.is_delete = isDelete;
	}
	
	public ForumThread(Integer id, boolean isDelete, boolean isThread){
		this.id = id;
		this.is_delete = isDelete;
	}
	
	public ForumThread(ForumPost forumPost, Date lastPostTime, Integer replyCount) {
		this.id = forumPost.getThread_id();
		this.last_poster_id = forumPost.getCreator_id();
		this.last_post_time = lastPostTime;
		this.reply_count = replyCount;
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
	
	public java.lang.String getPlate_name() {
		return plate_name;
	}

	public void setPlate_name(java.lang.String plate_name) {
		this.plate_name = plate_name;
	}

	public void setSubject(java.lang.String subject) {
		this.subject = subject;
	}

	public java.lang.String getSubject() {
		return this.subject;
	}
	
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setIs_top(java.lang.Boolean is_top) {
		this.is_top = is_top;
	}

	public java.lang.Boolean getIs_top() {
		return this.is_top;
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
	
	public void setView_count(java.lang.Integer view_count) {
		this.view_count = view_count;
	}

	public java.lang.Integer getView_count() {
		return this.view_count;
	}
	
	public void setReply_count(java.lang.Integer reply_count) {
		this.reply_count = reply_count;
	}

	public java.lang.Integer getReply_count() {
		return this.reply_count;
	}
	
	public void setLast_poster_id(java.lang.Integer last_poster_id) {
		this.last_poster_id = last_poster_id;
	}

	public java.lang.Integer getLast_poster_id() {
		return this.last_poster_id;
	}
	
	public java.lang.String getLast_poster_name() {
		return last_poster_name;
	}

	public void setLast_poster_name(java.lang.String last_poster_name) {
		this.last_poster_name = last_poster_name;
	}
	
	public void setLast_post_time(java.util.Date last_post_time) {
		this.last_post_time = last_post_time;
	}

	public java.util.Date getLast_post_time() {
		return this.last_post_time;
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

	public ForumUser getUser() {
		return user;
	}

	public void setUser(ForumUser user) {
		this.user = user;
	}

	public List<ForumPost> getPosts() {
		return posts;
	}

	public void setPosts(List<ForumPost> posts) {
		this.posts = posts;
	}

	public List<ForumFile> getFiles() {
		return files;
	}

	public void setFiles(List<ForumFile> files) {
		this.files = files;
	}      
}