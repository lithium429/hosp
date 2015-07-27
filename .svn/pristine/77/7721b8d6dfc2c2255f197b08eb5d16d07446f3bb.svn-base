package com.xz.oa.core.web.controller.meal;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.base.utils.WebUtil;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.oa.core.domain.entity.MealMenu;
import com.xz.oa.core.domain.entity.MealMenuAddUp;
import com.xz.oa.core.domain.entity.MealMenuHelp;
import com.xz.oa.core.domain.entity.MealUserHelp;
import com.xz.oa.core.service.meal.MealMenuService;
import com.xz.oa.core.service.organization.CompanyService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/mealMenu")
public class MealMenuController extends SpringBaseController {

	@Resource
	private MealMenuService mealMenuService;
	@Resource
	private CompanyService companyService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		DateTime sDate = DateTime.now().minusDays(DateTime.now().getDayOfWeek() - 1), eDate = DateTime.now().plusDays(7 - DateTime.now().getDayOfWeek()), sDate_next = sDate.plusWeeks(1), eDate_next = eDate
				.plusWeeks(1), sDate_last = sDate.minusWeeks(1), eDate_last = eDate.minusWeeks(1), sDate_v = sDate.minusWeeks(2), eDate_v = eDate.minusWeeks(2);
		MealMenu m = new MealMenu();
		m.getMap().put("meal_date_min", sDate_next.toString("yyyy-MM-dd"));
		m.getMap().put("meal_date_max", eDate_next.toString("yyyy-MM-dd"));
		m.getMap().put("sort_order", true);
		List<MealMenu> mealList = mealMenuService.queryList(m);
		model.addAttribute("mealList", mealList);

