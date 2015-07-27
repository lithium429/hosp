package com.xz.oa.core.web.controller.workflow.web;

import com.xz.oa.core.service.activiti.cmd.ProcessDefinitionDiagramCmd;
import org.activiti.engine.ManagementService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;
import org.nutz.json.Json;
import org.nutz.lang.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(value="/workflow/process")
public class DeployController {
	
	Logger logger=LoggerFactory.getLogger(DeployController.class);
	
	@Resource
	private RepositoryService repositoryService;
	
	@Resource
	private ManagementService managementService;
	
	@RequestMapping(value="")
	public ModelAndView index(){
		ModelAndView mv=new ModelAndView("");
		return mv;
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public ModelAndView list(@RequestParam(value = "categoryId",required = false) String categoryId,@RequestParam(value = "keyword",required = false) String keyword,
			HttpServletResponse response){
		//@RequestParam("page") int curPage,@RequestParam("rows") int pageSize,
		ModelAndView view = new ModelAndView("core/workflow/process_list");
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        ProcessDefinitionQuery processDefinitionQuery2;
        if (!Strings.isEmpty(categoryId) && !Strings.isEmpty(keyword)) {
            processDefinitionQuery2 = processDefinitionQuery.processDefinitionCategory(categoryId);
        } else if (!Strings.isEmpty(categoryId)) {
            processDefinitionQuery2 = processDefinitionQuery.processDefinitionCategory(categoryId);
        } else if (!Strings.isEmpty(keyword)) {
            processDefinitionQuery2 = processDefinitionQuery.processDefinitionNameLike(keyword);
        } else {
            processDefinitionQuery2 = processDefinitionQuery;
        }
        long total = processDefinitionQuery2.count();
		List<Object[]> list = new ArrayList<Object[]>();
		List<ProcessDefinition> processDefinitionList =
				processDefinitionQuery2.orderByProcessDefinitionId().desc().list();//listPage((curPage - 1) * pageSize, pageSize)
		for (ProcessDefinition processDefinition : processDefinitionList) {
			String deploymentId = processDefinition.getDeploymentId();
			Deployment deployment = repositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();
			list.add(new Object[] { processDefinition, deployment });
		}

		view.addObject("list", list);
//		Map<String, Object> obj = new HashMap<String, Object>();
//		obj.put("total", total);
//        obj.put("list", list);
//		String json= Json.toJson(obj);
		return view;

	}
	
	@RequestMapping(value="/suspend/{processDefinitionId}")
	public String suspend(@PathVariable("processDefinitionId") String processDefinitionId){
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            repositoryService.suspendProcessDefinitionById(processDefinitionId,
                    true, null);
            map.put("errcode", 0);
            map.put("errmsg", "挂起部署成功，processDefinitionId=" + processDefinitionId);

        } catch (Exception e) {
            map.put("errcode", 1);
            map.put("errmsg", "挂起部署失败：processDefinitionId=" + processDefinitionId + "\r\n" + e.getMessage());
        }
        return "redirect:/workflow/process/list";
	}
	
	@RequestMapping(value="/active/{processDefinitionId}")
	public String active(@PathVariable("processDefinitionId") String processDefinitionId){
		Map<String, Object> map = new HashMap<String, Object>();
        try {
            repositoryService.activateProcessDefinitionById(processDefinitionId,
                    true, null);
            map.put("errcode", 0);
            map.put("errmsg", "激活部署成功，processDefinitionId=" + processDefinitionId);

        } catch (Exception e) {
            map.put("errcode", 1);
            map.put("errmsg", "激活部署失败：processDefinitionId=" + processDefinitionId + "\r\n" + e.getMessage());
        }
        return "redirect:/workflow/process/list";
		
	}
	
	@RequestMapping(value="/delete/{deployId}")
	public String delete(@PathVariable("deployId") String deployId){
		Map<String, Object> map = new HashMap<String, Object>();
        try {
            repositoryService.deleteDeployment(deployId, true);//是否级联删除实例资源
            map.put("errcode", 0);
            map.put("errmsg", "删除部署成功，deployId=" + deployId);

        } catch (Exception e) {
            map.put("errcode", 1);
            map.put("errmsg", "根据模型部署流程失败：deployId=" + deployId + "\r\n" + e.getMessage());
        }
        return "redirect:/workflow/process/list";
	}
	
	@RequestMapping(value="/graph/{processDefinitionId}")
	public void graph(@PathVariable("processDefinitionId") String processDefinitionId,
            HttpServletResponse response) throws Exception {
		//response.setCharacterEncoding("UTF-8");
		Command<InputStream> cmd = new ProcessDefinitionDiagramCmd(
		      processDefinitionId);
		InputStream is = managementService.executeCommand(
		      cmd);
		response.setContentType("image/png");
		IOUtils.copy(is, response.getOutputStream());
	}
	
	@RequestMapping(value="/xml/{processDefinitionId}")
	public void xml(@PathVariable("processDefinitionId") String processDefinitionId,
            HttpServletResponse response) throws Exception {
		ProcessDefinition processDefinition = repositoryService
		        .createProcessDefinitionQuery()
		        .processDefinitionId(processDefinitionId).singleResult();
		String resourceName = processDefinition.getResourceName();
		InputStream resourceAsStream = repositoryService.getResourceAsStream(
		        processDefinition.getDeploymentId(), resourceName);
		response.setContentType("text/xml;charset=UTF-8");
		IOUtils.copy(resourceAsStream, response.getOutputStream());
	}
}
