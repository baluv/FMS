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

 <!-- <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2/jquery.min.js"></script>
 <link rel="Stylesheet" media="screen" href="../view/timepicker/ui.dropslide.css" />
      
       <script type="text/javascript" src="../view/timepicker/ui.js"></script>
        <script type="text/javascript" src="../view/timepicker/jquery.utils.js"></script>
       <script type="text/javascript" src="../view/timepicker/jquery.strings.js"></script>
        <script type="text/javascript" src="../view/timepicker/ui.dropslide.js"></script>
        <script type="text/javascript" src="../view/timepicker/ui.timepickr.js"></script>

        <script type="text/javascript">
            $(function(){
                //$('#test-1').timepickr({trigger: '#trigger-test'});
              $('#outtime').timepickr({handle: '#trigger-test1'});
            });
        </script>
		 <script type="text/javascript">
            $(function(){
                //$('#test-1').timepickr({trigger: '#trigger-test'});
              $('#intime').timepickr({handle: '#trigger-test2'});
            });
        </script>
        <script type="text/javascript">
        $(function() {
              $('#date').datepicker({changeMonth: true,
			      changeYear: true, dateFormat: 'dd MM,yy'});
			      });
           </script> -->
</head>
<body>
<div id="container1">
<div id="page1"><!--Header-->
<div
	style="margin-left: 20%; font: normal 14px Verdana; color: #0000FF; margin-right: 15%;">
<c:url var="saveDay2dayVehicleURL"
	value="/complaints/saveDay2dayVehicle.html" /> <form:form
	action="${saveDay2dayVehicleURL}" method="post"
	commandName="day2dayvehicleForm" id="dailyvehicle">
	<table cellpadding="4%" cellspacing="4%" id="rounded-corner">
	<thead>
		<tr>
		<th scope="col" class="rounded-left">&nbsp;</th>
			<th scope="col" class="rounded-right">Fill The Details Of Daily Vehicles</th>
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
			<td><input type="text" id="date" name="date" class="datepicker" /></td>
		</tr>
		<tr>
			<td align="right">Driver Name <font color="red">*</font></td>
			<td><form:input path="drivername" /></td>
		</tr>
		<tr>
			<td align="right">Organization <font color="red">*</font></td>
			<td><form:select path="organization">
				<form:option value="none" label="-------" />
				<form:option value="Maaruti Dental College"
					label="Maaruti Dental College" />
				<form:option value="Maaruti Nursing college"
					label="Maaruti Nursing college" />
				<form:option value="MMPS School" label="MMPS School" />
			</form:select></td>
		</tr>
		<tr>
			<td align="right">Moving To <font color="red">*</font></td>
			<td><form:input path="towhere" /></td>
		</tr>

		<tr>
			<td align="right">Out Reading Km <font color="red">*</font></td>
			<td><form:input path="outkm" /></td>
		</tr>
		<tr>
			<td align="right">In reading Km <font color="red">*</font></td>
			<td><form:input path="inkm" /></td>
		</tr>
		<tr>
			<td align="right">Out time <font color="red">*</font></td>
			<td><input id="outtime" name="outtime" type="text" style="width:80px" />
			<!--  <img src="../view/timepicker/clock.png" alt="Time" border="0" style="position:absolute;margin:4px 0 0 6px;" id="trigger-test1" /> -->
		</td></tr>
		<tr>
			<td align="right">In time <font color="red">*</font></td>
			<td><input id="intime"  name="intime" type="text" style="width:80px"/>
			 <!-- <img src="../view/timepicker/clock.png" alt="Time" border="0" style="position:absolute;margin:4px 0 0 6px;" id="trigger-test2"/></td>-->
		</tr>
		<tr>
		<td align="right">Refilling Fuel</td>
		<td><form:input path="refillingfuel"/></td>
		</tr>
		
		<tr>
			<td align="right">Comments:</td>
			<td><form:textarea path="repair"  cssClass="defaultText" title="Details about any repair or Tollgate charges..etc"/></td>
		</tr>
		<tr>
			<td align="right">Spent Amount <font color="red">*</font></td>
			<td><form:input path="amount" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value=" save " /></td>
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