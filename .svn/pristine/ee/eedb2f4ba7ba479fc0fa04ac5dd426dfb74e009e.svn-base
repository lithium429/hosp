
package com.xz.oa.core.web.controller.forum; 
 
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.WebUtil; 
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.ForumPlate;
import com.xz.oa.core.domain.entity.ForumThread;
import com.xz.oa.core.service.forum.ForumPlateService;
import com.xz.oa.core.service.forum.ForumThreadService; 
import com.xz.oa.core.web.controller.UploadSetController;

@Controller
@RequestMapping(value = "/forum/thread")
public class ForumThreadController extends UploadSetController {

	@Resource
	private ForumPlateService forumPlateService;
	
	@Resource
	private ForumThreadService forumThreadService;
	
	/**
	 * @Description 进入列表页面
	 * @param request 
	 * @return String    
	 * @author davidwan 
	 */
	@RequestMapping("/list")
	public String list(HttpServletRequest request, Model model) {
		getList(request, model);
		List<ForumPlate> plateList = forumPlateService.queryList(new ForumPlate());
		model.addAttribute("plateList", plateList);		
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
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		String subject = WebUtil.getString(request, "subject", "");
		Integer plateId = WebUtil.getInteger(request, "plate_id", null);
		
		ForumThread entity = new ForumThread(true);
		if(StringUtils.isNotBlank(subject)){
			entity.getMap().put("subject", subject);
		}
		entity.setPlate_id(plateId);
		
		
		PageInfo<ForumThread> pageInfo = forumThreadService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
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
		Integer plateId = WebUtil.getInteger(request, "plate_id", null);
		Boolean fromUserCenter = WebUtil.getBoolean(request, "from_user_center", false);
		String from = WebUtil.getString(request, "from", null);
		ForumThread entity = new ForumThread(plateId);
		model.addAttribute("model", entity);
		model.addAttribute("from", from);
		
		if(fromUserCenter){
			List<ForumPlate> list = forumPlateService.queryList(new ForumPlate());
			model.addAttribute("plateList", list);
			model.addAttribute("from_user_center", true);
		}
		
		initConfigValues(model);
		
		return getPathAdd();
	}

	/**
	 * @Title: add
	 * @Description: Ajax保存添加数据
	 * @param entity
	 * @param session
	 * @return JsonResult
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult add(ForumThread entity, HttpSession session) {
		entity.setCreator_id(getCurrentUserId());
		entity.setLast_poster_id(getCurrentUserId());
		entity.setLast_post_time(new Date());
		entity.setCreate_time(new Date()); 
		return forumThreadService.create(entity, session);
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
		ForumThread entity = forumThreadService.findById(id);
		model.addAttribute("model", entity);
		
		initConfigValues(model);
		
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
	JsonResult update(ForumThread entity) {
		return forumThreadService.modify(entity);
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
		return forumThreadService.removeById(id);
	}
	
	/**
	 * @Title: logic_delete
	 * @Description: Ajax删除
	 * @param id
	 * @param plate_id
	 * @param session
	 * @return JsonResult
	 */
	@RequestMapping(value = "/logic_delete", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult logicDelete(Integer id, Integer plate_id, HttpSession session) {
		return forumThreadService.modifyForDelete(id, plate_id, session);
	}

	/**
	 * @Title: batchDelete
	 * @Description: Ajax批量删除
	 * @param ids
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batch_delete", method = RequestMethod.POST)
	public @ResponseBody
	JsonResult batchDelete(String ids) {
		return forumThreadService.removeByIds(ids);
	}
	
	/**
	 * @Title: recover
	 * @Description: Ajax恢复
	 * @param id
	 * @param plate_id
	 * @param session
	 * @return JsonResult
	 */
	@RequestMapping(value = "/recover", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult recover(Integer id, Integer plate_id, HttpSession session) {
		return forumThreadService.modifyForRecover(id, plate_id, session);
	}
	
	/**
	 * @Title: recover
	 * @Description: Ajax恢复
	 * @param ids
	 * @param session
	 * @return JsonResult
	 */
	@RequestMapping(value = "/batch_recover", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult batchRecover(String ids, HttpSession session) {
		return forumThreadService.modifyForBatchRecover(ids.split(","), session);
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
		ForumThread entity = forumThreadService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}
	
	/**
	 * @Description 移动 
	 * @param id
	 * @param plate_id
	 * @param model
	 * @return String     
	 */
	@RequestMapping("/move")
	public String move(Integer id, Integer plate_id, Model model) {
		List<ForumPlate> list = forumPlateService.queryList(new ForumPlate());
		model.addAttribute("plateList", list);
		model.addAttribute("id", id);
		model.addAttribute("plate_id", plate_id);
		return getPath("move");
	}
	
	
	/**
	 * @Description ajax保存移动 
	 * @param entity
	 * @return JsonResult     
	 */
	@RequestMapping(value = "/move", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult move(ForumThread entity) {
		return forumThreadService.modifyForMove(entity);
	}
	
	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "forumThread";
	}

	@Override
	public String getModuleName() {
		return "主题";
	} 
}
