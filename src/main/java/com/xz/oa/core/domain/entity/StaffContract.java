package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


import com.xz.base.domain.BaseEntity;
import com.xz.base.utils.DateUtil;

public class StaffContract extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * staff_id
	 */
	private java.lang.Integer staff_id;

	/**
	 * 合同编号
	 */
	private java.lang.String code;

	/**
	 * 合同类型id
	 */
	private java.lang.Integer type_id;

	/**
	 * 签订日期
	 */
	private java.util.Date sign_date;

	/**
	 * 生效日期
	 */
	private java.util.Date valid_date;

	/**
	 * 终止日期
	 */
	private java.util.Date end_date;

	/**
	 * 解除日期
	 */
	private java.util.Date relieve_date;

	/**
	 * 状态：1.未开始，2.执行中，3.已终止，4.已解除
	 */
	private java.lang.Integer state;

	/**
	 * 备注
	 */
	private java.lang.String remark;

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
	 * 类型名称
	 */
	private java.lang.String type_name;

	/**
	 * 附件
	 */
	private List<StaffContractFile> files;

	public StaffContract() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setStaff_id(java.lang.Integer staff_id) {
		this.staff_id = staff_id;
	}

	public java.lang.Integer getStaff_id() {
		return this.staff_id;
	}
	
	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.lang.String getCode() {
		return this.code;
	}
	
	public void setType_id(java.lang.Integer type_id) {
		this.type_id = type_id;
	}

	public java.lang.Integer getType_id() {
		return this.type_id;
	}
	
	public void setSign_date(java.util.Date sign_date) {
		this.sign_date = sign_date;
	}

	public java.util.Date getSign_date() {
		return this.sign_date;
	}
	
	public void setValid_date(java.util.Date valid_date) {
		this.valid_date = valid_date;
	}

	public java.util.Date getValid_date() {
		return this.valid_date;
	}
	
	public void setEnd_date(java.util.Date end_date) {
		this.end_date = end_date;
	}

	public java.util.Date getEnd_date() {
		return this.end_date;
	}
	
	public void setRelieve_date(java.util.Date relieve_date) {
		this.relieve_date = relieve_date;
	}

	public java.util.Date getRelieve_date() {
		return this.relieve_date;
	}
	
	public void setState(java.lang.Integer state) {
		this.state = state;
	}

	public java.lang.Integer getState() {
		return this.state;
	}
	
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getRemark() {
		return this.remark;
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

	public java.lang.String getType_name() {
		return type_name;
	}

	public void setType_name(java.lang.String type_name) {
		this.type_name = type_name;
	}
	
	public List<StaffContractFile> getFiles() {
		return files;
	}

	public void setFiles(List<StaffContractFile> files) {
		this.files = files;
	}

	public java.lang.String getUser_code() {
		return user_code;
	}

	public void setUser_code(java.lang.String user_code) {
		this.user_code = user_code;
	}

	public String gainState()
	{
		String r="";
		Date now=DateUtil.getCurrentDate();
		System.out.println(now);
		if(this.state!=4){
			if(now.before(this.valid_date)){
				r="未开始";
			}else if(now.after(this.end_date)){
				r="已终止";
			}else{
				r="执行中";
			}
		}else
		{
			r="已解除";
		}
		return r;
	}
}