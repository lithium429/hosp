<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <table class="view_data wc100"> 
	    	<tbody> 
				<tr>
					<th class="w80">用户名：</td>
					<td>${model.name}</td>
					<th class="w20per">部门科室：</td>
					<td>${model.dept_name}</td>
				</tr> 
				<tr>
					<th class="">姓名：</td>
					<td>${model.real_name}</td>
					<th class="">所属角色：</td>
					<td>
						<c:forEach items="${model.roles}" var="temp" varStatus="vs1">
							<c:if test="${vs1.index!=0 }">,</c:if>${temp.role_name }
						</c:forEach>
					</td>
				</tr> 
				<tr>
					<th class="">手机：</td>
					<td>${model.mobile}</td>
					<th class="">邮箱：</td>
					<td>${model.email}</td>
				</tr> 
				<tr>
					<th class="">性别：</td>
					<td>
						<c:choose>
							<c:when test="${model.sex==1 }">男</c:when>
							<c:when test="${model.sex==2 }">女</c:when>
						</c:choose>
					</td>
					<th class="">状态：</td>
					<td>
						<c:choose>
							<c:when test="${model.state==1 }">正常</c:when>
							<c:when test="${model.state==2 }">冻结</c:when>
						</c:choose>
					</td>
				</tr> 
				<tr>
					<th class="">QQ：</td>
					<td>${model.qq}</td>
					<th class="">短信外发权限：</td>
					<td>
						<c:choose>
							<c:when test="${model.is_allowso }">有</c:when>
							<c:when test="${!model.is_allowso }">无</c:when>
						</c:choose>
					</td>
				</tr>
				<tr>
					<th class="">创建通讯录：</td>
					<td colspan="3">
						<c:choose>
							<c:when test="${model.has_address }">是</c:when>
							<c:when test="${!model.has_address }">否</c:when>
						</c:choose>
					</td>
				</tr>
				<tr>
					<th class="vtop">备注：</td>
					<td colspan="3">${model.remark}</td>
				</tr> 
			</tbody>
		</table>
	    <div class="btn_area">
	        <span class="btn btn_base"><input type="button" id="btn_pclose" value="关闭"></span>
	    </div>
	</div>
</gd:PopLayout> 