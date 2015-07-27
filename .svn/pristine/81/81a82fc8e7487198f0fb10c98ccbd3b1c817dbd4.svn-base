<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList,'添加') }" addlink="${my_type==1?'advice/add.do':'' }" addr="院长书记信箱  &gt; ${my_type==1?'我的信件':'' }"></gd:Navgation>
	<div class="data_model">
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="advice/datalist.do"
									data-ajax="true" data-ajax-begin="loadBegin"
									data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
									data-ajax-loading="#loading_img" data-ajax-method="POST"
									data-ajax-mode="replace" data-ajax-update="#data_list"
									novalidate="novalidate">
							<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
					        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
					        <input type="hidden" name="my_type" id="my_type" value="${my_type}" />
					        <div class="mb10 data_cont_wrap_list query_condition">
								<table>
									<tbody>
										<tr>
										<th class="w55">标题</th>					
										<td>
											<input class="inp_t inp_w150" name="title" id="title" />
										</td>
										<c:if test="${my_type==0 }">
											<th class="w55">写信人</th>					
											<td>
												<input class="inp_t inp_w150" name="user_name" id="user_name" />
											</td></c:if>
											<th class="w55">信件类型</th>					
											<td>
												<select name="type" class="type">
													<option value="">--请选择--</option>
													<option value="1">申诉</option>
													<option value="2">求决</option>
													<option value="3">举报投诉</option>
													<option value="4">反映建议</option>
													<option value="5">其它咨询</option>
												</select>
											</td>
											<th class="w55">处理情况</th>					
											<td>
												<select name="state" class="state">
													<option value="">--请选择--</option>
													<option value="1">未处理</option>
													<option value="2">已处理</option>
												</select>
											</td>
											<th class="w55">主题</th>					
											<td>
												<select name="topic_id" class="topic_id">
													<option value="">--请选择--</option>
													<c:forEach items="${topicList }" var="item" varStatus="vs">
														<option value="${item.id }">${item.name }</option>
													</c:forEach>
												</select>
											</td>
											<th class="w60">提交日期</th>					
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
													<a href="advice/list.do?my_type=${my_type }&menu_id=${menu_id}">重置</a>
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
 	<input type="hidden" id="HiddenIds" />
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() {
			
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '添加信件 ',
					width : '700px',
					height : '300px'
					
				});
				return false;
			});

			$('.update').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'update_page',
					title : '修改信件 ',
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
					title : '查看信件 ',
					width : '900px',
					height : '260px'
				});
				return false;
			});
			
			$(".change").live("click",function(){
				var $this=$(this),msg="",smsg="";
				if($this.hasClass("gk"))
				{
					msg="公开";
					smsg="公开成功";
				}else
				{
					msg="不公开";
					smsg="不公开成功";
				}
				util.easyAjaxRequest(msg,$this,smsg);
				return false;
			});
			
			$("#batch_change,#batch_change1").live("click",function(){
				var $this=$(this),msg="",smsg="";
				if($this.hasClass("gk"))
				{
					msg="公开";
					smsg="公开成功";
				}else
				{
					msg="不公开";
					smsg="不公开成功";
				}
				util.easyAjaxBatchRequest(msg,$this,null,null,smsg);
				return false;
			});
			
			// ajax批量处理
		    $('#batch_haddle').live('click',function () {
		        var idArray = [],idArray1 = [],$this = $(this),flag=true;
		        $("[name='id']:checked").each(function () { 
		            if($(this).attr("key")==0)
	            	{
		            	idArray.push($(this).val());
		          	    
	            	}
		        });
		        if (idArray.length === 0) {
		            informationMsg('请选择要批量处理的信息！');
		        }
		        else{
		        	
		            art.dialog.confirm('您确定要将选中的都批量处理?', function () {
		            	$("#HiddenIds").val(idArray.join(','));
		            	openPage({
							url : $this.attr("href"),
							id : 'return_page',
							title : '批量处理 ',
							width : '580px',
							height : '200px'
						});
		            });
		        }
		        return false;
		    });

			
		  	//处理
			$('.haddle').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'account_page',
					title : '处理 ',
					width : '580px',
					height : '200px'
				});
				return false;
			});
		});
	</script>
	</jsp:body>
</gd:PopLayout>
