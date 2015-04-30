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
				alert('发送命令成功');   
            }  
   	    });   
}

function test()
{
	console.log("coming");
	executeCommand(5);
	location.href = "cssz-cz.html";
}