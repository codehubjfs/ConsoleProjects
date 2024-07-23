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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/warden/manageticket.css">
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
                        <a href="oldissue.html"  class="nav-link active" >Manage Ticket</a>
                    </div>
                    
                    
                    
                      <a href="${pageContext.request.contextPath}/WardenStudentRoomController" class="nav-link">
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
                        
                        <li class="breadcrumb-item active" aria-current="page">Manage Ticket</li>
                       
                    </ol>
                </nav>
            </div>
            <br>
           
            
            
             <div class="ticket-table">
                       
                        <div class="card animate__animated animate__fadeInUp">
                            <div class="card-body">
                                <h5 class="card-title">Tickets</h5>
                                <table id="ticketsTable" class="table table-hover table-bordered responsive nowrap">
                                    <thead>
                                        <tr>
                                        <th scope="col">S.no</th>
			                            <th scope="col">Title</th>
			                           	<th scope="col">TicketRaisedDate</th>
			                            <th scope="col">MailId</th>
			                            <th scope="col">Allocated</th>
			                            <th scope="col">Priority</th>
			                            <th scope="col">Status</th>
			                            <th scope="col">Action</th>
			                           
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${NewTicket}" var="ticket" varStatus="status">
                                        
                                        <tr data-item-id="${ticket.issueid}" >
		                
			                			<td>${status.count}</td>
		                                <td>${ticket.issuetitle}</td>
		                                <td>${ticket.ticketraisedate}</td>
		                                <td>${ticket.raisedby}</td>
		                                <td>${ticket.allocateto}</td>
		                                 <td>${ticket.priority}</td>
		                                <td>${ticket.status}</td>
		                                <td>
                                                    <button type="button" class="btn btn-outline-primary assign-btn" data-toggle="modal" data-target="#assignModal" onclick="openAssignModal(this)">Assign</button>
                                        </td>
		                                
		               	 			
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <!-- Assign Modal -->
                        <div class="modal fade" id="assignModal" tabindex="-1" role="dialog" aria-labelledby="assignModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="assignModalLabel">Assign Supervisor</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form id="assignForm" action="AssignSupervisorController" method="get">
                                            <div class="form-group">
                                           
                                                <label for="supervisorSelect">Select Supervisor:</label>
                                                <select class="form-control" id="supervisorSelect" name="supervisorId">
                                                    <c:forEach items="${supervisors}" var="supervisor">
                                                        <option value="${supervisor.supervisorid}">${supervisor.name}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                            <input type="hidden" id="ticketIdInput" name="issueId">
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-primary" onclick="assignSupervisor()">Assign</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                       
                        
                   </div>
                </div>
       		</div>
   
  
        </div>
        
    </div>
    <!-- Footer -->
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

  
    
   <script>
   function openAssignModal(ticket){
	   const itemId = ticket.closest('tr').getAttribute('data-item-id');
      	
	   const ticketid=document.getElementById("ticketIdInput");
	   
	   ticketid.value=itemId
	   console.log(ticketid);
       
      
   }   
   
   function assignSupervisor(){
	   document.getElementById('assignForm').submit();
   }
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