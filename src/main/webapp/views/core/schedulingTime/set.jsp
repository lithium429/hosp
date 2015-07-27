<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout>
	<div class="mb10 crumbs"> 
		<span class="icon ico_place"></span><b>您当前的位置：</b>排班管理 &gt; 排班时间段管理
	</div>
	<!-- S 添加信息 -->
	<div class="data_model data_cont_wrap pop_wrap">
		<form id="data_form" method="post" action="schedulingTime/set.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
 			<table class="view wc100">
				<tbody>
					<tr>
						<td>
							<ul id="time_ul_1">
								<li>
									<span class="fb">周一到周五</span>
									<span class="btn btn_pub"><a href="javascript:void(0);" class="add_time" rel="1">添加时间段</a></span>
								</li>
								<c:if test="${list != null}">
									<c:forEach items="${list}" var="item" varStatus="vs">
										<c:if test="${item.type == 1}">
											<li class="li_item">
												<span class="user_child">
													<span><fmt:formatDate value="${item.start_time}" pattern="HH:mm" />-<fmt:formatDate value="${item.end_time}" pattern="HH:mm" /></span>
													<span class="item_remove del_user">×</span>
													<input type="hidden" name="start_time_1" value='<fmt:formatDate value="${item.start_time}" pattern="HH:mm" />' />
													<input type="hidden" name="end_time_1" value='<fmt:formatDate value="${item.end_time}" pattern="HH:mm" />' />
												</span> 
											</li>		
										</c:if>
									</c:forEach>							
								</c:if>
							</ul>
							
							<ul id="time_ul_2">
								<li>
									<span class="fb">周六周日</span>
									<span class="btn btn_pub"><a href="javascript:void(0);" class="add_time" rel="2">添加时间段</a></span>
								</li>
								<c:if test="${list != null}">
									<c:forEach items="${list}" var="item" varStatus="vs">
										<c:if test="${item.type == 2}">
											<li class="li_item">
												<span class="user_child">
													<span><fmt:formatDate value="${item.start_time}" pattern="HH:mm" />-<fmt:formatDate value="${item.end_time}" pattern="HH:mm" /></span>
													<span class="item_remove del_user">×</span>
													<input type="hidden" name="start_time_2" value='<fmt:formatDate value="${item.start_time}" pattern="HH:mm" />' />
													<input type="hidden" name="end_time_2" value='<fmt:formatDate value="${item.end_time}" pattern="HH:mm" />' />
												</span> 
											</li>		
										</c:if>
									</c:forEach>							
								</c:if>
							</ul> 
						</td>
					 </tr>
				</tbody>
				<tfoot>
					<tr>
						<td class="btn_area">
							<span class="btn btn_pub">
								<input type="submit" id="btn_save" value="保存" />
							</span> 
						</td>
					</tr>
				</tfoot>
			</table> 
			<div id="form_values" class="dn"></div>
		</form>
	</div>
	
	<!-- E 添加信息 -->
	<script type="text/javascript">
		$(function(){
			// 添加时间段
			$('.add_time').click(function(){
				var index = $(this).attr('rel');
				
				openPage({
					url: 'schedulingTime/add.do?index=' + index,
					id: 'add_time_page',
					title: '添加时间段',
					width: '500px',
					height: '260px' 
				});
			});
			
			// 删除
			$('.item_remove').live('click', function(){
				$(this).parents('.li_item').remove();
			});
			
			// 保存
			$('#btn_save').click(function(){
				var aindex = 0;
				
				// 构造日期
				function newDate(time){
					return '2014-1-1 ' + time + ':00';
				}
				
				function setValues(target, uindex){
					var tmpl = ['<input type="hidden" name="list[{index}].start_time" value="{0}" />',
					            '<input type="hidden" name="list[{index}].end_time" value="{1}" />',
					            '<input type="hidden" name="list[{index}].type" value="{2}" />'].join(''),
					array = [], html = '';
					target.find('input[name="start_time_' + uindex + '"]').each(function(index, item){
						var startTime = $(item).val(),
						endTime = $(item).next('input[name="end_time_' + uindex + '"]').val();
						html = util.formatString(tmpl, newDate(startTime), newDate(endTime), uindex);
						html = html.replace(/\{index\}/g, aindex);
						array.push(html);							
						aindex++;
					});
					
					return array.join('');
				}
				
				var array = [];
				var html = setValues($('#time_ul_1'), 1);
				array.push(html);
				html = setValues($('#time_ul_2'), 2);
				array.push(html);
				
				var valuesHtml = array.join('');
				if(util.isEmpty(valuesHtml)){
					errorMsg('请添加时间段！');
					return false;
				}
				
				$('#form_values').html(valuesHtml); 
			});
		});
		
		function backToList(result) {
			if (result.flag) {
				successMsg("保存成功！");
			} else {
				errorMsg(result.msg ? result.msg : '保存失败！');
			}
		}
	
		function showError(result) {
			errorMsg(result.msg);
		}
	</script>
	
</gd:Layout>
