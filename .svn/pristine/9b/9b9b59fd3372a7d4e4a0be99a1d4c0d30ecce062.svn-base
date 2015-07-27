<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<div class="datalistbox" style="top:80px;">
	<table class="OptionTable" id="tableSort">
	    <thead>
	    	<tr>
		        <th class="check w3per">
		            <input type="checkbox" id="check_all" class="inp_analog" /><span class="icon ico-checkbox"></span>
		        </th>
		        <th class="serial w5per">序号</th>
   				<th class="w20per">名称</th>
   				<th class="w20per">版主</th> 
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
		                ${vs.count}
		            </td>
		            <td>
		            	<c:if test="${item.layer == 2}">
		            		<span class="ml10">&nbsp;</span>
		            	</c:if>
		            	${item.name}
		            </td>
		            <td>
		            	${item.gainUserRealNamesForText()}
		            </td> 
					<td  class="operations">
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'修改') }">
						<a href="forumPlate/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') }">
						<a href="forumPlate/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'添加子版块') && item.layer == 1}">
							<a href="forumPlate/add.do?layer=2&parent_id=${item.id}" id="btn_add">添加子版块</a>
						</c:if>
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
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>