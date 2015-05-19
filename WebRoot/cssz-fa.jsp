<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath(); String basePath =
request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>相位方案</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<link href="css/stilearn-helper.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="js/jquery.js"></script>
		<script src="js/stilearn-base.js"></script>
		<script src="js/holder.js"></script>

		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>
		<script type="text/javascript" src="js/privatecssz.js"></script>
		<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>

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
  $(".select4").uedSelect({
    width : 150
  });
});
</script>

	</head>

	<body>
		<div class="formbody">
			<div id="usual1" class="usual">
				<div class="itab">
					<ul>
						<li>
							<a href="sigpublicparamAction!publicParam?id=<s:property value="#session.id"/>">一般参数</a>
						</li>
						<li>
							<a href="solutionAction!solutions" class="selected">相位方案</a>
						</li>
						<li>
							<a href="cssz-time.jsp">时间段参数</a>
						</li>
					</ul>
				</div>

				<div id="tab3" class="tabson">
					<div style="width: 100%; float: left;">
						<ul class="forminfo">
							<li></li>
							<li>
								<div style="float: left; line-height: 35px;">
									<label>
										选择相位方案：
									</label>
									<div class="vocation">
										<s:select list="solutions" name="solution.id"  id="solutions"
							listKey="id" listValue="soluname" value="solution.id" onchange="changeSolution()" cssClass="select1"></s:select>
									</div>
									<b>*</b>
								</div>
							</li>
						</ul>
						<div>
							<div class="xwlb">
							<s:iterator value="steps" var="step" status="status">
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img class="${step.id}23" alt="东西方向人行道西面上边" class="l23" src="images/rod/l230.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
											
												<img class="${step.id}03" alt="东西方向人行道东面上边" class="l03" src="images/rod/l030.png" width="15" />
											
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
											<!--  
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
												-->
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
											<!-- 
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
												-->
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img  id="${step.id}33" alt="南北方向人行道北面左边" class="l33" src="images/rod/l330.png" width="15" />
												<!-- 
												<img class="l03" src="images/rod/l030_2.png" width="15" />
											-->
											</div>
											<div class="xhup" style="margin-left: 155px;">
											
												<img id="${step.id}33" alt="南北方向人行道北面右边" class="l33" src="images/rod/l330.png" width="15" />
													<!-- 
												<img  class="l03" src="images/rod/l030_2.png" width="15" />
											-->
											</div>
										</div>
										
										<div style="height: 110px; width: 100%; float: left;">
											<div class="xleftdown">
												<table width="18" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="2"></td>
													</tr>
													<tr>
														<td align="center">
															<img id="${step.id}02"  src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="${step.id}01"  src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="${step.id}00"   src="images/rod/l000.png" alt="东向西左拐"
																width="15" height="15" />
														</td>
													</tr>
												</table>
											</div>
											<div class="xrightdown">
												<table width="50" height="18" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="2" height="18"></td>
														<td>
															<img id="${step.id}32"  src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="${step.id}31"  src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img  id="${step.id}30"  src="images/rod/l300.png" alt="北向南左拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
											<div class="xleftup">
												<table width="50" height="18" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="2" height="18"></td>
														<td>
															<img id="${step.id}10"  src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="${step.id}11"  src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="${step.id}12"  src="images/rod/l120.png" alt="南向北右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
											<div class="xrightup">
												<table width="18" border="0" align="center" cellpadding="0"
													cellspacing="0">
													<tr>
														<td height="2"></td>
													</tr>
													<tr>
														<td align="center">
															<img  id="${step.id}20"  src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="${step.id}21"  src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="${step.id}22"  src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
											
												<img class="${step.id}13"  src="images/rod/l130.png" alt="南北方向人行道南面左边" width="15" />
												<!-- 
												<img class="l13" src="images/rod/l130_2.png" alt="南北人行道" width="15" />
												-->
											</div>
											<div class="xhup" style="margin-left: 155px;">
											
												<img class="${step.id}13"  src="images/rod/l130.png" alt="南北方向人行道南面右边" width="15" />
												<!--  
												<img class="l13" src="images/rod/l130_2.png" alt="南北人行道" width="15" />
													-->
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												
												<img  class="${step.id}23"  src="images/rod/l230.png" alt="东西方向人行道西面下边" width="15" />
											
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
											
												<img class="${step.id}03"  src="images/rod/l030.png" alt="东西方向人行道东面下边" width="15" />
											
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
											 <!--  
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
													-->
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
											<!--
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
												-->
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号<s:property value="#status.count"/>
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
							</s:iterator>

							<div class="xwbtn" >
								<ul class="toolbar">
									<li style="height: 36px;width: 150px;">
										<span><img src="images/note-2.png" alt="" /> </span>保存相位方案
									</li>
								</ul>
							</div>
						</div>


					</div>
					<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>

					<script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

				</div>
	</body>
</html>
