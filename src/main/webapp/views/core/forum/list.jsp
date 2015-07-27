<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:ForumLayout>
	<jsp:attribute name="css">
		<link rel="stylesheet" type="text/css" href="static/js/kindeditor-4.1.4/themes/default/default.css" />
		<style type="text/css">
			.tl th,.tl td{padding:5px 0;border-bottom:1px solid #C2D5E3;}
		</style>
	</jsp:attribute>

	<jsp:body>
		<input type="hidden" id="plate_id" name="plate_id" value="${plateId}" />
		<!-- S top -->
		<gd:ForumTop />
		<!-- E top -->
		<!-- S content -->
		<div id="wp" class="wp">
			<!-- S nav -->
			<gd:ForumNav />
			<!-- E nav -->
			<!--[diy=diynavtop]--><div id="diynavtop" class="area"></div><!--[/diy]-->
			<div class="wp">
				<!--[diy=diy1]--><div id="diy1" class="area"></div><!--[/diy]-->
			</div>
			<div class="boardnav">
				<div id="ct" class="wp cl" style="margin-left:145px"> 
					<!-- S left nav -->
					<gd:ForumLeftNav current_plate_id="${plateId}" />
					<!-- E left nav -->
					<div class="mn">
						<div class="bm bml pbn">
							<div class="bm_h cl">
								<!-- <span class="y">
									<a href="javascript:void(0);" class="fa_bin" target="_blank">回收站</a>									
								</span> -->
								<h1 class="xs2">
									<a href="forum/list/${plate.id}.shtml">${plate.name}</a>
									<span class="xs1 xw0 i">今日: <strong class="xi1">${todayCount}</strong><span class="pipe">|</span>主题: <strong class="xi1">${pageInfo.recordCount}</strong></span>
								</h1>
							</div>
						</div>
		
						<div class="drag">
						<!--[diy=diy4]--><div id="diy4" class="area"></div><!--[/diy]-->
						</div>
		
						<div id="pgt" class="bm bw0 pgs cl">
							<span id="fd_page_top">
								<c:if test="${!empty list}">
									<gd:ForumPager />
								</c:if>
							</span>
							<span class="pgb y"><a href="forum/index.shtml">返&nbsp;回</a></span>
							<a href="javascript:void(0);" title="发新帖" class="btn_add_thread"><img src="static/images/forum/pn_post.png" alt="发新帖"></a>
						</div>
						<div class="tl bm bmw" style="position: relative;">
							<div class="th">
								<table cellspacing="0" cellpadding="0">
									<tbody>
										<tr>
											<th colspan="3">
												<div class="tf">
													<a id="filter_special" href="javascript:void(0);" class="xi2">主题</a>&nbsp;
												</div>
											</th>
											<td class="by">作者</td>
											<td class="num">回复/查看</td>
											<td class="by">最后发表</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="bm_c">
								<table cellspacing="0" cellpadding="0" id="threadlisttableid">
									<thead class="emptb dn">
										<tr>
											<td class="icn"></td>
											<td class="o"></td>
											<th></th>
											<td class="by"></td>
											<td class="num"></td>
											<td class="by"></td>
										</tr>
									</thead> 
									<c:choose>
										<c:when test="${!empty list}">
											<c:forEach items="${list}" var="item">
												<tbody>	
													<tr id="tr_thread_${item.id}">
														<td class="icn">
															<a href="forum/thread/${item.id}.shtml" title="新窗口打开" target="_blank">
																<img src="static/images/forum/folder_common.gif">
															</a>
														</td>
														<th class="common">
															<a href="forum/thread/${item.id}.shtml" class="s xst">
																${gdf:subStringWithEllipsis(item.subject, 28)}
																<c:if test="${item.has_file}">
																	<img src="static/images/forum/common.gif" alt="attachment" title="附件" align="absmiddle" />
																</c:if>
															</a>
														</th>
														<td class="by">
															<cite>
																<a href="forum/user/${item.creator_id}.shtml">${item.creator_name}</a>
															</cite>
															<em><span><fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd" /></span></em>
														</td>
														<td class="num">
															<a href="forum/thread/${item.id}.shtml" class="xi2">${item.reply_count}</a><em>${item.view_count}</em>
														</td>
														<td class="by">
															<cite>
																<a href="forum/user/${item.creator_id}.shtml">${item.last_poster_name}</a>
															</cite>
															<em><a href="forum/thread/${item.id}.shtml#lastpost"><fmt:formatDate value="${item.last_post_time}" pattern="yyyy-MM-dd HH:mm" /></a></em>
														</td>
													</tr>
												</tbody>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<tbody>
												<tr>
													<th colspan="5"><p class="emp">本版块或指定的范围内尚无主题</p></th>
												</tr>
											</tbody>
										</c:otherwise>
									</c:choose> 
								</table><!-- end of table "forum_G[fid]" branch 1/3 -->
							</div>
						</div>
								
						<div class="bm bw0 pgs cl">
							<span id="fd_page_bottom">
								<c:if test="${!empty list}">
									<gd:ForumPager />
								</c:if>
							</span>
							<span id="visitedforumstmp" class="pgb y"><a href="forum/index.shtml">返&nbsp;回</a></span>
							<a href="javascript:void(0);" title="发新帖" class="btn_add_thread"><img src="static/images/forum/pn_post.png" alt="发新帖"></a>
						</div>
						<!--[diy=diyfastposttop]--><div id="diyfastposttop" class="area"></div><!--[/diy]-->
						<div id="f_pst" class="bm">
							<form id="data_form">
								<div class="bm_h"><h2>快速发帖</h2></div>
								<div class="bm_c">
									<div id="fastpostreturn" style="margin:-5px 0 5px"></div>
									<div class="pbt cl">
										<input type="text" id="subject" name="subject" class="px" value="" maxlength="80" onkeyup="util.checkLen(this, '#length_tip', 80);" style="width:25em;" />
										<span>还可输入 <strong id="length_tip">80</strong> 个字符</span>
									</div>
						
									<div class="cl">
										<div id="content_div"></div>
									</div>
									<input type="hidden" id="content" name="content" />
									<div id="file_upload" class="file_div">
										<div class="file_btn">
											<span class="file_title dib">附件</span>
											<span class="btn btn_pub"><a href="file/add.do" id="btn_create">新建</a></span>
											<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_upload">上传</a></span>
											<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_batch_upload">批量上传</a></span>
											<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_select">从文件夹选择</a></span>
										</div>						
										<div class="mt5">
											<div id="file_container" class="dib inp_t mail_input">
												 
											</div>
										</div>
									</div>
									<p class="ptm pnpost">
										<button type="button" name="btn_submit" id="btn_submit" value="" tabindex="13" class="pn pnc">
											<strong>发表帖子</strong>
										</button>
									</p>
								</div>
							</form>
						</div>
						<!--[diy=diyforumdisplaybottom]--><div id="diyforumdisplaybottom" class="area"></div><!--[/diy]-->
					</div>
				</div>
			</div>
			<div class="wp mtn">
				<!--[diy=diy3]--><div id="diy3" class="area"></div><!--[/diy]-->
			</div>
		</div>
		<!-- E content --> 
		<script type="text/javascript" src="static/js/kindeditor-4.1.4/kindeditor.js"></script>
		<script type="text/javascript" src="static/js/kindeditor-4.1.4/lang/zh_CN.js"></script>
		<script type="text/javascript" src="static/js/biz/file.js"></script>
		<script type="text/javascript">
			$(function(){
				//正文在线编辑器
				var editor = KindEditor.create('#content_div', {
			        allowFileManager: false,
			        height: '200px',
			        width: '720px',
			        extraParams: {
			        	isFromEditor: true
			        }
		     	});
				
				// 初始化附件操作
			    file.init({
			    	batchUpload: {
						sizeLimit: Number('${sizeLimit}'),
						uploadLimit: Number('${uploadLimit}'),
						fileTypes: '${fileTypes}'
			    	}
			    }); 
				
				$('.btn_add_thread').click(function(){
					var plateId = $('#plate_id').val();
					openPage({
						url: 'forum/thread/add.do?plate_id=' + plateId,
						title: '发帖',
						width:'800px',
						height:'520px'
					});
					return false;
				});
				
				$('#btn_submit').click(function(){
					function infoDialog(msg){
						showDialog({
					        time: 2,
					        content: msg || '',
					        icon: 'warning',
					        close: true,
					        button: [{
					            name: '关闭',
					            focus: true
					        }]
					    });
					}
					
					var plateId = $('#plate_id').val(), 
					subject = $('#subject').val(),
					content = editor.html(); 
					
					if(util.isEmpty(subject)){
						infoDialog('请输入帖子主题！');
						return false;
					}
					else if(util.isEmpty(content)){
						infoDialog('请输入帖子内容！');
						return false;
					}
					$('#content').val(content);
					util.ajax({
						url: 'forum/thread/add.do?plate_id=' + plateId,
						type: 'post',
						data: $('#data_form').serialize(),
						success: function(result){
							if(result.flag){
								successMsg('帖子发表成功！', function(){
									window.location.reload();
								});
							}
						}
					});
				});
			});
			 
		</script>
	</jsp:body>
</gd:ForumLayout> 
 