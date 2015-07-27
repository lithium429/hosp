<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap"> 
		<form id="data_form" method="post" action="user/update.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<input type="hidden" name="id" id="id" value="${model.id}"/> 
			<input type="hidden" name="has_address" id="has_address" value="${model.has_address}"/> 
			<input type="hidden" id="role_ids" name="role_ids" value="${model.getroleIds() }"/>
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w100"><span class="c_red">*</span>用户名:&nbsp;</th>
						<td class="w260">
							<input type="text" class="inp_t" data-val="true" 
							data-val-remote-url="user/validateName.do" 
							data-val-remote-type="POST" 
							data-val-remote-additionalfields="*.name,*.id" 
							data-val-remote="该用户名已存在！"
							data-val-required="请输入用户名！" id="name" name="name" value="${model.name}" />
							<span class="field-validation-error" data-valmsg-for="name" data-valmsg-replace="true"></span>
						</td>
						<th class="w95"><span class="c_red">*</span>部门科室:&nbsp;</th>
						<td>
							<select id="dept_id" name="dept_id" data-val="true" data-val-required="请选择部门科室！">
								<option value="">--请选择--</option>
								<c:forEach items="${departmentList }" var="item" varStatus="vs">
									<option value="${item.id}" <c:if test="${model.dept_id==item.id}">selected="selected"</c:if> >${gdf:buildTreeName(item.name, item.layer)}</option>
								</c:forEach>
							</select>
							<span class="field-validation-error" data-valmsg-for="dept_id" data-valmsg-replace="true"></span>
						</td>
						
					</tr>
					<tr>
						<th><span class="c_red">*</span>姓名:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" data-val="true" data-val-required="请输入姓名！" id="real_name" name="real_name" value="${model.real_name}" />
							<span class="field-validation-error" data-valmsg-for="real_name" data-valmsg-replace="true"></span>
						</td>
						<th><span class="c_red">*</span>所属角色:&nbsp;</th>
						<td>
							<select id="role_id" name="role_id" multiple="multiple" class="w100">
								<option value="">--请选择--</option>
								<c:forEach items="${roleList }" var="item" varStatus="vs">
									<option value="${item.id }" <c:if test="${model.roleIds!=null &&  model.getroleListIds().contains(item.id)}">selected="selected"</c:if>>${item.name }</option>
								</c:forEach>
							</select>
							<span class="error dn" id="role_error">请选择所属角色！</span>
						</td>
					</tr>
					<tr>
						<th><span class="c_red">*</span>手机:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" data-val="true" data-val-required="请输入手机！" id="mobile" name="mobile" value="${model.mobile}"  maxlength="11" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
							<span class="field-validation-error" data-valmsg-for="mobile" data-valmsg-replace="true"></span>
						</td>
						<th><span class="c_red">*</span>邮箱:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" data-val="true" data-val-required="请输入邮箱！" data-val-email="您输入的邮箱不合法！" id="email" name="email" value="${model.email}" />
							<span class="field-validation-error" data-valmsg-for="email" data-valmsg-replace="true"></span>
						</td>
					</tr>
					<tr>
						<th><span class="c_red">*</span>职位类型:&nbsp;</th>
						<td>
							<select id="ptype" name="ptype">
								<option value="type_1" <c:if test="${model.ptype == 'type_1'}">selected="selected"</c:if>>普通人员</option>
								<option value="type_2" <c:if test="${model.ptype == 'type_2'}">selected="selected"</c:if>>科主任</option>
								<option value="type_3" <c:if test="${model.ptype == 'type_3'}">selected="selected"</c:if>>职能科室科长</option>
								<option value="type_4" <c:if test="${model.ptype == 'type_4'}">selected="selected"</c:if>>分管院长</option>
								<option value="type_5" <c:if test="${model.ptype == 'type_5'}">selected="selected"</c:if>>院长</option>
							</select>
						</td>
						<th>状态:&nbsp;</th>
						<td>
							<select id="state" name="state" class="w100">
								<option value="1" <c:if test="${model.state == 1 }">selected="selected"</c:if>>正常</option>
								<option value="2" <c:if test="${model.state == 2 }">selected="selected"</c:if>>冻结</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>性别:&nbsp;</th>
						<td>
							<label><input type="radio" name="sex" value="1" <c:if test="${model.sex==1}">checked="checked"</c:if> />男</label>
							<label><input type="radio" class="ml10" name="sex" value="2" <c:if test="${model.sex==2}">checked="checked"</c:if> />女</label>
						</td>
						<th>QQ:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" id="qq" name="qq" value="${model.qq}" />
						</td>
					</tr>
					<tr>
						<th>短信外发权限:&nbsp;</th>
						<td colspan="3">
							<input type="radio" name="is_allowso" value="true" <c:if test="${model.is_allowso}">checked="checked"</c:if> />有
							<input type="radio" class="ml10" name="is_allowso" value="false"  <c:if test="${!model.is_allowso}">checked="checked"</c:if>/>无
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
						<td></td>
						<td class="ptb10">
							<span class="btn btn_pub">
								<input id="btn_save" type="submit" value="保存" />
							</span>
							<span class="ml10 btn btn_base">
								<input type="button" id="btn_pclose" value="取消" />
							</span>
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<!-- E 添加信息 -->
	<script type="text/javascript">
	var opener = art.dialog.open.origin;
	$(function(){
		if(opener.$("#department_id").val()!="")
		{
			$("#dept_id option[value='"+opener.$("#department_id").val()+"']").attr("selected","selected");
		}
		$("#role_id").multiSelect({ oneOrMoreSelected: '*' });
		$('#role_id').blur(checkUserInfos);
		$("#btn_save").click(function(){
			var flag=true,role_ids=$("#role_ids").val();
	 		
			// 调用jquery.validate.unobtrusive.js 提供的验证方法 
	        function validate() {
	            var validationInfo = $('#data_form').data('unobtrusiveValidation');
	            return !validationInfo || !validationInfo.validate || validationInfo.validate();
	        }
	        flag=validate()&&flag;
	        falg=checkUserInfos()&&flag;
	        return flag;
	        
		});
	});
	
	 function checkUserInfos() {
	    var userInfoObj = $('#role_id'),
	    values = userInfoObj.selectedValuesString();
	    $("#role_ids").val(values);
	    if($("#role_ids").val()=="")
    	{
	    	$("#role_error").removeClass("dn");
	    	return false;
    	}else
   		{
    		$("#role_error").addClass("dn");
	    	return true;
   		}
	}
		function backToList(result) {
			if (result.flag) {
				successMsg(result.msg ? result.msg : "保存成功！", function() {
					var opener = art.dialog.open.origin;
					opener.$('#spec_form').submit();
					closeDialog();
				});
			} else {
				errorMsg(result.msg ? result.msg : "保存失败！");
			}
		}

		function showError() {
			errorMsg("修改用户时出错！");
		} 
	</script>
</gd:PopLayout>