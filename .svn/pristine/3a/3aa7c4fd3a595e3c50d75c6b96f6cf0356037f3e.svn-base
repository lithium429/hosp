<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<table class="wc100">
	<thead>
		<tr>
			<th class="check w3per">
				<input type="checkbox" id="check_all" class="inp_analog" />
				<span class="icon ico-checkbox"></span>
			</th>
			<th class="serial w5per">序号</th>
			<th class="w30per">文件</th>
			<th class="w20per">文件类型</th>
			<th class="w20per">创建时间</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="item" varStatus="vs">
			<tr>
				<td class="check w3per">
					<input type="checkbox" name="id" class="inp_analog batch" value="${item.id}" rel="${item.name}|${item.url}" />
					<span class="icon ico-checkbox"></span>
				</td>
				<td class="serial">${vs.count+pageInfo.startIndex}</td> 
				<td>${item.name}</td>
				<td>
					<c:choose>
						<c:when test="${item.type == 1}">文档</c:when>
						<c:when test="${item.type == 2}">图片</c:when>
						<c:when test="${item.type == 3}">其它</c:when>
					</c:choose>
				</td>
				<td>
					<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td> 
				<td>
					<c:choose>
						<c:when test='${gdf:containsValue("gif,jpg,jpeg,png,bmp", item.extension)}'>
							<a href="${item.url}" rel="lightbox"><img src="${item.url}" class="dn" jqimg="${item.url}" />查看</a>
						</c:when>
						<c:when test='${gdf:containsValue("doc,docx,xls,xlsx,ppt", item.extension)}'>
							<a href="file/view.do?id=${item.id}" class="view">阅读</a> 
						</c:when>
					</c:choose> 
				</td>
			</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<tr>
				<td colspan="6" class="t_c"><span class="no-records">暂无数据</span></td>
			</tr>
		</c:if>
	</tbody>
</table>
<c:if test="${!empty list}">
	<gd:Pager />
	<div class="bot_fun" style="width: 300px;"> 
		<a class="btn" id="btn_select" href="javascript:void(0);">选择</a>
	</div> 
</c:if>
<script type="text/javascript">
	$(function(){
		$("[rel='lightbox']").picbox();	
		
		$('#btn_select').click(function(){
			var opener = art.dialog.open.origin, itemArray;
			$('input[name="id"]:checked').each(function(index, item){
				itemArray = $(item).attr('rel').split('|');
				opener.file.setItem({
					type: '3',
					name: itemArray[0],
					url: itemArray[1],
					file_id: item.value
				});
			});
			closeDialog();
		});
	});
</script>