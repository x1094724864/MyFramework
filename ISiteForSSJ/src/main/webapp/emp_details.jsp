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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/registter.css">

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
	href="<%=request.getContextPath()%>/css/style2.css">

<style>
a {
	text-decoration: none
}

#content table tbody tr td {
	height: 55px;
	vertical-align: middle;
	border-bottom: 1px solid #DADADA;
	border-top: 1px solid #FFFFFF;
	/* font-size: 18px; */
}

td.showinfo {
	align-content:;
	text-align: center;
	width: 150px;
	font-size: 15px;
}

.item {
	text-align: right;
	width: 200px;
	color: #2C2C2C;
	font-size: 18px;
	font-weight: bold;
}

.image {
	width: 120px;
	height: 160px;
	width: 120px;
}

input.show {
vertical-align: middle;
	border-bottom: 1px solid #DADADA;
	border-top: 1px solid #FFFFFF;
height: 55px;
	border-bottom-width: 0px;
	border-right-width: 0px;
	border-top-width: 0px;
	border-left-width: 0px;
}
</style>
</head>
<body>


	<!--     内容      -->
	<div id="content" class="white">
		<h1>
			<img src="<%=request.getContextPath()%>/images/posts.png" alt="">员工管理
		</h1>
		<br> <br>
		<div class="bloc">
			<!-- <div  class=" item"  style="width: 100%; text-align: center; height: 65px;">
				<span style="font-size: 35px;">员工详细信息</span>
			</div> -->
			<div class="content">
				<form action="" method="post">
					<table align="center" style="text-align: center;" border="2">
						<thead>
							<tr>
								<th colspan="6"
									style="width: 100%; text-align: center; height: 65px; padding-top: 5px; border-bottom-width: 2px;""><span
									style="font-size: 35px;">员工详细信息</span></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class=" item">姓名</td>
								<td class="showinfo"><span value="dede">${emp.name }</span></td>
								<td class=" item">性别</td>
								<td class="showinfo"><input class="show" value="显示框"></td>
								<td colspan="2" rowspan="3" style="text-align: center;"><img
									src="<%=request.getContextPath()%>/photo_picture/myself.jpg"
									alt="photo_picture" class="image"></td>
							</tr>
							<tr>
								<td class=" item">部门</td>
								<td class="showinfo">显示框</td>
								<td class="item">年龄</td>
								<td class="showinfo">显示框</td>
								<!-- <td>头像</td> -->
							</tr>
							<tr>
								<td class="item">入职时间</td>
								<td class="showinfo">显示框</td>
								<td class="item">地址</td>
								<td class="showinfo">显示框</td>
								<!-- <td>头像</td> -->
							</tr>
							<tr>
								<td class="item">所学专业</td>
								<td class="showinfo">显示框</td>
								<td class="item">学历</td>
								<td class="showinfo">显示框</td>
								<td class="item" style="text-align: center;">员工编号</td>
								<td class="showinfo">显示框</td>
							</tr>
							<tr>
								<td class="item">手机号</td>
								<td class="showinfo">显示框</td>
								<td class="item">邮箱</td>
								<td class="showinfo">显示框</td>
								<td class="item" style="text-align: center;" colspan="2"><button>
										<a href="" style="text-align: center; font-size: 18px;">修改信息</a>
									</button></td>
								<td></td>
							</tr>
						</tbody>
						<tfoot></tfoot>
					</table>
				</form>




			</div>
		</div>
	</div>
	<div id="ui-datepicker-div"
		class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>
</body>
</html>