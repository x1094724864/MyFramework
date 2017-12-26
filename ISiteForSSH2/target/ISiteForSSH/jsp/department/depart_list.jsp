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
			<img src="../../images/posts.png" alt="">部门管理
		</h1>
		<br> <br>
		<div class="bloc">
			<div class="title">部门列表</div>
			<div class="content">
				<form action="" method="post">
					<table align="center">
						<thead>
							<tr>
								<th>选择</th>
								<th>部门编号</th>
								<th>部门名称</th>
								<th>部门描述</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="depart" items="${departmentList}" varStatus="vs">
								<tr>
									<td><input type="checkbox" name="ids" value="${depart.id}" /></td>
									<td>${depart.department_num}</td>
									<td>${depart.department_name}</td>
									<td>${depart.department_desc}</td>
									<td><button>
											<a href="editDepart.action?id=${depart.id}">修改</a>
										</button>
										<button>
											<a href="deleteDepart.action?id=${depart.id}">删除</a>
										</button></td>

								</tr>
							</c:forEach>
						</tbody>
						<tfoot></tfoot>
					</table>

				</form>

				<button>
					<a href="listDepart.action">获取所有</a>
				</button>


				<!-- <div class="left input">
					<div class="selector" id="uniform-tableaction">
						<span>全部</span> <select name="action" id="tableaction"
							style="opacity: 0;">
							<option value="">全部</option>
							<option value="">已审核</option>
							<option>审核中</option>
							<option>未处理</option>
						</select>
					</div>
				</div> -->
				<!-- <div class="pagination">
					<a href="http://www.grafikart.fr/demo/coreadmin/index.php?p=table#"
						class="prev">«</a> <a
						href="http://www.grafikart.fr/demo/coreadmin/index.php?p=table#">1</a>
					<a href="http://www.grafikart.fr/demo/coreadmin/index.php?p=table#"
						class="current">2</a> ... <a
						href="http://www.grafikart.fr/demo/coreadmin/index.php?p=table#">21</a>
					<a href="http://www.grafikart.fr/demo/coreadmin/index.php?p=table#">22</a>
					<a href="http://www.grafikart.fr/demo/coreadmin/index.php?p=table#"
						class="next">»</a>
				</div> -->
			</div>
		</div>
	</div>
	<div id="ui-datepicker-div"
		class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>
</body>
</html>