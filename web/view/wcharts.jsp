<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.load('current', {'packages':['bar']});
      google.charts.setOnLoadCallback(drawpieChart);
      google.charts.setOnLoadCallback(drawlineChart);
      google.charts.setOnLoadCallback(drawbarChart);
      function drawpieChart() {

        var data = google.visualization.arrayToDataTable([
          ['�������', 'jjj'],
          ['����',     ${mportion }],
          ['����',     ${fportion }]
         
        ]);

         var options = {
          title: '���� ����'
        }; 

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
      function drawlineChart() {
          var data = google.visualization.arrayToDataTable([
            ['��', '���� ����հ�'],
            ['18.11',  ${nov }],
            ['18.12',  ${dec }],
            ['19.01',  ${jan }],
            ['19.02',  ${feb }]
          ]);

          var options = {
            title: '���� �̿��� �հ�',
            curveType: 'function',
            legend: { position: 'bottom' }
          };

          var chart = new google.visualization.LineChart(document.getElementById('linechart'));

          chart.draw(data, options);
        }
      function drawbarChart() {
          var data = google.visualization.arrayToDataTable([
            ['�ɼ�', 'Ƚ��'],
            ['�����', ${ref } ],
            ['���ڷ�����', ${mic } ],
            ['����������', ${gas } ]
          ]);

          var options = {
                  bars: 'vertical', // Required for Material Bar Charts.
                  /* axes: {
                    x: {
                      0: { side: 'top', label: 'Percentage'} // Top x-axis.
                    }
                  }, */
                  bar: { groupWidth: "80%" }
                };
          var chart = new google.charts.Bar(document.getElementById('barchart'));
          chart.draw(data, options);
      }
    </script>
<div class="container-fluid">
<!-- �������� pi graph
���� ���ð� line graph
��Ÿ�,�ܰŸ� option top3  bar graph -->

	<!-- Breadcrumbs-->
	<ol class="breadcrumb">
		<li class="breadcrumb-item"><a href="#">Dashboard</a></li>
		<li class="breadcrumb-item active">Charts</li>
	</ol>

	<!-- Area Chart Example-->
	<div class="card mb-3">
		<div class="card-header">
			<i class="fas fa-chart-area"></i> ���� �̿��� �հ�
		</div>
		<div id="linechart">
		</div>
		<div class="card-footer small text-muted">Updated yesterday at
			11:59 PM</div>
	</div>

	<div class="row">
		<div class="col-lg-8">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-chart-bar"></i> ��ȣ �ɼ� TOP3
				</div>
				<div id="barchart">
				</div>
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</div>
		</div>
		<div class="col-lg-4">
			<div class="card mb-3">
				<div class="card-header">
					<i class="fas fa-chart-pie"></i> ���� ����
				</div>
				<div id="piechart">
				</div>
				<div class="card-footer small text-muted">Updated yesterday at
					11:59 PM</div>
			</div>
		</div>
	</div>

	<p class="small text-center text-muted my-5">
		<em>More chart examples coming soon...</em>
	</p>

</div>
