<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<c:choose>
		 <c:when test="${type==0 }"><c:set var="type_name" value="收件箱" /></c:when>
	 	 <c:when test="${type==1 }"><c:set var="type_name" value="发件箱" /></c:when>
	     <c:when test="${type==2 }"><c:set var="type_name" value="草稿箱" /></c:when>
	     <c:when test="${type==3 }"><c:set var="type_name" value="回收站" /></c:when>
	</c:choose>
	<div class="mb10 crumbs">
		<span class="icon ico_place"></span><b>您当前的位置：</b>内部邮件 &gt; ${type_name}
		<c:if test="${gdf:judgeRoleMenu(roleMenuList,'发送邮件') }">
		<div class="model_top_fun">
			<span class="btn btn_pub"><a href="email/send.do?type=${type}" id="btn_add">发送邮件</a></span>
		</div></c:if>
	</div>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="email/datalist.do"
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
												<c:when test="${type==0}">
												<th class="w55">发件人</th>					
												<td>
													<input class="inp_t inp_w150" name="sender_name" id="sender_name" />
												</td>
												</c:when>
												<c:otherwise>
												<th class="w55">收件人</th>					
												<td>
													<input class="inp_t inp_w150" name="receiver_name" id="receiver_name" />
												</td>
												</c:otherwise>
											</c:choose>				
											<th class="w55">主题</th>					
											<td>
												<input class="inp_t inp_w150" name="subject" id="subject" />
											</td>
											<th class="w60">发送时间</th>					
											<td>
												<input id="create_time_min" class="inp_t inp_w130 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'create_time_max\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'create_time_max\')}'})"  name="create_time_min"  />
												-
												<input id="create_time_max" class="inp_t inp_w130 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'create_time_min\')}'})"
					                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'create_time_min\')}'})"  name="create_time_max"  />
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="email/list.do?type=${type }&menu_id=${menu_id}">重置</a>
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
			
			//彻底删除
			$('#batch_delete1').live('click', function() {
				util.easyAjaxBatchRequest('彻底删除',$(this),'','',"彻底删除成功")
				return false;
			}); 
			
			//标为已读
			$('#read').live('click', function() {
				util.easyAjaxBatchRequest('标为已读',$(this),'','',"标为已读成功")
				return false;
			}); 
			
			 $('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '写邮件 ',
					width : '90%',
					height : '80%'
					
				});
				return false;
			}); 

			 //回复
			$('.reply').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'reply_page',
					title : '回复邮件 ',
					width : '90%',
					height : '80%'
				});
				return false;
			});
			
			 //转发
			$('.forward').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'reply_page',
					title : '转发邮件 ',
					width : '90%',
					height : '80%'
				});
				return false;
			});

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看邮件 ',
					width : '65%',
					height : '70%'
				});
				return false;
			});

		});
	</script>
	</jsp:body>
</gd:PopLayout>
