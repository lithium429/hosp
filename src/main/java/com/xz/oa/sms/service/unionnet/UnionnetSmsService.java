/**   
 * @Title: UnionnetSmsService.java 
 * @Package: com.xz.oa.sms.service.impl.unionnet 
 * @Description: 
 * @author: davidwan
 * @date: 2014-8-20 下午6:19:06 
 * @version: V1.0   
 */
package com.xz.oa.sms.service.unionnet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.oa.sms.dao.UnionnetSmsDao;
import com.xz.oa.sms.domain.entity.UnionnetSms;
import com.xz.oa.sms.model.SendResult;
import com.xz.oa.sms.service.SmsInterface;

@Service
public class UnionnetSmsService implements SmsInterface {

	@Resource
	private UnionnetSmsDao unionnetSmsDao;

	/*  
	 * 发送单条短信
	 */
	public SendResult send(String phone, String msg) {
		int result = this.unionnetSmsDao.insertEntity(new UnionnetSms(phone, msg));
		if (result > 0) {
			return new SendResult(true);
		} else {
			return new SendResult(false);
		}
	}

	/* 
	 * 发送多条内容相同的短信
	 */
	public SendResult batchSend(List<String> phones, String msg) {
		List<UnionnetSms> list = new ArrayList<UnionnetSms>();
		for (String phone : phones) {
			list.add(new UnionnetSms(phone, msg));
		}
		int result = this.unionnetSmsDao.insertEntityList(list);
		if (result > 0) {
			return new SendResult(true);
		} else {
			return new SendResult(false);
		}
	}

	/* 
	 * 发送多条内容不相同的短信
	 */
	public SendResult batchSend(Map<String, String> phoneMsgMap) {
		List<UnionnetSms> list = new ArrayList<UnionnetSms>();
		for (String key : phoneMsgMap.keySet()) {
			list.add(new UnionnetSms(key, phoneMsgMap.get(key)));
		}
		int result = this.unionnetSmsDao.insertEntityList(list);
		if (result > 0) {
			return new SendResult(true);
		} else {
			return new SendResult(false);
		}
	}

}
