package com.xz.oa.core.web.controller.forum;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 

import com.xz.base.model.PageInfo;
import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.DateUtil;
import com.xz.base.utils.WebUtil;
import com.xz.oa.core.domain.entity.ForumFile;
import com.xz.oa.core.domain.entity.ForumPlate;
import com.xz.oa.core.domain.entity.ForumPost;
import com.xz.oa.core.domain.entity.ForumThread;
import com.xz.oa.core.domain.enums.EnumGuideType;
import com.xz.oa.core.service.file.FileDownload;
import com.xz.oa.core.service.forum.ForumFileService;
import com.xz.oa.core.service.forum.ForumPlateService;
import com.xz.oa.core.service.forum.ForumPostService;
import com.xz.oa.core.service.forum.ForumThreadService;
import com.xz.oa.core.web.controller.UploadSetController;

@Controller
@RequestMapping(value = "/forum")
public class ForumController extends UploadSetController {

	private static final String IS_VIEW = "is_view";
	private static final int TOP_PAGE_SIZE = 10;

	@Resource
	private ForumPlateService forumPlateService;

	@Resource
	private ForumThreadService forumThreadService;

	@Resource
	private ForumPostService forumPostService;

	@Resource
	private ForumFileService forumFileService;

	/**
	 * @Description 进入首页
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/index")
	public String index(Model model) {
		initData(model);

		// 今日帖子数量
		ForumPost post = new ForumPost();
		String dateText = DateUtil.dateToStr(new Date(), "yyyy-MM-dd");
		post.getMap().put("today", true);
		post.getMap().put("today_start", dateText + " 00:00:00");
		post.getMap().put("today_end", dateText + " 23:59:59");
		post.setIs_delete(false);
		int todayCount = forumPostService.gainTotalCount(post);
		model.addAttribute("todayCount", todayCount);

		// 帖子数量
		post = new ForumPost();
		post.setIs_delete(false);
		int postCount = forumPostService.gainTotalCount(post);
		model.addAttribute("postCount", postCount);

		// 最新列表
		ForumThread thread = new ForumThread(false);
		thread.getMap().put("sort", true);
		PageInfo<ForumThread> pageInfo = forumThreadService.queryPageList(thread, 1, TOP_PAGE_SIZE);
		model.addAttribute("newThreadList", pageInfo.getData());
		model.addAttribute("threadCount", pageInfo.getRecordCount());

		// 最新回复列表
		thread = new ForumThread(false);
		thread.getMap().put("sort_last_post_time", true);
		pageInfo = forumThreadService.queryPageList(thread, 1, TOP_PAGE_SIZE);
		model.addAttribute("newReplyThreadList", pageInfo.getData());

		// 最热列表
		thread = new ForumThread(false);
		thread.getMap().put("sort_reply_count", true);
		pageInfo = forumThreadService.queryPageList(thread, 1, TOP_PAGE_SIZE);
		model.addAttribute("hotThreadList", pageInfo.getData());

		return getPath("index");
	}

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list/{plate_id}")
	public String threadList(@PathVariable(value = "plate_id") Integer plateId, Model model) {
		initData(model);
		initConfigValues(model);
		gainThreadPageData(plateId, 1, model);
		return getPathList();
	}

	/**
	 * @Description 获取列表大于第一页的数据
	 * @param typeId
	 * @param pageIndex
	 * @param model
	 * @return String
	 */
	@RequestMapping("/list/{plate_id}/{page_index}")
	public String homeListPage(@PathVariable(value = "plate_id") Integer plateId, @PathVariable(value = "page_index") Integer pageIndex, Model model) {
		initData(model);
		gainThreadPageData(plateId, pageIndex, model);
		return getPath("list");
	}

