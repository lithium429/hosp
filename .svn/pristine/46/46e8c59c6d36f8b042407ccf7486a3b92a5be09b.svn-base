<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:CareLayout>
	<!-- S nav -->
	<gd:CareNav current_type="0" />
	<!-- E nav -->
	<!-- S content -->
	<div class="clearfix wrap">
		<div class="clearfix article news_col">
			<c:forEach var="itemType" items="${typeList}">
				<!-- S 新闻列表 -->
				<div class="p_rel mod_wrap news_list column">
					<div class="hd"><h2>${itemType.name}</h2><em class="rdot"></em></div>
					<div class="bd">
						<c:if test="${homeMap != null}">
							<c:set var="list" value="${homeMap.get(itemType.id)}" />
						</c:if>
						<ul class="sd_list list">
							<c:choose>
								<c:when test="${!empty list}">
									<c:forEach items="${list}" var="item" varStatus="vs">
										<li><a href="care/home/details/${item.id}.shtml" title="${item.title}" target="_blank">${item.title}</a><span class="time"><fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd" /></span></li>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<li>暂无数据</li>
								</c:otherwise>
							</c:choose>
						</ul>
					</div>
					<span class="abs_rt"><a href="care/home/list/${itemType.id}.shtml" target="_blank">更多&gt;&gt;</a></span>
				</div><!-- E 新闻列表 -->
			</c:forEach>
		</div>
	</div><!-- E content --> 
</gd:CareLayout> 