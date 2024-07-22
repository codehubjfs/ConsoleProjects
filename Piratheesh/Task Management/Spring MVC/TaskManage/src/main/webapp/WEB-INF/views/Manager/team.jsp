<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Team</title>
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
                            <a class="nav-link" href="${pageContext.request.contextPath}/manager/dashboard"">Dashboard</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="${pageContext.request.contextPath}/manager/team">View Team</a>
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
               <div class="container mt-12">
		        <div class="row">
		        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
				        <c:forEach var="employee" items="${employees}">
		            <div class="col-md-4 " style="margin-bottom:2%;">
		                <div class="card profile-card">
		                    <img src="${pageContext.request.contextPath}/assets/Image/Manager/employee.png" class="card-img-top" alt="Employee Photo" style="height:60%; width:60%;margin-left:21%;margin-top:10%;">
		                    <div class="card-body text-center">
		                        <h5 class="card-title">${employee.name}</h5>
		                        <p class="card-text"><strong>Role: </strong>${employee.role}</p>
		                        <p class="card-text"><strong>Hire Date: </strong>${employee.hiredate}</p>
		                        <a href="mailto:${empployeeMail}" class="btn btn-primary">Contact</a>
		                    </div>
		                </div>
		            </div>
		            </c:forEach>
		            
		           
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
                  <form id="editProfileForm" action="${pageContext.request.contextPath}/manager/editprofile" novalidate>
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
                          <input type="tel" class="form-control" id="profilePhone" value="${employeeNumber}">
                      </div>
                      <div class="form-group">
                          <label for="profileOccupation">Role</label>
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
    <script></script>
</body>
</html>
