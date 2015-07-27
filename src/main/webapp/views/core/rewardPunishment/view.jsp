<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="w15per">奖惩属性：</th>
						<td class="w35per">
							<c:choose>
								<c:when test="${model.type==1 }">奖励</c:when>
								<c:otherwise>惩罚</c:otherwise>
							</c:choose>
						</td>
						<th class="w15per">人员：</th>
						<td class="">
							${model.name}(${model.user_code })
						</td>
					</tr>
					<tr>
						<th>奖惩名目：</th>
						<td>
							${model.item_name}
						</td>
						<th>奖惩日期：</th>
						<td>
							<fmt:formatDate value="${model.rp_date}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<th class="">授予单位</th>
						<td colspan="3">
							${model.unit}
						</td>
					</tr>
					<tr>
						<th class="">奖惩金额</th>
						<td colspan="3">
							${model.amount}
						</td>
					</tr>
					<tr>
						<th>附件</th>
						<td colspan="3">
							<c:if test="${!empty  model.files}">
							<div id="file_container" class="dib main_inpt">
								 <c:if test="${model.files != null && !model.files.isEmpty()}">
								 	<c:forEach items="${model.files}" var="item" varStatus="vs">
										<span id="file_item_${vs.index}" class="user_child file_item" >
											<a href="rewardPunishment/download.do?id=${item.id }" target="_blank"  >${item.name}</a>
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