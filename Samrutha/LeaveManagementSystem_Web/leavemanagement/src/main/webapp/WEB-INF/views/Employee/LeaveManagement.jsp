<%@page import="java.time.LocalDate"%>
<%@page import="com.leavemanagement.model.ApplicationStatus"%>
<%@page import="com.leavemanagement.model.Leaves"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.List"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave Management</title> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/EmployeeStyle.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
   <script src="${pageContext.request.contextPath}/asserts/javascript/EmployeeScript.js"></script>
   <style>
   		.card{
   			transition: 0s;
   		}
   		.card:hover {
		    transform: none;
		}
   </style>
</head>
<body>
     <header class="header fixed-top">
        <div class="header-img"><img src="${pageContext.request.contextPath}/asserts/images/image1.png" alt="Logo"></div>
        <a href="${pageContext.request.contextPath}/Profile" style="color: white;text-decoration: none;">
	        <div id="header-profile">
	        <div id="header-content"><p style="padding-top:15px; padding-right:5px"><%=session.getAttribute("username") %></p></div>
	        <div id="icon"><img src="${pageContext.request.contextPath}/asserts/images/image2.svg" alt="Icon" style="margin-top:15px;justify-content:center;height:25px"></div>
	        </div>
        </a>
    </header>
       <div class="row">
        <nav class="col-sm-2 sidebar sidebar-sticky">
                <a class="nav-link" href="${pageContext.request.contextPath}/employee/edashboard">Dashboard</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/employee/eprofile">Profile</a>
                <a class="nav-link active" href="${pageContext.request.contextPath}/employee/eleave">Applied Leaves</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/employee/ehistory">History</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </nav>
        <main class="col-md-12">
        <div class="col-md-10 content">
            <div>
                <h1>Applied Leaves</h1>
            </div>
            <div>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/employee/edashboard">Dashboard</a></li>
                    <li class="breadcrumb-item active" aria-current="page">Applied Leaves</li>
                  </ol>
                </nav>
            </div>
            <hr>
            <div class="row align-items-center justify-content-between">
                <div class="col-md-4 col-lg-3">
                    <form role="search">
                        <!-- <input class="form-control" type="search" placeholder="Search" aria-label="Search">  -->
                    </form>
                </div>
                <div class="col-md-4 col-lg-3 text-end">
                    <button type="button" class="btn btn-primary btn-sm " data-toggle="modal" data-target="#applyLeaveModal" id="ApplyButton">Apply Leave</button>
                </div>
            </div>
            <div class="row pt-3">
			    <div class="col-12">
			        <div class="card">
			            <div class="card-title">
			                <h6>Recently Applied Leaves</h6>
			            </div>
			            <div class="table-responsive">
			                <table class="table table-striped">
			                    <thead>
			                        <tr>
			                            <th scope="col">S.No</th>
			                            <th scope="col">LeaveId</th>
			                            <th scope="col">Leave Type</th>
			                            <th scope="col">Start Date</th>
			                            <th scope="col">End Date</th>
			                            <th scope="col">Leave Reason</th>
			                            <th scope="col">Suggested Employee</th>
			                            <th scope="col">Status</th>
			                            <th scope="col">Action</th>
			                        </tr>
			                    </thead>
			                    <tbody>
								    <% 
								        List<Leaves> leaves = (List<Leaves>) request.getAttribute("leaves");
								        List<Leaves> pendingLeaves = leaves.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.PENDING) && (l.getStartDate().isEqual(LocalDate.now()) || l.getStartDate().isAfter(LocalDate.now()))).collect(Collectors.toList());
								        request.setAttribute("pendingLeaves", pendingLeaves);

								    %>
								
								    <c:choose>
								        <c:when test="${not empty pendingLeaves}">
								            <c:forEach var="leave" items="${pendingLeaves}" varStatus="status">
								                <tr>
								                    <th scope="row">${status.index + 1}</th>
								                    <td>${leave.leaveId}</td>
								                    <td>${leave.leaveType}</td>
								                    <td>${leave.startDate}</td>
								                    <td>${leave.endDate}</td>
								                    <td>${leave.reason}</td>
								                    <td>${leave.assignWork}</td>
								                    <td><span class="badge bg-secondary">Pending</span></td>
								                    <td>
								                        <a href="#" style="color: #040430;" class="editIcon" data-toggle="modal" data-target="#editLeave" onclick="editLeave(this)">
								                            <ion-icon name="create-outline"></ion-icon>
								                        </a>
								                        <a href="#" style="color: #040430;" class="deleteIcon" data-toggle="modal" onclick="deleteLeave(this)" data-target="#deleteModal">
								                            <ion-icon name="trash-outline"></ion-icon>
								                        </a>
								                    </td>
								                </tr>
								            </c:forEach>
								        </c:when>
								        <c:otherwise>
								            <tr>
								                <td colspan="9" style="text-align: center">No leaves found.</td>
								            </tr>
								        </c:otherwise>
								    </c:choose>
								</tbody>

			                </table>
			            </div>
			        </div>
			    </div>
			</div>
			
			<div class="row pt-3">
			    <div class="col-12">
			        <div class="card">
			            <div class="card-title">
			                <h6>Approved Leaves</h6>
			            </div>
			            <div class="table-responsive">
			                <table class="table table-striped">
			                    <thead>
			                        <tr>
			                            <th scope="col">S.No</th>
			                            <th scope="col">LeaveId</th>
			                            <th scope="col">Leave Type</th>
			                            <th scope="col">Start Date</th>
			                            <th scope="col">End Date</th>
			                            <th scope="col">Leave Reason</th>
			                            <th scope="col">Suggested Employee</th>
			                            <th scope="col">Status</th>
			                            
			                        </tr>
			                    </thead>
			                    <tbody>
								    <% 
								        leaves = (List<Leaves>) request.getAttribute("leaves");
								        List<Leaves> approveLeaves = leaves.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.APPROVED) && (l.getStartDate().isEqual(LocalDate.now()) || l.getStartDate().isAfter(LocalDate.now()))).collect(Collectors.toList());
								        request.setAttribute("approveLeaves", approveLeaves);

								    %>
								
								    <c:choose>
								        <c:when test="${not empty approveLeaves}">
								            <c:forEach var="leave" items="${approveLeaves}" varStatus="status">
								                <tr>
								                    <th scope="row">${status.index + 1}</th>
								                    <td>${leave.leaveId}</td>
								                    <td>${leave.leaveType}</td>
								                    <td>${leave.startDate}</td>
								                    <td>${leave.endDate}</td>
								                    <td>${leave.reason}</td>
								                    <td>${leave.assignWork}</td>
								                    <td><span class="badge bg-success">Approved</span></td>
								                    
								                </tr>
								            </c:forEach>
								        </c:when>
								        <c:otherwise>
								            <tr>
								                <td colspan="9" style="text-align: center">No leaves found.</td>
								            </tr>
								        </c:otherwise>
								    </c:choose>
								</tbody>

			                </table>
			            </div>
			        </div>
			    </div>
			</div>
			
			<div class="row pt-3">
			    <div class="col-12">
			        <div class="card">
			            <div class="card-title">
			                <h6>Rejected Leaves</h6>
			            </div>
			            <div class="table-responsive">
			                <table class="table table-striped">
			                    <thead>
			                        <tr>
			                            <th scope="col">S.No</th>
			                            <th scope="col">LeaveId</th>
			                            <th scope="col">Leave Type</th>
			                            <th scope="col">Start Date</th>
			                            <th scope="col">End Date</th>
			                            <th scope="col">Leave Reason</th>
			                            <th scope="col">Suggested Employee</th>
			                            <th scope="col">Status</th>
			                            
			                        </tr>
			                    </thead>
			                    <tbody>
								    <% 
								        leaves = (List<Leaves>) request.getAttribute("leaves");
								        List<Leaves> rejectLeaves = leaves.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.REJECTED) && (l.getStartDate().isEqual(LocalDate.now()) || l.getStartDate().isAfter(LocalDate.now()))).collect(Collectors.toList());
								        request.setAttribute("rejectLeaves", rejectLeaves);

								    %>
								
								    <c:choose>
								        <c:when test="${not empty rejectLeaves}">
								            <c:forEach var="leave" items="${rejectLeaves}" varStatus="status">
								                <tr>
								                    <th scope="row">${status.index + 1}</th>
								                    <td>${leave.leaveId}</td>
								                    <td>${leave.leaveType}</td>
								                    <td>${leave.startDate}</td>
								                    <td>${leave.endDate}</td>
								                    <td>${leave.reason}</td>
								                    <td>${leave.assignWork}</td>
								                    <td><span class="badge bg-danger">Rejected</span></td>
							
								                </tr>
								            </c:forEach>
								        </c:when>
								        <c:otherwise>
								            <tr>
								                <td colspan="9" style="text-align: center">No leaves found.</td>
								            </tr>
								        </c:otherwise>
								    </c:choose>
								</tbody>

			                </table>
			            </div>
			        </div>
			    </div>
			</div>
			
			
			<div class="row pt-3">
			    <div class="col-12">
			        <div class="card">
			            <div class="card-title">
			                <h6>Cancelled Leaves</h6>
			            </div>
			            <div class="table-responsive">
			                <table class="table table-striped">
			                    <thead>
			                        <tr>
			                            <th scope="col">S.No</th>
			                            <th scope="col">LeaveId</th>
			                            <th scope="col">Leave Type</th>
			                            <th scope="col">Start Date</th>
			                            <th scope="col">End Date</th>
			                            <th scope="col">Leave Reason</th>
			                            <th scope="col">Suggested Employee</th>
			                            <th scope="col">Status</th>
			                        </tr>
			                    </thead>
			                    <tbody>
								    <% 
								        leaves = (List<Leaves>) request.getAttribute("leaves");
								        List<Leaves> cancelLeaves = leaves.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.CANCELLED) && (l.getStartDate().isEqual(LocalDate.now()) || l.getStartDate().isAfter(LocalDate.now()))).collect(Collectors.toList());
								        request.setAttribute("cancelLeaves", cancelLeaves);

								    %>
								
								    <c:choose>
								        <c:when test="${not empty cancelLeaves}">
								            <c:forEach var="leave" items="${cancelLeaves}" varStatus="status">
								                <tr>
								                    <th scope="row">${status.index + 1}</th>
								                    <td>${leave.leaveId}</td>
								                    <td>${leave.leaveType}</td>
								                    <td>${leave.startDate}</td>
								                    <td>${leave.endDate}</td>
								                    <td>${leave.reason}</td>
								                    <td>${leave.assignWork}</td>
								                    <td><span class="badge bg-warning">Cancelled</span></td>
								                </tr>
								            </c:forEach>
								        </c:when>
								        <c:otherwise>
								            <tr>
								                <td colspan="9" style="text-align: center">No leaves found.</td>
								            </tr>
								        </c:otherwise>
								    </c:choose>
								</tbody>

			                </table>
			            </div>
			        </div>
			    </div>
			</div>
			
        </div>
        </main>
    </div>
    </div>

    <!-- Bootstrap modal for editing leave -->
    <div class="modal fade" id="editLeave" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 350px;">
            <div class="modal-header d-block" style="text-align: center;">
                <h5 class="modal-title" id="exampleModalLabel">Edit Leave</h5>
            </div>
            <div class="modal-body">
                <form style="width: 30rem;" action="${pageContext.request.contextPath}/leaves/editLeave" method="post">
                    <input type="hidden" name="leaveId" id="leaveId">
                    <div class="form-row">
                        <div class="form-group col-md-8">
                            <label for="userName">UserName</label>
                            <input type="text" class="form-control" id="userName" name="userName" value="<%= session.getAttribute("username") %>" disabled>
                        </div>
                        <div class="form-group col-md-8">
                            <label for="inputType">Leave Type</label>
                            <select id="inputType" name="leaveType" class="form-control">
                                <option disabled>Select Leave Type</option>
                                <option>SICKLEAVE</option>
                                <option>CASUALLEAVE</option>
                                <option>VACATIONLEAVE</option>
                            </select>
                            <span id="leaveTypeFeedback" style="color: red;"></span>
                        </div>
                        <div class="form-group col-md-8">
                            <label for="sdate">Start Date</label>
                            <input type="date" class="form-control" id="sdate" name="startDate">
                        </div>
                        <div class="form-group col-md-8">
                            <label for="edate">End Date</label>
                            <input type="date" class="form-control" id="edate" name="endDate">
                        </div>
                        <div class="form-group col-md-8">
                            <label for="inputReason">Reason</label>
                            <textarea cols="25" rows="3" id="inputReason" name="reason" class="form-control"></textarea>
                        </div>
                        <div class="form-group col-md-8">
                            <label for="inputEmp">Suggestion to Assign work</label>
                            <select id="inputEmp" name="assignWork" class="form-control">
                                <option disabled>Select Employee</option>
                                <option>sam_ms</option>
                                <option>ram_s</option>
                                <option>praveen_kr</option>
                                <option>tharshine_rs</option>
                                
                            </select>
                        </div>
                    </div>
                    <div class="modal-footer" style="width: 300px;">
                        <button type="submit" class="btn btn-primary btn-sm">Update</button>
                        <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

    
    <!-- Bootstrap modal for deleting leave -->
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="exampleModalLabel">Confirm Delete</h5>
	            </div>
	            <div class="modal-body">
	                Are you sure you want to cancel the leave applicationId: <span id="displayleave"></span>
	            </div>
	            <div class="modal-footer">
	                <form action="${pageContext.request.contextPath}/leaves/cancelLeave">
	                	<input type="hidden" id="hiddenLeaveId" name="leaveId">
	                    <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">Close</button>
	                    <button type="submit" class="btn btn-sm btn-danger" id="confitmDelete">Cancel Leave</button>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>





    
    <!-- Apply leave -->
	    <div class="modal fade" id="applyLeaveModal" tabindex="-1" role="dialog" aria-labelledby="applyLeaveModalLabel" aria-hidden="true">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="applyLeaveModalLabel">Apply Leave</h5>
	            </div>
	            <div class="modal-body">
	                <form id="leaveForm" action="${pageContext.request.contextPath}/leaves/applyLeave" method="post" onsubmit="return validateForm()">
	                    <div class="form-group">
	                        <label for="leaveType">Leave Type</label>
	                        <select class="form-control" id="leaveType" name="leavetype">
	                            <option selected disabled>Enter leave type</option>
	                            <option value="SICKLEAVE">Sick Leave</option>
	                            <option value="CASUALLEAVE">Casual Leave</option>
	                            <option value="VACATIONLEAVE">Vacation Leave</option>
	                        </select>
	                        <span id="leaveTypeFeedback" style="color: red;"></span>
	                    </div>
	                    <div class="form-group">
	                        <label for="startDate">Start Date</label>
	                        <input type="date" class="form-control" id="startDate" name="startdate" onchange="validateStartDate()" oninput="clearError('startDateFeedback')">
	                        <span id="startDateFeedback" style="color: red;"></span>
	                    </div>
	                    <div class="form-group">
	                        <label for="endDate">End Date</label>
	                        <input type="date" class="form-control" id="endDate" name="enddate" onchange="validateEndDate()" oninput="clearError('endDateFeedback')">
	                        <span id="endDateFeedback" style="color: red;"></span>
	                    </div>
	                    <div class="form-group">
	                        <label for="count">No.of Days</label>
	                        <input type="Number" class="form-control" id="count" name="count" readonly>
	                        <span id="countFeedback" style="color: red;"></span>
	                    </div>
	                    <div class="form-group">
	                        <label for="leaveReason">Leave Reason</label>
	                        <textarea class="form-control" id="leaveReason" name="leaveReason" rows="3" onchange="validateLeaveReason()"></textarea>
	                        <span id="leaveReasonFeedback" style="color: red;"></span>
	                    </div>
	                    <div class="form-group">
	                        <label for="employeeSuggestion">Suggestion of Employee</label>
	                        <select class="form-control" id="employeeSuggestion" name="suggestEmp">
	                            <option selected disabled>Suggest the employee name to alter work</option>
	                            <option value="sam_ms">sam_ms</option>
	                            <option value="sam_ms">praveen_kr</option>
	                            <option value="sam_ms">ram_s</option>
	                            <option value="tharshine_rs">tharshine_rs</option>
	                        </select>
	                        <span id="employeeSuggestionFeedback" style="color: red;"></span>
	                    </div>
	                    <div class="modal-footer">
	                        <button type="button" class="btn btn-secondary btn-sm" data-dismiss="modal">Close</button>
	                        <button type="submit" class="btn btn-primary btn-sm">Apply</button>
	                    </div>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>

    <!-- Scripts -->
    <script src="${pageContext.request.contextPath}/asserts/javascript/EmployeeScript.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    
    <script>
    window.editLeave = function(anchor) {
        const row = anchor.parentElement.parentElement;
        const cells = row.getElementsByTagName('td');
        //const leaveId = row.querySelector('th').textContent; // Assuming the leave ID is in the first cell (th)
        const leaveId = cells[0].textContent;
        const leaveType = cells[1].textContent;
        const startDate = cells[2].textContent;
        const endDate = cells[3].textContent;
        const reason = cells[4].textContent;
        const assignWork = cells[5].textContent;

        document.getElementById('leaveId').value = leaveId;
        document.getElementById('sdate').value = startDate;
        document.getElementById('edate').value = endDate;
        document.getElementById('inputReason').value = reason;
        document.getElementById('inputEmp').value = assignWork;

        // Set the dropdown value for leave type
        const leaveTypeDropdown = document.getElementById('inputType');
        const options = leaveTypeDropdown.options;
        for (let i = 0; i < options.length; i++) {
            options[i].selected = (options[i].text === leaveType);
        }
    }
    
    window.deleteLeave = function(anchor) {
        const row = anchor.parentElement.parentElement;
        const cells = row.getElementsByTagName('td');
        const leaveId = cells[0].textContent.trim(); // Assuming the leaveId is in the first cell (td)
        
        document.getElementById('displayleave').textContent = leaveId;
        document.getElementById('hiddenLeaveId').value = leaveId;
    }
    
    function clearError(elementId) {
        document.getElementById(elementId).textContent = "";
        document.getElementById("formError").textContent = "";
    }
    
    
    
    </script>
    
</body>
</html>