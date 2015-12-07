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
<link href="../view/media/dataTables/demo_page.css" rel="stylesheet"
	type="text/css" />
<link href="../view/media/dataTables/demo_table.css" rel="stylesheet"
	type="text/css" />
<link href="../view/media/dataTables/demo_table_jui.css"
	rel="stylesheet" type="text/css" />
<link href="../view/media/themes/base/jquery-ui.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="../view/media/themes/smoothness/jquery-ui-1.7.2.custom.css"
	rel="stylesheet" type="text/css" media="all" />
<script src="../view/scripts/jquery.js" type="text/javascript"></script>
<script src="../view/scripts/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
        $(document).ready(function () {
            $("#complaints").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            });
        });
        </script>

<link href="../view/style.css" rel="stylesheet" type="text/css" />
<link href="../view/textbox.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container2">
<div id="page2">
<div
	style="margin-left: 20%; font: normal 14px Verdana; color: #0000FF; margin-right: 15%;">
<c:url var="roomHisoryURL"
	value="/complaints/getRoomHistory.html" /> <form:form
	action="${roomHisoryURL}" method="post" commandName="complaintForm"
	id="dailyvehicle">
	<table cellpadding="6%" cellspacing="6%" id="rounded-corner">
	<thead>
	<tr>
	<th scope="col" class="rounded-left">&nbsp;</th>
		<th scope="col" class="rounded-right">Choose Organization And Room Number</th>
   </tr>
		</thead>
		<tbody>
		<tr>
			<td><strong>Organization <font color="red">*</font></strong></td>
			<td>
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
			</form:select></div>
			</td>

		</tr>

		<tr >
			<td width="50%"><strong>Room Number <font color="red">*</font></strong></td>

			<td>
			<form:input path="roomNumber" />
			</td>
		</tr></tbody>
		<tfoot>
		<tr>
			<td class="rounded-foot-left">&nbsp;&nbsp;&nbsp;<input type="submit" value="Search" /></td>
			<td class="rounded-foot-right"></td>
		</tr>
		</tfoot>
	</table>
</form:form>

</div>
	<c:if test="${!empty complaintList}">

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
					<th align="left">Priority</th>
					<th align="left">Created On</th>
					<th align="left">Updated On</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${complaintList}" var="item">
					<tr style="cursor: pointer" onmouseover="this.background='#C0C0C0'"">
						<td><c:out value="${item.complaintId}"></c:out></td>
						<td><c:out value="${item.complaint}"></c:out></td>
						<td><c:out value="${item.organization}"></c:out></td>
						<td><c:out value="${item.roomNumber}"></c:out></td>
						<td><c:out value="${item.comments}"></c:out></td>
						<td><c:out value="${item.category}"></c:out></td>
						<td><c:out value="${item.status}"></c:out></td>
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
	</c:if>
	</div>
</div>
</body>



</html>