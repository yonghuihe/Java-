<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:debug/>
	<hr/>
	<h3>从root中取值,直接写属性名称</h3>
	<s:property value="name"/>
	<h3>从context中取值,需要加上#</h3>
	<s:property value="#age"/>
	<s:property value="#list"/>
	<s:property value="#list[1]"/>
</body>
</html>