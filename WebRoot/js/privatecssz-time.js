//时间段参数
function changeTime()
{
	var timetype = $("#timetype").val();
	var timeid = $("#timeid").val();
	var sid = $("#sid").val();
	console.log("sigtimeAction!sigtimes?sid="+sid+"&timeid="+timeid+"&sid="+sid);
	location.href = "sigtimeAction!sigtimes?timetype="+timetype+"&timeid="+timeid+"&sid="+sid;
}

function changeTimetype()
{
	var timetype = $("#timetype").val();
	var timeid = $("#timeid").val();
	var sid = $("#sid").val();
	console.log("sigtimeAction!sigtimes?sid="+sid+"&timeid="+timeid+"&sid="+sid);
	location.href = "sigtimeAction!sigtimes?timetype="+timetype+"&timeid="+timeid+"&sid="+sid;
}