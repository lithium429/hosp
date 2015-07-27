package com.xz.oa.core.web.controller;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;
import nl.justobjects.pushlet.core.Session;
import nl.justobjects.pushlet.core.SessionManager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;

import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.LogHelper;
import com.xz.base.utils.WebUtil;
import com.xz.base.context.SpringContextHolder;
import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.JsonResult;
import com.xz.base.model.PageInfo;
import com.xz.oa.core.domain.entity.NotifyMessage;
import com.xz.oa.core.service.notify.NotifyMessageService;
import com.xz.oa.core.service.user.OnlineUser;

@Controller
@RequestMapping(value = "/notifyMessage")
public class NotifyMessageController extends SpringBaseController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4539316915541624480L;

	public static class NotifyPullSource extends EventPullSource {
		/*
		 * 设置休眠时间
		 */
		@Override
		protected long getSleepTime() {
			return 10 * 1000;
		}

		/*
		 * 创建事件 业务部分写在pullEvent()方法中，这个方法会被定时调用。
		 */
		@Override
		protected Event pullEvent() {
			Event event = Event.createDataEvent("/notify/message");

			int count = SessionManager.getInstance().getSessionCount();
			if (count >= 1) {
				Session[] sessions = SessionManager.getInstance().getSessions();
				String userId = sessions[0].getEvent().getField("user_id");

				WebApplicationContext context = SpringContextHolder.getContext();
				NotifyMessageService notifyService = (NotifyMessageService) context.getBean("notifyService");

				NotifyMessage entity = new NotifyMessage();
				entity.setIs_query(false);
				entity.setIs_read(false);
				entity.setReceiver_id(Integer.parseInt(userId));
				Map<Integer, List<NotifyMessage>> map = notifyService.modifyAndQueryMapList(entity);
				try {
					String data = buildText(map);
					event.setField("data", data);
				} catch (Exception ex) {
					LogHelper.getLogger().error("构建事务通知信息时出错", ex);
				}

				// 在线用户
				event.setField("userCount", OnlineUser.getInstance().gainUserCount());
			}

			return event;
		}

		private String buildText(Map<Integer, List<NotifyMessage>> map) throws UnsupportedEncodingException {
			if (map == null) {
				return "";
			}

			StringBuffer buffer = new StringBuffer();
			List<NotifyMessage> list = null;
			String senderName = null;
			for (Integer key : map.keySet()) {
				list = map.get(key);
				if (list != null && !list.isEmpty()) {
					for (NotifyMessage item : list) {
						senderName = StringUtils.isBlank(item.getSender_real_name()) ? "系统" : item.getSender_real_name();
						buffer.append(key).append("#").append(item.getId()).append("#").append(item.getUrl()).append("#").append(item.getCreate_time()).append("#")
								.append(URLEncoder.encode(senderName, "utf-8")).append("#").append(URLEncoder.encode(item.getContent(), "utf-8")).append("#")
								.append(item.getReceiver_id()).append("^");
					}
				}
				buffer.append("|");
			}

			return buffer.toString();
		}
	}

	@Resource
	private NotifyMessageService notifyMessageService;

	/**
	 * @Description 进入列表页面
	 * @param request
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
		int pageIndex = WebUtil.getInt(request, "page_index", 0);
		int pageSize = WebUtil.getInt(request, "page_size", ConfigValue.PAGE_SIZE);
		String name = WebUtil.getString(request, "name", "");
		NotifyMessage entity = new NotifyMessage();
		if (StringUtils.isNotBlank(name)) {
			// entity.setName(name);
		}
		PageInfo<NotifyMessage> pageInfo = notifyMessageService.queryPageList(entity, pageIndex, pageSize);
		model.addAttribute("list", pageInfo.getData());
		model.addAttribute("pageInfo", pageInfo);
	}

	/**
	 * @Description 获取列表数据
	 * @param model
	 * @author davidwan
	 */
	@RequestMapping("/homelist")
	public @ResponseBody
	Map<Integer, List<NotifyMessage>> homeList(Boolean is_init, HttpServletRequest request) {
		NotifyMessage entity = new NotifyMessage();
		entity.setIs_read(false);
		entity.setIs_query(!is_init);
		entity.setReceiver_id(getCurrentUserId());
		Map<Integer, List<NotifyMessage>> map = notifyMessageService.modifyAndQueryMapList(entity);
		return map;
	}

	/**
	 * @Description 标记已读
	 * @param id
	 * @return JsonResult
	 */
	@RequestMapping("/read")
	public @ResponseBody
	JsonResult read(Integer id) {
		NotifyMessage entity = new NotifyMessage();
		entity.setId(id);
		entity.setIs_read(true);
		return notifyMessageService.modify(entity);
	}

	/**
	 * @Description 标记当前用户所有未读提醒为已读
	 * @param entity
	 * @return JsonResult
	 */
	@RequestMapping("/readall")
	public @ResponseBody
	JsonResult readAll(NotifyMessage entity) {
		entity.getMap().put("receiver_id", getCurrentUserId());
		entity.setIs_read(true);
		return notifyMessageService.modify(entity);
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
		NotifyMessage entity = notifyMessageService.findById(id);
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
	JsonResult update(NotifyMessage entity) {
		return notifyMessageService.modify(entity);
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
		return notifyMessageService.removeById(id);
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
		return notifyMessageService.removeByIds(ids);
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
		NotifyMessage entity = notifyMessageService.findById(id);
		model.addAttribute("model", entity);
		return getPathView();
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "notifyMessage";
	}

	@Override
	public String getModuleName() {
		return "模块名称";
	}
}
