package com.xz.oa.core.service.announcement;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.announcement.AnnouncementDeptDao;
import com.xz.oa.core.domain.entity.AnnouncementDept;   

@Service
public class AnnouncementDeptService{

	@Resource
	private AnnouncementDeptDao announcementDeptDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return AnnouncementDept    
	 * @author davidwan 
	 */
	public AnnouncementDept findById(Integer id) {
		AnnouncementDept entity = new AnnouncementDept();
		entity.setId(id);
		return announcementDeptDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return AnnouncementDept    
	 * @author davidwan 
	 */
	public AnnouncementDept find(AnnouncementDept entity) {
		return announcementDeptDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<AnnouncementDept>    
	 * @author davidwan 
	 */
	public List<AnnouncementDept> queryList(AnnouncementDept entity){
		return announcementDeptDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<AnnouncementDept>    
	 * @author davidwan 
	 */
	public PageInfo<AnnouncementDept> queryPageList(AnnouncementDept entity, int pageIndex, int pageSize){
		return announcementDeptDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(AnnouncementDept entity) {
		// 若要获取id，请使用entity.getId();
		int result = announcementDeptDao.insertEntity(entity);
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
	public JsonResult modify(AnnouncementDept entity) {
		int result = announcementDeptDao.updateEntity(entity);
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
		AnnouncementDept entity = new AnnouncementDept();
		entity.setId(id);
		int result = announcementDeptDao.deleteEntity(entity);
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
		AnnouncementDept entity = new AnnouncementDept();
		entity.getMap().put("ids", ids.split(","));
		int result = announcementDeptDao.deleteEntity(entity);
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
	public JsonResult remove(AnnouncementDept entity) { 
		int result = announcementDeptDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
