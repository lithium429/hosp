<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="w15per">人员：</th>
						<td class="w35per">
							${model.name}(${model.user_code })
						</td>
						<th class="w15per">合同编号：</th>
						<td class="">
							${model.code}
						</td>
					</tr>
					<tr>
						<th>合同类型：</th>
						<td>
							${model.type_name}
						</td>
						<th>合同签订日期：</th>
						<td>
							<fmt:formatDate value="${model.sign_date}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<th>合同生效日期：</th>
						<td>
							<fmt:formatDate value="${model.valid_date}" pattern="yyyy-MM-dd" />
						</td>
						<th>合同终止日期：</th>
						<td>
							<fmt:formatDate value="${model.end_date}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<th>合同是否已解除：</th>
						<td>
						<c:choose>
							<c:when test="${model.state==4 }">是</c:when>
							<c:otherwise>否</c:otherwise>
						</c:choose>
						</td>
						<c:if test="${model.state==4 }">
						<th>合同解除日期：</th>
						<td>
							<fmt:formatDate value="${model.relieve_date}" pattern="yyyy-MM-dd" />
						</td>
						</c:if>
					</tr>
					<tr>
						<th>附件</th>
						<td colspan="3">
							<c:if test="${!empty  model.files}">
							<div id="file_container" class="dib main_inpt">
								 <c:if test="${model.files != null && !model.files.isEmpty()}">
								 	<c:forEach items="${model.files}" var="item" varStatus="vs">
										<span id="file_item_${vs.index}" class="user_child file_item" >
											<a href="staffContract/download?id=${item.id }" target="_blank">${item.name}</a>
							            </span>
									</c:forEach>
								 </c:if>
							</div>
							</c:if>
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