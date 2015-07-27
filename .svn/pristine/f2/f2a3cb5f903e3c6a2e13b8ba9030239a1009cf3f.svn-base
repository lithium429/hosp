package com.xz.oa.core.service.sms;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.oa.core.dao.sms.SmsTplDao;
import com.xz.oa.core.domain.entity.SmsTpl;   
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

@Service
public class SmsTplService{

	@Resource
	private SmsTplDao smsTplDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return SmsTpl    
	 * @author davidwan 
	 */
	public SmsTpl findById(Integer id) {
		SmsTpl entity = new SmsTpl();
		entity.setId(id);
		return smsTplDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return SmsTpl    
	 * @author davidwan 
	 */
	public SmsTpl find(SmsTpl entity) {
		return smsTplDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<SmsTpl>    
	 * @author davidwan 
	 */
	public List<SmsTpl> queryList(SmsTpl entity){
		return smsTplDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<SmsTpl>    
	 * @author davidwan 
	 */
	public PageInfo<SmsTpl> queryPageList(SmsTpl entity, int pageIndex, int pageSize){
		return smsTplDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(SmsTpl entity) {
		entity.setCreate_time(new Date());
		if(entity.getType()==2 && judgeTpl(entity))
		{
			return new JsonResult(false,"类型为会议提醒的模板已存在！");
		}
		// 若要获取id，请使用entity.getId();
		int result = smsTplDao.insertEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.短信模版.getValue(), "添加短信模版","添加短信模版：" + entity.getContent());
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
	public JsonResult modify(SmsTpl entity) {
		if(entity.getType()==2 && judgeTpl(entity))
		{
			return new JsonResult(false,"类型为会议提醒的模板已存在！");
		}
		int result = smsTplDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.短信模版.getValue(), "修改 短信模版","修改 短信模版：" + entity.getContent());
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
		SmsTpl entity = new SmsTpl();
		entity.setId(id);
		int result = smsTplDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.短信模版.getValue(), "删除短信模版","删除短信模版ID：" + id);
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
		SmsTpl entity = new SmsTpl();
		entity.getMap().put("ids", ids.split(","));
		int result = smsTplDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.短信模版.getValue(), "批量删除短信模版","批量删除短信模版ID：" + ids);
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
	public JsonResult remove(SmsTpl entity) { 
		int result = smsTplDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}
	
	public boolean judgeTpl(SmsTpl entity)
	{
		boolean r=false;
		Integer id=entity.getId();
		if(id==null)
		{
			id=0;
		}
		SmsTpl t=new SmsTpl();
		t.getMap().put("id",id);
		t.getMap().put("type",entity.getType());
		t.getMap().put("type_valid",true);
		if(smsTplDao.selectEntityCount(t)>0)
		{
			r=true;
		}
		return r;
	}

}
