<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addlink="" addr="督办流程管理 &gt; 督办流程管理"></gd:Navgation>
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
											<th class="w70">当前责任人</th>					
											<td>
												<input class="inp_t inp_w150" name="user_name" id="user_name" />
											</td>
											<th class="w55">办结日期</th>					
											<td>
												<input id="end_date_min" class="inp_t w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_date_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_date_max\')}'})"  name="end_date_min"  />
												-
												<input id="end_date_max" class="inp_t w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'end_date_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'end_date_min\')}'})"  name="end_date_max"  />
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="handlingProcess/list.do?menu_id=${menu_id}">重置</a>
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
			
			//关闭
			$("#batch_close").live('click',function(){
				util.easyAjaxBatchRequestFiter("关闭",$(this),'2',"关闭成功");
				return false;	
			});
			
			//关闭
			$('.close').live('click', function() {
				util.easyAjaxRequest('关闭',$(this),"关闭成功")
				return false;
			}); 

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看督办流程 ',
					width : '800px',
					height : '350px'
				});
				return false;
			});

		});
	</script>
	</jsp:body>
</gd:PopLayout>
