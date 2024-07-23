<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/student/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    
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
                    <img src="${pageContext.request.contextPath}/asserts/image/student/ticket-perforated-fill (1).svg" alt="Logo"> 
                    <span>Ticket Raise</span>
                </div>
                <nav>
                    
                    
                    <a href="#" class="nav-link active">
                        <i class="fas fa-tachometer-alt"></i> Dashboard
                    </a>


                    <button class="dropdown-btn"  data-bs-toggle="collapse" data-bs-target="#ticketdropdown" aria-expanded="false" aria-controls="ticketdropdown">
                       <i class="fas fa-ticket-alt"></i>  Ticket
                        <i class="fa fa-caret-down"></i>
                    </button>

                    <div class="collapse" id="ticketdropdown">
                        <a href="${pageContext.request.contextPath}//tickeraise">Raise a ticket</a>
                        <a href="${pageContext.request.contextPath}//oldissue" >Old ticket</a>
                    </div>
                    
                    
                    
                    <a href="${pageContext.request.contextPath}/views/Student/notification.jsp" class="nav-link">
                        <i class="fas fa-bell"></i> Notifications
                    </a>
                    <!-- <a href="#" class="nav-link">
                        <i class="fas fa-cogs"></i> Settings
                    </a> -->
                    <!-- <a href="#" class="nav-link">
                        <i class="fas fa-question-circle"></i> Help & Support
                    </a> -->
                    <a href="${pageContext.request.contextPath}//logout" class="nav-link">
                        <i class="fas fa-sign-out-alt"></i> Log Out
                    </a>
                </nav>
            </div>
            <!-- Main Content -->
            <div class="col-10 main-content">
                <div class="row" style="margin-left">
                <div class="header">
                    <h3>Welcome 
                     <c:forEach items="${ProfileOverview}" var="profile" >
	                 ${profile.name}
	                 </c:forEach>
                    
                    </h3> 
                    <div class="user-profile">
                        <div class="dropdownprofile">
                            <img src="${pageContext.request.contextPath}/asserts/image/student/student.jpg" alt="User Profile" id="profileDropdown" class="dropdown-toggle" aria-haspopup="true" aria-expanded="false">
                            <div class="dropdown-container" id="dropdownContainer">
                                <div class="profile-info">
                                    <img src="${pageContext.request.contextPath}/asserts/image/student/student.jpg" alt="User Profile">
                                    <div class="details">
	                                    <c:forEach items="${ProfileOverview}" var="profile" >
	                                    	<h3 id="profileName">${profile.name}</h3>
	                                    	<p id="profileEmail">${profile.mailid}</p>
	                                    	<p id="profileNumber">${profile.phonenumber}</p>
	                                    	
	                                    </c:forEach>
                                        
                                	</div>
                                  
                                </div>
                                <hr>
                                <a href="#" id="editProfileLink">Edit Profile</a>
                                <a href="${pageContext.request.contextPath}//logout">Sign Out</a>
                            </div>
                            <!-- New form for editing profile -->
                            <div id="editProfileForm" style="display: none;" >
                                <form id="profileForm" action="${pageContext.request.contextPath}/studenteditprofile" method="get">
                                <c:forEach items="${ProfileOverview}" var="edit" >
                                    <div class="form-group">
	                                    
	                                        <label for="name" name="editname">Name:</label>
	                                        <input type="text" class="form-control" name="editname" id="editname" value="${edit.name}">
	                                </div>
	                                <div class="form-group">
	                                        <label for="email">Email:</label>
	                                        <input type="email" name="editmail" class="form-control" id="editmail" value="${edit.mailid}" disabled>
	                                </div>
	                                <div class="form-group">
	                                        <label for="phone">Phone Number:</label>
	                                        <input type="text" name="editnumber" class="form-control" id="editnumber" value="${edit.phonenumber}">
	                                </div>
	                             </c:forEach> 
                                    <button type="submit" class="btn btn-primary">Save Changes</button>
                                </form>
                            </div>

                        </div>
                    <div class="left-profile">
                        <div class="role">Student</div>
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
                        
                        <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                        
                       
                    </ol>
                </nav>
            </div>
            <div class="row1">
                
				
					
					
				
                <div class="row metrics">
                    <div class="col-3" >
                        <a href="${pageContext.request.contextPath}//supervisor">
                            <div class="metric">
                                <div class="icon">
                                    <img src="${pageContext.request.contextPath}/asserts/image/student/supervisorlogo.jpg" alt="Total Supervisors">
                                </div>
                                <div class="value">
                                    ${supervisorCount}
                                </div>
                                <div class="label">Total Supervisors</div>
                            </div>
                        </a>
                        
                    </div>
                    <div class="col-3" >
                        <a href="	${pageContext.request.contextPath}//warden">
                            <div class="metric" style="padding-bottom:32px;">
                                <div class="icon" >
                                <img src="${pageContext.request.contextPath}/asserts/image/student/images-5.jpg" alt="Total Wardens">
                                </div>
                               <div class="value">
                                    ${wardenCount}
                                </div>
                                <div class="label">Total Wardens</div>
                            </div>
                        </a>
                        
                    </div>
                    <div class="col-3">
                        <a href="${pageContext.request.contextPath}//studentdashboard">
                            <div class="metric" style="padding-bottom:32px;">
                                <div class="icon" >
                                	<img src="${pageContext.request.contextPath}/asserts/image/student/studentlogo.png" alt="Total Students">
                                </div>
                                <div class="value">
                                ${studentCount}
                                </div>
                                <div class="label">Total Students</div>
                            </div>
                        </a>
                        
                    </div>
                    <div class="col-3">
                        <a href="${pageContext.request.contextPath}//TotalIssueController">
                            <div class="metric">
                                <div class="icon"><img src="${pageContext.request.contextPath}/asserts/image/student/resolved.png" alt="Total Issues"></div>
                                <div class="value">
                                	${issueCount}
                                </div>
                                <div class="label">Total Issues</div>
                            </div>
                        </a>
                        
                    </div>
                </div>
                <div class="row">
                    <div class="col-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Open Tickets</h5>
                                <p class="card-text" id="inProgressTicketsCount">
										${issueOpened}
								</p>

                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">In-Progress Tickets</h5>
                                <p class="card-text" id="inProgressTicketsCount">
                                ${issueProgress}
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Resolved Tickets</h5>
                                <p class="card-text" id="resolvedTicketsCount">
                                ${issueCompleted}
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
 
                <!-- Recent Tickets -->
                <div class="card mt-4">
                    <div class="card-body">
                        <h5 class="card-title">Recent Ticket</h5>
                        <table class="table ">
                            <thead>
                                <tr>
                                   <th>S.no</th>
                           			<th>Issue Title</th>
                           			<th>TicketRaiseDate</th>
                           			<th>Raisedby</th>
                           			<th>AllocatedTo</th>
                           
                            		<th>Issue Date</th>
                            		<th>Priority</th>
                            		<th>Status</th>
                                </tr>
                            </thead>
                           
                                
	                       <tbody>         
		                       <c:forEach items="${RecentTickets}" var="ticket" varStatus="status">
		                			<tr>
		                
			                			<td>${status.count}</td>
		                                <td>${ticket.issuetitle}</td>
		                                <td>${ticket.ticketraisedate}</td>
		                                <td>${ticket.raisedby}</td>
		                                <td>${ticket.allocateto}</td>
		                                <td>${ticket.issuedate}</td>
		                                <td>${ticket.priority}</td>
		                                <td>${ticket.status}</td>
		               	 			</tr>
		            			</c:forEach>
	                      </tbody>
                        </table>
                    </div>
                </div>

                
                <div class="row">
                    <div class="col-6">
                            <div class="card mt-4">
                                <!-- Notifications -->
                                <h5 class="card-title">Notifications</h5>
                                    <ul id="notificationsList">
                                        <li>Update on ticket #123</li>
                                        <li>New response to ticket #124</li>
                                       
                                    </ul>
                            </div>
                        </div>
                         <!-- Profile Overview -->
                        <div class="col-6">
                            <div class="card mt-4 profileoverview">
                                <h5 class="card-title">Profile Overview</h5>
                                    <c:forEach items="${ProfileOverview}" var="student">
		                			  <p><strong>Name:</strong> ${student.name}</p>
                                    <p><strong>Mailid:</strong> ${student.mailid}</p>
                                    <p><strong>Phone Number:</strong> ${student.phonenumber}</p>
		            			</c:forEach>
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
	    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"></script>

    
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
	        document.addEventListener('DOMContentLoaded', function () {
		    // Dropdown toggle
		    document.getElementById('profileDropdown').addEventListener('click', function () {
		        var dropdownContainer = document.getElementById('dropdownContainer');
		        dropdownContainer.style.display = dropdownContainer.style.display === 'block' ? 'none' : 'block';
		    });
		
		    // Show edit profile form
		    document.getElementById('editProfileLink').addEventListener('click', function (event) {
		        event.preventDefault();
		        document.getElementById('dropdownContainer').style.display = 'none';
		        document.getElementById('editProfileForm').style.display = 'block';
		    });
		
		    // Handle form submission
		    document.getElementById('profileForm').addEventListener('submit', function (event) {
		        event.preventDefault(); // Prevent default form submission
		
		        // Retrieve updated values from form fields
		        var newName = document.getElementById('editname').value;
		       
		        var newPhone = document.getElementById('editnumber').value;
		
		        // Perform necessary actions (e.g., update profile on server)
		        console.log('New name:', newName);
		       
		        console.log('New phone:', newPhone);
		
		        // Hide edit profile form and show profile info
		        document.getElementById('editProfileForm').style.display = 'none';
		        document.getElementById('dropdownContainer').style.display = 'block';
		        
		        
		
		        // Submit the form programmatically
		        this.submit();
		    });
		});

    
    

    </script>
    
    
</body>
</html>
