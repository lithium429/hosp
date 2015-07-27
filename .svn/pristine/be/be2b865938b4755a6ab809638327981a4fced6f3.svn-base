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

// 页面初始化
var page = (function(){
	function init(){
		var opener = art.dialog.open.origin,
		idArray = [];
		opener.$('#file_container').find('input[name$="file_id"]').each(function(index, item){
			if(!util.isEmpty(item.value)){
				idArray.push(item.value);
			}
		});
		$('#not_ids').val(idArray.join(',')); 
	}
	
	return { init: init };
})();

$(function () {
    //初始化树
    ztreeWrapper.init();
    
    page.init();
    
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