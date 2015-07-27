<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<script type="text/javascript" src="static/js/flexigrid-1.1/js/flexigrid.js"></script> 
<div class="datalistbox" style="top:112px;">
	<table class="OptionTable" id="tableSort">
	    <thead>
	    	<tr>
		        <th class="check w3per">
		            <input type="checkbox" id="check_all" class="inp_analog" /><span class="icon ico-checkbox"></span>
		        </th>
		        <th class="serial w5per">序号</th>
   				<th class="w10per">会议主题</th>
   				<th class="w10per">会议主持人</th>
   				<th class="w12per">会议开始时间</th>
   				<th class="w12per">会议结束时间</th>
   				<th class="w10per">会议室</th>
   				<th class="w8per">会议状态</th>
   				<c:if test="${type!=0 }">
   				<th class="w8per">审核状态</th></c:if>
   				<c:if test="${type==2}">
   				<th class="w8per">申请人</th></c:if>
		        <th class="hd_operate">操作</th>
		  	</tr>
	    </thead>
    	<tbody>
			<c:forEach items="${list}" var="item" varStatus="vs">  
            	<tr >
					<td class="check w3per">
	                	<input type="checkbox" name="id" class="inp_analog batch" key="${item.verify_state}" value="${item.id}" /><span
		                    class="icon ico-checkbox"></span>
		            </td>
		            <td class="serial">
		                ${vs.count+pageInfo.startIndex}
		            </td>
		            <td>
		            	<a href="meeting/view.do?id=${item.id}&type=${type }" class="view">${item.subject}</a>
		            </td>
		            <td>
		            	${item.holder}
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.begin_time}" pattern="yyyy-MM-dd HH:mm" />
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.end_time}" pattern="yyyy-MM-dd HH:mm" />
		            </td>
		            <td>
		            	${item.room_name}
		            </td>
		            <td>
		            	${item.getStateBydate()}
		            </td>
		            <c:if test="${type!=0 }">
		            <td>
		            	<c:choose>
		            		<c:when test="${item.verify_state==1 }">待审核</c:when>
		            		<c:when test="${item.verify_state==2 }">审核通过</c:when>
		            		<c:when test="${item.verify_state==3 }">审核不通过</c:when>
		            	</c:choose>
		            </td></c:if>
   				<c:if test="${type==2}">
		            <td>
		            	${item.creator_real_name}
		            </td></c:if>
					<td  class="operations">
						<c:if test="${type==1 }">
							<c:if test="${item.getStateBydate()=='未开始' && item.verify_state==2  && gdf:judgeRoleMenu(roleMenuList,'取消')}">
							<a href="meeting/cancle.do?id=${item.id}" class="cancle">取消</a>&nbsp;</c:if>
							<c:if test="${item.verify_state==1 && gdf:judgeRoleMenu(roleMenuList,'修改')}">
							<a href="meeting/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
						</c:if>
						<c:if test="${type==2 &&item.verify_state==1 }">
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'通过') }">
							<a href="meeting/change.do?id=${item.id}&is_agree=true" class="change1 agree">通过</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'不通过') }">
							<a href="meeting/check.do?id=${item.id}&is_agree=false" class="change2">不通过</a>&nbsp;</c:if>
						</c:if>
						<c:if test="${((type==1 && item.verify_state==1) ||  type==2) && gdf:judgeRoleMenu(roleMenuList,'删除')}">
						<a href="meeting/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;
						</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="meeting/view.do?id=${item.id}&type=${type }" class="view">查看</a></c:if>
					</td>
				</tr>            
			</c:forEach>
         	<c:if test="${empty list}">
				<tr>
		        	<td colspan="${type==0?9:(type==2?11:10)}" class="t_c">
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
		<c:if test="${type!=0 && gdf:judgeRoleMenu(roleMenuList,'批量删除')}">
			<a class="btn" id="batch_delete${type==1?'1':'' }" href="meeting/batchdelete.do">批量删除</a>
		</c:if>
		
		<c:if test="${type==2}">
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量通过') }">
			<a class="btn agree" id="batch_change1" href="meeting/change.do?is_agree=true">通过</a></c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量不通过') }">
			<a class="btn" id="batch_change2" href="meeting/check.do?is_agree=false">不通过</a></c:if>
		</c:if>
		</div>
	</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>