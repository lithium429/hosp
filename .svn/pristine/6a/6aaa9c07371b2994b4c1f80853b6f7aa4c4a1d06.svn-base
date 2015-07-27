<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addlink="" addr="订餐管理 &gt; 我的订餐记录"></gd:Navgation>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="mealMenu/datalist_my.do"
									data-ajax="true" data-ajax-begin="loadBegin"
									data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
									data-ajax-loading="#loading_img" data-ajax-method="POST"
									data-ajax-mode="replace" data-ajax-update="#data_list"
									novalidate="novalidate">
					        <span class="ml20">订餐查询： </span>
					        <select class="date_lnterval" id="date_lnterval" name="date_lnterval">
					        	<c:forEach items="${dateArray}" var="item" varStatus="vs"> 
					        		<option value="${vs.index }">${item }</option>
					        	</c:forEach>
					        </select>
				     	</form>
				 	</div>
					<div class="data_model wc100 shfw_c" id="data_list">
					   <%@ include file="data_list_my.jsp"%>
				 	</div>
		 		</td>
		 	</tr>
	 	</table>
 	</div>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() {
			
			$("#date_lnterval").change(function(){
				
				$("#spec_form").submit();
			});
		});
		
		
	</script>
	</jsp:body>
</gd:PopLayout>
