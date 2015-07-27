<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="forum/thread/move.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w120"><span class="c_red">*</span>目标板块：</th>
						<td>
							 <input type="hidden" name="id" value="${id}" />
							 <select id="plate_id" name="plate_id">
								<option value="">--请选择--</option>
								<c:forEach items="${plateList}" var="item" varStatus="vs">
									<option value="${item.id}" <c:if test="${item.id == plate_id}">selected="selected"</c:if> <c:if test="${item.layer == 1}">disabled="disabled"</c:if>>
										${gdf:buildTreeName(item.name, item.layer)}
									</option>
								</c:forEach>
							</select>
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
			<script type="text/javascript">
				var opener = art.dialog.open.origin; 
				
				function backToList(result) {
					if (result.flag) {
						successMsg("保存成功！", function() {
							opener.window.location.reload();
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
	<!-- E 添加信息 -->
</gd:PopLayout>
