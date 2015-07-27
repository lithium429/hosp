<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<script type="text/javascript" src="static/js/flexigrid-1.1/js/flexigrid.js"></script> 
<div class="datalistbox" style="top:80px;left:312px;">
	<table class="OptionTable" id="tableSort">
	<thead>
		<tr>
			<th class="check w3per">
				<input type="checkbox" id="check_all" class="inp_analog" />
				<span class="icon ico-checkbox"></span>
			</th>
			<th class="serial w5per">序号</th>
			<th class="w20per">文件</th> 
			<th class="w20per">上传时间</th>
			<th class="w15per">上传用户</th>
			<th class="w15per">部门科室</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="item" varStatus="vs">
			<tr>
				<td class="check w3per">
					<input type="checkbox" name="id" class="inp_analog batch" value="${item.id}" />
					<span class="icon ico-checkbox"></span>
				</td>
				<td class="serial">${vs.count+pageInfo.startIndex}</td> 
				<td>${item.name}</td> 
				<td>
					<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> 
				<td>
					${item.creator_name}
				</td>
				<td>
					${item.dept_name}
				</td>
				<td>
					<c:if test="${userId != null && userId == item.creator_id}">
						<c:if test='${gdf:judgeRoleMenu(roleMenuList, "可见用户") }'>
							<a href="file/fileuser.do?id=${item.id}" class="fileuser">可见用户</a>
						</c:if>
						<c:if test='${gdf:judgeRoleMenu(roleMenuList, "修改文件名") }'>
							<a href="file/updatename.do?id=${item.id}" class="update_name">修改文件名</a>
						</c:if>
					</c:if>
					<c:choose>
						<c:when test='${gdf:containsValue("gif,jpg,jpeg,png,bmp", item.extension) && gdf:judgeRoleMenu(roleMenuList, "查看")}'>
							<a href="${item.url}" rel="lightbox"><img src="${item.url}" class="dn" jqimg="${item.url}" />查看</a>
						</c:when>
						<c:when test='${gdf:containsValue("doc,docx,xls,xlsx,ppt", item.extension) && gdf:judgeRoleMenu(roleMenuList, "阅读")}'>
							<a href="file/view.do?id=${item.id}" class="view">阅读</a> 
							<%-- <a href="file/update.do?id=${item.id}&directory_id=${item.directory_id}" class="update">修改</a> --%>
						</c:when>
					</c:choose>
					<c:if test='${gdf:judgeRoleMenu(roleMenuList, "下载") }'>
						<a href="file/download.do?id=${item.id}" class="download" target="_blank">下载</a>
					</c:if>
					<c:if test='${gdf:judgeRoleMenu(roleMenuList, "删除") }'> 
						<a href="file/logicdelete.do?id=${item.id}" class="delete">删除</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<tr>
				<td colspan="7" class="t_c"><span class="no-records">暂无数据</span></td>
			</tr>
		</c:if>
	</tbody>
</table>
</div>
<c:if test="${!empty list}">
	<gd:Pager />
	<div class="bot_fun" style="width:300px;left:315px;"> 
		<c:if test='${gdf:judgeRoleMenu(roleMenuList, "批量删除") }'> 
			<a class="btn" id="batch_delete" href="file/batchlogicdelete.do">批量删除</a>
		</c:if>
		<c:if test='${gdf:judgeRoleMenu(roleMenuList, "批量可见用户") }'> 
			<a class="btn ml5" id="batch_file_user" href="file/batchfileuser.do">可见用户</a>
		</c:if>
	</div> 
</c:if>
<script type="text/javascript">
	$(function(){
		 $('.OptionTable').flexigrid();
		$("[rel='lightbox']").picbox();	
	});
</script>