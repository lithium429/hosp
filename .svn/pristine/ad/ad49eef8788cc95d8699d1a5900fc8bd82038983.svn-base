package com.xz.oa.core.service.email;

import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.utils.StringUtil;
import com.xz.oa.core.dao.email.EmailUserDao;
import com.xz.oa.core.domain.entity.EmailUser;
import com.xz.oa.core.domain.enums.EnumEmailUserType;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service("emailUserService")
public class EmailUserService {

	@Resource
	private EmailUserDao emailUserDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return EmailUser
	 * @author davidwan
	 */
	public EmailUser findById(Integer id) {
		EmailUser entity = new EmailUser();
		entity.setId(id);
		return emailUserDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return EmailUser
	 * @author davidwan
	 */
	public EmailUser find(EmailUser entity) {
		return emailUserDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<EmailUser>
	 * @author davidwan
	 */
	public List<EmailUser> queryList(EmailUser entity) {
		return emailUserDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<EmailUser>
	 * @author davidwan
	 */
	public PageInfo<EmailUser> queryPageList(EmailUser entity, int pageIndex, int pageSize) {
		return emailUserDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param isRead
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<EmailUser>
	 * @author davidwan
	 */
	public PageInfo<EmailUser> queryHomePageList(EmailUser entity, Boolean isRead, int pageIndex, int pageSize) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();

		entity.setType((byte) EnumEmailUserType.接收.getValue());
		entity.setUser_id(shiroUser.getId());
		entity.setIs_read(isRead);
		entity.setIs_delete(false);
		entity.setIs_send(true);
		return emailUserDao.selectEntityPageList(entity, pageIndex, pageSize);
	} 

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(EmailUser entity) {
		// 若要获取id，请使用entity.getId();
		int result = emailUserDao.insertEntity(entity);
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
	public JsonResult modify(EmailUser entity,int type) {
		int model=0;
		Boolean is_read=entity.getIs_read(),is_delete=entity.getIs_delete();
		switch(type)
		{
		case -1:
			model=EnumLogModule.发送短信.getValue();
			break;
		case 0:
			model=EnumLogModule.收件箱.getValue();
			break;
		case 1:
			model=EnumLogModule.发件箱.getValue();
			break;
		case 2:
			model=EnumLogModule.草稿箱.getValue();
			break;
		case 3:
			model=EnumLogModule.邮件回收站.getValue();
			break;
		}
		int result = emailUserDao.updateEntity(entity);
		if (result > 0) {
			String action=is_read!=null&&is_read?"标为已读":"";
			action=is_delete!=null&&is_delete?(entity.getId()==null?"批量删除":"删除"):action;
			systemLogService.create(model, action+"邮件",action+"邮件ID：" + (entity.getId()==null?StringUtil.buildIds((String[])entity.getMap().get("ids")):entity.getId()));
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
		
		EmailUser entity = new EmailUser();
		entity.setId(id);
		int result = emailUserDao.deleteEntity(entity);
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
	public JsonResult removeByIds(String ids,int type) {
		int model=0;
		switch(type)
		{
		case -1:
			model=EnumLogModule.发送短信.getValue();
			break;
		case 0:
			model=EnumLogModule.收件箱.getValue();
			break;
		case 1:
			model=EnumLogModule.发件箱.getValue();
			break;
		case 2:
			model=EnumLogModule.草稿箱.getValue();
			break;
		case 3:
			model=EnumLogModule.邮件回收站.getValue();
			break;
		}
		EmailUser entity = new EmailUser();
		entity.getMap().put("ids", ids.split(","));
		int result = emailUserDao.deleteEntity(entity);
		if (result > 0) {
			systemLogService.create(model,"彻底删除邮件","彻底删除邮件ID：" + ids);
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
	public JsonResult remove(EmailUser entity) {
		int result = emailUserDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
