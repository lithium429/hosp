<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout> 
	<style type="text/css">
	.ztree .rz_span{width:120px;}
	</style>
	<gd:Navgation addr="文档管理  &gt; 共享文档"></gd:Navgation>
	<div class="data_model colum_two clearfix">
		<ul id="ztree_list" class="ztree transcipt_tree leftbox" style="width:300px;"></ul>
		<div class="rightbox" style="margin-left:320px;">
			<form id="spec_form" action="file/sharedatalist.do" data-ajax="true" data-ajax-begin="loadBegin" data-ajax-failure="loadFailure" data-ajax-failure="loadComplete" data-ajax-loading="#loading_img" data-ajax-method="POST" data-ajax-mode="replace" data-ajax-update="#data_list" novalidate="novalidate"> 
				<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" /> 
				<input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
				<input type="hidden" name="directory_id" id="directory_id" value="" />
				<input type="hidden" name="creator_id" id="creator_id" value="" />
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
									 <input id="min_create_time" name="min_create_time" class="inp_t w120 search_sel exportValue" readonly="readonly" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'max_create_time\')}'})" />
										-
									 <input id="max_create_time" name="max_create_time" class="inp_t w120 search_sel exportValue" readonly="readonly" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'min_create_time\')}'})" />
								</td>    
								<td>
									<span class="btn btn_pub">
										<input type="submit" id="btn_search" value="查询" />
									</span><span class="ml8 btn btn_base">
										<a href="directory/sharelist.do">重置</a>
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
	<script type="text/javascript"> 
	var ztreeWrapper = (function(){
	    var setting = {  
    		view: {
                dblClickExpand: false,
                expandSpeed: ($.browser.msie && parseInt($.browser.version) <= 6) ? "" : "fast"
            },
            data: {
                simpleData: {
                    enable: true, 
                    rootPId: null
                }
            }
	    }; 
	    
	 	// 初始化树
	    function init() {
	        //初始化树
	        var jsonTree = eval('(' + $("#json_tree").html() + ')');
	        $.fn.zTree.init($("#ztree_list"), setting, jsonTree); 
	    } 
    
	 	return { init: init };
	})();
 
	// 选择文档类型自动查询	
	var fileType = (function(){
		var fileTypes = $('input[name="type"]', $('#type_td')); 
		
		function init(){
	      	fileTypes.each(function(index, item){
	      		$(item).click(function(){
	      			var array = [];
	      			fileTypes.each(function(sindex, sitem){
	      				var checked = $(sitem).attr('checked');
	      				if(checked === 'checked'){
	      					array.push(sitem.value);
	      				}
	      			});
	      			$('#types').val(array.join(','));
	      			$('#spec_form').submit();
	      		});
	      	});
		}
		
		return { init: init };
	})();
    
    $(function () {
        //初始化树
        ztreeWrapper.init();  
        
      	//这里的bw类是在zTree的js里面我手动添加的，为了方便我找到当前哪个节点被点击并给它绑定事件
        //所以这个类没有其他意思，不要误解
        $(".bw").live("click", function () {
            var treeObj = $.fn.zTree.getZTreeObj("ztree_list"),
            node = treeObj.getSelectedNodes()[0],
            id = node["id"],
            creatorId = node["creatorId"];  
            
            $("#directory_id").val(id);
            $('#creator_id').val(creatorId);
            $("#spec_form").submit();
        });
      	
      	// 单击根节点
      	$('#ztree_list_1_a').click();
      	
      	// 自动查询
      	fileType.init(); 
		
		// 阅读
		$('.view').live('click',function(){
			if(!browser.isIE){
				informationMsg('对不起，此功能暂不支持非IE浏览器！');
				return false;
			}
			
			var url = $(this).attr('href');
			openPage({
				url: url,
				id: 'view_page',
				title: '阅读文件',
				width: '100%',
				height: '100%',
				init: function(){
					if(browser.isIE){
						$('.aui_close:last', art.dialog.top.parent.document).attr('style', 'visibility:hidden;');
					}
				}
			});
			return false;
		}); 
		 
	}); 
	</script>
</gd:Layout>
