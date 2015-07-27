<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<input type="hidden" name="user_id" id="user_id" value="${model.user_id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th><span class="c_red">*</span>标题：</th>
			<td colspan="3">
				<input type="text" class="inp_t w400" data-val="true"
				data-val-required="请输入标题！" id="title" name="title"
				data-val-remote-url="advice/validateTitle.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.title,*.id" 
				data-val-remote="该标题已存在！" 
				value="${model.title}" />
				<span class="field-validation-error" data-valmsg-for="title"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="w85"><span class="c_red">*</span>系统用户：</th>
			<td class="w35per">
				<div id="innerUser" class="dib main_inpt">
					<c:if test="${!empty model.user_id }">
						<span class="user_child" key_id="${model.user_id }" key_name="${model.user_name }">${model.user_name }<em class="del_user">×</em></span>
					</c:if>
				</div>
				<a href="javascript:(0);" id="addInner">选择</a>
			</td>
			<th class="w85"><span class="c_red">*</span>主题：</th>
			<td>
				<select name="topic_id" class="topic_id"  data-val="true" data-val-required="请选择主题！">
					<option value="">--请选择--</option>
					<c:forEach items="${topicList }" var="item" varStatus="vs">
						<option value="${item.id }" <c:if test="${item.id==model.topic_id }">selected="selected"</c:if> >${item.name }</option>
					</c:forEach>
				</select>
				<span class="field-validation-error" data-valmsg-for="topic_id"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th>是否匿名：</th>
			<td>
				<label><input type="radio" class="is_anonymous" name="is_anonymous" value="1" <c:if test="${model.is_anonymous || empty model.is_anonymous}">checked="checked"</c:if> />是</label>
				<label class="ml10"><input type="radio" class="is_anonymous" name="is_anonymous" value="0" <c:if test="${!model.is_anonymous}">checked="checked"</c:if> />否</label>
			</td>
			<th>紧急程度：</th>
			<td>
				<label><input type="radio" class="urgency" name="urgency" value="1" <c:if test="${model.urgency==1 || empty model.urgency}">checked="checked"</c:if> />一般</label>
				<label class="ml10"><input type="radio" class="urgency" name="urgency" value="2" <c:if test="${model.urgency==2}">checked="checked"</c:if> />重要</label>
				<label class="ml10"><input type="radio" class="urgency" name="urgency" value="23" <c:if test="${model.urgency==3}">checked="checked"</c:if> />紧急</label>
			</td>
		</tr>
		<tr>
			<th>复杂度：</th>
			<td>
				<label><input type="radio" class="complexity" name="complexity" value="1" <c:if test="${model.complexity==1 || empty model.complexity}">checked="checked"</c:if> />一般</label>
				<label class="ml10"><input type="radio" class="complexity" name="complexity" value="2" <c:if test="${model.complexity==2}">checked="checked"</c:if> />复杂</label>
			</td>
			<th><span class="c_red">*</span>信件类型：</th>
			<td>
				<select name="type" class="type"  data-val="true" data-val-required="请选择信件类型！">
					<option value="">--请选择--</option>
					<option value="1" <c:if test="${model.type==1 }">selected="selected"</c:if> >申诉</option>
					<option value="2" <c:if test="${model.type==2 }">selected="selected"</c:if> >求决</option>
					<option value="3" <c:if test="${model.type==3 }">selected="selected"</c:if> >举报投诉</option>
					<option value="4" <c:if test="${model.type==4 }">selected="selected"</c:if> >反映建议</option>
					<option value="5" <c:if test="${model.type==5 }">selected="selected"</c:if> >其它咨询</option>
				</select>
				<span class="field-validation-error" data-valmsg-for="type"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="vtop">内容:&nbsp;</th>
			<td colspan="3">
				<textarea cols="60" rows="5" name="content" class="inp_t form_ta">${model.content}</textarea>
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
<script type="text/javascript">
$(function(){
	
	$("#btnSave").click(function(){
		 function validate() {
            var validationInfo = $('form:eq(0)').data('unobtrusiveValidation');
            return !validationInfo || !validationInfo.validate || validationInfo.validate();
        }
        var flag = false;
        flag = validate();
        if(flag)
		 {
			var $item=$("#innerUser .user_child");
			if(!util.isNull($item.attr("key_id"))){
				$("#user_id").val($item.attr("key_id"));
			}else{
				$("#user_id").val('');
				informationMsg("请选择系统用户！")
				flag = false;
			}
		 }
        return flag;
		
	});
	
	//选择系统用户
	$("#addInner").click(function(){
		var url = 'user/sellist.do?key_v=3&is_my=true';
		openPage({
			url:url,
			id:'sel_page',
			title:'选择系统用户',
			width:'800px',
			height:'470px'
		});
		return false;
	});
	
	//删除用户
	$(".del_user").live("click",function(){
		$(this).parents(".user_child").remove();
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