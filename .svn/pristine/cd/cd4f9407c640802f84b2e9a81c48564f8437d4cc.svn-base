package com.xz.oa.core.service.staff;

import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.utils.ConfigValue;
import com.xz.oa.core.dao.address.AddressDao;
import com.xz.oa.core.dao.organization.DepartmentDao;
import com.xz.oa.core.dao.security.RoleDao;
import com.xz.oa.core.dao.staff.StaffDao;
import com.xz.oa.core.dao.user.UserDao;
import com.xz.oa.core.dao.user.UserRoleDao;
import com.xz.oa.core.domain.entity.Address;
import com.xz.oa.core.domain.entity.Department;
import com.xz.oa.core.domain.entity.Role;
import com.xz.oa.core.domain.entity.Staff;
import com.xz.oa.core.domain.entity.User;
import com.xz.oa.core.domain.entity.UserRole;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;

@Service
public class StaffService {

	@Resource
	private StaffDao staffDao;
	@Resource
	private SystemLogService systemLogService;

	@Resource
	private UserDao userDao;

	@Resource
	private AddressDao addressDao;

	@Resource
	private DepartmentDao deptDao;

	@Resource
	private RoleDao roleDao;
	
	@Resource
	private UserRoleDao userRoleDao;

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Staff
	 * @author davidwan
	 */
	public Staff findById(Integer id) {
		Staff entity = new Staff();
		entity.setId(id);
		return staffDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Staff
	 * @author davidwan
	 */
	public Staff find(Staff entity) {
		return staffDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Staff>
	 * @author davidwan
	 */
	public List<Staff> queryList(Staff entity) {
		return staffDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Staff>
	 * @author davidwan
	 */
	public PageInfo<Staff> queryPageList(Staff entity, int pageIndex, int pageSize) {
		return staffDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(Staff entity) {
		// 若要获取id，请使用entity.getId();
		int result = staffDao.insertEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.人员管理.getValue(), "添加人员","添加人员：" + entity.getName());
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
	public JsonResult modify(Staff entity) {
		if (entity.getEntry_date() == null) {
			entity.getMap().put("null_entry_date", true);
		}
		if (entity.getGraduate_date() == null) {
			entity.getMap().put("null_graduate_date", true);
		}
		int result = staffDao.updateEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.人员管理.getValue(), "修改人员","修改人员：" + entity.getName());
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
		Staff entity = new Staff();
		entity.setId(id);
		int result = staffDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.人员管理.getValue(), "删除人员","删除人员ID：" + id);
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
		Staff entity = new Staff();
		entity.getMap().put("ids", ids.split(","));
		int result = staffDao.deleteEntity(entity);
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.人员管理.getValue(), "批量删除人员","批量删除人员ID：" + ids);
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
	public JsonResult remove(Staff entity) {
		int result = staffDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	// 验证工号重名
	public boolean validateCode(Integer id, String code) {
		Staff t = new Staff();
		if (id == null) {
			id = 0;
		}
		t.getMap().put("id", id);
		t.getMap().put("code_valid", code);
		int count = staffDao.selectEntityCount(t);
		if (count > 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @Description 导入员工，用户
	 * @param text
	 * @return boolean
	 */
	public boolean modifyForImport(String text, Integer creatorId) {
		if (StringUtils.isBlank(text)) {
			return false;
		}
		String[] codeNameArray = text.split("\r\n");
		if (codeNameArray == null || codeNameArray.length == 0) {
			return false;
		}

		String deptName = ConfigValue.readValue("tempDeptName", "临时部门");
		Department dept = new Department(deptName);
		dept = deptDao.selectEntity(dept);
		if (dept == null) {
			return false;
		}

		String roleName = ConfigValue.readValue("tempRoleName", "普通用户");
		Role role = new Role(roleName);
		role = roleDao.selectEntity(role);
		if (role == null) {
			return false;
		}

		String[] itemArray = null;
		User user = null;
		UserRole userRole = null;
		Address address = null;
		Staff staff = null;
		
		for (String item : codeNameArray) {
			itemArray = item.trim().split("\\s+");
			if (itemArray == null || itemArray.length < 2) {
				continue;
			}
			// 用户
			user = new User(itemArray[0].trim(), "123456", itemArray[1].trim(), dept.getId(), true);
			userDao.insertEntity(user);
			
			// 用户权限
			userRole = new UserRole(user.getId(), role.getId());
			userRoleDao.insertEntity(userRole);

			// 内部通讯录
			address = new Address(user, creatorId);
			addressDao.insertEntity(address);

			staff = new Staff(user.getReal_name(), user.getName(), user.getId());
			staffDao.insertEntity(staff);
		}

		int result = 0;
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}

}
