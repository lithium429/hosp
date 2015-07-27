package com.xz.oa.sms.domain.entity;

import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class UnionnetSms extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * 手机号码
	 */
	private java.lang.String tel;

	/**
	 * 内容
	 */
	private java.lang.String msg;

	/**
	 * 来自
	 */
	private java.lang.String from;

	/**
	 * 级别
	 */
	private java.lang.Integer grade;
	
	/**
	 * 结果
	 */
	private java.lang.String result;

	public UnionnetSms() {
	}
	
	public UnionnetSms(String tel, String msg) {
		this.tel = tel;
		this.msg = msg;
		this.from = "oa";
		this.grade = 1;
	}

	public java.lang.String getTel() {
		return tel;
	}

	public void setTel(java.lang.String tel) {
		this.tel = tel;
	}

	public java.lang.String getMsg() {
		return msg;
	}

	public void setMsg(java.lang.String msg) {
		this.msg = msg;
	}

	public java.lang.String getFrom() {
		return from;
	}

	public void setFrom(java.lang.String from) {
		this.from = from;
	}

	public java.lang.Integer getGrade() {
		return grade;
	}

	public void setGrade(java.lang.Integer grade) {
		this.grade = grade;
	}

	public java.lang.String getResult() {
		return result;
	}

	public void setResult(java.lang.String result) {
		this.result = result;
	} 
	
}