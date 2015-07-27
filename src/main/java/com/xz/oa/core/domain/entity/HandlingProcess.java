package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.List;

import com.xz.base.domain.BaseEntity;

public class HandlingProcess extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 编号
	 */
	private java.lang.String code;

	/**
	 * 督办事宜
	 */
	private java.lang.String title;

	/**
	 * content
	 */
	private java.lang.String content;

	/**
	 * content
	 */
	private java.lang.String haddle_content;

	/**
	 * 当前责任人
	 */
	private java.lang.Integer user_id;

	/**
	 * 关闭日期
	 */
	private java.util.Date close_date;

	/**
	 * 办结日期
	 */
	private java.util.Date end_date;

	/**
	 * 状态：1.草稿，2.流转中，3.已关闭
	 */
	private java.lang.Integer state;

	/**
	 * 创建人
	 */
	private java.lang.Integer creator_id;

	/**
	 * 创建时间
	 */
	private java.util.Date create_time;

	/**
	 * 负责人
	 */
	private java.lang.String user_name;

	/**
	 * 创建人
	 */
	private java.lang.String creator_name;

	/**
	 * 创建人
	 */
	private List<HandlingProcessRecord> records;

	public HandlingProcess() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public java.lang.Integer getUser_id() {
		return this.user_id;
	}
	
	public void setClose_date(java.util.Date close_date) {
		this.close_date = close_date;
	}

	public java.util.Date getClose_date() {
		return this.close_date;
	}
	
	public void setEnd_date(java.util.Date end_date) {
		this.end_date = end_date;
	}

	public java.util.Date getEnd_date() {
		return this.end_date;
	}
	
	public void setState(java.lang.Integer state) {
		this.state = state;
	}

	public java.lang.Integer getState() {
		return this.state;
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
	
	public java.lang.String getUser_name() {
		return user_name;
	}

	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}

	public java.lang.String getCreator_name() {
		return creator_name;
	}

	public void setCreator_name(java.lang.String creator_name) {
		this.creator_name = creator_name;
	}

	public List<HandlingProcessRecord> getRecords() {
		return records;
	}

	public void setRecords(List<HandlingProcessRecord> records) {
		this.records = records;
	}

	public java.lang.String getHaddle_content() {
		return haddle_content;
	}

	public void setHaddle_content(java.lang.String haddle_content) {
		this.haddle_content = haddle_content;
	}


}