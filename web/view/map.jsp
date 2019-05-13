<%@ page language="java" contentType="text/html; charset=EUC-KR"
   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>simpleMap</title>
<script
   src="https://api2.sktelecom.com/tmap/js?version=1&format=javascript&appKey=cc08e70a-b7b7-4328-ab7d-7197563b2ebb"></script>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">

function initTmap(){
   var map = new Tmap.Map({
      div : "map_div", // map�� ǥ������ div
      width : "100%", // map�� width ����
      height : "100%", // map�� height ����
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
   pmarkerLayer = new Tmap.Layer.Markers();//��Ŀ ���̾� ����
   
   
   
   function findpath(lag,lng){
   //4. ��� Ž�� API ����û
   var startX = 127.028792;
   var startY = 37.498085;
   var endX = ${slag };
   var endY = ${slng };
   var prtcl;
   var headers = {};
   var plonlat;
   var picon;

   headers["appKey"]="cc08e70a-b7b7-4328-ab7d-7197563b2ebb";   
   $.ajax({
      method:"POST",
      headers : headers,
      url:"https://api2.sktelecom.com/tmap/routes?version=1&format=xml",
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
                  
                  map.addLayer(pmarkerLayer);//map�� ��Ŀ ���̾� �߰�
                  console.log("marker");
                  map.setCenter(new Tmap.LonLat(lng,lag).transform("EPSG:4326", "EPSG:3857"), 12);
                  
                  plonlat = new Tmap.LonLat(lng,lag).transform("EPSG:4326", "EPSG:3857");//��ǥ ����
                  var psize = new Tmap.Size(24, 38);//������ ũ�� ����
                  var poffset = new Tmap.Pixel(-(psize.w / 2), -(psize.h));//������ �߽��� ����
                  picon = new Tmap.Icon('/Moyeora/carcar.png',psize, poffset);//��Ŀ ������ ����
                     

                  // 6. ���Ž�� ��� �ݰ游ŭ ���� ���� ����
                  map.zoomToExtent(routeLayer.getDataExtent());
         
                  },
                  error:function(request,status,error){
                     console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                     }
                  });
   
   pmarkerLayer.clearMarkers();
   pmarker = new Tmap.Marker(plonlat, picon);//��Ŀ ����
   pmarkerLayer.addMarker(pmarker);//���̾ ��Ŀ �߰�

   }

   
   findpath(37.498085, 127.028792);
   
   
   function getlocation(){
      var carmap;
      $.ajax({
         url:"idlocation.myr",
         async: false,
         type:"post",
         data:"cid="+ ${cid },
         success:function(location){
            var lag = location.lag;
            var lng = location.lng;
            findpath(lag, lng);
            carmap = location.carmap;
            },  
            error:function(request,status,error){
               alert("error");
            }
            });
      return carmap;
   }
   
   function start(cnt){
      var   go = 23;
      var count = 1;
      if(cnt < count){
         setTimeout(function() {
            go=getlocation();
            start(go);
               }, 3000);
      }
   }    
   start(0);

   }
   
   
     
   </script>
</head>
<style>
html, body {
   height: 100%
}
</style>
<body onload="initTmap()">
   <div id="map_div"></div>
</body>
</html>