package com.xz.oa.core.service.security;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.user.UserRoleDao;
import com.xz.oa.core.domain.entity.UserRole;   

@Service
public class UserRoleService{

	@Resource
	private UserRoleDao userRoleDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return UserRole    
	 * @author davidwan 
	 */
	public UserRole findById(Integer id) {
		UserRole entity = new UserRole();
		entity.setId(id);
		return userRoleDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return UserRole    
	 * @author davidwan 
	 */
	public UserRole find(UserRole entity) {
		return userRoleDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<UserRole>    
	 * @author davidwan 
	 */
	public List<UserRole> queryList(UserRole entity){
		return userRoleDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<UserRole>    
	 * @author davidwan 
	 */
	public PageInfo<UserRole> queryPageList(UserRole entity, int pageIndex, int pageSize){
		return userRoleDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(UserRole entity) {
		// 若要获取id，请使用entity.getId();
		int result = userRoleDao.insertEntity(entity);
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
	public JsonResult modify(UserRole entity) {
		int result = userRoleDao.updateEntity(entity);
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
		UserRole entity = new UserRole();
		entity.setId(id);
		int result = userRoleDao.deleteEntity(entity);
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
		UserRole entity = new UserRole();
		entity.getMap().put("ids", ids.split(","));
		int result = userRoleDao.deleteEntity(entity);
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
	public JsonResult remove(UserRole entity) { 
		int result = userRoleDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
