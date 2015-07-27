<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap pop_wrap">
		<input type="hidden" name="id" value="${model.id}" />
		<table class="view wc100">
			<tbody>
				<tr>
					<th class="vtop w60"><span class="c_red">*</span>原因：</th>
					<td>
						<textarea cols="80" rows="10" id="reason" name="reason" class="inp_t form_ta"></textarea>
						<br />
						<span id="error_reason" class="error dn">请输入原因！</span>
					</td>
				</tr> 
			</tbody>
			<tfoot>
				<tr>
					<td class="btn_area" colspan="2"><span class="btn btn_pub">
							<input type="submit" id="btn_save" value="确定" />
					</span><span class="ml10 btn btn_base"> <input type="button"
							id="btn_pclose" value="取消">
					</span></td>
				</tr>
			</tfoot>
		</table>
	</div>
</gd:PopLayout>
<script type="text/javascript" src="static/js/biz/workflow.leave.js"></script>
<script type="text/javascript"> 
	$(function(){
		var keyObj = { 'deptLeaderAudit': 'deptLeaderPass', 'fdeptLeaderAudit': 'fdeptLeaderPass' },
		reasonObj = { 'deptLeaderAudit': 'leaderBackReason', 'fdeptLeaderAudit': 'fleaderBackReason' }, 
		opener = art.dialog.open.origin, 
		taskId = opener.$('#task_id').val(),
		tkey = opener.$('#tkey').val();
		
		// 驳回
		$('#btn_save').click(function(){
			var reason = $('#reason').val(),
			flag = util.checkItem('#reason', '#error_reason');
			if(!flag) {
				return false;
			}
			
			leaveInfo.complete(taskId, [{
				key: keyObj[tkey],
				value: false,
				type: 'B'
			}, {
				key: reasonObj[tkey],
				value: reason,
				type: 'S'
			}], function(){ 
				opener.refreshList();
			});	
		});
	});
</script>