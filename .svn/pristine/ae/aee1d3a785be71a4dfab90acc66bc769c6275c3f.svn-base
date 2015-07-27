<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w80"><span class="c_red">*</span>请假类型：</th>
			<td>
				<select class="w86" id="type" name="type" data-val="true" data-val-required="请选择请假类型！">
					<option value="">--请选择--</option>
					<option value="1" <c:if test="${ model.type == 1 }">selected="selected"</c:if>>病假</option>
					<option value="2" <c:if test="${ model.type == 2 }">selected="selected"</c:if>>事假</option>
					<option value="3" <c:if test="${ model.type == 3 }">selected="selected"</c:if>>年假</option>
					<option value="4" <c:if test="${ model.type == 4 }">selected="selected"</c:if>>其他</option>
				</select>
				<span class="field-validation-error" data-valmsg-for="type"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th><span class="c_red">*</span>开始时间：</th>					
			<td>
				<input id="start_time" name="start_time" class="inp_t inp_w150 search_sel ico_date" 
					onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_time\')}'})"
                    data-val="true" data-val-required="请选择开始时间！" value="<fmt:formatDate value="${model.start_time}" pattern="yyyy-MM-dd HH:mm" />" />
				<span class="field-validation-error" data-valmsg-for="start_time"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th><span class="c_red">*</span>结束时间：</th>					
			<td>
				<input id="end_time" name="end_time" class="inp_t inp_w150 search_sel ico_date" 
					onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'start_time\')}'})"
                  	data-val="true" data-val-required="请选择结束时间！" value="<fmt:formatDate value="${model.end_time}" pattern="yyyy-MM-dd HH:mm" />" />
				<span class="field-validation-error" data-valmsg-for="end_time"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="vtop">请假原因：</th>
			<td>
				<textarea cols="100" rows="10" id="reason" name="reason" class="inp_t form_ta">${model.reason}</textarea>
			</td>
		</tr>
		<tr>
			<th>提醒审批人：</th>
			<td>
				<label><input type="radio" class="is_notify" name="is_notify" value="true" <c:if test="${model.is_notify }">checked="checked"</c:if> />是</label>
				<label class="ml10"><input type="radio" class="is_notify" name="is_notify" value="false" <c:if test="${!model.is_notify}">checked="checked"</c:if> />否</label>
			</td>
		</tr>
	</tbody>
</table>