<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="w60">标题</th>
						<td class="w260">
							${model.title}
						</td>
						<th class="w60">公示类型</th>
						<td>
							<c:choose>
			             		<c:when test="${model.type == 1}">
			             			院务公开栏
			             		</c:when>
			             		<c:when test="${model.type == 2}">
			             			党务公开栏
			             		</c:when>
			             		<c:when test="${model.type == 3}">
			             			奖惩公示栏
			             		</c:when>
			             		<c:when test="${model.type == 4}">
			             			其它
			             		</c:when>
			             	</c:choose>
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
											<a href="publicityColumn/download.do?id=${item.id }" target="_blank"  >${item.name}</a>
							            </span>
									</c:forEach>
								 </c:if>
							</div>
							</c:if>
						</td>
					</tr>
					<tr>
						<th>内容</th>
						<td colspan="3">
							<div style="word-break:break-all;width:780px;overflow:auto;">
								${model.content}
							</div>
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