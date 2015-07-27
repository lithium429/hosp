package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class DirectoryDept extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * directory_id
	 */
	private java.lang.Integer directory_id;

	/**
	 * dept_id
	 */
	private java.lang.Integer dept_id;

	public DirectoryDept() {
		
	}
	
	public DirectoryDept(Integer dept_id) {
		this.dept_id = dept_id;
	}
	
	public DirectoryDept(Integer directory_id, Integer dept_id){
		this.directory_id = directory_id;
		this.dept_id = dept_id;
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setDirectory_id(java.lang.Integer directory_id) {
		this.directory_id = directory_id;
	}

	public java.lang.Integer getDirectory_id() {
		return this.directory_id;
	}
	
	public void setDept_id(java.lang.Integer dept_id) {
		this.dept_id = dept_id;
	}

	public java.lang.Integer getDept_id() {
		return this.dept_id;
	}


}