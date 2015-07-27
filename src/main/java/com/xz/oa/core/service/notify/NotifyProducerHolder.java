package com.xz.oa.core.service.notify;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.xz.oa.core.service.notify.handler.EmailNotifyEventHandler;
import com.xz.oa.core.service.notify.handler.LeaveInfoNotifyEventHandler;
import com.xz.oa.core.service.notify.handler.MeetingNotifyEventHandler;
import com.xz.oa.core.service.notify.handler.SchedulingNotifyEventHandler;

/**
 * 对话记录生产者单例持有者
 */
@SuppressWarnings("unchecked")
public class NotifyProducerHolder {
	private static final NotifyProducer producer;

	static {
		// Executor that will be used to construct new threads for consumers
		Executor executor = Executors.newCachedThreadPool();

		// The factory for the event
		NotifyEventFactory factory = new NotifyEventFactory();

		// Specify the size of the ring buffer, must be power of 2.
		int bufferSize = 1024;

		// Construct the Disruptor
		Disruptor<NotifyEvent> disruptor = new Disruptor<NotifyEvent>(factory, bufferSize, executor);

		// Connect the handler
		disruptor.handleEventsWith(new SchedulingNotifyEventHandler());
		disruptor.handleEventsWith(new MeetingNotifyEventHandler());
		disruptor.handleEventsWith(new EmailNotifyEventHandler());
		disruptor.handleEventsWith(new LeaveInfoNotifyEventHandler());

		// Start the Disruptor, starts all threads running
		disruptor.start();

		// Get the ring buffer from the Disruptor to be used for publishing.
		RingBuffer<NotifyEvent> ringBuffer = disruptor.getRingBuffer();

		producer = new NotifyProducer(ringBuffer);
	}
	
	public static NotifyProducer getNotifyProducer(){
		return producer;
	}
}
