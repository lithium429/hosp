<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList,'添加')}" addText="创建督办流程" addlink="handlingProcess/add.do" addr="我的督办流程  &gt; 我创建的督办流程"></gd:Navgation>
	<div class="data_model"> 
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="handlingProcess/datalist.do"
									data-ajax="true" data-ajax-begin="loadBegin"
									data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
									data-ajax-loading="#loading_img" data-ajax-method="POST"
									data-ajax-mode="replace" data-ajax-update="#data_list"
									novalidate="novalidate">
							<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
					        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
					        <input type="hidden" name="type" id="type" value="${type }" />
					        <div class="mb10 data_cont_wrap_list query_condition">
								<table>
									<tbody>
										<tr>
											<td>
												<label><input type="radio" value="0" name="state" checked="checked" />全部</label>
												<label class="ml8"><input type="radio" value="1" name="state" />草稿</label>
												<label class="ml8"><input type="radio" value="2" name="state" />流转中</label>
												<label class="ml8"><input type="radio" value="3" name="state" />已关闭</label>
											</td>
											<th class="w55">督办事宜</th>					
											<td>
												<input class="inp_t inp_w150" name="keyword" id="keyword" />
											</td>
											<th class="w65">当前责任人</th>					
											<td>
												<input class="inp_t inp_w150" name="user_name" id="user_name" />
											</td>
											<th class="w55">创建日期</th>					
											<td>
												<input id="create_time_min" class="inp_t w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'create_time_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'create_time_max\')}'})"  name="create_time_min"  />
												-
												<input id="create_time_max" class="inp_t w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'create_time_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'create_time_min\')}'})"  name="create_time_max"  />
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="handlingProcess/list.do?type=${type }&menu_id=${menu_id}">重置</a>
												</span>
											</td>
										</tr>
									 </tbody>
							 	 </table>
					        </div>
				     	</form>
				 	</div>
					<div class="data_model wc100 data_list_wrap" id="data_list">
					    <%@ include file="data_list_c.jsp"%>
				 	</div>
		 		</td>
		 	</tr>
	 	</table>
 	</div>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() {
			
			//批量删除
			$("#batch_delete1").live('click',function(){
				util.easyAjaxBatchRequestFiter("批量删除",$(this),'1,3',"批量删除成功");
				return false;	
			});
			
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '添加督办流程 ',
					width : '800px',
					height : '300px'
					
				});
				return false;
			});

			$('.update').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'update_page',
					title : '修改督办流程 ',
					width : '800px',
					height : '300px'
				});
				return false;
			});
			
			$('.haddle').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'update_page',
					title : '处理督办流程 ',
					width : '800px',
					height : '400px'
				});
				return false;
			});

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看督办流程 ',
					width : '800px',
					height : '380px'
				});
				return false;
			});

		});
	</script>
	</jsp:body>
</gd:PopLayout>
