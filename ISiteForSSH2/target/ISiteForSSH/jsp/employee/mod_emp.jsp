<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
<link rel="stylesheet" href="../../css/style.css">
<link rel="stylesheet" href="../../css/jquery.wysiwyg.old-school.css">

<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../../js/min.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
<link rel="stylesheet" href="../../css/style2.css">
<!-- <link rel="stylesheet" href="../../css/base.css"> -->

<style>
a {
	text-decoration: none
}
</style>
</head>
<body>


	<!--     内容      -->
	<div id="content" class="white">
		<h1>
			<img src="../../images/posts.png" alt="">员工管理——修改员工信息
		</h1>
		<br> <br>
		<div class="bloc">
			<div class="title">员工列表</div>
			<div class="content">
				<form action="deleteAllDepart.action" method="post">
					<table align="center" border="1">
						<thead align="right">
							<tr>
								<!-- <th>选择</th> -->
								<th>员工编号</th>
								<th>员工姓名</th>
								<th>性别</th>
								<th>部门</th>
								<th>学历</th>
								<th>专业</th>
								<th>入职时间</th>
								<th>地址</th>
								<th>电话号码</th>
								<!-- <th>操作</th> -->
							</tr>
						</thead>
						<tbody>
							<c:forEach var="emp" items="${employeeList}" varStatus="vs">
								<tr>
									<td align="right">${emp.employee_id}</td>
									<td>${emp.name }</td>
									<td>${emp.gender }</td>
									<td>${emp.department }</td>
									<td>${emp.education }</td>
									<td>${emp.profession }</td>
									<td>${emp.entry_Time }</td>
									<td>${emp.address }</td>
									<td>${emp.tel_number }</td>
									<td>
										<button>
											<a href="modifyEmp.action?employee.id=${emp.id}">删除</a>
										</button>
									</td>

								</tr>
							</c:forEach>
						</tbody>
						<tfoot></tfoot>
					</table>
					<input type="submit" value="确认删除" />&nbsp;&nbsp;<input
						type="reset" value="取消删除">
				</form>

				<!-- <button> -->
				<a href="listDepart.action">获取所有</a>
				<!-- </button> -->



			</div>
		</div>
	</div>
	<div id="ui-datepicker-div"
		class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>
</body>
</html>