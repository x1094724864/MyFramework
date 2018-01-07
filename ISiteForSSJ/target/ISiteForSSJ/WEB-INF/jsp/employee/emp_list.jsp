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

<style type="text/css">
a {
	text-decoration: none
}

</style>
</head>
<body>


	<!--     内容      -->
	<div id="content" class="white">
		<h1>
			<img src="<%=request.getContextPath() %>/images/posts.png" alt="">员工管理
		</h1>
		<br> <br>
		<div class="bloc">
			<div class="title">员工列表</div>
			<div class="content">
				<form action="" method="post">
					<table align="center">
						<thead>
							<tr>
								<!-- <th>选择</th> -->
								<th>员工编号</th>
								<th>员工姓名</th>
								<th>性别</th>
								<th>部门</th>
								<!-- <th>学历</th>
								<th>专业</th> -->
								<th>入职时间</th>
								<!-- <th>地址</th>
								<th>电话号码</th> -->
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="emp" items="${employeeList}" varStatus="vs">
								<tr>
									<td align="right">${emp.employee_id}</td>
									<td>${emp.name }</td>
									<td>${emp.gender }</td>
									<td>${emp.departmentName }</td>
									<%-- <td>${emp.education }</td>
									<td>${emp.profession }</td> --%>
									<td>${emp.entry_Time }</td>
									<%-- <td>${emp.address }</td>
									<td>${emp.tel_number }</td> --%>
									<td><a href="<%=request.getContextPath() %>/detailsEmp?id=${emp.id}">详细信息</a></td>
								</tr>
							</c:forEach>
						</tbody>
						<tfoot></tfoot>
					</table>

				</form>

				<button>
					<a href="listEmp">获取所有</a>
				</button>
				<form action="listEmpPage" method="post">
					<input type="hidden" name="depart.id" value="${depart.id}" /> <input
						type="hidden" name="depart.departmentNum"
						value="${depart.departmentNum}" /> <input type="hidden"
						name="depart.departmentName" value="${depart.departmentName}" />
					<input type="hidden" name="depart.department_desc"
						value="${depart.department_desc}" />
					<table align="center" border="0" cellspacing="0" width="680">
						<tr align="center">
							<td align="center">
								共${pager.recordCount}条记录&nbsp;&nbsp;每页显示${pager.pageSize}条&nbsp;&nbsp;第${pager.currentPage}页/共${pager.pageCount}页
								<a style="cursor: pointer; text-decoration: underline;" href="listEmpPage?requestPage=${pager.firstPage}">«</a>
								<a style="cursor: pointer; text-decoration: underline;" href="listEmpPage?requestPage=${pager.priviousPage}">Privious</a> 
								<a style="cursor: pointer; text-decoration: underline;" href="listEmpPage?requestPage=${pager.nextPage}">Next</a> 
								<a style="cursor: pointer; text-decoration: underline;" href="listEmpPage?requestPage=${pager.lastPage}">»</a> 
								<input style="text-align: center; border: 1px solid #CCCCCC;" type="text" name="requestPage" onchange="this.value=(new RegExp('^[0-9]*$').test(this.value)) ? this.value : 1"
								value="${requestPage}" size="2" /> 
								<input type="submit" value="go" />
							</td>
						</tr>
					</table>


					<div class="pagination">
						<a href="listEmpPage?requestPage=${pager.firstPage}" class="prev">«</a>
						<%-- <a href="listEmpPage?requestPage=${pager.firstPage}">${pager.firstPage}</a>  --%>
						<a href="listEmpPage?requestPage=${pager.priviousPage-1}">${pager.priviousPage-1}</a> 
						<a href="listEmpPage?requestPage=${pager.priviousPage}">${pager.priviousPage}</a> 
						<a href="listEmpPage?requestPage=${pager.currentPage}" class="current">${pager.currentPage}</a>
						<a href="listEmpPage?requestPage=${pager.nextPage}">${pager.nextPage}</a>
						<a href="listEmpPage?requestPage=${pager.nextPage+1}">${pager.nextPage+1}</a>
						<%-- <a href="listEmpPage?requestPage=${pager.lastPage}">${pager.lastPage-1}</a> --%>
						<a href="listEmpPage?requestPage=${pager.lastPage}" class="next">»</a>
					</div>
				</form>

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
		<br><br><br><br><br><br><br><br>
</body>
</html>