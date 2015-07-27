<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap">
	    <table class="view_data wc100"> 
	    	<tbody> 
				<tr>
					<th class="w20per">用户名：</td>
					<td>${model.user_name}</td>
				</tr> 
			</tbody>
		</table>
	    <div class="btn_area">
	        <span class="btn btn_base"><input type="button" id="btn_pclose" value="关闭"></span>
	    </div>
	</div>
</gd:PopLayout> 