<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<div class="view_data">
			<form id="data_form" method="post" action="leave/verify.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
				<input type="hidden" name="id" value="${model.id}" />
				<table class="view wc100">
					<tbody>
						<tr>
							<th class="w15per">请假人：</th>
							<td class="w35per">
								${model.staff_name}(${model.staff_code })
							</td>
							<th class="w15per">请假类型：</th>
							<td class="">
								<c:choose>
				            		<c:when test="${model.type == 1}">病假</c:when>
				            		<c:when test="${model.type == 2}">事假</c:when>
				            		<c:when test="${model.type == 3}">年假</c:when>
				            		<c:when test="${model.type == 4}">其他</c:when>
				            	</c:choose>
							</td>
						</tr>
						<tr>
							<th class="">审批人</th>
							<td colspan="3">
								${model.verify_user_name}
							</td>
						</tr>
						<tr>
							<th class="">请假原因</th>
							<td colspan="3">
								${model.reason}
							</td>
						</tr>
						<tr>
							<th>开始时间：</th>
							<td>
								<fmt:formatDate value="${model.start_time}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<th>结束时间：</th>
							<td>
								<fmt:formatDate value="${model.end_time}" pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
						</tr> 
						<tr>
							<th>审核</th>
							<td colspan="3">
								<label><input type="radio" name="state" id="state_2" value="2" checked="checked" />通过</label>
								<label><input type="radio" name="state" id="state_3" value="3" />不通过</label>
							</td>
						</tr>
						<tr id="reason_tr" class="dn">
							<th class="vtop w15per"><span class="c_red">*</span>理由：</th>
							<td colspan="3">
								<textarea class="inp_t form_ta dn" style="width:380px;" cols="50" id="content" name="content" rows="7"  data-val="true" data-val-required="请输入理由！"></textarea>
				                <span class="field-validation-valid" data-valmsg-for="content" data-valmsg-replace="true"></span>
							</td>
						<tr>
					</tbody>
					<tfoot>
						<tr>
							<td class="btn_area" colspan="4">
							<span class="btn btn_pub">
									<input type="submit" value="保存" id="btn_save" />
							</span><span class="ml10 btn btn_base"> <input type="button"
									id="btn_pclose" value="取消">
							</span></td>
						</tr>
					</tfoot>
				</table>
			</form>
		</div>
	</div>
	<!-- E 添加信息 -->
</gd:PopLayout>
<script type="text/javascript"> 
	$(function(){
		$('#state_2').click(function(){
			$('#reason_tr,#content').hide();
		});
		
		$('#state_3').click(function(){
			$('#reason_tr,#content').show();
		});
	});

	function backToList(result) {
		if (result.flag) {
			successMsg('审批成功！', function() {  
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