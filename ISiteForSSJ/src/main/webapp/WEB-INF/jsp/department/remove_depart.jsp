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
			<img src="<%=request.getContextPath()%>/images/posts.png" alt="">部门管理——删除部门信息
		</h1>
		<br> <br>
		<div class="bloc">
			<div class="title">部门列表</div>
			<div class="content">
				<form action="<%=request.getContextPath()%>/deleteDepartByIds" method="post">
					<table align="center" border="1">
						<thead align="right">
							<tr align="right">
								<th style="width: 50px;" align="center">选择</th>
								<th style="width: 90px;">部门编号</th>
								<th style="width: 200px;">部门名称</th>
								<th style="width: 350px; align-content: right:;" align="center">部门描述</th>
								<th style="width: 90px;">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="depart" items="${departmentList}" varStatus="vs">
								<tr>
									<td><input type="checkbox" name="depart_ids"
										value="${depart.id}" /></td>
									<td>${depart.departmentNum}</td>
									<td>${depart.departmentName}</td>
									<td>${depart.department_desc}</td>
									<td>
										<button>
											<a href="<%=request.getContextPath()%>/deleteDepart?id=${depart.id}">删除</a>
										</button>
									</td>

								</tr>
							</c:forEach>
						</tbody>
						<tfoot></tfoot>
					</table>
					<input type="submit" value="确认删除" /><input type="reset"
						value="取消删除">
				</form>


<table  align="center" border="0" cellspacing="0" width="680">
	<tr>
		<td align="center">
			共${pager.recordCount}条记录    每页显示${pager.pageSize}条    分${pager.pageCount}页/第${pager.currentPage}页
		   	 <a style="cursor:pointer;text-decoration: underline;" href="listDepart.action?requestPage=${pager.firstPage}">首页</a>
		   	 <a style="cursor:pointer;text-decoration: underline;" href="listDepart.action?requestPage=${pager.priviousPage}">上一页</a>
		   	 <a style="cursor:pointer;text-decoration: underline;" href="listDepart.action?requestPage=${pager.nextPage}">下一页</a>
		   	 <a style="cursor:pointer;text-decoration: underline;" href="listDepart.action?requestPage=${pager.lastPage}">尾页</a>
		   	 <input style="text-align:center;border: 1px solid #CCCCCC;" type="text" name="requestPage" onchange="this.value=(new RegExp('^[0-9]*$').test(this.value)) ? this.value : 1" value="${param.requestPage}" size="2"/>
		   	 <input type="submit" value="转到"/>
		</td>
	</tr>
</table>






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