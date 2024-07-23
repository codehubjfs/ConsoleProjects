<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Assign</title>
    <link rel="stylesheet" href="../../asserts/CSS/Manager/dashBoard.css">
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
                <img src="../../asserts/Image/Manager/taskmanagement1.jpg" alt="Logo" class="logo-img">
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
                            <a class="nav-link" href="dashBoard.jsp">Dashboard</a>
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
                            <a href="personaltask.jsp" class="nav-link">Personal Task Management</a>
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
                                <div class="card mb-4">
                                    <div class="card-header">Task Management</div>
                                    <div class="card-body">
                                        <h4 class="card-title">Task Creation Table</h4>
                                        <p class="card-description">Task table with card</p>
                                        <div class="table-responsive">
                                            <table class="table table-striped mt-3" id="taskTable">
                                                <thead>
                                                    <tr>
                                                        <th>Task Name</th>
                                                        <th>Task Description</th>
                                                        <th>Task ID</th>
                                                        <th>Start Date</th>
                                                        <th>End Date</th>
                                                        <th>Actions</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>Sample Task</td>
                                                        <td>Sample Description</td>
                                                        <td>1</td>
                                                        <td>2023-06-01</td>
                                                        <td>2023-06-05</td>
                                                        <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit" style="text-align: center;"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash" style="text-align: center;"></i></a>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Sample Task2</td>
                                                        <td>Sample Description2</td>
                                                        <td>2</td>
                                                        <td>2023-05-01</td>
                                                        <td>2023-05-05</td>
                                                        <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit" style="text-align: center;"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash" style="text-align: center;"></i></a>
                                                        </td>
                                                    </tr>
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
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal1" data-task="{'name': 'Samso Park', 'assignedTo': '34424433', 'dueDate': '2017-05-12', 'status': 'Pending'}"><i class="fa fa-edit"></i></a>
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
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal1" data-task="{'name': 'Marlo Sanki', 'assignedTo': '53425532', 'dueDate': '2015-05-15', 'status': 'In progress'}"><i class="fa fa-edit"></i></a>
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
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal1" data-task="{'name': 'John ryte', 'assignedTo': '53275533', 'dueDate': '2017-05-14', 'status': 'Fixed'}"><i class="fa fa-edit"></i></a>
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
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal1" data-task="{'name': 'Peter mark', 'assignedTo': '53275534', 'dueDate': '2017-05-16', 'status': 'Completed'}"><i class="fa fa-edit"></i></a>
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
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal1" data-task="{'name': 'Dave', 'assignedTo': '53275535', 'dueDate': '2017-05-20', 'status': 'In progress'}"><i class="fa fa-edit"></i></a>
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
                                            <input type="text" class="form-control" id="taskName" placeholder="Task Id" required>
                                            <div class="invalid-feedback">
                                                Please provide a task Id.
                                            </div>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="assignedTo">Assigned To</label>
                                            <input type="text" class="form-control" id="assignedTo" placeholder="Assigned To" required>
                                            <div class="invalid-feedback">
                                                Please provide an assignee.
                                            </div>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="dueDate">Due Date</label>
                                            <input type="date" class="form-control" id="dueDate" required>
                                            <div class="invalid-feedback">
                                                Please provide a due date.
                                            </div>
                                        </div>
                                        <div class="form-group col-md-3">
                                            <label for="status">Status</label>
                                            <select class="form-control" id="status" required>
                                                <option>Assigned</option>
                                                <option>Pending</option>
                                                <option>In Progress</option>
                                                <option>Completed</option>
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

     <!-- Add Task Modal -->
<div class="modal fade" id="addTaskModal" tabindex="-1" aria-labelledby="addTaskModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="taskForm" novalidate>
                <div class="modal-header">
                    <h5 class="modal-title" id="addTaskModalLabel">Add Task</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskName">Task Name</label>
                        <input type="text" class="form-control" id="taskName" required>
                        <div class="invalid-feedback">Task Name is required</div>
                    </div>
                    <div class="form-group">
                        <label for="taskDescription">Task Description</label>
                        <input type="text" class="form-control" id="taskDescription" required>
                        <div class="invalid-feedback">Task Description is required</div>
                    </div>
                    <div class="form-group">
                        <label for="taskID">Task ID</label>
                        <input type="text" class="form-control" id="taskID" required>
                        <div class="invalid-feedback">Task ID is required</div>
                    </div>
                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input type="date" class="form-control" id="startDate" required>
                        <div class="invalid-feedback">Start Date is required</div>
                    </div>
                    <div class="form-group">
                        <label for="endDate">End Date</label>
                        <input type="date" class="form-control" id="endDate" required>
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
            <form id="editTaskForm" novalidate>
                <div class="modal-header">
                    <h5 class="modal-title" id="editTaskModalLabel">Edit Task</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="editTaskName">Task Name</label>
                        <input type="text" class="form-control" id="editTaskName" required>
                        <div class="invalid-feedback">Task Name is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editTaskDescription">Task Description</label>
                        <input type="text" class="form-control" id="editTaskDescription" required>
                        <div class="invalid-feedback">Task Description is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editTaskID">Task ID</label>
                        <input type="text" class="form-control" id="editTaskID" required>
                        <div class="invalid-feedback">Task ID is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editStartDate">Start Date</label>
                        <input type="date" class="form-control" id="editStartDate" required>
                        <div class="invalid-feedback">Start Date is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editEndDate">End Date</label>
                        <input type="date" class="form-control" id="editEndDate" required>
                        <div class="invalid-feedback">End Date is required</div>
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
                Are you sure you want to delete this task?
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
                                <option value="Assigned">Assigned</option>
                                <option value="Pending">Pending</option>
                                <option value="In Progress">In Progress</option>
                                <option value="Completed">Completed</option>
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
    <script src="../../asserts/Javascript/Manager/taskmanage.js"></script>
</body>
</html>
    