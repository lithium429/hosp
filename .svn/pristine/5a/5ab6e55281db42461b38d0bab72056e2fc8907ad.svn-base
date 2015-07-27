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
						<td colspan="3">
							${model.name}
						</td>
					</tr>
					<tr>
						<th class="w80">图书类型</th>
						<td class="w200">${model.type_name }</td>
						<th class="w80">作者</th>
						<td>${model.author }</td>
					</tr>
					<tr>
						<th>购买日期</th>
						<td><fmt:formatDate value="${model.buy_time}" pattern="yyyy-MM-dd" /></td>
						<th>出版日期</th>
						<td><fmt:formatDate value="${model.publish_time}" pattern="yyyy-MM-dd" /></td>
					</tr>
					<tr>
						<th class="">一维码编号</th>
						<td colspan="3">
							${model.code}
						</td>
					</tr>
					<tr>
						<th class="vtop">备注</th>
						<td colspan="3">
							${model.remark}
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