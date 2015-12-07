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
	style="margin-left: 20%; font: bold 14px Verdana; color:#0000FF; margin-right: 15%;">
<c:url var="archiveURL"
	value="/complaints/archive.html" /> 
	<form action="${archiveURL}" method="post" id="pdfreport" >
	<table cellpadding="4%" cellspacing="4%" id="rounded-corner" >
	<thead>
	<tr>
	<th scope="col" class="rounded-left">&nbsp;</th>
		<th scope="col" class="rounded-right">Choose Month And Year For Archive And Backup The Complaints Data</th></tr></thead>
		<tbody>
		<tr>
			<td align="right">Month  <font color="red">*</font></td>
			<td ><select name="month">
				<option value="none">----------</option>
				<option value="January" >January</option>
				<option value="February">February</option>
				<option value="March">March</option>
				<option value="April">April</option>
				<option value="May">May</option>
				<option value="June">June</option>
				<option value="July">July</option>
				<option value="August">August</option>
				<option value="September" >September</option>
				<option value="October">October</option>
				<option value="November">November</option>
				<option value="December">December</option>
			</select></td></tr>
			<tr><td align="right">
			
			Year  <font color="red">*</font></td>
			<td>
			<select name="year">
				<option value="none">----------</option>
				<option value="2013" >2013</option>
				<option value="2014">2014</option>
				<option value="2015">2015</option>
				<option value="2016">2016</option>
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
				<option value="2020">2020</option>
				
			</select></td>
		</tr>
		</tbody>
		<tfoot>
		<tr>
		<td class="rounded-foot-left"></td>
		<td class="rounded-foot-right"><input type="submit" value="Submit"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ${msg}</td>
		</tr>
		</tfoot>
	</table>
</form>

</div>
</div>
</div>

</body>
<div>
<%@ include file="footer.jsp"%>
</div>
</html>