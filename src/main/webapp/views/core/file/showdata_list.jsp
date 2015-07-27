<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<table class="wc100">
	<thead>
		<tr> 
			<th class="serial w5per">序号</th>
			<th class="w15per">图片名称</th>
			<th class="w10per">时间</th>
			<th class="w15per">地点</th>
			<th class="w10per">发送人</th>
			<th class="w15per">联系方式</th>
			<th class="w15per">描述</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="item" varStatus="vs">
			<tr> 
				<td class="serial">${vs.count+pageInfo.startIndex}</td> 
				<td>${item.name}</td>
				<td>
					<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/> 
				</td>
				<td> 
					${gdf:gainSpecifiedElement(item.info, "|", 0)}
				</td>
				<td>
					${gdf:gainSpecifiedElement(item.info, "|", 1)}
				</td>
				<td>
					${gdf:gainSpecifiedElement(item.info, "|", 2)}
				</td> 
				<td>
					${gdf:gainSpecifiedElement(item.info, "|", 3)}
				</td> 
				<td>
					<c:choose>
						<c:when test='${gdf:containsValue("gif,jpg,jpeg,png,bmp", item.extension)}'>
							<a href="${item.url}" rel="lightbox"><img src="${item.url}" class="dn" jqimg="${item.url}" />查看</a>
						</c:when> 
					</c:choose>
					<a href="file/download.do?id=${item.id}" class="download" target="_blank">下载</a> 
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<tr>
				<td colspan="8" class="t_c"><span class="no-records">暂无数据</span></td>
			</tr>
		</c:if>
	</tbody>
</table>
<c:if test="${!empty list}">
	<gd:Pager />
</c:if>
<script type="text/javascript">
	$(function(){ 
		$("[rel='lightbox']").picbox();	
	});
</script>