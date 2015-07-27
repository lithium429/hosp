<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="schedulingTime/add.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
			<table class="view wc100">
				<tbody>
					<tr>
						<th class="w30per"><span class="c_red">*</span>起始时间：</th>
						<td>
							<input type="text" class="inp_t" readonly="readonly" data-val="true" data-val-required="请选择起始时间！" id="start_time" name="start_time" value=""
								onclick="WdatePicker({readyOnly:true,dateFmt:'HH:mm'})"
				 				onfocus="WdatePicker({readyOnly:true,dateFmt:'HH:mm'})" />
							<span class="field-validation-error" data-valmsg-for="start_time" data-valmsg-replace="true"></span>
						</td>
					</tr>
					<tr>
						<th><span class="c_red">*</span>结束时间：</th>
						<td>
							<input type="text" class="inp_t" readonly="readonly" data-val="true" data-val-required="请选择结束时间！" id="end_time" name="end_time" value="" 
								onclick="WdatePicker({readyOnly:true,dateFmt:'HH:mm'})"
				 				onfocus="WdatePicker({readyOnly:true,dateFmt:'HH:mm'})" />
							<span class="field-validation-error" data-valmsg-for="end_time" data-valmsg-replace="true"></span>
						</td>
					</tr> 
				</tbody>
				<tfoot>
					<tr>
						<td class="btn_area" colspan="2"><span class="btn btn_pub">
								<input type="submit" value="保存" />
						</span><span class="ml10 btn btn_base"> <input type="button"
								id="btn_pclose" value="取消">
						</span></td>
					</tr>
				</tfoot>
			</table> 
		</form>
	</div>
	<!-- E 添加信息 -->
	<script type="text/javascript"> 
		var opener = art.dialog.open.origin,
		ul = opener.$('#time_ul_' + '${index}');
	
		function backToList(result) {
			var msg = '';
			
			// 构造日期
			function newDate(time){
				return '2014-1-1 ' + time + ':00';
			}
			
			// 验证时间是否重叠
			function checkTime(startTime, endTime){
				var flag = true,
				startDate = newDate(startTime),
				endDate = newDate(endTime);
				$('input[name="start_time_${index}"]', ul).each(function(index, item){
					var ostartTime = $(item).val(), 
					oendTime = $(item).next('input[name="end_time_${index}"]').val(), 
					ostartDate = newDate(ostartTime),
					oendDate = newDate(oendTime);
					
					$.ajax({
						url: 'schedulingTime/compare.do',
						type: 'post',
						dataType: 'json',
						data: { ostartDate: ostartDate, oendDate: oendDate, startDate: startDate, endDate: endDate  },
						async: false,
						success: function(result){
							if(result.flag){
								flag = false;
								msg = ostartTime + '-' + oendTime;
							}
						}
					});
					if(!flag){
						return false;
					}
				});
				return flag;
			}
			
			if (result.flag) {
				var startTime = $('#start_time').val(),
				endTime = $('#end_time').val();
				/*flag = checkTime(startTime, endTime);
				if(!flag){
					errorMsg('所选时间段与已有时间段【' + msg +'】存在交叉！');
					return false;
				}*/
				
				successMsg("保存成功！", function() {
					var tmpl = ['<li class="li_item">',
					            	'<span class="user_child">',
										'<span>{0}-{1}</span>',
										'<span class="item_remove del_user" title="删除">×</span>',
										'<input type="hidden" name="start_time_${index}" value="{2}" />',
										'<input type="hidden" name="end_time_${index}" value="{3}" />',
									'</span>',
								'</li>'].join(''),
					
					html = util.formatString(tmpl, startTime, endTime, startTime, endTime); 
					ul.append(html);
					
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
