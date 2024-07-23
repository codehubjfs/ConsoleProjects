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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/student/ticketraise.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css">
    
     <!-- Data Table CSS -->
	<link rel='stylesheet' href='https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css'>
	<script src='https://code.jquery.com/jquery-3.7.0.js'></script>
	<!-- Data Table JS -->
	<script src='https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js'></script>
	<script src='https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js'></script>
	<script src='https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js'></script>
	<!-- Data Table JS -->
</head>
<body>
    

            
            <!-- Main Content -->
            <div class="container-fluid">
        <div class="row">
            <!-- Sidebar -->
            <div class="col-2 sidebar">
                <div class="logo">
                    <img src="${pageContext.request.contextPath}/asserts/image/student/ticket-perforated-fill (1).svg" alt="Logo"> 
                    <span>Ticket Raise</span>
                </div>
                <nav>
                    <a href="studentdashboard" class="nav-link">
                        <i class="fas fa-tachometer-alt"></i> Dashboard
                    </a>
                    <button class="dropdown-btn" data-bs-toggle="collapse" data-bs-target="#ticketdropdown" aria-expanded="false" aria-controls="ticketdropdown">
                        <i class="fas fa-ticket-alt"></i> Ticket
                        <i class="fa fa-caret-down"></i>
                    </button>
                    <div class="collapse" id="ticketdropdown">
                        <a href="#" class="active">Raise a ticket</a>
                        <a href="oldticket">Old ticket</a>
                    </div>
                    <a href="notification" class="nav-link">
                        <i class="fas fa-bell"></i> Notifications
                    </a>
                    <a href="logout" class="nav-link">
                        <i class="fas fa-sign-out-alt"></i> Log Out
                    </a>
                </nav>
            </div>

            <!-- Main Content -->
            <div class="col-10 main-content">
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
                                        <c:forEach items="${ProfileOverview}" var="profile">
                                            <h3>${profile.name}</h3>
                                            <p>${profile.mailid}</p>
                                            <p>${profile.phonenumber}</p>
                                        </c:forEach>
                                    </div>
                                </div>
                                <hr>
                                <a href="#" id="editProfileLink">Edit Profile</a>
                                <a href="logout">Sign Out</a>
                            </div>
                            <!-- New form for editing profile -->
                            <div id="editProfileForm" style="display: none;">
                                <form id="profileForm" action="studenteditprofile" method="get">
                                    <c:forEach items="${ProfileOverview}" var="edit">
                                        <div class="form-group">
                                            <label for="name">Name:</label>
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
                            <li class="breadcrumb-item"><a href="studentdashboard">Dashboard</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Ticket Raise</li>
                        </ol>
                    </nav>
                </div>

                <!-- Raise Ticket Button and Modal -->
                <button id="raiseTicketButton" class="btn btn-dark raisebutton" data-toggle="modal" data-target="#raiseTicketModal">Raise a Ticket</button>
                
                <div class="modal fade" id="raiseTicketModal" tabindex="-1" role="dialog" aria-labelledby="raiseTicketModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="raiseTicketModalLabel">Raise a Ticket</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <form id="ticketForm" action="newticket" method="post">
                                <div class="modal-body">
                                    <div id="alertPlaceholder">
                                        <c:if test="${not empty errors}">
                                            <div class="alert alert-danger">
                                                <ul>
                                                    <c:forEach var="error" items="${errors}">
                                                        <li>${error}</li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </c:if>
                                    </div>
                                    <div class="form-group">
                                        <label for="issueTitle">Issue Title:</label>
                                        <select id="issueTitle" class="form-control" name="issuetitle">
                                            <option value="Food">Food</option>
                                            <option value="Electricity">Electricity</option>
                                            <option value="Cleaning">Cleaning</option>
                                            <option value="Carpenter">Carpenter</option>
                                            <option value="Civil">Civil</option>
                                            <option value="Insect Problem">Insect Problem</option>
                                            <option value="Plumbing">Plumbing</option>
                                            <option value="Hall Seating">Hall Seating</option>
                                        </select>
                                        <div class="invalid-feedback">Please select an issue title.</div>
                                    </div>
                                    <div class="form-group">
                                        <label for="issueDescription">Issue Description:</label>
                                        <textarea id="issueDescription" name="description" class="form-control"></textarea>
                                        <div class="invalid-feedback">Please provide a description.</div>
                                    </div>
                                    <div class="form-group">
                                        <label for="priority">Priority:</label>
                                        <select id="priority" class="form-control" name="priority">
                                            <option value="low">Low</option>
                                            <option value="medium">Medium</option>
                                            <option value="high">High</option>
                                        </select>
                                        <div class="invalid-feedback">Please select a priority.</div>
                                    </div>
                                    <div class="form-group">
                                        <label for="issueDate">Issue Date:</label>
                                        <input type="date" id="issueDate" class="form-control" name="issuedate">
                                        <div class="invalid-feedback">Date cannot be in the future</div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="submit" class="btn btn-primary">Submit</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <br><br>
                <!-- Ticket Table -->
                
                
                
                <div class="table-container">
                    <!-- Add your table here, make sure it's not hidden -->
                    <table class="table table-striped table-bordered">
                        <table class="table table-striped" id="myTable">
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
                             <c:forEach items="${tickets}" var="ticket" varStatus="status">
                					<tr>
                
		                			 	<td>${status.count}</td>
		                                <td>${ticket.issuetitle}</td>
		                                <td>${ticket.ticketraisedate}</td>
		                                <td>${ticket.raisedby}</td>
		                                <td>${ticket.allocatedto}</td>
		                                <td>${ticket.issuedate}</td>
		                                <td>${ticket.priority}</td>
		                                <td>${ticket.status}</td>
               	 					</tr>
            					</c:forEach>
                        </tbody>
                    </table>
                </div>
                    </table>
                </div>
                <div class="ticket-table" id="ticketTable">
                    <h3>Your Tickets</h3>
                    
            </div>
        </div>
    </div>
    <!-- Footer -->

  
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
    
    $(document).ready(function() {
        $('#myTable').DataTable({
            "pageLength": 8,
            // Disable sorting on last column
            "columnDefs": [
                { "orderable": false, "targets": 7 }
            ],
            "dom": '<"top"f>rt<"bottom"lp><"clear">',
            language: {
                // Customize pagination prev and next buttons: use arrows instead of words
                'paginate': {
                    'previous': '<span class="fa fa-chevron-left"></span>',
                    'next': '<span class="fa fa-chevron-right"></span>'
                },
                // Customize number of elements to be displayed
                "lengthMenu": 'Display <select class="form-control input-sm">'+
                '<option value="8">8</option>'+
                '<option value="10">10</option>'+
                '<option value="20">20</option>'+
                '<option value="30">30</option>'+
                '<option value="40">40</option>'+
                '<option value="50">50</option>'+
                '<option value="-1">All</option>'+
                '</select> results'
            }
        });
    });
    </script>
    <script>
    document.addEventListener("DOMContentLoaded", function () {
        // Form validation
        function validateField(field) {
            if (field.value.trim() === "") {
                field.classList.add("is-invalid");
            } else {
                field.classList.remove("is-invalid");
            }
        }

        function validateDate(issuedate) {
            var today = new Date();
            console.log(today);
            var selectedDate = new Date(issuedate.value);
            if (selectedDate > today) {
                issuedate.classList.add("is-invalid");
            } else {
                issuedate.classList.remove("is-invalid");
            }
        }

        // Attach validateField function to oninput event of each input field
        document.getElementById("issueTitle").oninput = function () { validateField(this); };
        document.getElementById("issueDescription").oninput = function () { validateField(this); };
        document.getElementById("priority").oninput = function () { validateField(this); };
        document.getElementById("issueDate").oninput = function () { validateField(this); };
        document.getElementById("issueDate").onchange = function () { validateDate(this); };

        // Form submission
        document.getElementById("ticketForm").addEventListener("submit", function (event) {
            var isValid = true;
            var fields = this.querySelectorAll(".form-control");
            fields.forEach(function (field) {
                validateField(field);
                if (field.classList.contains("is-invalid")) {
                    isValid = false;
                }
            });
            validateDate(document.getElementById("issueDate"));
            if (document.getElementById("issueDate").classList.contains("is-invalid")) {
                isValid = false;
            }
            if (!isValid) {
                event.preventDefault();
            }
        });
    });

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
        var newEmail = document.getElementById('editmail').value;
        var newPhone = document.getElementById('editnumber').value;

        // Perform necessary actions (e.g., update profile on server)
        console.log('New name:', newName);
        console.log('New email:', newEmail);
        console.log('New phone:', newPhone);

        // Hide edit profile form and show profile info
        document.getElementById('editProfileForm').style.display = 'none';
        document.getElementById('dropdownContainer').style.display = 'block';

        // Submit the form programmatically
        this.submit();
    });
});

    </script>
    <script>
    $(document).ready(function(){
        $('[data-toggle="popover"]').popover();
    });
    </script>
</body>
</html>
