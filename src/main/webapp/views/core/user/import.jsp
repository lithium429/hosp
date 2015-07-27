<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%> 
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<input type="hidden" id="success_info" value="${successInfo}" />
		<div class="dn euser">
			${euserJson}
		</div>
		<div class="dn duser">
			${duserJson}
		</div>
		<form id="data_form" method="post" action="user/import.do" enctype="multipart/form-data">       
			<table class="wc100">
				<tbody>
					<tr>
						<th class="w60">文件<span class="c_red">*</span></th>
						<td>
							<input type="file" id="excel_file" name="excel_file" />
							<span id="excel_file_error" class="ml10 error dn">请选择要导入的文件！</span>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2" class="btn_area">
							<span class="btn btn_pub">
								<input type="submit" id="btn_save" value="导入数据" />
							</span><span class="ml10 btn btn_base"> <input type="button" id="btn_pclose" value="取消"  />
							</span>
							<c:if test="${!empty errorInfo}">
								<span id="error_info" class="ml10 error">${errorInfo}</span>
							</c:if> 
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<!-- E 添加信息 -->
	<script type="text/javascript">
		$(function(){
			$('#excel_file').blur(checkFile).select(checkFile);
			$('#btn_save').click(function() {
				var flag = checkFile();
				return flag;
			});

			var successInfo = $('#success_info').val();
			if (!util.isEmpty(successInfo)) {
				successMsg(successInfo);
			}
			//浏览点击触发事件
			$("#excel_file").click(function(){
				$("#error_info").hide();
			});				
		}); 

		// 验证选择的文件
		function checkFile() {
			return util.checkItem('#excel_file', '#excel_file_error');
		}
	</script>
</gd:PopLayout>
