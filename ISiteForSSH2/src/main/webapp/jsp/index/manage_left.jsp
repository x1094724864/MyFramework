<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>后台管理</title>
<link rel="stylesheet" href="../../css/style.css" />
<link rel="stylesheet" href="../../css/jquery.wysiwyg.old-school.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../../js/min.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
<link rel="stylesheet" href="../../css/style2.css" />
</head>
<body>
	<!--      左侧菜单     -->
	<div id="sidebar">
		<ul>
			<li><a><img src="../../images/layout.png" alt="">部门管理</a>
				<ul>
					<li><a href="listDepart.action" target="right">所有部门</a></li>
					<li><a href="editDepart.action" target="right">添加部门</a></li>
					<li><a href="modDepart.action" target="right">修改部门</a></li>
					<li><a href="removeDepart.action" target="right">删除部门</a></li>
				</ul></li>
			<li><a><img src="../../images/huser.png" alt="">员工管理</a>
				<ul>
					<li><a href="" target="right">添加员工</a></li>
					<li><a href="" target="right">修改员工</a></li>
					<li><a href="" target="right">查看员工</a></li>
					<li><a href="" target="right">删除员工</a></li>
				</ul></li>

		</ul>


	</div>
</body>
</html>