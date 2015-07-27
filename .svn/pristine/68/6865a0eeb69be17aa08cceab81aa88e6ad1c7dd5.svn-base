<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<c:choose>
	<c:when test="${forumUserTop.user_id == userId}">
		<ul id="thread_types" class="ttp bm cl">
			<li <c:if test="${type == 1}">class="xw1 a"</c:if>><a href="forum/user/${userId}.shtml">个人资料</a></li>
			<li <c:if test="${type == 2}">class="xw1 a"</c:if>><a href="forum/user/avatar.shtml">头像设置</a></li>
			<li <c:if test="${type == 3}">class="xw1 a"</c:if>><a href="forum/user/thread.shtml">我的主题</a></li>
			<li <c:if test="${type == 4}">class="xw1 a"</c:if>><a href="forum/user/post.shtml">我的回帖</a></li>
			<li <c:if test="${type == 5}">class="xw1 a"</c:if>><a href="forum/user/fav.shtml">我的收藏</a></li>
		</ul>
	</c:when>
	<c:otherwise>
		<ul id="thread_types" class="ttp bm cl">
			<li <c:if test="${type == 1}">class="xw1 a"</c:if>><a href="forum/user/${userId}.shtml">个人资料</a></li>
			<li <c:if test="${type == 3}">class="xw1 a"</c:if>><a href="forum/user/thread.shtml?uid=${userId}">他的主题</a></li>
			<li <c:if test="${type == 4}">class="xw1 a"</c:if>><a href="forum/user/post.shtml?uid=${userId}">他的回帖</a></li>
		</ul>
	</c:otherwise>
</c:choose>
<script type="text/javascript">
	$(function(){
		$('#btn_add_thread').click(addThread);
	});

	function addThread(){
		openPage({
			url: 'forum/thread/add.do?from_user_center=true',
			title: '发帖',
			width:'810px',
			height:'470px'
		});
		return false;
	}
</script>