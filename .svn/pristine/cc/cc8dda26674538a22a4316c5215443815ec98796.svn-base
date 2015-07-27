/**   
 * @Title: UserDaoTest.java 
 * @Package: com.xz.oa.dao 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-14 下午3:51:07 
 * @version: V1.0   
 */
package com.xz.oa.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith; 
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xz.oa.core.dao.security.MenuDao;
import com.xz.oa.core.domain.entity.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class MenuDaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Resource
	MenuDao menuDao;

	@Ignore
	@Test
	public void testInsert() {
		Menu entity = new Menu("菜单管理", "javascript:(0)", null, false, 1, 1, "", true, null, new Date());
		Integer id = menuDao.insertEntity(entity);
		System.out.println(id);

	}

}
