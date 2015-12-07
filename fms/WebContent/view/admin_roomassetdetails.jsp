<%@ include file="default.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

</head>
<link href="../view/style.css" rel="stylesheet" type="text/css" />

<body>
	<div id="container1">
		<div id="page1">
			<div
				style="margin-left: 20%; font: normal 14px Verdana; color: #0000FF">
				<table cellpadding="10%" cellspacing="10%" id="rounded-corner">
					<thead>
						<tr>
							<th bgcolor="#E4E6F5" class="rounded-left">Organization:<strong>${organization}</strong> </th>
							<th></th>
							<th></th>
							<th bgcolor="#E4E6F5" class="rounded-right"><strong>${roomNumber}</strong></th>
						</tr>
						<tr>
							<td bgcolor="#E4E6F5" class="rounded-left"><strong>ITEM
									NAME</strong></td>
							<td bgcolor="#E4E6F5"><strong>ITEM COUNT</strong></td>
							<td bgcolor="#E4E6F5"><strong>EDIT</strong></td>
							<td bgcolor="#E4E6F5" class="rounded-right"><strong>DELETE</strong></td>

							<c:forEach items="${assetList}" var="item">
								<tbody>
									<tr>
										<td><c:out value="${item.itemName}"></c:out></td>
										<td><c:out value="${item.itemCount}"></c:out></td>
										<td><a href="admineditroomassetform.html?id=${item.id}&itemName=${item.itemName}&itemCount=${item.itemCount}">Edit</a></td>
										<td><a href="admindeleteroomasset.html?id=${item.id}"  onclick="return confirm('Are you sure you want to delete?')">Delete</a></td>
									</tr>
								</tbody>
							</c:forEach>
					<tfoot>
						<tr>
							<td class="rounded-foot-left">&nbsp;</td>
							<td></td>
							<td></td>
							<td class="rounded-foot-right"></td>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
