<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout>
	<jsp:body> 
	<gd:Navgation addlink="" addr="订餐管理 &gt; 订餐"></gd:Navgation>
	<div class="data_model shfw_c">
		<div>
			<form id="data_form" method="post" action="mealMenu/reserve.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">
				<h2 class="ml20">${title }</h2>
				<input type="hidden" name="is_add" value="${meal_st==2?0:1 }" />
				<table class="wc100 ml20 view_data">
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
								<c:if test="${!empty mealList }">
									${mealList[0+vs.index*10].food_name }
									<em class="minus ml10"><a href="javascript:void(0);">-</a></em>
									<select name="mealUsers[${0+vs.index*10 }].order_count" class="order_count">
										<c:forEach begin="0" end="10" step="1" varStatus="vs1" >
											<option value="${vs1.index }" ${mealList[0+vs.index*10].order_count==vs1.index?"selected=selected":"" } >${vs1.index }</option>
										</c:forEach>
									</select>
									<em class="plus"><a href="javascript:void(0);">+</a></em>
									<input type="hidden" name="mealUsers[${0+vs.index*10 }].id" value="${!empty mealList?mealList[0+vs.index*10].order_id:'' }" />
									<input type="hidden" name="mealUsers[${0+vs.index*10 }].menu_id" value="${!empty mealList?mealList[0+vs.index*10].id:'' }" />
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td>B</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<c:if test="${!empty mealList }">
									${mealList[1+vs.index*10].food_name }
									<em class="minus ml10"><a href="javascript:void(0);">-</a></em>
									<select name="mealUsers[${1+vs.index*10 }].order_count" class="order_count">
										<c:forEach begin="0" end="10" step="1" varStatus="vs1" >
											<option value="${vs1.index }" ${mealList[1+vs.index*10].order_count==vs1.index?"selected=selected":"" }>${vs1.index }</option>
										</c:forEach>
									</select>
									<em class="plus"><a href="javascript:void(0);">+</a></em>
									<input type="hidden" name="mealUsers[${1+vs.index*10 }].id" value="${!empty mealList?mealList[1+vs.index*10].order_id:'' }" />
									<input type="hidden" name="mealUsers[${1+vs.index*10 }].menu_id" value="${!empty mealList?mealList[1+vs.index*10].id:'' }" />
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td>C</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<c:if test="${!empty mealList }">
									${mealList[2+vs.index*10].food_name }
									<em class="minus ml10"><a href="javascript:void(0);">-</a></em>
									<select name="mealUsers[${2+vs.index*10 }].order_count" class="order_count">
										<c:forEach begin="0" end="10" step="1" varStatus="vs1" >
											<option value="${vs1.index }" ${mealList[2+vs.index*10].order_count==vs1.index?"selected=selected":"" }>${vs1.index }</option>
										</c:forEach>
									</select>
									<em class="plus"><a href="javascript:void(0);">+</a></em>
									<input type="hidden" name="mealUsers[${2+vs.index*10 }].id" value="${!empty mealList?mealList[2+vs.index*10].order_id:'' }" />
									<input type="hidden" name="mealUsers[${2+vs.index*10 }].menu_id" value="${!empty mealList?mealList[2+vs.index*10].id:'' }" />
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td colspan="2">小荤</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<c:if test="${!empty mealList }">
									${mealList[3+vs.index*10].food_name }
									<input type="hidden" name="mealUsers[${3+vs.index*10 }].id" value="${!empty mealList?mealList[3+vs.index*10].order_id:'' }" />
									<input type="hidden" name="mealUsers[${3+vs.index*10 }].menu_id" value="${!empty mealList?mealList[3+vs.index*10].id:'' }" />
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td colspan="2">蔬菜</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<c:if test="${!empty mealList }">
									${mealList[4+vs.index*10].food_name }
									<input type="hidden" name="mealUsers[${4+vs.index*10 }].id" value="${!empty mealList?mealList[4+vs.index*10].order_id:'' }" />
									<input type="hidden" name="mealUsers[${4+vs.index*10 }].menu_id" value="${!empty mealList?mealList[4+vs.index*10].id:'' }" />
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td rowspan="5">晚餐</td>
							<td rowspan="3">大荤</td>
							<td>A</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<c:if test="${!empty mealList }">
									${mealList[5+vs.index*10].food_name }
									<em class="minus ml10"><a href="javascript:void(0);">-</a></em>
									<select name="mealUsers[${5+vs.index*10 }].order_count" class="order_count">
										<c:forEach begin="0" end="10" step="1" varStatus="vs1" >
											<option value="${vs1.index }" ${mealList[5+vs.index*10].order_count==vs1.index?"selected=selected":"" }>${vs1.index }</option>
										</c:forEach>
									</select>
									<em class="plus"><a href="javascript:void(0);">+</a></em>
									<input type="hidden" name="mealUsers[${5+vs.index*10 }].id" value="${!empty mealList?mealList[5+vs.index*10].order_id:'' }" />
									<input type="hidden" name="mealUsers[${5+vs.index*10 }].menu_id" value="${!empty mealList?mealList[5+vs.index*10].id:'' }" />
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td>B</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<c:if test="${!empty mealList }">
									${mealList[6+vs.index*10].food_name }
									<em class="minus ml10"><a href="javascript:void(0);">-</a></em>
									<select name="mealUsers[${6+vs.index*10 }].order_count" class="order_count">
										<c:forEach begin="0" end="10" step="1" varStatus="vs1" >
											<option value="${vs1.index }" ${mealList[6+vs.index*10].order_count==vs1.index?"selected=selected":"" }>${vs1.index }</option>
										</c:forEach>
									</select>
									<em class="plus"><a href="javascript:void(0);">+</a></em>
									<input type="hidden" name="mealUsers[${6+vs.index*10 }].id" value="${!empty mealList?mealList[6+vs.index*10].order_id:'' }" />
									<input type="hidden" name="mealUsers[${6+vs.index*10 }].menu_id" value="${!empty mealList?mealList[6+vs.index*10].id:'' }" />
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td>C</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<c:if test="${!empty mealList }">
									${mealList[7+vs.index*10].food_name }
									<em class="minus ml10"><a href="javascript:void(0);">-</a></em>
									<select name="mealUsers[${7+vs.index*10 }].order_count" class="order_count">
										<c:forEach begin="0" end="10" step="1" varStatus="vs1" >
											<option value="${vs1.index }" ${mealList[7+vs.index*10].order_count==vs1.index?"selected=selected":"" }>${vs1.index }</option>
										</c:forEach>
									</select>
									<em class="plus"><a href="javascript:void(0);">+</a></em>
									<input type="hidden" name="mealUsers[${7+vs.index*10 }].id" value="${!empty mealList?mealList[7+vs.index*10].order_id:'' }" />
									<input type="hidden" name="mealUsers[${7+vs.index*10 }].menu_id" value="${!empty mealList?mealList[7+vs.index*10].id:'' }" />
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td colspan="2">小荤</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<c:if test="${!empty mealList }">
									${mealList[8+vs.index*10].food_name }
									<input type="hidden" name="mealUsers[${8+vs.index*10 }].id" value="${!empty mealList?mealList[8+vs.index*10].order_id:'' }" />
									<input type="hidden" name="mealUsers[${8+vs.index*10 }].menu_id" value="${!empty mealList?mealList[8+vs.index*10].id:'' }" />
								</c:if>
							</td>
							</c:forEach>
						</tr>
						<tr>
							<td colspan="2">蔬菜</td>
							<c:forEach begin="0" end="6" step="1" varStatus="vs" >
							<td>
								<c:if test="${!empty mealList }">
									${mealList[9+vs.index*10].food_name }
									<input type="hidden" name="mealUsers[${9+vs.index*10 }].id" value="${!empty mealList?mealList[9+vs.index*10].order_id:'' }" />
									<input type="hidden" name="mealUsers[${9+vs.index*10 }].menu_id" value="${!empty mealList?mealList[9+vs.index*10].id:'' }" />
								</c:if>
							</td>
							</c:forEach>
						</tr>
					</tbody>
					<c:if test="${!empty mealList && meal_st!=1}">
					<tfoot>
						<tr>
							<td class="btn_area" colspan="10"><span class="btn btn_pub">
									<input type="submit" id="btn_save" value="保存" />
							</span></td>
						</tr>
					</tfoot>
					</c:if>
				</table>
			</form>
		</div>
	    
 	</div>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		$(function() {
			
			$('#btn_add').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'add_page',
					title : '添加图书类型 ',
					width : '500px',
					height : '200px'
					
				});
				return false;
			});

			$('.update').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'update_page',
					title : '修改图书类型 ',
					width : '500px',
					height : '200px'
				});
				return false;
			});

			$('.view').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'view_page',
					title : '查看图书类型 ',
					width : '500px',
					height : '200px'
				});
				return false;
			});
			
			//加
			$("em.plus").click(function(){
				var $this=$(this);
				var count=Number($this.prev().val());
				if(count<10)
				{
					count+=1;
					$this.prev().find("option:eq("+(count)+")").attr("selected","selected");
				}
			});
			
			//减
			$("em.minus").click(function(){
				var $this=$(this);
				var count=Number($this.next().val());
				if(count>0)
				{
					count-=1;
					$this.next().find("option:eq("+(count)+")").attr("selected","selected");
				}
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
</gd:PopLayout>
