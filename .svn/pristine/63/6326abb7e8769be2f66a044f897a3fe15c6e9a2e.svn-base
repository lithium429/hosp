package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xz.base.domain.BaseEntity;
import com.xz.base.utils.DateUtil;
import com.xz.oa.core.domain.enums.EnumNotifyMessageModuleType;

public class NotifyMessage extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 提醒发送者
	 */
	private java.lang.Integer sender_id;

	/**
	 * 发送者姓名
	 */
	private java.lang.String sender_name;

	/**
	 * 发送者姓名
	 */
	private java.lang.String sender_real_name;

	/**
	 * 提醒接收者
	 */
	private java.lang.Integer receiver_id;

	/**
	 * 类型：1.系统消息，2.用户消息
	 */
	private java.lang.Integer type;

	/**
	 * 内容
	 */
	private java.lang.String content;

	/**
	 * 是否已读
	 */
	private java.lang.Boolean is_read;

	/**
	 * 提醒地址
	 */
	private java.lang.String url;

	/**
	 * 模块类型：1.会议，2.邮件，3.值班，4.督办流程
	 */
	private java.lang.Integer module_type;

	/**
	 * ref_id
	 */
	private java.lang.Integer ref_id;

	/**
	 * create_time
	 */
	private java.util.Date create_time;

	/**
	 * 是否已经被查询
	 */
	private java.lang.Boolean is_query;

	public NotifyMessage() {
	}

	public NotifyMessage(Integer moduleType) {
		this.module_type = moduleType;
	}

	public NotifyMessage(Integer moduleType, Integer refId) {
		this.module_type = moduleType;
		this.ref_id = refId;
	}

	public NotifyMessage(Integer senderId, Integer receiverId, Integer type, Scheduling scheduling) {
		this.sender_id = senderId;
		this.receiver_id = receiverId;
		this.type = type;
		// 内容
		String week = DateUtil.getDayOfWeekForText(scheduling.getDay_of_week());
		String startTime = DateUtil.dateToStr(scheduling.getStart_time(), "HH:mm");
		String endTime = DateUtil.dateToStr(scheduling.getEnd_time(), "HH:mm");
		this.content = "值班提醒，日期：" + scheduling.getYear() + "年" + scheduling.getMonth() + "月" + scheduling.getDay() + "日" + "，星期" + week + "，时间段：" + startTime + "-" + endTime;
		this.url = "scheduling/view.do?from=notify&id=" + scheduling.getId();
		this.module_type = EnumNotifyMessageModuleType.值班.getValue();
		this.ref_id = scheduling.getId();
		this.create_time = new Date();
	}

	public NotifyMessage(Integer senderId, Integer receiverId, Integer type, Meeting meeting) {
		this.sender_id = senderId;
		this.receiver_id = receiverId;
		this.type = type;
		// 内容
		String beginTime = DateUtil.dateToStr(meeting.getBegin_time(), "yyyy-MM-dd HH:mm");
		this.content = meeting.getCreator_real_name() + "通知您于" + beginTime + "在" + meeting.getRoom_name() + "开会，会议主题：" + meeting.getSubject();
		this.url = "meeting/view.do?from=notify&id=" + meeting.getId();
		this.module_type = EnumNotifyMessageModuleType.会议.getValue();
		this.ref_id = meeting.getId();
		this.create_time = new Date();
	}

	public NotifyMessage(Integer senderId, Integer receiverId, Integer type, Email email) {
		this.sender_id = senderId;
		this.receiver_id = receiverId;
		this.type = type;
		// 请查收我的邮件！主题：Fw:会议：测试会议
		this.content = "请查收我的邮件，邮件主题：" + email.getSubject();
		this.url = "email/view.do?from=notify&id=" + email.getId();
		this.module_type = EnumNotifyMessageModuleType.邮件.getValue();
		this.ref_id = email.getId();
		this.create_time = new Date();
	}

	public NotifyMessage(Integer senderId, Integer receiverId, Integer type, String content, String url, Integer moduleType, Integer refId) {
		this.sender_id = senderId;
		this.receiver_id = receiverId;
		this.type = type;
		this.content = content;
		this.url = url;
		this.module_type = moduleType;
		this.ref_id = refId;
		this.create_time = new Date();
	}

	public NotifyMessage(Integer senderId, Integer receiverId, Integer type, Leave leave) {
		this.sender_id = senderId;
		this.receiver_id = receiverId;
		this.type = type;
		// 内容
		this.content = "有一条请假信息需要您审批！";
		this.url = "leave/verify.do?from=notify&id=" + leave.getId();
		this.module_type = EnumNotifyMessageModuleType.请假.getValue();
		this.ref_id = leave.getId();
		this.create_time = new Date();
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setSender_id(java.lang.Integer sender_id) {
		this.sender_id = sender_id;
	}

	public java.lang.Integer getSender_id() {
		return this.sender_id;
	}

	public java.lang.String getSender_name() {
		return sender_name;
	}

	public void setSender_name(java.lang.String sender_name) {
		this.sender_name = sender_name;
	}

	public java.lang.String getSender_real_name() {
		return sender_real_name;
	}

	public void setSender_real_name(java.lang.String sender_real_name) {
		this.sender_real_name = sender_real_name;
	}

	public void setReceiver_id(java.lang.Integer receiver_id) {
		this.receiver_id = receiver_id;
	}

	public java.lang.Integer getReceiver_id() {
		return this.receiver_id;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getType() {
		return this.type;
	}

	public void setContent(java.lang.String content) {
		this.content = content;
	}

	public java.lang.String getContent() {
		return this.content;
	}

	public void setIs_read(java.lang.Boolean is_read) {
		this.is_read = is_read;
	}

	public java.lang.Boolean getIs_read() {
		return this.is_read;
	}

	public void setUrl(java.lang.String url) {
		this.url = url;
	}

	public java.lang.String getUrl() {
		return this.url;
	}

	public void setModule_type(java.lang.Integer module_type) {
		this.module_type = module_type;
	}

	public java.lang.Integer getModule_type() {
		return this.module_type;
	}

	public void setRef_id(java.lang.Integer ref_id) {
		this.ref_id = ref_id;
	}

	public java.lang.Integer getRef_id() {
		return this.ref_id;
	}

	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}

	public java.lang.Boolean getIs_query() {
		return is_query;
	}

	public void setIs_query(java.lang.Boolean is_query) {
		this.is_query = is_query;
	}

	/**
	 * @Description 按照模块类型进行分组
	 * @param list
	 * @return Map<String,List<NotifyMessage>>
	 */
	public Map<Integer, List<NotifyMessage>> groupByModuleType(List<NotifyMessage> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}

		Map<Integer, List<NotifyMessage>> map = new HashMap<Integer, List<NotifyMessage>>();
		List<NotifyMessage> tempList = null;
		Integer key = null;
		for (NotifyMessage item : list) {
			key = item.getModule_type();
			if (!map.containsKey(key)) {
				tempList = new ArrayList<NotifyMessage>();
				tempList.add(item);
				map.put(key, tempList);
			} else {
				tempList = map.get(key);
				tempList.add(item);
			}
		}
		return map;
	}
}