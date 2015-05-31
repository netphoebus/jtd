//时间段参数
function changeTimeSelect()
{
	var timetype = $("#timetype").val();
	var timeid = $("#timeid").val();
	console.log("sigtimeAction!sigtimes?timetype="+timetype+"&timeid="+timeid);
	location.href = "sigtimeAction!sigtimes?timetype="+timetype+"&timeid="+timeid;
}

function changeSoSelect()
{
	var timetype = $("#timetype").val();
	var timeid = $("#timeid").val();
	var soid = $("#soid").val();
	console.log("sigtimeAction!sigtimes?timetype="+timetype+"&timeid="+timeid+"&soid="+soid);
	location.href = "sigtimeAction!sigtimes?timetype="+timetype+"&timeid="+timeid+"&soid="+soid;
}

var msg = "";
function updateStepTimes()
{
	var timeinputs = $(".timeinput");
	for(var i=0;i<timeinputs.length;i++){
        msg = msg + timeinputs[i].name+":"+ timeinputs[i].value+",";
	}
	$.ajax({   
            url:'updateStepTimes',//这里是你的action或者servlert的路径地址   
            type:'post', //数据发送方式  
            data: { "dates":msg},  
            traditional: true,  
            error: function(msg)
            { //失败   
            	alert('发送命令失败');   
            },   
            success: function(msg)
            { //成功   
				alert('修改步序执行时间');   
				msg = "";
            }  
   	    });  
}