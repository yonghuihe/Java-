<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/shoppingcart" method="post">
		商品:
		<select name="id">
			<option value="1">苹果表</option>
			<option value="2">外星人</option>
			<option value="3">mac pro</option>
		</select><br/>
		数量:<input type="text" name="num" required min="1"/><br/>
		<input type="submit" value="加入购物车"/>
	</form>
</body>
</html>