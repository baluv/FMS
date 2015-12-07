<%@ include file="default.jsp"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <link href="../view/media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="../view/media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="../view/media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="../view/media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="../view/media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
        <script src="../view/scripts/jquery.js" type="text/javascript"></script>
        <script src="../view/scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script type="text/javascript">
        $(document).ready(function () {
            $("#dailyvehicledetails").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            });
        });
        </script>
    </head>
    
   
    <body >
    <div id="container1">
	<div id="page1">
    <div id="dt_example">
        <div id="container">
            <div id="demo_jui">
		        <table id="dailyvehicledetails" class="display">
		            <thead>
		                <tr>
		                	<th>Id</th>
		                    <th>Date</th>
		                    <th>Vehicle&nbsp;&nbsp;Number</th>
		                    <th>Driver&nbsp;&nbsp;Name</th>
		                    <th>Organization</th>
		                    <th>Moving&nbsp;&nbsp;To</th>
		                    <th>In&nbsp;&nbsp;Km</th>
		                    <th>Out&nbsp;&nbsp;Km</th>
		                    <th>Repair</th>
		                    <th>Amount</th>
		                    
		                </tr>
		            </thead>
		            <tbody>
		          		<c:forEach items="${dailyVehicleList}" var="item">
						  <tr style="cursor:pointer" onmouseover="this.background='#C0C0C0'" >
						    <td><c:out value="${item.dailyvehicleid}"></c:out></td>
						    <td><c:out value="${item.date}"></c:out></td>
						    <td><c:out value="${item.vehiclenumber}"></c:out></td>
						    <td><c:out value="${item.drivername}"></c:out></td>
						    <td><c:out value="${item.organization}"></c:out></td>
						    <td><c:out value="${item.towhere}"></c:out></td>
						    <td><c:out value="${item.inkm}"></c:out></td>
						    <td><c:out value="${item.outkm}"></c:out></td>
						    <td><c:out value="${item.repair}"></c:out></td>
						    <td><c:out value="${item.amount}"></c:out></td>
						 </tr>
						  </c:forEach>
		            </tbody>
		        </table>
		    </div>
        </div>
        </div>
        </div>
        </div>
    </body>
</html>
