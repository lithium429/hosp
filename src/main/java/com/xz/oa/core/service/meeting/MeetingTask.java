/**   
 * @Title: ChatTask.java 
 * @Package: com.rz.webbrtx.csc.dwr.service 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-18 下午10:15:38 
 * @version: V1.0   
 */
package com.xz.oa.core.service.meeting;

import java.util.TimerTask;

import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.xz.base.utils.LogHelper;

public class MeetingTask extends TimerTask {
	public static final String IS_ENABLE_MEETING_TASK = "isEnableMeetingTask";
	
	private ServletContext context;

	public MeetingTask() {

	}

	public MeetingTask(ServletContext context) {
		this.context = context;
	}

	/*  
	 *  
	 */
	@Override
	public void run() { 
		try {
			ApplicationContext appContext = WebApplicationContextUtils.getRequiredWebApplicationContext(this.context);
			MeetingService meetingService = (MeetingService) appContext.getBean("meetingService");
			meetingService.modifyForSendNotifySMS();
		} catch (Exception ex) {
			LogHelper.getLogger().error("执行发送会议通知短信出错", ex);
		}
	}
}
