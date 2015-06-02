
var maphelper = null;//封装操作对象
var infowindow = null;//信息窗口
var mapobj = null;//地图对象
var markerZoom = 12;//标记红绿灯地图所在级别
var mapClickEventListener = null;
var markers = [];
var initMarkers = [];
var markermsg = [];

var markersJson = '';
var user=null;
var ips=[];
var options = "";



//绿波带
var markerids = [];
var dbclickable = true;
var clickable = false;
var dots = Array();
var lineId = Date.parse(new Date());//时间做唯一标示表示当前线的ID

var poly = null;

google.maps.event.addDomListener(window, "load", initialize);

 function initialize() {

	   var mapCanvas = document.getElementById("map_canvas");
		var myOptions = {
		zoom: markerZoom,   
		center: new Array(119.69663500785828, 31.369760901943426),  
		disableDefaultUI: false,   
		navigationControl: true,   
		navigationControlOptions: {position: google.maps.ControlPosition.RIGHT_TOP},    
		mapTypeControl: false, //比例尺控件  
		scaleControl: true,   //启用/停用在双击时缩放并居中
		disableDoubleClickZoom:true, 
		//地图类型
		//NORMAL_MAP 标注地图
		//HYBRID_MAP 卫星混合
		//OFFLINE_MAP 离线地图
		//TERRAIN_MAP 地形图
		mapTypeId: OFFLINE_MAP,
		mapPath:"maptile/googlemaps/roadmap/",
		mapFileExt:"png"
    };

    maphelper = new mapHelper();
    mapobj = maphelper.initMap(mapCanvas, myOptions);
	
	MarkersInit();

	//google.maps.event.addListener(mapobj, "rightclick", reset);

}




function ClearPoly() {
	maphelper.clearInstanceEvent(mapobj, 'click');//删除实例其所有事件侦听器或指定侦听器.
}





	//初始化信号机
function initSignal(marker) {
   
    //标记动画
    if (marker.getAnimation() != null) {
        marker.setAnimation(null);
    } else {
        marker.setAnimation(google.maps.Animation.BOUNCE);
    }

    var contentString = setMarkerContent(marker);
	
	if(infowindow)
		infowindow.close();
    infowindow = new google.maps.InfoWindow({ //根据HTML初始化infowindow
        content: contentString
    });

    infowindow.open(mapobj, marker);


    var MapsEvent = new google.maps.event.addListener(infowindow, 'closeclick',
			    function(event) {
			    		marker.setAnimation(null);
			    });

    setMarkerEvents(marker);

}




function removeClickListener() {
    if (mapClickEventListener) {
      google.maps.event.removeListener(mapClickEventListener);
      mapClickEventListener = null;
    }
  }
  
//设置信号机标示的事件
function setMarkerEvents(marker)
{
	 maphelper.bindInstanceEvent(marker, 'click', function(event,map,marker) {
	 		if(clickable)
	 		{
				if($.inArray( marker.id, markerids)==-1)
				{
					console.log(marker.id);
					markerids.push(marker.id);
					for(var i=0;i<initMarkers.length;i++)
					{
						if(initMarkers[i].id==marker.id)
						{
							console.log(initMarkers[i]);
							dots.push(new Array(initMarkers[i].getPosition().kb,initMarkers[i].getPosition().jb));
						}
					}
				}
				console.log(dots);
				 poly = maphelper.polyline({
						dots:dots,						
						color:"#008000",
						weight:16,
						opacity:0.5,
						id:lineId
				});
				
					maphelper.bindInstanceEvent(poly, 'dblclick', function(event,map) {
					
					console.log("这条线被打开了");
	        });
									
				
	 			$("#total_km").empty().text((poly.getLength()/1000).toFixed(3) + "km");  
	 		}
		});
		
		

	maphelper.bindInstanceEvent(marker, 'mouseover', function(event,map,marker) {
		
			//if(marker.isConnect&&!marker.isInitMarker)
			if(marker.initOver)
			{
			  	getMarkerWindow = new google.maps.InfoWindow({  content: getMarkerContent(marker) });
				getMarkerWindow.open(map, marker);
			}
			else
			{
				    var contentString = setMarkerContent(marker);

					if(infowindow)
						infowindow.close();
				    infowindow = new google.maps.InfoWindow({ //根据HTML初始化infowindow
				        content: contentString
				    });

				    infowindow.open(map, marker);

				    google.maps.event.addListener(infowindow, 'closeclick', function(event) {
		    			marker.setAnimation(null);
		    			});
			}
		 	
		 
		 
		});
		
	maphelper.bindInstanceEvent(marker, 'mouseout', function(event,map,marker) {
		 	if(getMarkerWindow)
		 	getMarkerWindow.close();
		 });

}

