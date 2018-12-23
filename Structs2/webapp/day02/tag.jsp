<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form namespace="/pss" action="tag">
		<p>用户名:<s:textfield name="username"/></p>
		<p>性别:<s:radio list="#{'1':'man', '2':'woman'}" name="gender"/></p>
		<p>兴趣:<s:checkboxlist list="#{'java':'Java','js':'JS'}" name="check"/></p>
		<p>城市:<s:select list="#{'020':'广州','010':'北京'}"  name="select" headerKey="-1" headerValue="--请选择--"/></p>
		<s:submit value="提交"/>
	</s:form>

	<%-- <s:debug/>
	<hr/>
	<h3>需求:值大于5的显示5,等于5的显示等于5,其他的显示小于5</h3>
	<s:if test="#num >5 ">大于5</s:if>
	<s:elseif test="#num == 5">等于5</s:elseif>
	<s:else>小于5</s:else>
	<hr/>
	<s:iterator value="#list" var="u">
		<p>id:<s:property value="#u.id"/>-name:<s:property value="#u.name"/>-salary:<s:property value="#u.salary"/></p> 
		<p>id:<s:property value="id"/>-name:<s:property value="name"/>-salary:<s:property value="salary"/></p>
	</s:iterator>--%>
</body>
</html>