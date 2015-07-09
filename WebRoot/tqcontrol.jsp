<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/lbd.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="js/tq.js"></script>
		<!--[if IE 6]>
	<script src="js/IE6PNG.js"></script>
	<script type="text/javascript">
		IE6PNG.fix('.png');
	</script>
<![endif]-->
		<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 200			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 120
	});
	$(".zxselect").uedSelect({
		width : 120
	});
	$(".fxselect").uedSelect({
		width : 120
	});
});
</script>
	</head>

	<body>

		<div id="usual1" class="usual" style="margin: 15px;">

			<div class="itab">
				<ul>
					<li>
						<a href="#tab1" class="selected">特勤控制</a>
					</li>

				</ul>
			</div>


			<div style="width: 100%; float: left; margin-top: 15px;">
				<div class="lleft lbdinfo ">
					<div style="float: left; line-height: 35px; width: 90%;">

						<label>
							时段选择：
						</label>
						<div class="vocation">
							<select id="timetype" name="timetype" class="select1"
								onchange="changeTimeSelect()">
								<option <s:if test="timetype==0">selected</s:if> value="0">
									普通日
								</option>
								<option <s:if test="timetype==1">selected</s:if> value="1">
									周日
								</option>
								<option <s:if test="timetype==2">selected</s:if> value="2">
									特殊日
								</option>
							</select>
						</div>
					</div>

					<div style="float: left; line-height: 35px; width: 90%;">
						<label>
							时段细分：
						</label>
						<div class="vocation">
							<select name="select3" id="orderid" class="select1"
								onchange="changeTimeSelect()">
								<option <s:if test="orderid==0">selected</s:if> value="0">
									时间段0
								</option>
								<option <s:if test="orderid==1">selected</s:if> value="1">
									时间段1
								</option>
								<option <s:if test="orderid==2">selected</s:if> value="2">
									时间段2
								</option>
								<option <s:if test="orderid==3">selected</s:if> value="3">
									时间段3
								</option>
								<option <s:if test="orderid==4">selected</s:if> value="4">
									时间段4
								</option>
								<option <s:if test="orderid==5">selected</s:if> value="5">
									时间段5
								</option>
								<option <s:if test="orderid==6">selected</s:if> value="6">
									时间段6
								</option>
								<option <s:if test="orderid==7">selected</s:if> value="7">
									时间段7
								</option>
								<option <s:if test="orderid==8">selected</s:if> value="8">
									时间段8
								</option>
								<option <s:if test="orderid==9">selected</s:if> value="9">
									时间段9
								</option>
								<option <s:if test="orderid==10">selected</s:if> value="10">
									时间段10
								</option>
								<option <s:if test="orderid==11">selected</s:if> value="11">
									时间段11
								</option>
								<option <s:if test="orderid==12">selected</s:if> value="12">
									时间段12
								</option>
								<option <s:if test="orderid==13">selected</s:if> value="13">
									时间段13
								</option>
								<option <s:if test="orderid==14">selected</s:if> value="14">
									时间段14
								</option>
								<option <s:if test="orderid==15">selected</s:if> value="15">
									时间段15
								</option>
							</select>
						</div>
					</div>


					
					<div style="float: left; line-height: 35px; width: 90%;">
						<label>
							开始时间：
						</label>
						<div class="vocation">
							<span style="margin-right: 5px;"> 
								<input type="time" name="begintime" class="dfinput" id="begintime" style="width: 125px;"  />
									</span>
						</div>
					</div>
					
					<div style="float: left; line-height: 35px; width: 90%;">
						<label>
							<input name="input" type="button" class="scbtn"
							style="margin-top: 15px;" onclick="deleteTqLine()" value="删除当前控制" />
						</label>
					</div>
					
					<div style="width: 100%; float: left; margin-top: 28px;">
						<table width="1000" class="filetable2">
							<thead>
								<tr>
									<th width="4%" height="40"
										style="text-align: center; line-height: 20px; text-indent: 0px;">
										编号
									</th>
									<th width="20%"
										style="text-align: center; line-height: 20px; text-indent: 10px;">
										路口名
									</th>
									<th width="14%"
										style="text-align: left; line-height: 20px; text-indent: 0px;">
										执行相位
									</th>
									<th width="15%"
										style="text-align: left; line-height: 20px; text-indent: 0px;">
										执行时间
									</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="sigVOs" var="sigVO" status="status">
									<tr>
										<td style="text-align: center;">
											<s:property value="id" />
										</td>
										<td style="text-align: center;">
											<s:property value="name" />
										</td>
										<td>
											<s:if test="usefulPhases!=null&&usefulPhases.size()>0">
												<s:select list="usefulPhases" listValue="name"
													listKey="sigid_usefulpid" name="usefulPhaseVO"
													cssClass="zxselect" ></s:select>
											</s:if>
											<s:else>没有可用相位</s:else>
										</td>
										<td>
												<input type="text" alt="执行时间"
													id="<s:property value="id"/>_time" class="dfinput_tqtime"  value="10"
													style="width: 120px;" /> 秒*10
										</td>
									</tr>
								</s:iterator>


							</tbody>
						</table>
					</div>
					<div
						style="width: 90%; float: left; margin-top: 20px; color: #999; text-align: center;">
						注：基准路口距离设置为0，其余路口的距离是与基准路口的距离。允许非对称相位
						<input type="hidden" id="mklid"
							value="<s:property value="mklid"/>" />
					</div>
					<div
						style="width: 90%; float: left; margin-top: 20px; color: #999; text-align: center;">
						<input name="input" type="button" class="scbtn" id="doControl"
							style="margin-top: 15px;"  value="执行特勤控制" />
					</div>
					
					<p>
						&nbsp;
					</p>
				</div>
			</div>
	</body>
</html>
