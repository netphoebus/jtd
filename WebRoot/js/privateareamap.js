var maphelper = null;//封装操作对象
var infowindow = null;//信息窗口
var mapobj = null;//地图对象
var markerZoom = 13;//标记红绿灯地图所在级别
var mapClickEventListener = null;
var markers = [];
var initMarkers = [];
var markermsg = [];
var markerId = Date.parse(new Date());//时间做唯一标示
var markersJson = '';
var user=null;
var numbers=[];
var options = "";

var dbclick = false;



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
    
    

	maphelper.bindInstanceEvent(mapobj, 'zoom_changed', function(event){
		$("#ZOOM").val(maphelper.getZoom());
	});		
	
	maphelper.bindInstanceEvent(mapobj, 'dblclick', function(event){
		if(dbclick)
		{
			$("#CLAT").val(event.latLng.lat());
			$("#CLNG").val(event.latLng.lng());
		}

	});
	
	//MarkersInit();

	//google.maps.event.addListener(mapobj, "rightclick", reset);

}

//初始化select
function addOption(){  
		for(var i=0;i<numbers.length;i++){   
		  	options = options+"+<option value=" +numbers[i] + ">" + numbers[i] + "</option>"
		}   
    }  


function addArea() {
	//改变新增区域按钮状态
	if($("#addarea").css("background-image")!="none")
	{
		$("#addarea").css("background-image",'none').css("color","#000");
		dbclick = true;
	 	alert("双击地图位置作为区域中心点.");
	}
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
		        title: '中心点',
		        icon: "images/boot2.png"

		  });
		  marker.connectSuccess = false;
		  marker.initOver = false;
		  marker.name = '';
		  marker.address = '';
		  marker.dbclickable = false;
		  initSignal(marker);  
		  initMarkers.push(marker);
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
		
		maphelper.bindInstanceEvent(marker, 'dblclick', function(event,map,marker) {
					if(marker.dbclickable)
					{
						window.open("sigAction!toTraffic?mkid="+marker.id,"rightFrame");
					}
	        });

	
		maphelper.bindInstanceEvent(marker, 'mouseover', function(event,map,marker) {
		
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
		 	marker.setPosition(event.latLng);
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
			    	    	numbers.push(markermsg[i].number);
				    	     var marker =  maphelper.markerPoint({
						  	    id:  markermsg[i].id,
								lat: markermsg[i].lat,
						        lng: markermsg[i].lng,
						        title: '红绿灯',
						        icon: "images/boot2.png"
				
						 	 });
						  marker.dbclickable = true;
						  marker.connectSuccess = true;
						  marker.initOver = true;
						  marker.number = markermsg[i].number;
						  marker.name = markermsg[i].name;
						  marker.address = markermsg[i].address;
						  setMarkerEvents(marker);
						  initMarkers.push(marker);
			    	    } 	   
			    	   
	            }  
    	    });  
    	    addOption();//初始化select
}


//获得信号机基本信息
function getMarkerContent(marker)
{
	return '<div  id="content"><h1 id="">当前信号机</h1><div id="bodyContent">' 
	+ '<br><div style="margin-top:0.8px">信号机编号：<input id="getnumber" value="'+marker.number+'" name="signal_number" type="text"  width="25px"/></div>' 
	+ '<br><div style="margin-top:0.8px">信号机地址：<input  id="address" value="'+marker.name+'" name="signal_address" type="text"    width="25px"/></div>' 
	+ '<br><div style="margin-top:0.8px">信号机名称：<input id="name" value="'+marker.address+'" name="signal_name" type="text"   width="25px"/></div>' 
	'</div>' ;
}

//绑定信号机并设置基本信息
function setMarkerContent(marker)
{
	
	return '<div  id="content"><h1 id="">绑定远程信号机</h1><div id="bodyContent">'
	+ '<div style="margin-top:10px; float:left; width:300px;">&nbsp;信号机&nbsp;&nbsp;编&nbsp;&nbsp;号&nbsp;&nbsp;：<select id="numberSelect"  name="numberSelect"  style="padding-bottom:1px;border:1px solid #cfdfe4" width="25px">'
	+options+'</select></div>' 
	+ '<br><div style="margin-top:5px; float:left; width:300px;">信号机地址：<input id="address" value="" name="signal_address" type="text"   style="padding-bottom:1px;border:1px solid #cfdfe4"  width="25px"/></div>' 
	+ '<br><div style="margin-top:5px; float:left; width:300px;">信号机名称：<input id="name" value="" name="signal_name" type="text"   style="padding-bottom:1px;border:1px solid #cfdfe4"  width="25px"/></div>' 
	+ '<br><div class="maptip"><btn><a href="javascript:saveMarker('+marker.id+')" target="rightFrame" ">绑定</a></btn></div></div>'

	'</div>' ;
}


//添加单个信号机标记
function saveArea()
{
	//改变新增区域按钮状态
	if($("#addarea").css("background-image")!="none")
	{
		alert("请点击 添加区域 按钮.");
	}else
	{
		var areaname = $('#areaname').val();
		var lat = $("#CLAT").val();
		var lng = $("#CLNG").val();
		var zoom = $("#ZOOM").val();
		if(lng==""||isNaN(parseFloat(lng)))
		{
			alert("请正确填写经度.");
			return ;
		}
		if(lat==""||isNaN(parseFloat(lat)))
		{
			alert("请正确填写纬度.");
			return ;
		}if(areaname=="")
		{
			alert("请填写区域名称..");
			return ;
		}
		console.log(parseInt(zoom));
		if(zoom==""||zoom==0||isNaN(parseInt(zoom)))
		{
			alert("当前地图级别不正确..");
			return ;
		}
		//改变新增区域按钮状态
		if($("#addarea").css("background-image")=="none")
		{
			$("#addarea").css("background-image",'url(images/topbtn02.fw.png)').css("color","#fff");
			dbclick = false;
		}
		$.ajax({   
	           url:'addArea',//这里是你的action或者servlert的路径地址   
	           type:'post', //数据发送方式     
				data: { "lat":lat,"lng":lng,"zoom":parseInt(zoom),"uareaname":areaname},
	           error: function(msg)
	           { //失败   
	           		alert('区域添加失败');   
	           },   
	           success: function(msg)
	           { //成功   
					alert('区域添加成功');  
					self.location.reload();  //刷新本页
	           }  
	  	    });   
    	    
	
	}
	
    	 
}


$(document).ready(function(){

	$("#areaname").on("blur",function(){
	
			var uareaname = $(this).val();
			$.ajax({   
			            url:'checkAreaname',//这里是你的action或者servlert的路径地址   
			            type:'post', //数据发送方式   
			            async:false,
			            data: { "uareaname":uareaname},
			            dataType:'json',
			            error: function(msg)
			            { //失败   
			            	console.log('post失败');   
			            },   
			            success: function(msg)
			            { //成功
							 if(msg!=null)
							 {
							 	alert(msg.message);
						 		$(document).ready(function(){ 
						 			$("#areaname").val('');
						 		});
							 }
						}
					});
	
	
	});

});






