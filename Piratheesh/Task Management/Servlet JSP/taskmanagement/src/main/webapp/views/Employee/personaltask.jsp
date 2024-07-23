<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task Assign</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/CSS/Employee/assignedtaskemp.css">
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
                <img src="${pageContext.request.contextPath}/asserts/Image/Employee/taskmanagement1.jpg" alt="Logo" class="logo-img">
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
            <nav class="col-md-2 d-none d-md-block sidebar">
                <div class="sidebar-sticky">
                    <h5 class="sidebar-heading">${employeeName} Dashboard</h5>
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="EmployeeDashBoard">Dashboard</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/views/Employee/calender.jsp" class="nav-link">Calendar</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/AssignedTask" class="nav-link">Assigned Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/PendingTask" class="nav-link">Pending Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/CompletedTask" class="nav-link">Completed Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/OverlayedTask" class="nav-link">Over Due Task</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/PersonalTask" class="nav-link active">Personal Task Management</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/index.jsp" class="nav-link">Logout</a>
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
                
                <div><h1>Perosnal Task Creation</h1></div>
                <hr>
                <div class="page-content page-container" id="page-content">
                    <div class="padding">
                        <div class="row container d-flex justify-content-center">
                            <div class="col-lg-12 grid-margin stretch-card">
                                <div class="card mb-8">
                                    <div class="card-header">Personal Task Management</div>
                                    <div class="card-body">
                                        <h4 class="card-title">Personal Task Creation Table</h4>
                                        <div class="table-responsive">
                                            <table class="table table-striped mt-6" id="taskTable">
                                                <thead>
                                                    <tr>
                                                    	
                                                    	<th>Task Id</th>
                                                        <th>Task Name</th>
                                                        <th>Task Description</th>
                                                        <th>Priority</th>
                                                        <th>Start Date</th>
                                                        <th>End Date</th>
                                                        <th>Actions</th>
                                                    </tr>
                                                </thead>
                                                <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
                       							<c:forEach var="task" items="${personalTasks}">
                                                    <tr>
                                                    	<td>${task.task_id}</td>
                                                        <td>${task.task_name}</td>
                                                        <td>${task.desp}</td>
                                                        <td>${task.priority}</td>
                                                        <td>${task.start_date}</td>
                                                        <td>${task.end_date}</td>
                                                        <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit" style="text-align: center;"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash" style="text-align: center;"></i></a>
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
            </main>
        </div>
    </div>

     <!-- Add Task Modal -->
<div class="modal fade" id="addTaskModal" tabindex="-1" aria-labelledby="addTaskModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="taskForm" action="PersonalTaskAdd" method="post" novalidate>
                <div class="modal-header">
                    <h5 class="modal-title" id="addTaskModalLabel">Add Task</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="taskName">Task Name</label>
                        <input type="text" class="form-control" id="taskName" name="taskName" required>
                        <div class="invalid-feedback">Task Name is required</div>
                    </div>
                    <div class="form-group">
                        <label for="taskDescription">Task Description</label>
                        <input type="text" class="form-control" id="taskDescription" name="desp" required>
                        <div class="invalid-feedback">Task Description is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editTaskID">Task Priority</label>
                        <select class="form-control" id="editTaskID" name="priority" required>
                            <option value="Low">Low</option>
                            <option value="Medium">Medium</option>
                            <option value="high">High</option>
                        </select>
                        <div class="invalid-feedback">Task Priority is required</div>
                    </div>
                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input type="date" class="form-control" id="startDate" name="startDate" required>
                        <div class="invalid-feedback">Start Date is required</div>
                    </div>
                    <div class="form-group">
                        <label for="endDate">End Date</label>
                        <input type="date" class="form-control" id="endDate" name="endDate" required>
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
            <form id="editTaskForm" action="EditPersonalTask" method="post" novalidate>
                <div class="modal-header">
                    <h5 class="modal-title" id="editTaskModalLabel">Edit Task</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="editTaskId">Task ID</label>
                        <input type="text" class="form-control" id="editTaskId" name="editTaskId" disabled>
                        <div class="invalid-feedback">Task ID is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editTaskName">Task Name</label>
                        <input type="text" class="form-control" id="editTaskName" name="editTaskName" required>
                        <div class="invalid-feedback">Task Name is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editTaskDescription">Task Description</label>
                        <input type="text" class="form-control" id="editTaskDescription" name="editTaskDescription" required>
                        <div class="invalid-feedback">Task Description is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editTaskPriority">Task Priority</label>
                        <select class="form-control" id="editTaskPriority" name="editTaskPriority" required>
                            <option value="Low">Low</option>
                            <option value="medium">Medium</option>
                            <option value="high">High</option>
                        </select>
                        <div class="invalid-feedback">Task Priority is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editStartDate">Start Date</label>
                        <input type="date" class="form-control" id="editStartDate" name="editStartDate" required>
                        <div class="invalid-feedback">Start Date is required</div>
                    </div>
                    <div class="form-group">
                        <label for="editEndDate">End Date</label>
                        <input type="date" class="form-control" id="editEndDate" name="editEndDate" required>
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
                    <form id="editProfileForm" action="EditProfile" method="post" novalidate>
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
                            <input type="tel" class="form-control" id="profilePhone" value="${employeeNumber}" name="phonenumber">
                        </div>
                        <div class="form-group">
                            <label for="profileOccupation">Occupation</label>
                            <input type="text" class="form-control" id="profileOccupation" value="${employeeRole}" disabled>
                        </div>
                        <div class="form-group">
                            <label for="profileCity">City</label>
                            <input type="text" class="form-control" id="profileCity" value="${employeeCity}"  name="city">
                        </div>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/asserts/Javascript/Employee/personaltask.js"></script>
</body>
</html>
