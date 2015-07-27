<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%> 
<div class="view_data">
	<table class="wc100">
		<tbody>
			<tr>
				<th class="w120">请假人：</th>
				<td>
					${model.user_name}
				</td>
			</tr>
			<tr>
				<th>请假类型：</th>
				<td>
					<c:choose>
	            		<c:when test="${model.type == 1}">病假</c:when>
	            		<c:when test="${model.type == 2}">事假</c:when>
	            		<c:when test="${model.type == 3}">年假</c:when>
	            		<c:when test="${model.type == 4}">其他</c:when>
	            	</c:choose>
				</td>
			</tr>
			<tr>
				<th>开始时间：</th>
				<td>
					<fmt:formatDate value="${model.start_time}" pattern="yyyy-MM-dd HH:mm" />
				</td>
			</tr>
			<tr>
				<th>结束时间：</th>
				<td>
					<fmt:formatDate value="${model.end_time}" pattern="yyyy-MM-dd HH:mm" />
				</td>
			</tr>
			<tr>
				<th>请假理由：</th>
				<td>
					${model.reason}
				</td>
			</tr>
		</tbody>
	</table>      
</div>
	   