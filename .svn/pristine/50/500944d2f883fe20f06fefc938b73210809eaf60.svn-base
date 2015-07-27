<%@page import="com.xz.oa.core.service.activiti.ProcessDefinitionCache,org.activiti.engine.RepositoryService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<%
	RepositoryService repositoryService = WebApplicationContextUtils.getWebApplicationContext(session.getServletContext()).getBean(org.activiti.engine.RepositoryService.class);
	ProcessDefinitionCache.setRepositoryService(repositoryService);
%> 
<gd:Layout> 
	<gd:Navgation addr="工作流 &gt; 运行中的流程"></gd:Navgation>
	<div class="data_model wc100 data_list_wrap" id="data_list">
		<table class="wc100"> 
			<tr>
				<th>执行IDssss</th>
				<th>流程实例ID</th>
				<th>流程定义ID</th>
				<th>当前节点</th>
				<th>是否挂起</th>
				<th>操作</th>
			</tr>
	
			<c:forEach items="${list}" var="p">
				<c:set var="pdid" value="${p.processDefinitionId }" />
				<c:set var="activityId" value="${p.activityId }" />
				<tr>
					<td>${p.id }</td>
					<td>${p.processInstanceId }</td>
					<td>${p.processDefinitionId }</td>
					<td><a class="trace" href='#' pid="${p.id }" pdid="${p.processDefinitionId}" title="点击查看流程图"><%=ProcessDefinitionCache.getActivityName(pageContext.getAttribute("pdid").toString(), ObjectUtils.toString(pageContext.getAttribute("activityId"))) %></a></td>
					<td>${p.suspended }</td>
					<td>
						<c:if test="${p.suspended }">
							<a href="workflow/processdefinition/update/active/${p.processInstanceId}">激活</a>
						</c:if>
						<c:if test="${!p.suspended }">
							<a href="workflow/processdefinition/update/suspend/${p.processInstanceId}">挂起</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>   
	</div>
</gd:Layout>