/**   
* @Title: UploadSetController.java 
* @Package: com.xz.oa.core.web.controller 
* @Description: 
* @author: davidwan
* @date: 2014-8-7 上午10:27:26 
* @version: V1.0   
*/
package com.xz.oa.core.web.controller;

import org.springframework.ui.Model;

import com.xz.base.controller.SpringBaseController;
import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.StringUtil;
import com.xz.oa.core.service.file.FileUpload;

public class UploadSetController extends SpringBaseController{
	
	/**
	 * @Description 初始化配置信息
	 * @param model void     
	 */
	protected void initConfigValues(Model model){
		// 文件大小限制
		Integer sizeLimit = ConfigValue.readIntValue(FileUpload.UPLAOD_MAX_SIZE, 20);
		model.addAttribute("sizeLimit", sizeLimit);
		
		// 批量上传文件数量限制
		Integer uploadLimit = ConfigValue.readIntValue(FileUpload.BATCH_UPLOAD_LIMIT, 10);
		model.addAttribute("uploadLimit", uploadLimit);
		
		// 文件扩展名
		String extText = ConfigValue.readValue(FileUpload.UPLOAD_FILE_EXT);
		model.addAttribute("fileTypes", StringUtil.buildBrowserFileTypes(extText));
	}
 
	@Override
	public String getFModulePath() { 
		return null;
	}
 
	@Override
	public String getModulePath() { 
		return null;
	}
 
	@Override
	public String getModuleName() { 
		return null;
	}

}
