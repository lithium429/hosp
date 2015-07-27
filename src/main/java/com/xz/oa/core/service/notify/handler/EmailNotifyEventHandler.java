package com.xz.oa.core.service.notify.handler;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;

import com.lmax.disruptor.EventHandler;
import com.xz.base.context.SpringContextHolder; 
import com.xz.oa.core.domain.entity.Email;
import com.xz.oa.core.domain.entity.EmailUser;
import com.xz.oa.core.domain.entity.NotifyMessage;
import com.xz.oa.core.domain.enums.EnumEmailUserType;
import com.xz.oa.core.domain.enums.EnumNotifyMessageModuleType;
import com.xz.oa.core.domain.enums.EnumNotifyMessageType;
import com.xz.oa.core.service.email.EmailService;
import com.xz.oa.core.service.email.EmailUserService;
import com.xz.oa.core.service.notify.NotifyEvent;
import com.xz.oa.core.service.notify.NotifyMessageService;

/**
 * 邮件事务提醒事件处理者（消费者）
 */
public class EmailNotifyEventHandler implements EventHandler<NotifyEvent> {

	/*
	 * 接收事件，保存事务提醒到数据库中
	 */
	public void onEvent(NotifyEvent event, long sequence, boolean endOfBatch) throws Exception {
		if (event != null && event.getMessage() != null) {
			NotifyMessage message = event.getMessage();
			if (message.getModule_type() == EnumNotifyMessageModuleType.邮件.getValue()) {
				ApplicationContext context = SpringContextHolder.getContext();
				NotifyMessageService notifyService = (NotifyMessageService) context.getBean("notifyService");
				Integer emailId = message.getRef_id();
				EmailUserService emailUserService = (EmailUserService) context.getBean("emailUserService");
				EmailService emailService = (EmailService) context.getBean("emailService");

				EmailUser emailUser = new EmailUser(emailId, EnumEmailUserType.接收.getValue());
				List<EmailUser> list = emailUserService.queryList(emailUser);

				Email email = emailService.findById(emailId);

				if (email != null && list != null && !list.isEmpty()) {
					String content = null;
					if (StringUtils.isNotBlank(email.getSubject())) {
						content = "请查收我的邮件！主题：" + email.getSubject();
					} else {
						content = "请查收我的邮件！主题：[暂无主题]";
					}
					for (EmailUser item : list) {
						message = new NotifyMessage(email.getSender_id(), item.getUser_id(), EnumNotifyMessageType.系统.getValue(), content, "email/view.do?from=notify&id=" + item.getId(),
								EnumNotifyMessageModuleType.邮件.getValue(), item.getId());
						notifyService.create(message);
					}
				}

			}
		}
	}
}
