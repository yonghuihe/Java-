
<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/money" method="post">
<%
	//准备一个随机值
	String token = UUID.randomUUID().toString();
	//把该值放入session中,用于校验使用
	session.setAttribute("token_in_session", token);
%>
	<input type="hidden" name="token" value="<%=token%>"/>
	转出金额:<input type="number" name="money" required/>
	<input type="submit" value="确定"/>
</form>
</body>
</html>