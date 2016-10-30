<%@page import="entity.computer"%>
<%@page import="entity.CartItem"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
    $(function(){
        $('.body').on('blur','input',function(){
        	var id = $(this).attr("name");
        	var num = $(this).val();
        	$.ajax({
				type: 'POST',
				url: 'change.do?id='+id+'&num='+num,
				success: function(data){
					window.location.href = window.location.href;
				},
				
			});
        })
    });
</script>
<title>cart list page</title>
</head>
<body>
<table class="table">
	<thead>
		<tr>
			<th>类型</th>
			<th>图片</th>
			<th>说明</th>
			<th>价格</th>
			<th>数量</th>
			<th>总价</th>
		</tr>
	</thead>
	<tbody class="body">
	<%
		List<CartItem> list = (List<CartItem>)request.getAttribute("list");
		//String zongjia = request.getParameter("zongjia");
		if(list!=null){
			for(CartItem c : list){
	%>
		<tr>
			<td><%=((computer)c.getHuowu()).getType() %></td>
			<td><img src="<%=((computer)c.getHuowu()).getPic() %>"></td>
			<td><%=((computer)c.getHuowu()).getc_desc() %></td>
			<td>￥<%=((computer)c.getHuowu()).getPrice() %></td>
			<td><input type="text" name="<%=((computer)c.getHuowu()).getC_id() %>" class="shuzhishuru" value="<%=c.getNum() %>"></td>
			<td class="jijia"><%=c.getZongjia() %></td>
		</tr>
		<%} %>
		<tr>
			<td class="zhongjia" colspan="6">￥${zongjia }</td>
		</tr>
	<%
			
		}else{
	%>
	<tr>
		<td colspan="6">暂无数据</td>
	</tr>
	<%
		}
	%>
	</tbody>
</table>
</body>
</html>