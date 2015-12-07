<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Facility Management System</title>


<link href="../view/main.css" rel="stylesheet" type="text/css">
<link href="../view/menu.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../view/js/ga.js"></script>
<script type="text/javascript" src="../view/js/script.js"></script>
<script src="../view/js/swfobject_modified.js" type="text/javascript"></script>
<script type="text/javascript" src="../view/jqueryValidations/jquery-1.9.1.min.js"></script>

<style media="screen" type="text/css">
	<!--
		 input, textarea { font-family: 'Trebuchet MS'; }
		.tableMain { border: solid 1px #a1a1a1; background-color: #f1f1f1; }
		.defaultText { width: 300px; }
		.defaultTextActive { color: #a1a1a1; font-style: italic; }
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

<body style="margin-bottom: 0px;"  >
	<div id="container">
    	<div id="page">
        
<!--Header-->
        	<div class="header"> 
            	<span class="logo"><a href="orghome.html"><img src="../view/images/logo_aecs.png" alt="Logo" ></a>
            	
            	</span>
                <span class="headerinfo">
             FACILITY MANAGEMENT SYSTEM
                </span>
                
                 <span class="header-link">
                	
                       Welcome, <strong>${organization}</strong>
                  
                    </span>
             
            </div>
            <!--Header-->
            <!--Menu-->
          <div class="menuarea">
            	<ul class="menu" id="menu">
                    <li><a href="orghome.html">Home</a></li>
                    <li><a href="newComplaint.html?organization=${organization}">New Complaint</a>
                    <ul
		style="overflow: hidden; display: block; height: 5px; z-index: 70; opacity: 0.03680981595092025;">
		<li class="current"><a href="orgcomplaints.html?organization=${organization}">Complaint List</a></li>
		
	</ul></li>
	<li><a href="#">Asset Tracking</a>
	  <ul
		style="overflow: hidden; display: block; height: 5px; z-index: 70; opacity: 0.03680981595092025;">
		<li class="current"><a href="#" class="arrow">Rooms</a>
		<ul
		style="overflow: hidden; display: block; height: 5px; z-index: 70; opacity: 0.03680981595092025;">
		<li class="current"><a href="addnewroom.html">Add New Room</a>
		
		
		</li>
		<li class="current"><a href="existingRoom.html?organization=${organization}">Existing Room Details</a>
		
		
		</li>
		</ul>
		
		</li>
		<li class="current"><a href="#" class="arrow">General Assets</a>
		<ul
		style="overflow: hidden; display: block; height: 5px; z-index: 70; opacity: 0.03680981595092025;">
		<li class="current"><a href="addnewitem.html?organization=${organization}">Add New Asset</a>
		</li>
		<li class="current"><a href="existingRoomsDetails.html?organization=${organization}">Existing Assets</a>
		</li>
		
		
		</ul>
		
		</li>
		<li class="current"><a href="#" class="arrow">IT Assets</a>
		<ul
		style="overflow: hidden; display: block; height: 5px; z-index: 70; opacity: 0.03680981595092025;">
		<li class="current"><a href="addnewmachine.html?organization=${organization}">Add New Machine</a>
		</li>
		<li class="current"><a href="existingMachine.html?organization=${organization}">Existing Machine Details</a>
		</li>
		</ul>
		
		</li>
		
	</ul>
	
	</li>
                    <li><a href="login.html">Logout</a></li>
                   	
                </ul>
                <div class="clearboth"></div>
      </div>
            
      </div>
    </div>
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


</body></html>