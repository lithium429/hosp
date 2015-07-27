<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<div class="t_c photo_box">
	<h2>封面</h2>
	<div class="pic"><img id="img4" class="img4" width="118px" height="166px" src="<c:if test="${empty model.image_url}">static/images/emptyImage.jpg</c:if><c:if test="${!empty model.image_url}">${model.image_url}</c:if>"></div> 
	<input type="hidden" class="inp_t inp_w120" id="image_url" name="image_url" value="${model.image_url}">
    <span class="btn btn_pub"><input type="button" value="上传" id="uploadImg" /></span><span class="ml8 btn btn_base"><input type="button" value="清除" id="clearImg" /></span>
</div>
<table class="view wc100">
	<tbody>
		<tr>
			<th class=""><span class="c_red">*</span>书籍名称：</th>
			<td colspan="3">
				<input type="text" class="inp_t" data-val="true"
				data-val-required="请输入书籍名称！" id="name" name="name"
				data-val-remote-url="book/validateName.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.name,*.id" 
				data-val-remote="该书籍名称已存在！" 
				value="${model.name}" />
				<span class="field-validation-error" data-valmsg-for="name"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="w80"><span class="c_red">*</span>图书类型:&nbsp;</th>
			<td class="w300">
				<select class="w86" id="type_id" name="type_id" data-val="true" data-val-required="请选择图书类型！">
					<option value="">--请选择--</option>
					<c:forEach items="${typeList }" var="item" varStatus="vs">
						<option value="${item.id }" <c:if test="${model.type_id==item.id }">selected="selected"</c:if> >${item.name }</option>
					</c:forEach>
				</select>
				<span class="field-validation-error" data-valmsg-for="type_id" data-valmsg-replace="true"></span>
			</td>
			<th class="w70">作者：</th>
			<td>
				<input type="text" class="inp_t" id="author" name="author" value="${model.author}" />
			</td>
		</tr>
		<tr>
			<th>
				购买日期:&nbsp;
			</th>
			<td>
				<input id="buy_time" class="inp_t inp_w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"
				 onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"  name="buy_time" value="<fmt:formatDate value="${model.buy_time}" pattern="yyyy-MM-dd" />" />
			</td>
			<th>
				出版日期:&nbsp;
			</th>
			<td>
				<input id="publish_time" class="inp_t inp_w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"
				 onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"  name="publish_time" value="<fmt:formatDate value="${model.publish_time}" pattern="yyyy-MM-dd" />" />
			</td>
		</tr>
		<tr>
			<th class=""><span class="c_red">*</span>一维码编号:&nbsp;</th>
			<td colspan="3">
				<c:choose>
					<c:when test="${empty model.id }">
					<input type="text" class="inp_t" readonly="readonly" data-val="true"
					data-val-required="请输入一维码编号！" id="code" name="code" 
					value="${model.code}" />
					<span class="ml10 btn btn_pub">
							<input type="button" id="generate" value="生成" />
					</span>
					<span class="field-validation-error" data-valmsg-for="code"
							data-valmsg-replace="true"></span>
					</c:when>
					<c:otherwise>
					${model.code}
					</c:otherwise>
				</c:choose>
				
			</td>
		</tr>
		<tr>
			<th class="">备注:&nbsp;</th>
			<td colspan="3">
				<textarea cols="60" rows="5" name="remark" class="inp_t form_ta">${model.remark}</textarea>
			</td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td class="btn_area" colspan="4"><span class="btn btn_pub">
					<input type="submit" value="保存" />
			</span><span class="ml10 btn btn_base"> <input type="button"
					id="btn_pclose" value="取消">
			</span></td>
		</tr>
	</tfoot>
</table>
	<script type="text/javascript" src="static/js/kindeditor-4.1.4/kindeditor.js"></script>
	<script type="text/javascript" src="static/js/kindeditor-4.1.4/lang/zh_CN.js"></script>
<script type="text/javascript">
$(function(){
	var editorML = KindEditor.editor({
		allowFileManager : true
	});
	
	//上传图片
	$("#uploadImg").click(function() {
		editorML.loadPlugin('image', function() {
			editorML.plugin.imageDialog({
				imageUrl : $('#image_url').val(),
				clickFn : function(url, title, width, height, border, align, realName) {
						$('#image_url').val(url);
						successMsg('上传成功');
						$("#img4").attr("src", $('#image_url').val());
						editorML.hideDialog();
					}
				});
			});
		return false;
	});
	
	//清除图片
    $("#clearImg").click(function(){
    	$("#img4").attr("src", 'static/images/emptyImage.jpg');
    	$('#image_url').val('');
    });
	
	//生成
	$("#generate").click(function(){
		 $.ajax({
	 	        type: "POST",
	 	        url: "book/generateCode.do",
	 	        dataType: "json",
	 	        async :false,
	 	        success: function (data) {
	 	            if (data.flag) {
	 	            	$("#code").val(data.obj);
	 	            }
	
	 	        },
	 	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	 	            errorMsg("出现未知错误！");
	 	        },
	 	        complete: function(){
	 	        	$.ajaxTip.remove();
	 	        }
	 	    });
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