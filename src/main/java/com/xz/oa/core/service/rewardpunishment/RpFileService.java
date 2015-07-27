package com.xz.oa.core.service.rewardpunishment;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.rewardpunishment.RpFileDao;
import com.xz.oa.core.domain.entity.RpFile;   

@Service
public class RpFileService{

	@Resource
	private RpFileDao rpFileDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return RpFile    
	 * @author davidwan 
	 */
	public RpFile findById(Integer id) {
		RpFile entity = new RpFile();
		entity.setId(id);
		return rpFileDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return RpFile    
	 * @author davidwan 
	 */
	public RpFile find(RpFile entity) {
		return rpFileDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<RpFile>    
	 * @author davidwan 
	 */
	public List<RpFile> queryList(RpFile entity){
		return rpFileDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<RpFile>    
	 * @author davidwan 
	 */
	public PageInfo<RpFile> queryPageList(RpFile entity, int pageIndex, int pageSize){
		return rpFileDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(RpFile entity) {
		// 若要获取id，请使用entity.getId();
		int result = rpFileDao.insertEntity(entity);
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
	public JsonResult modify(RpFile entity) {
		int result = rpFileDao.updateEntity(entity);
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
		RpFile entity = new RpFile();
		entity.setId(id);
		int result = rpFileDao.deleteEntity(entity);
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
		RpFile entity = new RpFile();
		entity.getMap().put("ids", ids.split(","));
		int result = rpFileDao.deleteEntity(entity);
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
	public JsonResult remove(RpFile entity) { 
		int result = rpFileDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
