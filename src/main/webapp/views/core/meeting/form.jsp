<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<input type="hidden" id="user_ids" name="user_ids" value="${model.getUserIds() }"/>
<input type="hidden" id="verify_state" name="verify_state" value="${model.verify_state }"/>
<input type="hidden" id="state" name="state" value="${model.state }"/>
<table class="view wc100">
	<tbody>
		<tr>
			<th class=""><span class="c_red">*</span>会议主题：</th>
			<td colspan="3">
				<input type="text" class="inp_t w400" data-val="true"
				data-val-required="请输入会议主题！" id="subject" name="subject"
				data-val-remote-url="meeting/validateSubject.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.subject,*.id" 
				data-val-remote="该会议主题已存在！" 
				value="${model.subject}" />
				<span class="field-validation-error" data-valmsg-for="subject"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class=""><span class="c_red">*</span>会议出席人：</th>
			<td colspan="3">
				<div id="innerUser" class="dib main_inpt">
					<c:forEach items="${model.users}" var="item" varStatus="vs">
						<span class="user_child" key_id="${item.user_id }" key_name="${item.user_name }">${item.user_name }<em class="del_user">×</em></span>
					</c:forEach>	
				</div>
				<a href="javascript:(0);" id="addInner">添加</a>
				<span class="error dn" id="user_error">请选择会议出席人！</span>	
				
				<%-- <input type="text" class="inp_t w400" data-val="true" readonly="readonly"
				data-val-required="请输入会议出席人！" id="user_names" name="user_names"
				value="${model.getUserNames()}" />
				<a href="user/sellist.do?is_my=true" id="addUser">添加</a>
				<a href="javascrpt:(0);" class="ml10" id="clearUser">清除</a>
				<span class="field-validation-error" data-valmsg-for="user_names"
						data-valmsg-replace="true"></span> --%>
			</td>
		</tr>
		<tr>
			<th class="w12per">会议主持人：</th>
			<td class="w35per">
				<input type="text" class="inp_t"  id="holder" name="holder" value="${model.holder}" />
			</td>
			<th class="w12per"><span class="c_red">*</span>会议室：</th>
			<td class="">
				<select class="w86" id="room_id" name="room_id" data-val="true" data-val-required="请选择会议室！" >
					<option value="">--请选择--</option>
					<c:forEach items="${roomList }" var="item" varStatus="vs">
						<option value="${item.id }" <c:if test="${model.room_id==item.id }">selected="selected"</c:if>>${item.name }</option>
					</c:forEach>
				</select>
				<span class="field-validation-error" data-valmsg-for="room_id"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class=""><span class="c_red">*</span>会议开始时间：</th>
			<td class="">
				<input id="begin_time" class="inp_t inp_w140 search_sel ico_date" data-val="true" data-val-required="请选择会议开始时间！" 
				 onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_time\')}',minDate:'%y-%M-%d'})"
				 onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'end_time\')}',minDate:'%y-%M-%d'})"  name="begin_time" value="<fmt:formatDate value="${model.begin_time}" pattern="yyyy-MM-dd HH:mm" />" />
				<span class="field-validation-error" data-valmsg-for="begin_time"
						data-valmsg-replace="true"></span>
			</td>
			<th class=""><span class="c_red">*</span>会议结束时间：</th>
			<td class="">
				<input id="end_time" class="inp_t inp_w140 search_sel ico_date" data-val="true" data-val-required="请选择会议结束时间！" 
				onclick="endDateClick()" onfocus="endDateClick()"  name="end_time" value="<fmt:formatDate value="${model.end_time}" pattern="yyyy-MM-dd HH:mm" />"  />
				<span class="field-validation-error" data-valmsg-for="end_time"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="">会议提醒：</th>
			<td colspan="3">
				<label><input type="checkbox" value="true" name="is_send_umsg" <c:if test="${model.is_send_umsg }">checked="checked"</c:if> />发送事务提醒</label>
				<label class="ml8"><input type="checkbox" value="true" name="is_send_smsg" <c:if test="${model.is_send_smsg }">checked="checked"</c:if> />发送短信提醒</label>
			</td>
		</tr>
		<tr>
			<th class="">会议设置：</th>
			<td colspan="3">
				提前<input type="text" name="remind_time" class="inp_t w80 num2" value="${model.remind_time }" />小时提醒
			</td>
		</tr>
		<tr>
			<th class="vtop">会议内容:&nbsp;</th>
			<td colspan="3">
				<textarea cols="60" rows="5" name="content" class="inp_t form_ta">${model.content}</textarea>
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
		var num2Reg = /^\d+\.?\d*$/;       // 验证小数
		$(".num2").blur(function () {
		    var target = $(this), 
		    value = target.val();
		    if (!util.isEmpty(value)) {
		        if (!num2Reg.test(value)) {
		            informationMsg("请输入大于等于0的整数或小数！");
		            target.val('').focus();
		            return false;
		        }
		    }
		});
		
		//添加内部用户
		$("#addInner").click(function(){
			var url = 'user/sellist.do?key_v=1&is_my=true';
			openPage({
				url:url,
				id:'sel_page',
				title:'选择会议出席人',
				width:'800px',
				height:'475px'
			});
			return false;
		});
		
		//删除用户
		$(".del_user").live("click",function(){
			$(this).parents(".user_child").remove();
		});
		
		$("#btnSave").click(function(){
			var flag=true;
			function validate() {
	            var validationInfo = $('#data_form').data('unobtrusiveValidation');
	            return !validationInfo || !validationInfo.validate || validationInfo.validate();
	        }
	        flag=validate()&&flag;
			var innerUsers="",outerUsers="";
			$("#innerUser .user_child").each(function(){
				var $this=$(this);
				if(innerUsers=="")
				{
					innerUsers=$this.attr("key_id");
				}else
				{
					innerUsers+=","+$this.attr("key_id");
				}
			});
			if(flag && innerUsers=="")
			{
				informationMsg("请选择内部人员！");
				return false;
			}
			$("#user_ids").val(innerUsers);
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
	
	function endDateClick() {
		var minDate = '%y-%M-%d';
	    if ($("#begin_time").val() != "") {
	        minDate = $("#begin_time").val();
	    }
	    WdatePicker({readyOnly:true, dateFmt:'yyyy-MM-dd HH:mm',minDate:minDate });
	}
	
</script>