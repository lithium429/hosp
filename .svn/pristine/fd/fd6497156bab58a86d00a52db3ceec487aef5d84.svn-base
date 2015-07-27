package com.xz.oa.core.service.forum;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.forum.ForumFileDao;
import com.xz.oa.core.domain.entity.ForumFile;   

@Service
public class ForumFileService{

	@Resource
	private ForumFileDao forumFileDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return ForumFile    
	 * @author davidwan 
	 */
	public ForumFile findById(Integer id) {
		ForumFile entity = new ForumFile();
		entity.setId(id);
		return forumFileDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return ForumFile    
	 * @author davidwan 
	 */
	public ForumFile find(ForumFile entity) {
		return forumFileDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<ForumFile>    
	 * @author davidwan 
	 */
	public List<ForumFile> queryList(ForumFile entity){
		return forumFileDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<ForumFile>    
	 * @author davidwan 
	 */
	public PageInfo<ForumFile> queryPageList(ForumFile entity, int pageIndex, int pageSize){
		return forumFileDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(ForumFile entity) {
		// 若要获取id，请使用entity.getId();
		int result = forumFileDao.insertEntity(entity);
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
	public JsonResult modify(ForumFile entity) {
		int result = forumFileDao.updateEntity(entity);
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
		ForumFile entity = new ForumFile();
		entity.setId(id);
		int result = forumFileDao.deleteEntity(entity);
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
		ForumFile entity = new ForumFile();
		entity.getMap().put("ids", ids.split(","));
		int result = forumFileDao.deleteEntity(entity);
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
	public JsonResult remove(ForumFile entity) { 
		int result = forumFileDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
