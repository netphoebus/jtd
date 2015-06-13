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

function executeAllCmdCommands()
{
	 executeCommand(1);
	 alert("执行命令1");
	 executeCommand(5);
	  alert("执行命令5");
	 executeCommand(6);
	  alert("执行命令6");
	 executeCommand(7);
	  alert("执行命令7");
	 executeCommand(8);
	  alert("执行命令8");
	 executeCommand(9);
	 alert("执行命令8");
	 executeCommand(10);
	 alert("执行命令8");
	 executeCommand(11);
	 alert("执行命令8");
	 executeCommand(12);
	 alert("执行命令8");
	 executeCommand(13);
	 alert("执行命令8");
	 executeCommand(14);
	 alert("执行命令8");
	 executeCommand(15);
	 alert("执行命令8");
	 executeCommand(16);
	 alert("执行命令8");
	 executeCommand(17);
	 alert("执行命令8");
	 executeCommand(18);
	 alert("执行命令8");
	 executeCommand(19);
	 alert("执行命令8");
	 executeCommand(20);
	 alert("执行命令8");
	 executeCommand(21);
	 alert("执行命令8");
	 executeCommand(22);
	 alert("执行命令8");
	 executeCommand(23);
	 alert("执行命令8");
	 executeCommand(24);
	 alert("执行命令8");
	 executeCommand(25);
	 alert("执行命令8");
	 executeCommand(26);
	 alert("执行命令8");
	 executeCommand(27);
	            
}

function executeSolutionCommands()
{
	 executeCommand(12);
	 executeCommand(13);
	 executeCommand(14);
	 executeCommand(15);
	 executeCommand(16);
	 executeCommand(17);
	 executeCommand(18);
	 executeCommand(19);
	 executeCommand(20);
	 executeCommand(21);
	 executeCommand(22);
	 executeCommand(23);
	 executeCommand(24);
	 executeCommand(25);
	 executeCommand(26);
	 executeCommand(27);
	            
}

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
