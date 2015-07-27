<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<input type="hidden" id="user_ids" name="user_ids" value="${model.gainUserIds()}" />
<input type="hidden" id="layer" name="layer" value="${model.layer}" />
<input type="hidden" id="parent_id" name="parent_id" value="${model.parent_id}" />
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w20per"><span class="c_red">*</span>名称：</th>
			<td>
				<input type="text" class="inp_t" data-val="true" data-val-required="请输入板块名称！" id="name" name="name" value="${model.name}" />
				<span class="field-validation-error" data-valmsg-for="name"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th class="w20per">排序：</th>
			<td>
				<input type="text" class="inp_t" id="sort" name="sort" value="${model.sort}" />
			</td>
		</tr>
		<tr>
			<th>版主：</th>
			<td>
				<div id="innerUser" class="dib main_inpt">
					<c:forEach items="${model.users}" var="item" varStatus="vs">
						<span class="user_child" key_id="${item.user_id }" key_name="${item.user_real_name }">${item.user_real_name }<em class="del_user">×</em></span>
					</c:forEach>	
				</div>
				<a href="javascript:(0);" id="addInner">添加</a> 
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
	$(function(){
		//添加内部用户
		$("#addInner").click(function(){
			var url = 'user/sellist.do?key_v=1&is_my=true';
			openPage({
				url:url,
				id:'sel_page',
				title:'选择版主 ',
				width:'800px',
				height:'475px'
			});
			return false;
		});
		
		//删除用户
		$(".del_user").live("click",function(){
			$(this).parents(".user_child").remove();
		});
		
		$('#btn_save').click(function(){
			var idArray = [];
			$("#innerUser .user_child").each(function(){
				var id = $(this).attr("key_id");
				idArray.push(id);
			}); 
			$("#user_ids").val(idArray.join(','));
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