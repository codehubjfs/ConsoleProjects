<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/CSS/Manager/dashBoard.css">
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
        <nav class="navbar navbar-expand-lg navbar-light" id="navtop" >
            <a class="navbar-brand" href="#">
                <img src="${pageContext.request.contextPath}/assets/Image/Manager/taskmanagement1.jpg" alt="Logo" class="logo-img">
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
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Logout</a>
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
                            <a class="nav-link active" href="${pageContext.request.contextPath}/manager/dashboard">Dashboard</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/manager/team">View Team</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/manager/taskmanage" class="nav-link">Task Management</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/manager/calender" class="nav-link">Calendar</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/manager/assigned" class="nav-link">Assigned Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/manager/pending" class="nav-link">Pending Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/manager/completed" class="nav-link">Completed Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/manager/overlayed" class="nav-link">Over Due Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/manager/personaltask" class="nav-link">Personal Task Management</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/logout" class="nav-link">Logout</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h2">-</h1>
                </div>
                <h1 class="h2">Good Morning, Manager</h1>
                <hr>
                <div class="row metrics">
                    
                    <div class="col-3">
                        <a href="${pageContext.request.contextPath}/manager/assigned" style="list-style: none; text-decoration: none; color: black;">
                            <div class="metric">
                                <div class="icon"><img src="${pageContext.request.contextPath}/assets/Image/Manager/assigned.png" alt="Assigned Task"></div>
                                <div class="value">${Assigned}</div>
                                <div class="label">Total Task Assigned</div>
                            </div>
                        </a>
                    </div>
                    <div class="col-3">
                        <a href="${pageContext.request.contextPath}/manager/completed" style="list-style: none; text-decoration: none; color: black;">
                            <div class="metric">
                                <div class="icon"><img src="${pageContext.request.contextPath}/assets/Image/Manager/completed.png" alt="Completed Task"></div>
                                <div class="value">${Completed}</div>
                                <div class="label">Total Task Completed</div>
                            </div>
                        </a>
                    </div>
                    <div class="col-3">
                        <a href="${pageContext.request.contextPath}/manager/pending" style="list-style: none; text-decoration: none; color: black;">
                            <div class="metric">
                                <div class="icon"><img src="${pageContext.request.contextPath}/assets/Image/Manager/pending.png" alt="Pending Task"></div>
                                <div class="value">${Pending}</div>
                                <div class="label">Total Task Pending</div>
                            </div>
                        </a>
                    </div>
                    <div class="col-3">
                        <a href="${pageContext.request.contextPath}/manager/overlayed" style="list-style: none; text-decoration: none; color: black;">
                            <div class="metric">
                                <div class="icon"><img src="${pageContext.request.contextPath}/assets/Image/Manager/overlayed.png" alt="Overlayed Task"></div>
                                <div class="value">${Overlayed}</div>
                                <div class="label">Total Task Overlayed</div>
                            </div>
                        </a>
                    </div>
                </div>

                

                <div class="row">
                    <div class="col-md-8">
                        <div class="card mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <span>TO DO</span>
                                <button type="button" class="btn btn-link" data-toggle="collapse" data-target="#myWorkCollapse" aria-expanded="false" aria-controls="myWorkCollapse">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-angle-expand" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M0 0h6v2H2v4H0V0zm14 14h-4v2h6V10h-2v4z"/>
                                    </svg>
                                </button>
                            </div>
                            <div id="myWorkCollapse" class="collapse">
                                <div class="card-body">
                                    <div class="table-responsive">
                                                    <table class="table table-hover">
													    <thead>
													        <tr>
													            <th>Task Id</th>
													            <th>Task Name</th>
													            <th>Description</th>
													            <th>End Date</th>
													            <th>Priority</th>
													        </tr>
													    </thead>
													    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
													    <tbody>
													        <c:forEach var="task" items="${personalTasks}">
													            <tr>
													                <td>${task.task_id}</td>
													                <td>${task.task_name}</td>
													                <td>${task.task_desp}</td>
													                <td>${task.end_date}</td>
													                <td>${task.task_priority}</td>
													            </tr>
													        </c:forEach>
													    </tbody>
													</table>
                                                  </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="card mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <span>Agenda</span>
                                <button type="button" class="btn btn-link" data-toggle="collapse" data-target="#agendaCollapse" aria-expanded="false" aria-controls="agendaCollapse">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-angle-expand" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M0 0h6v2H2v4H0V0zm14 14h-4v2h6V10h-2v4z"/>
                                    </svg>
                                </button>
                            </div>
                            <div id="agendaCollapse" class="collapse">
                                <div class="card-body">
                                    <p>Agenda items from your calendars will show here.</p>
                                    <button class="btn btn-primary">Add calendar integrations</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-8">
                        <div class="card mb-4 width:80%">
                            <div class="card-header">
                                Interactive Chart On Task
                            </div>
                            <div class="card-body">
                                <canvas id="myChart" style="width:80%;max-width:1000px;height: 330px;"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
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
                    <form id="editProfileForm" action ="${pageContext.request.contextPath}/manager/editprofile" method="post" novalidate>
                        <div class="form-group">
                            <label for="profilePicture">Profile Picture</label>
                            <img src="${pageContext.request.contextPath}/assets/Image/Manager/profile.png" alt="Profile Picture" class="img-thumbnail" id="profilePicture">
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
                            <input type="tel" class="form-control" id="profilePhone" value="${employeeNumber}" name="phonenumber">
                        </div>
                        <div class="form-group">
                            <label for="profileOccupation">Occupation</label>
                            <input type="text" class="form-control" id="profileOccupation" value="${employeeRole}" disabled>
                        </div>
                        <div class="form-group">
                            <label for="profileCity">City</label>
                            <input type="text" class="form-control" id="profileCity" value="${employeeCity}" name="city">
                        </div>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/assets/JavaScript/Manager/dashBoard.js"></script>
</body>
</html>
