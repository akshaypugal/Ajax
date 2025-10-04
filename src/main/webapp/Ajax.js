$(document).ready(function(){
	fetchStudent();

	$("#launch").click(function(){
		$("#form1")[0].reset();
		$("#sid").val("");
		$("#exampleModalLabel").text("Add Student")
		$("#add").show();
		$("#edit").hide();
		 $('#exampleModal').modal('show');
		console.log("clicked");
	})
	

	$(document).on('click' , '.edit-btn' ,  function(){
					var sid  = $(this).val();
					var obj = "id=" + sid +"&action=getStudent" ; 
					console.log(obj);
				$.ajax({
					url : "studentController" , 
					type : "POST" , 
					data : obj , 
					dataType : "json" , 
					success : function(response){
						$("#sid").val(response.sid);
						$("#sname").val(response.sname);
						$("#scourse").val(response.scourse);
						$("#sfee").val(response.sfee);
						$("#exampleModal").modal('show');
						$("#add").hide();
						$("#edit").show();
						$("#exampleModalLabel").text("Edit Student")
						
						
					} , 
					
					error : function(){
						
						alert("Could not load students data");
					}
				
				})		
					
				})
			
				

    $(document).on('click' , '.delete-btn' ,  function(){
		
		var id = $(this).val();   
		   var obj = "id= " + id + " &action=delete";
		   console.log("Singleton ");
		   console.log(obj + " from ajax");
		if(confirm("Do your want delete the row !!!")) {
			
			$.ajax({
					url : "studentController" , 
					type : "POST" , 
					data : obj , 
					dataType : "json",
					success : function(response){
						  alert(response.message)
						  fetchStudent();
						  
					} , 
					error : function(response){
						  alert(response.message);
					}
				})
			
		}
       
								
	})
	

	
	$(document).on('keyup' , "#ted" , function(){
		  var keyword = $(this).val();
		  console.log("Singleton ");
		  
		  console.log(keyword + " Inside the function");
		
		  var obj = keyword + "&action=search"
		  console.log(obj);
		  $.ajax({
			 url : "studentController",
			 type : "GET",
			 data : obj, 
			 dataType : "JSON",
			 success : function(response){
				var row = "";
				alert("outside each");
				$.each(response , function(index , item){
									
									row+="<tr>" ;
									row+="<td>"+item.sid+"</td>";
									row+="<td>"+item.sname+"</td>";
									row+="<td>"+item.scourse+"</td>";
									row+="<td>"+item.sfee+"</td>";
									row += "<td>";
								    row +='<button type="button" class="edit-btn" value="'+item.sid+'">' +
									       '<i class="fa fa-edit text-primary"></i>' +
									       '</button>';
								    row += '<button type="button" class="delete-btn" value="'+item.sid+'">' +
										          '<i class="fa fa-trash text-danger"></i>' +
										          '</button>';
								    row += "</td>";
									row += "</tr>";
									
								})
								alert("each end")
								$("#tablebody").html(row);
								
								
							},
							error : function(){
								  alter(error)
							}
						 })
	})
								
				
	function fetchStudent(){
		
		 $.ajax({
			url : "studentController",
			type : "GET",
			data : {action : "list"},
			dataType : "json" , 
			success : function(response){
				
				var row = "" ; 
				$.each(response , function(index , item){
					
					row+="<tr>" ;
					row+="<td>"+item.sid+"</td>";
					row+="<td>"+item.sname+"</td>";
					row+="<td>"+item.scourse+"</td>";
					row+="<td>"+item.sfee+"</td>";
					row += "<td>";
				    row +='<button type="button" class="edit-btn" value="'+item.sid+'">' +
					       '<i class="fa fa-edit text-primary"></i>' +
					       '</button>';
				    row += '<button type="button" class="delete-btn" value="'+item.sid+'">' +
						          '<i class="fa fa-trash text-danger"></i>' +
						          '</button>';
				    row += "</td>";
					row += "</tr>";
					
				})
				
				$("#tablebody").html(row);
				
				
			},
			error : function(){
				  alter(error)
			}
		 })
	}
    $("#add").click(function(){
        var obj = $("#form1").serialize() + "&action=add";
        console.log("Sending: ", obj);

        $.ajax({
            url : "studentController", 
            type : "POST", 
            data : obj, 
            dataType : "json", 
            success: function(response){
                console.log("Response:", response);
				$('#exampleModal').modal('hide');
				if(response && response.message){
                    alert(response.message);
					$('#exampleModal').modal('hide');
					fetchStudent();
                } else {
                    alert("No message returned!");
					
                }
               
            }, 
            error: function(response){
                console.error("Error:", response.message);
                alert("Error: " + response.message);
				$('#exampleModal').modal('hide');
            }
        });
    });
	
	
	$("#edit").click(function(){
		var id = $(this).val(); 
		console.log(id);
		 var obj = $("#form1").serialize() + id + "&action=edit";
		 console.log(obj);
		 $.ajax({
			url :"studentController" , 
			type : "POST" , 
			data : obj , 
			dataType : "json",
			success : function(response){
				alert(response.message);
				$('#exampleModal').modal('hide');
				fetchStudent();
			},
			error : function(response){
				alert(response.message)
				$('#exampleModal').modal('hide');
				fetchStudent();
				
			}
		 })
	})
});
