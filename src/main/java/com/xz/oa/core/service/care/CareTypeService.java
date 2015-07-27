package com.xz.oa.core.service.care;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.care.CareTypeDao;
import com.xz.oa.core.domain.entity.CareType;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

@Service
public class CareTypeService {

	@Resource
	private CareTypeDao careTypeDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return CareType
	 * @author davidwan
	 */
	public CareType findById(Integer id) {
		CareType entity = new CareType();
		entity.setId(id);
		return careTypeDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return CareType
	 * @author davidwan
	 */
	public CareType find(CareType entity) {
		return careTypeDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<CareType>
	 * @author davidwan
	 */
	public List<CareType> queryList(CareType entity) {
		return careTypeDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<CareType>
	 * @author davidwan
	 */
	public PageInfo<CareType> queryPageList(CareType entity, int pageIndex, int pageSize) {
		return careTypeDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(CareType entity) {
		// 若要获取id，请使用entity.getId();
		int result = careTypeDao.insertEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.护理天地.getValue(), "添加护理天地分类","添加护理天地分类：" + entity.getName());
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
	public JsonResult modify(CareType entity) {
		int result = careTypeDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.护理天地.getValue(), "修改护理天地分类","修改护理天地分类：" + entity.getName());
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
		CareType entity = new CareType();
		entity.setId(id);
		int result = careTypeDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.护理天地.getValue(), "删除护理天地分类","删除护理天地分类ID：" + id);
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
		CareType entity = new CareType();
		entity.getMap().put("ids", ids.split(","));
		int result = careTypeDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.护理天地.getValue(), "批量删除护理天地分类","批量删除护理天地分类ID：" + ids);
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
	public JsonResult remove(CareType entity) {
		int result = careTypeDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	// 验证名称重名
	public boolean validateName(Integer id, String name) {
		CareType t = new CareType();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("name_valid", name);
		int count = careTypeDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

	// 验证排序重名
	public boolean validateSort(Integer id, Integer sort) {
		CareType t = new CareType();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("sort_valid", sort);
		int count = careTypeDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}
