<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout>
	<style type="text/css">
		.mail_input{width:500px;}
	</style>
	<!-- S 添加信息 -->
	<gd:Navgation addr="排班管理 &gt; 科室排班"></gd:Navgation>
	<div class="data_model colum_two clearfix">
		<div style="padding:10px 10px 5px 30px;">
			<span>${deptName}</span> 
			<select id="sel_year">
				<c:forEach items="${years}" var="item" varStatus="vs">
					<option value="${item}" <c:if test="${item == year}">selected="selected"</c:if>>${item}年</option>
				</c:forEach>
			</select>
			<select id="sel_month">
				<c:forEach items="${months}" var="item" varStatus="vs">
					<option value="${item}" <c:if test="${item == month}">selected="selected"</c:if>>${item}月</option>
				</c:forEach>
			</select>
			<span>排班</span>
			<input type="hidden" id="now_year" value="${year}" />
			<input type="hidden" id="now_month" value="${month}" />
			<span class="btn btn_pub ml5"><input type="button" id="btn_save_top" value="保存" /></span>
			<span class="btn btn_pub ml20" id="btn_clear_span" style="display:none;"><input type="button" id="btn_clear" value="清空" /></span> 
		</div>
		<div class="leftbox" >
			<div class="data_model wc100 data_list_wrap dt_query">
				<form id="data_form" method="post" action="scheduling/dept.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
					<input type="hidden" name="year" id="year" value="${year}" />
					<input type="hidden" name="month" id="month" value="${month}" />
					<input type="hidden" id="dept_id" value="${deptId}" />
					<input type="hidden" id="creator_id" value="${userId}" />
					<input type="hidden" id="current_index" value="" />
		 			<script type="text/javascript" src="static/js/flexigrid-1.1/js/flexigrid.js"></script> 
					<div class="datalistbox" style="top:60px;left:30px;">
						<table class="OptionTable" id="tableSort">
							<thead> 
								 <tr>
									<th class="w80" style="padding-left:20px;">日期</th>
									<th class="w80">星期</th>
									<th class="w100">时段</th>
									<th class="w600">值班人员</th>
								</tr>
							</thead>
							<tbody id="tbody"> 
							</tbody>
							<tfoot>
								<tr>
									<td class="btn_area" colspan="4">
										<span class="btn btn_pub">
											<input type="submit" id="btn_save" value="保存" />
										</span> 
									</td>
								</tr>
							</tfoot>
						</table> 
					</div>
					<div id="form_values" class="dn"></div>
				</form>
			</div>
		</div>
		<div class="rightbox" style="float:right;">
			<ul>
				<li>选择值班人员</li>
				<li><input type="text" class="inp_t" name="real_name" id="real_name" onkeyup="ztreeWrapper.search();" value="" /></li>
			</ul>
			<ul id="ztree_list" class="ztree transcipt_tree"></ul>
		</div>
		<div class="dn" id="json_tree">${jsonTree}</div>
	</div>
	<!-- E 添加信息 -->
	<script type="text/javascript" src="static/js/biz/scheduling.js"></script>
	<script type="text/javascript">
		$(function(){
			page.init();
			scheduling.init();
			ztreeWrapper.init();
			$('#sel_year').change(function(){
				var year = Number(this.value),
				yearNow = Number('${year}');
				if(year > yearNow){
					$('#btn_clear_span').show();
				}
				else {
					$('#btn_clear_span').hide();
				}
				$('#year').val(this.value);
				scheduling.getData();
			});
			$('#sel_month').change(function(){
				var year = Number($('#sel_year').val()), 
				month = Number(this.value),
				yearNow = Number('${year}'),
				monthNow = Number('${month}');
				if(year > yearNow || (year == yearNow && month > monthNow)){
					$('#btn_clear_span').show();
				}
				else {
					$('#btn_clear_span').hide();
				}
				$('#month').val(this.value);
				scheduling.getData();
			});
			$('.OptionTable').flexigrid();
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
