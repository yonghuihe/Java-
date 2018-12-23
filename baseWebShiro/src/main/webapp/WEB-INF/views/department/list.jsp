<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门列表</title>
</head>
<body>
<center>
	<h1>部门列表</h1>
	<shiro:hasPermission name="department:create">
		<a href="/department?cmd=input">新增</a>
	</shiro:hasPermission>
	<br>
	<table border="1">
		<tbody>
			<tr>
				<th>编号</th>
				<th>部门名称</th>
				<th></th>
			</tr>
			<tr>
				<td>1</td>
				<td>总经办</td>
				<td>
					<a href="/department?cmd=input&id=1">编辑</a>
					<a href="/department?cmd=delete">删除</a>
				</td>
			</tr>
		</tbody>
	</table>
</center>
</body>
</html>