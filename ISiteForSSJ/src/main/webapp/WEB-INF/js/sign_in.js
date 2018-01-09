//js的验证码
//var code;
//function createCode() {
//	code = "";
//	var codeLength = 4; // 验证码的长度
//	var checkCode = $('#checkCode');
//	var codeChars = new Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 'a', 'b', 'c', 'd',
//			'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r',
//			's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E',
//			'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S',
//			'T', 'U', 'V', 'W', 'X', 'Y', 'Z'); // 所有候选组成验证码的字符，当然也可以用中文的
//	for (var i = 0; i < codeLength; i++) {
//		var charNum = Math.floor(Math.random() * 52);
//		code += codeChars[charNum];
//	}
//	if (checkCode) {
//		checkCode.className = "code";
//		checkCode.innerHTML = code;
//	}
//}
//function validateCode() {
//	var inputCode = $('#inputCode').val();
//	if (inputCode.length <= 0) {
//		alert("请输入验证码！");
//	} else if (inputCode.toUpperCase() != code.toUpperCase()) {
//		alert("验证码输入有误！");
//		createCode();
//	} else {
//		alert("验证码正确！");
//	}
//}

//java后台验证码
function chageCode() {
	$('#codeImage').attr('src', 'authCode?abc=' + Math.random());
	// 链接后添加Math.random，确保每次产生新的验证码，避免缓存问题。
}

function validateCode() {
	var inputCode = $('#verification_code').val();
	if (inputCode == "") {
		alert("请填写验证码");
		chageCode();
	} else {
		alert("进入ajax");
		$.ajax({
			type : "Post",
			contentType : "application/json",
			// url : chageCode(),
			url : "trueOrFalse?inputCode=" + inputCode,
			processData : false,
			dataType : "json",
			data : "{}",
			success : function(data) {
				if (data) {
					alert("后台传来的是" + data);
					checkLogin();
				} else {
					alert("验证码错误！");
					chageCode();
				}
			},
			error : function(data) {
				alert("inputCode:" + inputCode);
				alert("data:" + data);
				chageCode();
			}
		});
	}
}

function checkLogin() {
	var name = $('#username').val();
	var password = $('#password').val();
	if (name == "") {
		// $('#username_span').html("用户名不能包含空格，请重新输入").css("color", "red");
		alert("请填写用户名！");
		chageCode();
	} else if (password == "") {
		/* $('#username_span').html("用户名太短，请重新输入").css("color", "red"); */
		alert("请填写密码！");
		chageCode();
	} else if (password != "" && name != "") {
		$
				.ajax({
					type : "Post",
					contentType : "application/json",
					url : "checkUsernameAndPassword?username=" + name
							+ "&password=" + password,
//					url:"checkUsernameAndPassword",
					processData : false,
					dataType : "json",
					data : "{}",
					success : function(data) {
						if (data) {
							// window.location.href = "home?username=" + name+
							// "&password=" + password;
							document
									.write("<form action='home' method=post name=form1 style='display:none'>");
							document
									.write("<input type='hidden' name='username' value='"
											+ name + "'/>");
							document
									.write("<input type='hidden' name='password' value='"
											+ password + "'/>");
							document.write("</form>");
							document.form1.submit();

							alert("登陆成功！确认跳转");
						} else {
							alert("用户名或密码错误！");
							// chageCode();
							window.location.href = "tosign_in";
						}
					}
				});
	}
}