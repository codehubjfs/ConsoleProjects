<%@page import="java.util.stream.Collectors"%>
<%@page import="com.lms.bean.ApplicationStatus"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.bean.Leaves"%>
<%@page import="java.time.temporal.ChronoUnit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave Management</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/ManagerStyle.css">
    <style>
	    body{
	    	overflow-x:hidden;
	    }
        .card-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
        }
        .card {
            border: 1px solid #040430;
            border-radius: 20px;
            margin-bottom: 2rem;
            width: 250px; /* Set the width of each card */
            height: 410px;
            display: flex;
            flex-direction: column;
        }
        .thumb-lg {
            height: 50px;
            width: 50px;
        }
        .img-thumbnail {
            justify-content: flex-start;
            background-color: #fff;
            border: 1px solid #dee2e6;
            border-radius: 2px;
            max-width: 100%;
            height: 50px;
        }
        .content-container {
            display: flex;
            padding: 10px;
            margin-top: 0px;
            align-items: left;
            gap: 27px;
        }
        .content-container h4 {
            font-size: 20px;
            font-weight: bolder;
            color: #fff;
        }
        .card-title {
            height: 6rem;
            padding: 10px;
            border-top-left-radius: 20px;
            border-top-right-radius: 20px;
            background-color: #040430;
        }
        .card-title p {
            color: white;
            font-size: 12px;
        }
        #leave-body p {
            padding: 5px;
            font-size: 12px;
        }
        #leave-body h6 {
            border-radius: 0;
        }
        .activity {
            margin-left: 0px;
            padding: 0px;
        }
        .card-body-details p {
            margin-bottom: 2px;
        }
    </style>
</head>
<body>
	<header class="header fixed-top">
        <div class="header-img"><img src="${pageContext.request.contextPath}/asserts/images/image1.png" alt="header image"></div>
        <div id="header-content"><p><%= session.getAttribute("username") %></p></div>
        <div id="icon"><img src="${pageContext.request.contextPath}/asserts/images/image2.svg" alt="icon image"></div>
    </header>
    <div class="row">
        <nav class="col-md-2 sidebar sidebar-sticky">
            <a class="nav-link" href="${pageContext.request.contextPath}/mdashboard">Dashboard</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/mprofile">Profile</a>
            <a class="nav-link active" href="${pageContext.request.contextPath}/requestLeave">Leave Management</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/viewTeams">View Team</a>
            <a class="nav-link" href="${pageContext.request.contextPath}/Calender.jsp">Calendar</a>
            <a class="nav-link" href="index.jsp">Logout</a>
        </nav>
        <div class="col-md-10 content">
            <div>
                <h1>Leave Request</h1>
            </div>
            <div>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/mdashboard">Dashboard</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Leave Management</li>
                  </ol>
                </nav>
            </div>
            <hr>
            <div class="card-container">
                <% 
                    List<Leaves> leave = (List<Leaves>) request.getAttribute("leaves");
                	List<Leaves> pendingLeaves = leave.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.PENDING)).collect(Collectors.toList());
                    if (pendingLeaves != null && !pendingLeaves.isEmpty()) {
                        for (Leaves l : pendingLeaves) { 
                %>
                <div class="card">
                    <div class="card-title">
                        <div class="content-container">
                            <div class="thumb-sm member-thumb ml-2">
                                <img src="${pageContext.request.contextPath}/asserts/images/image2.svg" class="rounded-circle img-thumbnail" alt="profile image">
                            </div>
                            <div>
                                <h4><%= l.getEmp().getUserName() %></h4>
                                <p class="text"><%= l.getEmp().getDept().getDeptName() %></p>
                            </div>
                        </div>
                    </div>
                    <div class="card-body" id="leave-body">
                        <div class="card-body-details d-flex">
                            <p>Leave Type: </p>
                            <p><%= l.getLeaveType() %></p>
                        </div>
                        <div class="card-body-details d-flex">
                            <p>Date: </p>
                            <p><%= l.getStartDate() %> To <%= l.getEndDate() %></p>
                        </div>
                        <div class="card-body-details d-flex">
                            <p>Count: </p>
                            <p><%= ChronoUnit.DAYS.between(l.getStartDate(), l.getEndDate()) + 1 %> days</p>
                        </div>
                        <div class="card-body-details d-flex">
                            <p>Suggestion:</p>
                            <p><%= l.getAssignWork() %></p>
                        </div>
                        <div>
                            <h6>Reason</h6>
                            <input type="hidden" name="leaveId" value="<%= l.getLeaveId() %>">
                            <textarea cols="35" rows="5" style="font-size: 12px; resize: none;" readonly><%= l.getReason() %></textarea>
                        </div>
                        <div class="d-flex justify-content-between" style="padding:13px; padding-top:5px;padding-bottom:5px;">
                        
			                    <button type="button" class="btn btn-success btn-sm mx-1"  data-bs-toggle="modal" data-bs-target="#approveModal" data-leave-type="<%= l.getLeaveType() %>" data-leave-id = "<%= l.getLeaveId() %>" data-user-name = "<%= l.getEmp().getUserName() %>" onclick="openApproveModal()">Approve</button>
								<button type="button" class="btn btn-warning btn-sm mx-1" data-bs-toggle="modal" data-bs-target="#reassignModal" data-leave-type="<%= l.getLeaveType() %>" data-leave-id="<%= l.getLeaveId() %>" data-user-name="<%= l.getEmp().getUserName() %>">Reassign</button>
								<button type="submit" class="btn btn-danger btn-sm mx-1" data-bs-toggle="modal" data-bs-target="#rejectModal" data-leave-id="<%= l.getLeaveId() %>">Reject</button>
						</div>
                    </div>
                </div>
                <% } 
                   }
                   else { %>
                    <p>No Leaves found</p>
                <% } %>
            </div>
        </div>
    </div>

    <div class="modal fade" id="rejectModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 26rem;">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Rejection Reason</h5>
                
            </div>
            <div class="modal-body">
                <form id="rejectForm" action="reject" method="post">
                    <div class="form-group">
                        <label for="rejectionReason">Please enter the reason for rejection</label>
                        <textarea class="form-control" id="rejectionReason" name="rejectionReason" rows="3" placeholder="Enter reason for rejection"></textarea>
                    </div>
                    <input type="hidden" id="leaveId" name="leaveId" value="">
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-sm btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-sm btn-danger" onclick="submitRejection()">Reject</button>
            </div>
        </div>
    </div>
