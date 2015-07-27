<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:ForumLayout>
	<jsp:attribute name="css">
		<link rel="stylesheet" type="text/css" href="static/js/kindeditor-4.1.4/themes/default/default.css" />
		<style type="text/css">
			.tl th,.tl td{padding:5px 0;border-bottom:1px solid #C2D5E3;}
			.ttp .a a:hover{background-image:none;}
			.tl th{text-align:right;width:100px;} 
			.bd{margin-left:20px;height:auto;}
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
							<a href="javascript:void(0);" id="btn_add_thread"><img src="static/images/forum/pn_post.png" alt="发新帖"></a>
						</div>
						<gd:ForumUserTab />						
						<div class="tl bm bmw">
							<div class="bm_c">
								<div class="hd">
									<h2>个人资料</h2>
								</div>
								<div class="bd">
									<table cellspacing="0" cellpadding="0">
										<tr>
											<td rowspan="5" style="padding-right:5px;">
												<c:choose>
													<c:when test="${!empty forumUser.micon_url}">
														<img src="${forumUser.micon_url}" alt="" />
													</c:when>
													<c:otherwise>
														<img src="static/images/forum/noavatar_middle.gif" alt="" />
													</c:otherwise>
												</c:choose>
											</td>
										</tr>
										<tr>
											<th>姓名：</th>
											<td>${userInfo.real_name}</td>
											<th>部门科室：</th>
											<td>${userInfo.dept_name}</td>
											<th>性别：</th>
											<td>
												<c:choose>
													<c:when test="${userInfo.sex==1 }">男</c:when>
													<c:when test="${userInfo.sex==2 }">女</c:when>
												</c:choose>
											</td>
											<th>状态：</th>
											<td>
												<c:choose>
													<c:when test="${userInfo.state==1 }">正常</c:when>
													<c:when test="${userInfo.state==2 }">冻结</c:when>
												</c:choose>
											</td>
										</tr>
										<tr> 
											<th>手机：</th>
											<td>${userInfo.mobile}</td> 
											<th>邮箱：</th>
											<td>${userInfo.email}</td>
											<th>QQ：</th>
											<td colspan="3">${userInfo.qq}</td>
										</tr> 
										<tr>
											<th>主题数：</th>
											<td>${forumUser.thread_count}</td>
											<th>帖子数：</th>
											<td>${forumUser.post_count}</td>
											<th>最近登录时间：</th>
											<td><fmt:formatDate value="${loginLog.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
											<th>最近登录IP：</th>
											<td>${loginLog.ip}</td>
										</tr> 
									</table>
								</div>
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
 