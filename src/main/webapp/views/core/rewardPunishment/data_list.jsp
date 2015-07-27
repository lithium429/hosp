<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<script type="text/javascript" src="static/js/flexigrid-1.1/js/flexigrid.js"></script> 
<div class="datalistbox" style="top:110px;">
	<table class="OptionTable" id="tableSort">
	    <thead>
	    	<tr>
		        <th class="check w3per">
		            <input type="checkbox" id="check_all" class="inp_analog" /><span class="icon ico-checkbox"></span>
		        </th>
		        <th class="serial w5per">序号</th>
   				<th class="w10per">员工</th>
   				<th class="w12per">奖惩名目</th>
   				<th class="w5per">奖惩属性</th>
   				<th class="w15per">授予单位</th>
   				<th class="w8per">奖惩金额（元）</th>
   				<th class="w8per">奖惩日期</th>
   				<th class="w25per">奖惩内容</th>
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
		            	${item.name}
		            </td>
		            <td>
		            	${item.item_name}
		            </td>
		            <td>
		            	${item.type==1?'奖励':'惩罚'}
		            </td>
		            <td>
		            	${item.unit}
		            </td>
		            <td>
		            	${item.amount}
		            </td>
		            <td>
		            	<fmt:formatDate value="${item.rp_date}" pattern="yyyy-MM-dd" />
		            </td>
		            <td>
		            	${item.content}
		            </td>
					<td  class="operations">
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'修改') }">
						<a href="rewardPunishment/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') }">
						<a href="rewardPunishment/delete.do?id=${item.id}" class="delete">删除</a>&nbsp;</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="rewardPunishment/view.do?id=${item.id}" class="view">查看</a></c:if>
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
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量删除') }">
			<a class="btn" id="batch_delete" href="rewardPunishment/batchdelete.do">批量删除</a></c:if>
		</div>
	</c:if>
<script type="text/javascript">
    $(function () {
        $('.OptionTable').flexigrid();
     });
</script>