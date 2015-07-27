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
   				<th class="w20per">请假原因</th>
   				<th class="w10per">${type_key==0?'审批人员':'请假人员' }</th>
   				<th class="w12per">开始时间</th>
   				<th class="w12per">结束时间</th>
   				<th class="w8per">审批状态</th>
		        <th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
            	<tr >
					<td class="check w3per">
	                	<input type="checkbox" name="id" key=${item.verify_state } class="inp_analog batch" value="${item.id}" /><span
		                    class="icon ico-checkbox"></span>
		            </td>
		            <td class="serial">
		                ${vs.count+pageInfo.startIndex}
		            </td>
		            <td>
		            	<c:choose>
		            		<c:when test="${item.type==1 }">病假</c:when>
		            		<c:when test="${item.type==2 }">事假</c:when>
		            		<c:when test="${item.type==3 }">年假</c:when>
		            		<c:when test="${item.type==4 }">其他</c:when>
		            	</c:choose>
		            </td>
		            <td>
		            	${item.reason}
		            </td>
		            <td>
		            	${type_key==0?item.verify_user_name:item.staff_name}
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.start_time}" pattern="yyyy-MM-dd HH:mm" />
		            </td>
		            <td>
		         		 <fmt:formatDate value="${item.end_time}" pattern="yyyy-MM-dd HH:mm" />
		            </td>
		            <td>
		            	<c:choose>
		            		<c:when test="${item.verify_state==1 }">待审批</c:when>
		            		<c:when test="${item.verify_state==2 }">审批通过</c:when>
		            		<c:when test="${item.verify_state==3 }">审批不通过</c:when>
		            	</c:choose>
		            </td>
					<td  class="operations">
						<c:if test="${type_key==1 && item.verify_state==1 }">
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'通过') }">
						<a href="leave/change.do?id=${item.id}&state=2" class="change1">通过</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'不通过') }">
						<a href="leave/check.do?id=${item.id}&state=3" class="change2">不通过</a>&nbsp;</c:if></c:if>

						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'修改') && item.verify_state==1 && type_key==0}">
						<a href="leave/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') && (item.verify_state==1 || type_key==1)&& type_key==0}">
						<a href="leave/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="leave/view.do?id=${item.id}" class="view">查看</a></c:if>
					</td>
				</tr>            
			</c:forEach>
         	<c:if test="${empty list}">
				<tr>
		        	<td colspan="10" class="t_c">
		                <span class="no-records">暂无数据</span>
		            </td>
		        </tr>
        	</c:if>
    	</tbody>
    </table>
</div>
    <c:if test="${!empty list}">
		<gd:Pager />
		
		<div class="bot_fun" style="width:300px;">
		<c:if test="${type_key==1}">
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量通过') }">
			<a class="btn" id="batch_change1" href="leave/change.do?state=2">通过</a></c:if>
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量不通过') }">
			<a class="btn" id="batch_change2" href="leave/check.do?state=3">不通过</a></c:if></c:if>
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量删除')&& type_key==0 }">
			<a class="btn" id="batch_delete${type_key==0?'1':'' }" href="leave/batchdelete.do">批量删除</a></c:if>
		</div>
	</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>