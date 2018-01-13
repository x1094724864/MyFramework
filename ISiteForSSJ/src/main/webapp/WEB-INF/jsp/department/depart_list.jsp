<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理系统</title>
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
			<img src="<%=request.getContextPath()%>/images/posts.png" alt="">部门管理
		</h1>
		<br> <br>
		<div class="bloc">
			<div class="title">部门列表</div>
			<div class="content">
				<form action="" method="post">
					<table align="center">
						<thead>
							<tr>
								<!-- <th>选择</th> -->
								<th style="width: 90px;">部门编号</th>
								<th style="width: 200px;">部门名称</th>
								<th style="width: 350px; align-content: right:;" align="center">部门描述</th>
								<th style="width: 200px;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="depart" items="${departmentList}" varStatus="vs">
								<tr>
									<td>${depart.departmentNum}</td>
									<td>${depart.departmentName}</td>
									<td style="size: 5">${depart.department_desc}</td>
									<td><a href="<%=request.getContextPath()%>/employee/listEmpByDepart?id=${depart.id}">查看部门员工</a></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot></tfoot>
					</table>
<br>
				</form>

				<form action="listDepart" method="post">
					<table align="center" border="0" cellspacing="0" width="680">
						<tr align="center">
							<td align="center">
								共${pager.recordCount}条记录&nbsp;&nbsp;每页显示${pager.pageSize}条&nbsp;&nbsp;第${pager.currentPage}页/共${pager.pageCount}页
								<a style="cursor: pointer; text-decoration: underline;" href="listDepart?requestPage=${pager.firstPage}">«</a>
								<a style="cursor: pointer; text-decoration: underline;" href="listDepart?requestPage=${pager.priviousPage}">Privious</a> 
								<a style="cursor: pointer; text-decoration: underline;" href="listDepart?requestPage=${pager.nextPage}">Next</a> 
								<a style="cursor: pointer; text-decoration: underline;" href="listDepart?requestPage=${pager.lastPage}">»</a> 
								<input style="text-align: center; border: 1px solid #CCCCCC;" type="text" name="requestPage" onchange="this.value=(new RegExp('^[0-9]*$').test(this.value)) ? this.value : 1"
								value="${param.requestPage}"  size="2" /> 
								<input type="submit" value="go" />
							</td>
						</tr>
					</table>


					<div class="pagination">
						<a href="department/listDepart?requestPage=${pager.firstPage}" class="prev">«</a>
						<a href="department/listDepart?requestPage=${pager.firstPage}">1</a> <a
							href="http://www.grafikart.fr/demo/coreadmin/index.php?p=table#"
							class="current">2</a> ... <a
							href="http://www.grafikart.fr/demo/coreadmin/index.php?p=table#">21</a>
						<a
							href="http://www.grafikart.fr/demo/coreadmin/index.php?p=table#">22</a>
						<a href="department/listDepart?requestPage=${pager.lastPage}"
							class="next">»</a>
					</div>
				</form>




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
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>