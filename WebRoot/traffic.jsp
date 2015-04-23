<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> <%
String path = request.getContextPath(); String basePath =
request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>无标题文档</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" />
		<link href="css/select.css" rel="stylesheet" type="text/css" />
		<link href="css/stilearn-helper.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="js/jquery.1.4.2-min.js"></script>


		<script type="text/javascript" src="js/jquery.js"></script>
		<script src="js/stilearn-base.js"></script>
		<script src="js/holder.js"></script>

		<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
		<script type="text/javascript" src="js/select-ui.min.js"></script>
		<script type="text/javascript" src="editor/kindeditor.js"></script>

		<script type="text/javascript">

		$(function(){
				setInterval("ShowLights()",250);
				});
				function ShowLights(){
				console.log("进入方法.开始直行.....");
				  $.ajax({   
				            url:'realtime',//这里是你的action或者servlert的路径地址   
				            type:'get', //数据发送方式   
				            dataType:'json', //接受数据格式 (这里有很多,常用的有html,xml,js,json)   
				            error: function(msg)
				            { //失败   
				            	console.log('Error loading document');   
				            },   
				            success: function(msg)
				            { //成功   
				           	 	 $("#h01").attr("src","images/img/h01"+msg.h01+".png"); 
					           	 $("#h02").attr("src","images/img/h02"+msg.h02+".png");
					           	 $("#h03").attr("src","images/img/h03"+msg.h03+".png");
					           	 $("#h04").attr("src","images/img/h04"+msg.h04+".png"); 
					           	 $("#h05").attr("src","images/img/h05"+msg.h05+".png");
					           	 $("#h06").attr("src","images/img/h06"+msg.h06+".png");
					           	 $("#h07").attr("src","images/img/h07"+msg.h07+".png");
					           	 $("#h08").attr("src","images/img/h01"+msg.h01+".png");
					           	 
					           	 $("#s01").attr("src","images/img/s01"+msg.s01+".png"); 
					           	 $("#s02").attr("src","images/img/s02"+msg.s02+".png");
					           	 $("#s03").attr("src","images/img/s03"+msg.s03+".png");
					           	 $("#s04").attr("src","images/img/s04"+msg.s04+".png"); 
					           	 $("#s05").attr("src","images/img/s05"+msg.s05+".png");
					           	 $("#s06").attr("src","images/img/s06"+msg.s06+".png");
					           	 $("#s07").attr("src","images/img/s07"+msg.s07+".png");
					           	 $("#s08").attr("src","images/img/s01"+msg.s01+".png");
					           	 
				            }  
		            });        	 
		}


</script>



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
		width : 130  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
		<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});



});
</script>
		<script type="text/javascript">
$(document).ready(function(){
  $(".click2").click(function(){
  $(".tip2").fadeIn(200);
  });
  
  $(".tiptop2 a").click(function(){
  $(".tip2").fadeOut(200);
});



});
</script>
		<script type="text/javascript">
$(document).ready(function(){
  $(".click4").click(function(){
  $(".tip4").fadeIn(200);
  });
  
  $(".tiptop4 a").click(function(){
  $(".tip4").fadeOut(200);
});



});
</script>
		<script type="text/javascript">
$(document).ready(function(){
  $(".click3").click(function(){
  $(".tip3").fadeIn(200);
  });
  
  $(".tiptop3 a").click(function(){
  $(".tip3").fadeOut(200);
});



});
</script>
		<script type="text/javascript" src="js/jquery.tabso_yeso.js"></script>
		<script type="text/javascript">
$(document).ready(function($){
	
	
	
	//默认选项卡切换
	$("#normaltab").tabso({
		cntSelect:"#normalcon",
		tabEvent:"mouseover",
		tabStyle:"normal"
	});
	
});
</script>
		<script>
function show_div(){
 var obj=document.getElementById('test_div');
var btn=document.getElementById('show_btn');
	if(obj.style.display=='none'){
		obj.style.display='block';
		btn.innerHTML='自　动';
	}else{
		obj.style.display='none';
		btn.innerHTML='手　动';
	}
}
</script>

		<script>
