<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<%@ attribute name="current_type" type="java.lang.Integer"%>  
<div class="aside">
	<div class="mod_wrap sidenav">
		<div class="hd"><h2>栏目导航</h2></div>
		<div class="bd">
			<ul class="sd_list subnav">
				<c:if test="${!empty typeList}">
					<c:forEach var="item" items="${typeList}" varStatus="vs">
						<li <c:if test="${current_type == item.id}">class="cur"</c:if>><a href="care/home/list/${item.id}.shtml">${item.name}</a></li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
</div>