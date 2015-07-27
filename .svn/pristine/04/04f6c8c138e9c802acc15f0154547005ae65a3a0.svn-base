package com.xz.oa.core.domain.entity;

import java.io.Serializable;
import java.util.Map;

import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import com.xz.base.domain.BaseEntity;

public class Leave extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -1L;

	/**
	 * id
	 */
	private java.lang.Integer id;

	/**
	 * 管理的请假人员id
	 */
	private java.lang.Integer staff_id;

	/**
	 * 类型：1.病假，2.事假，3.年假，4.其它
	 */
	private java.lang.Integer type;

	/**
	 * 审核人id
	 */
	private java.lang.Integer verify_user_id;

	/**
	 * 审核状态：1.待审核，2.通过，3.不通过
	 */
	private java.lang.Integer verify_state;

	/**
	 * verify_content
	 */
	private java.lang.String verify_content;

	/**
	 * verify_time
	 */
	private java.util.Date verify_time;

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
	 * 是否提醒审核人
	 */
	private java.lang.Boolean is_notify;

	/**
	 * creator_id
	 */
	private java.lang.Integer creator_id;

	/**
	 * create_time
	 */
	private java.util.Date create_time;

	/**
	 * 员工姓名
	 */
	private java.lang.String staff_name;

	/**
	 * 员工号
	 */
	private java.lang.String staff_code;

	/**
	 * 审核人姓名
	 */
	private java.lang.String verify_user_name;

	/**
	 * 创建人姓名
	 */
	private java.lang.String creator_name;
	
	/**
	 * 流程实例Id
	 */
	private java.lang.String process_instance_id;
	
    // 流程任务
    private Task task;

    private Map<String, Object> variables;

    // 运行中的流程实例
    private ProcessInstance processInstance;

    // 历史的流程实例
    private HistoricProcessInstance historicProcessInstance;

    // 流程定义
    private ProcessDefinition processDefinition;

	public Leave() {
	}
	
	public Leave(String idText){
		this.id = Integer.getInteger(idText);
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setStaff_id(java.lang.Integer staff_id) {
		this.staff_id = staff_id;
	}

	public java.lang.Integer getStaff_id() {
		return this.staff_id;
	}

	public void setType(java.lang.Integer type) {
		this.type = type;
	}

	public java.lang.Integer getType() {
		return this.type;
	}

	public void setVerify_user_id(java.lang.Integer verify_user_id) {
		this.verify_user_id = verify_user_id;
	}

	public java.lang.Integer getVerify_user_id() {
		return this.verify_user_id;
	}

	public void setVerify_state(java.lang.Integer verify_state) {
		this.verify_state = verify_state;
	}

	public java.lang.Integer getVerify_state() {
		return this.verify_state;
	}

	public void setVerify_content(java.lang.String verify_content) {
		this.verify_content = verify_content;
	}

	public java.lang.String getVerify_content() {
		return this.verify_content;
	}

	public void setVerify_time(java.util.Date verify_time) {
		this.verify_time = verify_time;
	}

	public java.util.Date getVerify_time() {
		return this.verify_time;
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

	public void setCreate_time(java.util.Date create_time) {
		this.create_time = create_time;
	}

	public java.util.Date getCreate_time() {
		return this.create_time;
	}

	public java.lang.String getStaff_name() {
		return staff_name;
	}

	public void setStaff_name(java.lang.String staff_name) {
		this.staff_name = staff_name;
	}

	public java.lang.String getStaff_code() {
		return staff_code;
	}

	public void setStaff_code(java.lang.String staff_code) {
		this.staff_code = staff_code;
	}

	public java.lang.String getCreator_name() {
		return creator_name;
	}

	public void setCreator_name(java.lang.String creator_name) {
		this.creator_name = creator_name;
	}

	public java.lang.String getVerify_user_name() {
		return verify_user_name;
	}

	public void setVerify_user_name(java.lang.String verify_user_name) {
		this.verify_user_name = verify_user_name;
	}

	public java.lang.String getProcess_instance_id() {
		return process_instance_id;
	}

	public void setProcess_instance_id(java.lang.String process_instance_id) {
		this.process_instance_id = process_instance_id;
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