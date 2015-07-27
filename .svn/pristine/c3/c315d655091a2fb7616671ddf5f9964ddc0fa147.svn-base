package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.common.base.Joiner;
import com.xz.base.domain.BaseEntity;

public class ForumPlate extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * parent_id
	 */
	private java.lang.Integer parent_id;

	/**
	 * 父级名称
	 */
	private java.lang.String parent_name;

	/**
	 * name
	 */
	private java.lang.String name;

	/**
	 * sort
	 */
	private java.lang.Integer sort;

	/**
	 * icon_url
	 */
	private java.lang.String icon_url;

	/**
	 * layer
	 */
	private java.lang.Integer layer;

	/**
	 * 是否叶节点
	 */
	private java.lang.Boolean is_leaf;

	/**
	 * 主题数
	 */
	private java.lang.Integer thread_count;

	/**
	 * 帖数
	 */
	private java.lang.Integer post_count;

	/**
	 * 帖数
	 */
	private java.lang.Integer last_thread_id;

	/**
	 * 最后一次发表时间
	 */
	private java.util.Date last_post_time;

	/**
	 * 版主
	 */
	private java.util.List<ForumPlateUser> users;

	/**
	 * 
	 */
	private java.lang.String user_ids;

	public ForumPlate() {
	}

	public ForumPlate(Integer id) {
		this.id = id;
	}

	public ForumPlate(ForumPost forumPost, Date lastPostTime) {
		this.id = forumPost.getPlate_id();
		this.last_thread_id = forumPost.getThread_id();
		this.last_post_time = lastPostTime;
	}

	public ForumPlate(Integer sort, Integer layer, Integer parentId) {
		this.sort = sort;
		this.layer = layer;
		this.parent_id = parentId;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setParent_id(java.lang.Integer parent_id) {
		this.parent_id = parent_id;
	}

	public java.lang.Integer getParent_id() {
		return this.parent_id;
	}

	public java.lang.String getParent_name() {
		return parent_name;
	}

	public void setParent_name(java.lang.String parent_name) {
		this.parent_name = parent_name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setSort(java.lang.Integer sort) {
		this.sort = sort;
	}

	public java.lang.Integer getSort() {
		return this.sort;
	}

	public void setIcon_url(java.lang.String icon_url) {
		this.icon_url = icon_url;
	}

	public java.lang.String getIcon_url() {
		return this.icon_url;
	}

	public void setLayer(java.lang.Integer layer) {
		this.layer = layer;
	}

	public java.lang.Integer getLayer() {
		return this.layer;
	}

	public void setIs_leaf(java.lang.Boolean is_leaf) {
		this.is_leaf = is_leaf;
	}

	public java.lang.Boolean getIs_leaf() {
		return this.is_leaf;
	}

	public java.lang.Integer getThread_count() {
		return thread_count;
	}

	public void setThread_count(java.lang.Integer thread_count) {
		this.thread_count = thread_count;
	}

	public java.lang.Integer getPost_count() {
		return post_count;
	}

	public void setPost_count(java.lang.Integer post_count) {
		this.post_count = post_count;
	}

	public java.lang.Integer getLast_thread_id() {
		return last_thread_id;
	}

	public void setLast_thread_id(java.lang.Integer last_thread_id) {
		this.last_thread_id = last_thread_id;
	}

	public java.util.Date getLast_post_time() {
		return last_post_time;
	}

	public void setLast_post_time(java.util.Date last_post_time) {
		this.last_post_time = last_post_time;
	}

	public java.util.List<ForumPlateUser> getUsers() {
		return users;
	}

	public void setUsers(java.util.List<ForumPlateUser> users) {
		this.users = users;
	}

	public java.lang.String getUser_ids() {
		return user_ids;
	}

	public void setUser_ids(java.lang.String user_ids) {
		this.user_ids = user_ids;
	}

	/**
	 * @Description 获取版主用户Id
	 * @return java.lang.String
	 */
	public java.lang.String gainUserIds() {
		List<String> list = new ArrayList<String>();
		if (this.users != null && !this.users.isEmpty()) {
			for (ForumPlateUser user : this.users) {
				if (user != null) {
					list.add(user.getUser_id().toString());
				}
			}
			return Joiner.on(',').join(list);
		} else {
			return null;
		}
	}
	
	/**
	 * @Description 获取版主名称
	 * @return java.lang.String
	 */
	public java.lang.String gainUserRealNamesForText() {
		List<String> list = new ArrayList<String>();
		if (this.users != null && !this.users.isEmpty()) {
			for (ForumPlateUser user : this.users) {
				if (user != null) {
					list.add(user.getUser_real_name());
				}
			}
			return Joiner.on(',').join(list);
		} else {
			return null;
		}
	}

	/**
	 * @Description 获取版主名称
	 * @return java.lang.String
	 */
	public java.lang.String gainUserRealNames() {
		List<String> list = new ArrayList<String>();
		if (this.users != null && !this.users.isEmpty()) {
			for (ForumPlateUser user : this.users) {
				if (user != null) {
					list.add(String.format("<a href=\"%s\" class=\"notabs\">%s</a>", "forum/user/" + user.getUser_id() + ".shtml", user.getUser_real_name()));
				}
			}
			return Joiner.on(',').join(list);
		} else {
			return null;
		}
	}
}