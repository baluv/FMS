a<%@ include file="default.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Inward Returnable Form</title>


<script src="http://code.jquery.com/jquery-1.9.1.js"></script>

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
<div style="margin-left: 25%; font: normal 14px Verdana; color: #0000FF">
<c:url var="saveaOutwarURL" value="/complaints/outwardupdated.html" />
<form:form action="${saveaOutwarURL}" method="post"
	commandName="outwardupdateForm" id="outwardForm">
	<input type="hidden" name="organization" value="${organization}">
	<table cellpadding="10%" cellspacing="10%" id="rounded-corner">
	<thead>
	<tr>
	<th bgcolor="#E4E6F5" class="rounded-left">&nbsp;</th>
		<th bgcolor="#E4E6F5" class="rounded-right">Enter Outward Returnable Details</th></tr></thead>
		<tbody>
		<tr><td align="right">Id <font color="red">*</font></td>
		<td><form:input path="id" readonly="true"/></td></tr>
		<tr>
			<td align="right">Date <font color="red">*</font></td>
			<td><form:input path="date" cssClass="datepicker"/></td>
		</tr>
		<tr>
			<td align="right">Gate Pass <font color="red">*</font></td>
			<td><form:input path="gatepass"/></td>
		</tr>
		<tr>
			<td align="right">From<font color="red">*</font></td>
			<td><form:input path="fromwhere"/></td>
		</tr>
		<tr>
			<td align="right">To<font color="red">*</font></td>
			<td><form:input path="towhere"/></td>
		</tr>
		
		<tr>
			<td align="right">Authorized By</td>
			<td><form:input path="authorizedby"/></td>
		</tr>
		<tr>
			<td align="right">Expected Date</td>
			<td><form:input path="edate" cssClass="datepicker"/></td>
		</tr>
		<tr>
			<td align="right">Return Date</td>
			<td><form:input path="rdate" cssClass="datepicker"/></td>
		</tr>
		
		
		
		
		<tr>
			<td align="right"></td>
			<td><input type="submit" value="Update" /></td>
		</tr>
		</tbody>
		<tfoot>
		<tr>
			<td class="rounded-foot-left">&nbsp;</td>
			<td class="rounded-foot-right">${msg}</td>
		</tr>
</tfoot>
	</table>
	


</form:form></div>
</div>
</div>

</body>
<div><%@ include file="footer.jsp"%></div>
</html>