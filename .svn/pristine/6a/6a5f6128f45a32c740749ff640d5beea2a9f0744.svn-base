
package com.xz.oa.core.web.controller.rewardpunishment; 
 
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
import com.xz.base.utils.DateUtil;
import com.xz.base.utils.WebUtil;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.RewardPunishment;
import com.xz.oa.core.domain.entity.RpFile;
import com.xz.oa.core.service.file.FileDownload;
import com.xz.oa.core.service.rewardpunishment.RewardPunishmentService;
import com.xz.oa.core.service.rewardpunishment.RpFileService;
import com.xz.oa.core.service.rewardpunishment.RpItemService;

@Controller
@RequestMapping(value = "/rewardPunishment")
public class RewardPunishmentController extends SpringBaseController {

	@Resource
	private RewardPunishmentService rewardPunishmentService;
	@Resource
	private RpItemService rpItemService;
	@Resource
	private RpFileService rpFileService;
	
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
		String item_name = WebUtil.getString(request, "item_name", "");
		String unit = WebUtil.getString(request, "unit", "");
		int menu_id = WebUtil.getInt(request, "menu_id", 0);
		String types = WebUtil.getString(request, "types", "");
		String rp_date_min = WebUtil.getString(request, "rp_date_min", "");
		String rp_date_max = WebUtil.getString(request, "rp_date_max", "");
		RewardPunishment entity = new RewardPunishment();
		if(StringUtils.isNotBlank(name)){
			entity.getMap().put("name", name);
		}
		if(StringUtils.isNotBlank(item_name)){
			entity.getMap().put("item_name", item_name);
		}
		if(StringUtils.isNotBlank(unit)){
			entity.getMap().put("unit", unit);
		}
		if(StringUtils.isNotBlank(types)){
			entity.getMap().put("types", types.split(","));
		}
		if (StringUtils.isNotBlank(rp_date_min)) {
			entity.getMap().put("rp_date_min", DateUtil.strToDate(rp_date_min + " 00:00:00", "yyyy-MM-dd HH:mm:ss"));
		}
		if (StringUtils.isNotBlank(rp_date_max)) {
			entity.getMap().put("rp_date_max", DateUtil.strToDate(rp_date_max + " 23:59:59", "yyyy-MM-dd HH:mm:ss"));
		}
		entity.getMap().put("sort", true);
		PageInfo<RewardPunishment> pageInfo = rewardPunishmentService.queryPageList(entity, pageIndex, pageSize);
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
	JsonResult add(RewardPunishment entity) {
		return rewardPunishmentService.create(entity);
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
		RewardPunishment entity = rewardPunishmentService.findById(id);
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
	JsonResult update(RewardPunishment entity) {
		return rewardPunishmentService.modify(entity);
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
		return rewardPunishmentService.removeById(id);
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
		return rewardPunishmentService.removeByIds(ids);
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
		RewardPunishment entity = rewardPunishmentService.findById(id);
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
		RpFile entity = rpFileService.findById(id);
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
		return "rewardPunishment";
	}

	@Override
	public String getModuleName() {
		return "奖惩记录";
	} 
}
