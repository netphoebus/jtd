function executeCommand(id)
{
	$.ajax({   
            url:'doCommand',//这里是你的action或者servlert的路径地址   
            type:'post', //数据发送方式  
            data: { "commandId":id},   
            error: function(msg)
            { //失败   
            	alert('发送命令失败');   
            },   
            success: function(msg)
            { //成功   
				//alert('发送命令成功');   
            }  
   	    });   
}

function autojs()
{
	console.log($("#zdjs").val());
	if($("#zdjs").val()==4)
	{
		setInterval("suretime()",60*1000*60*24);
	}else if($("#zdjs").val()==5)
	{
		setInterval("suretime()",60*1000*60*24*7);
	}else if($("#zdjs").val()==0)
	{
		setInterval("suretime()",60*1000*5);
	}else if($("#zdjs").val()==1)
	{
		setInterval("suretime()",60*1000*10);
	}else if($("#zdjs").val()==2)
	{
		setInterval("suretime()",60*1000*30);
	}else if($("#zdjs").val()==3)
	{
		setInterval("suretime()",60*1000*60);
	}
}

function topSetting()
{
	alert("这里是高级设置~");
}





$(document).ready(function(){
	
	$("#manyCommands").click(function() 
	{ 
				alert("所有参数开始初始化..");
				$("#divProgressbar").progressbar({value: 0}); 
				$( "#divProgressbar" ).progressbar({
				  max: 250
				});
				var index = 0;//计数器
				var commandNumber = 0;
		    	var interval = setInterval(updateProgressbarValue, 3000);
		 		function updateProgressbarValue()
		 		{
		 			console.log(index);
		 			if(index == 25)
		 			{
		 				executeCommand(35);
		 				commandNumber = 35;
		 			}
		 			else if(index==0)
		 			{
		 				commandNumber = 1 ;
		 				executeCommand(1);
		 				index = index+1;
		 				commandNumber = 4;
		 				
		 			}else
		 			{
		 				commandNumber = commandNumber+1;
		 				executeCommand(commandNumber);
		 				index = index+1;
			 			
		 			}
		 			console.log("commandNumber:"+commandNumber);
			        var newValue = $("#divProgressbar").progressbar("option", "value") + 10; //读取进度条现有值并计算出新值
			        if(newValue==260)
			        {
			        	 $("#divProgressbar").progressbar({value: 0}); 
			        	 clearInterval(interval);
			        	 $("#divProgressbar").hide();
			        	 alert("执行了"+index+"条命令");
			        	 alert("最后的命令编号为:"+commandNumber);
			        	 index= 0;
			        	 commandNumber = 0;
			        	 alert("所有参数开始初始化完成。");
			        	 executeCommand(0);
			        }else
			        {
			        	 $("#divProgressbar").progressbar("option", "value", newValue);  //设置进度条新值  
			        }
   		 		}
				
	});
               
});


function suretime()
{
	$.ajax({   
            url:'suretime',//这里是你的action或者servlert的路径地址   
            type:'get', //数据发送方式   
            error: function(msg)
            { //失败   
            	alert('校时失败');   
            },   
            success: function(msg)
            { //成功   
				alert('校时成功');   
            }  
   	    });   
}

 //3：红 2：黄 1：绿 0：灭 null：未知
