<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList,'添加') }" addlink="staffContract/add.do" addr="人力资源  &gt; 人事信息  &gt; 人事合同"></gd:Navgation>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="staffContract/datalist.do"
									data-ajax="true" data-ajax-begin="loadBegin"
									data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
									data-ajax-loading="#loading_img" data-ajax-method="POST"
									data-ajax-mode="replace" data-ajax-update="#data_list"
									novalidate="novalidate">
							<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
					        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
					        <input type="hidden" name="states" id="states" value="" />
					        <div class="mb10 data_cont_wrap_list query_condition">
								<table>
									<tbody>
										<tr>
											<td colspan="4">
												<label><input type="checkbox" class="state" value="1" name="state" />未开始</label>
												<label class="ml8"><input class="state" type="checkbox" value="2" name="state" />执行中</label>
												<label class="ml8"><input class="state" type="checkbox" value="4" name="state" />已解除</label>
												<label class="ml8"><input class="state" type="checkbox" value="3" name="state" />已终止</label>
											</td>
											<th class="w60">生效日期</th>					
											<td>
												<input id="valid_date_min" class="inp_t inp_w130 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'valid_date_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'valid_date_max\')}'})"  name="valid_date_min"  />
												-
												<input id="valid_date_max" class="inp_t inp_w130 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'valid_date_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'valid_date_min\')}'})"  name="valid_date_max"  />
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="staffContract/list.do?menu_id=${menu_id}">重置</a>
												</span>
											</td>
										</tr>
										<tr>
											<th class="w35">员工</th>					
											<td>
												<input class="inp_t" name="name" id="name" placeholder="请输入员工姓名" />
											</td>
											<th class="w55">合同类型</th>					
											<td>
												<select id="type_id" name="type_id" class="w100">
													<option value="">全部</option>
													<c:forEach items="${typeList }" var="item" varStatus="vs">
														<option value="${item.id }">${item.name }</option>
													</c:forEach>
												</select>
											</td>
											<th class="w60">终止日期</th>					
											<td>
												<input id="end_date_min" class="inp_t inp_w130 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_date_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_date_max\')}'})"  name="end_date_min"  />
												-
												<input id="end_date_max" class="inp_t inp_w130 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'end_date_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'end_date_min\')}'})"  name="end_date_max"  />
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
			$(".state").change(function(){
				var $this=$(this),v="";
				$(".state:checked").each(function(){
					var $item=$(this);
					if(v==""){
						v=$item.val();
					}else{
						v+=","+$item.val();
					}
				});
				$("#states").val(v);
			});
			
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '添加人事合同 ',
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
					title : '修改人事合同 ',
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
					title : '查看人事合同 ',
					width : '900px',
					height : '450px'
				});
				return false;
			});

		});
	</script>
	</jsp:body>
</gd:PopLayout>
