<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="w15per">标题</th>
						<td class="" colspan="3">
							${model.title}
						</td>
					</tr>
					<tr>
						<th class="w15per vtop">附件</th>
						<td class="" colspan="3">
							<c:if test="${!empty  model.files}">
							<div id="file_container" class="dib main_inpt">
								 <c:if test="${model.files != null && !model.files.isEmpty()}">
								 	<c:forEach items="${model.files}" var="item" varStatus="vs">
										<span id="file_item_${vs.index}" class="user_child file_item" >
											<a href="care/download?id=${item.id }" target="_blank">${item.name}</a>
							            </span>
									</c:forEach>
								 </c:if>
							</div>
							</c:if>
						</td>
					</tr>
					<tr>
						<th>来源</th>
						<td class="w35per">
							${model.source}
						</td>
						<th class="w15per">浏览次数</th>
						<td>
							${model.browse_count}
						</td>
					</tr>
					<tr>
						<th>作者</th>
						<td>
							${model.author}
						</td>
						<th>分类</th>
						<td>
							${model.type_name}
						</td>
					</tr>
					<tr>
						<th>发布人</th>
						<td>
							${model.creator_name}
						</td>
						<th>发布时间</th>
						<td>
							<fmt:formatDate value="${model.create_time}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
					</tr>
					<tr>
						<th class="vtop">内容</th>
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