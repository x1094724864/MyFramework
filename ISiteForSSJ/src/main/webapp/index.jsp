<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<h1>index</h1>

<%-- <%
response.sendRedirect("/home");
%> --%>
<a href="login">登陆</a>
<a href="department/depart_list">所有部门</a>
<a href="<%=request.getContextPath()%>/hello">hello</a>

</body>
</html>
