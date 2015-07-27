<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:NTKOLayout>
	<jsp:attribute name="css">
		<style type="text/css" > 
			div.con_left{width:120px;float:left;}
			div.con_right{float:left;}
			ul li{height:22px;line-height:1.5;cursor:pointer;padding:2px 0 0 6px;}
			li.list_title{font-weight:bold;color:#00f;padding-left:4px;}
		</style>
	</jsp:attribute>
	<jsp:body>
		<!-- S 添加信息 -->
		<div class="data_model data_cont_wrap pop_wrap">
			<form id="form0" action="${baseUrl}/file/upload.do" enctype="multipart/form-data"> 
				<input type="hidden" id="file_id" name="file_id" value="${model.id}" />
				<input type="hidden" id="module_type" name="module_type" value="${model.module_type}" />
				<input type="hidden" id="directory_id" name="directory_id" value="${directory_id}" />
				<div class="con_left">
					<ul class="ul">
						<li class="list_title">常用操作</li>
						<li onclick="ntkoOcx.save();">保存文件</li>
						<li onclick="ntkoOcx.ensureSave();">关闭文件</li>  
					</ul> 
					<ul class="ul">
						<li class="list_title">界面设置</li>
						<li onclick="ntkoOcx.setMenubar();">菜单栏栏切换</li>
						<li onclick="ntkoOcx.setToolBar();">工具栏栏切换</li> 
					</ul> 
					<ul class="ul">
						<li class="list_title">打印控制</li>
						<li onclick="ntkoOcx.showPrintSet();">页面设置</li>
						<li onclick="ntkoOcx.printPreview();">打印预览</li>
					</ul> 
					<!-- <ul class="ul">
						<li class="list_title">痕迹保留功能</li>
						<li onclick="ntkoOcx.setReviewMode(true);">保留痕迹</li>
						<li onclick="ntkoOcx.setReviewMode(false);">取消留痕</li>
						<li onclick="ntkoOcx.setShowRevisions(true);">显示痕迹</li>
						<li onclick="ntkoOcx.setShowRevisions(false);">隐藏痕迹</li>
						<li onclick="ntkoOcx.acceptAllRevisions();">接受修订</li>
					</ul> -->
		          	</div>
		          
		        <div class="con_right">
		        	<div id="status_bar" class="dn" style="height:20px;width:100%;font-size:12px;color:red;font-weight:bold;"></div>
		        	<div>
		        		<script type="text/javascript" src="static/js/ntko/init.js"></script>
		        	</div>
		        </div>  
			</form> 
		</div>
		  
		<!-- E 添加信息 --> 
		<script type="text/javascript" src="static/js/ntko/control.js"></script>
		<script type="text/javascript" for="TANGER_OCX" event="OnDocumentClosed()">
			ntkoOcx.setFileState(false);
		</script> 
		<script type="text/javascript" for="TANGER_OCX" event="OnDocumentOpened(TANGER_OCX_str,TANGER_OCX_obj)">
			//saved属性用来判断文档是否被修改过,文档打开的时候设置成ture,当文档被修改,自动被设置为false,该属性由office提供.
			ntkoOcx.obj.activeDocument.saved = true;
			//获取文档控件中打开的文档的文档类型
			switch (ntkoOcx.obj.doctype){
				case 1:
					ntkoOcx.setFileType("Word.Document", "word");
					break;
				case 2:
					ntkoOcx.setFileType("Excel.Sheet", "excel"); 
					break;
				case 3:
					ntkoOcx.setFileType("PowerPoint.Show", "ppt"); 
					break; 
				case 6:
					ntkoOcx.setFileType("WPS Doc", "wps"); 
					break;
				case 7:
					ntkoOcx.setFileType("Kingsoft Sheet", "et"); 
					break;
				default :
					ntkoOcx.setFileType("unkownfiletype", "unkownfiletype"); 
					break;
			}
			ntkoOcx.setFileState(true);
		</script> 
		<script type="text/javascript">
			var opener = art.dialog.open.origin;
			$(function(){ 
				try{
					ntkoOcx.open('${model.url}');
				}
				catch(e){ }
			});    
			
			// 调用父页面刷新列表
			function refreshParent(){
				opener.$('#spec_form').submit();
			}
			
			// 关闭当前弹出层和父弹出层
			function closePage(){ 
				closeDialog();
			} 
		</script>
	</jsp:body>
</gd:NTKOLayout>
