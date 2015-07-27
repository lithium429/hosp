package com.xz.oa.core.web.controller.forum;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.WebUtil; 
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.ForumPost;
import com.xz.oa.core.domain.entity.ForumThread;
import com.xz.oa.core.service.forum.ForumPostService;
import com.xz.oa.core.service.forum.ForumThreadService; 
import com.xz.oa.core.web.controller.UploadSetController;

@Controller
@RequestMapping(value = "/forum/post")
public class ForumPostController extends UploadSetController {

	@Resource
	private ForumPostService forumPostService;

	@Resource
	private ForumThreadService forumThreadService;

	/**
	 * @Description 进入列表页面
	 * @param request
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
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		String name = WebUtil.getString(request, "name", "");
		ForumPost entity = new ForumPost();
		if (StringUtils.isNotBlank(name)) {
			// entity.setName(name);
		}
		PageInfo<ForumPost> pageInfo = forumPostService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
	}

	/**
	 * @Title: add
	 * @Description: 进入添加页面
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping("/add")
	public String add(ForumPost entity, Integer reply_count, Integer page_index, Model model) {
		model.addAttribute("model", entity);
		model.addAttribute("reply_count", reply_count);

		ForumThread thread = forumThreadService.findById(entity.getThread_id());
		model.addAttribute("thread", thread);

		if (entity.getReplyed_id() != null) {
			ForumPost replyedPost = forumPostService.findById(entity.getReplyed_id());
			model.addAttribute("replyedPost", replyedPost);
		}

		if (page_index == null) {
			model.addAttribute("pageIndex", 1);
		} else {
			model.addAttribute("pageIndex", page_index);
		}
		
		initConfigValues(model);

		return getPathAdd();
	}

	/**
	 * @Title: add
	 * @Description: Ajax保存添加数据
	 * @param entity
	 * @param reply_count
	 * @param session
	 * @return JsonResult
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult add(ForumPost entity, Integer reply_count, HttpSession session) {
		entity.setCreate_time(new Date());
		entity.setCreator_id(getCurrentUserId());
		return forumPostService.create(entity, reply_count, session);
	}

	/**
	 * @Title: update
	 * @Description: 进入修改页面
	 * @param id
	 * @param replyed_id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/update")
	public String update(Integer id, Integer replyed_id, Model model) {
		ForumPost entity = forumPostService.findById(id);
		model.addAttribute("model", entity);

		ForumThread thread = forumThreadService.findById(entity.getThread_id());
		model.addAttribute("thread", thread);
		
		if (replyed_id != null) {
			ForumPost replyedPost = forumPostService.findById(replyed_id);
			model.addAttribute("replyedPost", replyedPost);
		}
		
		initConfigValues(model);

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
	JsonResult update(ForumPost entity) {
		return forumPostService.modify(entity);
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
		return forumPostService.removeById(id);
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
		return forumPostService.removeByIds(ids);
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
		ForumPost entity = forumPostService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "forumPost";
	}

	@Override
	public String getModuleName() {
		return "模块名称";
	}
}
