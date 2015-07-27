package com.xz.oa.core.service.meeting;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.meeting.MeetingFileDao;
import com.xz.oa.core.domain.entity.MeetingFile;   

@Service
public class MeetingFileService{

	@Resource
	private MeetingFileDao meetingFileDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return MeetingFile    
	 * @author davidwan 
	 */
	public MeetingFile findById(Integer id) {
		MeetingFile entity = new MeetingFile();
		entity.setId(id);
		return meetingFileDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return MeetingFile    
	 * @author davidwan 
	 */
	public MeetingFile find(MeetingFile entity) {
		return meetingFileDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<MeetingFile>    
	 * @author davidwan 
	 */
	public List<MeetingFile> queryList(MeetingFile entity){
		return meetingFileDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<MeetingFile>    
	 * @author davidwan 
	 */
	public PageInfo<MeetingFile> queryPageList(MeetingFile entity, int pageIndex, int pageSize){
		return meetingFileDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(MeetingFile entity) {
		// 若要获取id，请使用entity.getId();
		int result = meetingFileDao.insertEntity(entity);
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
	public JsonResult modify(MeetingFile entity) {
		int result = meetingFileDao.updateEntity(entity);
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
		MeetingFile entity = new MeetingFile();
		entity.setId(id);
		int result = meetingFileDao.deleteEntity(entity);
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
		MeetingFile entity = new MeetingFile();
		entity.getMap().put("ids", ids.split(","));
		int result = meetingFileDao.deleteEntity(entity);
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
	public JsonResult remove(MeetingFile entity) { 
		int result = meetingFileDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
