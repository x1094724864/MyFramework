<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script type="text/javascript">
	$(function() { //生成验证码
		$('#kaptchaImage').click(
				function() {
					$(this).hide().attr('src',
							'/getYzm?' + Math.floor(Math.random() * 100))
							.fadeIn();
				});
	});

	window.onbeforeunload = function() {
		//关闭窗口时自动退出
		if (event.clientX > 360 && event.clientY < 0 || event.altKey) {
			alert(parent.document.location);
		}
	};

	function changeCode() { //刷新
		$('#kaptchaImage').hide().attr('src',
				'/getYzm?' + Math.floor(Math.random() * 100)).fadeIn();
		event.cancelBubble = true;
	}
</script>
<title>js验证码</title>

</head>
<body>
	<img src="/getYzm" id="kaptchaImage" style="margin-bottom: -3px" />
	<a href="#" onclick="changeCode()">看不清?换一张</a>
</body>
</html>
