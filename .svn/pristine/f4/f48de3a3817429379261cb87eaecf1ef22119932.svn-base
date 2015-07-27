package com.xz.oa.core.service.organization;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.model.ZTreeNode;
import com.xz.oa.core.dao.organization.CompanyDao;
import com.xz.oa.core.dao.organization.DepartmentDao;
import com.xz.oa.core.dao.user.UserDao;
import com.xz.oa.core.domain.entity.Company;
import com.xz.oa.core.domain.entity.Department;
import com.xz.oa.core.domain.entity.User;
import com.xz.oa.core.service.user.OnlineUser;

@Service
public class DepartmentService {

	@Resource
	private DepartmentDao departmentDao;

	@Resource
	private UserDao userDao;

	@Resource
	private CompanyDao companyDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Department
	 * @author davidwan
	 */
	public Department findById(Integer id) {
		Department entity = new Department();
		entity.setId(id);
		return departmentDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Department
	 * @author davidwan
	 */
	public Department find(Department entity) {
		return departmentDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Department>
	 * @author davidwan
	 */
	public List<Department> queryList(Department entity) {
		List<Department> list = new ArrayList<Department>();
		List<Department> targetList = departmentDao.selectEntityList(entity);
		if (targetList != null) {
			for (Department item : targetList) {
				if (!item.getIs_leaf()) {
					list.add(item);
					for (Department temp : targetList) {
						if (temp.getIs_leaf() && item.getId().equals(temp.getParent_id())) {
							list.add(temp);
						}
					}
				}
				else if(item.getLayer() == 1 && item.getIs_leaf()){
					list.add(item);
				}
			}
		}
		return list;
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Department>
	 * @author davidwan
	 */
	public List<Department> queryListByAddress(Department entity) {
		return departmentDao.selectEntityList(entity, "ByAddress");
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Department>
	 * @author davidwan
	 */
	public PageInfo<Department> queryPageList(Department entity, int pageIndex, int pageSize) {
		return departmentDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 获取部门用户树
	 * @param entity
	 * @param realName
	 * @return List<ZTreeNode>
	 */
	public List<ZTreeNode> queryTreeListWithUsers(Department entity, String realName) {
		List<ZTreeNode> list = new ArrayList<ZTreeNode>();

		List<Department> deptList = departmentDao.selectEntityList(entity);
		List<Integer> deptIds = new ArrayList<Integer>();
		if (deptList != null) {
			for (Department item : deptList) {
				deptIds.add(item.getId());
			}
			User user = new User();
			user.getMap().put("dept_ids", deptIds);
			if (StringUtils.isNotBlank(realName)) {
				user.getMap().put("real_name", realName.trim());
			}
			List<User> userList = userDao.selectEntityList(user);

			List<ZTreeNode> tempList = null;
			for (Department item : deptList) {
				tempList = item.buildTreeNodeWithUsers(userList);
				list.addAll(tempList);
			}
		}

		return list;
	}

	/**
	 * @Description 获取部门在线用户树
	 * @param entity
	 * @param realName
	 * @return List<ZTreeNode>
	 */
	public List<ZTreeNode> queryTreeListWithOnlineUsers(Department entity, String realName) {
		List<ZTreeNode> list = new ArrayList<ZTreeNode>();

		User user = new User();
		Set<Integer> userIds = OnlineUser.getInstance().gainUserIdList();
		if (userIds != null && !userIds.isEmpty()) {
			user.getMap().put("ids", userIds);
		}
		if (StringUtils.isNotBlank(realName)) {
			user.getMap().put("real_name", realName.trim());
		}
		List<User> userList = userDao.selectEntityList(user);

		if (userList != null) {
			// 根节点
			List<ZTreeNode> tempList = null;
			Company company = companyDao.selectEntity(new Company());
			ZTreeNode rootNode = new ZTreeNode(900000, company.getName());
			list.add(rootNode);

			List<Integer> deptIds = new ArrayList<Integer>();
			for (User item : userList) {
				deptIds.add(item.getDept_id());
			}
			entity.getMap().put("ids", deptIds);
			List<Department> deptList = departmentDao.selectEntityList(entity);

			// 获取父级部门
			if (deptList != null) {
				List<Integer> pdeptIds = new ArrayList<Integer>();
				for (Department item : deptList) {
					if (item.getParent_id() != null) {
						pdeptIds.add(item.getParent_id());
					}
				}
				if (!pdeptIds.isEmpty()) {
					entity.getMap().put("ids", pdeptIds);
					List<Department> pdeptList = departmentDao.selectEntityList(entity);
					if (pdeptList != null) {
						Integer parentId = 900000;
						for (Department item : pdeptList) {
							if (item.getParent_id() != null) {
								parentId += item.getParent_id();
							}
							list.add(new ZTreeNode(900000 + item.getId(), item.getName(), parentId, parentId, true));
						}
					}
				}
			}

			for (Department item : deptList) {
				tempList = item.buildTreeNodeWithOnlineUsers(userList);
				list.addAll(tempList);
			}
		}

		return list;
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(Department entity) {
		Department t = new Department();
		Integer sort = this.departmentDao.selectEntitySort(t);
		entity.setSort((sort == null ? 0 : sort) + 1);
		entity.setCreate_time(new Date());
		if (entity.hasParent()) {
			entity.setLayer(2);
		} else {
			entity.setLayer(1);
		}
		// 若要获取id，请使用entity.getId();
		int result = departmentDao.insertEntity(entity);
		if (result > 0) {
			// 更新父节点为非叶子节点
			if (entity.hasParent()) {
				Department parent = new Department(entity.getParent_id(), false);
				departmentDao.updateEntity(parent);
			}

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
	public JsonResult modify(Department entity) {
		int result = departmentDao.updateEntity(entity);
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
		Department entity = new Department();
		entity.setId(id);
		Department deletingEntity = departmentDao.selectEntity(entity);
		int result = departmentDao.deleteEntity(entity);
		if (result > 0) {
			if (deletingEntity.hasParent()) {
				// 判断父节点是否已经是叶子节点
				entity = new Department();
				entity.setParent_id(deletingEntity.getParent_id());
				int count = departmentDao.selectEntityCount(entity);
				if (count == 0) {
					entity = new Department(deletingEntity.getParent_id(), false);
					departmentDao.updateEntity(entity);
				}
			}
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
		Department entity = new Department();
		entity.getMap().put("ids", ids.split(","));
		int result = departmentDao.deleteEntity(entity);
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
	public JsonResult remove(Department entity) {
		int result = departmentDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	public List<ZTreeNode> getJson(Integer id, int type) {
		List<ZTreeNode> zTreeNodeList = new ArrayList<ZTreeNode>();
		Department t = new Department();
		if (id == null) {
			t.setLayer(1);
		} else {
			t.setParent_id(id);
		}
		List<Department> deparmentList = departmentDao.selectEntityList(t);
		if (deparmentList.size() > 0) {
			for (Department deparment : deparmentList) {
				ZTreeNode nodeItem = new ZTreeNode();
				nodeItem.setId(deparment.getId());
				nodeItem.setName(deparment.getName());
				t = new Department();
				t.setParent_id(deparment.getId());
				if (departmentDao.selectEntityCount(t) > 0) {
					nodeItem.setIsParent(true);
				} else {
					nodeItem.setIsParent(false);
				}
				if (deparment.getLayer() == 1) {
					nodeItem.setShowAddBtn(type != 0 ? false : true);
				} else {
					nodeItem.setShowAddBtn(false);
				}
				nodeItem.setShowDeleteBtn(type != 0 ? false : true);
				nodeItem.setShowEditBtn(type != 0 ? false : true);
				nodeItem.setParentId(id);
				zTreeNodeList.add(nodeItem);
			}
		}
		return zTreeNodeList;
	}

	/**
	 * @Description 根据名称获取部门
	 * @param name
	 * @return User
	 * @author davidwan
	 */
	public Department findByName(String name) {
		Department entity = new Department();
		entity.setName(name);
		return departmentDao.selectEntity(entity);
	}
}
