<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="address/move.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">

			<input type="hidden" id="id" name="id" value="${model.id }"/>
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="">群组:&nbsp;</th>
						<td>
							<input type="hidden" id="old_id" name="old_id" value="${model.group_id }"/>
							<select class="w86" id="group_id" name="group_id">
								<option value="">默认</option>
								<c:forEach items="${groupList }" var="item" varStatus="vs">
									<option value="${item.id }" <c:if test="${model.group_id==item.id }">selected="selected"</c:if>>${item.name }</option>
								</c:forEach>
							</select>
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
	
	<script type="text/javascript">
	var opener = art.dialog.open.origin;
	$(function(){
		
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