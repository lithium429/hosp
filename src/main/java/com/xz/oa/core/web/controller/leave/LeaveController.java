package com.xz.oa.core.web.controller.leave;

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

import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.DateUtil;
import com.xz.base.utils.WebUtil;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.Leave;
import com.xz.oa.core.domain.entity.LeaveVerifyRecord;
import com.xz.oa.core.service.leave.LeaveService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/leave")
public class LeaveController extends SpringBaseController {

	@Resource
	private LeaveService leaveService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		getList(request, model);
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
		return getPath("data_list");
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
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		int type_key = WebUtil.getInt(request, "type_key", 0);
		int type = WebUtil.getInt(request, "type", 0);
		String staff_name = WebUtil.getString(request, "staff_name", "");
		String verify_user_name = WebUtil.getString(request, "verify_user_name", "");
		String verify_states = WebUtil.getString(request, "verify_states", "");
		String start_time_min = WebUtil.getString(request, "start_time_min", "");
		String start_time_max = WebUtil.getString(request, "start_time_max", "");
		String end_time_min = WebUtil.getString(request, "end_time_min", "");
		String end_time_max = WebUtil.getString(request, "end_time_max", "");
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		Leave entity = new Leave();
		if (StringUtils.isNotBlank(staff_name)) {
			entity.getMap().put("staff_name", staff_name);
		}
		if (StringUtils.isNotBlank(verify_user_name)) {
			entity.getMap().put("verify_user_name", verify_user_name);
		}
		if (StringUtils.isNotBlank(verify_states)) {
			entity.getMap().put("verify_states", verify_states.split(","));
		}
		if (StringUtils.isNotBlank(start_time_min)) {
			entity.getMap().put("start_time_min", DateUtil.strToDate(start_time_min, DateUtil.DAY_TIME_MINUTE_TYPE));
		}
		if (StringUtils.isNotBlank(start_time_max)) {
			entity.getMap().put("start_time_max", DateUtil.strToDate(start_time_max, DateUtil.DAY_TIME_MINUTE_TYPE));
		}
		if (StringUtils.isNotBlank(end_time_min)) {
			entity.getMap().put("end_time_min", DateUtil.strToDate(end_time_min, DateUtil.DAY_TIME_MINUTE_TYPE));
		}
		if (StringUtils.isNotBlank(end_time_max)) {
			entity.getMap().put("end_time_max", DateUtil.strToDate(end_time_max, DateUtil.DAY_TIME_MINUTE_TYPE));
		}
		if (type != 0) {
			entity.setType(type);
		}
		if (type_key == 1) {
			entity.setVerify_user_id(shiroUser.getId());
		}else{
			entity.setCreator_id(shiroUser.getId());
		}
		PageInfo<Leave> pageInfo = leaveService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("menu_id", menu_id);
		model.addAttribute("type_key", type_key);
		model.addAttribute("roleMenuList", super.gainRoleMenu(menu_id));
	}

	/**
	 * @Title: add
	 * @Description: 进入添加页面
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
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
	JsonResult add(Leave entity) {
		return leaveService.create(entity);
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
		Leave entity = leaveService.findById(id);
		model.addAttribute("model", entity);
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
	JsonResult update(Leave entity) {
		return leaveService.modify(entity);
	}

	/**
	 * @Title: delete
	 * @Description: Ajax删除
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete(Integer id) {
		return leaveService.removeById(id);
	}

	/**
	 * @Title: batchDelete
	 * @Description: Ajax批量删除
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batchdelete", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult batchDelete(String ids) {
		return leaveService.removeByIds(ids);
	}

	/**
	 * @Description 进入详情页面
	 * @param id
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/view")
	public String view(Integer id, Model model) {
		Leave entity = leaveService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	/**
	 * @Title: haddle
	 * @Description: 进入退回页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("check")
	public String check(HttpServletRequest request, Integer id, Model model) {
		int state = WebUtil.getInt(request, "state", 0);
		model.addAttribute("state", state);
		model.addAttribute("id", id);
		return getPath("change");
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult change(LeaveVerifyRecord entity, HttpServletRequest request, int state) {
		int id = WebUtil.getInt(request, "id", 0);
		String ids = WebUtil.getString(request, "ids", "");
		// String contnet = WebUtil.getString(request, "contnet", "");
		return leaveService.modifyChange(id, ids, state, entity.getContent());
	}
	
	/**
	 * @Title: verify
	 * @Description: 进入审批页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("verify")
	public String verify(Integer id, Model model) {
		Leave entity = leaveService.findById(id);
		model.addAttribute("model", entity);
		return getPath("verify");
	}
	
	/**
	 * @Title: verify
	 * @Description: Ajax保存审批信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult verify(LeaveVerifyRecord entity, HttpServletRequest request, int state) {
		int id = WebUtil.getInt(request, "id", 0); 
		return leaveService.modifyChange(id, null, state, entity.getContent());
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "leave";
	}

	@Override
	public String getModuleName() {
		return "模块名称";
	}
}
