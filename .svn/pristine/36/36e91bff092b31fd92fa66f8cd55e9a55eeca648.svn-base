package com.xz.oa.core.service.staff;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.staff.StaffContractDao;
import com.xz.oa.core.dao.staff.StaffContractFileDao;
import com.xz.oa.core.domain.entity.StaffContractFile;
import com.xz.oa.core.domain.entity.StaffContract;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

@Service
public class StaffContractService {

	@Resource
	private StaffContractDao staffContractDao;

	@Resource
	private StaffContractFileDao staffContractFileDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return StaffContract
	 * @author davidwan
	 */
	public StaffContract findById(Integer id) {
		StaffContract entity = new StaffContract();
		entity.setId(id);
		return staffContractDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return StaffContract
	 * @author davidwan
	 */
	public StaffContract find(StaffContract entity) {
		return staffContractDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<StaffContract>
	 * @author davidwan
	 */
	public List<StaffContract> queryList(StaffContract entity) {
		return staffContractDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<StaffContract>
	 * @author davidwan
	 */
	public PageInfo<StaffContract> queryPageList(StaffContract entity, int pageIndex, int pageSize) {
		return staffContractDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(StaffContract entity) {
		entity.setCreate_time(new Date());
		// 若要获取id，请使用entity.getId();
		int result = staffContractDao.insertEntity(entity);
		int contract_id = entity.getId();
		// 添加附件
		if (entity.getFiles() != null && !entity.getFiles().isEmpty()) {
			for (StaffContractFile file : entity.getFiles()) {
				file.setContract_id(contract_id);
				file.setCreate_time(new Date());
				this.staffContractFileDao.insertEntity(file);
			}
		}
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.人事合同.getValue(), "添加人事合同","添加人事合同：" + entity.getCode());
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
	public JsonResult modify(StaffContract entity) {
		int result = staffContractDao.updateEntity(entity);
		int contract_id = entity.getId();
		StaffContractFile s = new StaffContractFile();
		s.setContract_id(contract_id);
		this.staffContractFileDao.deleteEntity(s);
		// 添加附件
		if (entity.getFiles() != null && !entity.getFiles().isEmpty()) {
			for (StaffContractFile file : entity.getFiles()) {
				file.setContract_id(contract_id);
				file.setCreate_time(new Date());
				this.staffContractFileDao.insertEntity(file);
			}
		}
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.人事合同.getValue(), "修改人事合同","修改人事合同：" + entity.getCode());
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
		StaffContract entity = new StaffContract();
		entity.setId(id);
		int result = staffContractDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.人事合同.getValue(), "删除人事合同","删除人事合同ID：" + id);
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
		StaffContract entity = new StaffContract();
		entity.getMap().put("ids", ids.split(","));
		int result = staffContractDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.人事合同.getValue(), "批量删除人事合同","批量删除人事合同ID：" + ids);
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
	public JsonResult remove(StaffContract entity) {
		int result = staffContractDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	// 验证工号重名
	public boolean validateCode(Integer id, String code) {
		StaffContract t = new StaffContract();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("code_valid", code);
		int count = staffContractDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}