	/**
	 * @Description 获取分页数据
	 * @param plateId
	 * @param pageIndex
	 * @param model
	 */
	private void gainThreadPageData(Integer plateId, Integer pageIndex, Model model) {
		ForumPlate plate = forumPlateService.findById(plateId);
		ForumThread entity = new ForumThread(plateId, false);
		entity.getMap().put("sort", true);
		PageInfo<ForumThread> pageInfo = forumThreadService.queryPageList(entity, pageIndex, ConfigValue.PAGE_SIZE);

		model.addAttribute("plate", plate);
		model.addAttribute("plateId", plateId);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "forum/list/" + plateId);

		// 今日帖子数量
		ForumPost post = new ForumPost();
		String dateText = DateUtil.dateToStr(new Date(), "yyyy-MM-dd");
		post.getMap().put("today", true);
		post.getMap().put("today_start", dateText + " 00:00:00");
		post.getMap().put("today_end", dateText + " 23:59:59");
		post.setIs_delete(false);
		post.setPlate_id(plateId);
		int todayCount = forumPostService.gainTotalCount(post);
		model.addAttribute("todayCount", todayCount);

		// 上传配置
		initConfigValues(model);
	}

	/**
	 * @Description 进入详情页面
	 * @param id
	 * @param model
	 * @param session
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/thread/{id}")
	public String thread(@PathVariable(value = "id") Integer id, Model model, HttpSession session, HttpServletRequest request) {
		// 增加浏览次数，基于Session
		if (session.getAttribute(IS_VIEW + id) == null) {
			session.setAttribute(IS_VIEW + id, true);
			forumThreadService.modifyForViewCount(id);
		}

		ForumThread thread = forumThreadService.findById(id);
		ForumPlate plate = forumPlateService.findById(thread.getPlate_id());

		ForumThread prevEntity = forumThreadService.findPrevByCurrentId(id, plate.getId());
		ForumThread nextEntity = forumThreadService.findNextByCurrentId(id, plate.getId());

		boolean isPlateAdmin = forumPlateService.judgePlateUser(plate.getId(), getCurrentUserId());

		model.addAttribute("thread", thread);
		model.addAttribute("plate", plate);
		model.addAttribute("plateId", plate.getId());
		model.addAttribute("prevThread", prevEntity);
		model.addAttribute("nextThread", nextEntity);
		model.addAttribute("refererUrl", request.getHeader("Referer"));
		model.addAttribute("isPlateAdmin", isPlateAdmin);

		Integer authorId = WebUtil.getInteger(request, "author_id", null);
		gainPostPageData(thread.getId(), 1, authorId, model);

		return getPath("thread");
	}

	/**
	 * @Description 进入详情页面
	 * @param id
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/thread/{id}/{page_index}")
	public String thread(@PathVariable(value = "id") Integer id, @PathVariable(value = "page_index") Integer pageIndex, Integer author_id, Model model) {
		ForumThread thread = forumThreadService.findById(id);
		ForumPlate plate = forumPlateService.findById(thread.getPlate_id());

		model.addAttribute("thread", thread);
		model.addAttribute("plate", plate);
		model.addAttribute("plateId", plate.getId());

		gainPostPageData(thread.getId(), pageIndex, author_id, model);

		return getPath("thread");
	}

	/**
	 * @Description 获取分页数据
	 * @param threadId
	 * @param pageIndex
	 * @param authorId
	 * @param model
	 */
	private void gainPostPageData(Integer threadId, Integer pageIndex, Integer authorId, Model model) {
		ForumPost entity = new ForumPost(threadId, false);
		entity.getMap().put("sort_thread", true);
		entity.setCreator_id(authorId);
		PageInfo<ForumPost> pageInfo = forumPostService.queryPageList(entity, pageIndex, ConfigValue.PAGE_SIZE);

		if (pageInfo != null && pageInfo.getRecordCount() > 0) {
			model.addAttribute("reply_count", pageInfo.getRecordCount());
		} else {
			model.addAttribute("reply_count", 1);
		}
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("pageIndex", pageIndex);
		model.addAttribute("url", "forum/thread/" + threadId);
		if (authorId != null) {
			model.addAttribute("queryParam", "?author_id=" + authorId);
			model.addAttribute("author_id", authorId);
		}
	}

	/**
	 * @Description
	 * @param type
	 * @param model
	 * @return String
	 */
	@RequestMapping("/guidelist/{type}/{page_index}")
	public String guideList(@PathVariable(value = "type") Integer type, @PathVariable(value = "page_index") Integer pageIndex, Model model) {
		model.addAttribute("type", type);
		model.addAttribute("typeText", EnumGuideType.fromInt(type));
		gainGuideThreadPageData(type, pageIndex, model);
		return getPath("guidelist");
	}

	/**
	 * @Description
	 * @param type
	 * @param model
	 * @return String
	 */
	@RequestMapping("/guidelist/{type}")
	public String guideList(@PathVariable(value = "type") Integer type, Model model) {
		model.addAttribute("type", type);
		model.addAttribute("typeText", EnumGuideType.fromInt(type));
		gainGuideThreadPageData(type, 1, model);
		return getPath("guidelist");
	}

	/**
	 * @Description 获取分页数据
	 * @param plateId
	 * @param pageIndex
	 * @param model
	 */
	private void gainGuideThreadPageData(Integer type, Integer pageIndex, Model model) {
		ForumThread entity = new ForumThread(false);
		if (type == EnumGuideType.最热主题.getValue()) {
			entity.getMap().put("sort_reply_count", true);
		} else if (type == EnumGuideType.最新回复.getValue()) {
			entity.getMap().put("sort_last_post_time", true);
		} else if (type == EnumGuideType.最新发表.getValue()) {
			entity.getMap().put("sort", true);
		}

		PageInfo<ForumThread> pageInfo = forumThreadService.queryPageList(entity, pageIndex, ConfigValue.PAGE_SIZE);

		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "forum/guidelist/" + type);
	}

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/search")
	public String searchList(HttpServletRequest request, Model model) {
		gainSearchPageData(request, 1, model);
		return getPath("search");
	}

	/**
	 * @Description 获取列表大于第一页的数据
	 * @param request
	 * @param pageIndex
	 * @param model
	 * @return String
	 */
	@RequestMapping("/search/{page_index}")
	public String searchListPage(HttpServletRequest request, @PathVariable(value = "page_index") Integer pageIndex, Model model) {
		gainSearchPageData(request, pageIndex, model);
		return getPath("search");
	}

	/**
	 * @Description 获取分页数据
	 * @param plateId
	 * @param pageIndex
	 * @param model
	 */
	private void gainSearchPageData(HttpServletRequest request, Integer pageIndex, Model model) {
		String keyword = WebUtil.getString(request, "search_key", "");
		ForumThread entity = new ForumThread(false);
		entity.getMap().put("sort", true);
		if (StringUtils.isNotBlank(keyword)) {
			entity.getMap().put("keyword", keyword);
		}
		PageInfo<ForumThread> pageInfo = forumThreadService.queryPageList(entity, pageIndex, ConfigValue.PAGE_SIZE);

		model.addAttribute("search_key", keyword);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "forum/search");
	}

	/**
	 * @Description 下载指定文件
	 * @param id
	 * @param request
	 * @param response
	 *            void
	 */
	@RequestMapping("/file/download/{id}")
	public void download(@PathVariable(value = "id") Integer id, HttpServletRequest request, HttpServletResponse response) {
		ForumFile entity = forumFileService.findById(id);
		if (entity != null) {
			FileDownload download = new FileDownload(request, response);
			download.process(entity.getUrl(), entity.getName());
		}
	}

	/**
	 * @Description 获取初始化数据
	 * @param model
	 */
	private void initData(Model model) {
		ForumPlate entity = new ForumPlate();
		entity.getMap().put("sort_asc", true);
		List<ForumPlate> list = forumPlateService.queryList(entity);
		model.addAttribute("plateList", list);
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "forum";
	}

	@Override
	public String getModuleName() {
		return "论坛";
	}
}
