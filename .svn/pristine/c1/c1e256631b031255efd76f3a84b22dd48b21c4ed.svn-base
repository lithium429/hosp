package com.xz.oa.core.domain.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.xz.base.domain.BaseEntity;

public class Announcement extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 公告类型id
	 */
	private java.lang.Integer type_id;

	/**
	 * 公告类型名称
	 */
	private java.lang.String type_name;

	/**
	 * 标题
	 */
	private java.lang.String title;

	/**
	 * 内容
	 */
	private java.lang.String content;

	/**
	 * 生效日期
	 */
	private java.util.Date valid_date;

	/**
	 * 终止日期
	 */
	private java.util.Date end_date;

	/**
	 * 排序
	 */
	private java.lang.Integer sort;

	/**
	 * 状态：1.未发布，2.生效，3.终止
	 */
	private java.lang.Integer state;

	/**
	 * 是否对所有部门可见
	 */
	private java.lang.Boolean is_show_all;

	/**
	 * 创建人id
	 */
	private java.lang.Integer creator_id;

	/**
	 * 创建时间
	 */
	private java.util.Date create_time;
	
	public List<AnnouncementDept> depts;
	
	public String dept_ids;

	/**
	 * 附件
	 */
	private List<AnnouncementFile> files;

	public Announcement() {
	} 
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setType_id(java.lang.Integer type_id) {
		this.type_id = type_id;
	}

	public java.lang.Integer getType_id() {
		return this.type_id;
	}
	
	public void setType_name(java.lang.String type_name) {
		this.type_name = type_name;
	}

	public java.lang.String getType_name() {
		return this.type_name;
	}
	
	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getTitle() {
		return this.title;
	}
	
	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
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
	
	public void setSort(java.lang.Integer sort) {
		this.sort = sort;
	}

	public java.lang.Integer getSort() {
		return this.sort;
	}
	
	public void setState(java.lang.Integer state) {
		this.state = state;
	}

	public java.lang.Integer getState() {
		return this.state;
	}
	
	public void setIs_show_all(java.lang.Boolean is_show_all) {
		this.is_show_all = is_show_all;
	}

	public java.lang.Boolean getIs_show_all() {
		return this.is_show_all;
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
	
	public void setDepts(List<AnnouncementDept> depts) {
		this.depts = depts;
	}

	public List<AnnouncementDept> getDepts() {
		return this.depts;
	}
	
	public void setDept_ids(java.lang.String dept_ids) {
		this.dept_ids = dept_ids;
	}

	public java.lang.String getDept_ids() {
		return this.dept_ids;
	}

	public List<AnnouncementFile> getFiles() {
		return files;
	}

	public void setFiles(List<AnnouncementFile> files) {
		this.files = files;
	}

	public String getDeptIds()
	{
		String r="";
		if(this.depts!=null)
		{
			for (AnnouncementDept item : this.depts) {
				if(r=="")
				{
					r=String.valueOf(item.getDept_id());
				}else
				{
					r+=","+String.valueOf(item.getDept_id());
				}
			}
		}
		return r;
	}

	public boolean judgeDeptId(int v)
	{
		boolean r=false;
		if(this.depts!=null)
		{
			for (AnnouncementDept item : this.depts) {
				if(item.getDept_id()==v)
				{
					r=true;
					break;
				}
			}
		}
		return r;
	}
	
	public String getDeptNames()
	{
		String r="";
		if(this.depts!=null)
		{
			for (AnnouncementDept item : this.depts) {
				if(r=="")
				{
					r=item.getDept_name();
				}else
				{
					r+=","+item.getDept_name();
				}
			}
		}
		return r;
	}
	
	//判断状态
	public String judgeState()
	{
		String r="未发布";
		Date now=new Date();
		if(!now.before(this.valid_date))
		{
			r="生效";
			if(this.end_date!=null && now.after(this.end_date))
			{
				r="终止";
			}
		}
		return r;
	}

}