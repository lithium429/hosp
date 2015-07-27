package com.xz.oa.core.service.notify;

import com.lmax.disruptor.RingBuffer;
import com.xz.oa.core.domain.entity.NotifyMessage;

/**
 * 事务提醒生产者
 */
public class NotifyProducer {
	private RingBuffer<NotifyEvent> ringBuffer;

	public NotifyProducer() {

	}

	public NotifyProducer(RingBuffer<NotifyEvent> ringBuffer) {
		this.ringBuffer = ringBuffer;
	}

	/**
	 * @Description: 发布事务提醒事件
	 * @param record
	 *            对话记录
	 * @author davidwan
	 */
	public void onData(NotifyMessage message) {
		long sequence = ringBuffer.next();
		try {
			NotifyEvent event = ringBuffer.get(sequence);
			event.setMessage(message);
		} finally {
			ringBuffer.publish(sequence);
		}
	}
}
