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
            $("#vouchers").dataTable({
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
		        <table id="vouchers" class="display">
		            <thead>
		                <tr>
		                	<th align="left">Voucher Date</th>
		                	<th align="left">Issued Date</th>
		                	<th align="left">Paid Person</th>
		                	<th align="left">Received Person</th>
		                	<th align="left">Received Party</th>
		                    <th align="left">Purpose</th>
		                    <th align="left">Amount</th>
		                    <th align="left">Phone Number</th>
		                    <th align="left">Complaint</th>
		                   
		                </tr>
		            </thead>
		            <tbody>
		          		<c:forEach items="${voucherList}" var="item">
						  <tr style="cursor:pointer" onmouseover="this.background='#C0C0C0'" ">
						    <td><c:out value="${item.voucherDate}"></c:out></td>
						     <td><c:out value="${item.issuedDate}"></c:out></td>
						     <td><c:out value="${item.paidPerson}"></c:out></td>
						     <td><c:out value="${item.receivedPerson}"></c:out></td>
						      <td><c:out value="${item.receivedParty}"></c:out></td>
						    <td><c:out value="${item.towards}"></c:out></td>
						    <td>Rs.<c:out value="${item.amount}"></c:out>.00</td>
						     <td><c:out value="${item.phoneNumber}"></c:out></td>
						    
						    <td><a href="viewComplaint.html?complaintId=${item.complaintId}">Complaint</a></td>
						
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
