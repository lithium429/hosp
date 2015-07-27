<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:ForumLayout>
	<jsp:attribute name="css">
		<link rel="stylesheet" type="text/css" href="static/js/kindeditor-4.1.4/themes/default/default.css" />
		<style type="text/css">
			.tl th,.tl td{padding:5px 0;border-bottom:1px solid #C2D5E3;}
			.ttp .a a:hover{background-image:none;}
			.tl .num{width:120px;}
		</style>
	</jsp:attribute>

	<jsp:body>
		<input type="hidden" id="plate_id" name="plate_id" value="${plateId}" />
		<!-- S top -->
		<gd:ForumTop current_type="4" />
		<!-- E top -->
		<!-- S content -->
		<div id="wp" class="wp">
			<!-- S nav -->
			<gd:ForumUserNav />
			<!-- E nav -->
			<!--[diy=diynavtop]--><div id="diynavtop" class="area"></div><!--[/diy]-->
			<div class="wp">
				<!--[diy=diy1]--><div id="diy1" class="area"></div><!--[/diy]-->
			</div>
			<div class="boardnav">
				<div id="ct" class="wp cl">  
					<div class="mn">
						<div class="bm bml pbn">
							<div class="bm_h cl">
								<h1 class="xs2"> ${typeText}</h1>
							</div>
						</div>
						<div id="pgt" class="bm bw0 pgs cl">
							<c:if test="${!empty list}">
								<gd:ForumPager />
							</c:if>
							<a href="javascript:void(0);" id="btn_add_thread"><img src="static/images/forum/pn_post.png" alt="发新帖"></a>
						</div>
						<gd:ForumUserTab />
						<div class="tl bm bmw" style="position: relative;">
							<div class="th">
								<table cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<th colspan="2">标题</th>
											<td class="frm">版块</td> 
											<td class="num">回复/查看</td>
											<td class="by">最后发表</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="bm_c">
								<table cellspacing="0" cellpadding="0">
									<c:choose>
										<c:when test="${!empty list}">
											<c:forEach items="${list}" var="item">
												<tbody>
													<tr>
														<td class="icn">
															<a href="forum/thread/${item.id}.shtml" title="新窗口打开" target="_blank">
																<img src="static/images/forum/folder_common.gif">
															</a>
														</td>
														<th class="common">
															<a href="forum/thread/${item.id}.shtml" class="xst">
																${gdf:subStringWithEllipsis(item.subject, 38)}
																<c:if test="${item.has_file}">
																	<img src="static/images/forum/common.gif" alt="attachment" title="附件" align="absmiddle">
																</c:if>
															</a>
														</th>
														<td class="frm"><a href="forum/list/${item.plate_id}.shtml" target="_blank">${item.plate_name}</a></td>
														<td class="num">
															<a href="forum/thread/${item.id}.shtml" class="xi2">${item.reply_count}</a><em>${item.view_count}</em>
														</td>
														<td class="by">
															<cite><a href="forum/user/${item.last_poster_id}.shtml">${item.last_poster_name}</a></cite>
															<em><a href="forum/thread/${item.id}.shtml#lastpost"><fmt:formatDate value="${item.last_post_time}" pattern="yyyy-MM-dd HH:mm" /></a></em>
														</td>
													</tr>
												</tbody> 
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tbody>
												<tr>
													<th colspan="5"><p class="emp">暂时还没有主题</p></th>
												</tr>
											</tbody>
										</c:otherwise>
									</c:choose> 
								</table>
							</div>
						</div>
						<div class="bm bw0 pgs cl">
							<c:if test="${!empty list}">
								<gd:ForumPager />
							</c:if> 
						</div>
					</div>
				</div>
			</div>
			<div class="wp mtn">
				<!--[diy=diy3]--><div id="diy3" class="area"></div><!--[/diy]-->
			</div>
		</div>
		<!-- E content -->
		<script type="text/javascript">
			$(function(){ 
				
			});
		</script>
	</jsp:body>
</gd:ForumLayout> 
 