<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:ForumLayout>
	<jsp:attribute name="css">
		<link rel="stylesheet" type="text/css" href="static/js/kindeditor-4.1.4/themes/default/default.css" />
		<style type="text/css">
			.tl th,.tl td{padding:5px 0;border-bottom:1px solid #C2D5E3;}
			.ttp .a a:hover{background-image:none;}
		</style>
	</jsp:attribute>

	<jsp:body>
		<input type="hidden" id="plate_id" name="plate_id" value="${plateId}" />
		<!-- S top -->
		<gd:ForumTop current_type="4" />
		<!-- E top -->
		<!-- S content -->
		<div id="wp" class="wp">
			<!-- S nav -->
			<gd:ForumUserNav />
			<!-- E nav -->
			<!--[diy=diynavtop]--><div id="diynavtop" class="area"></div><!--[/diy]-->
			<div class="wp">
				<!--[diy=diy1]--><div id="diy1" class="area"></div><!--[/diy]-->
			</div>
			<div class="boardnav">
				<div id="ct" class="wp cl">  
					<div class="mn">
						<div class="bm bml pbn">
							<div class="bm_h cl">
								<h1 class="xs2"> ${typeText}</h1>
							</div>
						</div> 
						<div id="pgt" class="bm bw0 pgs cl"> 
							<a href="javascript:void(0);" id="btn_add_thread"><img src="static/images/forum/pn_post.png" alt="发新帖"></a>
						</div>
						<gd:ForumUserTab />
						<div class="tl bm bmw" style="position:relative;">
							<div class="bm_c"> 
								<div class="hd"><h2>头像设置</h2></div>
								<div class="bd" >
									<div id="flash_content"></div>
								</div> 
							</div>
						</div> 
					</div>
				</div>
			</div>
			<div class="wp mtn">
				<!--[diy=diy3]--><div id="diy3" class="area"></div><!--[/diy]-->
			</div>
		</div>
		<!-- E content -->
		<script type="text/javascript" src="static/js/swfobject/swfobject.js"></script>
		<script type="text/javascript">
			var flashvars = {
				  "pSize": "200|200|200|200|120|120|48|48",
				  "jsfunc": "uploadEvent",
				  "pid": "75642723",
				  "imgUrl": "${img_url}",
				  "uploadSrc": true,
				  "showBrow": true,
				  "showCame": true,
				  "uploadUrl": "forum/user/upload.do"
				};

			var params = {
				menu: "false",
				scale: "noScale",
				allowFullscreen: "true",
				allowScriptAccess: "always",
				wmode: "transparent",
				bgcolor: "#FFFFFF"
			};

			var attributes = {
				id: "FaustCplus"
			};
			
			function uploadEvent(status){ 
				debugger;
				 status = String(status);
				 switch(status){ 
					case '1':
						successMsg('保存成功！');
						break; 
					case '2':
						if(confirm('js call upload')){
							return 1;
						}else{
							return 0;
						}
						break; 
					case '-1':
						informationMsg('取消上传！');
						break;
					case '-2':
						errorMsg('图片上传失败！'); 
						break;
					default:
						if(window.console){
							console.log(typeof(status) + ' ' + status);
						}
				} 
			}

			swfobject.embedSWF("static/js/flash/FaustCplus.swf", "flash_content", "650", "500", "9.0.0", "static/js/swfobject/expressInstall.swf", flashvars, params, attributes);
		</script> 
	</jsp:body>
</gd:ForumLayout> 
 