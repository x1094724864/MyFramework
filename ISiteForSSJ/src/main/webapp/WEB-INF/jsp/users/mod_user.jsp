<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>
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
	<!--     内容      -->
	<div id="content" class="white">
		<h1>
			<img src="<%=request.getContextPath()%>/images/posts.png" alt="">用户管理——编辑用户信息
		</h1>
		<br> <br>
		<div class="bloc">
			<div class="title">用户信息</div>
			<div class="content">
				<form action="<%=request.getContextPath()%>/modifyUser"
					method="post">
					<table align="center">
						<thead>
							<tr>
								<td><input type="hidden" name="id" value="${user.id }" /></td>
								<td><input type="hidden" name="permission"
									value="${user.permission }"></td>
							</tr>
						</thead>
						<tr>
							<td><span class="item">用户名</span></td>
							<td><div class="input">
									<input type="text" name="username" value="${user.username}"
										tabindex="1" />
								</div></td>
						</tr>
						<tr>
							<td><span class="item">密码</span></td>
							<td><div class="input">
									<input type="text" name="password" value="${user.password}"
										tabindex="2" />
								</div></td>
						</tr>

						<tr>
							<td></td>
							<td><br>
								<div class="submit">
									<input style="position: relative; left: 20px;" type="submit"
										value="提交" tabindex="11" /><input
										style="position: relative; left: 50px;" type="reset"
										value="重置" />
								</div></td>
						</tr>

					</table>

				</form>

			</div>
		</div>
	</div>
	<div id="ui-datepicker-div"
		class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>



</body>
</html>