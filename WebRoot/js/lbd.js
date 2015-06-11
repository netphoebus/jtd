var sigsJson = {

};
/*
var sig1 = new Sig(0,40,50,0,[0.33,0.33,0.33],"_a_0","_b_0");

var jsonranklist=[{"xlid":"cxh","xldigitid":123456,"topscore":2000,"topplaytime":"2009-08-20"},{"xlid":"zd","xldigitid":123456,"topscore":1500,"topplaytime":"2009-11-20"}];


*/
var jsonlist=
[
	{"sigid":1,"zxspeed":40,"fxspeed":50,"distance":0,"pharseArray":[0.33,0.33,0.33],"zxpharse":"_a_0","fxpharse":"_b_0"},
	{"sigid":2,"zxspeed":60,"fxspeed":60,"distance":500,"pharseArray":[0.33,0.33,0.33],"zxpharse":"_a_0","fxpharse":"_b_0"},
	
];
var sig =  {"sigid":0,"signame":"test","zxspeed":50,"fxspeed":50,"distance":0,"pharseArray":[0.33,0.33,0.33],"zxpharse":"_a_0","fxpharse":"_b_0"}

function initGreenRoad()
{
	var circleTime = $("#circleTime").val();
	var zxselect = $(".zxselect");
	var fxselect = $(".fxselect");
	
	
	
	zxselect.each( function(){
	
		
         console.log($(this).val());
         
         
     });
     
     
     
     
     fxselect.each( function(){
         console.log($(this).val());
         
         
         
     });
     
   	 var sig =  {"sigid":1,"signame":1,"zxspeed":40,"fxspeed":50,"distance":0,"pharseArray":[0.33,0.33,0.33],"zxpharse":"_a_0","fxpharse":"_b_0"}

     jsonlist.push(sig1);
     
     
     
     
     var url = "greenroad.jsp?jsonlist="+JSON.stringify(jsonlist);
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