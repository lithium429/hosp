package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import com.xz.base.domain.BaseEntity;

public class ForumPlateUser extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * user_id
	 */
	private java.lang.Integer user_id;
	
	/**
	 * 用户姓名
	 */
	private java.lang.String user_real_name;

	/**
	 * plate_id
	 */
	private java.lang.Integer plate_id;

	public ForumPlateUser() {
	}
	
	public ForumPlateUser(Integer plateId){
		this.plate_id = plateId;
	}
	
	public ForumPlateUser(Integer userId, Integer plateId){
		this.user_id = userId;
		this.plate_id = plateId;
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public java.lang.Integer getUser_id() {
		return this.user_id;
	} 
	
	public java.lang.String getUser_real_name() {
		return user_real_name;
	}

	public void setUser_real_name(java.lang.String user_real_name) {
		this.user_real_name = user_real_name;
	}

	public void setPlate_id(java.lang.Integer plate_id) {
		this.plate_id = plate_id;
	}

	public java.lang.Integer getPlate_id() {
		return this.plate_id;
	} 
}