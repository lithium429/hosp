<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<script type="text/javascript" src="static/js/flexigrid-1.1/js/flexigrid.js"></script> 
<div class="datalistbox" style="top:110px;">
	<table class="OptionTable" id="tableSort">
	    <thead>
	    	<tr>
		        <th class="check w3per">
		            <input type="checkbox" id="check_all" class="inp_analog" /><span class="icon ico-checkbox"></span>
		        </th>
		        <th class="serial w5per">序号</th>
				<th class="w10per">请假类型</th>
				<th class="w10per">申请人</th>
				<th class="w10per">申请时间</th>
				<th class="w10per">开始时间</th>
				<th class="w10per">结束时间</th>
				<th class="w10per">当前节点</th>
				<th class="w10per">任务创建时间</th>
				<th class="w10per">流程状态</th>
				<th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
				<c:set var="task" value="${item.task }" />
				<c:set var="pi" value="${item.processInstance}" />
            	<tr >
					<td class="check w3per">
	                	<input type="checkbox" name="id" class="inp_analog batch" value="${item.id}" /><span
		                    class="icon ico-checkbox"></span>
		            </td>
		            <td class="serial">
		                ${vs.count+pageInfo.startIndex}
		            </td>
		            <td>
		            	<c:choose>
		            		<c:when test="${ item.type == 1 }">病假</c:when>
		            		<c:when test="${ item.type == 2 }">事假</c:when>
		            		<c:when test="${ item.type == 3 }">年假</c:when>
		            		<c:when test="${ item.type == 4 }">其他</c:when>
		            	</c:choose>
		            </td>
		            <td>
		            	${item.user_name}
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm" />
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.start_time}" pattern="yyyy-MM-dd HH:mm" />
		            </td>
		            <td>
		         		<fmt:formatDate value="${item.end_time}" pattern="yyyy-MM-dd HH:mm" />
		            </td>
		            <td>
						<a class="trace" href="javascript:void(0);" pid="${pi.id}" pdid="${pi.processDefinitionId}" title="点击查看流程图">${task.name }</a>
					</td>
		            <td>
		            	<fmt:formatDate value="${task.createTime}" pattern="yyyy-MM-dd HH:mm" />
		            </td>
					<td>
						${pi.suspended ? "已挂起" : "正常" }
					</td>
					<td class="operations"> 
						<c:if test="${empty task.assignee }">
							<a class="claim" href="leaveInfo/claim/${task.id}.do">签收</a>
						</c:if>
						<c:if test="${!empty task.assignee}">
							<c:choose>
								<c:when test="${task.taskDefinitionKey == 'modifyApply'}">
									<a class="modify" href="leaveInfo/modify/${task.id}.do?leave_id=${item.id}&tkey=${task.taskDefinitionKey}">办理</a>
								</c:when>
								<c:otherwise>
									<a class="handle" href="leaveInfo/handle/${task.id}.do?leave_id=${item.id}&tkey=${task.taskDefinitionKey}">办理</a>
								</c:otherwise>
							</c:choose>
						</c:if>
					</td>
				</tr>            
			</c:forEach>
         	<c:if test="${empty list}">
				<tr>
		        	<td colspan="11" class="t_c">
		                <span class="no-records">暂无数据</span>
		            </td>
		        </tr>
        	</c:if>
    	</tbody>
    </table>
</div>
<c:if test="${!empty list}">
	<gd:Pager /> 
</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>