<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap"> 
		<form id="data_form" method="post" action="user/update_user.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<input type="hidden" name="id" id="id" value="${model.id}"/> 
			<input type="hidden" name="has_address" id="has_address" value="${model.has_address}"/> 
			<input type="hidden" id="role_ids" name="role_ids" value="${model.getroleIds() }"/>
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w100"><span class="c_red">*</span>用户名:&nbsp;</th>
						<td class="w260">
							${model.name}
						</td>
						<th class="w95"><span class="c_red">*</span>部门科室:&nbsp;</th>
						<td>
							${model.dept_name}
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
							<c:forEach items="${model.roles}" var="temp" varStatus="vs1">
								<c:if test="${vs1.index!=0 }">,</c:if>${temp.role_name }
							</c:forEach>
						</td>
					</tr>
					<tr>
						<th><span class="c_red">*</span>手机:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" data-val="true" data-val-required="请输入手机！" id="mobile" name="mobile" value="${model.mobile}"  maxlength="12" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
							<span class="field-validation-error" data-valmsg-for="mobile" data-valmsg-replace="true"></span>
						</td>
						<th><span class="c_red">*</span>邮箱:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" data-val="true" data-val-required="请输入邮箱！" data-val-email="您输入的邮箱不合法！" id="email" name="email" value="${model.email}" />
							<span class="field-validation-error" data-valmsg-for="email" data-valmsg-replace="true"></span>
						</td>
					</tr>
					<tr>
						<th>性别:&nbsp;</th>
						<td>
							<label><input type="radio" name="sex" value="1" <c:if test="${model.sex==1}">checked="checked"</c:if> />男</label>
							<label><input type="radio" class="ml10" name="sex" value="2" <c:if test="${model.sex==2}">checked="checked"</c:if> />女</label>
						</td>
						<th>状态:&nbsp;</th>
						<td>
							<c:choose>
								<c:when test="${model.state==1 }">正常</c:when>
								<c:when test="${model.state==2 }">冻结</c:when>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>QQ:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" id="qq" name="qq" value="${model.qq}" />
						</td>
						<th>短信外发权限:&nbsp;</th>
						<td >
							<c:choose>
								<c:when test="${model.is_allowso }">有</c:when>
								<c:when test="${!model.is_allowso }">无</c:when>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th class="vtop">备注:&nbsp;</th>
						<td colspan="3">
							${model.remark}
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
		
	});
	
	 
		function backToList(result) {
			if (result.flag) {
				successMsg("保存成功！", function() {
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