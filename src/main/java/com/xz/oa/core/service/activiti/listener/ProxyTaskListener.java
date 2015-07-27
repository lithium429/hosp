package com.xz.oa.core.service.activiti.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

import java.util.Collections;
import java.util.List;

public class ProxyTaskListener implements TaskListener {

	private List<TaskListener> taskListeners = Collections.EMPTY_LIST;

	@Override
	public void notify(DelegateTask delegateTask) {
		for (TaskListener taskListener : taskListeners) {
			taskListener.notify(delegateTask);
		}
	}

	public void setTaskListeners(List<TaskListener> taskListeners) {
		this.taskListeners = taskListeners;
	}

}
