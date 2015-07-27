<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="w15per">请假人：</th>
						<td class="w35per">
							${model.staff_name}(${model.staff_code })
						</td>
						<th class="w15per">请假类型：</th>
						<td class="">
							<c:choose>
			            		<c:when test="${model.type==1 }">病假</c:when>
			            		<c:when test="${model.type==2 }">事假</c:when>
			            		<c:when test="${model.type==3 }">年假</c:when>
			            		<c:when test="${model.type==4 }">其他</c:when>
			            	</c:choose>
						</td>
					</tr>
					<tr>
						<th class="">审批人</th>
						<td colspan="3">
							${model.verify_user_name}
						</td>
					</tr>
					<tr>
						<th class="">请假原因</th>
						<td colspan="3">
							${model.reason}
						</td>
					</tr>
					<tr>
						<th>开始时间：</th>
						<td>
							<fmt:formatDate value="${model.start_time}" pattern="yyyy-MM-dd HH:mm" />
						</td>
						<th>结束时间：</th>
						<td>
							<fmt:formatDate value="${model.end_time}" pattern="yyyy-MM-dd HH:mm" />
						</td>
					</tr>
					<tr>
						<th class="">提醒审批人</th>
						<td colspan="3">
							<c:choose>
			            		<c:when test="${model.is_notify }">是</c:when>
			            		<c:when test="${!model.is_notify }">否</c:when>
			            	</c:choose>
						</td>
					</tr>
					<c:if test="${model.verify_state!=1 }">
					<tr>
						<th>审批时间</th>
						<td colspan="3">
							<fmt:formatDate value="${model.verify_time}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
					</tr>
					</c:if>
					<c:if test="${model.verify_state==3 }">
					<tr>
						<th class="vtop">理由</th>
						<td colspan="3">
							${model.verify_content}
						</td>
					</tr>
					</c:if>
				</tbody>
			</table>      
	    </div>
	    <div class="btn_area">
	        <span class="btn btn_base"><input type="button" id="btn_pclose" value="关闭"></span>
	    </div>
	</div>
</gd:PopLayout> 