<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td {
		text-align: center;
	}
</style>
</head>
<body>
    
	<table align="center" border="1" width="50%">
		<caption>商品列表</caption>
		<tr>
			<td colspan="9">
				<a href="/product?cmd=edit">新增商品</a>
			</td>
		</tr>
		<tr style="background-color: orange;">
			<th>编号</th>
			<th>商品名称</th>
			<th>零售价</th>
			<th>商品分类</th>
			<th>供应商</th>
			<th>品牌</th>
			<th>折扣</th>
			<th>成本价</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${list}" var="product" varStatus="num">
			<tr style="background-color: ${num.count % 2 == 0 ? 'gray' : ''};">
				<td>${product.id}</td>
				<td>${product.productName}</td>
				<td>${product.salePrice}</td>
				<td>
					<c:choose>
						<c:when test="${product.dir_id == 2}">有线鼠标</c:when>
						<c:when test="${product.dir_id == 3}">无线鼠标</c:when>
						<c:otherwise>游戏鼠标</c:otherwise>
					</c:choose>
				</td>
				<td>${product.supplier}</td>
				<td>${product.brand}</td>
				<td>${product.cutoff}</td>
				<td>${product.costPrice}</td>
				<td align="center">
					<a href="/product?cmd=edit&id=${product.id}">编辑</a>
					<a href="/product?cmd=delete&id=${product.id}">删除</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>