<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="">会议主题</th>
						<td class="" colspan="3"> 
							${model.subject}
						</td>
					</tr>
					<tr>
						<th>会议出席人</th>
						<td colspan="3">
							${model.getUserNames()}
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
											<a href="meeting/download.do?id=${item.id }" target="_blank"  >${item.name}</a>
							            </span>
									</c:forEach>
								 </c:if>
							</div>
							</c:if>
						</td>
					</tr>
					<tr>
						<th class="w16per">会议主持人</th>
						<td class="w35per">
							${model.holder}
						</td>
						<th class="w16per">会议室</th>
						<td >
							${model.room_name}
						</td>
					</tr>
					<tr>
						<th>会议开始时间</th>
						<td >
							<fmt:formatDate value="${model.begin_time}" pattern="yyyy-MM-dd HH:mm" />
						</td>
						<th>会议结束时间</th>
						<td >
							<fmt:formatDate value="${model.end_time}" pattern="yyyy-MM-dd HH:mm" />
						</td>
					</tr>
					<tr>
						<th>是否发送事务提醒</th>
						<td>
							${model.is_send_umsg?"是":"否" }
						</td>
						<th>是否发送短信提醒</th>
						<td>
							${model.is_send_smsg?"是":"否" }
						</td>
					</tr>
					<tr>
						<th>会议设置</th>
						<td colspan="3">
							提前${model.remind_time}小时提醒
						</td>
					</tr>
					<tr>
						<th class="vtop">会议内容</th>
						<td colspan="3">
							${model.content}
						</td>
					</tr>
					<c:if test="${type==2 }">
					<tr>
						<th>申请人</th>
						<td>
							${model.creator_real_name }
						</td>
						<th>申请时间</th>
						<td>
							<fmt:formatDate value="${model.create_time}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
					</tr>
					</c:if>
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