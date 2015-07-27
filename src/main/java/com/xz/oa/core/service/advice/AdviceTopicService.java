package com.xz.oa.core.service.advice;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.advice.AdviceTopicDao;
import com.xz.oa.core.domain.entity.AdviceTopic;

@Service
public class AdviceTopicService {

	@Resource
	private AdviceTopicDao adviceTopicDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return AdviceTopic
	 * @author davidwan
	 */
	public AdviceTopic findById(Integer id) {
		AdviceTopic entity = new AdviceTopic();
		entity.setId(id);
		return adviceTopicDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return AdviceTopic
	 * @author davidwan
	 */
	public AdviceTopic find(AdviceTopic entity) {
		return adviceTopicDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<AdviceTopic>
	 * @author davidwan
	 */
	public List<AdviceTopic> queryList(AdviceTopic entity) {
		return adviceTopicDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<AdviceTopic>
	 * @author davidwan
	 */
	public PageInfo<AdviceTopic> queryPageList(AdviceTopic entity, int pageIndex, int pageSize) {
		return adviceTopicDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(AdviceTopic entity) {
		entity.setCreate_time(new Date());
		AdviceTopic t = new AdviceTopic();
		Integer sort = adviceTopicDao.selectEntitySort(t);
		entity.setSort((sort == null ? 0 : sort) + 1);
		// 若要获取id，请使用entity.getId();
		int result = adviceTopicDao.insertEntity(entity);
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
	public JsonResult modify(AdviceTopic entity) {
		int result = adviceTopicDao.updateEntity(entity);
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
		AdviceTopic entity = new AdviceTopic();
		entity.setId(id);
		int result = adviceTopicDao.deleteEntity(entity);
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
		AdviceTopic entity = new AdviceTopic();
		entity.getMap().put("ids", ids.split(","));
		int result = adviceTopicDao.deleteEntity(entity);
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
	public JsonResult remove(AdviceTopic entity) {
		int result = adviceTopicDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	// 验证名称重名
	public boolean validateName(Integer id, String name) {
		AdviceTopic t = new AdviceTopic();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("name", name);
		t.getMap().put("name_valid", "true");
		int count = adviceTopicDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}
