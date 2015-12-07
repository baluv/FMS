<%@ include file="org_default.jsp"%>
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
            $("#existingmachine").dataTable({
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
		        <table id="existingmachine" class="display">
		            <thead>
		                <tr>
		                	<th align="left">Id</th>
		                    <th align="left">Machine Type</th>
		                     <th align="left">Machine</th>
		                      <th align="left">Room No</th>
		                       <th align="left">Description</th>
		                    <th align="left">Update</th>
		                    <th align="left">Delete</th> 
		                </tr>
		            </thead>
		            <tbody>
		          		<c:forEach items="${machineList}" var="item">
						  <tr style="cursor:pointer" onmouseover="this.background='#C0C0C0'" ">
						    <td><c:out value="${item.itassetid}"></c:out></td>
						    <td><c:out value="${item.machinetype}"></c:out></td>
						    <td><c:out value="${item.machine}"></c:out></td>
						    <td><c:out value="${item.roomNumber}"></c:out></td>
						    <td><c:out value="${item.description}"></c:out></td>
						   <td><a href="updateMachine.html?itassetid=${item.itassetid}&machinetype=${item.machinetype}&machine=${item.machine}&roomNumber=${item.roomNumber}&description=${item.description}">Update</a></td> 
						   <td><a href="deleteMachine.html?itassetid=${item.itassetid}&organization=${organization}" onclick="return confirm('Are you sure you want to delete?')">Delete</a></td> 
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
