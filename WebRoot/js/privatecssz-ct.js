//绿灯冲突
var updateCTs = {};
$(document).ready(function(){
	var imgsrc_new = "";//新的图片路径
	var img = null;
	var imgsrc="";
	var ids = {};
	var id = "";
			
	$("td img").click(function(event) {
			img = $(event.target);
			console.log(img);
			imgsrc = img[0].currentSrc;
			id = img[0].id;
			if(imgsrc.indexOf("tick")==-1)
			{
				$("#"+id).attr("src","img/tick.png");
				updateCTs[id] = 0;
			}else
			{
				$("#"+id).attr("src","img/cross.png");
				updateCTs[id] = 1;
				
			}
			console.log(updateCTs);
		});
		
	
});