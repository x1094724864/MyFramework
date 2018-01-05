<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@page import="com.lx.entity.Department"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改部门信息</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.wysiwyg.old-school.css">

<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/main.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/style2.css">
</head>
<%-- <%
Department department= ModelAttribute.s
%> --%>

<body>
	<!--     内容      -->
	<div id="content" class="white">
		<h1>
			<img src="<%=request.getContextPath() %>/images/posts.png" alt="">部门管理——编辑部门信息
		</h1>
		<br> <br>
		<div class="bloc">
			<div class="title">部门列表</div>
			<div class="content">
				<form action="saveDepart" method="post">
					<table align="center">
						<tr>
							<td colspan="2"><input type="hidden" name="id"
								value="${department.id }" /></td>
						</tr>
						<tr>
							<td><span class="title">部门编号</span></td>
							<td><input type="text" name="departmentNum"
								value="${department.departmentNum}" tabindex="1" /></td>
						</tr>
						<tr>
							<td><span class="title">部门名称</span></td>
							<td><input type="text" name="departmentName"
								value="${department.departmentName }" tabindex="2" /></td>
						</tr>
						<tr>
							<td><span class="title">部门描述</span></td>
							<td><textarea rows="5" cols="21"
									name="department_desc"
									style="resize:none; margin: 0px; width: 160px; height: 100px; padding-right: 0px; border-right-width: 1px; padding-left: 0px; border-left-width: 1px;"
									value="${department.department_desc }" tabindex="3"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="提交" tabindex="4" />&nbsp;&nbsp;<input
								type="reset" value="重置" /></td>
						</tr>

					</table>

				</form>

				<!-- <button>
					<a href="modDepart.action">获取所有</a>
				</button> -->


			</div>
		</div>
	</div>
	<div id="ui-datepicker-div"
		class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>



</body>
</html>