<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap pop_wrap">
		<input type="hidden" name="id" value="${model.id}" />
		<input type="hidden" id="task_id" name="task_id" value="${taskId}" />
		<input type="hidden" id="tkey" name="tkey" value="${tkey}" />
		<%@ include file="view_form.jsp"%>
		<c:choose>
			<c:when test="${tkey == 'reportBack' }">
				 <div class="view_data">
					<table class="wc100">
						<tbody> 
							<tr>
								<th class="w120">实际开始时间：</th>
								<td>
									<input id="reality_start_time" name="reality_start_time" class="inp_t inp_w150 search_sel ico_date" 
										onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'reality_end_time\')}'})" value="" />
									<span id="error_start_time" class="dn">请选择实际开始时间！</span>
								</td>
							</tr>
							<tr>
								<th>实际结束时间：</th>
								<td>
									<input id="reality_end_time" name="reality_end_time" class="inp_t inp_w150 search_sel ico_date" 
										onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'reality_start_time\')}'})" value="" />
									<span id="error_end_time" class="dn" >请选择实际结束时间！</span>
								</td>
							</tr> 
						</tbody>
						<tfoot>
							<tr> 
								<td class="btn_area" colspan="2">
									<span class="btn btn_pub">
										<input type="submit" id="btn_save" value="保存" />
									</span>
									<span class="ml10 btn btn_base">
										<input type="button" id="btn_pclose" value="取消">
									</span>
								</td> 
							</tr>
						</tfoot>
					</table>      
				</div>
			</c:when>
			<c:otherwise>
				<div class="btn_area">
			    	<span class="btn btn_base"><input type="button" id="btn_agree" value="同意" /></span>
			    	<span class="ml10 btn btn_base"><input type="button" id="btn_disagree" value="不同意" /></span>
			    	<span class="ml10 btn btn_base"><input type="button" id="btn_pclose" value="取消" /></span>
			    </div>	
			</c:otherwise>
		</c:choose> 
	</div>  
</gd:PopLayout>
<script type="text/javascript" src="static/js/biz/workflow.leave.js"></script>
<script type="text/javascript"> 
	$(function(){
		var taskId = $('#task_id').val(),
		keyObj = { 'deptLeaderAudit': 'deptLeaderPass', 'fdeptLeaderAudit': 'fdeptLeaderPass' };
		
		$('#btn_agree').click(function(){
			// 更新流程完成情况
			leaveInfo.complete(taskId, [{
				key: keyObj['${tkey}'],
				value: true,
				type: 'B'
			}], function(){ 
				refreshList();
			});
			return false;
		});
		
		$('#btn_disagree').click(function(){
			openPage({
				url : 'leaveInfo/reason.do',
				id : 'add_page',
				title : '不同意 ',
				width : '600px',
				height : '200px'
			});
			return false;
		}); 
		
		$('#btn_save').click(function(){
			var startTime = $('#reality_start_time').val(),
			endTime = $('#reality_end_time').val(); 
			
			var flag = util.checkItem('#reality_start_time', '#error_start_time');
			flag = util.checkItem('#reality_end_time', '#error_end_time');
			if(!flag){
				return false;
			}
			
			leaveInfo.complete(taskId, [{
				key: 'realityStartTime',
				value: startTime,
				type: 'D'
			}, {
				key: 'realityEndTime',
				value: endTime,
				type: 'D'
			}], function(){ 
				refreshList();
			});
		});
	});
	
	// 刷新列表
	function refreshList(){
		var opener = art.dialog.open.origin;
		opener.$('#spec_form').submit();
		closeDialog();
	}
</script>