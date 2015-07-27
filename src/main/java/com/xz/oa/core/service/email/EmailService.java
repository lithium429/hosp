package com.xz.oa.core.service.email;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.utils.StringUtil;
import com.xz.oa.core.dao.email.EmailContentDao;
import com.xz.oa.core.dao.email.EmailDao;
import com.xz.oa.core.dao.email.EmailFileDao;
import com.xz.oa.core.dao.email.EmailReceiverDao;
import com.xz.oa.core.dao.email.EmailUserDao;
import com.xz.oa.core.domain.entity.Email;
import com.xz.oa.core.domain.entity.EmailContent;
import com.xz.oa.core.domain.entity.EmailFile;
import com.xz.oa.core.domain.entity.EmailReceiver;
import com.xz.oa.core.domain.entity.EmailUser;
import com.xz.oa.core.domain.entity.NotifyMessage;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.domain.enums.EnumNotifyMessageModuleType;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.notify.NotifyEventExecutor;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service("emailService")
public class EmailService {

	@Resource
	private EmailDao emailDao;

	@Resource
	private EmailContentDao emailContentDao;

	@Resource
	private EmailReceiverDao emailReceiverDao;

	@Resource
	private EmailUserDao emailUserDao;

	@Resource
	private EmailFileDao emailFileDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Email
	 * @author davidwan
	 */
	public Email findById(Integer id) {
		Email entity = new Email();
		entity.setId(id);
		return emailDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Email
	 * @author davidwan
	 */
	public Email find(Email entity) {
		return emailDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Email>
	 * @author davidwan
	 */
	public List<Email> queryList(Email entity) {
		return emailDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Email>
	 * @author davidwan
	 */
	public PageInfo<Email> queryPageList(Email entity, int pageIndex, int pageSize) {
		return emailDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(Email entity) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		Date now = new Date();
		entity.setSender_id(shiroUser.getId());
		entity.setCreate_time(now);
		if (entity.getFiles() != null && entity.getFiles().size() > 0) {
			entity.setIs_file(true);
		}
		// 若要获取id，请使用entity.getId();
		int result = emailDao.insertEntity(entity);
		int email_id = entity.getId();
		// 邮件内容
		String content = entity.getContent();
		EmailContent ec = new EmailContent();
		ec.setContent(content);
		ec.setEmail_id(email_id);
		emailContentDao.insertEntity(ec);

		// 邮件附件
		if (entity.getFiles() != null && entity.getFiles().size() > 0) {
			for (EmailFile item : entity.getFiles()) {
				item.setCreate_time(now);
				item.setEmail_id(email_id);
				emailFileDao.insertEntity(item);
			}
		}

		// 邮件收件人
		Integer reply_id = entity.getReply_email_id();
		Boolean is_reply = entity.getIs_reply();
		Boolean is_forward = entity.getIs_forward();
		EmailUser eu = new EmailUser();
		eu.setType((byte) 1);
		eu.setIs_send(entity.getIs_send());
		eu.setUser_id(shiroUser.getId());
		eu.setEmail_id(email_id);
		eu.setReply_email_id(reply_id);
		eu.setIs_reply(is_reply);
		eu.setIs_forward(is_forward);
		emailUserDao.insertEntity(eu);
		EmailReceiver er = new EmailReceiver();
		if (!StringUtil.isNullOrEmpty(entity.getInnerUserIds())) {
			for (String item : entity.getInnerUserIds().split(",")) {
				int user_id = Integer.valueOf(item);
				er = new EmailReceiver();
				er.setEmail_id(email_id);
				er.setUser_id(user_id);
				er.setType(1);
				emailReceiverDao.insertEntity(er);
				eu = new EmailUser();
				eu.setType((byte) 2);
				eu.setIs_send(entity.getIs_send());
				eu.setUser_id(user_id);
				eu.setEmail_id(email_id);
				eu.setReply_email_id(reply_id);
				eu.setIs_reply(is_reply);
				eu.setIs_forward(is_forward);
				emailUserDao.insertEntity(eu);
			}
		}
		if (!StringUtil.isNullOrEmpty(entity.getInnerUser_csIds())) {
			for (String item : entity.getInnerUser_csIds().split(",")) {
				int user_id = Integer.valueOf(item);
				er = new EmailReceiver();
				er.setEmail_id(email_id);
				er.setUser_id(user_id);
				er.setType(2);
				emailReceiverDao.insertEntity(er);
				eu = new EmailUser();
				eu.setType((byte) 2);
				eu.setIs_copy(true);
				eu.setIs_send(entity.getIs_send());
				eu.setUser_id(user_id);
				eu.setEmail_id(email_id);
				eu.setReply_email_id(reply_id);
				eu.setIs_reply(is_reply);
				eu.setIs_forward(is_forward);
				emailUserDao.insertEntity(eu);
			}
		}
		if (!StringUtil.isNullOrEmpty(entity.getInnerUser_msIds())) {
			for (String item : entity.getInnerUser_msIds().split(",")) {
				int user_id = Integer.valueOf(item);
				er = new EmailReceiver();
				er.setEmail_id(email_id);
				er.setUser_id(user_id);
				er.setType(3);
				emailReceiverDao.insertEntity(er);
				eu = new EmailUser();
				eu.setType((byte) 2);
				eu.setIs_secret(true);
				eu.setIs_send(entity.getIs_send());
				eu.setUser_id(user_id);
				eu.setEmail_id(email_id);
				eu.setReply_email_id(reply_id);
				eu.setIs_reply(is_reply);
				eu.setIs_forward(is_forward);
				emailUserDao.insertEntity(eu);
			}
		}
		if (result > 0) {
			String action="发送";
			action=is_forward!=null&&is_forward?"回复":action;
			action=is_reply!=null&&is_reply?"转发":action;
			action=entity.getIs_send()!=null&&entity.getIs_send()?action:"存草稿";
			//添加操作日志
			int type=entity.getType(),model=0;
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
			case 10:
				model=EnumLogModule.外部通讯录.getValue();
				break;
			}
			systemLogService.create(model, action+"邮件",action+"邮件：" + entity.getSubject());
			
			// 添加事务提醒
			NotifyMessage message = new NotifyMessage(EnumNotifyMessageModuleType.邮件.getValue());
			message.setRef_id(email_id);
			NotifyEventExecutor.execute(message);
			
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
	public JsonResult modify(Email entity) {
		int result = emailDao.updateEntity(entity);
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
		Email entity = new Email();
		entity.setId(id);
		int result = emailDao.deleteEntity(entity);
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
		Email entity = new Email();
		entity.getMap().put("ids", ids.split(","));
		int result = emailDao.deleteEntity(entity);
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
	public JsonResult remove(Email entity) {
		int result = emailDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
