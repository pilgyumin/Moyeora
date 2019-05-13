<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>simpleMap</title>
         <script src="https://api2.sktelecom.com/tmap/js?version=1&format=javascript&appKey=4ab58193-fb58-4392-967f-401a29e0a4c2"></script>
         <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script type="text/javascript">
			function initTmap(){
				var map = new Tmap.Map({
	div : "map_div", // map�� ǥ������ div
	width : "100%", // map�� width ����
	height : "380px", // map�� height ����
});
map.setCenter(new Tmap.LonLat("127.058908811749", "37.52084364186228").transform("EPSG:4326", "EPSG:3857"), 12);
var routeLayer = new Tmap.Layer.Vector("route");
map.addLayer(routeLayer);

var markerStartLayer = new Tmap.Layer.Markers("start");
var markerEndLayer = new Tmap.Layer.Markers("end");
var markerWaypointLayer = new Tmap.Layer.Markers("waypoint");
var markerWaypointLayer2 = new Tmap.Layer.Markers("waypoint2");
var pointLayer = new Tmap.Layer.Vector("point");

//2. ����, ���� �ɺ����
//����
map.addLayer(markerStartLayer);

var size = new Tmap.Size(24, 38);
var offset = new Tmap.Pixel(-(size.w / 2), -size.h);
var icon = new Tmap.IconHtml("<img src='http://tmapapis.sktelecom.com/upload/tmap/marker/pin_r_m_s.png' />", size, offset);
var marker_s = new Tmap.Marker(new Tmap.LonLat(${slag },${slng }).transform("EPSG:4326", "EPSG:3857"), icon);
markerStartLayer.addMarker(marker_s);

//����
map.addLayer(markerEndLayer);

var size = new Tmap.Size(24, 38);
var offset = new Tmap.Pixel(-(size.w / 2), -size.h);
var icon = new Tmap.IconHtml("<img src='http://tmapapis.sktelecom.com/upload/tmap/marker/pin_r_m_e.png' />", size, offset);
var marker_e = new Tmap.Marker(new Tmap.LonLat(${elag }, ${elng }).transform("EPSG:4326", "EPSG:3857"), icon);
markerEndLayer.addMarker(marker_e);




//4. ��� Ž�� API ����û
var startX = ${slag };
var startY = ${slng };
var endX = ${elag };
var endY = ${elng };
var prtcl;
var headers = {}; 
headers["appKey"]="4ab58193-fb58-4392-967f-401a29e0a4c2";
$.ajax({
		method:"POST",
		headers : headers,
		url:"https://api2.sktelecom.com/tmap/routes?version=1&format=xml",//
		async:false,
		data:{
			startX : startX,
			startY : startY,
			endX : endX,
			endY : endY,
			reqCoordType : "WGS84GEO",
			resCoordType : "EPSG3857",
			angle : "172",
			searchOption : "0",
			trafficInfo : "Y" //�������� ǥ�� �ɼ��Դϴ�.
		},
		success:function(response){
			prtcl = response;
		
		//5. ���Ž�� ��� Line �׸���
		//�����,������ ��Ŀ ����
		markerStartLayer.clearMarkers();
		markerEndLayer.clearMarkers();
		//������ ��Ŀ ����
						
		var trafficColors = {
				extractStyles:true,
				
				/* ���� ���������� ǥ��Ǹ� �Ʒ��� ���� Color�� Line�� �����˴ϴ�. */
				trafficDefaultColor:"#000000", //Default
				trafficType1Color:"#009900", //����
				trafficType2Color:"#8E8111", //��ü
				trafficType3Color:"#FF0000", //��ü
				
			};    
		var kmlForm = new Tmap.Format.KML(trafficColors).readTraffic(prtcl);
		var routeLayer = new Tmap.Layer.Vector("vectorLayerID"); //���� ���̾� ����
		routeLayer.addFeatures(kmlForm); // ���������� ���� ���̾ �߰�   
		
		map.addLayer(routeLayer); // ������ ���� ���̾� �߰�
		
		markerWaypointLayer2 = new Tmap.Layer.Markers("waypoint2");
		map.addLayer(markerWaypointLayer2);
		
		pmarkerLayer = new Tmap.Layer.Markers();//��Ŀ ���̾� ����
		map.addLayer(pmarkerLayer);//map�� ��Ŀ ���̾� �߰�
		   
		var plonlat = new Tmap.LonLat(${gpsx }, ${gpsy }).transform("EPSG:4326", "EPSG:3857");//��ǥ ����
		var psize = new Tmap.Size(24, 38);//������ ũ�� ����
		var poffset = new Tmap.Pixel(-(psize.w / 2), -(psize.h));//������ �߽��� ����
		var picon = new Tmap.Icon('http://tmapapis.sktelecom.com/upload/tmap/marker/pin_b_m_a.png',psize, poffset);//��Ŀ ������ ����
		
		pmarker = new Tmap.Marker(plonlat, picon);//��Ŀ ����
		pmarkerLayer.addMarker(pmarker);//���̾ ��Ŀ �߰�
		
		
		// 6. ���Ž�� ��� �ݰ游ŭ ���� ���� ����
		map.zoomToExtent(routeLayer.getDataExtent());
		
	},
	error:function(request,status,error){
		console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	}
});


			
			}
</script> 
 </head>
    <body onload="initTmap()">
        <div id="map_div">
        </div>        
    </body>
</html>	