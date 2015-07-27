package com.xz.oa.core.service.care;

import java.util.Date; 
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.care.CareDao;
import com.xz.oa.core.dao.care.CareFileDao;
import com.xz.oa.core.domain.entity.Care;
import com.xz.oa.core.domain.entity.CareFile;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class CareService {

	@Resource
	private CareDao careDao;

	@Resource
	private CareFileDao careFileDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Care
	 * @author davidwan
	 */
	public Care findById(Integer id) {
		Care entity = new Care();
		entity.setId(id);
		return careDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Care
	 * @author davidwan
	 */
	public Care find(Care entity) {
		return careDao.selectEntity(entity);
	}
	
	/**
	 * @Description 获取当前数据的上一条 
	 * @param id
	 * @param typeId
	 * @return Care     
	 */
	public Care findPrevByCurrentId(Integer id, Integer typeId){
		Care entity = new Care(typeId);
		entity.getMap().put("prev", true);
		entity.getMap().put("id", id);
		entity.getMap().put("sort_asc", true);
		return careDao.selectEntity(entity, "ForPrev");
	}
	
	/**
	 * @Description 获取当前数据的下一条 
	 * @param id
	 * @param typeId
	 * @return Care     
	 */
	public Care findNextByCurrentId(Integer id, Integer typeId){
		Care entity = new Care(typeId);
		entity.getMap().put("next", true);
		entity.getMap().put("id", id);
		entity.getMap().put("sort", true);
		return careDao.selectEntity(entity, "ForNext");
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Care>
	 * @author davidwan
	 */
	public List<Care> queryList(Care entity) {
		return careDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Care>
	 * @author davidwan
	 */
	public PageInfo<Care> queryPageList(Care entity, int pageIndex, int pageSize) {
		return careDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 获取首页分类列表
	 * @return Map<Integer,List<Care>>
	 */
	public Map<Integer, List<Care>> queryHomeList() {
		Care entity = new Care();
		List<Care> list = careDao.selectEntityList(entity, "ForHome");
		Map<Integer, List<Care>> map = entity.groupListByType(list);
		return map;
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(Care entity) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		entity.setCreator_id(shiroUser.getId());
		// 若要获取id，请使用entity.getId();
		int result = careDao.insertEntity(entity);
		// 护理ID
		int care_id = entity.getId();

		// 添加护理天地附件
		if (entity.getFiles() != null && !entity.getFiles().isEmpty()) {
			for (CareFile file : entity.getFiles()) {
				file.setCare_id(care_id);
				file.setCreate_time(new Date());
				this.careFileDao.insertEntity(file);
			}
		}

		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.护理天地.getValue(), "添加护理天地","添加护理天地：" + entity.getTitle());
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
	public JsonResult modify(Care entity) {
		if (entity.getBrowse_count() == null) {
			entity.getMap().put("null_browse_count", true);
		}
		int result = careDao.updateEntity(entity);
		// 护理ID
		Integer care_id = entity.getId();

		// 添加护理天地附件
		// 添加会议附件
		CareFile mf = new CareFile(care_id);
		this.careFileDao.deleteEntity(mf);
		if (entity.getFiles() != null && !entity.getFiles().isEmpty()) {
			for (CareFile file : entity.getFiles()) {
				file.setCare_id(care_id);
				file.setCreate_time(new Date());
				this.careFileDao.insertEntity(file);
			}
		}
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.护理天地.getValue(), "修改护理天地","修改护理天地：" + entity.getTitle());
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
		Care entity = new Care();
		entity.setId(id);
		int result = careDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.护理天地.getValue(), "删除护理天地","删除护理天地ID：" + id);
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
		Care entity = new Care();
		entity.getMap().put("ids", ids.split(","));
		int result = careDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.护理天地.getValue(), "批量删除护理天地","批量删除护理天地ID：" + ids);
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
	public JsonResult remove(Care entity) {
		int result = careDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	// 验证标题重名
	public boolean validateTitle(Integer id, String title) {
		Care t = new Care();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("title_valid", title);
		int count = careDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}
