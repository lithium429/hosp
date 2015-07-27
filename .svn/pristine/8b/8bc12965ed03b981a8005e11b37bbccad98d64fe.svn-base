package com.xz.oa.core.service.advice;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.advice.AdviceConfigDao;
import com.xz.oa.core.domain.entity.AdviceConfig;   

@Service
public class AdviceConfigService{

	@Resource
	private AdviceConfigDao adviceConfigDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return AdviceConfig    
	 * @author davidwan 
	 */
	public AdviceConfig findById(Integer id) {
		AdviceConfig entity = new AdviceConfig();
		entity.setId(id);
		return adviceConfigDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return AdviceConfig    
	 * @author davidwan 
	 */
	public AdviceConfig find(AdviceConfig entity) {
		return adviceConfigDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<AdviceConfig>    
	 * @author davidwan 
	 */
	public List<AdviceConfig> queryList(AdviceConfig entity){
		return adviceConfigDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<AdviceConfig>    
	 * @author davidwan 
	 */
	public PageInfo<AdviceConfig> queryPageList(AdviceConfig entity, int pageIndex, int pageSize){
		return adviceConfigDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(AdviceConfig entity) {
		int result =0;
		if(entity.getId()!=null)
		{
			result = adviceConfigDao.updateEntity(entity);
		}else
		{
			result = adviceConfigDao.insertEntity(entity);
		}
		// 若要获取id，请使用entity.getId();
		
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
	public JsonResult modify(AdviceConfig entity) {
		int result = adviceConfigDao.updateEntity(entity);
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
		AdviceConfig entity = new AdviceConfig();
		entity.setId(id);
		int result = adviceConfigDao.deleteEntity(entity);
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
		AdviceConfig entity = new AdviceConfig();
		entity.getMap().put("ids", ids.split(","));
		int result = adviceConfigDao.deleteEntity(entity);
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
	public JsonResult remove(AdviceConfig entity) { 
		int result = adviceConfigDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
