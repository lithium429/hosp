package com.xz.oa.core.service.leave;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
 
import org.activiti.engine.HistoryService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.history.HistoricProcessInstanceQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xz.base.model.PageInfo;
import com.xz.base.utils.PageUtil;
import com.xz.oa.core.dao.leave.LeaveInfoDao; 
import com.xz.oa.core.domain.entity.LeaveInfo;

/**
 * 请假流程Service
 *
 * @author HenryYan
 */
@Service
public class LeaveInfoWorkflowService {

    private static Logger logger = LoggerFactory.getLogger(LeaveInfoWorkflowService.class);

    @Resource
    private LeaveInfoDao leaveInfoDao;

    private RuntimeService runtimeService;

    protected TaskService taskService;

    protected HistoryService historyService;

    protected RepositoryService repositoryService;

    @Autowired
    private IdentityService identityService;
    
	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return LeaveInfo
	 * @author davidwan
	 */
	public LeaveInfo findById(Integer id) {
		LeaveInfo entity = new LeaveInfo(id);
		return leaveInfoDao.selectEntity(entity);
	}

    /**
     * 启动流程
     *
     * @param entity
     */
    public ProcessInstance createAndStartWorkflow(LeaveInfo entity, Map<String, Object> variables) {
    	entity.setCreate_time(new Date());
    	leaveInfoDao.insertEntity(entity);
        logger.debug("save entity: {}", entity);
        String businessKey = entity.getId().toString();

        ProcessInstance processInstance = null;
        try {
            // 用来设置启动流程的人员ID，引擎会自动把用户ID保存到activiti:initiator中
            identityService.setAuthenticatedUserId(entity.getCreator_id().toString());

            processInstance = runtimeService.startProcessInstanceByKey("leave", businessKey, variables);
            String processInstanceId = processInstance.getId();
            entity = new LeaveInfo(entity.getId(), processInstanceId);
            leaveInfoDao.updateEntity(entity);
            logger.debug("start process of {key={}, bkey={}, pid={}, variables={}}", new Object[]{ "leave", businessKey, processInstanceId, variables });
        } finally {
            identityService.setAuthenticatedUserId(null);
        }
        return processInstance;
    }

    /**
     * 查询待办任务
     *
     * @param userId 用户ID
     * @return
     */
    public PageInfo<LeaveInfo> findTodoTasks(Integer userId, int pageIndex, int pageSize) {
        // 根据当前人的ID查询
        TaskQuery taskQuery = taskService.createTaskQuery().taskCandidateOrAssigned(userId.toString());
        int startIndex = PageUtil.gainStartIndex(pageIndex, pageSize);
        int endIndex = PageUtil.gainEndIndex(pageIndex, pageSize);

        List<Task> tasks = taskQuery.listPage(startIndex, endIndex);

        // 根据流程的业务ID查询实体并关联
        List<LeaveInfo> list = new ArrayList<LeaveInfo>();
        LeaveInfo leaveInfo = null;
        ProcessInstance processInstance = null;
        ProcessDefinition processDefinition = null;
        for (Task task : tasks) {
            String processInstanceId = task.getProcessInstanceId();
            processInstance = runtimeService.createProcessInstanceQuery().processInstanceId(processInstanceId).active().singleResult();
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            leaveInfo = leaveInfoDao.selectEntity(new LeaveInfo(businessKey));
            leaveInfo.setTask(task);
            leaveInfo.setProcessInstance(processInstance);
            processDefinition = getProcessDefinition(processInstance.getProcessDefinitionId());
            leaveInfo.setProcessDefinition(processDefinition);
            list.add(leaveInfo);
        }
        int count = (int)taskQuery.count();
        PageInfo<LeaveInfo> pageInfo = new PageInfo<LeaveInfo>(list, pageSize, count, pageIndex); 
        return pageInfo;
    }

    /**
     * 读取运行中的流程
     *
     * @return
     */ 
    public PageInfo<LeaveInfo> findRunningProcessInstaces(LeaveInfo entity, int pageIndex, int pageSize) {
        
        ProcessInstanceQuery query = runtimeService.createProcessInstanceQuery().processDefinitionKey("leave").active().orderByProcessInstanceId().desc();
        int startIndex = PageUtil.gainStartIndex(pageIndex, pageSize);
        int endIndex = PageUtil.gainEndIndex(pageIndex, pageSize);
        List<ProcessInstance> instancList = query.listPage(startIndex, endIndex);
        
        List<LeaveInfo> list = new ArrayList<LeaveInfo>();
        // 关联业务实体
        LeaveInfo leaveInfo = null;
        ProcessDefinition processDefinition = null;
        for (ProcessInstance processInstance : instancList) {
            String businessKey = processInstance.getBusinessKey();
            if (businessKey == null) {
                continue;
            }
            leaveInfo = leaveInfoDao.selectEntity(new LeaveInfo(businessKey));
            leaveInfo.setProcessInstance(processInstance);
            processDefinition = getProcessDefinition(processInstance.getProcessDefinitionId());
            leaveInfo.setProcessDefinition(processDefinition);
            list.add(leaveInfo);

            // 设置当前任务信息
            List<Task> tasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).active().orderByTaskCreateTime().desc().listPage(0, 1);
            leaveInfo.setTask(tasks.get(0));
        }
        int count = (int) query.count();
        PageInfo<LeaveInfo> pageInfo = new PageInfo<LeaveInfo>(list, pageSize, count, pageIndex); 
        return pageInfo;
    }

    /**
     * 读取已结束中的流程
     *
     * @return
     */ 
    public PageInfo<LeaveInfo> findFinishedProcessInstaces(LeaveInfo entity, int pageIndex, int pageSize) {
        HistoricProcessInstanceQuery query = historyService.createHistoricProcessInstanceQuery().processDefinitionKey("leave").finished().orderByProcessInstanceEndTime().desc();
        int startIndex = PageUtil.gainStartIndex(pageIndex, pageSize);
        int endIndex = PageUtil.gainEndIndex(pageIndex, pageSize);
        List<HistoricProcessInstance> historicList = query.listPage(startIndex, endIndex);

        List<LeaveInfo> list = new ArrayList<LeaveInfo>();
        // 关联业务实体
        LeaveInfo leaveInfo = null;
        ProcessDefinition processDefinition = null;
        for (HistoricProcessInstance historicProcessInstance : historicList) {
            String businessKey = historicProcessInstance.getBusinessKey();
            leaveInfo = leaveInfoDao.selectEntity(new LeaveInfo(businessKey));
            processDefinition = getProcessDefinition(historicProcessInstance.getProcessDefinitionId());
            leaveInfo.setProcessDefinition(processDefinition);
            leaveInfo.setHistoricProcessInstance(historicProcessInstance);
            list.add(leaveInfo);
        } 
        int count = (int) query.count();
        PageInfo<LeaveInfo> pageInfo = new PageInfo<LeaveInfo>(list, pageSize, count, pageIndex); 
        return pageInfo;
    }

    /**
     * 查询流程定义对象
     *
     * @param processDefinitionId 流程定义ID
     * @return
     */
    protected ProcessDefinition getProcessDefinition(String processDefinitionId) {
        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
        return processDefinition;
    }
    
    @Autowired
    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @Autowired
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Autowired
    public void setHistoryService(HistoryService historyService) {
        this.historyService = historyService;
    }

    @Autowired
    public void setRepositoryService(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

}
