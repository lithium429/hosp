<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<h2 class="inside_group">分类列表</h2><c:if test="${gdf:judgeRoleMenu(roleMenuList,'添加分类')}"><span class="p_abs abs_rt btn btn_pub" style="top:4px;"><a href="careType/add.do" id="btn_add1">添加分类</a></span></c:if> 
<ul class="list roleUl">
	<c:forEach items="${typeList}" var="item" varStatus="vs">  
		<li class="child${item.id } roleLi ${vs.index==0 && empty type_id  || type_id==item.id?'cur':''}" spanId="${item.id }">
		${item.name }
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'修改分类')}"><a href="careType/update.do?id=${item.id}" class="update">修改</a>&nbsp;</c:if> 
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除分类')}"><a href="careType/delete.do?id=${item.id}" class="delete_type">删除</a></c:if> 
		</li>
	</c:forEach>
</ul>
<script type="text/javascript">
    $(function () {
        Init();
        
    });

    function Init() {
    	$("#list1").html('');
        if ($(".roleUl .cur").length > 0) {
            var $item = $(".roleUl .cur");
            $(".type_id").val($item.attr("spanId"));
            
            $("#spec_form").submit();
        }else{
        	 var $item =$(".roleUl li:eq(0)");
        	 $item.addClass("cur");
        	 $(".type_id").val($item.attr("spanId"));
             
             $("#spec_form").submit();
        }
    }
</script>