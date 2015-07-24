<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
 
 function getCookie(c_name)      //根据分隔符每个变量的值
 {
     if (document.cookie.length > 0) {
         c_start = document.cookie.indexOf(c_name + "=")
         if (c_start != -1) { 
             c_start = c_start + c_name.length + 1;
             c_end = document.cookie.indexOf("^",c_start);
             if (c_end==-1)
                 c_end=document.cookie.length;
             return unescape(document.cookie.substring(c_start,c_end));
     } 
   }
     return "";
 }
 
 function setCookie(c_name, n_value, p_name, p_value, expiredays)        //设置cookie
 {
     var exdate = new Date();
     exdate.setDate(exdate.getDate() + expiredays);
     document.cookie = c_name + "=" + escape(n_value) + "^" + p_name + "=" + escape(p_value) + ((expiredays == null) ? "" : "^;expires=" + exdate.toGMTString());
     console.log(document.cookie)
 }
 
 function checkCookie()      //检测cookie是否存在，如果存在则直接读取，否则创建新的cookie
 {
     
     var username = getCookie('username');
     var password = getCookie('password');
     if (username != null && username != "" && password != null && password != "") {
         
         document.getElementById("username").value = username;
         document.getElementById("password").value = password;
     }
     else {
     	 //document.getElementById("username").value = "";
         document.getElementById("password").value = "";
         
     }
     
 }
 
 function cleanCookie (c_name, p_name) {     //使cookie过期
     document.cookie = c_name + "=" + ";" + p_name + "=" + ";expires=Thu, 01-Jan-70 00:00:01 GMT";
 }
 function checkIsUp(){
	 if(document.getElementById("checkup").checked==true){
		setCookie('username', document.getElementById("username").value, 'password', document.getElementById("password").value, 365);	 
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

	<body class=" loginbg png">

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
