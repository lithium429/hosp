<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w80"><span class="c_red">*</span>请假人：</th>
			<td class="w320">
				<input type="text" class="inp_t"  id="staff_name" name="staff_name" value="<c:if test="${!empty model.staff_id }">${model.staff_name}(${model.staff_code })</c:if>" />
				<c:if test="${!empty model.id }"><input type="hidden" id="staff_id" name="staff_id" value="${model.staff_id }" /></c:if>
				<span id="staffError" class="red error dn"></span>
			</td>
			<th class="w80"><span class="c_red">*</span>请假类型：</th>
			<td>
				<select class="w86" name="type" data-val="true" data-val-required="请选择请假类型！">
					<option value="">--请选择--</option>
					<option value="1" <c:if test="${model.type==1 }">selected="selected"</c:if>>病假</option>
					<option value="2" <c:if test="${model.type==2 }">selected="selected"</c:if>>事假</option>
					<option value="3" <c:if test="${model.type==3 }">selected="selected"</c:if>>年假</option>
					<option value="4" <c:if test="${model.type==4 }">selected="selected"</c:if>>其他</option>
				</select>
				<span class="field-validation-error" data-valmsg-for="type"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class=""><span class="c_red">*</span>审批人：</th>
			<td colspan="3">
				<input type="text" class="inp_t"  id="verify_user_name" name="verify_user_name" value="<c:if test="${!empty model.verify_user_id }">${model.verify_user_name}</c:if>" />
				<c:if test="${!empty model.id }"><input type="hidden" id="verify_user_id" name="verify_user_id" value="${model.verify_user_id }" /></c:if>
				<span id="userError" class="red error dn"></span>
			</td>
		</tr>
		<tr>
			<th class="vtop">请假原因：</th>
			<td colspan="3">
				<textarea cols="100" rows="10" name="reason" class="inp_t form_ta">${model.reason}</textarea>
			</td>
		</tr>
		<tr>
			<th class="w60"><span class="c_red">*</span>开始时间：</th>					
			<td>
				<input id="start_time" class="inp_t inp_w150 search_sel ico_date" 
				onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_time\')}'})"
                  onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_time\')}'})" 
                  name="start_time"  data-val="true" data-val-required="请选择开始时间！" value="<fmt:formatDate value="${model.start_time}" pattern="yyyy-MM-dd HH:mm" />" />
				<span class="field-validation-error" data-valmsg-for="start_time"
						data-valmsg-replace="true"></span>
			</td>
			<th class="w60"><span class="c_red">*</span>结束时间：</th>					
			<td>
				<input id="end_time" class="inp_t inp_w150 search_sel ico_date" 
				onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'start_time\')}'})"
                  onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',minDate:'#F{$dp.$D(\'start_time\')}'})" 
                  name="end_time"  data-val="true" data-val-required="请选择结束时间！" value="<fmt:formatDate value="${model.end_time}" pattern="yyyy-MM-dd HH:mm" />" />
				<span class="field-validation-error" data-valmsg-for="end_time"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="">提醒审批人：</th>
			<td colspan="3">
				<label><input type="radio" class="is_notify" name="is_notify" value="1" <c:if test="${model.is_notify }">checked="checked"</c:if> />是</label>
				<label class="ml10"><input type="radio" class="is_notify" name="is_notify" value="0" <c:if test="${!model.is_notify}">checked="checked"</c:if> />否</label>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td class="btn_area" colspan="2"><span class="btn btn_pub">
					<input type="submit" id="btnSave" value="保存" />
			</span><span class="ml10 btn btn_base"> <input type="button"
					id="btn_pclose" value="取消">
			</span></td>
		</tr>
	</tfoot>
</table>
<script type="text/javascript" src="static/js/jquery.autocomplete.js"></script>	
<script type="text/javascript">
	$(function(){
		//智能搜索工程名称
        $('#staff_name').autocomplete({
            serviceUrl: 'staff/autoStaff',
            hiddenId: 'staff_id',
            mapping: { id: 'id', name: 'name' },
            params: { Time: +new Date() },
            onSelect: function () {
                var $EngineeringName = $("#staff_name");
                var $EngineeringNameError = $("#staffError");
                $EngineeringName.removeClass("input-validation-error").addClass("valid");
                $EngineeringNameError.addClass("dn").html("");
            }
        });
		
        $('#verify_user_name').autocomplete({
            serviceUrl: 'user/autoUser',
            hiddenId: 'verify_user_id',
            mapping: { id: 'id', name: 'name' },
            params: { Time: +new Date() },
            onSelect: function () {
                var $EngineeringName = $("#verify_user_name");
                var $EngineeringNameError = $("#userError");
                $EngineeringName.removeClass("input-validation-error").addClass("valid");
                $EngineeringNameError.addClass("dn").html("");
            }
        });
		
    	 // 【人员】文本框的blur事件
        $("#staff_name").blur(function () {
            CheckEngineering(1);
        });
    	 
    	 // 【奖惩名目】文本框的blur事件
        $("#verify_user_name").blur(function () {
            CheckUser(1);
        });
		
        $("#btnSave").click(function(){
    		var flag=true;
    		// 调用jquery.validate.unobtrusive.js 提供的验证方法 
            function validate() {
                var validationInfo = $('#data_form').data('unobtrusiveValidation');
                return !validationInfo || !validationInfo.validate || validationInfo.validate();
            }
            flag=validate()&&flag;
            flag=CheckEngineering(2)&&flag;
            flag=CheckUser(2)&&flag;
    		
    		return flag;
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
	
	// 检查人员【type=1是鼠标离开的时候触发的，type=2是点击提交按钮触发的】
    function CheckEngineering(type) {
        var $this = $("#staff_name");
        var flag = true;
        var $EngineeringNameError = $("#staffError");
        if (!util.isEmpty($this.val())) {
            if ($this.next("input:hidden").size() == 0 && type == 2) {
                $this.addClass("input-validation-error").removeClass("valid");
                $EngineeringNameError.removeClass("dn").html("请重新请假人！");
                flag = false;
            }
            else {
                $this.removeClass("input-validation-error").addClass("valid");
                $EngineeringNameError.addClass("dn").html("");
            }
        }
        else {
        	$this.addClass("input-validation-error").removeClass("valid");
            $EngineeringNameError.removeClass("dn").html("请输入请假人！");
            flag = false;
        }
        return flag;
    }
	
 	// 检查奖惩名目【type=1是鼠标离开的时候触发的，type=2是点击提交按钮触发的】
    function CheckUser(type) {
        var $this = $("#verify_user_name");
        var flag = true;
        var $EngineeringNameError = $("#userError");
        if (!util.isEmpty($this.val())) {
            if ($this.next("input:hidden").size() == 0 && type == 2) {
                $this.addClass("input-validation-error").removeClass("valid");
                $EngineeringNameError.removeClass("dn").html("请重新选择审批人！");
                flag = false;
            }
            else {
                $this.removeClass("input-validation-error").addClass("valid");
                $EngineeringNameError.addClass("dn").html("");
            }
        }
        else {
        	$this.addClass("input-validation-error").removeClass("valid");
            $EngineeringNameError.removeClass("dn").html("请输入审批人！");
            flag = false;
        }
        return flag;
    }
</script>