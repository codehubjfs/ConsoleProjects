<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Assign</title>
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
                            <a class="dropdown-item" href="../../index.jsp">Logout</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="row">
            <nav class="col-md-2 d-none d-md-block sidebar">
                <div class="sidebar-sticky">
                    <h5 class="sidebar-heading">${employeeName} Dashboard</h5>
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="ManagerDashBoard">Dashboard</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="team.jsp">View Team</a>
                        </li>
                        <li class="nav-item">
                            <a href="taskmanage.jsp" class="nav-link active">Task Management</a>
                        </li>
                        <li class="nav-item">
                            <a href="calender.jsp" class="nav-link">Calendar</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/MAssignedTask" class="nav-link">Assigned Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/MPendingTask" class="nav-link">Pending Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/MCompletedTask" class="nav-link">Completed Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/MOverlayedTask" class="nav-link">Over Due Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/MPersonalTask" class="nav-link">Personal Task Management</a>
                        </li>
                        <li class="nav-item">
                            <a href="../Login/login.html" class="nav-link">Logout</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <div class="container" id="navigation">
                    <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="manager.html">Dashboard</a></li>
                            <li class="breadcrumb-item"><a href="#">Task Management</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Task Assign</li>
                        </ol>
                    <nav>
                </div>
                
                <div><h1>Task Creation</h1></div>
                <hr>
                <div class="page-content page-container" id="page-content">
                    <div class="padding">
                        <div class="row container d-flex justify-content-center">
                            <div class="col-lg-12 grid-margin stretch-card">
                                <div class="card lg-12">
                                    <div class="card-header">Task Management</div>
                                    <div class="card-body">
                                        <h4 class="card-title">Task Creation Table</h4>
                                        <div class="table-responsive">
                                            <table class="table table-striped mt-3" id="taskTable">
											    <thead>
											        <tr>
											            <th>#</th>
											            <th>Task ID</th>
											            <th>Task Name</th>
											            <th>Start Date</th>
											            <th>End Date</th>
											            <th>Actions</th>
											        </tr>
											    </thead>
											    <tbody>
											        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
											        <c:forEach var="task" items="${task}" varStatus="status">
											            <tr>
											                <td>${status.count}</td>
											                <td>${task.task_id}</td>
											                <td>${task.task_name}</td>
											                <td>${task.start_date}</td>
											                <td>${task.end_date}</td>
											                <td>
											                    <a href="#" class="info-task" data-toggle="modal" data-target="#aboutTask" data-description="${task.desp}" data-priority="${task.priority}">
											                        <svg style="padding-left:15px" xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
											                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
											                            <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0"/>
											                        </svg>
											                    </a>
											                    <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal">
											                        <svg style="padding-left:5px" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
											                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
											                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
											                        </svg>
											                    </a>
											                    <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal" data-task-id="${task.task_id}">
											                        <i class="fa fa-trash" style="text-align: center;"></i>
											                    </a>
											                </td>
											            </tr>
											        </c:forEach>
											    </tbody>
											</table>
                                            <button class="btn btn-primary" data-toggle="modal" data-target="#addTaskModal">Add Task</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <hr>
                <div>
                    <h1>Task Assign</h1>
                </div>
                <hr>
                <div class="page-content page-container" id="page-content">
                    <div class="padding">
                        <div class="row container d-flex justify-content-center">
                            <div class="col-lg-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Task Assigned Table</h4>
                                        <p class="card-description">
                                            Task table with employee ID
                                        </p>
                                        <div class="table-responsive">
                                            <table class="table table-striped">
                                                <thead>
                                                    <tr>
                                                        <th>Task ID</th>
                                                        <th>Assigned To Emp_ID</th>
                                                        <th>Due Date</th>
                                                        <th>Status</th>
                                                        <th>Actions</th>
                                                        <th>About Task</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>1</td>
                                                        <td>34424433</td>
                                                        <td>12 May 2017</td>
                                                        <td>Pending</td>
                                                        <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal1"><i class="fa fa-edit"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal1"><i class="fa fa-trash"></i></a>
                                                        </td>
                                                        <td>
                                                            <a href="#" class="info-task" data-toggle="modal" data-target="#aboutTask"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
                                                                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                                                                <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0"/>
                                                              </svg></a>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>2</td>
                                                        <td>53425532</td>
                                                        <td>15 May 2015</td>
                                                        <td>In progress</td>
                                                        <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal1"><i class="fa fa-edit"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal1"><i class="fa fa-trash"></i></a>
                                                        </td>
                                                        <td>
                                                            <a href="#" class="info-task" data-toggle="modal" data-target="#aboutTask"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
                                                                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                                                                <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0"/>
                                                              </svg></a>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>3</td>
                                                        <td>53275533</td>
                                                        <td>14 May 2017</td>
                                                        <td>Fixed</td>
                                                        <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal1"><i class="fa fa-edit"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal1"><i class="fa fa-trash"></i></a>
                                                        </td>
                                                        <td>
                                                            <a href="#" class="info-task" data-toggle="modal" data-target="#aboutTask"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
                                                                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                                                                <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0"/>
                                                              </svg></a>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>4</td>
                                                        <td>53275534</td>
                                                        <td>16 May 2017</td>
                                                        <td>Completed</td>
                                                        <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal1"><i class="fa fa-edit"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal1"><i class="fa fa-trash"></i></a>
                                                        </td>
                                                        <td>
                                                            <a href="#" class="info-task" data-toggle="modal" data-target="#aboutTask"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
                                                                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                                                                <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0"/>
                                                              </svg></a>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>5</td>
                                                        <td>53275535</td>
                                                        <td>20 May 2017</td>
                                                        <td>In progress</td>
                                                        <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal1"><i class="fa fa-edit"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal1"><i class="fa fa-trash"></i></a>
                                                        </td>
                                                        <td>
                                                            <a href="#" class="info-task" data-toggle="modal" data-target="#aboutTask"><svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
                                                                <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
                                                                <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0"/>
                                                              </svg></a>
                                                        </td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                <hr>
                <div class="row">
                    <div class="col-md-12">
                        <div class="card mb-4">
                            <div class="card-header">
                                Task Management
                            </div>
                            <div class="card-body">
                                <form id="taskForm" novalidate>
                                    <div class="form-row">
                                        <div class="form-group col-md-3">
                                            <label for="taskName">Task ID</label>
                                            <input type="text" class="form-control" id="taskName" placeholder="Task Id" required name="taskId">
                                            <div class="invalid-feedback">
                                                Please provide a task Id.
                                            </div>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="assignedTo">Assigned To</label>
                                            <input type="text" class="form-control" id="assignedTo" placeholder="Assigned To" required name="emp_id">
                                            <div class="invalid-feedback">
                                                Please provide an assignee.
                                            </div>
                                        </div>
                                        
                                        <div class="form-group col-md-3">
                                            <label for="status">Status</label>
                                            <select class="form-control" id="status" required name="status">
                                                <option value="assigned">Assigned</option>
                                                <option value="pending">In Progress</option>
                                                <option value="completed">Completed</option>
                                                <option value="overlayed">Overlayed</option>
                                            </select>
                                            <div class="invalid-feedback">
                                                Please select a status.
                                            </div>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary">Add Task</button>
                                </form>
                                
                            </div>
                        </div>
                    </div>
                </div>
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


 <!-- Add Task Modal -->
