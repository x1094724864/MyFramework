// 判断部门名是包含空格，以及长度是否符合要求，另外异步验证部门名是否已存在
var checkedEmpId = false;
var checkedEmpDepartName = false;
var checkedEducation = false;
var checkedEmpId = false;
var checkedTimeQualified = false;
var checkedTell = false;
var checkedMail = false;
var checkedProfession = false;
var checkedAddress;
// 检查员工编号
function checkEmployee_id() {
	// 利用正则表达式对输入数据匹配
	var employee_id = $('#employee_id').val();
	$('#employee_id_span').html("");
	// 匹配到一个非数字字符，则返回false
	var expr = /\D/i;
	if (employee_id == "") {
		// $('#employee_id_span').html("请填写员工编号").css("color", "red");
		return checkedEmpId = false;
	} else if (expr.test(employee_id)) {
		// $('#depart_num_span').html("不能输入非数字字符").css("color", "red");
		alert("员工编号不能是非数字字符");
		return checkedEmpId = false;
	} else {
		$.ajax({
			type : "Post",
			contentType : "application/json",
			url : "empIsExistByEmpId?employee_id=" + employee_id,
			processData : false,
			dataType : "json",
			data : "{}",
			success : function(data) {
				if (data) {
					// $('#username_span').html("该部门名已存在！").css("color",
					// "red");
					alert("该员工编号已存在！");
					// $('#employee_id_span').html("请重新填写员工编号").css(
					// "color", "red");
					return checkedEmpId = false;
				} else {
					// $('#employee_id_span').html("部门编号可用").css("color",
					// "green");
					return checkedEmpId = true;
				}
			}
		});
	}
}
/**
 * 员工姓名允许重复，此处不验证了
 * 
 * @returns
 */

// 检查部门选择
function checkEmpDepartName() {
	var empDepartmentName = $('#empDepartmentName').val();
	$('#employee_depart_span').html("");
	if (empDepartmentName == "未选择") {
		return checkedEmpDepartName = false;
	}
	return checkedEmpDepartName = true;
}

// 检查学历选择
function checkEducation() {
	var education = $('#education').val();
	$('#employee_education_span').html("");
	if (education == "未选择") {
		return checkedEducation = false;
	}
	return checkedEducation = true;
}

// 设置时间样式
/* Chinese initialisation for the jQuery UI date picker plugin. */
/* Written by Cloudream (cloudream@gmail.com). */
jQuery(function($) {
	$.datepicker.regional['zh-CN'] = {
		closeText : '关闭',
		prevText : '&#x3C;上月',
		nextText : '下月&#x3E;',
		currentText : '今天',
		monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月',
				'十月', '十一月', '十二月' ],
		monthNamesShort : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月',
				'九月', '十月', '十一月', '十二月' ],
		dayNames : [ '星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ],
		dayNamesShort : [ '周日', '周一', '周二', '周三', '周四', '周五', '周六' ],
		dayNamesMin : [ '日', '一', '二', '三', '四', '五', '六' ],
		weekHeader : '周',
		dateFormat : 'yy-mm-dd',
		firstDay : 1,
		isRTL : false,
		showMonthAfterYear : true,
		yearSuffix : '年'
	};
	$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
});
// 验证输入的日期是否大于当前日期
function checkTimeQualified() {
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
	var day = date.getDate();
	if (day < 10) {
		day = "0" + day;
	}
	// 将年月日拼接在一起
	var date_str = date.getFullYear() + "" + month + "" + day;
	var date_choose = $('#entry_Time').val();
	// 最好将其转换成整形，方便比较大小
	var date_now = parseInt(date_str);
	var date_entry_time = parseInt(date_choose.replace(/-/g, ''));

	if (date_entry_time > date_now) {
		// $('#employee_entry_time_span').html("入职时间不能大于今天，请重新选择！").css("color",
		// "red");
		return checkedTimeQualified = false;
	} else {
		// $('#employee_entry_time_span').html("√").css("color", "green");
		return checkedTimeQualified = true;
	}
}

