<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList,'添加') }" addlink="${type==0?'bookBorrow/add.do':'' }" addr="图书管理  &gt; ${type==0?'借阅申请':'借阅审批' }"></gd:Navgation>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="bookBorrow/datalist.do"
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
												<label><input type="radio" value="0" name="verify_state" checked="checked" />全部</label>
												<label class="ml8"><input type="radio" value="1" name="verify_state" />待审核</label>
												<label class="ml8"><input type="radio" value="2" name="verify_state" />通过</label>
												<label class="ml8"><input type="radio" value="3" name="verify_state" />不通过</label>
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
													<a href="bookBorrow/list.do?type=${type }&menu_id=${menu_id}">重置</a>
												</span>
											</td>
										</tr>
									 </tbody>
							 	 </table>
					        </div>
				     	</form>
				 	</div>
					<div class="data_model wc100 data_list_wrap" id="data_list">
					   
				 	</div>
		 		</td>
		 	</tr>
	 	</table>
 	</div>
 	<input id="HiddenIds" type="hidden" />
 	<input id="HiddenIds1" type="hidden" />
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#spec_form").submit();
			
			//批量删除
			$("#batch_delete1").live('click',function(){
				util.easyAjaxBatchRequestFiter("批量删除",$(this),'1,3',"批量删除成功");
				return false;	
			});
			
			//审核
			$("#batch_change1").live('click',function(){
				util.easyAjaxBatchRequestFiterMoreRepeat("批量审核",$(this),'1',"批量审核成功","您选择的信息中含有重复的书籍信息！");
				return false;	
			});
			

			
			// ajax批量审核
		    $('#batch_change2').live('click',function () {
		        var idArray = [],idArray1 = [],$this = $(this),flag=true;
		        $("[name='id']:checked").each(function () { 
		            if($(this).attr("key")==1 && "1".indexOf($(this).attr("key"))>=0)
	            	{
		            	idArray.push($(this).val());
		          	    idArray1.push($(this).attr("key_id"));
		          	    
	            	}
		        });
		        if (idArray.length === 0) {
		            informationMsg('请选择要批量审核不通过的信息！');
		        }
		        else{
		        	
		            art.dialog.confirm('您确定要将选中的都批量审核不通过?', function () {
		            	$("#HiddenIds").val(idArray.join(','));
		            	$("#HiddenIds1").val(idArray1.join(','));
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
				util.easyAjaxRequest("审核",$(this),"审核成功");
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
			
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '添加借阅申请 ',
					width : '600px',
					height : '400px'
					
				});
				return false;
			});

			$('.update').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'update_page',
					title : '修改借阅申请 ',
					width : '500px',
					height : '300px'
				});
				return false;
			});

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看借阅申请 ',
					width : '600px',
					height : '300px'
				});
				return false;
			});

		});
	</script>
	</jsp:body>
</gd:PopLayout>
