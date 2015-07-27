<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w80"><span class="c_red">*</span>标题：&nbsp;</th>
			<td class="w260">
				<input type="text" class="inp_t w160" data-val="true"
				data-val-required="请输入标题！" id="title" name="title"
				data-val-remote-url="publicityColumn/validateTitle.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.title,*.id" 
				data-val-remote="该标题已存在！" 
				value="${model.title}" maxlength="40" />
				<span class="field-validation-error" data-valmsg-for="title"
						data-valmsg-replace="true"></span>
			</td> 
		</tr> 
		<th><span class="c_red">*</span>公示类型：&nbsp;</th>
		<td>
			<select id="type" name="type" data-val="true" data-val-required="请选择公示类型！">
				<option value="1" <c:if test="${model.type == 1}">selected="selected"</c:if>>院务公开栏</option>
				<option value="2" <c:if test="${model.type == 2}">selected="selected"</c:if>>党务公开栏</option>
				<option value="3" <c:if test="${model.type == 3}">selected="selected"</c:if>>奖惩公示栏</option>
				<option value="4" <c:if test="${model.type == 4}">selected="selected"</c:if>>其它</option>
			</select> 
		</td>
		<tr>
			<th>附件：&nbsp;</th>
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
			<th class="vtop">内容：&nbsp;</th>
			<td colspan="3">
				<input type="hidden" id="content" name="content" value="" />
				<div id="content_div" >${model.content }</div>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td class="btn_area" colspan="2"><span class="btn btn_pub">
					<input type="submit" id="btn_save" value="保存" />
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
		 
		$("#btn_save").click(function(){
			var content = editor.html();
	    	$("#content").val(content);   
		});
		
		//正文在线编辑器
		var editor = KindEditor.create('#content_div', {
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