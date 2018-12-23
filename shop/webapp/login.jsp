<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeImg(ele){
		ele.src = "/randomCode?"+new Date().getTime();
	}
</script>
</head>
<body>
	<%
		/* 	session.invalidate();//销毁session */
	%>
	<h3>用户登录</h3>
	<span style="color: red">${errorMsg}</span>
	<form action="/login" method="post">
		账号:
		<input type="text" name="username" />
		<br />
		<!-- 密码:<input type="password" name="password"/> -->
		验证码:
		<input type="text" name="randomCode" />
		<img style="cursor: pointer;" src="/randomCode" title="看不清,换一张" onclick="changeImg(this)">
		<br />
		<input type="submit" value="登录" />
	</form>
</body>
</html>