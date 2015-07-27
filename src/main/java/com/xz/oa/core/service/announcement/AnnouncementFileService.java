package com.xz.oa.core.service.announcement;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.announcement.AnnouncementFileDao;
import com.xz.oa.core.domain.entity.AnnouncementFile;   

@Service
public class AnnouncementFileService{

	@Resource
	private AnnouncementFileDao announcementFileDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return AnnouncementFile    
	 * @author davidwan 
	 */
	public AnnouncementFile findById(Integer id) {
		AnnouncementFile entity = new AnnouncementFile();
		entity.setId(id);
		return announcementFileDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return AnnouncementFile    
	 * @author davidwan 
	 */
	public AnnouncementFile find(AnnouncementFile entity) {
		return announcementFileDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<AnnouncementFile>    
	 * @author davidwan 
	 */
	public List<AnnouncementFile> queryList(AnnouncementFile entity){
		return announcementFileDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<AnnouncementFile>    
	 * @author davidwan 
	 */
	public PageInfo<AnnouncementFile> queryPageList(AnnouncementFile entity, int pageIndex, int pageSize){
		return announcementFileDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(AnnouncementFile entity) {
		// 若要获取id，请使用entity.getId();
		int result = announcementFileDao.insertEntity(entity);
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
	public JsonResult modify(AnnouncementFile entity) {
		int result = announcementFileDao.updateEntity(entity);
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
		AnnouncementFile entity = new AnnouncementFile();
		entity.setId(id);
		int result = announcementFileDao.deleteEntity(entity);
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
		AnnouncementFile entity = new AnnouncementFile();
		entity.getMap().put("ids", ids.split(","));
		int result = announcementFileDao.deleteEntity(entity);
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
	public JsonResult remove(AnnouncementFile entity) { 
		int result = announcementFileDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
