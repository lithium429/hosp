package com.xz.oa.core.web.controller.email;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.Email;
import com.xz.oa.core.domain.entity.EmailFile;
import com.xz.oa.core.domain.entity.EmailUser;
import com.xz.oa.core.domain.entity.User;
import com.xz.oa.core.domain.entity.UserHelp;
import com.xz.oa.core.service.email.EmailFileService;
import com.xz.oa.core.service.email.EmailService;
import com.xz.oa.core.service.email.EmailUserService;
import com.xz.oa.core.service.file.FileDownload;
import com.xz.oa.core.service.user.UserService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;
import com.xz.oa.core.web.controller.UploadSetController;

@Controller
@RequestMapping(value = "/email")
public class EmailController extends UploadSetController {

	@Resource
	private EmailService emailService;
	@Resource
	private EmailUserService emailUserService;
	@Resource
	private UserService userService;
	@Resource
	private EmailFileService emailFileService;

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
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/selUser")
	public String selUser(HttpServletRequest request, Model model) {
		String name = WebUtil.getString(request, "name", "");
		User u = new User();
		if (StringUtils.isNotBlank(name)) {
			u.getMap().put("real_name", name);
		}
		u.getMap().put("sort", true);
		u.getMap().put("id_vaild", true);
		model.addAttribute("userList", userService.queryListHelp(u));
		getList(request, model);
		return getPath("selUser");
	}

