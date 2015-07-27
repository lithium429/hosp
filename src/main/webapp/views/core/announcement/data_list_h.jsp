<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<div class="datalistbox" style="top:40px;">
	<table class="OptionTable" id="tableSort">
	    <thead>
	    	<tr> 
		        <th class="serial w60">序号</th>
   				<th class="w30per">公告标题</th>
   				<th class="w10per">类型</th>
   				<th class="w20per">发布时间</th>
		        <th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
            	<tr > 
		            <td class="serial">
		                ${vs.count+pageInfo.startIndex}
		            </td>
		            <td>
		            	<a href="announcement/view.do?id=${item.id}&is_home=${is_home}" class="view">${item.title}</a>
		            </td>
		            <td>
		            	${item.type_name}
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm:ss" />
		            </td>
					<td  class="operations">
						<a href="announcement/view.do?id=${item.id}&is_home=${is_home}" class="view">查看</a>
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
<c:if test="${!empty list}">
	<gd:Pager />
	<div class="bot_fun" style="width:300px;">
		
	</div>
</c:if>
<script type="text/javascript">
    $(function () {
    	setTimeout(function(){
        	$('.OptionTable').flexigrid();
    	}, 1);
     });
</script>