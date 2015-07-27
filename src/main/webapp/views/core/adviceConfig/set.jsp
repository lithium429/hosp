<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<gd:Navgation addlink="" addr="院长书记信箱  &gt; 信箱设置"></gd:Navgation>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap">
		<form id="data_form" method="post" action="adviceConfig/set.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<input type="hidden" name="id" value="${model.id}" />
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w10per">受理说明:&nbsp;</th>
						<td>
							<input type="hidden" id="instruction" name="instruction" value="" />
							<div id="instruction_div" >${model.instruction }</div>
						</td>
					</tr>
					<tr>
						<th class="">管理办法:&nbsp;</th>
						<td>
							<input type="hidden" id="regulation" name="regulation" value="" />
							<div id="regulation_div" >${model.regulation }</div>
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
			<script type="text/javascript">
			$(function(){
				 //正文在线编辑器
				var editorAgreement = KindEditor.create('#instruction_div', {
			        allowFileManager: false,
			        height: '260px',
			        width: '700px',
			        extraParams: {
			        	isFromEditor: true
			        }
			 	});
				 
				 //正文在线编辑器
				var editorAgreement1 = KindEditor.create('#regulation_div', {
			        allowFileManager: false,
			        height: '260px',
			        width: '700px',
			        extraParams: {
			        	isFromEditor: true
			        }
			 	});
				 
				 $("#btnSave").click(function(){
					 var flag=true;
						// 调用jquery.validate.unobtrusive.js 提供的验证方法 
				        function validate() {
				            var validationInfo = $('#data_form').data('unobtrusiveValidation');
				            return !validationInfo || !validationInfo.validate || validationInfo.validate();
				        }
				        flag = validate() && flag;
						if(flag) {
							var instruction = editorAgreement.html();
							var regulation = editorAgreement1.html();
							$("#instruction").val(instruction);
							$("#regulation").val(regulation);
						}
						
						return flag;
				 });
			});
				function backToList(result) {
					if (result.flag) {
						successMsg("保存成功！", function() {
							location.reload();
						});
					} else {
						errorMsg(result.msg);
					}
				}
			
				function showError(result) {
					errorMsg(result.msg);
				}
				
			</script>
		</form>
	</div>
	<!-- E 添加信息 -->
</gd:PopLayout>
