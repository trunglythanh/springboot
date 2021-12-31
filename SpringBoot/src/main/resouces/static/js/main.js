var data="";
var selectedIndex="";

	$(function(){		
		$("#dialog-confirm" ).dialog({
			  autoOpen:false,
		      resizable: false,
		      height: "auto",
		      width: 400,
		      modal: true,
		      buttons: {
		        "Delete": function() {
		        	delete_(selectedIndex);
		          $(this).dialog("close");
		        },
		        Cancel: function() {
		          $(this).dialog( "close" );
		        }
		     }
		 });
		
		$(function() {
		    $( "#dialog-message" ).dialog({
		      autoOpen: false,
		      modal: true,
		      buttons: {
		        Ok: function() {
		          $( this ).dialog( "close" );
		        }
		      }
		    });
		  });
		
		openAddPopup = function(){
			$("#dialog-form").dialog("open");
		}
		
		openEditPopup = function(i){
			selectedIndex=i;
			
			name2.val(data[selectedIndex].name);
			gender2.val(data[selectedIndex].gender);
			studentNumber2.val(data[selectedIndex].studentNumber);
			
			$("#dialog-edit").dialog("open");
		}
		
		openDeletePopup = function(i) {
			selectedIndex=i;
			openConfirmPopup();
		}
		
		openConfirmPopup = function() {
			$("#dialog-confirm").dialog("open");
		}
		
		openMessagePopup = function() {
			$("#dialog-message").dialog("open");
		}		
		
		//ajax istekleri
		refreshTable = function() {
			$.ajax({
				url: "http://localhost:8081/students",
			    dataType: 'json',
			    success: function(response){
			    	data=response;
			    	$('.tr').remove();
					var no = 1;
					for(i=0; i < data.length; i++){
						$("#contactTable").append('<tr class="tr"> <td>' + no + '</td> <td>' + data[i].name + '</td> <td>' + data[i].gender + '</td> <td>' + data[i].studentNumber + '</td> <td><input type="button" class="contactAddButton" onclick="openEditPopup('+i+')" value="Edit"></input></td> <td> <input type="button" class="contactAddButton" onclick="openDeletePopup('+i+');" value="Delete"></input></td> </tr>');
						no=no+1;
					}			
				}			
			});
		}
		
		delete_ = function(selectedIndex) {
			$.ajax({
				url: "http://localhost:8081/students/"+data[selectedIndex].id,
				type: 'DELETE',
			    success: function(response){
			    	$('.message').html("Success delete");
			    	openMessagePopup();
			    	refreshTable();
			    }
			});
		}
		
		var a="";
		var b="";
		var c="";
		
		add_ = function(a, b, c) {
			console.log("ADD btn");
			$.ajax({
				url: "http://localhost:8081/students",
				type: 'POST',
				contentType: 'application/json',
			    dataType: 'json',
				data:	JSON.stringify( { "name": a, "gender": b, "studentNumber": c  } ),			    
			    success: function(response){
			    	$('.message').html("Success create student");
			    	openMessagePopup();
			    	refreshTable();
			    }
			});
		}
		
		edit_ = function(selectedId, a, b, c) {
			$.ajax({
				url: "http://localhost:8081/students",
				type: 'PUT',
				contentType: 'application/json',
			    dataType: 'json',
				data:	JSON.stringify( { "id" : data[selectedIndex].id ,"name": a, "gender": b, "studentNumber": c  } ),
			    success: function(response){
			    	$('.message').html("Success update student");
			    	openMessagePopup();
			    	refreshTable();
			    }
			});
		}

	    var dialog ="";
	    var form = "";
	    var name = $( "#nameInput" );
	    var gender = $( "#genderInput" );
	    var studentNumber = $( "#studentNumberInput" );
	    var allFields = $( [] ).add( name ).add( gender ).add( studentNumber );
	    var tips = $( ".validateTips" );

	    function updateTips( t ) {
	      tips
	        .text( t )
	        .addClass( "ui-state-highlight" );
	      setTimeout(function() {
	        tips.removeClass( "ui-state-highlight", 1500 );
	      }, 500 );
	    }
	 
	    function checkLength(o, n, min) {
	      if (o.val().length == min) {
	        o.addClass( "ui-state-error" );
	        updateTips( "" + n + " can not be empty.")
	        return false;
	      } else {
	        return true;
	      }
	    }

	    dialog = $( "#dialog-form" ).dialog({
	      autoOpen: false,
	      height: 400,
	      width: 350,
	      modal: true,
	      buttons: {
	        "Save": function() {
				a = name.val();
				b = gender.val();
				c = studentNumber.val();
				var valid = true;
			    allFields.removeClass( "ui-state-error" );
			      
			    valid = valid && checkLength( name, "Name", 0);
			    valid = valid && checkLength( gender, "Last Name", 0);
			    valid = valid && checkLength( studentNumber, "Student Number", 0);
			 
			    if ( valid ) {
			      dialog.dialog( "close");
			      add_(a,b,c);
			    }
			},
	        Cancel: function() {
	          dialog.dialog( "close" );
	        }
	      },
	      close: function() {
	        form[ 0 ].reset();
	        allFields.removeClass( "ui-state-error" );
	      }
	    });
	 
	    form = dialog.find( "form" ).on( "submit", function( event ) {
	      event.preventDefault();
	    });
	    
	    var dialog2 ="";
	    var form2 = "";
	    var name2 = $( "#nameInput2" );
	    var gender2 = $( "#genderInput2" );
	    var studentNumber2 = $( "#studentNumberInput2" );
	    var allFields2 = $( [] ).add( name2 ).add( gender2 ).add( studentNumber2 );
	    var tips2 = $( ".validateTips2" );

	    function updateTips2( t ) {
	      tips
	        .text( t )
	        .addClass( "ui-state-highlight" );
	      setTimeout(function() {
	        tips.removeClass( "ui-state-highlight", 1500 );
	      }, 500 );
	    }
	 
	    function checkLength2(o, n, min) {
	      if (o.val().length == min) {
	        o.addClass( "ui-state-error" );
	        updateTips2( "" + n + " can not be empty.")
	        return false;
	      } else {
	        return true;
	      }
	    }

	    dialog2 = $( "#dialog-edit" ).dialog({
	      autoOpen: false,
	      height: 400,
	      width: 350,
	      modal: true,
	      buttons: {
	        "Save": function() {
				a = name2.val();
				b = gender2.val();
				c = studentNumber2.val();
				var selectedId = data[selectedIndex].id;
				var valid = true;
			    allFields2.removeClass( "ui-state-error" );
			      
			    valid = valid && checkLength2( name2, "First Name", 0);
			    valid = valid && checkLength2( gender2, "Last Name", 0);
			    valid = valid && checkLength2( studentNumber2, "Phone Number", 0);
			 
			    if ( valid ) {
			      dialog2.dialog( "close");
			      edit_(selectedId, a, b, c);
			    }
			},
	        Cancel: function() {
	          dialog2.dialog( "close" );
	        }
	      },
	      close: function() {
	        form2[ 0 ].reset();
	        allFields2.removeClass( "ui-state-error" );
	      }
	    });
	 
	    form2 = dialog2.find( "form" ).on( "submit", function( event ) {
	      event.preventDefault();
	    });
	    
	  });
	
	  jQuery(function($){
		   $("#phoneNumberInput").mask("(999) 999-9999");
	   });
	  
	  jQuery(function($){
		   $("#phoneNumberInput2").mask("(999) 999-9999");
	   });