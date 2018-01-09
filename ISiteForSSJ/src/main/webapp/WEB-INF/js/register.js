/**
 * register.jsp页面的注册信息，验证使用
 */

// 判断用户名是包含空格，以及长度是否符合要求，另外异步验证用户名是否已存在
function checkUsername() {
	var name = $('#username').val();

	if (name.indexOf(" ") != -1) {
		$('#username_span').html("用户名不能包含空格，请重新输入").css("color", "red");
	} else if (name.length < 4) {
		$('#username_span').html("用户名太短，请重新输入").css("color", "red");
	} else if (name.length > 8) {
		$('#username_span').html("用户名太长，请重新输入").css("color", "red");
	} else {
		$.ajax({
			type : "Post",
			contentType : "application/json",
			url : "userIsExist?username=" + name,
			processData : false,
			dataType : "json",
			data : "{}",
			success : function(data) {
				if (data) {
					$('#username_span').html("该用户名已存在！").css("color", "red");
				} else {
					$('#username_span').html("√").css("color", "green");
				}
			}
		});
	}
}

// 判断输入的密码是否符合要求
function checkPwd1() {
	var password = $('#password').val();
	if (password.indexOf(" ") != -1) {
		$('#error_pwd').html("密码不能包含空格，请重新输入").css("color", "red");
	} else if (password.length < 8) {
		$('#error_pwd').html("密码太短，请重新输入");
	} else if (password.length > 16) {
		$('#error_pwd').html("密码太长，请重新输入");
	} else {
		$('#error_pwd').html("√").css("color", "green");
	}
}

// 验证2次输入的密码是否一致
function checkPwd2() {
	var password = $('#password').val();
	var password2 = $('#repassword').val();
	if (password2 == "") {
		$('#error2_pwd').html("密码不能为空").css("color", "red");
	} else {
		if (password != password2) {
			$('#error2_pwd').html("两次输入密码不一致").css("color", "red");
		} else {
			$('#error2_pwd').html("√").css("color", "green");
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
	} else {
		$('#error_tell').html("√").css("color", "green");
	}
}

// 检查输入的email是否合法
function checkEmail() {
	// 利用正则表达式对输入数据匹配
	var email = $('#email').val();
	// 以字母或数字开头，跟上@,字母数字以.com结尾
	var expr = /^([0-9]|[a-z])+@([0-9]|[a-z])+(\.[c][o][m])$/i;
	if (!expr.test(email)) {
		$('#error_email').html("输入的邮箱格式有误").css("color", "red");
	} else {
		$('#error_email').html("√").css("color", "green");
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
	} else {
		$('#error_birth').html("√").css("color", "green");
	}
}

// 更换验证码的方法
function changeImgCode() {
	var url = "checkImg?abc" + Math.random();
	$('#checkImg').attr("src", url);
}
// 判断验证码是否正确，可以使用ajax的方式验证，暂时不实现了，在后台实现验证功能
/*
 * function verdictImg(){
 * 
 * var getImg = session.getAttribute("randomString"); var inputImg =
 * $('checkcode').val(); if (getImg.equalsIgnoreCase(inputImg)) {
 * $('error_checkcode').html("√"); }else { $('error_checkcode').html("验证码输入错误"); } }
 */