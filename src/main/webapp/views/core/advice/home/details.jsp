<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:AdviceLayout>
	<!-- S nav --> 
	<gd:AdviceNav current_type="4" />
	<!-- E nav -->
	<!-- S content -->
	<div class="clearfix wrap">
		<%-- <div class="crumb crumb_wrap">
			<div class="crumb_inner">
				当前位置：<a class="fb crumb_lk" href="care/home/index.shtml">首页</a>
				<span class="crumb_arrow">&gt;</span>
				<a class="crumb_lk" href="care/home/list/${model.type_id}.shtml">${model.type_name}</a><span class="crumb_arrow">&gt;</span>正文	
			</div>
		</div> --%>
		<div class="clerfix article news_detail mail_detail">
			<!-- S 详细页 -->
			<div class="p_rel mod_wrap">
				<div class="bd">
					<h1 class="readtitle">${model.title} </h1>
					<div class="readtitle2 mail_head">
						<ul class="info_list">
							<li>写信人：${model.is_anonymous?'匿名':model.user_name}&#12288;</li>
							<li>提交时间：<fmt:formatDate value="${model.create_time}" pattern="yyyy-MM-dd HH:mm:ss" />&#12288;</li>
							<li>复杂度：${model.complexity==1?'一般':'复杂' }&#12288;</li>
							<li>紧急程度：
							<c:choose>
								<c:when test="${model.urgency==1 }">一般</c:when>
								<c:when test="${model.urgency==2 }">重要</c:when>
								<c:when test="${model.urgency==3 }">紧急</c:when>
							</c:choose>
							</li>
							<li>信件类型:&#12288;
								<c:choose>
									<c:when test="${model.type==1 }">申诉</c:when>
									<c:when test="${model.type==2 }">求决</c:when>
									<c:when test="${model.type==3 }">举报投诉</c:when>
									<c:when test="${model.type==4 }">反映建议</c:when>
									<c:when test="${model.type==5 }">其它咨询</c:when>
								</c:choose>
							</li>
							<li>主题：${model.topic_name}</li>
						</ul> 
					</div>
					<div id="article_cont" class="article_cont">
						${model.content}
					</div>	
					<c:if test="${model.state==2 }">
					<div class="dispose_cont">	
						<ul class="info_list">
							<li>处理人：${model.haddle_name}&#12288;</li>
							<li>处理时间：<fmt:formatDate value="${model.haddle_time}" pattern="yyyy-MM-dd HH:mm:ss" /></li>						
						</ul>
						<div id="" class="article_cont">
							${model.haddle_content}
						</div>
					</div>		
					</c:if>
					<div class="other_article">
						<ul class="sd_list list">
							<c:if test="${prevAdvice != null}">
								<li>上一篇：<a href="advice/home/details/${prevAdvice.id}.shtml" title="${prevAdvice.title}">${prevAdvice.title}</a></li>
							</c:if>
							<c:if test="${nextAdvice != null}">
								<li>下一篇：<a href="advice/home/details/${nextAdvice.id}.shtml" title="${nextAdvice.title}">${nextAdvice.title}</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div><!-- E 详细页 -->
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
</gd:AdviceLayout> 