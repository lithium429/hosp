package com.xz.oa.core.service.address;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.address.AddressGroupDao;
import com.xz.oa.core.domain.entity.AddressGroup;    
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class AddressGroupService{

	@Resource
	private AddressGroupDao addressGroupDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return AddressGroup    
	 * @author davidwan 
	 */
	public AddressGroup findById(Integer id) {
		AddressGroup entity = new AddressGroup();
		entity.setId(id);
		return addressGroupDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return AddressGroup    
	 * @author davidwan 
	 */
	public AddressGroup find(AddressGroup entity) {
		return addressGroupDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<AddressGroup>    
	 * @author davidwan 
	 */
	public List<AddressGroup> queryList(AddressGroup entity){
		return addressGroupDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<AddressGroup>    
	 * @author davidwan 
	 */
	public PageInfo<AddressGroup> queryPageList(AddressGroup entity, int pageIndex, int pageSize){
		return addressGroupDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(AddressGroup entity) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser)currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		AddressGroup t=new AddressGroup();
		Integer sort=addressGroupDao.selectEntitySort(t);
		entity.setSort((sort==null?0:sort)+1);
		entity.setCreator_id(shiroUser.getId());
		// 若要获取id，请使用entity.getId();
		int result = addressGroupDao.insertEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.外部通讯录.getValue(), "添加分组","添加分组：" + entity.getName());
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
	public JsonResult modify(AddressGroup entity) {
		int result = addressGroupDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.外部通讯录.getValue(), "修改分组","修改分组：" + entity.getName());
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
		AddressGroup entity = new AddressGroup();
		entity.setId(id);
		int result = addressGroupDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.外部通讯录.getValue(), "删除分组","删除分组ID：" + id);
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
		AddressGroup entity = new AddressGroup();
		entity.getMap().put("ids", ids.split(","));
		int result = addressGroupDao.deleteEntity(entity);
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
	public JsonResult remove(AddressGroup entity) { 
		int result = addressGroupDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
