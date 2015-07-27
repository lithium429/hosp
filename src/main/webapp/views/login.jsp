<%@ page import="com.xz.base.utils.WebUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<%@ page import="com.xz.base.utils.ConfigValue" %>
<%@ page import="org.springframework.context.ApplicationContext"%>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page import="com.xz.oa.core.service.organization.CompanyService" %>
<%
	String systemCode = ConfigValue.readValue("systemCode", "001");
	ApplicationContext theContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
	CompanyService companyService = (CompanyService)theContext.getBean("companyService"); 
	String systemName = companyService.findCompanyName();
	request.setAttribute("systemCode", systemCode);
	request.setAttribute("systemName", systemName);
%>
<!DOCTYPE html>
<html>
<head>
<title>医院OA办公自动化管理系统</title>
<base href="<%=WebUtil.getBasePath(request)%>" />
<link rel="stylesheet" type="text/css" href="static/css/login.css" />
</head>
<body>
	<div class="wrap_login">
		<div class="login_logo">
			<img src="static/images/llogo_${systemCode}.png" alt="${systemName}" />
			<h1>医院OA办公自动化管理系统</h1>
		</div>
		<div class="login_form">
			<h2>系统登录</h2>
			<form id="login_form" method="post" action="login.do">
				<ul class="login_list">
					<li>
						<label>
							<span class="dib lab_tit User">用户名：</span><input type="text" value="${userName}" name="user_name" id="user_name" class="inp_t user_name" data-val="true" data-val-required="请输入用户名！" />
							<span class="field-validation-error" data-valmsg-for="user_name" data-valmsg-replace="true">
								<span for="user_name" generated="true" class="dn">请输入用户名！</span>
							</span>
						</label>
					</li> 
					<li>
						<label>
							<span class="dib lab_tit Paw">密&nbsp;&nbsp;&nbsp;码：</span><input type="password" name="password" id="password" value="${password}" class="inp_t user_paw" data-val="true" data-val-required="请输入密碼！" />
							<span class="field-validation-error" data-valmsg-for="password" data-valmsg-replace="true">
								<span for="password" generated="true" class="dn">请输入密码！</span>
							</span>
						</label>
					</li>
					<c:if test="${displayCaptcha}">
						<li>
							<label>
								<span class="dib lab_tit verif">验证码：</span>
								<input type="text" value="" name="captcha" id="captcha" class="inp_t" style="width: 80px" data-val="true" data-val-required="请输入验证码！" />
								<img src="static/vimages/verifycode.jpg" class="v_m" id="captcha_img" alt="点击刷新验证码" />
								<span class="field-validation-error" data-valmsg-for="captcha" data-valmsg-replace="true">
									<span for="captcha" generated="true" class="dn">请输入验证码！</span>
								</span>
							</label>
						</li>
					</c:if>
				</ul>
				<p class="btn_area">
					<input type="submit" id="btn_login" class="btn_submit" value="登录" />
				</p>
				<c:if test="${!empty errorInfo}">
					<p class="mt10 pl130">
						<span class="field-validation-error">${errorInfo}</span>
					</p>
				</c:if>
			</form>
		</div>
		<span class="show mt20 t_info">${systemName} All rights Reserved.   技术支持：上海联众 <a href="component.do" class="ml8" target="_blank">组件下载</a></span>
	</div>
	<script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
    <script type="text/javascript" src="static/js/jquery.unobtrusive-ajax.min.js" ></script>
    <script type="text/javascript" src="static/js/jquery.validate.unobtrusive.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#user_name').focus();

			$('#captcha_img').click(function() {
				$(this).attr('src', 'static/vimages/verifycode.jpg?time=' + new Date().getTime());
			});
		});
	</script>
</body>