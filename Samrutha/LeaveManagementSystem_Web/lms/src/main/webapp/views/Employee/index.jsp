<%@page import="com.lms.bean.ApplicationStatus"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.lms.bean.Leaves"%>
<%@page import="java.util.List"%>
<%@page import="com.lms.bean.BalanceLeaveBean"%>
<%@page import="com.lms.bean.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/EmployeeStyle.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="${pageContext.request.contextPath}/asserts/javascript/Employee.js"></script>
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
    <div class="container-fluid">
        <div class="row">
            <nav class="col-sm-2 sidebar sidebar-sticky">
                <a class="nav-link active" href="${pageContext.request.contextPath}/Dashboard">Dashboard</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/Profile">Profile</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/Leave">Applied Leaves</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/History">History</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
            </nav>
            <div class="col-sm-10 content">
                <div>
                    <h1>Welcome <%= ((Employee)request.getSession().getAttribute("employee")).getFirstName() %>...!</h1>
                </div>
                <div>
                    <nav aria-label="breadcrumb">
                      <ol class="breadcrumb">
                        <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                      </ol>
                    </nav>
                </div>
                <hr>
                <div class="activity">
                <% BalanceLeaveBean bleave = (BalanceLeaveBean) request.getAttribute("balanceLeave"); %>
                    <div class="row">
                        <div class="col-md-2 col-sm-6" class="cardTrans">
							<div class="card">
							    <div class="card-body">
							      <h6 class="card-title">Sick Leave</h6>
							      <p class="card-text" id="sickleave"><%= 15-bleave.getSickLeave() %>/15</p>
							    </div>
							</div>
							</div>
							<div class="col-md-2 col-sm-6">
							<div class="card">
							    <div class="card-body">
							      <h6 class="card-title">Casual Leave</h6>
							      <p class="card-text" id="casualleave"><%= 15-bleave.getCasualLeave() %>/15</p>
							    </div>
							</div>
							</div>
							<div class="col-md-2 col-sm-6">
							<div class="card">
							    <div class="card-body">
							      <h6 class="card-title">Vacation Leave</h6>
							      <p class="card-text" id="vacationleave"><%= 15-bleave.getVacationLeave() %>/15</p>
							    </div>
							</div>
							</div>
							<div class="col-md-2 col-sm-6">
							<div class="card">
							    <div class="card-body">
							      <h6 class="card-title">Balance Leave</h6>
							      <p class="card-text"><%= bleave.getBalanceLeave() %></p>
							    </div>
							</div>
							</div>
							<div class="col-md-2 col-sm-6">
							<div class="card">
							    <div class="card-body">
							      <h6 class="card-title">Total Leave</h6>
							      <p class="card-text"><%= bleave.getTotlaLeave() %></p>
							    </div>
							</div>
						</div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-8" class="cardTrans">
                        <div class="card">
                            <div class="card-body">
                              <h6 class="card-title">Recently Applied Leaves</h6>
                              <div class="table-responsive">
                                <table class="table table-striped">
			                    <thead>
			                        <tr>
			                            <th scope="col">S.No</th>
			                            <th scope="col">LeaveId</th>
			                            <th scope="col">Leave Type</th>
			                            <th scope="col">Start Date</th>
			                            <th scope="col">Status</th>
			                            <th scope="col">Action</th>
			                        </tr>
			                    </thead>
			                    <tbody>
								    <% 
								        List<Leaves> leaves = (List<Leaves>) request.getAttribute("leaves");
								        List<Leaves> pendingLeaves = leaves.stream().filter((l) -> l.getStatus().equals(ApplicationStatus.PENDING)).collect(Collectors.toList());
								        List<Leaves> limitedLeaves = pendingLeaves.stream().limit(3).collect(Collectors.toList());
								        request.setAttribute("pendingLeaves", limitedLeaves);
								    %>
								
								    <c:choose>
								        <c:when test="${not empty pendingLeaves}">
								            <c:forEach var="leave" items="${pendingLeaves}" varStatus="status">
								                <tr>
								                    <th scope="row">${status.index + 1}</th>
								                    <td>${leave.leaveId}</td>
								                    <td>${leave.leaveType}</td>
								                    <td>${leave.startDate}</td>
								                    <td><span class="badge bg-secondary">Pending</span></td>
								                    <td>
								                        <a href="${pageContext.request.contextPath}/Leave" style="color: #040430;">
								                            <ion-icon name="eye-outline"></ion-icon>
								                        </a>
								                        
								                    </td>
								                </tr>
								            </c:forEach>
								        </c:when>
								        <c:otherwise>
								            <tr>
								                <td colspan="6">No leaves found.</td>
								            </tr>
								        </c:otherwise>
								    </c:choose>
								</tbody>
								
			                </table>
			                <div class="more">
	                            <a href="${pageContext.request.contextPath}/Leave">View More</a>
	                        </div>
                              </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4" class="cardTrans">
                        <div class="card" id="graph">
                            <div class="card-body">
                                <div>
                                    <h3>Balance Leave Analysis</h3>
                                </div>
                                <div>
                                    <canvas id="leaveChart" style="width:100%;max-width:600px; height:190px"></canvas>
                                </div> 
                            </div>
                        </div> 
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/asserts/javascript/EmployeeScript.js"></script>

    <div class="modal fade" id="editLeave" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" style="width: 350px;">
            <div class="modal-header d-block" style="text-align: center;">
                <h5 class="modal-title" id="exampleModalLabel">Edit Leave</h5>
            </div>
            <div class="modal-body">
                <form style="width: 30rem;" action="${pageContext.request.contextPath}/editLeave" method="post">
                    <input type="hidden" name="leaveId" id="leaveId">
                    <div class="form-row">
                        <div class="form-group col-md-8">
                            <label for="userName">UserName</label>
                            <input type="text" class="form-control" id="userName" name="userName" value="<%= session.getAttribute("username") %>" disabled>
                        </div>
                        <div class="form-group col-md-8">
                            <label for="inputType">Leave Type</label>
                            <select id="inputType" name="leaveType" class="form-control" disabled>
                                <option disabled>Select Leave Type</option>
                                <option>Sick Leave</option>
                                <option>Casual Leave</option>
                                <option>Vacations</option>
                                <option>Marriage Leave</option>
                                <option>Paternity Leave</option>
                            </select>
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
	                <form action="${pageContext.request.contextPath}/DeleteLeave" method="post">
	                	<input type="hidden" id="hiddenLeaveId" name="leaveId">
	                    <button type="button" class="btn btn-sm btn-secondary" data-dismiss="modal">Close</button>
	                    <button type="submit" class="btn btn-sm btn-danger" id="confitmDelete">Cancel Leave</button>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>

    
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

    </script>    
</body>
</html>