<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Completed Task</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/CSS/Manager/assignedtaskman.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
        body {
            position: relative;
            overflow-x: hidden;
            font-size: 1.125rem;
        }
        .navbar {
            position: fixed;
            width: 100%;
            z-index: 1000;
        }
        .sidebar {
            position: fixed;
            top: 56px; /* Height of the navbar */
            bottom: 0;
            left: 0;
            z-index: 100;
            overflow-y: auto;
            padding-top: 20px;
        }
        .main-content {
            margin-left: 200px; /* Width of the sidebar */
            padding-top: 20px;
            padding-bottom: 20px;
        }
        .sticky-top {
            position: -webkit-sticky;
            position: sticky;
            top: 56px; /* Height of the navbar */
            z-index: 1020;
            background-color: #fff;
        }
        @media (max-width: 768px) {
            .main-content {
                margin-left: 0;
            }
            .sidebar {
                position: static;
            }
        }
    </style>
</head>
<body>
    <div class="container-fluid" style="margin: 0% !important; padding:0% !important">
        <nav class="navbar navbar-expand-lg navbar-light">
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/asserts/Image/Manager/taskmanagement1.jpg" alt="Logo" class="logo-img">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fa fa-user-circle" aria-hidden="true" style="font-size: 25px;"></i>
                        </a>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#editProfileModal">Edit Profile</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/index.jsp">Logout</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="row">
            <nav id="sidebar" class="col-md-2 d-none d-md-block sidebar">
                <div class="sidebar-sticky">
                    <h5 class="sidebar-heading">${employeeName} Dashboard</h5>
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/EmployeeDashBoard">Dashboard</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/views/Manager/team.jsp">View Team</a>
                        </li>
                        <li class="nav-item">
                            <a href="taskmanage.jsp" class="nav-link">Task Management</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/views/Manager/calender.jsp" class="nav-link">Calendar</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/MAssignedTask" class="nav-link">Assigned Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/MPendingTask" class="nav-link">Pending Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/MCompletedTask" class="nav-link active">Completed Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/MOverlayedTask" class="nav-link">Over Due Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/MPersonalTask" class="nav-link">Personal Task Management</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/index.jsp" class="nav-link">Logout</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h2">-</h1>
                </div>
                <div id="navigation">
                    <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/ManagerDashBoard">Dashboard</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Completed Task</li>
                        </ol>
                    <nav>
                </div>
                <h1 class="h2" style="text-align: center;">Completed Task</h1>
                <hr>
                <table class="table table-striped table-bordered">
    <thead class="thead-Dark">
        <tr>
            <th scope="col">Task_id</th>
            <th scope="col">Task Name</th>
            <th scope="col">Started Date</th>
            <th scope="col">Ended Date</th>
            <th scope="col">Status</th>
            <th scope="col">Action</th>
        </tr>
    </thead>
    <tbody>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <c:forEach var="task" items="${completedTasks}">
            <tr>
                <td>${task.task_id}</td>
                <td>${task.task_name}</td>
                <td>${task.start_date}</td>
                <td>${task.end_date}</td>
                <td>${task.status}</td>
                <td>
                    <a href="#" class="info-task" data-toggle="modal" data-target="#aboutTask" 
                       data-description="${task.desp}" data-priority="${task.priority}">
                        <svg style="padding-left:15px" xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                            <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0"/>
                        </svg>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
                <nav aria-label="Page navigation">
                    <ul class="pagination justify-content-center" id="paginationControls">
                        <li class="page-item"><a class="page-link active" href="#" data-page="1">1</a></li>
                        <li class="page-item"><a class="page-link" href="#" data-page="2">2</a></li>
                        <li class="page-item"><a class="page-link" href="#" data-page="3">3</a></li>
                        
                    </ul>
                </nav>
            </main>
        </div>
    </div>
    
          <!-- About Task Modal -->
<div class="modal fade" id="aboutTask" tabindex="-1" role="dialog" aria-labelledby="aboutTaskLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="aboutTaskLabel">Task Details</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p><strong>Description: </strong><span id="task_desp"></span></p>
                <p><strong>Priority: </strong><span id="task_priority"></span></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
   
    <!-- Edit Profile Modal -->
    <div class="modal fade" id="editProfileModal" tabindex="-1" aria-labelledby="editProfileModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editProfileModalLabel">Edit Profile</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="editProfileForm" action ="EditProfile" method="post" novalidate>
                        <div class="form-group">
                            <label for="profilePicture">Profile Picture</label>
                            <img src="${pageContext.request.contextPath}/asserts/Image/Manager/profile.png" alt="Profile Picture" class="img-thumbnail" id="profilePicture">
                        </div>
                        <div class="form-group">
                            <label for="profileName">Name</label>
                            <input type="text" class="form-control" id="profileName" value="${employeeName}" disabled>
                        </div>
                        <div class="form-group">
                            <label for="profileEmail">Email</label>
                            <input type="email" class="form-control" id="profileEmail" value="${employeeMail}" disabled>
                        </div>
                        <div class="form-group">
                            <label for="profilePhone">Phone Number</label>
                            <input type="tel" class="form-control" id="profilePhone" value="${employeeNumber}">
                        </div>
                        <div class="form-group">
                            <label for="profileOccupation">Occupation</label>
                            <input type="text" class="form-control" id="profileOccupation" value="${employeeRole}" disabled>
                        </div>
                        <div class="form-group">
                            <label for="profileCity">City</label>
                            <input type="text" class="form-control" id="profileCity" value="${employeeCity}">
                        </div>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
    $(document).ready(function () {
        $('.edit-task').on('click', function () {
            var row = $(this).closest('tr');
            var taskId = row.find('td:eq(0)').text();
            var taskName = row.find('td:eq(1)').text();
            var startDate = row.find('td:eq(2)').text();
            var endDate = row.find('td:eq(3)').text();
            var status = row.find('td:eq(4)').text();

            $('#taskId').val(taskId);
            $('#taskName').val(taskName);
            $('#startDate').val(startDate);
            $('#endDate').val(endDate);
            $('#status').val(status);
        });

        $('.info-task').on('click', function () {
            var taskDesp = $(this).data('description');
            var taskPriority = $(this).data('priority');

            $('#task_desp').text(taskDesp);
            $('#task_priority').text(taskPriority);
        });
    });

	</script>
</body>
</html>
