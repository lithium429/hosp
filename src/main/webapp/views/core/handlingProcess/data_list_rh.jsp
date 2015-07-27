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
   				<th class="w12per">编号</th>
   				<th class="w10per">督办事宜</th>
   				<th class="w12per">创建时间</th>
   				<th class="w10per">创建人</th>
   				<th class="w10per">当前责任人</th>
   				<th class="w12per">办结日期</th>
   				<th class="w8per">状态</th>
		        <th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
            	<tr >
					<td class="check w3per">
	                	<input type="checkbox" name="id"  class="inp_analog batch" value="${item.id}" /><span
		                    class="icon ico-checkbox"></span>
		            </td>
		            <td class="serial">
		                ${vs.count+pageInfo.startIndex}
		            </td>
		            <td>
		            	<a href="handlingProcess/view.do?id=${item.id}" class="view">${item.code}</a>
		            </td>
		            <td>
		            	<a href="handlingProcess/view.do?id=${item.id}" class="view">${item.title}</a>
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd" />	
		            </td>
		            <td>
		            	${item.creator_name}
		            </td>
		            <td>
		            	${item.user_name}
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.end_date}" pattern="yyyy-MM-dd" />	
		            </td>
		            <td>
	            		<c:choose>
		            		<c:when test="${item.state==1 }">草稿</c:when>
		            		<c:when test="${item.state==2 }">流转中</c:when>
		            		<c:when test="${item.state==3 }">已关闭</c:when>
		            	</c:choose>
		            </td>
					<td  class="operations">
					<c:if test="${gdf:judgeRoleMenu(roleMenuList,'处理') }">
						<a href="handlingProcess/haddle.do?id=${item.id}" class="haddle">处理</a>&nbsp;</c:if>
					<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="handlingProcess/view.do?id=${item.id}" class="view">查看</a></c:if>
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
			<!-- <div class="bot_fun" style="width:300px;">
				<a class="btn" id="batch_delete1" href="handlingProcess/batchdelete.do">批量删除</a>
			</div> -->
		</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>