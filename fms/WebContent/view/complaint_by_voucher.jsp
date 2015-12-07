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
            $("#complaints").dataTable({
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
		        <table id="complaints" class="display">
		            <thead>
		                <tr>
		                	<th align="left">Id</th>
		                    <th align="left">Complaint</th>
		                    <th align="left">Organization</th>
		                    <th align="left">Room No</th>
		                    <th align="left">Comments</th>
		                    <th align="left">Category</th>
		                    <th align="left">Status</th>
		                    <th align="left">Assigned To</th>
		                    <th align="left">Priority</th>
		                    <th align="left">Created On</th>
		                    <th align="left">Updated On</th> 
		                </tr>
		            </thead>
		            <tbody>
		          		<c:forEach items="${complaintList}" var="item">
						  <tr style="cursor:pointer" onmouseover="this.background='#C0C0C0'" ">
						    <td><c:out value="${item.complaintId}"></c:out></td>
						    <td><c:out value="${item.complaint}"></c:out></td>
						    <td><c:out value="${item.organization}"></c:out></td>
						    <td><c:out value="${item.roomNumber}"></c:out></td>
						    <td><c:out value="${item.comments}"></c:out></td>
						    <td><c:out value="${item.category}"></c:out></td>
						    <td><c:out value="${item.status}"></c:out></td>
						    <td><c:out value="${item.assignedto}"></c:out></td>
						    <td><c:out value="${item.priority}"></c:out></td>
						    <td><c:out value="${item.createdDate}"></c:out></td>
						    <td><c:out value="${item.updatedDate}"></c:out></td>  
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
