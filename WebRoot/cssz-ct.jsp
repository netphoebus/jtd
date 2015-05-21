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
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<link href="css/stilearn-helper.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.js"></script>
<script src="js/stilearn-base.js"></script>
<script src="js/holder.js"></script>

<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>
<script type="text/javascript" src="js/privatecssz-ct.js"></script>



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
     
    <li><a href="solutionAction!solutions" >相位方案</a></li> 
    <li><a href="cssz-time.jsp"  >时间段参数</a></li> 
    <li><a href="cssz-ct.jsp"  class="selected">绿冲突表</a></li> 
  	</ul>
    </div>
    <div style="font-size:18px; font-family:黑体; font-weight:bold; width:100%; text-align:center; line-height:30px; margin-top:15px;">绿冲突表</div>
    <div id="tab2" class="tabson">
      <table class="tablelist">
        <tbody >
        </tbody>
        <tbody>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
            <td>6</td>
            <td>7</td>
            <td>8</td>
            <td>9</td>
            <td>10</td>
            <td>11</td>
            <td>12</td>
            <td>13</td>
            <td>14</td>
            <td>15</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>东左</td>
            <td>东直</td>
            <td>东右</td>
            <td>东人</td>
            <td>南左</td>
            <td>南直</td>
            <td>南右</td>
            <td>南人</td>
            <td>西左</td>
            <td>西直</td>
            <td>西右</td>
            <td>西人</td>
            <td>北左</td>
            <td>北直</td>
            <td>北右</td>
            <td>北人</td>
          </tr>
          <tr>
            <td>0</td>
            <td>东左</td>
            <td>0<img src="img/tick.png"/></td>
            <td>0<img src="img/tick.png"/></td>
            <td>0<img src="img/tick.png"/></td>
            <td>0<img src="img/tick.png"/></td>
            <td>1<img src="img/cross.png"/></td>
            <td>1<img src="img/cross.png"/></td>
            <td>0<img src="img/tick.png"/></td>
            <td>0<img src="img/tick.png"/></td>
            <td>0<img src="img/tick.png"/></td>
            <td>1<img src="img/cross.png"/></td>
            <td>0<img src="img/tick.png"/></td>
            <td>1<img src="img/cross.png"/></td>
            <td>1<img src="img/cross.png"/></td>
            <td>0<img src="img/tick.png"/></td>
            <td>0<img src="img/tick.png"/></td>
            <td>1<img src="img/tick.png"/></td>
          </tr>
          <tr>
            <td>1</td>
            <td>东直</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>1</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>1</td>
            <td>0</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>2</td>
            <td>东右</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
          </tr>
          <tr>
            <td>3</td>
            <td>东人</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
          </tr>
          <tr>
            <td>4</td>
            <td>南左</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>5</td>
            <td>南直</td>
            <td>&nbsp;</td>
            <td>1</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>1</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>6</td>
            <td>南右</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
          </tr>
          <tr>
            <td>7</td>
            <td>南人</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
          </tr>
          <tr>
            <td>8</td>
            <td>西左</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>9</td>
            <td>西直</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>1</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>1</td>
            <td>0</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>10</td>
            <td>西右</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
          </tr>
          <tr>
            <td>11</td>
            <td>西人</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
          </tr>
          <tr>
            <td>12</td>
            <td>北左</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>13</td>
            <td>北直</td>
            <td>&nbsp;</td>
            <td>1</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
          </tr>
          <tr>
            <td>14</td>
            <td>北右</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
          </tr>
          <tr>
            <td>15</td>
            <td>北人</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>&nbsp;</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="formtext">
      <p>256的表格</p>
      <p>自己对自己肯定是不冲突的，其它可定义，默认表，需填写</p>
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
