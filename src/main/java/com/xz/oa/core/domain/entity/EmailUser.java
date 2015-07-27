package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List; 

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xz.base.domain.BaseEntity;
import com.xz.base.utils.DateUtil;
 
public class EmailUser extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 类型：1.发送，2.接收
	 */
	private java.lang.Byte type;

	/**
	 * 当type为1时，表示发送人id，为2表示接收人id
	 */
	private java.lang.Integer user_id;

	/**
	 * 是否转发
	 */
	private java.lang.Boolean is_forward;

	/**
	 * 是否回复
	 */
	private java.lang.Boolean is_reply;

	/**
	 * 被回复邮件id
	 */
	private java.lang.Integer reply_email_id;

	/**
	 * 是否删除
	 */
	private java.lang.Boolean is_delete;

	/**
	 * 是否发送
	 */
	private java.lang.Boolean is_send;

	/**
	 * 是否已读
	 */
	private java.lang.Boolean is_read;

	/**
	 * 是否密送
	 */
	private java.lang.Boolean is_secret;

	/**
	 * 是否抄送
	 */
	private java.lang.Boolean is_copy;

	/**
	 * email_id
	 */
	private java.lang.Integer email_id;

	/**
	 * 是否有附件
	 */
	private java.lang.Boolean is_file;

	/**
	 * sender_id
	 */
	private java.lang.Integer sender_id;

	/**
	 * sender_name
	 */
	private java.lang.String sender_name;

	/**
	 * user_name
	 */
	private java.lang.String user_name;

	/**
	 * 主题
	 */
	private java.lang.String subject;

	/**
	 * create_time
	 */
	private java.util.Date create_time;

	/**
	 * create_time
	 */
	private List<EmailReceiver> users;

	/**
	 * create_time
	 */
	private List<EmailFile> files;

	/**
	 * 内容
	 */
	private java.lang.String content;

	public java.lang.String getContent() {
		return content;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public EmailUser() {
	}
	
	public EmailUser(Integer emailId, Integer type) {
		this.email_id = emailId;
		this.type = (byte)type.intValue();
	}

	public List<EmailFile> getFiles() {
		return files;
	}

	public void setFiles(List<EmailFile> files) {
		this.files = files;
	}

	public List<EmailReceiver> getUsers() {
		return users;
	}

	public void setUsers(List<EmailReceiver> users) {
		this.users = users;
	}

	public java.util.Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.lang.String getSubject() {
		return subject;
	}

	public void setSubject(java.lang.String subject) {
		this.subject = subject;
	}

	public java.lang.String getUser_name() {
		return user_name;
	}

	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}

	public java.lang.Integer getSender_id() {
		return sender_id;
	}

	public void setSender_id(java.lang.Integer sender_id) {
		this.sender_id = sender_id;
	}

	public java.lang.String getSender_name() {
		return sender_name;
	}

	public void setSender_name(java.lang.String sender_name) {
		this.sender_name = sender_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public java.lang.Boolean getIs_file() {
		return is_file;
	}

	public void setIs_file(java.lang.Boolean is_file) {
		this.is_file = is_file;
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

	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public java.lang.Integer getUser_id() {
		return this.user_id;
	}

	public void setIs_forward(java.lang.Boolean is_forward) {
		this.is_forward = is_forward;
	}

	public java.lang.Boolean getIs_forward() {
		return this.is_forward;
	}

	public void setIs_reply(java.lang.Boolean is_reply) {
		this.is_reply = is_reply;
	}

	public java.lang.Boolean getIs_reply() {
		return this.is_reply;
	}

	public void setReply_email_id(java.lang.Integer reply_email_id) {
		this.reply_email_id = reply_email_id;
	}

	public java.lang.Integer getReply_email_id() {
		return this.reply_email_id;
	}

	public void setIs_delete(java.lang.Boolean is_delete) {
		this.is_delete = is_delete;
	}

	public java.lang.Boolean getIs_delete() {
		return this.is_delete;
	}

	public void setIs_send(java.lang.Boolean is_send) {
		this.is_send = is_send;
	}

	public java.lang.Boolean getIs_send() {
		return this.is_send;
	}

	public void setIs_read(java.lang.Boolean is_read) {
		this.is_read = is_read;
	}

	public java.lang.Boolean getIs_read() {
		return this.is_read;
	}

	public void setIs_secret(java.lang.Boolean is_secret) {
		this.is_secret = is_secret;
	}

	public java.lang.Boolean getIs_secret() {
		return this.is_secret;
	}

	public void setIs_copy(java.lang.Boolean is_copy) {
		this.is_copy = is_copy;
	}

	public java.lang.Boolean getIs_copy() {
		return this.is_copy;
	}

	public void setEmail_id(java.lang.Integer email_id) {
		this.email_id = email_id;
	}

	public java.lang.Integer getEmail_id() {
		return this.email_id;
	}

	@JsonIgnore
	public String getAllUserNames() {
		String r = "";
		if (this.users != null) {
			for (EmailReceiver item : this.users) {
				if (r == "") {
					r = item.getUser_name();
				} else {
					r += "," + item.getUser_name();
				}
			}
		}
		return r;
	}

	@JsonIgnore
	public String getUserNames() {
		String r = "";
		if (this.users != null) {
			for (EmailReceiver item : this.users) {
				if (item.getType() == 1) {
					if (r == "") {
						r = item.getUser_name();
					} else {
						r += "," + item.getUser_name();
					}
				}
			}
		}
		return r;
	}

	@JsonIgnore
	public String getUserNames_cs() {
		String r = "";
		if (this.users != null) {
			for (EmailReceiver item : this.users) {
				if (item.getType() == 2) {
					if (r == "") {
						r = item.getUser_name();
					} else {
						r += "," + item.getUser_name();
					}
				}
			}
		}
		return r;
	}

	@JsonIgnore
	public String getUserNames_cs(int user_id) {
		String r = "";
		if (this.users != null) {
			for (EmailReceiver item : this.users) {
				if (item.getType() == 2 && item.getUser_id() == user_id) {
					if (r == "") {
						r = item.getUser_name();
					} else {
						r += "," + item.getUser_name();
					}
				}
			}
		}
		return r;
	}

	@JsonIgnore
	public String getUserNames_ms() {
		String r = "";
		if (this.users != null) {
			for (EmailReceiver item : this.users) {
				if (item.getType() == 3) {
					if (r == "") {
						r = item.getUser_name();
					} else {
						r += "," + item.getUser_name();
					}
				}
			}
		}
		return r;
	}

	public String judge() {
		String r = "";
		long nowtime = new Date().getTime(), starttime = DateUtil.strToDate(DateUtil.todayStart()).getTime(), oneday = 24 * 3600 * 1000;
		if (this.create_time.getTime() > starttime) {
			// 1-5分钟
			if (nowtime - this.create_time.getTime() <= 5 * 60 * 1000) {
				r = "刚刚";
			} else if (nowtime - this.create_time.getTime() <= 10 * 60 * 1000) {
				r = "5分钟前";
			} else if (nowtime - this.create_time.getTime() <= 30 * 60 * 1000) {
				r = "10分钟前";
			} else if (nowtime - this.create_time.getTime() <= 1 * 60 * 60 * 1000) {
				r = "半小时前";
			} else if (nowtime - this.create_time.getTime() <= 5 * 60 * 60 * 1000) {
				r = "1小时前";
			} else if (nowtime - this.create_time.getTime() <= 10 * 60 * 60 * 1000) {
				r = "5小时前";
			} else if (nowtime - this.create_time.getTime() <= 15 * 60 * 60 * 1000) {
				r = "10小时前";
			} else {
				r = "15小时前";
			}
		} else if (starttime - this.create_time.getTime() > oneday) {
			r = DateUtil.dateToStr(this.create_time, "MM月dd日");
		} else {
			r = "昨天";
		}
		return r;
	}

}