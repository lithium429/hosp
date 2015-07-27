<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<c:if test="${!is_home }">
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList,'添加')}" addlink="announcement/add.do" addr="系统管理  &gt; 公告管理"></gd:Navgation></c:if>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="announcement/datalist.do"
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
											<th class="w55">公告</th>					
											<td>
												<input class="inp_t inp_w150" name="keyword" id="keyword" />
											</td>
											<th class="w60">生效时间</th>					
											<td>
												<input id="valid_date_min" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'valid_date_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'valid_date_max\')}'})"  name="valid_date_min"  />
												-
												<input id="valid_date_max" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'valid_date_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'valid_date_min\')}'})"  name="valid_date_max"  />
											</td>
											
											<th class="w60">范围</th>					
											<td>
												<select id="dept_id" multiple="multiple" name="dept_id" class="w100">
													<option value="">全部</option>
													<c:forEach items="${deptList }" var="item" varStatus="vs">
														<option value="${item.id}">${gdf:buildTreeName(item.name, item.layer)}</option>
													</c:forEach>
												</select>
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="announcement/list.do?menu_id=${menu_id}&is_home=${is_home}">重置</a>
												</span>
											</td>
										</tr>
										<tr>
											<th class="w60">类型</th>					
											<td>
												<select id="type_id" name="type_id" class="w100">
													<option value="">全部</option>
													<c:forEach items="${typeList }" var="item" varStatus="vs">
														<option value="${item.id }">${item.name }</option>
													</c:forEach>
												</select>
											</td>
											<th class="w60">终止时间</th>					
											<td>
												<input id="end_date_min" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_date_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_date_max\')}'})"  name="end_date_min"  />
												-
												<input id="end_date_max" class="inp_t inp_w150 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'end_date_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'end_date_min\')}'})"  name="end_date_max"  />
											</td>
											<th class="w60">状态</th>					
											<td>
												<select id="state" name="state" class="w100">
													<option value="">全部</option>
													<option value="1">未发布</option>
													<option value="2">生效</option>
													<option value="3">终止</option>
												</select>
											</td>
										</tr>
									 </tbody>
							 	 </table>
					        </div>
				     	</form>
				 	</div>
					<div class="data_model wc100 data_list_wrap" id="data_list">
					<%-- <c:choose>
						<c:when test="${is_home }"><%@ include file="data_list_h.jsp"%></c:when>
						<c:otherwise><%@ include file="data_list.jsp"%></c:otherwise>
					</c:choose> --%>
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
			
			//生效
			$(".effect").live('click',function(){
				util.easyAjaxRequest("生效",$(this),"生效成功");
				return false;	
			});
			
			//终止
			$(".stop").live('click',function(){
				util.easyAjaxRequest("终止",$(this),"终止成功");
				return false;	
			});
			
			//生效
			$("#effect").live('click',function(){
				util.easyAjaxBatchRequestFiter("生效",$(this),'f',"生效成功");
				return false;	
			});
			
			//终止
			$("#stop").live('click',function(){
				util.easyAjaxBatchRequestFiter("终止",$(this),'s',"终止成功");
				return false;	
			});
			
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '添加公告 ',
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
					title : '修改公告',
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
					title : '查看公告',
					width : '800px',
					height : '300px'
				});
				return false;
			});

			$("#dept_id").multiSelect({ oneOrMoreSelected: '*', optGroupSelectable: true });
			$('#dept_id').blur(checkUserInfos);
		});
	    
	    function checkUserInfos() {
		    var userInfoObj = $('#dept_id'),
		    values = userInfoObj.selectedValuesString();
		    $("#dept_ids").val(values);
		}
	</script>
	</jsp:body>
</gd:PopLayout>
