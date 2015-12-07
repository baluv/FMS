<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

	<title>Facility Management System</title>


<!--Datapicker  -->
 

<link href="../view/main.css" rel="stylesheet" type="text/css" />

<link href="../view/menu.css" rel="stylesheet" type="text/css"/>

<script type="text/javascript" src="../view/js/ga.js">
</script>
<script type="text/javascript" src="../view/js/script.js"></script>
<script src="../view/js/swfobject_modified.js" type="text/javascript"></script>


<style>
a:link {color:#FFFF00;}    /* unvisited link */
a:visited {color:#00FF00;} /* visited link */
a:hover {color:#FF00FF;}   /* mouse over link */
a:active {color:#0000FF;}  /* selected link */
</style>
<style media="screen" type="text/css">
	<!--
		 input, textarea { font-family: 'Courier New'; }
		.tableMain { border: solid 1px #a1a1a1; background-color: #f1f1f1; }
		.defaultText { width: 300px; }
		.defaultTextActive { color: #a1a1a1; font-style: normal; }
	//-->
	</style>
	<script language="javascript">
	<!--
	$(document).ready(function()
	{
		$(".defaultText").focus(function(srcc)
		{
			if ($(this).val() == $(this)[0].title)
			{
				$(this).removeClass("defaultTextActive");
				$(this).val("");
			}
		});
		
		$(".defaultText").blur(function()
		{
			if ($(this).val() == "")
			{
				$(this).addClass("defaultTextActive");
				$(this).val($(this)[0].title);
			}
		});
		
		$(".defaultText").blur();		
	});
	//-->
	</script>




</head>

<!--Header-->
<body>
<div class="header"><span class="logo"><a href="ahome.html"><img
	src="../view/images/logo_aecs.png" alt="Logo"></a></span>
	<span class="headerinfo">
             FACILITY MANAGEMENT SYSTEM
                </span>
	 <span
	class="header-link"> Welcome, <strong>${organization}&nbsp;&nbsp;&nbsp;<a href="login.html">Logout</a></strong> </span>

</div>
<!--Header--> <!--Menu-->
<div class="menuarea">
<ul class="menu" id="menu">
	<li><a href="ahome.html">Home</a></li>
	<li><a href="#">Complaints</a>
	<ul
		style="overflow: hidden; display: block; height: 5px; z-index: 69; opacity: 0.05504587155963303;">
		<li class="current"><a href="adminNewComplaint.html?organization=${organization}">New Complaint</a></li>
		<li class="current"><a href="allComplaintList.html">Complaint List</a></li>
		
	<li class="current"><a href="#" class="arrow">Reports</a>
		<ul>
		 <li class="current"><a href="dailycomplaintreports.html">Daily Complaint Reports</a></li>
		    <li class="current"><a href="byCategory.html">Complaints By Category</a></li>
			<li class="current"><a href="byOrganization.html">Complaints By Organization</a></li>
			<li class="current"><a href="roomHistoryReport.html">Room History</a></li>
			
		</ul>
	</ul>
	</li>
	<li><a href="#">Payments</a>
	<ul
		style="overflow: hidden; display: block; height: 5px; z-index: 70; opacity: 0.03680981595092025;">
		<li class="current"><a href="allvouchersList.html">Voucher List</a></li>
		<li class="current"><a href="voucherreports.html">Voucher Reports</a></li>
	</ul>
	</li>

	<li><a href="#">Complaints History</a>
	<ul
		style="overflow: hidden; display: block; height: 5px; z-index: 71; opacity: 0.10909090909090909;">
		<li class="current"><a href="closedComplaints.html">Complaints </a></li>
		<li class="current"><a href="searchRoomHistory.html">Room History</a>
	</ul>
	</li>
	<li><a href="#">Vehicles</a>
	<ul
		style="overflow: hidden; display: block; height: 5px; z-index: 72; opacity: 0.04411764705882353;">
		<li class="current"><a href="newVehicle.html">Add New Vehicle</a></li>
		<li class="current"><a href="#" class="arrow">Existing Vehicles</a>
		<ul>
		<li class="current"><a href="existingVehicleDetails.html">Existing Vehicle Details</a></li>
		<li class="current"><a href="existingVehicle.html">Vehicle Service Entry</a></li>
		<li class="current"><a href="VehicleServiceDetails.html">Vehicle Service Details</a></li>
		</ul>
		</li>
	
		<li class="current"><a href="day2dayVehicle.html">Daily
		Vehicle Details Entry</a></li>
		<li class="current"><a href="refillingfuel.html">Fuel Refilling Entry</a></li>
		<li class="current"><a href="" class="arrow">Vehicle Report</a>
		<ul>
		    <li class="current"><a href="dailyVehicleDetailsInfo.html">Daily Vehicle Details Info</a></li>
			<li class="current"><a href="vehicleReport.html">Daily Vehicle Details Report</a></li>
			
		</ul>
		</li>
	</ul>
	</li>
	
	<li><a href="#">Asset Tracking</a>
	  <ul
		style="overflow: hidden; display: block; height: 5px; z-index: 70; opacity: 0.03680981595092025;">
		<li class="current"><a href="#" class="arrow">Rooms</a>
		<ul
		style="overflow: hidden; display: block; height: 5px; z-index: 70; opacity: 0.03680981595092025;">
		<li class="current"><a href="adminnewroom.html">Add New Room</a>
		
		
		</li>
		<li class="current"><a href="existingroomedetails.html?organization=${organization}">Existing Room Details</a>
		
		
		</li>
		</ul>
		
		</li>
		<li class="current"><a href="#" class="arrow">General Assets</a>
		<ul
		style="overflow: hidden; display: block; height: 5px; z-index: 70; opacity: 0.03680981595092025;">
		<li class="current"><a href="adminnewitem.html?organization=${organization}">Add New Item</a>
		</li>
		<li class="current"><a href="adminexistingitems.html?organization=${organization}">Existing Items</a>
		</li>
		</ul>
		
		</li>
		<li class="current"><a href="#" class="arrow">IT Assets</a>
		<ul
		style="overflow: hidden; display: block; height: 5px; z-index: 70; opacity: 0.03680981595092025;">
		<li class="current"><a href="adminnewmachine.html?organization=${organization}">Add New Machine</a>
		</li>
		<li class="current"><a href="existingmachinedetails.html?organization=${organization}">Existing Machine Details</a>
		</li>
		</ul>
		
		</li>
		
	</ul>
	
	</li>
	
	<li><a href="#">Material Movement</a>
	<ul
		style="overflow: hidden; display: block; height: 5px; z-index: 72; opacity: 0.04411764705882353;">
		<li class="current"><a href="inwardreturnable.html">Inward</a>
		</li>
		<li class="current"><a href="outwardreturnable.html">Outward</a>
		
		</li>
<li class="current" ><a href="#" class="arrow">Inward Info</a>
		<ul>
		<li class="current"><a href="inwardreturnableinfo.html?type=Returnable"/>Returnable</a></li>
		<li class="current"><a href="inwardnonreturnableinfo.html?type=Non-Returnable"/>Non-Returnable</a></li>
		
		</ul>
		
		</li>
		
		<li class="current" ><a href="#" class="arrow">OutWard Info</a>
		<ul>
		<li class="current"><a href="outwardreturnableinfo.html?type=Returnable"/>Returnable</a></li>
		<li class="current"><a href="outwardnonreturnableinfo.html?type=Non-Returnable"/>Non-Returnable</a></li>
		
		</ul>
		
		</li>
		
		<li class="current" ><a href="#" class="arrow">Reports</a>
		<ul>
		<li class="current"><a href="inwardreport.html"/>Inward</a></li>
		<li class="current"><a href="outwardreport.html"/>Outward</a></li>
		
		</ul>
		
		</li>
		</ul></li>
		<li><a href="archivepage.html" onclick="return confirm('You are going to control the data backup monthly wise. Are you sure Do You want to go for data backup?')">Archive Control</a></li>
	
	

</ul>
<div class="clearboth"></div>
</div>
<!--Menu--> <!-- work space--> <!-- work space--> <!--footer-bg--> <!-- <div class="footer-bg">
            	<img src="./images/footermenubg.jpg" width="1202" height="7" alt="Footer">
            </div>--> <!--footer-bg-->

<script language="javascript" type="text/javascript">
<!--
swfobject.registerObject("FlashID");
//-->
    </script>

<script language="javascript" type="text/javascript">
	var menu2=new menu2.dd("menu2");
	menu2.init("menu2","menu2hover");
</script>

<script language="javascript" type="text/javascript">
	var menu=new menu.dd("menu");
	menu.init("menu","menuhover");
</script>


</body>

</html>