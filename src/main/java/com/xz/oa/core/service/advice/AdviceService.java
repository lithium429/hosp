package com.xz.oa.core.service.advice;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.advice.AdviceDao;
import com.xz.oa.core.domain.entity.Advice;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class AdviceService {

	@Resource
	private AdviceDao adviceDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Advice
	 * @author davidwan
	 */
	public Advice findById(Integer id) {
		Advice entity = new Advice();
		entity.setId(id);
		return adviceDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Advice
	 * @author davidwan
	 */
	public Advice find(Advice entity) {
		return adviceDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Advice>
	 * @author davidwan
	 */
	public List<Advice> queryList(Advice entity) {
		return adviceDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Advice>
	 * @author davidwan
	 */
	public PageInfo<Advice> queryPageList(Advice entity, int pageIndex, int pageSize) {
		return adviceDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 获取当前数据的上一条
	 * @param id
	 * @param typeId
	 * @return Care
	 */
	public Advice findPrevByCurrentId(Integer id) {
		Advice entity = new Advice();
		entity.setIs_open(true);
		entity.getMap().put("prev", true);
		entity.getMap().put("id", id);
		entity.getMap().put("sort_asc", true);
		return adviceDao.selectEntity(entity, "ForPrev");
	}

	/**
	 * @Description 获取当前数据的下一条
	 * @param id
	 * @param typeId
	 * @return Care
	 */
	public Advice findNextByCurrentId(Integer id) {
		Advice entity = new Advice();
		entity.setIs_open(true);
		entity.getMap().put("next", true);
		entity.getMap().put("id", id);
		entity.getMap().put("sort", true);
		return adviceDao.selectEntity(entity, "ForNext");
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(Advice entity) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		entity.setCreator_id(shiroUser.getId());
		// 若要获取id，请使用entity.getId();
		int result = adviceDao.insertEntity(entity);
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
	public JsonResult modify(Advice entity) {
		int result = adviceDao.updateEntity(entity);
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
	public JsonResult modifyHaddle(int id, String ids, String content) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		Advice entity = new Advice();
		entity.setHaddle_time(new Date());
		entity.setHaddle_id(shiroUser.getId());
		entity.setHaddle_content(content);
		entity.setState(2);
		if (id == 0) {
			entity.getMap().put("ids", ids.split(","));
		} else {
			entity.setId(id);
		}
		int result = adviceDao.updateEntity(entity);
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
		Advice entity = new Advice();
		entity.setId(id);
		int result = adviceDao.deleteEntity(entity);
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
		Advice entity = new Advice();
		entity.getMap().put("ids", ids.split(","));
		int result = adviceDao.deleteEntity(entity);
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
	public JsonResult remove(Advice entity) {
		int result = adviceDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	// 验证标题重名
	public boolean validateTitle(Integer id, String title) {
		Advice t = new Advice();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("title_valid", title);
		int count = adviceDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

}
