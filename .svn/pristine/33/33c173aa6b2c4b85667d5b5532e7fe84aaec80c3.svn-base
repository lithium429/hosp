<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<script type="text/javascript" src="static/js/flexigrid-1.1/js/flexigrid.js"></script> 
<div class="datalistbox" style="top:80px;">
	<table class="OptionTable" id="tableSort">
	    <thead>
	    	<tr>
		        <th class="check w3per">
		            <input type="checkbox" id="check_all" class="inp_analog" /><span class="icon ico-checkbox"></span>
		        </th>
		        <th class="serial w5per">序号</th>
   				<th class="w15per">书籍名称</th>
   				<th class="w15per">一维编码</th>
   				<th class="w10per">类型</th>
   				<c:if test="${type==1}">
   				<th class="w8per">借书人</th></c:if>
   				<th class="w12per">借书日期</th>
   				<th class="w12per">预期还书日期</th>
   				<th class="w10per">审核状态</th>
		        <th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
            	<tr >
					<td class="check w3per">
	                	<input type="checkbox" name="id" key=${item.verify_state } key_id="${item.book_id }" class="inp_analog batch" value="${item.id}" /><span
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
   				<c:if test="${type==1}">
		            <td>
		            	${item.creator_name}
		            </td></c:if>
		            <td>
		            	<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd" />	
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.return_time}" pattern="yyyy-MM-dd" />	
		            </td>
		            <td>
		            	<c:choose>
		            		<c:when test="${item.verify_state==1 }">待审核</c:when>
		            		<c:when test="${item.verify_state==2 }">通过</c:when>
		            		<c:when test="${item.verify_state==3 }">不通过</c:when>
		            	</c:choose>
		            </td>
					<td  class="operations">
					<c:if test="${type==1 && item.verify_state==1 }">
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'通过') }">
						<a href="bookBorrow/change.do?id=${item.id}&book_id=${item.book_id }&state=2" class="change1">通过</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'不通过') }">
						<a href="bookBorrow/check.do?id=${item.id}&book_id=${item.book_id }&state=3" class="change2">不通过</a>&nbsp;</c:if></c:if>
					<c:if test="${type==0 }">
					<c:if test="${item.verify_state==1 && gdf:judgeRoleMenu(roleMenuList,'修改')}">
						<a href="bookBorrow/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') }">
						<a href="bookBorrow/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;</c:if></c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="bookBorrow/view.do?id=${item.id}&state=${item.verify_state}&type=${type}" class="view">查看</a></c:if>
					</td>
				</tr>            
			</c:forEach>
         	<c:if test="${empty list}">
				<tr>
		        	<td colspan="${type==1?10:9 }" class="t_c">
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
			<c:if test="${type==1}">
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量通过') }">
			<a class="btn" id="batch_change1" href="bookBorrow/change.do?state=2">通过</a></c:if>
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量不通过') }">
			<a class="btn" id="batch_change2" href="bookBorrow/check.do?state=3">不通过</a></c:if></c:if>
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量删除') }">
			<a class="btn" id="batch_delete1" href="bookBorrow/batchdelete.do">批量删除</a></c:if>
		</div>
	</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>