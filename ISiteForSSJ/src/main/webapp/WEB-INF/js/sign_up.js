//注册页面js文件
var username;
var password1;
var initPassword;
// var tell;
var email;
// var permission=0;

// 判断用户名是包含空格，以及长度是否符合要求，另外异步验证用户名是否已存在
function checkUsername() {
	var name = $('#username').val();

	if (name.indexOf(" ") != -1) {
		$('#username_span').html("用户名不能包含空格，请重新输入").css("color", "red");
		return checkedName = false;
	} else if (name == " ") {
		$('#username_span').html("请填写用户名").css("color", "red");
		return checkedName = false;
	} else if (name.length < 4) {
		$('#username_span').html("用户名太短，请重新输入").css("color", "red");
		return checkedName = false;
	} else if (name.length > 8) {
		$('#username_span').html("用户名太长，请重新输入").css("color", "red");
		return checkedName = false;
	} else {
		$.ajax({
			type : "Post",
			contentType : "application/json",
			url : "userIsExist?username=" + name,
			processData : false,
			dataType : "json",
			data : "{}",
			// data : checkName,
			success : function(data) {
				if (data) {
					$('#username_span').html("该用户名已被注册！").css("color", "red");
					return checkedName = false;
				} else {
					$('#username_span').html("此用户名可用").css("color", "green");
					username = name;
					return checkedName = true;
				}
			}
		});
	}
}

// 判断输入的密码是否符合要求
function checkInitPassword() {
	var init_password = $('#init_password').val();
	var repeat_password = $('#repeat_password').val();
	if (repeat_password == "") {
		if (init_password.indexOf(" ") != -1) {
			$('#error_init_pwd').html("密码不能包含空格，请重新输入！").css("color", "red");
			return checkedInitPwd = false;
		} else if (init_password.length < 6) {
			$('#error_init_pwd').html("密码太短，请重新输入！").css("color", "red");
			return checkedInitPwd = false;
		} else if (init_password.length > 16) {
			$('#error_init_pwd').html("密码超出限制，请重新输入！").css("color", "red");
			return checkedInitPwd = false;
		} else {
			$('#error_init_pwd').html("密码符合要求").css("color", "green");
			// password1= init_password;
			return checkedInitPwd = true;
		}
	} else if (repeat_password != "") {
		$('#error_init_pwd').html("");
		$('#error_init_pwd2').html("");
		if (init_password.indexOf(" ") != -1) {
			$('#error_init_pwd').html("密码不能包含空格，请重新输入！").css("color", "red");
			return checkedInitPwd = false;
		} else if (init_password.length < 6) {
			$('#error_init_pwd').html("密码太短，请重新输入！").css("color", "red");
			return checkedInitPwd = false;
		} else if (init_password.length > 16) {
			$('#error_init_pwd').html("密码超出限制，请重新输入！").css("color", "red");
			return checkedInitPwd = false;
		} else if (init_password != repeat_password) {
			$('#error_init_pwd').html("密码符合要求").css("color", "green");
			$('#error_repeat_pwd').html("两次输入密码不一致！").css("color", "red");
			return checkedInitPwd = false;
		} else {
			$('#error_repeat_pwd').html("密码输入一致").css("color", "green");
			// password= init_password;
			// initPassword= init_password;
			checkedRepeatPwd = true;
			return checkedInitPwd = true;
		}
	}
}

// 验证2次输入的密码是否一致
function checkRepeatPassword() {
	var init_password = $('#init_password').val();
	var repeat_password = $('#repeat_password').val();
	if (repeat_password == "") {
		$('#error_repeat_pwd').html("密码不能为空！").css("color", "red");
		return checkedRepeatPwd = false;
	} else {
		if (init_password != repeat_password) {
			$('#error_repeat_pwd').html("两次输入密码不一致！").css("color", "red");
			return checkedRepeatPwd = false;
		} else {
			$('#error_repeat_pwd').html("密码输入一致").css("color", "green");
			password2 = repeat_password;
			initPassword = init_password;
			checkedInitPwd = true;
			return checkedRepeatPwd = true;
		}
	}
}

