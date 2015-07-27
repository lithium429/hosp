<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="leaveInfo/add.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<%@ include file="form.jsp"%>
			<div class="btn_area">
				<span class="btn btn_pub">
					<input type="submit" id="btn_save" value="保存" />
				</span>
				<span class="ml10 btn btn_base">
					<input type="button" id="btn_pclose" value="取消" />
				</span> 
			</div>
		</form>
	</div>
	<!-- E 添加信息 -->
	<script type="text/javascript">
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
</gd:PopLayout>
