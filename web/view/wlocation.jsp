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
      height : "700px", // map의 height 설정
      });
   map.setCenter(new Tmap.LonLat("127.0275", "37.498").transform("EPSG:4326", "EPSG:3857"), 12);
   var routeLayer = new Tmap.Layer.Vector("route");
   map.addLayer(routeLayer);

   var markerStartLayer = new Tmap.Layer.Markers("start");
   var markerEndLayer = new Tmap.Layer.Markers("end");
   var markerWaypointLayer = new Tmap.Layer.Markers("waypoint");
   var markerWaypointLayer2 = new Tmap.Layer.Markers("waypoint2");
   var pointLayer = new Tmap.Layer.Vector("point");
    

   pmarkerLayer = new Tmap.Layer.Markers();//마커 레이어 생성
   map.zoomTo(14);

   function findpath(lag,lng){
   //4. 경로 탐색 API 사용요청
   var startX = ${slag };
   var startY = ${slng };
   var endX = ${elag };
   var endY = ${elng }; 
   var prtcl;
   var headers = {};
   var plonlat;
   var picon;

   map.addLayer(pmarkerLayer);//map에 마커 레이어 추가
   console.log("marker");
   
   plonlat = new Tmap.LonLat(lng,lag).transform("EPSG:4326", "EPSG:3857");//좌표 설정
   var psize = new Tmap.Size(24, 38);//아이콘 크기 설정
   var poffset = new Tmap.Pixel(-(psize.w / 2), -(psize.h));//아이콘 중심점 설정
   picon = new Tmap.Icon('/Moyeora/caricon.jpg',psize, poffset);//마커 아이콘 설정
      
   
   pmarkerLayer.clearMarkers();
   pmarker = new Tmap.Marker(plonlat, picon);//마커 생성
   pmarkerLayer.addMarker(pmarker);//레이어에 마커 추가

   }
   
   findpath(37.499683, 127.034085);
   
   /* go=getlocation();
   start(go); */
   
   
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

<body onload="initTmap()">
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i>상세차량정보
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<!-- <thead>
					<tr>
						<th>Name</th>
						<th>Position</th>
						<th>Office</th>
						<th>Age</th>
						<th>Start date</th>
						<th>Salary</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>Name</th>
						<th>Position</th>
						<th>Office</th>
						<th>Age</th>
						<th>Start date</th>
						<th>Salary</th>
					</tr>
				</tfoot> -->
				<tbody>
					<tr>
						<td>차량 번호 : ${carst.cid }</td>
						<td colspan="5">등록일 : ${carst.cregdate }</td>
					</tr>
					<tr>
						<td>배터리 : ${carst.battery }</td>
						<td>RPM : ${carst.rpm }</td>
						<td>속도 : ${carst.speed }</td>
						<td>현재온도 : ${carst.ptemp }</td>
						<td>희망온도 : ${carst.htemp}</td>
						<td>조명 : ${carst.light }</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<div id="map_div" style="width:100%; height: 500px;"></div>
</div>
   
</body>
</html>