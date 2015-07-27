/**   
 * @Title: UserDaoTest.java 
 * @Package: com.xz.oa.dao 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-14 下午3:51:07 
 * @version: V1.0   
 */
package com.xz.oa.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith; 
import org.springframework.test.context.ContextConfiguration; 
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests; 
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.user.UserDao;
import com.xz.oa.core.domain.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class UserDaoTest  extends AbstractJUnit4SpringContextTests {
	@Resource
	UserDao userDao;

	@Ignore
	@Test
	public void testInsert() {
		User entity = new User("jack", "123456", "davidwan");
		Integer id = userDao.insertEntity(entity);
		System.out.println(id);
	}

	@Ignore
	@Test
	public void testSelect() {
		User entity = new User();
		entity.setId(1);
		entity.getMap().put("ids", new Integer[] { 1 });
		entity = userDao.selectEntity(entity);
		assertNotNull(entity);
	}

	@Ignore
	@Test
	public void testUpdate() {
		User entity = new User();
		entity.setId(1);
		entity.setName("terry");
		int rows = userDao.updateEntity(entity);
		assertNotEquals(0, rows);
	}

	@Ignore
	@Test
	public void testSelectList() {
		User entity = new User();
		entity.setId(2);
		entity.getMap().put("sort", true);
		List<User> list = userDao.selectEntityList(entity);
		assertNotNull(list);
		assertEquals(0, list.size());
	}

	@Ignore
	@Test
	public void testSelectPageList() {
		User entity = new User();
		entity.getMap().put("sort", true);
		PageInfo<User> pageInfo = userDao.selectEntityPageList(entity, 1, 3);
		assertNotNull(pageInfo);
		assertNotNull(pageInfo.getData());
		assertNotEquals(0, pageInfo.getData().size());
	}

	@Ignore
	@Test
	public void testDelete() {
		User entity = new User();
		entity.getMap().put("ids", new Integer[] { 1, 2 });
		int rows = userDao.deleteEntity(entity);
		assertNotEquals(0, rows);
	}
}
