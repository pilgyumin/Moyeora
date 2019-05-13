<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i>회원정보
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						<thead>
							<tr>
								<th>Name</th>
								<th>ID</th>
								<th>Sex</th>
								<th>email</th>
								<th>Phone</th>
								<th>Register date</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>Name</th>
								<th>ID</th>
								<th>Sex</th>
								<th>email</th>
								<th>Phone</th>
								<th>Register date</th>
							</tr>
						</tfoot>
						<tbody>
						<c:forEach var="i" begin="1" end="${clist.size() }" step="1">
							<tr>
								<td><a href="wcustst.myr?cust_id=${clist[i-1].cust_id }">${clist[i-1].cust_name }</a></td>
								<td>${clist[i-1].cust_id }</td>
								<td>${clist[i-1].cust_sex }</td>
								<td>${clist[i-1].cust_email }</td>
								<td>0${clist[i-1].cust_phone }</td>
								<td>${clist[i-1].cust_regdate }</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
			<div class="card-footer small text-muted">Updated yesterday at
				11:59 PM</div>
		</div>