<div class="modal fade" id="addTaskModal" tabindex="-1" aria-labelledby="addTaskModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="taskForm" novalidate action="TaskCreation" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="addTaskModalLabel">Add Task</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskName">Task Name</label>
                        <input type="text" class="form-control" id="taskName" required name="taskName">
                        <div class="invalid-feedback">Task Name is required</div>
                    </div>
                    <div class="form-group">
                        <label for="taskDescription">Task Description</label>
                        <input type="text" class="form-control" id="taskDescription" required name="desp">
                        <div class="invalid-feedback">Task Description is required</div>
                    </div>
                    <div class="form-group">
                        <label for="taskPriority">Task Priority</label>
                        <select class="form-control" id="taskPriority" required name="priority">
                            <option value="">Select Priority</option>
                            <option value="Low">Low</option>
                            <option value="medium">Medium</option>
                            <option value="high">High</option>
                        </select>
                        <div class="invalid-feedback">Task Priority is required</div>
                    </div>
                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input type="date" class="form-control" id="startDate" required name="startDate">
                        <div class="invalid-feedback">Start Date is required</div>
                    </div>
                    <div class="form-group">
                        <label for="endDate">End Date</label>
                        <input type="date" class="form-control" id="endDate" required name="endDate">
                        <div class="invalid-feedback">End Date is required</div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save Task</button>
                </div>
            </form>
        </div>
    </div>
</div>




<!-- Edit Task Modal -->
<div class="modal fade" id="editTaskModal" tabindex="-1" aria-labelledby="editTaskModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="editTaskForm" novalidate action="EditTask" method="post">
                <div class="modal-header">
                    <h5 class="modal-title" id="editTaskModalLabel">Edit Task</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="editTaskID">Task ID</label>
                        <input type="text" class="form-control" id="editTaskID" readonly name="task_id">
                        <div class="invalid-feedback">Task ID is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editTaskName">Task Name</label>
                        <input type="text" class="form-control" id="editTaskName" required name="taskName">
                        <div class="invalid-feedback">Task Name is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editTaskDescription">Task Description</label>
                        <input type="text" class="form-control" id="editTaskDescription" required name="taskDesp">
                        <div class="invalid-feedback">Task Description is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editStartDate">Start Date</label>
                        <input type="date" class="form-control" id="editStartDate" required name="taskStart">
                        <div class="invalid-feedback">Start Date is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editEndDate">End Date</label>
                        <input type="date" class="form-control" id="editEndDate" required name="taskEnd">
                        <div class="invalid-feedback">End Date is required</div>
                    </div>
                    <div class="form-group">
                        <label for="taskPriority">Task Priority</label>
                        <select class="form-control" id="taskPriority" required name="status">
                            <option value="Low">Low</option>
                            <option value="medium">Medium</option>
                            <option value="high">High</option>
                        </select>
                        <div class="invalid-feedback">Task Priority is required</div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>
            </form>
        </div>
    </div>
