package com.xz.oa.core.web.controller.scheduling;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody; 

import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.base.model.ZTreeNode;
import com.xz.base.utils.DateUtil;
import com.xz.base.utils.WebUtil;
import com.xz.oa.core.domain.entity.Department;
import com.xz.oa.core.domain.entity.Scheduling;
import com.xz.oa.core.domain.entity.SchedulingTime;
import com.xz.oa.core.service.organization.DepartmentService;
import com.xz.oa.core.service.scheduling.SchedulingService;
import com.xz.oa.core.service.scheduling.SchedulingTimeService;

@Controller
@RequestMapping(value = "/scheduling")
public class SchedulingController extends SpringBaseController {
	@Resource
	private DepartmentService departmentService;

	@Resource
	private SchedulingService schedulingService;

	@Resource
	private SchedulingTimeService schedulingTimeService;

	/**
	 * @Title: dept
	 * @Description: 进入科室排班页面
	 * @param model
	 * @return String
	 */
	@RequestMapping("/dept")
	public String dept(Model model) {
		Integer userId = getCurrentUserId();
		Integer deptId = getCurrentUserDeptId();
		Department dept = departmentService.findById(deptId);
		if (dept != null) {
			model.addAttribute("deptName", dept.getName());
			model.addAttribute("deptId", deptId);
		}
		model.addAttribute("userId", userId);
		initData(model, deptId);

		return getPath("dept");
	}

	/**
	 * @Title: dept
	 * @Description: Ajax保存科室排班数据
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult dept(Scheduling entity) {
		return schedulingService.createOrModify(entity, false);
	}

	/**
	 * @Title: all
	 * @Description: 进入总排班页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/all")
	public String all(Integer id, Model model) {
		Integer userId = getCurrentUserId();
		Integer deptId = getCurrentUserDeptId();
		model.addAttribute("userId", userId);
		model.addAttribute("deptId", deptId);

		// 获取所有部门
		Department department = new Department();
		List<Department> deptList = departmentService.queryList(department);
		model.addAttribute("deptList", deptList);

		initData(model, deptId);

		return getPath("all");
	}

	/**
	 * @Title: all
	 * @Description: Ajax保存总排班信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/all", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult all(Scheduling entity) {
		return schedulingService.createOrModify(entity, true);
	}

	/**
	 * @Description 获取指定年月排班信息
	 * @param year
	 * @param month
	 * @param deptId
	 * @param model
	 * @return String
	 */
	@RequestMapping("/data")
	public String data(Integer year, Integer month, Integer deptId, Model model) {
		Map<Byte, List<SchedulingTime>> timeMap = schedulingTimeService.queryListByGroup(new SchedulingTime());
		model.addAttribute("timeMap", timeMap);
		if (timeMap != null && !timeMap.isEmpty()) {
			model.addAttribute("stimeCount", timeMap.size());
		}

		model.addAttribute("days", DateUtil.getDaysOfMonth(new DateTime(year, month, 1, 0, 0, 0)));
		model.addAttribute("year", year);
		model.addAttribute("month", month);

		DateTime now = DateTime.now();
		model.addAttribute("yearNow", now.getYear());
		model.addAttribute("monthNow", now.getMonthOfYear());
		model.addAttribute("dayNow", now.getDayOfMonth());

		// 获取排班信息
		Scheduling entity = new Scheduling();
		entity.setDept_id(deptId);
		entity.setYear(year);
		entity.setMonth(Byte.valueOf(month.toString()));
		List<Scheduling> list = schedulingService.queryList(entity);
		model.addAttribute("schedulingList", list);

		return getPath("data");
	}

	/**
	 * @Description
	 * @param model
	 *            void
	 */
	private void initData(Model model, Integer deptId) {
		// 获取部门用户
		Department department = new Department(deptId);
		List<ZTreeNode> treeList = departmentService.queryTreeListWithUsers(department, null);
		String jsonTree = WebUtil.toJson(treeList);
		model.addAttribute("jsonTree", jsonTree);

		DateTime now = DateTime.now();
		model.addAttribute("year", now.getYear());
		model.addAttribute("month", now.getMonthOfYear());
		List<Integer> years = new ArrayList<Integer>();
		for (int i = 2014; i <= 2099; i++) {
			years.add(i);
		}
		model.addAttribute("years", years);
		model.addAttribute("months", new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 });
	}
	
	/**
	 * @Description 清空 
	 * @param entity
	 * @return JsonResult     
	 */
	@RequestMapping("/clear")
	public @ResponseBody
	JsonResult clear(Scheduling entity) {
		DateTime now = DateTime.now();
		if(entity.getYear() > now.getYear() || 
			(entity.getYear() == now.getYear() && entity.getMonth() > now.getMonthOfYear())){
			return schedulingService.remove(entity);	
		}
		return new JsonResult(false);
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
		Scheduling entity = schedulingService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	/**
	 * @Description
	 * @param realName
	 * @param deptId
	 * @return String
	 */
	@RequestMapping(value = "gettree.do", method = RequestMethod.POST)
	public @ResponseBody
	String getTree(String realName, Integer deptId) {
		Department department = new Department(deptId);
		List<ZTreeNode> treeList = departmentService.queryTreeListWithUsers(department, realName);

		return WebUtil.toJson(treeList);
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "scheduling";
	}

	@Override
	public String getModuleName() {
		return "排班管理";
	}
}
