<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="w20per">部门</th>
						<td class="">
							${model.dept_name}
						</td>
					</tr>
					<tr>
						<th>日期</th>
						<td>
							${model.year}年${model.month}月${model.day}日，星期${gdf:getDayOfWeekForText(model.year, model.month, model.day)}
						</td>
					</tr>
					<tr>
						<th>时间段</th>
						<td>
							<fmt:formatDate value="${model.start_time}" pattern="HH:mm" />-<fmt:formatDate value="${model.end_time}" pattern="HH:mm" />
						</td>
					</tr>
					<tr>
						<th>值班人员</th>
						<td>
							<c:forEach var="item" items="${model.users}" varStatus="vs">
								<span class="mr5">${item.user_name}（${item.user_mobile}）</span>
							</c:forEach>
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