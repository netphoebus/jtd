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
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>用户修改</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<link href="css/stilearn-helper.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script src="js/stilearn-base.js"></script>
		<script src="js/holder.js"></script>

		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>

		<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 200			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
		<script type="text/javascript" src="js/pageKit.js"></script>
	</head>

	<body>

		<div class="formbody">


			<div id="usual1" class="usual">

				<div class="itab">
					<ul>

						<li>
							<a href="#tab4" class="selected">用户修改</a>
						</li>
						<!--
    <li><a href="#tab3">权限分配</a></li> 
  -->
					</ul>
				</div>




				<div id="tab4" class="tabson">
				
				<form action="useroAction!update" method="post">
					<ul class="forminfo">
						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="85">
										<label>
											登录名：
										</label>
									</td>
									<td width="220">
										<s:hidden name="page"/>
										<s:hidden name="usero.id"></s:hidden>
										<s:textfield name="usero.username" cssClass="dfinput"
											 cssStyle="width:200px;"></s:textfield>
										<b>*</b>
									</td>
									<td>
										&nbsp;
									</td>
								</tr>
							</table>
						</li>

						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="85">
										<label>
											密 码：
										</label>
									</td>
									<td width="220">
										<s:textfield name="usero.password" cssClass="dfinput"
											cssStyle="width:200px;"></s:textfield>
										<b>*</b>
									</td>
									<td>
										&nbsp;
									</td>
								</tr>
							</table>
						</li>
						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="85">
										<label>
											重新输入密码：
										</label>
									</td>
									<td width="220">
										<s:textfield name="newpwd" cssClass="dfinput"
											cssStyle="width:200px;"></s:textfield>
										<b>*</b>
									</td>
									<td>
										&nbsp;
									</td>
								</tr>
							</table>
						</li>
						<li>
							<div style="float: left; line-height: 35px;">
								<label>
									所属角色：
								</label>
								<div class="vocation">
									<s:select list="#{0:'超级管理员',1:'管理员',2:'普通用户'}" listKey="key"
										listValue="value" name="usero.ulimit" cssClass="select1"></s:select>
								</div>
								<b>*</b>
							</div>
						</li>


						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="85">
										&nbsp;
									</td>
									<td>
									<s:token></s:token>
										<input value="保存" type="submit" class="scbtn" />
									</td>
								</tr>
								
							</table>
						</li>
					</ul>
					</form>
					
					
				</div>


				<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>

				<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>





			</div>

		</div>

	</body>
</html>
