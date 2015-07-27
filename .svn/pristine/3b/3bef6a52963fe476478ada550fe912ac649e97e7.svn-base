<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList,'添加') }" addlink="care/add.do" addr="护理天地 &gt; 护理天地"></gd:Navgation>
	<div class="p_rel data_model colum_two clearfix inner_dblist">
		<form id="spec_form1" action="care/type_datalist.do"
				data-ajax="true" data-ajax-begin="loadBegin"
				data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
				data-ajax-loading="#loading_img" data-ajax-method="POST"
				data-ajax-mode="replace" data-ajax-update="#list"
				novalidate="novalidate">
		        <input type="hidden" name="type_id" class="type_id" id="type_id1" value="" />
		        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id }" />
	   </form>
     	<div class="frame_inner_left left_box" id="list">
        </div>
		<div class="rightbox pt10">
		    <table class="wc100">
		        <tr>
		             <td>
						<div class="data_cont_wrap">
							<form id="spec_form" action="care/datalist.do"
										data-ajax="true" data-ajax-begin="loadBegin"
										data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
										data-ajax-loading="#loading_img" data-ajax-method="POST"
										data-ajax-mode="replace" data-ajax-update="#data_list"
										novalidate="novalidate">
								<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
						        <input type="hidden" name="menu_id" id="menu_id1" value="${menu_id}" />
						        <input type="hidden" name="type_id" class="type_id" id="type_id" value="${type_id}" />
						         <div class="mb10 data_cont_wrap_list query_condition">
									<table>
										<tbody>
											<tr>
												<th class="w70">标题/内容</th>					
												<td>
													<input class="inp_t inp_w150" name="keyword" id="keyword" />
												</td>
												<th class="w65">发布时间</th>					
												<td>
													<input id="create_time_min" class="inp_t w160 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'create_time_max\')}'})"
						                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'create_time_max\')}'})"  name="create_time_min"  />
													-
													<input id="create_time_max" class="inp_t w160 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'create_time_min\')}'})"
						                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'create_time_min\')}'})"  name="create_time_max"  />
												</td>
												<td>
													<span class="btn btn_pub">
														<input type="submit" id="btn_search" value="查询" />
													</span><span class="ml8 btn btn_base">
														<a href="care/list.do?menu_id=${menu_id}">重置</a>
													</span>
												</td>
											</tr>
										 </tbody>
								 	 </table>
						        </div>
					     	</form>
					 	</div>
			 		</td>
			 	</tr>
		 	</table>
		 	<div class="data_model wc100 data_list_wrap dt_query rbox_wrap" id="data_list">
			   
		 	</div>
	 	</div>
 	</div>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() {
			
			$(".roleUl .roleLi").live("click", function () {
	            var $this = $(this);
	            $(".roleUl .roleLi").removeClass("cur");
	            $this.addClass("cur");

	            $("#type_id,#type_id1").val($this.attr("spanId"));
	            $("#spec_form").submit(); 
	        });
	        
	    	$("#spec_form1").submit();
	    	
				// 添加
				$('#btn_add1').live('click',function(){
					var url = $(this).attr('href');
					openPage({
						url:url,
						id:'add_page',
						title:'添加分类',
						width:'450px',
						height:'180px'
					});
					return false;
				});
	    	
				// 添加
				$('.update').live('click',function(){
					var url = $(this).attr('href');
					openPage({
						url:url,
						id:'update_page',
						title:'修改分类',
						width:'450px',
						height:'180px'
					});
					return false;
				});
				
				$('#btn_add').live('click',function(){
					var url = $(this).attr('href');
					openPage({
						url:url,
						id:'add_page',
						title:'添加护理天地',
						width:'900px',
						height:'560px'
					});
					return false;
				});
				
				//删除分类
				$('.delete_type').live('click',function(){
					var $this=$(this);
					util.easyAjaxRequest_all("删除分类时，会同步删除该分类下的所有内容，您确定要删除么？",$this,"删除成功","spec_form1");
					return false;
				});
				
				// 修改
				$('.update_lik').live('click',function(){
					var url = $(this).attr('href');
					openPage({
						url:url,
						id:'update_page',
						title:'修改护理天地',
						width:'900px',
						height:'560px'
					});
					return false;
				});

				/*
				$('.view').live('click', function() {
					var url = $(this).attr('href');
					openPage({
						url : url,
						id : 'view_page',
						title : '查看护理天地 ',
						width : '600px',
						height : '300px'
					});
					return false;
				});
				*/

		});
	</script>
	</jsp:body>
</gd:PopLayout>
