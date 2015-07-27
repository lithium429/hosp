<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w110"><span class="c_red">*</span>公告类型名称：</th>
			<td>
				<input type="text" class="inp_t" data-val="true"
				data-val-required="请输入公告类型名称！" id="name" name="name"
				data-val-remote-url="announcementType/validateName.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.name,*.id" 
				data-val-remote="该公告类型名称已存在！" 
				value="${model.name}" />
				<span class="field-validation-error" data-valmsg-for="name"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="vtop">备注:&nbsp;</th>
			<td>
				<textarea cols="60" rows="5" name="remark" class="inp_t form_ta">${model.remark}</textarea>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td class="btn_area" colspan="2"><span class="btn btn_pub">
					<input type="submit" value="保存" />
			</span><span class="ml10 btn btn_base"> <input type="button"
					id="btn_pclose" value="取消">
			</span></td>
		</tr>
	</tfoot>
</table>
<script type="text/javascript">
$(function(){
	
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