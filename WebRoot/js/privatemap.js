
var maphelper = null;//封装操作对象
var infowindow = null;//信息窗口
var mapobj = null;//地图对象
var markerZoom = 12;//标记红绿灯地图所在级别
var mapClickEventListener = null;
var markers = [];
var markerId = Date.parse(new Date());//时间做唯一标示
var markersJson = '';

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

	google.maps.event.addListener(mapobj, "rightclick", reset);

    addClickEventListener();

}

function reset() {

    for (var i in markers) {
      markers[i].setMap(null);
    }
    markers = [];
 }



function addClickEventListener() {
        if (!mapClickEventListener) {
          mapClickEventListener = google.maps.event.addListener(mapobj, 'click', function (event) {
            addMarker(event.latLng, true);
          });
        }
      }

	function addMarker(latlng, doQuery) {
		  var marker =  maphelper.markerPoint({
		  	    id:  markerId++,
				lat: latlng.lat(),
		        lng: latlng.lng(),
		        title: '红绿灯',
		        icon: "images/boot2.png"

		  });
		  marker.connectSuccess = false;
		  marker.initOver = false;
		  marker.name = '';
		  marker.address = '';
		  initSignal(marker);  
		  markers.push(marker);
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
	var getMarkerWindow = new google.maps.InfoWindow({  content: getMarkerContent(marker) });

	maphelper.bindInstanceEvent(marker, 'dblclick', function(event,map,marker) {
					location.href = "traffic.jsp";
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

	maphelper.bindInstanceEvent(marker, 'dragend', function(event,map,marker) {
		 	console.log(event.latLng);
		 	marker.setPosition(event.latLng);
		 });


	
}

//初始化标志
function MarkersInit()
{
		$.ajax({   
	            url:'load',//这里是你的action或者servlert的路径地址   
	            type:'post', //数据发送方式   
	            dataType:'json',  
	            error: function(msg)
	            { //失败   
	            	console.log('post失败');   
	            },   
	            success: function(msg)
	            { //成功
	            	  markers = msg;
	            		console.log(markers);
	            		 for(var i=0;i<markers.length;i++)
			    	    {
			    	    	console.log("进入");
				    	     var marker =  maphelper.markerPoint({
						  	    id:  markers[i].id,
								lat: markers[i].lat,
						        lng: markers[i].lng,
						        title: '红绿灯',
						        icon: "images/boot2.png"
				
						 	 });
						  marker.connectSuccess = true;
						  marker.initOver = true;
						  marker.name = markers[i].name;
						  marker.address = markers[i].address;
						  setMarkerEvents(marker);
			    	    } 	   
	            }  
    	    });   
}





//获得信号机基本信息
function getMarkerContent(marker)
{
	return '<div  id="content"><h1 id="">当前信号机</h1><div id="bodyContent">' 
	+ '<br><div style="margin-top:0.8px">&nbsp;ip&nbsp;地&nbsp;&nbsp;址&nbsp;&nbsp;：<input id="ip" value="'+marker.id+'" name="signal_ipaddress" type="text"  width="25px"/></div>' 
	+ '<br><div style="margin-top:0.8px">信号机地址：<input  id="address" value="'+marker.name+'" name="signal_address" type="text"     width="25px"/></div>' 
	+ '<br><div style="margin-top:0.8px">信号机名称：<input id="name" value="'+marker.address+'" name="signal_name" type="text"    width="25px"/></div>' 
	'</div>' ;
}

//绑定信号机并设置基本信息
function setMarkerContent(marker)
{

	return '<div  id="content"><h1 id="">绑定远程信号机</h1><div id="bodyContent">'
	+ '<div style="margin-top:10px; float:left; width:300px;">&nbsp;ip&nbsp;&nbsp;地&nbsp;&nbsp;址&nbsp;&nbsp;：<input id="ip" value="" name="signal_ipaddress" type="text" style="padding-bottom:1px;border:1px solid #cfdfe4" width="25px"/></div>' 
	+ '<br><div style="margin-top:5px; float:left; width:300px;">信号机地址：<input id="address" value="" name="signal_address" type="text"   style="padding-bottom:1px;border:1px solid #cfdfe4"  width="25px"/></div>' 
	+ '<br><div style="margin-top:5px; float:left; width:300px;">信号机名称：<input id="name" value="" name="signal_name" type="text"   style="padding-bottom:1px;border:1px solid #cfdfe4"  width="25px"/></div>' 
	+ '<br><div class="maptip"><btn><a href="javascript:saveMarker('+marker.id+')" target="rightFrame" ">绑定</a></btn></div></div>'

	'</div>' ;
}


//添加单个信号机
function saveMarker(id)
{
	for(var i=0;i<markers.length;i++)
	{
		if(markers[i].id == id)
		{
			var ip = $('#ip').val();
			var address = $('#address').val();
			var name = $('#name').val();
			var lat = markers[i].getPosition().jb;
			var lng = markers[i].getPosition().kb;
			

			$.ajax({   
	            url:'add',//这里是你的action或者servlert的路径地址   
	            type:'post', //数据发送方式     
	 			data: { "id":id,"ip":ip,"address":address,"name":name,"lat":lat,"lng":lng},
	            error: function(msg)
	            { //失败   
	            	console.log('post失败');   
	            },   
	            success: function(msg)
	            { //成功   
	          		if(infowindow)
					infowindow.close();
	            }  
    	    });   
    	    
    	    markers[i].initOver = true;
    	    markers[i].setAnimation(null);
    	    markers[i].name = name;
    	    markers[i].address = address;
		}
	}
}

function getMarkersJson(markers)
{
	
	for(var marker in markers)
	{
		marker.getPosition();
	}
}

function saveMarkers()
{
	var json_data = JSON.stringify(markers[0]); 
	console.log(json_data);
	$.ajax({   
            url:'add',//这里是你的action或者servlert的路径地址   
            type:'post', //数据发送方式     
 			data: { "markersJsonMsg": 123123},
            error: function(msg)
            { //失败   
            	console.log('Error loading document');   
            },   
            success: function(msg)
            { //成功   
            	
	           	 
            }  
    });     

}