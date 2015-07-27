var ntkoOcx = (function(){
	var ocxObj = util.$g("TANGER_OCX"), isFileOpened, fileType, fileTypeSimple, savedFile = null;
 
	function init(){
		ocxObj.IsUseUTF8Data = true;
		ocxObj.FileNew = false;
		ocxObj.FileSave = false;
		ocxObj.FileClose = false;
		ocxObj.FileOpen = false;
	}
	
	function create(type) { 
		init();
		switch (type) {
			case "1":
				ocxObj.CreateNew("Word.Document");
				break;
			case "2":
				ocxObj.CreateNew("Excel.Sheet");
				break;
			case "3":
				ocxObj.CreateNew("PowerPoint.Show");
				break;
		}
	}

	function open(fileUrl) {
		init();
		ocxObj.BeginOpenFromURL(fileUrl);
	}
	
	function read(fileUrl){ 
		init();
		ocxObj.FileSaveAs = false;
		ocxObj.BeginOpenFromURL(fileUrl); 
	}
	
	function setFileType(type, simpleType){
		fileType = type;
		fileTypeSimple = simpleType;
	}

	function setFileState(bool) {
		isFileOpened = bool;
		fileType = ocxObj.DocType;
	}

	function save() {    
		var myUrl = $('#form0').attr('action'), 
		moduleType = $('#module_type').val(),
		directoryId = $('#directory_id').val(),
		fileName = $('#file_name').val(),
		fileId = $('#file_id').val(),
		result = null;
		
		if (isFileOpened) {
			switch (ocxObj.doctype) {
			case 1:
				fileType = "doc";
				break;
			case 2:
				fileType = "xls";
				break;
			case 3:
				fileType = "ppt";
				break;
			case 4:
				fileType = "Visio.Drawing";
				break;
			case 5:
				fileType = "MSProject.Project";
				break;
			case 6:
				fileType = "wps";
				break;
			case 7:
				fileType = "Kingsoft Sheet";
				break;
			default:
				fileType = "unkownfiletype";
			} 
			result = ocxObj.saveToURL(myUrl, // 提交到的url地址
									"upLoadFile", // 文件域的id
									["fileType=" + fileType,  
									 "moduleType=" + moduleType,
									 "directoryId=" + directoryId,
									 "fileId=" + fileId].join('&'), // 与控件一起提交的参数如："p1=a&p2=b&p3=c"
									fileName, // 上传文件的名称，类似<input type=file 的value
									0 // 与控件一起提交的表单id，也可以是form的序列号，这里应该是0.
								); 
			var resultObj = eval('(' + util.trim(result) + ')' );
			if(resultObj.flag){
				savedFile = { 
					name: fileName,
					url: resultObj.obj
				}; 
				close();
			}
			else{
				$('#status_bar').removeClass('dn').html("服务器返回信息：" + resultObj.msg);
			}
		}
	}

	function saveAsHtml() {
		var htmlFileName = $('#file_name').val() + ".html", result = null;
		if (isFileOpened) {
			result = ocxObj.PublishAsHTMLToURL("url", "uploadHtml", "htmlFileName=" + htmlFileName, htmlFileName);
			result = util.trim(result);
			$('#status_bar').removeClass('dn').html("服务器返回信息：" + result);
			close();
		}
	}

	function close() {
		// 关闭文档
		ocxObj.Close();
		ocxObj.style.display = "none";

		successMsg('保存成功！', function() {
			refreshParent(savedFile);
			closePage();
		});
	}

	function setReviewMode(value) {
		if (ocxObj.doctype == 1) {
			ocxObj.ActiveDocument.TrackRevisions = value; // 设置是否保留痕迹
		}
	}

	function setShowRevisions(value) {
		if (ocxObj.doctype == 1) {
			ocxObj.ActiveDocument.ShowRevisions = value; // 设置是否显示痕迹
		}
	}
	
	function acceptAllRevisions(){
		ocxObj.ActiveDocument.AcceptAllRevisions();
	}

	function setFilePrint(value) {
		ocxObj.fileprint = value; // 是否允许打印
	}
	
	function showPrintSet(){
		ocxObj.showDialog(5);
	}
	
	function printPreview(){
		ocxObj.PrintPreview();
	}

	function setFileClose(value){
		ocxObj.FileClose = value;
	}

	function setFileNew(value) {
		ocxObj.FileNew = value; // 是否允许新建
	}

	function setFileSave(value) {
		ocxObj.FileSave = value;
	}

	function setFileSaveAs(value) {
		ocxObj.FileSaveAs = value; // 是否允许另存为
	}

	function setIsNoCopy(value) {
		ocxObj.IsNoCopy = value; // 是否禁止粘贴
	}

	// 设置工具栏
	function setToolBar() {
		ocxObj.ToolBars = !ocxObj.ToolBars;
	}

	// 控制是否显示所有菜单
	function setMenubar() {
		ocxObj.Menubar = !ocxObj.Menubar;
	}
	
	// 设置是否允许编辑
	function setReadOnly(value){  
		var appName, i;
	    try {
	        if (value) {
	        	ocxObj.IsShowToolMenu = false;
	        }

	        if (!isFileOpened)
	            return;

	        with (ocxObj.ActiveDocument) {
	            appName = new String(Application.Name);
	            //Word
	            if ((appName.toUpperCase()).indexOf("WORD") > -1){
	                if (ProtectionType != -1 && !value) {
	                    Unprotect();
	                }
	                if (ProtectionType == -1 && value) {
	                    Protect(3, true, "");
	                }
	            }
	            //EXCEL
	            else if ((appName.toUpperCase()).indexOf("EXCEL") > -1){
	                for (i = 1; i <= Application.Sheets.Count; i++) {
	                    if (value) {
	                        Application.Sheets(i).Protect("", true, true, true);
	                    }
	                    else {
	                        Application.Sheets(i).Unprotect("");
	                    }
	                }
	                if (value) {
	                    Application.ActiveWorkbook.Protect("", true);
	                }
	                else {
	                    Application.ActiveWorkbook.Unprotect("");
	                }
	            }
	            else {
	            }
	        }
	    }
	    catch (err) {
	    	if(console && console.log){
	    		console.log(err);
	    	}
	    }
	    finally {
	    }
	}
	
	function ensureSave(){  
		if (!ocxObj.activeDocument.saved) {
	        var flag = confirm("文档修改过，还没有保存，是否需要保存？");
	        if(flag){
	        	save();
	        }
	        else{
	        	closePage();
	        }
	    } 
		else{
			closePage();
		}
	}
	
	return { 
		obj: ocxObj,
		create: create,
		open: open,
		save: save,
		read: read,
		ensureSave: ensureSave,
		setFileType: setFileType,
		setFileState: setFileState,
		setReadOnly: setReadOnly, 
		// 痕迹
		setReviewMode: setReviewMode,
		setShowRevisions: setShowRevisions,
		acceptAllRevisions: acceptAllRevisions,
		// 工具、菜单
		setToolBar: setToolBar,
		setMenubar: setMenubar,
		// 打印
		setFilePrint: setFilePrint,
		showPrintSet: showPrintSet,
		printPreview: printPreview
	};
})();
 