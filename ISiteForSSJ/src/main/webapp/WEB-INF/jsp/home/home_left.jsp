<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/jquery.wysiwyg.old-school.css">


<!-- jQuery AND jQueryUI -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/my_style.css">
</head>
<%
	Integer permission = (Integer) session.getAttribute("permission");
%>
<body>
	<!--      左侧菜单     -->
	<div id="sidebar">
		<ul>
			<li><a><img
					src="<%=request.getContextPath()%>/images/layout.png" alt="">部门管理</a>
				<ul>
					<li><a href="department/listDepart" target="right">所有部门</a></li>
					<li><a href="department/editDepart" target="right">添加部门</a></li>
					<li><a href="department/modDepart" target="right">修改部门</a></li>
					<li><a href="department/removeDepart" target="right">删除部门</a></li>
				</ul></li>
			<li><a>&nbsp;<img
					src="<%=request.getContextPath()%>/images/huser.png" alt="">员工管理
			</a>
				<ul>
					<li><a href="employee/listEmp" target="right">查看员工</a></li>
					<li><a href="employee/editEmp" target="right">添加员工</a></li>
					<li><a href="employee/modEmp" target="right">修改员工</a></li>
					<li><a href="employee/removeEmp" target="right">删除员工</a></li>
				</ul></li>
			<c:choose>
				<c:when test="<%=permission != null && permission >= 2%>">
					<li><a><img
							src="<%=request.getContextPath()%>/images/husers.png" alt="">用户管理</a>
						<ul>
							<li><a href="users/userList" target="right">用户列表</a></li>
							<li><a href="users/addUser" target="right">添加用户</a></li>
							<li><a href="users/userListByPermission" target="right">高于自己的权限用户不显示</a></li>
						</ul></li>
				</c:when>
				<c:otherwise>

				</c:otherwise>
			</c:choose>

		</ul>


	</div>
</body>
</html>