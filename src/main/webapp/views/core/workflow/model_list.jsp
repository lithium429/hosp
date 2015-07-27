<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout> 
	<gd:Navgation addlink="workflow/model/gotoaddmodel.do" addr="工作流 &gt; 模型管理"></gd:Navgation>
	<div class="data_model wc100 data_list_wrap" id="data_list">
	     <table class="wc100">
			<thead>
				<tr>
					<th class="w80">Id</th>
					<th class="w80">Key</th>
					<th class="w120">Name</th>
					<th class="w80">Version</th>
					<th class="w10per">创建时间</th>
					<th class="w10per">最后更新时间</th>
					<th class="w30per">元数据</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.id }</td>
						<td>${item.key }</td>
						<td>${item.name}</td>
						<td>${item.version}</td>
						<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><fmt:formatDate value="${item.lastUpdateTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>${item.metaInfo}</td>
						<td>
							<a href="workflow/model/modeler?modelId=${item.id}" target="_blank">编辑</a>
							<a href="workflow/model/deploy/${item.id}">部署</a>
							<a href="workflow/model/export/${item.id}" target="_blank">导出</a>
	                        <a href="workflow/model/delete/${item.id}">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
 	</div>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
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