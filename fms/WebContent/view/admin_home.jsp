<%@ include file="default.jsp"%>
<html>
<head>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>

    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable(${ComplaintsByStatus});

       

        var chart = new google.visualization.PieChart(document.getElementById('complaints_by_status'));
        chart.draw(data,{width: 400, height: 300, title: 'Complaints by Status'});
      }
    </script>
   

    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable(${ComplaintsByCategory});

      
        var chart = new google.visualization.PieChart(document.getElementById('complaints_by_category'));
        chart.draw(data,{width: 400, height: 300, title: 'Complaints by Category'});
      }
    </script>
    <script type="text/javascript">
      google.load("visualization", "1", {packages:["corechart"]});
      google.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable(${ComplaintsByOrganization});

      
        var chart = new google.visualization.PieChart(document.getElementById('complaints_by_organization'));
        chart.draw(data,{width: 400, height: 300, title: 'Complaints by Organization'});
      }
    </script>
</head>
<body>

<div id="container1">
<div id="page1">
<table style="border:1px solid #eee" cellspacing="2"  >
				<tr>
					<td align="left"><div id="complaints_by_status"></div></td>
					<td align="left"><div id="complaints_by_category"></div></td>
					<td align="left"><div id="complaints_by_organization"></div></td>
				</tr>
			</table>
</div>
</div>
</body>
<div>
<%@ include file="footer.jsp"%>
</div>
</html>