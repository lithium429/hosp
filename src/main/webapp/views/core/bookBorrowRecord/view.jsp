<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap user_info_form">
		<div class="t_c photo_box">
			<h2>封面</h2>
			<div class="pic"><img id="img4" class="img4" width="118px" height="166px" src="<c:if test="${empty model.image_url}">images/emptyImage.jpg</c:if><c:if test="${!empty model.image_url}">${model.image_url}</c:if>"></div> 
		</div>
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="">书籍名称</th>
						<td >
							${model.name}
						</td>
						<th class="">一维码编号</th>
						<td >
							${model.code}
						</td>
					</tr>
					<tr>
						<th>借书日期</th>
						<td><fmt:formatDate value="${model.borrow_time}" pattern="yyyy-MM-dd" /></td>
						<th>预期还书日期</th>
						<td><fmt:formatDate value="${model.return_time}" pattern="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<th>借书人</th>
						<td>${model.creator_name }</td>
						<th>领取状态</th>
						<td>
							<c:choose>
			            		<c:when test="${model.borrow_state==1 }">未领取</c:when>
			            		<c:when test="${model.borrow_state==2 }">已领取</c:when>
			            		<c:when test="${model.borrow_state==3 }">已归还</c:when>
			            	</c:choose>
						</td>
					</tr>
					<c:if test="${model.verify_state!=1 }">
					<tr>
						<th>审核人</th>
						<td>
							${model.verify_user_name }
						</td>
						<th>审核时间</th>
						<td>
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