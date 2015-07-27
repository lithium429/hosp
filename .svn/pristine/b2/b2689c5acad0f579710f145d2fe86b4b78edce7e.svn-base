<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout>
	<jsp:body> 
	<gd:Navgation addlink="" addr="订餐管理 &gt; 菜单管理"></gd:Navgation>
	<div class="data_model">
		<div class="shfw_c">
			<form id="data_form" method="post" action="mealMenu/add.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
				<h2 class="ml20">下周菜单${sDate_next.toString("M月dd日")}至${eDate_next.toString("M月dd日")}</h2>
				<input type="hidden" name="is_add" value="${!empty mealList?0:1 }" />
				<table class="wc100 view_data ml20 " >
					<tbody>
						<tr>
							<td colspan="3">分类\日期</td>
							<td class="w140">星期一</td>
							<td class="w140">星期二</td>
							<td class="w140">星期三</td>
							<td class="w140">星期四</td>
							<td class="w140">星期五</td>
							<td class="w140">星期六</td>
							<td class="w140">星期天</td>
						</tr>
						<tr>
							<td class="w35" rowspan="5">午餐</td>
							<td class="w30" rowspan="3">大荤</td>
							<td class="w30">A</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<input type="hidden" name="meals[${0+vs.index*10 }].id" value="${!empty mealList?mealList[0+vs.index*10].id:'' }" />
								<input type="hidden" name="meals[${0+vs.index*10 }].sort" value="${0+vs.index*10 }" />
								<input type="hidden" name="meals[${0+vs.index*10 }].day_of_week" value="${vs.index+1}" />
								<input type="hidden" name="meals[${0+vs.index*10 }].meal_date" value="${sDate_next.plusDays(vs.index).toString('yyyy-MM-dd')}" />
								<input type="hidden" name="meals[${0+vs.index*10 }].state" class="state" value="" />
								<input type="hidden" name="meals[${0+vs.index*10 }].time_type" value="1" />
								<input type="hidden" name="meals[${0+vs.index*10 }].food_type" value="1" />
								<input type="hidden" name="meals[${0+vs.index*10 }].meat_type" value="1" />
								<input type="text" class="inp_t w130 food_name" name="meals[${0+vs.index*10 }].food_name" value="${!empty mealList?mealList[0+vs.index*10].food_name:'' }" />
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td>B</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<input type="hidden" name="meals[${1+vs.index*10 }].id" value="${!empty mealList?mealList[1+vs.index*10].id:'' }" />
								<input type="hidden" name="meals[${1+vs.index*10 }].sort" value="${1+vs.index*10 }" />
								<input type="hidden" name="meals[${1+vs.index*10 }].day_of_week" value="${vs.index+1}" />
								<input type="hidden" name="meals[${1+vs.index*10 }].meal_date" value="${sDate_next.plusDays(vs.index).toString('yyyy-MM-dd')}" />
								<input type="hidden" name="meals[${1+vs.index*10 }].state" class="state" value="" />
								<input type="hidden" name="meals[${1+vs.index*10 }].time_type" value="1" />
								<input type="hidden" name="meals[${1+vs.index*10 }].food_type" value="1" />
								<input type="hidden" name="meals[${1+vs.index*10 }].meat_type" value="2" />
								<input type="text" class="inp_t w130 food_name" name="meals[${1+vs.index*10 }].food_name" value="${!empty mealList?mealList[1+vs.index*10].food_name:'' }" />
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td>C</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<input type="hidden" name="meals[${2+vs.index*10 }].id" value="${!empty mealList?mealList[2+vs.index*10].id:'' }" />
								<input type="hidden" name="meals[${2+vs.index*10 }].sort" value="${2+vs.index*10 }" />
								<input type="hidden" name="meals[${2+vs.index*10 }].day_of_week" value="${vs.index+1}" />
								<input type="hidden" name="meals[${2+vs.index*10 }].meal_date" value="${sDate_next.plusDays(vs.index).toString('yyyy-MM-dd')}" />
								<input type="hidden" name="meals[${2+vs.index*10 }].state" class="state" value="" />
								<input type="hidden" name="meals[${2+vs.index*10 }].time_type" value="1" />
								<input type="hidden" name="meals[${2+vs.index*10 }].food_type" value="1" />
								<input type="hidden" name="meals[${2+vs.index*10 }].meat_type" value="3" />
								<input type="text" class="inp_t w130 food_name" name="meals[${2+vs.index*10 }].food_name" value="${!empty mealList?mealList[2+vs.index*10].food_name:'' }" />
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td colspan="2">小荤</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<input type="hidden" name="meals[${3+vs.index*10 }].id" value="${!empty mealList?mealList[3+vs.index*10].id:'' }" />
								<input type="hidden" name="meals[${3+vs.index*10 }].sort" value="${3+vs.index*10 }" />
								<input type="hidden" name="meals[${3+vs.index*10 }].day_of_week" value="${vs.index+1}" />
								<input type="hidden" name="meals[${3+vs.index*10 }].meal_date" value="${sDate_next.plusDays(vs.index).toString('yyyy-MM-dd')}" />
								<input type="hidden" name="meals[${3+vs.index*10 }].state" class="state" value="" />
								<input type="hidden" name="meals[${3+vs.index*10 }].time_type" value="1" />
								<input type="hidden" name="meals[${3+vs.index*10 }].food_type" value="2" />
								<input type="hidden" name="meals[${3+vs.index*10 }].meat_type" value="0" />
								<input type="text" class="inp_t w130 food_name" name="meals[${3+vs.index*10 }].food_name" value="${!empty mealList?mealList[3+vs.index*10].food_name:'' }" />
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td colspan="2">蔬菜</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<input type="hidden" name="meals[${4+vs.index*10 }].id" value="${!empty mealList?mealList[4+vs.index*10].id:'' }" />
								<input type="hidden" name="meals[${4+vs.index*10 }].sort" value="${4+vs.index*10 }" />
								<input type="hidden" name="meals[${4+vs.index*10 }].day_of_week" value="${vs.index+1}" />
								<input type="hidden" name="meals[${4+vs.index*10 }].meal_date" value="${sDate_next.plusDays(vs.index).toString('yyyy-MM-dd')}" />
								<input type="hidden" name="meals[${4+vs.index*10 }].state" class="state" value="" />
								<input type="hidden" name="meals[${4+vs.index*10 }].time_type" value="1" />
								<input type="hidden" name="meals[${4+vs.index*10 }].food_type" value="3" />
								<input type="hidden" name="meals[${4+vs.index*10 }].meat_type" value="0" />
								<input type="text" class="inp_t w130 food_name" name="meals[${4+vs.index*10 }].food_name" value="${!empty mealList?mealList[4+vs.index*10].food_name:'' }" />
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td rowspan="5">晚餐</td>
							<td rowspan="3">大荤</td>
							<td>A</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<input type="hidden" name="meals[${5+vs.index*10 }].id" value="${!empty mealList?mealList[5+vs.index*10].id:'' }" />
								<input type="hidden" name="meals[${5+vs.index*10 }].sort" value="${5+vs.index*10 }" />
								<input type="hidden" name="meals[${5+vs.index*10 }].day_of_week" value="${vs.index+1}" />
								<input type="hidden" name="meals[${5+vs.index*10 }].meal_date" value="${sDate_next.plusDays(vs.index).toString('yyyy-MM-dd')}" />
								<input type="hidden" name="meals[${5+vs.index*10 }].state" class="state" value="" />
								<input type="hidden" name="meals[${5+vs.index*10 }].time_type" value="2" />
								<input type="hidden" name="meals[${5+vs.index*10 }].food_type" value="1" />
								<input type="hidden" name="meals[${5+vs.index*10 }].meat_type" value="1" />
								<input type="text" class="inp_t w130 food_name" name="meals[${5+vs.index*10 }].food_name" value="${!empty mealList?mealList[5+vs.index*10].food_name:'' }" />
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td>B</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<input type="hidden" name="meals[${6+vs.index*10 }].id" value="${!empty mealList?mealList[6+vs.index*10].id:'' }" />
								<input type="hidden" name="meals[${6+vs.index*10 }].sort" value="${6+vs.index*10 }" />
								<input type="hidden" name="meals[${6+vs.index*10 }].day_of_week" value="${vs.index+1}" />
								<input type="hidden" name="meals[${6+vs.index*10 }].meal_date" value="${sDate_next.plusDays(vs.index).toString('yyyy-MM-dd')}" />
								<input type="hidden" name="meals[${6+vs.index*10 }].state" class="state" value="" />
								<input type="hidden" name="meals[${6+vs.index*10 }].time_type" value="2" />
								<input type="hidden" name="meals[${6+vs.index*10 }].food_type" value="1" />
								<input type="hidden" name="meals[${6+vs.index*10 }].meat_type" value="2" />
								<input type="text" class="inp_t w130 food_name" name="meals[${6+vs.index*10 }].food_name" value="${!empty mealList?mealList[6+vs.index*10].food_name:'' }" />
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td>C</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<input type="hidden" name="meals[${7+vs.index*10 }].id" value="${!empty mealList?mealList[7+vs.index*10].id:'' }" />
								<input type="hidden" name="meals[${7+vs.index*10 }].sort" value="${7+vs.index*10 }" />
								<input type="hidden" name="meals[${7+vs.index*10 }].day_of_week" value="${vs.index+1}" />
								<input type="hidden" name="meals[${7+vs.index*10 }].meal_date" value="${sDate_next.plusDays(vs.index).toString('yyyy-MM-dd')}" />
								<input type="hidden" name="meals[${7+vs.index*10 }].state" class="state" value="" />
								<input type="hidden" name="meals[${7+vs.index*10 }].time_type" value="2" />
								<input type="hidden" name="meals[${7+vs.index*10 }].food_type" value="1" />
								<input type="hidden" name="meals[${7+vs.index*10 }].meat_type" value="3" />
								<input type="text" class="inp_t w130 food_name" name="meals[${7+vs.index*10 }].food_name" value="${!empty mealList?mealList[7+vs.index*10].food_name:'' }" />
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td colspan="2">小荤</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<input type="hidden" name="meals[${8+vs.index*10 }].id" value="${!empty mealList?mealList[8+vs.index*10].id:'' }" />
								<input type="hidden" name="meals[${8+vs.index*10 }].sort" value="${8+vs.index*10 }" />
								<input type="hidden" name="meals[${8+vs.index*10 }].day_of_week" value="${vs.index+1}" />
								<input type="hidden" name="meals[${8+vs.index*10 }].meal_date" value="${sDate_next.plusDays(vs.index).toString('yyyy-MM-dd')}" />
								<input type="hidden" name="meals[${8+vs.index*10 }].state" class="state" value="" />
								<input type="hidden" name="meals[${8+vs.index*10 }].time_type" value="1" />
								<input type="hidden" name="meals[${8+vs.index*10 }].food_type" value="2" />
								<input type="hidden" name="meals[${8+vs.index*10 }].meat_type" value="0" />
								<input type="text" class="inp_t w130 food_name" name="meals[${8+vs.index*10 }].food_name" value="${!empty mealList?mealList[8+vs.index*10].food_name:'' }" />
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td colspan="2">蔬菜</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<input type="hidden" name="meals[${9+vs.index*10 }].id" value="${!empty mealList?mealList[9+vs.index*10].id:'' }" />
								<input type="hidden" name="meals[${9+vs.index*10 }].sort" value="${9+vs.index*10 }" />
								<input type="hidden" name="meals[${9+vs.index*10 }].day_of_week" value="${vs.index+1}" />
								<input type="hidden" name="meals[${9+vs.index*10 }].meal_date" value="${sDate_next.plusDays(vs.index).toString('yyyy-MM-dd')}" />
								<input type="hidden" name="meals[${9+vs.index*10 }].state" class="state" value="" />
								<input type="hidden" name="meals[${9+vs.index*10 }].time_type" value="1" />
								<input type="hidden" name="meals[${9+vs.index*10 }].food_type" value="3" />
								<input type="hidden" name="meals[${9+vs.index*10 }].meat_type" value="0" />
								<input type="text" class="inp_t w130 food_name" name="meals[${9+vs.index*10 }].food_name" value="${!empty mealList?mealList[9+vs.index*10].food_name:'' }" />
							</td>
							</c:forEach>
						</tr>
					</tbody>
					<c:if test="${empty mealList ||  mealList[0].state==1}">
					<tfoot>
						<tr>
							<td class="btn_area" colspan="10"><span class="btn btn_pub">
									<input type="submit" id="btn_save" value="保存修改" />
							</span><span class="btn btn_pub ml10">
									<input type="submit" id="btn_sub" class="sub" value="提交菜单" />
							</span></td>
						</tr>
					</tfoot>
					</c:if>
				</table>
			</form>
		</div>
	    <table class="wc100">
	        <tr>
	             <td>
					<div class="data_cont_wrap">
						<form id="spec_form" action="mealMenu/datalist.do"
									data-ajax="true" data-ajax-begin="loadBegin"
									data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
									data-ajax-loading="#loading_img" data-ajax-method="POST"
									data-ajax-mode="replace" data-ajax-update="#data_list"
									novalidate="novalidate">
							<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" />
					        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
					        <span class="ml20">菜单查询： </span>
					        <select class="date_lnterval" id="date_lnterval" name="date_lnterval">
					        	<c:forEach items="${dateArray}" var="item" varStatus="vs"> 
					        		<option value="${vs.index }">${item }</option>
					        	</c:forEach>
					        </select>
					       <!--  <div class="mb10 data_cont_wrap_list query_condition">
								<table>
									<tbody>
										<tr>
											<th class="w55">图书类型</th>					
											<td>
												<input class="inp_t inp_w150" name="name" id="name" />
											</td>
											<td>
												<span class="btn btn_pub">
													<input type="submit" id="btn_search" value="查询" />
												</span><span class="ml8 btn btn_base">
													<a href="bookType/list.do">重置</a>
												</span>
											</td>
										</tr>
									 </tbody>
							 	 </table>
					        </div> -->
				     	</form>
				 	</div>
					<div class="data_model wc100 shfw_c" id="data_list">
					   <%@ include file="data_list.jsp"%>
				 	</div>
		 		</td>
		 	</tr>
	 	</table>
 	</div>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#btn_save,#btn_sub").click(function(){
				var flag=true;
				$(".food_name").each(function(){
					
					if($(this).val()=="")
					{
						flag=false;
					}
				});
				if(flag){
				    if($(this).hasClass("sub"))
					{
						$(".state").val(2);

						art.dialog.confirm('提交菜单后就不允许再次修改，您确认提交？', function () {
			            	$("#data_form").submit();
			            });
					}else{
						$(".state").val(1);
						return true;
					} 
					 				
				}else{
					informationMsg("请输入菜单！");
				}
				return false;
			});

			
			$("#date_lnterval").change(function(){
				
				$("#spec_form").submit();
			});
		});
		
		function backToList(result) {
			if (result.flag) {
				successMsg("保存成功！", function() {
					location.reload();
				});
			} else {
				errorMsg(result.msg);
			}
		}

		function showError(result) {
			errorMsg(result.msg);
		}
	</script>
	</jsp:body>
</gd:Layout>
