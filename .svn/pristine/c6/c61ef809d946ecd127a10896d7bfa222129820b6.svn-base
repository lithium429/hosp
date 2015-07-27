<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:AdviceLayout>
	<!-- S nav -->
	<gd:AdviceNav current_type="3" />
	<!-- E nav -->
	<!-- S content -->
	<div class="clearfix wrap">
		<%-- <div class="crumb crumb_wrap">
			<div class="crumb_inner">
				当前位置：<a class="fb crumb_lk" href="care/home/index.shtml">首页</a>
				<span class="crumb_arrow">&gt;</span>
				<a class="crumb_lk" href="javascript:void(0);">${typeName}</a>	
			</div>
		</div> --%>
		<div class="clearfix article">
			<!-- S 公开信件-->
			<div class="p_rel mod_wrap">
				<div class="hd"><h2>公开信件</h2></div>
				<div class="bd">
					<ul class="sd_list list">
						<c:choose>
							<c:when test="${!empty list}">
								<c:forEach items="${list}" var="item" varStatus="vs">
									<li><a href="advice/home/details/${item.id}.shtml" title="${item.title}" target="_blank">${item.title}</a><span class="time"><fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd" /></span></li>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<li>暂无数据</li>
							</c:otherwise>
						</c:choose>
					</ul>
					<!-- S pager -->
					<c:if test="${!empty list}">
						<gd:CarePager />
					</c:if>
					<!-- E pager -->
				</div>
			</div><!-- E 公开信件 -->
		</div>
	</div><!-- E content -->
</gd:AdviceLayout> 