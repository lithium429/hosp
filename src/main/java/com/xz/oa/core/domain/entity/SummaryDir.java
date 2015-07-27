package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class SummaryDir extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 名称
	 */
	private java.lang.String name;

	/**
	 * 父级id
	 */
	private java.lang.Integer parent_id;

	/**
	 * parent_ids
	 */
	private java.lang.String parent_ids;

	/**
	 * 层级
	 */
	private java.lang.Integer layer;

	/**
	 * year
	 */
	private java.util.Date year;

	/**
	 * 模块类型：1.我的文档，2.总结文档
	 */
	private java.lang.Integer quarter;

	/**
	 * 是否逻辑删除
	 */
	private java.lang.Boolean is_delete;

	/**
	 * creator_id
	 */
	private java.lang.Integer creator_id;

	/**
	 * create_time
	 */
	private java.util.Date create_time;

	public SummaryDir() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return this.name;
	}
	
	public void setParent_id(java.lang.Integer parent_id) {
		this.parent_id = parent_id;
	}

	public java.lang.Integer getParent_id() {
		return this.parent_id;
	}
	
	public void setParent_ids(java.lang.String parent_ids) {
		this.parent_ids = parent_ids;
	}

	public java.lang.String getParent_ids() {
		return this.parent_ids;
	}
	
	public void setLayer(java.lang.Integer layer) {
		this.layer = layer;
	}

	public java.lang.Integer getLayer() {
		return this.layer;
	}
	
	public void setYear(java.util.Date year) {
		this.year = year;
	}

	public java.util.Date getYear() {
		return this.year;
	}
	
	public void setQuarter(java.lang.Integer quarter) {
		this.quarter = quarter;
	}

	public java.lang.Integer getQuarter() {
		return this.quarter;
	}
	
	public void setIs_delete(java.lang.Boolean is_delete) {
		this.is_delete = is_delete;
	}

	public java.lang.Boolean getIs_delete() {
		return this.is_delete;
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


}