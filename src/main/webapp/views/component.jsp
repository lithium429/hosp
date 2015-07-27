<%@ page import="com.xz.base.utils.WebUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>控件安装</title>
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script>
<!-- 
<script type="text/javascript" src="static/js/ntko/control.js"></script> -->
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	font-family: "Microsoft YaHei", "宋体", arial, serif;
	font-size: 11px;
}

img {
	border: none;
}

a,a:visited {
	text-decoration: none;
	color: #5b98d0;
}

.main {
	width: 450px;
	margin: 0 auto;
}

.title {
	margin-top: 15px;
	padding-left: 20px;
	font-size: 12px;
}

.content {
	margin-left: 40px;
	margin-top: 40px;
	width: 360px;
}

.ocxcontent {
	width: 310px;
	float: left;
	line-height: 18px;
	margin-bottom: 24px;
}

.ocxtitle {
	font-size: 14px;
	font-weight: bold;
	line-height: 24px;
}

.download {
	width: 30px;
	float: right;
}

.bottom {
	margin-top: 36px;
	margin-left: 40px;
}
</style>
</head>
<body>
	<!--加载控件-->
    <div id="obj" style="display: none">
        <!--office平台版-->
        <object id="office" classid="clsid:C9BC4DFF-4248-4a3c-8A49-63A7D317F404"></object>
       
    </div>
    <div id="tmp" style="display: none"></div>
    <div class="main">
        <div class="title">控件安装</div>
        <div class="content">
            <div class="ocx">
                <div class="ocxcontent">
                    <p class="ocxtitle">OFFICE文档控件</p>
                    <p>OFFICE文档控件在浏览器中可直接编辑和导入Word、Excel文档并保存到服务器，实现文档和电子表格的统一管理，具备手写签名、电子印章、痕迹保留、模板套红、条码管理等功能。</p>
                </div>
                <div class="download">
                    <a href="static/js/weboffice/weboffice.exe">
                        <img id="foroffice" src="static/images/download.png" alt="下载控件" />
					</a>
                </div>
            </div>    
            <div class="ocx">
                <div class="ocxcontent">
                    <p class="ocxtitle">ie8浏览器下载控件</p>
                    <p>支持的操作系统： Windows XP Service Pack 2; Windows XP Service Pack 3</p>
                </div>
                <div class="download">
                    <a href="static/js/ie/ie8.rar">
                        <img id="forsfoffice" src="static/images/download.png" alt="下载控件" />
					</a>
                </div>
            </div> 
            <div class="ocx">
                <div class="ocxcontent">
                    <p class="ocxtitle">安装龙图Exe调用控件</p>
                </div>
                <div class="download">
                    <a href="static/js/appCaller/appCaller.exe">
                        <img id="forpdftif" src="static/images/download.png" alt="下载控件" />
					</a>
                </div>
            </div> 
            <div class="ocx">
                <div class="ocxcontent">
                    <p class="ocxtitle">depend</p>
                </div>
                <div class="download">
                    <a href="static/js/depend/Depends.bkill.com.zip">
                        <img id="dependtif" src="static/images/download.png" alt="下载控件" />
					</a>
                </div>
            </div>           
        </div>
        <div style="clear: both"></div>
        <div class="bottom">
            <span class="ocxtitle">注：</span>浏览器需运行“为此计算机上的所有用户安装此加载项选项”
        </div>
    </div> 
    
</body> 
</html>