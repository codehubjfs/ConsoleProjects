<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EmployeeMangement</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/AdminStyle.css"> 
</head>
<body>
<header class="header fixed-top">
        <div class="header-img"><img src="${pageContext.request.contextPath}/asserts/images/image1.png" alt="Logo"></div>
        <a href="${pageContext.request.contextPath}/eprofile" style="color: white;text-decoration: none;">
	        <div id="header-profile">
	        <div id="header-content"><p style="padding-top:15px; padding-right:5px"><%=session.getAttribute("username") %></p></div>
	        <div id="icon"><img src="${pageContext.request.contextPath}/asserts/images/image2.svg" alt="Icon" style="margin-top:15px;justify-content:center;height:25px"></div>
	        </div>
        </a>
    </header>
       <div class="row">
        <nav class="col-sm-2 sidebar sidebar-sticky">
                <a class="nav-link active" href="${pageContext.request.contextPath}/admin/adashboard">Dashboard</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/aprofile">Profile</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/employeeManagement">EmployeeManagement</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
           </nav>
        <div class="col-md-10 content">
            <div>
                <h1>Employee Management</h1>
            </div>
            <div>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/employee/edashboard">Dashboard</a></li>
                    <li class="breadcrumb-item active" aria-current="page">EmployeeManagement</li>
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
                    <button type="button" class="btn btn-primary btn-sm " data-toggle="modal" data-target="#inserEmployee" id="InsertButton">Add Employee</button>
                </div>
            </div> 
		</div>
	</div>
	
	
	<div class="modal fade" id="insertEmployeeModal" tabindex="-1" role="dialog" aria-labelledby="insertEmployeeModalLabel" aria-hidden="true">
	    <div class="modal-dialog" role="document">
	        <div class="modal-content">
	            <div class="modal-header">
	                <h5 class="modal-title" id="insertEmployeeModalLabel">Add Employee</h5>
	            </div>
	            <div class="modal-body">
	                <form id="leaveForm" action="${pageContext.request.contextPath}/admin/addEmployee" method="post" onsubmit="return validateForm()">
	                    <div class="form-group">
	                        <label for="firstName">First Name</label>
	                        <input type = "text" class="form-control" name = "firstName" id = "firstName">
	                        <span id="firstNameFeedback" style="color: red;"></span>
	                    </div>
	                    <div class="form-group">
	                        <label for="lastName">LastName</label>
	                        <input type="text" class="form-control" id="lastName" name="lastName" onchange="validateStartDate()" oninput="clearError('lastNameFeedback')">
	                        <span id="lastNameFeedback" style="color: red;"></span>
	                    </div>
	                    <div class="form-group">
	                        <label for="email">Email</label>
	                        <input type="email" class="form-control" id="email" name="email" onchange="validateStartDate()" oninput="clearError('emailFeedback')">
	                        <span id="emailFeedback" style="color: red;"></span>
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
	                        <button type="submit" class="btn btn-primary btn-sm">Add</button>
	                    </div>
	                </form>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>