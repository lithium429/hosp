package com.xz.oa.core.web.controller.forum;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.coobird.thumbnailator.Thumbnails;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.AvatarJsonResult;
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.IOHelper;
import com.xz.base.utils.LogHelper;
import com.xz.base.utils.StringUtil;
import com.xz.oa.core.domain.entity.ForumThread;
import com.xz.oa.core.domain.entity.ForumUser;
import com.xz.oa.core.domain.entity.ForumUserFav;
import com.xz.oa.core.domain.entity.LoginLog;
import com.xz.oa.core.domain.entity.User;
import com.xz.oa.core.domain.enums.EnumForumUserCenter;
import com.xz.oa.core.service.file.FileUpload;
import com.xz.oa.core.service.forum.ForumPostService;
import com.xz.oa.core.service.forum.ForumThreadService;
import com.xz.oa.core.service.forum.ForumUserService;
import com.xz.oa.core.service.log.LoginLogService;
import com.xz.oa.core.service.user.UserService;

@Controller
@RequestMapping(value = "/forum/user")
public class ForumUserController extends SpringBaseController {

	@Resource
	private ForumUserService forumUserService;

	@Resource
	private ForumThreadService forumThreadService;

	@Resource
	private ForumPostService forumPostService;

	@Resource
	private UserService userService;

	@Resource
	private LoginLogService loginLogService;

	/**
	 * @Description 进入用户信息页面
	 * @param id
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/{id}")
	public String userInfo(@PathVariable(value = "id") Integer id, Model model) {
		initInfo(id, EnumForumUserCenter.个人资料, model);

		User user = userService.findById(id);
		ForumUser forumUser = forumUserService.find(new ForumUser(id));
		LoginLog loginLog = loginLogService.queryLastedLog(new LoginLog(id));
		model.addAttribute("loginLog", loginLog);

		model.addAttribute("userInfo", user);
		model.addAttribute("forumUser", forumUser);
		model.addAttribute("type", EnumForumUserCenter.个人资料.getValue());
		model.addAttribute("typeText", EnumForumUserCenter.个人资料);
		model.addAttribute("typeUrl", "forum/user/" + id + ".shtml");

		return getPath("index");
	}

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/avatar")
	public String avatar(HttpServletRequest request, Model model) {
		initInfo(null, EnumForumUserCenter.头像设置, model);

		model.addAttribute("type", EnumForumUserCenter.头像设置.getValue());
		model.addAttribute("typeText", EnumForumUserCenter.头像设置);
		model.addAttribute("typeUrl", "forum/user/avatar.shtml");

		ForumUser forumUser = new ForumUser(getCurrentUserId());
		forumUser = forumUserService.find(forumUser);
		if (forumUser != null && StringUtils.isNotBlank(forumUser.getBicon_url())) {
			model.addAttribute("img_url", forumUser.getBicon_url().replace("_b", ""));
		} else {
			model.addAttribute("img_url", "static/images/forum/noavatar_big.gif");
		}

		return getPath("avatar");
	}

	/**
	 * @Title: avatar
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/avatar", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult update(ForumUser entity) {
		return forumUserService.modify(entity);
	}

	/**
	 * @Description 处理头像上传
	 * @param request
	 * @return JsonResult
	 */
	@RequestMapping("/upload")
	public @ResponseBody
	AvatarJsonResult upload(HttpServletRequest request) {
		FileUpload upload = new FileUpload(request);
		JsonResult result = (JsonResult) upload.processOther();

		if (result.isFlag() && result.getObj() != null) {
			// 保存文件到数据库
			String obj = result.getObj().toString();
			String[] objArray = StringUtil.split(obj, "|");
			String filePath = objArray[0];
			String fileUrl = objArray[1];

			String bfilePath = IOHelper.rename(filePath, "_b");
			String mfilePath = IOHelper.rename(filePath, "_m");
			String sfilePath = IOHelper.rename(filePath, "_s");

			String bfileUrl = IOHelper.rename(fileUrl, "_b");
			String mfileUrl = IOHelper.rename(fileUrl, "_m");
			String sfileUrl = IOHelper.rename(fileUrl, "_s");
			try {
				Thumbnails.of(filePath).scale(1d).toFile(bfilePath);
				Thumbnails.of(filePath).scale(0.6d).toFile(mfilePath);
				Thumbnails.of(filePath).scale(0.24d).toFile(sfilePath);

				ForumUser forumUser = new ForumUser(getCurrentUserId(), bfileUrl, mfileUrl, sfileUrl);
				result = forumUserService.modify(forumUser);
				if (!result.isFlag()) {
					return new AvatarJsonResult(-2);
				} else {
					request.getSession().removeAttribute(ForumUserService.FORUM_LOGIN_USER);
				}

			} catch (Exception e) {
				LogHelper.getLogger().error("保存头像出错", e);
			}

			return new AvatarJsonResult(1);
		} else {
			return new AvatarJsonResult(-2);
		}
	}

