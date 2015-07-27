<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<tr class="dn">
	<td colspan="3">
		<input type="hidden" id="stime_count" value="${stimeCount}" />
	</td>
</tr>
<c:forEach var="day" items="${days}" varStatus="vsDay">
	<c:set var="dayOfWeek" value="${gdf:getDayOfWeek(year, month, day)}" />
	<c:set var="timeType" value="${gdf:getTimeTypeByDayOfWeek(dayOfWeek)}" />
	<c:set var="initTimeList" value="${timeMap.get(timeType)}" />
	<c:set var="timeList" value="${gdf:gainTimeList(year, month, day, initTimeList, schedulingList)}" />
	<c:set var="rowspan" value="${timeList.size()}" />
	<c:set var="isAllowEdit" value="${year > yearNow  || (year == yearNow && ((month == monthNow && day >= dayNow) || month > monthNow))}" />
	<c:choose>
		<c:when test="${isAllowEdit}">
			<c:set var="tdItemClass" value="td_item" />
		</c:when>
		<c:otherwise>
			<c:set var="tdItemClass" value="cursor_na" />
		</c:otherwise>
	</c:choose>
	<c:choose>
		<c:when test="${timeList.size() > 1}">
			<tr>
				<td rowspan="${rowspan + 1}" style="padding-left:20px;">${day}</td>
				<td rowspan="${rowspan + 1}">${gdf:getDayOfWeekForText(year, month, day)}</td>
			</tr>		
			<c:forEach var="timeItem" items="${timeList}" varStatus="vsTime">
				<c:set var="sindex" value="${vsDay.index}_${vsTime.index}" />
				<tr>
					<td>							
						<fmt:formatDate value="${timeItem.start_time}" pattern="HH:mm" />-<fmt:formatDate value="${timeItem.end_time}" pattern="HH:mm" />						
					</td>
					<c:set var="itemId" value="${gdf:gainSchedulingId(year, month, day, timeItem.start_time, timeItem.end_time, schedulingList)}" />	
					<td class="${tdItemClass}" rel="${sindex}" item_id="${itemId}" day="${day}" day_of_week="${dayOfWeek}" start_time='<fmt:formatDate value="${timeItem.start_time}" pattern="HH:mm" />' end_time='<fmt:formatDate value="${timeItem.end_time}" pattern="HH:mm" />'>
						<div class="dib mr10 inp_t mail_input" id="div_${sindex}">
							<c:set var="list" value="${gdf:gainSchedulingUsers(itemId, schedulingList)}" />
							<c:if test="${list != null && list.size() > 0}">
								<c:forEach var="schedulingItem" items="${list}" varStatus="vsScheduling">
			                        <span id="span_${sindex}_${vsScheduling.index}" class="user_child" onclick="scheduling.remove('span_${sindex}_${vsScheduling.index}', ${isAllowEdit});">
			                        	${schedulingItem.user_name}<c:if test="${isAllowEdit}"><em title="删除" class="del_user">×</em></c:if>
			                        	<input type="hidden" name="user_id" value="${schedulingItem.user_id}" />
			                        </span>		      
		                        </c:forEach>
	                        </c:if>             
        		        </div> 
					</td>
				</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td style="padding-left:20px;">${day}</td>
				<td>${gdf:getDayOfWeekForText(year, month, day)}</td>
				<td>		 
					<c:forEach var="timeItem" items="${timeList}" varStatus="subVs">	
						<c:set var="startTime" value="${timeItem.start_time}" />
						<c:set var="endTime" value="${timeItem.end_time}" />	
						<fmt:formatDate value="${startTime}" pattern="HH:mm" />-<fmt:formatDate value="${endTime}" pattern="HH:mm" />
					</c:forEach>						
				</td>	
				<c:set var="itemId" value="${gdf:gainSchedulingId(year, month, day, startTime, endTime, schedulingList)}" />
				<td class="${tdItemClass}" rel="${vsDay.index}_0" item_id="${itemId}" day="${day}" day_of_week="${dayOfWeek}"  start_time='<fmt:formatDate value="${startTime}" pattern="HH:mm" />' end_time='<fmt:formatDate value="${endTime}" pattern="HH:mm" />' >
					<div class="dib mr10 inp_t mail_input" id="div_${vsDay.index}_0">
						<c:set var="list" value="${gdf:gainSchedulingUsers(itemId, schedulingList)}" />
						<c:if test="${list != null && list.size() > 0}">
							<c:forEach var="schedulingItem" items="${list}" varStatus="vsScheduling">
		                        <span id="span_${vsDay.index}_0_${vsScheduling.index}" class="user_child" onclick="scheduling.remove('span_${vsDay.index}_0_${vsScheduling.index}', ${isAllowEdit});">
		                        	${schedulingItem.user_name}<c:if test="${isAllowEdit}"><em title="删除" class="del_user">×</em></c:if>
		                        	<input type="hidden" name="user_id" value="${schedulingItem.user_id}" />
		                        </span>		      
	                        </c:forEach>
                        </c:if>             
       		        </div> 
				</td>
			</tr>		
		</c:otherwise>
	</c:choose>
</c:forEach>