var updateFang = {};
$(document).ready(function(){

			var datas = {};
			var imgsrc_new = "";//新的图片路径
			var img = "";
			var conflictStart = "";
			var conflictStr = "";
		$(".picbox img").click(function(event) {
	
			var img = $(event.target);
			var imgsrc = img[0].src;//获得当前焦点的src
			
			console.log("imgsrc:-----------------------"+imgsrc);
			var lastnumber = imgsrc.substring(imgsrc.indexOf(".png")-1,imgsrc.indexOf(".png"));//当前焦点的灯的颜色
			
			console.log("lastnumber:-----------------------"+lastnumber);
			
			var headnumber = imgsrc.substring(imgsrc.indexOf(".png")-3,imgsrc.indexOf(".png")-1);//当前焦点的路口方位及左转还是右转灯	
			console.log("headnumber:-----------------------"+headnumber);
			
			var headnumber1 = headnumber.substring(0,1);//当前焦点的路口方位
			var headnumber2 = headnumber.substring(1,2);//当前焦点的灯转向
			
			//根据灯的种类及当前颜色 来修改灯的颜色
			if(lastnumber == 0)
			{
					//当前灯色要改为绿色的时候要进行绿冲突判断
					
					//第一步：判断是那个路口的那个灯进行设置为绿色，则获得当前绿冲突的情况 放在conflictStr中
					if(headnumber=="00")
					{
						conflictStr = $("#c1").val();
					}
					else if(headnumber=="01")
					{
						conflictStr = $("#c2").val();
					}
					else if(headnumber=="02")
					{
						conflictStr = $("#c3").val();
					}
					else if(headnumber=="03")
					{
						conflictStr = $("#c4").val();
					}
					else if(headnumber=="10")
					{
						conflictStr = $("#c5").val();
					}
					else if(headnumber=="11")
					{
						conflictStr = $("#c6").val();
					}
					else if(headnumber=="12")
					{
						conflictStr = $("#c7").val();
					}
					else if(headnumber=="13")
					{
						conflictStr = $("#c8").val();
					}
					else if(headnumber=="20")
					{
						conflictStr = $("#c9").val();
					}
					else if(headnumber=="21")
					{
						conflictStr = $("#c10").val();
					}else if(headnumber=="22")
					{
						conflictStr = $("#c11").val();
					}else if(headnumber=="23")
					{
						conflictStr = $("#c12").val();
					}else if(headnumber=="30")
					{
						conflictStr = $("#c13").val();
					}else if(headnumber=="31")
					{
						conflictStr = $("#c14").val();
					}else if(headnumber=="32")
					{
						conflictStr = $("#c15").val();
					}else if(headnumber=="33")
					{
						conflictStr = $("#c16").val();
					}
					console.log("冲突:"+conflictStr);
					//第二部：分两种情况，一种为 id 一种为 class 解析conflictStr 并逐一找出冲突的灯当前的颜色是否为绿色如果为绿色则返回
					if(img[0].id==null||img[0].id =="")
					{
						//class
						var imgclass= img[0].classList[0];
						conflictStart = imgclass.substring(0,1);
							console.log("====================1")
						if(typeof(conflictStr) != "undefined"&&conflictStr!="")
						{
							var strs= conflictStr.split(","); //字符分割 
							console.log("strs:-------------------------"+strs);
							for (i=0;i<strs.length-1;i++) 
							{ 
								var lightKind = strs[i].substring(strs[i].length-1,strs[i].length);
								console.log("lightKind:-------------------------"+lightKind);
								var imgNow = null;//当前与之比较的灯
								var currentLightNumber = 0;//当前与之比较的灯 的种类
								var srcNow = "";
								if(lightKind==3)
								{
									 imgNow = $("."+conflictStart+strs[i]);
									 console.log("imgNow:---------------------------"+"."+conflictStart+strs[i]);
									 srcNow = imgNow[0].currentSrc;
									 currentLightNumber = srcNow.substring(srcNow.indexOf(".png")-1,srcNow.indexOf(".png"));//当前比较灯的颜色
								}else
								{
									imgNow = $("#"+conflictStart+strs[i]);
									srcNow = imgNow[0].currentSrc;
								    currentLightNumber = srcNow.substring(srcNow.indexOf(".png")-1,srcNow.indexOf(".png"));//当前比较灯的颜色
								}
								if(currentLightNumber==1)
								{
									alert(imgNow[0].alt+"与当前灯绿冲突");
									return;
								}
							}
						}
						console.log("====================2");
					}else
					{
						//id
						var imgid = img[0].id;
						console.log("imgid:-------------------------"+imgid);
						
						
						conflictStart = imgid.substring(0,imgid.indexOf("_"));
						
						console.log("conflictStart:-------------------------"+conflictStart);
						
						if(typeof(conflictStr) != "undefined"&&conflictStr!="")
						{
							var strs= conflictStr.split(","); //字符分割 
							console.log("strs:-------------------------"+strs);
							for (i=0;i<strs.length-1;i++) 
							{ 
								var lightKind = strs[i].substring(strs[i].length-1,strs[i].length);
								console.log("lightKind:-------------------------"+lightKind);
								var imgNow = null;//当前与之比较的灯
								var currentLightNumber = 0;//当前与之比较的灯 的种类
								var srcNow = "";
								if(lightKind==3)
								{
									 imgNow = $("."+conflictStart+strs[i]);
									 console.log("imgNow:---------------------------"+"."+conflictStart+strs[i]);
									 srcNow = imgNow[0].currentSrc;
									 currentLightNumber = srcNow.substring(srcNow.indexOf(".png")-1,srcNow.indexOf(".png"));//当前比较灯的颜色
								}else
								{
									imgNow = $("#"+conflictStart+strs[i]);
									srcNow = imgNow[0].currentSrc;
								    currentLightNumber = srcNow.substring(srcNow.indexOf(".png")-1,srcNow.indexOf(".png"));//当前比较灯的颜色
								}
								if(currentLightNumber==1)
								{
									alert(imgNow[0].alt+"与当前灯绿冲突");
									return;
								}
							} 
						}
					}
				
				lastnumber = 1;
				imgsrc_new = "images/rod/l"+headnumber+"1.png";
				
			}else if(lastnumber == 1)
			{
				lastnumber = 3;
				imgsrc_new = "images/rod/l"+headnumber+"3.png";
			}else if(lastnumber == 3)
			{
				lastnumber = 0;
				imgsrc_new = "images/rod/l"+headnumber+"0.png";
			}
			if(headnumber2==3)
			{
				var imgclass= img[0].classList[0];
				
				updateFang[imgclass] = lastnumber;
				
				$("."+imgclass).attr("src",imgsrc_new);
			}else
			{
				var imgid = img[0].id;
				
				updateFang[imgid] = lastnumber;
				
				img.attr("src",imgsrc_new);
			}
		});
		
		
});

