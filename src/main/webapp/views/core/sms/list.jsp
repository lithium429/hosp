<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<div class="mb10 crumbs">
		<span class="icon ico_place"></span><b>您当前的位置：</b>手机短信  &gt; ${type==0?'我的短信':'短信管理' }
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'发送短信') }">
		<div class="model_top_fun">
			<span class="btn btn_pub"><a href="sms/send.do?type=${type}&is_pop=true" id="btn_add">发送短信</a></span>
		</div></c:if>
	</div>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="sms/datalist.do"
									data-ajax="true" data-ajax-begin="loadBegin"
									data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
									data-ajax-loading="#loading_img" data-ajax-method="POST"
									data-ajax-mode="replace" data-ajax-update="#data_list"
									novalidate="novalidate">
							<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
					        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
					        <input type="hidden" name="type" id="type" value="${type}" />
					         <div class="mb10 data_cont_wrap_list query_condition">
								<table>
									<tbody>
										<tr>					
											<td>
												<select id="date_type"  name="date_type" class="w100">
													<option value="">全部</option>
													<option value="1">今天发送</option>
													<option value="2">本周发送</option>
													<option value="3">本月发送</option>
													<option value="4">本年发送</option>
												</select>
											</td>
											<th class="w55">短信内容</th>					
											<td>
												<input class="inp_t inp_w150" name="content" id="content" />
											</td>
											<th class="w60">发送时间</th>					
											<td>
												<input id="create_time_min" class="inp_t inp_w130 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'create_time_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'create_time_max\')}'})"  name="create_time_min"  />
												-
												<input id="create_time_max" class="inp_t inp_w130 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'create_time_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'create_time_min\')}'})"  name="create_time_max"  />
											</td>
											<th class="w55">发信人</th>					
											<td>
												<input class="inp_t inp_w150" name="sender_name" id="sender_name" />
											</td>
											<th class="w60">状态</th>					
											<td>
												<select id="state" name="state" class="w100">
													<option value="">全部</option>
													<option value="1">成功</option>
													<option value="2">失败</option>
												</select>
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="sms/list.do?type=${type }&menu_id=${menu_id}">重置</a>
												</span>
											</td>
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
			//重新发送
			$('.send_again').live('click', function() {
				util.easyAjaxRequest('重新发送',$(this),"重新发送成功")
				return false;
			}); 
			
			//重新发送
			$('#bath_send_again').live('click', function() {
				util.easyAjaxBatchRequest('重新发送',$(this),'','',"重新发送成功")
				return false;
			}); 
			
			 $('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '发送短信 ',
					width : '90%',
					height : '80%'
					
				});
				return false;
			}); 

			$('.update').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'update_page',
					title : '修改短信模板 ',
					width : '600px',
					height : '200px'
				});
				return false;
			});

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看短信 ',
					width : '500px',
					height : '220px'
				});
				return false;
			});

		});
	</script>
	</jsp:body>
</gd:PopLayout>
