package com.xz.oa.core.service.address;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.address.AddressUserDao;
import com.xz.oa.core.domain.entity.AddressUser;   

@Service
public class AddressUserService{

	@Resource
	private AddressUserDao addressUserDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return AddressUser    
	 * @author davidwan 
	 */
	public AddressUser findById(Integer id) {
		AddressUser entity = new AddressUser();
		entity.setId(id);
		return addressUserDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return AddressUser    
	 * @author davidwan 
	 */
	public AddressUser find(AddressUser entity) {
		return addressUserDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<AddressUser>    
	 * @author davidwan 
	 */
	public List<AddressUser> queryList(AddressUser entity){
		return addressUserDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<AddressUser>    
	 * @author davidwan 
	 */
	public PageInfo<AddressUser> queryPageList(AddressUser entity, int pageIndex, int pageSize){
		return addressUserDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(AddressUser entity) {
		// 若要获取id，请使用entity.getId();
		int result = addressUserDao.insertEntity(entity);
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
	public JsonResult modify(AddressUser entity) {
		int result = addressUserDao.updateEntity(entity);
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
		AddressUser entity = new AddressUser();
		entity.setId(id);
		int result = addressUserDao.deleteEntity(entity);
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
		AddressUser entity = new AddressUser();
		entity.getMap().put("ids", ids.split(","));
		int result = addressUserDao.deleteEntity(entity);
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
	public JsonResult remove(AddressUser entity) { 
		int result = addressUserDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
