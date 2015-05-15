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
		<title>日志管理</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<link href="css/stilearn-helper.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="js/jquery.js"></script>
		<script src="js/stilearn-base.js"></script>
		<script src="js/holder.js"></script>

		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>
		<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
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
							<a href="#tab3" class="selected">用户日志管理</a>
						</li>
						<li>
							<a href="#tab4">设备状态日志</a>
						</li>
					</ul>
				</div>





				<div id="tab3" class="tabson">
					<form action="oplogAction!list" method="post">
					<ul class="forminfo">
						<li>
							<div style="float: left; line-height: 35px;">
								<label>
									用户名：
								</label>
								<div class="vocation">
									<s:select list="useros" name="uid" cssClass="select1" listKey="id" listValue="username"></s:select>
								</div>
								<b>*</b>
							</div>
						</li>
						<li>
							<div style="float: left; line-height: 35px;">
								<label>
									操作类型：
								</label>
								<div class="vocation">
									<s:select list="#{0:'未选择',1:'登陆',2:'操作信号机'}" name="logtype" cssClass="select1" listKey="key" listValue="value"></s:select>
								</div>
								<b>*</b>
							</div>
						</li>

						<li>
							<div style="float: left; line-height: 35px;">
								<label>
									操作时间：
								</label>
								<div class="vocation">
									<s:textfield name="startdate" cssStyle="width: 150px;" cssClass="Wdate" onClick="WdatePicker()"></s:textfield>
									<strong>到</strong>
									<s:textfield name="enddate" cssStyle="width: 150px;" cssClass="Wdate" onClick="WdatePicker()"></s:textfield>
								</div>
						</li>
						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="85">
										&nbsp;
									</td>
									<td height="50">
										<input name="input2" type="submit" class="scbtn" value="查询" />

										<input name="input3" type="reset" class="scbtn" value="重置" />

										<input name="input6" type="button" class="scbtn" value="删除" />
									</td>
								</tr>
							</table>
						</li>

					</ul>
					</form>
					<table class="tablelist">
						<thead>
							<tr>
								<th width="5%">
									<input name="input" type="checkbox" value="" checked="checked" />
								</th>
								<th width="16%">
									时间
									<i class="sort"><img src="images/px.gif" alt="" />
									</i>
								</th>
								<th width="11%">
									登录IP
								</th>
								<th width="45%">
									操作事件
								</th>
								<th width="23%">
									操作用户
								</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="oplogs" var="oplog">
							<tr>
								<td>
									<input name="input" type="checkbox" value="" />
								</td>
								<td>
									<s:date name="optime" format="yyyy-MM-dd HH:mm:ss"/>
								</td>
								<td>
									<s:property value="loginip"/>
								</td>
								<td>
									<s:if test="iptype==1">
										登陆
									</s:if>
									<s:else>
										其他
									</s:else>
								</td>
								<td>
									<s:property value="usero.username"/>
								</td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
					<ul class="forminfo" style="line-height: 40px; font-size: 14px;">
						<table width="98%" border="0" align="center" cellpadding="2"
							cellspacing="1" bgcolor="#93CDF3" style="margin-top: 8px">
							<tr align="right" bgcolor="#EEF4EA">
								<td height="34" align="center" bgcolor="#FFFFFF">
									&nbsp;
								</td>
								<td height="34" colspan="6" align="center" bgcolor="#FFFFFF">
									记录数：<s:property value="totalCount" />&nbsp;&nbsp;&nbsp;
									<a
										href="javascript:jumpOplogPage('oplogAction!list',<s:property value="1"/>,<s:property value="uid"/>,<s:property value="logtype"/>,'<s:property value="startdate"/>','<s:property value="enddate"/>');"
										target="main">首页</a>&nbsp;&nbsp;
									<a
										href="javascript:jumpOplogPage('oplogAction!list',<s:property value="page-1"/>,<s:property value="uid"/>,<s:property value="logtype"/>,'<s:property value="startdate"/>','<s:property value="enddate"/>');"
										target="main">上一页</a>&nbsp;&nbsp;&nbsp;
									<a
										href="javascript:jumpOplogPage('oplogAction!list',<s:property value="page+1"/>,<s:property value="uid"/>,<s:property value="logtype"/>,'<s:property value="startdate"/>','<s:property value="enddate"/>');"
										target="main">下一页</a>&nbsp;&nbsp;&nbsp;
									<a
										href="javascript:jumpOplogPage('oplogAction!list',<s:property value="pageCount"/>,<s:property value="uid"/>,<s:property value="logtype"/>,'<s:property value="startdate"/>','<s:property value="enddate"/>');"
										target="main">尾页</a>&nbsp;&nbsp;&nbsp;
									<input type='button' class="exit"
										onclick="jumpPage('oplogAction!list',document.getElementById('page').value,<s:property value="uid"/>,<s:property value="logtype"/>,'<s:property value="startdate"/>','<s:property value="enddate"/>');"
										value='转到' />
									&nbsp; 当前页：
									<input onpaste="return false" onkeypress="checkPage();"
										id="page" type="text" name="page"
										value="<s:property value="page"/>" size="2"
										style="width: 25px; height: 20px; line-height: 18px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;" />
									/共
									<s:property value="pageCount" />
									页
								</td>
							</tr>
						</table>
					</ul>
				</div>




				<div id="tab4" class="tabson">
					<ul class="forminfo">
						<!--
           <li>
                <div style="float:left; line-height:35px;">
                  <label>所属服务器：</label>
                  <div class="vocation">
            <select name=" " class="select1">
              <option>宜兴市交通警察大队</option>
            </select></div>
            <b>*</b>
        </div> 
      </li>
    -->
						<li>
							<div style="float: left; line-height: 35px;">
								<label>
									选择设备：
								</label>
								<div class="vocation">
									<select name=" " class="select1">
										<option>
											T节点
										</option>
									</select>
								</div>
								<!--
                <label>　编　号：</label>
                <span class="vocation">
                <input type="text" class="dfinput"  style="width:100px;"/>
                </span> 
            -->
							</div>
						</li>
						<li>
							<div style="float: left; line-height: 35px;">
								<label>
									选择事件：
								</label>
								<div class="vocation">
									<select name=" " class="select1">
										<option>
											步跳
										</option>
									</select>
								</div>
							</div>
						</li>
						<li>
							<div style="float: left; line-height: 35px;">
								<label>
									起始时间：
								</label>
								<div class="vocation">
									<input type="text" class="dfinput" style="width: 150px;" />
									<strong>到</strong>
									<input type="text" class="dfinput" style="width: 150px;" />
								</div>
							</div>
						</li>
						<li>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="85">
										&nbsp;
									</td>
									<td height="50">
										<input name="input2" type="button" class="scbtn" value="查询" />

										<input name="input3" type="button" class="scbtn" value="重置" />

										<input name="input6" type="button" class="scbtn" value="删除" />
									</td>
								</tr>
							</table>
						</li>

					</ul>
					<table class="tablelist">
						<thead>
							<tr>
								<th width="5%">
									<input name="input" type="checkbox" value="" checked="checked" />
								</th>
								<th width="10%">
									日期
									<i class="sort"><img src="images/px.gif" alt="" />
									</i>
								</th>
								<th width="9%">
									时间
								</th>
								<th width="11%">
									设备
								</th>
								<th width="65%">
									事件
								</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<input name="input" type="checkbox" value="" />
								</td>
								<td>
									2015-12-12
								</td>
								<td>
									10:12:08
								</td>
								<td>
									<div id="u5" jquery171015793810490029025="20">
										<div id="u6" jquery171015793810490029025="21">
											<p>
												T42
											</p>
										</div>
									</div>
								</td>
								<td>
									信号机--联机
								</td>
							</tr>
							<tr>
								<td>
									<input name="input" type="checkbox" value="" />
								</td>
								<td>
									2015-12-12
								</td>
								<td>
									10:12:08
								</td>
								<td>
									T11
								</td>
								<td>
									&nbsp;
								</td>
							</tr>
							<tr>
								<td>
									<input name="input" type="checkbox" value="" />
								</td>
								<td>
									2015-12-12
								</td>
								<td>
									10:12:08
								</td>
								<td>
									<div id="u9" jquery171015793810490029025="20">
										<div id="u10" jquery171015793810490029025="21">
											<p>
												T44
											</p>
										</div>
									</div>
								</td>
								<td>
									&nbsp;
								</td>
							</tr>
						</tbody>
					</table>
					<ul class="forminfo" style="line-height: 40px; font-size: 14px;">
						<table width="98%" border="0" align="center" cellpadding="2"
							cellspacing="1" bgcolor="#93CDF3" style="margin-top: 8px">
							<tr align="right" bgcolor="#EEF4EA">
								<td height="34" align="center" bgcolor="#FFFFFF">
									&nbsp;
								</td>
								<td height="34" colspan="6" align="center" bgcolor="#FFFFFF">
									记录数：3&nbsp;&nbsp;&nbsp;
									<a href="javascript:jumpPage(1)" target="main">首页</a>&nbsp;&nbsp;
									<a href="javascript:jumpPage(2)" target="main">上一页</a>&nbsp;&nbsp;&nbsp;
									<a href="javascript:jumpPage(4)" target="main">下一页</a>&nbsp;&nbsp;&nbsp;
									<a href="javascript:jumpPage(5)" target="main">尾页</a>&nbsp;&nbsp;&nbsp;
									<input type='button' class="exit" onclick="" value='转到' />
									&nbsp;
									<!-- 
            <select size="1" name="page">
              <option selected="selected">第1页</option>
              <option>第2页</option>
              <option>第3页</option>
              </select>
            -->
									当前页：
									<input onpaste="return false" onkeypress="checkPage();"
										id="page" type="text" name="page" value="3" size="2"
										style="width: 25px; height: 20px; line-height: 18px; BORDER-RIGHT: #cccccc 1px solid; BORDER-TOP: #cccccc 1px solid; FONT-SIZE: 13px; BORDER-LEFT: #cccccc 1px solid; COLOR: #000000; BORDER-BOTTOM: #cccccc 1px solid; FONT-FAMILY: 宋体; BACKGROUND-COLOR: #ffffff;" />
									/共5页
								</td>
							</tr>
						</table>
					</ul>
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
