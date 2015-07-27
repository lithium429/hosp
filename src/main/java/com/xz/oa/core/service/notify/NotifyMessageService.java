package com.xz.oa.core.service.notify;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.notify.NotifyMessageDao;
import com.xz.oa.core.domain.entity.NotifyMessage;

@Service("notifyService")
public class NotifyMessageService {

	@Resource
	private NotifyMessageDao notifyMessageDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return NotifyMessage
	 * @author davidwan
	 */
	public NotifyMessage findById(Integer id) {
		NotifyMessage entity = new NotifyMessage();
		entity.setId(id);
		return notifyMessageDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return NotifyMessage
	 * @author davidwan
	 */
	public NotifyMessage find(NotifyMessage entity) {
		return notifyMessageDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<NotifyMessage>
	 * @author davidwan
	 */
	public List<NotifyMessage> queryList(NotifyMessage entity) {
		return notifyMessageDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<NotifyMessage>
	 * @author davidwan
	 */
	public Map<Integer, List<NotifyMessage>> modifyAndQueryMapList(NotifyMessage entity) {
		List<NotifyMessage> list = notifyMessageDao.selectEntityList(entity);
		if (list != null && !list.isEmpty()) {
			NotifyMessage param = new NotifyMessage();
			param.setIs_query(true);

			List<Integer> idList = new ArrayList<Integer>();
			for (NotifyMessage item : list) {
				idList.add(item.getId());
			}
			param.getMap().put("ids", idList.toArray());
			notifyMessageDao.updateEntity(param);
		}

		return entity.groupByModuleType(list);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<NotifyMessage>
	 * @author davidwan
	 */
	public PageInfo<NotifyMessage> queryPageList(NotifyMessage entity, int pageIndex, int pageSize) {
		return notifyMessageDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(NotifyMessage entity) {
		// 若要获取id，请使用entity.getId();
		int result = notifyMessageDao.insertEntity(entity);
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
	public JsonResult modify(NotifyMessage entity) {
		int result = notifyMessageDao.updateEntity(entity);
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
		NotifyMessage entity = new NotifyMessage();
		entity.setId(id);
		int result = notifyMessageDao.deleteEntity(entity);
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
		NotifyMessage entity = new NotifyMessage();
		entity.getMap().put("ids", ids.split(","));
		int result = notifyMessageDao.deleteEntity(entity);
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
	public JsonResult remove(NotifyMessage entity) {
		int result = notifyMessageDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
