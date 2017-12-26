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
	<div id="content" class="white">
		<form action="saveDepart.action" method="post">
			<table>
				<tr>
					<td><input type="hidden" name="department.id"
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
	</div>
</body>
</html>