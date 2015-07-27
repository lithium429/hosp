<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<gd:Layout> 
	<gd:Navgation addShow="${gdf:judgeRoleMenu(roleMenuList,'添加')&& type!=1 }" addlink="address/add.do?type=${type}" addr="通讯录 &gt; ${type==1?'内部通讯录':'外部通讯录' }"></gd:Navgation>
	<div class="p_rel data_model colum_two clearfix">
		<form id="spec_form" action="address/datalist1.do"
						data-ajax="true" data-ajax-begin="loadBegin"
						data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
						data-ajax-loading="#loading_img" data-ajax-method="POST"
						data-ajax-mode="replace" data-ajax-update="#list"
						novalidate="novalidate">
		        <input type="hidden" name="type" id="type1" value="${type}" />
				<input type="hidden" name="is_share" id="is_share1" value="" />
				<input type="hidden" name="dept_id" id="dept_id1" value="" />
				<input type="hidden" name="group_id" id="group_id1" value="" />
		        <input type="hidden" name="menu_id" id="menu_id1" value="${menu_id}" />
		        <input type="hidden" name="list_type" id="list_type" value="1" />
		        
	    </form>
     	<div class="frame_inner_left left_box" id="list">
        </div>
		<div class="rightbox pt10">
			<form id="spec_form1" action="address/datalist.do"
						data-ajax="true" data-ajax-begin="loadBegin"
						data-ajax-failure="loadFailure" data-ajax-failure="loadComplete"
						data-ajax-loading="#loading_img" data-ajax-method="POST"
						data-ajax-mode="replace" data-ajax-update="#data_list"
						novalidate="novalidate">
		        <input type="hidden" name="menu_id" id="menu_id" value="${menu_id}" />
		        <input type="hidden" name="type" id="type2" value="${type}" />
				<input type="hidden" name="is_share" id="is_share" value="${is_share }" />
				<input type="hidden" name="dept_id" id="dept_id" value="${dept_id }" />
				<input type="hidden" name="group_id" id="group_id" value="${group_id }" />
		        <input type="text" class="inp_t" name="keyword" id="keyword" placeholder="搜索联系人..." onkeyup="responseEnter(event);" value="" />
		        <span class="btn btn_pub ml8">
				<input type="submit" id="btn_search" value="搜索" />
			</span>
	     	</form>
	     	<div class="data_model wc100 data_list_wrap dt_query rbox_wrap" id="data_list" style="height:500px;overflow:scroll;">
			   
		 	</div>
	 	</div>
 	</div>
	<img class="dn" id="loading_img" src="static/img/loading.gif" alt="loading" /> 
	<script type="text/javascript" src="static/js/index.js"></script>
<script type="text/javascript">
var type=$("#type1").val();
    $(function () {
        
        $(".roleUl .roleLi").live("click", function () {
            var $this = $(this);
            $(".roleUl .roleLi").removeClass("cur");
            $this.addClass("cur");
            if(type==1)
           	{
                $("#group_id,#is_share").val('');
                $("#dept_id").val($this.attr("spanId"));
           	}else
        	{
                $("#dept_id,#is_share").val('');
                $("#group_id").val($this.attr("spanId"));
           		if($this.hasClass("share"))
         		{
           			$("#is_share").val('1');
         		}
        	}
            $("#spec_form1").submit(); 
        });
        
    		$("#spec_form").submit();
			// 添加分组
			$('#btn_add1').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url:url,
					id:'add_page',
					title:'添加分组',
					width:'400px',
					height:'120px'
				});
				return false;
			});
			
			// 添加联系人
			$('#btn_add').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url:url,
					id:'add_page',
					title:'添加分组',
					width:'900px',
					height:'450px'
				});
				return false;
			});
			
			//发送邮件
			$('.send_email').live('click', function() {
				var url = $(this).attr('href');
				openPage({
					url : url,
					id : 'send_email',
					title : '写邮件 ',
					width : '90%',
					height : '80%'
					
				});
				return false;
			}); 
			
			//发送短信
			$('.send_sms').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url:url,
					id:'send_sms',
					title:'发送短信',
					width : '90%',
					height : '80%'
				});
				return false;
			});
			
			// 修改
			$('.update').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url:url,
					id:'update_page',
					title:'修改分组',
					width:'400px',
					height:'120px'
				});
				return false;
			});
			
			// 共享
			$('.share').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url:url,
					id:'share_page',
					title:'共享',
					width:'600px',
					height:'200px'
				});
				return false;
			});
			
			// 移动
			$('.move').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url:url,
					id:'move_page',
					title:'移动',
					width:'400px',
					height:'120px'
				});
				return false;
			});
			
			// 修改
			$('.update_lik').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url:url,
					id:'update_page',
					title:'修改联系人',
					width:'900px',
					height:'450px'
				});
				return false;
			});
			
			// 查看
			$('.view_lik').live('click',function(){
				var url = $(this).attr('href');
				openPage({
					url:url,
					id:'view_page',
					title:'查看联系人',
					width:'680px',
					height:'500px'
				});
				return false;
			}); 
			
			$(".delete_group").live('click',function(){
				var $this=$(this);
				util.easyAjaxRequest_all("该分组删除后,分组中的联系人均移动至默认组,您确定要删除分组？",$this,"删除成功","spec_form");
				return false;
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
	    
	</script>
</gd:Layout>
