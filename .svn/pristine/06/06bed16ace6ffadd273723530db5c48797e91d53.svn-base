<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<table class="wc100 ml20 view_data">
	<tbody>
		<tr>
			<td colspan="3">分类\日期</td>
			<td class="w140">星期一</td>
			<td class="w140">星期二</td>
			<td class="w140">星期三</td>
			<td class="w140">星期四</td>
			<td class="w140">星期五</td>
			<td class="w140">星期六</td>
			<td class="w140">星期天</td>
		</tr>
		<tr>
			<td class="w35" rowspan="5">午餐</td>
			<td class="w30" rowspan="3">大荤</td>
			<td class="w30">A</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="${!empty list && list[0+vs.index*10].order_count>0?'cur':'' }">
				${!empty list?list[0+vs.index*10].food_name:'' }
				<c:if test="${!empty list && list[0+vs.index*10].order_count>0 }">
				<span>(${list[0+vs.index*10].order_count }份)</span>
				</c:if>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>B</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="${!empty list && list[1+vs.index*10].order_count>0?'cur':'' }">
				${!empty list?list[1+vs.index*10].food_name:'' }
				<c:if test="${!empty list && list[1+vs.index*10].order_count>0 }">
				<span>(${list[1+vs.index*10].order_count }份)</span>
				</c:if>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>C</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="${!empty list && list[2+vs.index*10].order_count>0?'cur':'' }">
				${!empty list?list[2+vs.index*10].food_name:'' }
				<c:if test="${!empty list && list[2+vs.index*10].order_count>0 }">
				<span>(${list[2+vs.index*10].order_count }份)</span>
				</c:if>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td colspan="2">小荤</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty list?list[3+vs.index*10].food_name:'' }
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td colspan="2">蔬菜</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty list?list[4+vs.index*10].food_name:'' }
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td rowspan="5">晚餐</td>
			<td rowspan="3">大荤</td>
			<td>A</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="${!empty list && list[5+vs.index*10].order_count>0?'cur':'' }">
				${!empty list?list[5+vs.index*10].food_name:'' }
				<c:if test="${!empty list && list[5+vs.index*10].order_count>0 }">
				<span>(${list[5+vs.index*10].order_count }份)</span>
				</c:if>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>B</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="${!empty list && list[6+vs.index*10].order_count>0?'cur':'' }">
				${!empty list?list[6+vs.index*10].food_name:'' }
				<c:if test="${!empty list && list[6+vs.index*10].order_count>0 }">
				<span>(${list[6+vs.index*10].order_count }份)</span>
				</c:if>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>C</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="${!empty list && list[7+vs.index*10].order_count>0?'cur':'' }">
				${!empty list?list[7+vs.index*10].food_name:'' }
				<c:if test="${!empty list && list[7+vs.index*10].order_count>0 }">
				<span>(${list[7+vs.index*10].order_count }份)</span>
				</c:if>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td colspan="2">小荤</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty list?list[8+vs.index*10].food_name:'' }
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td colspan="2">蔬菜</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty list?list[9+vs.index*10].food_name:'' }
			</td>
			</c:forEach>
		</tr>
	</tbody>
</table>