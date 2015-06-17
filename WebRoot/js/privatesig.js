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
	if($("#zdjs").val()=="一天")
	{
		setInterval("suretime()",60*1000*60*24);
	}else if($("#zdjs").val()=="一周")
	{
		setInterval("suretime()",60*1000*60*24*7);
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
		    	var interval = setInterval(updateProgressbarValue, 1500);
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
