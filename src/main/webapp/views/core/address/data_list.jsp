<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<table class="wc90" id="list_table">
	<tbody> 
		<c:forEach items="${list}" var="temp" varStatus="vs1">
			<tr id="${temp.fname.toUpperCase()}" class="group_tr">
				<td colspan="3"> 
				${temp.fname.toUpperCase()}
				</td>
			</tr>
			<c:forEach items="${temp.addresss}" var="item" varStatus="vs">
				<tr>
					<td class="w70per">
					<img id="img4" class="mtb10 img4" width="40px" height="40px" src="<c:if test="${empty item.img_url}">static/images/photo.jpg</c:if><c:if test="${!empty item.img_url}">${item.img_url}</c:if>">
					${item.name}
					(${item.mobile})
					<c:if test="${type==2 && item.is_share && is_share!=1 }"><span class="icon ico_share"></span> </c:if>
					</td>
					<td></td>
					<td>
						<c:if test="${item.type==1 }">
							<c:if test="${is_allow }">
							<a href="sms/send.do?user_id=${item.user_id}&type=0" class="send_sms">发送短信</a></c:if>
							<a href="email/send.do?user_id=${item.user_id}&type=0" class="send_email">发送邮件</a>
						</c:if>
						<c:if test="${is_share!=1 }">
						<c:if test="${item.type==2 }">
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'共享') }">
						<a href="address/share.do?id=${item.id}" class="share">共享</a></c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'移动') }">
						<a href="address/move.do?id=${item.id}" class="move">移动</a></c:if>
						</c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'修改') }">
						<a href="address/update.do?id=${item.id}" class="update_lik">修改</a></c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'删除') }">
						<a href="address/delete.do?id=${item.id}&user_id=${item.user_id }&g_id=${type==2?item.group_id:item.dept_id}&type=${type}" class="delete">删除</a></c:if></c:if>
						<c:if test="${gdf:judgeRoleMenu(roleMenuList,'查看') }">
						<a href="address/view.do?id=${item.id}&is_share=${is_share}" class="view_lik">查看</a></c:if>
					</td>
				</tr>
			</c:forEach>
		</c:forEach>
		<c:if test="${empty list}">
			<tr>
				<td colspan="4" class="t_c"><span class="no-records">暂无数据</span></td>
			</tr>
		</c:if>
	</tbody>
</table>
<div id="indexbar" class="index_li">
	<a href="javascript:void(0);" onclick="letterSort.click(0);">AB</a>
	<a href="javascript:void(0);" onclick="letterSort.click(2);">CD</a>
	<a href="javascript:void(0);" onclick="letterSort.click(4);">EF</a>
	<a href="javascript:void(0);" onclick="letterSort.click(6);">GH</a>
	<a href="javascript:void(0);" onclick="letterSort.click(8);">IJ</a>
	<a href="javascript:void(0);" onclick="letterSort.click(10);">KL</a>
	<a href="javascript:void(0);" onclick="letterSort.click(12);">MN</a>
	<a href="javascript:void(0);" onclick="letterSort.click(14);">OP</a>
	<a href="javascript:void(0);" onclick="letterSort.click(16);">QR</a>
	<a href="javascript:void(0);" onclick="letterSort.click(18);">ST</a>
	<a href="javascript:void(0);" onclick="letterSort.click(20);">UV</a>
	<a href="javascript:void(0);" onclick="letterSort.click(22);">WX</a>
	<a href="javascript:void(0);" onclick="letterSort.click(24);">YZ</a>
</div>
<script type="text/javascript">
var zArray=['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'];
	var letterSort = (function(){
		function click(index){ 
			var min=zArray[index],max=zArray[Number(index)+1],r="";
			$(".group_tr").each(function(){
				var id=$(this).attr("id");
				if(id==min)
				{
					r=min;
					return false;
				}else if(id==max)
				{
					r=max;
					return false;
				}
			}); 
			if(r!="")
			{
			var letter="#"+r;
			var itop = $('#list_table').position().top, 
			dataList = $('#data_list'), 
			top = $(letter).position().top, 
			scrollTop = dataList.scrollTop();

			dataList.animate({scrollTop: top - itop}, "slow"); 
			}
		}
		
		return { click: click };
	})();
</script>