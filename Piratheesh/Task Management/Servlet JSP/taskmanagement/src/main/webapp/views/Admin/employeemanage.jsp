<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Management</title>
    <link rel="stylesheet" href="../../asserts/CSS/Admin/employeemanage.css">
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
                    <h5 class="sidebar-heading">Admin's Dashboard</h5>
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="dashBoard.jsp">Dashboard</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="employeemanage.jsp">Employee Management</a>
                        </li>
                        <li class="nav-item">
                            <a href="adminmanage.jsp" class="nav-link">Admin Management</a>
                        </li>
                        <li class="nav-item">
                            <a href="reportmanage.jsp" class="nav-link">Report Management</a>
                        </li>
                        <li class="nav-item">
                            <a href="../../index.jsp" class="nav-link">Logout</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                <div>
                    <h1>Employee Management</h1>
                </div>
                <hr>
                <div>
                    <h1>Employee Management</h1>
                </div>
                <hr>
                <div class="page-content page-container" id="page-content">
                    <div class="padding">
                        <div class="row container d-flex justify-content-center">
                            <div class="col-lg-12 px-3 stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Employee Table</h4>
                                        <p class="card-description">
                                            Employee Table with Details
                                        </p>
                                        <button class="btn btn-primary" data-toggle="modal" data-target="#addTaskModal">Add Employee</button>
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                    <tr>
                                                        <th>Name</th>
                                                        <th>ID No.</th>
                                                        <th>Email</th>
                                                        <th>Password</th>
                                                        <th>City</th>
                                                        <th>Hire Date</th>
                                                        <th>Manager ID</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="employeeTableBody">
                                                   

                                                </tbody>
                                            </table>
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
                <div class="modal-header">
                    <h5 class="modal-title" id="addTaskModalLabel">Add Employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="taskForm" novalidate>
                        <div class="form-group">
                            <label for="empName">Employee Name</label>
                            <input type="text" class="form-control" id="empName" placeholder="Employee Name" required>
                            <div class="invalid-feedback">Please enter employee name.</div>
                        </div>
                        <div class="form-group">
                            <label for="empID">Employee ID</label>
                            <input type="text" class="form-control" id="empID" placeholder="Employee ID" disabled>
                            <div class="invalid-feedback">Please enter employee ID.</div>
                        </div>
                        <div class="form-group">
                            <label for="emailId">Email</label>
                            <input type="email" class="form-control" id="emailId" placeholder="Email Id" required>
                            <div class="invalid-feedback">Please enter a valid email.</div>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="text" class="form-control" id="password" value="welcome123" disabled>
                        </div>
                        <div class="form-group">
                            <label for="city">City</label>
                            <input type="text" class="form-control" id="city" placeholder="City" required>
                            <div class="invalid-feedback">Please enter city.</div>
                        </div>
                        <div class="form-group">
                            <label for="hiredate">Hire Date</label>
                            <input type="date" class="form-control" id="hiredate" required>
                            <div class="invalid-feedback">Please enter hire date.</div>
                        </div>
                        <div class="form-group">
                            <label for="magid">Manager ID</label>
                            <input type="text" class="form-control" id="magid" placeholder="Manager ID" required>
                            <div class="invalid-feedback">Please enter manager ID.</div>
                        </div>
                        <button type="submit" class="btn btn-primary">Add Employee</button>
                        <button type="reset" class="btn btn-primary">Reset</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Edit Task Modal -->
    <div class="modal fade" id="editTaskModal" tabindex="-1" aria-labelledby="editTaskModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editTaskModalLabel">Edit Employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="editTaskForm" novalidate>
                        <input type="hidden" id="editEmpIndex">
                        <div class="form-group">
                            <label for="editEmpName">Employee Name</label>
                            <input type="text" class="form-control" id="editEmpName" required disabled>
                            <div class="invalid-feedback">Please enter employee name.</div>
                        </div>
                        <div class="form-group">
                            <label for="editEmpID">Employee ID</label>
                            <input type="text" class="form-control" id="editEmpID" required disabled>
                            <div class="invalid-feedback">Please enter employee ID.</div>
                        </div>
                        <div class="form-group">
                            <label for="editEmailId">Email</label>
                            <input type="email" class="form-control" id="editEmailId" required>
                            <div class="invalid-feedback">Please enter a valid email.</div>
                        </div>
                        <div class="form-group">
                            <label for="editPassword">Password</label>
                            <input type="text" class="form-control" id="editPassword" required disabled>
                            <div class="invalid-feedback">Please enter password.</div>
                        </div>
                        <div class="form-group">
                            <label for="editCity">City</label>
                            <input type="text" class="form-control" id="editCity" required>
                            <div class="invalid-feedback">Please enter city.</div>
                        </div>
                        <div class="form-group">
                            <label for="editHiredate">Hire Date</label>
                            <input type="date" class="form-control" id="editHiredate" required>
                            <div class="invalid-feedback">Please enter hire date.</div>
                        </div>
                        <div class="form-group">
                            <label for="editMagid">Manager ID</label>
                            <input type="text" class="form-control" id="editMagid" required>
                            <div class="invalid-feedback">Please enter manager ID.</div>
                        </div>
                        <button type="submit" class="btn btn-primary">Update Employee</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Delete Task Modal -->
    <div class="modal fade" id="deleteTaskModal" tabindex="-1" aria-labelledby="deleteTaskModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteTaskModalLabel">Delete Employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure you want to delete this employee?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                    <button type="button" class="btn btn-danger" id="confirmDelete">Delete</button>
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
                            <img src="../../asserts/Image/Admin/profile.png" alt="Profile Picture" class="img-thumbnail" id="profilePicture">
                        </div>
                        <div class="form-group">
                            <label for="profileName">Name</label>
                            <input type="text" class="form-control" id="profileName" value="John Doe" disabled>
                        </div>
                        <div class="form-group">
                            <label for="profileEmail">Email</label>
                            <input type="email" class="form-control" id="profileEmail" value="johndoe@example.com" disabled>
                        </div>
                        <div class="form-group">
                            <label for="profilePhone">Phone Number</label>
                            <input type="tel" class="form-control" id="profilePhone" value="123-456-7890">
                        </div>
                        <div class="form-group">
                            <label for="profileOccupation">Occupation</label>
                            <input type="text" class="form-control" id="profileOccupation" value="Administrator" disabled>
                        </div>
                        <div class="form-group">
                            <label for="profileCity">City</label>
                            <input type="text" class="form-control" id="profileCity" value="New York">
                        </div>
                        <button type="submit" class="btn btn-primary">Save changes</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <script src="../../asserts/Javascript/Admin/employeemanage.js"></script>
</body>
</html>
