package com.xz.oa.core.service.notify.handler;

import org.springframework.context.ApplicationContext;

import com.lmax.disruptor.EventHandler;
import com.xz.base.context.SpringContextHolder;
import com.xz.oa.core.domain.entity.NotifyMessage;
import com.xz.oa.core.domain.enums.EnumNotifyMessageModuleType;
import com.xz.oa.core.service.notify.NotifyEvent;
import com.xz.oa.core.service.notify.NotifyMessageService;

/**
 * 排班事务提醒事件处理者（消费者）
 */
public class SchedulingNotifyEventHandler implements EventHandler<NotifyEvent> {

	/*
	 * 接收事件，保存事务提醒到数据库中
	 */
	public void onEvent(NotifyEvent event, long sequence, boolean endOfBatch) throws Exception {
		if (event != null && event.getMessage() != null) {
			NotifyMessage message = event.getMessage();
			if (message.getModule_type() == EnumNotifyMessageModuleType.值班.getValue()) {
				ApplicationContext context = SpringContextHolder.getContext();
				NotifyMessageService notifyService = (NotifyMessageService) context.getBean("notifyService");
				notifyService.create(message);
			}
		}
	}
}
