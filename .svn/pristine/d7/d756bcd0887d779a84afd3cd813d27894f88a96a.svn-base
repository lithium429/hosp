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
   				<th class="w20per">主题</th>
   				<th class="w10per">板块</th>
   				<th class="w15per">作者</th>
   				<th class="w15per">回复/查看</th>
   				<th class="w15per">最后回复</th> 
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
		            	<a href="forum/thread/${item.id}.shtml" target="_blank">${item.subject}</a>
		            </td>
		            <td>
		            	<a href="forum/list/${item.plate_id}.shtml" target="_blank">${item.plate_name}</a>
		            </td>
		            <td>
		            	<a href="forum/user/${item.creator_id}.shtml" target="_blank">${item.creator_name}</a>
		            	<p><fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm" /></p>
		            </td>  
		            <td>
		            	${item.reply_count}/${item.view_count}
		            </td>
		            <td>
		            	${item.last_poster_name}
		            	<p><fmt:formatDate value="${item.last_post_time}" pattern="yyyy-MM-dd HH:mm" /></p>
		            </td>
					<td class="operations">
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'恢复') }">
							<a href="forum/thread/recover.do?id=${item.id}&plate_id=${item.plate_id}" class="recover">恢复</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') }">
							<a href="forum/thread/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;</c:if>
					</td>
				</tr>            
			</c:forEach>
         	<c:if test="${empty list}">
				<tr>
		        	<td colspan="8" class="t_c">
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
		<c:if test='${gdf:judgeRoleMenu(roleMenuList, "批量恢复") }'>
			<a class="btn" id="batch_recover" href="forum/thread/batch_recover.do">批量恢复</a>
		</c:if>
		<c:if test='${gdf:judgeRoleMenu(roleMenuList, "批量删除") }'>
			<a class="btn ml5" id="batch_delete" href="forum/thread/batch_delete.do">批量删除</a>
		</c:if>
	</div> 
</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>