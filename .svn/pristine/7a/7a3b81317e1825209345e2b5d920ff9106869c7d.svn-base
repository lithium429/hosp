/**   
 * @Title: MySessionListener.java 
 * @Package: com.xz.oa.core.service.user.listener 
 * @Description: 
 * @author: davidwan
 * @date: 2014-8-27 下午5:02:08 
 * @version: V1.0   
 */
package com.xz.oa.core.service.user.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.xz.base.utils.LogHelper;
import com.xz.oa.core.service.user.OnlineUser;

public class MySessionListener implements HttpSessionListener {

	/*
	 * 会话创建
	 */
	public void sessionCreated(HttpSessionEvent se) {

	}

	/*
	 * 会话结束
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		// 会话过期，从在线用户列表中移除该会话对应的用户
		try {
			HttpSession session = se.getSession();
			Integer userId = (Integer) session.getAttribute(session.getId());
			OnlineUser.getInstance().remove(userId, se.getSession());
		} catch (Exception ex) {
			LogHelper.getLogger().error("移除在线用户出错", ex);
		}
	}

}
