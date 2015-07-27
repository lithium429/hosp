package com.xz.oa.core.web.controller.advice;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.DateUtil;
import com.xz.base.utils.WebUtil;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.Advice;
import com.xz.oa.core.domain.entity.AdviceConfig;
import com.xz.oa.core.domain.entity.AdviceTopic;
import com.xz.oa.core.service.advice.AdviceConfigService;
import com.xz.oa.core.service.advice.AdviceService;
import com.xz.oa.core.service.advice.AdviceTopicService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/advice")
public class AdviceController extends SpringBaseController {

	@Resource
	private AdviceService adviceService;

	@Resource
	private AdviceTopicService adviceTopicService;

	@Resource
	private AdviceConfigService adviceConfigService;

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
		model.addAttribute("topicList", getTopicList());
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
		int topic_id = WebUtil.getInt(request, "topic_id", 0);
		int type = WebUtil.getInt(request, "type", 0);
		int state = WebUtil.getInt(request, "state", 0);
		int my_type = WebUtil.getInt(request, "my_type", 0);
		String user_name = WebUtil.getString(request, "user_name", "");
		String title = WebUtil.getString(request, "title", "");
		String create_time_min = WebUtil.getString(request, "create_time_min", "");
		String create_time_max = WebUtil.getString(request, "create_time_max", "");
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		Advice entity = new Advice();
		if (StringUtils.isNotBlank(user_name)) {
			entity.getMap().put("user_name", user_name);
		}
		if (StringUtils.isNotBlank(title)) {
			entity.getMap().put("title", title);
		}
		if (topic_id != 0) {
			entity.setTopic_id(topic_id);
		}
		if (type != 0) {
			entity.setType(type);
		}
		if (state != 0) {
			entity.setState(state);
		}
		if (StringUtils.isNotBlank(create_time_min)) {
			entity.getMap().put("create_time_min", DateUtil.strToDate(create_time_min + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		}
		if (StringUtils.isNotBlank(create_time_max)) {
			entity.getMap().put("create_time_max", DateUtil.strToDate(create_time_max + " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
		}
		if (my_type == 1) {
			entity.setUser_id(shiroUser.getId());
		}
		entity.getMap().put("sort", true);
		PageInfo<Advice> pageInfo = adviceService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("my_type", my_type);
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
	@RequestMapping("/add")
	public String add(HttpServletRequest request, Model model) {
		model.addAttribute("topicList", getTopicList());
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
	JsonResult add(Advice entity) {
		return adviceService.create(entity);
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
		Advice entity = adviceService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("topicList", getTopicList());
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
	JsonResult update(Advice entity) {
		return adviceService.modify(entity);
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
		return adviceService.removeById(id);
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
		return adviceService.removeByIds(ids);
	}

	/**
	 * @Title: delete
	 * @Description: Ajax删除
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult change(Integer id, int is_open) {
		Advice entity = new Advice();
		entity.setId(id);
		entity.setIs_open(is_open == 1);
		return adviceService.modify(entity);
	}

	/**
	 * @Title: batchDelete
	 * @Description: Ajax批量删除
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batchchange", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult batchChange(String ids, int is_open) {
		Advice entity = new Advice();
		entity.getMap().put("ids", ids.split(","));
		entity.setIs_open(is_open == 1);
		return adviceService.modify(entity);
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
		Advice entity = adviceService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	public List<AdviceTopic> getTopicList() {
		AdviceTopic t = new AdviceTopic();
		t.getMap().put("sort_order", true);
		List<AdviceTopic> list = adviceTopicService.queryList(t);
		return list;
	}

	/**
	 * @Title: batchDelete
	 * @Description: 验证标题重名
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/validateTitle", method = RequestMethod.POST)
	public @ResponseBody
	boolean validateTitle(Integer id, String title) {
		boolean result = adviceService.validateTitle(id, title);
		return result;
	}

	/**
	 * @Title: update
	 * @Description: 进入添加页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/haddle")
	public String haddle(HttpServletRequest request, Model model) {
		int id = WebUtil.getInt(request, "id", 0);
		if (id != 0) {
			model.addAttribute("id", id);
		}
		return getPath("haddle");
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/haddle", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult haddle(HttpServletRequest request) {
		int id = WebUtil.getInt(request, "id", 0);
		String ids = WebUtil.getString(request, "ids", "");
		String content = WebUtil.getString(request, "content", "");
		return adviceService.modifyHaddle(id, ids, content);
	}

	/**
	 * @Description 进入书记院长信箱 -受理说明
	 * @param model
	 * @return String
	 */
	@RequestMapping("/home/instruction")
	public String homeInstruction(Model model) {
		AdviceConfig ac = new AdviceConfig();
		model.addAttribute("config", adviceConfigService.find(ac));
		return getPath("home/instruction");
	}

	/**
	 * @Description 进入书记院长信箱 -管理办法
	 * @param model
	 * @return String
	 */
	@RequestMapping("/home/regulation")
	public String homeRegulation(Model model) {
		AdviceConfig ac = new AdviceConfig();
		model.addAttribute("config", adviceConfigService.find(ac));
		return getPath("home/regulation");
	}

	/**
	 * @Description 进入书记院长信箱 -我要写信
	 * @param model
	 * @return String
	 */
	@RequestMapping("/home/add")
	public String homeAdd(Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();

		model.addAttribute("shiroUser", shiroUser);
		model.addAttribute("topicList", getTopicList());
		return getPath("home/add");
	}

	/**
	 * @Description 获取列表第一页数据
	 * @param typeId
	 * @param model
	 * @return String
	 */
	@RequestMapping("/home/list")
	public String homeList(Model model) {

		gainPageData(1, model);
		return getPath("home/list");
	}

	/**
	 * @Description 获取列表大于第一页的数据
	 * @param typeId
	 * @param pageIndex
	 * @param model
	 * @return String
	 */
	@RequestMapping("/home/list/{page_index}")
	public String homeListPage(@PathVariable(value = "page_index") Integer pageIndex, Model model) {

		gainPageData(pageIndex, model);
		return getPath("home/list");
	}

	/**
	 * @Description 获取分页数据
	 * @param typeId
	 * @param pageIndex
	 * @param model
	 */
	private void gainPageData(Integer pageIndex, Model model) {
		Advice entity = new Advice();
		entity.setIs_open(true);
		entity.getMap().put("sort", true);
		PageInfo<Advice> pageInfo = adviceService.queryPageList(entity, pageIndex, ConfigValue.PAGE_SIZE);

		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "advice/home/list");
	}

	/**
	 * @Description
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/home/details/{id}")
	public String homeDetials(@PathVariable(value = "id") Integer id, Model model) {

		Advice entity = adviceService.findById(id);
		model.addAttribute("model", entity);

		Advice prevEntity = adviceService.findPrevByCurrentId(id);
		Advice nextEntity = adviceService.findNextByCurrentId(id);
		model.addAttribute("prevAdvice", prevEntity);
		model.addAttribute("nextAdvice", nextEntity);

		return getPath("home/details");
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "advice";
	}

	@Override
	public String getModuleName() {
		return "信件管理";
	}
}