</div>



<!-- approve -->
   <div class="modal fade" id="approveModal" tabindex="-1" aria-labelledby="approveModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 26rem; align-items: center;">
        <div class="modal-content" style="align-items: center; justify-content: center;">
            <div class="modal-header">
                <h5 class="modal-title" id="approveModalLabel">Approve Leave<br>
                    <p class="text-muted" style="text-align: center; font-size: 12px;"><span id="modal-username"></span><br>
                    <span id="modal-leave-type"></span></p>
                </h5>
            </div>
            <div class="modal-body">
                <p id="modal-approve-leave-text">Are you sure you want to approve the leave request?</p>
            </div>
            <div class="modal-footer">
                <form id="approveForm" action="approve">
                    <input type="hidden" name="leaveId" id="hidden-leave-id">
                    <button type="button" class="btn btn-sm btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-sm btn-success">Approve</button>
                </form>
            </div>
        </div>
    </div>
</div>

    
    <!-- Reassign -->
<div class="modal fade" id="reassignModal" tabindex="-1" aria-labelledby="reassignModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 26rem; align-items: center;">
        <div class="modal-content" style="align-items: center; justify-content: center;">
            <div class="modal-header">
                <div>
                    <h5 class="modal-title" id="reassignModalLabel">Reassign Work</h5>
                    <p class="text-muted" style="text-align: center; font-size: 12px;"> 
                        <span id="reassign-username"></span><br>
                        <span id="reassign-leavetype"></span>
                    </p>
                </div>
            </div>
            <div class="modal-body">
                <form id="reassignForm" action="reassign">
                    <input type="hidden" name="leaveId" id="leave-id">
                    <div class="form-group">
                        <label for="employeeSuggestion">Select the employee to reassign the work</label>
                        <select class="form-control" id="employeeSuggestion" name="reassignWork">
                            <option disabled style="font-size: 12px;">Suggest the employee name to alter work</option>
                            <option selected style="font-size: 12px;">sam_ms</option>
                            <option style="font-size: 12px;">tharshine_rs</option>
                            <option style="font-size: 12px;">praveen_kr</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-sm btn-success" onclick="submitReassign()">Approve</button>
            </div>
        </div>
    </div>
</div>




	
 	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="../../asserts/javascript/ManagerScript.js"></script>
    <script>
    
    
    
    function openApproveModal() {
        // Get the button that was clicked
        var button = event.target;

        // Get the leave ID and username from the button's attributes
        var leaveId = button.getAttribute('data-leave-id');
        var username = button.getAttribute('data-user-name');
        var leaveType = button.getAttribute('data-leave-type');

        // Update the modal's content with the new information
        document.getElementById('modal-username').innerText = username;
        document.getElementById('modal-leave-type').innerText = leaveType;
        document.getElementById('modal-approve-leave-text').innerText = 'Are you sure you want to approve the leave request for Leave Id: ' + leaveId + '?';

        // Set the hidden input's value to the leave ID
        document.getElementById('hidden-leave-id').value = leaveId;
    }
    
    

    $(document).ready(function() {
        $('#reassignModal').on('show.bs.modal', function(event) {
            var button = $(event.relatedTarget); // Button that triggered the modal
            var leaveId = button.data('leave-id'); // Extract info from data-* attributes
            var leaveType = button.data('leave-type');
            var username = button.data('user-name');

            console.log('leaveId:', leaveId);
            console.log('leaveType:', leaveType);
            console.log('username:', username);

            var modal = $(this);
            modal.find('#reassign-leavetype').text(leaveType); // Update leave type
            modal.find('#reassign-username').text(username); // Update username
            modal.find('#leave-id').val(leaveId); // Update hidden leave-id input field
        });
    });
    function submitReassign() {
        // Perform validation or any additional logic if needed
        document.getElementById('reassignForm').submit(); // Submit the form
    }
    
    $('#rejectModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget); // Button that triggered the modal
        var leaveId = button.data('leave-id'); // Extract leave ID from data-leave-id attribute
        
        var modal = $(this);
        
        modal.find('.modal-body #leaveId').val(leaveId); // Set the value of the leaveId input field in the modal
    });

    // Function to submit rejection form
    function submitRejection() {
        // Perform validation or any additional logic if needed
        document.getElementById('rejectForm').submit(); // Submit the form
    }
    </script>
</body>
</html>