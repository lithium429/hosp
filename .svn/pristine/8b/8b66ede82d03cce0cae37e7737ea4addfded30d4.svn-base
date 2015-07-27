<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<table class="wc100 view_data">
    <thead>
    	<tr>
	        <th class="check w3per">
	            <input type="checkbox" id="check_all" class="inp_analog" /><span class="icon ico-checkbox"></span>
	        </th>
			<th class="w25per">书籍名称</th>
			<th class="w40per">一维编码</th>
			<th class="">封面图片</th>
	  	</tr>
    </thead>
   	<tbody>
		<c:forEach items="${list}" var="item" varStatus="vs">  
           	<tr >
				<td class="check w3per">
                	<input type="checkbox" name="bookId"  class="inp_analog batch bookId" value="${item.id}" /><span
	                    class="icon ico-checkbox"></span>
	            </td>
	            <td>
	            	${item.name}
	            </td>
	            <td>
	            	${item.code}
	            </td>
	            <td>
	            	<img id="img4" class="img4" width="59px" height="83px" src="<c:if test="${empty item.image_url}">static/images/emptyImage.jpg</c:if><c:if test="${!empty item.image_url}">${item.image_url}</c:if>">
	            </td>
			</tr>            
		</c:forEach>
        	<c:if test="${empty list}">
			<tr>
	        	<td colspan="4" class="t_c">
	                <span class="no-records">暂无数据</span>
	            </td>
	        </tr>
       	</c:if>
   	</tbody>
   </table>