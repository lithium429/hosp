<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList,'添加') }" addlink="rewardPunishment/add.do" addr="人力资源  &gt; 人事信息  &gt; 奖惩记录"></gd:Navgation>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="rewardPunishment/datalist.do"
									data-ajax="true" data-ajax-begin="loadBegin"
									data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
									data-ajax-loading="#loading_img" data-ajax-method="POST"
									data-ajax-mode="replace" data-ajax-update="#data_list"
									novalidate="novalidate">
							<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
					        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
					        <input type="hidden" name="types" id="types" value="" />
					        <div class="mb10 data_cont_wrap_list query_condition">
								<table>
									<tbody>
										<tr>
											<td colspan="2">
												<label><input type="checkbox" class="type" value="1" name="type" />奖励</label>
												<label class="ml8"><input class="type" type="checkbox" value="2" name="type" />惩罚</label>
											</td>
											<th class="w55">授予单位</th>					
											<td>
												<input class="inp_t inp_w150" name="unit" id="unit" placeholder="请输入授予单位" />
											</td>
											<th class="w60">奖惩日期</th>					
											<td>
												<input id="rp_date_min" class="inp_t inp_w130 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'rp_date_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'rp_date_max\')}'})"  name="rp_date_min"  />
												-
												<input id="rp_date_max" class="inp_t inp_w130 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'rp_date_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'rp_date_min\')}'})"  name="rp_date_max"  />
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="rewardPunishment/list.do?menu_id=${menu_id}">重置</a>
												</span>
											</td>
										</tr>
										<tr>
											<th class="w35">员工</th>					
											<td>
												<input class="inp_t inp_w150" name="name" id="name" placeholder="请输入员工姓名" />
											</td>
											<th class="w55">奖惩名目</th>					
											<td>
												<input class="inp_t inp_w150" name="item_name" id="item_name" placeholder="请输入奖惩名目" />
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
			//合同状态change用于查询
			$(".type").change(function(){
				var $this=$(this),v="";
				$(".type:checked").each(function(){
					var $item=$(this);
					if(v==""){
						v=$item.val();
					}else{
						v+=","+$item.val();
					}
				});
				$("#types").val(v);
			});
			
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '添加奖惩记录 ',
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
					title : '修改奖惩记录 ',
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
					title : '查看奖惩记录 ',
					width : '900px',
					height : '450px'
				});
				return false;
			});

		});
	</script>
	</jsp:body>
</gd:PopLayout>
