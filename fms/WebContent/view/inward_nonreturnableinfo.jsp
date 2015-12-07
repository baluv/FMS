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
<link href="../view/media/dataTables/demo_page.css" rel="stylesheet"
	type="text/css" />
<link href="../view/media/dataTables/demo_table.css" rel="stylesheet"
	type="text/css" />
<link href="../view/media/dataTables/demo_table_jui.css"
	rel="stylesheet" type="text/css" />
<link href="../view/media/themes/base/jquery-ui.css" rel="stylesheet"
	type="text/css" media="all" />
<link href="../view/media/themes/smoothness/jquery-ui-1.7.2.custom.css"
	rel="stylesheet" type="text/css" media="all" />
<script src="../view/scripts/jquery.js" type="text/javascript"></script>
<script src="../view/scripts/jquery.dataTables.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
        $(document).ready(function () {
            $("#Inwardinfo").dataTable({
                "sPaginationType": "full_numbers",
                "bJQueryUI": true
            });
        });
        </script>

<link href="../view/style.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="container2">
<div id="page2">


	<c:if test="${!empty InwardList}">

		<div id="dt_example">
		<div id="container">
		<div id="demo_jui">
		<table id="Inwardinfo" class="display">
			<thead>
				<tr>
					<th align="left">Id</th>
					<th align="left">Date</th>
					<th align="left">Invoice Number</th>
					<th align="left">From</th>
					<th align="left">To</th>
					<th align="left">Edit</th>
					
					<th align="left">View Quantity</th>
				
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${InwardList}" var="item">
					<tr style="cursor: pointer" onmouseover="this.background='#C0C0C0'"">
						<td><c:out value="${item.id}"></c:out></td>
						<td><c:out value="${item.date}"></c:out></td>
						<td><c:out value="${item.invoicenumber}"></c:out></td>
						<td><c:out value="${item.fromwhere}"></c:out></td>
						<td><c:out value="${item.towhere}"></c:out></td>
						<td><a href="updateinwardnonreturnable.html?id=${item.id}&date=${item.date}&invoicenumber=${item.invoicenumber}&fromwhere=${item.fromwhere}&towhere=${item.towhere}">Edit</a></td>
						
						<td><a href="inwardnonreturnablequantity.html?id=${item.id}">View Quantity</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
		</div>
		</div>
	</c:if>
	</div>
</div>
</body>



</html>