package com.xz.oa.core.web.controller.publicitycolumn;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import com.xz.oa.core.domain.entity.PublicityColumn;
import com.xz.oa.core.domain.entity.PublicityColumnFile;
import com.xz.oa.core.domain.enums.EnumPublicityColumnType;
import com.xz.oa.core.service.file.FileDownload;
import com.xz.oa.core.service.publicitycolumn.PublicityColumnService;

@Controller
@RequestMapping(value = "/publicityColumn")
public class PublicityColumnController extends SpringBaseController {

	@Resource
	private PublicityColumnService publicityColumnService;

	/**
	 * @Description 进入列表页面
	 * @param request
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		boolean is_home = WebUtil.getBoolean(request, "is_home", false);
		getList(request, model);
		model.addAttribute("is_home", is_home);
		return getPath(is_home ? "list_h" : "list");
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
		boolean is_home = WebUtil.getBoolean(request, "is_home", false);
		getList(request, model);
		return getPath(is_home ? "data_list_h" : "data_list");
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
		int type = WebUtil.getInt(request, "type", 0);
		String keyword = WebUtil.getString(request, "keyword", "");
		PublicityColumn entity = new PublicityColumn();
		if (type != 0) {
			entity.setType(type);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(keyword)) {
			map.put("keyword", keyword.trim());
		}
		map.put("sort_order_desc", true);
		entity.setMap(map);
		int maxSort = publicityColumnService.gainSort();
		model.addAttribute("maxSort", maxSort);
		PageInfo<PublicityColumn> pageInfo = publicityColumnService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("typeList", EnumPublicityColumnType.values());
	}

	/**
	 * @Description 获取列表数据
	 * @return String
	 * @author davidwan
	 */
	@RequestMapping("/homelist")
	public @ResponseBody
	JsonResult homeList(Integer type) {
		PublicityColumn publicityColumn = new PublicityColumn();
		if (type != null) {
			publicityColumn.setType(type);
		}
		PageInfo<PublicityColumn> pageInfo = publicityColumnService.queryPageList(publicityColumn, 1, 10);
		if (pageInfo != null) {
			return new JsonResult(true, null, pageInfo.getData());
		}
		return new JsonResult(false);
	}

	/**
	 * @Title: add
	 * @Description: 进入添加页面
	 * @param request
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
	JsonResult add(PublicityColumn entity) {
		Integer userId = getCurrentUserId();
		entity.setCreator_id(userId);
		entity.setCreate_time(new Date());
		return publicityColumnService.create(entity);
	}

	/**
	 * @Title: update
	 * @Description: 进入修改页面
	 * @param id
	 * @param model
	 * @return String
	 */
	@RequestMapping("/update")
	public String update(Integer id, Model model) {
		PublicityColumn entity = publicityColumnService.findById(id);
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
	JsonResult update(PublicityColumn entity) {
		return publicityColumnService.modify(entity);
	}

	/**
	 * @Title: update
	 * @Description: Ajax保存修改信息
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping(value = "/move", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult move(HttpServletRequest request, int sort, boolean is_up) {
		int toSort = WebUtil.getInt(request, "toSort", 0);
		return publicityColumnService.modifyMove(sort, is_up, toSort == 0 ? null : toSort);
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
		boolean result = publicityColumnService.validateTitle(id, title);
		return result;
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
		return publicityColumnService.removeById(id);
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
		return publicityColumnService.removeByIds(ids);
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
		PublicityColumn entity = publicityColumnService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
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
		PublicityColumnFile entity = publicityColumnService.findFileById(id);
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
		return "publicityColumn";
	}

	@Override
	public String getModuleName() {
		return "公示栏";
	}
}
