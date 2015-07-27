package com.xz.oa.core.service.address;

import java.util.Date;
import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.utils.SpellUtil;
import com.xz.oa.core.dao.address.AddressDao;
import com.xz.oa.core.dao.address.AddressGroupDao;
import com.xz.oa.core.dao.address.AddressUserDao;
import com.xz.oa.core.dao.organization.DepartmentDao;
import com.xz.oa.core.dao.user.UserDao;
import com.xz.oa.core.domain.entity.Address;
import com.xz.oa.core.domain.entity.AddressGroup;
import com.xz.oa.core.domain.entity.AddressHelp;
import com.xz.oa.core.domain.entity.AddressUser;
import com.xz.oa.core.domain.entity.Department;
import com.xz.oa.core.domain.entity.User;
import com.xz.oa.core.domain.enums.EnumLogModule;
import com.xz.oa.core.service.log.SystemLogService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Service
public class AddressService {

	@Resource
	private AddressDao addressDao;

	@Resource
	private AddressGroupDao addressGroupDao;

	@Resource
	private AddressUserDao addressUserDao;

	@Resource
	private DepartmentDao departmentDao;

	@Resource
	private UserDao userDao;
	@Resource
	private SystemLogService systemLogService;

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Address
	 * @author davidwan
	 */
	public int getCount(Address entity) {
		return addressDao.selectEntityCount(entity);
	}

