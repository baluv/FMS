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

<link href="../view/jquery-ui.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../view/js/format.js"></script>

<script type="text/javascript" src="../view/js/jquery-ui.js"></script>

<link href="../view/style.css" rel="stylesheet" type="text/css" />
<link href="../view/textbox.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="container1">
<div id="page1">
<div
	style="margin-left: 20%; font: normal 14px Verdana; color: #0000FF; margin-right: 15%;">
<c:url var="saveExistingVehicleURL"
	value="/complaints/saveExistingVehicle.html" /> <form:form
	action="${saveExistingVehicleURL}" method="post"
	commandName="existingvehicleform" id="existingvehicle">
	<table cellpadding="10%" cellspacing="10%"  id="rounded-corner">
	<thead>
		<tr>
		<th scope="col" class="rounded-left">&nbsp;</th>
			<th scope="col" class="rounded-right">Existing Vehicles Details</th>
		</tr>
		</thead>
		<tbody>
		<tr>
			<td align="right">Vehicle Number <font color="red">*</font></td>
			<td><c:if test="${!empty vehiclelist}">
				<form:select path="vehiclenumber">
					<form:option value="none">Select</form:option>
					<c:forEach items="${vehiclelist}" var="item">
						<form:option value="${item.vehiclenumber}">
							<c:out value="${item.vehiclenumber}"></c:out>
						</form:option>
					</c:forEach>
				</form:select>
			</c:if></td>
		</tr>
		<tr>
			<td align="right">Date <font color="red">*</font></td>
			<td><form:input path="servicedate" cssClass="datepicker"></form:input></td>
		</tr>
		<tr>
			<td align="right">Person <font color="red">*</font></td>
			<td><form:input path="person"></form:input></td>
		</tr>
		<tr>
			<td align="right">Amount <font color="red">*</font></td>
			<td><form:input path="amount"></form:input></td>
		</tr>
		<tr>
			<td align="right">Comments </td>
			<td><form:textarea path="comments" ></form:textarea></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="save" /></td>
		</tr>
</tbody>
<tfoot>
					<tr>
					<td class="rounded-foot-left">&nbsp;</td>
					<td class="rounded-foot-right"><strong>${successMessage}</strong></td>
					</tr>
					</tfoot>
	</table>
	

</form:form></div>
</div>
</div>

</body>
<div><%@ include file="footer.jsp"%>
</div>
</html>