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
      div : "map_div", // map을 표시해줄 div
      width : "100%", // map의 width 설정
      height : "100%", // map의 height 설정
      });
   map.setCenter(new Tmap.LonLat("127.058908811749", "37.52084364186228").transform("EPSG:4326", "EPSG:3857"), 12);
   var routeLayer = new Tmap.Layer.Vector("route");
   map.addLayer(routeLayer);

   var markerStartLayer = new Tmap.Layer.Markers("start");
   var markerEndLayer = new Tmap.Layer.Markers("end");
   var markerWaypointLayer = new Tmap.Layer.Markers("waypoint");
   var markerWaypointLayer2 = new Tmap.Layer.Markers("waypoint2");
   var pointLayer = new Tmap.Layer.Vector("point");
    

   //2. 시작, 도착 심볼찍기
   //시작
   map.addLayer(markerStartLayer);

   var size = new Tmap.Size(24, 38);
   var offset = new Tmap.Pixel(-(size.w / 2), -size.h);
   var icon = new Tmap.IconHtml("<img src='http://tmapapis.sktelecom.com/upload/tmap/marker/pin_r_m_s.png' />", size, offset);
   var marker_s = new Tmap.Marker(new Tmap.LonLat(${slag },${slng }).transform("EPSG:4326", "EPSG:3857"), icon);
   markerStartLayer.addMarker(marker_s);

   //도착
   map.addLayer(markerEndLayer);

   var size = new Tmap.Size(24, 38);
   var offset = new Tmap.Pixel(-(size.w / 2), -size.h);
   var icon = new Tmap.IconHtml("<img src='http://tmapapis.sktelecom.com/upload/tmap/marker/pin_r_m_e.png' />", size, offset);
   var marker_e = new Tmap.Marker(new Tmap.LonLat(${elag }, ${elng }).transform("EPSG:4326", "EPSG:3857"), icon);
   markerEndLayer.addMarker(marker_e);
   pmarkerLayer = new Tmap.Layer.Markers();//마커 레이어 생성
   
   
   
   function findpath(lag,lng){
   //4. 경로 탐색 API 사용요청
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
               trafficInfo : "Y" //교통정보 표출 옵션입니다.
               },
               success:function(response){
                  prtcl = response;
                  //5. 경로탐색 결과 Line 그리기
                  //출발지,도착지 마커 제거
                  markerStartLayer.clearMarkers();
                  markerEndLayer.clearMarkers();
                  //경유지 마커 제거
                  var trafficColors = {
                        extractStyles:true,
                        /* 실제 교통정보가 표출되면 아래와 같은 Color로 Line이 생성됩니다. */
                        trafficDefaultColor:"#000000", //Default
                        trafficType1Color:"#009900", //원할
                        trafficType2Color:"#8E8111", //지체
                        trafficType3Color:"#FF0000", //정체
                        };    
                  var kmlForm = new Tmap.Format.KML(trafficColors).readTraffic(prtcl);
                  var routeLayer = new Tmap.Layer.Vector("vectorLayerID"); //백터 레이어 생성
                  routeLayer.addFeatures(kmlForm); // 교통정보를 백터 레이어에 추가   
                  map.addLayer(routeLayer); // 지도에 백터 레이어 추가
                  markerWaypointLayer2 = new Tmap.Layer.Markers("waypoint2");
                  map.addLayer(markerWaypointLayer2);
                  
                  map.addLayer(pmarkerLayer);//map에 마커 레이어 추가
                  console.log("marker");
                  map.setCenter(new Tmap.LonLat(lng,lag).transform("EPSG:4326", "EPSG:3857"), 12);
                  
                  plonlat = new Tmap.LonLat(lng,lag).transform("EPSG:4326", "EPSG:3857");//좌표 설정
                  var psize = new Tmap.Size(24, 38);//아이콘 크기 설정
                  var poffset = new Tmap.Pixel(-(psize.w / 2), -(psize.h));//아이콘 중심점 설정
                  picon = new Tmap.Icon('/Moyeora/carcar.png',psize, poffset);//마커 아이콘 설정
                     

                  // 6. 경로탐색 결과 반경만큼 지도 레벨 조정
                  map.zoomToExtent(routeLayer.getDataExtent());
         
                  },
                  error:function(request,status,error){
                     console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                     }
                  });
   
   pmarkerLayer.clearMarkers();
   pmarker = new Tmap.Marker(plonlat, picon);//마커 생성
   pmarkerLayer.addMarker(pmarker);//레이어에 마커 추가

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