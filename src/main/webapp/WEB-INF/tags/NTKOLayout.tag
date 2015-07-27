<%@ tag language="java" pageEncoding="UTF-8" import="com.xz.base.utils.WebUtil" %>
<%@ attribute name="title" fragment="true"%>
<%@ attribute name="css" fragment="true"%>
<%@ attribute name="js" fragment="true"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<%
	request.setAttribute("baseUrl", WebUtil.getBasePath(request));
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta content="IE=7" http-equiv="X-UA-Compatible" /> 
	<!--设置缓存-->
	<meta http-equiv="cache-control" content="no-cache,must-revalidate" />
	<meta http-equiv="pragram" content="no-cache" />
	<meta http-equiv="expires" content="0" />
	
	<title>OA</title>
	<base href="${baseUrl}" />
	<link rel="stylesheet" type="text/css" href="static/css/manage.css" /> 
	<link rel="stylesheet" type="text/css" href="static/js/artDialog/skins/blue.css" /> 
	<jsp:invoke fragment="css" />
	<script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script> 
	<script type="text/javascript" src="static/js/artDialog/jquery.artDialog.js"></script>
	<script type="text/javascript" src="static/js/artDialog/plugins/iframeTools.js"></script> 
	<script type="text/javascript" src="static/js/base.js"></script>   
	<jsp:invoke fragment="js" />
</head>
<body>
	<jsp:doBody />
	<script type="text/javascript">
		window.onerror =  function(){
			if(browser.isIE && art.dialog){
				$('.aui_close:last', art.dialog.top.parent.document).attr('style', 'visibility:visible;');
			}
		}
	</script>
</body>
</html>