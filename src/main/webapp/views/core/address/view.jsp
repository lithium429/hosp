<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap user_info_form">
		<div class="t_c photo_box">
			<div class="pic"><img id="img4" class="img4" width="160px" height="160px" src="<c:if test="${empty model.img_url}">static/images/photo.jpg</c:if><c:if test="${!empty model.img_url}">${model.img_url}</c:if>"></div> 
		</div>
	    <table class="view_data wc100"> 
	    	<tbody> 
				<tr>
					<th class="w80">姓名：</td>
					<td>${model.name }</td>
					<th class="w20per">性别：</td>
					<td>
						<c:choose>
							<c:when test="${model.sex==1 }">男</c:when>
							<c:when test="${model.sex==2 }">女</c:when>
						</c:choose>
					</td>
				</tr> 
				<tr>
					<c:choose>
							<c:when test="${model.type==1 }">
								<th class="">部门科室：</th>
								<td>
									${model.dept_name }
								</td>
							</c:when>
							<c:when test="${model.type==2 }">
								<th class="">群组：</th>
								<td>
									<c:choose>
										<c:when test="${login_id==model.creator_id && is_share==1 }">
											共享-默认组
										</c:when>
										<c:otherwise>
											${empty model.group_name?'默认组': model.group_name}
										</c:otherwise>
									</c:choose>
								</td>
							</c:when>
						</c:choose>
					<th class="">邮箱：</td>
					<td>${model.email}</td>
				</tr> 
				<tr>
					<th class="">手机：</td>
					<td>${model.mobile}</td>
					<th class="">QQ：</td>
					<td>${model.qq}</td>
				</tr> 
				<tr>
					<th class="">职位：</th>
					<td colspan="3">
						${model.post }
					</td>
				</tr>
				<tr>
					<th class="">工作单位：</th>
					<td colspan="3">
						${model.company }
					</td>
				</tr>
				<tr>
					<th class="">联系地址：</th>
					<td colspan="3">
						${model.address }
					</td>
				</tr>
				<tr>
					<th class="vtop">备注：</th>
					<td colspan="3">
						${model.remark}
					</td>
				</tr>
				<c:if test="${model.type==2 }">
				<tr>
					<td colspan="4">
						<c:choose>
							<c:when test="${!model.is_share }">不共享</c:when>
							<c:when test="${model.is_share}">共享</c:when>
						</c:choose>
					</td>
				</tr></c:if>
				<tr id="user_nameTr" class="${model.is_share?'':'dn' }">
					<th class="">${is_share==-1?'共享范围':'共享用户' }：</th>
					<td colspan="3">
						<c:choose>
							<c:when test="${is_share==-1 }">${model.getUserNamesByAddressUsers()}</c:when>
							<c:when test="${is_share==1 }">${model.creator_name}</c:when>	
						</c:choose>
						
					</td>
				</tr>
			</tbody>
		</table>
	    <div class="btn_area">
	        <span class="btn btn_base"><input type="button" id="btn_pclose" value="关闭"></span>
	    </div>
	</div>
</gd:PopLayout> 