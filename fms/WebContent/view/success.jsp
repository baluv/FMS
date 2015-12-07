<%@ include file="org_default.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Success page</title>


	
<link href="../view/style.css" rel="stylesheet" type="text/css" />
<link href="../view/textbox.css" rel="stylesheet" type="text/css" />

</head>
<body>
<div id="container1">
<div id="page1">
<div style="margin-left: 20%; font: normal 14px Verdana; color: #0000FF">


	<table cellpadding="10%" cellspacing="10%" id="rounded-corner" align="center"><thead><tr>
		
		<th scope="col" ><strong>${msg}</strong></th></tr></thead>
		
	</table>	
   
</div>	
</div>
</div>

</body>
<div ><%@ include file="footer.jsp"%></div>
</html>