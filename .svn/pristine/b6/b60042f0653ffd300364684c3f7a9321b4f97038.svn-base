/**   
 * @Title: UserDaoTest.java 
 * @Package: com.xz.oa.dao 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-14 下午3:51:07 
 * @version: V1.0   
 */
package com.xz.sms.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;
 
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xz.oa.sms.model.SendResult;
import com.xz.oa.sms.service.unionnet.UnionnetSmsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class SmsServiceTest extends AbstractJUnit4SpringContextTests {
	@Resource
	UnionnetSmsService unionnetSmsService;

	@Ignore
	@Test
	public void testCreate() {
		SendResult result = unionnetSmsService.send("13666666666", "hello");
		assertEquals(true, result.isFlag());
	}

	//@Ignore
	@Test
	public void testWebService() { 
	}
}
