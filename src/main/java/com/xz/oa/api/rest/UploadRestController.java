/**   
 * @Title: UserController.java 
 * @Package: com.xz.oa.api.rest 
 * @Description: 用户
 * @author: davidwan
 * @date: 2014-9-12 下午2:18:42 
 * @version: V1.0   
 */
package com.xz.oa.api.rest;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.xz.base.utils.LogHelper;
import com.xz.oa.core.service.file.FileUpload;

@RestController
@RequestMapping(value = "/api/file")
public class UploadRestController {

	/**
	 * @Description 登录
	 * @return String
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(HttpServletRequest request) {
		try {
			
			AuthenticationToken token = new UsernamePasswordToken("admin", "123456");
			Subject currentUser = SecurityUtils.getSubject();
			currentUser.login(token);
			
			FileUpload upload = new FileUpload(request);
			upload.process();

			return "success";
		} catch (Exception ex) {
			LogHelper.getLogger().error("上传失败", ex);
			return "failed";
		}
	}
}
