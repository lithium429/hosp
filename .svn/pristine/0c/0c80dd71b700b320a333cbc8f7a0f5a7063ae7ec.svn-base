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
   				<th class="w10per">员工</th>
   				<th class="w12per">合同编号</th>
   				<th class="w15per">合同类型</th>
   				<th class="w10per">生效日期</th>
   				<th class="w10per">终止日期</th>
   				<th class="w10per">解除日期</th>
   				<th class="w8per">合同状态</th>
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
		            	${item.name}
		            </td>
		            <td>
		            	${item.code}
		            </td>
		            <td>
		            	${item.type_name}
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.valid_date}" pattern="yyyy-MM-dd" />
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.end_date}" pattern="yyyy-MM-dd" />
		            </td>
		            <td>
		            	<c:choose>
		            		<c:when test="${empty item.relieve_date }">--</c:when>
		            		<c:otherwise>
			            		<fmt:formatDate value="${item.relieve_date}" pattern="yyyy-MM-dd" />
			            	</c:otherwise>
		            	</c:choose>
		            </td>
		            <td>
		            	${item.gainState()}
		            </td>
					<td  class="operations">
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'修改') }">
						<a href="staffContract/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') }">
						<a href="staffContract/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="staffContract/view.do?id=${item.id}" class="view">查看</a></c:if>
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
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量删除') }">
			<a class="btn" id="batch_delete" href="staffContract/batchdelete.do">批量删除</a></c:if>
		</div>
	</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>