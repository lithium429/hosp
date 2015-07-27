
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout> 
	<div id="welcomebody">
	    <table class="wc100" cellpadding="0" cellspacing="0">
	        <tr>
	            <td valign="top">
	                <div class="clearfix manage">
	                    <div class="home_model" id="announcement">
	                        <div class="hd">
	                            <h2>最新公告</h2>
	                        </div>
	                        <div class="bd p_rel">
	                        	<div id="announcement_type" class="tabs_hd">
	                        		<ul class="clearfix Tab_Panels">
	                        			<li class="cur"><a href="javascript:void(0);" class="announcement_type ml10 tab_inner" rel="0">全部公告</a></li>
		                        		<c:if test="${announcementTypeList != null}">
		                        			<c:forEach var="item" items="${announcementTypeList}" varStatus="vs">
		                        				<li><a href="javascript:void(0);" class="announcement_type tab_inner" rel="${item.id}">${item.name}</a></li>
		                        			</c:forEach>
		                        		</c:if>
	                        		</ul>
	                        	</div>
                        		<ul id="announcement_ul" class="list" style="height:130px;overflow:hidden;">
                        			<c:choose>
                        				<c:when test="${!empty announcementList}">
		                        			<c:forEach var="item" items="${announcementList}">
		                        				<li>
		                        					<a href="javascript:announcement.view('${item.id}');">【${item.type_name}】&nbsp;${item.title}</a>
		                        					<span>（<fmt:formatDate value="${item.valid_date}" pattern="yyyy-MM-dd" />）</span>
		                        				</li>
		                        			</c:forEach>
		                        		</c:when>
		                        		<c:otherwise>
		                        			<li>暂无公告</li>
		                        		</c:otherwise>
		                        	</c:choose>
                        		</ul>
                        		<a href="javascript:void(0);" url="announcement/list.do?is_home=true" id="announce_list" class="p_abs abs_rt ">更多&gt;&gt;</a>
	                        </div>
	                    </div>
	                    <div class="home_model" id="publicity_column">
	                        <div class="hd">
	                            <h2>公示栏</h2>
	                        </div>
	                        <div class="bd p_rel">
	                        	<div id="publicity_column_type" class="tabs_hd">
	                        		<ul class="clearfix Tab_Panels">
	                        			<li class="cur"><a href="javascript:void(0);" class="publicity_column_type ml10 tab_inner" rel="1">院务公开栏</a></li>
		                        		<li><a href="javascript:void(0);" class="publicity_column_type ml10 tab_inner" rel="2">党务公开栏</a></li>
		                        		<li><a href="javascript:void(0);" class="publicity_column_type ml10 tab_inner" rel="3">奖惩公示栏</a></li>
		                        		<li><a href="javascript:void(0);" class="publicity_column_type ml10 tab_inner" rel="4">其它</a></li>
	                        		</ul>
	                        	</div>
                        		<ul id="publicity_column_ul" class="list" style="height:130px;overflow:hidden;">
                        			<c:choose>
                        				<c:when test="${!empty publicityColumnList}">
		                        			<c:forEach var="item" items="${publicityColumnList}"> 
		                        				<li>
		                        					<a href="javascript:publicityColumn.view('${item.id}');">${item.title}
		                        						<span>（<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm" />）</span>
		                        					</a>
		                        				</li>
		                        			</c:forEach>
		                        		</c:when>
		                        		<c:otherwise>
		                        			<li>暂无公示</li>
		                        		</c:otherwise>
		                        	</c:choose>
                        		</ul>
                        		<a href="javascript:void(0);" url="publicityColumn/list.do?is_home=true" id="pc_list" class="p_abs abs_rt list_more">更多&gt;&gt;</a>
	                        </div>
	                    </div>
	                    <div class="home_model" id="meeting">
	                        <div class="hd">
	                            <h2>我的会议</h2>
	                        </div>
	                        <div class="bd p_rel">
	                            <div id="metting_type" class="tabs_hd">
	                        		<ul class="clearfix Tab_Panels">
	                        			<li class="cur"><a href="javascript:void(0);" class="meeting_type tab_inner" rel="1">本周会议</a></li>
	                        			<li><a href="javascript:void(0);" class="meeting_type tab_inner" rel="2">未来七天会议</a></li>
	                        		</ul>
	                        	</div>
                        		<ul id="meeting_ul" class="list" style="height:130px;overflow:hidden;">
                        			<c:choose>
                        				<c:when test="${!empty meetingList}">
		                        			<c:forEach var="item" items="${meetingList}">
		                        				<li>
		                        					<a href="javascript:meeting.view('${item.id}');">${item.subject}</a>
		                        					<span>（<fmt:formatDate value="${item.begin_time}" pattern="MM-dd HH:mm" /> - <fmt:formatDate value="${item.end_time}" pattern="MM-dd HH:mm" />）</span>
		                        				</li>
		                        			</c:forEach>
	                        			</c:when>
	                        			<c:otherwise>
	                        				<li>暂无会议</li>
	                        			</c:otherwise>
                        			</c:choose>
                        		</ul>
                        		<a href="javascript:void(0);" url="meeting/list.do?type=0" class="p_abs abs_rt list_more">更多&gt;&gt;</a>
	                        </div>
	                    </div>
	                    <div class="home_model" id="email">
	                        <div class="hd">
	                            <h2>内部邮件</h2>
	                        </div>
	                        <div class="bd p_rel">
	                        	<div id="email_type" class="tabs_hd">
	                        		<ul class="clearfix Tab_Panels">
	                        			<li class="cur"><a href="javascript:void(0);" class="email_type tab_inner" rel="">全部邮件</a></li>
	                        			<li><a href="javascript:void(0);" class="email_type tab_inner" rel="0">未读邮件</a></li>
	                        			<li><a href="javascript:void(0);" class="email_type tab_inner" rel="1">已读邮件</a></li>
	                        		</ul>
	                        	</div>
	                            <ul id="email_ul" class="list" style="height:130px;overflow:hidden;">
                        			<c:choose>
                        				<c:when test="${!empty emailList}">
		                        			<c:forEach var="item" items="${emailList}">
		                        				<li>
		                        					<a href="javascript:email.view('${item.id}');">${item.sender_name}&nbsp;${item.subject}</a>
		                        				</li>
		                        			</c:forEach>
	                        			</c:when>
	                        			<c:otherwise>
	                        				<li>暂无邮件</li>
	                        			</c:otherwise>
                        			</c:choose>
                        		</ul>
                        		<a href="javascript:void(0);" url="email/list.do?type=0" class="p_abs abs_rt list_more">更多&gt;&gt;</a>
	                        </div>
	                    </div>
	                    <div class="home_model">
	                        <div class="hd">
	                            <h2>今日值班</h2>
	                        </div>
	                        <div class="bd">
	                           <ul class="list">
	                           		<c:choose>
                        				<c:when test="${!empty schedulingMap}">
		                        			<c:forEach var="key" items="${schedulingMap.keySet()}">
		                        				<c:set var="list" value="${schedulingMap.get(key)}" />
		                        				<c:set var="first" value="${list.get(0)}" />
		                        				<li>
		                        					<span class="bold">${first.dept_name}</span>
													<c:forEach var="item" items="${list}">		                        					
		                        						<span>（<fmt:formatDate value="${item.start_time}" pattern="HH:mm" /> - <fmt:formatDate value="${item.end_time}" pattern="HH:mm" />）</span>
		                        						<c:if test="${!empty item.users}">
			                        						<c:forEach var="itemUser" items="${item.users}">	
			                        							<span>${itemUser.user_name}（${itemUser.user_mobile}）</span>
			                        						</c:forEach>
		                        						</c:if>
		                        					</c:forEach>
		                        				</li>
		                        			</c:forEach>
	                        			</c:when>
	                        			<c:otherwise>
	                        				<li>暂无值班</li>
	                        			</c:otherwise>
                        			</c:choose>
	                           </ul>
	                        </div>
	                    </div>
	                </div>
	            </td>
	        </tr>
	    </table>
	</div>
	
	<script type="text/javascript"> 
	
		// 打开更多tab
		var linkMore = (function(){
			var parent = window.parent;
			function init(){
				$('.list_more').click(function(){
					var url = $(this).attr('url');
					parent.tab.openPanel(url);
				});
				
				$("#announce_list").click(function(){
					openPage({
						url : $(this).attr('url'),
						id : 'view_announcement_page',
						title : '公告',
						width : '90%',
						height : '80%' 
					});
					return false;
				});
				
				$("#pc_list").click(function(){
					openPage({
						url : $(this).attr('url'),
						id : 'view_pc_page',
						title : '公示',
						width : '90%',
						height : '80%' 
					});
					return false;
				});
			}
			
			return { init: init };
		})();
	
		// 公告
		var announcement = (function(){
			var container = $('#announcement'),
			ul = $('#announcement_ul'),
			tmpl = ['<li>',
						'<a href="javascript:announcement.view(\'{0}\');">【{1}】&nbsp;{2}</a>',
						'<span>（{3}）</span>',
					'</li>'].join('');
			function init(){
				$('.announcement_type', container).click(function(){
					var typeId = $(this).attr('rel');
					get(typeId);
				});
			}
			
			function get(typeId){
				util.ajax({
					url: 'announcement/homelist.do',
					type: 'post',
					data: { typeId: typeId },
					dataType: 'json',
					success: function(result){
						if(result.flag){
							var builder = new StringBuilder();
							$.each(result.obj, function(index, item){
								builder.appendFormat(tmpl, item.id, item.type_name, item.title, dateUtil.format(new Date(item.valid_date), 'yyyy-MM-dd'));
							});
							if(builder.getLength() > 0){
								ul.html(builder.toString());
								marquee.init();
							}
							else{
								ul.html('<li>暂无公告</li>');
							}
						}
					}
				});
			}
			
			function view(id){
				openPage({
					url : 'announcement/view.do?is_home=true&id=' + id,
					id : 'view_announcement_page',
					title : '查看公告',
					width : '80%',
					height : '60%'
					
				});
			}
			
			return { init: init, view: view };
			
		})();
		
		// 公示栏
		var publicityColumn = (function(){
			var container = $('#publicity_column'),
			ul = $('#publicity_column_ul'),
			tmpl = ['<li>',
						'<a href="javascript:publicityColumn.view(\'{0}\');">{1}',
						'<span>（{2}）</span></a>',
					'</li>'].join('');
			function init(){
				$('.publicity_column_type', container).click(function(){
					var type = $(this).attr('rel');
					get(type);
				});
			}
			
			function get(type){
				util.ajax({
					url: 'publicityColumn/homelist.do',
					type: 'post',
					data: { type: type },
					dataType: 'json',
					success: function(result){
						if(result.flag){
							var builder = new StringBuilder();
							$.each(result.obj, function(index, item){
								builder.appendFormat(tmpl, item.id, item.title, dateUtil.format(new Date(item.create_time), 'yyyy-MM-dd HH:mm'));
							});
							if(builder.getLength() > 0){
								ul.html(builder.toString());
								marquee.init();
							}
							else{
								ul.html('<li>暂无公示栏</li>');
							}
						}
					}
				});
			}
			
			function view(id){
				openPage({
					url : 'publicityColumn/view.do?is_home=true&id=' + id,
					id : 'view_publicity_column_page',
					title : '查看公示栏',
					width : '900px',
					height : '60%'
					
				});
			}
			
			return { init: init, view: view };
			
		})();
		
		// 会议
		var meeting = (function(){
			var container = $('#meeting'),
			ul = $('#meeting_ul'),
			tmpl = ['<li>',
						'<a href="javascript:meeting.view(\'{0}\');">{1}</a>',
                        '<span>（{2} - {3}）</span>',
					'</li>'].join('');
			function init(){
				$('.meeting_type', container).click(function(){
					var type = $(this).attr('rel');
					get(type);
				});
			}
			
			function get(type){
				util.ajax({
					url: 'meeting/homelist.do',
					type: 'post',
					data: { type: type },
					dataType: 'json',
					success: function(result){
						if(result.flag){
							var builder = new StringBuilder();
							$.each(result.obj, function(index, item){
								builder.appendFormat(tmpl, item.id, item.subject, dateUtil.format(new Date(item.begin_time), 'MM-dd HH:mm'), dateUtil.format(new Date(item.end_time), 'MM-dd HH:mm'));
							});
							if(builder.getLength() > 0){
								ul.html(builder.toString());
								marquee.init();
							}
							else{
								ul.html('<li>暂无会议</li>')
							}
						}
					}
				});
			}
			
			function view(id){
				openPage({
					url : 'meeting/view.do?type=0&id=' + id,
					id : 'view_meeting_page',
					title : '查看会议',
					width : '100%',
					height : '95%'
					
				});
			}
			
			return { init: init, view: view };
			
		})();
		
		// 内部邮件
		var email = (function(){
			var container = $('#email'),
			ul = $('#email_ul'),
			tmpl = ['<li>',
						'<a href="javascript:email.view(\'{0}\');">{1}&nbsp;{2}</a>',
					'</li>'].join('');
			function init(){
				$('.email_type', container).click(function(){
					var isRead = $(this).attr('rel');
					get(isRead);
				});
			}
			
			function get(isRead){
				util.ajax({
					url: 'email/homelist.do',
					type: 'post',
					data: { isRead: isRead },
					dataType: 'json',
					success: function(result){
						if(result.flag){
							var builder = new StringBuilder();
							$.each(result.obj, function(index, item){
								builder.appendFormat(tmpl, item.id, item.sender_name, item.subject);
							});
							if(builder.getLength() > 0){
								ul.html(builder.toString());
								marquee.init();
							}
							else{
								ul.html('<li>暂无邮件</li>')
							}
						}
					}
				});
			}
			
			function view(id){
				openPage({
					url : 'email/view.do?id=' + id,
					id : 'view_mail_page',
					title : '查看邮件',
					width : '100%',
					height : '95%'
					
				}); 
			}
			
			return { init: init, view: view };
			
		})();
		
		// 滚动
		var marquee = (function(){
			var t = null;
			function init(){
				$('.list').each(function(index, item){
					var length = $(item).find('li').length;
					if(length > 5){
						start(26, 100, 800, item);
					}
				});
			}
			
			function start(lh, speed, delay, target) {
		        var purse = false;
		        target.innerHTML += target.innerHTML;
		        target.onmouseover = function () { 
		        	purse = true; 
		        	if(t){
		        		clearInterval(t);
		        	}
		        }
		        target.onmouseout = function () { 
		        	purse = false;  
		        	setTimeout(start, delay);
		        }
		        target.scrollTop = 0;
		        
		        function start() {
		        	if(t){
		        		clearInterval(t);
		        	}
		            t = setInterval(scrolling, speed);
		            if (!purse) { 
		            	target.scrollTop += 1; 
		            }
		        }
		        
		        function scrolling() {
		            if (target.scrollTop % lh != 0) {
		                target.scrollTop += 1;
		                if (target.scrollTop >= target.scrollHeight / 2) {
		                	target.scrollTop = 0;
		                }
		            } else {
		                clearInterval(t);
		                setTimeout(start, delay);
		            }
		        }
		        setTimeout(start, delay);
		    }
			return { init: init };
		})();
		
		$(function(){
			announcement.init();
			publicityColumn.init();
			meeting.init();
			email.init();
			linkMore.init();
			marquee.init();
		});
	</script>
</gd:Layout> 