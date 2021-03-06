<%@page import="com.lx.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>后台管理</title>
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

</head>
<%
	Users user = (Users) session.getAttribute("user");
%>
<body>

	<!--     内容      -->
	<div id="content" class="white">
		<h1>
			<img src="images/logo/logo1.png" alt="">后台管理——个人中心
		</h1>
		<div class="bloc left">
			<div class="title">快捷入口</div>
			<div class="content dashboard">
				<div class="center" style="display: block; width: auto;">
					<a class="shortcut" href="users/modUser?id=${user.id}" >用户修改<img
						src="Your Admin Panel_files/picture.png" alt="" width="48"
						height="48">
					</a> <a class="shortcut"> <img
						src="Your Admin Panel_files/contact.png" alt="" width="48"
						height="48">
					</a>
					<div class="cb"></div>
				</div>
			</div>
		</div>
		<div class="bloc right">
			<div class="title">
				登陆信息 
			</div>
			<div class="content">
				<div>
					<table class="noalt">
						<thead>
							<tr>
								<th colspan="2"><em>Stefan Salvatore</em></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><h6>
										用户角色：
										<c:choose>
											<c:when test="<%=user == null%>">
												游客
											</c:when>
											<c:otherwise>
												${user.permissionName}
											</c:otherwise>
										</c:choose>
									</h6></td>
							</tr>
							<tr>
								<!-- <td><h6>上次登录时间：2014-01-17 12:21:21</h6></td> -->
							</tr>
						</tbody>
					</table>
				</div>
				<div class="cb"></div>
			</div>
		</div>
		<div class="cb"></div>
		<div class="bloc">
			<div class="title">
				管理须知
			</div>
			<div class="content">
			<span>还没来得及写，反正就是一些用户操作条例</span>
				<!-- <h5>10/10/2011</h5>
				<ul>
					<li>关于财务公司资金管理平台TMS系统升级的通知</li>
					<li>汽车金融业务2014年校园招聘</li>
					<li>2013年正式员工招聘公告</li>
					<li>招聘公告</li>
					<li>兵装财务2012年正式员工补充招聘</li>
				</ul>
				<h5>09/08/2011</h5>
				<ul>
					<li>兵装财务公司服务收费价目监督投诉电话</li>
					<li>关于兵装集团财务公司TMS 系统版本升级的通知</li>
				</ul>
				<h5>01/07/2011</h5>
				<ul>
					<li>关于兵装集团财务公司TMS 系统进行的升级的通知</li>
					<li>关于启用兵器装备集团财资管理平台(TMS系统)电子回单功能的通知</li>
				</ul> -->
			</div>
		</div>
	</div>
	<div id="ui-datepicker-div"
		class="ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all"></div>
</body>
</html>
