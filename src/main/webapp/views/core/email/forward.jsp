<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout>
	<!-- S 添加信息 -->
<div class="data_model data_cont_wrap sms_info">
	<div class="rightbox" style=" width:230px;overflow:hidden;">
		<h2>选择收信人</h2>
		<div class="pd10 bd">
			<form id="spec_form" action="email/selUser.do"
					data-ajax="true" data-ajax-begin="loadBegin"
					data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
					data-ajax-loading="#loading_img" data-ajax-method="POST"
					data-ajax-mode="replace" data-ajax-update="#userDiv"
					novalidate="novalidate">
					<input type="text" class="inp_t" name="name" id="" />
			</form>
			<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
			<div id="userDiv" class="pt10" style="overflow:auto;">
				<%@ include file="selUser.jsp"%>
			</div>
		</div>
	</div>
	<form id="data_form" method="post" action="email/forward.do" data-ajax="true" data-ajax-begin="showTip" data-ajax-complete="hideTip" data-ajax-success="backToList" data-ajax-error="showError">	
	<input type="hidden" name="is_send" id="is_send" value="1" />
	<input type="hidden" name="is_forward" id="is_forward" value="1" />
	<input type="hidden" name="innerUserIds" id="innerUserIds" value="" />
	<input type="hidden" name="innerUser_csIds" id="innerUser_csIds" value="" />
	<input type="hidden" name="innerUser_msIds" id="innerUser_msIds" value="" />
	<input type="hidden" name="type" id="type" value="${type }" />
	<input type="hidden" name="is_view" id="is_view" value="${is_view }" />
		
		<table class="view w70per left_box">
			<tbody>
				<tr>
					<th class="w15per vtop">收信人：</th>
					<td>
						<div id="innerUser" class="dib inp_t user_dib mail_input">
							
						</div>		
					</td>
				</tr>
				<tr>
					<th class="vtop">抄送：</th>
					<td>
						<div id="innerUser_cs" class="dib inp_t mail_input">
							
						</div>	
					</td>
				</tr>
				<tr>
					<th class="vtop">密送：</th>
					<td>
						<div id="innerUser_ms" class="dib inp_t mail_input">
							
						</div>	
					</td>
				</tr>
				<tr>
					<th class="">主题：</th>
					<td>
						<input type="text" class="inp_t mail_input" name="subject" id="subject" value="转发：${model.subject }"/>	
					</td>
				</tr>
				<tr>
					<th class="">附件：</th>
					<td>
						<span class="btn btn_pub"><a href="file/add.do" id="btn_create">新建</a></span>
						<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_upload">上传</a></span>
						<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_batch_upload">批量上传</a></span>
						<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_select">从文件夹选择</a></span>
						
						<div>
							<div id="file_container" class="dib inp_t mail_input">
								 <c:if test="${model.files != null && !model.files.isEmpty() && !empty model.files}">
								 	<c:forEach items="${model.files}" var="item" varStatus="vs">
										<span id="file_item_${vs.index}" class="user_child file_item" onclick="file.remove('file_item_${vs.index}');">
											${item.name}<em title="删除" class="del_user">×</em>
				            				<input type="hidden" name="files[${vs.index}].type" value="${item.type}" />
							            	<input type="hidden" name="files[${vs.index}].url" value="${item.url}" />
							            	<input type="hidden" name="files[${vs.index}].name" value="${item.name}" />
							            	<input type="hidden" name="files[${vs.index}].file_id" value="${item.file_id}" />
							            	<input type="hidden" name="files[${vs.index}].sort" value="${item.sort}" />
							            </span>
									</c:forEach>
								 </c:if>
							</div>
						</div>
					</td>
				</tr>
				<tr>
					<th class="vtop">正文:&nbsp;</th>
					<td>
						<input type="hidden" id="content" name="content" value="${content }" />
						<div id="content_div" >
							<br />
							<div style="border-bottom: #cccccc 1px solid; padding-bottom: 5px; padding-left: 15px; padding-right: 15px; background: #edf6db; font-size: 12px; padding-top: 5px"><span style="line-height: 16px"><b>发件人：</b>&nbsp;${model.sender_name }</span><br>
								<c:if test="${!empty model.getUserNames() }"> <span style="line-height: 16px"><b>收件人：</b>&nbsp;${model.getUserNames() }</span><br></c:if>
								<c:if test="${!empty model.getUserNames_cs() }"> <span style="line-height: 16px"><b>抄送：</b>&nbsp;${model.getUserNames_cs() }</span><br></c:if>
								<c:if test="${model.is_send }"> <span style="line-height: 16px"><b>发送时间：</b>&nbsp;	<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></span><br></c:if>
								<c:if test="${!empty model.subject }"><span style="line-height: 16px"><b>主题：</b>&nbsp;转发: ${model.subject }</span></c:if>
							</div>
							<div style="padding:10px;margin:8px 0 0 20px;border-left:1px solid #666666;color:#999;background:#EEE;">${model.content }</div>
						</div>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td class="btn_area" colspan="2"><span class="btn btn_pub">
							<input type="submit" id="btnSave" value="发送" />
					</span>
					<span class="btn btn_pub ml10">
							<input type="submit" id="btnDraft" value="存草稿" />
					</span>
					<span class="btn btn_base ml10"><input type="button" id="btn_pclose"  value="返回"></span></td>
				</tr>
			</tfoot>
		</table>
	<script type="text/javascript" src="static/js/kindeditor-4.1.4/kindeditor.js"></script>
	<script type="text/javascript" src="static/js/kindeditor-4.1.4/lang/zh_CN.js"></script>
	<script type="text/javascript" src="static/js/biz/file.js"></script>	
	<script type="text/javascript">
	$(function(){
		//发送click事件
		$("#btnSave").click(function(){
			var flag=true;
			if($("#subject").val()=="")
			{
				informationMsg("请输入主题！");
				return false;
			}
			
			var innerUserIds="",innerUser_csIds="",innerUser_msIds="";
			$("#innerUser .user_child").each(function(){
				var $this=$(this);
				if(innerUserIds=="")
				{
					innerUserIds=$this.attr("key_id");
				}else
				{
					innerUserIds+=","+$this.attr("key_id");
				}
			});

			if(innerUserIds=="")
			{
				informationMsg("请选择收件人！");
				return false;
			}
			$("#innerUser_cs .user_child").each(function(){
				var $this=$(this);
				if(innerUser_csIds=="")
				{
					innerUser_csIds=$this.attr("key_id");
				}else
				{
					innerUser_csIds+=","+$this.attr("key_id");
				}
			});
			$("#innerUser_ms .user_child").each(function(){
				var $this=$(this);
				if(innerUser_msIds=="")
				{
					innerUser_msIds=$this.attr("key_id");
				}else
				{
					innerUser_msIds+=","+$this.attr("key_id");
				}
			});

			$("#innerUserIds").val(innerUserIds);
			$("#innerUser_csIds").val(innerUser_csIds);
			$("#innerUser_msIds").val(innerUser_msIds);
			if(flag)
			{
				$("#is_send").val(1);
				$("#content").val(editorAgreement.html());  
			}
			if($("#content").val()=="")
			{
				informationMsg("请输入内容！");
				return false;
			}
			return flag;
		});
		
		//存草稿click事件
		$("#btnDraft").click(function(){
			var flag=true;
			
			var innerUserIds="",innerUser_csIds="",innerUser_msIds="";
			$("#innerUser .user_child").each(function(){
				var $this=$(this);
				if(innerUserIds=="")
				{
					innerUserIds=$this.attr("key_id");
				}else
				{
					innerUserIds+=","+$this.attr("key_id");
				}
			});
			$("#innerUser_cs .user_child").each(function(){
				var $this=$(this);
				if(innerUser_csIds=="")
				{
					innerUser_csIds=$this.attr("key_id");
				}else
				{
					innerUser_csIds+=","+$this.attr("key_id");
				}
			});
			$("#innerUser_ms .user_child").each(function(){
				var $this=$(this);
				if(innerUser_msIds=="")
				{
					innerUser_msIds=$this.attr("key_id");
				}else
				{
					innerUser_msIds+=","+$this.attr("key_id");
				}
			});

			$("#innerUserIds").val(innerUserIds);
			$("#innerUser_csIds").val(innerUser_csIds);
			$("#innerUser_msIds").val(innerUser_msIds);
			if(flag)
			{
				$("#is_send").val(0);
				$("#content").val(editorAgreement.html());  
			}
			
			return flag;
		});
		
		//清空多行文本框
		$("div.dib").click(function(){
			matchChild();
			$("div.dib").removeClass("user_dib");
			$(this).addClass("user_dib");
		});
		
		//短信模板click事件
		$("#tplUl li.sysuser_child").live("click",function(){
			var $this=$(this),key=$this.attr("key");
			
			if($this.hasClass("cur"))
			{
				$(".user_child_sel"+key).remove();
				$("li.u_child"+key).removeClass("cur");
			}else
			{
				if(!checkUser(key))
				{
					informationMsg("该用户已经被选择！")
					return false;
				}else
				{
					$("div.user_dib").append("<span class='user_child user_child_sel"+key+"' key_id='"+key+"' key_name='"+$this.attr("key_n")+"'>"+$this.attr("key_n")+"<em class='del_user'>&times;</em></span>");
					$("li.u_child"+key).addClass("cur");
				}
			}
			/* $("#content").val($this.html()); */
		});
		
		//删除用户
		$(".del_user").live("click",function(){
			var key=$(this).parents(".user_child").attr("key_id");
			$("ul li.u_child"+key).removeClass("cur");
			$(this).parents(".user_child").remove();
		});
		
		
		//正文在线编辑器
		var editorAgreement = KindEditor.create('#content_div', {
	        allowFileManager: true,
	        height: '260px',
	        width: '700px',
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
		
		
	});
	function backToList(result) {
		if (result.flag) {
			var msg=$("#is_send").val()==0?'保存成功！':'发送成功！';
			successMsg(msg, function() {
				var opener = art.dialog.open.origin;
				if($("#is_view").val()=="1")
				{
					opener.freshList();
				}else
				{
					opener.$('#spec_form').submit();
				}
				closeDialog();
			});
		} else {
			errorMsg(result.msg);
		}
	}

	function showError(result) {
		errorMsg(result.msg);
	}
	
	 //在快速搜索中按回车触发的事件
    function responseEnter(e) {
        // 响应回车
        var key = window.event ? e.keyCode : e.which;
        if (key == 13) {
        	
        	$("#spec_form").submit();
        }

    }

    /**
     * 列表开始加载
     */
    function loadBegin(){
    	$('#loading_img').show();
    	$('#error_msg').hide();
    }

    /**
     * 列表加载完成
     */
    function loadComplete(){
    	$('#loading_img').hide();
    }

    /**
     * 列表加载失败
     */
    function loadFailure(){
    	$('#loading_img').hide();
        $('#data_list').html('<div id="error_msg">读取数据失败，请重试</div>');
    }
    
    function checkUser(key){
    	var flag=true;
    	$(".user_child").each(function(){
    		if($(this).attr("key_id")==key)
   			{
    			flag=false;
    			return false;
   			}
    	});
    	return flag;
    };
    
    function matchChild()
    {
    	$("ul li.sysuser_child").removeClass("cur");
    	$("ul li.sysuser_child").each(function(){
    		
    		var $this=$(this);
    		$(".user_child").each(function(){
    			var $item=$(this);
    			if($this.attr("key")==$item.attr("key_id"))
    			{
    				$this.addClass("cur");
    			}
    		});
    	});
    }
		
	</script>
	</form>
</div>

	<!-- E 添加信息 -->
</gd:Layout>