//初始化地图所有标志
function MarkersInit()
{
		$.ajax({   
	            url:'load',//这里是你的action或者servlert的路径地址   
	            type:'post', //数据发送方式   
	            dataType:'json', 
	            async:false,
	            error: function(msg)
	            { //失败   
	            	console.log('post失败');   
	            },   
	            success: function(msg)
	            { //成功
	            		encodeURI(msg);
	            		
	            	 	markermsg = msg;
	            	 	for(var i=0;i<markermsg.length;i++)
			    	    {
			    	    	ips.push(markermsg[i].ip);
				    	     var marker =  maphelper.markerPoint({
						  	    id:  markermsg[i].id,
								lat: markermsg[i].lat,
						        lng: markermsg[i].lng,
						        title: '红绿灯',
						        icon: "images/boot2.png"
				
						 	 });
						  marker.connectSuccess = true;
						  marker.initOver = true;
						  marker.ip = markermsg[i].ip;
						  marker.name = markermsg[i].name;
						  marker.address = markermsg[i].address;
						  setMarkerEvents(marker);
						  initMarkers.push(marker);
			    	    } 	   
			    	   
	            }  
    	    });  
}


//获得信号机基本信息
function getMarkerContent(marker)
{
	return '<div  id="content"><h1 id="">当前信号机</h1><div id="bodyContent">' 
	+ '<br><div style="margin-top:0.8px">&nbsp;ip&nbsp;地&nbsp;&nbsp;址&nbsp;&nbsp;：<input id="getip" value="'+marker.ip+'" name="signal_ipaddress" type="text"  width="25px"/></div>' 
	+ '<br><div style="margin-top:0.8px">信号机地址：<input  id="address" value="'+marker.name+'" name="signal_address" type="text"    width="25px"/></div>' 
	+ '<br><div style="margin-top:0.8px">信号机名称：<input id="name" value="'+marker.address+'" name="signal_name" type="text"   width="25px"/></div>' 
	'</div>' ;
}



//添加单个信号机标记
function saveMarker(id)
{
	for(var i=0;i<initMarkers.length;i++)
	{
		if(initMarkers[i].id == id)
		{
			var ip = $('#ipSelect').val();
			var address = $('#address').val();
			var name = $('#name').val();
			var lat = initMarkers[i].getPosition().jb;
			var lng = initMarkers[i].getPosition().kb;
			
			$.ajax({   
	            url:'addOrUpdate',//这里是你的action或者servlert的路径地址   
	            type:'post', //数据发送方式     
	 			data: { "id":id,"ip":ip,"address":address,"name":name,"lat":lat,"lng":lng},
	            error: function(msg)
	            { //失败   
	            	alert('信号机增加失败');   
	            },   
	            success: function(msg)
	            { //成功   
	          		if(infowindow)
					infowindow.close();
					alert('信号机绑定成功');   
	            }  
    	    });   
    	    
    	    initMarkers[i].initOver = true;
    	    initMarkers[i].setAnimation(null);
    	    initMarkers[i].name = name;
    	    initMarkers[i].address = address;
    	    initMarkers[i].ip = ip;
		}
	}
}


//删除单个信号机标记
function deleteMarker(id)
{
	for(var i=0;i<initMarkers.length;i++)
	{
	
		if(initMarkers[i].id == id)
		{
			$.ajax({   
	            url:'delete',//这里是你的action或者servlert的路径地址   
	            type:'post', //数据发送方式     
	 			data: { "id":id},
	            error: function(msg)
	            { //失败   
	            	alert('信号机删除失败');   
	            },   
	            success: function(msg)
	            { //成功   
	            	alert('信号机删除成功');   
	            }  
    	    });   
    	   	 initMarkers[i].setMap(null);
	         initMarkers.splice(i,1);
		}
	}
}


function Polyline() {
		alert("点击地图上的信号机");
 		 dbclickable = false;//双击屏蔽
		 clickable = true;//单击启动
}

//清楚当前绿线
function ClearPoly() {
	maphelper.clearPoly();
	maphelper.clearLine();
	$("#total_km").text("");
	dbclickable = false;//双击恢复
	clickable = true;//单击恢复
	
}


function saveLine()
{
	if(markerids.length<2)
	{
		alert("当前没有可保存的绿波带");
	}else
	{
		console.log(poly);
		var sids = "";
		for(var i=0;i<markerids.length;i++)
		{
			sids = sids +markerids[i]+",";
		}
		$.ajax({   
            url:'addLine',//这里是你的action或者servlert的路径地址   
            type:'post', //数据发送方式     
 			data: { "linemid":lineId,"sids":sids},
            error: function(msg)
            { //失败   
            		alert("当前绿波带保存失败"); 
            },   
            success: function(msg)
            { //成功   
					alert("当前绿波带保存成功");  
            }  
   	    });   
	
	}
	
}

