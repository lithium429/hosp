package com.xz.oa.core.domain.entity;
 
import java.io.Serializable;
import java.util.Map;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.xz.base.domain.BaseEntity;

public class LeaveInfo extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;
	

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * process_instance_id
	 */
	private java.lang.String process_instance_id;

	/**
	 * 请假人员(用户)id
	 */
	private java.lang.Integer user_id;
	
	/**
	 * 请假人员(用户)名称
	 */
	private java.lang.String user_name;

	/**
	 * 类型：1.病假，2.事假，3.年假，4.其它
	 */
	private java.lang.Integer type;

	/**
	 * 原因
	 */
	private java.lang.String reason;

	/**
	 * 开始时间
	 */
	private java.util.Date start_time;

	/**
	 * 结束时间
	 */
	private java.util.Date end_time;

	/**
	 * reality_start_time
	 */
	private java.util.Date reality_start_time;

	/**
	 * reality_end_time
	 */
	private java.util.Date reality_end_time;

	/**
	 * 是否提醒审核人
	 */
	private java.lang.Boolean is_notify;

	/**
	 * creator_id
	 */
	private java.lang.Integer creator_id;
	
	/**
	 * 请假人姓名
	 */
	private java.lang.Integer creator_name;

	/**
	 * create_time
	 */
	private java.util.Date create_time;
	
	  // 流程任务
    private Task task;

    private Map<String, Object> variables;

    // 运行中的流程实例
    private ProcessInstance processInstance;

    // 历史的流程实例
    private HistoricProcessInstance historicProcessInstance;

    // 流程定义
    private ProcessDefinition processDefinition;


	public LeaveInfo() {
	}
	
	public LeaveInfo(Integer id) {
		this.id = id;
	}
	
	public LeaveInfo(Integer id, String process_instance_id){
		this.id = id;
		this.process_instance_id = process_instance_id;
	}
	
	public LeaveInfo(String idText){
		this.id = Integer.valueOf(idText);
	}
	
	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}
	
	public void setProcess_instance_id(java.lang.String process_instance_id) {
		this.process_instance_id = process_instance_id;
	}

	public java.lang.String getProcess_instance_id() {
		return this.process_instance_id;
	}
	
	public void setUser_id(java.lang.Integer user_id) {
		this.user_id = user_id;
	}

	public java.lang.Integer getUser_id() {
		return this.user_id;
	} 
	
	public java.lang.String getUser_name() {
		return user_name;
	}

	public void setUser_name(java.lang.String user_name) {
		this.user_name = user_name;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getType() {
		return this.type;
	}
	
	public void setReason(java.lang.String reason) {
		this.reason = reason;
	}

	public java.lang.String getReason() {
		return this.reason;
	}
	
	public void setStart_time(java.util.Date start_time) {
		this.start_time = start_time;
	}

	public java.util.Date getStart_time() {
		return this.start_time;
	}
	
	public void setEnd_time(java.util.Date end_time) {
		this.end_time = end_time;
	}

	public java.util.Date getEnd_time() {
		return this.end_time;
	}
	
	public void setReality_start_time(java.util.Date reality_start_time) {
		this.reality_start_time = reality_start_time;
	}

	public java.util.Date getReality_start_time() {
		return this.reality_start_time;
	}
	
	public void setReality_end_time(java.util.Date reality_end_time) {
		this.reality_end_time = reality_end_time;
	}

	public java.util.Date getReality_end_time() {
		return this.reality_end_time;
	}
	
	public void setIs_notify(java.lang.Boolean is_notify) {
		this.is_notify = is_notify;
	}

	public java.lang.Boolean getIs_notify() {
		return this.is_notify;
	}
	
	public void setCreator_id(java.lang.Integer creator_id) {
		this.creator_id = creator_id;
	}

	public java.lang.Integer getCreator_id() {
		return this.creator_id;
	} 
	
	public java.lang.Integer getCreator_name() {
		return creator_name;
	}

	public void setCreator_name(java.lang.Integer creator_name) {
		this.creator_name = creator_name;
	}

	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public Map<String, Object> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, Object> variables) {
		this.variables = variables;
	}

	public ProcessInstance getProcessInstance() {
		return processInstance;
	}

	public void setProcessInstance(ProcessInstance processInstance) {
		this.processInstance = processInstance;
	}

	public HistoricProcessInstance getHistoricProcessInstance() {
		return historicProcessInstance;
	}

	public void setHistoricProcessInstance(HistoricProcessInstance historicProcessInstance) {
		this.historicProcessInstance = historicProcessInstance;
	}

	public ProcessDefinition getProcessDefinition() {
		return processDefinition;
	}

	public void setProcessDefinition(ProcessDefinition processDefinition) {
		this.processDefinition = processDefinition;
	} 

}