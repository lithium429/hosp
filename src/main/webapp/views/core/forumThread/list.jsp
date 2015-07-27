<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout> 
	<div class="mb10 crumbs">
		<span class="icon ico_place"></span><b>您当前的位置：</b>论坛管理 &gt; 主题回收站
	</div>
	<div class="data_model"> 
		<form id="spec_form" action="forum/thread/datalist.do" data-ajax="true" data-ajax-begin="loadBegin" data-ajax-failure="loadFailure" data-ajax-failure="loadComplete" data-ajax-loading="#loading_img" data-ajax-method="POST" data-ajax-mode="replace" data-ajax-update="#data_list" novalidate="novalidate">
			<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" /> 
			<input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" /> 
			<div class="mb10 data_cont_wrap_list query_condition">
				<table>
					<tbody>
						<tr>
							<th class="w70">板块</th>					
							<td>
								<select id="plate_id" name="plate_id">
									<c:forEach items="${plateList}" var="item" varStatus="vs">
										<option>--所有板块--</option>
										<option value="${item.id}" <c:if test="${item.layer == 1}">disabled="disabled"</c:if>>
											${gdf:buildTreeName(item.name, item.layer)}
										</option>
									</c:forEach>
								</select>
							</td>
							<th class="w70">主题</th>					
							<td>
								<input class="inp_t inp_w150" name="subject" id="subject" />
							</td>
							<td>
								<span class="btn btn_pub">
									<input type="submit" id="btn_search" value="查询" />
								</span><span class="ml8 btn btn_base">
									<a href="forum/thread/list.do?menu_id=${menu_id}">重置</a>
								</span>
							</td>
						</tr>
					 </tbody>
			 	 </table>
	        </div>
     	</form>
     	<div class="data_model wc100 data_list_wrap" id="data_list"> 
     		<%@ include file="data_list.jsp"%>
	 	</div> 
 	</div> 
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" />
	 
	<script type="text/javascript" src="static/js/index.js"></script> 
	<script type="text/javascript" src="static/js/flexigrid-1.1/js/flexigrid.js"></script> 
	<script type="text/javascript">  
		$(function(){ 
			
			// 恢复
			$('.recover').live('click', function(){ 
				var url = $(this).attr('href');
				 util.ajax({
					 url: url,
					 type: 'post', 
					 dataType: 'json',
					 success: function(result){
						 if(result.flag){
							 successMsg('恢复成功！', function(){
								$('#spec_form').submit(); 
							 });
						 }
						 else{
							 errorMsg('恢复失败！');
						 }
					 }
				}); 
				return false;
			}); 
			
			// 批量恢复
			$('#batch_recover').live('click', function(){
				var url = $(this).attr('href'), idArray = [];
				$('input[name="id"]:checked').each(function(index, item){
					idArray.push(item.value);
				});
				if(idArray.length === 0){
					informationMsg('请选择需要恢复的主题！');
					return false;	
				}
				 util.ajax({
					 url: url,
					 type: 'post', 
					 dataType: 'json',
					 data: { ids: idArray.join(',') },
					 success: function(result){
						 if(result.flag){
							 successMsg('恢复成功！', function(){
								$('#spec_form').submit(); 
							 });
						 }
						 else{
							 errorMsg('恢复失败！');
						 }
					 }
				}); 
				return false;
			});
		}); 
	</script>
</gd:Layout>
