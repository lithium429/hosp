<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w20per"><span class="c_red">*</span>信件主题：</th>
			<td>
				<input type="text" class="inp_t" data-val="true"
				data-val-required="请输入信件主题！" id="name" name="name"
				data-val-remote-url="adviceTopic/validateName.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.name,*.id" 
				data-val-remote="该信件主题已存在！" 
				value="${model.name}" />
				<span class="field-validation-error" data-valmsg-for="name"
						data-valmsg-replace="true"></span>
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