</div>


<!-- Delete Task Modal -->
<div class="modal fade" id="deleteTaskModal" tabindex="-1" aria-labelledby="deleteTaskModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteTaskModalLabel">Delete Task</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure you want to delete Task ID: <span id="taskIdDisplay"></span>?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-danger" id="confirmDelete">Delete</button>
            </div>
        </div>
    </div>
</div>

    <!-- Edit Task Modal -->
    <div class="modal fade" id="editTaskModal1" tabindex="-1" role="dialog" aria-labelledby="editTaskModalLabel1" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <form id="editTaskForm" novalidate>
                    <div class="modal-header">
                        <h5 class="modal-title" id="editTaskModalLabel">Edit Task</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" id="editTaskId">
                        <div class="form-group">
                            <label for="editTaskName">Task ID</label>
                            <input type="text" class="form-control" id="editTaskName" required>
                            <div class="invalid-feedback">Please enter a task ID.</div>
                        </div>
                        <div class="form-group">
                            <label for="editAssignedTo">Assigned To</label>
                            <input type="text" class="form-control" id="editAssignedTo" required>
                            <div class="invalid-feedback">Please enter the assignee.</div>
                        </div>
                        <div class="form-group">
                            <label for="editDueDate">Due Date</label>
                            <input type="date" class="form-control" id="editDueDate" required>
                            <div class="invalid-feedback">Please enter a due date.</div>
                        </div>
                        <div class="form-group">
                            <label for="editStatus">Status</label>
                            <select class="form-control" id="editStatus" required>
                                <option value="assigned">Assigned</option>
                                <option value="pending">In Progress</option>
                                <option value="Completed">Completed</option>
                                <option value="overlayed">Over Due</option>
                            </select>
                            <div class="invalid-feedback">Please select a status.</div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Delete Task Confirmation Modal -->
    <div class="modal fade" id="deleteTaskModal1" tabindex="-1" role="dialog" aria-labelledby="deleteTaskModalLabel1" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteTaskModalLabel">Delete Task</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure you want to delete this task?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-danger" id="confirmDeleteButton">Delete</button>
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
                    <form id="editProfileForm" novalidate>
                        <div class="form-group">
                            <label for="profilePicture">Profile Picture</label>
                            <img src="../../asserts/Image/Manager/profile.png" alt="Profile Picture" class="img-thumbnail" id="profilePicture">
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

        // Custom validation for the task form
            	
    	 $('#taskForm').on('submit', function (event) {
    	        // Check if the form is valid
    	        if (this.checkValidity() === false) {
    	            event.preventDefault(); // Prevent default form submission if invalid
    	            event.stopPropagation(); // Stop propagation if invalid
    	        }

    	        // Add Bootstrap validation classes
    	        $(this).addClass('was-validated');
    	    });
        // Handle showing task details
        $('.info-task').on('click', function () {
            var description = $(this).data('description');
            var priority = $(this).data('priority');

            $('#task_desp').text(description);
            $('#task_priority').text(priority);
        });

        // Handle editing task
        $('.edit-task').on('click', function () {
            var row = $(this).closest('tr');
            var taskId = row.find('td:eq(1)').text();
            var taskName = row.find('td:eq(2)').text();
            var startDate = row.find('td:eq(3)').text();
            var endDate = row.find('td:eq(4)').text();
            var taskDescription = row.find('.info-task').data('description');
            var taskPriority = row.find('.info-task').data('priority');

            $('#editTaskID').val(taskId);
            $('#editTaskName').val(taskName);
            $('#editTaskDescription').val(taskDescription);
            $('#editStartDate').val(startDate);
            $('#editEndDate').val(endDate);
            $('#taskPriority').val(taskPriority.toLowerCase()); // Assuming the priority is stored in lower case
        });

        // Handle delete task
        $('.delete-task').on('click', function () {
            var taskId = $(this).data('task-id');
            $('#taskIdDisplay').text(taskId);
            $('#confirmDelete').data('task-id', taskId);
        });

        $('#confirmDelete').on('click', function () {
            var taskId = $(this).data('task-id');
            window.location.href = 'DeleteTask?taskId=' + encodeURIComponent(taskId);
        });

    });


    </script>
</body>
</html>
    