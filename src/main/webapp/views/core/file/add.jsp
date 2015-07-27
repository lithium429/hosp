<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<table class="view wc100">
			<tbody>
				<tr>
					<th class="w15per"><span class="c_red">*</span>文件类型:&nbsp;</th>
					<td>
						<label><input type="radio" name="type" value="1" checked="checked" />Word文档</label>
						<label><input type="radio" name="type" value="2" />Excel文档</label>
						<label><input type="radio" name="type" value="3" />PPT文档</label>
					</td> 
				</tr> 
				<tr>
					<th><span class="c_red">*</span>文件名:&nbsp;</th>
					<td>
						<input type="text" class="inp_t" id="name" name="name" value="新建文件" />
						<span class="error dn" id="error_name">请输入文件名！</span>
					</td> 
				</tr> 
			</tbody>
			<tfoot>
				<tr> 
					<td></td>
					<td class="ptb10"> 
						<span class="btn btn_pub">
							<input id="btn_save" type="button" value="新建文件" />
						</span>
					</td>
				</tr>
			</tfoot>
		</table> 
	</div>
	<!-- E 添加信息 -->
	<script type="text/javascript">
		$(function(){
			function check(){
				var name = $('#name').val();
				if(util.isEmpty(name)){
					$('#error_name').show();
					return false;
				}
				else {
					$('#error_name').hide();
					return true;
				}
			}
			
			$('#name').blur(check);
			$('#btn_save').click(function(){
				var flag = check();
				if(flag){
					openPage({
						url: 'file/new.do?moduleType=${moduleType}&directoryId=${directoryId}',
						id: 'new_file_page',
						title: '新建文件',
						width: '100%',
						height: '100%',
						init: function(){   
							if(browser.isIE){
								$('.aui_close:last', art.dialog.top.parent.document).attr('style', 'visibility:hidden;');
							}
						}
					});
				}
			});
		});
		
		// 刷新父页面列表
		function refreshParent(obj){ 
			var opener = art.dialog.open.origin;
			if(util.isEmpty('${from}')){
				opener.$('#spec_form').submit();
			}
			// 如果是附件上传
			else if('${from}' === 'attachment'){
				opener.file.setItem({
					type: '1',
					url: obj.url,
            		name: obj.name,
            		file_id: ''
				});
			}
		} 
		
	</script>
</gd:PopLayout>
