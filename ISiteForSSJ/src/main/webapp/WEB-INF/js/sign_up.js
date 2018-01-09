//注册页面js文件
var username;
var password;
// var tell;
var email;
// var permission=0;

// 判断用户名是包含空格，以及长度是否符合要求，另外异步验证用户名是否已存在
function checkUsername() {
	var name = $('#username').val();

	if (name.indexOf(" ") != -1) {
		$('#username_span').html("用户名不能包含空格，请重新输入").css("color", "red");
		return checkName = false;
	} else if (name.length < 4) {
		$('#username_span').html("用户名太短，请重新输入").css("color", "red");
		return checkName = false;
	} else if (name.length > 8) {
		$('#username_span').html("用户名太长，请重新输入").css("color", "red");
		return checkName = false;
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
					return checkName = false;
				} else {
					$('#username_span').html("此用户名可用").css("color", "green");
					username = name;
					return checkName = true;
				}
			}
		});
	}
}

// 判断输入的密码是否符合要求
function checkPwd1() {
	var password1 = $('#password').val();
	if (password1.indexOf(" ") != -1) {
		$('#error_pwd').html("密码不能包含空格，请重新输入！").css("color", "red");
		return checkPwd1 = false;
	} else if (password1.length < 6) {
		$('#error_pwd').html("密码太短，请重新输入！");
		return checkPwd1 = false;
	} else if (password1.length > 16) {
		$('#error_pwd').html("密码超出限制，请重新输入！");
		return checkPwd1 = false;
	} else {
		$('#error_pwd').html("密码符合要求").css("color", "green");
		password = password1;
		return checkPwd1 = true;
	}
}

// 验证2次输入的密码是否一致
function checkPwd2() {
	var password = $('#password').val();
	var password2 = $('#repassword').val();
	if (password2 == "") {
		$('#error2_pwd').html("密码不能为空！").css("color", "red");
		return checkPwd2 = false;
	} else {
		if (password != password2) {
			$('#error2_pwd').html("两次输入密码不一致！").css("color", "red");
			return checkPwd2 = false;
		} else {
			$('#error2_pwd').html("密码输入一致").css("color", "green");
			return checkPwd2 = true;
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
		return checkTell = false;
	} else {
		$('#error_tell').html("√").css("color", "green");
		return checkTell = true;
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
		return checkEmail = false;
	} else {
		$('#error_email').html("√").css("color", "green");
		email = input_email;
		return checkEmail = true;
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
		return checkBirth = false;
	} else {
		$('#error_birth').html("√").css("color", "green");
		return checkBirth = true;
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
					// alert("后台传来的是" + data);
					// checkLogin();
					// return validateResult = true;
					register();
					// return data;
				} else {
					alert("验证码错误！");
					chageCode();
					// return validateResult=false;
					// return data;
				}
			},
			error : function(data) {
				// alert("inputCode:" + inputCode);
				// alert("data:" + data);
				chageCode();
				return validateCode = false;
			}
		});
	}
}

function test() {
	// var checkUsername=checkUsername().val();
	alert("username=" + username)
	alert("password=" + password)
	alert("checkPwd2=" + checkPwd2)
	alert("email=" + email)
	alert("validateCode=" + validateResult)

}

function register() {
	if (checkName && checkPwd1 && checkPwd2 && checkEmail) {
		window.location.href = "temporary?username=" + username + "&password="
				+ password + "&email=" + email + "&permission=0";
	} else if (!checkName) {
		alert("用户名有问题！")
	} else if (!checkPwd1) {
		alert("密码有问题！")
	} else if (!checkPwd2) {
		alert("两次密码不长一智！")
	} else if (!checkEmail) {
		alert("邮箱有问题！")
	}

}

// function register(){
// if (checkName&&checkPwd1&&checkPwd2&&checkEmail) {
// $.ajax({
// type : "Post",
// contentType : "application/json",
// url : "temporary?username=" + name
// + "&password=" + password,
// processData : false,
// dataType : "json",
// data : "{}",
// success : function(data) {
// if (data) {
// // window.location.href = "home?username=" + name+
// // "&password=" + password;
// document
// .write("<form action='home' method=post name=form1 style='display:none'>");
// document
// .write("<input type='hidden' name='username' value='"
// + name + "'/>");
// document
// .write("<input type='hidden' name='password' value='"
// + password + "'/>");
// document.write("</form>");
// document.form1.submit();
//
// alert("登陆成功！确认跳转");
// } else {
// alert("用户名或密码错误！");
// // chageCode();
// window.location.href = "tosign_in";
// }
// }
// });
//		
// }
//	
//	
// }
//

