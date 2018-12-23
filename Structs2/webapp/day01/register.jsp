<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/pss/reg" method="post">
		<p>账号:<input type="text" name="username"/></p>
		<p>年龄:<input type="number" name="age"/></p>
		<p>爱好:
			<input type="checkbox" name="hobby" value="java"/>	Java
			<input type="checkbox" name="hobby" value="js"/> js
			<input type="checkbox" name="hobby" value="Data2"/> Data2
		</p>
		<input type="submit" value="朕要提交"/>
	</form>
</body>
</html>