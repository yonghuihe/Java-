<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/login" method="post" enctype="multipart/form-data">
		<input type="text" name="username">
		<input type="text" name="password">
		<input type="text" name="inputTime">
		<!-- <input type="file" name="img"> -->
		<input type="submit" value="登录">
	</form>
</body>
</html>