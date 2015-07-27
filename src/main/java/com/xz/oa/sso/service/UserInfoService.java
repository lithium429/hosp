/**   
* @Title: UserLoginService.java 
* @Package: com.xz.oa.sso.service 
* @Description: 
* @author: davidwan
* @date: 2014-8-20 下午2:23:17 
* @version: V1.0   
*/
package com.xz.oa.sso.service;

public interface UserInfoService {
	
	/**
	 * @Description 根据工号（用户名）和密码验证用户 
	 * @param userCode
	 * @param password
	 * @return Object     
	 */
	public Object verifyUser(String userCode, String password);
	
	/**
	 * @Description 根据工号（用户名）获取用户信息
	 * @param userCode
	 * @return Object     
	 */
	public Object gainUserInfo(String userCode);
}
