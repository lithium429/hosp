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

import java.util.List;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xz.oa.core.domain.entity.MealMenu;
import com.xz.oa.core.service.meal.MealMenuService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/applicationContext.xml")
public class MealMenuServiceTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Resource
	private MealMenuService mealMenuService;

	@Ignore
	@Test
	public void testCreate() {
		DateTime sDate = DateTime.now().minusDays(DateTime.now().getDayOfWeek() - 1), 
				eDate = DateTime.now().plusDays(7 - DateTime.now().getDayOfWeek()), 
				sDate_next = sDate.plusWeeks(1), 
				eDate_next = eDate.plusWeeks(1), 
				sDate_last = sDate.minusWeeks(1), 
				eDate_last = eDate.minusWeeks(1), 
				sDate_v = sDate.minusWeeks(2), 
				eDate_v = eDate.minusWeeks(2);
		MealMenu m = new MealMenu();
		m.getMap().put("sort_order", true);
		m.getMap().put("meal_date_min", sDate_next.toString("yyyy-MM-dd"));
		m.getMap().put("meal_date_max", eDate_next.toString("yyyy-MM-dd"));
		List<MealMenu> mealList = mealMenuService.queryList(m);
		System.out.println(sDate_last);
		System.out.println(eDate_last);
		System.out.println(sDate_v);
		System.out.println(eDate_v);
		assertNotNull(mealList);
	}

}
