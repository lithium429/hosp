<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<div class="plr10 pager" id="pager">
	<input type="hidden" value="${pageInfo.pageCount}" id="page_count"/>
	<input type="hidden" value="${url}" id="url" />
	<!--S 首页\上一页 按钮 -->
	<c:choose>
		<c:when test="${pageInfo.pageIndex != 1}">
			<a href="${url}.shtml" class="p_sign">首页</a>
			<a href="${url}/${pageInfo.pageIndex-1}.shtml" class="p_sign">上一页</a>
		</c:when>
		<c:otherwise>
			<span class="disabled p_sign">首页</span>
			<span class="disabled p_sign">上一页</span>
		</c:otherwise>
	</c:choose>
	<!--E 首页\上一页 按钮 -->
	<!--S 页数列表 -->
	<c:forEach items="${pageInfo.pageList}" var="item">
		<c:choose>
			<c:when test="${item == pageInfo.pageIndex}">
				<span class="current">${item}</span>
			</c:when>
			<c:otherwise>
				<a href="${url}/${item}.shtml">${item}</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	<!--E 页数列表 -->
	<!--S 下一页\尾页 按钮 -->
	<c:choose>
		<c:when test="${pageInfo.pageIndex != pageInfo.pageCount}">
			<a href="${url}/${pageInfo.pageIndex+1}.shtml" class="p_sign">下一页 </a>
			<a href="${url}/${pageInfo.pageCount}.shtml" class="p_sign">末页</a>
		</c:when>
		<c:otherwise>
			<span class="disabled p_sign">下一页</span>
			<span class="disabled p_sign">末页</span>
		</c:otherwise>
	</c:choose>
	<!--E 下一页\尾页 按钮 -->
	<span class="total">共<em class="num_tot">${pageInfo.pageCount}</em>页</span>
	<!--S 跳转 按钮 -->
	去第 <input type="text" id="text_goto_page" class="mlr5 inp_t" value="${pageInfo.pageIndex}" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
	 size="3" maxlength="3" /> 页 <input type="button" id="btn_goto_page" class="ml5 btn_sub" value="确定" />
	<!--E 跳转 按钮 -->
	<script type="text/javascript">
		$(function(){
			$('#btn_goto_page').click(function(){
				var gotoPage = $('#text_goto_page').val(), 
				pageCount = $('#page_count').val(),
				url = $('#url').val();
				
				// url是否为空判断
				if(!/\S+/.test(url)){
					return false;
				}
				
				// 判断输入页码是否大于当前总页数
				gotoPage = Number(gotoPage);
				pageCount = Number(pageCount);
				if(gotoPage > pageCount){
					gotoPage = pageCount;
				}
				
				window.location.href = url + '/' + gotoPage + '.shtml';
			});
		});
	</script>
</div>