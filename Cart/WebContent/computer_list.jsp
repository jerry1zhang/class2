<%@page import="entity.computer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<title>computer_list Page</title>
</head>
<body>
<table class="table">
	<thead>
		<tr>
			<th>类型</th>
			<th>图片</th>
			<th>说明</th>
			<th>价格</th>
			<th>操作</th>
		</tr>
	</thead>
	<tbody>
	<%
		List<computer> list = (List<computer>)request.getAttribute("list");
		if(list!=null){
			for(computer c : list){
	%>
		<tr>
			<td><%=c.getType()%></td>
			<td><img src="<%=c.getPic()%>"></td>
			<td><%=c.getc_desc()%></td>
			<td>￥<%=c.getPrice()%></td>
			<td><a href="joinCart.do?id=<%=c.getC_id() %>">加入购物车</a></td>
		</tr>
	<%
			}
		}else{
	%>
	<tr>
		<td colspan="5">暂无数据</td>
	</tr>
	<%
		}
	%>
	<tr>
		<td colspan="5" style="float: right;"><a href="cartList.do">进入购物车</a></td>
	</tr>
	</tbody>
</table>
</body>
</html>