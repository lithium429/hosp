<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap user_info_form">
		<form id="data_form" method="post" action="address/add.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<input type="hidden" id="user_ids" name="addressUserIds"/>
			<input type="hidden" id="id" name="id"/>
			<input type="hidden" id="type" name="type" value="${type }"/>
			<div class="t_c photo_box">
					<div class="pic"><img id="img4" class="img4" width="160px" height="160px" src="<c:if test="${empty model.img_url}">static/images/photo.jpg</c:if><c:if test="${!empty model.img_url}">${model.img_url}</c:if>"></div> 
					<input type="hidden" class="inp_t inp_w120" id="img_url" name="img_url" value="${model.img_url}">
				    <span class="btn btn_pub"><input type="button" value="上传" id="uploadImg" /></span><span class="ml8 btn btn_base"><input type="button" value="清除" id="clearImg" /></span>
					<c:if test="${type==2 }">
					<span class="show mt5"><label><input type="radio" checked="checked" class="is_share" name="is_share" value="false" />不共享</label>
					<label class="cf60"><input type="radio" class="ml10 is_share" name="is_share" value="true" />共享</label></span></c:if>
			</div>
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w60"><span class="c_red">*</span>姓名:&nbsp;</th>
						<td class="w250">
							<input type="text" class="inp_t" data-val="true" data-val-required="请输入姓名！" id="name" name="name" value="" />
							<span class="field-validation-error" data-valmsg-for="name" data-valmsg-replace="true"></span>
						</td>
						<th class="w60">性别:&nbsp;</th>
						<td>
							<input type="radio" checked="checked" class="" name="sex" value="1" />男
							<input type="radio" class="ml10" name="sex" value="2" />女
						</td>
					</tr>
					<tr>
						<c:choose>
							<c:when test="${type==1 }">
								<th class="">部门科室:&nbsp;</th>
								<td>
									<select class="w86" id="dept_id" name="dept_id">
										<c:forEach items="${departmentList }" var="item" varStatus="vs">
											<c:choose>
												<c:when test="${item.layer == 1}">
													<optgroup label="${item.name}"</optgroup>
												</c:when>
												<c:otherwise>
													<option value="${item.id }">${item.name }</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</td>
							</c:when>
							<c:when test="${type==2 }">
								<th class="">群组:&nbsp;</th>
								<td>
									<select class="w86" id="group_id" name="group_id">
										<option value="">默认</option>
										<c:forEach items="${groupList }" var="item" varStatus="vs">
											<option value="${item.id }">${item.name }</option>
										</c:forEach>
									</select>
								</td>
							</c:when>
						</c:choose>
						<th class=""><span class="c_red">*</span>邮箱:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" data-val="true" data-val-required="请输入邮箱！" 
							 data-val-email="您输入的邮箱不合法！" id="email" name="email" value="" />
							<span class="field-validation-error" data-valmsg-for="email" data-valmsg-replace="true"></span>
						</td>
					</tr>
					<tr>
						<th class=""><span class="c_red">*</span>手机:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" data-val="true" data-val-required="请输入手机！" id="mobile" name="mobile" value="" maxlength="11" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
							<span class="field-validation-error" data-valmsg-for="mobile" data-valmsg-replace="true"></span>
						</td>
						<th class="">QQ:&nbsp;</th>
						<td>
							<input type="text" class="inp_t" id="qq" name="qq" value="" />
						</td>
					</tr>
					<tr>
						<th class="">职位:&nbsp;</th>
						<td colspan="3">
							<input type="text" class="inp_t" id="post" name="post" value="" />
						</td>
					</tr>
					<tr>
						<th class="">工作单位:&nbsp;</th>
						<td colspan="3">
							<input type="text" class="inp_t w200" id="company" name="company" value="" />
						</td>
					</tr>
					<tr>
						<th class="">联系地址:&nbsp;</th>
						<td colspan="3">
							<input type="text" class="inp_t w200" id="address" name="address" value="" />
						</td>
					</tr>
					<tr>
						<th class="vtop">备注:&nbsp;</th>
						<td colspan="3">
							<textarea cols="60" rows="5" name="remark" class="inp_t form_ta">${model.remark}</textarea>
						</td>
					</tr>
					<c:if test="${type==2 }">
					<tr id="user_nameTr" class="dn">
						<th class="">共享用户:&nbsp;</th>
						<td colspan="3">
						<textarea cols="60" rows="5" name="user_names" id="user_names" class="inp_t form_ta" disabled="disabled"></textarea>
						<a href="user/sellist.do" id="addUser">添加</a>
						<a href="javascrpt:(0);" class="ml10" id="clearUser">清除</a>
						</td>
					</tr></c:if>
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
	
	<script type="text/javascript" src="static/js/kindeditor-4.1.4/kindeditor.js"></script>
	<script type="text/javascript" src="static/js/kindeditor-4.1.4/lang/zh_CN.js"></script>
	<!-- E 添加信息 -->
	<script type="text/javascript">
	var opener = art.dialog.open.origin;
	var type=$("#type").val();
	$(function(){
		var editorML = KindEditor.editor({
			allowFileManager : true
		});

	    //上传图片
		$("#uploadImg").click(function() {
			editorML.loadPlugin('image', function() {
				editorML.plugin.imageDialog({
					imageUrl : $('#img_url').val(),
					clickFn : function(url, title, width, height, border, align, realName) {
							$('#img_url').val(url);
							successMsg('上传成功');
							$("#img4").attr("src", $('#img_url').val());
							editorML.hideDialog();
						}
					});
				});
			return false;
		});
	    
	    //是否共享选择
	    $(".is_share").change(function(){
	    	var $this=$(this);
	    	$("#user_ids,#user_names").val('');
	    	if($this.val()=="true")
    		{
	    		$("#user_nameTr").removeClass("dn");
    		}else
    		{
    			$("#user_nameTr").addClass("dn");
    		}
	    });
	    
	    //清除图片
	    $("#clearImg").click(function(){
	    	$("#img4").attr("src", 'static/images/photo.jpg');
	    	$('#img_url').val('');
	    });
	    
	    //清除共享用户
	    $("#clearUser").click(function(){
	    	$('#user_ids,#user_names').val('');
	    });
	    
	    //选择共享用户
	    $("#addUser").click(function(){
	    	var url = $(this).attr('href');
			openPage({
				url:url,
				id:'sel_page',
				title:'选择共享用户',
				width:'800px',
				height:'475px'
			});
			return false;
	    });
	    
	    
	    
	    //设置默认值
		if(opener.$("#dept_id").val()!="")
		{
			$("#dept_id option[value='"+opener.$("#dept_id").val()+"']").attr("selected","selected");
		}
		if(opener.$("#group_id").val()!="")
		{
			$("#group_id option[value='"+opener.$("#group_id").val()+"']").attr("selected","selected");
		}
		
	});
	 
	function backToList(result) {
		if (result.flag) {
			successMsg(result.msg ? result.msg : "保存成功！", function() {
				opener.$('#is_share1,#dept_id1,#group_id1').val('');
				if(type==1)
				{
					opener.$('#dept_id1').val(opener.$("#dept_id").val());
				}else
				{
					opener.$('#is_share1').val(opener.$("#is_share").val());
					opener.$('#group_id1').val(opener.$("#group_id").val());
				}
				opener.$("#list_type").val(2);
				opener.$('#spec_form').submit();
				closeDialog();
			});
		} else {
			errorMsg(result.msg ? result.msg : "保存失败！");
		}
	}

		function showError() {
			errorMsg("添加用户时出错！");
		}
	</script>
</gd:PopLayout>