function runByPharse()
{
	var gltime = $("#gltime").val();
	var rltime = $("#rltime").val();
	var yltime = $("#yltime").val();
	console.log(updateFang,gltime,rltime,yltime);
	var msg = "";
	for(var prop in updateFang){
    if(updateFang.hasOwnProperty(prop)){
        console.log('key is ' + prop +' and value is' + updateFang[prop]);
        msg = msg + prop+":"+ updateFang[prop]+",";
    	}
	}
	console.log(msg);
		$.ajax({   
            url:'runByPharse',//这里是你的action或者servlert的路径地址   
            type:'post', //数据发送方式  
            data: { "dates":msg,"gltime":parseInt(gltime),"rltime":parseInt(rltime),"yltime":parseInt(yltime)},  
            traditional: true,  
            error: function(msg)
            { //失败   
            	alert('发送命令失败');   
            },   
            success: function(msg)
            { //成功   
				alert('运行成功'); 
            }  
   	    });  
}


function allRed(id)
{
	
		$("."+id+"_2_3").attr("src","images/rod/l233.png");
		updateFang[id+"_2_3"] = 3;	
									
		$("."+id+"_0_3").attr("src","images/rod/l033.png");
		updateFang[id+"_0_3"] = 3;	
			
		$("."+id+"_3_3").attr("src","images/rod/l333.png");
		updateFang[id+"_3_3"] = 3;	
		
		$("."+id+"_3_3").attr("src","images/rod/l333.png");
		updateFang[id+"_3_3"] = 3;	
		
		
		$("#"+id+"_0_2").attr("src","images/rod/l023.png");
		updateFang[id+"_0_2"] = 3;	
		
		$("#"+id+"_0_2").attr("src","images/rod/l023.png");
		updateFang[id+"_0_2"] = 3;	
		
							
		$("#"+id+"_0_1").attr("src","images/rod/l013.png");
		updateFang[id+"_0_1"] = 3;	
		
		$("#"+id+"_0_0").attr("src","images/rod/l003.png");
		updateFang[id+"_0_0"] = 3;	
		
		$("#"+id+"_3_2").attr("src","images/rod/l323.png");
		updateFang[id+"_3_2"] = 3;
		
		$("#"+id+"_3_1").attr("src","images/rod/l313.png");
		updateFang[id+"_3_1"] = 3;
		
		$("#"+id+"_3_0").attr("src","images/rod/l303.png");
		updateFang[id+"_3_0"] = 3;
		
		$("#"+id+"_1_0").attr("src","images/rod/l103.png");
		updateFang[id+"_1_0"] = 3;
		
		$("#"+id+"_1_1").attr("src","images/rod/l113.png");
		updateFang[id+"_1_1"] = 3;
		
		$("#"+id+"_1_2").attr("src","images/rod/l123.png");
		updateFang[id+"_1_2"] = 3;
		
		$("#"+id+"_2_0").attr("src","images/rod/l203.png");
		updateFang[id+"_2_0"] = 3;
		
		$("#"+id+"_2_1").attr("src","images/rod/l213.png");
		updateFang[id+"_2_1"] = 3;
		
		$("#"+id+"_2_2").attr("src","images/rod/l223.png");
		updateFang[id+"_2_2"] = 3;
		
		$("."+id+"_1_3").attr("src","images/rod/l133.png");
		updateFang[id+"_1_3"] = 3;
		
		$("."+id+"_1_3").attr("src","images/rod/l133.png");
		updateFang[id+"_1_3"] = 3;
		
		$("."+id+"_2_3").attr("src","images/rod/l233.png");
		updateFang[id+"_2_3"] = 3;
		
		$("."+id+"_0_3").attr("src","images/rod/l033.png");
		updateFang[id+"_0_3"] = 3;
	
}

