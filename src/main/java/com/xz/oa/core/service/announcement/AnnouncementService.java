package com.xz.oa.core.service.announcement;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.announcement.AnnouncementDao;
import com.xz.oa.core.dao.announcement.AnnouncementDeptDao;
import com.xz.oa.core.dao.announcement.AnnouncementFileDao;
import com.xz.oa.core.domain.entity.Announcement;
import com.xz.oa.core.domain.entity.AnnouncementDept;
import com.xz.oa.core.domain.entity.AnnouncementFile;
import com.xz.oa.core.domain.enums.EnumAnnouncementState;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class AnnouncementService {

	@Resource
	private AnnouncementDao announcementDao;

	@Resource
	private AnnouncementDeptDao announcementDeptDao;
	@Resource
	private SystemLogService systemLogService;

	@Resource
	private AnnouncementFileDao announcementFileDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Announcement
	 * @author davidwan
	 */
	public Announcement findById(Integer id) {
		Announcement entity = new Announcement();
		entity.setId(id);
		return announcementDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Announcement
	 * @author davidwan
	 */
	public Announcement find(Announcement entity) {
		return announcementDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Announcement>
	 * @author davidwan
	 */
	public List<Announcement> queryList(Announcement entity) {
		return announcementDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取最大排序值
	 * @param entity
	 * @return List<Announcement>
	 * @author davidwan
	 */
	public int getSort(Announcement entity) {
		Integer sort = announcementDao.selectEntitySort(entity);
		return sort == null ? 0 : sort;
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Announcement>
	 * @author davidwan
	 */
	public PageInfo<Announcement> queryPageList(Announcement entity, int pageIndex, int pageSize) {
		return announcementDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Announcement>
	 * @author davidwan
	 */
	public PageInfo<Announcement> queryHomePageList(Announcement entity, int pageIndex, int pageSize) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();

		entity.getMap().put("dept_ids", new Integer[] { shiroUser.getDept_id() });
		entity.getMap().put("state", EnumAnnouncementState.生效.getValue());
		entity.getMap().put("now_date", new Date());
		entity.getMap().put("sort_order_desc", true);
		return announcementDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(Announcement entity) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		Announcement t = new Announcement();
		Integer sort = announcementDao.selectEntitySort(t);
		entity.setSort((sort == null ? 0 : sort) + 1);
		entity.setCreator_id(shiroUser.getId());
		if (entity.getValid_date() == null) {
			entity.setValid_date(new Date());
		}
		// 若要获取id，请使用entity.getId();
		int result = announcementDao.insertEntity(entity);
		int announcement_id = entity.getId();
		// 部门范围
		if (entity.getDept_ids() != null && entity.getDept_ids() != "" && !entity.getIs_show_all()) {
			AnnouncementDept u = null;
			for (String item : entity.getDept_ids().split(",")) {
				u = new AnnouncementDept();
				u.setAnnouncement_id(announcement_id);
				u.setDept_id(Integer.valueOf(item));
				announcementDeptDao.insertEntity(u);
			}
		}

		// 添加公告附件
		if (entity.getFiles() != null && !entity.getFiles().isEmpty()) {
			for (AnnouncementFile file : entity.getFiles()) {
				file.setAnnouncement_id(announcement_id);
				file.setCreate_time(new Date());
				this.announcementFileDao.insertEntity(file);
			}
		}
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.公告管理.getValue(), "添加公告", "添加公告：" + entity.getTitle());
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
	public JsonResult modify(Announcement entity) {

		int result = announcementDao.updateEntity(entity);
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
	public JsonResult modify(Announcement entity, boolean is_show) {
		int announcement_id = entity.getId();
		if (entity.getValid_date() == null) {
			entity.setValid_date(new Date());
		}
		if (entity.getEnd_date() == null) {
			entity.getMap().put("end_date_null", true);
		}
		AnnouncementDept u = new AnnouncementDept();
		u.setAnnouncement_id(announcement_id);
		announcementDeptDao.deleteEntity(u);
		// 部门范围
		if (entity.getDept_ids() != null && entity.getDept_ids() != "" && !entity.getIs_show_all()) {

			for (String item : entity.getDept_ids().split(",")) {
				u = new AnnouncementDept();
				u.setAnnouncement_id(announcement_id);
				u.setDept_id(Integer.valueOf(item));
				announcementDeptDao.insertEntity(u);
			}
		}
		int result = announcementDao.updateEntity(entity);

		// 添加公告附件
		AnnouncementFile af = new AnnouncementFile();
		af.setAnnouncement_id(entity.getId());
		this.announcementFileDao.deleteEntity(af);
		if (entity.getFiles() != null && !entity.getFiles().isEmpty()) {
			for (AnnouncementFile file : entity.getFiles()) {
				file.setAnnouncement_id(entity.getId());
				file.setCreate_time(new Date());
				this.announcementFileDao.insertEntity(file);
			}
		}
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.公告管理.getValue(), "修改公告", "修改公告：" + entity.getTitle());

			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 修改 (生效，终止)
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult modify(Integer id, String ids, boolean is_stop) {
		Announcement entity = new Announcement();
		if (id == null) {
			entity.getMap().put("ids", ids.split(","));
		} else {
			entity.setId(id);
		}
		if (is_stop) {
			entity.setEnd_date(new Date());
		} else {
			entity.setValid_date(new Date());
		}
		int result = announcementDao.updateEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.公告管理.getValue(), is_stop ? "终止公告" : "生效公告", (is_stop ? "终止" : "生效") + "公告ID：" + (id == null ? ids : id));
			return new JsonResult(true, is_stop ? "终止成功" : "生效成功");
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
		Announcement a = new Announcement();
		int midSort = -1, result = 0;
		if (toSort == null) {
			if (is_up) {
				a.getMap().put("sort_min", sort);
				a.getMap().put("sort_order_asc", true);
			} else {
				a.getMap().put("sort_max", sort);
				a.getMap().put("sort_order_desc", true);
			}
			a = announcementDao.selectEntity(a, "ToSort");
			if (a != null) {
				toSort = a.getSort();
			} else {
				return new JsonResult(true, "公告排序成功！");
			}
			a = new Announcement();
			a.setSort(midSort);
			a.getMap().put("sort", sort);
			result = announcementDao.updateEntity(a);
			a = new Announcement();
			a.setSort(sort);
			a.getMap().put("sort", toSort);
			result = announcementDao.updateEntity(a);
			a = new Announcement();
			a.setSort(toSort);
			a.getMap().put("sort", midSort);
			result = announcementDao.updateEntity(a);
		} else {
			a = new Announcement();
			a.setSort(toSort + 1);
			a.getMap().put("sort", sort);
			result = announcementDao.updateEntity(a);
		}

		if (result > 0) {
			return new JsonResult(true, "公告排序成功");
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
		Announcement entity = new Announcement();
		entity.setId(id);
		int result = announcementDao.deleteEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.公告管理.getValue(), "删除公告", "删除公告ID：" + id);
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
		Announcement entity = new Announcement();
		entity.getMap().put("ids", ids.split(","));
		int result = announcementDao.deleteEntity(entity);
		if (result > 0) {
			// 添加操作日志
			systemLogService.create(EnumLogModule.公告管理.getValue(), "批量删除公告", "批量删除公告ID：" + ids);
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
	public JsonResult remove(Announcement entity) {
		int result = announcementDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	// 验证名称重名
	public boolean validateTitle(Integer id, String title) {
		Announcement t = new Announcement();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("title", title);
		t.getMap().put("title_valid", "true");
		int count = announcementDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}
