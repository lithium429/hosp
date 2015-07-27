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
public class ForumPostService{

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
	 * @return ForumPost    
	 * @author davidwan 
	 */
	public ForumPost findById(Integer id) {
		ForumPost entity = new ForumPost();
		entity.setId(id);
		return forumPostDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return ForumPost    
	 * @author davidwan 
	 */
	public ForumPost find(ForumPost entity) {
		return forumPostDao.selectEntity(entity);
	}
	
	/**
	 * @Description 获取总数
	 * @param entity
	 * @return int     
	 */
	public int gainTotalCount(ForumPost entity){
		return forumPostDao.selectEntityCount(entity);
	}
	
	/**
	 * @Description 根据条件获取列表 
	 * @param entity
	 * @return List<ForumPost>    
	 * @author davidwan 
	 */
	public List<ForumPost> queryList(ForumPost entity){
		return forumPostDao.selectEntityList(entity);
	}
	
	/**
	 * @Description 根据条件获取分页列表 
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<ForumPost>    
	 * @author davidwan 
	 */
	public PageInfo<ForumPost> queryPageList(ForumPost entity, int pageIndex, int pageSize){
		return forumPostDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @param replyCount
	 * @param session
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult create(ForumPost entity, Integer replyCount, HttpSession session) {
		// 若要获取id，请使用entity.getId(); 
		boolean hasFile = entity.getFiles() != null && entity.getFiles().size() > 0;
		entity.setHas_file(hasFile);
		int result = forumPostDao.insertEntity(entity);
		forumThreadDao.updateEntity(new ForumThread(entity, new Date(), replyCount));
		forumPlateDao.updateForumPlateLastInfo(new ForumPlate(entity.getPlate_id())); 
		forumUserDao.updateForumUserCount(new ForumUser(entity.getCreator_id()));
		
		// 添加附件
		if (entity.getFiles() != null && entity.getFiles().size() > 0) {
			for (ForumFile item : entity.getFiles()) {
				item.setPost_id(entity.getId());
				item.setFtype(EnumForumType.跟帖.getValue());
				item.setCreate_time(new Date());
				forumFileDao.insertEntity(item);
			}
		}
		
		if (result > 0) {
			session.removeAttribute(ForumUserService.FORUM_LOGIN_USER);
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
	public JsonResult modify(ForumPost entity) {
		boolean hasFile = entity.getFiles() != null && entity.getFiles().size() > 0;
		entity.setHas_file(hasFile);
		int result = forumPostDao.updateEntity(entity);
		
		// 修改附件
		ForumFile forumFile = new ForumFile(entity.getId(), true);
		forumFileDao.deleteEntity(forumFile);
		if (entity.getFiles() != null && entity.getFiles().size() > 0) {
			for (ForumFile item : entity.getFiles()) {
				item.setPost_id(entity.getId());
				item.setFtype(EnumForumType.跟帖.getValue());
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
	 * @Description 根据Id删除 
	 * @param id
	 * @return JsonResult    
	 * @author davidwan 
	 */
	public JsonResult removeById(Integer id) {
		ForumPost entity = new ForumPost();
		entity.setId(id);
		int result = forumPostDao.deleteEntity(entity);
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
		ForumPost entity = new ForumPost();
		entity.getMap().put("ids", ids.split(","));
		int result = forumPostDao.deleteEntity(entity);
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
	public JsonResult remove(ForumPost entity) { 
		int result = forumPostDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
