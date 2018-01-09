function getCode() {
	var realCode;
	var msg;
	var inputCode = $('#authCode').val();
	if (inputCode == "") {
		alert("请输入验证码");
		return false;
	} else {
		alert("进入Ajax");
		$.ajax({
			type : "post",
			contentType : 'application/json',
			async : true,
			url : "checkCode?inputCode="+inputCode,
			processData : false,
//			dataType : "json",

//			data : '{"result":"' + realCode + '","msg":"' + msg + '"}',
//
			dataType : "json",
			data : "{}",
//			data : {
//				"result" : realCode,
//				"msg" : msg,
//			},
			error : function() {
				hideLoadingDialog();
				alert("异常");
			},
			success : function(date) {
//				alert("data.result" + data.result);
//				alert("data.ro" + data.ro);
				alert("data=" + date);
//				alert("data=" + ro.result);
//				alert("data=" + ro.msg);
			}
		});

	}
	// 加密
	// password = $.md5(password);

	showLoadingDialog("登录中，请稍后...");

}
