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
			<div class="con_left">
				<ul class="ul">
					<li class="list_title">常用操作</li>
					<li onclick="closePage();">关闭文件</li>  
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
		</div>
		  
		<!-- E 添加信息 --> 
		<script type="text/javascript" src="static/js/ntko/control.js"></script>
		<script type="text/javascript" for="TANGER_OCX" event="OnDocumentClosed()">
			ntkoOcx.setFileState(false);
		</script> 
		<script type="text/javascript" for="TANGER_OCX" event="OnDocumentOpened(TANGER_OCX_str,TANGER_OCX_obj)"> 
			ntkoOcx.setFileState(true);
			ntkoOcx.setReadOnly(true);
		</script> 
		<script type="text/javascript"> 
			$(function(){ 
				try{
					ntkoOcx.read('${model.url}');
				}
				catch(e){ }
			});     
			
			// 关闭当前弹出层
			function closePage(){ 
				try{
					ntkoOcx.obj.close();
				}
				catch(e){ }
				closeDialog();
			} 
		</script>
	</jsp:body>
</gd:NTKOLayout>
