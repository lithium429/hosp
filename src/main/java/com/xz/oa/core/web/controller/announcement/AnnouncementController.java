package com.xz.oa.core.web.controller.announcement;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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
import com.xz.oa.core.domain.entity.Announcement;
import com.xz.oa.core.domain.entity.AnnouncementFile;
import com.xz.oa.core.domain.entity.AnnouncementType;
import com.xz.oa.core.domain.entity.Department;
import com.xz.oa.core.service.announcement.AnnouncementFileService;
import com.xz.oa.core.service.announcement.AnnouncementService;
import com.xz.oa.core.service.announcement.AnnouncementTypeService;
import com.xz.oa.core.service.file.FileDownload;
import com.xz.oa.core.service.organization.DepartmentService;

@Controller
@RequestMapping(value = "/announcement")
public class AnnouncementController extends SpringBaseController {

	@Resource
	private AnnouncementService announcementService;
	@Resource
	private AnnouncementTypeService announcementTypeService;
	@Resource
	private DepartmentService departmentService;
	@Resource
	private AnnouncementFileService announcementFileService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		boolean is_home=WebUtil.getBoolean(request, "is_home", false);
		model.addAttribute("typeList", getTypeList());
		model.addAttribute("deptList", getDepartmentList());
		model.addAttribute("is_home", is_home);
		getList(request, model);
		return getPath(is_home?"list_h":"list");
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
		boolean is_home=WebUtil.getBoolean(request, "is_home", false);
		model.addAttribute("is_home", is_home);
		getList(request, model);
		return getPath(is_home?"data_list_h":"data_list");
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @author davidwan
	 */
	private void getList(HttpServletRequest request, Model model) {
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		String keyword = WebUtil.getString(request, "keyword", "");
		int type_id = WebUtil.getInt(request, "type_id", 0);
		int state = WebUtil.getInt(request, "state", 0);
		String dept_ids = WebUtil.getString(request, "dept_ids", "");
		String create_time_min = WebUtil.getString(request, "create_time_min", "");
		String create_time_max = WebUtil.getString(request, "create_time_max", "");
		String valid_date_min = WebUtil.getString(request, "valid_date_min", "");
		String valid_date_max = WebUtil.getString(request, "valid_date_max", "");
		String end_date_min = WebUtil.getString(request, "end_date_min", "");
		String end_date_max = WebUtil.getString(request, "end_date_max", "");
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		Announcement entity = new Announcement();
		model.addAttribute("maxSort", announcementService.getSort(entity));
		if (StringUtils.isNotBlank(keyword)) {
			entity.getMap().put("keyword", keyword);
		}
		if (StringUtils.isNotBlank(dept_ids)) {
			entity.getMap().put("dept_ids", dept_ids.split(","));
		}
		if (StringUtils.isNotBlank(create_time_min)) {
			entity.getMap().put("create_time_min", DateUtil.strToDate(create_time_min));
		}
		if (StringUtils.isNotBlank(create_time_max)) {
			entity.getMap().put("create_time_max", DateUtil.strToDate(create_time_max));
		}
		if (StringUtils.isNotBlank(valid_date_min)) {
			entity.getMap().put("valid_date_min", DateUtil.strToDate(valid_date_min, DateUtil.DAY_TIME_MINUTE_TYPE));
		}
		if (StringUtils.isNotBlank(valid_date_max)) {
			entity.getMap().put("valid_date_max", DateUtil.strToDate(valid_date_max, DateUtil.DAY_TIME_MINUTE_TYPE));
		}
		if (StringUtils.isNotBlank(end_date_min)) {
			entity.getMap().put("end_date_min", DateUtil.strToDate(end_date_min, DateUtil.DAY_TIME_MINUTE_TYPE));
		}
		if (StringUtils.isNotBlank(end_date_max)) {
			entity.getMap().put("end_date_max", DateUtil.strToDate(end_date_max));
		}
		if (type_id != 0) {
			entity.setType_id(type_id);
		}
		if (state != 0) {
			entity.getMap().put("state", state);
			entity.getMap().put("now_date", new Date());
		}
		entity.getMap().put("sort_order_desc", true);
		PageInfo<Announcement> pageInfo = announcementService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("menu_id", menu_id);
		model.addAttribute("roleMenuList",super.gainRoleMenu(menu_id) );
	}

	/**
	 * @Description 获取列表数据
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/homelist")
	public @ResponseBody JsonResult homeList(Integer typeId) {
		Announcement announcement = new Announcement();
		if (typeId != 0) {
			announcement.setType_id(typeId);
		}
		PageInfo<Announcement> pageInfo = announcementService.queryHomePageList(announcement, 1, 10);
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
		model.addAttribute("typeList", getTypeList());
		model.addAttribute("deptList", getDepartmentList());
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
	JsonResult add(Announcement entity) {
		return announcementService.create(entity);
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
		Announcement entity = announcementService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("typeList", getTypeList());
		model.addAttribute("deptList", getDepartmentList());
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
	JsonResult update(Announcement entity) {
		return announcementService.modify(entity, true);
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/move", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult move(HttpServletRequest request, int sort, boolean is_up) {
		int toSort = WebUtil.getInt(request, "toSort", 0);
		return announcementService.modifyMove(sort, is_up, toSort == 0 ? null : toSort);
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/change", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult change(HttpServletRequest request, boolean is_stop) {
		int id = WebUtil.getInt(request, "id", 0);
		String ids = WebUtil.getString(request, "ids", "");
		return announcementService.modify(id == 0 ? null : id, ids, is_stop);
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
		return announcementService.removeById(id);
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
		return announcementService.removeByIds(ids);
	}

	/**
	 * @Description 进入详情页面
	 * @param id
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/view")
	public String view(HttpServletRequest request,Integer id, Model model) {
		boolean is_home=WebUtil.getBoolean(request, "is_home", false);
		Announcement entity = announcementService.findById(id);
		model.addAttribute("model", entity);
		return getPath(is_home?"view_h":"view");
	}

	/**
	 * @Title: batchDelete
	 * @Description: 验证标题重名
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/validateTitle", method = RequestMethod.POST)
	public @ResponseBody
	boolean validateName(Integer id, String title) {
		boolean result = announcementService.validateTitle(id, title);
		return result;
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
		AnnouncementFile entity = announcementFileService.findById(id);
		if (entity != null) {
			FileDownload download = new FileDownload(request, response);
			download.process(entity.getUrl(), entity.getName());
		}
	}

	// 获取公告类型集合
	public List<AnnouncementType> getTypeList() {
		AnnouncementType at = new AnnouncementType();
		at.getMap().put("sort_order", true);
		return announcementTypeService.queryList(at);
	}

	// 获取二级部门集合
	public List<Department> getDepartmentList() {
		Department r = new Department();
		return departmentService.queryList(r);
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "announcement";
	}

	@Override
	public String getModuleName() {
		return "公告管理";
	}
}
