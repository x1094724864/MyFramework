<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
	<h2>Hello World!</h2>
	<h1>index</h1>

<%-- 	<%
		response.sendRedirect("tosign_in");
	%> --%>
	<a href="<%=request.getContextPath()%>/tosign_in">登陆</a>
	<a href="tosign_up">注册</a>
	<a href="users/userList">用户列表</a>
	<a href="department/depart_list">所有部门</a>
	<a href="<%=request.getContextPath()%>/hello">hello</a>
	<a href="<%=request.getContextPath()%>/pageable">pageable</a>
	<a href="<%=request.getContextPath()%>/getall">getall</a>

</body>
</html>
