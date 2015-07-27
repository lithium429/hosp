package com.xz.oa.core.service.meeting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.utils.DateUtil;
import com.xz.base.utils.StringUtil;
import com.xz.oa.core.dao.meeting.MeetingDao;
import com.xz.oa.core.dao.meeting.MeetingFileDao;
import com.xz.oa.core.dao.meeting.MeetingUserDao;
import com.xz.oa.core.dao.meeting.MeetingVerifyRecordDao;
import com.xz.oa.core.dao.notify.NotifyMessageDao;
import com.xz.oa.core.domain.entity.Meeting;
import com.xz.oa.core.domain.entity.MeetingFile;
import com.xz.oa.core.domain.entity.MeetingUser;
import com.xz.oa.core.domain.entity.MeetingVerifyRecord;
import com.xz.oa.core.domain.entity.NotifyMessage;
import com.xz.oa.core.domain.enums.EnumHomeMeetingType;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.domain.enums.EnumMeetingState;
import com.xz.oa.core.domain.enums.EnumNotifyMessageModuleType;
import com.xz.oa.core.domain.enums.EnumVerifyState;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.notify.NotifyEventExecutor;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser; 
import com.xz.oa.sms.service.SmsInterface;

@Service("meetingService")
public class MeetingService {

	@Resource
	private MeetingDao meetingDao;

	@Resource
	private MeetingUserDao meetingUserDao;

	@Resource
	private MeetingFileDao meetingFileDao;

	@Resource
	private MeetingVerifyRecordDao meetingVerifyRecordDao;

	@Resource
	private NotifyMessageDao notifyMessageDao;

	@Resource
	private SystemLogService systemLogService;

	private SmsInterface smsInterface;

