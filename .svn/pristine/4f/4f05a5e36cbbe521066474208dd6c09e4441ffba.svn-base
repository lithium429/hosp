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
   				<th class="w15per">标题</th>
   				<th class="w15per">主题</th>
   				<th class="w10per">写信人</th>
   				<th class="w10per">信件类型</th>
   				<th class="w10per">处理情况</th>
   				<th class="w15per">提交时间</th>
		        <th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
            	<tr >
					<td class="check w3per">
	                	<input type="checkbox" name="id" key=${item.state } class="inp_analog batch" value="${item.id}" /><span
		                    class="icon ico-checkbox"></span>
		            </td>
		            <td class="serial">
		                ${vs.count+pageInfo.startIndex}
		            </td>
		            <td>
		            	${item.title}
		            </td>
		            <td>
		            	${item.topic_name}
		            </td>
		            <td>
		            	${item.user_name}
		            </td>
		            <td>
			            <c:choose>
			            	<c:when test="${item.type==1 }">申诉</c:when>
			            	<c:when test="${item.type==2 }">求决</c:when>
			            	<c:when test="${item.type==3 }">举报投诉</c:when>
			            	<c:when test="${item.type==4 }">反映建议</c:when>
			            	<c:when test="${item.type==5 }">其它咨询</c:when>
			            </c:choose>
		            </td>
		            <td>
		            	 <c:choose>
			            	<c:when test="${item.state==1 }">未处理</c:when>
			            	<c:when test="${item.state==2 }">已处理</c:when>
			            </c:choose>
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm:ss" />
		            </td>
					<td  class="operations">
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'修改') && item.state==1}">
						<a href="advice/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'处理') && item.state==1 }">
						<a class="btn haddle"  href="advice/haddle.do?id=${item.id }">处理</a></c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'公开') && !item.is_open }">
						<a class="btn gk change"  href="advice/change.do?id=${item.id }&is_open=1">公开</a></c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'不公开') && item.is_open }">
						<a class="btn change" href="advice/change.do?id=${item.id }&is_open=0">不公开</a></c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') }">
						<a href="advice/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="advice/view.do?id=${item.id}" class="view">查看</a></c:if>
					</td>
				</tr>            
			</c:forEach>
         	<c:if test="${empty list}">
				<tr>
		        	<td colspan="9" class="t_c">
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
			<a class="btn" id="batch_delete" href="advice/batchdelete.do">批量删除</a></c:if>
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'处理') }">
			<a class="btn" id="batch_haddle" href="advice/haddle.do">批量处理</a></c:if>
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'公开') }">
			<a class="btn gk" id="batch_change" href="advice/batchchange.do?is_open=1">公开</a></c:if>
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'不公开') }">
			<a class="btn" id="batch_change1" href="advice/batchchange.do?is_open=0">不公开</a></c:if>
		</div>
	</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>