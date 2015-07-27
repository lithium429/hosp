<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout> 
	<div class="mb10 crumbs"> 
		<span class="icon ico_place"></span><b>您当前的位置：</b>文档管理 &gt; 回收站
		<div class="model_top_fun">
			<c:if test='${gdf:judgeRoleMenu(roleMenuList, "批量恢复") }'> 
				<span class="btn btn_pub"><a href="file/batchrecover.do" id="batch_recover">批量恢复</a></span>
			</c:if>
			<c:if test='${gdf:judgeRoleMenu(roleMenuList, "批量删除") }'> 
				<span><a href="file/batchdelete.do" class="btn" id="batch_delete">批量删除</a></span>
			</c:if>
		</div> 
	</div>
	<div class="data_model clearfix">
		<form id="spec_form" action="file/rubishdatalist.do" data-ajax="true" data-ajax-begin="loadBegin" data-ajax-failure="loadFailure" data-ajax-failure="loadComplete" data-ajax-loading="#loading_img" data-ajax-method="POST" data-ajax-mode="replace" data-ajax-update="#data_list" novalidate="novalidate"> 
			<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
			<input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
			<input type="hidden" name="is_delete" id="is_delete" value="true" />  
			<input type="hidden" name="creator_id" id="creator_id" value="${userId}" />
			<input type="hidden" name="types" id="types" value="" />
	        <div class="mb10 data_cont_wrap_list query_condition">
				<table>
					<tbody>
						<tr>
							<th class="w55">文件类型</th>					
							<td id="type_td">
								<label><input type="checkbox" class="inp_analog" value="1" name="type" /><span class="mr5 icon ico-checkbox"></span>文档</label>
								<label><input type="checkbox" class="inp_analog" value="2" name="type" /><span class="mr5 icon ico-checkbox"></span>图片</label>
								<label><input type="checkbox" class="inp_analog" value="3" name="type" /><span class="mr5 icon ico-checkbox"></span>其它</label> 
							</td>
							<th class="w55">文件名</th>					
							<td>
								<input class="inp_t inp_w150" name="name" id="name" />
							</td>
							<th class="w55">上传时间</th>					
							<td>
								 <input id="min_create_time" name="min_create_time" class="inp_t w140 search_sel exportValue ico_date" readonly="readonly" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'max_create_time\')}'})" />
									-
								 <input id="max_create_time" name="max_create_time" class="inp_t w140 search_sel exportValue ico_date" readonly="readonly" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'min_create_time\')}'})" />
							</td>    
							<td>
								<span class="btn btn_pub">
									<input type="submit" id="btn_search" value="查询" />
								</span><span class="ml8 btn btn_base">
									<a href="file/rubishlist.do">重置</a>
								</span>
							</td>
						</tr>
					 </tbody>
			 	 </table>
	        </div>
     	</form>
     	<div class="data_model wc100 data_list_wrap dt_query" id="data_list"> 
	 	</div> 
 	</div> 
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" />
	 
	<script type="text/javascript" src="static/js/index.js"></script> 
	<script type="text/javascript">  
	// 选择文档类型自动查询	
	var fileType = (function(){
		var fileTypes = $('input[name="type"]', $('#type_td')); 
		
		function init(){
	      	fileTypes.each(function(index, item){
	      		$(item).click(function(){
	      			var array = [];
	      			fileTypes.each(function(sindex, sitem){
	      				var checked = $(sitem).attr('checked');
	      				if(checked === 'checked'){
	      					array.push(sitem.value);
	      				}
	      			});
	      			$('#types').val(array.join(','));
	      			$('#spec_form').submit();
	      		});
	      	});
		}
		
		return { init: init };
	})();
    
    $(function () {
    	$('#spec_form').submit();
    	
      	// 自动查询
      	fileType.init();  
      	
      	// 批量恢复
      	$('#batch_recover').click(function(){
			util.easyAjaxBatchRequestFiter('恢复', $(this), 'recover', '恢复成功！');
			return false;
		}); 

      	// 单个恢复
      	$('.recover').live('click', function(){
			util.easyAjaxRequest('恢复', $(this), '恢复成功！');
			return false;
      	});
	});
	</script>
</gd:Layout>
