<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<%@ attribute name="current_type" type="java.lang.Integer"%>
<div class="wrap p_rel main_nav">
	<ul class="clearfix nav">
		<li <c:if test="${current_type == 0}">class="cur"</c:if>><a href="care/home/index.shtml">首页</a></li>
		<c:if test="${!empty typeList}">
			<c:forEach var="item" items="${typeList}" varStatus="vs">
				<li <c:if test="${current_type == item.id}">class="cur"</c:if>><a href="care/home/list/${item.id}.shtml">${item.name}</a></li>
			</c:forEach>
		</c:if>
	</ul>
	<div class="top_serarch">
		<form>
			<input type="text" name="" placeholder="站内搜索" class="inp_t" /><input type="submit" class="btn_sea" value="搜索"  />
		</form>
	</div>
</div>