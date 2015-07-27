<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<div class="tabs_hd">
	<ul class="clearfix Tab_Panels">
		<li class="${type==0?'cur':'' }"><a href="handlingProcess/list.do?type=0" class="tab_inner" key="2">待我处理的督办流程</a></li>
		<li class="${type==1?'cur':'' }"><a href="handlingProcess/list.do?type=1" class="tab_inner" key="0">我创建的督办流程</a></li>
		<li class="${type==2?'cur':'' }"><a href="handlingProcess/list.do?type=2" class="tab_inner" key="0">我处理过的督办流程</a></li>
	</ul>
</div>
