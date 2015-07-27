<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w20per"><span class="c_red">*</span>分类名称：</th>
			<td>
				<input type="text" class="inp_t" data-val="true"
				data-val-required="请输入分类名称！" id="name" name="name"
				data-val-remote-url="careType/validateName.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.name,*.id" 
				data-val-remote="该分类名称已存在！" 
				value="${model.name}" />
				<span class="field-validation-error" data-valmsg-for="name"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class=""><span class="c_red">*</span>排序:&nbsp;</th>
			<td>
				<input type="text" class="inp_t" data-val="true"
				data-val-required="请输入排序！" id="sort" name="sort"
			    data-val-regex="排序只能够输入整数！" data-val-regex-pattern="^\d+$"
				data-val-remote-url="careType/validateSort.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.sort,*.id" 
				data-val-remote="该排序已存在！" 
				value="${model.sort}" />
				<span class="field-validation-error" data-valmsg-for="sort"
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
				opener.$('#spec_form1').submit();
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