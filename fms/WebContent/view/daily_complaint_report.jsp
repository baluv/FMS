<%@ include file="default.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
<div id="container2">
<div id="page2"><!--Header-->
<div
	style="margin-left:20%; font: bold 14px Verdana; color: #0000FF; margin-right: 15%;">
<c:url var="dailycomplaintsURL"
	value="/complaints/dailycomplaintsreports.html" /> 
	<form action="${dailycomplaintsURL}" method="post" id="pdfreport" target="_blank">
	<table cellpadding="6%" cellspacing="6%" id="rounded-corner">
	<thead>
	<tr>
<th	scope="col" class="rounded-left">&nbsp;</th>
		<th scope="col" class="rounded-right">Choose Following Details To Get Daily Report</th></tr></thead>
	<tbody>
	<tr>
	<td align="right">Organization <font color="red">*</font></td><td>
	
		<select name="organization">
				<option value="none" >----select-----</option>
				<option value="AECS Administrative Office">AECS Administrative Office</option>
				<option value="Maaruti Dental College">Maaruti Dental College</option>
				<option value="Maaruti Dental College Boys Hostel">Maaruti Dental College Boys Hostel</option>
				<option value="Maaruti Dental College Girls Hostel">Maaruti Dental College Girls Hostel</option>
				<option value="Kaleya Nagar Nursing Hostel">Kaleya Nagar Nursing Hostel</option>
				<option value="Maaruti Nursing College Building Boys Hostel">Maaruti Nursing College Building Boys Hostel</option>
				<option value="Maaruti Nursing College Building Girls Hostel">Maaruti Nursing College Building Girls Hostel</option>
				<option value="Maaruti Nursing College">Maaruti Nursing College</option>
				<option value="MMPS School">MMPS School</option></select></td></tr>
		<tr>
			
			<td align="right">Status <font color="red">*</font></td>
			<td><select name="status">
				<option value="none">----------</option>
				<option value="Open" >Open</option>
				<option value="Work In Progress" >Work In Progress</option>
				<option value="Closed">Closed</option>
				
			</select></td></tr>
			<tr><td align="right">Date <font color="red">*</font></td><td><input type="text" name="currentDate" class="datepicker"/></td></tr>
			</tbody>
		<tfoot>
		<tr>
		<td class="rounded-foot-left">&nbsp;</td>
		<td class="rounded-foot-right"><input type="submit" value="Get Report"/></td>
		</tr>
		</tfoot>
	</table>
	


</form></div>
</div>
</div>

</body>
<div><%@ include file="footer.jsp"%>
</html>