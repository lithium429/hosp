<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:ForumLayout>
	<jsp:attribute name="css">
		<link rel="stylesheet" type="text/css" href="static/js/kindeditor-4.1.4/themes/default/default.css" /> 
	</jsp:attribute>

	<jsp:body>
		<input type="hidden" id="plate_id" value="${plateId}" />
		<input type="hidden" id="thread_id" value="${thread.id}" />
		<input type="hidden" id="reply_count" value="${reply_count}" />
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
			<div id="ct" class="wp cl">
				<div id="pgt" class="pgs mbm cl pbm bbs">
					<div class="pgt">
						<c:if test="${!empty list}">
							<gd:ForumPager />
						</c:if>
					</div>
					<span class="y pgb"><a href="${returnUrl}">返回</a></span>
					<a href="javascript:void(0);" title="发新帖" class="btn_add_thread"><img src="static/images/forum/pn_post.png" alt="发新帖" /></a>
					<a href="javascript:void(0);" title="回复" class="btn_add_post"><img src="static/images/forum/pn_reply.png" alt="回复" /></a>
				</div> 
				<c:if test="${thread.creator_id == forumUserTop.user_id || isPlateAdmin}">
					<div id="modmenu" class="xi2 pbm">
						<a href="javascript:void(0);" class="btn_delete">删除主题</a><span class="pipe">|</span><a href="javascript:void(0);" class="btn_move">移动</a>
					</div>
				</c:if>
				<div id="postlist" class="pl bm">
					<table cellspacing="0" cellpadding="0">
						<tbody>
							<tr>
								<td class="pls ptn pbn">
									<div class="hm ptn">
										<span class="xg1">查看:</span> <span class="xi1">${thread.view_count}</span><span class="pipe">|</span><span class="xg1">回复:</span> <span class="xi1">${thread.reply_count}</span>
									</div>
								</td>
								<td class="plc ptm pbn vwthd">
									<div class="y">
										<c:choose>
											<c:when test="${prevThread != null}">
												<a href="forum/thread/${prevThread.id}.shtml" title="上一主题"><img src="static/images/forum/thread-prev.png" alt="上一主题" class="vm" /></a>
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0);" title="上一主题"><img src="static/images/forum/thread-prev.png" alt="上一主题" class="vm" /></a>
											</c:otherwise>
										</c:choose>
										<c:choose>
											<c:when test="${nextThread != null}">
												<a href="forum/thread/${nextThread.id}.shtml"  title="下一主题"><img src="static/images/forum/thread-next.png" alt="下一主题" class="vm" /></a>
											</c:when>
											<c:otherwise>
												<a href="javascript:void(0);" title="下一主题"><img src="static/images/forum/thread-next.png" alt="下一主题" class="vm" /></a>
											</c:otherwise>
										</c:choose>
									</div>
									<h1 class="ts">
										<span id="thread_subject">${thread.subject}</span>
									</h1> 
								</td>
							</tr>
						</tbody>
					</table> 
					
					<table cellspacing="0" cellpadding="0" class="ad">
						<tbody>
							<tr>
								<td class="pls"></td>
								<td class="plc"></td>
							</tr>
						</tbody>
					</table>
					
					<c:forEach items="${list}" var="item" varStatus="vsList">
						<c:choose>
							<c:when test="${vsList.index == 0 && pageInfo.pageIndex == 1}">
								<div id="post_${item.id}">
									<table class="plhin" cellspacing="0" cellpadding="0">
										<tbody>
											<tr>
												<td class="pls" rowspan="2">
													<div id="favatar36" class="pls favatar">
							 							<div class="pi">
															<div class="authi"><a href="forum/user/${thread.creator_id}.shtml" target="_blank" class="xw1">${thread.creator_name}</a></div>
														</div> 
														<div>
															<div class="avatar">
																<a href="forum/user/${thread.creator_id}.shtml" class="avtm" target="_blank">
																	<c:choose>
																		<c:when test="${empty thread.user.micon_url}">
																			<img src="static/images/forum/noavatar_middle.gif" alt="" />
																		</c:when>
																		<c:otherwise>
																			<img src="${thread.user.micon_url}" alt="" />
																		</c:otherwise>
																	</c:choose>
																</a>
															</div>
														</div>
														<div class="tns xg2">
															<table cellspacing="0" cellpadding="0">
																<tbody>
																	<tr>
																		<th>
																			<p>
																				<a href="forum/user/thread.shtml?uid=${thread.creator_id}" class="xi2">${thread.user.thread_count}</a>
																			</p>
																			主题
																		</th>
																		<td>
																			<p>
																				<a href="forum/user/post.shtml?uid=${thread.creator_id}" class="xi2">${thread.user.post_count}</a>
																			</p>
																			帖子
																		</td>
																	</tr>
																</tbody>
															</table>
														</div>
							
														<dl class="pil cl"></dl>  
													</div>
												</td>
												<td class="plc">
													<div class="pi">
														<strong>
															<a href="javascript:void(0);"><em>${vsList.index + 1}</em><sup>#</sup></a>
														</strong>
														<div class="pti">
															<div class="pdbt">
															</div>
															<div class="authi">
																<img class="authicn vm" id="authicon36" src="static/images/forum/online_member.gif">
																<em id="authorposton36">发表于 <fmt:formatDate value="${thread.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></em>
																<span class="pipe">|</span>
																<c:choose>
																	<c:when test="${empty author_id}">
																		<a href="${url}.shtml?author_id=${thread.creator_id}">只看该作者</a>
																	</c:when>
																	<c:otherwise>
																		<a href="${url}.shtml">显示全部楼层</a>
																	</c:otherwise>
																</c:choose> 
																<!-- <span class="pipe">|</span><a href="javascript:void(0);">倒序浏览</a>  -->
															</div>
														</div>
													</div>
													<div class="pct">
														<style type="text/css">.pcb{margin-right:0}</style>
														<div class="pcb">
															<c:if test="${thread.is_close}">
																<div class="locked">提示: <em>该帖被管理员或版主屏蔽，只有管理员或有管理权限的成员可见</em></div>
															</c:if>
															<div class="t_fsz">
																<table cellspacing="0" cellpadding="0">
																	<tbody>
																		<tr>
																			<td class="t_f">
																				${item.content}
																			</td>
																		</tr>
																	</tbody>
																</table>
																<c:if test="${thread.files != null}">
																	<ul class="forum_file_ul">
																		<c:forEach var="fileItem" items="${thread.files}">
																			<li>
																				<img src="static/images/forum/common.gif" alt="attachment" title="附件" align="absmiddle" />
																				<a href="forum/file/download/${fileItem.id}.shtml" title="点击下载" target="_blank">${fileItem.name}</a>
																			</li>
																		</c:forEach>
																	</ul>
																</c:if>
																<div id="vfastpost" class="fullvfastpost">
																	<table cellspacing="0" cellpadding="0" id="vfastposttb">
																		<tbody>
																			<tr>
																				<td id="vf_l"></td>
																				<td id="vf_m">
																					<input type="text" name="content" id="content" value="#在这里快速回复#" style="color:#CDCDCD;" />
																				</td>
																				<td id="vf_r"></td>
																				<td id="vf_b">
																					<button type="button" class="pn pnc" id="btn_fast_reply" value="true"></button>
																				</td>
																			</tr>
																		</tbody>
																	</table> 
																</div>
															</div> 
														</div>
													</div>
												</td>
											</tr>
											<tr>
												<td class="plc plm">
													<c:if test="${item.is_first}">
														<div id="p_btn" class="mtw mbm hm cl">
															<a href="javascript:void(0);" id="btn_add_fav" title="收藏本帖"><i><img src="static/images/forum/fav.gif" alt="收藏">收藏</i></a>
														</div>
													</c:if>
												</td>
											</tr>
											<tr>
												<td class="pls"></td>
												<td class="plc" style="overflow:visible;">
													<div class="po hin">
														<div class="pob cl">
															<em>
																<a class="btn_add_post fastre" href="javascript:void(0);">回复</a>
																<c:if test="${item.creator_id == forumUserTop.user_id || isPlateAdmin}">
																	<a class="btn_edit_thread editp" href="javascript:void(0);">编辑</a>
																</c:if>
															</em>						
														</div>
													</div>
												</td>
											</tr>
											<tr class="ad">
												<td class="pls"></td>
												<td class="plc"></td>
											</tr>
										</tbody>
									</table>
								</div>
							</c:when>
							<c:otherwise>
								<div id="post_${item.id}">
									<table class="plhin" cellspacing="0" cellpadding="0">
										<tbody>
											<tr>
												<td class="pls" rowspan="2">
													<div id="favatar36" class="pls favatar">
							 							<div class="pi">
															<div class="authi"><a href="forum/user/${item.creator_id}.shtml" target="_blank" class="xw1">${item.creator_name}</a></div>
														</div> 
														<div>
															<div class="avatar">
																<a href="forum/user/${item.creator_id}.shtml" class="avtm" target="_blank">
																	<c:choose>
																		<c:when test="${empty item.user.micon_url}">
																			<img src="static/images/forum/noavatar_middle.gif" alt="" />
																		</c:when>
																		<c:otherwise>
																			<img src="${item.user.micon_url}" alt="" />
																		</c:otherwise>
																	</c:choose>
																</a>
															</div>
														</div>
														<div class="tns xg2">
															<table cellspacing="0" cellpadding="0">
																<tbody>
																	<tr>
																		<th>
																			<p>
																				<a href="forum/user/thread.shtml?uid=${item.creator_id}" class="xi2">${item.user.thread_count}</a>
																			</p>
																			主题
																		</th>
																		<td>
																			<p>
																				<a href="forum/user/post.shtml?uid=${item.creator_id}" class="xi2">${item.user.post_count}</a>
																			</p>
																			帖子
																		</td>
																	</tr>
																</tbody>
															</table>
														</div>
							
														<dl class="pil cl"></dl>  
													</div>
												</td>
												<td class="plc">
													<a name="post_${item.id}" class="anchor"></a>
													<div class="pi">
														<strong>
															<a href="javascript:void(0);"><em>${vsList.index + 1 + (pageInfo.pageSize * (pageInfo.pageIndex - 1))}</em><sup>#</sup></a>
														</strong>
														<div class="pti">
															<div class="pdbt">
															</div>
															<div class="authi">
																<img class="authicn vm" id="authicon36" src="static/images/forum/online_member.gif">
																<em id="authorposton36">发表于 <fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></em>
																<span class="pipe">|</span>
																<c:choose>
																	<c:when test="${empty author_id}">
																		<a href="${url}.shtml?author_id=${item.creator_id}">只看该作者</a>
																	</c:when>
																	<c:otherwise>
																		<a href="${url}.shtml">显示全部楼层</a>
																	</c:otherwise>
																</c:choose>   
															</div>
														</div>
													</div>
													<div class="pct">
														<style type="text/css">.pcb{margin-right:0}</style>
														<div class="pcb">
															<div class="t_fsz">
																<table cellspacing="0" cellpadding="0">
																	<tbody>
																		<tr>
																			<td class="t_f">
																				<c:if test="${item.replyed_post != null}">
																					<div class="quote">
																						<blockquote>
																							<font size="2">
																								<a href="${item.replyed_url}" target="_blank">
																									<font color="#999999">${item.replyed_post.creator_name} 发表于<fmt:formatDate value="${item.replyed_post.create_time}" pattern="yyyy-MM-dd HH:mm" /></font>
																								</a>
																							</font>
																							<br />
																							${item.replyed_post.content}
																						</blockquote>
																					</div>
																					<br />
																				</c:if>
																				${item.content}
																			</td>
																		</tr>
																	</tbody>
																</table> 
																<c:if test="${item.files != null}">
																	<ul class="forum_file_ul">
																		<c:forEach var="fileItem" items="${item.files}">
																			<li>
																				<img src="static/images/forum/common.gif" alt="attachment" title="附件" align="absmiddle" />
																				<a href="forum/file/download/${fileItem.id}.shtml" title="点击下载" target="_blank">${fileItem.name}</a>
																			</li>
																		</c:forEach>
																	</ul>
																</c:if>
															</div> 
														</div>
													</div>
												</td>
											</tr> 
											<tr>
												<td class="plc plm"></td>
											</tr>
											<tr>
												<td class="pls"></td>
												<td class="plc" style="overflow:visible;">
													<div class="po hin">
														<div class="pob cl">
															<em>
																<a class="btn_add_post_reply fastre" href="javascript:void(0);" replyed_id="${item.id}">回复</a>
																<c:if test="${item.creator_id == forumUserTop.user_id || isPlateAdmin}">
																	<a class="btn_edit_post editp" href="javascript:void(0);" post_id="${item.id}" <c:if test="${item.replyed_post != null}">replyed_id="${item.replyed_post.id}"</c:if>>编辑</a>
																</c:if>
															</em>						
														</div>
													</div>
												</td>
											</tr>
											<tr class="ad">
												<td class="pls"></td>
												<td class="plc"></td>
											</tr>
										</tbody>
									</table>
								</div>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
				<div class="xi2 mbm pbm bbs">
					<c:if test="${thread.creator_id == forumUserTop.user_id || isPlateAdmin}">
						<a href="javascript:void(0);" class="btn_delete">删除主题</a><span class="pipe">|</span><a href="javascript:void(0);" class="btn_move">移动</a>
					</c:if>
				</div>
				<div class="pgs mtm mbm cl">
					<div class="pgt">
						<c:if test="${!empty list}">
							<gd:ForumPager />
						</c:if>
					</div>
					<span class="y pgb"><a href="${refererUrl}">返回</a></span>
					<a href="javascript:void(0);" title="发新帖" class="btn_add_thread"><img src="static/images/forum/pn_post.png" alt="发新帖"></a>
					<a href="javascript:void(0);" title="回复" class="btn_add_post"><img src="static/images/forum/pn_reply.png" alt="回复"></a>
				</div>
				<!--[diy=diyfastposttop]-->
				<div id="diyfastposttop" class="area"></div>
				<!--[/diy]-->
				<div id="f_pst" class="pl bm bmw">
					<form id="data_form">
						<table cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<td class="pls">
										<div class="avatar avtm">
											<img src="${forumUserTop.micon_url}" />
										</div>
									</td>
									<td class="plc">
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
											<button type="button" id="btn_submit" class="pn pnc vm" value="replysubmit"><strong>发表回复</strong></button>
											<!-- <label for="fastpostrefresh"><input id="fastpostrefresh" type="checkbox" class="pc">回帖后跳转到最后一页</label> --> 
										</p>
									</td>
								</tr>
							</tbody>
						</table>
					</form>
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
			var editor = null;
		
			$(function(){
				//正文在线编辑器
				editor = KindEditor.create('#content_div', {
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
				
				// Thread相关
				thread.init();
				
				// 快速回复
				fastPost.init();
			});
			
			var thread = (function(){
				var plateId = $('#plate_id').val(),
				threadId = $('#thread_id').val(),
				replyCount = $('#reply_count').val(),
				flayer = Number(replyCount) + 1,
				pageIndex = $('#page_index').val();
				
				function init(){
					$('.btn_delete').click(remove);
					$('.btn_move').click(move);
					$('.btn_add_thread').click(add);
					$('.btn_add_post').click(addPost);
					$('.btn_edit_thread').click(editThread);
					$('.btn_add_post_reply').click(addPostReply);
					$('.btn_edit_post').click(editPost);
					$('#btn_add_fav').click(addToFav);
					$('#btn_submit').click(addPostByPop);
				}
				
				function add(){
					openPage({
						url: 'forum/thread/add.do?from=thread&plate_id=' + plateId,
						title: '发帖',
						width:'810px',
						height:'478px'
					});
					return false;
				}
				
				function addPost(){
					openPage({
						url: 'forum/post/add.do?plate_id=' + plateId + '&thread_id=' + threadId + '&reply_count=' + replyCount + '&flayer=' + flayer,
						title: '回复',
						width:'810px',
						height:'468px'
					});
					return false; 
				}
				
				function addPostByPop(){
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
					
					var content = editor.html();  
					if(util.isEmpty(content)){
						infoDialog('请输入回复内容！');
						return false;
					}
					$('#content').val(content);
					util.ajax({
						url: ['forum/post/add.do?plate_id=', plateId, '&thread_id=', threadId, '&reply_count=', replyCount, '&flayer=', flayer].join(''),
						type: 'post',
						data: $('#data_form').serialize(),
						success: function(result){
							if(result.flag){
								successMsg('回复成功！', function(){
									window.location.reload();
								});
							}
						}
					});
				}
				
				// 添加对指定跟帖回复
				function addPostReply(){
					var replyedId = $(this).attr('replyed_id'),
					urlArray = ['forum/post/add.do?plate_id=', plateId, 
							    '&thread_id=', threadId,
							    '&reply_count=', replyCount,
							    '&flayer=', flayer,
							    '&replyed_id=', replyedId,
							    '&page_index=', pageIndex]; 
					openPage({
						url: urlArray.join(''),
						title: '回复',
						width: '810px',
						height: '520px'
					});
				}
				
				// 修改主题
				function editThread(){
					openPage({
						url: 'forum/thread/update.do?id=' + threadId,
						title: '修改主题',
						width: '810px',
						height: '468px'
					});
				}
				
				// 修改回复
				function editPost(){
					var id = $(this).attr('post_id'),
					replyedId = $(this).attr('replyed_id'),
					height = '468px',
					urlArray = [ 'forum/post/update.do?id=', id, 
					             '&thread_id=', threadId ];
					if(!util.isNull(replyedId)){
						height = '520px';
						urlArray.push('&replyed_id=' + replyedId);
					}
					
					openPage({
						url: urlArray.join(''),
						title: '修改回复',
						width: '810px',
						height: height
					});
				}
				
				// 删除
				function remove(){
					confirmDialog('您确认要删除该主题么？', function(){
						util.ajax({
							url: 'forum/thread/logic_delete.do?id=' + threadId + '&plate_id=' + plateId,
							type: 'post',
							dataType: 'json',
							success: function(result){
								if(result.flag){
									window.location.reload();
								}
							}
						});
					})
				}
				
				// 关闭
				function close(){
					
				}
				
				// 移动
				function move(){
					openPage({
						url: 'forum/thread/move.do?plate_id=' + plateId + '&id=' + threadId,
						title: '移动',
						width:'400px',
						height:'160px'
					});
					return false; 
				}
				
				// 收藏主题
				function addToFav(){  
					util.ajax({
						url: 'forum/user/fav/add.do',
						type: 'post',
						data: { id: threadId },
						success: function(result){
							if(result.flag){
								successMsg('收藏成功！');
							}
							else{
								informationMsg(result.msg ? result.msg : '收藏失败！');
							}
						}
					});
				}
				
				return { init: init };
			})();
			
			// 快速回复
			var fastPost = (function(){
				function init(){
					$('#content').focus(function(){
						if(this.value === '#在这里快速回复#'){
							$(this).val('').removeAttr('style');
						}
					}).blur(function(){
						if(util.isEmpty(this.value)){
							$(this).val('#在这里快速回复#').css({ 'color': '#CDCDCD' });
						}
					});
					
					$('#btn_fast_reply').click(postReply);
				}
				
				function postReply(){
					var plateId = $('#plate_id').val(), 
					threadId = $('#thread_id').val(),
					replyCount = $('#reply_count').val(),
					content = $('#content').val();
					if(content === '#在这里快速回复#' || util.isEmpty(content)){
						return false;
					}
					util.ajax({
						url: 'forum/post/add.do',
						type: 'post',
						data: { plate_id: plateId, thread_id: threadId, content: content, reply_count: replyCount, flayer: Number(replyCount) + 1 },
						success: function(result){
							if(result.flag){
								successMsg('帖子发表成功！', function(){
									window.location.reload();
								});
							}
						}
					});
				} 
				
				return { init: init };
			})();
			 
		</script>
	</jsp:body>
</gd:ForumLayout> 
 