<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calendar</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/CSS/Employee/calender.css">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    
  <style>
    body{
        font-size: 1.125rem;
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
                            <a href="${pageContext.request.contextPath}/manager/taskmanage" class="nav-link">Task Management</a>
                        </li>
                        <li class="nav-item">
                            <a href="${pageContext.request.contextPath}/manager/calender" class="nav-link active">Calendar</a>
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
                <div class="col-md-10 content">

                    <div>
                        <h1>Calender</h1>
                    </div>
                    
                  <hr>
                  
                  <div class="calendar">
                    <div class="timeline">
                      <div class="spacer"></div>
                      <div class="time-marker">9 AM</div>
                      <div class="time-marker">10 AM</div>
                      <div class="time-marker">11 AM</div>
                      <div class="time-marker">12 PM</div>
                      <div class="time-marker">1 PM</div>
                      <div class="time-marker">2 PM</div>
                      <div class="time-marker">3 PM</div>
                      <div class="time-marker">4 PM</div>
                      <div class="time-marker">5 PM</div>
                      <div class="time-marker">6 PM</div>
                    </div>
                    <div class="days">
                      <div class="day mon">
                        <div class="date">
                          <p class="date-num">9</p>
                          <p class="date-day">Mon</p>
                        </div>
                        <div class="events">
                          <div class="event start-2 end-5 securities">
                            <p class="title">Securities Regulation</p>
                            <p class="time">2 PM - 5 PM</p>
                          </div>
                        </div>
                      </div>
                      <div class="day tues">
                        <div class="date">
                          <p class="date-num">12</p>
                          <p class="date-day">Tues</p>
                        </div>
                        <div class="events">
                          <div class="event start-10 end-12 corp-fi">
                            <p class="title">Corporate Finance</p>
                            <p class="time">10 AM - 12 PM</p>
                          </div>
                          <div class="event start-1 end-4 ent-law">
                            <p class="title">Entertainment Law</p>
                            <p class="time">1PM - 4PM</p>
                          </div>
                        </div>
                      </div>
                      <div class="day wed">
                        <div class="date">
                          <p class="date-num">11</p>
                          <p class="date-day">Wed</p>
                        </div>
                        <div class="events">
                          <div class="event start-12 end-1 writing">
                            <p class="title">Writing Seminar</p>
                            <p class="time">11 AM - 12 PM</p>
                          </div>
                          <div class="event start-2 end-5 securities">
                            <p class="title">Securities Regulation</p>
                            <p class="time">2 PM - 5 PM</p>
                          </div>
                        </div>
                      </div>
                      <div class="day thurs">
                        <div class="date">
                          <p class="date-num">12</p>
                          <p class="date-day">Thurs</p>
                        </div>
                        <div class="events">
                          <div class="event start-10 end-12 corp-fi">
                            <p class="title">Corporate Finance</p>
                            <p class="time">10 AM - 12 PM</p>
                          </div>
                          <div class="event start-1 end-4 ent-law">
                            <p class="title">Entertainment Law</p>
                            <p class="time">1PM - 4PM</p>
                          </div>
                        </div>
                      </div>
                      <div class="day fri">
                        <div class="date">
                          <p class="date-num">13</p>
                          <p class="date-day">Fri</p>
                        </div>
                        <div class="events">
                        </div>
                      </div>
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
                    <input type="tel" class="form-control" id="profilePhone" value="${employeeNumber}"  name="phonenumber">
                </div>
                <div class="form-group">
                    <label for="profileOccupation">Role</label>
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
    
</body>
</html>
