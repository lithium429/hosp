package com.xz.oa.core.service.sms;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.sms.SmsDao;
import com.xz.oa.core.domain.entity.Sms;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.domain.enums.EnumSmsState;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;
import com.xz.oa.sms.model.SendResult;
import com.xz.oa.sms.service.SmsInterface;

@Service
public class SmsService {

	@Resource
	private SmsDao smsDao;

	private SmsInterface smsInterface;

	@Resource
	private SystemLogService systemLogService;

	public void setSmsInterface(SmsInterface smsInterface) {
		this.smsInterface = smsInterface;
	}

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Sms
	 * @author davidwan
	 */
	public Sms findById(Integer id) {
		Sms entity = new Sms();
		entity.setId(id);
		return smsDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Sms
	 * @author davidwan
	 */
	public Sms find(Sms entity) {
		return smsDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Sms>
	 * @author davidwan
	 */
	public List<Sms> queryList(Sms entity) {
		return smsDao.selectEntityList(entity);
	}

	/**
	 * @Description 获取发送条数
	 * @param entity
	 * @return List<Sms>
	 * @author davidwan
	 */
	public Integer queryScount(Sms entity) {
		Integer r = smsDao.selectEntityCount(entity, "Scount");
		return r == null ? 0 : r;
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Sms>
	 * @author davidwan
	 */
	public PageInfo<Sms> queryPageList(Sms entity, int pageIndex, int PageSize) {
		return smsDao.selectEntityPageList(entity, pageIndex, PageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(Sms entity, String innerUsers, String outerUsers, String otherUser) {
		int user_id = 0, result = 0;
		String user_name = "", user_phone = "";
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		entity.setSender_id(shiroUser.getId());
		entity.setState(2);
		String content = entity.getContent();
		int c = content.length() / 70;
		if (content.length() % 70 > 0) {
			c += 1;
		}
		entity.setScount(c);
		entity.setInterface_type(1);
		entity.setIs_retry(false);
		entity.setRetry_count(0);

		SendResult sendResult = null;
		// 内部人员
		if (innerUsers != "") {
			entity.setReceiver_type(1);
			String[] innerUserArray = innerUsers.split(";");
			for (String item : innerUserArray) {
				entity.setId(null);
				user_id = Integer.valueOf(item.substring(0, item.indexOf("[")));
				user_name = item.substring(item.indexOf("[") + 1, item.indexOf("("));
				user_phone = item.substring(item.indexOf("(") + 1, item.indexOf(")"));
				entity.setReceiver_id(user_id);
				entity.setReceiver_name(user_name);
				entity.setPhone(user_phone);

				// 调用短信接口发送短信
				sendResult = smsInterface.send(user_phone, entity.getContent());
				if (sendResult == null) {
					return new JsonResult(false, "系统未配置短信接口，请联系系统管理员！");
				}
				if (sendResult.isFlag()) {
					entity.setState(EnumSmsState.成功.getValue());
				} else {
					entity.setState(EnumSmsState.失败.getValue());
				}
				result = smsDao.insertEntity(entity);
			}
		}
		// 外部人员
		if (outerUsers != "") {
			entity.setReceiver_type(2);
			String[] outerUserArray = outerUsers.split(";");
			for (String item : outerUserArray) {
				entity.setId(null);
				user_id = Integer.valueOf(item.substring(0, item.indexOf("[")));
				user_name = item.substring(item.indexOf("[") + 1, item.indexOf("("));
				user_phone = item.substring(item.indexOf("(") + 1, item.indexOf(")"));
				entity.setReceiver_id(user_id);
				entity.setReceiver_name(user_name);
				entity.setPhone(user_phone);

				// 调用短信接口发送短信
				sendResult = smsInterface.send(user_phone, entity.getContent());
				if (sendResult == null) {
					return new JsonResult(false, "系统未配置短信接口，请联系系统管理员！");
				}
				if (sendResult.isFlag()) {
					entity.setState(EnumSmsState.成功.getValue());
				} else {
					entity.setState(EnumSmsState.失败.getValue());
				}
				result = smsDao.insertEntity(entity);
			}
		}
		// 其他人员
		if (otherUser != "") {
			entity.setReceiver_type(3);
			entity.setReceiver_id(null);
			entity.setReceiver_name(null);
			String[] otherUserArray = otherUser.split(";");
			for (String item : otherUserArray) {
				entity.setId(null);
				entity.setPhone(item);

				// 调用短信接口发送短信
				sendResult = smsInterface.send(item, entity.getContent());
				if (sendResult == null) {
					return new JsonResult(false, "系统未配置短信接口，请联系系统管理员！");
				}
				if (sendResult.isFlag()) {
					entity.setState(EnumSmsState.成功.getValue());
				} else {
					entity.setState(EnumSmsState.失败.getValue());
				}
				result = smsDao.insertEntity(entity);
			}
		}

		if (result > 0) {
			int model = EnumLogModule.发送短信.getValue();
			if (entity.getType() != null && entity.getType() == 10) {
				model = EnumLogModule.外部通讯录.getValue();
			}

			// 添加操作日志
			systemLogService.create(model, "发送短信", "发送短信：" + entity.getContent());
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
	public JsonResult modify(Sms entity) {
		int result = smsDao.updateEntity(entity);
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
	public JsonResult modifySend_again(int id, String ids) {
		Sms entity = new Sms();
		if (id == 0) {
			entity.getMap().put("ids", ids.split(","));
		} else {
			entity.setId(id);
		}
		List<Sms> list = smsDao.selectEntityList(entity);

		if (list != null) {
			int result = 0;
			SendResult sendResult = null;
			Sms updatingEntity = null;
			for (Sms item : list) {
				updatingEntity = new Sms(item.getId(), true);
				updatingEntity.getMap().put("haddle_retry_count", true);
				sendResult = smsInterface.send(item.getPhone(), item.getContent());
				if (sendResult == null) {
					return new JsonResult(false, "系统未配置短信接口，请联系系统管理员！");
				}
				if (sendResult.isFlag()) {
					updatingEntity.setState(EnumSmsState.成功.getValue());
				} else {
					updatingEntity.setState(EnumSmsState.失败.getValue());
				}
				result = smsDao.updateEntity(updatingEntity);
				if (!sendResult.isFlag() || result < 0) {
					return new JsonResult(false, "发送失败！");
				}
			}
			// 添加操作日志
			systemLogService.create(EnumLogModule.短信管理.getValue(), "重新发送短信", "重新发送短信：" + entity.getContent());
			return new JsonResult(true);
		} else {
			return new JsonResult(false, "发送失败！");
		}
	}

	/**
	 * @Description 根据Id删除
	 * @param id
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult removeById(Integer id) {
		Sms entity = new Sms();
		entity.setId(id);
		int result = smsDao.deleteEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.短信管理.getValue(), "删除短信", "删除短信ID：" + id);
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
		Sms entity = new Sms();
		entity.getMap().put("ids", ids.split(","));
		int result = smsDao.deleteEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.短信管理.getValue(), "批量删除短信", "批量删除短信ID：" + ids);
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
	public JsonResult remove(Sms entity) {
		int result = smsDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
