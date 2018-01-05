<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.wysiwyg.old-school.css">

<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style2.css">

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
			<img src="<%=request.getContextPath() %>/images/posts.png" alt="">员工管理——修改员工信息
		</h1>
		<br> <br>
		<div class="bloc">
			<div class="title">员工列表</div>
			<div class="content">
				<form action="" method="post">
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
									<td>${emp.departmentName }</td>
									<td>${emp.education }</td>
									<td>${emp.profession }</td>
									<td>${emp.entry_Time }</td>
									<td>${emp.address }</td>
									<td>${emp.tel_number }</td>
									<td>
										<button>
											<a href="editEmp?id=${emp.id}">修改</a>
										</button>
									</td>

								</tr>
							</c:forEach>
						</tbody>
						<tfoot></tfoot>
					</table>
				</form>

				<!-- <button> -->
				<!-- <a href="listDepart.action">获取所有</a> -->
				<!-- </button> -->



			</div>
		</div>
	</div>
	<div id="ui-datepicker-div"
		class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>
</body>
</html>