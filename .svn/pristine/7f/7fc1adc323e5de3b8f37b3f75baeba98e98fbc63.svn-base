package com.xz.oa.core.service.leave;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import com.xz.base.context.SpringContextHolder;
import com.xz.oa.core.dao.leave.LeaveInfoDao;
import com.xz.oa.core.domain.entity.LeaveInfo;

import java.util.Date;

/**
 * 销假后处理器
 * <p>
 * 设置销假时间
 * </p>
 * <p>
 * 使用Spring代理，可以注入Bean，管理事物
 * </p>
 * 
 * @author HenryYan
 */
@Service
public class ReportBackEndProcessor implements TaskListener {

	private static final long serialVersionUID = 1L;
 
	private LeaveInfoDao leaveInfoDao;

	private RuntimeService runtimeService;

	/*
	 * 通知
	 */
	public void notify(DelegateTask delegateTask) {
		leaveInfoDao = (LeaveInfoDao)SpringContextHolder.getContext().getBean("leaveInfoDao");
		runtimeService = (RuntimeService)SpringContextHolder.getContext().getBean("runtimeService");
		
		String processInstanceId = delegateTask.getProcessInstanceId();
		ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
		LeaveInfo leave = leaveInfoDao.selectEntity(new LeaveInfo(processInstance.getBusinessKey()));

		Object realityStartTime = delegateTask.getVariable("realityStartTime");
		leave.setReality_start_time((Date) realityStartTime);
		Object realityEndTime = delegateTask.getVariable("realityEndTime");
		leave.setReality_end_time((Date) realityEndTime);

		leaveInfoDao.updateEntity(leave);
	} 
}
