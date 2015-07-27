<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th>标题</th>
						<td colspan="3">
							${model.title}
						</td>
					</tr>
					<tr>
						<th class="w15per">系统用户</th>
						<td class="w35per">
							${model.user_name}
						</td>
						<th class="w15per">主题</th>
						<td class="">
							${model.topic_name}
						</td>
					</tr>
					<tr>
						<th>是否匿名</th>
						<td>
							<c:choose>
								<c:when test="${model.is_anonymous }">是</c:when>
								<c:when test="${!model.is_anonymous }">否</c:when>
							</c:choose>
						</td>
						<th>紧急程度</th>
						<td>
							<c:choose>
								<c:when test="${model.urgency==1 }">一般</c:when>
								<c:when test="${model.urgency==2 }">重要</c:when>
								<c:when test="${model.urgency==3 }">紧急</c:when>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>复杂度</th>
						<td>
							<c:choose>
								<c:when test="${model.complexity==1 }">一般</c:when>
								<c:when test="${model.complexity==2 }">复杂</c:when>
							</c:choose>
						</td>
						<th>信件类型</th>
						<td>
							<c:choose>
								<c:when test="${model.type==1 }">申诉</c:when>
								<c:when test="${model.type==2 }">求决</c:when>
								<c:when test="${model.type==3 }">举报投诉</c:when>
								<c:when test="${model.type==4 }">反映建议</c:when>
								<c:when test="${model.type==5 }">其它咨询</c:when>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>内容</th>
						<td colspan="3">
							${model.content}
						</td>
					</tr>
					<c:if test="${model.state==2 }">
					<tr>
						<th>处理人</th>
						<td>
							${model.haddle_name}
						</td>
						<th>处理时间</th>
						<td>
							<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${model.haddle_time}"  />
						</td>
					</tr>
					<tr>
						<th>处理内容</th>
						<td colspan="3">
							${model.haddle_content}
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