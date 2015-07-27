<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout> 
	<div class="mb10 crumbs">
		<span class="icon ico_place"></span><b>您当前的位置：</b>论坛管理 &gt; 板块管理
		<div class="model_top_fun" id="top_btn_div">
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'添加') }">
				<span class="btn btn_pub"><a href="forumPlate/add.do?layer=1" id="btn_add">添加</a></span>
			</c:if>
		</div> 
	</div>
	<div class="data_model"> 
		<form id="spec_form" action="forumPlate/datalist.do" data-ajax="true" data-ajax-begin="loadBegin" data-ajax-failure="loadFailure" data-ajax-failure="loadComplete" data-ajax-loading="#loading_img" data-ajax-method="POST" data-ajax-mode="replace" data-ajax-update="#data_list" novalidate="novalidate"> 
			<input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" /> 
     	</form>
     	<div class="data_model wc100 data_list_wrap" id="data_list"> 
     		<%@ include file="data_list.jsp"%>
	 	</div> 
 	</div> 
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" />
	 
	<script type="text/javascript" src="static/js/index.js"></script> 
	<script type="text/javascript" src="static/js/flexigrid-1.1/js/flexigrid.js"></script> 
	<script type="text/javascript">  
		$(function(){
			// 新建板块
			$('#btn_add').live('click',function(){ 
				var url = $(this).attr('href');
				openPage({
					url: url,
					id: 'add_page',
					title: '新建板块',
					width: '650px',
					height: '300px'
				});
				return false;
			});
			
			// 修改
			$('.update').live('click',function(){ 
				var url = $(this).attr('href');
				openPage({
					url: url,
					id: 'update_page',
					title: '修改板块',
					width: '650px',
					height: '300px'
				});
				return false;
			}); 
			
			// 查看
			$('.view').live('click',function(){ 
				var url = $(this).attr('href');
				openPage({
					url: url,
					id: 'view_page',
					title: '查看板块',
					width: '650px',
					height: '300px'
				});
				return false;
			});  
		}); 
	</script>
</gd:Layout>
