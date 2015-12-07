<%@ include file="org_default.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Edit item details</title>

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
<c:url var="editAssetURL" value="/complaints/editsavenewasset.html" />
<form:form action="${editAssetURL}" method="post"
	commandName="newItemForm" id="AssetForm">
	<form:hidden  path="id" ></form:hidden>
	<table cellpadding="10%" cellspacing="10%" id="rounded-corner" align="center"><thead><tr>
		<th scope="col" class="rounded-left">&nbsp; </th>
		<th scope="col" class="rounded-right">Update Item Details</th></tr></thead>
		
		
    <tbody>
		<tr>
			<td align="right">Item Name <font color="red">*</font></td>
			<td><form:input path="itemName" ></form:input></td>
		</tr>
		<tr>
			<td align="right">Item Count <font color="red">*</font></td>
			<td><form:input path="itemCount" ></form:input></td>
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
<div ><%@ include file="footer.jsp"%></div>
</html>