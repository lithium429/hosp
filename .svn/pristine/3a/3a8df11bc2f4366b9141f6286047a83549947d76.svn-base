<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<table class="wc100 view_data ml20">
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
			<td class="w35" rowspan="6">午餐</td>
			<td class="w30" rowspan="3">大荤</td>
			<td class="w30">A</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="">
				<c:choose>
					<c:when test="${!empty meal_list }">${meal_list[0+vs.index*6].food_name }</c:when>
					<c:when test="${!empty total_list }">${total_list[0+vs.index*2].gainFood_name(1) }</c:when>
				</c:choose>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>B</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="">
				<c:choose>
					<c:when test="${!empty meal_list }">${meal_list[1+vs.index*6].food_name }</c:when>
					<c:when test="${!empty total_list }">${total_list[0+vs.index*2].gainFood_name(2) }</c:when>
				</c:choose>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>C</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="">
				<c:choose>
					<c:when test="${!empty meal_list }">${meal_list[2+vs.index*6].food_name }</c:when>
					<c:when test="${!empty total_list }">${total_list[0+vs.index*2].gainFood_name(3) }</c:when>
				</c:choose>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td rowspan="3">订餐</td>
			<td>A</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty total_list?total_list[0+vs.index*2].gainFood_num(1):0 }
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>B</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty total_list?total_list[0+vs.index*2].gainFood_num(2):0 }
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>C</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty total_list?total_list[0+vs.index*2].gainFood_num(3):0 }
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td colspan="3">总计</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty total_list?total_list[0+vs.index*2].total_count:0 }
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td rowspan="7">晚餐</td>
			<td rowspan="3">大荤</td>
			<td>A</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="">
				<c:choose>
					<c:when test="${!empty meal_list }">${meal_list[3+vs.index*6].food_name }</c:when>
					<c:when test="${!empty total_list }">${total_list[1+vs.index*2].gainFood_name(1) }</c:when>
				</c:choose>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>B</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="">
				<c:choose>
					<c:when test="${!empty meal_list }">${meal_list[4+vs.index*6].food_name }</c:when>
					<c:when test="${!empty total_list }">${total_list[1+vs.index*2].gainFood_name(2) }</c:when>
				</c:choose>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>C</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td class="">
				<c:choose>
					<c:when test="${!empty meal_list }">${meal_list[5+vs.index*6].food_name }</c:when>
					<c:when test="${!empty total_list }">${total_list[1+vs.index*2].gainFood_name(3) }</c:when>
				</c:choose>
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td rowspan="3">订餐</td>
			<td>A</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty total_list?total_list[1+vs.index*2].gainFood_num(1):0 }
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>B</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty total_list?total_list[1+vs.index*2].gainFood_num(2):0 }
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td>C</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty total_list?total_list[1+vs.index*2].gainFood_num(3):0 }
			</td>
			</c:forEach>
		</tr>
		<tr>
			<td colspan="2">总计</td>
			<c:forEach begin="0" end="6" step="1" varStatus="vs" >
			<td>
				${!empty total_list?total_list[1+vs.index*2].total_count:0 }
			</td>
			</c:forEach>
		</tr>
	</tbody>
</table>