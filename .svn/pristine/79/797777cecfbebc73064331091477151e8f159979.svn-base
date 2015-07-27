<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w80"><span class="c_red">*</span>角色名称：</th>
			<td>
				<input type="text" class="inp_t" data-val="true"
				data-val-required="角色名称！" id="name" name="name"
				data-val-remote-url="role/validateName.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.name,*.id" 
				data-val-remote="该角色名称已存在！" 
				value="${model.name}" />
				<span class="field-validation-error" data-valmsg-for="name"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="">复制默认：</th>
			<td>
				<select id="role_id" name="role_id" <c:if test="${!empty model.id }">disabled="disabled"</c:if> >
					<option value="">--请选择--</option>
					<c:forEach var="item" items="${roleList}" varStatus="vs">
						<option value="${item.id}" <c:if test="${item.id eq model.role_id}">selected="selected"</c:if> >
							${item.name}
						</option>
					</c:forEach>
				</select>
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