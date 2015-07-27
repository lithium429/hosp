/**   
 * @Title: UserController.java 
 * @Package: com.xz.oa.api.rest 
 * @Description: 用户
 * @author: davidwan
 * @date: 2014-9-12 下午2:18:42 
 * @version: V1.0   
 */
package com.xz.oa.api.rest;
 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xz.base.model.JsonResult;

@RestController
@RequestMapping(value = "/api/user")
public class UserRestController {

	/**
	 * @Description 登录 
	 * @param userName
	 * @param password
	 * @return JsonResult     
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody JsonResult login(String userName, String password) {
		return new JsonResult(true);
	}

}
