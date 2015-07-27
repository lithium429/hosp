package com.xz.oa.core.web.controller.file;

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
import com.xz.base.utils.WebUtil;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.File;
import com.xz.oa.core.domain.enums.EnumDirModuleType;
import com.xz.oa.core.service.file.FileDownload;
import com.xz.oa.core.service.file.FileService;
import com.xz.oa.core.service.file.FileUpload;

@Controller
@RequestMapping(value = "/file")
public class FileController extends SpringBaseController {

	@Resource
	private FileService fileService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
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
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/showlist")
	public String showList(HttpServletRequest request, Model model) {
		return getPath("showlist");
	}
	
	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/showdatalist")
	public String showDatalist(HttpServletRequest request, Model model) {
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE); 
		String name = WebUtil.getString(request, "name", null); 
		String minCreateTime = WebUtil.getString(request, "min_create_time", null);
		String maxCreateTime = WebUtil.getString(request, "max_create_time", null); 

		File entity = new File(); 
		entity.setModule_type(3);  
		if (StringUtils.isNotBlank(name)) {
			entity.getMap().put("name", name);
		} 
		if (StringUtils.isNotBlank(minCreateTime)) {
			entity.getMap().put("min_create_time", minCreateTime);
		}
		if (StringUtils.isNotBlank(maxCreateTime)) {
			entity.getMap().put("max_create_time", maxCreateTime);
		} 
		PageInfo<File> pageInfo = fileService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		return getPath("showdata_list");
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/sharedatalist")
	public String shareDatalist(HttpServletRequest request, Model model) {
		getList(request, model);
		return getPath("sharedata_list");
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/selectdatalist")
	public String selectDatalist(HttpServletRequest request, Model model) {
		getList(request, model);
		return getPath("selectdata_list");
	}

	/**
	 * @Description 获取回收站列表数据
	 * @param request
	 * @param model
	 * @author davidwan
	 */
	@RequestMapping("/summarydatalist")
	public String summaryDatalist(HttpServletRequest request, Model model) {
		getSummaryList(request, model);
		return getPath("summarydata_list");
	}

	/**
	 * @Description 进入回收站列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/rubishlist")
	public String rubishlist(HttpServletRequest request, Model model) {
		model.addAttribute("userId", getCurrentUserId());
		
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		model.addAttribute("menu_id", menu_id);
		model.addAttribute("roleMenuList", super.gainRoleMenu(menu_id));
		
		return getPath("rubishlist");
	}

	/**
	 * @Description 获取回收站列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/rubishdatalist")
	public String rubishDatalist(HttpServletRequest request, Model model) {
		getList(request, model);
		return getPath("rubishdata_list");
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @author davidwan
	 */
	private void getList(HttpServletRequest request, Model model) {
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		Integer directoryId = WebUtil.getInteger(request, "directory_id", null);
		Integer creatorId = WebUtil.getInteger(request, "creator_id", null);
		String name = WebUtil.getString(request, "name", "");
		String types = WebUtil.getString(request, "types", "");
		String minCreateTime = WebUtil.getString(request, "min_create_time", "");
		String maxCreateTime = WebUtil.getString(request, "max_create_time", "");
		String notIds = WebUtil.getString(request, "not_ids", "");
		boolean isDelete = WebUtil.getBoolean(request, "is_delete", false);

		File entity = new File();
		entity.setDirectory_id(directoryId);
		entity.setCreator_id(creatorId);
		if (!isDelete) {
			entity.setModule_type(EnumDirModuleType.我的文档.getValue());
		}
		entity.getMap().put("is_delete", isDelete);

		if (StringUtils.isNotBlank(name)) {
			entity.getMap().put("name", name);
		}
		if (StringUtils.isNotBlank(types)) {
			entity.getMap().put("types", types.split(","));
		}
		if (StringUtils.isNotBlank(minCreateTime)) {
			entity.getMap().put("min_create_time", minCreateTime);
		}
		if (StringUtils.isNotBlank(maxCreateTime)) {
			entity.getMap().put("max_create_time", maxCreateTime);
		}
		if (StringUtils.isNotBlank(notIds)) {
			entity.getMap().put("not_ids", notIds.split(","));
		}

		PageInfo<File> pageInfo = fileService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		
		model.addAttribute("roleMenuList", super.gainRoleMenu(menu_id));
	}

	/**
	 * @Description 获取总结文档列表数据
	 * @param request
	 * @param model
	 * @author davidwan
	 */
	private void getSummaryList(HttpServletRequest request, Model model) {
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		Integer directoryId = WebUtil.getInteger(request, "directory_id", null);
		// Integer creatorId = WebUtil.getInteger(request, "creator_id", null);
		Integer deptId = WebUtil.getInteger(request, "dept_id", null);
		String name = WebUtil.getString(request, "name", null);
		String creatorName = WebUtil.getString(request, "creator_name", null);
		String minCreateTime = WebUtil.getString(request, "min_create_time", null);
		String maxCreateTime = WebUtil.getString(request, "max_create_time", null);
		boolean isDelete = WebUtil.getBoolean(request, "is_delete", false);

		File entity = new File();
		entity.setDirectory_id(directoryId);
		entity.setModule_type(EnumDirModuleType.总结文档.getValue());
		entity.getMap().put("is_delete", isDelete);
		entity.getMap().put("dept_id", deptId);
		entity.getMap().put("current_user_id", getCurrentUserId());

		if (StringUtils.isNotBlank(name)) {
			entity.getMap().put("name", name);
		}
		if (StringUtils.isNotBlank(creatorName)) {
			entity.getMap().put("creator_name", creatorName);
		}
		if (StringUtils.isNotBlank(minCreateTime)) {
			entity.getMap().put("min_create_time", minCreateTime);
		}
		if (StringUtils.isNotBlank(maxCreateTime)) {
			entity.getMap().put("max_create_time", maxCreateTime);
		}

		model.addAttribute("userId", getCurrentUserId());

		PageInfo<File> pageInfo = fileService.querySummaryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("roleMenuList", super.gainRoleMenu(menu_id));
	}

	/**
	 * @Title: add
	 * @Description: 进入添加页面
	 * @param moduleType
	 * @param directoryId
	 * @param from
	 * @param model
	 * @return String
	 */
	@RequestMapping("/add")
	public String add(Integer moduleType, Integer directoryId, String from, Model model) {
		model.addAttribute("moduleType", moduleType);
		model.addAttribute("directoryId", directoryId);
		model.addAttribute("from", from);
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
	JsonResult add(File entity) {
		return fileService.create(entity);
	}

	/**
	 * @Title: update
	 * @Description: 进入修改页面
	 * @param id
	 * @param directory_id
	 *            文件夹id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/update")
	public String update(Integer id, Integer directory_id, Model model) {
		File entity = fileService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("directory_id", directory_id);
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
	JsonResult update(File entity) {
		return fileService.modify(entity);
	}

	/**
	 * @Title: update
	 * @Description: 进入修改文件名页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/updatename")
	public String updateName(Integer id, Model model) {
		File entity = fileService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("file_name", entity.gainFileNameWithoutExt());

		return getPath("updatename");
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改文件名信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/updatename", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult updateName(File entity) {
		entity.setName(entity.getName() + "." + entity.getExtension());
		return fileService.modify(entity);
	}

	/**
	 * @Title: update
	 * @Description: 进入修改页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/fileuser")
	public String fileuser(Integer id, Model model) {
		File entity = fileService.findWithUsersById(id);
		model.addAttribute("model", entity);
		return getPath("fileuser");
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/fileuser", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult fileuser(Integer file_id, String user_ids) {
		return fileService.modifyForFileUser(file_id, user_ids);
	}

	/**
	 * @Description 批量设置可见用户
	 * @return String
	 */
	@RequestMapping("/batchfileuser")
	public String batchFileUser() {
		return getPath("batchfileuser");
	}

	/**
	 * @Description Ajax保存批量设置可见用户
	 * @param file_ids
	 * @param user_ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batchfileuser", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult batchFileUser(String file_ids, String user_ids) {
		return fileService.modifyForFileUser(file_ids, user_ids);
	}

	/**
	 * @Title: delete
	 * @Description: Ajax逻辑删除
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/logicdelete", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult logicDelete(Integer id) {
		File entity = new File();
		entity.setId(id);
		entity.setIs_delete(true);
		return fileService.modify(entity);
	}

	/**
	 * @Title: batchDelete
	 * @Description: Ajax批量逻辑删除
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batchlogicdelete", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult batchLogicDelete(String ids) {
		File entity = new File();
		entity.getMap().put("ids", ids.split(","));
		entity.setIs_delete(true);
		return fileService.modify(entity);
	}

	/**
	 * @Title: recover
	 * @Description: Ajax恢复
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping(value = "/recover", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult recover(Integer id) {
		File entity = new File(id, false);
		return fileService.modify(entity);
	}

	/**
	 * @Title: batchRecover
	 * @Description: Ajax批量恢复
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batchrecover", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult batchRecover(String ids) {
		File entity = new File();
		entity.setIs_delete(false);
		entity.getMap().put("ids", ids.split(","));
		return fileService.modifyRecover(entity);
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
		return fileService.removeById(id);
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
		return fileService.removeByIds(ids);
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
		File entity = fileService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	/**
	 * @Description 处理Office OCX控件上传
	 * @param request
	 * @return JsonResult
	 */
	@RequestMapping("/upload")
	public @ResponseBody
	JsonResult upload(HttpServletRequest request) {
		FileUpload upload = new FileUpload(request);
		return (JsonResult) upload.process();
	}

	/**
	 * @Description 进入新建文件页面
	 * @param moduleType
	 * @param directoryId
	 * @param model
	 * @return String
	 */
	@RequestMapping("/new")
	public String newFile(Integer moduleType, Integer directoryId, Model model) {
		model.addAttribute("moduleType", moduleType);
		model.addAttribute("directoryId", directoryId);
		return getPath("new");
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
		File entity = fileService.findById(id);
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
		return "file";
	}

	@Override
	public String getModuleName() {
		return "文档";
	}
}
