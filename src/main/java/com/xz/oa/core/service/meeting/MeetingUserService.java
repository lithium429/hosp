package com.xz.oa.core.service.meeting;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.meeting.MeetingUserDao;
import com.xz.oa.core.domain.entity.MeetingUser;   

@Service
public class MeetingUserService{

	@Resource
	private MeetingUserDao meetingUserDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return MeetingUser    
	 * @author davidwan 
	 */
	public MeetingUser findById(Integer id) {
		MeetingUser entity = new MeetingUser();
		entity.setId(id);
		return meetingUserDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return MeetingUser    
	 * @author davidwan 
	 */
	public MeetingUser find(MeetingUser entity) {
		return meetingUserDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<MeetingUser>    
	 * @author davidwan 
	 */
	public List<MeetingUser> queryList(MeetingUser entity){
		return meetingUserDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<MeetingUser>    
	 * @author davidwan 
	 */
	public PageInfo<MeetingUser> queryPageList(MeetingUser entity, int pageIndex, int pageSize){
		return meetingUserDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(MeetingUser entity) {
		// 若要获取id，请使用entity.getId();
		int result = meetingUserDao.insertEntity(entity);
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
	public JsonResult modify(MeetingUser entity) {
		int result = meetingUserDao.updateEntity(entity);
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
		MeetingUser entity = new MeetingUser();
		entity.setId(id);
		int result = meetingUserDao.deleteEntity(entity);
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
		MeetingUser entity = new MeetingUser();
		entity.getMap().put("ids", ids.split(","));
		int result = meetingUserDao.deleteEntity(entity);
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
	public JsonResult remove(MeetingUser entity) { 
		int result = meetingUserDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
