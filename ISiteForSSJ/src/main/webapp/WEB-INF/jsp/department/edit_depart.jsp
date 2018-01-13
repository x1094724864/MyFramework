<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@page import="com.lx.entity.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改部门信息</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/style.css">
<%-- <link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.wysiwyg.old-school.css"> --%>

<!-- jQuery AND jQueryUI -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/add_department.js"></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/my_style.css">
</head>

<body>
	<!--     内容      -->
	<div id="content" class="white">
		<h1>
			<img src="<%=request.getContextPath()%>/images/posts.png" alt="">部门管理——编辑部门信息
		</h1>
		<br> <br>
		<div class="bloc">
			<div class="title">部门信息</div>
			<div class="content">
				<!-- <form action="department/saveDepart" method="post"> -->
				<form action="" method="post">
				<table align="center">
					<thead>
						<tr>
							<td colspan="2"><input type="hidden" name="id"
								value="${department.id }" /></td>
						</tr>
					</thead>
					<tr>
						<td><span class="item">部门编号</span></td>
						<td><div class="input">
								<input type="text" name="departmentNum" id="departmentNum"
									value="${department.departmentNum}" tabindex="1"
									onblur="checkDepartNum()" />
							</div></td><td><span id="depart_num_span"></span></td>
					</tr>
					<tr>
						<td><span class="item">部门名称</span></td>
						<td><div class="input">
								<input type="text" name="departmentName" id="departmentName"
									value="${department.departmentName }" tabindex="2"
									onblur="checkDepartName()" />
							</div></td><td><span id="depart_name_span"></span></td>
					</tr>
					<!-- <tr>
						<td><span class="item">时间测试</span></td>
						<td><div class="input">
								<input type="text" class="datepicker" /><span
									id="depart_name_span"></span>
							</div></td>
					</tr> -->

					<tr>
						<td><span class="item">部门描述</span></td>
						<td><div class="input">
								<textarea rows="5" cols="21" name="department_desc"
									id="department_desc" onblur="checkDepartDesc()"
									value="${department.department_desc }" tabindex="3"></textarea>
								
							</div></td><td><span id="depart_desc_span"></span></td>
					</tr>
					<tr>
						<td></td>
						<td><br>
							<div class="submit">
								<input type="submit" value="提交" tabindex="11"
									onclick="saveDepart()" /><input
									style="position: relative; left: 50px;" type="reset" value="重置" />
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