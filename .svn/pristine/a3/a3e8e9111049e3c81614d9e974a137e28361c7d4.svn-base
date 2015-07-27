<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="file/updatename.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
 			<input type="hidden" id="id" name="id" value="${model.id}"/>
 			<input type="hidden" id="extension" name="extension" value="${model.extension}"/>
			<table class="view wc100">
				<tbody>
					<tr id="user_nameTr" >
						<th class="w140"><span class="c_red">*</span>文件名:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" id="name" name="name" data-val="true" data-val-required="请输入文件名！" value="${file_name}" />.${model.extension}
							<span class="field-validation-error" data-valmsg-for="name" data-valmsg-replace="true"></span>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<th></th>
						<td class="ptb10">
							<span class="ml10 btn btn_pub">
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
			errorMsg("修改文件名时出错！");
		}
	</script>
</gd:PopLayout>