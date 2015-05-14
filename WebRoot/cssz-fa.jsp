<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> <%
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
							<a href="cssz-cs.jsp">一般参数</a>
						</li>

						<li>
							<a href="#tab3" class="selected">相位方案</a>
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
										<s:select list="solutions"  id="solutions"
							listKey="id" listValue="name" onchange="changeLine()"></s:select>
									</div>
									<b>*</b>
								</div>
							</li>
						</ul>
						<div>
							<div class="xwlb">
								<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号01
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
								<!--单个相位图li结束 -->
								<ul>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号02
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号03
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号04
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号05
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号06
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号07
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号08
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号09
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号10
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号11
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号12
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号13
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号14
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号15
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号16
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号17
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号18
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号19
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号20
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号21
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号22
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号23
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号24
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号25
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号26
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号27
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号28
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号29
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号30
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号31
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img class="l03" src="images/rod/l030_2.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img alt="东西方向人行道" class="l03" src="images/rod/l030.png" width="15" /><img  class="l03" src="images/rod/l030_2.png" width="15" />
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
															<img id="l02" src="images/rod/l020.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l01" src="images/rod/l010.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l00" src="images/rod/l000.png" alt="东向西左拐"
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
															<img id="l32" src="images/rod/l320.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l31" src="images/rod/l310.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l30" src="images/rod/l300.png" alt="北向南左拐" width="15"
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
															<img id="l10" src="images/rod/l100.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="l11" src="images/rod/l110.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="l12" src="images/rod/l120.png" alt="南向北右拐" width="15"
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
															<img  id="l20" src="images/rod/l200.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l21" src="images/rod/l210.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="l22" src="images/rod/l220.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhup" style="margin-left: 155px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" /><img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030.png" alt="南北人行道" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="l13" src="images/rod/l030_2.png" alt="南北人行道" width="15" />
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<h1>
										序号32
									</h1>
									<btn>清 空</btn>
									<btn>全 红</btn>
								</li>
								</ul>
							</div>


							<div class="xwbtn">
								<ul class="toolbar">
									<!--
         <li><span><img src="images/previous.png" alt="" width="24" height="24" /></span>上一相位</li>
          -->
									<li>
										<span><img src="images/note-2.png" alt="" /> </span>保存相位方案
									</li>
									<!--
         <li><span><img src="images/next.png" alt="" width="24" height="24" /></span>下一相位</li>
          -->


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
