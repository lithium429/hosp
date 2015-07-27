/** 
 *  请假
 */
var leaveInfo = (function(){
	function complete(taskId, variables, func){
	    var keyArray = [], valueArray = [], typeArray = [];
		if (variables) {
			$.each(variables, function() {
				keyArray.push(this.key);
				valueArray.push(this.value);
				typeArray.push(this.type);
			});
		} 
		
		// 发送任务完成请求
		util.ajax({
			url: 'leaveInfo/complete.do',
			type: 'post',
			dataType: 'json',
			data: { taskId: taskId, keys: keyArray.join(','), values: valueArray.join(','), types: typeArray.join(',') },
			success: function(result){
				if(result.flag){
					successMsg(result.msg ? result.msg : '操作成功！', function(){
						if(!util.isNull(func)){
							func();
						}
					});
				}
				else {
					errorMsg(result.msg ? result.msg : "操作失败！");
				}
			}
		});
	} 

	return {
		complete: complete 
	};
})();

