<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout>  
	<div class="mb10 crumbs"> 
		<div class="tabs_hd">
			<ul class="clearfix Tab_Panels" id="usersel">
				<li class="cur"><a href="javascript:void(0);" class="tab_inner">我的文档</a></li>
				<li><a href="directory/selectshare.do" class="tab_inner">共享文档</a></li>
			</ul>
		</div>
	</div>
	<div class="data_model colum_two clearfix">
		<ul id="ztree_list" class="ztree transcipt_tree leftbox" style="width:200px;"></ul>
		<div class="rightbox" style="margin-left:220px;">
			<form id="spec_form" action="file/selectdatalist.do" data-ajax="true" data-ajax-begin="loadBegin" data-ajax-failure="loadFailure" data-ajax-failure="loadComplete" data-ajax-loading="#loading_img" data-ajax-method="POST" data-ajax-mode="replace" data-ajax-update="#data_list" novalidate="novalidate"> 
				<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" /> 
				<input type="hidden" name="directory_id" id="directory_id" value="" />
				<input type="hidden" name="creator_id" id="creator_id" value="" />
				<input type="hidden" name="not_ids" id="not_ids" value="" />
				<input type="hidden" name="types" id="types" value="" />
		        <div class="mb10 data_cont_wrap_list query_condition">
					<table>
						<tbody>
							<tr>
								<th class="w55">文件类型</th>					
								<td id="type_td">
									<label><input type="checkbox" class="inp_analog" value="1" name="type" /><span class="mr5 icon ico-checkbox"></span>文档</label>
									<label><input type="checkbox" class="inp_analog" value="2" name="type" /><span class="mr5 icon ico-checkbox"></span>图片</label>
									<label><input type="checkbox" class="inp_analog" value="3" name="type" /><span class="mr5 icon ico-checkbox"></span>其它</label> 
								</td>
								<th class="w55">文件名</th>					
								<td>
									<input class="inp_t inp_w150" name="name" id="name" />
								</td>
								<th class="w55">上传时间</th>					
								<td>
									 <input id="min_create_time" name="min_create_time" class="inp_t w140 search_sel exportValue ico_date" readonly="readonly" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'max_create_time\')}'})" />
										-
									 <input id="max_create_time" name="max_create_time" class="inp_t w140 search_sel exportValue ico_date" readonly="readonly" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'min_create_time\')}'})" />
								</td>    
								<td>
									<span class="btn btn_pub">
										<input type="submit" id="btn_search" value="查询" />
									</span><span class="ml8 btn btn_base">
										<a href="directory/select.do">重置</a>
									</span>
								</td>
							</tr>
						 </tbody>
				 	 </table>
		        </div>
	     	</form>
	     	<div class="data_model wc100 data_list_wrap dt_query rbox_wrap" id="data_list">
			     
		 	</div>
	 	</div>
 	</div>
 	<div class="dn" id="json_tree">${jsonTree}</div>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" />
	 
	<script type="text/javascript" src="static/js/index.js"></script> 
	<script type="text/javascript" src="static/js/biz/file.select.js"></script> 
</gd:Layout>
