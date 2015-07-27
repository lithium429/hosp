<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout> 
	<gd:Navgation addlink="userlog/add.do" addr="组织架构 &gt; 用户日志管理"></gd:Navgation>
	<div class="data_model data_cont_wrap">
		<form id="spec_form" action="userlog/datalist.do" data-ajax="true" data-ajax-begin="loadBegin" data-ajax-failure="loadFailure" data-ajax-failure="loadComplete" data-ajax-loading="#loading_img" data-ajax-method="POST" data-ajax-mode="replace" data-ajax-update="#data_list" novalidate="novalidate">
			<input type="hidden" name="page_index" id="page_index" value="${page_index}" />
	        <div class="data_cont_wrap_list">
			    <table class="wc100">
			        <tr>
			         <th class="w6per">
						内容：
					 </th>
					 <td class="w8per">
						<input name="content" class="inp_t" />
					 </td> 
					 <td>	
					      <span class="btn btn_pub"><input type="submit" id="btn_search" value="查询"></span>
                          <span class="ml10 btn btn_base">
                               <a href="userlog/list.do">重置</a>
                          </span>
					 </td>
			        </tr>
			    </table>
			</div>
     	</form>
 	</div>
	<div class="data_model wc100 data_list_wrap" id="data_list">
	     <%@ include file="data_list.jsp"%>
 	</div>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
	<script type="text/javascript">
		
		$(function(){
			// 添加
			$('#btn_add').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url:url,
					id:'add_page',
					title:'添加用户日志',
					width:'600px',
					height:'50%'
				});
				return false;
			});
			
			// 修改
			$('.update').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url:url,
					id:'update_page',
					title:'修改用户日志',
					width:'600px',
					height:'50%'
				});
				return false;
			});
			
			// 查看
			$('.view').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url:url,
					id:'view_page',
					title:'查看用户日志',
					width:'600px',
					height:'45%'
				});
				return false;
			}); 
		});
	</script>
</gd:Layout>
