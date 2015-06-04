<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
		<title>时间参数</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<link href="css/stilearn-helper.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="js/jquery.js"></script>
		<script src="js/stilearn-base.js"></script>
		<script src="js/holder.js"></script>

		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>
		<script type="text/javascript" src="js/privatecssz-time.js"></script>
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
							<a href="sigpublicparamAction!publicParam">一般参数</a>
						</li>
						<li>
							<a href="solutionAction!solutions">相位方案</a>
						</li>
						<li>
							<a href="sigtimeAction!sigtimes" class="selected"> 时间段参数</a>
						</li>
					</ul>
				</div>
	
				<div id="tab2" class="tabson">
					<ul class="forminfo">
						<li>
						</li>
						<li>
							<div style="float: left; line-height: 35px;">
								<label>
									时间段选择：
								</label>
								<div class="vocation">
									<select id="timetype" name="timetype" class="select1" onchange="changeTimeSelect()">
										<option value="1">
											普通日
										</option>
										<option value="2">
											周日
										</option>
										<option value="3">
											特殊日
										</option>
									</select>
								</div>
								<b>*</b>
							</div>
							<div style="float: left; line-height: 35px; padding-left: 20px;">
								<label>
									时间段细分：
								</label>
								<div class="vocation">
									<s:select list="commontimesVO"   listValue="commontimename" listKey="cid"   id="timeid"
						             name="commontimeVO" value="commontime.id" cssClass="select1" onchange="changeTimeSelect()"></s:select>  
								</div>
								<b>*</b>
							</div>
							<div style="float: left; line-height: 35px; padding-left: 20px;">
								<ul class="toolbar">
									<li onclick="updateStepTimes()" class="click" style="height: 28px; line-height: 28px;">
										<span><img src="images/time.png" alt="" width="24"
												height="24" />
										</span>保存相位执行时间
									</li>
								</ul>
							</div>
						</li>
					</ul>
					<div style="width: 100%; float: left;">
						<div class="csleft" style="line-height: 35px;">
						<form id="sigtimeform" name="sigtimeform" action="sigtimeAction!update"
									method="post">
									<s:hidden name="commontime.id"></s:hidden>
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="right">
										<label style="margin-right: 20px">
											时
										</label>
									</td>
									<td>
										<s:textfield name="commontime.hour" cssClass="dfinput"
									cssStyle="width:150px;"></s:textfield>
									</td>
								</tr>
								<tr>
									<td align="right">
										<label style="margin-right: 20px"> 
											分
										</label>
									</td>
									<td>
									<s:textfield name="commontime.minute" cssClass="dfinput"
									cssStyle="width:150px;"></s:textfield>
									</td>
								</tr>
								<tr>
									<td align="right">
										<label style="margin-right: 20px">
											秒
										</label>
									</td>
									<td>
										<s:textfield name="commontime.seconds" cssClass="dfinput"
									cssStyle="width:150px;"></s:textfield>
									</td>
								</tr>
								<tr>
									<td align="right">
										<label style="margin-right: 20px">
											控制方式
										</label>
									</td>
									<td >
										<s:select list="#{1:'无电缆联动',2:'其他控制方式'}"
								name="commontime.workingway" listKey="key" listValue="value" cssClass="select4"></s:select>
									</td>
								</tr>
								<tr>
									<td align="right">
										<label style="margin-right: 20px">
											相位方案
										</label>
									</td>
									<td style="margin-left:10px">
								 
											<s:select list="solutions"   listValue="soluname" listKey="id"   id="soid"
						             name="commontime.workingprogram" value="solution.id" cssClass="select4"  onchange="changeSelect()"></s:select> 
									</td>
								</tr>
								<tr>
									<td align="right">
										<label style="margin-right: 20px">
											绿闪时间
										</label>
									</td>
									<td>
										<s:textfield name="commontime.lstime" cssClass="dfinput"
									cssStyle="width:150px;"></s:textfield>
									</td>
								</tr>
								<tr>
									<td align="right">
										<label style="margin-right: 20px">
											黄灯时间
										</label>
									</td>
									<td>
										<s:textfield name="commontime.hdtime" cssClass="dfinput"
									cssStyle="width:150px;"></s:textfield>
									</td>
								</tr>
								<tr>
									<td align="right">
										<label style="margin-right: 20px">
											红灯时间
										</label>
									</td>
									<td>
										<s:textfield name="commontime.qchdtime" cssClass="dfinput"
									cssStyle="width:150px;"></s:textfield>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="right">
										<div style="line-height: 35px;">
											<input name="input5" type="submit" class="scbtn"
												style="margin-right: auto; margin-right: auto; height: 25px;"
												value="保存参数" onclick="" />
										</div>
									</td>
								</tr>
							</table>
							</form>
						</div>
						<div class="csright">
							<div class="xwlb">
							<s:iterator value="steptimes" var="step" status="status">
									<!--单个相位图li开始 -->
								<li>
									<!--相位图开始 -->
									<div class="picbox">
										<div style="width: 100%; float: left; height: ">
											<div class="xhu">
											</div>
											<div class="xhu" style="margin-left: 135px;">
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												<img class="${step.id}_2_3" alt="东西方向人行道西面上边" class="l23" src="images/rod/l23${step.roads[3].rxcolor}.png" width="15" />
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
												<img class="${step.id}_0_3" alt="东西方向人行道东面上边" class="l03" src="images/rod/l03${step.roads[0].rxcolor}.png" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
												<img  class="${step.id}_3_3" alt="南北方向人行道北面左边"  src="images/rod/l33${step.roads[3].rxcolor}.png" width="15" />
											</div>
											<div class="xhup" style="margin-left: 165px;">
												<img class="${step.id}_3_3" alt="南北方向人行道北面右边" src="images/rod/l33${step.roads[3].rxcolor}.png" width="15" />
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
															<img id="${step.id}_0_2"  src="images/rod/l02${step.roads[0].rightcolor}.png" alt="东向西右拐"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="${step.id}_0_1"  src="images/rod/l01${step.roads[0].linecolor}.png" alt="东向西直行"
																width="15" height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="${step.id}_0_0"   src="images/rod/l00${step.roads[0].leftcolor}.png" alt="东向西左拐"
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
															<img id="${step.id}_3_2"  src="images/rod/l32${step.roads[3].rightcolor}.png" alt="北向南右拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="${step.id}_3_1"  src="images/rod/l31${step.roads[3].linecolor}.png" alt="北向南直行" width="15"
																height="15" />
														</td>
														<td>
															<img  id="${step.id}_3_0"  src="images/rod/l30${step.roads[3].leftcolor}.png" alt="北向南左拐" width="15"
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
															<img id="${step.id}_1_0"  src="images/rod/l10${step.roads[1].leftcolor}.png" alt="南向北左拐" width="15"
																height="15" />
														</td>
														<td>
															<img id="${step.id}_1_1"  src="images/rod/l11${step.roads[1].linecolor}.png" alt="南向北直行" width="15"
																height="15" />
														</td>
														<td>
															<img id="${step.id}_1_2"  src="images/rod/l12${step.roads[1].rightcolor}.png" alt="南向北右拐" width="15"
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
															<img  id="${step.id}_2_0"  src="images/rod/l20${step.roads[2].leftcolor}.png" alt="西向东左拐" width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="${step.id}_2_1"  src="images/rod/l21${step.roads[2].linecolor}.png" alt="西向东直行"  width="15"
																height="15" />
														</td>
													</tr>
													<tr>
														<td align="center">
															<img id="${step.id}_2_2"  src="images/rod/l22${step.roads[2].rightcolor}.png" alt="西向东右拐" width="15"
																height="15" />
														</td>
													</tr>
												</table>
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhup">
											
												<img class="${step.id}_1_3"  src="images/rod/l13${step.roads[1].rxcolor}.png" alt="南北方向人行道南面左边" width="15" />
											</div>
											<div class="xhup" style="margin-left: 165px;">
											
												<img class="${step.id}_1_3"  src="images/rod/l13${step.roads[1].rxcolor}.png" alt="南北方向人行道南面右边" width="15" />
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
												
												<img  class="${step.id}_2_3"  src="images/rod/l23${step.roads[2].rxcolor}.png" alt="东西方向人行道西面下边" width="15" />
											
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
											
												<img class="${step.id}_0_3"  src="images/rod/l03${step.roads[0].rxcolor}.png" alt="东西方向人行道东面下边" width="15" />
											
											</div>
										</div>
										<div style="width: 100%; float: left; height: ">
											<div class="xhu" style="margin-top: 0px;">
											</div>
											<div class="xhu" style="margin-left: 135px; margin-top: 0px;">
											</div>
										</div>
									</div>
									<!--相位图结束 -->
									<txt>
									<h1>
										序号<s:property value="#status.index"/>
									</h1>
									<s:property value="phasename"/>：
										<input value="${step.second}" name="${step.id}_${step.stepname}" class="timeinput" style="width: 60px; height: 20px;"/>
									秒	
									</txt>
								</li>
							</s:iterator>

							</div>
						</div>
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
