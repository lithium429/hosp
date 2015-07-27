package com.xz.oa.core.domain.entity;

public class LoginHelp {

	private java.lang.String msg;

	private java.lang.String userName;

	private java.lang.String password;
	
	private java.lang.Boolean flag;
	
	private java.lang.String sys_password;
	
	public LoginHelp(){
		
	}
	
	public LoginHelp(Boolean flag){
		this.flag = flag;
	}
	
	public LoginHelp(Boolean flag, String msg){
		this.flag = flag;
		this.msg = msg;
	}
	
	public java.lang.String getMsg() {
		return msg;
	}

	public void setMsg(java.lang.String msg) {
		this.msg = msg;
	}

	public java.lang.Boolean getFlag() {
		return flag;
	}

	public void setFlag(java.lang.Boolean flag) {
		this.flag = flag;
	}

	public java.lang.String getUserName() {
		return userName;
	}

	public void setUserName(java.lang.String userName) {
		this.userName = userName;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public java.lang.String getSys_password() {
		return sys_password;
	}

	public void setSys_password(java.lang.String sys_password) {
		this.sys_password = sys_password;
	}
	
	
}
