
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
