<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap user_info_form">
		<div class="t_c photo_box">
			<div class="pic"><img id="img4" class="img4" width="160px" height="160px" src="<c:if test="${empty model.photo}">static/images/photo.jpg</c:if><c:if test="${!empty model.photo}">${model.photo}</c:if>"></div> 
			<input type="hidden" class="inp_t inp_w120" id="photo" name="photo" value="${model.photo}">
		</div>
	    <div class="view_data">
	        <table class="wc100">
				<tbody>
					<tr>
						<th class="w18per">系统用户</th>
						<td class="w35per">
							${model.user_name}
						</td>
						<th class="w15per">姓名</th>
						<td class="">
							${model.name}
						</td>
					</tr>
					<tr>
						<th>工号</th>
						<td>
							${model.code}
						</td>
						<th>性别</th>
						<td>
							<c:choose>
								<c:when test="${model.sex==1 }">男</c:when>
								<c:when test="${model.sex==2 }">女</c:when>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>身份证号</th>
						<td>
							${model.id_number}
						</td>
						<th>出生日期</th>
						<td>
							<fmt:formatDate value="${model.birthday}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<th>详细地址</th>
						<td colspan="3">
							${model.address}
						</td>
					</tr>
					<tr>
						<th>籍贯</th>
						<td>
							${model.native_place }
						</td>
						<th>民族</th>
						<td>
							${mdoel.gainNation()}
						</td>
					</tr>
					<tr>
						<th>婚姻状况</th>
						<td>
							<c:choose>
								<c:when test="${model.marital_status==1 }">未婚</c:when>
								<c:when test="${model.marital_status==2 }">已婚</c:when>
								<c:when test="${model.marital_status==3 }">离异</c:when>
								<c:when test="${model.marital_status==4 }">丧偶</c:when>
							</c:choose>
						</td>
						<th>政治面貌</th>
						<td>
							<c:choose>
								<c:when test="${model.political_status==1 }">群众</c:when>
								<c:when test="${model.political_status==2 }">共青团员</c:when>
								<c:when test="${model.political_status==3 }">中共党员</c:when>
								<c:when test="${model.political_status==4 }">中共预备党员</c:when>
								<c:when test="${model.political_status==5 }">民主党派</c:when>
								<c:when test="${model.political_status==6 }">无党派人士</c:when>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>员工类型</th>
						<td>
							<c:choose>
								<c:when test="${model.marital_status==1 }">合同工</c:when>
								<c:when test="${model.marital_status==2 }">正式员工</c:when>
								<c:when test="${model.marital_status==2 }">临时工</c:when>
							</c:choose>
						</td>
						<th>职务</th>
						<td>
							${model.post}
						</td>
					</tr>
					<tr>
						<th>技术职称</th>
						<td>
							${model.post_title}
						</td>
						<th>职称级别</th>
						<td>
							<c:choose>
								<c:when test="${model.post_title_level==1 }">初级</c:when>
								<c:when test="${model.post_title_level==2 }">中级</c:when>
								<c:when test="${model.post_title_level==3 }">副高</c:when>
								<c:when test="${model.post_title_level==4 }">正高</c:when>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>考勤排班类型</th>
						<td>
							<c:choose>
								<c:when test="${model.scheduling_type==1 }">正常班</c:when>
								<c:when test="${model.scheduling_type==2 }">全日班</c:when>
								<c:when test="${model.scheduling_type==3 }">轮班制</c:when>
							</c:choose>
						</td>
						<th>固定电话</th>
						<td>
							${model.phone}
						</td>
					</tr>
					<tr>
						<th>手机</th>
						<td>
							${model.mobile }
						</td>
						<th>邮箱</th>
						<td>
							${model.email}
						</td>
					</tr>
					<tr>
						<th>QQ</th>
						<td>
							${model.qq }
						</td>
						<th>入职日期</th>
						<td>
							<fmt:formatDate value="${model.entry_date}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<th>学历</th>
						<td>
							${mdoel.gainEducation()}
						</td>
						<th>毕业日期</th>
						<td>
							<fmt:formatDate value="${model.graduate_date}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<th>毕业学校</th>
						<td colspan="3">
							${model.graduate_school}
						</td>
					</tr>
					<tr>
						<th class="vtop">备注</th>
						<td colspan="3">
							${model.remark}
						</td>
					</tr>
					<tr>
						<th class="vtop">简历</th>
						<td colspan="3">
							${model.resume}
						</td>
					</tr>
				</tbody>
			</table>      
	    </div>
	    <div class="btn_area">
	        <span class="btn btn_base"><input type="button" id="btn_pclose" value="关闭"></span>
	    </div>
	</div>
</gd:PopLayout> 