<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:PopLayout> 
	<div class="data_model data_cont_wrap mail_detail">
	    <div class="mail_head">
		    <h2>${model.subject }</h2>
		    <div class="info_list">
			    <ul>
			    	<li><span>发件人：</span>${model.sender_name }</li>
			    	<c:if test="${model.is_send }"><li><span>时间：</span><fmt:formatDate value="${model.create_time}" pattern="yyyy-MM-dd HH:mm:ss" /></span></li></c:if>
			    	<c:if test="${!empty model.getUserNames() }"><li><span>收件人：${model.getUserNames() }</span></li></c:if>
			    	<c:if test="${!empty model.getUserNames_cs() }"><li><span>抄送人：${model.getUserNames_cs() }</span></li></c:if>
			    	<c:if test="${type==1 && model.getUserNames_ms() }"><li><span>密送人：</span>${model.getUserNames_ms() }</li></c:if>
			    	<c:if test="${model.files != null && !model.files.isEmpty()}"><li><span>附件：</span>
			    	<c:forEach items="${model.files}" var="item" varStatus="vs">
						<span id="file_item_${vs.index}" class="user_child file_item" key="${item.id }">
							<a href="email/download.do?id=${item.id }" target="_blank" >${item.name}</a>
			            </span>
					</c:forEach>
			    	</li></c:if>
			    </ul>
		    </div>
		</div> 
	    <div class="mail_cont">
	    	${model.content }
	    </div>
	    <div class="btn_area">
	        <span class="btn btn_pub"><input type="button" id="btn_reply" value="回复"></span>
	        <span class="btn btn_pub ml10"><input type="button" id="btn_forward" value="转发"></span>
	        <span class="btn btn_base ml10"><input type="button" id="btn_pclose" value="关闭"></span>
	    </div>
	</div>
</gd:PopLayout> 
<script type="text/javascript">
$(function(){

	var opener = art.dialog.open.origin;
	opener.$('#spec_form').submit();
	$("#btn_reply").click(function(){
		var url = $(this).attr('href');
		openPage({
			url : 'email/reply.do?id=${model.id}&is_view=1',
			id : 'reply_page',
			title : '回复邮件 ',
			width : '90%',
			height : '80%'
		});
		return false;
		
	});
	
	$("#btn_forward").click(function(){
		var url = $(this).attr('href');
		openPage({
			url : 'email/forward.do?id=${model.id}&is_view=1',
			id : 'reply_page',
			title : '转发邮件 ',
			width : '90%',
			height : '80%'
		});
		return false;
		
	});
});

function freshList()
{
	var opener = art.dialog.open.origin;
	opener.$('#spec_form').submit();
}
</script>