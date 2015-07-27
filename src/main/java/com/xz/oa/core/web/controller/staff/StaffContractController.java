package com.xz.oa.core.web.controller.staff;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
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
import com.xz.oa.core.domain.entity.StaffContract;
import com.xz.oa.core.domain.entity.StaffContractFile;
import com.xz.oa.core.domain.entity.StaffContractType;
import com.xz.oa.core.service.file.FileDownload;
import com.xz.oa.core.service.staff.StaffContractFileService;
import com.xz.oa.core.service.staff.StaffContractService;
import com.xz.oa.core.service.staff.StaffContractTypeService;

@Controller
@RequestMapping(value = "/staffContract")
public class StaffContractController extends SpringBaseController {

	@Resource
	private StaffContractService staffContractService;
	@Resource
	private StaffContractTypeService staffContractTypeService;
	@Resource
	private StaffContractFileService staffContractFileService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		model.addAttribute("typeList", getTypeList());
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
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		int type_id = WebUtil.getInt(request, "type_id", 0);
		String name = WebUtil.getString(request, "name", "");
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		String states = WebUtil.getString(request, "states", "");
		String valid_date_min = WebUtil.getString(request, "valid_date_min", "");
		String valid_date_max = WebUtil.getString(request, "valid_date_max", "");
		String end_date_min = WebUtil.getString(request, "end_date_min", "");
		String end_date_max = WebUtil.getString(request, "end_date_max", "");
		StaffContract entity = new StaffContract();
		if (StringUtils.isNotBlank(name)) {
			entity.getMap().put("name", name);
		}
		if (!"".equals(states)) {
			entity.getMap().put("check_state", true);
			entity.getMap().put("now_date", DateTime.now().toString("yyyy-MM-dd"));
			if (states.contains("1")) {
				entity.getMap().put("state1", true);
			}
			if (states.contains("2")) {
				entity.getMap().put("state2", true);
			}
			if (states.contains("3")) {
				entity.getMap().put("state3", true);
			}
			if (states.contains("4")) {
				entity.getMap().put("state4", true);
			}
		}
		if (StringUtils.isNotBlank(valid_date_min)) {
			entity.getMap().put("valid_date_min", DateUtil.strToDate(valid_date_min + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		}
		if (StringUtils.isNotBlank(valid_date_max)) {
			entity.getMap().put("valid_date_max", DateUtil.strToDate(valid_date_max + " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
		}
		if (StringUtils.isNotBlank(end_date_min)) {
			entity.getMap().put("end_date_min", DateUtil.strToDate(end_date_min + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		}
		if (StringUtils.isNotBlank(end_date_max)) {
			entity.getMap().put("end_date_max", DateUtil.strToDate(end_date_max + " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
		}
		if (type_id != 0) {
			entity.setType_id(type_id);
		}
		entity.getMap().put("sort", true);
		PageInfo<StaffContract> pageInfo = staffContractService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
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
		model.addAttribute("typeList", getTypeList());
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
	JsonResult add(StaffContract entity) {
		return staffContractService.create(entity);
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
		StaffContract entity = staffContractService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("typeList", getTypeList());
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
	JsonResult update(StaffContract entity) {
		return staffContractService.modify(entity);
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
		return staffContractService.removeById(id);
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
		return staffContractService.removeByIds(ids);
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
		StaffContract entity = staffContractService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	/**
	 * @Title: batchDelete
	 * @Description: 验证工号重名
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/validateCode", method = RequestMethod.POST)
	public @ResponseBody
	boolean validateTitle(Integer id, String code) {

		boolean result = staffContractService.validateCode(id, code);
		return result;
	}

	// 获取合同类型
	public List<StaffContractType> getTypeList() {
		StaffContractType a = new StaffContractType();
		a.getMap().put("sort_order", true);
		return staffContractTypeService.queryList(a);
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
		StaffContractFile entity = staffContractFileService.findById(id);
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
		return "staffContract";
	}

	@Override
	public String getModuleName() {
		return "人事合同";
	}
}
