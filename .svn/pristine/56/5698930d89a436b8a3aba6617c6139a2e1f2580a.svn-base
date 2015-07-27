<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:CareLayout>
	<!-- S nav --> 
	<gd:CareNav current_type="${model.type_id}" />
	<!-- E nav -->
	<!-- S content -->
	<div class="clearfix wrap">
		<div class="crumb crumb_wrap">
			<div class="crumb_inner">
				当前位置：<a class="fb crumb_lk" href="care/home/index.shtml">首页</a>
				<span class="crumb_arrow">&gt;</span>
				<a class="crumb_lk" href="care/home/list/${model.type_id}.shtml">${model.type_name}</a><span class="crumb_arrow">&gt;</span>正文	
			</div>
		</div>
		<div class="clerfix article news_detail">
			<!-- S 新闻详细页 -->
			<div class="p_rel mod_wrap">
				<div class="bd">
					<h1 class="readtitle">${model.title} </h1>
					<div class="readtitle2 sub_info">
						编辑：${model.author}&#12288;发布时间：<fmt:formatDate value="${model.create_time}" pattern="yyyy-MM-dd" />&#12288;【<a href="javascript:doZoom(18)">大</a> <a href="javascript:doZoom(16)">中</a> <a href="javascript:doZoom(14)">小</a>】 阅读次数：<c:choose><c:when test="${model.browse_count == null}">1</c:when><c:otherwise>${model.browse_count}</c:otherwise></c:choose>
					</div>
					<div id="article_cont" class="article_cont">
						${model.content}
					</div>
					<c:if test="${!empty model.files}">
						<div class="article_file">
							<h3>附件下载</h3>
							<ul class="list file_li">
								<c:forEach var="item" items="${model.files}">
									<li><a href="care/home/download/${item.id}.shtml" target="_blank">${item.name}</a></li>	
								</c:forEach>
							</ul>
						</div>
					</c:if>					
					<div class="other_article">
						<ul class="sd_list list">
							<c:if test="${prevCare != null}">
								<li>上一篇：<a href="care/home/details/${prevCare.id}.shtml" title="${prevCare.title}">${prevCare.title}</a></li>
							</c:if>
							<c:if test="${nextCare != null}">
								<li>下一篇：<a href="care/home/details/${nextCare.id}.shtml" title="${nextCare.title}">${nextCare.title}</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div><!-- E 新闻详细页 -->
		</div>
	</div><!-- E content --> 
	<script type="text/javascript">
		function doZoom(fontSize){
			var target = $('#article_cont'); 
			target.css({'font-size': fontSize + 'px'});
			target.find('p').each(function(index, item){
				$(item).css({'font-size': fontSize + 'px'}); 
			});
		}
	</script>
</gd:CareLayout> 