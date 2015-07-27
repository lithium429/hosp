package com.xz.oa.core.service.notify.handler;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.lmax.disruptor.EventHandler;
import com.xz.base.context.SpringContextHolder;
import com.xz.base.utils.DateUtil;
import com.xz.oa.core.domain.entity.Meeting;
import com.xz.oa.core.domain.entity.MeetingUser;
import com.xz.oa.core.domain.entity.NotifyMessage;
import com.xz.oa.core.domain.enums.EnumMeetingState;
import com.xz.oa.core.domain.enums.EnumNotifyMessageModuleType;
import com.xz.oa.core.domain.enums.EnumNotifyMessageType;
import com.xz.oa.core.domain.enums.EnumVerifyState;
import com.xz.oa.core.service.meeting.MeetingService;
import com.xz.oa.core.service.notify.NotifyEvent;
import com.xz.oa.core.service.notify.NotifyMessageService;

/**
 * 事务提醒事件处理者（消费者）
 */
public class MeetingNotifyEventHandler implements EventHandler<NotifyEvent> {

	private NotifyMessageService notifyService;

	/*
	 * 接收事件，保存会议事务提醒到数据库中
	 */
	public void onEvent(NotifyEvent event, long sequence, boolean endOfBatch) throws Exception {
		if (event != null && event.getMessage() != null) {
			NotifyMessage message = event.getMessage();
			if (message.getModule_type() == EnumNotifyMessageModuleType.会议.getValue()) {
				ApplicationContext context = SpringContextHolder.getContext();
				MeetingService meetingService = (MeetingService) context.getBean("meetingService");
				notifyService = (NotifyMessageService) context.getBean("notifyService");

				String[] refIds = (String[]) message.getMap().get("ref_ids");
				Meeting meeting = null;
				if (message.getRef_id() != null) {
					meeting = new Meeting(message.getRef_id(), true);
					meeting = meetingService.find(meeting);
					if (meeting != null) {
						if (meeting.getState() == EnumMeetingState.已取消.getValue()) {
							saveNotifyMessageForCancel(meeting);
						} else {
							saveNotifyMessageForVerify(meeting);
						}
					}
				} else if (refIds != null && refIds.length > 0) {
					meeting = new Meeting(message.getRef_id(), true);
					List<Meeting> meetingList = meetingService.queryList(meeting);
					if (meetingList != null && !meetingList.isEmpty()) {
						for (Meeting item : meetingList) {
							saveNotifyMessageForVerify(item);
						}
					}
				}
			}
		}
	}

	/**
	 * @Description 保存会议审核事务提醒到数据库
	 * @param meeting
	 *            void
	 */
	private void saveNotifyMessageForVerify(Meeting meeting) {

		NotifyMessage message = null;
		String content = "";
		if (meeting.getVerify_state() == EnumVerifyState.审核通过.getValue()) {
			content = "您的会议申请已通过审核，会议主题：" + meeting.getSubject();
		} else if (meeting.getVerify_state() == EnumVerifyState.审核不通过.getValue()) {
			content = "您的会议申请未通过审核，会议主题：" + meeting.getSubject();
		}

		// 通知会议申请人
		message = new NotifyMessage(null, meeting.getCreator_id(), EnumNotifyMessageType.系统.getValue(), content, "meeting/view.do?from=notify&id=" + meeting.getId(), EnumNotifyMessageModuleType.会议.getValue(),
				meeting.getId());
		notifyService.create(message);

		// 通知参会人员
		if (meeting.getUsers() != null && !meeting.getUsers().isEmpty() && meeting.getVerify_state() == EnumVerifyState.审核通过.getValue()) {
			for (MeetingUser user : meeting.getUsers()) {
				message = new NotifyMessage(meeting.getCreator_id(), user.getUser_id(), EnumNotifyMessageType.系统.getValue(), meeting);
				notifyService.create(message);
			}
		}
	}

	/**
	 * @Description 保存会议取消提醒到数据库
	 * @param meeting
	 * void
	 */
	private void saveNotifyMessageForCancel(Meeting meeting) {
		String beginTime = DateUtil.dateToStr(meeting.getBegin_time(), "yyyy-MM-dd HH:mm");
		String content = meeting.getCreator_real_name() + "通知您原定于" + beginTime + "在" + meeting.getRoom_name() + "的会议已被取消，会议主题：" + meeting.getSubject();
		NotifyMessage message = null;
		if (meeting.getUsers() != null && !meeting.getUsers().isEmpty()) {
			for (MeetingUser user : meeting.getUsers()) {
				message = new NotifyMessage(meeting.getCreator_id(), user.getUser_id(), EnumNotifyMessageType.系统.getValue(), content, "meeting/view.do?from=notify&id=" + meeting.getId(), EnumNotifyMessageModuleType.会议.getValue(),
						meeting.getId());
				notifyService.create(message);
			}
		}
	}
}
