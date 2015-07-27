package com.xz.oa.core.service.forum;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.forum.ForumFileDao;
import com.xz.oa.core.dao.forum.ForumPlateDao;
import com.xz.oa.core.dao.forum.ForumPostDao;
import com.xz.oa.core.dao.forum.ForumThreadDao;
import com.xz.oa.core.dao.forum.ForumUserDao;
import com.xz.oa.core.domain.entity.ForumFile;
import com.xz.oa.core.domain.entity.ForumPlate;
import com.xz.oa.core.domain.entity.ForumPost;
import com.xz.oa.core.domain.entity.ForumThread;
import com.xz.oa.core.domain.entity.ForumUser; 
import com.xz.oa.core.domain.enums.EnumForumType;

@Service
public class ForumThreadService {

	@Resource
	private ForumPlateDao forumPlateDao;

	@Resource
	private ForumThreadDao forumThreadDao;

	@Resource
	private ForumPostDao forumPostDao;

	@Resource
	private ForumUserDao forumUserDao;
	
	@Resource
	private ForumFileDao forumFileDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return ForumThread
	 * @author davidwan
	 */
	public ForumThread findById(Integer id) {
		ForumThread entity = new ForumThread();
		entity.setId(id);
		return forumThreadDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return ForumThread
	 * @author davidwan
	 */
	public ForumThread find(ForumThread entity) {
		return forumThreadDao.selectEntity(entity);
	}

	/**
	 * @Description 获取当前数据的上一条
	 * @param id
	 * @param plateId
	 * @return ForumThread
	 */
	public ForumThread findPrevByCurrentId(Integer id, Integer plateId) {
		ForumThread entity = new ForumThread(plateId);
		entity.setIs_delete(false);
		entity.getMap().put("prev", true);
		entity.getMap().put("id", id);
		entity.getMap().put("sort_asc", true);
		return forumThreadDao.selectEntity(entity, "ForPrev");
	}

	/**
	 * @Description 获取当前数据的下一条
	 * @param id
	 * @param plateId
	 * @return ForumThread
	 */
	public ForumThread findNextByCurrentId(Integer id, Integer plateId) {
		ForumThread entity = new ForumThread(plateId);
		entity.setIs_delete(false);
		entity.getMap().put("next", true);
		entity.getMap().put("id", id);
		entity.getMap().put("sort", true);
		return forumThreadDao.selectEntity(entity, "ForNext");
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<ForumThread>
	 * @author davidwan
	 */
	public List<ForumThread> queryList(ForumThread entity) {
		return forumThreadDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<ForumThread>
	 * @author davidwan
	 */
	public PageInfo<ForumThread> queryPageList(ForumThread entity, int pageIndex, int pageSize) {
		return forumThreadDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param userId
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<ForumThread>
	 * @author davidwan
	 */
	public PageInfo<ForumThread> queryPageListWithPosts(Integer userId, int pageIndex, int pageSize) {
		ForumPost forumPost = new ForumPost();
		forumPost.setCreator_id(userId);
		forumPost.setIs_delete(false);
		forumPost.setIs_first(false);
		List<Integer> threadIds = forumPostDao.selectThreadIds(forumPost);
		if(threadIds == null || threadIds.isEmpty()){
			return null;
		}
		ForumThread forumThread = new ForumThread(threadIds, userId, false);
		forumThread.getMap().put("sort", true);
		return forumThreadDao.selectEntityPageList(forumThread, "WithPosts", pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @param session
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(ForumThread entity, HttpSession session) {
		// 若要获取id，请使用entity.getId();
		boolean hasFile = entity.getFiles() != null && entity.getFiles().size() > 0;
		entity.setHas_file(hasFile);
		int result = forumThreadDao.insertEntity(entity);
		forumPostDao.insertEntity(new ForumPost(entity));
		forumPlateDao.updateForumPlateLastInfo(null);
		forumUserDao.updateForumUserCount(new ForumUser(entity.getCreator_id()));
		
		// 添加附件
		if (entity.getFiles() != null && entity.getFiles().size() > 0) {
			for (ForumFile item : entity.getFiles()) {
				item.setThread_id(entity.getId());
				item.setFtype(EnumForumType.主题.getValue());
				item.setCreate_time(new Date());
				forumFileDao.insertEntity(item);
			}
		}

		if (result > 0) {
			session.removeAttribute(ForumUserService.FORUM_LOGIN_USER);
			return new JsonResult(true, null, entity.getId());
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
	public JsonResult modify(ForumThread entity) {
		boolean hasFile = entity.getFiles() != null && entity.getFiles().size() > 0;
		entity.setHas_file(hasFile);
		int result = forumThreadDao.updateEntity(entity);
		
		// 修改附件
		ForumFile forumFile = new ForumFile(entity.getId());
		forumFileDao.deleteEntity(forumFile);
		if (entity.getFiles() != null && entity.getFiles().size() > 0) {
			for (ForumFile item : entity.getFiles()) {
				item.setThread_id(entity.getId());
				item.setFtype(EnumForumType.主题.getValue());
				item.setCreate_time(new Date());
				forumFileDao.insertEntity(item);
			}
		}
		
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 修改查看次数
	 * @param id
	 * @return JsonResult
	 */
	public JsonResult modifyForViewCount(Integer id) {
		ForumThread entity = new ForumThread();
		entity.setId(id);
		int result = forumThreadDao.updateThreadViewCount(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 移动主题
	 * @param entity
	 * @return JsonResult
	 */
	public JsonResult modifyForMove(ForumThread entity) {
		int result = forumThreadDao.updateEntity(entity);
		forumPostDao.updateEntity(new ForumPost(entity.getId(), entity.getPlate_id()));
		forumPlateDao.updateForumPlateLastInfo(new ForumPlate());
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 逻辑删除
	 * @param id
	 * @param plateId
	 * @return JsonResult
	 */
	public JsonResult modifyForDelete(Integer id, Integer plateId, HttpSession session) {
		int result = forumThreadDao.updateEntity(new ForumThread(id, true, true));
		forumPlateDao.updateForumPlateLastInfo(new ForumPlate(plateId));
		forumUserDao.updateForumUserCount(null);
		if (result > 0) {
			session.removeAttribute(ForumUserService.FORUM_LOGIN_USER);
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 恢复
	 * @param id
	 * @param plateId
	 * @return JsonResult
	 */
	public JsonResult modifyForRecover(Integer id, Integer plateId, HttpSession session) {
		int result = forumThreadDao.updateEntity(new ForumThread(id, false, true));
		forumPlateDao.updateForumPlateLastInfo(new ForumPlate(plateId));
		forumUserDao.updateForumUserCount(null);
		if (result > 0) {
			session.removeAttribute(ForumUserService.FORUM_LOGIN_USER);
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 批量恢复
	 * @param ids
	 * @return JsonResult
	 */
	public JsonResult modifyForBatchRecover(String[] ids, HttpSession session) {
		int result = forumThreadDao.updateEntity(new ForumThread(ids, false));
		forumPlateDao.updateForumPlateLastInfo(null);
		forumUserDao.updateForumUserCount(null);
		if (result > 0) {
			session.removeAttribute(ForumUserService.FORUM_LOGIN_USER);
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
		ForumThread entity = new ForumThread();
		entity.setId(id);
		int result = forumThreadDao.deleteEntity(entity);
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
		ForumThread entity = new ForumThread();
		entity.getMap().put("ids", ids.split(","));
		int result = forumThreadDao.deleteEntity(entity);
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
	public JsonResult remove(ForumThread entity) {
		int result = forumThreadDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
