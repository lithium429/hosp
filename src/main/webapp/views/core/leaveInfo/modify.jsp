<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="leaveInfo/modify.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<input type="hidden" id="task_id" value="${task_id}" />
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w80">
							不同意原因：
						</th>
						<td>
							<c:if test="${model != null && model.variables != null}">
								<c:choose>
									<c:when test='${!empty model.variables.get("leaderBackReason")}'>
										科主任，${model.variables.get("leaderBackReason")}
									</c:when>
									<c:when test='${!empty model.variables.get("fleaderBackReason")}'>
										职能科室科长，${model.variables.get("fleaderBackReason")}
									</c:when>
								</c:choose>
							</c:if>
						</td>
					</tr>
					<tr> 
						<th>
							<span class="c_red">*</span>操作：
						</th>
						<td>
							<label class="hand">
								<input type="radio" name="apply" value="false" checked="checked" />取消申请
							</label>
							<label class="ml10 hand">
								<input type="radio" name="apply" value="true" />重新申请
							</label>
						</td>
					</tr>
				</tbody>
			</table>
			<div id="apply_form" class="dn">
				<%@ include file="form.jsp"%>
			</div>
			<div class="btn_area">
				<span class="btn btn_pub">
					<input type="submit" id="btn_save" value="保存" />
				</span>
				<span class="ml10 btn btn_base">
					<input type="button" id="btn_pclose" value="取消" />
				</span> 
			</div>
		</form>
	</div>
	<!-- E 添加信息 -->
	<script type="text/javascript" src="static/js/biz/workflow.leave.js"></script>
	<script type="text/javascript">
		$(function(){
			$('input[name="apply"]').click(function(){
				$('#apply_form').toggleClass('dn');
			});
			
			$('#btn_save').click(function(){
				var taskId = $('#task_id').val(),
				reApply = $('input[name="apply"]:checked').val();
				
				// 提交的时候把变量
				leaveInfo.complete(taskId, [{
					key: 'reApply',
					value: reApply,
					type: 'B'
				}, {
					key: 'leaveType',
					value: $('#type').val(),
					type: 'I'
				}, {
					key: 'startTime',
					value: $('#start_time').val(),
					type: 'D'
				}, {
					key: 'endTime',
					value: $('#end_time').val(),
					type: 'D'
				}, {
					key: 'reason',
					value: $('#reason').val(),
					type: 'S'
				}, {
					key: 'is_notify',
					value: $('input[name="is_notify"]:checked').val(),
					type: 'B'
				}], function(){ 
					refreshList();
				});
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
		
		// 刷新列表
		function refreshList(){
			var opener = art.dialog.open.origin;
			opener.$('#spec_form').submit();
			closeDialog();
		}
		
	</script>
</gd:PopLayout>
