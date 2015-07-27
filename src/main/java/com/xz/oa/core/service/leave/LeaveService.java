package com.xz.oa.core.service.leave;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.leave.LeaveDao;
import com.xz.oa.core.dao.leave.LeaveVerifyRecordDao;
import com.xz.oa.core.domain.entity.Leave;
import com.xz.oa.core.domain.entity.LeaveVerifyRecord;
import com.xz.oa.core.domain.entity.NotifyMessage;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.domain.enums.EnumNotifyMessageType;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.notify.NotifyEventExecutor;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class LeaveService {

	@Resource
	private LeaveDao leaveDao;

	@Resource
	private LeaveVerifyRecordDao leaveVerifyRecordDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Leave
	 * @author davidwan
	 */
	public Leave findById(Integer id) {
		Leave entity = new Leave();
		entity.setId(id);
		return leaveDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Leave
	 * @author davidwan
	 */
	public Leave find(Leave entity) {
		return leaveDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Leave>
	 * @author davidwan
	 */
	public List<Leave> queryList(Leave entity) {
		return leaveDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Leave>
	 * @author davidwan
	 */
	public PageInfo<Leave> queryPageList(Leave entity, int pageIndex, int pageSize) {
		return leaveDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(Leave entity) {
		entity.setVerify_state(1);
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		entity.setCreator_id(shiroUser.getId());
		// 若要获取id，请使用entity.getId();
		int result = leaveDao.insertEntity(entity);
		if (result > 0) {
			// 添加事务提醒
			NotifyMessage message = new NotifyMessage(null, entity.getVerify_user_id(), EnumNotifyMessageType.系统.getValue(), entity);
			NotifyEventExecutor.execute(message);
			
			// 添加操作日志
			systemLogService.create(EnumLogModule.请假登记.getValue(), "添加请假登记", "添加请假登记：" + entity.getStaff_name());
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
	public JsonResult modify(Leave entity) {
		int result = leaveDao.updateEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.请假登记.getValue(), "修改请假登记", "修改请假登记：" + entity.getStaff_name());
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
		Leave entity = new Leave();
		entity.setId(id);
		int result = leaveDao.deleteEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.请假登记.getValue(), "删除请假登记", "删除请假登记ID：" + id);
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
		Leave entity = new Leave();
		entity.getMap().put("ids", ids.split(","));
		int result = leaveDao.deleteEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.请假登记.getValue(), "批量删除请假登记", "批量删除请假登记ID：" + ids);
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
	public JsonResult remove(Leave entity) {
		int result = leaveDao.deleteEntity(entity);
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
	public JsonResult modifyChange(int id, String ids, int state, String content) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		LeaveVerifyRecord a = null;
		Leave entity = new Leave();

		entity.setVerify_state(state);
		entity.setVerify_content(content);
		entity.setVerify_time(new Date());

		if (id == 0) {
			entity.getMap().put("ids", ids.split(","));
			for (String item : ids.split(",")) {
				a = new LeaveVerifyRecord();
				a.setLeave_vstate(entity.getVerify_state());
				a.setLeave_id(Integer.valueOf(item));
				a.setCreate_time(new Date());
				a.setContent(content == null ? "" : content);
				a.setCreator_id(shiroUser.getId());
				leaveVerifyRecordDao.insertEntity(a);
			}
		} else {
			entity.setId(id);
			a = new LeaveVerifyRecord();
			a.setLeave_vstate(entity.getVerify_state());
			a.setLeave_id(id);
			a.setContent(content == null ? "" : content);
			a.setCreate_time(new Date());
			a.setCreator_id(shiroUser.getId());
			leaveVerifyRecordDao.insertEntity(a);

		}
		int result = leaveDao.updateEntity(entity);
		if (result > 0) {
			String action = "审批通过";
			if (state == 3) {
				action = "审批不通过";
			}
			// 添加操作日志
			systemLogService.create(EnumLogModule.请假审批.getValue(), action + "请假登记", action + "请假登记ID：" + (id == 0 ? ids : id));
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
