<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<c:if test="${empty from_user_center}">
	<input type="hidden" name="plate_id" value="${model.plate_id}" />
</c:if>
<input type="hidden" name="id" value="${model.id}" />
<table class="view wc100">
	<tbody>
		<c:if test="${!empty from_user_center}">
			<tr>
				<th class="w120"><span class="c_red">*</span>所属板块：</th>
				<td>
					<select id="plate_id" name="plate_id">
						<c:forEach items="${plateList}" var="item" varStatus="vs">
							<option value="${item.id}" <c:if test="${item.layer == 1}">disabled="disabled"</c:if>>
								${gdf:buildTreeName(item.name, item.layer)}
							</option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</c:if>
		<tr>
			<th <c:if test="${empty from_user_center}">class="w60"</c:if>><span class="c_red">*</span>主题：</th>
			<td>
				<input type="text" id="subject" name="subject" class="inp_t" value="${model.subject}" maxlength="80" onkeyup="util.checkLen(this, '#length_tip', 80);" style="width:25em" />
				<span>还可输入 <strong id="length_tip">80</strong> 个字符</span> 
			</td>
		</tr>
		<tr>
			<th><span class="c_red">*</span>内容：</th>
			<td>
				<div id="content_div">${model.content}</div>
				<input type="hidden" id="content" name="content" value="" />
			</td>
		</tr> 
		<tr>
			<th><span>附件：</span></th>
			<td>
				<span class="btn btn_pub"><a href="file/add.do" id="btn_create">新建</a></span>
				<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_upload">上传</a></span>
				<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_batch_upload">批量上传</a></span>
				<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_select">从文件夹选择</a></span>
				
				<div>
					<div id="file_container" class="dib inp_t mail_input">
						 <c:if test="${model.files != null && !model.files.isEmpty()}">
						 	<c:forEach items="${model.files}" var="item" varStatus="vs">
								<span id="file_item_${vs.index}" class="user_child file_item" onclick="file.remove('file_item_${vs.index}');">
									${item.name}<em title="删除" class="del_user">×</em>
		            				<input type="hidden" name="files[${vs.index}].type" value="${item.type}" />
					            	<input type="hidden" name="files[${vs.index}].url" value="${item.url}" />
					            	<input type="hidden" name="files[${vs.index}].name" value="${item.name}" />
					            	<input type="hidden" name="files[${vs.index}].file_id" value="${item.file_id}" />
					            	<input type="hidden" name="files[${vs.index}].sort" value="${item.sort}" />
					            </span>
							</c:forEach>
						 </c:if>
					</div>
				</div>
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
<script type="text/javascript" src="static/js/kindeditor-4.1.4/kindeditor.js"></script>
<script type="text/javascript" src="static/js/kindeditor-4.1.4/lang/zh_CN.js"></script>
<script type="text/javascript" src="static/js/biz/file.js"></script>
<script type="text/javascript">
	var opener = art.dialog.open.origin;
	$(function(){
		//正文在线编辑器
		var editor = KindEditor.create('#content_div', {
	        allowFileManager: false,
	        height: '280px',
	        width: '720px',
	        extraParams: {
	        	isFromEditor: true
	        }
     	});
		
		// 初始化附件操作
	    file.init({
	    	batchUpload: {
				sizeLimit: Number('${sizeLimit}'),
				uploadLimit: Number('${uploadLimit}'),
				fileTypes: '${fileTypes}'
	    	}
	    }); 
		
		$('#btn_save').click(function(){			
			function infoDialog(msg){
				showDialog({
			        time: 2,
			        content: msg || '',
			        icon: 'warning',
			        close: true,
			        button: [{
			            name: '关闭',
			            focus: true
			        }]
			    })
			}
			
			var plateId = $('#plate_id').val(), 
			subject = $('#subject').val(),
			content = editor.html(); 
			
			if(util.isEmpty(subject)){
				infoDialog('请输入帖子主题！');
				return false;
			}
			else if(util.isEmpty(content)){
				infoDialog('请输入帖子内容！');
				return false;
			} 
			$('#content').val(content);
		});  
	
	});
	
	function backToList(result) {
		if (result.flag) {
			successMsg("保存成功！", function() {
				if(!util.isEmpty(result.obj) && !util.isEmpty('${from}')){
					opener.window.location.href = '${baseUrl}forum/thread/' + result.obj + '.shtml';
				}
				else{
					opener.window.location.reload();
					closeDialog();					
				}
			});
		} else {
			errorMsg(result.msg);
		}
	}

	function showError(result) {
		errorMsg(result.msg);
	}
</script>