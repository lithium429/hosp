package com.xz.oa.core.service.activiti.cmd;

import com.xz.base.utils.bpm.CustomProcessDiagramGenerator;
import org.activiti.engine.impl.interceptor.Command;
import org.activiti.engine.impl.interceptor.CommandContext;

import java.io.InputStream;

public class HistoryProcessInstanceDiagramCmd implements Command<InputStream> {
	
	protected String historyProcessInstanceId;
	
	public HistoryProcessInstanceDiagramCmd(String historyProcessInstanceId) {
        this.historyProcessInstanceId = historyProcessInstanceId;
    }
	@Override
	 public InputStream execute(CommandContext commandContext) {
	        try {
	            CustomProcessDiagramGenerator customProcessDiagramGenerator = new CustomProcessDiagramGenerator();

	            return customProcessDiagramGenerator
	                    .generateDiagram(historyProcessInstanceId);
	        } catch (Exception ex) {
	            throw new RuntimeException(ex);
	        }
	    }
	
}
