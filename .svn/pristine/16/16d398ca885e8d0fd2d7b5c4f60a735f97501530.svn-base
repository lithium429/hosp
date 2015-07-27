package com.xz.oa.core.service.staff;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.staff.StaffContractFileDao;
import com.xz.oa.core.domain.entity.StaffContractFile;   

@Service
public class StaffContractFileService{

	@Resource
	private StaffContractFileDao staffContractFileDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return StaffContractFile    
	 * @author davidwan 
	 */
	public StaffContractFile findById(Integer id) {
		StaffContractFile entity = new StaffContractFile();
		entity.setId(id);
		return staffContractFileDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return StaffContractFile    
	 * @author davidwan 
	 */
	public StaffContractFile find(StaffContractFile entity) {
		return staffContractFileDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<StaffContractFile>    
	 * @author davidwan 
	 */
	public List<StaffContractFile> queryList(StaffContractFile entity){
		return staffContractFileDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<StaffContractFile>    
	 * @author davidwan 
	 */
	public PageInfo<StaffContractFile> queryPageList(StaffContractFile entity, int pageIndex, int pageSize){
		return staffContractFileDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(StaffContractFile entity) {
		// 若要获取id，请使用entity.getId();
		int result = staffContractFileDao.insertEntity(entity);
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
	public JsonResult modify(StaffContractFile entity) {
		int result = staffContractFileDao.updateEntity(entity);
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
		StaffContractFile entity = new StaffContractFile();
		entity.setId(id);
		int result = staffContractFileDao.deleteEntity(entity);
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
		StaffContractFile entity = new StaffContractFile();
		entity.getMap().put("ids", ids.split(","));
		int result = staffContractFileDao.deleteEntity(entity);
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
	public JsonResult remove(StaffContractFile entity) { 
		int result = staffContractFileDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
