package com.xz.oa.core.domain.entity;

import java.util.Date;
import java.util.List;
import java.io.Serializable;
import com.xz.base.domain.BaseEntity;
import com.xz.base.utils.SpellUtil;

public class Address extends BaseEntity implements Serializable {

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
	 * 名称拼音
	 */
	private java.lang.String pname;

	/**
	 * 名称首字母拼音
	 */
	private java.lang.String fname;

	/**
	 * 头像
	 */
	private java.lang.String img_url;

	/**
	 * dept_id
	 */
	private java.lang.Integer dept_id;

	/**
	 * dept_name
	 */
	private java.lang.String dept_name;

	/**
	 * dept_id
	 */
	private java.lang.Integer dept_id_old;

	/**
	 * 所属分组id
	 */
	private java.lang.Integer group_id;

	/**
	 * 所属分组名称
	 */
	private java.lang.String group_name;

	/**
	 * 所属分组id
	 */
	private java.lang.Integer group_id_old;

	/**
	 * post
	 */
	private java.lang.String post;

	/**
	 * 性别：1.男，2.女
	 */
	private java.lang.Integer sex;

	/**
	 * 电子邮箱
	 */
	private java.lang.String email;

	/**
	 * 手机号码
	 */
	private java.lang.String mobile;

	/**
	 * qq
	 */
	private java.lang.String qq;

	/**
	 * 单位
	 */
	private java.lang.String company;

	/**
	 * 联系地址
	 */
	private java.lang.String address;

	/**
	 * 备注
	 */
	private java.lang.String remark;

	/**
	 * 类型：1.内部，2.外部
	 */
	private java.lang.Integer type;

	/**
	 * 是否共享
	 */
	private java.lang.Boolean is_share;

	/**
	 * 所属用户
	 */
	private java.lang.Integer creator_id;

	/**
	 * 创建时间
	 */
	private java.util.Date create_time;

	private List<AddressUser> addressUsers;

	private String addressUserIds;

	private String addressUserNames;

	/**
	 * 所属用户
	 */
	private java.lang.String creator_name;

	public java.lang.Integer user_id;

	public Address() {
	}
	
	public Address(Integer id, User user) {
		this.id = id;
		this.name = user.getReal_name();
		this.pname = SpellUtil.getFullSpell(this.name);
		this.fname = SpellUtil.getFirstOneSpell(this.name);
		this.sex = user.getSex();
		this.dept_id = user.getDept_id();
	}

	public Address(User user, Integer creatorId) {
		this.dept_id = user.getDept_id();
		this.name = user.getReal_name();
		this.create_time = new Date();
		this.creator_id = creatorId;
		this.user_id = user.getId();
		this.sex = user.getSex();
		this.mobile = user.getMobile();
		this.email = user.getEmail();
		this.qq = user.getQq();
		this.pname = SpellUtil.getFullSpell(user.getReal_name());
		this.fname = SpellUtil.getFirstOneSpell(user.getReal_name());
		this.type = 1;
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

	public void setPname(java.lang.String pname) {
		this.pname = pname;
	}

	public java.lang.String getPname() {
		return this.pname;
	}

	public void setFname(java.lang.String fname) {
		this.fname = fname;
	}

	public java.lang.String getFname() {
		return this.fname;
	}

	public void setImg_url(java.lang.String img_url) {
		this.img_url = img_url;
	}

	public java.lang.String getImg_url() {
		return this.img_url;
	}

	public void setDept_id(java.lang.Integer dept_id) {
		this.dept_id = dept_id;
	}

	public java.lang.Integer getDept_id() {
		return this.dept_id;
	}

	public void setDept_name(java.lang.String dept_name) {
		this.dept_name = dept_name;
	}

	public java.lang.String getDept_name() {
		return this.dept_name;
	}

	public void setDept_id_old(java.lang.Integer dept_id_old) {
		this.dept_id_old = dept_id_old;
	}

	public java.lang.Integer getDept_id_old() {
		return this.dept_id_old;
	}

	public void setGroup_id(java.lang.Integer group_id) {
		this.group_id = group_id;
	}

	public java.lang.Integer getGroup_id() {
		return this.group_id;
	}

	public void setGroup_name(java.lang.String group_name) {
		this.group_name = group_name;
	}

	public java.lang.String getGroup_name() {
		return this.group_name;
	}

	public void setGroup_id_old(java.lang.Integer group_id_old) {
		this.group_id_old = group_id_old;
	}

	public java.lang.Integer getGroup_id_old() {
		return this.group_id_old;
	}

	public void setPost(java.lang.String post) {
		this.post = post;
	}

	public java.lang.String getPost() {
		return this.post;
	}

	public void setSex(java.lang.Integer sex) {
		this.sex = sex;
	}

	public java.lang.Integer getSex() {
		return this.sex;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getEmail() {
		return this.email;
	}

	public void setMobile(java.lang.String mobile) {
		this.mobile = mobile;
	}

	public java.lang.String getMobile() {
		return this.mobile;
	}

	public void setQq(java.lang.String qq) {
		this.qq = qq;
	}

	public java.lang.String getQq() {
		return this.qq;
	}

	public void setCompany(java.lang.String company) {
		this.company = company;
	}

	public java.lang.String getCompany() {
		return this.company;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getAddress() {
		return this.address;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getRemark() {
		return this.remark;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getType() {
		return this.type;
	}

	public void setIs_share(java.lang.Boolean is_share) {
		this.is_share = is_share;
	}

	public java.lang.Boolean getIs_share() {
		return this.is_share;
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

	public void setAddressUsers(List<AddressUser> addressUsers) {
		this.addressUsers = addressUsers;
	}

	public List<AddressUser> getAddressUsers() {
		return this.addressUsers;
	}

	public void setAddressUserIds(java.lang.String addressUserIds) {
		this.addressUserIds = addressUserIds;
	}

	public java.lang.String getAddressUserIds() {
		return this.addressUserIds;
	}

	public void setAddressUserNames(java.lang.String addressUserNames) {
		this.addressUserNames = addressUserNames;
	}

	public java.lang.String getAddressUserNames() {
		return this.addressUserNames;
	}

	public String getUserIdsByAddressUsers() {
		String r = "";
		if (addressUsers != null) {

			for (AddressUser item : addressUsers) {
				if (r == "") {
					r = String.valueOf(item.getUser_id());
				} else {
					r = r + "," + String.valueOf(item.getUser_id());
				}
			}
		}
		return r;
	}

	public String getUserNamesByAddressUsers() {
		String r1 = "";
		if (addressUsers != null) {

			for (AddressUser item : addressUsers) {
				if (r1 == "") {
					r1 = item.getUser_name();
				} else {
					r1 = r1 + "," + item.getUser_name();
				}
			}
		}
		return r1;
	}

	public java.lang.String getCreator_name() {
		return creator_name;
	}

	public void setCreator_name(java.lang.String creator_name) {
		this.creator_name = creator_name;
	}

	public java.lang.Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public Address gainAddressById(List<Address> addressList, Integer user_id) {
		if (addressList == null || addressList.isEmpty() || user_id == null) {
			return null;
		}
		for (Address address : addressList) {
			if (user_id.equals(address.getUser_id())) {
				return address;
			}
		}
		return null;
	}

}