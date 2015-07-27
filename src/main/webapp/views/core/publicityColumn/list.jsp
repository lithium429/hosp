<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<c:if test="${!is_home }">
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList,'添加')}" addlink="publicityColumn/add.do" addr="系统管理  &gt; 公示栏管理"></gd:Navgation></c:if>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="publicityColumn/datalist.do"
									data-ajax="true" data-ajax-begin="loadBegin"
									data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
									data-ajax-loading="#loading_img" data-ajax-method="POST"
									data-ajax-mode="replace" data-ajax-update="#data_list"
									novalidate="novalidate">
							<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
					        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
							<input type="hidden" name="dept_ids" id="dept_ids" value="" />
							<input type="hidden" name="is_home" id="is_home" value="${is_home }" />
					         <div class="mb10 data_cont_wrap_list query_condition">
								<table>
									<tbody>
										<tr>
											<th class="w55">标题</th>					
											<td>
												<input class="inp_t inp_w150" name="keyword" id="keyword" />
											</td> 
											<th class="w60">类型</th>					
											<td>
												<select id="type" name="type" class="w100">
													<option value="">全部</option>
													<option value="1">院务公开栏</option>
													<option value="2">党务公开栏</option>
													<option value="3">奖惩公示栏</option>
													<option value="4">其它</option>
												</select>
											</td>  
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="publicityColumn/list.do?menu_id=${menu_id}&is_home=${is_home}">重置</a>
												</span>
											</td>
										</tr> 
									 </tbody>
							 	 </table>
					        </div>
				     	</form>
				 	</div>
					<div class="data_model wc100 data_list_wrap" id="data_list">
				 
				 	</div>
		 		</td>
		 	</tr>
	 	</table>
 	</div>
	<script type="text/javascript" src="static/js/flexigrid-1.1/js/flexigrid.js"></script> 
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() {
			
			$("#spec_form").submit();
			//排序
			$(".move_up,.move_down,.move_top").live('click',function(){
				util.easyAjaxRequest(null,$(this),"排序成功");
				return false;	
			}); 
			
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '添加公示栏 ',
					width : '900px',
					height : '500px'
					
				});
				return false;
			});

			$('.update').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'update_page',
					title : '修改公示栏',
					width : '900px',
					height : '500px'
				});
				return false;
			});

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看公示栏',
					width : '900px',
					height : '500px'
				});
				return false;
			}); 
		}); 
	</script>
	</jsp:body>
</gd:PopLayout>