function clearAllLight(id)
{
	$("."+id+"_2_3").attr("src","images/rod/l230.png");
		updateFang[id+"_2_3"] = 0;	
									
		$("."+id+"_0_3").attr("src","images/rod/l030.png");
		updateFang[id+"_0_3"] = 0;	
			
		$("."+id+"_3_3").attr("src","images/rod/l330.png");
		updateFang[id+"_3_3"] = 0;	
		
		$("."+id+"_3_3").attr("src","images/rod/l330.png");
		updateFang[id+"_3_3"] = 0;	
		
		
		$("#"+id+"_0_2").attr("src","images/rod/l020.png");
		updateFang[id+"_0_2"] = 0;	
		
		$("#"+id+"_0_2").attr("src","images/rod/l020.png");
		updateFang[id+"_0_2"] = 0;	
		
							
		$("#"+id+"_0_1").attr("src","images/rod/l010.png");
		updateFang[id+"_0_1"] = 0;	
		
		$("#"+id+"_0_0").attr("src","images/rod/l000.png");
		updateFang[id+"_0_0"] = 0;	
		
		$("#"+id+"_3_2").attr("src","images/rod/l320.png");
		updateFang[id+"_3_2"] = 0;
		
		$("#"+id+"_3_1").attr("src","images/rod/l310.png");
		updateFang[id+"_3_1"] = 0;
		
		$("#"+id+"_3_0").attr("src","images/rod/l300.png");
		updateFang[id+"_3_0"] = 0;
		
		$("#"+id+"_1_0").attr("src","images/rod/l100.png");
		updateFang[id+"_1_0"] = 0;
		
		$("#"+id+"_1_1").attr("src","images/rod/l110.png");
		updateFang[id+"_1_1"] = 0;
		
		$("#"+id+"_1_2").attr("src","images/rod/l120.png");
		updateFang[id+"_1_2"] = 0;
		
		$("#"+id+"_2_0").attr("src","images/rod/l200.png");
		updateFang[id+"_2_0"] = 0;
		
		$("#"+id+"_2_1").attr("src","images/rod/l210.png");
		updateFang[id+"_2_1"] = 0;
		
		$("#"+id+"_2_2").attr("src","images/rod/l220.png");
		updateFang[id+"_2_2"] = 0;
		
		$("."+id+"_1_3").attr("src","images/rod/l130.png");
		updateFang[id+"_1_3"] = 0;
		
		$("."+id+"_1_3").attr("src","images/rod/l130.png");
		updateFang[id+"_1_3"] = 0;
		
		$("."+id+"_2_3").attr("src","images/rod/l230.png");
		updateFang[id+"_2_3"] = 0;
		
		$("."+id+"_0_3").attr("src","images/rod/l030.png");
		updateFang[id+"_0_3"] = 0;
}
