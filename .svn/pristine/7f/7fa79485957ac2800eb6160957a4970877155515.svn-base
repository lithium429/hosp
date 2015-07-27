<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="file/batchfileuser.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<input type="hidden" id="file_ids" name="file_ids" value="${file_ids}" />
			<input type="hidden" id="user_ids" name="user_ids" value="" />  
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w80" style="vertical-align:top;">可见用户</th>
						<td class="w400">
							<a href="user/sellist.do?key_v=1" id="add_user">添加</a>
							<a href="javascript:void(0);" class="ml10" id="clear_user">清除所有</a>
							<span class="error dn" id="user_error">请选择用户！</span>	
							<div style="width:400px;overflow:auto;">
								<div id="innerUser" class="dib main_inpt">
								</div>
							</div>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th></th>
						<td>
							<span class="btn btn_pub">
								<input id="btn_save" type="submit" value="保存" />
							</span>
							<span class="ml10 btn btn_base">
								<input type="button" id="btn_pclose" value="取消" />
							</span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<!-- E 添加信息 -->
	<script type="text/javascript">
		var opener = art.dialog.open.origin; 
		
		$(function(){ 
			var idArray = [];
			opener.$('input[name="id"]:checked').each(function(index, item){
				idArray.push(item.value);
			});
			$('#file_ids').val(idArray.join(','));
			
			//删除用户
			$(".del_user").live("click",function(){
				$(this).parents(".user_child").remove();
			});
			
		    //清除共享用户
		    $("#clear_user").click(function(){
		    	$('#innerUser').html('');
		    });
		    
		    //选择共享用户
		    $("#add_user").click(function(){
		    	var url = $(this).attr('href');
				openPage({
					url: url,
					id: 'sel_page',
					title: '选择可见用户',
					width: '800px',
					height: '475px'
				});
				return false;
		    });
		    
		    // 保存共享用户
		    $('#btn_save').click(function(){
		    	var userIdArray = [], context = $('#innerUser');
		    	$('.user_child', context).each(function(index, item){
		    		userIdArray.push($(item).attr('key_id'));
		    	});
		    	if(userIdArray.length === 0){
		    		$('#user_error').show();
		    		return false;
		    	}
		    	
		    	$('#user_ids').val(userIdArray.join(','));
		    });
		});
	 
		function backToList(result) {
			if (result.flag) {
				successMsg(result.msg ? result.msg : "保存成功！", function() {  
					opener.$('#spec_form').submit();
					closeDialog();
				});
			} else {
				errorMsg(result.msg ? result.msg : "保存失败！");
			}
		}

		function showError() {
			errorMsg("设置可见用户时出错！");
		}
	</script>
</gd:PopLayout>