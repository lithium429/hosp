<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<script type="text/javascript" src="static/js/flexigrid-1.1/js/flexigrid.js"></script> 
<div class="datalistbox" style="top:63px;">
	<table class="OptionTable" id="tableSort">
	    <thead>
	    	<tr>
		        <th class="check w3per">
		            <input type="checkbox" id="check_all" class="inp_analog" /><span class="icon ico-checkbox"></span>
		        </th>
		        <th class="serial w5per">序号</th>
   				<th class="w15per">类型</th>
   				<th class="w50per">内容</th>
		        <th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
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
		            		<c:when test="${item.type==1 }">普通</c:when>
		            		<c:when test="${item.type==2 }">会议提醒</c:when>
		            	</c:choose>
		            </td>
		            <td>
		            	${item.content}
		            </td>
					<td  class="operations">
					<c:if test="${gdf:judgeRoleMenu(roleMenuList,'修改') }">
						<a href="smsTpl/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
					<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') }">
						<a href="smsTpl/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;</c:if>
					<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="smsTpl/view.do?id=${item.id}" class="view">查看</a></c:if>
					</td>
				</tr>            
			</c:forEach>
         	<c:if test="${empty list}">
				<tr>
		        	<td colspan="5" class="t_c">
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
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量删除') }">
		<a class="btn" id="batch_delete" href="smsTpl/batchdelete.do">批量删除</a></c:if>
	</div>
</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>