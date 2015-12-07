<%@ include file="default.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

   

<script type="text/javascript"
	src="../view/jqueryValidations/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="../view/jqueryValidations/jquery.validate.js"></script>
<script src="../view/jqueryValidations/formValidation.js"
	type="text/javascript"></script>
<style type="text/css">
* {
	font-family: Verdana;
	font-size: 11px;
	line-height: 14px;
}

.submit {
	margin-left: 125px;
	margin-top: 10px;
}

.label {
	display: block;
	float: left;
	width: 120px;
	text-align: right;
	margin-right: 5px;
}

.form-row {
	padding: 5px 0;
	clear: both;
	width: 700px;
}

label.error {
	width: 250px;
	display: block;
	float: left;
	color: red;
	padding-left: 10px;
}

input[type=text],input[type=password],textarea {
	width: 250px;
	float: left;
}

textarea {
	height: 50px;
}
</style>
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
<body>
<div
	style="margin-left: 30%; font: normal 14px Verdana; color: #0000FF;">
<c:url var="searchComplaintsURL"
	value="/complaints/searchComplaintsbyOrganization.html" /> <form:form
	action="${searchComplaintsURL}" method="post"
	commandName="orgForm" id="dailyvehicle">
	<div class="form-row"><form:select path="organization"
				id="org1">
				<form:option value="none" label="----select-----" />
				<form:option value="AECS Administrative Office"
					label="AECS Administrative Office" />
				<form:option value="Maaruti Dental College"
					label="Maaruti Dental College" />
				<form:option value="Maaruti Dental College Boys Hostel"
					label="Maaruti Dental College Boys Hostel" />
				<form:option value="Maaruti Dental College Girls Hostel"
					label="Maaruti Dental College Girls Hostel" />
				<form:option value="Kaleya Nagar Nursing Hostel"
					label="Kaleya Nagar Nursing Hostel" />
				<form:option value="Maaruti Nursing College Building Boys Hostel"
					label="Maaruti Nursing College Building Boys Hostel" />
				<form:option value="Maaruti Nursing College Building Girls Hostel"
					label="Maaruti Nursing College Building Girls Hostel" />
				<form:option value="Maaruti Nursing College"
					label="Maaruti Nursing College" />
				<form:option value="MMPS School" label="MMPS School" />
			</form:select><input type="submit" value="  GO  " /></div>
</form:form></div>

<div id="dt_example">
        <div id="container">
            <div id="demo_jui">
		        <table id="complaints" class="display">
		            <thead>
		                 <tr>
		                    <th align="left">Complaint</th>
		                    <th align="left">Organization</th>
		                    <th align="left">Room&nbsp;&nbsp;No</th>
		                    <th align="left">Comments</th>
		                   	<th align="left">Category</th>
		                     <th align="left">Machine</th>
		                    <th align="left">Status</th>
		                    <th align="left">Priority</th>
		                    <th align="left">Created&nbsp;&nbsp;On</th>
		                    <th align="left">Updated&nbsp;&nbsp;On</th>
		                     <th align="left">Update</th>
		                    <th align="left">Voucher</th>   
		                </tr>
		            </thead>
		            <tbody>
		          		<c:forEach items="${complaintList}" var="item">
						  <tr style="cursor:pointer" onmouseover="this.background='#C0C0C0'" ">
						    <td><c:out value="${item.complaint}"></c:out></td>
						    <td><c:out value="${item.organization}"></c:out></td>
						    <td><c:out value="${item.roomNumber}"></c:out></td>
						    <td><c:out value="${item.comments}"></c:out></td>
						    <td><c:out value="${item.category}"></c:out></td>
						     <td><c:out value="${item.machine}"></c:out></td>
						    <td><c:out value="${item.status}"></c:out></td>
						    <td><c:out value="${item.priority}"></c:out></td>
						    <td><c:out value="${item.createdDate}"></c:out></td>
						    <td><c:out value="${item.updatedDate}"></c:out></td>  
						    <td><a href="updateComplaint.html?complaintId=${item.complaintId}&complaint=${item.complaint}&roomNumber=${item.roomNumber}&priority=${item.priority}&category=${item.category}&status=${item.status}&comments=${item.comments} ">Update</a></td>
						    <td><a href="voucher.html?cid=${item.complaintId}">Voucher</a></td>
						 </tr>
						 </c:forEach>
		            </tbody>       
		        </table>
		    </div>
        </div>
  	 </div>        
</body>
<div>
<%@ include file="footer.jsp"%>
</div>
</html>