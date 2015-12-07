<%@ include file="default.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Update The Machine Details</title>


<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script type="text/javascript"
	src="../view/jqueryValidations/jquery.validate.js"></script>
<script src="../view/jqueryValidations/formValidation.js"
	type="text/javascript"></script>
<script>
$(function() {
var availableRooms = ${rooms};	
$( "#roomNumber" ).autocomplete({
source: availableRooms
});
});
</script>	

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


<link href="../view/style.css" rel="stylesheet" type="text/css" />
<link href="../view/textbox.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="container1">
<div id="page1">
<div style="margin-left: 20%; font: normal 14px Verdana; color: #0000FF">
<c:url var="adminupdateMachineURL" value="/complaints/adminmachineUpdated.html" />
<form:form action="${adminupdateMachineURL}" method="post"
	commandName="updateMachineForm" id="AssetForm">
	<input type="hidden" name="organization" value="${organization}">
	<table cellpadding="10%" cellspacing="10%" id="rounded-corner" align="center"><thead><tr>
		<th scope="col" class="rounded-left">&nbsp; </th>
		<th scope="col" class="rounded-right">Enter New Machine Details</th></tr></thead>
		
		
    <tbody>
    <tr><td align="right">Machine Id <font color="red">*</font></td><td><form:input path="itassetid" readonly="true"/></td></tr>
		<tr>
			<td align="right">Machine Type <font color="red">*</font></td>
			<td><form:select path="machinetype">
				<form:option value="none" label="----------"></form:option>
				<form:option value="Computer" label="Computer"></form:option>
				<form:option value="Cameras" label="Cameras"></form:option>
				<form:option value="Printer" label="Printer"></form:option>
				<form:option value="Scanner" label="Scanner"></form:option>
				<form:option value="Xerox" label="Xerox"></form:option>
				<form:option value="UPS" label="UPS"></form:option>
				<form:option value="Switches" label="Switches"></form:option>
				
			</form:select></td>
		</tr>
		
		<tr>
			<td align="right">Machine Name <font color="red">*</font></td>
			<td><form:input path="machine"/></td>
		</tr>
		<tr>
			<td align="right">Room Number <font color="red">*</font></td>
			<td><form:input path="roomNumber" /></td>
		</tr>
		<tr>
			<td align="right">Description </td>
			<td><form:textarea path="description" /></td>
		</tr>
	
	
		<tr>
			<td >&nbsp;</td>
			<td ><input type="submit" value="Update" /></td>
		</tr>
		
</tbody>
	
		<tfoot><tr>
			<td class="rounded-foot-left"></td>
			<td class="rounded-foot-right"><strong>${msg}</strong></td>
		</tr></tfoot>
	</table>


</form:form></div>
</div>
</div>

</body>
<div><%@ include file="footer.jsp"%></div>
</html>