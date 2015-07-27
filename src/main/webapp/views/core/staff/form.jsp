<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<input type="hidden" name="id" value="${model.id}" />
<input type="hidden" name="user_id" id="user_id" value="${model.user_id}" />
<div class="t_c photo_box">
		<div class="pic"><img id="img4" class="img4" width="160px" height="160px" src="<c:if test="${empty model.photo}">static/images/photo.jpg</c:if><c:if test="${!empty model.photo}">${model.photo}</c:if>"></div> 
		<input type="hidden" class="inp_t inp_w120" id="photo" name="photo" value="${model.photo}">
	    <span class="btn btn_pub"><input type="button" value="上传" id="uploadImg" /></span><span class="ml8 btn btn_base"><input type="button" value="清除" id="clearImg" /></span>	
</div>
<table class="view wc100">
	<tbody>
		<tr>
			<th class="w95">系统用户：</th>
			<td class="w300">
				<div id="innerUser" class="dib main_inpt">
					<c:if test="${!empty model.user_id }">
						<span class="user_child" key_id="${model.user_id }" key_name="${model.user_name }">${model.user_name }<em class="del_user">×</em></span>
					</c:if>
				</div>
				<a href="javascript:(0);" id="addInner">选择</a>
			</td>
			<th class="w80"><span class="c_red">*</span>姓名：</th>
			<td>
				<input type="text" class="inp_t" data-val="true"
				data-val-required="请输入姓名！" id="name" name="name"
				value="${model.name}" />
				<span class="field-validation-error" data-valmsg-for="name"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th><span class="c_red">*</span>工号：</th>
			<td>
				<input type="text" class="inp_t" data-val="true"
				data-val-required="请输入工号！" id="code" name="code"
				data-val-remote-url="staff/validateCode.do" 
				data-val-remote-type="POST" 
				data-val-remote-additionalfields="*.code,*.id" 
				data-val-remote="该工号已存在！"
				value="${model.code}" />
				<span class="field-validation-error" data-valmsg-for="code"
						data-valmsg-replace="true"></span>
			</td>
			<th>性别：</th>
			<td>
				<label><input type="radio" class="sex" name="sex" value="1" <c:if test="${model.sex==1 || empty model.sex}">checked="checked"</c:if> />男</label>
				<label class="ml10"><input type="radio" class="sex" name="sex" value="2" <c:if test="${model.sex==2}">checked="checked"</c:if> />女</label>
			</td>
		</tr>
		<tr>
			<th><span class="c_red">*</span>身份证号：</th>
			<td>
				<input type="text" class="inp_t w150" data-val="true" onblur="CheckCarId(true)"
				data-val-required="请输入身份证号！" id="id_number" name="id_number"
				value="${model.id_number}" />
				<span class="field-validation-error" data-valmsg-for="id_number"
						data-valmsg-replace="true"></span>
			</td>
			<th><span class="c_red">*</span>出生日期：</th>
			<td>
				<input id="birthday" class="inp_t inp_w100 search_sel ico_date" data-val="true" data-val-required="请选择出生日期！" 
				 onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"
				 onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"  name="birthday" value="<fmt:formatDate value="${model.birthday}" pattern="yyyy-MM-dd" />" />
				<span class="field-validation-error" data-valmsg-for="birthday"
						data-valmsg-replace="true"></span>
			</td>
		</tr>
		<tr>
			<th>详细地址：</th>
			<td colspan="3">
				<input class="inp_t w500" id="address" name="address"  type="text" value="${model.address }">
			</td>
		</tr>
		<tr>
			<th>籍贯：</th>
			<td>
				<input class="inp_t" id="native_place" name="native_place"  type="text" value="${model.native_place }">
			</td>
			<th>民族：</th>
			<td>
				<select class="w86" name="nation">
					<c:forEach items="${nationArray}" var="item" varStatus="vs">  
						<option value="${vs.index+1 }" <c:if test="${model.nation== vs.index+1}">selected="selected"</c:if>>${item }</option>
					</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<th>婚姻状况：</th>
			<td>
				<select class="w86" name="marital_status">
					<option value="1" <c:if test="${model.marital_status==1}">selected="selected"</c:if>>未婚</option>
					<option value="2" <c:if test="${model.marital_status==2}">selected="selected"</c:if>>已婚</option>
					<option value="3" <c:if test="${model.marital_status==3}">selected="selected"</c:if>>离异</option>
					<option value="4" <c:if test="${model.marital_status==4}">selected="selected"</c:if>>丧偶</option>
				</select>
			</td>
			<th>政治面貌：</th>
			<td>
				<select class="w86" name="political_status">
					<option value="1" <c:if test="${model.political_status==1}">selected="selected"</c:if>>群众</option>
					<option value="2" <c:if test="${model.political_status==2}">selected="selected"</c:if>>共青团员</option>
					<option value="3" <c:if test="${model.political_status==3}">selected="selected"</c:if>>中共党员</option>
					<option value="4" <c:if test="${model.political_status==4}">selected="selected"</c:if>>中共预备党员</option>
					<option value="5" <c:if test="${model.political_status==5}">selected="selected"</c:if>>民主党派</option>
					<option value="6" <c:if test="${model.political_status==6}">selected="selected"</c:if>>无党派人士</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>员工类型：</th>
			<td>
				<select class="w86" name="marital_status">
					<option value="1" <c:if test="${model.marital_status==1}">selected="selected"</c:if>>合同工</option>
					<option value="2" <c:if test="${model.marital_status==2}">selected="selected"</c:if>>正式员工</option>
					<option value="3" <c:if test="${model.marital_status==3}">selected="selected"</c:if>>临时工</option>
				</select>
			</td>
			<th>职务：</th>
			<td>
				<input class="inp_t" id="post" name="post"  type="text" value="${model.post }">
			</td>
		</tr>
		<tr>
			<th>技术职称：</th>
			<td>
				<input class="inp_t" id="post_title" name="post_title"  type="text" value="${model.post_title }">
			</td>
			<th>职称级别：</th>
			<td>
				<select class="w86" name="post_title_level">
					<option value="1" <c:if test="${model.post_title_level==1}">selected="selected"</c:if>>初级</option>
					<option value="2" <c:if test="${model.post_title_level==2}">selected="selected"</c:if>>中级</option>
					<option value="3" <c:if test="${model.post_title_level==3}">selected="selected"</c:if>>副高</option>
					<option value="4" <c:if test="${model.post_title_level==4}">selected="selected"</c:if>>正高</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>考勤排班类型：</th>
			<td>
				<select class="w86" name="scheduling_type">
					<option value="1" <c:if test="${model.scheduling_type==1}">selected="selected"</c:if>>正常班</option>
					<option value="2" <c:if test="${model.scheduling_type==2}">selected="selected"</c:if>>全日班</option>
					<option value="3" <c:if test="${model.scheduling_type==3}">selected="selected"</c:if>>轮班制</option>
				</select>
			</td>
			<th>固定电话：</th>
			<td>
				<input class="inp_t" id="phone" name="phone"  type="text" value="${model.phone }">
			</td>
		</tr>
		<tr>
			<th>手机：</th>
			<td>
				<input class="inp_t" id="mobile" name="mobile"  maxlength="11" type="text" value="${model.mobile }">
			</td>
			<th>邮箱：</th>
			<td>
				<input class="inp_t" id="email" name="email"  type="text" value="${model.email }">
			</td>
		</tr>
		<tr>
			<th>QQ：</th>
			<td>
				<input class="inp_t" id="qq" name="qq" class="qq" type="text" value="${model.qq }">
			</td>
			<th>入职日期：</th>
			<td>
				<input id="entry_date" class="inp_t inp_w100 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"
				 onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"  name="entry_date" value="<fmt:formatDate value="${model.entry_date}" pattern="yyyy-MM-dd" />" />
			</td>
		</tr>
		<tr>
			<th>学历：</th>
			<td>
				<select class="w86" name="education">
					<c:forEach items="${educationArray}" var="item" varStatus="vs">  
						<option value="${vs.index+1 }" <c:if test="${model.education== vs.index+1}">selected="selected"</c:if>>${item }</option>
					</c:forEach>
				</select>
			</td>
			<th>毕业日期：</th>
			<td>
				<input id="graduate_date" class="inp_t inp_w100 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"
						                            onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"  name="graduate_date" value="<fmt:formatDate value="${model.graduate_date}" pattern="yyyy-MM-dd" />" />
			</td>
		</tr>
		<tr>
			<th>毕业学校：</th>
			<td colspan="3">
				<input class="inp_t w500" id="graduate_school" name="graduate_school"  type="text" value="${model.graduate_school }">
			</td>
		</tr>
		<tr>
			<th class="vtop">备注:&nbsp;</th>
			<td colspan="3">
				<textarea cols="60" rows="5" name="remark" class="inp_t form_ta">${model.remark}</textarea>
			</td>
		</tr>
		<tr>
			<th class="vtop">简历:&nbsp;</th>
			<td colspan="3">
				<input type="hidden" id="resume" name="resume" value="${model.resume }" />
				<div id="resume_div" >${model.resume }</div>
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
<script type="text/javascript" src="static/js/CheckCardId.js"></script>
<script type="text/javascript">
$(function(){
	
	$("#btnSave").click(function(){
		 function validate() {
             var validationInfo = $('form:eq(0)').data('unobtrusiveValidation');
             return !validationInfo || !validationInfo.validate || validationInfo.validate();
         }
         var flag = false;
         flag = validate();
         flag = CheckCarId(false);
         if(flag)
 		 {
 			$("#resume").val(editorAgreement.html());  
 			var $item=$("#innerUser .user_child");
 			if(!util.isNull($item)){
 				$("#user_id").val($item.attr("key_id"));
 			}else{
 				$("#user_id").val('');
 			}
 		 }
         return flag;
		
	});
	
	var editorML = KindEditor.editor({
		allowFileManager : true
	});

    //上传图片
	$("#uploadImg").click(function() {
		editorML.loadPlugin('image', function() {
			editorML.plugin.imageDialog({
				imageUrl : $('#photo').val(),
				clickFn : function(url, title, width, height, border, align, realName) {
						$('#photo').val(url);
						successMsg('上传成功');
						$("#img4").attr("src", $('#photo').val());
						editorML.hideDialog();
					}
				});
			});
		return false;
	});
    
    //清除图片
    $("#clearImg").click(function(){
    	$("#img4").attr("src", 'static/images/photo.jpg');
    	$('#photo').val('');
    });
	
	//删除用户
	$(".del_user").live("click",function(){
		$(this).parents(".user_child").remove();
	});
	
	//选择系统用户
	$("#addInner").click(function(){
		var url = 'user/sellist.do?key_v=3&is_my=true';
		openPage({
			url:url,
			id:'sel_page',
			title:'选择系统用户',
			width:'800px',
			height:'400px'
		});
		return false;
	});
	
	//正文在线编辑器
	var editorAgreement = KindEditor.create('#resume_div', {
        allowFileManager: false,
        height: '260px',
        width: '700px',
        extraParams: {
        	isFromEditor: true
        }
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
	
	
	// 检查身份证编号是否合法
    function CheckCarId(IsShowBirthday) {
        var flag = true;
        var $carId = $("#id_number");
        var $birthday = $("#birthday");
        if ($carId.val() != "") {
            if (!checkIdNumber.check($carId.val())) {
                flag = false;
                $carId.removeClass("valid").addClass("input-validation-error").parent().find("span").removeClass("field-validation-valid").addClass("field-validation-error").html('<span class="" for="id_number" generated="true">身份证号输入不正确！</span>');
                if (IsShowBirthday && $birthday) {
                    $birthday.val("").addClass("input-validation-error").removeClass("valid").next("span").attr("class", "field-validation-error").html('<span class="" for="birthday" generated="true">请选择出生日期！</span>');
                }
            }
            else {
                var birthday = idcard_getbirthday($carId.val());
                $carId.removeClass("input-validation-error").addClass("valid").parent().find("span").empty();
                if (IsShowBirthday) {
                    $birthday.val(birthday);
                    if ($birthday.next("span").hasClass("field-validation-error")) {
                        $birthday.addClass("valid").removeClass("input-validation-error").next("span").empty().attr("class", "field-validation-valid");
                    }
                }
            }
        }
        return flag;
    }
</script>