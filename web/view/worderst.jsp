<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i>예약상세정보
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
								<td>주문번호</td>
								<td>회원ID</td>
								<td>차ID</td>
								<td>모듈ID</td>
								<td>주문 상태</td>
								<td>수령 시간</td>
								<td>반납 시간</td>
							</tr>
							<tr>
								<td>${olist.oid }</td>
								<td><a href="wcustst.myr?cust_id=${olist.cust_id }">${olist.cust_id }</a></td>
								<c:choose>
									<c:when test="${'운행완료' eq olist.ostatus }"  >
										<td>${olist.cid }</td>
									</c:when>
									<c:otherwise>
										<td><a href="currentlocation.myr?id=${olist.cust_id }">${olist.cid }</a></td>
									</c:otherwise>
								</c:choose>
								
								<td>${olist.mid }</td>
								<td>${olist.ostatus }</td>
								
								<td>${olist.stime }</td>
								<td>${olist.etime }</td>
							</tr>
							<tr>
								<td>차량옵션 1</td>
								<td>차량옵션 2</td>
								<td>차량옵션 3</td>
								<td>차량옵션 4</td>
								<td>차량 종류</td>
								<td>이용 금액</td>
								<td>주문 일시</td>
							</tr>
							<tr>
								<td>${olist.moption1 }</td>
								<td>${olist.moption2 }</td>
								<td>${olist.moption3 }</td>
								<td>${olist.moption4 }</td>
								<td>${olist.mtype }</td>
								<td>${olist.totalprice }</td>
								<td>${olist.odate }</td>
								
							</tr> 
						</tbody>
					</table>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated yesterday at
				11:59 PM</div>
		</div>