package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.xz.base.domain.BaseEntity;

public class Meeting extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 主题
	 */
	private java.lang.String subject;

	/**
	 * 主持人
	 */
	private java.lang.String holder;

	/**
	 * 会议室
	 */
	private java.lang.Integer room_id;

	/**
	 * 会议室名称
	 */
	private java.lang.String room_name;

	/**
	 * 开始时间
	 */
	private java.util.Date begin_time;

	/**
	 * 结束时间
	 */
	private java.util.Date end_time;

	/**
	 * 内容
	 */
	private java.lang.String content;

	/**
	 * 状态：1.未开始，2.进行中，3.已结束，4.已取消
	 */
	private java.lang.Integer state;

	/**
	 * 审核状态：1.待审核，2.通过，3.不通过
	 */
	private java.lang.Integer verify_state;

	/**
	 * 是否发送用户消息
	 */
	private java.lang.Boolean is_send_umsg;

	/**
	 * 是否发送短信
	 */
	private java.lang.Boolean is_send_smsg;
	
	/**
	 * 是否已经发送
	 */
	private java.lang.Boolean is_sended;

	/**
	 * 所属用户id
	 */
	private java.lang.Integer creator_id;
	
	/**
	 * 所属用户名称
	 */
	private java.lang.String creator_real_name;

	/**
	 * 创建时间
	 */
	private java.util.Date create_time;

	/**
	 * 附件
	 */
	private List<MeetingFile> files;

	/**
	 * 会议出席人
	 */
	private List<MeetingUser> users;

	/**
	 * 审核记录
	 */
	private List<MeetingVerifyRecord> verifys;

	/**
	 * 用户ids
	 */
	private java.lang.String user_ids;
	
	public java.lang.Double remind_time;

	/**
	 * 审核用户id
	 */
	private java.lang.Integer verify_user_id;
	
	/**
	 * 审核用户名称
	 */
	private java.lang.String verify_user_name;
	
	/**
	 * 审核时间
	 */
	private java.util.Date verify_time;
	
	/**
	 * 审核用户名称
	 */
	private java.lang.String verify_content;

	public Meeting() {
	}
	
	public Meeting(Boolean isSended) {
		this.is_sended = isSended;
	}
	
	public Meeting(Integer id, Boolean isSendUmsg) {
		this.id = id;
		this.is_send_umsg = isSendUmsg;
	}
	
	public Meeting(Integer verifyState, Boolean isSendUmsg, Boolean isSended) {
		this.verify_state = verifyState;
		this.is_send_umsg = isSendUmsg;
		this.is_sended = isSended;
	}
	
	public Meeting(Integer id, Integer state) {
		this.id = id;
		this.state = state;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setSubject(java.lang.String subject) {
		this.subject = subject;
	}

	public java.lang.String getSubject() {
		return this.subject;
	}

	public void setHolder(java.lang.String holder) {
		this.holder = holder;
	}

	public java.lang.String getHolder() {
		return this.holder;
	}

	public void setRoom_id(java.lang.Integer room_id) {
		this.room_id = room_id;
	}

	public java.lang.Integer getRoom_id() {
		return this.room_id;
	}

	public void setRoom_name(java.lang.String room_name) {
		this.room_name = room_name;
	}

	public java.lang.String getRoom_name() {
		return this.room_name;
	}

	public void setBegin_time(java.util.Date begin_time) {
		this.begin_time = begin_time;
	}

	public java.util.Date getBegin_time() {
		return this.begin_time;
	}

	public void setEnd_time(java.util.Date end_time) {
		this.end_time = end_time;
	}

	public java.util.Date getEnd_time() {
		return this.end_time;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
	}

	public void setState(java.lang.Integer state) {
		this.state = state;
	}

	public java.lang.Integer getState() {
		return this.state;
	}

	public void setVerify_state(java.lang.Integer verify_state) {
		this.verify_state = verify_state;
	}

	public java.lang.Integer getVerify_state() {
		return this.verify_state;
	}

	public void setIs_send_umsg(java.lang.Boolean is_send_umsg) {
		this.is_send_umsg = is_send_umsg;
	}

	public java.lang.Boolean getIs_send_umsg() {
		return this.is_send_umsg;
	}

	public void setIs_send_smsg(java.lang.Boolean is_send_smsg) {
		this.is_send_smsg = is_send_smsg;
	}

	public java.lang.Boolean getIs_send_smsg() {
		return this.is_send_smsg;
	} 

	public java.lang.Boolean getIs_sended() {
		return is_sended;
	}

	public void setIs_sended(java.lang.Boolean is_sended) {
		this.is_sended = is_sended;
	}

	public void setCreator_id(java.lang.Integer creator_id) {
		this.creator_id = creator_id;
	}

	public java.lang.Integer getCreator_id() {
		return this.creator_id;
	} 
	
	public java.lang.String getCreator_real_name() {
		return creator_real_name;
	}

	public void setCreator_real_name(java.lang.String creator_real_name) {
		this.creator_real_name = creator_real_name;
	}

	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}

	public void setFiles(List<MeetingFile> files) {
		this.files = files;
	}

	public List<MeetingFile> getFiles() {
		return this.files;
	}

	public void setUsers(List<MeetingUser> users) {
		this.users = users;
	}

	public List<MeetingUser> getUsers() {
		return this.users;
	}

	public void setVerifys(List<MeetingVerifyRecord> verifys) {
		this.verifys = verifys;
	}

	public List<MeetingVerifyRecord> getVerifys() {
		return this.verifys;
	}

	public void setUser_ids(java.lang.String user_ids) {
		this.user_ids = user_ids;
	}

	public java.lang.String getUser_ids() {
		return this.user_ids;
	}

	public void setRemind_time(java.lang.Double remind_time) {
		this.remind_time = remind_time;
	}

	public java.lang.Double getRemind_time() {
		return this.remind_time;
	}

	public java.lang.Integer getVerify_user_id() {
		return verify_user_id;
	}

	public void setVerify_user_id(java.lang.Integer verify_user_id) {
		this.verify_user_id = verify_user_id;
	}

	public java.lang.String getVerify_user_name() {
		return verify_user_name;
	}

	public void setVerify_user_name(java.lang.String verify_user_name) {
		this.verify_user_name = verify_user_name;
	}

	public java.util.Date getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(java.util.Date verify_time) {
		this.verify_time = verify_time;
	}

	public java.lang.String getVerify_content() {
		return verify_content;
	}

	public void setVerify_content(java.lang.String verify_content) {
		this.verify_content = verify_content;
	}

	public String getUserIds() {
		String r = "";
		if (users != null) {

			for (MeetingUser item : users) {
				if (r == "") {
					r = String.valueOf(item.getUser_id());
				} else {
					r = r + "," + String.valueOf(item.getUser_id());
				}
			}
		}
		return r;
	}

	public String getUserNames() {
		String r1 = "";
		if (users != null) {

			for (MeetingUser item : users) {
				if (r1 == "") {
					r1 = item.getUser_name();
				} else {
					r1 = r1 + "," + item.getUser_name();
				}
			}
		}
		return r1;
	}
	
	//获取状态根据时间
	public String getStateBydate(){
		String r="-";
		int state=0;
		if(this.verify_state==2)
		{
			if(this.state!=null && this.state==4)
			{
				r="已取消";
				state=4;
			}else
			{
				Date now=new Date();
				if(this.begin_time!=null && now.before(this.begin_time))
				{
					r="未开始";
					state=1;
				}else if(this.end_time !=null && now.after(this.end_time))
				{
					r="已结束";
					state=3;
				}else
				{
					r="进行中";
					state=2;
				}
			}
			
		}
		this.state=state;
		return r;
	}
	

	
	//获取状态根据时间
	public void genateStateBydate(){
		int state=0;
		if(this.state!=null && this.state==4)
		{
			state=4;
		}else
		{
			Date now=new Date();
			if(this.begin_time!=null && now.before(this.begin_time))
			{
				state=1;
			}else if(this.end_time !=null && now.after(this.end_time))
			{
				state=3;
			}else
			{
				state=2;
			}
		}
		this.state=state;
	}

}