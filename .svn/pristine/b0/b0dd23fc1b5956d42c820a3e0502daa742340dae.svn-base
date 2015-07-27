<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w110"><span class="c_red">*</span>人员：</th>
			<td class="w300">
				<input type="text" class="inp_t"  id="name" name="name" value="<c:if test="${!empty model.staff_id }">${model.name}(${model.user_code })</c:if>" />
				<c:if test="${!empty model.id }"><input type="hidden" id="staff_id" name="staff_id" value="${model.staff_id }" /></c:if>
				<span id="staffError" class="red error dn"></span>
			</td>
			<th class="w110"><span class="c_red">*</span>合同编号：</th>
			<td >
				<input type="text" class="inp_t" data-val="true"
				data-val-required="请输入合同编号！" id="code" name="code"
				data-val-remote-url="staffContract/validateCode.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.code,*.id" 
				data-val-remote="该合同编号已存在！"
				value="${model.code}" />
				<span class="field-validation-error" data-valmsg-for="code"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th><span class="c_red">*</span>合同类型：</th>
			<td>
				<select class="w120" name="type_id" id="type_id" data-val="true" data-val-required="请选择合同类型！">
					<option value="">--请选择--</option>
					<c:forEach items="${typeList}" var="item" varStatus="vs">  
						<option value="${item.id}" <c:if test="${model.type_id== item.id}">selected="selected"</c:if>>${item.name }</option>
					</c:forEach>
				</select>
				<span class="field-validation-error" data-valmsg-for="type_id"
						data-valmsg-replace="true"></span>
			</td>
			<th>合同签订日期：</th>
			<td>
				<input id="sign_date" class="inp_t inp_w100 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"
				 onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"  name="sign_date" value="<fmt:formatDate value="${model.sign_date}" pattern="yyyy-MM-dd" />" />
			</td>
		</tr>
		<tr>
			<th class="w60"><span class="c_red">*</span>合同生效日期：</th>					
			<td>
				<input id="valid_date" class="inp_t inp_w130 search_sel ico_date" 
				onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_date\')}'})"
                  onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_date\')}'})" 
                  name="valid_date"  data-val="true" data-val-required="请选择合同生效日期！" value="<fmt:formatDate value="${model.valid_date}" pattern="yyyy-MM-dd" />" />
				<span class="field-validation-error" data-valmsg-for="valid_date"
						data-valmsg-replace="true"></span>
			</td>
			<th class="w60"><span class="c_red">*</span>合同终止日期：</th>					
			<td>
				<input id="end_date" class="inp_t inp_w130 search_sel ico_date" 
				onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'valid_date\')}'})"
                  onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'valid_date\')}'})" 
                  name="end_date"  data-val="true" data-val-required="请选择合同终止日期！" value="<fmt:formatDate value="${model.end_date}" pattern="yyyy-MM-dd" />" />
				<span class="field-validation-error" data-valmsg-for="end_date"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th>合同是否已解除：</th>
			<td>
				<label><input type="radio" class="state" name="state" value="4" <c:if test="${model.state==4 }">checked="checked"</c:if> />是</label>
				<label class="ml10"><input type="radio" class="state" name="state" value="0" <c:if test="${model.state!=4|| empty model.state}">checked="checked"</c:if> />否</label>
			</td>
			<th class="closeCon ${model.state==4?'':'dn' } ">合同解除日期</th>
			<td class="closeCon ${model.state==4?'':'dn' } ">
				<input id="relieve_date" class="inp_t inp_w130 search_sel ico_date" 
				onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_date\')}',minDate:'#F{$dp.$D(\'valid_date\')}'})"
                  onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'end_date\')}',minDate:'#F{$dp.$D(\'valid_date\')}'})" 
                  name="relieve_date"  data-val="true" data-val-required="请选择合同解除日期！" value="<fmt:formatDate value="${model.relieve_date}" pattern="yyyy-MM-dd" />" />
				<span class="field-validation-error" data-valmsg-for="relieve_date"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="">附件：</th>
			<td colspan="3">
				<span class="btn btn_pub"><a href="file/add.do" id="btn_create">新建</a></span>
				<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_upload">上传</a></span>
				<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_batch_upload">批量上传</a></span>
				<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_select">从文件夹选择</a></span>
				
				<div>
					<div id="file_container" class="dib inp_t mail_input">
						 <c:if test="${model.files != null && !model.files.isEmpty()}">
						 	<c:forEach items="${model.files}" var="item" varStatus="vs">
								<span id="file_item_${vs.index}" class="user_child file_item" onclick="file.remove('file_item_${vs.index}');">
									${item.name}<em title="删除" class="del_user">×</em>
		            				<input type="hidden" name="files[${vs.index}].type" value="${item.type}" />
					            	<input type="hidden" name="files[${vs.index}].url" value="${item.url}" />
					            	<input type="hidden" name="files[${vs.index}].name" value="${item.name}" />
					            	<input type="hidden" name="files[${vs.index}].file_id" value="${item.file_id}" />
					            	<input type="hidden" name="files[${vs.index}].sort" value="${item.sort}" />
					            </span>
							</c:forEach>
						 </c:if>
					</div>
				</div>
			</td>
		</tr>
		<tr>
			<th class="vtop">备注:&nbsp;</th>
			<td colspan="3">
				<textarea cols="60" rows="5" name="remark" class="inp_t form_ta">${model.remark}</textarea>
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
<script type="text/javascript" src="static/js/kindeditor-4.1.4/kindeditor.js"></script>
<script type="text/javascript" src="static/js/kindeditor-4.1.4/lang/zh_CN.js"></script>
<script type="text/javascript" src="static/js/biz/file.js"></script>
<script type="text/javascript">
	$(function(){
		//智能搜索工程名称
        $('#name').autocomplete({
            serviceUrl: 'staff/autoStaff',
            hiddenId: 'staff_id',
            mapping: { id: 'id', name: 'name' },
            params: { Time: +new Date() },
            onSelect: function () {
                var $EngineeringName = $(this);
                var $EngineeringNameError = $(this).parent().find("#staffError");
                $EngineeringName.removeClass("input-validation-error").addClass("valid");
                $EngineeringNameError.addClass("dn").html("");
            }
        });
		
		$(".state").change(function(){
			var $this=$(this);
			$("#relieve_date").val('');
			$("#relieve_date").removeClass("input-validation-error").addClass("valid").next().addClass("field-validation-valid").removeClass("field-validation-error").html("");
			if($this.val()==4)
			{
				$(".closeCon").removeClass("dn");
			}else
			{
				$(".closeCon").addClass("dn");
			}
		});
		
     // 【人员】文本框的blur事件
        $("#name").blur(function () {
            CheckEngineering(1);
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
    		
    		return flag;
    	}); 
        
     	// 初始化附件操作
	    file.init({
	    	batchUpload: {
				sizeLimit: Number('${sizeLimit}'),
				uploadLimit: Number('${uploadLimit}'),
				fileTypes: '${fileTypes}'
	    	}
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
        var $this = $("#name");
        var flag = true;
        var $EngineeringNameError = $("#staffError");
        if (!util.isEmpty($this.val())) {
            if ($this.next("input:hidden").size() == 0 && type == 2) {
                $this.addClass("input-validation-error").removeClass("valid");
                $EngineeringNameError.removeClass("dn").html("请重新选择人员！");
                flag = false;
            }
            else {
                $this.removeClass("input-validation-error").addClass("valid");
                $EngineeringNameError.addClass("dn").html("");
            }
        }
        else {
        	$this.addClass("input-validation-error").removeClass("valid");
            $EngineeringNameError.removeClass("dn").html("请输入人员！");
            flag = false;
        }
        return flag;
    }
</script>