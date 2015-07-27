/**   
 * @Title: UserDaoTest.java 
 * @Package: com.xz.oa.dao 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-14 下午3:51:07 
 * @version: V1.0   
 */
package com.xz.oa.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith; 
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xz.base.model.JsonResult;
import com.xz.oa.core.domain.entity.User; 
import com.xz.oa.core.service.user.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Resource
	UserService userService;

	@Ignore
	@Test
	public void testCreate() {
		User entity = new User("david", "123456", "davidwan");
		entity.setDept_id(1);
		entity.setState(1);
		entity.setEmail("davidwan@163.com");
		JsonResult result = userService.create(entity);

		assertEquals(true, result.isFlag());
	}

}
