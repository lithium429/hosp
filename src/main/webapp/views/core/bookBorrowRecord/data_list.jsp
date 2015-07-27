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
   				<th class="w12per">一维编码</th>
   				<th class="w15per">类型</th>
   				<c:if test="${type==1}">
   				<th class="w8per">借书人</th></c:if>
   				<th class="w12per">借书日期</th>
   				<th class="w12per">预期还书日期</th>
   				<th class="w10per">领取状态</th>
		        <th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
            	<tr >
					<td class="check w3per">
	                	<input type="checkbox" name="id" key=${item.borrow_state } key_id="${item.book_id }"  class="inp_analog batch" value="${item.id}" /><span
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
		            	<fmt:formatDate value="${item.borrow_time}" pattern="yyyy-MM-dd" />	
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.return_time}" pattern="yyyy-MM-dd" />	
		            </td>
		            <td>
		            	<c:choose>
		            		<c:when test="${item.borrow_state==1 }">未领取</c:when>
		            		<c:when test="${item.borrow_state==2 }">已领取</c:when>
		            		<c:when test="${item.borrow_state==3 }">已归还</c:when>
		            	</c:choose>
		            </td>
					<td  class="operations">
					<c:if test="${type==1 }">
					<c:if test="${item.borrow_state==1 && gdf:judgeRoleMenu(roleMenuList,'领取')}">
						<a href="bookBorrowRecord/change.do?id=${item.id}&book_id=${item.book_id }&state=2" class="change">领取</a>&nbsp;</c:if>
					<c:if test="${item.borrow_state==2 && gdf:judgeRoleMenu(roleMenuList,'归还')}">
						<a href="bookBorrowRecord/change.do?id=${item.id}&book_id=${item.book_id }&state=3" class="change returnBack">归还</a>&nbsp;</c:if></c:if>
					<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="bookBorrowRecord/view.do?id=${item.id}&state=${item.verify_state}" class="view">查看</a></c:if>
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
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量领取') }">
			<a class="btn" id="batch_change" href="bookBorrowRecord/change.do?state=2">领取</a></c:if>
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量归还') }">
			<a class="btn returnBack" id="batch_change1" href="bookBorrowRecord/change.do?state=3">归还</a></c:if></c:if>
		</div>
	</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>