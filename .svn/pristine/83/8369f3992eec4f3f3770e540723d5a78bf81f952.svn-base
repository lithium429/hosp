package com.xz.oa.core.service.meeting;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.meeting.MeetingRoomDao;
import com.xz.oa.core.domain.entity.MeetingRoom;   
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class MeetingRoomService{

	@Resource
	private MeetingRoomDao meetingRoomDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return MeetingRoom    
	 * @author davidwan 
	 */
	public MeetingRoom findById(Integer id) {
		MeetingRoom entity = new MeetingRoom();
		entity.setId(id);
		return meetingRoomDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return MeetingRoom    
	 * @author davidwan 
	 */
	public MeetingRoom find(MeetingRoom entity) {
		return meetingRoomDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<MeetingRoom>    
	 * @author davidwan 
	 */
	public List<MeetingRoom> queryList(MeetingRoom entity){
		return meetingRoomDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<MeetingRoom>    
	 * @author davidwan 
	 */
	public PageInfo<MeetingRoom> queryPageList(MeetingRoom entity, int pageIndex, int pageSize){
		return meetingRoomDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(MeetingRoom entity) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser)currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreator_id(shiroUser.getId());
		entity.setCreate_time(new Date());
		// 若要获取id，请使用entity.getId();
		int result = meetingRoomDao.insertEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.会议室管理.getValue(), "添加会议室","添加会议室：" + entity.getName());
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
	public JsonResult modify(MeetingRoom entity) {
		int result = meetingRoomDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.会议室管理.getValue(), "修改会议室","修改会议室：" + entity.getName());
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
		MeetingRoom entity = new MeetingRoom();
		entity.setId(id);
		int result = meetingRoomDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.会议室管理.getValue(), "删除会议室","删除会议室ID：" + id);
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
		MeetingRoom entity = new MeetingRoom();
		entity.getMap().put("ids", ids.split(","));
		int result = meetingRoomDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.会议室管理.getValue(), "批量删除会议室","批量删除会议室ID：" + ids);
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
	public JsonResult remove(MeetingRoom entity) { 
		int result = meetingRoomDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}
	
	//验证名称重名
	public boolean validateName(Integer id, String name) {
		MeetingRoom t = new MeetingRoom();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("name", name);
		t.getMap().put("name_valid", "true");
		int count = meetingRoomDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}
