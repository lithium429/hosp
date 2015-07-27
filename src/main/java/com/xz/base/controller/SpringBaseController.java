package com.xz.base.controller;
 
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xz.base.model.JsonResult;
import com.xz.base.utils.LogHelper;
import com.xz.oa.core.domain.entity.RoleMenu;
import com.xz.oa.core.service.security.RoleMenuService;
import com.xz.oa.core.service.user.ShiroDbRealm.ShiroUser;

public abstract class SpringBaseController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	private RoleMenuService roleMenuService;

	protected String getBasePath(HttpServletRequest request) {
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
		return basePath;
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {  
		binder.registerCustomEditor(Date.class, new DateEditor()); 
		binder.registerCustomEditor(Float.class, new CustomNumberEditor(Float.class, true));
	}

	/**
	 * @Description 获取父模块路径
	 * @return String
	 * @author davidwan
	 */
	abstract public String getFModulePath();

	/**
	 * @Description 获取模块路径
	 * @return String
	 * @author davidwan
	 */
	abstract public String getModulePath();

	/**
	 * @Description 获取模块名称
	 * @return String
	 * @author davidwan
	 */
	abstract public String getModuleName();

	/**
	 * @Description 拼接指定页视图路径
	 * @return String
	 * @author davidwan
	 */
	public String getPath(String name) {
		return getFModulePath() + "/" + getModulePath() + "/" + name;
	}

	/**
	 * @Description 拼接列表页视图路径
	 * @return String
	 * @author davidwan
	 */
	public String getPathList() {
		return getFModulePath() + "/" + getModulePath() + "/list";
	}

	/**
	 * @Description 拼接添加页视图路径
	 * @return String
	 * @author davidwan
	 */
	public String getPathAdd() {
		return getFModulePath() + "/" + getModulePath() + "/add";
	}

	/**
	 * @Description 拼接更新页视图路径
	 * @return String
	 * @author davidwan
	 */
	public String getPathUpdate() {
		return getFModulePath() + "/" + getModulePath() + "/update";
	}

	/**
	 * @Description 拼接详细页视图路径
	 * @return String
	 * @author davidwan
	 */
	public String getPathView() {
		return getFModulePath() + "/" + getModulePath() + "/view";
	}

	/**
	 * @Description 获取当前登录用户Id
	 * @return Integer
	 * @author davidwan
	 */
	protected Integer getCurrentUserId() {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipal();
		return shiroUser.getId();
	}

	/**
	 * @Description
	 * @return Integer
	 */
	protected Integer getCurrentUserDeptId() {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipal();
		return shiroUser.getDept_id();
	}

	public List<RoleMenu> gainRoleMenu(int menu_id) {
		Subject currentUser = SecurityUtils.getSubject();
		ShiroUser shiroUser = (ShiroUser) currentUser.getPrincipals().getPrimaryPrincipal();
		RoleMenu a = new RoleMenu();
		a.setIs_action(true);
		a.getMap().put("menu_id_l", menu_id);
		a.getMap().put("my_id", shiroUser.getId());
		return roleMenuService.queryList_power(a);
	}

	/**
	 * @Description 处理异常
	 * @param ex
	 * @return String
	 * @author davidwan
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public JsonResult handleException(HttpServletRequest request, Exception ex) {
		String msg = null;
		String url = request.getRequestURI();
		if (ex instanceof DataIntegrityViolationException && url.indexOf("delete") > -1) {
			msg = "该" + getModuleName() + "有关联的信息，无法删除！";
		} else {
			msg = "系统错误，请联系系统管理员！";
		}
		LogHelper.getLogger().error(msg, ex);
		return new JsonResult(false, msg);
	}
}
