<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w60"><span class="c_red">*</span>标题：</th>
			<td colspan="3">
				<input type="text" class="inp_t" data-val="true"
				data-val-required="请输入标题！" id="title" name="title"
				data-val-remote-url="care/validateTitle.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.title,*.id" 
				data-val-remote="该标题已存在！" 
				value="${model.title}" />
				<span class="field-validation-error" data-valmsg-for="title"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="">附件：</th>
			<td  colspan="3">
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
			<th>来源</th>
			<td>
				<input type="text" class="inp_t" id="source" name="source" value="${model.source}" />
			</td>
			<th>浏览次数</th>
			<td>
				<input type="text" class="inp_t" id="browse_count" name="browse_count" value="${model.browse_count}"
				 data-val="true" data-val-regex="浏览次数只能够输入整数！" data-val-regex-pattern="^\d+$"	 />
				<span class="field-validation-error" data-valmsg-for="browse_count"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th>作者</th>
			<td class="w300">
				<input type="text" class="inp_t" id="author" name="author" value="${model.author}" />
			</td>
			<th class="w70"><span class="c_red">*</span>分类</th>
			<td>
				<select class="w86" id="type_id" name="type_id" data-val="true" data-val-required="请选择分类！">
					<option value="">--请选择--</option>
					<c:forEach items="${typeList }" var="item" varStatus="vs">
						<option value="${item.id }" <c:if test="${model.type_id==item.id }">selected="selected"</c:if> >${item.name }</option>
					</c:forEach>
				</select>
				<span class="field-validation-error" data-valmsg-for="type_id" data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class=""><span class="c_red">*</span>内容:&nbsp;</th>
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
	var opener = art.dialog.open.origin;
	$(function(){
		
		if(opener.$("#type_id").val()!="" && $("#type_id").val()==""){
			$("#type_id option[value='"+opener.$("#type_id").val()+"']").attr("selected","selected");
		}
		//发送click事件
	    $("#btnSave").click(function(){
			var flag=true;
			// 调用jquery.validate.unobtrusive.js 提供的验证方法 
	        function validate() {
	            var validationInfo = $('#data_form').data('unobtrusiveValidation');
	            return !validationInfo || !validationInfo.validate || validationInfo.validate();
	        }
	        flag = validate() && flag;
			if(flag) {
				var content = editorAgreement.html();
				if(util.isEmpty(content)){
					informationMsg("请输入内容！");
					return false;
				}
				$("#content").val(content);
			}
			
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
		 
	  //正文在线编辑器
		var editorAgreement = KindEditor.create('#content_div', {
	        allowFileManager: false,
	        height: '260px',
	        width: '700px',
	        extraParams: {
	        	isFromEditor: true
	        }
	 	});
	});
	function backToList(result) {
		if (result.flag) {
			successMsg("保存成功！", function() {
				
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