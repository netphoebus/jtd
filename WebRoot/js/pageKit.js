//pageKit.js
//登陆页面，验证码
function changeImage()
{
			var v=document.getElementById("im");
			var anum = Math.random()*100;
			v.innerHTML="<img src=toolkitAction!validateCode?id="+anum+" width=80 height=32  />";
}

//分页显示
function jumpPage(url,page,con,convalue,status,pid){
console.log("enter1");
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&con='+con+'&convalue='+convalue+'&status='+status+'&pkid='+pid;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location=url;
}
//分页显示用户管理
function jumpPage(url,page,convalue){
console.log("userManage----------------");
	var page=page;
	if(isNaN(page)){
		var page2=document.getElementById(page).value;
		page=parseInt(page2);
	}
	
	var url=url+'?page='+page+'&convalue='+convalue;
	url=encodeURI(url);
	url=encodeURI(url);
	window.location=url;
}


function deleteBatch(url){
				var aa=document.all.chek;
				var loc=url+"!deleteBatch?ids=0";
				if(aa.value>0){
					loc=url+"!delete?id="+aa.value;
				}
				if(aa.length>0){
					for(var i=0;i<aa.length;i++){
						if(aa[i].checked==true){
							var cpid=aa[i].value;
							loc=loc+","+cpid;
						}
					}
				}
				
				window.location=loc;
}


//全选
function selectAll(){
	var aa=document.getElementsByName("chek");
	if(aa.length>0){
		for(var i=0;i<aa.length;i++){
			aa[i].checked=true;
		}
	}

}
//反选
function reverse(){
	var aa=document.getElementsByName("chek");
	if(aa.length>0){
		for(var i=0;i<aa.length;i++){
			if(aa[i].checked==false){
				aa[i].checked=true;
			}else{
				aa[i].checked=false;
			}
		}
	}

}
//禁止使用退格键backspace
function keyDown(){
            // 禁止使用backspace键
            if(window.event.keyCode == 8){
                alert("该文本框为只读");
                event.returnValue=false;
            }
            // 后面还可以禁止其它键，照着上面的方法写就行了
            // 比如：if(event.shiftKey&&event.keyCode == 121) // 屏蔽shift+F10
}
//公文字典多选择删除shoufatype_manage.jsp


function checkNum(obj){
    //定义正则表达式部分
    var num=obj.value;
    if(isNaN(num)){
        alert("密码只能输入数字");
        obj.value="";
        obj.focus();
    }
}



function checkNum2(){
    //定义正则表达式部分
    var num=obj.value;
    if(isNaN(num)){
        alert("密码只能输入数字");
        obj.value="";
        obj.focus();
    }
}

