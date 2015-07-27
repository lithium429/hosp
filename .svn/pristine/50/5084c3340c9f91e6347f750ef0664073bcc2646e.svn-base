package com.xz.oa.core.service.leave;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.oa.core.dao.workflow.ActivitiDao;

/**
 * 请假流程结束监听器
 *
 * @author: Henry Yan
 */
@Service 
public class LeaveProcessEndListener implements ExecutionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7084106194323197213L;

	protected Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ActivitiDao activitiDao;

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        String processInstanceId = execution.getProcessInstanceId();
        int i = activitiDao.deleteFormPropertyByProcessInstanceId(processInstanceId);
        logger.debug("清理了 {} 条历史表单数据", i);
    }
}
