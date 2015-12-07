<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Facility Management System</title>


<link href="../view/main.css" rel="stylesheet" type="text/css">
<link href="../view/menu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../view/js/ga.js"></script>
<script type="text/javascript" src="../view/js/script.js"></script>
<script src="../view/js/swfobject_modified.js" type="text/javascript"></script>
<script src="../view/js/jquery.min.js"></script>

<script type="text/javascript"
	src="../view/jqueryValidations/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="../view/jqueryValidations/jquery.validate.js"></script>
<script src="../view/jqueryValidations/formValidation.js"
	type="text/javascript"></script>
	<link href="../view/style.css" rel="stylesheet" type="text/css" />
<link href="../view/textbox.css" rel="stylesheet" type="text/css" />
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
</head>

<body style="margin-bottom: 0px;">
<div id="container">
<div id="page"><!--Header-->
<div class="header"><span class="logo"><a href="#"><img
	src="../view/images/logo_aecs.png" alt="Logo"></a></span>
	<span class="headerinfo">
             FACILITY MANAGEMENT SYSTEM
                </span>
	 <span
	class="header-link"> </span></div>

<div style="margin-left: 25%;  font: normal 14px Verdana; color: #0000FF">
<c:url var="checkLoginURL" value="/complaints/checkLogin.html" /> <form:form
	action="${checkLoginURL}" method="post" commandName="loginForm"
	id="loginform">
<table cellpadding="6%" cellspacing="6%" id="rounded-corner" align="center"><thead><tr>
		<th scope="col" class="rounded-left">&nbsp; </th>
		<th scope="col" class="rounded-right">Enter Credentials For Login</th></tr></thead>
		<tbody>

		<tr>
			<td align="right"><strong>Organization&nbsp;<font color="red">*</font></strong></td>
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

		<tr>
			<td align="right"> <strong>User Id <font color="red">*</font></strong></td>

			<td>
			<div class="form-row"><form:input path="userid" /></div>
			</td>

		</tr>
		<tr>
			<td align="right"><strong>Password <font color="red">*</font></strong></td>
			<td>
			<div class=""><form:password path="password" /></div>
			</td>

		</tr>
		
		</tbody>
		<tfoot>
		<tr>
			<td class="rounded-foot-left">&nbsp;</td>
			<td class="rounded-foot-right"><input type="submit" value="  Login  " />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="changepassword.html" >Change Password</a></td>
		</tr>
</tfoot>
	</table>


</form:form></div>
</div>

</div>

</body>
<div ><%@ include file="footer.jsp"%></div>
</html>
