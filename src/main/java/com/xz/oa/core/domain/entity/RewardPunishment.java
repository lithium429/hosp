package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.List;

import com.xz.base.domain.BaseEntity;

public class RewardPunishment extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 属性：1.奖励，2.惩罚
	 */
	private java.lang.Integer type;

	/**
	 * 关联的员工id
	 */
	private java.lang.Integer staff_id;

	/**
	 * 关联的奖惩名目id
	 */
	private java.lang.Integer item_id;

	/**
	 * 奖惩日期
	 */
	private java.util.Date rp_date;

	/**
	 * 授予单位
	 */
	private java.lang.String unit;

	/**
	 * 奖惩金额
	 */
	private java.math.BigDecimal amount;

	/**
	 * 奖惩内容
	 */
	private java.lang.String content;

	/**
	 * create_time
	 */
	private java.util.Date create_time;

	/**
	 * 员工
	 */
	private java.lang.String name;

	/**
	 * 员工工号
	 */
	private java.lang.String user_code;

	/**
	 * 名目名称
	 */
	private java.lang.String item_name;

	/**
	 * 附件
	 */
	private List<RpFile> files;

	public RewardPunishment() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setStaff_id(java.lang.Integer staff_id) {
		this.staff_id = staff_id;
	}

	public java.lang.Integer getStaff_id() {
		return this.staff_id;
	}
	
	public void setItem_id(java.lang.Integer item_id) {
		this.item_id = item_id;
	}

	public java.lang.Integer getItem_id() {
		return this.item_id;
	}
	
	public void setRp_date(java.util.Date rp_date) {
		this.rp_date = rp_date;
	}

	public java.util.Date getRp_date() {
		return this.rp_date;
	}
	
	public void setUnit(java.lang.String unit) {
		this.unit = unit;
	}

	public java.lang.String getUnit() {
		return this.unit;
	}
	
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}

	public java.math.BigDecimal getAmount() {
		return this.amount;
	}
	
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
	}
	
	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getUser_code() {
		return user_code;
	}

	public void setUser_code(java.lang.String user_code) {
		this.user_code = user_code;
	}

	public java.lang.String getItem_name() {
		return item_name;
	}

	public void setItem_name(java.lang.String item_name) {
		this.item_name = item_name;
	}

	public List<RpFile> getFiles() {
		return files;
	}

	public void setFiles(List<RpFile> files) {
		this.files = files;
	}

	
}