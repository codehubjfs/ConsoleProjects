<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Assign</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/CSS/Manager/assignedtaskman.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel='stylesheet' href='https://cdn.datatables.net/1.13.5/css/dataTables.bootstrap5.min.css'>
	<script src='https://code.jquery.com/jquery-3.7.0.js'></script>
	<!-- Data Table JS -->
	<script src='https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js'></script>
	<script src='https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js'></script>
	<script src='https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js'></script>
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
            <nav class="col-md-2 d-none d-md-block sidebar">
                <div class="sidebar-sticky">
                    <h5 class="sidebar-heading">${employeeName} Dashboard</h5>
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/manager/dashboard">Dashboard</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/manager/team">View Team</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/manager/taskmanage" class="nav-link active">Task Management</a>
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
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-5">
                <div class="container" id="navigation">
                    <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="manager.html">Dashboard</a></li>
                            <li class="breadcrumb-item"><a href="#">Task Management</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Task Assign</li>
                        </ol>
                    <nav>
                </div>
                
                <div><h1 style="text-align: center;">Task Creation</h1></div>
                <hr>
                                            <button class="btn btn-primary" data-toggle="modal" data-target="#addTaskModal">Add Task</button><br><br>
					 <table class="table table-striped table-bordered"  id="taskTable">
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
											                    <a href="#" class="info-task" data-toggle="modal" data-target="#aboutTask" data-id="${task.task_id}" data-name="${task.task_name}"  data-description="${task.task_desp}" data-priority="${task.task_priortiy}">
											                        <svg style="padding-left:15px" xmlns="http://www.w3.org/2000/svg" width="33" height="33" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
											                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
											                            <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0"/>
											                        </svg>
											                    </a>
											                    <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal">
											                        <svg style="padding-left:5px" xmlns="http://www.w3.org/2000/svg" width="23" height="23" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
											                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
											                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
											                        </svg>
											                    </a>
											                    <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal" data-task-id="${task.task_id}">
											                        <svg xmlns="http://www.w3.org/2000/svg" width="21" height="21" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
																		  <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
																		  <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
																	</svg>
											                    </a>
											                </td>
											            </tr>
											        </c:forEach>
											    </tbody>
											</table>         
                <hr>
                <div>
                    <h1 style="text-align: center;">Task Assign</h1>
                </div>
                <hr>
                 <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#assignModal">Assign Task</button><br><br>
                 <table class="table table-striped table-bordered" id="assignTable">
				    <thead>
				        <tr>
				            <th>Task ID</th>
				            <th>Assigned To Emp_ID</th>
				            <th>Employee Name</th>
				            <th>Status</th>
				            <th>Actions</th>
				            <th>About Task</th>
				        </tr>
				    </thead>
				    <tbody>
				        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				        <c:forEach var="tasks" items="${assignTask}">
				            <tr>
				                <td>${tasks.task_id}</td>
				                <td>${tasks.emp_id}</td>
				                <td>${tasks.name}</td>
				                <td>${tasks.status}</td>
				                <td>
				                    <a href="#" class="edit-task1" data-toggle="modal" data-target="#editTaskModal1">
				                        <svg style="padding-left:5px" xmlns="http://www.w3.org/2000/svg" width="23" height="23" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
				                            <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
				                            <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
				                        </svg>
				                    </a>
				                    <a href="#" class="delete-task1" data-toggle="modal" data-target="#deleteTaskModal1" data-task1-id="${tasks.task_id}" data-emp-id="${tasks.emp_id}">
				                        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
				                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
				                            <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
				                        </svg>
				                    </a>
				                </td>
				                <td>
				                    <a href="#" class="info-task" data-toggle="modal" data-target="#aboutTask" data-id="${tasks.task_id}" data-name="${tasks.task_name}" data-description="${tasks.task_desp}" data-priority="${tasks.task_priortiy}">
				                        <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
				                            <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16"/>
				                            <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0"/>
				                        </svg>
				                    </a>
				                </td>
				            </tr>
				        </c:forEach>
				    </tbody>
				</table>

                <hr>
            </main>
        </div>
    </div>
    
    <!-- model to assign task -->
            <div class="modal" id="assignModal">
            <div class="modal-dialog">
                <div class="modal-content">

                    <!-- Modal Header -->
                    <div class="modal-header">
                        <h4 class="modal-title">Assign Task</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>

                    <!-- Modal body -->
                    
                    <div class="modal-body">
                        <form id="taskForm" action="${pageContext.request.contextPath}/manager/assignTask" novalidate>
                            
                                <div class="form-group">
                                    <label for="taskName">Task ID</label>
                                    <input type="text" class="form-control" id="taskName" placeholder="Task Id" required name="taskId">
                                    <div class="invalid-feedback">
                                        Please provide a task Id.
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="assignedTo">Assigned To(Employee ID)</label>
                                    <input type="text" class="form-control" id="assignedTo" placeholder="Assigned To" required name="emp_id">
                                    <div class="invalid-feedback">
                                        Please provide an assignee.
                                    </div>
                                </div>
                            
                            
                                <div class="form-group">
                                    <label for="status">Status</label>
                                    <input type="text" class="form-control" id="assignedTo" placeholder="Assigned To" required name="status" value="Assigned" readonly>
                                    
                                    <div class="invalid-feedback">
                                        Please select a status.
                                    </div>
                                </div>
                            
                            <button type="submit" class="btn btn-primary">Add Task</button>
                        </form>
                    </div>
                    </div>
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
                <p><strong>Task Id:</strong> <span id="task_id"></span></p>
                <p><strong>Task Name:</strong> <span id="task_name"></span></p>
                <p><strong>Description: </strong> <span id="task_desp"></span></p>
                <p><strong>Priority: </strong> <span id="task_priority"></span></p>
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
            <form id="taskForm1" action="${pageContext.request.contextPath}/manager/taskCreation" >
                <div class="modal-header">
                    <h5 class="modal-title" id="addTaskModalLabel">Add Task</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskName">Task Name</label>
                        <input type="text" class="form-control" id="taskName"  name="taskName">
                        <div class="invalid-feedback">Task Name is required</div>
                    </div>
                    <div class="form-group">
                        <label for="taskDescription">Task Description</label>
                        <input type="text" class="form-control" id="taskDescription"  name="desp">
                        <div class="invalid-feedback">Task Description is required</div>
                    </div>
                    <div class="form-group">
                        <label for="taskPriority">Task Priority</label>
                        <select class="form-control" id="taskPriority"  name="priority">
                            <option value="">Select Priority</option>
                            <option value="Low">Low</option>
                            <option value="medium">Medium</option>
                            <option value="high">High</option>
                        </select>
                        <div class="invalid-feedback">Task Priority is required</div>
                    </div>
                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input type="date" class="form-control" id="startDate"  name="startDate">
                        <div class="invalid-feedback">Start Date is required</div>
                    </div>
                    <div class="form-group">
                        <label for="endDate">End Date</label>
                        <input type="date" class="form-control" id="endDate"  name="endDate">
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
            <form id="editTaskForm" novalidate action="${pageContext.request.contextPath}/manager/editTask" method="post">
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
                <form id="editTaskForm1" action="${pageContext.request.contextPath}/manager/editAssign" novalidate>
                    <div class="modal-header">
                        <h5 class="modal-title" id="editTaskModalLabel">Edit Task</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        
                        <div class="form-group">
                            <label for="editTaskId">Task ID</label>
                            <input type="text" class="form-control" id="editTaskId" name="task_id" required readonly>
                            <div class="invalid-feedback">Please enter a task ID.</div>
                        </div>
                        <div class="form-group">
                            <label for="editAssignedTo">Assigned To</label>
                            <input type="text" class="form-control" id="editAssignedTo" name="emp_id" required readonly>
                            <div class="invalid-feedback">Please enter the assignee.</div>
                        </div>
                        <div class="form-group">
                            <label for="editAssignedName">Assignee Name</label>
                            <input type="text" class="form-control" id="editAssignedName" name="assignee_name" required readonly>
                            <div class="invalid-feedback">Please enter the assignee.</div>
                        </div>
                        <div class="form-group">
                            <label for="editStatus">Status</label>
                            <select class="form-control" id="editStatus" required name="status">
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
                Are you sure you want to delete Task ID: <span id="tasksIdDisplay"></span>?<br>
                Assigned To Employee ID: <span id="empIdDisplay"></span> <!-- Added empId display -->
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
                    <form id="editProfileForm" action ="${pageContext.request.contextPath}/manager/editprofile" novalidate>
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
    <script>
