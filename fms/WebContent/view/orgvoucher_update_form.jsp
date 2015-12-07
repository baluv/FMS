<%@ include file="org_default.jsp"%>
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
<c:url var="orgupdateComplaintVoucherURL"
	value="/complaints/orgupdateVoucher.html" /> 
	<form:form action="${orgupdateComplaintVoucherURL}" method="post"
	commandName="voucherForm" id="voucherForm">
	<table cellpadding="6%" cellspacing="6%" id="rounded-corner">
<thead>
		<tr>
		<th scope="col" class="rounded-left">&nbsp;</th>
			<th  scope="col" class="rounded-right">Fill Updated Details For Complaint Voucher</th>
		</tr>
		</thead>
	<tbody>
	<tr>
			<td align="right">Complaint Id </td>
			<td>
				<form:input path="complaintId"  value="${cid}" readonly="true" size="10"/>
			</td>
		</tr>
		<tr>
			<td align="right">Voucher Date <font color="red">*</font></td>
			<td><form:input path="voucherDate" cssClass="datepicker" readonly="true"></form:input></td>
		</tr>
		<tr>
			<td align="right">Issued Date <font color="red">*</font></td>
			<td><form:input path="issuedDate" cssClass="datepicker" readonly="true"></form:input></td>
		</tr>
		<tr>
			<td align="right">Cash Mode <font color="red">*</font></td>
			<td><form:input path="cashmode"></form:input></td>
		</tr>
		<tr>
			<td align="right">Amount <font color="red">*</font></td>
			<td><form:input path="amount"></form:input></td>
		</tr>
		
		<tr>
			<td align="right">Towards </td>
			<td><form:textarea path="towards"></form:textarea></td>
		</tr>
		<tr>
			<td align="right">Paid Person </td>
			<td><form:input path="paidPerson"></form:input></td>
		</tr>
		<tr>
			<td align="right">Received Person </td>
			<td><form:input path="receivedPerson"></form:input></td>
		</tr>
		<tr>
			<td align="right">Received Party </td>
			<td><form:input path="receivedParty"></form:input></td>
		</tr>
		<tr>
			<td align="right">Phone Number </td>
			<td><form:input path="phoneNumber"></form:input></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Update" /></td>
		</tr>
</tbody>
<tfoot>
		<tr>
		<td class="rounded-foot-left">&nbsp;</td>
		<td class="rounded-foot-right"><strong>${msg}</strong><strong><a href="voucherInfo.html?cid=${cid}" target="_blank">Generate Voucher </a></strong></td>
		</tr></tfoot>
	</table>
	

</form:form>

</div>

</div>
</div>

</body>

<div><%@ include file="footer.jsp"%></div>
</html>