// 检查输入的号码是否合法
function checkTell() {
	// 利用正则表达式对输入数据匹配
	var tell = $('#telephone').val();
	// 匹配到一个非数字字符，则返回false
	var expr = /\D/i;
	if (expr.test(tell)) {
		$('#error_tell').html("不能输入非数字字符").css("color", "red");
		return checkedTell = false;
	} else {
		$('#error_tell').html("√").css("color", "green");
		return checkedTell = true;
	}
}

// 检查输入的email是否合法
function checkEmail() {
	// 利用正则表达式对输入数据匹配
	var input_email = $('#email').val();
	// 以字母或数字开头，跟上@,字母数字以.com结尾
	var expr = /^([0-9]|[a-z])+@([0-9]|[a-z])+(\.[c][o][m])$/i;
	if (!expr.test(input_email)) {
		$('#error_email').html("输入的邮箱格式有误").css("color", "red");
		return checkedEmail = false;
	} else {
		$('#error_email').html("√").css("color", "green");
		email = input_email;
		return checkedEmail = true;
	}
}

// 验证输入的日期是否大于当前日期
function checkBirth() {
	var date = new Date();
	/*
	 * 获取当前日期，但如果获取的月和日为单数，则系统不会自动加0，会导致获取的当前日期小于输入的日期，需要修改代码实现 var year =
	 * date.toLocaleDateString();获取的日期为yyyy/mm/dd类型的日期，暂时不需要使用
	 */
	// 获取月份，并判断月份是否需要加0；
	var month = date.getMonth() + 1;
	if (month < 10) {
		month = "0" + month;
	}
	// 获取天数，并判断天数前是否需要加0；
	var tian = date.getDate();
	if (tian < 10) {
		tian = "0" + tian;
	}
	// 将年月日拼接在一起
	var date_str = date.getFullYear() + "" + month + "" + tian;
	var date_choose = $('#birth').val();
	// 最好将其转换成整形，方便比较大小
	var date_now = parseInt(date_str);
	var date_birth = parseInt(date_choose.replace(/-/g, ''));

	if (date_birth > date_now) {
		$('#error_birth').html("您输入的日期不合法，请重新选择！").css("color", "red");
		return checkedBirth = false;
	} else {
		$('#error_birth').html("√").css("color", "green");
		return checkedBirth = true;
	}
}

// java后台验证码
// 变换验证码
function chageCode() {
	$('#codeImage').attr('src', 'authCode?abc=' + Math.random());
	// 链接后添加Math.random，确保每次产生新的验证码，避免缓存问题。
}

function validateCode() {
	var inputCode = $('#verification_code').val();
	if (inputCode == "") {
		alert("请填写验证码");
		chageCode();
	} else if (checkedName && checkedInitPwd && checkedRepeatPwd
			&& checkedEmail) {
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
					register();
				} else {
					alert("验证码错误！");
					chageCode();
				}
			},
			error : function(data) {
				chageCode();
				return validateCode = false;
			}
		});
	} else if (!checkedName) {
		alert("用户名有问题！")
	} else if (!checkedInitPwd) {
		alert("密码有问题！")
	} else if (!checkedRepeatPwd) {
		alert("两次密码不一致！")
	} else if (!checkedEmail) {
		alert("邮箱有问题！")
	}
}

function register() {
	if (checkedName && checkedInitPwd && checkedRepeatPwd && checkedEmail) {
//		window.location.href = "temporary?username=" + username + "&password="
//				+ initPassword + "&email=" + email + "&permission=0";

		document.write("<form action='temporary' method=post name=sign_up style='display:none'>");
		document.write("<input type='hidden' name='username' value='" + username + "'/>");
		document.write("<input type='hidden' name='password' value='" + initPassword + "'/>");
		document.write("<input type='hidden' name='email' value='" + email + "'/>");
		document.write("<input type='hidden' name='permission' value= '0' />");
		document.write("</form>");
		document.sign_up.submit();

	} else if (!checkedName) {
		alert("用户名有问题！")
	} else if (!checkedInitPwd) {
		alert("密码有问题！")
	} else if (!checkedRepeatPwd) {
		alert("两次密码不长一智！")
	} else if (!checkedEmail) {
		alert("邮箱有问题！")
	}

}
