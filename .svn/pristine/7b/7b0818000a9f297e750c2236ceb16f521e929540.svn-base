<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<script type="text/javascript" src="static/js/flexigrid-1.1/js/flexigrid.js"></script> 
<div class="datalistbox" style="top:80px;">
	<table class=" OptionTable" id="tableSort">
	<thead>
		<tr>
			<th class="check w3per">
				<input type="checkbox" id="check_all" class="inp_analog" />
				<span class="icon ico-checkbox"></span>
			</th>
			<th class="serial w5per">序号</th>
			<th class="w30per">文件</th>
			<th class="w20per">文件类型</th>
			<th class="w20per">创建时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="item" varStatus="vs">
			<tr>
				<td class="check w3per">
					<input type="checkbox" name="id" class="inp_analog batch" value="${item.id}" key="recover" />
					<span class="icon ico-checkbox"></span>
				</td>
				<td class="serial">${vs.count+pageInfo.startIndex}</td> 
				<td>${item.name}</td>
				<td>
					<c:choose>
						<c:when test="${item.type == 1}">文档</c:when>
						<c:when test="${item.type == 2}">图片</c:when>
						<c:when test="${item.type == 3}">其它</c:when>
					</c:choose>
				</td>
				<td>
					<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> 
				<td>
					<c:if test='${gdf:judgeRoleMenu(roleMenuList, "下载") }'> 
						<a href="file/download.do?id=${item.id}" class="download" target="_blank">下载</a>
					</c:if>
					<c:if test='${gdf:judgeRoleMenu(roleMenuList, "恢复") }'> 
						<a href="file/recover.do?id=${item.id}" class="recover">恢复</a>
					</c:if>
					<c:if test='${gdf:judgeRoleMenu(roleMenuList, "删除") }'>   
						<a href="file/delete.do?id=${item.id}" class="delete">删除</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<tr>
				<td colspan="6" class="t_c"><span class="no-records">暂无数据</span></td>
			</tr>
		</c:if>
	</tbody>
</table>
</div>
<c:if test="${!empty list}">
	<gd:Pager /> 
</c:if> 
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>