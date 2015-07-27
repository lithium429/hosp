<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<h3><em class="mr5 c_hui dot">∨</em>系统用户</h3>
<ul id="tplUl" class="ml30 scroll_box mail_friend">
	<c:forEach items="${userList}" var="item" varStatus="vs">
	<li class="tplLi">
		<h4 class="dept">${item.deptName }</h4>
		<ul class="m5 pl20">
			<c:forEach items="${item.users}" var="temp" varStatus="vs1">
			<li class="sysuser_child u_child${temp.id }" key="${temp.id }" key_n="${temp.real_name }">${temp.real_name }[${temp.name}]</li>
			</c:forEach>
		</ul>
	</li>
	</c:forEach>
</ul>
<script type="text/javascript">
	$(function(){
		matchChild();
		
	});
		
	</script>