package com.xz.oa.core.service.leave;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.leave.LeaveVerifyRecordDao;
import com.xz.oa.core.domain.entity.LeaveVerifyRecord;   

@Service
public class LeaveVerifyRecordService{

	@Resource
	private LeaveVerifyRecordDao leaveVerifyRecordDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return LeaveVerifyRecord    
	 * @author davidwan 
	 */
	public LeaveVerifyRecord findById(Integer id) {
		LeaveVerifyRecord entity = new LeaveVerifyRecord();
		entity.setId(id);
		return leaveVerifyRecordDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return LeaveVerifyRecord    
	 * @author davidwan 
	 */
	public LeaveVerifyRecord find(LeaveVerifyRecord entity) {
		return leaveVerifyRecordDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<LeaveVerifyRecord>    
	 * @author davidwan 
	 */
	public List<LeaveVerifyRecord> queryList(LeaveVerifyRecord entity){
		return leaveVerifyRecordDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<LeaveVerifyRecord>    
	 * @author davidwan 
	 */
	public PageInfo<LeaveVerifyRecord> queryPageList(LeaveVerifyRecord entity, int pageIndex, int pageSize){
		return leaveVerifyRecordDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(LeaveVerifyRecord entity) {
		// 若要获取id，请使用entity.getId();
		int result = leaveVerifyRecordDao.insertEntity(entity);
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
	public JsonResult modify(LeaveVerifyRecord entity) {
		int result = leaveVerifyRecordDao.updateEntity(entity);
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
		LeaveVerifyRecord entity = new LeaveVerifyRecord();
		entity.setId(id);
		int result = leaveVerifyRecordDao.deleteEntity(entity);
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
		LeaveVerifyRecord entity = new LeaveVerifyRecord();
		entity.getMap().put("ids", ids.split(","));
		int result = leaveVerifyRecordDao.deleteEntity(entity);
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
	public JsonResult remove(LeaveVerifyRecord entity) { 
		int result = leaveVerifyRecordDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
