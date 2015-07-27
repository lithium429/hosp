package com.xz.oa.core.web.controller.sms;

import java.util.List;

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
import com.xz.oa.core.domain.entity.Sms;
import com.xz.oa.core.domain.entity.SmsTpl;
import com.xz.oa.core.service.sms.SmsService;
import com.xz.oa.core.service.sms.SmsTplService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;
import com.xz.oa.core.service.user.UserService;

@Controller
@RequestMapping(value = "/sms")
public class SmsController extends SpringBaseController {

	@Resource
	private SmsService smsService;
	@Resource
	private SmsTplService smsTplService;
	@Resource
	private UserService userService;

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
		int state = WebUtil.getInt(request, "state", 0);
		int type = WebUtil.getInt(request, "type", 0);
		String sender_name = WebUtil.getString(request, "sender_name", "");
		String content = WebUtil.getString(request, "content", "");
		String create_time_min = WebUtil.getString(request, "create_time_min", "");
		String create_time_max = WebUtil.getString(request, "create_time_max", "");
		int date_type = WebUtil.getInt(request, "date_type", 0);
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		Sms entity = new Sms();
		if (date_type != 0) {
			switch (date_type) {
			case 1:
				entity.getMap().put("create_time_sel", DateUtil.strToDate(DateUtil.todayStart()));
				break;
			case 2:
				entity.getMap().put("create_time_sel", DateUtil.getThisWeekStart());
				break;
			case 3:
				entity.getMap().put("create_time_sel", DateUtil.getThisMouthStart());
				break;
			case 4:
				entity.getMap().put("create_time_sel", DateUtil.getThisYearStart());
				break;
			}
		}
		if (StringUtils.isNotBlank(sender_name)) {
			entity.getMap().put("sender_name", sender_name);
		}
		if (StringUtils.isNotBlank(content)) {
			entity.getMap().put("content", content);
		}
		if (StringUtils.isNotBlank(create_time_min)) {
			entity.getMap().put("create_time_min", DateUtil.strToDate(create_time_min, "yyyy-MM-dd"));
		}
		if (StringUtils.isNotBlank(create_time_max)) {
			entity.getMap().put("create_time_max", DateUtil.strToDate(create_time_max+" 23:59:59", "yyyy-MM-dd HH:mm:ss"));
		}
		if (state != 0) {
			entity.setState(state);
		}
		if (type == 0) {
			entity.getMap().put("my_id", shiroUser.getId());
		}
		entity.getMap().put("sort", true);
		PageInfo<Sms> pageInfo = smsService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("scount", smsService.queryScount(entity));
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("type", type);
		model.addAttribute("menu_id", menu_id);
		model.addAttribute("roleMenuList",super.gainRoleMenu(menu_id) );
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
	JsonResult add(Sms entity) {
		return smsService.create(entity, "", "", "");
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
		Sms entity = smsService.findById(id);
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
	JsonResult update(Sms entity, Model model) {
		return smsService.modify(entity);
	}

	/**
	 * @Title: add
	 * @Description: 进入添加页面
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping("/send")
	public String send(HttpServletRequest request, Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		int type = WebUtil.getInt(request, "type", -1);
		//int user_id = WebUtil.getInt(request, "user_id",0);
		
		model.addAttribute("type", type);
		model.addAttribute("is_allowso", shiroUser.getIs_allowso());
		model.addAttribute("tplList", getSmsTplList());
		int user_id = WebUtil.getInt(request, "user_id", 0);
		if(user_id!=0)
		{
			model.addAttribute("user", userService.findById(user_id));
		}
		
		return getPath("send");
	}

	/**
	 * @Title: add
	 * @Description: Ajax保存添加数据
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult send(HttpServletRequest request, Sms entity) {
		String innerUsers = WebUtil.getString(request, "innerUsers", "");
		String outerUsers = WebUtil.getString(request, "outerUsers", "");
		String otherUser = WebUtil.getString(request, "otherUser", "");
		return smsService.create(entity, innerUsers, outerUsers, otherUser);
	}

	/**
	 * @Title: add
	 * @Description: Ajax保存添加数据
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/send_again", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult send_again(HttpServletRequest request) {
		String ids = WebUtil.getString(request, "ids", "");
		int id = WebUtil.getInt(request, "id", 0);
		return smsService.modifySend_again(id, ids);
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
		return smsService.removeById(id);
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
		return smsService.removeByIds(ids);
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
		Sms entity = smsService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	// 获取短信模板集合
	public List<SmsTpl> getSmsTplList() {
		SmsTpl m = new SmsTpl();
		m.setType(1);
		m.getMap().put("sort", true);
		return smsTplService.queryList(m);
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "sms";
	}

	@Override
	public String getModuleName() {
		return "短信管理";
	}
}
