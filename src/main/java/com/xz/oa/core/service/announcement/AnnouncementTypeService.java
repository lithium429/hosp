package com.xz.oa.core.service.announcement;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.announcement.AnnouncementTypeDao;
import com.xz.oa.core.domain.entity.AnnouncementType;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class AnnouncementTypeService {

	@Resource
	private AnnouncementTypeDao announcementTypeDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return AnnouncementType
	 * @author davidwan
	 */
	public AnnouncementType findById(Integer id) {
		AnnouncementType entity = new AnnouncementType();
		entity.setId(id);
		return announcementTypeDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return AnnouncementType
	 * @author davidwan
	 */
	public AnnouncementType find(AnnouncementType entity) {
		return announcementTypeDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<AnnouncementType>
	 * @author davidwan
	 */
	public List<AnnouncementType> queryList(AnnouncementType entity) {
		return announcementTypeDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<AnnouncementType>
	 * @author davidwan
	 */
	public PageInfo<AnnouncementType> queryPageList(AnnouncementType entity, int pageIndex, int pageSize) {
		return announcementTypeDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(AnnouncementType entity) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		AnnouncementType t = new AnnouncementType();
		Integer sort = announcementTypeDao.selectEntitySort(t);
		entity.setSort((sort == null ? 0 : sort) + 1);
		entity.setCreator_id(shiroUser.getId());
		// 若要获取id，请使用entity.getId();
		int result = announcementTypeDao.insertEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.公告类型管理.getValue(), "添加公告类型", "添加公告类型：" + entity.getName());
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
	public JsonResult modify(AnnouncementType entity) {
		int result = announcementTypeDao.updateEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.公告类型管理.getValue(), "修改公告类型", "修改公告类型：" + entity.getName());
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
		AnnouncementType entity = new AnnouncementType();
		entity.setId(id);
		int result = announcementTypeDao.deleteEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.公告类型管理.getValue(), "删除公告类型", "删除公告类型ID：" + id);
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
		AnnouncementType entity = new AnnouncementType();
		entity.getMap().put("ids", ids.split(","));
		int result = announcementTypeDao.deleteEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.公告类型管理.getValue(), "批量删除公告类型", "批量删除公告类型ID：" + ids);
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
	public JsonResult remove(AnnouncementType entity) {
		int result = announcementTypeDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	// 验证名称重名
	public boolean validateName(Integer id, String name) {
		AnnouncementType t = new AnnouncementType();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("name", name);
		t.getMap().put("name_valid", "true");
		int count = announcementTypeDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}
