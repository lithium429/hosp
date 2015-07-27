<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout> 
	<gd:Navgation addr="工作流 &gt; 流程定义及部署管理"></gd:Navgation>
	<div class="data_model wc100 data_list_wrap" id="data_list">
		<table class="wc100">
			<thead>
				<tr>
					<th class="w10per">ProcessDefinitionId</th>
					<th class="w10per">DeploymentId</th>
					<th class="w100">名称</th>
					<th class="w80">KEY</th>
					<th class="w10per">版本号</th>
					<th class="w15per">XML</th>
					<th class="w15per">图片</th>
					<th class="w10per">部署时间</th>
					<th class="w80">是否挂起</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<c:set var="process" value="${item[0]}" />
					<c:set var="deployment" value="${item[1]}" />
					<tr>
						<td>${process.id }</td>
						<td>${process.deploymentId }</td>
						<td>${process.name }</td>
						<td>${process.key }</td>
						<td>${process.version }</td>
						<td><a target="_blank" href='workflow/process/xml/${process.id}'>${process.resourceName }</a></td>
						<td><a target="_blank" href='workflow/process/graph/${process.id}'>${process.diagramResourceName }</a></td>
						<td><fmt:formatDate value="${deployment.deploymentTime }" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${process.suspended} |
							<c:if test="${process.suspended }">
								<a href="workflow/process/active/${process.id}">激活</a>
							</c:if>
							<c:if test="${!process.suspended }">
								<a href="workflow/process/suspend/${process.id}">挂起</a>
							</c:if>
						</td>
						<td>
	                        <a href='workflow/process/delete/${process.deploymentId}'>删除</a>
	                        <a href='workflow/process/convert_to_model/${process.id}'>转换为Model</a>
	                    </td>
					</tr>
				</c:forEach>
			</tbody>
		</table>   
 	</div> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function(){
			// 添加
			$('#btn_add').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url: url,
					id: 'add_page',
					title: '添加模型',
					width: '500px',
					height: '300px'
				});
				return false;
			});
		});
	</script>
</gd:Layout> 
	