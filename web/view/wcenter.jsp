<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<div id="content-wrapper">

	<div class="container-fluid">

		<!-- Breadcrumbs-->
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
			<li class="breadcrumb-item active">Overview</li>
		</ol>

		<!-- Icon Cards-->
		<div class="row">
			<div class="col-xl-3 col-sm-6 mb-3">
				<div class="card text-white bg-primary o-hidden h-100">
					<div class="card-body">
						<div class="card-body-icon">
							<i class="fas fa-fw fa-comments"></i>
						</div>
						<div class="mr-5">26 New Messages!</div>
					</div>
					<a class="card-footer text-white clearfix small z-1" href="#">
						<span class="float-left">View Details</span> <span
						class="float-right"> <i class="fas fa-angle-right"></i>
					</span>
					</a>
				</div>
			</div>
			<div class="col-xl-3 col-sm-6 mb-3">
				<div class="card text-white bg-warning o-hidden h-100">
					<div class="card-body">
						<div class="card-body-icon">
							<i class="fas fa-fw fa-list"></i>
						</div>
						<div class="mr-5">11 New Tasks!</div>
					</div>
					<a class="card-footer text-white clearfix small z-1" href="#">
						<span class="float-left">View Details</span> <span
						class="float-right"> <i class="fas fa-angle-right"></i>
					</span>
					</a>
				</div>
			</div>
			<div class="col-xl-3 col-sm-6 mb-3">
				<div class="card text-white bg-success o-hidden h-100">
					<div class="card-body">
						<div class="card-body-icon">
							<i class="fas fa-fw fa-shopping-cart"></i>
						</div>
						<div class="mr-5">123 New Orders!</div>
					</div>
					<a class="card-footer text-white clearfix small z-1" href="#">
						<span class="float-left">View Details</span> <span
						class="float-right"> <i class="fas fa-angle-right"></i>
					</span>
					</a>
				</div>
			</div>
			<div class="col-xl-3 col-sm-6 mb-3">
				<div class="card text-white bg-danger o-hidden h-100">
					<div class="card-body">
						<div class="card-body-icon">
							<i class="fas fa-fw fa-life-ring"></i>
						</div>
						<div class="mr-5">13 New Tickets!</div>
					</div>
					<a class="card-footer text-white clearfix small z-1" href="#">
						<span class="float-left">View Details</span> <span
						class="float-right"> <i class="fas fa-angle-right"></i>
					</span>
					</a>
				</div>
			</div>
		</div>

		<!-- Area Chart Example-->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-chart-area"></i> Area Chart Example
			</div>
			<div class="card-body">
				<canvas id="myAreaChart" width="100%" height="30"></canvas>
			</div>
			<div class="card-footer small text-muted">Updated yesterday at
				11:59 PM</div>
		</div>

		<!-- DataTables Example -->
		<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i>ȸ������
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

	</div>