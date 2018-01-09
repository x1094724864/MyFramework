<%@ page language="java" contentType="text/html; charset=UTF-8"  
pageEncoding="UTF-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<script type="text/javascript" src="../js/jquery-1.4.4.min.js"></script>  
<script type="text/javascript" src="../js/jquery.form_utf8.js"></script>  
<link rel="stylesheet" href="../css/rabb.css">  
<title>Insert title here</title>  
</head>  
<body>  
    <div id="mask">  
    </div>  
    <div id="login">  
        <span id="close_login">×</span>  
        <form name="loginForm" id="loginForm"  action="../login/checkLogin">  
        <ul>  
            <li><input name="code" id="code" type="text" placeholder="请输入验证码" class="input_code">  
            <img id="licenceImg" src="../login/maskCode" border="0" width="80px" height="30px" align="absmiddle" alt='验证码,看不清楚? 请点击刷新验证码' onClick="refreshImage();" style="cursor: pointer;">  
            <a href="javascript:refreshImage();" style="font-size: 12px;color:#FF7F50;margin-left: 2px;">换一张</a>  
            </li>  
            <li style="margin-top:40px;"><input onclick="showRequest();" type="submit" class="input_submmit" onvalue="登录"/>  
            </li>  
            <li><span id="loginInfo" style="font-size: 14px;color:#FF7F50;margin-left: 2px;"></span></li>  
        </ul>  
    </div>  
    <div class="more">  
        <div class="menudiv"><a href="javascript:;" id="btn">登录</a><a href="javascript:;" id="btn2">退出</a></div>  
    </div>  
</body>  
  
<script type="text/javascript">  
$(document).ready(function() {  
    var options = {  
        beforeSubmit : showRequest, // pre-submit callback   
        success : showResponse, // post-submit callback   
        dataType : 'xml',  
        resetForm : false  
    };  
    $('#loginForm').ajaxForm(options);  
    var user = "${username}";  
    if(user!=''){  
        $("#btn").html("当前用户："+user);  
        $("#btn2").show();  
        $("#btn2").click(function(){  
            $("#mask").show();  
            $("#login").show();  
            window.location.href = "../login/logout";  
        });  
    }else{  
        $("#btn").click(function(){  
            $("#mask").show();  
            $("#login").show();  
            $("#loginInfo").html("");  
        });  
        $("#close_login").click(function(){  
            $("#mask").hide();  
            $("#login").hide();  
        });  
    }  
});  
  
function showRequest() {  
    if($("#username").val()==""){  
        $("#loginInfo").html("请输入用户名！");  
        return false;  
    }else if($("#password").val()==""){  
        $("#loginInfo").html("请输入密码！");  
        return false;  
    }else if($("#code").val()==""){  
        $("#loginInfo").html("请输入验证码！");  
        return false;  
    }else{  
        $("#loginInfo").html("正在登陆...");  
        return true;  
    }  
      
}  
function showResponse(responseXML){  
    var result = $("result", responseXML).text();  
    var status = $("status", responseXML).text();  
    $("#loginInfo").html(result);  
    if(status==6){  
        window.location.href = "../hellorabbit/login";  
    }  
}  
function refreshImage(img) {  
    var imageUrl = 'authCode'; //生成图片  
    var imgs = document.getElementById("licenceImg");  
    imgs.src = imageUrl + '?' + Math.random();  
}  
</script>  
</html>  