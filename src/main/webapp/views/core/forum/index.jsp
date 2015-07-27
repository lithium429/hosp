<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:ForumLayout>
	<!-- S nav -->
	<gd:ForumTop />
	<!-- E nav -->
	<!-- S content -->
	<div id="wp" class="wp">
		<div id="ct" class="wp cl">
			<div id="chart" class="bm bw0 cl mtm">
				<p class="chart z">今日: <em>${todayCount}</em><span class="pipe">|</span>主题: <em>${threadCount}</em><span class="pipe">|</span>帖子: <em>${postCount}</em></p>
				<div class="y">
				<a href="forum/user/thread.shtml" title="我的主题" class="xi2">我的主题</a><span class="pipe">|</span><a href="forum/guidelist/2.shtml" title="最新回复" class="xi2">最新回复</a></div>
			</div>
			<!--[diy=diy_chart]--><div id="diy_chart" class="area"></div><!--[/diy]-->
			<div class="mn">
				<!--S index four grid -->
				<div class="fl bm">
					<div class="bm bmw cl">
						<div id="category_grid" class="bm_c" >
							<table cellspacing="0" cellpadding="0">
								<tr>
									<td valign="top" class="category_l1" style="padding-left:1px;">
										<div class="subjectbox">
											<h4>最新主题</h4>
											<ul class="category_newlist" style="height:230px;">
												<c:if test="${newThreadList != null}">
													<c:forEach var="item" items="${newThreadList}">
														<li>
															<a href="forum/thread/${item.id}.shtml" target="_blank">
																${gdf:subStringWithEllipsis(item.subject, 28)}
																<c:if test="${item.has_file}">
																	<img src="static/images/forum/common.gif" alt="attachment" title="附件" align="absmiddle" />
																</c:if>
															</a>
														</li>
													</c:forEach>
												</c:if>
											</ul>
										</div>
									</td>
									<td valign="top" class="category_l2">
										<div class="replaybox">
											<h4><span class="tit_replay"></span>最新回复</h4>
									        <ul class="category_newlist">
									            <c:if test="${newReplyThreadList != null}">
													<c:forEach var="item" items="${newReplyThreadList}">
														<li>
															<a href="forum/thread/${item.id}.shtml" target="_blank">
																${gdf:subStringWithEllipsis(item.subject, 28)}
																<c:if test="${item.has_file}">
																	<img src="static/images/forum/common.gif" alt="attachment" title="附件" align="absmiddle" />
																</c:if>
															</a>
														</li>
													</c:forEach>
												</c:if>
									         </ul>
										</div>
									</td>
									<td valign="top" class="category_l3">
										<div class="hottiebox">
											<h4><span class="tit_hottie"></span>热帖</h4>
									        <ul class="category_newlist">
									        	<c:if test="${hotThreadList != null}">
													<c:forEach var="item" items="${hotThreadList}">
														<li>
															<a href="forum/thread/${item.id}.shtml" target="_blank">
																${gdf:subStringWithEllipsis(item.subject, 28)}
																<c:if test="${item.has_file}">
																	<img src="static/images/forum/common.gif" alt="attachment" title="附件" align="absmiddle" />
																</c:if>
															</a>
														</li>
													</c:forEach>
												</c:if>
									        </ul>
										</div>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
				<!-- E index four grid -->
				<div class="fl bm">
					<c:forEach var="item" items="${plateList}">
						<c:if test="${item.layer == 1}">
							<div class="bm bmw  flg cl">
								<div class="bm_h cl">
									<span class="o">
										<img src="static/images/forum/collapsed_no.gif" title="收起/展开" alt="收起/展开" onclick="javascript:forumPlate.toggle('#plate_${item.id}', this);" />
									</span>
									<c:set var="realNames" value="${item.gainUserRealNames()}" />
									<c:if test="${!empty realNames }">
										<span class="y">分区版主: ${realNames}</span>
									</c:if>
									<h2><a href="javascript:void(0);" style="color:#0033CC;">${item.name}</a></h2>
								</div>
								<div id="plate_${item.id}" class="bm_c">
									<table cellspacing="0" cellpadding="0" class="fl_tb">
										<tr>
											<c:set var="cindex" value="0" />
											<c:forEach var="childItem" items="${plateList}">
												<c:if test="${childItem.layer == 2 && childItem.parent_id == item.id}">
													<c:set var="cindex" value="${cindex + 1}" />
													<c:if test="${cindex > 4 && cindex % 4 == 1}">
														</tr>
														<tr class="fl_row">
													</c:if>
													<td class="fl_g" style="width:24.9%">
														<div class="fl_icn_g">
															<a href="forum/list/${childItem.id}.shtml"><img src="static/images/forum/forum.gif" alt="${childItem.name}" /></a>
														</div>
														<dl>
															<dt><a href="forum/list/${childItem.id}.shtml">${childItem.name}</a></dt>
															<dd><em>主题: ${childItem.thread_count}</em>, <em>帖数: ${childItem.post_count}</em></dd>
															<dd>
																<c:choose>
																	<c:when test="${!empty  childItem.last_post_time}">
																		<a href="forum/thread/${childItem.last_thread_id}.shtml">最后发表: <fmt:formatDate value="${childItem.last_post_time}" pattern="yyyy-MM-dd HH:mm" /></a>
																	</c:when>
																	<c:otherwise>
																		从未
																	</c:otherwise>
																</c:choose>
															</dd>
														</dl>
													</td>
												</c:if>
										 	</c:forEach>
									 	</tr>
									</table>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		
			<div class="wp mtn">
			<!--[diy=diy3]--><div id="diy3" class="area"></div><!--[/diy]-->
			</div> 
		</div> 
	</div>
	<script type="text/javascript">
		$(function(){
			$('.fl_row').each(function(index, item){
				var tds = $(item).find('td').length;
				if(tds < 4){
					for(var i = 0; i < 4 - tds; i++){
						$(item).append('<td class="fl_g" style="width:24.9%"></td>');
					}
				}
			});
		}); 
	</script>
</gd:ForumLayout> 