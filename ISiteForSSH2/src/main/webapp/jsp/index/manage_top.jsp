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
</head>
<%
	String username = (String) session.getAttribute("username");
%>
<body>
	<!--    顶部   -->
	<div id="head">
		<div class="left">
			<a class="button profile"><img src="../../images/huser.png"
				alt="" style="margin-top: 5px;"></a>
			<!-- Hi, <a>MyMaster</a> -->
			<c:choose>
				<c:when test="${flag }">
					<a href="toLogin.action">登录</a>

				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="<%=username == null%>">
							游客未登录，请<a href="toLoginPage.action" target="_parent">登录</a>
						</c:when>
						<c:otherwise>
							你好！<%=username%>&nbsp;|&nbsp;<a href="toLoguot.action" target="_parent">注销</a>
						</c:otherwise>
					</c:choose>
				</c:otherwise>

			</c:choose>




		</div>
	</div>

</body>
</html>