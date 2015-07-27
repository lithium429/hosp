/**   
* @Title: SmsService.java 
* @Package: com.xz.oa.sms.service 
* @Description: 短信接口
* @author: davidwan
* @date: 2014-8-20 下午5:19:08 
* @version: V1.0   
*/
package com.xz.oa.sms.service;

import java.util.List;
import java.util.Map;

import com.xz.oa.sms.model.SendResult;

public interface SmsInterface {
	/**
	 * @Description 单个号码发送 
	 * @param phone
	 * @param msg
	 * @return SendResult     
	 */
	public SendResult send(String phone, String msg);
	
	/**
	 * @Description 多个号码，相同内容发送 
	 * @param phone
	 * @param msg
	 * @return SendResult     
	 */
	public SendResult batchSend(List<String> phone, String msg);
	
	/**
	 * @Description 多个号码，不同内容发送 
	 * @param phoneMsgMap
	 * @return SendResult     
	 */
	public SendResult batchSend(Map<String, String> phoneMsgMap);
}
