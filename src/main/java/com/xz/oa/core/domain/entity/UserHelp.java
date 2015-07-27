package com.xz.oa.core.domain.entity;

import java.util.List;


public class UserHelp {

	/**
	 * 部门名称
	 */
	private java.lang.String deptName;

	/**
	 * 部门Id
	 */
	private java.lang.String deptId;
	
	private List<User> users;

	public UserHelp() {
	}
	
	public void setDeptName(java.lang.String deptName) {
		this.deptName = deptName;
	}

	public java.lang.String getDeptName() {
		return this.deptName;
	}
	
	public void setDeptId(java.lang.String deptId) {
		this.deptId = deptId;
	}

	public java.lang.String getDeptId() {
		return this.deptId;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getUsers() {
		return this.users;
	}
	
}
