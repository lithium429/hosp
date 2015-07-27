package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xz.base.domain.BaseEntity;

public class SchedulingTime extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 类型：1.周一到周五，2.周六周日
	 */
	private java.lang.Byte type;

	/**
	 * 起始时间
	 */
	private java.util.Date start_time;

	/**
	 * 结束时间
	 */
	private java.util.Date end_time;

	/**
	 * 仅仅用来获取页面数据
	 */
	private List<SchedulingTime> list;

	public SchedulingTime() {
	}
	
	public SchedulingTime(java.util.Date startTime, java.util.Date endTime) {
		this.start_time = startTime;
		this.end_time = endTime;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setType(java.lang.Byte type) {
		this.type = type;
	}

	public java.lang.Byte getType() {
		return this.type;
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

	public List<SchedulingTime> getList() {
		return list;
	}

	public void setList(List<SchedulingTime> list) {
		this.list = list;
	}

	/**
	 * @Description 根据type对列表进行分组 
	 * @param list
	 * @return Map<Byte,List<SchedulingTime>>     
	 */
	public Map<Byte, List<SchedulingTime>> groupListByType(List<SchedulingTime> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		Map<Byte, List<SchedulingTime>> map = new HashMap<Byte, List<SchedulingTime>>();
		List<SchedulingTime> tempList = null;
		Byte type = null;
		for (SchedulingTime item : list) {
			type = item.getType();
			if (map.containsKey(type)) {
				tempList = map.get(type);
				tempList.add(item);
			} else {
				tempList = new ArrayList<SchedulingTime>();
				tempList.add(item);
				map.put(type, tempList);
			}
		}
		return map;
	}
}