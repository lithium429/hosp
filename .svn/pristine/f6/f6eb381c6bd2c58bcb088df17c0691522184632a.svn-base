<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
<gd:HomeLayout> 
	<jsp:body> 
		<!-- S header -->
		<div id="header">
			<div class="wrap head">
				<a href="javascript:void(0);" class="logo"><img src="static/images/logo_${systemCode}.png" alt="logo" class="png" title="${systemName}" /></a>
				<div class="top_fun">
					<c:if test="${moduleList != null && !empty moduleList}">
						<div class="mr10 other_os">
							<select id="user_module">
								<c:forEach items="${moduleList}" var="item" varStatus="vs">
									<option value="${item}">${item}</option>
								</c:forEach>
							</select>
							<a href="javascript:void(0);" id="btn_enter">启动系统</a>
						</div>
					</c:if>
					<!-- <span class="weather"><img src="static/images/w1.png" width="37" height="37" class="png" alt="多云" title="多云" /></span> -->
					<span class="address">上海</span>
					<span class="ml10 time" id="current_time"></span>
					<span class="date">星期${weekday} ${month}月${day}日</span>
					<span class="date">欢迎您，${real_name}！</span>
				</div>				
			</div>
		</div><!-- E header -->
		<!-- S tabs -->
		<div id="main_nav" class="clearfix nav">
			<div class="wrap nav_wrap">
				<a href="javascript:void(0);" id="start_menu" class="start" hidefocus="hidefocus">
					菜单
				</a>
				<span id="nav_left_arrow" class="nav_arrow">&lt;&lt;</span>
				<ul id="menu_nav" class="menu">
					<li class="menu_nav first cur" id="menu_nav_0"><a href="javascript:void(0);" hidefocus="hidefocus">首页</a><em class="nav_rbg"></em></li>
				</ul>
				<span id="nav_right_arrow" class="nav_arrow">&gt;&gt;</span>
			</div>
		</div><!-- E tabs -->
		<!-- S subfun -->
		<div id="subfun">
			 <a href="javascript:void(0);" title="OA首页" class="icon icon_home" id="btn_home">OA首页</a> 
			 <a href="care/home/index.shtml" title="护理天地" class="icon icon_nurse" target="_blank">护理天地</a>
			 <a href="forum/index.shtml" title="论坛" class="icon icon_forum" target="_blank">论坛</a>
			 <a href="advice/home/instruction.shtml" title="书记院长信箱" class="icon icon_mail" target="_blank">书记院长信箱</a>
			 <a href="javascript:void(0);" title="修改密码" id="edit_psw" class="icon icon_paw">修改密码</a>
			 <a href="javascript:void(0);" title="修改个人信息" id="edit_user" class="icon icon_info">修改个人信息</a>
			 <a href="javascript:void(0);" title="注销登录" id="btn_login_out_top" class="icon icon_logout">注销登录</a>
			 <a href="javascript:void(0);" title="隐藏/显示顶部" id="hide_topbar" class="icon icon_toggle">隐藏/显示顶部</a>
			 <!-- S 终极tabs -->
			 <div id="funbar_left">
				<div id="funbar" class="subtabs">
					
				</div>
			</div><!-- E 终极tabs -->
		</div><!-- E subfun -->
		<!-- S container -->
		<div id="container" class="main_cont">
			<div class="tabs_panel" id="tabs_panel_0">  
				<iframe src="home/info.do" frameborder="0" scrolling="auto" name="tab_iframe" allowtransparency="true" style="width:100%;"></iframe>
			</div>
		</div>
		<!-- E container -->
		<div id="overlay_start_menu"></div>
		<!-- S footer -->
		<div id="footer" class="foot">
			<span class="rbox">
				<a href="javascript:void(0);" id="btn_online_user" class="mr10" hidefocus="hidefocus" title="${onlineUserCount}人在线">在线<span id="user_count">${onlineUserCount}</span>人</a>
				<a href="javascript:void(0);" id="btn_notify" class="icon notice" hidefocus="hidefocus" title="事务提醒">事务提醒</a>
			</span>
		</div><!-- E footer -->
		<div class="online_user" id="online_user">
			<h2>当前在线</h2>
			<ul id="ztree_list" class="ztree transcipt_tree"></ul>
		</div>
		<!-- S osnav -->
			<div id="menu_panel">
				<div class="panel_head"></div>
				<!-- S 用户信息 -->
				<div class="panel_user clearfix">
					<div class="avatar">
						<img src="static/images/avatar/0.gif" alt="头像" />
						<em class="status_icon status_icon_1"></em>
						<div id="status">
							<a href="javascript:void(0);" class="status1"><em class="s_icon status_1"></em>在线</a>
							<a href="javascript:void(0);" class="status2"><em class="s_icon status_2"></em>忙碌</a>
							<a href="javascript:void(0);" class="status3"><em class="s_icon status_4"></em>离开</a>
						</div>
					</div>
					<div class="name">
						${real_name}
					</div>
					<div class="tools">
						<a href="javascript:void(0);" id="btn_login_out" title="退出"><i class="mr5 icon exit"></i>退出</a>
					</div>
				</div>
				<em class="pannel_split"></em>
				<div class="panel_menu">
					<!-- S 一级菜单 -->
					<div id="first_panel">
						<div class="scroll_up"></div>
						<ul id="first_menu">
							<c:if test="${menuListOne != null}">
								<c:forEach var="item" items="${menuListOne}" varStatus="vs">
									<c:set var="fcur" value="" />
									<c:if test="${vs.index == 0}">
										<c:set var="fcur" value=" cur" />
										<c:set var="firstId" value="${item.id}" />
									</c:if>
									<li class="fitem_li"><a id="${item.id}" class="menu_fitem${fcur}" href="${item.url}" rel="${item.id}" hidefocus="hidefocus"><i class="${item.icon_class}"></i>${item.name}</a></li>
								</c:forEach>
							</c:if>
						</ul>
						<div class="scroll_down"></div>
					</div><!-- E 一级菜单 -->
					<!-- S 二级级菜单 -->
					<div id="second_panel">
						<div class="second_panel_head"></div>
						<div class="second_panel_menu">
							<ul id="second_menu"> 
								<c:if test="${menuListTwo != null}">
									<c:forEach var="item" items="${menuListTwo}">
										<li rel="${item.parent_id}" class="sitem_li" <c:if test="${item.parent_id != firstId}">style="display:none;"</c:if>>
											<c:choose>
												<c:when test="${item.is_leaf}">
													<c:set var="sexpand" value=" leaf_item" />
												</c:when>
												<c:otherwise>
													<c:set var="sexpand" value=" expand" />
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${!item.is_open_new}">
													<a id="${item.id}" href="javascript:void(0);" url="${item.url}" class="menu_sitem${sexpand}" hidefocus="hidefocus"><span>${item.name}</span></a>
												</c:when>
												<c:otherwise>
													<a id="${item.id}" href="${item.url}" target="_blank" class="menu_sitem${sexpand}" hidefocus="hidefocus"><span>${item.name}</span></a>
												</c:otherwise>
											</c:choose>
											<c:if test="${menuListThree != null && menuListThree.size() > 0}">
												<ul>
													<c:forEach var="subItem" items="${menuListThree}">
														<c:if test="${subItem.parent_id == item.id}">
															<li class="titem_li">
																<c:choose>
																	<c:when test="${!subItem.is_open_new}">
																		<a id="${subItem.id}" href="javascript:void(0);" url="${subItem.url}" class="menu_titem leaf_item" hidefocus="hidefocus"><span>${subItem.name}</span></a>
																	</c:when>
																	<c:otherwise>
																		<a id="${subItem.id}" href="${subItem.url}" target="_blank" class="menu_titem leaf_item" hidefocus="hidefocus"><span>${subItem.name}</span></a>																		
																	</c:otherwise>
																</c:choose>
															</li>
														</c:if>
													</c:forEach>
												</ul>
											</c:if>
										</li>
									</c:forEach> 
								</c:if>
							</ul>
						</div>
						<div class="second_panel_foot"></div>
					</div><!-- E 二级级菜单 -->
				</div>
				<div class="panel_foot"></div>
			</div><!-- E osnav --> 
		<OBJECT classid="clsid:A3E8EEE9-E85E-472A-AEB3-EB182A605C62"  
         	codebase="/${res}/ocx/AppCallerXControl.ocx#version=1,0,0,0" width="0"  height="0" visible="0" id="AppCaller">  
        </OBJECT>  
        <script type="text/javascript">
            function clientInvoke(name, code) {
                AppCaller.callApp(name, code);
            }
            
		</script> 
		<iframe id="notify_iframe" src="views/core/home/notify.jsp" style="display:none;"></iframe>
		<input type="hidden" id="user_id" name="user_id" value="${userId}" /> 
		<input type="hidden" id="login_type" name="login_type" value="${login_type }" /> 
		<script type="text/javascript">
			// 调整iframe窗体高度
			function resizeLayout() {
			    try {
			        // 主操作区域高度
			        var windowWidth = (window.document.documentElement.clientWidth || window.document.body.clientWidth || window.innerHeight),
					windowHeight = (window.document.documentElement.clientHeight || window.document.body.clientHeight || window.innerHeight),
					headHeight = $('#header').is(':visible') ? $('#header').outerHeight() : 0,
					navHeight = $('#main_nav').outerHeight(),
					subfunHeight = $('#subfun').outerHeight(),
					footerHeight = $('#footer').outerHeight(),
					height = windowHeight - headHeight - navHeight - subfunHeight - footerHeight; 
			        $('#container').height(height);
			        $('#container iframe').css({ height: height });
	  
			    } catch (ex) {
			    }
			}  
			
			// 缩放窗口
			$(window).resize(function(){
				resizeLayout();
				tab.controllNavArrow();
			});

			$(function() {
				resizeLayout(); 
 				menu.init();
 				tab.init();
 				notify.init();
 				util.initTime('#current_time');
 				onlineUser.init();
 				
 				//单点登录用户启动系统
 				$('#btn_enter').click(function(){
 					var name = $('#user_module').val();
 					try{
 						clientInvoke(name, '${com_psw}');
 					}
 					catch(e){ }
 				});
				
 				//判断是否第一次登陆或者重置密码
 				if($("#login_type").val() != 0 ){
 					var login_type = $("#login_type").val();
 					var msg ='这是您第一次登录';
 					if(login_type == 2 ){
 						msg = '您的密码已被重置';
 					}
 					art.dialog.confirm( msg + '，请修改下默认密码哦！', function () {
 						openPage({
							url: 'user/reset_psw.do',
							id: 'reset_psw_page',
							title: '重置密码',
							width: '500px',
							height: '200px'
						});
 			        });
 				}
 				
 				//修改密码
 				$("#edit_psw").click(function(){
 					
 					openPage({
						url: 'user/update_psw.do',
						id: 'reset_psw_page',
						title: '修改密码',
						width: '560px',
						height: '200px'
					});
 					return false;
 				});
 				
 				//修改个人资料
 				$("#edit_user").click(function(){
 					
 					openPage({
						url: 'user/update_user.do',
						id: 'reset_psw_page',
						title: '修改个人资料',
						width: '800px',
						height: '400px'
					});
 					return false;
 				});
 				
				// 顶部折叠
				$("#hide_topbar").toggle(function(){
					$("#header").hide();
					$(this).addClass("icon_toggleup");
					$("#container").css('top', '67px');
					resizeLayout(); 
				}, function(){
					$("#header").show();
					$(this).removeClass("icon_toggleup");
					$("#container").css('top', '125px');
					resizeLayout();
				});
				
				// 用户状态
				$(".avatar").click(function(){
					//$("#status").toggle();
				}); 
				
				$('#btn_home').click(function(){
					$('#menu_nav_0').click();
				});
				
				$("#btn_login_out,#btn_login_out_top").click(function() {
					$('#overlay_start_menu').hide();
					art.dialog.confirm("您确定要注销吗？", function() {
						location.href = "${baseUrl}logout.do";
					}, function(){
						$('#overlay_start_menu').show();	
					});
				});
			});
			
			// 菜单控制
			var menu = (function(){
				function init(){
					// 主菜单折叠
					$('#start_menu').click(function(){
						var menuPanel = $('#menu_panel');  
						if(menuPanel.css('display') === 'block'){
							$('#overlay_start_menu').hide();
							menuPanel.slideUp(300);
						}
						
						$('#overlay_start_menu').show();
						menuPanel.slideDown('fast');
					});
					 
					$('#overlay_start_menu').click(function(){ 
						$('#overlay_start_menu').hide();
						$('#menu_panel').slideUp(300); 
					});
					
					// 一级菜单
					$('.menu_fitem', $('#first_menu')).click(function(){
						$('.menu_fitem').removeClass('cur');
						$(this).addClass('cur');
						 
						// 控制当前一级菜单下的二级菜单是否显示
						var id = $(this).attr('rel');
						$('#second_menu').find('.sitem_li').each(function(index, item){
							var parentId = $(item).attr('rel');
							if(id == parentId){
								$(item).show();
							}
							else{
								$(item).hide();
							}
						});
					});
					
					// 二级菜单控制三级菜单显示
					$("#second_menu li a.expand").toggle(function(){
						$(this).addClass("cur").next("ul").show();
					},function(){
						$(this).removeClass("cur").next("ul").hide();
					});
					
					// 点击叶子菜单隐藏主菜单
					$('.leaf_item').click(function(){
						$("#menu_panel").hide();
						$('#overlay_start_menu').hide();
					}); 
				} 
				
				return { init: init };
			})();
			
			// tab导航控制
			var tab = (function(){
				var navContainer = $('#menu_nav'), 
				panelContainer = $('#container'),
				funBar = $('#funbar'),
				menuNav = $('#menu_nav'),
				selectedFun = {},
				openedTabPanel = {};
				
				function init(){
					var navTmpl = '<li class="menu_nav" id="menu_nav_{0}" url="{1}"><a href="javascript:void(0);" hidefocus="hidefocus">{2}</a><em class="nav_rbg"></em><a href="javascript:void(0);" class="close" rel="{3}" hidefocus="hidefocus">&times;</a></li>',
					panelTmpl = ['<div class="tabs_panel" id="tabs_panel_{0}">',  
									'<iframe src="{1}" frameborder="0" scrolling="auto" name="tab_iframe" style="width:100%;" allowtransparency="true"></iframe>',
								'</div>'].join('');
					// 叶节点事件处理，创建\显示tab和panel
					$('.leaf_item').click(function(){ 
						var id = $(this).attr('id'), 
						name = $(this).text(), 
						url = $(this).attr('url'),  
						nav = $('#menu_nav_' + id), 
						panel = $('#tabs_panel_' + id) ;
						if(util.isNull(url) || util.isEmpty(url)){
							return;
						}
						
						if(nav.length === 0){
							navContainer.append(util.formatString(navTmpl, id, url , name, id)); 
						}
						nav.addClass('cur').siblings('li').removeClass('cur');
						
						if(panel.length === 0){
							panelContainer.append(util.formatString(panelTmpl, id, util.appendUrlParam(url, 'menu_id=' + id)));
						}
						panel.show().siblings('div').hide();
						
						controllNavArrow();
						setFunbar(url, '#tabs_panel_' + id);
						resizeLayout();
						
						return false;
					});
					
					// 导航关闭事件
					$('.close').live('click', function(){
						var id = $(this).attr('rel'),
						navObj = $('#menu_nav_' + id),
						panelObj = $('#tabs_panel_' + id);
						navObj.prev().click();
						navObj.remove(); 
						panelObj.remove(); 
						
						controllNavArrow();
						
						return false;
					});
					
					// 导航点击事件处理
					$('.menu_nav').live('click', function(){
						var navId = $(this).attr('id'),  
						id = navId.replace('menu_nav_', '#tabs_panel_'),
						url = $(this).attr('url');
						$(this).addClass('cur').siblings('li').removeClass('cur');
						$(id).show().siblings('div').hide();
						
						adjustNav(navId);
						setFunbar(url, id);
						
						return false;
					});
					
					$('#nav_left_arrow').bind('click', function(){
						moveNav('left');
					});
					
					$('#nav_right_arrow').bind('click', function(){
						moveNav('right');
					});
				}
				
				// 打开Panel
				function openPanel(url){
					$('.leaf_item').each(function(index, item){
						var turl = $(item).attr('url');
						if(url === turl){
							$(item).click();
						}
					});
				}
				
				// 控制导航向左向右箭头是否显示
				function controllNavArrow(){
					var mainWidth = $(document).outerWidth() - 400,
					ulWidth = 0, itemWidth = 0;
					$('.menu_nav', menuNav).each(function(index, item){
						itemWidth = Number($(item).outerWidth()) + 10;
						ulWidth += itemWidth;
					}); 
					
					if(ulWidth > mainWidth){
						$('#nav_left_arrow,#nav_right_arrow').show();
						menuNav.animate({ scrollLeft: 9999 }, 'normal');
					}
					else{
						$('#nav_left_arrow,#nav_right_arrow').hide();
					}
				}
				
				// 调整当前位置
				function adjustNav(navId){ 
					var tabsOffsetLeft = $('#' + navId, menuNav).offset().left,
				    tabsWidth = $('#' +navId, menuNav).outerWidth(),
				    containerOffsetLeft = menuNav.offset().left,
				    containerWidth = menuNav.outerWidth(),
				    containerScrollLeft  = menuNav.scrollLeft();
					//要选中的标签的左侧可见，右侧不可见
			        if(tabsOffsetLeft > containerOffsetLeft && tabsOffsetLeft + tabsWidth > containerOffsetLeft + containerWidth){
			        	var scrollTo = (tabsOffsetLeft + tabsWidth) - (containerOffsetLeft + containerWidth) + containerScrollLeft + 6;
			        	menuNav.animate({ scrollLeft: scrollTo }, 400);
			        }
			        //要选中的标签的右侧可见，左侧不可见
			        else if(tabsOffsetLeft < containerOffsetLeft){
			          	var scrollTo = containerScrollLeft - (containerOffsetLeft - tabsOffsetLeft) - 6;
			          	menuNav.animate({ scrollLeft: scrollTo }, 400);
					}
				}
				
				// 移动导航
				function moveNav(type){
					var ulWidth = 0, itemWidth = 0, count = 0, 
					scrollLeft = menuNav.scrollLeft(), step = 40;
					$('.menu_nav', menuNav).each(function(index, item){
						itemWidth = Number($(item).outerWidth());
						ulWidth += itemWidth;
						count++;
					});
					
					step = ulWidth / count;
					
					if(type === 'left'){
						menuNav.animate({ scrollLeft: scrollLeft - step }, 'normal');
					}
					else if(type === 'right'){
						menuNav.animate({ scrollLeft: scrollLeft + step }, 'normal');
					}
				}
				
				// 设置标签
				function setFunbar(url, panelId){
					var funObj = { 	'directory/list.do' : [{name: '我的文档', url: 'directory/list.do'}, {name: '共享文档', url: 'directory/sharelist.do'}],
									'directory/list.do?from_type=personal' : [{name: '我的文档', url: 'directory/list.do'}, {name: '共享文档', url: 'directory/sharelist.do'}],
							       	'handlingProcess/list.do?type=0' : [{name: '待我处理的督办流程', url: 'handlingProcess/list.do?type=0'}, {name: '我创建的督办流程', url: 'handlingProcess/list.do?type=1'}, {name: '我处理过的督办流程', url: 'handlingProcess/list.do?type=2'}],
							       	'handlingProcess/list.do?type=0&from_type=personal' : [{name: '待我处理的督办流程', url: 'handlingProcess/list.do?type=0'}, {name: '我创建的督办流程', url: 'handlingProcess/list.do?type=1'}, {name: '我处理过的督办流程', url: 'handlingProcess/list.do?type=2'}]	   
							     }; 
					var funArray = funObj[url];
					if(!util.isNull(funArray) && funArray.length > 0){
						var funTmpl = '<a href="javascript:void(0);"{0} onclick="tab.reloadIframe(this, \'{1}\', \'{2}\')" hidefocus="hidefocus"><em class="inner">{3}</em></a>',
						builder = new StringBuilder(), cur = '';
						for(var i = 0; i < funArray.length; i++ ){
							if( selectedFun[panelId] == funArray[i].url){
								cur = ' class="cur"';
							}
							else{
								cur = '';
							}
							builder.appendFormat(funTmpl, cur, panelId, funArray[i].url, funArray[i].name);
						}
						funBar.html(builder.toString());
						
						// 判断标签是否都未选中，如果都未选中，将会默认选中第一个
						var flag = false;
						funBar.find('a').each(function(index, item){
							if($(item).hasClass('cur')){
								flag = true;
							}
						}); 
						if(!flag){
							funBar.find('a:first').addClass('cur');
						}
					}
					else {
						funBar.html('');
					}
				}
				
				// 重新加载iframe
				function reloadIframe(self, panelId, url){
					var tempArray = panelId.split('tabs_panel_');
					$(panelId).find('iframe').attr('src', util.appendUrlParam(url, 'menu_id=' + tempArray[1]));
					$(self).addClass('cur').siblings().removeClass('cur');
					// 把选中的页签url保存起来
					selectedFun[panelId] = url;
					
					resizeLayout();
				} 	 
				
				return { init: init, reloadIframe: reloadIframe, openPanel: openPanel, controllNavArrow: controllNavArrow };
			})();
			
			// 标题闪烁
			var flashTitle = (function(){
				function init(){
					setTimeout(function(){ flash_title.flash('有新的事务提醒'); }, 150);
				}
				
				function clear(){
					setTimeout(function(){  flash_title.clear(); }, 100);
				}
				
				return {
					init: init,
					clear: clear
				};
			})(); 
			
			// 事务提醒
			var notify = (function(){
				var typeObj = { 
						1: '<i class="icon meeting"></i>', 
						2: '<i class="icon mail"></i>', 
						3: '<i class="icon date"></i>', 
						4: '<i class="icon workflow"></i>',
						5: '<i class="icon hr"></i>' 
					};
				
				function init(){
					getData(true);
					$('#btn_notify').click(function(){
						getData(false);
					});
				}
				
				// 获取事务提醒数据
				function getData(isInit){
					util.ajax({
						url: 'notifyMessage/homelist.do?is_init=' + isInit,
						type: 'get',
						dataType: 'json',
						data: { Time: util.now() },
						success: function(result){  
							if(!util.isNull(result)){
								process(result);
							}
							else if(!isInit){ 
								artDialog.through({
									id: 'notify',
									title: '事务提醒',
									width: '260px',
									height: '100px',
									time: 3, 
									content: '<h2>暂无新提醒，<span id="back_time">3</span>秒后自动关闭！</h2>', 
									button: [{
							            name: '关闭',
							            focus: true
							        }],
							        init: function(){
							        	// 倒数3秒
							        	var backTime = $('#back_time', this.content());
							        	setInterval(function(){
							        		backTime.text(Number(backTime.text()) - 1);
							        	}, 1000);
							        }
								});
							}
						}
					});
				}
				
				function process(result){					
					var tmpl = ['<div class="notify_type">',
								'<div class="notify_type_title">',
									'<span class="item_read" type="{0}" title="分类提醒全部已读"></span>',
									'<span class="item_type_name">{1}</span>',
								'</div>',
								'<ul class="notify_data"{2}>{3}</ul>',
							'</div>'].join(''),
					itemTmpl = '<li class="hand notify_data_li" url="{0}" id="{1}" type="{2}"><p class="notify_data_info"><span class="notify_item_time">{3}</span>{4}</p><p class="notify_item_content">{5}</p></li>',
					builder = new StringBuilder(),
					itemBuilder = null,
					senderName = null,
					style = null,
					count = 0;
					for(var type in result){
						itemBuilder = new StringBuilder();
						$.each(result[type], function(index, item){
							senderName = util.isNull(item.sender_real_name) ? '系统' : item.sender_real_name;
							itemBuilder.appendFormat(itemTmpl, item.url, item.id, type, util.getTimeTip(new Date(item.create_time)), senderName, item.content);
							if(index > 1){
								style = ' style="overflow-y:scroll;"';
							}
							else {
								style = '';
							}
							count++;
						});
						builder.appendFormat(tmpl, type, typeObj[type], style, itemBuilder.toString());
					} 
					
					artDialog.through({
						id: 'notify',
						title: '事务提醒<span class="ml5">[共<span id="notify_count">' + count + '</span>条提醒]</span>',
						width: '500px', 
						content: builder.toString(),
						button: [{
				            name: '全部标记已读',
				            focus: true,
				            callback: function () {
				            	// 停止标题闪烁
								flashTitle.clear();
				            	
				                util.ajax({
				                	url: 'notifyMessage/readall.do',
				                	type: 'get'
				                });
				            }
				        },
				        {
				            name: '关闭',
				            focus: true,
				            callback: function(){
				            	flashTitle.clear();
				            }
				        }]
					});
					
					$('.notify_data_li').click(function(){ 
						// 停止标题闪烁
						flashTitle.clear();
						
						var url = $(this).attr('url'),
						id = $(this).attr('id'),
						type = $(this).attr('type'),
						width = '100%',
						height = '95%';
						
						if(util.isEmpty(url)){
							return false;
						}
						
						// 会议
						if(type === '1'){
							url = url + '&type=1';
						}
						// 值班
						else if(type === '3'){
							width = '600px';
							height = '220px';
						}
						// 请假审批
						else if(type === '5'){
							width = '700px';
							height = '400px';
						}
						
						// 标记已读
						if(!util.isEmpty(id)){
							$.ajax({
								url: 'notifyMessage/read.do',
			                	type: 'get',
			                	data: { id: id },
			                	async: false
							});
						}
						
						if(!util.isEmpty(url)){
							openPage({
								url : url,
								id : 'view_page',
								title : '查看详细 ',
								width : width,
								height : height,
								init: function(){ 
								}
							});
						} 
						
						// 移除已读提醒 [.notify_type -> .notify_data -> .notify_data_li]
						var ul = $(this).parent(),
						liCount = ul.find('.notify_data_li').length;
						
						// 分类提醒小于等于3，则不显示滚动条
						if(liCount === 3){
							ul.removeAttr('style');
						}
						// 如果该分类下提醒已经全部已读，则把该分类全部移除
						if(liCount === 1){
							ul.parent().remove();
						}
						else{
							$(this).remove();
						}
						
						var alength = $('.notify_data_li').length; 
						if(alength === 0){
							closeDialogById('notify');
						}
						
						//重置提醒个数
						var nowCount = $('#notify_count').text();
						$('#notify_count').text(Number(nowCount) - 1);
					});
				}
				
				return { init: init, getData: getData, process: process };
			})(); 
			
			// 在线用户
			var onlineUser = (function(){
				var div = $('#online_user'),
				setting = {   
					view: {
			            dblClickExpand: false,
			            expandSpeed: ($.browser.msie && parseInt($.browser.version) <= 6) ? "" : "fast"
			        },
			        data: {
			            simpleData: {
			            	enable: true,
		                    idKey: "id",
		                    pIdKey: "pid",
		                    rootPId: null
			            }
			        },
			        callback: {
			    		onClick: function(event, treeId, treeNode){
			    			if(!treeNode['isParent']){
			    				openPage({
			    					url: 'user/view.do?id=' + treeNode['id'],
			    					id: 'view_page',
			    					title: '查看用户',
			    					width: '600px',
			    					height: '350px'
			    				});
			    				return false;
			    			}
			    		}
			    	}
			    };  
				
				function init(){				
					$('#btn_online_user').click(function(){ 
						if(isShow()){
							div.hide();
							return false;
						}
						getData();
						 
						return false;
					});
				}
				
				// 是否已经显示
				function isShow(){
					return div.css('display') === 'block';
				}
				
				// 获取数据
				function getData(){
					$.ajax({
						url: 'department/onlineuser.do',
						type: 'post',
						dataType: 'json',
						success: function(result){
							if(result.flag){
								$.fn.zTree.init($("#ztree_list"), setting, result.obj);
								div.fadeIn();
							}
						}
					});
				}
				
				return { init: init, getData: getData, isShow: isShow };
			})();
		</script>
	</jsp:body>
</gd:HomeLayout>