	/**
	 * @Description 获取首页列表数据
	 * @param isRead
	 * @return JsonResult
	 */
	@RequestMapping("/homelist")
	public @ResponseBody
	JsonResult homeList(Boolean isRead) {
		PageInfo<EmailUser> pageInfo = emailUserService.queryHomePageList(new EmailUser(), isRead, 1, 10);
		if (pageInfo != null) {
			return new JsonResult(true, null, pageInfo.getData());
		}
		return new JsonResult(false);
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
		String subject = WebUtil.getString(request, "subject", "");
		String sender_name = WebUtil.getString(request, "sender_name", "");
		String receiver_name = WebUtil.getString(request, "receiver_name", "");
		String create_time_min = WebUtil.getString(request, "create_time_min", "");
		String create_time_max = WebUtil.getString(request, "create_time_max", "");
		int type = WebUtil.getInt(request, "type", 0);
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		EmailUser entity = new EmailUser();
		if (StringUtils.isNotBlank(subject)) {
			entity.getMap().put("subject", subject);
		}
		if (StringUtils.isNotBlank(sender_name)) {
			entity.getMap().put("sender_name", sender_name);
		}
		if (StringUtils.isNotBlank(receiver_name)) {
			entity.getMap().put("receiver_name", receiver_name);
			if (type == 3) {
				entity.getMap().put("receiver_name_my", shiroUser.getName());
			}
		}
		if (StringUtils.isNotBlank(create_time_min)) {
			entity.getMap().put("create_time_min", DateUtil.strToDate(create_time_min, "yyyy-MM-dd"));
		}
		if (StringUtils.isNotBlank(create_time_max)) {
			entity.getMap().put("create_time_max", DateUtil.strToDate(create_time_max + " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
		}
		switch (type) {
		case 0:
			entity.setType((byte) 2);
			entity.setIs_delete(false);
			entity.setIs_send(true);
			entity.setUser_id(shiroUser.getId());
			break;
		case 1:
			entity.setType((byte) 1);
			entity.setIs_delete(false);
			entity.setIs_send(true);
			entity.setUser_id(shiroUser.getId());
			break;
		case 2:
			entity.setType((byte) 1);
			entity.setIs_delete(false);
			entity.setIs_send(false);
			entity.setUser_id(shiroUser.getId());
			break;
		case 3:
			entity.setIs_delete(true);
			entity.setUser_id(shiroUser.getId());
			break;
		}
		PageInfo<EmailUser> pageInfo = emailUserService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("type", type);
		model.addAttribute("menu_id", menu_id);
		model.addAttribute("roleMenuList", super.gainRoleMenu(menu_id));
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
		String from = WebUtil.getString(request, "from", "");
		int type = WebUtil.getInt(request, "type", -1);
		model.addAttribute("type", type);
		model.addAttribute("from", from);
		model.addAttribute("userList", getSysUsers());
		int user_id = WebUtil.getInt(request, "user_id", 0);
		if (user_id != 0) {
			model.addAttribute("user", userService.findById(user_id));
		}
		initConfigValues(model);
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
	JsonResult send(HttpServletRequest request, Email entity) {

		return emailService.create(entity);
	}

	/**
	 * @Title: add
	 * @Description: 进入添加页面
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping("/reply")
	public String reply(Integer id, HttpServletRequest request, Model model) {
		model.addAttribute("userList", getSysUsers());
		initConfigValues(model);
		EmailUser entity = emailUserService.findById(id);
		model.addAttribute("model", entity);
		int is_view = WebUtil.getInt(request, "is_view", 0);
		model.addAttribute("is_view", is_view);
		int type = WebUtil.getInt(request, "type", -1);
		model.addAttribute("type", type);
		return getPath("reply");
	}

	/**
	 * @Title: add
	 * @Description: Ajax保存添加数据
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult reply(HttpServletRequest request, Email entity) {

		return emailService.create(entity);
	}

	/**
	 * @Title: add
	 * @Description: 进入添加页面
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping("/forward")
	public String forward(Integer id, HttpServletRequest request, Model model) {
		model.addAttribute("userList", getSysUsers());
		initConfigValues(model);
		EmailUser entity = emailUserService.findById(id);
		model.addAttribute("model", entity);
		int is_view = WebUtil.getInt(request, "is_view", 0);
		model.addAttribute("is_view", is_view);
		int type = WebUtil.getInt(request, "type", -1);
		model.addAttribute("type", type);
		return getPath("forward");
	}

	/**
	 * @Title: add
	 * @Description: Ajax保存添加数据
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/forward", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult forward(HttpServletRequest request, Email entity) {

		return emailService.create(entity);
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
		return emailUserService.removeById(id);
	}

	/**
	 * @Title: batchDelete
	 * @Description: Ajax批量删除
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batchdelete", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult batchDelete(String ids, int type) {
		return emailUserService.removeByIds(ids, type);
	}

	/**
	 * @Title: delete
	 * @Description: Ajax删除
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/delete_logic", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult delete_logic(Integer id, int type) {
		EmailUser a = new EmailUser();
		a.setId(id);
		a.setIs_delete(true);
		return emailUserService.modify(a, type);
	}

	/**
	 * @Title: batchDelete
	 * @Description: Ajax批量删除
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batchdelete_logic", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult batchDelete_logic(String ids, int type) {
		EmailUser a = new EmailUser();
		a.getMap().put("ids", ids.split(","));
		a.setIs_delete(true);
		return emailUserService.modify(a, type);
	}

	/**
	 * @Title: batchDelete
	 * @Description: Ajax批量删除
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/read", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult read(String ids, int type) {
		EmailUser a = new EmailUser();
		a.getMap().put("ids", ids.split(","));
		a.setIs_read(true);
		return emailUserService.modify(a, type);
	}

	/**
	 * @Description 进入详情页面
	 * @param id
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Integer id, Model model) {
		EmailUser entity = emailUserService.findById(id);
		model.addAttribute("model", entity);
		int type = WebUtil.getInt(request, "type", -1);
		model.addAttribute("type", type);

		if (!entity.getIs_read()) {
			EmailUser a = new EmailUser();
			a.setId(id);
			a.setIs_read(true);
			emailUserService.modify(a, type);
		}
		return getPathView();
	}

	public List<UserHelp> getSysUsers() {
		User u = new User();
		u.getMap().put("sort", true);
		u.getMap().put("id_vaild", true);
		return userService.queryListHelp(u);
	}

	/**
	 * @Description 根据指定文件id下载文件
	 * @param id
	 * @param request
	 * @param response
	 *            void
	 */
	@RequestMapping("/download")
	public void download(Integer id, HttpServletRequest request, HttpServletResponse response) {
		EmailFile entity = emailFileService.findById(id);
		if (entity != null) {
			FileDownload download = new FileDownload(request, response);
			download.process(entity.getUrl(), entity.getName());
		}
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "email";
	}

	@Override
	public String getModuleName() {
		return "邮件";
	}
}