document.getElementById('taskForm').addEventListener('submit', function(event) {
    console.log("Form submitted");

    let isValid = true;

    // Validate Task ID
    const taskIdInput = document.getElementById('taskName');
    taskIdInput.addEventListener("input",()=>{
    	
    	task();
    	
    });
    
    function task(){
    	if (!/^\d+$/.test(taskIdInput.value)) {
            taskIdInput.classList.remove("is-valid");
            taskIdInput.classList.add("is-invalid");
            isValid = false;
            return false;
        } else {
            taskIdInput.classList.remove("is-invalid");
            taskIdInput.classList.add("is-valid");
            return true;
        }
    }
    

    // Validate Assigned To
    const assignedToInput = document.getElementById('assignedTo');
    
    assignedToInput.addEventListener("input",()=>{
    	
    	assigned();
    	
    });
    
    function assigned(){
    if (!/^\d+$/.test(assignedToInput.value)) {
        assignedToInput.classList.remove("is-valid");
        assignedToInput.classList.add("is-invalid");
        isValid = false;
        return false;
    } else {
        assignedToInput.classList.remove("is-invalid");
        assignedToInput.classList.add("is-valid");
        return true;
    }
    }

    // Additional validation logic if needed
	isValid&=assigned();
    isValid&=task();
    if (isValid) {
        // Submit the form if all validations pass
        this.submit();
    } else {
    	event.preventDefault();
        console.log("Form contains invalid inputs");
    }
});
</script>
    <script>
    /*document.addEventListener("DOMContentLoaded", function () {
    	
        var form = document.getElementById('taskForm');
        form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
        }, false);
        
        // Validate on input change
        var inputs = form.querySelectorAll('input, select');
        inputs.forEach(function (input) {
            input.addEventListener('change', function () {
                if (input.checkValidity()) {
                    input.classList.remove('is-invalid');
                    input.classList.add('is-valid');
                } else {
                    input.classList.remove('is-valid');
                    input.classList.add('is-invalid');
                }
            });
        });
    }); */
    
    var form1= document.getElementById('taskForm1');
    form1.addEventListener('submit', (event) => {
        console.log("hiii");
        
        var isNotEmpty = true;
        form1.querySelectorAll('input').forEach(input => {
        	var value = input.value;
        	if(value===''){
        		input.classList.remove("is-valid");
            input.classList.add("is-invalid");
            	isNotEmpty = false;
        	}else
        		{
        		input.classList.remove("is-invalid");
        		input.classList.add("is-valid");
        		}
        });
        if(!isNotEmpty){
        	event.preventDefault();
        }
    });

    
    form1.addEventListener('input',()=>{
    	console.log("inside");
    });
    
    
    
    

    </script>
    <script>
    $(document).ready(function () {
            
        // Handle showing task details
        $('.info-task').on('click', function () {
            var taskId = $(this).data('id');
            var taskName = $(this).data('name');
            var description = $(this).data('description');
            var priority = $(this).data('priority');

            $('#task_id').text(taskId);
            $('#task_name').text(taskName);
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
        
        // Handle editing task
        $('.edit-task1').on('click', function () {
            var row = $(this).closest('tr');
            var taskId = row.find('td:eq(0)').text();
            var empId = row.find('td:eq(1)').text();
            var assigneeName = row.find('td:eq(2)').text();
            var status = row.find('td:eq(3)').text();

            $('#editTaskId').val(taskId);
            $('#editAssignedTo').val(empId);
            $('#editAssignedName').val(assigneeName);
            $('#editStatus').val(status.toLowerCase()); // Assuming the status is stored in lower case
        });

        // Handle delete task
        $('.delete-task').on('click', function () {
            var taskId = $(this).data('task-id');
            $('#taskIdDisplay').text(taskId);
            $('#confirmDelete').data('task-id', taskId);
        });

        $('#confirmDelete').on('click', function () {
            var taskId = $(this).data('task-id');
            location.href = '${pageContext.request.contextPath}/manager/DeleteTask?taskId=' + encodeURIComponent(taskId);
        });

    });
    </script>
    <script>
    // Handle delete task
    $(document).ready(function () {
    $('.delete-task1').on('click', function () {
        var taskId = $(this).data('task1-id');
        var empId = $(this).data('emp-id'); // Get the emp_id data attribute

        $('#tasksIdDisplay').text(taskId);
        $('#empIdDisplay').text(empId); // Display emp_id in the modal if needed
        $('#confirmDeleteButton').data('task1-id', taskId); // Store task_id in the button
        $('#confirmDeleteButton').data('emp-id', empId); // Store emp_id in the button
    });

    $('#confirmDeleteButton').on('click', function () {
        var taskId = $(this).data('task1-id');
        var empId = $(this).data('emp-id');
        location.href = '${pageContext.request.contextPath}/manager/DeleteAssign?taskId=' + encodeURIComponent(taskId) + '&empId=' + encodeURIComponent(empId);
    });
});

</script>
    
    <script>
    $(document).ready(function() {
        $('#assignTable').DataTable({
        	"pageLength": 4,
          //disable sorting on last column
          "columnDefs": [
            { "orderable": false, "targets": 5 }
          ],
          language: {
            //customize pagination prev and next buttons: use arrows instead of words
            'paginate': {
              'previous': '<span class="fa fa-chevron-left"></span>',
              'next': '<span class="fa fa-chevron-right"></span>'
            },
            //customize number of elements to be displayed
            "lengthMenu": 'Display <select class="form-control input-sm">'+
            '<option value="5">5</option>'+
            '<option value="10">10</option>'+
            '<option value="20">20</option>'+
            '<option value="30">30</option>'+
            '<option value="40">40</option>'+
            '<option value="50">50</option>'+
            '<option value="-1">All</option>'+
            '</select> results'
          }
        })  
     
     $('#taskTable').DataTable({
     	"pageLength": 4,
       //disable sorting on last column
       "columnDefs": [
         { "orderable": false, "targets": 5 }
       ],
       language: {
         //customize pagination prev and next buttons: use arrows instead of words
         'paginate': {
           'previous': '<span class="fa fa-chevron-left"></span>',
           'next': '<span class="fa fa-chevron-right"></span>'
         },
         //customize number of elements to be displayed
         "lengthMenu": 'Display <select class="form-control input-sm">'+
         '<option value="5">5</option>'+
         '<option value="10">10</option>'+
         '<option value="20">20</option>'+
         '<option value="30">30</option>'+
         '<option value="40">40</option>'+
         '<option value="50">50</option>'+
         '<option value="-1">All</option>'+
         '</select> results'
       }
     })  
     
    } );
    </script>
</body>
</html>
    