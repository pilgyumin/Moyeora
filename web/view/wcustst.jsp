<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i>회원 상세정보
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						 <!-- <thead>
							<tr>
								<th>주문번호</th>
								<th>회원ID</th>
								<th>차ID</th>
								<th>모듈ID</th>
								<th>주문 상태</th>
								<th>차량 종류</th>
								<th>수령 시간</th>
								<th>반납 시간</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>주문번호</th>
								<th>회원ID</th>
								<th>차ID</th>
								<th>모듈ID</th>
								<th>주문 상태</th>
								<th>차량 종류</th>
								<th>수령 시간</th>
								<th>반납 시간</th>
							</tr>
						</tfoot>  -->
						<tbody>
							<tr>
								<td>회원ID</td>
								<td>회원이름</td>
								<td>생년월일</td>
								<td>E-mail</td>
								<td>휴대폰 번호</td>
								<td>주소</td>
								<td>성별</td>
								<td>등록일</td>
							</tr>
							<tr>
								<td>${cust.cust_id }</td>
								<td>${cust.cust_name }</td>
								<td>${cust.cust_birthdate }</td>
								<td>${cust.cust_email }</td>
								<td>0${cust.cust_phone }</td>
								<td>${cust.cust_address }</td>
								<td>${cust.cust_sex }</td>
								<td>${cust.cust_regdate }</td>
							</tr>
							<tr><td colspan="8"></td></tr>
							<tr>
								<td>선호 1</td>
								<td>선호 2</td>
								<td>선호 3</td>
								<td>선호 차량</td>
								<td>조명</td>
								<td>온도</td>
								<td>좌석</td>
								<td>최근 이용 차량</td>
							</tr>
							<tr>
								<td>${cust.cust_fav1 }</td>
								<td>${cust.cust_fav2 }</td>
								<td>${cust.cust_fav3 }</td>
								<td>${cust.cust_favcar }</td>
								<td>${cust.ctmlgt }</td>
								<td>${cust.ctmtep }</td>
								<td>${cust.ctmseat }</td>
								<td>${cust.ctmcar }</td>
							</tr> 
							<tr><td colspan="8"></td></tr>
						</tbody>
					</table>
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>주문번호</th>
								<th>회원ID</th>
								<th>차ID</th>
								<th>모듈ID</th>
								<th>주문 상태</th>
								<th>차량 종류</th>
								<th>수령 시간</th>
								<th>반납 시간</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>주문번호</th>
								<th>회원ID</th>
								<th>차ID</th>
								<th>모듈ID</th>
								<th>주문 상태</th>
								<th>차량 종류</th>
								<th>수령 시간</th>
								<th>반납 시간</th>
							</tr>
						</tfoot>
						<tbody>
						<c:forEach var="i" begin="1" end="${olist.size() }" step="1">
							<tr>
								<td><a href="worderst.myr?oid=${olist[i-1].oid }">${olist[i-1].oid }</a></td>
								<td>${olist[i-1].cust_id }</td>
								<td>${olist[i-1].cid }</td>
								<td>${olist[i-1].mid }</td>
								<td>${olist[i-1].ostatus }</td>
								<td>${olist[i-1].mtype }</td>
								<td>${olist[i-1].stime }</td>
								<td>${olist[i-1].etime }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated yesterday at
				11:59 PM</div>
		</div>