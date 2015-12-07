jQuery.validator.addMethod( 
	  "selectNone", 
	  function(value, element) { 
	    if (element.value == "none") 
	    { 
	      return false; 
	    } 
	    else return true; 
	  }, 
	  "Please select an option." 
	); 
	 
	 
	$(document).ready(function() {
	$("#loginform").validate({
        rules: {
        organization: {
        "selectNone" : true
        },
         userid: "required",
       password: "required"
      
         
        },
        });
 });
 
 $(document).ready(function() {
	$("#pdfreport").validate({
        rules: {
        organization: {
        "selectNone" : true
        },
        category: {
        "selectNone" : true
        },
        month: {
        "selectNone" : true
        },
        year: {
        "selectNone" : true
        },  
        status: {
        "selectNone" : true
        }
        },
        });
 });
 
 $(document).ready(function() {
	$("#newvehicle").validate({
        rules: {
        vehiclename: "required",
        vehiclenumber: "required",
        vehicletype: "required"
       
         
        },
        });
 });
 
  $(document).ready(function() {
	$("#existingvehicle").validate({
        rules: {
        person: "required",
        servicedate: "required",
        amount: "required",
          vehiclenumber: {
        "selectNone" : true
        }
        
        
        },
        });
 });
 

 $(document).ready(function() {
	$("#dailyvehicle").validate({
	
        rules: {
          vehiclenumber: {
        "selectNone" : true
        },
     	date: "required",
        drivername: "required",
         organization: {
        "selectNone" : true
        },
        towhere: "required",
        purpose: "required",
        outkm: "required",
        inkm: "required",
        intime: "required",
        outtime: "required"
         
        },
        });
 });
 
 $(document).ready(function() {
	$("#newcomplaint").validate({
        rules: {
        complaint: "required",
          category: {
        "selectNone" : true
        },
         priority: {
        "selectNone" : true
        },
        status: {
        "selectNone" : true
        }
       
         
        },
        });
 });
$(document).ready(function() {
	$("#voucherForm").validate({
        rules: {
        voucherDate:"required",
        amount: "required",
        cashmode:"required",
        towards:"required"
               
        },
        });
   });
   
   $(document).ready(function() {
	      $("#AssetForm").validate({
        rules: {
        machinetype: {
        "selectNone" : true
        },
        machine:"required",
       roomNumber: "required"
       
               
        },
        });
     });   
     
     
      $(document).ready(function() {
	      $("#refillingForm").validate({
        rules: {
       vehiclenumber: {
        "selectNone" : true
        },
        organization: {
        "selectNone" : true
        },
       fuel:"required",
       date:"required"
       
        },
        });
     });  
     
     
      $(document).ready(function() {
	      $("#inwardForm").validate({
        rules: {
        type: {
        "selectNone" : true
        },
      date:"required",
      invoicenumber: "required",
        description: "required",
          quantity: "required",
            fromwhere: "required",
            towhere:"required"
       
               
        },
        });
     });   
     
     
      $(document).ready(function() {
	      $("#outwardForm").validate({
        rules: {
        type: {
        "selectNone" : true
        },
      date:"required",
     gatepass: "required",
        description: "required",
          quantity: "required",
            fromwhere: "required",
            towhere:"required"
       
               
        },
        });
     });   
     
     
     $(document).ready(function() {
	$("#MaterialForm").validate({
        rules: {
        type: {
        "selectNone" : true
        },
        fromdate: "required",
        todate:"required"
       
               
        },
        });
   });
     
     