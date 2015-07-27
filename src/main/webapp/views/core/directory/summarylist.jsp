<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout> 
	<style type="text/css">
	.ztree .rz_span{width:120px;}
	</style>
	<div class="mb10 crumbs"> 
		 <span class="icon ico_place"></span><b>您当前的位置：</b>文档管理 &gt; 总结文档
		 <div class="model_top_fun" id="top_btn_div">
		 	<c:if test="${gdf:judgeRoleMenu(roleMenuList,'新建文件') }">
				<span class="btn btn_pub"><a href="file/add.do" id="btn_add">新建文件</a></span>
			</c:if>
			<c:if test="${gdf:judgeRoleMenu(roleMenuList,'批量上传文件') }">
				<span class="btn btn_pub"><a href="javascript:void(0);" id="btn_upload">批量上传文件</a></span>
			</c:if> 
		</div> 
	</div>
	<div class="data_model colum_two clearfix">
		<ul id="ztree_list" class="ztree transcipt_tree leftbox" style="width:300px;"></ul>
		<div class="rightbox" style="margin-left:320px;">
			<form id="spec_form" action="file/summarydatalist.do" data-ajax="true" data-ajax-begin="loadBegin" data-ajax-failure="loadFailure" data-ajax-failure="loadComplete" data-ajax-loading="#loading_img" data-ajax-method="POST" data-ajax-mode="replace" data-ajax-update="#data_list" novalidate="novalidate"> 
				<input type="hidden" name="page_index" id="page_index" value="${pageIndex}" /> 
				<input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
				<input type="hidden" name="directory_id" id="directory_id" value="" />
				<input type="hidden" name="creator_id" id="creator_id" value="" />
				<input type="hidden" name="types" id="types" value="" />
		        <div class="mb10 data_cont_wrap_list query_condition">
					<table>
						<tbody>
							<tr> 
								<th class="w55">文件名</th>					
								<td>
									<input class="inp_t inp_w120" name="name" id="name" />
								</td>
								<th class="w55">上传时间</th>					
								<td>
									 <input id="min_create_time" name="min_create_time" class="inp_t w120 search_sel exportValue" readonly="readonly" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'max_create_time\')}'})" />
										-
									 <input id="max_create_time" name="max_create_time" class="inp_t w120 search_sel exportValue" readonly="readonly" onclick="WdatePicker({readyOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'min_create_time\')}'})" />
								</td>    
								<th class="w55">部门科室</th>					
								<td>
									<select id="dept_id" name="dept_id" >
										<option value="">--全部--</option>
										<c:forEach items="${deptList}" var="item" varStatus="vs">
											<c:choose>
												<c:when test="${item.layer == 1}">
													<optgroup label="${item.name}"</optgroup>
												</c:when>
												<c:otherwise>
													<option value="${item.id }">${item.name }</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</td>
								<th class="w55">上传用户</th>					
								<td>
									<input class="inp_t inp_w120" name="creator_name" id="creator_name" />
								</td>
								<td>
									<span class="btn btn_pub">
										<input type="submit" id="btn_search" value="查询" />
									</span><span class="ml8 btn btn_base">
										<a href="directory/summarylist.do">重置</a>
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
	<input type="hidden" id="show_add" value="${gdf:judgeRoleMenu(roleMenuList,'添加文件夹') }" />
	<input type="hidden" id="show_edit" value="${gdf:judgeRoleMenu(roleMenuList,'修改文件夹') }" />
	<input type="hidden" id="show_del" value="${gdf:judgeRoleMenu(roleMenuList,'删除文件夹') }" />
	 
	<script type="text/javascript" src="static/js/index.js"></script> 
	<script type="text/javascript" src="static/js/kindeditor-4.1.4/kindeditor.js"></script>
	<script type="text/javascript" src="static/js/kindeditor-4.1.4/lang/zh_CN.js"></script>
	<script type="text/javascript"> 
	var ztreeWrapper = (function(){
	    var setting = { 
	        async: {
	            enable: true,
	            url: 'directory/getchilds.do',
	            autoParam: ["id"],
	            otherParam: { module_type: 2},
	            dataType: "text",
	            type: "post",
	            dataFilter: null
	        },
	        callback: {
	            beforeAsync: beforeAsync,
	            onAsyncSuccess: onAsyncSuccess,
	            onAsyncError: onAsyncError,
	            beforeRemove: zTreeBeforeRemove,
	            beforeEditName: zTreeBeforeEditName,
	            beforeRename: zTreeBeforeRename
	        }, 
	        data: {
	            simpleData: {
	                enable: true, 
	                rootPId: 0
	            },
	            keep: {
	            	parent: true
	            }
	        },
	        edit: {
	            drag: {
	                isMove: false,
	                isCopy: false
	            },
	            editNameSelectAll: true,
	            enable: true,
	            removeTitle: '删除',
	            renameTitle: '修改',
	            showRemoveBtn: setRemoveBtn,
	            showRenameBtn: setRenameBtn
	        },
	        view: {
	            addHoverDom: addHoverDom,
	            removeHoverDom: removeHoverDom
	        }
	    };
	
	    var newCount = 1;
	    function addHoverDom(treeId, treeNode) {
	    	// 获取子节点
	    	function getChildIds(parentNode, isShare){
	    		if(util.isNull(parentNode)){
	    			return '';
	    		} 

	    		var idArray = [], children = parentNode.children;
	    		if(!util.isNull(children) && children.length > 0){
	    			for(var i=0; i<children.length; i++){
	    				if(children[i].isShare == isShare){
	    					idArray.push(children[i].id);
	    				}
	    				var childIds = getChildIds(children[i], isShare);
	    				if(!util.isEmpty(childIds)){
	    					idArray.push(childIds);
	    				}
	    			}
	    		}
	    		return idArray.join(',');
	    	}
	    	
	        if (treeNode.showAddBtn && $("#show_add").val()=="true") {
	            var aObj = $("#" + treeNode.tId + "_a");
	            if ($("#diyBtn_space_" + treeNode.id).length > 0) return;
	            var editStr = "<span  class='button add' title='添加' id='diyBtn_space_" + treeNode.id + "' onfocus='this.blur();' > </span>";
	            aObj.append(editStr);
	            var btn = $("#diyBtn_space_" + treeNode.id);
	            if (btn){ 
	            	btn.bind("click", function () {
		                var zTree = $.fn.zTree.getZTreeObj("ztree_list");
		                var newNode = zTree.addNodes(treeNode, 
		                		{ 
		                			id: (100 + newCount), 
		                		  	parentId: treeNode.id, 
		                		  	isAdd: true,
		                		  	showDeleteBtn: true,
		                		  	showEditBtn: true,
		                		  	isParent: true,
		                		  	showAddBtn: true, 
		                		  	name: "NewNode" + (newCount++) 
		                		 });
		                if (newNode) {
		                    zTree.editName(newNode[0]);
		                }
		                return false;
		            });
	            }
	        } 
	    };
	    function removeHoverDom(treeId, treeNode) {
	        $("#diyBtn_space_" + treeNode.id).unbind().remove(); 
	    };
	
	    // 用于捕获节点编辑名称结束（Input 失去焦点 或 按下 Enter 键）之后，更新节点名称数据之前的事件回调函数，并且根据返回值确定是否允许更改名称的操作
	    function zTreeBeforeRename(treeId, treeNode, newName, isCancel) {
	    	// 获取所有父节点id，根节点除外
	    	function getParentIds(node){
	    		var idArray = [];
	    		if(node.parentTId){
	    			var parentNode = node.getParentNode(), ids = null;
	    			if(parentNode.id && !util.isEmpty(parentNode.id)){
	    				idArray.push(parentNode.id);
	    				ids = getParentIds(parentNode);
	    				if(!util.isEmpty(ids)){
	    					idArray.push(ids);
	    				}
	    			}
	    		}
	    		return idArray.join(',');
	    	}
	    	
	        var currentId = treeNode["id"], 
	        parentId = treeNode["parentId"], 
	        layer = treeNode["level"],
	        flag = true;  
	        
	      //修改
	        if (!treeNode["isAdd"]) {
	        	// 节点名称改变时才需要更新数据库
	        	if(treeNode["name"] !== util.trim(newName)){        		
		            $.ajax({
		                type: 'POST',
		                dataType: 'Json',
		                url: 'directory/update.do',
		                data: { id: currentId, name: newName },
		                cache: false,
		                async: false,
		                success: function (result) {
		                    if (result.flag) {
		                        successMsg("修改成功！"); 
		                        $("#spec_form").submit(); 
		                    }
		                    else {
		                        informationMsg(result.msg);
		                        flag = false;
		                    }
		                },
		                error: function () {
		                    errorMsg("修改异常！");
		                    flag = false;
		                }
		            });
	        	}
	        }
	        else {  //添加
	        	if(util.isNull(parentId)) {
	        		parentId = "";
	       		}
	        	var parentIds = getParentIds(treeNode);
	        
	            $.ajax({
	                type: 'POST',
	                dataType: 'Json',
	                url: 'directory/add.do',
	                data: { name: newName, parent_id: parentId, parent_ids: parentIds, module_type: 2, layer: Number(layer)},
	                cache: false,
	                async: false,
	                success: function (result) {
	                    if (result.flag) {
	                        successMsg("添加成功！");   
	                    	refreshNodes(treeNode);
	                    }
	                    else {
	                        informationMsg(result.msg);
	                        flag = false;
	                    }
	                },
	                error: function () {
	                    errorMsg("添加异常！");
	                    flag = false;
	                }
	            });
	        }
			return flag;
	    }
	
	    //删除节点前触发的事件 用于捕获节点被删除之前的事件回调函数，并且根据返回值确定是否允许删除操作
	    function zTreeBeforeRemove(treeId, treeNode) {
	        var currentId = treeNode["id"];
	        var tId = treeNode["tId"];
	        var flag = true;
	        confirmDialog("您确定要删除吗，删除此文件夹会同时删除此文件夹下的文件，并且不可恢复？", function () {
	            $.ajax({
	                type: 'POST',
	                dataType: 'Json',
	                url: 'directory/delete.do?id=' + currentId,
	                cache: false,
	                async: false,
	                success: function (result) {
	                    if (result.flag) {
	                        var treeObj = $.fn.zTree.getZTreeObj("ztree_list"),
	                        parentObj = treeNode.getParentNode();
	                        treeObj.removeNode(treeNode); 
	                        
	                        successMsg("删除成功！");
	                        $('#spec_form').submit();
	                    }
	                    else {
	                        informationMsg(result.msg);
	                        flag = false;
	                    }
	                },
	                error: function () {
	                    errorMsg("删除异常！");
	                    flag = false;
	                }
	            });
	        });
	        return false;
	    }
	    
	    // 刷新节点
	    function refreshNodes(node){
			var treeObj = $.fn.zTree.getZTreeObj("ztree_list"),
			parentNode = node.getParentNode();
			if(parentNode){
				treeObj.reAsyncChildNodes(parentNode, "refresh");
				expandNodes(parentNode);
			}
			else{
				treeObj.reAsyncChildNodes(node, "refresh");
				expandNodes(node);
			}
			
	    }
	
	    // 设置哪些节点可以有编辑按钮
	    function zTreeBeforeEditName(treeId, treeNode) { 
	        return true;
	    }
	
	    // 设置哪些文档类别后面有删除按钮
	    function setRemoveBtn(treeId, treeNode) {
	        return treeNode.showDeleteBtn && $("#show_del").val() == "true";
	    }
	
	    // 设置哪些文档类别后面有编辑按钮
	    function setRenameBtn(treeId, treeNode) {
	        return treeNode.showEditBtn && $("#show_edit").val() == "true";
	    }
	
	    var curStatus = "init", curAsyncCount = 0, asyncForAll = false, goAsync = false;
	
	    function filter(treeId, parentNode, childNodes) {
	        if (!childNodes) return null;
	        for (var i = 0, l = childNodes.length; i < l; i++) {
	            childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
	        }
	        return childNodes;
	    }
	
	    // 异步加载前触发的方法
	    function beforeAsync() {
	        curAsyncCount++;
	    }
	
	    // 异步加载成功后触发的方法
	    function onAsyncSuccess(event, treeId, treeNode, msg) {
	        curAsyncCount--;
	        if (curStatus == "expand") {
	            expandNodes(treeNode.children);
	        } else if (curStatus == "async") {
	            asyncNodes(treeNode.children);
	        }
	
	        if (curAsyncCount <= 0) {
	            if (curStatus != "init" && curStatus != "") { 
	                asyncForAll = true;
	            }
	            curStatus = "";
	        }
	    }
	
	    // 异步加载【失败】的时候触发的方法
	    function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
	        curAsyncCount--;
	
	        if (curAsyncCount <= 0) {
	            curStatus = "";
	            if (treeNode != null) asyncForAll = true;
	        }
	    }
	
	    //检查是否已经加载过了。
	    function check() {
	        if (curAsyncCount > 0) { 
	            return false;
	        }
	        return true;
	    }
	
	    //加载所有节点
	    function expandNodes(nodes) {
	        if (!nodes) return;
	        curStatus = "expand";
	        var zTree = $.fn.zTree.getZTreeObj("ztree_list");
	        for (var i = 0, l = nodes.length; i < l; i++) {
	            zTree.expandNode(nodes[i], true, false, false);
	            if (nodes[i].isParent && nodes[i].zAsync) {
	                expandNodes(nodes[i].children);
	            } else {
	                goAsync = true;
	            }
	        } 
	    }
	
	    //全部打开树的方法
	    function openAllForTree() {
	        if (!check()) {
	            return;
	        }
	        var zTree = $.fn.zTree.getZTreeObj("ztree_list");
	        if (asyncForAll) {
	            zTree.expandAll(true);
	        } else {
	            expandNodes(zTree.getNodes());
	            if (!goAsync) {
	                curStatus = "";
	            }
	        }
	    }
	    
	 	// 初始化树
	    function init() {
	        //初始化树
	        var jsonTree = eval('(' + $("#json_tree").html() + ')');
	        $.fn.zTree.init($("#ztree_list"), setting, jsonTree);
	        //获取当前zTree对象，后面的参数字符串指的是tree容器的Id
	        var treeObj = $.fn.zTree.getZTreeObj("ztree_list"); 
	        openAllForTree(); //如果放开这个方法，则默认就全部打开
	    } 
    
	 	return { init: init };
	})();

	var editorDoc = KindEditor.editor({
        isMulti: true,
        allowFileManager: false,
        sizeLimit: '${sizeLimit}MB', //允许上传的最大文件容量
        uploadLimit: Number('${uploadLimit}'),
        fileTypes: '${fileTypes}', //允许上传的文件类型
        fileTypesDesc: '文档', //选择文件框的提示信息
        dirName: 'file', //存放上传文件的文件夹
        fileIcon: 'file.gif', //列表中的文件图标
        extraFileUploadParams: { directory_id: $('#directory_id'), module_type: 2 },
        //选择文件后回调的函数
        afterSelectFile: function (urlText, fileNameText) {  
        },
        afterUploadSuccess: function(){
        	successMsg('上传成功！', function(){
        		$("#spec_form").submit();	
        	});
        }
    });
	
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
            
            // 选中根目录不显示顶部操作按钮
            if(util.isNull(id)){
            	$('#top_btn_div').hide();
            }
            else{
            	$('#top_btn_div').show();
            }
            
            $("#directory_id").val(id);
            $('#creator_id').val(creatorId);
            $("#spec_form").submit();
        });
      	
      	// 单击根节点
      	$('.level0').click();
      	
      	// 自动查询
      	fileType.init();
      	
      	// 批量上传
        $("#btn_upload").click(function () { 
            editorDoc.loadPlugin('multiimage', function () {
                editorDoc.plugin.multiImageDialog({
                    //全部插入按钮回调函数
                    clickFn: function (urlList) { 
                        editorDoc.hideDialog();
                    },
                    //删除回调函数
                    afterRemove: function (currentUrl, urlList) {
                        return;
                    }
                });
            });
        }); 
      
		// 新建文件
		$('#btn_add').live('click',function(){
			if(!browser.isIE){
				informationMsg('对不起，此功能暂不支持非IE浏览器！');
				return false;
			}
			
			var url = $(this).attr('href'),
			directoryId = $('#directory_id').val();
			openPage({
				url: url + '?moduleType=2&directoryId=' + directoryId,
				id: 'add_page',
				title: '新建文件',
				width: '650px',
				height: '200px'
			});
			return false;
		});
		
		// 修改
		$('.update').live('click',function(){
			if(!browser.isIE){
				informationMsg('对不起，此功能暂不支持非IE浏览器！');
				return false;
			}
			
			var url = $(this).attr('href');
			openPage({
				url: url,
				id: 'update_page',
				title: '修改文件',
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
		
		// 修改文件名
		$('.update_name').live('click',function(){ 
			var url = $(this).attr('href');
			openPage({
				url: url,
				id: 'update_name_page',
				title: '修改文件名',
				width: '500px',
				height: '140px' 
			});
			return false;
		});
		
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
		
		// 可见用户
		$('.fileuser').live('click',function(){  
			var url = $(this).attr('href');
			openPage({
				url: url,
				id: 'fileuser_page',
				title: '设置可见用户',
				width: '500px',
				height: '200px' 
			});
			return false;
		});
		
		// 批量可见用户
		$('#batch_file_user').live('click' ,function(){
			var scount = $('input[name="id"]:checked').length;
			if(scount === 0){
				informationMsg('请先选择文件！');
				return false;
			}
			
			var url = $(this).attr('href');
			openPage({
				url: url,
				id: 'batch_fileuser_page',
				title: '设置可见用户',
				width: '600px',
				height: '220px' 
			});
			return false;
		});
	}); 
	</script>
</gd:Layout>
