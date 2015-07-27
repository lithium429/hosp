<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<%@ attribute name="current_plate_id" type="java.lang.Integer"%> 
<div id="sd_bdl" class="bdl" style="width:130px;margin-left:-145px">
	<!--[diy=diyleftsidetop]--><div id="diyleftsidetop" class="area"></div><!--[/diy]-->
	<div class="tbn" id="forumleftside"><h2 class="bdl_h">版块导航</h2>
		<c:if test="${!empty plateList}">
			<c:forEach var="leftItem" items="${plateList}">
				<c:if test="${leftItem.layer == 1}">
					<dl id="lf_${leftItem.id}">
						<dt><a href="javascript:void(0);" hidefocus="true" onclick="forumPlate.toggleLeft('#lf_${leftItem.id}')" title="${leftItem.name}">${leftItem.name}</a></dt>
						<c:forEach var="leftSubItem" items="${plateList}">
							<c:if test="${leftSubItem.parent_id == leftItem.id}">
								<dd <c:if test="${leftSubItem.id == current_plate_id}">class="bdl_a"</c:if>>
									<a href="forum/list/${leftSubItem.id}.shtml" title="${leftSubItem.name}">${leftSubItem.name}</a>
								</dd>
							</c:if>
						</c:forEach>
					</dl>
				</c:if>
			</c:forEach>
		</c:if> 
	</div>
	<!--[diy=diyleftsidebottom]--><div id="diyleftsidebottom" class="area"></div><!--[/diy]-->
</div>
<script type="text/javascript">
	$(function(){
		forumPlate.initLeft();
	});
</script>