<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Team</title>
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
                            <a class="dropdown-item" href="../Login/login.html">Logout</a>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="row">
            <nav class="col-md-2 d-none d-md-block sidebar">
                <div class="sidebar-sticky">
                    <h5 class="sidebar-heading">Piratheesh's Dashboard</h5>
                    <ul class="nav flex-column">
                        <li class="nav-item">
                            <a class="nav-link" href="dashBoard.jsp">Dashboard</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="team.jsp">View Team</a>
                        </li>
                        <li class="nav-item">
                            <a href="taskmanage.jsp" class="nav-link">Task Management</a>
                        </li>
                        
                        <li class="nav-item">
                            <a href="calender.jsp" class="nav-link">Calendar</a>
                        </li>
                        <li class="nav-item">
                            <a href="perosnaltask.jsp" class="nav-link">Personal Task Management</a>
                        </li>
                        <li class="nav-item">
                          <a href="../../index.jsp" class="nav-link">Logout</a>
                      </li>
                    </ul>
                </div>
            </nav>
            <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
              <div class="container" id="navigation">
                <nav style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="manager.html">Dashboard</a></li>
                        <li class="breadcrumb-item active" aria-current="page">Team</li>
                    </ol>
                <nav>
              </div>
                <div >
                    <h1>Your Team's</h1>
                </div>
                <hr>
                <div class="row">
                    <div class="col-md-7">
                        <div class="card mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <span>Team 1</span>
                                <button type="button" class="btn btn-link" data-toggle="collapse" data-target="#team1Collapse" aria-expanded="false" aria-controls="team1Collapse">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-angle-expand" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M0 0h6v2H2v4H0V0zm14 14h-4v2h6V10h-2v4z"/>
                                    </svg>
                                </button>
                            </div>
                            <div id="team1Collapse" class="collapse">
                                <div class="page-content page-container" id="page-content">
                                    <div class="padding">
                                        <div class="row container d-flex justify-content-center">
                                  <div class="col-lg-12 grid-margin stretch-card">
                                              <div class="card">
                                                <div class="card-body">
                                                  <h4 class="card-title">Team 1</h4>
                                                  <p class="card-description">
                                                   Team Members and Detials
                                                  </p>
                                                  <div class="table-responsive">
                                                    <table class="table table-hover">
                                                      <thead>
                                                        <tr>
                                                          <th>Employee Id</th>
                                                          <th>UserName</th>
                                                          <th>Role</th>
                                                          <th>Status</th>
                                                          <th>Action</th>
                                                        </tr>
                                                      </thead>
                                                      <tbody>
                                                        <tr>
                                                          <td>101</td>
                                                          <td>Hitesh Chauhan</td>
                                                          <td>Employee</td>
                                                          <td><label class="badge badge-danger">Pending</label></td>
                                                          <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                        </td>
                                                        </tr>
                                                        <tr>
                                                          <td>401</td>
                                                          <td>Samso Palto</td>
                                                          <td>Employee</td>
                                                          <td><label class="badge badge-warning">In progress</label></td>
                                                          <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                        </td>
                                                        </tr>
                                                        <tr>
                                                          <td>502</td>
                                                          <td>Tiplis mang</td>
                                                          <td>Employee</td>
                                                          <td><label class="badge badge-info">Fixed</label></td>
                                                          <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                        </td>
                                                        </tr>
                                                        <tr>
                                                          <td>560</td>
                                                          <td>Pter parker</td>
                                                          <td>Employee</td>
                                                          <td><label class="badge badge-success">Completed</label></td>
                                                          <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                        </td>
                                                        </tr>
                                                        <tr>
                                                          <td>150</td>
                                                          <td>Ankit Dave</td>
                                                          <td>Employee</td>
                                                          <td><label class="badge badge-warning">In progress</label></td>
                                                          <td>
                                                            <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                            <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
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
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="card mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <span>Line Graph of Employee</span>
                                <button type="button" class="btn btn-link" data-toggle="collapse" data-target="#graph1Collapse" aria-expanded="false" aria-controls="graph1Collapse">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-angle-expand" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M0 0h6v2H2v4H0V0zm14 14h-4v2h6V10h-2v4z"/>
                                    </svg>
                                    
                                </button>
                                
                            </div>
                            <div class="collapse" id="graph1Collapse">
                                <h3>Analysis of Task Perfomance</h3>
                                <div class="analysis-card">
                                <canvas id="analysisChart" style="width:100%;max-width:600px;"></canvas>
                                </div>  
                            </div>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-md-7">
                        <div class="card mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <span>Team 2</span>
                                <button type="button" class="btn btn-link" data-toggle="collapse" data-target="#team2Collapse" aria-expanded="false" aria-controls="team2Collapse">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-angle-expand" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M0 0h6v2H2v4H0V0zm14 14h-4v2h6V10h-2v4z"/>
                                    </svg>
                                </button>
                            </div>
                            <div id="team2Collapse" class="collapse">
                                <div class="page-content page-container" id="page-content">
                                    <div class="padding">
                                        <div class="row container d-flex justify-content-center">
                                <div class="col-lg-12 grid-margin stretch-card">
                                              <div class="card">
                                                <div class="card-body">
                                                  <h4 class="card-title">Basic Hoverable Table</h4>
                                                  <p class="card-description">
                                                   Basic Hoverable Table example
                                                  </p>
                                                  <div class="table-responsive">
                                                    <table class="table table-hover">
                                                        <thead>
                                                          <tr>
                                                            <th>Employee Id</th>
                                                            <th>UserName</th>
                                                            <th>Role</th>
                                                            <th>Status</th>
                                                            <th>Action</th>
                                                          </tr>
                                                        </thead>
                                                        <tbody>
                                                          <tr>
                                                            <td>101</td>
                                                            <td>Hitesh Chauhan</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-danger">Pending</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>401</td>
                                                            <td>Samso Palto</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-warning">In progress</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>502</td>
                                                            <td>Tiplis mang</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-info">Fixed</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>560</td>
                                                            <td>Pter parker</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-success">Completed</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>150</td>
                                                            <td>Ankit Dave</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-warning">In progress</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
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
                                            </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="card mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <span>Line Graph of Employee</span>
                                <button type="button" class="btn btn-link" data-toggle="collapse" data-target="#graph2Collapse" aria-expanded="false" aria-controls="graph2Collapse">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-angle-expand" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M0 0h6v2H2v4H0V0zm14 14h-4v2h6V10h-2v4z"/>
                                    </svg>
                                </button>
                            </div>

                            <div class="collapse" id="graph2Collapse">
                                <h3>Analysis of Task Perfomance</h3>
                                <canvas id="analysisChart2" style="width:100%;max-width:600px;"></canvas>
                            </div>
                            
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-md-7">
                        <div class="card mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <span>Team 3</span>
                                <button type="button" class="btn btn-link" data-toggle="collapse" data-target="#team3Collapse" aria-expanded="false" aria-controls="team3Collapse">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-angle-expand" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M0 0h6v2H2v4H0V0zm14 14h-4v2h6V10h-2v4z"/>
                                    </svg>
                                </button>
                            </div>
                            <div id="team3Collapse" class="collapse">
                                <div class="page-content page-container" id="page-content">
                                    <div class="padding">
                                        <div class="row container d-flex justify-content-center">
                                <div class="col-lg-12 grid-margin stretch-card">
                                              <div class="card">
                                                <div class="card-body">
                                                  <h4 class="card-title">Basic Hoverable Table</h4>
                                                  <p class="card-description">
                                                   Basic Hoverable Table example
                                                  </p>
                                                  <div class="table-responsive">
                                                    <table class="table table-hover">
                                                        <thead>
                                                          <tr>
                                                            <th>Employee Id</th>
                                                            <th>UserName</th>
                                                            <th>Role</th>
                                                            <th>Status</th>
                                                            <th>Action</th>
                                                          </tr>
                                                        </thead>
                                                        <tbody>
                                                          <tr>
                                                            <td>101</td>
                                                            <td>Hitesh Chauhan</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-danger">Pending</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>401</td>
                                                            <td>Samso Palto</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-warning">In progress</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>502</td>
                                                            <td>Tiplis mang</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-info">Fixed</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>560</td>
                                                            <td>Pter parker</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-success">Completed</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>150</td>
                                                            <td>Ankit Dave</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-warning">In progress</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
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
                                            </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="card mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <span>Line Graph of Employee</span>
                                <button type="button" class="btn btn-link" data-toggle="collapse" data-target="#graph3Collapse" aria-expanded="false" aria-controls="graph3Collapse">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-angle-expand" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M0 0h6v2H2v4H0V0zm14 14h-4v2h6V10h-2v4z"/>
                                    </svg>
                                </button>
                            </div>

                            <div class="collapse" id="graph3Collapse">
                                <h3>Analysis of Task Perfomance</h3>
                                <canvas id="analysisChart3" style="width:100%;max-width:600px;"></canvas>
                            </div>
                            
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-md-7">
                        <div class="card mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <span>Team 4</span>
                                <button type="button" class="btn btn-link" data-toggle="collapse" data-target="#team4Collapse" aria-expanded="false" aria-controls="team4Collapse">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-angle-expand" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M0 0h6v2H2v4H0V0zm14 14h-4v2h6V10h-2v4z"/>
                                    </svg>
                                </button>
                            </div>
                            <div id="team4Collapse" class="collapse">
                                <div class="page-content page-container" id="page-content">
                                    <div class="padding">
                                        <div class="row container d-flex justify-content-center">
                                <div class="col-lg-12 grid-margin stretch-card">
                                              <div class="card">
                                                <div class="card-body">
                                                  <h4 class="card-title">Basic Hoverable Table</h4>
                                                  <p class="card-description">
                                                   Basic Hoverable Table example
                                                  </p>
                                                  <div class="table-responsive">
                                                    <table class="table table-hover">
                                                        <thead>
                                                          <tr>
                                                            <th>Employee Id</th>
                                                            <th>UserName</th>
                                                            <th>Role</th>
                                                            <th>Status</th>
                                                            <th>Action</th>
                                                          </tr>
                                                        </thead>
                                                        <tbody>
                                                          <tr>
                                                            <td>101</td>
                                                            <td>Hitesh Chauhan</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-danger">Pending</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>401</td>
                                                            <td>Samso Palto</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-warning">In progress</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>502</td>
                                                            <td>Tiplis mang</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-info">Fixed</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>560</td>
                                                            <td>Pter parker</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-success">Completed</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
                                                            </td>
                                                          </tr>
                                                          <tr>
                                                            <td>150</td>
                                                            <td>Ankit Dave</td>
                                                            <td>Employee</td>
                                                            <td><label class="badge badge-warning">In progress</label></td>
                                                            <td>
                                                                <a href="#" class="edit-task" data-toggle="modal" data-target="#editTaskModal"><i class="fa fa-edit"></i></a>
                                                                <a href="#" class="delete-task" data-toggle="modal" data-target="#deleteTaskModal"><i class="fa fa-trash"></i></a>
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
                                            </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-5">
                        <div class="card mb-4">
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <span>Line Graph of Employee</span>
                                <button type="button" class="btn btn-link" data-toggle="collapse" data-target="#graph4Collapse" aria-expanded="false" aria-controls="graph4Collapse">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrows-angle-expand" viewBox="0 0 16 16">
                                        <path fill-rule="evenodd" d="M0 0h6v2H2v4H0V0zm14 14h-4v2h6V10h-2v4z"/>
                                    </svg>
                                </button>
                            </div>
                            <div class="collapse" id="graph4Collapse">
                                <h3>Analysis of Task Perfomance</h3>
                                <canvas id="analysisChart4" style="width:100%;max-width:600px;"></canvas>
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
                  <form id="editProfileForm" novalidate>
                      <div class="form-group">
                          <label for="profilePicture">Profile Picture</label>
                          <img src="../../asserts/Image/Manager/profile.png" alt="Profile Picture" class="img-thumbnail" id="profilePicture">
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
                          <input type="text" class="form-control" id="profileOccupation" value="Manager" disabled>
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
    <script src="../../asserts/Javascript/Manager/team.js"></script>
    <!-- <script src="manager.js"></script> -->
</body>
</html>
