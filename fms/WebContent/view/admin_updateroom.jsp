a<%@ include file="default.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Update The Room Details</title>
<link href="../view/style.css" rel="stylesheet" type="text/css" />
<link href="../view/textbox.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="container1">
<div id="page1">
<div style="margin-left: 25%; font: normal 14px Verdana; color: #0000FF">
<c:url var="adminupdateRoomURL" value="/complaints/adminroomUpdated.html" />
<form:form action="${adminupdateRoomURL}" method="post"
	commandName="updateRoomForm" id="assetForm">
	<input type="hidden" name="organization" value="${organization}">
	<table cellpadding="10%" cellspacing="10%" id="rounded-corner">
	<thead>
	<tr>
	<th bgcolor="#E4E6F5" class="rounded-left">&nbsp;</th>
		<th bgcolor="#E4E6F5" class="rounded-right">Update Room Number</th></tr></thead>
		<tbody>
		<tr><td align="right">Room Id  <font color="red">*</font></td><td><form:input path="generalassetid" readonly="true"/></td></tr>
		<tr>
			<td align="right">Room Number <font color="red">*</font></td>
			<td><form:input path="roomNumber"/></td>
		</tr>
		<tr>
			<td align="right"></td>
			<td><input type="submit" value=" Update " /></td>
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
<div ><%@ include file="footer.jsp"%></div>
</html>