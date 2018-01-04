<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
body {
	padding: 0;
	margin: 0;
	overflow-y: hidden;
}

.main {
	height: 100%;
	width: 100%;
	position: absolute;
}

.top {
	width: 100%;
	height: 42px;
	position: absolute;
	top: 0;
	z-index: 102;
}

.bottom {
	width: 100%;
	height: 100%;
	position: absolute;
	z-index: 101;
}

.left {
	width: 20%;
/* 	width: 14.4%; */
	height: 100%;
	clear: both;
	float: left;
	position: absolute;
	top: 0;
}

.right {
	width: 81%;
/* 	width: 85.6%; */
	height: 100%;
	position: absolute;
	left:18.5%;
/* 	left: 14.4%; */
	top: 42px;
}
</style>
</head>
<body>
	<div class="main">
		<div class="top">
			<iframe name="top" width="100%" height="100%" src="<%=request.getContextPath()%>/home_top"></iframe>
		</div>
		<div class="bottom">
			<div class="left">
				<iframe name="left" width="100%" height="100%"
					src="home_left" scrolling="no"></iframe>
			</div>
			<div class="right">
				<iframe name="right" width="100%" height="100%" src="http://www.baidu.com"
					scrolling=""></iframe>
			</div>
		</div>
	</div>
</body>
</html>