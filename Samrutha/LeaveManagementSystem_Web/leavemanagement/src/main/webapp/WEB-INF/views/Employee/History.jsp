<%@page import="com.leavemanagement.model.Leaves"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>History</title> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/EmployeeStyle.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
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
                <a class="nav-link" href="${pageContext.request.contextPath}/employee/eleave">Applied Leaves</a>
                <a class="nav-link active" href="${pageContext.request.contextPath}/employee/ehistory">History</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
        </nav>
        <div class="col-md-10 content">
            <div>
                <h1>History</h1>
            </div>
            <div>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/employee/edashboard">Dashboard</a></li>
                        <li class="breadcrumb-item active" aria-current="page">History</li>
                    </ol>
                </nav>
            </div>
            <hr>
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
			                            int serialNo = 1;
			                            List<Leaves> leaves = (List<Leaves>) request.getAttribute("approvedleaves");
			                            LocalDate currentDate = LocalDate.now();

			                         
			                         	List<Leaves> filteredLeaves = leaves.stream()
			                                 .filter(leave -> leave.getStartDate().isBefore(currentDate))
			                                 .collect(Collectors.toList());
			                            
			                            if (filteredLeaves != null && !filteredLeaves.isEmpty()) {
			                                for (Leaves leave : filteredLeaves) {
			                        %>
			                        <tr>
			                            <th scope="row"><%= serialNo++ %></th>
			                            <td><%= leave.getLeaveType() %></td>
			                            <td><%= leave.getStartDate() %></td>
			                            <td><%= leave.getEndDate() %></td>
			                            <td><%= leave.getReason() %></td>
			                            <td><%= leave.getAssignWork() %></td>
			                            <td><span class="badge bg-success">Approved</span></td>
			                        </tr>
			                        <%
			                                }
			                            } else {
			                        %>
			                        <tr>
			                            <td colspan="8" style="text-align: center">No leaves found.</td>
			                        </tr>
			                        <%
			                            }
			                        %>
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
			                            int rejNo = 1;
			                            List<Leaves> rejectleaves = (List<Leaves>) request.getAttribute("rejectedleaves");
			                            if (rejectleaves != null && !rejectleaves.isEmpty()) {
			                                for (Leaves leave : rejectleaves) {
			                        %>
			                        <tr>
			                            <th scope="row"><%= rejNo++ %></th>
			                            <td><%= leave.getLeaveType() %></td>
			                            <td><%= leave.getStartDate() %></td>
			                            <td><%= leave.getEndDate() %></td>
			                            <td><%= leave.getReason() %></td>
			                            <td><%= leave.getAssignWork() %></td>
			                            
			                            <td><span class="badge bg-danger">Rejected</span></td>
			                        </tr>
			                        <%
			                                }
			                            } else {
			                        %>
			                        <tr>
			                            <td colspan="8" style="text-align: center">No leaves found.</td>
			                        </tr>
			                        <%
			                            }
			                        %>
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
			                            int cancelNo = 1;
			                            List<Leaves> cancelledLeaves = (List<Leaves>) request.getAttribute("cancelledleaves");
			                            if (cancelledLeaves != null && !cancelledLeaves.isEmpty()) {
			                                for (Leaves leave : cancelledLeaves) {
			                        %>
			                        <tr>
			                            <th scope="row"><%= cancelNo++ %></th>
			                            <td><%= leave.getLeaveType() %></td>
			                            <td><%= leave.getStartDate() %></td>
			                            <td><%= leave.getEndDate() %></td>
			                            <td><%= leave.getReason() %></td>
			                            <td><%= leave.getAssignWork() %></td>
			                            <td><span class="badge bg-warning">Cancelled</span></td>
			                        </tr>
			                        <%
			                                }
			                            } else {
			                        %>
			                        <tr>
			                            <td colspan="8" style="text-align: center">No leaves found.</td>
			                        </tr>
			                        <%
			                            }
			                        %>
			                    </tbody>
			                </table>
			            </div>
			        </div>
			    </div>
			</div>
    </div>
</div>
    <!-- Scripts -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="../../asserts/javascript/EmployeeScript.js"></script>
</body>
</html>