<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="directory/share.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<input type="hidden" name="ids" value="${ids}" />
			<input type="hidden" id="is_share_all" name="is_share_all" value="true" />
			<input type="hidden" id="dept_ids" name="dept_ids" value="" />
			
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w15per"><span class="c_red">*</span>范围:&nbsp;</th>
						<td>
							<label><input type="radio" id="share_all" name="share_type" value="1" checked="checked" />所有部门</label>
							<label><input type="radio" id="share_dept" name="share_type" value="2" />指定部门</label> 
						</td> 
					</tr> 
					<tr id="share_dept_tr">
						<th><span class="c_red">*</span>共享部门:&nbsp;</th>
						<td>
							<select id="dept_id" multiple="multiple" name="dept_id" >
								<option value="">--全部--</option>
								<c:forEach items="${deptList }" var="item" varStatus="vs">
									<option value="${item.id}">${gdf:buildTreeName(item.name, item.layer)}</option>
								</c:forEach>
							</select>
							<span id="error_dept_id" class="error dn">请选择共享部门！</span>
						</td> 
					</tr> 
				</tbody>
				<tfoot>
					<tr> 
						<td></td>
						<td class="ptb10"> 
							<span class="btn btn_pub">
									<input type="submit" id="btn_save" value="保存" />
							</span><span class="ml10 btn btn_base"> <input type="button"
									id="btn_pclose" value="取消">
							</span>
						</td>
					</tr>
				</tfoot>
			</table> 
		</form>
	</div>
	<!-- E 添加信息 -->
	<script type="text/javascript">
		$(function(){
			$('#share_all').click(function(){
				$('#share_dept_tr').hide();
				$('#is_share_all').val('true');
			});
			
			$('#share_dept').click(function(){
				$('#share_dept_tr').show();
				$('#is_share_all').val('false');
			});
			
			$("#dept_id").multiSelect({ oneOrMoreSelected: '*', optGroupSelectable: true });
			$('#dept_id').blur(checkDeptIds);
			$('#share_dept_tr').hide();
			
			$('#btn_save').click(function(){
				var flag = $('#is_share_all').val() == 'false'; 
				if(flag){
					flag = flag && checkDeptIds() ;
				}
				else{
					flag = true;
				}
				return flag;
			}); 
		}); 
		
		function checkDeptIds() {
		    var deptObj = $('#dept_id'),
		    values = deptObj.selectedValuesString();
		    if(util.isEmpty(values)){
		    	$('#error_dept_id').removeClass('dn');
		    	return false;
		    }
		    $("#dept_ids").val(values);
		    $('#error_dept_id').addClass('dn');
		    return true;
		}
		
		function backToList(result) {
			if (result.flag) {
				successMsg("共享成功！", function() {
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
