<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改部门信息</title>
<link rel="stylesheet" href="../../css/style.css">
<link rel="stylesheet" href="../../css/jquery.wysiwyg.old-school.css">

<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../../js/min.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
<link rel="stylesheet" href="../../css/style2.css">
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
				<form action="saveEmp.action" method="post">
					<table align="center">
						<tr>
							<td><input type="hidden" name="employee.id"
								value="${employee.id }" /></td>
						</tr>
						
						<tr>
							<td>员工编号</td>
							<td><input type="text" name="employee.employee_id"
								value="${employee.employee_id }" /></td>
						</tr>
						<tr>
							<td>员工姓名</td>
							<td><input type="text" name="employee.name"
								value="${employee.name }" /></td>
						</tr>
						<tr>
							<td>性别</td>
							<td><input type="text" name="employee.gender"
								value="${employee.gender }" /></td>
						</tr>
						<tr>
							<td>部门</td>
							<td><input type="text" name="employee.department"
								value="${employee.department}" /></td>
						</tr>
						<tr>
							<td>学历</td>
							<td><input type="text" name="employee.education"
								value="${employee.education }" /></td>
						</tr>
						<tr>
							<td>专业</td>
							<td><input type="text" name="employee.profession"
								value="${employee.profession}" /></td>
						</tr>
						<tr>
							<td>入职时间</td>
							<td><input type="text" name="employee.entry_Time"
								value="${employee.entry_Time }" /></td>
						</tr>
						<tr>
							<td>地址</td>
							<td><input type="text" name="employee.address"
								value="${employee.address }" /></td>
						</tr>
						<tr>
							<td>电话号码</td>
							<td><input type="text" name="employee.tel_number"
								value="${employee.tel_number }" /></td>
						</tr>

						<tr>
							<td></td>
							<td><input type="submit" value="提交" />&nbsp;<input type="reset"
								value="重置" /></td>
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



	<%-- <div id="content" class="white">
		<form action="saveDepart.action" method="post">
			<table>
				<tr>
					<td><input type="hidden" name="department.id"
						value="${department.id }" /></td>
				</tr>
				<tr>
					<td><input type="text" name="department.id"
						value="${department.id }" /></td>
				</tr>
				<tr>
					<td>部门编号</td>
					<td><input type="text" name="department.department_num"
						value="${department.department_num }" /></td>
				</tr>
				<tr>
					<td>部门名称</td>
					<td><input type="text" name="department.department_name"
						value="${department.department_name }" /></td>
				</tr>
				<tr>
					<td>部门描述</td>
					<td><textarea rows="5" cols="21"
							name="department.department_desc"
							style="margin: 0px; width: 168px; height: 102px;"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="提交" /><input type="reset"
						value="重置" /></td>
				</tr>
			</table>
		</form>
	</div> --%>
</body>
</html>