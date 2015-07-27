<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="bookBorrow/update.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-success="showError" novalidate="novalidate">
		   <input type="hidden" name="id"  value="${model.id}" />
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w100">
							<span class="c_red">*</span>预计还书时间:&nbsp;
						</th>
						<td>
							<input id="return_time" class="inp_t inp_w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})" data-val="true" data-val-required="请选择预计还书时间！"
							 onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"  name="return_time" value="<fmt:formatDate value="${model.return_time}" pattern="yyyy-MM-dd" />" />
							<span class="field-validation-error" data-valmsg-for="return_time"
									data-valmsg-replace="true"></span>
						</td>
					</tr>
					<tr>
						<th class="">图书类型:&nbsp;</th>
						<td class="">
							${model.type_name }
						</td>
					</tr>
					<tr>
						<td colspan="2" id="showTable">
							<table class="wc100 view_data">
						    <thead>
						    	<tr>
									<th class="w25per">书籍名称</th>
									<th class="w25per">一维编码</th>
									<th class="">封面图片</th>
							  	</tr>
						    </thead>
						   	<tbody>
					           	<tr >
						            <td>
						            	${model.name}
						            </td>
						            <td>
						            	${model.code}
						            </td>
						            <td>
						            	<img id="img4" class="img4" width="20px" height="40px" src="<c:if test="${empty model.image_url}">images/emptyImage.jpg</c:if><c:if test="${!empty model.image_url}">${model.image_url}</c:if>">
						            </td>
									</tr>      
						   	</tbody>
						   </table>
							
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td class="btn_area" colspan="4"><span class="btn btn_pub">
								<input type="submit" id="btnSave" value="保存" />
						</span><span class="ml10 btn btn_base"> <input type="button"
								id="btn_pclose" value="取消">
						</span></td>
					</tr>
				</tfoot>
			</table> 
			<script type="text/javascript">
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
					errorMsg(result.msg);
				}
			}
		
			function showError(result) {
				errorMsg(result.msg);
			}
				
			</script>
		</form>	
	</div>
</gd:PopLayout> 