<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap"> 
		<form id="data_form" method="post" action="userlog/update.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<input type="hidden" name="id" id="id" value="${model.id}"/> 
			<table class="view wc100">
				<tbody>  
					<tr>
						<th class="w15per"><span class="c_red">*</span>用户id:&nbsp;</th>
						<td>
							<select id="user_id" name="user_id" data-val="true" data-val-required="请选择用户id！">
								<option value="">--请选择--</option>
								<c:forEach items="${userList}" var="item">
									<option value="${item.id}" <c:if test="${model.user_id == item.id}">selected="selected"</c:if> >${item.name}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th class="w15per"><span class="c_red">*</span>内容:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" data-val="true" data-val-required="请输入内容！" id="content" name="content" value="${model.content}" />
							<span class="field-validation-error" data-valmsg-for="content" data-valmsg-replace="true"></span>
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