function change_pic()
{
 var imgObj = document.getElementById("h01");

 if(imgObj.getAttribute("src",2)== "images/img/h01h.png")
 {imgObj.src="images/img/h010.png";}
 else
 {imgObj.src="images/img/h010.png";}
}
</script>

	</head>

	<body>
		<div class="formbody">

			<div class="tabson" style="margin-top: 0px;">
				<ul class="toolbar" style="width: 100%; margin-bottom: 10px;">
					<li style="padding-left: 5px;">
						信号机基本信息 | IP:192.168.1.27 地址:人民中路十字路口 名称:人民路信号灯
					</li>
				</ul>
				<div style="width: 100%; float: left;">
					<div class="xwbox">
						<li>
							<div
								style="width: 166px; height: 29px; margin-top: 75px; margin-left: 290px;">
								<img src="images/img/h010.png" alt="东西方向人行道" id="h01"
									/>
							</div>
						</li>
						<li style="height: 280px;">
							<div style="height: 280px; width: 100%; float: left;">
								<div
									style="width: 29px; height: 166px; float: left; margin-top: 50px; margin-left: 170px;">
									<img id="s01" src="images/img/s010.png" alt="南北方向人行道" />
								</div>
								<div
									style="width: 60px; height: 72px; float: left; margin-top: 140px; margin-left: 4px;">
									<table width="25" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>
												<img id="h02" src="images/img/h020.png" alt="西边左转灯" />
											</td>
										</tr>
										<tr>
											<td>
												<img id="h03" src="images/img/h030.png" alt="西边直转灯" />
											</td>
										</tr>
										<tr>
											<td>
												<img id="h04" src="images/img/h040.png" alt="西边右转灯" />
											</td>
										</tr>
									</table>
								</div>
								<div
									style="width: 72px; height: 60px; float: left; margin-top: 20px; margin-left: 10px;">
									<table width="72" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>
												<img id="s02" src="images/img/s020.png" alt="" />
											</td>
											<td>
												<img id="s03" src="images/img/s030.png" alt="" />
											</td>
											<td>
												<img  id="s04" src="images/img/s040.png" alt="" />
											</td>
										</tr>
									</table>
								</div>
								<div
									style="width: 72px; height: 60px; float: left; margin-top: 220px; margin-left: 35px;">
									<table width="32" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>
												<img id="s06"  src="images/img/s060.png" alt="" />
											</td>
											<td>
												<img  id="s05" src="images/img/s050.png" alt="" />
											</td>
											<td>
												<img  id="s07" src="images/img/s070.png" alt="" />
											</td>
										</tr>
									</table>
								</div>
								<div
									style="width: 60px; height: 72px; float: left; margin-top: 65px; margin-left: 0px;">
									<table width="25" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td>
												<img id="h07" src="images/img/h070.png" alt="" />
											</td>
										</tr>
										<tr>
											<td>
												<img id="h06" src="images/img/h060.png" alt="" />
											</td>
										</tr>
										<tr>
											<td>
												<img id="h05" src="images/img/h050.png" alt="" />
											</td>
										</tr>
									</table>
								</div>
								<div
									style="width: 29px; height: 166px; float: left; margin-top: 50px; margin-left: 30px;">
									<img id="s08" src="images/img/s010.png" alt="" />
								</div>
							</div>
						</li>
						<li>
							<div
								style="width: 166px; height: 29px; margin-top: 20px; margin-left: 290px;">
								<img  id="h08" src="images/img/h010.png" alt="" />
							</div>
						</li>
					</div>
				</div>
				<div style="width: 100%; float: left; margin-bottom: 10px;">
					<ul class="toolbar">
						<li onclick="javascript:location.href='cssz.html'"
							style="cursor: auto;">
							<span><img src="images/boot.png" alt="" width="24"
									height="24" />
							</span>设 置 :
						</li>
					</ul>
					<ul class="toolbar1">

						<li onclick="javascript:location.href='cssz-cs.html'">
							设置参数
						</li>

					</ul>

				</div>

				<div style="width: 100%; float: left; margin-bottom: 10px;">
					<ul class="toolbar">
						<li style="cursor: auto;">
							<span><img src="images/car.png" alt="" width="24"
									height="24" />
							</span>查 看 :
						</li>
					</ul>
					<ul class="toolbar1">

						<li class="click2">
							汽车流量
						</li>
						<li class="click3">
							故障信息
						</li>
						<li class="click4">
							操作日志
						</li>

					</ul>

				</div>

				<div style="width: 100%; float: left; margin-bottom: 10px;">
					<ul class="toolbar">
						<li style="cursor: auto;">
							<span><img src="images/13.png" alt="" width="24"
									height="23" />
							</span>控 制 :
						</li>
					</ul>
					<ul class="toolbar1">
						<li>
							自 动
						</li>
						<li id="show_btn" onclick="show_div()">
							手 动
						</li>



					</ul>

				</div>

				<div id="test_div"
					style="width: 100%; float: left; display: none; margin-bottom: 15px;">

					<ul class="toolbar1" style="margin-left: 80px;">

						<li class="click">
							黄 闪
						</li>
						<li class="click">
							关 灯
						</li>
						<li>
							全 红
						</li>
						<li>
							锁 定
						</li>
						<li style="background: none; border: solid 1px #fff;">
							<select name="select" class="select2">
								<option>
									指定相位运行
								</option>
								<option>
									相位001
								</option>
								<option>
									相位021
								</option>
							</select>
						</li>
					</ul>

				</div>


			</div>


		</div>

		<div class="tip">
			<div class="tiptop">
				<span>信号设置</span><a></a>
			</div>

			<div class="tipinfo">

				<div class="tipright" style="line-height: 25px;">
					<p>
						路口名称：
						<input type="text" class="dfinput2" style="width: 150px;" />
					</p>
					<p>
						路口编码：
						<input type="text" class="dfinput2" style="width: 150px;" />
					</p>
					<p>
						路口地址：
						<input type="text" class="dfinput2" style="width: 150px;" />
					</p>
					<p>
						路口端口：
						<input type="text" class="dfinput2" style="width: 150px;" />
					</p>
					<p>
						中心端口：
						<input type="text" class="dfinput2" style="width: 150px;" />
					</p>
					<p>
					<table width="50%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="20">
								&nbsp;
							</td>
							<td width="66">
								<btn class="forminfobtn2">保存路口信息</btn>
							</td>
							<td width="66">
								<btn class="forminfobtn">连接</btn>
							</td>
							<td width="203">
								<btn class="forminfobtn">断开</btn>
							</td>
							<td>
								&nbsp;
							</td>
						</tr>
					</table>
					<p style="margin-top: 5px;">
						工作方式：
						<input type="text" class="dfinput2" style="width: 150px;" />
					</p>
					<p>
						工 作 日 ：
						<input type="text" class="dfinput2" style="width: 150px;" />
					</p>
					<p>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="44%" align="left">
								工作方案：
								<input type="text" class="dfinput2" style="width: 30px;" />
							</td>
							<td width="56%">
								时 间 段 ：
								<input type="text" class="dfinput2" style="width: 30px;" />
							</td>
						</tr>
					</table>
					<p>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="44%" align="left">
								步 序：
								<input type="text" class="dfinput2" style="width: 30px;" />
							</td>
							<td width="56%">
								剩余时间：
								<input type="text" class="dfinput2" style="width: 30px;" />
							</td>
						</tr>
					</table>
					<p>
						故障信息：
					</p>
					<div style="width: 240px; height: 100px; overflow: auto;">
						<cite>该信号灯运行正常，无故障。如果是请点击确定按钮
							，否则请点取消。该信号灯运行正常，无故障。如果是请点击确定按钮 ，否则请点取消。该信号灯运行正常，无故障。如果是请点击确定按钮
							，否则请点取消。该信号灯运行正常，无故障。如果是请点击确定按钮 ，否则请点取消。该信号灯运行正常，无故障。如果是请点击确定按钮
							，否则请点取消。该信号灯运行正常，无故障。如果是请点击确定按钮 ，否则请点取消。</cite>
					</div>

				</div>

				<div class="tipleft">
					<p>
						运行状态：未连接....
					</p>
					<div
						style="width: 500px; height: 400px; float: left; overflow: hidden;">
						<img src="images/img/fw.jpg" width="500" height="400" />
					</div>
				</div>
			</div>


		</div>



		<div class="tip2">
			<div class="tiptop2">
				<span>月车流量查询</span><a></a>
			</div>

			<div class="tipinfo2">
				<div class="tipright" style="width: 680px; padding-right: 5px;">
					<ul class="tabbtn" id="normaltab">
						<li class="current">
							<a href="#">流量信息列表</a>
						</li>
						<li>
							<a href="#">流量报表折线图</a>
						</li>
						<li>
							<a href="#">流量报表柱状图</a>
						</li>
					</ul>
					<!--tabbtn end-->
					<div class="tabcon" id="normalcon">
						<div class="sublist">
							<ul>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											1
										</td>
									</tr>
								</table>

							</ul>
						</div>
						<!--tabcon end-->
						<div class="sublist">
							<ul>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											2
										</td>
									</tr>
								</table>
							</ul>
						</div>
						<!--tabcon end-->
						<div class="sublist">
							<ul>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											<img src="images/img/z.png" width="680" height="270" />
										</td>
									</tr>
								</table>
							</ul>
						</div>
						<!--tabcon end-->

					</div>
					<!--tabcon end-->
				</div>
				<div class="tipleft" style="width: 180px; line-height: 35px;">
					<p>
						查询条件：
					</p>
					<p>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								服务器：
							</td>
							<td>
								<select name="select" class="select2">
									<option>
										118信号服务器
									</option>
									<option>
										125信号服务器
									</option>
									<option>
										006信号服务器
									</option>
								</select>
							</td>
						</tr>
					</table>

					<p>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								节点名：
							</td>
							<td>
								<select name="select" class="select2">
									<option>
										03阳泉路
									</option>
									<option>
										32东虹路
									</option>
									<option>
										22龙英伦路
									</option>
								</select>
							</td>
						</tr>
					</table>

					<p>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								年 份：
							</td>
							<td>
								<select name="select" class="select2">
									<option>
										2015
									</option>
									<option>
										2014
									</option>
									<option>
										2013
									</option>
								</select>
							</td>
						</tr>
					</table>

					<p>
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td>
								月 份：
							</td>
							<td>
								<select name="select" class="select2">
									<option>
										8
									</option>
									<option>
										7
									</option>
									<option>
										6
									</option>
								</select>
							</td>
						</tr>
					</table>

					<p>
						<btn class="forminfobtn">查 询</btn>
					</p>
				</div>
			</div>


		</div>




		<div class="tip3">
			<div class="tiptop3">
				<span>故障信息</span><a></a>
			</div>

			<div class="tipinfo3">
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


		</div>



		<div class="tip4">
			<div class="tiptop4">
				<span>操作日志</span><a></a>
			</div>

			<div class="tipinfo3">
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
						<tr>
							<td>
								<input name="input" type="checkbox" value="" />
							</td>
							<td>
								2015-12-12 10:12:08
							</td>
							<td>
								192.168.1.43
							</td>
							<td>
								<div id="u5" jquery171015793810490029025="20">
									<div id="u6" jquery171015793810490029025="21">
										<p>
											用户登录
										</p>
									</div>
								</div>
							</td>
							<td>
								admin
							</td>
						</tr>
						<tr>
							<td>
								<input name="input" type="checkbox" value="" />
							</td>
							<td>
								2015-12-12 10:12:08
							</td>
							<td>
								192.168.1.43
							</td>
							<td>
								<div id="u7" jquery171015793810490029025="20">
									<div id="u8" jquery171015793810490029025="21">
										<p>
											视频设备管理-查询所在服务器上的所有视频设备
										</p>
									</div>
								</div>
							</td>
							<td>
								admin
							</td>
						</tr>
						<tr>
							<td>
								<input name="input" type="checkbox" value="" />
							</td>
							<td>
								2015-12-12 10:12:08
							</td>
							<td>
								192.168.1.43
							</td>
							<td>
								<div id="u9" jquery171015793810490029025="20">
									<div id="u10" jquery171015793810490029025="21">
										<p>
											用户登录
										</p>
									</div>
								</div>
							</td>
							<td>
								admin
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


		</div>
	</body>
</html>