	public void setSmsInterface(SmsInterface smsInterface) {
		this.smsInterface = smsInterface;
	}

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Meeting
	 * @author davidwan
	 */
	public Meeting findById(Integer id) {
		Meeting entity = new Meeting();
		entity.setId(id);
		entity.getMap().put("file_sort", true);

		return meetingDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Meeting
	 * @author davidwan
	 */
	public Meeting find(Meeting entity) {
		return meetingDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Meeting>
	 * @author davidwan
	 */
	public List<Meeting> queryList(Meeting entity) {
		return meetingDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Meeting>
	 * @author davidwan
	 */
	public PageInfo<Meeting> queryPageList(Meeting entity, int pageIndex, int pageSize) {
		return meetingDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param userId
	 * @param type
	 * @param pageIndex
	 * @param pageSize
	 *            PageInfo<Meeting>
	 */
	public PageInfo<Meeting> queryHomePageList(Meeting entity, Integer userId, int type, int pageIndex, int pageSize) {
		entity.getMap().put("user_id", userId);
		entity.setVerify_state(EnumVerifyState.审核通过.getValue());
		entity.getMap().put("now_date", new Date());
		if (type == EnumHomeMeetingType.本周.getValue()) {
			entity.getMap().put("this_week", true);
			entity.getMap().put("this_week_start", DateUtil.getThisWeekStart());
			entity.getMap().put("this_week_end", DateUtil.getThisWeekEnd());
		} else if (type == EnumHomeMeetingType.未来七天.getValue()) {
			entity.getMap().put("seven_days", true);
			entity.getMap().put("seven_days_start", DateTime.now().toDate());
			entity.getMap().put("seven_days_end", DateTime.now().plusDays(6).toDate());
		}
		return meetingDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(Meeting entity) {
		entity.setVerify_state(1);
		String msg = this.jusdeDate(entity);
		if (msg != "") {
			return new JsonResult(false, "您输入的会议时间在已存在日期：" + msg);
		}
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		entity.setCreator_id(shiroUser.getId());
		entity.genateStateBydate();
		// 若要获取id，请使用entity.getId();
		int result = meetingDao.insertEntity(entity);

		// 添加参会人员
		int meeting_id = entity.getId();
		MeetingUser u = new MeetingUser();
		if (entity.getUser_ids() != null && !"".equals(entity.getUser_ids())) {
			for (String item : entity.getUser_ids().split(",")) {
				u = new MeetingUser();
				u.setMeeting_id(meeting_id);
				u.setUser_id(Integer.valueOf(item));
				this.meetingUserDao.insertEntity(u);
			}
		}

		// 添加会议附件
		if (entity.getFiles() != null && !entity.getFiles().isEmpty()) {
			for (MeetingFile file : entity.getFiles()) {
				file.setMeeting_id(meeting_id);
				file.setCreate_time(new Date());
				this.meetingFileDao.insertEntity(file);
			}
		}

		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.会议申请.getValue(), "添加会议", "添加会议：" + entity.getSubject());
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
	public JsonResult modify(Meeting entity) {
		int result = meetingDao.updateEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.会议申请.getValue(), "修改会议", "修改会议：" + entity.getSubject());
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
	public JsonResult modifyForCancel(Integer id) {
		Meeting entity = new Meeting(id, EnumMeetingState.已取消.getValue());
		int result = meetingDao.updateEntity(entity);
		if (result > 0) {

			// 添加事务提醒
			NotifyMessage message = new NotifyMessage(EnumNotifyMessageModuleType.会议.getValue());
			message.setRef_id(id);
			NotifyEventExecutor.execute(message);

			return new JsonResult(true);
		} else {
			// 添加操作日志
			systemLogService.create(EnumLogModule.会议申请.getValue(), "取消会议", "取消会议：" + entity.getSubject());
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 修改
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult modifyChange(int id, String ids, boolean is_agree, String content) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		MeetingVerifyRecord a = null;
		String action = "";
		Meeting entity = new Meeting();

		NotifyMessage message = new NotifyMessage(EnumNotifyMessageModuleType.会议.getValue());
		if (is_agree) {
			action = "审核通过";
			entity.setVerify_state(2);
		} else {
			action = "审核不通过";
			entity.setVerify_state(3);
		}
		entity.setVerify_content(content);
		entity.setVerify_time(new Date());
		entity.setVerify_user_id(shiroUser.getId());
		if (id == 0) {
			entity.getMap().put("ids", ids.split(","));
			for (String item : ids.split(",")) {
				a = new MeetingVerifyRecord();
				a.setMeeting_vstate(entity.getVerify_state());
				a.setMeeting_id(Integer.valueOf(item));
				a.setCreate_time(new Date());
				a.setContent(content == null ? "" : content);
				a.setCreator_id(shiroUser.getId());
				meetingVerifyRecordDao.insertEntity(a);
			}
			message.getMap().put("ref_ids", ids);
		} else {
			entity.setId(id);
			a = new MeetingVerifyRecord();
			a.setMeeting_vstate(entity.getVerify_state());
			a.setMeeting_id(id);
			a.setContent(content == null ? "" : content);
			a.setCreate_time(new Date());
			a.setCreator_id(shiroUser.getId());
			meetingVerifyRecordDao.insertEntity(a);
			message.setRef_id(id);
		}
		int result = meetingDao.updateEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.会议审批.getValue(), action + "会议", action + "会议ID：" + (id == 0 ? StringUtil.buildIds((String[]) entity.getMap().get("ids")) : id));
			// 添加事务提醒
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
	public JsonResult modify(Meeting entity, boolean is_edit) {
		String msg = this.jusdeDate(entity);
		if (msg != "") {
			return new JsonResult(false, "您输入的会议时间在已存在日期：" + msg);
		}
		entity.genateStateBydate();
		int result = meetingDao.updateEntity(entity);

		// 添加参会人员
		Integer meeting_id = entity.getId();
		MeetingUser u = new MeetingUser();
		u.setMeeting_id(meeting_id);
		this.meetingUserDao.deleteEntity(u);
		if (entity.getUser_ids() != null && !"".equals(entity.getUser_ids())) {
			for (String item : entity.getUser_ids().split(",")) {
				u = new MeetingUser();
				u.setMeeting_id(meeting_id);
				u.setUser_id(Integer.valueOf(item));
				this.meetingUserDao.insertEntity(u);
			}
		}

		// 添加会议附件
		MeetingFile mf = new MeetingFile(meeting_id);
		this.meetingFileDao.deleteEntity(mf);
		if (entity.getFiles() != null && !entity.getFiles().isEmpty()) {
			for (MeetingFile file : entity.getFiles()) {
				file.setMeeting_id(meeting_id);
				file.setCreate_time(new Date());
				this.meetingFileDao.insertEntity(file);
			}
		}

		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.会议申请.getValue(), "修改会议", "修改会议：" + entity.getSubject());
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
		Meeting entity = new Meeting();
		entity.setId(id);
		int result = meetingDao.deleteEntity(entity);

		// 删除事务提醒
		NotifyMessage message = new NotifyMessage();
		message.setRef_id(id);
		notifyMessageDao.deleteEntity(message);

		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.会议申请.getValue(), "删除会议", "删除会议ID：" + id);
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
		String[] idArray = ids.split(",");
		Meeting entity = new Meeting();
		entity.getMap().put("ids", idArray);
		int result = meetingDao.deleteEntity(entity);

		// 删除事务提醒
		NotifyMessage message = new NotifyMessage();
		message.getMap().put("ref_ids", idArray);
		notifyMessageDao.deleteEntity(message);

		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.会议申请.getValue(), "批量删除会议", "批量删除会议ID：" + ids);
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
	public JsonResult remove(Meeting entity) {
		int result = meetingDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	// 验证主题重名
	public String jusdeDate(Meeting entity) {
		String r = "";
		Integer id = entity.getId();
		if (id == null) {
			id = 0;
		}
		Meeting t = new Meeting();
		t.getMap().put("id", id);
		t.setRoom_id(entity.getRoom_id());
		t.getMap().put("verify_state_not", 3);
		t.getMap().put("judge_date_min", entity.getBegin_time());
		t.getMap().put("judge_date_max", entity.getEnd_time());
		t.getMap().put("judge_date", "true");
		List<Meeting> mList = meetingDao.selectEntityList(t);

		if (mList != null) {
			Date min = null, max = null;
			for (Meeting item : mList) {
				if (entity.getBegin_time().before(item.getBegin_time())) {
					min = item.getBegin_time();
					if (entity.getEnd_time().before(item.getEnd_time())) {
						max = entity.getEnd_time();
					} else {
						max = item.getEnd_time();
					}
				} else {
					min = entity.getBegin_time();
					if (entity.getEnd_time().before(item.getEnd_time())) {
						max = entity.getEnd_time();
					} else {
						max = item.getEnd_time();
					}
				}
				r += "【" + DateUtil.dateToStr(min) + "~" + DateUtil.dateToStr(max) + "】";
			}
		}
		return r;
	}

	// 验证主题重名
	public boolean validateSubject(Integer id, String subject) {
		Meeting t = new Meeting();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("subject", subject);
		t.getMap().put("subject_valid", "true");
		int count = meetingDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @Description 发送会议通知短信
	 */
	public void modifyForSendNotifySMS() {
		Meeting entity = new Meeting(EnumVerifyState.审核通过.getValue(), true, false);
		entity.getMap().put("notify_now", new Date());
		List<Meeting> meetingList = meetingDao.selectEntityList(entity, "ForNotify");
		if (meetingList != null && !meetingList.isEmpty()) {
			String beginTime = null, content = null;
			List<Integer> sendedIds = new ArrayList<Integer>();
			for (Meeting meeting : meetingList) {
				if (meeting.getUsers() != null) {
					beginTime = DateUtil.dateToStr(meeting.getBegin_time(), "yyyy-MM-dd HH:mm");
					content = meeting.getCreator_real_name() + "通知您于" + beginTime + "在" + meeting.getRoom_name() + "开会，会议主题：" + meeting.getSubject();
					for (MeetingUser user : meeting.getUsers()) {
						if (StringUtils.isNotBlank(user.getUser_mobile())) {
							smsInterface.send(user.getUser_mobile(), content);
						} 
						sendedIds.add(meeting.getId());
					}
				}
			}

			if (!sendedIds.isEmpty()) {
				entity = new Meeting(true);
				entity.getMap().put("ids", sendedIds);
				meetingDao.updateEntity(entity);
			}
		}
	}

}
