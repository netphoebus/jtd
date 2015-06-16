var sigsJson = {

};
/*
var sig1 = new Sig(0,40,50,0,[0.33,0.33,0.33],"_a_0","_b_0");

var jsonranklist=[{"xlid":"cxh","xldigitid":123456,"topscore":2000,"topplaytime":"2009-08-20"},{"xlid":"zd","xldigitid":123456,"topscore":1500,"topplaytime":"2009-11-20"}];


*/
var jsonlist=
[

	
];
var sig =  {"sigid":0,"signame":"test","zxspeed":50,"fxspeed":50,"distance":0,"pharseArray":[0.33,0.33,0.33],"zxpharse":"_a_0","fxpharse":"_b_0"}

function initGreenRoad()
{
	var timetype = $("#timetype").val();
	var orderid = $("#orderid").val();
	var maxCircleTime = $("#maxCircleTime").val();
	var circleTime = $("#circleTime").val();
	var zxselect = $(".zxselect");
	var fxselect = $(".fxselect");
	var test = $("#asdasdasd");
	var begintime =  $("#begintime").val();
	
	var number = -1;
	zxselect.each( function(){
          console.log($(this).val());//注：1_0 1:表示信号机id，0:表示当前相位
          var sigid = parseInt($(this).val().split("_")[0]);//获得信号机id
          console.log("number:"+number);
          number = number+1;
          var signame = getJqueryMsg(sigid+"_signame");//String
          var circle = parseInt(getJqueryMsg(sigid+"_circle"));//int
          var zxspeed = parseInt(getJqueryMsg(sigid+"_zxspeed"));//int
          var fxspeed = parseInt(getJqueryMsg(sigid+"_fxspeed"));//int
          var distance = parseInt(getJqueryMsg(sigid+"_distance"));//int
          var pharseArray = getJqueryArrryMsg(sigid+"_pro");//Array
          var zxpharse = "_a_"+$(this).val().split("_")[1];//获得信号机 周期拼接相位//String
          if(number==0)
          {
          	 var fxpharse = "_c_"+$(this).val().split("_")[1];//获得信号机 周期拼接相位//String
          }else
          {
          	 var fxpharse = null;
          }
          
          var sig =  {"sigid":sigid,"signumber":number,"signame":signame,"sigcircle":circle,"zxspeed":zxspeed,"fxspeed":fxspeed,"distance":distance,"pharseArray":pharseArray,"zxpharse":zxpharse,"fxpharse":fxpharse};
     	  jsonlist.push(sig);
     	 
     });
     
     function getJqueryMsg(str)
   	 {
   	 	checkJqueryObj(str);
   	 	return $("#"+str).val();
   	 }
   	 
   	 function checkJqueryObj(str)
   	 {
	   	 if($("#"+str).val()==undefined||$("#"+str).val()=="")
		 {
			return 0;
		 }
   	 }
   	 
   	 function getJqueryArrryMsg(str)
   	 {
	   	if($("#"+str).val()==undefined)
		{
			return [];
		}
   	 	var arryStr =  $("#"+str).val();
   	 	arryStr = arryStr.substring(arryStr.indexOf("["),arryStr.length);
   	 	arryStr = arryStr.substring(1,arryStr.lastIndexOf("]"));
   	 	var str = arryStr.split(",");
   	 	var doubleArray = [];
   	 	for(var i=0;i<str.length;i++)
   	 	{
   	 		doubleArray.push(parseFloat(str[i]));
   	 		console.log(parseFloat(str[i]));
   	 	}
   	 	return doubleArray;
   	 }
     
     
     fxselect.each( function(){
		 var fxpharse = "_c_"+$(this).val().split("_")[1];//获得信号机 周期拼接相位
         jsonlist[0].fxpharse = fxpharse;
         
     });
     
     var url = "greenroad.jsp?jsonlist="+JSON.stringify(jsonlist)+"&maxCircleTime="+maxCircleTime+"&timetype="+timetype+"&orderid="+orderid+"&begintime="+begintime;
     url = encodeURI(url);
  	 self.location = url;
}


//时间段参数
function changeTimeSelect()
{
	var timetype = $("#timetype").val();
	var orderid = $("#orderid").val();
	var mklid = $("#mklid").val();
	console.log("sigtimeAction!sigtimes?timetype="+timetype+"&orderid="+orderid+"&mklid="+mklid);
	location.href = "greenroadAction!lbd?timetype="+timetype+"&orderid="+orderid+"&mklid="+mklid;
}