<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<%@ attribute name="current_type" type="java.lang.Integer"%>
<%@ tag import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ tag import="org.springframework.context.ApplicationContext"%>
<%@ tag import="com.xz.oa.core.service.forum.ForumUserService"%>
<%@ tag import="com.xz.oa.core.domain.entity.ForumUser"%>

<%
	if(session.getAttribute("forum_login_user") == null){
		ApplicationContext theContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
		ForumUserService forumUserService = (ForumUserService) theContext.getBean("forumUserService");
		forumUserService.gainForumUser(session);
	}
	ForumUser forumUser = (ForumUser)session.getAttribute("forum_login_user");
	request.setAttribute("forumUserTop", forumUser); 
%>
<div id="hd">
	<div class="wp">
		<div class="hdc cl"><h2><a href="forum/index.shtml" title="Discuz! Board"><img src="static/images/forum/logo.png" alt="论坛" style="border:none;" /></a></h2>
			<div id="um">
				<div class="avt y"><a href="forum/user/${forumUserTop.user_id}.shtml"><img src="${forumUserTop.sicon_url}"></a></div>
				<p>
					<strong class="vwmy">${forumUserTop.user_name}</strong>
					<span class="pipe">|</span><a href="logout.do">退出</a>
				</p>
				<p>
					<span>主题：${forumUserTop.thread_count}</span><span class="pipe">|</span><span>帖子：${forumUserTop.post_count}</span>
				</p>
			</div>
		</div>
		<div id="nv">
			<ul>
				<li <c:if test="${empty current_type}">class="a"</c:if>><a href="forum/index.shtml" hidefocus="true" title="首页">首页</a></li>
				<li <c:if test="${current_type == 1}">class="a"</c:if>><a href="forum/guidelist/1.shtml" hidefocus="true" title="最热">最热</a></li>
				<li <c:if test="${current_type == 2 || current_type == 3}">class="a"</c:if>><a href="forum/guidelist/2.shtml" hidefocus="true" title="最新">最新</a></li>
				<li <c:if test="${current_type == 4}">class="a"</c:if>><a href="forum/user/${forumUserTop.user_id}.shtml" hidefocus="true" title="个人空间">个人空间</a></li>
			</ul>
		</div>
		<div id="mu" class="cl"></div>
		<div id="scbar" class="cl">
			<form id="search_form" method="post" autocomplete="off" action="forum/search.shtml"> 
				<table cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td class="scbar_icon_td"></td>
							<td class="scbar_txt_td">
								<c:choose>
									<c:when test="${empty search_key}">
										<input type="text" name="search_key" id="search_key" value="请输入搜索内容" autocomplete="off" x-webkit-speech="" speech="" class="xg1" style="color:#CDCDCD;" />
									</c:when>
									<c:otherwise>
										<input type="text" name="search_key" id="search_key" value="${search_key}" autocomplete="off" x-webkit-speech="" speech="" class="xg1" />
									</c:otherwise>
								</c:choose>
							</td>
							<td class="scbar_type_td"><a href="javascript:void(0);" id="scbar_type" class="xg1" hidefocus="true">主题</a></td>
							<td class="scbar_btn_td">
								<input type="button" id="btn_search" class="pn pnc" value="" style="width:40px;" />
							</td>
							<td class="scbar_hot_td">
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(function(){
		search.init();
	});
	
	var search = (function(){
		function init(){
			$('#search_key').focus(function(){
				if(this.value === '请输入搜索内容'){
					$(this).val('').removeAttr('style');
				}
			}).blur(function(){
				if(util.isEmpty(this.value)){
					$(this).val('请输入搜索内容').css({ 'color': '#CDCDCD' });
				}
			});
			
			$('#btn_search').click(go);
		}
		
		function go(){
			var searchKey = $('#search_key').val();
			if(searchKey === '请输入搜索内容' || util.isEmpty(searchKey)){
				return false;
			}
			else{
				$('#search_form').submit();
			}
		}
		
		function handlePage(){
			$('.pg').find('a').click(function(){
				var url = $(this).attr('href');
				$('#search_form').attr('action', url).submit();
				return false;
			});
		}
		
		return { init: init, handlePage: handlePage };
	})();
</script>
