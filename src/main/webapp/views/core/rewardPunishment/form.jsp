<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w80">奖惩属性：</th>
			<td class="w320">
				<label><input type="radio" class="type" name="type" value="1" <c:if test="${model.type==1|| empty model.type }">checked="checked"</c:if> />奖励</label>
				<label class="ml10"><input type="radio" class="type" name="type" value="2" <c:if test="${model.type==2}">checked="checked"</c:if> />惩罚</label>
			</td>
			<th class="w80"><span class="c_red">*</span>人员：</th>
			<td class="">
				<input type="text" class="inp_t"  id="name" name="name" value="<c:if test="${!empty model.staff_id }">${model.name}(${model.user_code })</c:if>" />
				<c:if test="${!empty model.id }"><input type="hidden" id="staff_id" name="staff_id" value="${model.staff_id }" /></c:if>
				<span id="staffError" class="red error dn"></span>
			</td>
		</tr>
		<tr>
			<th class=""><span class="c_red">*</span>奖惩名目：</th>
			<td >
				<input type="text" class="inp_t"  id="item_name" name="item_name" value="<c:if test="${!empty model.item_id }">${model.item_name}</c:if>" />
				<c:if test="${!empty model.id }"><input type="hidden" id="item_id" name="item_id" value="${model.item_id }" /></c:if>
				<span id="itemError" class="red error dn"></span>
			</td>
			<th>奖惩日期：</th>
			<td>
				<input id="rp_date" class="inp_t inp_w100 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"
				 onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"  name="rp_date" value="<fmt:formatDate value="${model.rp_date}" pattern="yyyy-MM-dd" />" />
			</td>
		</tr>
		<tr>
			<th>授予单位：</th>
			<td colspan="3">
				<input type="text" class="inp_t w500"  id="unit" name="unit" value="${model.unit}" />
			</td>
		</tr>
		<tr>
			<th>奖惩金额：</th>
			<td colspan="3">
				<input type="text" name="amount" data-val="true" data-val-regex="奖惩金额只能够输入的正数！" data-val-regex-pattern="^([1-9][0-9]*(\.\d+)?)|(0\.\d+)$" class="inp_t" value="${model.amount}" />&nbsp;
				<span class="field-validation-valid" data-valmsg-for="amount" data-valmsg-replace="true"></span>			</td>
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
			<th class="vtop">奖惩内容:&nbsp;</th>
			<td colspan="3">
				<textarea cols="100" rows="10" name="content" class="inp_t form_ta">${model.content}</textarea>
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
                var $EngineeringName = $("#name");
                var $EngineeringNameError = $("#staffError");
                $EngineeringName.removeClass("input-validation-error").addClass("valid");
                $EngineeringNameError.addClass("dn").html("");
            }
        });
		
        $('#item_name').autocomplete({
            serviceUrl: 'rpItem/autoItem',
            hiddenId: 'item_id',
            mapping: { id: 'id', name: 'name' },
            params: { Time: +new Date() },
            onSelect: function () {
                var $EngineeringName = $("#item_name");
                var $EngineeringNameError = $("#itemError");
                $EngineeringName.removeClass("input-validation-error").addClass("valid");
                $EngineeringNameError.addClass("dn").html("");
            }
        });
		
    	 // 【人员】文本框的blur事件
        $("#name").blur(function () {
            CheckEngineering(1);
        });
    	 
    	 // 【奖惩名目】文本框的blur事件
        $("#item_name").blur(function () {
            CheckItem(1);
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
            flag=CheckItem(2)&&flag;
    		
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
	
 	// 检查奖惩名目【type=1是鼠标离开的时候触发的，type=2是点击提交按钮触发的】
    function CheckItem(type) {
        var $this = $("#item_name");
        var flag = true;
        var $EngineeringNameError = $("#itemError");
        if (!util.isEmpty($this.val())) {
            if ($this.next("input:hidden").size() == 0 && type == 2) {
                $this.addClass("input-validation-error").removeClass("valid");
                $EngineeringNameError.removeClass("dn").html("请重新选择奖惩名目！");
                flag = false;
            }
            else {
                $this.removeClass("input-validation-error").addClass("valid");
                $EngineeringNameError.addClass("dn").html("");
            }
        }
        else {
        	$this.addClass("input-validation-error").removeClass("valid");
            $EngineeringNameError.removeClass("dn").html("请输入奖惩名目！");
            flag = false;
        }
        return flag;
    }
</script>