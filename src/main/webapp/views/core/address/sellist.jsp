<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout> 
	<%-- <gd:Navgation addlink="" addr="通讯录 &gt; ${type==1?'内部通讯录':'外部通讯录' }"></gd:Navgation> --%>
	<div class="p_rel data_model colum_two clearfix">
     	<div class="frame_inner_left left_box" id="list">
     		<h2 class="inside_group">我的分组（<span id="total_count">${addressGroupList.size()+1}</span>）</h2>
			<ul class="list roleUl">
					<li class="child roleLi ${addressGroupList.size()==0 && empty group_id && empty is_share ?'cur':''}"  spanId="">默认组（<span class="child_count">${myCount}</span>）</li>
				<c:forEach items="${addressGroupList}" var="item" varStatus="vs">  
					<li class="child${item.id } roleLi ${(vs.index==0&& empty is_share && empty group_id) || (empty is_share && group_id==item.id)?'cur':''}" spanId="${item.id }">
					${item.name }（<span class="child_count">${item.acount}</span>）
					</li>
				</c:forEach>
			</ul>
			<h2 class="inside_group">分享</h2>
			<ul class="list roleUl">
					<li  class="roleLi share ${!empty is_share ?'cur':''}"  spanId="">默认组（<span class="child_count">${shareCount}</span>）</li>
			</ul>
        </div>
		<div class="rightbox pt10">
			<form id="spec_form" action="address/seldatalist.do"
						data-ajax="true" data-ajax-begin="loadBegin"
						data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
						data-ajax-loading="#loading_img" data-ajax-method="POST"
						data-ajax-mode="replace" data-ajax-update="#data_list"
						novalidate="novalidate">
		        <input type="hidden" name="type" id="type2" value="2" />
				<input type="hidden" name="is_share" id="is_share" value="${is_share }" />
				<input type="hidden" name="group_id" id="group_id" value="${group_id }" />
		        <input type="text" class="inp_t" name="keyword" id="keyword"  onkeyup="responseEnter(event);" value="" />
				<span class="ml10 btn btn_pub">
					<input type="submit" value="搜索" />
				</span>
				<span class="ml50 btn btn_pub">
					<input id="btn_save" type="button" value="保存" />
				</span>
				<span class="ml10 btn btn_base">
					<input type="button" id="btn_pclose" value="取消" />
				</span>
	     	</form>
	     	<div class="data_model wc100 data_list_wrap dt_query rbox_wrap" id="data_list" style="height:500px;overflow:scroll;">
			   
		 	</div>
	 	</div>
 	</div>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
<script type="text/javascript">

var nameArray=[],idArray=[];
var opener = art.dialog.open.origin;
    $(function () {
    	var selIds = null,selNames = null; 
    	//外部人员选择初始化
    	opener.$("#outerUser span").each(function(){
				var $item=$(this);
				idArray.push($item.attr("key_id"));
				nameArray.push($item.attr("key_name"));
		}); 
    	//我的分组初始化
		 Init();
		 //我的分组click事件
        $(".roleUl .roleLi").click(function () {
            var $this = $(this);
            $(".roleUl .roleLi").removeClass("cur");
            $this.addClass("cur");
            $("#is_share").val('');
            $("#group_id").val($this.attr("spanId"));
       		if($this.hasClass("share"))
     		{
       			$("#is_share").val('1');
     		}
            $("#spec_form").submit(); 
        });
        
    	$("#spec_form").submit();
			
		//通讯录click事件	
		$("#v_body .child_v").live("click",function(){
			var $this=$(this);
			if($this.hasClass("cur"))
			{
				$this.removeClass("cur");
				var i=arrayUtil.get(idArray,$this.attr("key_id"));
   				if(i!=-1)
 			    {
   					idArray=arrayUtil.removeByIndex(idArray,i);
   					nameArray=arrayUtil.removeByIndex(nameArray,i);
 			    }
			}else
			{
				$this.addClass("cur");
				idArray.push($this.attr("key_id"));
    			 	nameArray.push($this.attr("key_name"));
			}
		});
		
		//保存
		$("#btn_save").click(function(){ 
			var html="";
  				arrayUtil.each(idArray, function (index, item) {
  					if(html=="")
 					{
  						html="<span class='user_child' key_id='"+item+"' key_name='"+nameArray[index]+"'>"+nameArray[index]+"<em class='del_user'>&times;</em></span>"
 					}else
					{
 						html+="<span class='user_child' key_id='"+item+"' key_name='"+nameArray[index]+"'>"+nameArray[index]+"<em class='del_user'>&times;</em></span>"
					}
  				});
  				opener.$("#outerUser").html(html);
			closeDialog();
    	});
	});

    //在快速搜索中按回车触发的事件
    function responseEnter(e) {
        // 响应回车
        var key = window.event ? e.keyCode : e.which;
        if (key == 13) {
        	$("#spec_form1").submit();
        }

    } 

    //我的分组初始化
    function Init() {
        if ($(".roleUl .cur").length > 0) {
            var $item = $(".roleUl .cur");
            $("#group_id").val($item.attr("spanId"));
            
            $("#spec_form").submit();
        }
    }
    
    //匹配已选择通讯录
    function checkId()
    {
    	if(!util.isNull(idArray))
   		{
    		$("#v_body .child_v").each(function(){
    			var $this=$(this);
    			$.each(idArray,function(n,value){
       			if($this.attr("key_id")==value)
    			{
       				$this.addClass("cur");
    			}
       		 	});
    		});
    		 
   		}
    }
	    
	</script>
</gd:Layout>
