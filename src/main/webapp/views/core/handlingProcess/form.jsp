<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<input type="hidden" name="user_id" id="user_id" value="${model.user_id}" />
<input type="hidden" name="state" id="state" value="${model.state}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w80"><span class="c_red">*</span>督办事宜：</th>
			<td>
				<input type="text" class="inp_t" data-val="true"
				data-val-required="请输入督办事宜！" id="title" name="title"
				value="${model.title}" />
				<span class="field-validation-error" data-valmsg-for="title"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class=""><span class="c_red">*</span>责任人:&nbsp;</th>
			<td class="">
				<div id="innerUser" class="dib inp_t mail_input">
					<c:if test="${!empty model.user_id }">
					<span class="user_child user_child_sel${model.user_id }" key_id="${model.user_id }" key_name="${model.user_name }">${model.user_name }<em class="del_user">×</em></span>
					</c:if>
				</div>
				<em class="btn btn_pub ml8">
					<input type="button" id="selUser"  value="选择" />
				</em>
				<span class="dn error" id="user_error">请选择责任人！</span>
			</td>
		</tr>
		<tr>
			<th>
				<span class="c_red">*</span>办结日期:&nbsp;
			</th>
			<td>
				<input id="end_date" class="inp_t inp_w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"
				 onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})" data-val="true" data-val-required="请选择办结日期！"
				  name="end_date" value="<fmt:formatDate value="${model.end_date}" pattern="yyyy-MM-dd" />" />
				<span class="field-validation-error" data-valmsg-for="end_date"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="">事宜内容:&nbsp;</th>
			<td colspan="3">
				<textarea cols="60" rows="5" name="content" class="inp_t form_ta">${model.content}</textarea>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td class="btn_area" colspan="4"><span class="btn btn_pub">
					<input type="submit" id="btnSave_sub" class="sub" value="提交" />
			</span><span class="btn btn_pub ml10">
					<input type="submit" id="btnSave" value="保存" />
			</span><span class="ml10 btn btn_base"> <input type="button"
					id="btn_pclose" value="取消">
			</span></td>
		</tr>
	</tfoot>
</table>
<script type="text/javascript">
$(function(){
	$("#btnSave,#btnSave_sub").click(function(){
		
		var flag=true;
		// 调用jquery.validate.unobtrusive.js 提供的验证方法 
        function validate() {
            var validationInfo = $('#data_form').data('unobtrusiveValidation');
            return !validationInfo || !validationInfo.validate || validationInfo.validate();
        }
		if($(this).hasClass("sub"))
		{
			$("#state").val('2');
		}else
		{
			$("#state").val('1');
		}
        flag=validate();
        var user_id=$("#innerUser span.user_child").attr("key_id");
        if(util.isNull(user_id))
        {
        	$("#innerUser").addClass("input-validation-error");
        	$("#user_error").removeClass("dn");
        	$("#user_id").val('');
        	flag=false;
        }else
        {
        	$("#innerUser").removeClass("input-validation-error");
        	$("#user_error").addClass("dn");
        	$("#user_id").val(user_id);
        }
        return flag;
	});
	
	
	//删除用户
	$(".del_user").live("click",function(){
		$(this).parents(".user_child").remove();
	});
	
	$("#selUser").click(function(){
		var url = 'user/sellist.do?key_v=2';
		openPage({
			url:url,
			id:'sel_page',
			title:'选择责任人',
			width:'800px',
			height:'475px'
		});
		return false;
	});
});
	function backToList(result) {
		if (result.flag) {
			successMsg("保存成功！", function() {
				var opener = art.dialog.open.origin;
				opener.$('#spec_form').submit();
				closeDialog();
			});
		} else {
			errorMsg(result.msg);
		}
	}

	function showError(result) {
		errorMsg(result.msg);
	}
	
</script>