<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Ticket</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/warden/viewticket.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    
    <link rel='stylesheet' href='https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css'>
	<script src='https://code.jquery.com/jquery-3.7.0.js'></script>
	<!-- Data Table JS -->
	<script src='https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js' defer></script>
	<script src='https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js' defer></script>
	<script src='https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js' defer></script>
	<!-- Data Table JS -->
    
    <!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!-- Bootstrap JavaScript -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

    <script src="demo.js" defer></script>
    
</head>
<body>
    <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-2 sidebar">
                <div class="logo">
                    <img src="${pageContext.request.contextPath}/asserts/image/warden/ticket-perforated-fill (1).svg" alt="Logo"> 
                    <span>Ticket Raise</span>
                </div>
                <nav>
                    
                    
                    <a href="${pageContext.request.contextPath}/WardenDashBoardController" class="nav-link ">
                        <i class="fas fa-tachometer-alt"></i> Dashboard
                    </a>


                    <button class="dropdown-btn"  data-bs-toggle="collapse" data-bs-target="#ticketdropdown" aria-expanded="false" aria-controls="ticketdropdown">
                       <i class="fas fa-ticket-alt"></i>  Ticket
                        <i class="fa fa-caret-down"></i>
                    </button>

                    <div class="collapse" id="ticketdropdown">
                       <a href="${pageContext.request.contextPath}/WardenServletController">View Ticket</a>
                        <a href="${pageContext.request.contextPath}/ManageTicketController" >Manage Ticket</a>
                    </div>
                    
                    
                    
                    <a href="notification.html" class="nav-link">
                        <i class="fas fa-bed"></i>Rooms
                    </a>
                    <!-- <a href="#" class="nav-link">
                        <i class="fas fa-cogs"></i> Settings
                    </a> -->
                    <!-- <a href="#" class="nav-link">
                        <i class="fas fa-question-circle"></i> Help & Support
                    </a> -->
                    <a href="${pageContext.request.contextPath}/LogoutController" class="nav-link">
                        <i class="fas fa-sign-out-alt"></i> Log Out
                    </a>
                </nav>
            </div>
            <!-- Main Content -->
            <div class="col-10 main-content">
                <div class="row">
                <div class="header">
                <div class="warden-profile">
                <c:forEach items="${ProfileOverview}" var="warden">
                    <h3>Welcome ${warden.name}</h3>
                    
                   </c:forEach> 
                </div>
                    <div class="user-profile">
                        <div class="dropdownprofile">
                            <img src="${pageContext.request.contextPath}/asserts/image/warden/warden.jpg" alt="User Profile" id="profileDropdown" class="dropdown-toggle" aria-haspopup="true" aria-expanded="false">
                            <div class="dropdown-container" id="dropdownContainer">
                                <div class="profile-info">
                                    <img src="${pageContext.request.contextPath}/asserts/image/warden/warden.jpg" alt="User Profile">
                                    <div class="details">
	                                    <c:forEach items="${ProfileOverview}" var="profile" >
	                                    	<h3 id="profileName">${profile.name}</h3>
	                                    	<p id="profileEmail">${profile.mailid}</p>
	                                    	
	                                    	
	                                    </c:forEach>
                                        
                                	</div>
                                </div>
                                <hr>
                                <a href="#" id="editProfileLink">Edit Profile</a>
                                <a href="${pageContext.request.contextPath}/LogoutController">Sign Out</a>
                            </div>
                            <!-- New form for editing profile -->
                            <div id="editProfileForm" style="display: none;">
                                <form id="profileForm">
                                    <div class="form-group">
                                        <label for="name">Name:</label>
                                        <input type="text" class="form-control" id="name" value="Madhavaprasad">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email:</label>
                                        <input type="email" class="form-control" id="email" value="example@example.com">
                                    </div>
                                    <div class="form-group">
                                        <label for="phone">Phone Number:</label>
                                        <input type="text" class="form-control" id="phone" value="8610172466">
                                    </div>
                                    <div class="form-group">
                                        <label for="password">Password:</label>
                                        <input type="password" class="form-control" id="password" value="********">
                                    </div>
                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                </form>
                            </div>

                        </div>
                    <div class="left-profile">
                        <div class="role">Warden</div>
                        <div class="name">
                        <c:forEach items="${ProfileOverview}" var="profile">
	                 		${profile.name}
	                 </c:forEach>
	                 	</div>
                    </div>
                </div>
            </div>
            <div class="row1">
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        
                       
                        <li class="breadcrumb-item "><a href="${pageContext.request.contextPath}/WardenDashBoardController">Dashboard</a></li>
                        
                        <li class="breadcrumb-item active" aria-current="page">Rooms</li>
                       
                    </ol>
                </nav>
            </div>
            <br>
           
            
        <table class="table table-striped table-bordered">
                    <thead class="thead-Dark">
                        
                        <tr>
                            <th scope='col'>S.No</th>
                            <th scope="col">Name</th>
                            <th scope="col">Department</th>
                            <th scope="col">Room No</th>
                            <th scope="col">Block</th>
                            <th scope="col">Phonenumber</th>
                            <th scope="col">Action</th>
                        </tr>
                    </thead>
                    <tbody id="studentTableBody">
                        <c:forEach items="${studentdetails}" var="student" varStatus="status">
                      		<tr data-item-id="${student.mailid}">
                      			<td>${status.count}</td>
                      			<td class="std-name">${student.name}</td>
                      			<td>${student.department}</td>
                      			<td class="room-no">${student.roomno}</td>
                      			<td class="block-no">${student.blockno}</td>
                      			<td>${student.phonenumber}</td>
                      			
                      			<td>
                                <div class="btn-group" role="group" aria-label="Action Buttons">
                                    <button type="button" class="btn btn-outline-primary btn-sm" onclick="editStudent(this)">
                                        <i class="fas fa-edit"></i>
                                    </button>
                                   
                                </div>
                            </td>
                      		</tr>
                      	</c:forEach>
                       </tbody> 
                </table>
            </div>
        </div>
    </div>
	
	<div class="modal fade" id="editUserModal" tabindex="-1" role="dialog" aria-labelledby="editUserModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="editUserModalLabel">Edit User Info</h5>
         <button type="button" class="btn-close" data-dismiss="modal" aria-label="Close"></button>
      </div>
       <form id="editUserForm" action="${pageContext.request.contextPath}/WardenStudentRoomChangeController" method="get">
      <div class="modal-body">
      
       		<label for="mailid">Mailid:</label>
       		<input type="text" class="form-control"  id="add-modal-disablemail" disabled>
       		
       		<input type="hidden" class="form-control"  id="add-modal-email" name="mailid">
       		
       		 
         
          
          <div class="">
            <label for="roomno">Room No:</label>
             <select name="roomNo" id="add-modal-roomno" class="form-control" required>
                                    <option value="" selected disabled>Room no</option>
                                    <option value="101">101</option>
                                    <option value="102">102</option>
                                    <option value="103">103</option>
                                    <option value="104">104</option>
                                    <option value="105">105</option>
                                    <option value="106">106</option>
                                    <option value="107">107</option>
                                    <option value="108">108</option>
                                    <option value="109">109</option>
                                    <option value="110">110</option>
                                </select>
          </div>
          <div class="">
            <label for="Blockno">Block No:</label>
            <select name="blockno" id="add-modal-blockno" class="form-control" required>
                                    <option value="" selected disabled>select the Block No:</option>
                                    <option value="A">A</option>
                                    <option value="B">B</option>
                                    <option value="C">C</option>
                                    <option value="D">D</option>
                                    <option value="E">E</option>
                                    <option value="F">F</option>
                                </select>
          </div>
         
        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" onclick="submitEditUserForm()">Save changes</button>
      </div>
      </form>
    </div>
  </div>
