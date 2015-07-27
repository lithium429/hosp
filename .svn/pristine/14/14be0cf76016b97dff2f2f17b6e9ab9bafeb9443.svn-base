<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList,'添加') }" addlink="${type!=0?'meeting/add.do':'' }" addr="会议管理  &gt; ${type==0?'我的会议':(type==1?'会议申请':'会议审批') }"></gd:Navgation>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="meeting/datalist.do"
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
											<c:choose>
												<c:when test="${type==0 }">
												<th class="w65">会议状态</th>					
												<td>
													<select name="state" class="state w100">
														<option value="">全部</option>
														<option value="1">未开始</option>
														<option value="2">进行中</option>
														<option value="3">已结束</option>
														<option value="4">已取消</option>
													</select>
												</td>
												</c:when>
												<c:otherwise>
												<th class="w65">审核状态</th>					
												<td>
													<select name="verify_state" class="verify_state w100">
														<option value="">全部</option>
														<option value="1">待审核</option>
														<option value="2">审核通过</option>
														<option value="3">审核不通过</option>
													</select>
												</td>
												
												</c:otherwise>
											</c:choose>
											<th class="w70">会议主题</th>					
											<td>
												<input class="inp_t inp_w150" name="subject" id="subject" />
											</td>
											<th class="w80">会议开始时间</th>					
											<td>
												<input id="begin_time_min" class="inp_t w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'begin_time_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'begin_time_max\')}'})"  name="begin_time_min"  />
												-
												<input id="begin_time_max" class="inp_t w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'begin_time_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'begin_time_min\')}'})"  name="begin_time_max"  />
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="meeting/list.do?type=${type }&menu_id=${menu_id}">重置</a>
												</span>
											</td>
										</tr>
										<tr>
											<th class="">会议室</th>					
											<td>
												<select id="room_id" name="room_id" class="w100">
													<option value="">全部</option>
													<c:forEach items="${roomList }" var="item" varStatus="vs">
														<option value="${item.id }">${item.name }</option>
													</c:forEach>
												</select>
											</td>
											<th class="">会议主持人</th>					
											<td>
												<input class="inp_t inp_w150" name="holder" id="holder" />
											</td>
											<th class="">会议结束时间</th>					
											<td>
												<input id="end_time_min" class="inp_t w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_time_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_time_max\')}'})"  name="end_time_min"  />
												-
												<input id="end_time_max" class="inp_t w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'end_time_min\')}'})"
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
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
 	<input id="HiddenIds" type="hidden" />
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() {
			
			//审核
			$(".change1").live('click',function(){
				util.easyAjaxRequest("审核通过",$(this),"审核成功");
				return false;	
			});
			
			//取消
			$(".cancle").live('click',function(){
				util.easyAjaxRequest("取消",$(this),"取消成功");
				return false;	
			});
			

			
			//核算
			$('.change2').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'account_page',
					title : '审核不通过 ',
					width : '580px',
					height : '200px'
				});
				return false;
			});
			
			//批量审核
			$("#batch_change1").live('click',function(){
				util.easyAjaxBatchRequestFiter("审核通过",$(this),'1',"审核成功");
				return false;	
			});
			
			//批量删除
			$("#batch_delete1").live('click',function(){
				util.easyAjaxBatchRequestFiter("批量删除",$(this),'1',"批量删除成功");
				return false;	
			});
			
			// ajax批量核算
		    $('#batch_change2').live('click',function () {
		        var idArray = [],$this = $(this),flag=true;
		        $("[name='id']:checked").each(function () { 
		            if($(this).attr("key")==1)
	            	{
		            	idArray.push($(this).val());
	            	}
		        });
		        
		        if (idArray.length === 0) {
		            informationMsg('请选择要批量审核不通过的信息！');
		        }
		        else{
		        	
		            art.dialog.confirm('您确定要将选中的都批量审核不通过?', function () {
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
			
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '添加会议 ',
					width : '950px',
					height : '500px'
					
				});
				return false;
			});

			$('.update').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'update_page',
					title : '修改会议 ',
					width : '950px',
					height : '500px'
				});
				return false;
			});

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看会议 ',
					width : '800px',
					height : '400px'
				});
				return false;
			});

		});
	</script>
	</jsp:body>
</gd:PopLayout>
