package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xz.base.domain.BaseEntity;

public class Scheduling extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * dept_id
	 */
	private java.lang.Integer dept_id;
	
	/**
	 * 部门名称
	 */
	private java.lang.String dept_name;
	
	/**
	 * year
	 */
	private java.lang.Integer year;

	/**
	 * month
	 */
	private java.lang.Byte month;

	/**
	 * day
	 */
	private java.lang.Byte day;

	/**
	 * day_of_week
	 */
	private java.lang.Byte day_of_week;

	/**
	 * start_time
	 */
	private java.util.Date start_time;

	/**
	 * end_time
	 */
	private java.util.Date end_time;

	/**
	 * creator_id
	 */
	private java.lang.Integer creator_id;

	/**
	 * create_time
	 */
	private java.util.Date create_time;
	
	/**
	 * 值班人员
	 */
	private List<SchedulingUser> users;
	
	/**
	 * 仅用于接收页面参数
	 */
	private List<Scheduling> list;

	public Scheduling() {
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setDept_id(java.lang.Integer dept_id) {
		this.dept_id = dept_id;
	}

	public java.lang.Integer getDept_id() {
		return this.dept_id;
	}  
	
	public java.lang.String getDept_name() {
		return dept_name;
	}

	public void setDept_name(java.lang.String dept_name) {
		this.dept_name = dept_name;
	}

	public java.lang.Integer getYear() {
		return year;
	}

	public void setYear(java.lang.Integer year) {
		this.year = year;
	}

	public void setMonth(java.lang.Byte month) {
		this.month = month;
	}

	public java.lang.Byte getMonth() {
		return this.month;
	}
	
	public void setDay(java.lang.Byte day) {
		this.day = day;
	}

	public java.lang.Byte getDay() {
		return this.day;
	}
	
	public void setDay_of_week(java.lang.Byte day_of_week) {
		this.day_of_week = day_of_week;
	}

	public java.lang.Byte getDay_of_week() {
		return this.day_of_week;
	}
	
	public void setStart_time(java.util.Date start_time) {
		this.start_time = start_time;
	}

	public java.util.Date getStart_time() {
		return this.start_time;
	}
	
	public void setEnd_time(java.util.Date end_time) {
		this.end_time = end_time;
	}

	public java.util.Date getEnd_time() {
		return this.end_time;
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

	public List<SchedulingUser> getUsers() {
		return users;
	}

	public void setUsers(List<SchedulingUser> users) {
		this.users = users;
	}

	public List<Scheduling> getList() {
		return list;
	}

	public void setList(List<Scheduling> list) {
		this.list = list;
	}  
	
	/**
	 * @Description 根据部门进行分组 
	 * @param schedulingList
	 * @return Map<String,List<Scheduling>>     
	 */
	public Map<String, List<Scheduling>> groupByDept(List<Scheduling> schedulingList){
		if(schedulingList == null || schedulingList.isEmpty()) {
			return null;
		}
		
		Map<String, List<Scheduling>> map = new HashMap<String, List<Scheduling>>();
		List<Scheduling> list = null;
		String key = null;
		for (Scheduling item : schedulingList) {
			key = item.getDept_name();
			if (!map.containsKey(key)) {
				list = new ArrayList<Scheduling>();
				list.add(item);
				map.put(key, list);
			} else {
				list = map.get(key);
				list.add(item);
			}
		}
		return map;
	}
}