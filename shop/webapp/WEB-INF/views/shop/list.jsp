<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>购物车</h3>
	<a href="/shop.jsp">继续购物</a>
	<table border="1">
		<tr>
			<th>商品名称</th>
			<th>单价</th>
			<th>数量</th>
			<th>操作</th>
		</tr>
		<c:forEach var="item" items="${cart_in_session.list}">
			<tr>
				<td>${item.name}</td>
				<td>${item.salePrice}</td>
				<td>${item.num}</td>
				<td><a href="/shoppingcart?cmd=delete&id=${item.id}">删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">总价:${cart_in_session.totalPrice}</td>
		</tr>
	</table>
</body>
</html>