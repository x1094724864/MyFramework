<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试验证码</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/login_style.css">


<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/test.js"></script>
</head>
<%-- <%
	String code = (String)session.getAttribute("strCode");
%> --%>


<body>
	<form action="toLogin.do" id="loginUser" method="post">
		<div class="form-group">
			验证码：<input id="authCode" name="authCode" type="text" />
			<!--这里img标签的src属性的值为后台实现图片验证码方法的请求地址-->
			<label><img type="image" src="authCode" id="codeImage"
				onclick="chageCode()" title="图片看不清？点击重新得到验证码"
				style="cursor: pointer;" /></label> <label><a onclick="chageCode()">换一张</a></label>
		</div>
		<button onclick="trueOrFalse()">检查</button>
		<input type="button" class="btn btn-default" onclick="subm()"
			value="登录" />
	</form>
</body>
</html>