
function chageCode() {
	$('#codeImage').attr('src', 'authCode?abc=' + Math.random());
	// 链接后添加Math.random，确保每次产生新的验证码，避免缓存问题。
}

function trueOrFalse() {
	var inputCode = $('#authCode').val();
	if (inputCode == "") {
		alert("请填写验证码");
	} else {
		alert("进入ajax");
		$.ajax({
			type : "Post",
			contentType : "application/json",
			// url : chageCode(),
			url : "trueOrFalse?inputCode="+inputCode,
			processData : false,
			dataType : "json",
			data : "{}",
			success : function(data) {
				alert("后台传来的是" + data);
			},
			error : function(data) {
				alert("inputCode:" + inputCode);
			}
		});
	}

	alert("后台dsdas传来的是");
}
