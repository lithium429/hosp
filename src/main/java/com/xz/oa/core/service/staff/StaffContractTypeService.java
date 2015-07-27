package com.xz.oa.core.service.staff;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.staff.StaffContractTypeDao;
import com.xz.oa.core.domain.entity.StaffContractType;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

@Service
public class StaffContractTypeService {

	@Resource
	private StaffContractTypeDao staffContractTypeDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return StaffContractType
	 * @author davidwan
	 */
	public StaffContractType findById(Integer id) {
		StaffContractType entity = new StaffContractType();
		entity.setId(id);
		return staffContractTypeDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return StaffContractType
	 * @author davidwan
	 */
	public StaffContractType find(StaffContractType entity) {
		return staffContractTypeDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<StaffContractType>
	 * @author davidwan
	 */
	public List<StaffContractType> queryList(StaffContractType entity) {
		return staffContractTypeDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<StaffContractType>
	 * @author davidwan
	 */
	public PageInfo<StaffContractType> queryPageList(StaffContractType entity, int pageIndex, int pageSize) {
		return staffContractTypeDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(StaffContractType entity) {
		StaffContractType t = new StaffContractType();
		Integer sort = staffContractTypeDao.selectEntitySort(t);
		entity.setSort((sort == null ? 0 : sort) + 1);
		// 若要获取id，请使用entity.getId();
		int result = staffContractTypeDao.insertEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.合同类型.getValue(), "添加合同类型","添加合同类型：" + entity.getName());
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
	public JsonResult modify(StaffContractType entity) {
		int result = staffContractTypeDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.合同类型.getValue(), "添加合同类型","添加合同类型：" + entity.getName());
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
		StaffContractType entity = new StaffContractType();
		entity.setId(id);
		int result = staffContractTypeDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.合同类型.getValue(), "删除合同类型","删除合同类型ID：" + id);
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
		StaffContractType entity = new StaffContractType();
		entity.getMap().put("ids", ids.split(","));
		int result = staffContractTypeDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.合同类型.getValue(), "批量删除合同类型","批量删除合同类型ID：" + ids);
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
	public JsonResult remove(StaffContractType entity) {
		int result = staffContractTypeDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	// 验证名称重名
	public boolean validateName(Integer id, String name) {
		StaffContractType t = new StaffContractType();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("name_valid", name);
		int count = staffContractTypeDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}
