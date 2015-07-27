package com.xz.oa.core.web.controller.file;
 
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.xz.base.model.JsonResult;  
import com.xz.base.model.ZTreeNode;
import com.xz.base.utils.WebUtil;
import com.xz.oa.core.domain.entity.Department;
import com.xz.oa.core.domain.entity.Directory;
import com.xz.oa.core.domain.enums.EnumDirModuleType;
import com.xz.oa.core.service.file.DirectoryService; 
import com.xz.oa.core.service.organization.DepartmentService;
import com.xz.oa.core.web.controller.UploadSetController;

@Controller
@RequestMapping(value = "/directory")
public class DirectoryController extends UploadSetController {

	@Resource
	private DirectoryService directoryService;
	
	@Resource
	private DepartmentService departmentService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		List<ZTreeNode> treeList = new ArrayList<ZTreeNode>();
		treeList.add(new ZTreeNode("根目录", getCurrentUserId()));
		String jsonTree = WebUtil.toJson(treeList);
		model.addAttribute("jsonTree", jsonTree);
		
		initConfigValues(model);
		
		// 动作权限
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		model.addAttribute("menu_id", menu_id);
		model.addAttribute("roleMenuList", super.gainRoleMenu(menu_id));
		
		return getPathList();
	}

	// / <summary>
	// / ajsx异步加载子节点
	// / </summary>
	// / <returns></returns>
	@RequestMapping(value = "getchilds", method = RequestMethod.POST)
	public @ResponseBody
	List<ZTreeNode> getSonNodes(HttpServletRequest request, Model model) {
		Integer id = WebUtil.getInt(request, "id", 0);
		Integer moduleType = WebUtil.getInt(request, "module_type", 0);
		
		return directoryService.queryAsyncTreeList(getCurrentUserId(), id, moduleType);
	}
	
	/**
	 * @Description 进入共享列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/sharelist")
	public String shareList(HttpServletRequest request, Model model) {
		List<ZTreeNode> treeList = directoryService.queryShareTreeList(getCurrentUserDeptId(), EnumDirModuleType.我的文档.getValue());
		String jsonTree = WebUtil.toJson(treeList);
		model.addAttribute("jsonTree", jsonTree);	
		
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		model.addAttribute("menu_id", menu_id);
		
		return getPath("sharelist");
	}
	
	/**
	 * @Description 进入我的文档选择页面 
	 * @param request
	 * @param model
	 * @return String     
	 */
	@RequestMapping("/select")
	public String selectList(HttpServletRequest request, Model model) {
		List<ZTreeNode> treeList = directoryService.queryTreeList(getCurrentUserId(), EnumDirModuleType.我的文档.getValue());
		String jsonTree = WebUtil.toJson(treeList);
		model.addAttribute("jsonTree", jsonTree);	
		return getPath("selectlist");
	}
	
	/**
	 * @Description 进入我的文档选择页面 
	 * @param request
	 * @param model
	 * @return String     
	 */
	@RequestMapping("/selectshare")
	public String selectShareList(HttpServletRequest request, Model model) {
		List<ZTreeNode> treeList = directoryService.queryShareTreeList(getCurrentUserDeptId(), EnumDirModuleType.我的文档.getValue());
		String jsonTree = WebUtil.toJson(treeList);
		model.addAttribute("jsonTree", jsonTree);	
		return getPath("selectsharelist");
	}
	
	/**
	 * @Description 进入共享列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/summarylist")
	public String summaryList(HttpServletRequest request, Model model) {
		List<ZTreeNode> treeList = new ArrayList<ZTreeNode>();
		treeList.add(new ZTreeNode("根目录", getCurrentUserId()));
		String jsonTree = WebUtil.toJson(treeList);
		model.addAttribute("jsonTree", jsonTree);
		
		// 获取部门列表
		Department entity = new Department(); 
		List<Department> deptList = departmentService.queryList(entity); 
		model.addAttribute("deptList", deptList);
		
		initConfigValues(model);
		
		// 动作权限
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		model.addAttribute("menu_id", menu_id);
		model.addAttribute("roleMenuList", super.gainRoleMenu(menu_id));
		
		return getPath("summarylist");
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
	JsonResult add(Directory entity) {
		entity.setCreator_id(getCurrentUserId());
		return directoryService.create(entity);
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
		Directory entity = directoryService.findById(id);
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
	JsonResult update(Directory entity) {
		return directoryService.modify(entity);
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
		return directoryService.removeById(id);
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
		return directoryService.removeByIds(ids);
	}
	
	/**
	 * @Title: share
	 * @Description: 进入共享页面
	 * @param ids
	 * @param model
	 * @return String
	 */
	@RequestMapping(value = "/share", method = RequestMethod.GET)
	public String share(String ids, Model model) {
		Department entity = new Department(); 
		List<Department> deptList = departmentService.queryList(entity);
		model.addAttribute("ids", ids);
		model.addAttribute("deptList", deptList);
		return getPath("share");
	}
	 
	/**
	 * @Title: share
	 * @Description: Ajax共享
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/share", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult share(String ids, Boolean is_share_all, String dept_ids) { 
		return directoryService.modifyForShare(ids, is_share_all, dept_ids);
	}
	
	/**
	 * @Title: unshare
	 * @Description: Ajax取消共享
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/unshare", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult unshare(String ids) { 
		return directoryService.modifyForUnshare(ids);
	} 

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "directory";
	}

	@Override
	public String getModuleName() {
		return "文件夹";
	}
}
