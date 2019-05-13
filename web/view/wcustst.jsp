<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<div class="card mb-3">
			<div class="card-header">
				<i class="fas fa-table"></i>ȸ�� ������
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
								<td>ȸ��ID</td>
								<td>ȸ���̸�</td>
								<td>�������</td>
								<td>E-mail</td>
								<td>�޴��� ��ȣ</td>
								<td>�ּ�</td>
								<td>����</td>
								<td>�����</td>
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
								<td>��ȣ 1</td>
								<td>��ȣ 2</td>
								<td>��ȣ 3</td>
								<td>��ȣ ����</td>
								<td>����</td>
								<td>�µ�</td>
								<td>�¼�</td>
								<td>�ֱ� �̿� ����</td>
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