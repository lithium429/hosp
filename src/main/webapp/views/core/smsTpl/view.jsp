<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="w15per">模板类型</th>
						<td class="">
							<c:choose>
			            		<c:when test="${model.type==1 }">普通</c:when>
			            		<c:when test="${model.type==2 }">会议提醒</c:when>
			            	</c:choose>
						</td>
					</tr>
					<tr>
						<th class="vtop">内容</th>
						<td>
							${model.content}
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