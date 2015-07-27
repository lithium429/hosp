<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<h2 class="inside_group">我的分组（<span id="total_count">${addressGroupList.size()+1}</span>）</h2><c:if test="${gdf:judgeRoleMenu(roleMenuList,'添加分组') }"><span class="p_abs abs_rt btn btn_pub" style="top:4px;"><a href="addressGroup/add.do" id="btn_add1">添加分组</a></span></c:if>
<ul class="list roleUl">
		<li class="child roleLi ${list_type==2 && empty group_id && empty is_share || addressGroupList.size()==0 && empty group_id && empty is_share ?'cur':''}"  spanId="">默认组（<span class="child_count">${myCount}</span>）</li>
	<c:forEach items="${addressGroupList}" var="item" varStatus="vs">  
		<li class="child${item.id } roleLi ${(vs.index==0&& empty is_share && list_type==1) || (empty is_share && group_id==item.id)?'cur':''}" spanId="${item.id }">
		${item.name }（<span class="child_count">${item.acount}</span>）
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'修改分组') }">
		<a href="addressGroup/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if>
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除分组') }">
		<a href="addressGroup/delete.do?id=${item.id}" class="delete_group">删除</a></c:if>
		</li>
	</c:forEach>
</ul>
<h2 class="inside_group">共享</h2>
<ul class="list roleUl">
		<li  class="roleLi share ${!empty is_share ?'cur':''}"  spanId="">默认组（<span class="child_count">${shareCount}</span>）</li>
</ul>
<script type="text/javascript">
    $(function () {
        Init();
        
    });

    function Init() {
    	
    	$("#list1").html('');
        if ($(".roleUl .cur").length > 0) {
            var $item = $(".roleUl .cur");
            $("#group_id").val($item.attr("spanId"));
            
            $("#spec_form1").submit();
        }
    }
</script>