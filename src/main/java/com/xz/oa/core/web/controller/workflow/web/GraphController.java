package com.xz.oa.core.web.controller.workflow.web;

import com.xz.oa.core.service.activiti.cmd.HistoryProcessInstanceDiagramCmd;
import org.activiti.engine.ManagementService;
import org.activiti.engine.impl.interceptor.Command;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@Controller
@RequestMapping(value = "/workflow/flow")
public class GraphController {


	@Resource
	ManagementService managementService;

	@RequestMapping(value = "/graph/{processInstanceId}")
	public void graphHistory(@PathVariable("processInstanceId") String processInstanceId,
			HttpServletResponse response) throws Exception {
		Command<InputStream> cmd = new HistoryProcessInstanceDiagramCmd(
				processInstanceId);

		InputStream is = managementService.executeCommand(
				cmd);
		response.setContentType("image/png");

		int len = 0;
		byte[] b = new byte[1024];

		while ((len = is.read(b, 0, 1024)) != -1) {
			response.getOutputStream().write(b, 0, len);
		}
	}
}
