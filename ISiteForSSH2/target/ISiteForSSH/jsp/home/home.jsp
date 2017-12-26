<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>后台管理系统</title>
<link rel="stylesheet" href="../../css/style.css" />
<link rel="stylesheet" href="../../css/jquery.wysiwyg.old-school.css" />

<!-- jQuery AND jQueryUI -->
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../js/jquery-ui.min.js"></script>
<script type="text/javascript" src="../../js/min.js"></script>
<script type="text/javascript" src="../../js/main.js"></script>
<link rel="stylesheet" href="../../css/style2.css" />

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
	top: 0;
	z-index: 101;
}

.left {
	width: 14.4%;
	height: 100%;
	clear: both;
	float: left;
	position: absolute;
	top: 0;
}

.right {
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>
	<div class="main">
		<div class="top">
			<iframe name="top" width="100%" height="100%" src="home_head.jsp"></iframe>
		</div>
		<div class="bottom">
			<div class="left">
				<iframe name="left" width="100%" height="100%" src="home_left.jsp"
					scrolling="no"></iframe>
			</div>
			<div class="right">
				<iframe name="right" width="100%" height="100%" src="content.jsp"></iframe>
			</div>
		</div>
	</div>

</body>
</html>