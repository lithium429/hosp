package com.xz.oa.core.service.notify;

import com.xz.oa.core.domain.entity.NotifyMessage;
 
public class NotifyEventExecutor {

	public static void execute(NotifyMessage message) {
		NotifyProducer producer = NotifyProducerHolder.getNotifyProducer();
		producer.onData(message); 
	}
}
