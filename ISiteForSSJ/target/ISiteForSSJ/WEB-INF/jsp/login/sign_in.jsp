<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title>登录</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/login_style.css">


<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/login.js"></script>
</head>
<style type="text/css">
</style>

<body class="bg">

	<%-- <form action="<%=request.getContextPath() %>/jsp/index/manage_left.jsp" method="post"> --%>
	<!-- <form action="" method="post"> -->
	<!-- <div class="bg"></div> -->
	<div class="container">
		<div class="line bouncein">
			<div class="xs6 xm4 xs3-move xm4-move">
				<div style="height: 150px;"></div>
				<div class="media media-y margin-big-bottom"></div>
				<div class="panel loginbox">
					<div class="text-center margin-big padding-big-top">
						<h1>后台管理中心</h1>
					</div>
					<div class="panel-body"
						style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
						<div class="form-group">
							<div class="field field-icon-right">
								<input type="text" class="input input-big" name="username"
									id="username" placeholder="登录账号" /> <span
									class="icon icon-user margin-small-right"></span>
							</div>
						</div>
						<div class="form-group">
							<div class="field field-icon-right">
								<input type="password" class="input input-big" name="password"
									id="password" placeholder="登录密码" /> <span
									class="icon icon-key margin-small-right"></span>
							</div>
						</div>
						<div class="form-group">
							<div class="field">
								<input type="text" class="input input-big" name="verification_code"
									id="verification_code" placeholder="填写右侧的验证码" /> <img
									src="authCode" id="codeImage" onclick="chageCode()"
									title="图片看不清？点击重新得到验证码" width="100" height="32"
									class="passcode" style="height: 43px; cursor: pointer; width: 80px;"
									onClick="chageCode()">
							</div>
						</div>
						<div style="padding: 30px;">
							<!-- <input type="button" id="button" onclick="checkLogin()"
								class="button button-block bg-main text-big input-big"
								value="登录"> -->
							<button onclick="validateCode()">验证码</button>
							<button onclick="checkLogin()">登陆</button>
						</div>
						<div style="padding: 30px;">
							<table>
								<tr>
									<td align="right"><a href="tosign_up"><span
											class="icon icon-reply margin-small-right"
											style="color: blue; text-align: right;"> 没有账号？注册临时游客账户</span></a>
								</tr>
								<tr>
									<td><br></td>
								</tr>
								<tr>
									<td><a href="home"><span
											class="icon icon-reply margin-small-right"
											style="color: blue; text-align: right;"> 不登录，直接游客访问</span></a></td>
								</tr>
							</table>


						</div>

					</div>
				</div>
			</div>
		</div>
		<!-- </form> -->
</body>
</html>