	/**
	 * @Description 根据Id获取实体
	 * @param id
	 * @return Address
	 * @author davidwan
	 */
	public Address findById(Integer id) {
		Address entity = new Address();
		entity.setId(id);
		return addressDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取实体
	 * @param entity
	 * @return Address
	 * @author davidwan
	 */
	public Address find(Address entity) {
		return addressDao.selectEntity(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Address>
	 * @author davidwan
	 */
	public List<Address> queryList(Address entity) {
		return addressDao.selectEntityList(entity);
	}

	/**
	 * @Description 根据条件获取列表
	 * @param entity
	 * @return List<Address>
	 * @author davidwan
	 */
	public List<AddressHelp> queryListHelp(Address entity) {
		return addressDao.selectEntityListHelp(entity);
	}

	/**
	 * @Description 根据条件获取分页列表
	 * @param entity
	 * @param pageIndex
	 * @param pageSize
	 * @return PageInfo<Address>
	 * @author davidwan
	 */
	public PageInfo<Address> queryPageList(Address entity, int pageIndex, int pageSize) {
		return addressDao.selectEntityPageList(entity, pageIndex, pageSize);
	}

	/**
	 * @Description 添加
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult create(Address entity) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		entity.setCreate_time(new Date());
		entity.setCreator_id(shiroUser.getId());
		if (entity.getName() != null) {
			entity.setPname(SpellUtil.getFullSpell(entity.getName()));
			entity.setFname(SpellUtil.getFirstOneSpell(entity.getName()));
		}
		// 若要获取id，请使用entity.getId();
		int result = addressDao.insertEntity(entity);
		int address_id = entity.getId();
		// 分组数量
		if (entity.getGroup_id() != null) {
			AddressGroup a = new AddressGroup();
			a.setId(entity.getGroup_id());
			a.getMap().put("acount_val", 1);
			addressGroupDao.updateEntity(a);
		}
		if (entity.getDept_id() != null) {
			Department d = new Department();
			d.setId(entity.getDept_id());
			d.getMap().put("acount_val", 1);
			departmentDao.updateEntity(d);
		}
		// 共享用户
		if (entity.getAddressUserIds() != null && entity.getAddressUserIds() != "") {
			AddressUser u = null;
			for (String item : entity.getAddressUserIds().split(",")) {
				u = new AddressUser();
				u.setAddress_id(address_id);
				u.setUser_id(Integer.valueOf(item));
				addressUserDao.insertEntity(u);
			}
		}
		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.外部通讯录.getValue(), "添加外部通讯录","添加外部通讯录：" + entity.getName());
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
	public JsonResult modify(Address entity, Integer old_id) {
		if (entity.getName() != null) {
			entity.setPname(SpellUtil.getFullSpell(entity.getName()));
			entity.setFname(SpellUtil.getFirstOneSpell(entity.getName()));
		}
		int address_id = entity.getId();
		if (entity.getType() == 2) {
			// 分组数量
			AddressGroup a = null;
			if (old_id != null) {
				a = new AddressGroup();
				a.setId(old_id);
				a.getMap().put("acount_val", -1);
				addressGroupDao.updateEntity(a);
			}
			if (entity.getGroup_id() != null) {
				a = new AddressGroup();
				a.setId(entity.getGroup_id());
				a.getMap().put("acount_val", 1);
				addressGroupDao.updateEntity(a);
			} else {
				entity.getMap().put("group_id_null", true);
			}

			AddressUser u = new AddressUser();
			u.setAddress_id(address_id);
			addressUserDao.deleteEntity(u);
			// 共享用户
			if (entity.getAddressUserIds() != null && entity.getAddressUserIds() != "") {

				for (String item : entity.getAddressUserIds().split(",")) {
					u = new AddressUser();
					u.setAddress_id(address_id);
					u.setUser_id(Integer.valueOf(item));
					addressUserDao.insertEntity(u);
				}
			}
		}/* else {
			Department a = null;
			if (old_id != null) {
				a = new Department();
				a.setId(old_id);
				a.getMap().put("acount_val", -1);
				departmentDao.updateEntity(a);
			}
			if (entity.getDept_id() != null) {
				a = new Department();
				a.setId(entity.getGroup_id());
				a.getMap().put("acount_val", 1);
				departmentDao.updateEntity(a);
			}
		}*/
		int result = addressDao.updateEntity(entity);
		if (result > 0) {
			int model=EnumLogModule.外部通讯录.getValue();
			String action="修改外部通讯录";
			if(entity.getGroup_id() == null){
				model=EnumLogModule.内部通讯录.getValue();
				action="修改内部通讯录";
			}
			//添加操作日志
			systemLogService.create(model,action,action+"：" + entity.getName());
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 共享
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult modify(String ids, int id) {
		Address a = new Address();
		a.setId(id);
		a.setIs_share(false);
		AddressUser u = new AddressUser();
		u.setAddress_id(id);
		addressUserDao.deleteEntity(u);
		// 共享用户
		if (ids != null && ids != "") {

			a.setIs_share(true);
			for (String item : ids.split(",")) {
				u = new AddressUser();
				u.setAddress_id(id);
				u.setUser_id(Integer.valueOf(item));
				addressUserDao.insertEntity(u);
			}
		}
		int result = addressDao.updateEntity(a);

		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.外部通讯录.getValue(), "共享外部通讯录","共享外部通讯录ID：" + (id!=0?id:ids));
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

	/**
	 * @Description 移动
	 * @param entity
	 * @return JsonResult
	 * @author davidwan
	 */
	public JsonResult modify(Integer group_id, Integer old_id, int id) {
		Address entity = new Address();
		if(group_id==null)
		{
			entity.getMap().put("group_id_null", true);
		}
		entity.setGroup_id(group_id);
		entity.setId(id);
		AddressGroup a = null;
		if (old_id != null) {
			a = new AddressGroup();
			a.setId(old_id);
			a.getMap().put("acount_val", -1);
			addressGroupDao.updateEntity(a);
		}
		if (entity.getGroup_id() != null) {
			a = new AddressGroup();
			a.setId(entity.getGroup_id());
			a.getMap().put("acount_val", 1);
			addressGroupDao.updateEntity(a);
		} else {
			entity.getMap().put("", true);
		}
		int result = addressDao.updateEntity(entity);

		if (result > 0) {
			//添加操作日志
			systemLogService.create(EnumLogModule.外部通讯录.getValue(), "移动外部通讯录","移动外部通讯录ID：" + id);
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
	public JsonResult modify(Address entity) {
		int result = addressDao.updateEntity(entity);

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
	public JsonResult removeById(Integer id,Integer user_id, Integer group_id, int type) {
		Address entity = new Address();
		entity.setId(id);
		int result = addressDao.deleteEntity(entity);
		if (group_id != null && type == 2) {
			AddressGroup a = new AddressGroup();
			a.setId(group_id);
			a.getMap().put("acount_val", -1);
			addressGroupDao.updateEntity(a);
		}
		if (group_id != null && type == 1) {
			Department a = new Department();
			a.setId(group_id);
			a.getMap().put("acount_val", -1);
			departmentDao.updateEntity(a);
			if(user_id!=null)
			{
				User u=new User();
				u.setId(user_id);
				u.setHas_address(false);
				userDao.updateEntity(u);
			}
		}
		if (result > 0) {
			int model=EnumLogModule.外部通讯录.getValue();
			String action="删除外部通讯录";
			if(type == 1){
				model=EnumLogModule.内部通讯录.getValue();
				action="删除内部通讯录";
			}
			//添加操作日志
			systemLogService.create(model, action,action+"ID：" + id);
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
	public JsonResult removeByIds(String ids, Integer group_id, int type) {
		Address entity = new Address();
		entity.getMap().put("ids", ids.split(","));
		int result = addressDao.deleteEntity(entity);
		if (group_id != null && type == 2) {
			AddressGroup a = new AddressGroup();
			a.setId(group_id);
			a.getMap().put("acount_val", -ids.split(",").length);
			addressGroupDao.updateEntity(a);
		}
		if (group_id != null && type == 1) {
			Department a = new Department();
			a.setId(group_id);
			a.getMap().put("acount_val", -ids.split(",").length);
			departmentDao.updateEntity(a);
		}
		if (result > 0) {
			int model=EnumLogModule.外部通讯录.getValue();
			String action="批量删除外部通讯录";
			if(type == 1){
				model=EnumLogModule.内部通讯录.getValue();
				action="批量删除内部通讯录";
			}
			//添加操作日志
			systemLogService.create(model, action,action+"ID：" + ids);
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
	public JsonResult remove(Address entity) {
		int result = addressDao.deleteEntity(entity);
		if (result > 0) {
			return new JsonResult(true);
		} else {
			return new JsonResult(false);
		}
	}

}
