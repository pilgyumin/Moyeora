<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i>���������
			</div>
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">
						 <!-- <thead>
							<tr>
								<th>�ֹ���ȣ</th>
								<th>ȸ��ID</th>
								<th>��ID</th>
								<th>���ID</th>
								<th>�ֹ� ����</th>
								<th>���� ����</th>
								<th>���� �ð�</th>
								<th>�ݳ� �ð�</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th>�ֹ���ȣ</th>
								<th>ȸ��ID</th>
								<th>��ID</th>
								<th>���ID</th>
								<th>�ֹ� ����</th>
								<th>���� ����</th>
								<th>���� �ð�</th>
								<th>�ݳ� �ð�</th>
							</tr>
						</tfoot>  -->
						<tbody>
							<tr>
								<td>�ֹ���ȣ</td>
								<td>ȸ��ID</td>
								<td>��ID</td>
								<td>���ID</td>
								<td>�ֹ� ����</td>
								<td>���� �ð�</td>
								<td>�ݳ� �ð�</td>
							</tr>
							<tr>
								<td>${olist.oid }</td>
								<td><a href="wcustst.myr?cust_id=${olist.cust_id }">${olist.cust_id }</a></td>
								<c:choose>
									<c:when test="${'����Ϸ�' eq olist.ostatus }"  >
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
								<td>�����ɼ� 1</td>
								<td>�����ɼ� 2</td>
								<td>�����ɼ� 3</td>
								<td>�����ɼ� 4</td>
								<td>���� ����</td>
								<td>�̿� �ݾ�</td>
								<td>�ֹ� �Ͻ�</td>
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