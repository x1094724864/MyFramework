// 判断部门名是包含空格，以及长度是否符合要求，另外异步验证部门名是否已存在
var checkedEmpId = true;
var checkedEmpDepartName = true;
var checkedEducation = true;
var checkedEmpId = true;
var checkedTimeQualified = true;
var checkedTell = true;
var checkedMail = true;
var checkedProfession = true;
var checkedAddress = true;
// 检查员工编号
function checkEmployee_id() {
	// 利用正则表达式对输入数据匹配
	var employee_id = $('#employee_id').val();
	// 匹配到一个非数字字符，则返回false
	var expr = /\D/i;
	if (employee_id == "") {
		return checkedEmpId = false;
	} else if (expr.test(employee_id)) {
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
					alert("该员工编号已存在！是否继续使用该编号？");
					return checkedEmpId = true;
				} else {
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

// 检查入职时间
// 以下是日期样式
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
		return checkedTimeQualified = false;
	} else {
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
			return checkedTell = false;
		} else {
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
		return checkedMail = false;
	} else {
		mail = input_mail;
		return checkedMail = true;
	}
}

// 专业检查
function checkProfession() {
	var profession = $('#profession').val();
	$('#employee_profession_span').html("");
	if (education == "") {
		return checkedProfession = false;
	}
	return checkedProfession = true;
}

// 地址检查
function checkAddress() {
	var address = $('#address').val();
	$('#employee_address_span').html("");
	if (education == "") {
		return checkedAddress = false;
	}
	return checkedAddress = true;
}

function saveEmployee() {
	var employee_id = $('#employee_id').val();
	var name = $('#name').val();
	// var gender = $('#gender').val();
	var departmentName = $('#empDepartmentName').val();
	var entry_Time = $('#entry_Time').val();
	var education = $('#education').val();
	// var profession = $('#profession').val();
	// var address = $('#address').val();
	// var tel_number = $('#tel_number').val();
	// var mail = $('#mail').val();
	// var photo = $('#photo').val();

	if (checkInputIsEmpty()) {

		// var allow_to_submit = checkedEmpId && checkedEmpDepartName
		// && checkedEducation && checkedTimeQualified && checkedTell
		// && checkedMail && checkedProfession && checkedAddress;

		if (checkInputIsQualified()) {
			saveEmpForm.submit();
			alert("员工信息填写完成！确认跳转");
		} else {
			alert("填写的信息不符合要求哦~~~请检查之后再提交吧！");
		}
	}
}
// 检查选项的合法性
function checkInputIsQualified() {
	if (!checkedEmpId) {
		alert("请填写员工编号 ！");
		return false;
	} else if (name == "") {
		alert("请填写员工姓名 ！");
		return false;
	} else if (!checkedEmpDepartName) {
		alert("部门为必填项 ！");
		return false;
	} else if (entry_Time == "") {
		alert("请选择入职时间！")
		return false;
	} else if (!checkedTimeQualified) {
		alert("入职时间不能大于当前日期 ！");
		return false;
	} else if (!checkedAddress) {
		alert("请填写员工地址信息 ！");
		return false;
	} else if (!checkedProfession) {
		alert("请填写专业信息 ！");
		return false;
	} else if (!checkedEducation) {
		alert("请填写员工学历！");
		return false;
	} else if (!checkedTell) {
		alert("请检查员工电话号码！");
		return false;
	} else if (!checkedMail) {
		alert("请检查员工邮箱！");
		return false;
	}
	return true;

}

// 检查选项是否为空
function checkInputIsEmpty() {
	var employee_id = $('#employee_id').val();
	var name = $('#name').val();
	var departmentName = $('#empDepartmentName').val();
	var entry_Time = $('#entry_Time').val();
	var education = $('#education').val();
	var profession = $('#profession').val();
	var address = $('#address').val();
	var tel_number = $('#tel_number').val();
	var mail = $('#mail').val();
	var photo = $('#photo').val();
	if (employee_id == "") {
		alert("请填写员工编号！");
		return false;
	} else if (name == "") {
		alert("请填写员工姓名！");
		return false;
	} else if (departmentName == "未选择") {
		alert("请选择一个部门！");
		return false;
	} else if (entry_Time == "") {
		alert("请选择入职时间！");
		return false;
	} else if (education == "未选择") {
		alert("请选择员工学历！");
		return false;
	} else if (profession == "") {
		alert("请填写员工所学专业！");
		return false;
	} else if (address == "") {
		alert("请填写员工地址！");
		return false;
	} else if (tel_number == "") {
		alert("请填写员工联系号码！");
		return false;
	} else if (mail == "") {
		alert("请填写员工邮箱！");
		return false;
	} else if (photo == "") {
		alert("请上传一张员工照片！");
		return false;
	}
	return true;

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
