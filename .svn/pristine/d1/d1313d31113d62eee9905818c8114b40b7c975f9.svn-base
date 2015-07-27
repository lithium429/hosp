package com.xz.oa.core.web.controller.staff;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.base.Charsets;
import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.LogHelper;
import com.xz.base.utils.WebUtil;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.AutoMapper;
import com.xz.base.model.JsonResult;
import com.xz.base.model.MapperChild;
import com.xz.base.model.PageInfo;
import com.xz.base.model.UploadItem;
import com.xz.oa.core.domain.entity.Staff;
import com.xz.oa.core.domain.enums.EnumEducation;
import com.xz.oa.core.domain.enums.EnumNation;
import com.xz.oa.core.service.staff.StaffService;

@Controller
@RequestMapping(value = "/staff")
public class StaffController extends SpringBaseController {

	@Resource
	private StaffService staffService;

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
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		String name = WebUtil.getString(request, "name", "");
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		Staff entity = new Staff();
		if (StringUtils.isNotBlank(name)) {
			entity.getMap().put("name", name);
		}
		entity.getMap().put("sort", true);
		PageInfo<Staff> pageInfo = staffService.queryPageList(entity, pageIndex, pageSize);
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
		model.addAttribute("nationArray", getNations());
		model.addAttribute("educationArray", getEducations());
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
	JsonResult add(Staff entity) {
		return staffService.create(entity);
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
		Staff entity = staffService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("nationArray", getNations());
		model.addAttribute("educationArray", getEducations());
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
	JsonResult update(Staff entity) {
		return staffService.modify(entity);
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
		return staffService.removeById(id);
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
		return staffService.removeByIds(ids);
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
		Staff entity = staffService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("nationArray", getNations());
		model.addAttribute("educationArray", getEducations());
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

		boolean result = staffService.validateCode(id, code);
		return result;
	}

	// 获取民族
	public EnumNation[] getNations() {
		return EnumNation.values();
	}

	// 获取学历
	public EnumEducation[] getEducations() {
		return EnumEducation.values();
	}

	/**
	 * @Title: batchDelete
	 * @Description: Ajax批量改变状态
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/autoStaff", method = RequestMethod.POST)
	public @ResponseBody
	AutoMapper autoStaff(HttpServletRequest request, Model model) {
		String query = WebUtil.getString(request, "query", "0");
		try {

			Staff s = new Staff();
			if (!"0".equals(query)) {
				s.getMap().put("name", query);
			}
			s.getMap().put("sort", true);
			List<Staff> staffList = staffService.queryList(s);
			List<MapperChild> data = new ArrayList<MapperChild>();
			List<String> suggestions = new ArrayList<String>();
			if (staffList == null) {
				staffList = new ArrayList<Staff>();
			}
			for (Staff item : staffList) {
				MapperChild m = new MapperChild();
				m.setId(item.getId());
				m.setName(item.getName());
				data.add(m);
				suggestions.add(item.getName() + "(" + item.getCode() + ")");
			}
			AutoMapper auto = new AutoMapper();
			auto.setData(data);
			auto.setQuery(query);
			auto.setSuggestions(suggestions);
			auto.setSuccess(true);
			// 修改下面组装的括号样式时需要到方法中也需要修改括号样式
			return auto;
		} catch (Exception ex) {
			AutoMapper auto = new AutoMapper();
			auto.setQuery(query);
			auto.setSuggestions(new ArrayList<String>());
			auto.setSuccess(false);
			return auto;
		}
	}

	/**
	 * @Description 导入员工数据
	 * @param model
	 * @return String
	 */
	@RequestMapping("/import")
	public String importStaff(Model model) {
		model.addAttribute(new UploadItem());
		return getPath("import");
	}

	/**
	 * @Description 保存导入数据
	 * @param file
	 * @return String
	 */
	@RequestMapping(value = "/import", method = RequestMethod.POST)
	public String importStaff(@RequestParam("excel_file") MultipartFile file, Model model) {
		try {
			if (file != null) {
				byte[] bytes = file.getBytes();
				String text = new String(bytes, Charsets.UTF_8);
				boolean flag = staffService.modifyForImport(text, getCurrentUserId());
				if (!flag) {
					model.addAttribute("errorInfo", "导入出错！");
				} else {
					model.addAttribute("successInfo", "导入成功！");
				}
			} else {
				model.addAttribute("errorInfo", "未选择文件！");
			}

		} catch (Exception ex) {
			LogHelper.getLogger().error("获取文件内容时出错", ex);
		}
		return getPath("import");
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "staff";
	}

	@Override
	public String getModuleName() {
		return "员工管理";
	}
}
