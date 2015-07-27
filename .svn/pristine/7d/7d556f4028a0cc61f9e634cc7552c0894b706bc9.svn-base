<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addlink="" addr="图书管理  &gt; ${type==0?'我的图书':'借阅明细' }"></gd:Navgation>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="bookBorrowRecord/datalist.do"
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
												<label><input type="radio" value="0" name="borrow_state" checked="checked" />全部</label>
												<label class="ml8"><input type="radio" value="1" name="borrow_state" />未领取</label>
												<label class="ml8"><input type="radio" value="2" name="borrow_state" />已领取</label>
												<label class="ml8"><input type="radio" value="3" name="borrow_state" />已归还</label>
											</td>
											<th class="w55">书籍名称</th>					
											<td>
												<input class="inp_t inp_w150" name="name" id="name" />
											</td>
											<th class="w55">作者</th>					
											<td>
												<input class="inp_t inp_w150" name="author" id="author" />
											</td>
											<th class="w55">类型</th>					
											<td>
												<select id="type_id" name="type_id" class="w100">
													<option value="">全部</option>
													<c:forEach items="${typeList }" var="item" varStatus="vs">
														<option value="${item.id }">${item.name }</option>
													</c:forEach>
												</select>
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="bookBorrowRecord/list.do?type=${type }&menu_id=${menu_id}">重置</a>
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
			
			//领取；归还
			$("#batch_change,#batch_change1").live('click',function(){
				var key="1",msg="领取";
				if($(this).hasClass("returnBack"))
				{
					key="2";
					msg="归还";
				}
				
				util.easyAjaxBatchRequestFiterMore(msg,$(this),key,msg+"成功");
				return false;	
			});
			
			//领取；归还
			$(".change").live('click',function(){
				var msg="领取";
				if($(this).hasClass("returnBack"))
				{
					msg="归还";
				}
				util.easyAjaxRequest(msg,$(this),msg+"成功");
				return false;	
			});

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看 '+$("#type").val()==0?"我的图书":"借阅明细",
					width : '600px',
					height : '300px'
				});
				return false;
			});
			

		});
	</script>
	</jsp:body>
</gd:PopLayout>
