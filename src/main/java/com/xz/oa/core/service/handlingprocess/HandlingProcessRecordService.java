package com.xz.oa.core.service.handlingprocess;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.handlingprocess.HandlingProcessRecordDao;
import com.xz.oa.core.domain.entity.HandlingProcessRecord;   

@Service
public class HandlingProcessRecordService{

	@Resource
	private HandlingProcessRecordDao handlingProcessRecordDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return HandlingProcessRecord    
	 * @author davidwan 
	 */
	public HandlingProcessRecord findById(Integer id) {
		HandlingProcessRecord entity = new HandlingProcessRecord();
		entity.setId(id);
		return handlingProcessRecordDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return HandlingProcessRecord    
	 * @author davidwan 
	 */
	public HandlingProcessRecord find(HandlingProcessRecord entity) {
		return handlingProcessRecordDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<HandlingProcessRecord>    
	 * @author davidwan 
	 */
	public List<HandlingProcessRecord> queryList(HandlingProcessRecord entity){
		return handlingProcessRecordDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<HandlingProcessRecord>    
	 * @author davidwan 
	 */
	public PageInfo<HandlingProcessRecord> queryPageList(HandlingProcessRecord entity, int pageIndex, int pageSize){
		return handlingProcessRecordDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(HandlingProcessRecord entity) {
		// 若要获取id，请使用entity.getId();
		int result = handlingProcessRecordDao.insertEntity(entity);
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
	public JsonResult modify(HandlingProcessRecord entity) {
		int result = handlingProcessRecordDao.updateEntity(entity);
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
		HandlingProcessRecord entity = new HandlingProcessRecord();
		entity.setId(id);
		int result = handlingProcessRecordDao.deleteEntity(entity);
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
		HandlingProcessRecord entity = new HandlingProcessRecord();
		entity.getMap().put("ids", ids.split(","));
		int result = handlingProcessRecordDao.deleteEntity(entity);
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
	public JsonResult remove(HandlingProcessRecord entity) { 
		int result = handlingProcessRecordDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
