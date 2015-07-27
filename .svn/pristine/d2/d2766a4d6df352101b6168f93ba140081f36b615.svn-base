package com.xz.oa.core.service.meeting;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.meeting.MeetingVerifyRecordDao;
import com.xz.oa.core.domain.entity.MeetingVerifyRecord;   

@Service
public class MeetingVerifyRecordService{

	@Resource
	private MeetingVerifyRecordDao meetingVerifyRecordDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return MeetingVerifyRecord    
	 * @author davidwan 
	 */
	public MeetingVerifyRecord findById(Integer id) {
		MeetingVerifyRecord entity = new MeetingVerifyRecord();
		entity.setId(id);
		return meetingVerifyRecordDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return MeetingVerifyRecord    
	 * @author davidwan 
	 */
	public MeetingVerifyRecord find(MeetingVerifyRecord entity) {
		return meetingVerifyRecordDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<MeetingVerifyRecord>    
	 * @author davidwan 
	 */
	public List<MeetingVerifyRecord> queryList(MeetingVerifyRecord entity){
		return meetingVerifyRecordDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<MeetingVerifyRecord>    
	 * @author davidwan 
	 */
	public PageInfo<MeetingVerifyRecord> queryPageList(MeetingVerifyRecord entity, int pageIndex, int pageSize){
		return meetingVerifyRecordDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(MeetingVerifyRecord entity) {
		// 若要获取id，请使用entity.getId();
		int result = meetingVerifyRecordDao.insertEntity(entity);
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
	public JsonResult modify(MeetingVerifyRecord entity) {
		int result = meetingVerifyRecordDao.updateEntity(entity);
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
		MeetingVerifyRecord entity = new MeetingVerifyRecord();
		entity.setId(id);
		int result = meetingVerifyRecordDao.deleteEntity(entity);
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
		MeetingVerifyRecord entity = new MeetingVerifyRecord();
		entity.getMap().put("ids", ids.split(","));
		int result = meetingVerifyRecordDao.deleteEntity(entity);
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
	public JsonResult remove(MeetingVerifyRecord entity) { 
		int result = meetingVerifyRecordDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
