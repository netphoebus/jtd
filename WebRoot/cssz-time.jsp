<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> <%
String path = request.getContextPath(); String basePath =
request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
    <li><a href="cssz-cs.jsp" >一般参数</a></li> 
     
    <li><a href="cssz-fa.jsp" >相位方案</a></li> 
    <li><a href="#tab2" class="selected"  >时间段参数</a></li> 
  	</ul>
    </div> 
     
         
     <div id="tab2" class="tabson">
       <ul class="forminfo">
         <li>         </li>
         <li>
           <div style="float:left; line-height:35px;">
             <label>时间段选择：</label>
             <div class="vocation">
               <select name="select" class="select1">
                 <option>普通日</option>
                 <option>周日</option>
                 <option>特殊日</option>
             </select></div>
             <b>*</b>
           </div>
           <div style="float:left; line-height:35px; padding-left:20px;">
             <label>时间段细分：</label>
             <div class="vocation">
               <select name="select3" class="select1">
                 <option>时间段0</option>
                 <option>时间段1</option>
                 <option>时间段2</option>
                 <option>时间段3</option>
                 <option>时间段4</option>
                 <option>时间段5</option>
                 <option>时间段6</option>
                 <option>时间段7</option>
                 <option>时间段8</option>
                 <option>时间段9</option>
                 <option>时间段10</option>
                 <option>时间段11</option>
                 <option>时间段12</option>
                 <option>时间段13</option>
                 <option>时间段14</option>
                 <option>时间段15</option>
               </select>
             </div>
             <b>*</b> </div>
           <div style="float:left; line-height:35px; padding-left:20px;">
             <ul class="toolbar">
               <li class="click" style="height:28px; line-height:28px;"><span><img src="images/time.png" alt="" width="24" height="24" /></span>查看所有时间段</li>
             </ul>
           </div>
         </li>
         </ul>
         <div style="width:100%; float:left;">
          <div class="csleft" style="line-height:35px;">
          
          <table border="0" cellspacing="0" cellpadding="0">
            <!--
             <tr>
               <td align="right">&nbsp;</td>
               <td>&nbsp;</td>
               <td colspan="2" align="center">相位持续时间： 120 秒</td>
             </tr>
             -->
             <tr>
               <td align="right"><label>时　 </label></td>
               <td><input type="text" class="dfinput"  style="width:150px;"/></td>
             </tr>
             <tr>
               <td align="right"><label>分　 </label></td>
               <td><input type="text" class="dfinput"  style="width:150px;"/></td>
             </tr>
             <tr>
               <td align="right"><label>秒　 </label></td>
               <td><input type="text" class="dfinput"  style="width:150px;"/></td>
             </tr>
             <tr>
               <td align="right"><label>控制方式　 </label></td>
               <td>
                  <select name="kzfs" class="select4">
                      <option value="1">无电缆联动</option>
                      <option value="2">其他控制方式</option>
                  </select>
               </td>
             </tr>
             <tr>
               <td align="right"><label>相位方案　 </label></td>
               <td>
                  <select name="xwfa" class="select4">
                      <option value="1">相位方案1</option>
                      <option value="2">相位方案2</option>
                  </select>
               </td>
             </tr>
             <tr>
               <td align="right"><label>绿闪时间　 </label></td>
               <td><input type="text" class="dfinput"  style="width:150px;"/></td>
             </tr>
             <tr>
               <td align="right"><label>黄灯时间　 </label></td>
               <td><input type="text" class="dfinput"  style="width:150px;"/></td>
             </tr>
             <tr>
               <td align="right"><label>红灯时间　 </label></td>
               <td><input type="text" class="dfinput"  style="width:150px;"/></td>
             </tr>
             <tr>
               <td colspan="2" align="right">
               <div style="line-height:35px;">
                 <input name="input5" type="button" class="scbtn" style=" margin-right:auto; margin-right:auto; height:25px;" value="保存" onclick=""/>
               </div></td>
             </tr>
           </table>
           </div>
         <div class="csright">
            <div class="xwlb" >
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
                 <txt>
                   <h1 >序号01</h1>
                   相位0：<input type="text" class="dfinput"  style="width:60px; height:20px;"/> 秒</txt>

          </li>
              <ul>
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
                  <txt>
                    <h1 >序号02</h1>
                    相位1：
                    <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                    秒</txt>
                </li>
              </ul>
              <ul>
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
              <txt>
                <h1 >序号03</h1>
                相位2：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
          <ul>
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
              <txt>
                <h1 >序号04</h1>
                相位3：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号05</h1>
                相位4：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号06</h1>
                相位5：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号07</h1>
                相位6：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号08</h1>
                相位7：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号09</h1>
                相位8：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号10</h1>
                相位9：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号11</h1>
                相位10：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号12</h1>
                相位11：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号13</h1>
                相位12：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号14</h1>
                相位13：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号15</h1>
                相位14：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号16</h1>
                相位15：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号17</h1>
                相位16：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号18</h1>
                相位17：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号19</h1>
                相位18：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号20</h1>
                相位19：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号21</h1>
                相位20：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号22</h1>
                相位21：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号23</h1>
                相位22：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号24</h1>
                相位23：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号25</h1>
                相位24：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号26</h1>
                相位25：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号27</h1>
                相位26：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号28</h1>
                相位27：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号29</h1>
                相位28：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号30</h1>
                相位29：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号31</h1>
                相位30：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
           <ul>
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
              <txt>
                <h1 >序号32</h1>
                相位31：
                <input type="text" class="dfinput"  style="width:60px; height:20px;"/>
                秒</txt>
            </li>
          </ul>
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
