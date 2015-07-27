package com.xz.oa.core.service.care;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.care.CareFileDao;
import com.xz.oa.core.domain.entity.CareFile;   

@Service
public class CareFileService{

	@Resource
	private CareFileDao careFileDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return CareFile    
	 * @author davidwan 
	 */
	public CareFile findById(Integer id) {
		CareFile entity = new CareFile();
		entity.setId(id);
		return careFileDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return CareFile    
	 * @author davidwan 
	 */
	public CareFile find(CareFile entity) {
		return careFileDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<CareFile>    
	 * @author davidwan 
	 */
	public List<CareFile> queryList(CareFile entity){
		return careFileDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<CareFile>    
	 * @author davidwan 
	 */
	public PageInfo<CareFile> queryPageList(CareFile entity, int pageIndex, int pageSize){
		return careFileDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(CareFile entity) {
		// 若要获取id，请使用entity.getId();
		int result = careFileDao.insertEntity(entity);
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
	public JsonResult modify(CareFile entity) {
		int result = careFileDao.updateEntity(entity);
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
		CareFile entity = new CareFile();
		entity.setId(id);
		int result = careFileDao.deleteEntity(entity);
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
		CareFile entity = new CareFile();
		entity.getMap().put("ids", ids.split(","));
		int result = careFileDao.deleteEntity(entity);
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
	public JsonResult remove(CareFile entity) { 
		int result = careFileDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
