package com.xz.oa.core.service.email;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.email.EmailFileDao;
import com.xz.oa.core.domain.entity.EmailFile;   

@Service
public class EmailFileService{

	@Resource
	private EmailFileDao emailFileDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return EmailFile    
	 * @author davidwan 
	 */
	public EmailFile findById(Integer id) {
		EmailFile entity = new EmailFile();
		entity.setId(id);
		return emailFileDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return EmailFile    
	 * @author davidwan 
	 */
	public EmailFile find(EmailFile entity) {
		return emailFileDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<EmailFile>    
	 * @author davidwan 
	 */
	public List<EmailFile> queryList(EmailFile entity){
		return emailFileDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<EmailFile>    
	 * @author davidwan 
	 */
	public PageInfo<EmailFile> queryPageList(EmailFile entity, int pageIndex, int pageSize){
		return emailFileDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(EmailFile entity) {
		// 若要获取id，请使用entity.getId();
		int result = emailFileDao.insertEntity(entity);
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
	public JsonResult modify(EmailFile entity) {
		int result = emailFileDao.updateEntity(entity);
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
		EmailFile entity = new EmailFile();
		entity.setId(id);
		int result = emailFileDao.deleteEntity(entity);
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
		EmailFile entity = new EmailFile();
		entity.getMap().put("ids", ids.split(","));
		int result = emailFileDao.deleteEntity(entity);
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
	public JsonResult remove(EmailFile entity) { 
		int result = emailFileDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
