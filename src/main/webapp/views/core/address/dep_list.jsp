<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<h2 class="inside_group">部门科室（<span id="total_count">${departmentList.size()}</span>）</h2>
<ul class="list roleUl">
	<c:forEach items="${departmentList}" var="item" varStatus="vs">  
		<li class="child${item.id } roleLi ${(vs.index==0 && empty dept_id) || dept_id==item.id ?'cur':''}" spanId="${item.id }">
		${item.name }（<span class="child_count">${item.acount}</span>）
		</li>
	</c:forEach>
</ul>
<script type="text/javascript">
    $(function () {
        Init();
        
    });

    function Init() {
    	
        if ($(".roleUl .cur").length > 0) {
            var $item = $(".roleUl .cur");
            $("#dept_id").val($item.attr("spanId"));
            $("#group_id,#is_share").val('');
            $("#spec_form1").submit();
        }
    }
</script>