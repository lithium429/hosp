<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<input type="hidden" name="dept_ids" id="dept_ids" value="${model.getDeptIds()}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w65"><span class="c_red">*</span>标题:&nbsp;</th>
			<td class="w260">
				<input type="text" class="inp_t" data-val="true"
				data-val-required="请输入标题！" id="title" name="title"
				data-val-remote-url="announcement/validateTitle.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.title,*.id" 
				data-val-remote="该标题已存在！" 
				value="${model.title}" />
				<span class="field-validation-error" data-valmsg-for="title"
						data-valmsg-replace="true"></span>
			</td>
			<th class="w70"><span class="c_red">*</span>公告类型:&nbsp;</th>
			<td>
				<select class="w86" id="type_id" name="type_id" data-val="true" data-val-required="请选择公告类型！">
					<option value="">--请选择--</option>
					<c:forEach items="${typeList }" var="item" varStatus="vs">
						<option value="${item.id }" <c:if test="${model.type_id==item.id }">selected="selected"</c:if> >${item.name }</option>
					</c:forEach>
				</select>
				<span class="field-validation-error" data-valmsg-for="type_id" data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th>
				生效日期:&nbsp;
			</th>
			<td>
				<input id="valid_date" class="inp_t inp_w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_date\')}',minDate:'%y-%M-%d'})"
				 onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_date\')}',minDate:'%y-%M-%d'})"  name="valid_date" value="<fmt:formatDate value="${model.valid_date}" pattern="yyyy-MM-dd HH:mm" />" />
			</td>
			<th>
				终止日期:&nbsp;
			</th>
			<td>
				<input id="end_date" class="inp_t inp_w140 search_sel ico_date" onclick="endDateClick()" onfocus="endDateClick()"  name="end_date" value="<fmt:formatDate value="${model.end_date}" pattern="yyyy-MM-dd HH:mm" />"  />
			</td>
		</tr>
		<tr>
			<th>
				范围&nbsp;
			</th>
			<td >	
				<label><input type="radio" class="is_show_all" name="is_show_all" value="true" <c:if test="${!empty model.id && model.is_show_all}">checked="checked"</c:if> />所有部门可见</label>
				<label><input type="radio" class="is_show_all ml10" name="is_show_all" value="false" <c:if test="${empty model.id || !model.is_show_all}">checked="checked"</c:if> />指定部门可见</label>
			</td>
			<td colspan="2" id="dept_id_td" class="${empty model.id || !model.is_show_all?'vv':'vh' }">
				<select id="dept_id" multiple="multiple" name="dept_id" >
					<option value="">--全部--</option>
					<c:forEach items="${deptList }" var="item" varStatus="vs">
						<option value="${item.id}" <c:if test="${model.judgeDeptId(item.id)}">selected="selected"</c:if>>${gdf:buildTreeName(item.name, item.layer)}</option>
					</c:forEach>
				</select>
			<span class="error dn" id="dept_error">请选择指定部门！</span>
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
			<th class="vtop">内容:&nbsp;</th>
			<td colspan="3">
				<input type="hidden" id="content" name="content" value="" />
				<div id="content_div" >${model.content }</div>
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
<script type="text/javascript" src="static/js/kindeditor-4.1.4/kindeditor.js"></script>
<script type="text/javascript" src="static/js/kindeditor-4.1.4/lang/zh_CN.js"></script>
<script type="text/javascript" src="static/js/biz/file.js"></script>
<script type="text/javascript">
$(function(){
	$(".is_show_all").change(function(){
		var $this=$(this);
		if($this.val()=="false")
		{
			$("#dept_id_td").addClass("vv").removeClass("vh");
		}else
		{
			$("#dept_id_td").addClass("vh").removeClass("vv");
		}
		$("#dept_error").addClass("dn");
	});
	$("#dept_id").multiSelect({ oneOrMoreSelected: '*', optGroupSelectable: true });
	$('#dept_id').blur(checkUserInfos);
	
	$("#btnSave").click(function(){
		var flag=true,role_ids=$("#role_ids").val();
 		
		// 调用jquery.validate.unobtrusive.js 提供的验证方法 
        function validate() {
            var validationInfo = $('#data_form').data('unobtrusiveValidation');
            return !validationInfo || !validationInfo.validate || validationInfo.validate();
        }
        flag=validate()&&flag;
        flag=checkUserInfos()&&flag;
        if(flag){
        	$("#content").val(editorAgreement.html());  
        }
        return flag;
	});
	
	//正文在线编辑器
	var editorAgreement = KindEditor.create('#content_div', {
        allowFileManager: false,
        height: '260px',
        width: '700px',
        extraParams: {
        	isFromEditor: true
        }
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

function checkUserInfos() {
    var userInfoObj = $('#dept_id'),
    values = userInfoObj.selectedValuesString();
    $("#dept_ids").val(values);
    if($("#dept_ids").val()=="" && $(".is_show_all:checked").val()=="false"){
    	$("#dept_error").removeClass("dn");
    	return false;
	}else{
		$("#dept_error").addClass("dn");
    	return true;
	}
}

function endDateClick() {
	var minDate = '%y-%M-%d';
    if ($("#valid_date").val() != "") {
        minDate = $("#valid_date").val();
    }
    WdatePicker({readyOnly:true, dateFmt:'yyyy-MM-dd HH:mm',minDate:minDate });
}

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
	
	
</script>