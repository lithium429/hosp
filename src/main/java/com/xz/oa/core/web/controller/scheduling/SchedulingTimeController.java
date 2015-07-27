
package com.xz.oa.core.web.controller.scheduling; 
  
import java.util.Date;
import java.util.List;

import javax.annotation.Resource; 
 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
  
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult; 
import com.xz.oa.core.domain.entity.SchedulingTime;
import com.xz.oa.core.service.scheduling.SchedulingTimeService;

@Controller
@RequestMapping(value = "/schedulingTime")
public class SchedulingTimeController extends SpringBaseController {

	@Resource
	private SchedulingTimeService schedulingTimeService;
  
	/**
	 * @Title: set
	 * @Description: 进入设置页面
	 * @param model
	 * @return String
	 */
	@RequestMapping("/set")
	public String set(Model model) {
		List<SchedulingTime> list = schedulingTimeService.queryList(new SchedulingTime());
		model.addAttribute("list", list);
		return getPath("set");
	}

	/**
	 * @Title: set
	 * @Description: Ajax保存设置数据
	 * @return JsonResult
	 */
	@RequestMapping(value = "/set", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult set(SchedulingTime entity) {
		return schedulingTimeService.create(entity);
	} 
	
	/**
	 * @Title: add
	 * @Description: 进入添加页面 
	 * @param model
	 * @return String
	 */
	@RequestMapping("/add")
	public String add(Integer index, Model model) {
		model.addAttribute("index", index);
		return getPathAdd();
	}

	/**
	 * @Title: add
	 * @Description: Ajax保存数据
	 * @return JsonResult
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult add() {
		return new JsonResult(true);
	} 
	
	/**
	 * @Title: add
	 * @Description: Ajax保存数据
	 * @return JsonResult
	 */
	@RequestMapping(value = "/compare", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult compare(Date ostartDate, Date oendDate, Date startDate, Date endDate) {
		boolean flag = !(startDate.compareTo(oendDate) >= 0 || endDate.compareTo(ostartDate) <= 0);
		return new JsonResult(flag);
	}
	 
	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "schedulingTime";
	}

	@Override
	public String getModuleName() {
		return "排班时间段设置";
	} 
}
