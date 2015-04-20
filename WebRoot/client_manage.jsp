<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户信息管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <h2>用户信息管理</h2>
    <table width="50%" border="1">
    	<tr>
    		<td>编号</td>
    		<td>用户名</td>
    		<td>密码</td>
    		<td>权限</td>
    	</tr>
    	<s:iterator value="clients" var="client">
    	<tr>
    		<td><s:property value="id"/></td>
    		<td><s:property value="username"/></td>
    		<td><s:property value="password"/></td>
    		<td><s:property value="limits"/></td>
    	</tr>
    	</s:iterator>
    </table>
  </body>
</html>
