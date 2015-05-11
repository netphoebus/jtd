<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath(); String basePath =
request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>一般参数</title>
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
    <li><a href="#tab1" class="selected" >一般参数</a></li> 
    <li><a href="cssz-fa.jsp"  >相位方案</a></li> 
    <li><a href="cssz-time.jsp" >时间段参数</a></li> 
  	</ul>
    </div> 
    
    <div id="tab1" class="tabson">
    <div class="csbox">
    <table border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td style="padding-right:5px;"><input name="　" type="button" class="scbtn" value="校 时"/></td>
    <td style="padding-right:5px;"> <input name="　" type="button" class="scbtn" value="自动校时"/></td>
    <td> <div class="vocation">
        <select name="select4" class="select2">
          <option>5秒后自动校验</option>
          <option>10秒后自动校验</option>
        </select> </div></td>
  </tr>
</table>
      
     

    </div>
    
    
    <div style="width:30%; padding-top:15px; padding-bottom:15px; float:left;">
    
    <div class="csbox">开机黄闪：
    <!-- 
      <input type="text" class="dfinput"   style="width:150px;" value="开机黄闪的国标定义和时间范围"  onclick="JavaScript:this.value=''"/> 
       -->
       <s:textfield name="sigParas.time_huangshan" cssClass="dfinput"   cssStyle="width:150px;"></s:textfield>
    秒</div>

    <div class="csbox">清场红灯： 
     <!-- 
      <input type="text" class="dfinput"   style="width:150px;"/> 
       -->
        <s:textfield name="sigParas.time_qingchanghongdeng" cssClass="dfinput"   cssStyle="width:150px;"></s:textfield>
    秒</div>
    
    <div class="csbox">最短绿灯：
    <!-- 
      <input type="text" class="dfinput"   style="width:150px;"/> 
      -->
      <s:textfield name="sigParas.G_min" cssClass="dfinput"   cssStyle="width:150px;"></s:textfield>
    秒</div>
    <div class="csbox">最长绿灯：
    <!-- 
      <input type="text" class="dfinput"   style="width:150px;"/> 
      -->
       <s:textfield name="sigParas.G_max" cssClass="dfinput"   cssStyle="width:150px;"></s:textfield>
    秒</div>
    <div class="csbox">步长时间：
       <!-- 
      <input type="text" class="dfinput"   style="width:150px;"/> 
        -->
        <s:textfield name="sigParas.G_step" cssClass="dfinput"   cssStyle="width:150px;"></s:textfield>
    秒</div>
    <div style="height:50px;"></div>
    <div>
    <div class="csbox">
    		 <s:checkbox name="" cssClass="checkinput"></s:checkbox>
             <txt> 　行人触发功能使用　</txt>
             </div>
     <div class="csbox">行人请求：
         <s:textfield name="sigParas.time_huangshan" cssClass="dfinput"   cssStyle="width:150px;"></s:textfield>
    秒</div>
     <div class="csbox">请求周期：
         <s:textfield name="sigParas.time_huangshan" cssClass="dfinput"   cssStyle="width:150px;"></s:textfield>
    ×10秒</div>
    </div>
    </div>
    <div style="width:70%;  padding-top:15px; padding-bottom:15px; float:left;">
    <div>
      <span class="csbox">
           <s:checkbox name="" cssClass="checkinput"></s:checkbox>
      周　日</span></div>
    <div id="zr" style="">
      <table  width="90%" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td><span class="csbox">
            <s:checkbox name="" value="" cssClass="checkinput"></s:checkbox>
            星期一</span></td>
          <td><span class="csbox">
            <s:checkbox name="" value="" cssClass="checkinput"></s:checkbox>
            
            星期二</span></td>
          <td><span class="csbox">
           <s:checkbox name="" value="" cssClass="checkinput"></s:checkbox>
            
            星期三</span></td>
          <td><span class="csbox">
           <s:checkbox name="" value="" cssClass="checkinput"></s:checkbox>
            
            星期四</span></td>
          <td><span class="csbox">
           <s:checkbox name="" value="" cssClass="checkinput"></s:checkbox>
            
            星期五</span></td>
          <td><span class="csbox">
           <s:checkbox name="" value="" cssClass="checkinput"></s:checkbox>
			星期六</span></td>
          <td><span class="csbox">
          <s:checkbox name="" value="" cssClass="checkinput"></s:checkbox>
			星期天</span></td>
						
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
    </div>
    <div><span class="csbox">
    <input name="input11" class="checkinput" type="checkbox" value="" />
特殊日</span></div>
    <div>
      <table  width="98%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><span class="csbox">
    01、
        <input type="text" class="dfinput"   style="width:30px;" />
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 02、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 03、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 04、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 05、
        <input type="text" class="dfinput"   style="width:30px;"/>
      月
  <input type="text" class="dfinput"   style="width:30px;"/>
      日</span></td>
    </tr>
  <tr>
    <td><span class="csbox"> 06、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 07、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 08、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 09、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> <label>10、</label>
      <input type="text" class="dfinput"   style="width:30px;"/>
      月
  <input type="text" class="dfinput"   style="width:30px;"/>
      日</span></td>
    </tr>
  <tr>
    <td><span class="csbox"> 11、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 12、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 13、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 14、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 15、
        <input type="text" class="dfinput"   style="width:30px;"/>
      月
  <input type="text" class="dfinput"   style="width:30px;"/>
      日</span></td>
    </tr>
  <tr>
    <td><span class="csbox"> 16、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 17、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 18、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 19、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 20、
        <input type="text" class="dfinput"   style="width:30px;"/>
      月
  <input type="text" class="dfinput"   style="width:30px;"/>
      日</span></td>
    </tr>
  <tr>
    <td><span class="csbox"> 21、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 22、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 23、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td><span class="csbox"> 24、
        <input type="text" class="dfinput"   style="width:30px;"/>
月
<input type="text" class="dfinput"   style="width:30px;"/>
日</span></td>
    <td>&nbsp;</td>
  </tr>
    </table>
  </div>

</div>

    <div class="tools">
      <ul class="toolbar">
        <li class="click"><span><img src="images/settings.png" alt="" width="24" height="24" /></span>设置完成</li>
        <li class="click"><span><img src="images/recycle.png" alt="" width="24" height="24" /></span>恢复默认</li>
        <li><span><img src="images/clipboard.png" alt="" width="24" height="24" /></span>调　阅</li>
         <li><span><img src="images/t03.png" alt="" /></span>清　空</li>
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
