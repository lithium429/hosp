
package com.xz.oa.core.web.controller.staff; 
 
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.WebUtil;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.StaffContractType;
import com.xz.oa.core.service.staff.StaffContractTypeService;

@Controller
@RequestMapping(value = "/staffContractType")
public class StaffContractTypeController extends SpringBaseController {

	@Resource
	private StaffContractTypeService staffContractTypeService;
	
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
	public String datalist(HttpServletRequest request, Model model){
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
		StaffContractType entity = new StaffContractType();
		if(StringUtils.isNotBlank(name)){
			entity.getMap().put("name", name);
		}
		entity.getMap().put("sort_order", true);
		PageInfo<StaffContractType> pageInfo = staffContractTypeService.queryPageList(entity, pageIndex, pageSize);
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
	JsonResult add(StaffContractType entity) {
		return staffContractTypeService.create(entity);
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
		StaffContractType entity = staffContractTypeService.findById(id);
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
	JsonResult update(StaffContractType entity) {
		return staffContractTypeService.modify(entity);
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
		return staffContractTypeService.removeById(id);
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
		return staffContractTypeService.removeByIds(ids);
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
		StaffContractType entity = staffContractTypeService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	/**
	 * @Title: batchDelete
	 * @Description: 验证名称重名
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/validateName", method = RequestMethod.POST)
	public @ResponseBody
	boolean validateName(Integer id, String name) {
		boolean result = staffContractTypeService.validateName(id, name);
		return result;
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "staffContractType";
	}

	@Override
	public String getModuleName() {
		return "人事合同类型";
	} 
}
