package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class CareFile extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 所属会议
	 */
	private java.lang.Integer care_id;

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

	public CareFile() {
	}

	public CareFile(Integer careId) {
		this.care_id = careId;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setCare_id(java.lang.Integer care_id) {
		this.care_id = care_id;
	}

	public java.lang.Integer getCare_id() {
		return this.care_id;
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