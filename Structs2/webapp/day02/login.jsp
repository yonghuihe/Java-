<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>用户登录</h3>
	<s:form namespace="/pss" action="login">
		<p>账号:<s:textfield name="username"/></p>
		<p>密码:<s:password name="password"/></p>
		<s:submit value="朕要登录"/>
	</s:form>
</body>
</html>