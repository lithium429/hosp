package com.xz.oa.core.service.email;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.email.EmailContentDao;
import com.xz.oa.core.domain.entity.EmailContent;   

@Service
public class EmailContentService{

	@Resource
	private EmailContentDao emailContentDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return EmailContent    
	 * @author davidwan 
	 */
	public EmailContent findById(Integer id) {
		EmailContent entity = new EmailContent();
		entity.setId(id);
		return emailContentDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return EmailContent    
	 * @author davidwan 
	 */
	public EmailContent find(EmailContent entity) {
		return emailContentDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<EmailContent>    
	 * @author davidwan 
	 */
	public List<EmailContent> queryList(EmailContent entity){
		return emailContentDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<EmailContent>    
	 * @author davidwan 
	 */
	public PageInfo<EmailContent> queryPageList(EmailContent entity, int pageIndex, int pageSize){
		return emailContentDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(EmailContent entity) {
		// 若要获取id，请使用entity.getId();
		int result = emailContentDao.insertEntity(entity);
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
	public JsonResult modify(EmailContent entity) {
		int result = emailContentDao.updateEntity(entity);
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
		EmailContent entity = new EmailContent();
		entity.setId(id);
		int result = emailContentDao.deleteEntity(entity);
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
		EmailContent entity = new EmailContent();
		entity.getMap().put("ids", ids.split(","));
		int result = emailContentDao.deleteEntity(entity);
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
	public JsonResult remove(EmailContent entity) { 
		int result = emailContentDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
