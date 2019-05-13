<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<div class="card mb-3" id="left">
	<div class="card-header">
		<i class="fas fa-table"></i>차량정보
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				
				<thead>
					<tr>
						<th>CAR Number</th>
						<th>예약상태</th>
						<th>Register date</th>
					</tr>
				</thead>
				<tfoot>
					<tr>
						<th>CAR Number</th>
						<th>예약상태</th>
						<th>Register date</th>
					</tr>
				</tfoot>
				<tbody>
					<c:forEach var="i" begin="1" end="${carlist.size() }" step="1">
						<tr>
							<c:choose>
								<c:when test="${'사용중' eq carlist[i-1].cstatus}"  >
									<td><a href="wcarst.myr?cid=${carlist[i-1].cid }">${carlist[i-1].cnum }</a></td>
									<td>${carlist[i-1].cstatus }</td>
									<td>${carlist[i-1].cregdate }</td>
								</c:when>
								<c:otherwise>
									<td>${carlist[i-1].cnum }</td>
									<td>${carlist[i-1].cstatus }</td>
									<td>${carlist[i-1].cregdate }</td>
								</c:otherwise>
							</c:choose>
							
							
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="card-footer small text-muted">Updated yesterday at
		11:59 PM</div>
</div>
<div class="w404">
<c:choose>
			<c:when test="${w404 != null }">
				<jsp:include page="${w404 }.jsp" />
			</c:when>
			<c:otherwise>
				<jsp:include page="w404.jsp" />
			</c:otherwise>
		</c:choose>
</div>