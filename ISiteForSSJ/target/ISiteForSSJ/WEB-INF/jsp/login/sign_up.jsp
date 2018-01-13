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
<title>注册</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/login_style.css">

<!-- jQuery AND jQueryUI -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/main.js"></script>
<!-- 下面是注册校验 -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/register.js"></script>

<style type="text/css">
.tip {
	color: red;
}
</style>

</head>
	
</script>

<body  class="bg">

	<!-- <form action="saveUser" method="post"> -->
	<form action="temporary" method="post">
		<!-- <div class="bg"></div> -->
		<div class="container">
			<div class="line bouncein">
				<div class="xs6 xm4 xs3-move xm4-move">
					<div style="height: 150px;"></div>
					<div class="media media-y margin-big-bottom"></div>
					<div class="panel loginbox">
						<div class="text-center margin-big padding-big-top">
							<h1>临时用户注册</h1>
						</div>
						<div class="panel-body"
							style="padding: 30px; padding-bottom: 10px; padding-top: 10px;">
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="text" class="input input-big" name="username"
										id="username" placeholder="4-8位用户名" onblur="checkUsername()" />
									<!-- <span class="icon icon-user margin-small-right"></span> --><span
										id="username_span" class="tip"></span><br>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name="password"
										id="password" placeholder="6-16位密码" onblur="checkPwd1()" /> <!-- <span
										class="icon icon-key margin-small-right"> --></span> <span
										class="tip" id="error_pwd"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="password" class="input input-big" name=""
										id="repassword" placeholder="再次确认密码" onblur="checkPwd2()"/> <!-- <span
										class="icon icon-key margin-small-right"> --></span><span
										id="error2_pwd" class="tip"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field field-icon-right">
									<input type="test" class="input input-big reg_email"
										name="email" id="email" placeholder="邮箱" onblur="checkEmail()"/> <!-- <span
										class="icon icon-reply margin-small-right"> --></span><span
										class="tip" id="error_email"></span>
								</div>
							</div>
							<div class="form-group">
								<div class="field">
									<input type="text" class="input input-big" name="code"
										placeholder="填写右侧的验证码" /> <img
										src="./../../images/passcode.jpg" alt="" width="100"
										height="32" class="passcode"
										style="height: 43px; cursor: pointer;"
										onClick="this.src=this.src+'?'">
								</div>
							</div>
						</div>
						<input type="hidden" name="permission" value="0" />
						<div style="padding: 30px;">
							<input type="submit" id="button"
								class="button button-block bg-main text-big input-big"
								value="注册">
						</div>
						<span class="tip password_hint"></span>
						<!-- <div style="padding: 30px;">
							<input type="button" id="button_submit"
								class="button button-block bg-main text-big input-big"
								value="注册">
						</div> -->

						<div style="padding: 30px;">
							<a href="tosign_in"><span
								class="icon icon-mail-reply margin-small-right"
								style="color: blue; text-align: left;"> 有账号，立即登陆</span></a>
						</div>
					</div>
					<br><br>
				</div>
			</div>
		</div>

	</form>
</body>
</html>