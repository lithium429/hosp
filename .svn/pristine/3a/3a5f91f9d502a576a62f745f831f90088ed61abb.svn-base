package com.xz.oa.core.web.controller.care;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.DateUtil;
import com.xz.base.utils.WebUtil;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.Care;
import com.xz.oa.core.domain.entity.CareFile;
import com.xz.oa.core.domain.entity.CareType;
import com.xz.oa.core.service.care.CareFileService;
import com.xz.oa.core.service.care.CareService;
import com.xz.oa.core.service.care.CareTypeService;
import com.xz.oa.core.service.file.FileDownload;

@Controller
@RequestMapping(value = "/care")
public class CareController extends SpringBaseController {

	@Resource
	private CareService careService;
	@Resource
	private CareTypeService careTypeService;
	@Resource
	private CareFileService careFileService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		getTypeList(request, model);
		return getPathList();
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/type_datalist")
	public String type_datalist(HttpServletRequest request, Model model) {
		getTypeList(request, model);
		return getPath("type_data_list");
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
	private void getTypeList(HttpServletRequest request, Model model) {
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		int type_id = WebUtil.getInt(request, "type_id", 0);
		CareType c = new CareType();
		c.getMap().put("sort_order", true);
		model.addAttribute("typeList", careTypeService.queryList(c));
		model.addAttribute("menu_id", menu_id);
		if (type_id != 0) {
			model.addAttribute("type_id", type_id);
		}
		model.addAttribute("roleMenuList", super.gainRoleMenu(menu_id));
	}

	/**
	 * @Description 获取列表数据
	 * @param request
	 * @param model
	 * @author davidwan
	 */
	private void getList(HttpServletRequest request, Model model) {
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		String keyword = WebUtil.getString(request, "keyword", "");
		String create_time_min = WebUtil.getString(request, "create_time_min", "");
		String create_time_max = WebUtil.getString(request, "create_time_max", "");
		int type_id = WebUtil.getInt(request, "type_id", 0);
		Care entity = new Care();
		if (StringUtils.isNotBlank(keyword)) {
			entity.getMap().put("keyword", keyword);
		}
		if (StringUtils.isNotBlank(create_time_min)) {
			entity.getMap().put("create_time_min", DateUtil.strToDate(create_time_min, "yyyy-MM-dd HH:mm:ss"));
		}
		if (StringUtils.isNotBlank(create_time_max)) {
			entity.getMap().put("create_time_max", DateUtil.strToDate(create_time_max, "yyyy-MM-dd HH:mm:ss"));
		}
		if (type_id != 0) {
			entity.setType_id(type_id);
		}
		PageInfo<Care> pageInfo = careService.queryPageList(entity, pageIndex, pageSize);
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
		model.addAttribute("typeList", getTypes());
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
	JsonResult add(Care entity) {
		return careService.create(entity);
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
		Care entity = careService.findById(id);
		model.addAttribute("model", entity);
		model.addAttribute("typeList", getTypes());
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
	JsonResult update(Care entity) {
		return careService.modify(entity);
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
		return careService.removeById(id);
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
		return careService.removeByIds(ids);
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
		Care entity = careService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	public List<CareType> getTypes() {
		CareType c = new CareType();
		c.getMap().put("sort_order", true);
		return careTypeService.queryList(c);
	}

	/**
	 * @Title: batchDelete
	 * @Description: 验证标题重名
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/validateTitle", method = RequestMethod.POST)
	public @ResponseBody
	boolean validateTitle(Integer id, String title) {
		boolean result = careService.validateTitle(id, title);
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
		downloadFile(id, request, response);
	}
	
	/**
	 * @Description 下载附件
	 * @param id
	 * @param request
	 * @param response void     
	 */
	private void downloadFile(Integer id, HttpServletRequest request, HttpServletResponse response){
		CareFile entity = careFileService.findById(id);
		if (entity != null) {
			FileDownload download = new FileDownload(request, response);
			download.process(entity.getUrl(), entity.getName());
		}
	}

	/**
	 * @Description 进入护理天地前台首页 
	 * @param model
	 * @return String     
	 */
	@RequestMapping("/home/index")
	public String homeIndex(Model model) {
		initData(model);
		Map<Integer, List<Care>> map = careService.queryHomeList();
		model.addAttribute("homeMap", map);
		
		return getPath("home/index");
	}

	/**
	 * @Description 获取列表第一页数据
	 * @param typeId
	 * @param model
	 * @return String
	 */
	@RequestMapping("/home/list/{type_id}")
	public String homeList(@PathVariable(value = "type_id") Integer typeId, Model model) {
		initData(model);
		gainPageData(typeId, 1, model);
		return getPath("home/list");
	}

	/**
	 * @Description 获取列表大于第一页的数据
	 * @param typeId
	 * @param pageIndex
	 * @param model
	 * @return String
	 */
	@RequestMapping("/home/list/{type_id}/{page_index}")
	public String homeListPage(@PathVariable(value = "type_id") Integer typeId, @PathVariable(value = "page_index") Integer pageIndex, Model model) {
		initData(model);
		gainPageData(typeId, pageIndex, model);
		return getPath("home/list");
	}

	/**
	 * @Description 获取分页数据
	 * @param typeId
	 * @param pageIndex
	 * @param model
	 */
	private void gainPageData(Integer typeId, Integer pageIndex, Model model) {
		CareType careType = careTypeService.findById(typeId);
		Care entity = new Care(typeId);
		entity.getMap().put("sort", true);
		PageInfo<Care> pageInfo = careService.queryPageList(entity, pageIndex, ConfigValue.PAGE_SIZE);
		
		model.addAttribute("typeName", careType.getName());
		model.addAttribute("typeId", typeId);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("url", "care/home/list/" + typeId);
	}

	/**
	 * @Description
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/home/details/{id}")
	public String homeDetials(@PathVariable(value = "id") Integer id, Model model) {
		initData(model);
		Care entity = careService.findById(id);
		model.addAttribute("model", entity); 
		
		Care prevEntity = careService.findPrevByCurrentId(id, entity.getType_id());
		Care nextEntity = careService.findNextByCurrentId(id, entity.getType_id());
		model.addAttribute("prevCare", prevEntity);
		model.addAttribute("nextCare", nextEntity);

		return getPath("home/details");
	}
	
	/**
	 * @Description
	 * @param id
	 * @param model 
	 */
	@RequestMapping("/home/download/{id}")
	public void downloadHome(@PathVariable(value = "id") Integer id, HttpServletRequest request, HttpServletResponse response) { 
		downloadFile(id, request, response);
	}

	/**
	 * @Description 获取初始化数据
	 * @param model 
	 */
	private void initData(Model model) {
		CareType entity = new CareType();
		entity.getMap().put("sort_order", true);
		List<CareType> typeList = careTypeService.queryList(entity);
		model.addAttribute("typeList", typeList);
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "care";
	}

	@Override
	public String getModuleName() {
		return "模块名称";
	}
}
