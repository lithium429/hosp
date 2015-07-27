<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout>
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList, '添加申请') }" addlink="leaveInfo/add.do" addr="人力资源  &gt; 考勤管理  &gt; 请假办理"></gd:Navgation>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="leaveInfo/datalist.do"
									data-ajax="true" data-ajax-begin="loadBegin"
									data-ajax-failure="loadFailure" data-ajax-complete="loadComplete"
									data-ajax-method="POST" data-ajax-mode="replace"
									data-ajax-update="#data_list" novalidate="novalidate">
							<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
					        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" /> 
					        <div class="mb10 data_cont_wrap_list query_condition">
								<table>
									<tbody>
										<tr>
											<th>开始时间</th>					
											<td>
												<input id="start_time_min" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'start_time_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'start_time_max\')}'})"  name="start_time_min"  />
												-
												<input id="start_time_max" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'start_time_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'start_time_min\')}'})"  name="start_time_max"  />
											</td>
											<th>结束时间</th>					
											<td>
												<input id="end_time_min" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_time_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_time_max\')}'})"  name="end_time_min"  />
												-
												<input id="end_time_max" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'end_time_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'end_time_min\')}'})"  name="end_time_max"  />
											</td>
											<th>请假类型</th>					
											<td>
												<select class="w86" name="type" >
													<option value="">--请选择--</option>
													<option value="1">病假</option>
													<option value="2">事假</option>
													<option value="3">年假</option>
													<option value="4">其他</option>
												</select>
											</td> 
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="leaveInfo/task/list.do?menu_id=${menu_id}">重置</a>
												</span>
											</td>
										</tr> 
										</tr>
									 </tbody>
							 	 </table>
					        </div>
				     	</form>
				 	</div>
					<div class="data_model wc100 data_list_wrap" id="data_list">
					    <%@ include file="data_list.jsp"%>
				 	</div>
		 		</td>
		 	</tr>
	 	</table>
 	</div> 
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() { 
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '申请请假 ',
					width : '700px',
					height : '300px'
					
				});
				return false;
			});
			
			// 签收成功
			$('.claim').live('click', function(){
				var $this = $(this);
				util.easyAjaxRequest('签收', $this, '签收成功');
				return false;
			});
			
			// 办理
			$('.handle').live('click', function(){
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'handle_page',
					title : '办理',
					width : '500px',
					height : '360px'
				});
				return false;
			}); 
			
			// 调整申请
			$('.modify').live('click', function(){
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'modify_page',
					title : '办理',
					width : '700px',
					height : '360px'
				});
				return false;
			}); 
		});
	</script>
</gd:Layout>
