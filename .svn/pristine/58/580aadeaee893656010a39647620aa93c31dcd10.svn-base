package com.xz.oa.core.service.publicitycolumn;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.publicitycolumn.PublicityColumnDao;
import com.xz.oa.core.dao.publicitycolumn.PublicityColumnFileDao;
import com.xz.oa.core.domain.entity.PublicityColumn;
import com.xz.oa.core.domain.entity.PublicityColumnFile;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

@Service
public class PublicityColumnService {

	@Resource
	private PublicityColumnDao publicityColumnDao;

	@Resource
	private SystemLogService systemLogService;

	@Resource
	private PublicityColumnFileDao publicityColumnFileDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return PublicityColumn
	 * @author davidwan
	 */
	public PublicityColumn findById(Integer id) {
		PublicityColumn entity = new PublicityColumn();
		entity.setId(id);
		return publicityColumnDao.selectEntity(entity);
	}

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return PublicityColumn
	 * @author davidwan
	 */
	public PublicityColumnFile findFileById(Integer id) {
		PublicityColumnFile entity = new PublicityColumnFile();
		entity.setId(id);
		return publicityColumnFileDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return PublicityColumn
	 * @author davidwan
	 */
	public PublicityColumn find(PublicityColumn entity) {
		return publicityColumnDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<PublicityColumn>
	 * @author davidwan
	 */
	public List<PublicityColumn> queryList(PublicityColumn entity) {
		return publicityColumnDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<PublicityColumn>
	 * @author davidwan
	 */
	public PageInfo<PublicityColumn> queryPageList(PublicityColumn entity, int pageIndex, int pageSize) {
		return publicityColumnDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 根据条件获取最大排序值
	 * @return int
	 */
	public int gainSort() {
		Integer sort = publicityColumnDao.selectEntitySort(new PublicityColumn());
		return sort == null ? 0 : sort;
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(PublicityColumn entity) {
		// 若要获取id，请使用entity.getId();
		Integer sort = publicityColumnDao.selectEntitySort(new PublicityColumn());
		entity.setSort((sort == null ? 0 : sort) + 1);
		int result = publicityColumnDao.insertEntity(entity);

		// 添加附件
		List<PublicityColumnFile> files = entity.getFiles();
		if (files != null && !files.isEmpty()) {
			int pcId = entity.getId();
			for (PublicityColumnFile file : files) {
				file.setPc_id(pcId);
				file.setCreate_time(new Date());
				this.publicityColumnFileDao.insertEntity(file);
			}
		}
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.公示栏管理.getValue(), "添加公示栏", "添加公示栏：" + entity.getTitle());
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
	public JsonResult modify(PublicityColumn entity) {
		int result = publicityColumnDao.updateEntity(entity);

		// 删除附件
		PublicityColumnFile fileEntity = new PublicityColumnFile(entity.getId());
		this.publicityColumnFileDao.deleteEntity(fileEntity);

		// 添加附件
		List<PublicityColumnFile> files = entity.getFiles();
		if (files != null && !files.isEmpty()) {
			int pcId = entity.getId();
			for (PublicityColumnFile file : files) {
				file.setPc_id(pcId);
				file.setCreate_time(new Date());
				this.publicityColumnFileDao.insertEntity(file);
			}
		}
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.公示栏管理.getValue(), "修改公示栏", "修改公示栏：" + entity.getTitle());
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 修改 （排序）
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult modifyMove(int sort, boolean is_up, Integer toSort) {
		PublicityColumn column = new PublicityColumn();
		int midSort = -1, result = 0;
		if (toSort == null) {
			if (is_up) {
				column.getMap().put("sort_min", sort);
				column.getMap().put("sort_order_asc", true);
			} else {
				column.getMap().put("sort_max", sort);
				column.getMap().put("sort_order_desc", true);
			}
			column = publicityColumnDao.selectEntity(column, "ToSort");
			if (column != null) {
				toSort = column.getSort();
			} else {
				return new JsonResult(true, "公示栏排序成功！");
			}
			column = new PublicityColumn();
			column.setSort(midSort);
			column.getMap().put("sort", sort);
			result = publicityColumnDao.updateEntity(column);
			column = new PublicityColumn();
			column.setSort(sort);
			column.getMap().put("sort", toSort);
			result = publicityColumnDao.updateEntity(column);
			column = new PublicityColumn();
			column.setSort(toSort);
			column.getMap().put("sort", midSort);
			result = publicityColumnDao.updateEntity(column);
		} else {
			column = new PublicityColumn();
			column.setSort(toSort + 1);
			column.getMap().put("sort", sort);
			result = publicityColumnDao.updateEntity(column);
		}
		if (result > 0) {
			return new JsonResult(true, "公示栏排序成功");
		} else {
			return new JsonResult(false);
		}
	}

	// 验证名称重名
	public boolean validateTitle(Integer id, String title) {
		PublicityColumn column = new PublicityColumn();
		if (id == null) {
			id = 0;
		}
		column.getMap().put("id", id);
		column.getMap().put("title", title);
		column.getMap().put("title_valid", "true");
		int count = publicityColumnDao.selectEntityCount(column);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @Description 根据Id删除
	 * @param id
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult removeById(Integer id) {
		PublicityColumn entity = new PublicityColumn();
		entity.setId(id);
		int result = publicityColumnDao.deleteEntity(entity);
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
		PublicityColumn entity = new PublicityColumn();
		entity.getMap().put("ids", ids.split(","));
		int result = publicityColumnDao.deleteEntity(entity);
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
	public JsonResult remove(PublicityColumn entity) {
		int result = publicityColumnDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