		getList(request, model);
		model.addAttribute("sDate_next", sDate_next);
		model.addAttribute("eDate_next", eDate_next);
		String[] dateArray = { sDate.toString("M月dd日") + "-" + eDate.toString("M月dd日") + "(本周)", sDate_last.toString("M月dd日") + "-" + eDate_last.toString("M月dd日") + "(上周)",
				sDate_v.toString("M月dd日") + "-" + eDate_v.toString("M月dd日") };
		model.addAttribute("dateArray", dateArray);
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
		int date_lnterval = WebUtil.getInt(request, "date_lnterval", 0);
		DateTime sDate = DateTime.now().minusDays(DateTime.now().getDayOfWeek() - 1), eDate = DateTime.now().plusDays(7 - DateTime.now().getDayOfWeek()), sDate_last = sDate.minusWeeks(1), eDate_last = eDate
				.minusWeeks(1), sDate_v = sDate.minusWeeks(2), eDate_v = eDate.minusWeeks(2);
		MealMenu entity = new MealMenu();
		switch (date_lnterval) {
		case 0:
			entity.getMap().put("meal_date_min", sDate.toString("yyyy-MM-dd"));
			entity.getMap().put("meal_date_max", eDate.toString("yyyy-MM-dd"));
			break;
		case 1:
			entity.getMap().put("meal_date_min", sDate_last.toString("yyyy-MM-dd"));
			entity.getMap().put("meal_date_max", eDate_last.toString("yyyy-MM-dd"));
			break;
		case 2:
			entity.getMap().put("meal_date_min", sDate_v.toString("yyyy-MM-dd"));
			entity.getMap().put("meal_date_max", eDate_v.toString("yyyy-MM-dd"));
			break;
		}
		entity.getMap().put("sort_order", true);
		model.addAttribute("list", mealMenuService.queryList(entity));
	}

	/**
	 * @Title: add
	 * @Description: 进入添加页面
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping("/add")
	public String add(HttpServletRequest request) {
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
	JsonResult add(MealMenuHelp entity) {
		return mealMenuService.create(entity);
	}

	/**
	 * @Title: add
	 * @Description: 进入订餐页面
	 * @param request
	 * @param model
	 * @return String
	 */
	@RequestMapping("/reserve")
	public String reserve(HttpServletRequest request, Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		DateTime sDate = DateTime.now().minusDays(DateTime.now().getDayOfWeek() - 1), eDate = DateTime.now().plusDays(7 - DateTime.now().getDayOfWeek()), sDate_next = sDate.plusWeeks(1), eDate_next = eDate
				.plusWeeks(1);
		String title = "";
		MealMenu a = new MealMenu();
		a.getMap().put("meal_date_min", sDate_next.toString("yyyy-MM-dd"));
		a.getMap().put("meal_date_max", eDate_next.toString("yyyy-MM-dd"));
		a.setState(2);
		a.getMap().put("sort_order", true);
		List<MealMenu> mealList = mealMenuService.queryList(a);
		if (mealList != null && mealList.size() > 0) {
			title = "下周菜单  " + sDate_next.toString("M月dd日") + "-" + eDate_next.toString("M月dd日");
			a.getMap().put("user_id", shiroUser.getId());
			List<MealMenu> mealList1 = mealMenuService.queryList_reserve(a);
			if (mealList1 != null && mealList1.size() > 0) {
				model.addAttribute("mealList", mealList1);// 下周提交菜单并且当前用户定过餐
				model.addAttribute("meal_st", 2);// 有下周提交菜单并且当前用户订餐过
			} else {
				model.addAttribute("mealList", mealList);// 下周提交菜单
				model.addAttribute("meal_st", 0);// 有下周提交菜单，但当前用户没有订餐过
			}
		} else {
			title = "本周菜单  " + sDate.toString("M月dd日") + "-" + eDate.toString("M月dd日");
			a = new MealMenu();
			a.getMap().put("meal_date_min", sDate.toString("yyyy-MM-dd"));
			a.getMap().put("meal_date_max", eDate.toString("yyyy-MM-dd"));
			a.setState(2);
			a.getMap().put("user_id", shiroUser.getId());
			a.getMap().put("sort_order", true);
			model.addAttribute("mealList", mealMenuService.queryList_reserve(a));// 本周当前用户提交菜单
			model.addAttribute("meal_st", 1);// 用来显示本周当前用户订餐情况，不做修改
		}
		model.addAttribute("title", title);
		return getPath("reserve");
	}

	/**
	 * @Title: add
	 * @Description: Ajax保存添加数据
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/reserve", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult reserve(MealUserHelp entity) {
		return mealMenuService.create(entity);
	}

	/**
	 * @Title: update
	 * @Description: 进入订餐页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/update")
	public String update(Integer id, Model model) {
		MealMenu entity = mealMenuService.findById(id);
		model.addAttribute("model", entity);
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
	JsonResult update(MealMenu entity) {
		return mealMenuService.modify(entity);
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
		return mealMenuService.removeById(id);
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
		return mealMenuService.removeByIds(ids);
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
		MealMenu entity = mealMenuService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	/**
	 * @Description 进入[我的订餐记录]列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list_my")
	public String list_my(HttpServletRequest request, Model model) {
		DateTime sDate = DateTime.now().minusDays(DateTime.now().getDayOfWeek() - 1), eDate = DateTime.now().plusDays(7 - DateTime.now().getDayOfWeek()), sDate_last = sDate.minusWeeks(1), eDate_last = eDate
				.minusWeeks(1), sDate_v = sDate.minusWeeks(2), eDate_v = eDate.minusWeeks(2);
		getList_my(request, model);

		String[] dateArray = { sDate.toString("M月dd日") + "-" + eDate.toString("M月dd日") + "(本周)", sDate_last.toString("M月dd日") + "-" + eDate_last.toString("M月dd日") + "(上周)",
				sDate_v.toString("M月dd日") + "-" + eDate_v.toString("M月dd日") };
		model.addAttribute("dateArray", dateArray);
		return getPath("list_my");
	}

	/**
	 * @Description 获取[我的订餐记录]列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/datalist_my")
	public String datalist_my(HttpServletRequest request, Model model) {
		getList_my(request, model);
		return getPath("data_list_my");
	}

	/**
	 * @Description 获取[我的订餐记录]列表数据
	 * @param request
	 * @param model
	 * @author davidwan
	 */
	private void getList_my(HttpServletRequest request, Model model) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		int date_lnterval = WebUtil.getInt(request, "date_lnterval", 0);
		DateTime sDate = DateTime.now().minusDays(DateTime.now().getDayOfWeek() - 1), eDate = DateTime.now().plusDays(7 - DateTime.now().getDayOfWeek()), sDate_last = sDate.minusWeeks(1), eDate_last = eDate
				.minusWeeks(1), sDate_v = sDate.minusWeeks(2), eDate_v = eDate.minusWeeks(2);
		MealMenu entity = new MealMenu();
		switch (date_lnterval) {
		case 0:
			entity.getMap().put("meal_date_min", sDate.toString("yyyy-MM-dd"));
			entity.getMap().put("meal_date_max", eDate.toString("yyyy-MM-dd"));
			break;
		case 1:
			entity.getMap().put("meal_date_min", sDate_last.toString("yyyy-MM-dd"));
			entity.getMap().put("meal_date_max", eDate_last.toString("yyyy-MM-dd"));
			break;
		case 2:
			entity.getMap().put("meal_date_min", sDate_v.toString("yyyy-MM-dd"));
			entity.getMap().put("meal_date_max", eDate_v.toString("yyyy-MM-dd"));
			break;
		}
		entity.setState(2);
		entity.getMap().put("user_id", shiroUser.getId());
		entity.getMap().put("sort_order", true);
		List<MealMenu> mealList = mealMenuService.queryList_reserve(entity);
		if (mealList == null || mealList.size() == 0) {
			entity.getMap().remove("user_id");
			mealList = mealMenuService.queryList(entity);
		}
		model.addAttribute("list", mealList);
	}

	/**
	 * @Description 进入[订餐统计]列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list_up")
	public String list_up(HttpServletRequest request, Model model) {
		DateTime sDate = DateTime.now().minusDays(DateTime.now().getDayOfWeek() - 1), eDate = DateTime.now().plusDays(7 - DateTime.now().getDayOfWeek()), sDate_last = sDate.minusWeeks(1), eDate_last = eDate
				.minusWeeks(1), sDate_next = sDate.plusWeeks(1), eDate_next = eDate.plusWeeks(1), sDate_v = sDate.minusWeeks(2), eDate_v = eDate.minusWeeks(2);
		getList_up(request, model, true);

		model.addAttribute("Tree", companyService.getTree());

		String[] dateArray = { sDate_next.toString("M月dd日") + "-" + eDate_next.toString("M月dd日") + "(下周)", sDate.toString("M月dd日") + "-" + eDate.toString("M月dd日") + "(本周)",
				sDate_last.toString("M月dd日") + "-" + eDate_last.toString("M月dd日") + "(上周)", sDate_v.toString("M月dd日") + "-" + eDate_v.toString("M月dd日") };
		model.addAttribute("dateArray", dateArray);
		return getPath("list_up");
	}

	/**
	 * @Description 获取[订餐统计]列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/datalist_up")
	public String datalist_up(HttpServletRequest request, Model model) {
		getList_up(request, model, false);
		return getPath("data_list_up");
	}

	/**
	 * @Description 获取[订餐统计]列表数据
	 * @param request
	 * @param model
	 * @author davidwan
	 */
	private void getList_up(HttpServletRequest request, Model model, boolean is_list) {
		int date_lnterval = WebUtil.getInt(request, "date_lnterval", 0);
		int dept_id = WebUtil.getInt(request, "dept_id", 0);
		int parent_id = WebUtil.getInt(request, "parent_id", 0);
		DateTime sDate = DateTime.now().minusDays(DateTime.now().getDayOfWeek() - 1), eDate = DateTime.now().plusDays(7 - DateTime.now().getDayOfWeek()), sDate_last = sDate.minusWeeks(1), eDate_last = eDate
				.minusWeeks(1), sDate_next = sDate.plusWeeks(1), eDate_next = eDate.plusWeeks(1), sDate_v = sDate.minusWeeks(2), eDate_v = eDate.minusWeeks(2);
		MealMenuAddUp entity = new MealMenuAddUp();

		switch (date_lnterval) {
		case 0:
			entity.getMap().put("meal_date_min", sDate_next.toString("yyyy-MM-dd"));
			entity.getMap().put("meal_date_max", eDate_next.toString("yyyy-MM-dd"));
			break;
		case 1:
			entity.getMap().put("meal_date_min", sDate.toString("yyyy-MM-dd"));
			entity.getMap().put("meal_date_max", eDate.toString("yyyy-MM-dd"));
			break;
		case 2:
			entity.getMap().put("meal_date_min", sDate_last.toString("yyyy-MM-dd"));
			entity.getMap().put("meal_date_max", eDate_last.toString("yyyy-MM-dd"));
			break;
		case 3:
			entity.getMap().put("meal_date_min", sDate_v.toString("yyyy-MM-dd"));
			entity.getMap().put("meal_date_max", eDate_v.toString("yyyy-MM-dd"));
			break;
		}
		entity.setState(2);
		if (is_list) {
			int count = mealMenuService.queryCount(entity);
			if (count == 0) {
				entity.getMap().put("meal_date_min", sDate.toString("yyyy-MM-dd"));
				entity.getMap().put("meal_date_max", eDate.toString("yyyy-MM-dd"));
				date_lnterval = 1;
			}
		}
		entity.setFood_type(1);
		if (dept_id != 0) {
			entity.getMap().put("dept_id", dept_id);
		}
		if (parent_id != 0) {
			entity.getMap().put("parent_id", parent_id);
		}
		List<MealMenuAddUp> mealList = mealMenuService.queryList_addUp(entity);
		if (mealList == null || mealList.size() == 0) {
			model.addAttribute("meal_list", mealMenuService.queryList(entity));
		} else {
			model.addAttribute("total_list", mealList);
		}
		model.addAttribute("date_lnterval", date_lnterval);
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "mealMenu";
	}

	@Override
	public String getModuleName() {
		return "菜单管理";
	}
}
