<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout>
	<jsp:body> 
		<gd:Navgation addr="系统管理 &gt; 角色权限"></gd:Navgation>
		<div class="p_rel data_model colum_two clearfix">
			<form id="data_form" method="post" action="role/rolepower.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
		        <!-- S left -->
		        <div class="frame_inner_left left_box" id="list">
		        </div>
		        <!-- E left -->
		        <!-- S rightbox -->
		        <div class="frame_right right_box ml100" id="list1">
		        </div>
		        <!-- E rightbox -->
			    <div class="dn">
			        <input type="hidden" id="MenuIds" name="MenuIds" />
			        <input type="hidden" id="MenuActionIds" name="MenuActionIds" />
					<input type="hidden" id="role_id" name="role_id" value="" />
			    </div>
			</form>
		</div>
		<form id="spec_form" action="role/datalist.do"
				data-ajax="true" data-ajax-begin="loadBegin"
				data-ajax-failure="loadFailure" data-ajax-complete="loadComplete"
				data-ajax-loading="#loading_img" data-ajax-method="POST"
				data-ajax-mode="replace" data-ajax-update="#list"
				novalidate="novalidate">
			<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
	        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
	   	</form>
		<form id="spec_form1" action="role/rolePermission.do"
				data-ajax="true" data-ajax-begin="loadBegin"
				data-ajax-failure="loadFailure" data-ajax-complete="loadComplete"
				data-ajax-loading="#loading_img" data-ajax-method="POST"
				data-ajax-mode="replace" data-ajax-update="#list1"
				novalidate="novalidate">
			<input type="hidden" id="roleId" name="roleId" value="" />
	        <input type="hidden" name="menu_id" id="menu_id1" value="${menu_id}" />
	   	</form>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() {
	        $('#spec_form').submit();

	        $.ajaxSetup({
	            cache: false //设置成false将不会从浏览器缓存读取信息
	        });
	        
	        $(".roleUl .roleLi").live("click", function () {
	            var $this = $(this);
	            
	            $this.addClass("cur").siblings("li").removeClass("cur");
	            $("#roleId,#role_id").val($this.attr("spanId"));
	            $("#spec_form1").submit();
	        });
			
			

			$('.update').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'update_page',
					title : '修改动作 ',
					width : '500px',
					height : '200px'
				});
				return false;
			});

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看动作 ',
					width : '500px',
					height : '200px'
				});
				return false;
			});

		});
		
		//添加
		function create() {
	        var $this = $(this);
	        var opts = { url: 'role/add.do',
	            id: 'addRole',
	            title: '添加角色',
	            width: '400px',
	            height: '240px'
	        }
	        openPage(opts);
	        return false;
	    } 
	</script>
	</jsp:body>
</gd:Layout>