	/**
	 * @Description 进入列表页面
	 * @param uid
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/thread")
	public String thread(Integer uid, Model model) {
		gainThreadPageData(uid, 1, model);
		return getPath("thread");
	}

	/**
	 * @Description 进入列表页面
	 * @param uid
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/thread/{page_index}")
	public String thread(Integer uid, @PathVariable(value = "page_index") Integer pageIndex, Model model) {
		gainThreadPageData(uid, pageIndex, model);
		return getPath("thread");
	}

	/**
	 * @Description 获取分页数据
	 * @param userId
	 * @param pageIndex
	 * @param model
	 */
	private void gainThreadPageData(Integer userId, Integer pageIndex, Model model) {
		model.addAttribute("type", EnumForumUserCenter.我的主题.getValue());
		model.addAttribute("typeText", EnumForumUserCenter.我的主题);
		model.addAttribute("typeUrl", "forum/user/thread.shtml");

		userId = initInfo(userId, EnumForumUserCenter.我的主题, model);
		ForumThread entity = new ForumThread(false);
		entity.setCreator_id(userId);
		entity.getMap().put("sort", true);
		PageInfo<ForumThread> pageInfo = forumThreadService.queryPageList(entity, pageIndex, ConfigValue.PAGE_SIZE);

		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "forum/user/thread");
	}

	/**
	 * @Description 进入列表页面
	 * @param uid
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/post")
	public String post(Integer uid, Model model) {
		gainThreadPostPageData(uid, 1, model);
		return getPath("post");
	}

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/post/{page_index}")
	public String post(Integer uid, @PathVariable(value = "page_index") Integer pageIndex, Model model) {
		gainThreadPostPageData(uid, pageIndex, model);
		return getPath("post");
	}

	/**
	 * @Description 获取分页数据
	 * @param userId
	 * @param pageIndex
	 * @param model
	 */
	private void gainThreadPostPageData(Integer userId, Integer pageIndex, Model model) {
		model.addAttribute("type", EnumForumUserCenter.我的回帖.getValue());
		model.addAttribute("typeText", EnumForumUserCenter.我的回帖);
		model.addAttribute("typeUrl", "forum/user/post.shtml");

		userId = initInfo(userId, EnumForumUserCenter.我的回帖, model);
		PageInfo<ForumThread> pageInfo = forumThreadService.queryPageListWithPosts(userId, pageIndex, ConfigValue.PAGE_SIZE);
		if (pageInfo != null) {
			model.addAttribute("list", pageInfo.getData());
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("url", "forum/user/post");
		}
	}

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/fav")
	public String fav(HttpServletRequest request, Model model) {
		initInfo(null, EnumForumUserCenter.我的收藏, model);
		gainFavPageData(1, model);
		return getPath("fav");
	}

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/fav/{page_index}")
	public String fav(HttpServletRequest request, @PathVariable(value = "page_index") Integer pageIndex, Model model) {
		initInfo(null, EnumForumUserCenter.我的收藏, model);
		gainFavPageData(pageIndex, model);
		return getPath("fav");
	}

	/**
	 * @Description 获取分页数据
	 * @param pageIndex
	 * @param model
	 */
	private void gainFavPageData(Integer pageIndex, Model model) {
		List<Integer> idList = forumUserService.queryForFavIds(getCurrentUserId());
		if (idList != null) {
			ForumThread entity = new ForumThread(false);
			entity.getMap().put("sort", true);
			entity.getMap().put("ids", idList);
			PageInfo<ForumThread> pageInfo = forumThreadService.queryPageList(entity, pageIndex, ConfigValue.PAGE_SIZE);

			model.addAttribute("list", pageInfo.getData());
			model.addAttribute("pageInfo", pageInfo);
			model.addAttribute("url", "forum/user/fav");
		}

		model.addAttribute("type", EnumForumUserCenter.我的收藏.getValue());
		model.addAttribute("typeText", EnumForumUserCenter.我的收藏);
		model.addAttribute("typeUrl", "forum/user/fav.shtml");
	}

	/**
	 * @Title: logic_delete
	 * @Description: Ajax删除
	 * @param id
	 * @param plate_id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/fav/add", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult addToFav(Integer id) {
		return forumUserService.createForFav(new ForumUserFav(id, getCurrentUserId()));
	}

	/**
	 * @Description 移除收藏
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/fav/remove", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult removeForFav(String ids) {
		return forumUserService.removeForFavByIds(ids, getCurrentUserId());
	}

	/**
	 * @Description 设置信息
	 * @param userId
	 * @param userCenter
	 * @param model
	 * @return Integer
	 */
	private Integer initInfo(Integer userId, EnumForumUserCenter userCenter, Model model) {
		if (userId == null) {
			userId = getCurrentUserId();
		} else {
			if (userCenter == EnumForumUserCenter.我的主题) {
				model.addAttribute("type", EnumForumUserCenter.我的主题.getValue());
				model.addAttribute("typeText", "他的主题");
				model.addAttribute("typeUrl", "forum/user/thread.shtml?uid=" + userId);
			} else if (userCenter == EnumForumUserCenter.我的回帖) {
				model.addAttribute("type", EnumForumUserCenter.我的回帖.getValue());
				model.addAttribute("typeText", "他的回帖");
				model.addAttribute("typeUrl", "forum/user/post.shtml?uid=" + userId);
			}
		}
		model.addAttribute("userId", userId);
		return userId;
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "forumUser";
	}

	@Override
	public String getModuleName() {
		return "模块名称";
	}
}
