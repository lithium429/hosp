<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="bookBorrow/add.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<input id="book_ids" type="hidden" name="book_ids" class="inp_t" />
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
							<select class="w86" id="type_id" name="type_id" >
								<option value="">--请选择--</option>
								<c:forEach items="${typeList }" var="item" varStatus="vs">
									<option value="${item.id }" >${item.name }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>
							搜索:&nbsp;
						</th>
						<td>
							<input id="name" class="inp_t" /><span class="btn btn_pub ml8">
								<input type="button" id="search" value="搜索" />
							</span>
						</td>
					</tr>
					<tr>
						<td colspan="2" id="showTable">
							
							
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
	<script type="text/javascript" src="static/js/index.js"></script>
			<script type="text/javascript">
			$(function(){
				$("#search").click(function(){
					$("#spec_form input").val('');
					$("#name_hidden").val($("#name").val());
					$("#type_id_hidden").val($("#type_id").val());
					$('#spec_form').submit();
				});
				
				$("#btnSave").click(function(){
					
					var flag=true;
					// 调用jquery.validate.unobtrusive.js 提供的验证方法 
			        function validate() {
			            var validationInfo = $('#data_form').data('unobtrusiveValidation');
			            return !validationInfo || !validationInfo.validate || validationInfo.validate();
			        }
			        flag=validate();
			        if(flag)
		        	{
			        	var length=$("input.bookId:checked").length;
			        	if(length==0)
		        		{
			        		informationMsg("请选择书籍！");
			        		flag=false;
		        		}else
		        		{
		        			var book_ids="";
		        			$("input.bookId:checked").each(function(){
		        				if(book_ids=="")
		        				{
		        					book_ids=$(this).val();
		        				}else
		        				{
		        					book_ids+=","+$(this).val();
		        				}
		        			});
		        			$("#book_ids").val(book_ids);
		        		}
		        	}
			        return flag;
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
		<form id="spec_form" action="bookBorrow/seldatalist.do"
				data-ajax="true" data-ajax-begin="loadBegin"
				data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
				data-ajax-loading="#loading_img" data-ajax-method="POST"
				data-ajax-mode="replace" data-ajax-update="#showTable"
				novalidate="novalidate">
		<input type="hidden" name="name" id="name_hidden" value="" />
        <input type="hidden" name="type_id" id="type_id_hidden" value="" />
        
    	</form>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<!-- E 添加信息 -->
</gd:PopLayout>
