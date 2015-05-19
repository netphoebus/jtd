
function initPublicParam() {
	//css部分
	$("#xyxr").click(function () {
		if ($("#xyxr").attr("checked") == "checked") {
			$("#xr").show();
		} else {
			$("#xr").hide();
		}
	});
	$("#spetime").click(function () {
		if ($("#spetime").attr("checked") == "checked") {
			$("#spe").show();
		} else {
			$("#spe").hide();
		}
	});
	$("#suntime").click(function () {
		if ($("#suntime").attr("checked") == "checked") {
			$("#sunt").show();
		} else {
			$("#sunt").hide();
		}
	});
	
	



	//checkbox部分
	if ($("#xyxr").attr("value") == 1) {
		$("#xyxr").attr("checked", "checked");
		$("#xr").show();
	} else {
		$("#xr").hide();
	}
	if ($("#spetime").attr("value") == 1) {
		$("#spetime").attr("checked", "checked");
		$("#spe").show();
	} else {
		$("#spe").hide();
	}
	if ($("#suntime").attr("value") == 1) {
		$("#suntime").attr("checked", "checked");
		$("#sunt").show();
	} else {
		$("#sunt").hide();
	}
	
	
	
	//checkbox部分
	if ($("#mon").attr("value") == 1) {
		$("#mon").attr("checked", "checked");
	}
	if ($("#tue").attr("value") == 1) {
		$("#tue").attr("checked", "checked");
	}
	if ($("#wes").attr("value") == 1) {
		$("#wes").attr("checked", "checked");
	}
	if ($("#thir").attr("value") == 1) {
		$("#thir").attr("checked", "checked");
	}
	if ($("#fra").attr("value") == 1) {
		$("#fra").attr("checked", "checked");
	}
	if ($("#sata").attr("value") == 1) {
		$("#sata").attr("checked", "checked");
	}
	if ($("#sun").attr("value") == 1) {
		$("#sun").attr("checked", "checked");
	}
}


function cleanAll()
{
	$(':input','#publicparamform')  
	 .not(':button, :submit, :reset, :hidden')  
	 .val('')  
}

function changeSolution()
{
	$("#solutions").val();
	console.log($("#solutions").val());
	window.open("solutionAction!solutions?soid="+$("#solutions").val(),"rightFrame");
}

$(document).ready(function(){

	$("div img").click(function(event) {
	
			var start = "";
			var end = "";
			
			var imgsrc_new = "";
			
			var img = $(event.target);
			
			console.log(img[0].src);
			
			var imgsrc = img[0].src;
			
			end = imgsrc.indexOf(".png")-38;
			
			if(img[0].id==null||img[0].id =="")
			{
				var imgclass= img[0].classList[0];
				
				start = imgclass.substr(imgclass.length-2,imgclass.length);
				
			}else
			{
				var imgid = img[0].id;
				start = imgid.substr(imgid.length-2,imgid.length);
			}
			start = imgsrc.indexOf(start);
			
			imgsrc_new = imgsrc.substr(start,end);
			console.log(imgsrc_new);
			var headnumber = imgsrc_new.substr(0,imgsrc_new.length-1);
			var lastnumber = imgsrc_new.substr(imgsrc_new.length-1,imgsrc_new.length);
			console.log(headnumber);
			console.log(lastnumber);
			if(lastnumber<3)
			{
				lastnumber = parseInt(lastnumber)+1;
				imgsrc_new = "images/rod/l"+headnumber+lastnumber+".png";
			}else
			{
				imgsrc_new = "images/rod/l"+headnumber+"0"+".png";
			}
			
			img.attr("src",imgsrc_new);
		});
});
