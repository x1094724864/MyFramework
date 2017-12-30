<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加新部门</title>
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
	<div id="content" class="white">
		<form action="saveEmp.action" method="post">
			<table>
				<tr>
					<td><input type="hidden" name="employee.id" /></td>
				</tr>
				<tr>
					<td>员工编号</td>
					<td><input type="text" name="employee.employee_id" /></td>
				</tr>
				<tr>
					<td>员工姓名</td>
					<td><input type="text" name="employee.name" /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input type="text" name="employee.gender" /></td>
				</tr>
				<tr>
					<td>部门</td>
					<td><input type="text" name="employee.department" /></td>
				</tr>
				<tr>
					<td>学历</td>
					<td><input type="text" name="employee.education" /></td>
				</tr>
				<tr>
					<td>专业</td>
					<td><input type="text" name="employee.profession" /></td>
				</tr>
				<tr>
					<td>入职时间</td>
					<td><input type="text" name="employee.entry_Time" /></td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="employee.address" /></td>
				</tr>
				<tr>
					<td>电话号码</td>
					<td><input type="text" name="employee.tel_number" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="提交" /><input type="reset"
						value="重置" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>