</div>
    <!-- Footer -->
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" defer></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js" defer></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"  defer></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js" defer></script>
  	<script>
  	
function editStudent(student){
    	
    	let row = student.closest('tr');
    	
    	let roomNo=row.querySelector('.room-no');
    	let blockNo=row.querySelector('.block-no');
    	
    	
    	let editModal = new bootstrap.Modal(document.getElementById('editUserModal'));
    	editModal.show();
    	
    	let roomno=document.getElementById('add-modal-roomno');
    	let blockno=document.getElementById('add-modal-blockno');
    	var mailid=student.closest('tr').getAttribute('data-item-id');
    	
    	let tempMail=document.getElementById('add-modal-disablemail');
    	
    	
    	let editMail=document.getElementById('add-modal-email');
    	
    	
    	tempMail.value=mailid;
    	
    	editMail.value=mailid;
    	
    	console.log(tempMail);
    	console.log(editMail);
    	roomno.value=roomNo.textContent;
    	blockno.value=blockNo.textContent;
			
    }
</script>
  	</script>

    <script>
    $(document).ready(function() {
        $('#myTable').DataTable({
        	"pageLength": 5,
          //disable sorting on last column
          "columnDefs": [
            { "orderable": false, "targets": 4 }
          ],
          language: {
            //customize pagination prev and next buttons: use arrows instead of words
            'paginate': {
              'previous': '<span class="fa fa-chevron-left"></span>',
              'next': '<span class="fa fa-chevron-right"></span>'
            },
            //customize number of elements to be displayed
            "lengthMenu": 'Display <select class="form-control input-sm">'+
            '<option value="5">5</option>'+
            '<option value="10">10</option>'+
            '<option value="20">20</option>'+
            '<option value="30">30</option>'+
            '<option value="40">40</option>'+
            '<option value="50">50</option>'+
            '<option value="-1">All</option>'+
            '</select> results'
          }
        })  
    } );
    </script>
    
    <script>
         
        function toggleSidebar() {
            var sidebar = document.getElementById("mySidebar");
            var content = document.querySelector('.content');
            if (sidebar.style.width === "250px") {
                sidebar.style.width = "0";
                content.style.marginLeft = "0";
            } else {
                sidebar.style.width = "250px";
                content.style.marginLeft = "250px";
            }
        }

        var dropdown = document.getElementsByClassName("dropdown-btn");
        var i;

        for (i = 0; i < dropdown.length; i++) {
            dropdown[i].addEventListener("click", function() {
                this.classList.toggle("inactive");
                var dropdownContent = this.nextElementSibling;
                if (dropdownContent.style.display === "block") {
                    dropdownContent.style.display = "none";
                } else {
                    dropdownContent.style.display = "block";
                }
            });
        }

        // WE CAN EDIT THE PROFILE
        document.addEventListener('DOMContentLoaded', function() {
        var profileDropdown = document.getElementById('profileDropdown');
        var dropdownContainer = document.getElementById('dropdownContainer');
    
        profileDropdown.addEventListener('click', function() {
            dropdownContainer.style.display = dropdownContainer.style.display === 'block' ? 'none' : 'block';
        });
    
        // Close the dropdown if the user clicks outside of it
        window.onclick = function(event) {
            if (!event.target.matches('#profileDropdown')) {
                if (dropdownContainer.style.display === 'block') {
                    dropdownContainer.style.display = 'none';
                }
            }
        }
        document.addEventListener('DOMContentLoaded', function() {
            var profileLink = document.getElementById('profileLink');
            profileLink.addEventListener('mouseenter', displayProfile); // Mouse enter
            profileLink.addEventListener('touchstart', displayProfile); // Touch start
        });



        

        var editProfileLink = document.getElementById('editProfileLink');
        editProfileLink.addEventListener('click', function(event) {
        event.preventDefault(); // Prevent default link behavior

            // Hide profile info and show edit profile form
            document.getElementById('profileForm').reset(); // Reset form fields
            document.getElementById('dropdownContainer').style.display = 'none';
            document.getElementById('editProfileForm').style.display = 'block';
            });

        // Add event listener for form submission
            document.getElementById('profileForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent form submission

           
            var newPassword = document.getElementById('password').value;

            
            console.log('New password:', newPassword);

            
            document.getElementById('editProfileForm').style.display = 'none';
            document.getElementById('dropdownContainer').style.display = 'block';
        });


        
    document.getElementById('profileForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form submission

    // Retrieve updated values from form fields
    var newName = document.getElementById('name').value;
    var newEmail = document.getElementById('email').value;
    var newPhone = document.getElementById('phone').value;
    var newPassword = document.getElementById('password').value;

    // Update profile info
    document.getElementById('profileName').innerText = newName;
    document.getElementById('profileEmail').innerText = newEmail;
    document.getElementById('profilePhone').innerText = newPhone;

    // Perform necessary actions (e.g., update profile on server)
    console.log('New name:', newName);
    console.log('New email:', newEmail);
    console.log('New phone:', newPhone);
    console.log('New password:', newPassword);

    // Hide edit profile form and show profile info
    document.getElementById('editProfileForm').style.display = 'none';
    document.getElementById('dropdownContainer').style.display = 'block';
    alert("Updated Successfully")
        });

    }); 

    
    

    </script>
    
    
</body>
</html>