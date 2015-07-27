package com.xz.oa.core.service.scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.google.common.base.Joiner;
import com.xz.base.model.JsonResult;
import com.xz.base.utils.DateUtil;
import com.xz.oa.core.dao.scheduling.SchedulingTimeDao;
import com.xz.oa.core.domain.entity.SchedulingTime;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

@Service
public class SchedulingTimeService {

	@Resource
	private SchedulingTimeDao schedulingTimeDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<SchedulingTime>
	 * @author davidwan
	 */
	public List<SchedulingTime> queryList(SchedulingTime entity) {
		return schedulingTimeDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<SchedulingTime>
	 * @author davidwan
	 */
	public Map<Byte, List<SchedulingTime>> queryListByGroup(SchedulingTime entity) {
		List<SchedulingTime> list = schedulingTimeDao.selectEntityList(entity);
		return entity.groupListByType(list);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(SchedulingTime entity) {
		// 若要获取id，请使用entity.getId();
		int result = schedulingTimeDao.deleteEntity(new SchedulingTime());
		List<String> contentList = new ArrayList<String>();
		if (entity != null && entity.getList() != null) {
			for (SchedulingTime item : entity.getList()) {
				result = schedulingTimeDao.insertEntity(item);
				contentList.add(DateUtil.dateToStr(item.getStart_time()) + "-" + DateUtil.dateToStr(item.getEnd_time()));
			}
		}
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.排班时间段管理.getValue(), "添加时间段", "添加时间段：" + Joiner.on(';').join(contentList));
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
	public JsonResult modify(SchedulingTime entity) {
		int result = schedulingTimeDao.updateEntity(entity);
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
		SchedulingTime entity = new SchedulingTime();
		entity.setId(id);
		int result = schedulingTimeDao.deleteEntity(entity);
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
		SchedulingTime entity = new SchedulingTime();
		entity.getMap().put("ids", ids.split(","));
		int result = schedulingTimeDao.deleteEntity(entity);
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
	public JsonResult remove(SchedulingTime entity) {
		int result = schedulingTimeDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
