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
							${model.user_name}
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
						<th>开始时间：</th>
						<td>
							<fmt:formatDate value="${model.start_time}" pattern="yyyy-MM-dd HH:mm" />
						</td>
						<th>结束时间：</th>
						<td>
							<fmt:formatDate value="${model.end_time}" pattern="yyyy-MM-dd HH:mm" />
						</td>
					</tr>
				</tbody>
			</table>      
	    </div>
	    <div class="btn_area">
	        <span class="btn btn_base"><input type="button" id="btn_pclose" value="关闭"></span>
	    </div>
	</div>
</gd:PopLayout> 