package com.xz.oa.core.service.meal;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.meal.MealUserDao;
import com.xz.oa.core.domain.entity.MealUser;   

@Service
public class MealUserService{

	@Resource
	private MealUserDao mealUserDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return MealUser    
	 * @author davidwan 
	 */
	public MealUser findById(Integer id) {
		MealUser entity = new MealUser();
		entity.setId(id);
		return mealUserDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return MealUser    
	 * @author davidwan 
	 */
	public MealUser find(MealUser entity) {
		return mealUserDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<MealUser>    
	 * @author davidwan 
	 */
	public List<MealUser> queryList(MealUser entity){
		return mealUserDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<MealUser>    
	 * @author davidwan 
	 */
	public PageInfo<MealUser> queryPageList(MealUser entity, int pageIndex, int pageSize){
		return mealUserDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(MealUser entity) {
		// 若要获取id，请使用entity.getId();
		int result = mealUserDao.insertEntity(entity);
		if (result > 0) {
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
	public JsonResult modify(MealUser entity) {
		int result = mealUserDao.updateEntity(entity);
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
		MealUser entity = new MealUser();
		entity.setId(id);
		int result = mealUserDao.deleteEntity(entity);
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
		MealUser entity = new MealUser();
		entity.getMap().put("ids", ids.split(","));
		int result = mealUserDao.deleteEntity(entity);
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
	public JsonResult remove(MealUser entity) { 
		int result = mealUserDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