// 检查输入的号码是否合法
function checkTell() {
	// 利用正则表达式对输入数据匹配
	var tel_number = $('#tel_number').val();
	$('#employee_tel_span').html("");
	// 匹配到一个非数字字符，则返回false
	var expr = /\D/i;
	if (tel_number != "") {
		if (expr.test(tel_number)) {
			// $('#employee_tel_span').html("不能输入非数字字符").css("color", "red");
			return checkedTell = false;
		} else {
			// $('#employee_tel_span').html("√").css("color", "green");
			return checkedTell = true;
		}
	}
}

// 检查输入的email是否合法
function checkMail() {
	// 利用正则表达式对输入数据匹配
	var input_mail = $('#mail').val();
	$('#employee_mail_span').html("");
	// 以字母或数字开头，跟上@,字母数字以.com结尾
	var expr = /^([0-9]|[a-z])+@([0-9]|[a-z])+(\.[c][o][m])$/i;
	if (!expr.test(input_mail)) {
		// $('#employee_mail_span').html("输入的邮箱格式有误").css("color", "red");
		return checkedMail = false;
	} else {
		// $('#employee_mail_span').html("√").css("color", "green");
		mail = input_mail;
		return checkedMail = true;
	}
}

// 专业检查
function checkProfession() {
	var profession = $('#profession').val();
	$('#employee_profession_span').html("");
	if (education == "") {
		// $('#employee_profession_span').html("请填写专业！").css("color", "red");
		return checkedProfession = false;
	}
	return checkedProfession = true;
}

// 地址检查
function checkAddress() {
	var address = $('#address').val();
	$('#employee_address_span').html("");
	if (education == "") {
		// $('#employee_address_span').html("请填写地址！").css("color", "red");
		return checkedAddress = false;
	}
	return checkedAddress = true;
}

function saveEmployee() {
	// var employee_id = $('#employee_id').val();
	var name = $('#name').val();
	// var gender = $('#gender').val();
	// var departmentName = $('#empDepartmentName').val();
	var entry_Time = $('#entry_Time').val();
	// var education = $('#education').val();
	// var profession = $('#profession').val();
	// var address = $('#address').val();
	// var tel_number = $('#tel_number').val();
	// var mail = $('#mail').val();
	// var photo = $('#photo').val();

	var allow_to_submit = checkedEmpId && checkedEmpDepartName
			&& checkedEducation && checkedTimeQualified && checkedTell
			&& checkedMail && checkedProfession && checkedAddress;
	if (!checkedEmpId) {
		alert("请填写员工编号 ！");
	} else if (name == "") {
		alert("请填写员工姓名 ！");
	} else if (!checkedEmpDepartName) {
		alert("部门为必填项 ！");
	} else if (entry_Time == "") {
		alert("请选择入职时间！")
	} else if (!checkedTimeQualified) {
		alert("入职时间不能大于当前日期 ！");
	} else if (!checkedAddress) {
		alert("请填写员工地址信息 ！");
	} else if (!checkedProfession) {
		alert("请填写专业信息 ！");
	} else if (!checkedEducation) {
		alert("请填写员工学历！");
	} else if (!checkedTell) {
		alert("请检查员工电话号码！");
	} else if (!checkedMail) {
		alert("请检查员工邮箱！");
	} else

	if (allow_to_submit) {
		saveEmpForm.submit();
		alert("员工信息填写完成！确认跳转");
	} else {
		alert("填写的信息不符合要求哦~~~请检查之后再提交吧！");
	}
}

// 重置
function resetValue() {
	$('#employee_id').val("");
	$('#employee_id_span').html("");

	$('#name').val("");
	$('#entry_Time').val("");
	$('#employee_entry_time_span').html("");

	$('#profession').val("");
	$('#employee_profession_span').html("");

	$('#address').val("");
	$('#employee_address_span').html("");

	$('#tel_number').val("");
	$('#employee_tel_span').html("");

	$('#mail').val("");
	$('#employee_mail_span').html("");

	$('#uniform-empDepartmentName span').html('-----请选择部门-----');
	$('#employee_depart_span').html("");

	$('#uniform-education span').html('-----请选择学历-----');
	$('#employee_education_span').html("");

	$('#uniform-photo .filename').html("未选择照片");
}
// 刷新重置
function reset() {
	location.reload();
}
