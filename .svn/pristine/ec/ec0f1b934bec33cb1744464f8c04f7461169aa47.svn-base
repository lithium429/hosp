<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList,'添加') }" addlink="leave/add.do" addr="人力资源  &gt; 考勤管理  &gt; ${type_key==0?'请假登记':'请假审批' }"></gd:Navgation>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="leave/datalist.do"
									data-ajax="true" data-ajax-begin="loadBegin"
									data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
									data-ajax-loading="#loading_img" data-ajax-method="POST"
									data-ajax-mode="replace" data-ajax-update="#data_list"
									novalidate="novalidate">
							<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
					        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
					        <input type="hidden" name="type_key" id="type_key" value="${type_key }" />
					        <input type="hidden" name="verify_states" id="verify_states" value="" />
					        <div class="mb10 data_cont_wrap_list query_condition">
								<table>
									<tbody>
										<tr>
											<td colspan="4">
												<label><input type="checkbox" class="verify_state" value="1" name="verify_state" />待审批</label>
												<label class="ml8"><input class="verify_state" type="checkbox" value="2" name="verify_state" />审批通过</label>
												<label class="ml8"><input class="verify_state" type="checkbox" value="3" name="verify_state" />审批不通过</label>
											</td>
											<th class="">开始时间</th>					
											<td colspan="">
												<input id="start_time_min" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'start_time_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'start_time_max\')}'})"  name="start_time_min"  />
												-
												<input id="start_time_max" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'start_time_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'start_time_min\')}'})"  name="start_time_max"  />
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="leave/list.do?menu_id=${menu_id}&type_key=${type_key}">重置</a>
												</span>
											</td>
										</tr>
										<tr>
											<th class="">请假类型</th>					
											<td>
												<select class="w86" name="type" >
													<option value="">--请选择--</option>
													<option value="1">病假</option>
													<option value="2">事假</option>
													<option value="3">年假</option>
													<option value="4">其他</option>
												</select>
											</td>	
											<th>${type_key==0?'审批人员':'请假人员' }</th>
											<td>
												<c:choose>
													<c:when test="${type_key==0 }">
														<input class="inp_t inp_w150" name="verify_user_name" id="verify_user_name" placeholder="请输入系统用户" />
													</c:when>
													<c:otherwise>
														<input class="inp_t inp_w150" name="staff_name" id="staff_name" placeholder="请输入员工姓名" />
													</c:otherwise>
												</c:choose>
											</td>
											<th class="">结束时间</th>					
											<td>
												<input id="end_time_min" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_time_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_time_max\')}'})"  name="end_time_min"  />
												-
												<input id="end_time_max" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'end_time_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'end_time_min\')}'})"  name="end_time_max"  />
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
 	<input id="HiddenIds" type="hidden" />
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() {
			//合同状态change用于查询
			$(".verify_state").change(function(){
				var $this=$(this),v="";
				$(".verify_state:checked").each(function(){
					var $item=$(this);
					if(v==""){
						v=$item.val();
					}else{
						v+=","+$item.val();
					}
				});
				$("#verify_states").val(v);
			});
			
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '添加请假登记 ',
					width : '900px',
					height : '300px'
					
				});
				return false;
			});

			$('.update').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'update_page',
					title : '修改请假登记',
					width : '900px',
					height : '300px'
				});
				return false;
			});

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看请假登记 ',
					width : '900px',
					height : '320px'
				});
				return false;
			});
			
			//审核
			$("#batch_change1").live('click',function(){
				util.easyAjaxBatchRequestFiterMore("批量审批",$(this),'1',"批量审批成功");
				return false;	
			});
			
			//批量删除
			$("#batch_delete1").live('click',function(){
				util.easyAjaxBatchRequestFiter("批量删除",$(this),'1',"批量删除成功");
				return false;	
			});
			
			// ajax批量审批
		    $('#batch_change2').live('click',function () {
		        var idArray = [],$this = $(this),flag=true;
		        $("[name='id']:checked").each(function () { 
		            if($(this).attr("key")==1 && "1".indexOf($(this).attr("key"))>=0)
	            	{
		            	idArray.push($(this).val());
		          	    
	            	}
		        });
		        if (idArray.length === 0) {
		            informationMsg('请选择要批量审批不通过的信息！');
		        }
		        else{
		        	
		            art.dialog.confirm('您确定要将选中的都批量审批不通过?', function () {
		            	$("#HiddenIds").val(idArray.join(','));
		            	openPage({
							url : $this.attr("href"),
							id : 'return_page',
							title : '批量审核不通过 ',
							width : '580px',
							height : '200px'
						});
		            });
		        }
		        return false;
		    });
			
			//审核
			$(".change1").live('click',function(){
				util.easyAjaxRequest("审批",$(this),"审批成功");
				return false;	
			});
			
			//核算
			$('.change2').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'account_page',
					title : '审批不通过 ',
					width : '580px',
					height : '200px'
				});
				return false;
			});

		});
	</script>
	</jsp:body>
</gd:PopLayout>
