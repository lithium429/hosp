package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class ForumFile extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 所属主题
	 */
	private java.lang.Integer thread_id;

	/**
	 * 所属回帖
	 */
	private java.lang.Integer post_id;

	/**
	 * 关联类型：1.主题，2.回帖
	 */
	private java.lang.Integer ftype;

	/**
	 * 类型：1.新建，2.上传，3.从文件夹中选择
	 */
	private java.lang.Integer type;

	/**
	 * file_id
	 */
	private java.lang.Integer file_id;

	/**
	 * 上传文件路径
	 */
	private java.lang.String url;

	/**
	 * 上传文件名称
	 */
	private java.lang.String name;

	/**
	 * sort
	 */
	private java.lang.Byte sort;

	/**
	 * create_time
	 */
	private java.util.Date create_time;

	public ForumFile() {
	}
	
	public ForumFile(Integer threadId){
		this.thread_id = threadId;
	}
	
	public ForumFile(Integer postId, boolean isPost){
		this.post_id = postId;
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
	
	public void setPost_id(java.lang.Integer post_id) {
		this.post_id = post_id;
	}

	public java.lang.Integer getPost_id() {
		return this.post_id;
	}
	
	public void setFtype(java.lang.Integer ftype) {
		this.ftype = ftype;
	}

	public java.lang.Integer getFtype() {
		return this.ftype;
	}
	
	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setFile_id(java.lang.Integer file_id) {
		this.file_id = file_id;
	}

	public java.lang.Integer getFile_id() {
		return this.file_id;
	}
	
	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	public java.lang.String getUrl() {
		return this.url;
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return this.name;
	}
	
	public void setSort(java.lang.Byte sort) {
		this.sort = sort;
	}

	public java.lang.Byte getSort() {
		return this.sort;
	}
	
	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}


}