<%@ include file="org_default.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>New Complains Form</title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
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

<link href="../view/style.css" rel="stylesheet" type="text/css" />

<link href="../view/textbox.css" rel="stylesheet" type="text/css"/>

 
        
 </head>
<body>
<div id="container1">
<div id="page1">
<div style="margin-left: 20%; font: normal 14px Verdana; color: #0000FF">
<c:url var="saveComplaintURL" value="/complaints/saveComplaint.html" />
<form:form action="${saveComplaintURL}" method="post"
	commandName="complaintsForm" id="newcomplaint">
	<input type="hidden" name="organization" value="${organization}">
	<table cellpadding="10%" cellspacing="10%" id="rounded-corner">
	<thead>
	<tr>
	
	<th scope="col" class="rounded-left">&nbsp;</th>
		<th scope="col" class="rounded-right">Fill The Details For New
		Complaint</th></tr></thead>
		<tbody>
		<tr>
               <td align="right">Category <font color="red">*</font></td>
                <td>
                        <form:select path="category" id="category">
                            <optgroup label="General Complaints">
								<form:option value="none">none</form:option>
                                <form:option value="Electrical" label="Electrical"></form:option>
                                <form:option value="Fabrication" label="Fabrication"></form:option>
                                <form:option value="Dental Chairs" label="Dental Chairs"></form:option>
				                <form:option value="Civil" label="Civil"></form:option>
                                <form:option value="Painting">Painting</form:option>
                                <form:option value="Plumbing">Plumbing</form:option>
                                <form:option value="Carpentry" label="Carpentry"></form:option>
				       <form:option value="Vehicle" label="Vehicle"></form:option>
				<form:option value="General" label="General"></form:option>
                            </optgroup>
                            <optgroup label="IT Complaints">
                                <form:option value="Computer" label="Computer"></form:option>
				<form:option value="Cameras" label="Cameras"></form:option>
				<form:option value="Printer" label="Printer"></form:option>
				<form:option value="Scanner" label="Scanner"></form:option>
				<form:option value="Xerox" label="Xerox"></form:option>
				<form:option value="UPS" label="UPS"></form:option>
				<form:option value="Switches" label="Switches"></form:option>
                            </optgroup>
                        </form:select></td>
                </tr>
		
		<tr><td align="right">Machine Name</td>
		<td><form:input path="machine" id="machine"/></td></tr>
		<tr>
			<td align="right">Room Number</td>
			<td><form:input path="roomNumber"/></td>
		</tr>
		<tr>
			<td align="right">Complaint <font color="red">*</font></td>
			<td><form:textarea path="complaint"/></td>
		</tr>
		
		
		<tr>
			<td align="right">Priority</td>
			<td><form:select path="priority">
				<form:option value="none" label="----------"></form:option>
				<form:option value="Normal" label="Normal" selected="selected" ></form:option>
				<form:option value="High" label="High"></form:option>
			</form:select></td>
		</tr>
		
		<tr>
			<td align="right">Status</td>
			<td><form:select path="status">
				<form:option value="none" label="----------"></form:option>
				<form:option value="Open" label="Open" selected="selected"></form:option>
				<form:option value="Work In Progress" label="Work In Progress"></form:option>
				<form:option value="Closed" label="Closed"></form:option>
			</form:select></td>
		</tr>
		<tr><td align="right">Assigned To</td><td><form:input path="assignedto"/></td></tr>
		<tr>
			<td align="right">Comments</td>
			<td><form:textarea path="comments"></form:textarea></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Submit" /></td>
		</tr></tbody>
		<tfoot>
		<tr>
		<td class="rounded-foot-left">&nbsp;</td>
		<td class="rounded-foot-right"><strong>${successMessage}</strong></td>
		</tr></tfoot>

	</table>
	
<script type="text/javascript">
            $("#category").change(function() {
                var selected = $(":selected", this);
                var optgroupLabel = selected.closest('optgroup').attr('label');
                console.log(optgroupLabel);
                if (optgroupLabel == "General Complaints") {
                    $('#machinename').attr('readonly', true);
                    $("#machinename").addClass('readOnly');
                    
                } else {
                    $('#machinename').attr('readonly', false);
                    $("#machinename").removeClass('readOnly');
                    
                }
            });
        </script>

<script>
$(function() {
var availableMachines = ${machines};	
$( "#machine" ).autocomplete({
source: availableMachines
});
});
</script> 

<script>
$(function() {
var availableRooms = ${rooms};	
$( "#roomNumber" ).autocomplete({
source: availableRooms
});
});
</script>	

</form:form></div>
</div>
</div>

</body>
<div><%@ include file="footer.jsp"%></div>
</html>