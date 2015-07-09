//时间段参数
function changeTimeSelect()
{
	var timetype = $("#timetype").val();
	var orderid = $("#orderid").val();
	var mklid = $("#mklid").val();
	location.href = "greenroadAction!tq?timetype="+timetype+"&orderid="+orderid+"&mklid="+mklid;
}


function deleteTqLine()
{
	console.log("进入删除")
	var mklid = $("#mklid").val();
	$.ajax({   
	            url:'deleteTqLine',//这里是你的action或者servlert的路径地址   
	            type:'post', //数据发送方式     
	 			data: { "mklid":mklid},
	            error: function(msg)
	            { //失败   
	            	alert('删除失败');   
	            },   
	            success: function(msg)
	            { //成功   
	            	alert('删除成功');   
	            	location.reload();  //刷新本页
	            }  
    	    });   	
}

function test()
{
	console.log("test");
}
$(document).ready(function(){
	//设置相位执行时间
		$(".dfinput_tqtime").on("blur",function(){
				console.log($(this));
				var time = $(this).val();
				time = parseInt(time);
				if(isNaN(time))
				{
					alert("执行时间设置不正确,请重新设置.");
					$(this).val(10);//恢复原值
					return ;
				}else
				{
					if(time<10||time>90)
					{
						alert("执行时间超出范围,相位执行时间10秒-90秒.");
						$(this).val(10);//恢复原值
						return ;
					}
				}
		});
		
		
		
	
		
		$("#doControl").on("click",function(){
			var zxselect = $(".zxselect");//获得一共多少个正确相位：代表需要设置的信号机
			var timetype = $("#timetype").val();
			var orderid = $("#orderid").val();
			var begintime = $("#begintime").val();
			var msg = '';
			zxselect.each( function(){
	          var sigid = parseInt($(this).val().split("_")[0]);//获得信号机id
	          var time = $("#"+sigid+"_time").val();
	          msg = msg + $(this).val()+"_"+time+",";
	    	 });
	    	 
	    	 
			 console.log("msg:"+msg,timetype,orderid,begintime);
			 if(msg!='')
			 {
			 	$.ajax({   
		            url:'doControl',//这里是你的action或者servlert的路径地址   
		            type:'post', //数据发送方式  
		            data: { "orderid":orderid,"timetype":timetype,"begintime":begintime,"dates":msg},  
		            error: function(msg)
		            { //失败   
		            	alert('发送命令失败');   
		            },   
		            success: function(msg)
		            { //成功   
						alert('设置成功');   
						msg = '';
		            }  
		   	    });  
			 
			 }
			 
			 
			 
		});
		
		
	
	
});