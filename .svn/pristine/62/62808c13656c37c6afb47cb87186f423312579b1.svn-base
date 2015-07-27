
package com.xz.oa.core.web.controller.handlingprocess; 
 
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.HandlingProcess;
import com.xz.oa.core.service.handlingprocess.HandlingProcessService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/handlingProcess")
public class HandlingProcessController extends SpringBaseController {

	@Resource
	private HandlingProcessService handlingProcessService;
	
	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String    
	 * @author davidwan 
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		int type = WebUtil.getInt(request, "type", -1);
		getList(request, model);
		String path="list";
		switch(type)
		{
			case 0:
				path="list_rh";
				break;
			case 1:
				path="list_c";
				break;
			case 2:
				path="list_h";
				break;
		}
		return getPath(path);
	}
	
	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @return String    
	 * @author davidwan 
	 */
	@RequestMapping("/datalist")
	public String datalist(HttpServletRequest request, Model model){
		int type = WebUtil.getInt(request, "type", -1);
		getList(request, model);
		String path="data_list";
		switch(type)
		{
			case 0:
				path="data_list_rh";
				break;
			case 1:
				path="data_list_c";
				break;
			case 2:
				path="data_list_h";
				break;
		}
		return getPath(path);
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
		int type = WebUtil.getInt(request, "type", -1);
		int state = WebUtil.getInt(request, "state", 0);
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		String user_name = WebUtil.getString(request, "user_name", "");
		String creator_name = WebUtil.getString(request, "creator_name", "");
		String keyword = WebUtil.getString(request, "keyword", "");
		String end_date_min = WebUtil.getString(request, "end_date_min", "");
		String end_date_max = WebUtil.getString(request, "end_date_max", "");
		String create_time_min = WebUtil.getString(request, "create_time_min", "");
		String create_time_max = WebUtil.getString(request, "create_time_max", "");
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		HandlingProcess entity = new HandlingProcess();
		if (StringUtils.isNotBlank(user_name)) {
			entity.getMap().put("user_name",user_name);
		}
		if (StringUtils.isNotBlank(creator_name)) {
			entity.getMap().put("creator_name",creator_name);
		}
		if (StringUtils.isNotBlank(keyword)) {
			entity.getMap().put("keyword",keyword);
		}
		switch(type)
		{
			case 0:
				entity.setState(2);
				entity.setUser_id(shiroUser.getId());
				break;
			case 1:
				entity.setCreator_id(shiroUser.getId());
				break;
			case 2:
				entity.getMap().put("user_id_all", shiroUser.getId());
				break;
			default:
				entity.getMap().put("n_state", 1);	
		}
		if(state!=0)
		{
			entity.setState(state);
		}
		if (StringUtils.isNotBlank(end_date_min)) {
			entity.getMap().put("end_date_min", DateUtil.strToDate(end_date_min+" 00:00:00","yyyy-MM-dd HH:mm:ss"));
		}
		if (StringUtils.isNotBlank(end_date_max)) {
			entity.getMap().put("end_date_max", DateUtil.strToDate(end_date_max+" 23:59:59","yyyy-MM-dd HH:mm:ss"));
		}
		if (StringUtils.isNotBlank(create_time_min)) {
			entity.getMap().put("create_time_min", DateUtil.strToDate(create_time_min+" 00:00:00","yyyy-MM-dd HH:mm:ss"));
		}
		if (StringUtils.isNotBlank(create_time_max)) {
			entity.getMap().put("create_time_max", DateUtil.strToDate(create_time_max+" 23:59:59","yyyy-MM-dd HH:mm:ss"));
		}
		entity.getMap().put("sort",true);
		PageInfo<HandlingProcess> pageInfo = handlingProcessService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("type", type);
		model.addAttribute("my_id", shiroUser.getId());
		model.addAttribute("menu_id", menu_id);
		model.addAttribute("roleMenuList",super.gainRoleMenu(menu_id) );
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
	JsonResult add(HandlingProcess entity) {
		return handlingProcessService.create(entity);
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
		HandlingProcess entity = handlingProcessService.findById(id);
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
	JsonResult update(HandlingProcess entity) {
		return handlingProcessService.modify(entity);
	}

	/**
	 * @Title: update
	 * @Description: 进入处理页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/haddle")
	public String haddle(Integer id, Model model) {
		HandlingProcess entity = handlingProcessService.findById(id);
		model.addAttribute("model", entity);
		return getPath("haddle");
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存处理信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/haddle", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult haddle(HandlingProcess entity) {
		return handlingProcessService.modifyHaddle(entity);
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
		return handlingProcessService.removeById(id);
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
		return handlingProcessService.removeByIds(ids);
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
		HandlingProcess entity = handlingProcessService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	/**
	 * @Title: delete
	 * @Description: Ajax删除
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/close", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult close(HttpServletRequest request) {
		int id = WebUtil.getInt(request, "id", 0);
		String ids = WebUtil.getString(request, "ids", "");
		return handlingProcessService.modifyClose(id,ids);
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "handlingProcess";
	}

	@Override
	public String getModuleName() {
		return "督办流程";
	} 
}
