// 判断部门名是包含空格，以及长度是否符合要求，另外异步验证部门名是否已存在
//var  checkedDepartName = true;
var  checkedDepartName = false;
//幻觉了？
function checkDepartName() {
	var departmentName = $('#departmentName').val();
	if (departmentName.indexOf(" ") != -1) {
		alert("部门名不能包含空格，请重新输入");
		return checkedDepartName = false;
	} else if (departmentName == "") {
		alert("请填写部门名");
		return checkedDepartName = false;
	} else if (departmentName.length < 3) {
		alert("部门名太短，请重新输入");
		return checkedDepartName = false;
	} else if (departmentName.length > 8) {
		alert("部门名太长，请重新输入");
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
					alert("该部门已存在！请重新填写部门名称!");
					return checkedDepartName = false;
				} else {
					// $('#depart_name_span').html("部门名可用").css("color",
					// "green");
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
		alert("请填写部门编号");
		return checkedDepartNum = false;
	} else if (expr.test(departmentNum)) {
		alert("部门编号不能是非数字字符");
		return checkedDepartNum = false;
	} else {
		$.ajax({
			type : "Post",
			contentType : "application/json",
			url : "departIsExistByDepartNum?departmentNum=" + departmentNum,
			processData : false,
			dataType : "json",
			data : "{}",
			success : function(data) {
				if (data) {
					alert("该部门编号已存在！请重新填写部门编号!");
					return checkedDepartNum = false;
				} else {
					return checkedDepartNum = true;
				}
			}
		});
	}
}

// 检查部门描述
//function checkDepartDesc() {
//	var department_desc = $('#department_desc').val();
//	$('#depart_desc_span').html("");
//	if (department_desc == "") {
//		$('#depart_desc_span').html("多少写一下吧！").css("color", "red");
//		return checkedDepartDesc = false;
//	} else if (department_desc.length < 10) {
//		$('#depart_desc_span').html("太少了，没法了解啊！").css("color", "red");
//		return checkedDepartDesc = false;
//	} else if (department_desc.length > 400) {
//		$('#depart_desc_span').html("描述太多啦！请精简一些~").css("color", "red");
//		return checkedDepartDesc = false;
//	} else {
//		$('#depart_desc_span').html("就先说这么多吧！").css("color", "green");
//		return checkedDepartDesc = true;
//	}
//}


$(document).ready(function() {
	$("#department_desc").keyup(function() {
		var department_desc = $('#department_desc').val();
		var length = 400;
		var content_len = $("#department_desc").val().length;
		var in_len = length - content_len;

		// 当用户输入的字数大于制定的数时，让提交按钮失效
		// 小于制定的字数，就可以提交

		if (content_len <=400) {
			$("#depart_desc_span").html(content_len);
			 $("#submitDepart").attr("disabled", false);
			// 可以继续执行其他操作
			 return checkedDepartDesc = true; 
		} else {
			$("#depart_desc_span").html(content_len).css("color","red");
			 $("#submitDepart").val('qunima');
			return checkedDepartDesc = false;
		}

	});
});

function saveDepart() {
	var departmentName = $('#departmentName').val();
	var departmentNum = $('#departmentNum').val();
	var department_desc = $('#department_desc').val();

	if (checkedDepartName && checkedDepartNum && checkedDepartDesc) {
//		document
//				.write("<form action='saveDepart' method='post' name='saveDepart' style='display:none'>");
//		document.write("<input type='hidden' name='departmentNum' value='"
//				+ departmentNum + "'/>");
//		document.write("<input type='hidden' name='departmentName' value='"
//				+ departmentName + "'/>");
//		document.write("<input type='hidden' name='department_desc' value='"
//				+ department_desc + "'/>");
//		document.write("</form>");
//		document.saveDepart.submit();
		saveDepartForm.submit();
		alert("部门信息填写完成！确认跳转");
	} else {
		alert("填写的信息不符合要求哦~~~请检查之后再提交吧！");
	}
}
