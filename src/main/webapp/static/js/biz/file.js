var file = (function(){
	var opts = null, editorSingle = null, editorMulti = null;
	
	// 初始化
	function init(options){
		var defaults = {
			createBtn: '#btn_create',
			uploadBtn: '#btn_upload',
			batchUploadBtn: '#btn_batch_upload',
			selectBtn: '#btn_select',
			createUrl: 'file/add.do?from=attachment',
			selectUrl: 'directory/select.do',
			container: $('#file_container'),
			batchUpload: {
				sizeLimit: 20,
				uploadLimit: 10,
				fileTypes: '' 
			}
		};
		
		opts = $.extend({}, defaults, options);  
		
		$(opts.createBtn).click(create);
		$(opts.uploadBtn).click(upload);
		$(opts.batchUploadBtn).click(batchUpload);
		$(opts.selectBtn).click(select);
	}
	
	// 新建
	function create(){  
		if(!browser.isIE){
			informationMsg('对不起，此功能暂不支持非IE浏览器！');
			return false;
		}
		
		openPage({
			url: opts.createUrl,
			id: 'add_file_page',
			title: '新建文件',
			width: '650px',
			height: '200px'
		});
		return false;
	}
	
	// 单个上传
	function upload(){
		editorSingle = KindEditor.editor({
			allowFileManager : false
		}); 
		editorSingle.loadPlugin('insertfile', function () {
			editorSingle.plugin.fileDialog({
                fileUrl: '',
                clickFn: function (url, name) {
                	setItem({
                		type: '2',
                		url: url,
                		name: name,
                		file_id: ''
                	});
                    successMsg('上传成功！');
                    editorSingle.hideDialog();
                }
            });
        });
		
		return false; 
	}
	
	// 多个上传
	function batchUpload(){
		// 初始化多文件上传对象
		editorMulti = KindEditor.editor({
	        isMulti: true,
	        allowFileManager: false,
	        sizeLimit: opts.batchUpload.sizeLimit + 'MB', //允许上传的最大文件容量
	        uploadLimit: opts.batchUpload.uploadLimit,
	        fileTypes: opts.batchUpload.fileTypes, //允许上传的文件类型
	        fileTypesDesc: '文档', //选择文件框的提示信息
	        dirName: 'file', //存放上传文件的文件夹
	        fileIcon: 'file.gif', //列表中的文件图标
	        extraFileUploadParams: opts.batchUpload.extraFileUploadParams,
	        //选择文件后回调的函数【只在浏览服务器文件时使用，通过allowFileManager参数开启】
	        afterSelectFile: function (urlText, fileNameText){
	        	
	        },
	        afterOneUploadSuccess: function(fileItem){
	        	setItem({
            		type: '2',
            		url: fileItem.url,
            		name: fileItem.name,
            		file_id: ''
            	});
	        },
	        afterUploadSuccess: function(){
				successMsg('上传成功！'); 
			}
	    });
		
		// 加载上传控件
		editorMulti.loadPlugin('multiimage', function () {
			editorMulti.plugin.multiImageDialog({
                //全部插入按钮回调函数【已被屏蔽】
                clickFn: function (urlList) { 
                	editorMulti.hideDialog();
                },
                //删除回调函数【直接上传，并关闭对话框】
                afterRemove: function (currentUrl, urlList) { 
                    return;
                }
            });
        });
		return false;
	}
	
	// 选择文件
	function select(){
		openPage({
			url: opts.selectUrl,
			id: 'select_file_page',
			title: '选择文件',
			width: '90%',
			height: '80%'
		});
		return false;
	} 
	
	// 删除
	function remove(id){
		$('#' + id).remove();
		var name = null, tempArray = null;
		$('.file_item').each(function(index, item){
			$(item).find('input[name^="files"]').each(function(sindex, sitem){ 
				name = $(sitem).attr('name');
				tempArray = name.split('.');
				$(sitem).attr('name', 'files['+ index + '].' + tempArray[1]);
			});
		});
	}
	
	// 设置到页面
	function setItem(item){
		var tmpl = ['<span id="file_item_{index}" class="user_child file_item" onclick="file.remove(\'file_item_{index}\');">',
		            	'{0}<em title="删除" class="del_user">×</em>',
		            	'<input type="hidden" name="files[{index}].type" value="{1}" />',
		            	'<input type="hidden" name="files[{index}].url" value="{2}" />',
		            	'<input type="hidden" name="files[{index}].name" value="{3}" />',
		            	'<input type="hidden" name="files[{index}].file_id" value="{4}" />',
		            	'<input type="hidden" name="files[{index}].sort" value="{5}" />',
		            '</span>'].join(''),
		index = opts.container.find('.file_item').length,
		html = util.formatString(tmpl, item.name, item.type, item.url, item.name, item.file_id, index);
		html = html.replace(/\{index\}/g, index);
		opts.container.append(html);
	}
	
	return { init: init, setItem: setItem, remove: remove };
})();