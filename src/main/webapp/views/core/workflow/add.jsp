<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="workflow/model/addModel.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w80"><span class="c_red">*</span>名称：</th>
						<td>
							<input id="name" name="name" type="text" class="inp_t" data-val="true" data-val-required="请输入名称！"/>
							<span class="field-validation-error" data-valmsg-for="name" data-valmsg-replace="true"></span>
						</td>
					</tr>
					<tr>
						<th><span class="c_red">*</span>Key：</th>
						<td>
							<input id="key" name="key" type="text" class="inp_t" data-val="true" data-val-required="请输入Key！"/>
							<span class="field-validation-error" data-valmsg-for="key" data-valmsg-replace="true"></span>
						</td>
					</tr>
					<tr>
						<th>描述：</th>
						<td>
							<textarea id="description" name="description" cols="60" rows="10" class="inp_t form_ta"></textarea>
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
		function backToList(result) {
			if (result.flag) {
				successMsg(result.msg ? result.msg : "保存成功！", function() {
					var opener = art.dialog.open.origin;
					opener.window.location.reload();
					closeDialog();
				});
			} else {
				errorMsg(result.msg ? result.msg : "保存失败！");
			}
		}

		function showError() {
			errorMsg("添加模型时出错！");
		}
	</script>
</gd:PopLayout>
