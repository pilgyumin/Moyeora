<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<script src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>
<script>
$(document).ready(function(){
    function goMap(lat,lng){
        var center = new google.maps.LatLng(
          lat,lng
        );
        map = new google.maps.Map(
        document.querySelector('#map'),
        {
            mapType:google.maps.MapTypeId.ROADMAP,
            zoom:15,
            center:center
            
        });
        
    };
	goMap(${lat },${lng });
});
</script>
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
	<div id="map" style="width:100%; height: 400px;"></div>
</div>