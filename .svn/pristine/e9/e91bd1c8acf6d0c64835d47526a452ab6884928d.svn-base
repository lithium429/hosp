package com.xz.oa.core.web.controller.leave;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest; 

import org.activiti.engine.ActivitiException;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.Variable;
import com.xz.base.utils.WebUtil;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.LeaveInfo;
import com.xz.oa.core.service.leave.LeaveInfoWorkflowService;

@Controller
@RequestMapping(value = "/leaveInfo")
public class LeaveInfoController extends SpringBaseController {

	@Resource
	protected LeaveInfoWorkflowService workflowService;

	@Resource
	protected RuntimeService runtimeService;

	@Resource
	protected TaskService taskService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		getList(request, model);
		return getPathList();
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/datalist")
	public String datalist(HttpServletRequest request, Model model) {
		getList(request, model);
		return getPath("data_list");
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @author davidwan
	 */
	private void getList(HttpServletRequest request, Model model) {
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		Integer userId = getCurrentUserId();
		PageInfo<LeaveInfo> pageInfo = workflowService.findTodoTasks(userId, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
	}

	/**
	 * @Title: add
	 * @Description: 进入添加页面
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
		return getPathAdd();
	}

	/**
	 * @Title: add
	 * @Description: Ajax保存添加数据
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult add(LeaveInfo entity) {
		try {
			Integer userId = getCurrentUserId();
			entity.setUser_id(userId);
			entity.setCreator_id(userId);
			Map<String, Object> variables = new HashMap<String, Object>();
			ProcessInstance processInstance = workflowService.createAndStartWorkflow(entity, variables);
			System.out.println("流程已启动，流程ID：" + processInstance.getId());
		} catch (ActivitiException e) {
			if (e.getMessage().indexOf("no processes deployed with key") != -1) {
				logger.warn("没有部署流程!", e);
				return new JsonResult(false, "没有部署流程，请在[工作流]->[流程管理]页面点击<重新部署流程>");
			} else {
				logger.error("启动请假流程失败：", e);
				return new JsonResult(false, "系统内部错误！");
			}
		}

		return new JsonResult(true);
	}

	/**
	 * 完成任务
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "complete", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public JsonResult complete(String taskId, Variable var) {
		try {
			Map<String, Object> variables = var.getVariableMap();
			taskService.complete(taskId, variables);
			return new JsonResult(true);
		} catch (Exception e) {
			logger.error("error on complete task {}, variables={}", new Object[] { taskId, var.getVariableMap(), e });
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 签收任务 
	 * @param taskId
	 * @return JsonResult     
	 */
	@RequestMapping(value = "claim/{id}")
	@ResponseBody
	public JsonResult claim(@PathVariable("id") String taskId) {
		Integer userId = getCurrentUserId();
		taskService.claim(taskId, userId.toString());
		return new JsonResult(true);
	}

	/**
	 * @Description 办理 
	 * @param taskId
	 * @param leave_id
	 * @param tkey
	 * @param model
	 * @return String     
	 */
	@RequestMapping(value = "handle/{id}")
	public String handle(@PathVariable("id") String taskId, Integer leave_id, String tkey, Model model) {
		LeaveInfo entity = workflowService.findById(leave_id);
		model.addAttribute("model", entity);
		model.addAttribute("taskId", taskId);
		model.addAttribute("tkey", tkey);
		return getPath("handle");
	}
	
	/**
	 * @Title: add
	 * @Description: 进入不同意页面
	 * @return String
	 */
	@RequestMapping("/reason")
	public String reason() {
		return getPath("reason");
	}
	
	/**
	 * @Title: modify
	 * @Description: 进入调整申请页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/modify/{id}")
	public String modify(@PathVariable("id") String taskId, Integer leave_id, String tkey, Model model) {
		LeaveInfo entity = workflowService.findById(leave_id);
		Map<String, Object> variables = taskService.getVariables(taskId);
		entity.setVariables(variables);
		model.addAttribute("model", entity);
		model.addAttribute("task_id", taskId);
		
		return getPath("modify");
	}

	/**
	 * @Title: update
	 * @Description: 进入修改页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/update")
	public String update(Integer id, Model model) {
		LeaveInfo entity = null; // leaveInfoService.findById(id);
		model.addAttribute("model", entity);
		return getPathUpdate();
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult update(LeaveInfo entity) {
		return null; // leaveInfoService.modify(entity);
	}

	/**
	 * @Title: delete
	 * @Description: Ajax删除
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(Integer id) {
		return null; // leaveInfoService.removeById(id);
	}

	/**
	 * @Title: batchDelete
	 * @Description: Ajax批量删除
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batchdelete", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult batchDelete(String ids) {
		return null; // leaveInfoService.removeByIds(ids);
	}

	/**
	 * @Description 进入详情页面
	 * @param id
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/view")
	public String view(Integer id, String task_id, Model model) {
		LeaveInfo entity = workflowService.findById(id);
		Map<String, Object> variables = taskService.getVariables(task_id);
		entity.setVariables(variables);
		model.addAttribute("model", entity);
		return getPathView();
	} 

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "leaveInfo";
	}

	@Override
	public String getModuleName() {
		return "请假";
	}
}
