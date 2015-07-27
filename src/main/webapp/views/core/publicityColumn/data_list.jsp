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
   				<th class="w20per">标题</th>
   				<th class="w8per">类型</th>
   				<th class="w20per">发布时间</th>
   				<th class="w12per">排序</th> 
		        <th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
            	<tr>
					<td class="check w3per">
	                	<input type="checkbox" name="id" class="inp_analog batch" value="${item.id}" /><span
		                    class="icon ico-checkbox" ></span>
		            </td>
		            <td class="serial">
		                ${vs.count+pageInfo.startIndex}
		            </td>
		            <td>
		            	<a href="publicityColumn/view.do?id=${item.id}" class="view">${item.title}</a>
		            </td>
		            <td>
		             	<c:choose>
		             		<c:when test="${item.type == 1}">
		             			院务公开栏
		             		</c:when>
		             		<c:when test="${item.type == 2}">
		             			党务公开栏
		             		</c:when>
		             		<c:when test="${item.type == 3}">
		             			奖惩公示栏
		             		</c:when>
		             		<c:when test="${item.type == 4}">
		             			其它
		             		</c:when>
		             	</c:choose>
		            </td> 
		            <td>
		            	<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm:ss" />
		            </td>
		            <td>
		            	<c:if test="${gdf:judgeRoleMenu(roleMenuList,'向上')  && (vs.index!=0 || pageInfo.pageIndex!=1)}">
		            	<a href="publicityColumn/move.do?sort=${item.sort}&is_up=true" class="move_up">向上</a>&nbsp;</c:if>
		            	<c:if test="${gdf:judgeRoleMenu(roleMenuList,'向下') && (pageInfo.pageCount!=pageInfo.pageIndex || vs.index!=list.size()-1) }">
		            	<a href="publicityColumn/move.do?sort=${item.sort}&is_up=false" class="move_down">向下</a>&nbsp;</c:if>
		            	<c:if test="${gdf:judgeRoleMenu(roleMenuList,'置顶') && (vs.index!=0 || pageInfo.pageIndex!=1) }">
		            	<a href="publicityColumn/move.do?sort=${item.sort}&is_up=true&toSort=${maxSort}" class="move_top">置顶</a></c:if>
		            </td> 
					<td  class="operations">
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'修改') }">
							<a href="publicityColumn/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') }">
							<a href="publicityColumn/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;</c:if>
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
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量删除') }">
		<a class="btn" id="batch_delete" href="publicityColumn/batchdelete.do">批量删除</a></c:if>
	</div>
</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>