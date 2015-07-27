package com.xz.oa.core.web.controller.address;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.base.utils.WebUtil;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.oa.core.domain.entity.Address;
import com.xz.oa.core.domain.entity.AddressGroup;
import com.xz.oa.core.domain.entity.Department;
import com.xz.oa.core.service.address.AddressGroupService;
import com.xz.oa.core.service.address.AddressService;
import com.xz.oa.core.service.organization.DepartmentService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/address")
public class AddressController extends SpringBaseController {

	@Resource
	private AddressService addressService;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private AddressGroupService addressGroupService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {

		int type = WebUtil.getInt(request, "type", 1);
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		model.addAttribute("type", type);
		model.addAttribute("menu_id", menu_id);
		model.addAttribute("roleMenuList", super.gainRoleMenu(menu_id));
		return getPathList();
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/datalist")
	public String datalist(HttpServletRequest request, Model model) {
		getList(request, model);
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		model.addAttribute("roleMenuList", super.gainRoleMenu(menu_id));
		return getPath("data_list");
	}

	/**
	 * @Description 获取分组数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/datalist1")
	public String datalist1(HttpServletRequest request, Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		int type = WebUtil.getInt(request, "type", 1);
		int list_type = WebUtil.getInt(request, "list_type", 1);
		String is_share = WebUtil.getString(request, "is_share", "");
		String group_id = WebUtil.getString(request, "group_id", "");
		String dept_id = WebUtil.getString(request, "dept_id", "");
		if (type == 1) {
			Department d = new Department();
			d.setIs_leaf(true);
			model.addAttribute("departmentList", departmentService.queryList(d));
		} else {
			AddressGroup a = new AddressGroup();
			a.getMap().put("sort_order", true);
			a.setCreator_id(shiroUser.getId());
			model.addAttribute("addressGroupList", addressGroupService.queryList(a));
			Address s = new Address();
			s.setIs_share(false);
			s.setType(type);
			s.setCreator_id(shiroUser.getId());
			s.getMap().put("group_id_null", true);
			model.addAttribute("myCount", addressService.getCount(s));
			s = new Address();
			s.setType(type);
			s.setIs_share(true);
			s.getMap().put("user_id_share", shiroUser.getId());
			s.getMap().put("creator_id", shiroUser.getId());
			model.addAttribute("shareCount", addressService.getCount(s));
		}
		model.addAttribute("type", type);
		model.addAttribute("list_type", list_type);
		model.addAttribute("is_share", is_share);
		model.addAttribute("group_id", group_id != "" ? Integer.valueOf(group_id) : null);
		model.addAttribute("dept_id", dept_id != "" ? Integer.valueOf(dept_id) : null);
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		model.addAttribute("roleMenuList", super.gainRoleMenu(menu_id));
		return getPath(type == 1 ? "dep_list" : "group_list");
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @author davidwan
	 */
	private void getList(HttpServletRequest request, Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		int type = WebUtil.getInt(request, "type", 1);
		int is_share = WebUtil.getInt(request, "is_share", -1);
		int dept_id = WebUtil.getInt(request, "dept_id", 0);
		int group_id = WebUtil.getInt(request, "group_id", 0);
		String keyword = WebUtil.getString(request, "keyword", "");
		Address entity = new Address();
		if (StringUtils.isNotBlank(keyword)) {
			entity.getMap().put("keyword", keyword);
		}
		entity.setType(type);
		if (is_share != -1) {
			entity.setIs_share(is_share == 0 ? false : true);
		}
		if (dept_id != 0) {
			entity.setDept_id(dept_id);
		} else if (is_share != 1) {
			entity.setCreator_id(shiroUser.getId());
		} else if (is_share == 1) {
			entity.getMap().put("user_id_share", shiroUser.getId());
			entity.getMap().put("creator_id", shiroUser.getId());
		}
		if (group_id != 0) {
			entity.setGroup_id(group_id);
		} else if (is_share == -1) {
			entity.getMap().put("group_id_null", true);
		}

		model.addAttribute("dept_id", dept_id);
		model.addAttribute("is_allow", shiroUser.getIs_allowso());
		model.addAttribute("is_share", is_share);
		model.addAttribute("group_id", group_id);
		model.addAttribute("type", type);
		entity.getMap().put("sort", true);
		model.addAttribute("list", addressService.queryListHelp(entity));
	}

	/**
	 * @Title: add
	 * @Description: 进入添加页面
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request, int type, Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		model.addAttribute("type", type);
		if (type == 1) {
			Department d = new Department();
			model.addAttribute("departmentList", departmentService.queryList(d));
		} else {
			AddressGroup a = new AddressGroup();
			a.getMap().put("sort_order", true);
			a.setCreator_id(shiroUser.getId());
			model.addAttribute("groupList", addressGroupService.queryList(a));
		}
		return getPathAdd();
	}

	/**
	 * @Title: add
	 * @Description: Ajax保存添加数据
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult add(Address entity) {
		return addressService.create(entity);
	}

	/**
	 * @Title: update
	 * @Description: 进入添加页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/update")
	public String update(Integer id, Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		Address entity = addressService.findById(id);
		model.addAttribute("model", entity);

		if (entity.getType() == 1) {
			Department d = new Department();
			model.addAttribute("departmentList", departmentService.queryList(d));
		} else {
			AddressGroup a = new AddressGroup();
			a.getMap().put("sort_order", true);
			a.setCreator_id(shiroUser.getId());
			model.addAttribute("groupList", addressGroupService.queryList(a));
		}
		return getPathUpdate();
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult update(HttpServletRequest request, Address entity) {
		int old_id = WebUtil.getInt(request, "old_id", 0);
		// boolean old_share=WebUtil.getBoolean(request, "old_share", false);

		return addressService.modify(entity, old_id == 0 ? null : old_id);
	}

	/**
	 * @Title: update
	 * @Description: 进入添加页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/share")
	public String share(Integer id, Model model) {
		Address entity = addressService.findById(id);
		model.addAttribute("model", entity);

		return getPath("share");
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/share", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult share(HttpServletRequest request, Address entity) {

		return addressService.modify(entity.getAddressUserIds(), entity.getId());
	}

	/**
	 * @Title: update
	 * @Description: 进入添加页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/move")
	public String move(Integer id, Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		Address entity = addressService.findById(id);
		model.addAttribute("model", entity);

		AddressGroup a = new AddressGroup();
		a.getMap().put("sort_order", true);
		a.setCreator_id(shiroUser.getId());
		model.addAttribute("groupList", addressGroupService.queryList(a));
		return getPath("move");
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/move", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult move(HttpServletRequest request, Address entity) {
		int old_id = WebUtil.getInt(request, "old_id", 0);
		// boolean old_share=WebUtil.getBoolean(request, "old_share", false);

		return addressService.modify(entity.getGroup_id(), old_id == 0 ? null : old_id, entity.getId());
	}

	/**
	 * @Title: delete
	 * @Description: Ajax删除
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(Integer id, Integer user_id, Integer g_id, int type) {
		return addressService.removeById(id, user_id, g_id, type);
	}

	/**
	 * @Title: batchDelete
	 * @Description: Ajax批量删除
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batchdelete", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult batchDelete(String ids, Integer g_id, int type) {
		return addressService.removeByIds(ids, g_id, type);
	}

	/**
	 * @Description 进入详情页面
	 * @param id
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/view")
	public String view(Integer id, int is_share, Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		Address entity = addressService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("is_share", is_share);
		model.addAttribute("login_id", shiroUser.getId());
		return getPathView();
	}

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/sellist")
	public String sellist(HttpServletRequest request, Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();

		int type = 2;
		model.addAttribute("type", type);
		AddressGroup a = new AddressGroup();
		a.getMap().put("sort_order", true);
		a.setCreator_id(shiroUser.getId());
		model.addAttribute("addressGroupList", addressGroupService.queryList(a));
		Address s = new Address();
		s.setIs_share(false);
		s.setType(type);
		s.setCreator_id(shiroUser.getId());
		s.getMap().put("group_id_null", true);
		model.addAttribute("myCount", addressService.getCount(s));
		s = new Address();
		s.setType(type);
		s.setIs_share(true);
		s.getMap().put("user_id_share", shiroUser.getId());
		s.getMap().put("creator_id", shiroUser.getId());
		model.addAttribute("shareCount", addressService.getCount(s));
		return getPath("sellist");
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/seldatalist")
	public String seldatalist(HttpServletRequest request, Model model) {
		getList(request, model);
		return getPath("seldata_list");
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "address";
	}

	@Override
	public String getModuleName() {
		return "通讯录";
	}
}
