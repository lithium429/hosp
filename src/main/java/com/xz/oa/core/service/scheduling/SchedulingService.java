package com.xz.oa.core.service.scheduling;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.notify.NotifyMessageDao;
import com.xz.oa.core.dao.scheduling.SchedulingDao;
import com.xz.oa.core.dao.scheduling.SchedulingUserDao;
import com.xz.oa.core.domain.entity.NotifyMessage;
import com.xz.oa.core.domain.entity.Scheduling;
import com.xz.oa.core.domain.entity.SchedulingTime;
import com.xz.oa.core.domain.entity.SchedulingUser;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.domain.enums.EnumNotifyMessageModuleType;
import com.xz.oa.core.domain.enums.EnumNotifyMessageType;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.notify.NotifyEventExecutor;

@Service
public class SchedulingService {

	@Resource
	private SchedulingDao schedulingDao;

	@Resource
	private SchedulingUserDao schedulingUserDao;

	@Resource
	private NotifyMessageDao notifyMessageDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Scheduling
	 * @author davidwan
	 */
	public Scheduling findById(Integer id) {
		Scheduling entity = new Scheduling();
		entity.setId(id);
		return schedulingDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Scheduling
	 * @author davidwan
	 */
	public Scheduling find(Scheduling entity) {
		return schedulingDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Scheduling>
	 * @author davidwan
	 */
	public List<Scheduling> queryList(Scheduling entity) {
		return schedulingDao.selectEntityList(entity);
	}

	/**
	 * @Description 获取当日值班表
	 * @param entity
	 * @return Map<String, List<Scheduling>>
	 * @author davidwan
	 */
	public Map<String, List<Scheduling>> queryHomeMap(Scheduling entity) {
		DateTime now = DateTime.now();
		entity.setYear(now.getYear());
		entity.setMonth((byte) now.getMonthOfYear());
		entity.setDay((byte) now.getDayOfMonth());
		List<Scheduling> list = schedulingDao.selectEntityList(entity);
		Map<String, List<Scheduling>> map = entity.groupByDept(list);
		return map;
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Scheduling>
	 * @author davidwan
	 */
	public PageInfo<Scheduling> queryPageList(Scheduling entity, int pageIndex, int pageSize) {
		return schedulingDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult createOrModify(Scheduling entity, boolean is_all) {
		int result = 0;
		if (entity.getList() != null) {
			SchedulingUser schedulingUser = null;
			NotifyMessage message = null;
			for (Scheduling scheduling : entity.getList()) {
				if (scheduling.getId() == null) {
					scheduling.setCreate_time(new Date());
					schedulingDao.insertEntity(scheduling);
				} else {
					schedulingDao.updateEntity(scheduling);
				}
				if (scheduling.getUsers() != null) {
					schedulingUser = new SchedulingUser(scheduling.getId());
					schedulingUserDao.deleteEntity(schedulingUser);

					message = new NotifyMessage(EnumNotifyMessageModuleType.值班.getValue(), scheduling.getId());
					notifyMessageDao.deleteEntity(message);
					for (SchedulingUser user : scheduling.getUsers()) {

						user.setScheduling_id(scheduling.getId());
						schedulingUserDao.insertEntity(user);

						// 添加事务提醒
						message = new NotifyMessage(null, user.getUser_id(), EnumNotifyMessageType.系统.getValue(), scheduling);
						NotifyEventExecutor.execute(message);
					}
				}

				result++;
			}
		}
		if (result > 0) {
			int model = EnumLogModule.科室排班.getValue();
			String action = "科室排班";
			if (is_all) {
				model = EnumLogModule.总排班表.getValue();
				action = "总排班表";
			}
			// 添加操作日志
			systemLogService.create(model, "设置" + action, "设置" + action + "：" + entity.getYear() + "-" + entity.getMonth());
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
	public JsonResult modify(Scheduling entity) {
		int result = schedulingDao.updateEntity(entity);
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
		Scheduling entity = new Scheduling();
		entity.setId(id);
		int result = schedulingDao.deleteEntity(entity);
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
		Scheduling entity = new Scheduling();
		entity.getMap().put("ids", ids.split(","));
		int result = schedulingDao.deleteEntity(entity);
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
	public JsonResult remove(Scheduling entity) {
		int result = schedulingDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 根据条件获取id
	 * @param year
	 * @param month
	 * @param day
	 * @param startTime
	 * @param endTime
	 * @param list
	 * @return Integer
	 */
	public static Integer gainSchedulingId(Integer year, Byte month, Byte day, Date startTime, Date endTime, List<Scheduling> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		Integer id = null;
		for (Scheduling item : list) {
			if (item.getYear().equals(year) && item.getMonth().equals(month) && item.getDay().equals(day) && item.getStart_time().equals(startTime) && item.getEnd_time().equals(endTime)) {
				id = item.getId();
				break;
			}
		}
		return id;
	}

	/**
	 * @Description 根据排班id获取值班人员
	 * @param id
	 * @param list
	 * @return List<SchedulingUser>
	 */
	public static List<SchedulingUser> gainSchedulingUsers(Integer id, List<Scheduling> list) {
		if (list == null || list.isEmpty()) {
			return null;
		}
		List<SchedulingUser> users = null;
		for (Scheduling item : list) {
			if (item.getId().equals(id)) {
				users = item.getUsers();
				break;
			}
		}
		return users;
	}

	/**
	 * @Description 获取时间段
	 * @param year
	 * @param month
	 * @param day
	 * @param initList
	 * @param list
	 * @return List<SchedulingTime>
	 */
	public static List<SchedulingTime> gainTimeList(Integer year, Byte month, Byte day, List<SchedulingTime> initList, List<Scheduling> list) {
		if (list == null || list.isEmpty()) {
			return initList;
		}
		List<SchedulingTime> timeList = new ArrayList<SchedulingTime>();
		SchedulingTime schedulingTime = null;
		for (Scheduling item : list) {
			if (year.equals(item.getYear()) && month.equals(item.getMonth()) && day.equals(item.getDay())) {
				schedulingTime = new SchedulingTime(item.getStart_time(), item.getEnd_time());
				timeList.add(schedulingTime);
			}
		}
		if (timeList.isEmpty()) {
			return initList;
		}
		return timeList;
	}
}
