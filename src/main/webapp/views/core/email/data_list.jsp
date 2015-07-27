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
		        <c:choose>
					<c:when test="${type==0}">
					<th class="w8per">发件人</th>	
					</c:when>
					<c:otherwise>
					<th class=w8per>收件人</th>		
					</c:otherwise>
				</c:choose>	
   				<th class="w50per">主题</th>
   				<th class="w8per">时间</th>
   				<th class="w12per">是否有附件</th>
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
						<c:when test="${type==0}">
							${item.sender_name}
						</c:when>
						<c:when test="${!empty item.getUserNames()}">
							${item.getUserNames()}
						</c:when>
						<c:otherwise>	
							<span><无收件人></span>
						</c:otherwise>
					</c:choose>
					</td>		
		            <td>
		            <c:choose>
		            	<c:when test="${!empty item.subject}">
							<a href="email/view.do?id=${item.id}&type=${type}" class="view"><c:if test="${type==0 }"><span class="icon ${item.is_read?'ico_oldmail':'ico_newmail' }"></span></c:if> ${item.subject}</a>
						</c:when>
						<c:otherwise>	
							(无主题)
						</c:otherwise>
					</c:choose>
		            </td>
		            <td>
		            	${item.judge()}
		            </td>
		            <td>
		            	<c:choose>
		            		<c:when test="${item.is_file }">是</c:when>
		            		<c:when test="${!item.is_file }">否</c:when>
		            	</c:choose>
		            </td>
					<td  class="operations">
					<c:if test="${type==0 && gdf:judgeRoleMenu(roleMenuList,'回复')}">
						<a href="email/reply.do?id=${item.id}&type=${type}" class="reply">回复</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'转发') }">
						<a href="email/forward.do?id=${item.id}&type=${type}" class="forward">转发</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') }">
						<a href="email/${type>1?'delete':'delete_logic' }.do?id=${item.id}&type=${type}" class="delete">删除</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="email/view.do?id=${item.id}&type=${type}" class="view">查看</a></c:if>
					</td>
				</tr>            
			</c:forEach>
         	<c:if test="${empty list}">
				<tr>
		        	<td colspan="7" class="t_c">
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
		
		<c:if test="${type==0 && gdf:judgeRoleMenu(roleMenuList,'标记已读')}">
			<a class="btn" id="read" href="email/read.do?type=${type}">标记已读</a> </c:if>
			<c:if test="${type<2 && gdf:judgeRoleMenu(roleMenuList,'批量删除') }">
			<a class="btn" id="batch_delete" href="email/batchdelete_logic.do?type=${type}">批量删除</a></c:if>
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'彻底删除') }">
			<a class="btn" id="batch_delete1" href="email/batchdelete.do?type=${type}">彻底删除</a></c:if>
	</div>
</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>