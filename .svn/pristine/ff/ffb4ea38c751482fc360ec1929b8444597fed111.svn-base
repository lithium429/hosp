package com.xz.oa.core.service.email;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.email.EmailReceiverDao;
import com.xz.oa.core.domain.entity.EmailReceiver;   

@Service
public class EmailReceiverService{

	@Resource
	private EmailReceiverDao emailReceiverDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return EmailReceiver    
	 * @author davidwan 
	 */
	public EmailReceiver findById(Integer id) {
		EmailReceiver entity = new EmailReceiver();
		entity.setId(id);
		return emailReceiverDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return EmailReceiver    
	 * @author davidwan 
	 */
	public EmailReceiver find(EmailReceiver entity) {
		return emailReceiverDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<EmailReceiver>    
	 * @author davidwan 
	 */
	public List<EmailReceiver> queryList(EmailReceiver entity){
		return emailReceiverDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<EmailReceiver>    
	 * @author davidwan 
	 */
	public PageInfo<EmailReceiver> queryPageList(EmailReceiver entity, int pageIndex, int pageSize){
		return emailReceiverDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(EmailReceiver entity) {
		// 若要获取id，请使用entity.getId();
		int result = emailReceiverDao.insertEntity(entity);
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
	public JsonResult modify(EmailReceiver entity) {
		int result = emailReceiverDao.updateEntity(entity);
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
		EmailReceiver entity = new EmailReceiver();
		entity.setId(id);
		int result = emailReceiverDao.deleteEntity(entity);
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
		EmailReceiver entity = new EmailReceiver();
		entity.getMap().put("ids", ids.split(","));
		int result = emailReceiverDao.deleteEntity(entity);
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
	public JsonResult remove(EmailReceiver entity) { 
		int result = emailReceiverDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
