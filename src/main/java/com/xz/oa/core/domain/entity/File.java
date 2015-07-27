package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import com.google.common.base.Joiner;
import com.xz.base.domain.BaseEntity;
import com.xz.base.utils.ConfigValue;
import com.xz.oa.core.domain.enums.EnumFileType;
import com.xz.oa.core.service.file.FileUpload;

public class File extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 名称
	 */
	private java.lang.String name;

	/**
	 * 路径
	 */
	private java.lang.String url;

	/**
	 * 类型：1.文档，2.图片，3.其它
	 */
	private java.lang.Integer type;

	/**
	 * 文件扩展名
	 */
	private java.lang.String extension;

	/**
	 * info
	 */
	private java.lang.String info;

	/**
	 * 模块类型：1.会议，2.邮件
	 */
	private java.lang.Integer module_type;

	/**
	 * 大小：单位kb
	 */
	private java.lang.Long size;

	/**
	 * 是否逻辑删除
	 */
	private java.lang.Boolean is_delete;

	/**
	 * 所属文件夹id
	 */
	private java.lang.Integer directory_id;

	/**
	 * 创建时间
	 */
	private java.util.Date create_time;

	/**
	 * 创建人id
	 */
	private java.lang.Integer creator_id;

	/**
	 * 创建人用户名
	 */
	private java.lang.String creator_name;

	/**
	 * 部门名称
	 */
	private java.lang.String dept_name;

	/**
	 * 可见用户
	 */
	private List<FileUser> users;

	public File() {
	}

	public File(Integer id) {
		this.id = id;
	}

	public File(Integer id, boolean isDelete) {
		this.id = id;
		this.is_delete = isDelete;
	}

	public File(Integer id, String url) {
		this.id = id;
		this.url = url;
	}

	public File(java.io.File file, String fileName, Integer moduleType, String url, Integer directoryId) {
		this.name = fileName;
		this.url = url;
		this.extension = FilenameUtils.getExtension(this.name);
		this.type = gainFileType();
		this.module_type = moduleType;
		this.size = FileUtils.sizeOf(file) / 1024;
		this.directory_id = directoryId;
		this.create_time = new Date();
	}

	/**
	 * @Description 获取文件类型
	 * @return int
	 * @author davidwan
	 */
	private int gainFileType() {
		String docExt = ConfigValue.readValue(FileUpload.UPLOAD_DOC_EXT, "doc,docx,xls,xlsx,ppt,wps,txt,pdf");
		if (Arrays.asList(docExt.split(",")).contains(this.extension)) {
			return EnumFileType.文档.getValue();
		}
		String imgExt = ConfigValue.readValue(FileUpload.UPLOAD_IMAGE_EXT, "gif,jpg,jpeg,png,bmp");
		if (Arrays.asList(imgExt.split(",")).contains(this.extension)) {
			return EnumFileType.图片.getValue();
		}
		return EnumFileType.其它.getValue();
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getName() {
		return this.name;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	public java.lang.String getUrl() {
		return this.url;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getType() {
		return this.type;
	}

	public void setExtension(java.lang.String extension) {
		this.extension = extension;
	}

	public java.lang.String getExtension() {
		return this.extension;
	}

	public void setInfo(java.lang.String info) {
		this.info = info;
	}

	public java.lang.String getInfo() {
		return this.info;
	}

	public void setModule_type(java.lang.Integer module_type) {
		this.module_type = module_type;
	}

	public java.lang.Integer getModule_type() {
		return this.module_type;
	}

	public void setSize(java.lang.Long size) {
		this.size = size;
	}

	public java.lang.Long getSize() {
		return this.size;
	}

	public void setIs_delete(java.lang.Boolean is_delete) {
		this.is_delete = is_delete;
	}

	public java.lang.Boolean getIs_delete() {
		return this.is_delete;
	}

	public java.lang.Integer getDirectory_id() {
		return directory_id;
	}

	public void setDirectory_id(java.lang.Integer directory_id) {
		this.directory_id = directory_id;
	}

	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}

	public java.lang.Integer getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(java.lang.Integer creator_id) {
		this.creator_id = creator_id;
	}

	public java.lang.String getCreator_name() {
		return creator_name;
	}

	public void setCreator_name(java.lang.String creator_name) {
		this.creator_name = creator_name;
	}

	public java.lang.String getDept_name() {
		return dept_name;
	}

	public void setDept_name(java.lang.String dept_name) {
		this.dept_name = dept_name;
	}

	public List<FileUser> getUsers() {
		return users;
	}

	public void setUsers(List<FileUser> users) {
		this.users = users;
	}

	public String gainFileNameWithoutExt() {
		return this.name.substring(0, this.name.lastIndexOf("."));
	}

	/**
	 * @Description 获取可见用户Id
	 * @return String
	 */
	public String gainUserIds() {
		String ids = null;
		if (this.users != null && !this.users.isEmpty()) {
			List<Integer> idList = new ArrayList<Integer>();
			for (FileUser user : this.users) {
				idList.add(user.getUser_id());
			}
			ids = Joiner.on(",").join(idList);
		}
		return ids;
	}

	/**
	 * @Description 获取可见用户名称
	 * @return String
	 */
	public String gainUserNames() {
		String names = null;
		if (this.users != null && !this.users.isEmpty()) {
			List<String> nameList = new ArrayList<String>();
			for (FileUser user : this.users) {
				nameList.add(user.getUser_name());
			}
			names = Joiner.on(",").join(nameList);
		}
		return names;
	}
}