<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="handlingProcess/haddle.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-success="showError" novalidate="novalidate">
			<input type="hidden" name="id" value="${model.id}" />
			<input type="hidden" name="user_id" id="user_id" value="" />
			<input type="hidden" name="state" id="state" value="${model.state}" />
			<input type="hidden" name="title" id="title" value="${model.title}" />
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w80">督办事宜：</th>
						<td class="w260">
							${model.title}
						</td>
						<th class="w80">编号：</th>
						<td class="">
							${model.code}
						</td>
					</tr>
					<tr>
						<th class="">创建人：</th>
						<td class="">
							${model.creator_name}
						</td>
						<th class="">创建日期：</th>
						<td class="">
							<fmt:formatDate value="${model.create_time}" pattern="yyyy-MM-dd" />	
						</td>
					</tr>
					<tr>
						<th class="">责任人：</th>
						<td class="">
							${model.user_name}
						</td>
						<th class="">办结日期：</th>
						<td class="">
							<fmt:formatDate value="${model.end_date}" pattern="yyyy-MM-dd" />	
						</td>
					</tr>
					<tr>
						<th class="vtop">事宜内容：</th>
						<td colspan="3">
							${model.content}
						</td>
					</tr>
					<tr>
						<th class="vtop">处理记录：</th>
						<td colspan="3">
							<table class="wc100 view_data">
								<thead>
									<tr>
										<th>处理人</th>
										<th>处理时间</th>
										<th>处理内容</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${model.records}" var="item" varStatus="vs">  
										<tr>
											<td>${item.user_name }</td>
											<td><fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd" /></td>
											<td>${item.content }</td>
										</tr>
									</c:forEach>
									<c:if test="${empty model.records}">
										<tr>
								        	<td colspan="3" class="t_c">
								                <span class="no-records">暂无数据</span>
								            </td>
								        </tr>
						        	</c:if>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<th class="vtop"><span class="c_red">*</span>处理内容:&nbsp;</th>
						<td colspan="3">
							<textarea cols="60" rows="5" name="haddle_content" class="inp_t form_ta" data-val="true" data-val-required="请输入处理内容！"></textarea>
							<span class="field-validation-error" data-valmsg-for="haddle_content"
									data-valmsg-replace="true"></span>
						</td>
					</tr>
					
					<tr>
						<th class="">移交责任人:&nbsp;</th>
						<td class="">
							<div id="innerUser" class="dib inp_t mail_input" style=" width:120px;">
								

							</div>
							<em class="btn btn_pub ml8">
								<input type="button" id="selUser"  value="选择" />
							</em>
							<span class="dn error" id="user_error">请选择移交责任人！</span>
						</td>
						<th>
							办结日期:&nbsp;
						</th>
						<td>
							<input id="end_date" class="inp_t inp_w140 search_sel ico_date" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})"
							 onfocus="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd'})" name="end_date" value="" />
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td class="btn_area" colspan="4"><span class="btn btn_pub">
								<input type="submit" id="btnSave_shb" class="shb" value="处理关闭" />
						</span><span class="btn btn_pub ml10">
								<input type="submit" id="btnSave" value="移交处理" />
						</span><span class="ml10 btn btn_base"> <input type="button"
								id="btn_pclose" value="取消">
						</span></td>
					</tr>
				</tfoot>
			</table>
			<script type="text/javascript">
			$(function(){
				$("#btnSave,#btnSave_shb").click(function(){
					
					var flag=true;
					// 调用jquery.validate.unobtrusive.js 提供的验证方法 
			        function validate() {
			            var validationInfo = $('#data_form').data('unobtrusiveValidation');
			            return !validationInfo || !validationInfo.validate || validationInfo.validate();
			        }
					if($(this).hasClass("shb"))
					{
						$("#state").val('3');
					}else
					{
						$("#state").val('2');
					}
			        flag=validate();
			        var user_id=$("#innerUser span.user_child").attr("key_id");
			        if(util.isNull(user_id) && !$(this).hasClass("shb"))
			        {
			        	$("#innerUser").addClass("input-validation-error");
			        	$("#user_error").removeClass("dn");
			        	$("#user_id").val('');
			        	flag=false;
			        }else
			        {
			        	$("#innerUser").removeClass("input-validation-error");
			        	$("#user_error").addClass("dn");
			        	if(!util.isNull(user_id))
			        	{
			        		$("#user_id").val(user_id);
			        	}
			        }
			        return flag;
				});
				
				
				//删除用户
				$(".del_user").live("click",function(){
					$(this).parents(".user_child").remove();
				});
				
				$("#selUser").click(function(){
					var url = 'user/sellist.do?key_v=2';
					openPage({
						url:url,
						id:'sel_page',
						title:'选择责任人',
						width:'800px',
						height:'400px'
					});
					return false;
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
		</form>	
	</div>
</gd:PopLayout> 