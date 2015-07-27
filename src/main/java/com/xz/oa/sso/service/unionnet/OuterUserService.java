/**   
 * @Title: UserService.java 
 * @Package: com.xz.oa.sso.service.impl.unionnet 
 * @Description: 
 * @author: davidwan
 * @date: 2014-8-20 下午2:34:01 
 * @version: V1.0   
 */
package com.xz.oa.sso.service.unionnet;

import com.xz.base.utils.LogHelper;
import com.xz.oa.sso.service.UserInfoService;
import com.xz.oa.sso.service.UserModuleService;
import com.xz.oa.sso.utils.SsoConfigValue;
import com.xz.oa.sso.utils.WebServiceUtil;

public class OuterUserService implements UserInfoService, UserModuleService {

	public static final String CALLTYPE_001 = "SYS01";
	public static final String CALLTYPE_002 = "SYS02";

	public static final String METHOD_VERIFYUSER = "VerifyUser";
	public static final String METHOD_EPRSENDLAB = "EprSendLab";

	private static final String wsdlUrl = SsoConfigValue.readValue("ssoUrl");
 

	/*
	 * 验证用户
	 */
	public Object verifyUser(String userCode, String password) { 
		try { 
			Object result = WebServiceUtil.invoke(wsdlUrl, METHOD_VERIFYUSER ,userCode, password);
			return result;
		} catch (Exception e) {
			LogHelper.getLogger().error("验证用户信息时出错", e);
			return null;
		}
	}

	/*
	 * 获取用户信息
	 */
	public Object gainUserInfo(String userCode) { 
		try { 
			return WebServiceUtil.invoke(wsdlUrl, METHOD_EPRSENDLAB ,CALLTYPE_001, userCode);
		} catch (Exception e) {
			LogHelper.getLogger().error("获取用户信息时出错", e);
			return null;
		}
	}

	/*
	 * 获取用户模块信息
	 */
	public Object gainUserModules(String userCode) { 
		try {
			return WebServiceUtil.invoke(wsdlUrl, METHOD_EPRSENDLAB ,CALLTYPE_002, userCode);
		} catch (Exception e) {
			LogHelper.getLogger().error("获取用户模块时出错", e);
			return null;
		}
	}

}
