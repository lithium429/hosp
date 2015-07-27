/**   
 * @Title: MyApplicationListener.java 
 * @Package: com.xz.oa.core.service.user.listener 
 * @Description: 
 * @author: davidwan
 * @date: 2014-8-27 下午5:00:23 
 * @version: V1.0   
 */
package com.xz.oa.core.service.user.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
 
import com.xz.base.utils.ConfigValue;
import com.xz.oa.core.service.meeting.MeetingTask;
import com.xz.oa.core.service.user.OnlineUser;

public class MyApplicationListener implements ServletContextListener {

	private Timer timer = new Timer();

	/*
	 * 应用程序启动
	 */
	public void contextInitialized(ServletContextEvent sce) {
		OnlineUser.getInstance().init(sce.getServletContext());

		boolean isEnable = ConfigValue.readBooleanValue(MeetingTask.IS_ENABLE_MEETING_TASK, false);
		if(isEnable){
			timer.schedule(new MeetingTask(sce.getServletContext()), 1000, 10000);
		}
	}

	/*
	 * 应用程序终止
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
	}

}
