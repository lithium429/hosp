package com.xz.oa.core.service.forum;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.utils.ConfigValue;
import com.xz.oa.core.dao.forum.ForumUserDao;
import com.xz.oa.core.dao.forum.ForumUserFavDao;
import com.xz.oa.core.domain.entity.ForumUser;
import com.xz.oa.core.domain.entity.ForumUserFav;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service("forumUserService")
public class ForumUserService {

	public final static String FORUM_LOGIN_USER = "forum_login_user";

	@Resource
	private ForumUserDao forumUserDao;

	@Resource
	private ForumUserFavDao forumUserFavDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return ForumUser
	 * @author davidwan
	 */
	public ForumUser findById(Integer id) {
		ForumUser entity = new ForumUser();
		entity.setId(id);
		return forumUserDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return ForumUser
	 * @author davidwan
	 */
	public ForumUser find(ForumUser entity) {
		return forumUserDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<ForumUser>
	 * @author davidwan
	 */
	public List<ForumUser> queryList(ForumUser entity) {
		return forumUserDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<ForumUser>
	 * @author davidwan
	 */
	public PageInfo<ForumUser> queryPageList(ForumUser entity, int pageIndex, int pageSize) {
		return forumUserDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(ForumUser entity) {
		// 若要获取id，请使用entity.getId();
		int result = forumUserDao.insertEntity(entity);
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
	public JsonResult modify(ForumUser entity) {
		int result = forumUserDao.updateEntity(entity);
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
		ForumUser entity = new ForumUser();
		entity.setId(id);
		int result = forumUserDao.deleteEntity(entity);
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
		ForumUser entity = new ForumUser();
		entity.getMap().put("ids", ids.split(","));
		int result = forumUserDao.deleteEntity(entity);
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
	public JsonResult remove(ForumUser entity) {
		int result = forumUserDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 获取收藏主题id列表
	 * @param userId
	 * @return List<Integer>
	 */
	public List<Integer> queryForFavIds(Integer userId) {
		List<Integer> idList = null;
		ForumUserFav userFav = new ForumUserFav(userId);
		List<ForumUserFav> list = forumUserFavDao.selectEntityList(userFav);
		if (list != null && !list.isEmpty()) {
			idList = new ArrayList<Integer>();
			for (ForumUserFav item : list) {
				idList.add(item.getThread_id());
			}
		}
		return idList;
	}

	/**
	 * @Description
	 * @param entity
	 * @return JsonResult
	 */
	public JsonResult createForFav(ForumUserFav entity) {
		// 若要获取id，请使用entity.getId();
		int count = forumUserFavDao.selectEntityCount(entity);
		if (count > 0) {
			return new JsonResult(false, "抱歉，您已收藏，请勿重复收藏！");
		}
		int result = forumUserFavDao.insertEntity(entity);
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
	public JsonResult removeForFavById(Integer id) {
		ForumUserFav entity = new ForumUserFav();
		entity.setId(id);
		int result = forumUserFavDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 根据多个Id删除
	 * @param threadIds
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult removeForFavByIds(String threadIds, Integer userId) {
		ForumUserFav entity = new ForumUserFav(userId);
		entity.getMap().put("thread_ids", threadIds.split(","));
		int result = forumUserFavDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 获取论坛登录用户
	 * @param session
	 */
	public void gainForumUser(HttpSession session) {
		boolean isEnable = ConfigValue.readBooleanValue("isEnableForum", false);
		if (!isEnable) {
			return;
		}

		if (session.getAttribute(FORUM_LOGIN_USER) == null) {
			Subject currentUser = SecurityUtils.getSubject();
			ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
			if (shiroUser != null) {
				ForumUser forumUser = forumUserDao.selectEntity(new ForumUser(shiroUser.getId()));
				if (forumUser != null) {
					if (StringUtils.isBlank(forumUser.getBicon_url())) {
						forumUser.setBicon_url("static/images/forum/noavatar_big.gif");
					}
					if (StringUtils.isBlank(forumUser.getMicon_url())) {
						forumUser.setMicon_url("static/images/forum/noavatar_middle.gif");
					}
					if (StringUtils.isBlank(forumUser.getSicon_url())) {
						forumUser.setSicon_url("static/images/forum/noavatar_small.gif");
					}
					session.setAttribute(FORUM_LOGIN_USER, forumUser);
				}
			}
		}
	}
}
