<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>

<c:if test="${pageInfo != null && pageInfo.pageCount > 1}">
	<div class="pg">
		<c:if test="${pageInfo.pageIndex > 1}">
			<a href="${url}/${pageInfo.pageIndex - 1}.shtml${queryParam}" class="prev">上一页</a>
		</c:if>
		<c:forEach items="${pageInfo.pageList}" var="item">
			<c:choose>
				<c:when test="${item == pageInfo.pageIndex}">
					<strong>${item}</strong>
				</c:when>
				<c:otherwise>
					<a href="${url}/${item}.shtml${queryParam}">${item}</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<label>
			<input type="text" name="custom_page" class="px" size="2" title="输入页码，按回车快速跳转" value="${pageInfo.pageIndex}" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" />
			<span title="共 ${pageInfo.pageCount} 页"> / ${pageInfo.pageCount}页</span>
		</label>
		<c:if test="${pageInfo.pageIndex < pageInfo.pageCount}">
			<a href="${url}/${pageInfo.pageIndex + 1}.shtml${queryParam}" class="nxt">下一页</a>
		</c:if>
		<input type="hidden" id="page_count" name="page_count" value="${pageInfo.pageCount}" />
		<input type="hidden" id="page_index" name="page_index" value="${pageInfo.pageIndex}" />
	</div> 
</c:if>

<script type="text/javascript">
	$(function(){
		fpager.init();	
	});
	
	var fpager = (function(){
		function init(){
			$('input[name="custom_page"]').keydown(function(e){
				go(e, this.value);
			});
		}
		
		function go(event, pageIndex){
			if(event.keyCode == 13){
				var pageCount = $('#page_count').val();
				if(Number(pageIndex) > Number(pageCount)){
					pageIndex = pageCount;
				}
				window.location.href = '${baseUrl}${url}/'+ pageIndex + '.shtml${queryParam}';
				return false;
			}
		}
		
		return { init: init };
	})();
</script>