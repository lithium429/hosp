package com.xz.oa.core.service.leave;
 
import org.activiti.engine.RuntimeService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Component;

import com.xz.base.context.SpringContextHolder;
import com.xz.oa.core.dao.leave.LeaveInfoDao;
import com.xz.oa.core.domain.entity.LeaveInfo;

import java.util.Date;

/**
 * 调整请假内容处理器
 *
 * @author HenryYan
 */
@Component
public class AfterModifyApplyContentProcessor implements TaskListener {

    private static final long serialVersionUID = 1L;

    private LeaveInfoDao leaveInfoDao;

    private RuntimeService runtimeService;

    /* (non-Javadoc)
     * @see org.activiti.engine.delegate.TaskListener#notify(org.activiti.engine.delegate.DelegateTask)
     */
    public void notify(DelegateTask delegateTask) {
    	leaveInfoDao = (LeaveInfoDao)SpringContextHolder.getContext().getBean("leaveInfoDao");
		runtimeService = (RuntimeService)SpringContextHolder.getContext().getBean("runtimeService");
    	
        String processInstanceId = delegateTask.getProcessInstanceId();
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
        LeaveInfo leaveInfo = leaveInfoDao.selectEntity(new LeaveInfo(processInstance.getBusinessKey()));

        leaveInfo.setType((Integer) delegateTask.getVariable("leaveType"));
        leaveInfo.setStart_time((Date) delegateTask.getVariable("startTime"));
        leaveInfo.setEnd_time((Date) delegateTask.getVariable("endTime"));
        leaveInfo.setReason((String) delegateTask.getVariable("reason"));
        leaveInfo.setIs_notify((Boolean) delegateTask.getVariable("is_notify"));

        leaveInfoDao.updateEntity(leaveInfo);
    }

}
