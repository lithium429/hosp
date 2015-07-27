<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="w80">督办事宜：</th>
						<td class="w260">
							${model.title}
						</td>
						<th class="w80">编号：</th>
						<td class="">
							${model.code}
						</td>
					</tr>
					<tr>
						<th class="">创建人：</th>
						<td class="">
							${model.creator_name}
						</td>
						<th class="">创建日期：</th>
						<td class="">
							<fmt:formatDate value="${model.create_time}" pattern="yyyy-MM-dd" />	
						</td>
					</tr>
					<tr>
						<th class="">责任人：</th>
						<td class="">
							${model.user_name}
						</td>
						<th class="">办结日期：</th>
						<td class="">
							<fmt:formatDate value="${model.end_date}" pattern="yyyy-MM-dd" />	
						</td>
					</tr>
					<tr>
						<th class="">状态：</th>
						<td class="">
							<c:choose>
			            		<c:when test="${model.state==1 }">草稿</c:when>
			            		<c:when test="${model.state==2 }">流转中</c:when>
			            		<c:when test="${model.state==3 }">已关闭</c:when>
			            	</c:choose>
						</td>
						<th class="">关闭日期：</th>
						<td class="">
							<fmt:formatDate value="${model.close_date}" pattern="yyyy-MM-dd" />	
						</td>
					</tr>
					<tr>
						<th class="vtop">事宜内容：</th>
						<td colspan="3">
							${model.content}
						</td>
					</tr>
					<tr>
						<th class="vtop">处理记录：</th>
						<td colspan="3" class="shfw_c">
							<table class="wc100 view_data">
								<thead>
									<tr>
										<th>处理人</th>
										<th>处理时间</th>
										<th>处理内容</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${model.records}" var="item" varStatus="vs">  
										<tr>
											<td>${item.user_name }</td>
											<td><fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd" /></td>
											<td>${item.content }</td>
										</tr>
									</c:forEach>
									<c:if test="${empty model.records}">
										<tr>
								        	<td colspan="3" class="t_c">
								                <span class="no-records">暂无数据</span>
								            </td>
								        </tr>
						        	</c:if>
								</tbody>
							</table>
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