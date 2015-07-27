<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="address/share.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<input type="hidden" id="user_ids" name="addressUserIds" value="${model.getUserIdsByAddressUsers() }"/>
			<input type="hidden" id="id" name="id" value="${model.id }"/>
			<table class="view wc100">
				<tbody>
					<tr id="user_nameTr" >
						<th>共享范围</th>
						<td>
							<textarea cols="60" rows="5" name="user_names" id="user_names" class="inp_t form_ta" disabled="disabled">${model.getUserNamesByAddressUsers()}</textarea>
							<a href="user/sellist.do" id="addUser">添加</a>
							<a href="javascrpt:(0);" class="ml10" id="clearUser">清除</a>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td></td>
						<td class="ptb10">
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
	var type=$("#type").val();
	$(function(){

	    
	    //清除共享用户
	    $("#clearUser").click(function(){
	    	$('#user_ids,#user_names').val('');
	    	return false;
	    });
	    
	    //选择共享用户
	    $("#addUser").click(function(){
	    	var url = $(this).attr('href');
			openPage({
				url:url,
				id:'sel_page1',
				title:'选择共享用户',
				width:'800px',
				height:'475px'
			});
			return false;
	    });
	    
	    
	});
	 
	function backToList(result) {
		if (result.flag) {
			successMsg(result.msg ? result.msg : "保存成功！", function() {
				opener.$('#is_share1,#dept_id1,#group_id1').val('');
				opener.$('#is_share1').val(opener.$("#is_share").val());
				opener.$('#group_id1').val(opener.$("#group_id").val());
				opener.$("#list_type").val(2);
				opener.$('#spec_form').submit();
				closeDialog();
			});
		} else {
			errorMsg(result.msg ? result.msg : "保存失败！");
		}
	}

		function showError() {
			errorMsg("修改用户时出错！");
		}
	</script>
</gd:PopLayout>