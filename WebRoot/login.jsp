﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0023)http://www.contoso.com/ -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>欢迎登录信号机管理系统</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<script language="JavaScript" src="js/jquery.js"></script>

		<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script>
		<script type="text/javascript" src="js/pageKit.js"></script>
		<script type="text/javascript">
 
 //设置cookie
function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays*24*60*60*1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}
//获取cookie
function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1);
        if (c.indexOf(name) != -1) return c.substring(name.length, c.length);
    }
    return "";
}
//清除cookie  
function clearCookie(name) {  
    setCookie(name, "", -1);  
    
}  
function checkCookie() {
    var user = getCookie("username");
    if (user != "") {
        alert("Welcome again " + user);
    } else {
        user = prompt("Please enter your name:", "");
        if (user != "" && user != null) {
            setCookie("username", user, 365);
        }
    }
}
//checkCookie(); 


function loadthis(){
	var checkup = getCookie("checkup");
	console.log(checkup);
	if(checkup=='on'){
		console.log("i m in 1");
		document.getElementById("username").value=getCookie("username");
		document.getElementById("password").value=getCookie("password");
		document.getElementById("checkup").checked=true;
	}else{
		console.log("i m in what");
		document.getElementById("username").value="";
		document.getElementById("password").value="";
		document.getElementById("checkup").checked=false;
	}
}

function checkIsUp(){
	 if(document.getElementById("checkup").checked==true){
	 	console.log("checked");
		setCookie('username', document.getElementById("username").value, 365);	 
		setCookie('password', document.getElementById("password").value, 365);	 
		setCookie('checkup', document.getElementById("checkup").value, 365);	 
	 }else{
	 	console.log("unchecked");
	 	clearCookie("username");
		clearCookie("password");
		clearCookie("checkup");
	 }
	 return true;
 }
 </script>
		<!--[if IE 6]>
	<script src="js/IE6PNG.js"></script>
	<script type="text/javascript">
		IE6PNG.fix('.png');
	</script>
<![endif]-->
	</head>

	<body class=" loginbg png"  onload="loadthis()">

		<div class="logintop png">
			<span>欢迎登录信号机管理系统</span>

		</div>

		<div class="loginbody">

			<span class="systemlogo png"></span>

			<div class="loginbox png">
				<div
					style="margin-top: 40px; padding-left: 120px; font-size: 20px; color: #FFF;">
					信号机管理系统
				</div>
				<form action="useroAction!login" method="post" onsubmit="return checkIsUp()">
				<ul style="margin-top: 60px; padding-left: 15px;">
					<li>
						<input name="username" id="username" value="${loginFail }"
							type="text" class="loginuser" placeholder="用户名"
							onFocus="this.value=''" />
					</li>
					<li>
						<input name="password" type="password" id="password"
							class="loginpwd" placeholder="密码" onFocus="this.select()" />
					</li>
					<li>
						<table>
							<tr>
								<td style="padding: 2px;">
									<input name="validate" type="text" id="validate"
										class="loginyzm" placeholder="验证码" onFocus="this.select()" />
								</td>
								<td style="padding: 2px;">
									<span id="im"> <img src="toolkitAction!validateCode"
											width="80" height="32" /> </span>
								</td>
								<td style="padding: 2px;">
									<font style="font-size: 12px;"><a
										href="javascript:changeImage();" id="aim">看不清</a> </font>
								</td>
							</tr>
						</table>



					</li>
					<li>
						<input name="" type="submit" class="loginbtn" value="登录"
							onclick="javascript:window.location='main.html'" />
						<label>
							<input name="checkup" id="checkup" type="checkbox"
								checked="checked" style="margin-bottom: 8px;" />
							记住密码
						</label>
					</li>
				</ul>
				</form>

			</div>

		</div>



		<div class="loginbm png">
			软件技术支持：477937204@qq.com
		</div>


	</body>
</html>
