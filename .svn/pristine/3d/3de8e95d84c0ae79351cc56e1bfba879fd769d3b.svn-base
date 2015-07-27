<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<table class="wc90" id="list_table">
	<tbody id="v_body"> 
		<c:forEach items="${list}" var="temp" varStatus="vs1">
			<tr id="${temp.fname.toUpperCase()}" class="group_tr">
				<td > 
				${temp.fname.toUpperCase()}
				</td>
			</tr>
			<c:forEach items="${temp.addresss}" var="item" varStatus="vs">
				<tr class="child_v" key_id="${item.id }" key_name="${item.name}(${item.mobile})">
					<td class="wc100">
					<img id="img4" class="mtb10 img4" width="40px" height="40px" src="<c:if test="${empty item.img_url}">static/images/photo.jpg</c:if><c:if test="${!empty item.img_url}">${item.img_url}</c:if>">
					${item.name}
					(${item.mobile})
					</td>
				</tr>
			</c:forEach>
		</c:forEach>
		<c:if test="${empty list}">
			<tr>
				<td colspan="3" class="t_c"><span class="no-records">暂无数据</span></td>
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
$(function(){
	checkId();
});
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