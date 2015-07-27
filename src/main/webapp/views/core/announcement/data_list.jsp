<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<div class="datalistbox" style="top:110px;">
	<table class="OptionTable" id="tableSort">
	    <thead>
	    	<tr>
		        <th class="check w3per">
		            <input type="checkbox" id="check_all" class="inp_analog" /><span class="icon ico-checkbox"></span>
		        </th>
		        <th class="serial w5per">序号</th>
   				<th class="w8per">公告标题</th>
   				<th class="w8per">类型</th>
   				<th class="w20per">范围</th>
   				<th class="w12per">生效日期</th>
   				<th class="w12per">终止日期</th>
   				<th class="w12per">排序</th>
   				<th class="w5per">状态</th>
		        <th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
            	<tr >
					<td class="check w3per">
	                	<input type="checkbox" name="id" class="inp_analog batch" value="${item.id}" key="${item.judgeState()=='未发布'?'f':(item.judgeState()=='生效'?'s':'') }" /><span
		                    class="icon ico-checkbox" ></span>
		            </td>
		            <td class="serial">
		                ${vs.count+pageInfo.startIndex}
		            </td>
		            <td>
		            	<a href="announcement/view.do?id=${item.id}" class="view">${item.title}</a>
		            </td>
		            <td>
		            	${item.type_name}
		            </td>
		            <td>
		            	<c:choose>
		            		<c:when test="${item.is_show_all }">
		            		全院
		            		</c:when>
		            		<c:otherwise>
		            		${item.getDeptNames()}
		            		</c:otherwise>
		            	</c:choose>
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.valid_date}" pattern="yyyy-MM-dd HH:mm" />
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.end_date}" pattern="yyyy-MM-dd HH:mm" />
		            </td>
		            <td>
		            	<c:if test="${gdf:judgeRoleMenu(roleMenuList,'向上') && (vs.index!=0 || pageInfo.pageIndex!=1)}">
		            	<a href="announcement/move.do?sort=${item.sort}&is_up=true" class="move_up">向上</a>&nbsp;</c:if>
		            	<c:if test="${gdf:judgeRoleMenu(roleMenuList,'向下') && (pageInfo.pageCount!=pageInfo.pageIndex || vs.index!=list.size()-1) }">
		            	<a href="announcement/move.do?sort=${item.sort}&is_up=false" class="move_down">向下</a>&nbsp;</c:if>
		            	<c:if test="${gdf:judgeRoleMenu(roleMenuList,'置顶') && (vs.index!=0 || pageInfo.pageIndex!=1) }">
		            	<a href="announcement/move.do?sort=${item.sort}&is_up=true&toSort=${maxSort}" class="move_top">置顶</a></c:if>
		            </td>
		            <td>
		            	${item.judgeState()}
		            </td>
					<td  class="operations">
					<c:if test="${item.judgeState()=='未发布' && gdf:judgeRoleMenu(roleMenuList,'生效') }">
						<a href="announcement/change.do?id=${item.id}&is_stop=false" class="effect">生效</a>&nbsp;</c:if>
					<c:if test="${item.judgeState()=='生效' &&  gdf:judgeRoleMenu(roleMenuList,'终止') }">
						<a href="announcement/change.do?id=${item.id}&is_stop=true" class="stop">终止</a>&nbsp;</c:if>
					<c:if test="${gdf:judgeRoleMenu(roleMenuList,'修改') }">
						<a href="announcement/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
					<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') }">
						<a href="announcement/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;</c:if>
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
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量生效') }">
		<a class="btn" id="effect" href="announcement/change.do?is_stop=false">生效</a></c:if>
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量终止') }">
		<a class="btn" id="stop" href="announcement/change.do?is_stop=true">终止</a></c:if>
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量删除') }">
		<a class="btn" id="batch_delete" href="announcement/batchdelete.do">批量删除</a></c:if>
	</div>
</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>