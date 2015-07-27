package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xz.base.domain.BaseEntity;

public class Care extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 标题
	 */
	private java.lang.String title;

	/**
	 * 浏览次数
	 */
	private java.lang.Integer browse_count;

	/**
	 * 来源
	 */
	private java.lang.String source;

	/**
	 * 作者
	 */
	private java.lang.String author;

	/**
	 * 作者
	 */
	private java.lang.String content;

	/**
	 * 借书人id
	 */
	private java.lang.Integer creator_id;

	/**
	 * create_time
	 */
	private java.util.Date create_time;

	/**
	 * type_id
	 */
	private java.lang.Integer type_id;

	/**
	 * 附件
	 */
	private List<CareFile> files;

	/**
	 * type_name
	 */
	private java.lang.String type_name;

	/**
	 * creator_name
	 */
	private java.lang.String creator_name;

	public Care() {
	}

	public Care(Integer typeId) {
		this.type_id = typeId;
	}
	
	public Care(Integer id, Integer typeId){
		this.id = id;
		this.type_id = typeId;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getTitle() {
		return this.title;
	}

	public void setBrowse_count(java.lang.Integer browse_count) {
		this.browse_count = browse_count;
	}

	public java.lang.Integer getBrowse_count() {
		return this.browse_count;
	}

	public void setSource(java.lang.String source) {
		this.source = source;
	}

	public java.lang.String getSource() {
		return this.source;
	}

	public void setAuthor(java.lang.String author) {
		this.author = author;
	}

	public java.lang.String getAuthor() {
		return this.author;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
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

	public void setType_id(java.lang.Integer type_id) {
		this.type_id = type_id;
	}

	public java.lang.Integer getType_id() {
		return this.type_id;
	}

	public List<CareFile> getFiles() {
		return files;
	}

	public void setFiles(List<CareFile> files) {
		this.files = files;
	}

	public java.lang.String getType_name() {
		return type_name;
	}

	public void setType_name(java.lang.String type_name) {
		this.type_name = type_name;
	}

	public java.lang.String getCreator_name() {
		return creator_name;
	}

	public void setCreator_name(java.lang.String creator_name) {
		this.creator_name = creator_name;
	}

	/**
	 * @Description 根据创建用户分组
	 * @param careList
	 * @return Map<Integer,List<Care>>
	 */
	public Map<Integer, List<Care>> groupListByType(List<Care> careList) {
		if(careList == null || careList.isEmpty()){
			return null;
		}
		
		Map<Integer, List<Care>> map = new HashMap<Integer, List<Care>>();
		List<Care> list = null;
		for (Care item : careList) {
			if (!map.containsKey(item.type_id)) {
				list = new ArrayList<Care>();
				list.add(item);
				map.put(item.type_id, list);
			} else {
				list = map.get(item.type_id);
				list.add(item);
			}
		}
		return map;
	}
}