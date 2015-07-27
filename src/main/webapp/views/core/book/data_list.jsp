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
   				<th class="w15per">作者</th>
   				<th class="w15per">类型</th>
   				<th class="w10per">是否借出</th>
   				<th class="w8per">状态</th>
		        <th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
            	<tr >
					<td class="check w3per">
	                	<input type="checkbox" name="id" key="${item.is_borrow?1:0 }" class="inp_analog batch" value="${item.id}" /><span
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
		            	${item.author}
		            </td>
		            <td>
		            	${item.type_name}
		            </td>
		            <td>
		            	<span class="${item.is_borrow?'c_red':''}">${item.is_borrow?"借出":"未借"}</span>	
		            </td>
		            <td>
		            	<span class="${item.state==2?'c_red':''}"><c:choose>
		            		<c:when test="${item.state==1 }">正常</c:when>
		            		<c:when test="${item.state==2 }">报废</c:when>
		            	</c:choose></span>	
		            </td>
					<td  class="operations">
					<c:if test="${item.state==1 && !item.is_borrow && gdf:judgeRoleMenu(roleMenuList,'报废') }">
						<a href="book/scrap.do?id=${item.id}" class="scrap">报废</a>&nbsp;</c:if>
					<c:if test="${item.state==1 && gdf:judgeRoleMenu(roleMenuList,'修改')}">
						<a href="book/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
					<c:if test="${!item.is_borrow && gdf:judgeRoleMenu(roleMenuList,'删除')}"><a href="book/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;</c:if>		
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="book/view.do?id=${item.id}" class="view">查看</a></c:if>
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
			<a class="btn" id="batch_delete1" href="book/batchdelete.do">批量删除</a></c:if>
		</div>
	</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>