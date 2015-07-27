package com.xz.oa.core.service.handlingprocess;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo; 
import com.xz.base.utils.StringUtil;
import com.xz.oa.core.dao.handlingprocess.HandlingProcessDao;
import com.xz.oa.core.dao.handlingprocess.HandlingProcessRecordDao;
import com.xz.oa.core.domain.entity.HandlingProcess;   
import com.xz.oa.core.domain.entity.HandlingProcessRecord;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class HandlingProcessService{

	@Resource
	private HandlingProcessDao handlingProcessDao;

	@Resource
	private HandlingProcessRecordDao handlingProcessRecordDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return HandlingProcess    
	 * @author davidwan 
	 */
	public HandlingProcess findById(Integer id) {
		HandlingProcess entity = new HandlingProcess();
		entity.setId(id);
		return handlingProcessDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return HandlingProcess    
	 * @author davidwan 
	 */
	public HandlingProcess find(HandlingProcess entity) {
		return handlingProcessDao.selectEntity(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<HandlingProcess>    
	 * @author davidwan 
	 */
	public List<HandlingProcess> queryList(HandlingProcess entity){
		return handlingProcessDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<HandlingProcess>    
	 * @author davidwan 
	 */
	public PageInfo<HandlingProcess> queryPageList(HandlingProcess entity, int pageIndex, int pageSize){
		return handlingProcessDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(HandlingProcess entity) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		entity.setCreator_id(shiroUser.getId());
		entity.setCode(generateCode());
		// 若要获取id，请使用entity.getId();
		int result = handlingProcessDao.insertEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.我的督办流程.getValue(), "创建督办流程","创建督办流程：" + entity.getTitle());
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
	public JsonResult modify(HandlingProcess entity) {
		int result = handlingProcessDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.我的督办流程.getValue(), "修改督办流程","修改督办流程：" + entity.getTitle());
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 处理 
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult modifyHaddle(HandlingProcess entity) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		HandlingProcessRecord r=new HandlingProcessRecord();
		r.setContent(entity.getHaddle_content());
		r.setCreate_time(new Date());
		r.setHandling_id(entity.getId());
		r.setUser_id(shiroUser.getId());
		handlingProcessRecordDao.insertEntity(r);
		if(entity.getState()==3)
		{
			entity.setUser_id(null);
			entity.setClose_date(new Date());
		}
		int result = handlingProcessDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.我的督办流程.getValue(), "处理督办流程","处理督办流程：" + entity.getTitle());
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 关闭
	 * @param entity
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult modifyClose(int id,String ids) {
		
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		HandlingProcessRecord r=new HandlingProcessRecord();
		r.setContent("用户"+shiroUser.getName()+"在督办流程管理中关闭");
		r.setCreate_time(new Date());
		r.setUser_id(shiroUser.getId());
		
		HandlingProcess entity=new HandlingProcess();
		if(id==0)
		{
			entity.getMap().put("ids", ids.split(","));
			for (String  item : ids.split(",")) {
				r.setId(null);
				r.setHandling_id(Integer.valueOf(item));
				handlingProcessRecordDao.insertEntity(r);
			}
		}else
		{
			entity.setId(id);
			r.setHandling_id(entity.getId());
			handlingProcessRecordDao.insertEntity(r);
		}
		entity.setState(3);
		entity.setClose_date(new Date());
		
		
		
		int result = handlingProcessDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.督办流程管理.getValue(), "关闭督办流程","关闭督办流程ID：" + (id==0?ids:id));
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
		HandlingProcess entity = new HandlingProcess();
		entity.setId(id);
		int result = handlingProcessDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.我的督办流程.getValue(), "删除督办流程","删除督办流程ID：" + id);
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
		HandlingProcess entity = new HandlingProcess();
		entity.getMap().put("ids", ids.split(","));
		int result = handlingProcessDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.我的督办流程.getValue(), "删除督办流程","删除督办流程ID：" + ids);
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
	public JsonResult remove(HandlingProcess entity) { 
		int result = handlingProcessDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	//生成编码
	public String generateCode()
	{
		HandlingProcess entity = new HandlingProcess();
		String r=handlingProcessDao.selectEntityCode(entity);
		if(StringUtil.isNullOrEmpty(r))
		{
			r="SJ1000000000001";
		}else
		{
			String r1=r.substring(2);
			r="SJ"+String.valueOf(Long.valueOf(r1)+1);
		}
		return r;
	}

}
