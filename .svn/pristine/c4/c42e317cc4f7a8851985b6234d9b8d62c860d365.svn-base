package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.List;

import com.xz.base.domain.BaseEntity;
import com.xz.oa.core.domain.enums.EnumEducation;
import com.xz.oa.core.domain.enums.EnumNation;

public class Staff extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 姓名
	 */
	private java.lang.String name;

	/**
	 * 工号
	 */
	private java.lang.String code;

	/**
	 * 性别：1.男，2.女
	 */
	private java.lang.Integer sex;

	/**
	 * id_number
	 */
	private java.lang.String id_number;

	/**
	 * birthday
	 */
	private java.util.Date birthday;

	/**
	 * 籍贯
	 */
	private java.lang.String native_place;

	/**
	 * 现居住详细地址
	 */
	private java.lang.String address;

	/**
	 * 民族
	 */
	private java.lang.Integer nation;

	/**
	 * 婚姻状况：1.未婚，2.已婚，3.离异，4.丧偶
	 */
	private java.lang.Integer marital_status;

	/**
	 * 政治面貌：1.群众，2.共青团员，3.中共党员，4.中共预备党员，5.民主党派，6.无党派人士
	 */
	private java.lang.Integer political_status;

	/**
	 * photo
	 */
	private java.lang.String photo;

	/**
	 * 员工类型：1.合同工，2.正式员工，3.临时工
	 */
	private java.lang.Integer type;

	/**
	 * 职务
	 */
	private java.lang.String post;

	/**
	 * 技术职称
	 */
	private java.lang.String post_title;

	/**
	 * 职称级别：1.初级，2.中级，3.副高，4.正高
	 */
	private java.lang.Integer post_title_level;

	/**
	 * 考勤排班类型：1.正常班，2.全日班，3.轮班制
	 */
	private java.lang.Integer scheduling_type;

	/**
	 * phone
	 */
	private java.lang.String phone;

	/**
	 * mobile
	 */
	private java.lang.String mobile;

	/**
	 * email
	 */
	private java.lang.String email;

	/**
	 * qq
	 */
	private java.lang.String qq;

	/**
	 * 入职日期
	 */
	private java.util.Date entry_date;

	/**
	 * 学历：1.小学，2.初中，3.高中，4.中专，5.技校，6.大专，7.本科，8.研究生，9.博士，10.博士后
	 */
	private java.lang.Integer education;

	/**
	 * 毕业日期
	 */
	private java.util.Date graduate_date;

	/**
	 * 毕业学校
	 */
	private java.lang.String graduate_school;

	/**
	 * 备注
	 */
	private java.lang.String remark;

	/**
	 * 简历（html)
	 */
	private java.lang.String resume;

	/**
	 * 关联的系统用户id
	 */
	private java.lang.Integer user_id;

	/**
	 * 关联的系统用户姓名
	 */
	private java.lang.String user_name;

	public Staff() {
	}
	
	public Staff(Integer id, User user) {
		this.id = id;
		this.code = user.getName();
		this.name = user.getReal_name();
		this.sex = user.getSex();
	}

	public Staff(String name, String code, Integer userId) {
		this.name = name;
		this.code = code;
		this.user_id = userId;
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

	public void setCode(java.lang.String code) {
		this.code = code;
	}

	public java.lang.String getCode() {
		return this.code;
	}

	public void setSex(java.lang.Integer sex) {
		this.sex = sex;
	}

	public java.lang.Integer getSex() {
		return this.sex;
	}

	public void setId_number(java.lang.String id_number) {
		this.id_number = id_number;
	}

	public java.lang.String getId_number() {
		return this.id_number;
	}

	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public java.util.Date getBirthday() {
		return this.birthday;
	}

	public void setNative_place(java.lang.String native_place) {
		this.native_place = native_place;
	}

	public java.lang.String getNative_place() {
		return this.native_place;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getAddress() {
		return this.address;
	}

	public void setNation(java.lang.Integer nation) {
		this.nation = nation;
	}

	public java.lang.Integer getNation() {
		return this.nation;
	}

	public void setMarital_status(java.lang.Integer marital_status) {
		this.marital_status = marital_status;
	}

	public java.lang.Integer getMarital_status() {
		return this.marital_status;
	}

	public void setPolitical_status(java.lang.Integer political_status) {
		this.political_status = political_status;
	}

	public java.lang.Integer getPolitical_status() {
		return this.political_status;
	}

	public void setPhoto(java.lang.String photo) {
		this.photo = photo;
	}

	public java.lang.String getPhoto() {
		return this.photo;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getType() {
		return this.type;
	}

	public void setPost(java.lang.String post) {
		this.post = post;
	}

	public java.lang.String getPost() {
		return this.post;
	}

	public void setPost_title(java.lang.String post_title) {
		this.post_title = post_title;
	}

	public java.lang.String getPost_title() {
		return this.post_title;
	}

	public void setPost_title_level(java.lang.Integer post_title_level) {
		this.post_title_level = post_title_level;
	}

	public java.lang.Integer getPost_title_level() {
		return this.post_title_level;
	}

	public void setScheduling_type(java.lang.Integer scheduling_type) {
		this.scheduling_type = scheduling_type;
	}

	public java.lang.Integer getScheduling_type() {
		return this.scheduling_type;
	}

	public void setPhone(java.lang.String phone) {
		this.phone = phone;
	}

	public java.lang.String getPhone() {
		return this.phone;
	}

	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	public java.lang.String getMobile() {
		return this.mobile;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getEmail() {
		return this.email;
	}

	public void setQq(java.lang.String qq) {
		this.qq = qq;
	}

	public java.lang.String getQq() {
		return this.qq;
	}

	public void setEntry_date(java.util.Date entry_date) {
		this.entry_date = entry_date;
	}

	public java.util.Date getEntry_date() {
		return this.entry_date;
	}

	public void setEducation(java.lang.Integer education) {
		this.education = education;
	}

	public java.lang.Integer getEducation() {
		return this.education;
	}

	public void setGraduate_date(java.util.Date graduate_date) {
		this.graduate_date = graduate_date;
	}

	public java.util.Date getGraduate_date() {
		return this.graduate_date;
	}

	public void setGraduate_school(java.lang.String graduate_school) {
		this.graduate_school = graduate_school;
	}

	public java.lang.String getGraduate_school() {
		return this.graduate_school;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getRemark() {
		return this.remark;
	}

	public void setResume(java.lang.String resume) {
		this.resume = resume;
	}

	public java.lang.String getResume() {
		return this.resume;
	}

	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public java.lang.Integer getUser_id() {
		return this.user_id;
	}

	public java.lang.String getUser_name() {
		return user_name;
	}

	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}

	public String gainNation() {
		String r = "";
		if (this.nation != null) {
			r = EnumNation.values()[this.nation].name();
		}
		return r;
	}

	public String gainEducation() {
		String r = "";
		if (this.education != null) {
			r = EnumEducation.values()[this.education].name();
		}
		return r;
	}
	
	public Staff gainStaffById(List<Staff> staffList, Integer user_id) {
		if (staffList == null || staffList.isEmpty() || user_id == null) {
			return null;
		}
		for (Staff staff : staffList) {
			if (user_id.equals(staff.getUser_id())) {
				return staff;
			}
		}
		return null;
	}
}