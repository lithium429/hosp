package com.xz.oa.core.service.rewardpunishment;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.rewardpunishment.RpItemDao;
import com.xz.oa.core.domain.entity.RpItem;   
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

@Service
public class RpItemService{

	@Resource
	private RpItemDao rpItemDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return RpItem    
	 * @author davidwan 
	 */
	public RpItem findById(Integer id) {
		RpItem entity = new RpItem();
		entity.setId(id);
		return rpItemDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return RpItem    
	 * @author davidwan 
	 */
	public RpItem find(RpItem entity) {
		return rpItemDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<RpItem>    
	 * @author davidwan 
	 */
	public List<RpItem> queryList(RpItem entity){
		return rpItemDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<RpItem>    
	 * @author davidwan 
	 */
	public PageInfo<RpItem> queryPageList(RpItem entity, int pageIndex, int pageSize){
		return rpItemDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(RpItem entity) {

		RpItem t = new RpItem();
		Integer sort = rpItemDao.selectEntitySort(t);
		entity.setSort((sort == null ? 0 : sort) + 1);
		// 若要获取id，请使用entity.getId();
		int result = rpItemDao.insertEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.奖惩名目.getValue(), "添加奖惩名目","添加奖惩名目：" + entity.getName());
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
	public JsonResult modify(RpItem entity) {
		int result = rpItemDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.奖惩名目.getValue(), "修改奖惩名目","修改奖惩名目：" + entity.getName());
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
		RpItem entity = new RpItem();
		entity.setId(id);
		int result = rpItemDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.奖惩名目.getValue(), "删除奖惩名目","删除奖惩名目ID：" + id);
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
		RpItem entity = new RpItem();
		entity.getMap().put("ids", ids.split(","));
		int result = rpItemDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.奖惩名目.getValue(), "批量删除奖惩名目","批量删除奖惩名目ID：" + ids);
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
	public JsonResult remove(RpItem entity) { 
		int result = rpItemDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	// 验证名称重名
	public boolean validateName(Integer id, String name) {
		RpItem t = new RpItem();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("name_valid", name);
		int count = rpItemDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}
