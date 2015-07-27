<%@ tag language="java" pageEncoding="UTF-8" import="com.xz.base.utils.WebUtil" %>
<%@ attribute name="title" fragment="true"%>
<%@ attribute name="css" fragment="true"%>
<%@ attribute name="js" fragment="true"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<%
	String baseUrl = WebUtil.getBasePath(request);
	request.setAttribute("baseUrl", baseUrl);
%>

<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
	<title>护理天地_上海市第一康复医院</title>
	<base href="${baseUrl}" />

	<link rel="stylesheet" type="text/css" href="static/css/news.css" />
	<jsp:invoke fragment="css" />
	<script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script>
	<!--  
	<script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.validate.unobtrusive.min.js"></script>
	<script type="text/javascript" src="static/js/jquery.unobtrusive-ajax.min.js"></script>
	<script type="text/javascript" src="static/js/artDialog/jquery.artDialog.js"></script>
	<script type="text/javascript" src="static/js/artDialog/plugins/iframeTools.js"></script>
	<script type="text/javascript" src="static/js/base.js"></script>  -->
	
	
	<!--[if lte IE 6]>
	<script type="text/javascript" src="static/js/DD_belatedPNG_0.0.8a-min.js"></script>
	<script type="text/javascript">
		DD_belatedPNG.fix('.png,.count,#control_navbar,.app_cont,#funbar_left .subtabs a,#funbar_left .subtabs a.cur .inner,.app_name_inner,.app_inner_r,.foot .start,.pannel_split,#menu_panel .panel_head,#menu_panel .panel_user,#menu_panel .panel_menu,#menu_panel .panel_foot');
	</script>
	<![endif]-->
	<jsp:invoke fragment="js" />
</head>
<body class="frame_wrap">
	<div class="topbar">
		<div class="p_rel wrap">
			欢迎来到上海市第一康复医院！
			<span class="ml15 time">
				<script type="text/javascript">
					var year, month, day, week,
					date = new Date();
					year = date.getFullYear();
					month = date.getMonth() + 1;
					dayOfMonth = date.getDate();
					day = date.getDay();
					
					switch(day){
						case 0:
							week = "星期日";
							break;
						case 1:
							week = "星期一";
							break;
						case 2:
							week = "星期二";
							break;
						case 3:
							week = "星期三";
							break;
						case 4:
							week = "星期四";
							break;
						case 5:
							week = "星期五";
							break;
						case 6:
							week = "星期六";
							break; 
					} 
					document.write("今天是 " + year + "年" + month + "月" + dayOfMonth + "日 " + week);
				</script>
			</span>
			<div class="topnav">
				<a href="http://www.yplnyy.com/" target="_blank" class="home">上海市第一康复医院</a>
			</div>
		</div>
	</div>
	<div class="wrap topbanner">
		<img src="static/images/topbanner.jpg" alt="oa系统" title="上海市第一康复医院oa系统" />
		<a href="http://www.yplnyy.com/" target="_blank" class="logo_link" title="上海市第一康复医院">上海市第一康复医院</a>
	</div>
	<jsp:doBody />
	<!--S footer -->
	<div id="footer">
	    <div id="footer_text">
	        <p>
				Copyright © 2014.上海市第一康复医院 .All Rights Reserved 上海市第一康复医院信息中心，邮箱：lingyingdu@163.com<br>
				地址：上海市杨浦区杭州路349号 邮编：200090  电话：021-65432021  传真：021-65432021-713<br>
				沪ICP备06055554号
	        </p>
	    </div>
	</div>
	<!--E footer -->
</body>
</html>