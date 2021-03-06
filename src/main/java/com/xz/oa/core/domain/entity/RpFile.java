package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class RpFile extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 所属奖惩记录
	 */
	private java.lang.Integer rp_id;

	/**
	 * 类型：1.新建，2.上传，3.从文件夹中选择
	 */
	private java.lang.Byte type;

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

	public RpFile() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setRp_id(java.lang.Integer rp_id) {
		this.rp_id = rp_id;
	}

	public java.lang.Integer getRp_id() {
		return this.rp_id;
	}
	
	public void setType(java.lang.Byte type) {
		this.type = type;
	}

	public java.lang.Byte getType() {
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