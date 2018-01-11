// 判断部门名是包含空格，以及长度是否符合要求，另外异步验证部门名是否已存在
//var  checkedDepartName = true;
//var  checkedDepartName = false;
function checkDepartName() {
	var departmentName = $('#departmentName').val();
	$('#depart_name_span').html("");
	if (departmentName.indexOf(" ") != -1) {
		$('#depart_name_span').html("部门名不能包含空格，请重新输入").css("color", "red");
		return checkedDepartName = false;
	} else if (departmentName == "") {
		$('#depart_name_span').html("请填写部门名").css("color", "red");
		return checkedDepartName = false;
	} else if (departmentName.length < 3) {
		$('#depart_name_span').html("部门名太短，请重新输入").css("color", "red");
		return checkedDepartName = false;
	} else if (departmentName.length > 8) {
		$('#depart_name_span').html("部门名太长，请重新输入").css("color", "red");
		return checkedDepartName = false;
	} else {
		$.ajax({
			type : "Post",
			contentType : "application/json",
			url : "departIsExistByDepartName?departmentName=" + departmentName,
			processData : false,
			dataType : "json",
			data : "{}",
			success : function(data) {
				if (data) {
					// $('#username_span').html("该部门名已存在！").css("color", "red");
					alert("该部门已存在！");
					$('#depart_num_span').html("请重新填写部门名称").css(
							"color", "red");
					return checkedDepartName = false;
				} else {
					$('#depart_name_span').html("部门名可用").css("color", "green");
					return checkedDepartName = true;
				}
			}
		});
	}
	return checkedDepartName = false;
}

// 检查部门编号
function checkDepartNum() {
	// 利用正则表达式对输入数据匹配
	var departmentNum = $('#departmentNum').val();
	$('#depart_num_span').html("");
	// 匹配到一个非数字字符，则返回false
	var expr = /\D/i;
	if (departmentNum == "") {
		$('#depart_num_span').html("请填写部门编号").css("color", "red");
		return checkedDepartNum = false;
	} else if (expr.test(departmentNum)) {
		// $('#depart_num_span').html("不能输入非数字字符").css("color", "red");
		alert("部门编号不能是非数字字符");
		return checkedDepartNum = false;
	} else {
		$
				.ajax({
					type : "Post",
					contentType : "application/json",
					url : "departIsExistByDepartNum?departmentNum="
							+ departmentNum,
					processData : false,
					dataType : "json",
					data : "{}",
					success : function(data) {
						if (data) {
							// $('#username_span').html("该部门名已存在！").css("color",
							// "red");
							alert("该部门编号已存在！");
							$('#depart_num_span').html("请重新填写部门编号").css(
									"color", "red");
							return checkedDepartNum = false;
						} else {
							$('#depart_num_span').html("部门编号可用").css("color",
									"green");
							return checkedDepartNum = true;
						}
					}
				});
	}
}

// 检查部门描述
function checkDepartDesc() {
	var department_desc = $('#department_desc').val();
	$('#depart_desc_span').html("");
	if (department_desc == "") {
		$('#depart_desc_span').html("多少写一下吧！").css("color", "red");
		return checkedDepartDesc = false;
	} else if (department_desc.length < 10) {
		$('#depart_desc_span').html("太少了，没法了解啊！").css("color", "red");
		return checkedDepartDesc = false;
	} else if (department_desc.length > 400) {
		$('#depart_desc_span').html("描述太多啦！请精简一些~").css("color", "red");
		return checkedDepartDesc = false;
	} else {
		$('#depart_desc_span').html("就先说这么多吧！").css("color", "green");
		return checkedDepartDesc = true;
	}
}

function saveDepart() {
	var departmentName = $('#departmentName').val();
	var departmentNum = $('#departmentNum').val();
	var department_desc = $('#department_desc').val();

	if (checkedDepartName && checkedDepartNum && checkedDepartDesc) {
		document
				.write("<form action='saveDepart' method='post' name='saveDepart' style='display:none'>");
		document.write("<input type='hidden' name='departmentNum' value='"
				+ departmentNum + "'/>");
		document.write("<input type='hidden' name='departmentName' value='"
				+ departmentName + "'/>");
		document.write("<input type='hidden' name='department_desc' value='"
				+ department_desc + "'/>");
		document.write("</form>");
		document.saveDepart.submit();

		alert("部门信息填写完成！确认跳转");
	}else{
		alert("填写的信息不符合要求哦~~~请检查之后再提交吧！");
	}
}
