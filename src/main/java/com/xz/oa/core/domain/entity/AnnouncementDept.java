package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class AnnouncementDept extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * announcement_id
	 */
	private java.lang.Integer announcement_id;

	/**
	 * dept_id
	 */
	private java.lang.Integer dept_id;

	/**
	 * dept_name
	 */
	private java.lang.String dept_name;

	public AnnouncementDept() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setAnnouncement_id(java.lang.Integer announcement_id) {
		this.announcement_id = announcement_id;
	}

	public java.lang.Integer getAnnouncement_id() {
		return this.announcement_id;
	}
	
	public void setDept_id(java.lang.Integer dept_id) {
		this.dept_id = dept_id;
	}

	public java.lang.Integer getDept_id() {
		return this.dept_id;
	}
	
	public void setDept_name(java.lang.String dept_name) {
		this.dept_name = dept_name;
	}

	public java.lang.String getDept_name() {
		return this.dept_name;
	}


}