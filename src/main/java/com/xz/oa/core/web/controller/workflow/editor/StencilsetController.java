package com.xz.oa.core.web.controller.workflow.editor;

import org.activiti.engine.ActivitiException;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.InputStream;

@Controller
@RequestMapping(value="/workflow/editor")
public class StencilsetController {
	
	
	@RequestMapping(value="/stencilset")
	@ResponseBody
	 public String getStencilset() {
		System.out.println("stencilset");
		  InputStream stencilsetStream = this.getClass().getClassLoader().getResourceAsStream("stencilset.json");
	        try {
	            return IOUtils.toString(stencilsetStream);
	        } catch (Exception e) {
	            throw new ActivitiException("Error while loading stencil set", e);
	        }
	    }
}
