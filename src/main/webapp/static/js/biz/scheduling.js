var page = (function(){
	function init(){
		var width = $(document).width();
		$('.leftbox').width(Math.round(width * 0.7));
		$('.rightbox').width(Math.round(width * 0.28)); 
	}
	
	return { init: init };
})();

// 排班
var scheduling = (function(){
	var context = $('#tbody'),
	ztreeObj = null,
	creatorId = $('#creator_id').val();
	
	function init(){
		getData();
		
		$('.td_item').live('click', function(){
			$('.td_item').css('background', '#fff');
			$(this).css('background', '#dddfff');
			$('#current_index').val($(this).attr('rel'));
		});
		
		$('.bw').live('click', selectUser);
		
		$('#btn_save,#btn_save_top').click(save);
		$('#btn_clear').click(clear);
	}
	
	function changeDept(){
		var deptId = $(this).val(),
		edeptId = $('#dept_id').val(); 
		if(deptId != edeptId){
			$('#dept_id').val(deptId);
			getData();
			ztreeWrapper.search();
		}
	}
	
	// 获取排班数据
	function getData(){
		var year = $('#year').val(), 
		month = $('#month').val(),
		deptId = $('#dept_id').val();
		util.ajax({
			url: 'scheduling/data.do',
			type: 'get',
			dataType: 'html',
			data: { year: year, month: month, deptId: deptId, time: util.now() },
			success: function(html){
				$('#tbody').html(html);
			}
		});
	}

	// 选择用户
	function selectUser(){
		var currentIndex = $('#current_index').val();
		if(util.isEmpty(currentIndex)){
			return;
		}
		
		var treeObj = $.fn.zTree.getZTreeObj('ztree_list'),
        node = treeObj.getSelectedNodes()[0],
        id = node['id'], name = node['name'], 
        currentDiv = $('#div_'+ currentIndex),
        flag = false;
		
		// 检查用户是否已经被选择
		currentDiv.find('input[name="user_id"]').each(function(index, item){
			if(item.value == id){
				flag = true;
				return false; 
			}
		});
		
		if(flag){ 
			return ; 
		}
		
        var spanIndex = currentDiv.find('span').length + 1,
        spanId = 'span_' + currentIndex + '_' + spanIndex,
        tmpl = ['<span id="{0}" class="user_child" onclick="scheduling.remove(\'{1}\');">{2}',
            		'<em title="删除" class="del_user">×</em>',
            		'<input type="hidden" name="user_id" value="{3}" />',
            	'</span>'].join(''),
        html = util.formatString(tmpl, spanId, spanId, name, id); 
		currentDiv.append(html);
	}
	
	// 删除已选值班人员
	function remove(id, flag){
		if(!util.isNull(flag) && !flag ){
			return false;
		}
		$('#' + id).remove();
	}
	
	// 构造日期
	function newDate(time){
		return '2014-1-1 ' + time + ':00';
	}
	
	// 保存数据
	function save(){
		var stimeCount = $('#stime_count').val();
		if(util.isEmpty(stimeCount) || Number(stimeCount) === 0){
			errorMsg('请先设置排班时间段！');
			return false;
		}
		
		var tmpl = ['<input type="hidden" name="list[{index}].dept_id" value="{0}" />',
		            '<input type="hidden" name="list[{index}].year" value="{1}" />',
		            '<input type="hidden" name="list[{index}].month" value="{2}" />',
		            '<input type="hidden" name="list[{index}].day" value="{3}" />',
		            '<input type="hidden" name="list[{index}].day_of_week" value="{4}" />',
		            '<input type="hidden" name="list[{index}].start_time" value="{5}" />',
		            '<input type="hidden" name="list[{index}].end_time" value="{6}" />',
		            '<input type="hidden" name="list[{index}].creator_id" value="{7}" />',
		            '<input type="hidden" name="list[{index}].id" value="{8}" />'].join(''),
		utmpl = '<input type="hidden" name="list[{index}].users[{uindex}].user_id" value="{0}" />',
		builder = new StringBuilder(),
		deptId = $('#dept_id').val(),
		year = $('#year').val(),
		month = $('#month').val();
		$('.td_item', context).each(function(index, item){
			var target = $(item), day = target.attr('day'),
			dayOfWeek = target.attr('day_of_week'),
			startTime = target.attr('start_time'),
			endTime = target.attr('end_time')
			itemId = target.attr('item_id');
			builder.appendFormat(tmpl.replace(/\{index\}/g, index), deptId, year, month, day, dayOfWeek, newDate(startTime), newDate(endTime), creatorId, itemId);
			
			$(item).find('input[name="user_id"]').each(function(subIndex, subItem){
				builder.appendFormat(utmpl.replace(/\{index\}/g, index).replace(/\{uindex\}/g, subIndex), subItem.value);
			}); 
		});
		
		$('#form_values').html(builder.toString()); 
		$('#data_form').submit();
		return false;
	}
	
	//清空指定年、月份的数据
	function clear(){
		var deptId = $('#dept_id').val(),
		year = $('#year').val(),
		month = $('#month').val();
		util.ajax({
			url: 'scheduling/clear.do',
			type: 'get',
			dataType: 'json',
			data: { year: year, month: month, dept_id: deptId, time: util.now() },
			success: function(result){
				if(result.flag){
					$('.td_item').each(function(index, item){
						$(item).removeAttr('item_id');
						$(item).find('.mail_input').html('');	
					});
					successMsg('清空成功！');
				}
			}
		});
	}
	
	return { init: init, getData: getData, remove: remove, save: save, changeDept: changeDept };
})();

// 部门用户树
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
        var jsonTree = eval('(' + $("#json_tree").html() + ')');
        $.fn.zTree.init($("#ztree_list"), setting, jsonTree);  
    } 
 	
    // 搜索
 	function search(){
 		 $.ajax({
 			url: 'scheduling/gettree.do',
 			type: 'post',
 			dataType: 'text',
 			data: { realName: $('#real_name').val(), deptId: $('#dept_id').val() },
 			success: function(data){ 
 				if(!util.isEmpty(data)){
 					$("#json_tree").html(data); 
 					init();
 				}
 			}
 		 });
 	}

 	return { init: init, search: search };
})();