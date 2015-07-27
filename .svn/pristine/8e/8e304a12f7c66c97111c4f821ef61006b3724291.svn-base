<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="leave/change.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<input type="hidden" name="id" value="${id}" />
			<input type="hidden" name="ids" id="ids" value="" />
			<input type="hidden" name="state" id="state" value="${state }" />
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="vtop w15per"><span class="c_red">*</span>理由：</th>
						<td>
							<textarea class="valid" cols="50" id="content" name="content" rows="7"  data-val="true" data-val-required="请输入理由！"></textarea>
			                <span class="field-validation-valid" data-valmsg-for="content" data-valmsg-replace="true"></span>
						</td>
					<tr>
				</tbody>
				<tfoot>
					<tr>
						<td class="btn_area" colspan="2">
						<span class="btn btn_pub">
								<input type="submit" value="保存" id="btnSave" />
						</span><span class="ml10 btn btn_base"> <input type="button"
								id="btn_pclose" value="取消">
						</span></td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<!-- E 添加信息 -->
</gd:PopLayout>
<script type="text/javascript">
var opener = art.dialog.open.origin;
	$(function(){
		$("#ids").val(opener.$("#HiddenIds").val());
		
		
	});
	function backToList(result) {
		if (result.flag) {
			successMsg('审批成功！', function() {
				opener.$("#HiddenIds").val('');
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