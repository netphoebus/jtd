﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
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
<!--[if IE 6]>
	<script src="js/IE6PNG.js"></script>
	<script type="text/javascript">
		IE6PNG.fix('.png');
	</script>
<![endif]-->
</head>	

<body  class=" loginbg png" >

<div class="logintop png">    
    <span>欢迎登录信号机中心管理系统平台</span>    
     
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo png"></span> 
       
    <div class="loginbox png">
<div style="padding-top:40px; padding-left:120px; font-size:20px; color:#FFF;">信号机中心管理控制平台</div>
<form action="useroAction!login" method="post">
    <ul>
    <li><input name="username" type="text" class="loginuser" value="${loginFail}" onclick="JavaScript:this.value=''"/></li>
    <li><input name="password" type="password" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
    <li><input type="submit" type="button" class="loginbtn" value="登录"/><label>
    <input name="" type="checkbox" value="" checked="checked" style="margin-bottom:8px;" />记住密码</label></li>
    </ul>
</form>    
    </div>
    </div>
    <div class="loginbm png">技术支持：477937204@qq.com </div>
    
</body>
</html>
