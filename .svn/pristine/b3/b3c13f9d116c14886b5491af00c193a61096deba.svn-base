package com.xz.oa.core.web.controller.meeting;

import java.util.Date;
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
import com.xz.oa.core.domain.entity.Meeting;
import com.xz.oa.core.domain.entity.MeetingFile;
import com.xz.oa.core.domain.entity.MeetingRoom;
import com.xz.oa.core.domain.entity.MeetingVerifyRecord;
import com.xz.oa.core.service.file.FileDownload;
import com.xz.oa.core.service.meeting.MeetingFileService;
import com.xz.oa.core.service.meeting.MeetingRoomService;
import com.xz.oa.core.service.meeting.MeetingService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;
import com.xz.oa.core.web.controller.UploadSetController;

@Controller
@RequestMapping(value = "/meeting")
public class MeetingController extends UploadSetController {

	@Resource
	private MeetingService meetingService;
	@Resource
	private MeetingRoomService meetingRoomService;
	@Resource
	private MeetingFileService meetingFileService;

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
		model.addAttribute("roomList", getMeetingRoomList());
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
		int type = WebUtil.getInt(request, "type", 0);
		int room_id = WebUtil.getInt(request, "room_id", 0);
		int verify_state = WebUtil.getInt(request, "verify_state", -1);
		String holder = WebUtil.getString(request, "holder", "");
		String subject = WebUtil.getString(request, "subject", "");
		int state = WebUtil.getInt(request, "state", 0);
		String begin_time_min = WebUtil.getString(request, "begin_time_min", "");
		String begin_time_max = WebUtil.getString(request, "begin_time_max", "");
		String end_time_min = WebUtil.getString(request, "end_time_min", "");
		String end_time_max = WebUtil.getString(request, "end_time_max", "");
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		Meeting entity = new Meeting();
		if (type == 0) {
			entity.getMap().put("user_id", shiroUser.getId());
			entity.setVerify_state(2);
		} else if (type == 1) {
			entity.setCreator_id(shiroUser.getId());
		}
		if (verify_state != -1) {
			entity.setVerify_state(verify_state);
		}
		if (StringUtils.isNotBlank(holder)) {
			entity.getMap().put("holder", holder);
		}
		if (StringUtils.isNotBlank(subject)) {
			entity.getMap().put("subject", subject);
		}
		if (StringUtils.isNotBlank(begin_time_min)) {
			entity.getMap().put("begin_time_min", DateUtil.strToDate(begin_time_min, DateUtil.DAY_TIME_MINUTE_TYPE));
		}
		if (StringUtils.isNotBlank(begin_time_max)) {
			entity.getMap().put("begin_time_max", DateUtil.strToDate(begin_time_max, DateUtil.DAY_TIME_MINUTE_TYPE));
		}
		if (StringUtils.isNotBlank(end_time_min)) {
			entity.getMap().put("end_time_min", DateUtil.strToDate(end_time_min, DateUtil.DAY_TIME_MINUTE_TYPE));
		}
		if (StringUtils.isNotBlank(end_time_max)) {
			entity.getMap().put("end_time_max", DateUtil.strToDate(end_time_max, DateUtil.DAY_TIME_MINUTE_TYPE));
		}
		if (room_id != 0) {
			entity.setRoom_id(room_id);
		}
		if (state != 0) {
			entity.getMap().put("state", state);
			entity.getMap().put("now_date", new Date());
		}
		entity.getMap().put("sort", true);
		PageInfo<Meeting> pageInfo = meetingService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("type", type);
		model.addAttribute("menu_id", menu_id);
		model.addAttribute("roleMenuList",super.gainRoleMenu(menu_id) );
	}

	/**
	 * @Description 获取列表数据
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/homelist")
	public @ResponseBody
	JsonResult homeList(Integer type) {
		PageInfo<Meeting> pageInfo = meetingService.queryHomePageList(new Meeting(), getCurrentUserId(), type, 1, 10);
		if (pageInfo != null) {
			return new JsonResult(true, null, pageInfo.getData());
		}
		return new JsonResult(false);
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
		model.addAttribute("roomList", getMeetingRoomList());
		initConfigValues(model);
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
	JsonResult add(Meeting entity) {
		return meetingService.create(entity);
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
		Meeting entity = meetingService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("roomList", getMeetingRoomList());
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
	JsonResult update(Meeting entity) {
		return meetingService.modify(entity, true);
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
		return meetingService.removeById(id);
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
		return meetingService.removeByIds(ids);
	}

	/**
	 * @Description 进入详情页面
	 * @param id
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/view")
	public String view(Integer id,int type, Model model) {
		Meeting entity = meetingService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("type", type);
		return getPathView();
	}

	/**
	 * @Title: batchDelete
	 * @Description: 验证主题重名
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/validateSubject", method = RequestMethod.POST)
	public @ResponseBody
	boolean validateSubject(Integer id, String subject) {
		boolean result = meetingService.validateSubject(id, subject);
		return result;
	}

	// 获取会议室集合
	public List<MeetingRoom> getMeetingRoomList() {
		MeetingRoom m = new MeetingRoom();
		m.getMap().put("sort", true);
		return meetingRoomService.queryList(m);
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
		boolean is_agree = WebUtil.getBoolean(request, "is_agree", false);
		model.addAttribute("is_agree", is_agree);
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
	JsonResult change(MeetingVerifyRecord entity, HttpServletRequest request, boolean is_agree) {
		int id = WebUtil.getInt(request, "id", 0);
		String ids = WebUtil.getString(request, "ids", "");
		// String contnet = WebUtil.getString(request, "contnet", "");
		return meetingService.modifyChange(id, ids, is_agree, entity.getContent());
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/cancle", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult cancle(int id) { 
		return meetingService.modifyForCancel(id);
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
		MeetingFile entity = meetingFileService.findById(id);
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
		return "meeting";
	}

	@Override
	public String getModuleName() {
		return "会议";
	}
}
