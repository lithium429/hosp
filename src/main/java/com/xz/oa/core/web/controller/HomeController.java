/**   
 * @Title: HomeController.java 
 * @Package: com.xz.oa.core.controller 
 * @Description: 
 * @author: davidwan
 * @date: 2014-7-15 上午10:57:20 
 * @version: V1.0   
 */
package com.xz.oa.core.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xz.base.controller.SpringBaseController;
import com.xz.base.model.PageInfo;
import com.xz.base.utils.ConfigValue;
import com.xz.base.utils.DateUtil;
import com.xz.oa.core.domain.entity.Announcement;
import com.xz.oa.core.domain.entity.AnnouncementType;
import com.xz.oa.core.domain.entity.EmailUser;
import com.xz.oa.core.domain.entity.Meeting;
import com.xz.oa.core.domain.entity.Menu;
import com.xz.oa.core.domain.entity.PublicityColumn;
import com.xz.oa.core.domain.entity.Scheduling;
import com.xz.oa.core.domain.entity.User;
import com.xz.oa.core.domain.enums.EnumHomeMeetingType;
import com.xz.oa.core.domain.enums.EnumPublicityColumnType;
import com.xz.oa.core.service.announcement.AnnouncementService;
import com.xz.oa.core.service.announcement.AnnouncementTypeService;
import com.xz.oa.core.service.email.EmailUserService;
import com.xz.oa.core.service.meeting.MeetingService;
import com.xz.oa.core.service.organization.CompanyService;
import com.xz.oa.core.service.publicitycolumn.PublicityColumnService;
import com.xz.oa.core.service.scheduling.SchedulingService;
import com.xz.oa.core.service.user.OnlineUser;
import com.xz.oa.core.service.user.UserService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

@Controller
@RequestMapping(value = "/home")
public class HomeController extends SpringBaseController {

	@Resource
	private UserService userService;

	@Resource
	private CompanyService companyService;

	@Resource
	private AnnouncementTypeService announcementTypeService;

	@Resource
	private AnnouncementService announcementService;

	@Resource
	private MeetingService meetingService;

	@Resource
	private SchedulingService schedulingService;

	@Resource
	private EmailUserService emailUserService;
	
	@Resource
	private PublicityColumnService publicityColumnService;

	/**
	 * @Description 进入首页
	 * @param model
	 * @return String
	 */
	@RequestMapping("index")
	public String index(HttpServletRequest request, Model model, HttpSession session) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		Integer userId = getCurrentUserId();
		int login_type = 0;
		Boolean is_login = (Boolean) session.getAttribute("is_login");
		Map<Integer, List<Menu>> map = userService.queryUserMenus(userId);
		if (map != null) {
			model.addAttribute("menuListOne", map.get(1));
			model.addAttribute("menuListTwo", map.get(2));
			model.addAttribute("menuListThree", map.get(3));
		}
		if (is_login != null && is_login) {
			session.removeAttribute("is_login");
			User u = userService.findById(userId);
			if (u.getIs_first_login()) {
				login_type = 1;
			} else if (u.getIs_reseted_psw()) {
				login_type = 2;
			}
			if (login_type > 0) {
				u.setIs_first_login(false);
				u.setIs_reseted_psw(false);
				userService.modify("", u);
			}
		}

		// 获取当前登录用户

		DateTime now = DateTime.now();
		model.addAttribute("month", now.getMonthOfYear());
		model.addAttribute("day", now.getDayOfMonth());
		model.addAttribute("weekday", DateUtil.getDayOfWeekForText(now.getYear(), now.getMonthOfYear(), now.getDayOfMonth()));
		model.addAttribute("userId", userId);
		model.addAttribute("login_type", login_type);
		model.addAttribute("real_name", shiroUser.getRealName());

		List<String> moduleList = userService.gainModule(shiroUser.getName());

		model.addAttribute("moduleList", moduleList);
		String sys_password = (String) session.getAttribute("sys_password");
		if (sys_password != null) {
			model.addAttribute("com_psw", shiroUser.getName() + " " + sys_password);
		}

		String systemCode = ConfigValue.readValue("systemCode", "001");
		String systemName = companyService.findCompanyName();
		model.addAttribute("systemCode", systemCode);
		model.addAttribute("systemName", systemName);

		// 在线用户数量
		Integer onlineUserCount = OnlineUser.getInstance().gainUserCount();
		if (onlineUserCount == 0) {
			return "redirect:/tlogout.do";
		}
		model.addAttribute("onlineUserCount", onlineUserCount);

		return getPath("index");
	}

	@RequestMapping("info")
	public String info(Model model) {
		// 公告类型
		PageInfo<AnnouncementType> announcementTypePageInfo = announcementTypeService.queryPageList(new AnnouncementType(), 1, 5);
		model.addAttribute("announcementTypeList", announcementTypePageInfo.getData());

		// 公告
		PageInfo<Announcement> announcementPageInfo = announcementService.queryHomePageList(new Announcement(), 1, 10);
		model.addAttribute("announcementList", announcementPageInfo.getData());
		
		// 公示栏
		PageInfo<PublicityColumn> pcPageInfo = publicityColumnService.queryPageList(new PublicityColumn(EnumPublicityColumnType.院务公开栏.getValue()), 1, 10);
		model.addAttribute("publicityColumnList", pcPageInfo.getData());

		// 会议
		PageInfo<Meeting> meetingPageInfo = meetingService.queryHomePageList(new Meeting(), getCurrentUserId(), EnumHomeMeetingType.本周.getValue(), 1, 10);
		model.addAttribute("meetingList", meetingPageInfo.getData());

		// 内部邮件
		PageInfo<EmailUser> emailPageInfo = emailUserService.queryHomePageList(new EmailUser(), null, 1, 10);
		model.addAttribute("emailList", emailPageInfo.getData());
		
		// 今日值日表
		Map<String, List<Scheduling>> schedulingMap = schedulingService.queryHomeMap(new Scheduling());
		model.addAttribute("schedulingMap", schedulingMap);

		return getPath("info");
	}

	@Override
	public String getFModulePath() {
		return "core";
	}

	@Override
	public String getModulePath() {
		return "home";
	}

	@Override
	public String getModuleName() {
		return "首页";
	}
}
