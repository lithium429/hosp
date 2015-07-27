package com.xz.oa.core.service.meal;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.meal.MealMenuDao;
import com.xz.oa.core.dao.meal.MealUserDao;
import com.xz.oa.core.domain.entity.MealMenu;   
import com.xz.oa.core.domain.entity.MealMenuAddUp;
import com.xz.oa.core.domain.entity.MealMenuHelp;
import com.xz.oa.core.domain.entity.MealUser;
import com.xz.oa.core.domain.entity.MealUserHelp;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class MealMenuService{

	@Resource
	private MealMenuDao mealMenuDao;

	@Resource
	private MealUserDao mealUserDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return MealMenu    
	 * @author davidwan 
	 */
	public MealMenu findById(Integer id) {
		MealMenu entity = new MealMenu();
		entity.setId(id);
		return mealMenuDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return MealMenu    
	 * @author davidwan 
	 */
	public MealMenu find(MealMenu entity) {
		return mealMenuDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<MealMenu>    
	 * @author davidwan 
	 */
	public List<MealMenu> queryList(MealMenu entity){
		return mealMenuDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取数量
	 * @param entity
	 * @return List<MealMenu>    
	 * @author davidwan 
	 */
	public int queryCount(MealMenu entity){
		return mealMenuDao.selectEntityCount(entity);
	}
	

	
	/**
	 * @Description 根据条件获取订餐列表 
	 * @param entity
	 * @return List<MealMenu>    
	 * @author davidwan 
	 */
	public List<MealMenu> queryList_reserve(MealMenu entity){
		return mealMenuDao.selectEntityList(entity,"_eat");
	}
	
	/**
	 * @Description 根据条件获取订餐列表 
	 * @param entity
	 * @return List<MealMenu>    
	 * @author davidwan 
	 */
	public List<MealMenuAddUp> queryList_addUp(MealMenuAddUp entity){
		return mealMenuDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<MealMenu>    
	 * @author davidwan 
	 */
	public PageInfo<MealMenu> queryPageList(MealMenu entity, int pageIndex, int pageSize){
		return mealMenuDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加菜单
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(MealMenuHelp entity) {
		int result=0;
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		if(entity.getIs_add())
		{
			for (MealMenu item : entity.getMeals()) {
				item.setCreate_time(new Date());
				item.setCreator_id(shiroUser.getId());
				result=mealMenuDao.insertEntity(item);
			}
		}else
		{
			for (MealMenu item : entity.getMeals()) {
				result=mealMenuDao.updateEntity(item);
			}
		}
		if (result > 0) {
			DateTime sDate = DateTime.now().minusDays(DateTime.now().getDayOfWeek() - 1), 
					eDate = DateTime.now().plusDays(7 - DateTime.now().getDayOfWeek()), 
					sDate_next = sDate.plusWeeks(1), eDate_next = eDate.plusWeeks(1);
			String action=entity.getIs_add()?"添加":"修改";
			//添加操作日志
			systemLogService.create(EnumLogModule.菜单管理.getValue(), action+"菜单",action+"菜单：" + sDate_next.toString("yyyy-MM-dd")+"-"+eDate_next.toString("yyyy-MM-dd"));
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}
	


	/**
	 * @Description 添加订餐
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(MealUserHelp entity) {
		int result=0;
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		if(entity.getIs_add())
		{
			for (MealUser item : entity.getMealUsers()) {
				item.setUser_id(shiroUser.getId());
				result=mealUserDao.insertEntity(item);
			}
		}else
		{
			for (MealUser item : entity.getMealUsers()) {
				result=mealUserDao.updateEntity(item);
			}
		}
		if (result > 0) {
			DateTime sDate = DateTime.now().minusDays(DateTime.now().getDayOfWeek() - 1), 
					eDate = DateTime.now().plusDays(7 - DateTime.now().getDayOfWeek()), 
					sDate_next = sDate.plusWeeks(1), eDate_next = eDate.plusWeeks(1);
			String action=entity.getIs_add()?"添加":"修改";
			//添加操作日志
			systemLogService.create(EnumLogModule.订餐.getValue(), action+"订餐",action+"订餐：" + sDate_next.toString("yyyy-MM-dd")+"-"+eDate_next.toString("yyyy-MM-dd"));
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 修改 
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult modify(MealMenu entity) {
		int result = mealMenuDao.updateEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 根据Id删除 
	 * @param id
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult removeById(Integer id) {
		MealMenu entity = new MealMenu();
		entity.setId(id);
		int result = mealMenuDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}
	
	/**
	 * @Description 根据多个Id删除 
	 * @param ids
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult removeByIds(String ids) {
		MealMenu entity = new MealMenu();
		entity.getMap().put("ids", ids.split(","));
		int result = mealMenuDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 根据指定条件删除 
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult remove(MealMenu entity) { 
		int result = mealMenuDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
