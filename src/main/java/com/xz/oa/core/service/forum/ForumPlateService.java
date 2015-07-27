package com.xz.oa.core.service.forum;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.dao.forum.ForumPlateDao;
import com.xz.oa.core.dao.forum.ForumPlateUserDao;
import com.xz.oa.core.domain.entity.ForumPlate;
import com.xz.oa.core.domain.entity.ForumPlateUser;

@Service
public class ForumPlateService {

	@Resource
	private ForumPlateDao forumPlateDao;

	@Resource
	private ForumPlateUserDao forumPlateUserDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return ForumPlate
	 * @author davidwan
	 */
	public ForumPlate findById(Integer id) {
		ForumPlate entity = new ForumPlate();
		entity.setId(id);
		return forumPlateDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return ForumPlate
	 * @author davidwan
	 */
	public ForumPlate find(ForumPlate entity) {
		return forumPlateDao.selectEntity(entity);
	}

	/**
	 * @Description 获取最大排序值
	 * @param entity
	 * @return int
	 */
	public Integer findMaxSort(ForumPlate entity) {
		return forumPlateDao.selectEntitySort(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<ForumPlate>
	 * @author davidwan
	 */
	public List<ForumPlate> queryList(ForumPlate entity) {
		List<ForumPlate> list = new ArrayList<ForumPlate>();
		List<ForumPlate> targetList = forumPlateDao.selectEntityList(entity);
		if (targetList != null) {
			for (ForumPlate item : targetList) {
				if (item.getLayer() == 1) {
					list.add(item);
					for (ForumPlate subItem : targetList) {
						if (subItem.getLayer() == 2 && item.getId().equals(subItem.getParent_id())) {
							list.add(subItem);
						}
					}
				}
			}
		}
		return list;
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<ForumPlate>
	 * @author davidwan
	 */
	public PageInfo<ForumPlate> queryPageList(ForumPlate entity, int pageIndex, int pageSize) {
		return forumPlateDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(ForumPlate entity) {
		// 若要获取id，请使用entity.getId();
		int result = forumPlateDao.insertEntity(entity);

		// 保存版主
		if (entity.getUser_ids() != null && StringUtils.isNotBlank(entity.getUser_ids())) {
			String[] idArray = entity.getUser_ids().split(",");
			ForumPlateUser user = null;
			Integer userId = null;
			for (String item : idArray) {
				userId = NumberUtils.toInt(item, 0);
				if (userId > 0) {
					user = new ForumPlateUser(userId, entity.getId());
					this.forumPlateUserDao.insertEntity(user);
				}
			}
		}

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
	public JsonResult modify(ForumPlate entity) {
		int result = forumPlateDao.updateEntity(entity);

		// 删除原版主
		ForumPlateUser u = new ForumPlateUser(entity.getId());
		this.forumPlateUserDao.deleteEntity(u);

		// 保存版主
		if (entity.getUser_ids() != null && StringUtils.isNotBlank(entity.getUser_ids())) {
			String[] idArray = entity.getUser_ids().split(",");
			ForumPlateUser user = null;
			Integer userId = null;
			for (String item : idArray) {
				userId = NumberUtils.toInt(item, 0);
				if (userId > 0) {
					user = new ForumPlateUser(userId, entity.getId());
					this.forumPlateUserDao.insertEntity(user);
				}
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
		ForumPlate entity = new ForumPlate();
		entity.setId(id);
		int result = forumPlateDao.deleteEntity(entity);
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
		ForumPlate entity = new ForumPlate();
		entity.getMap().put("ids", ids.split(","));
		int result = forumPlateDao.deleteEntity(entity);
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
	public JsonResult remove(ForumPlate entity) {
		int result = forumPlateDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 判断是否是板块管理员
	 * @param plateId
	 * @param userId
	 * @return  boolean     
	 */
	public boolean judgePlateUser(Integer plateId, Integer userId){
		int count = forumPlateUserDao.selectEntityCount(new ForumPlateUser(userId, plateId));
		return count > 0;
	}
}
