<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="assserts/css/DashBoard.css">
    <style type="text/css">
    /* Custom styles for the dashboard */

.circular-progress-bar {
    width: 50px;
    height: 50px;
    border-radius: 50%;
    background: conic-gradient(#4caf50 0% 70%, #e0e0e0 70% 100%);
    display: flex;
    align-items: center;
    justify-content: center;
    font-weight: bold;
    color: #4caf50;
}

.progress-bars .progress {
    height: 20px;
}

.progress-bar {
    background-color: #4caf50;
}

.sidebar {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    z-index: 100;
    padding: 48px 0 0;
    box-shadow: inset -1px 0 0 rgba(0, 0, 0, 0.1);
}

.sidebar .nav-link {
    font-weight: 500;
    color: #333;
}

.sidebar .nav-link:hover {
    color: #007bff;
}

.main-content {
    margin-left: 200px; /* Adjust according to sidebar width */
    padding: 20px;
}
/*DashBoard*/
:root {
    --numDays: 5;
    --numHours: 10;
    --timeHeight: 60px;
    --calBgColor: #fff1f8;
    --eventBorderColor: #f2d3d8;
    --eventColor1: #ffd6d1;
    --eventColor2: #fafaa3;
    --eventColor3: #e2f8ff;
    --eventColor4: #d1ffe6;
  }
  
  .calendar {
    display: grid;
    gap: 10px;
    grid-template-columns: auto 1fr;
    margin: 2rem;
  }
  
  .timeline {
    display: grid;
    grid-template-rows: repeat(var(--numHours), var(--timeHeight));
  }
  
  .days {
    display: grid;
    grid-column: 2;
    gap: 5px;
    grid-template-columns: repeat(auto-fit, minmax(150px, 1fr));
  }
  
  .events {
    display: grid;
    grid-template-rows: repeat(var(--numHours), var(--timeHeight));
    border-radius: 5px;
    background: var(--calBgColor);
  }
  
  
  .start-10 {
    grid-row-start: 2;
  }
  
  .start-12 {
    grid-row-start: 4;
  }
  
  .start-1 {
    grid-row-start: 5;
  }
  
  .start-2 {
    grid-row-start: 6;
  }
  
  .end-12 {
    grid-row-end: 4;
  }
  
  .end-1 {
    grid-row-end: 5;
  }
  
  .end-3 {
    grid-row-end: 7;
  }
  
  .end-4 {
    grid-row-end: 8;
  }
  
  .end-5 {
    grid-row-end: 9;
  }
  
  
  
  .title {
    font-weight: 600;
    margin-bottom: 0.25rem;
  }
  
  .event {
    border: 1px solid var(--eventBorderColor);
    border-radius: 5px;
    padding: 0.5rem;
    margin: 0 0.5rem;
    background: white;
  }
  
  .space,
  .date {
    height: 60px
  }
  

  
  body {
    font-family: system-ui, sans-serif;
  }
  
  .corp-fi {
    background: var(--eventColor1);
  }
  
  .ent-law {
    background: var(--eventColor2);
  }
  
  .writing {
    background: var(--eventColor3);
  }
  
  .securities {
    background: var(--eventColor4);
  }
  
  .date {
    display: flex;
    gap: 1em;
  }
  
  .date-num {
    font-size: 3rem;
    font-weight: 600;
    display: inline;
  }
  
  .date-day {
    display: inline;
    font-size: 3rem;
    font-weight: 100;
  }
  .vh-100 {
    height: 100vh;
}
.vertical-nav {
    width: 200px;
    height: 100%;
    position: fixed;
    top: 56px; /* height of the top navbar */
    left: 0;
    padding-top: 20px;
}
    </style>
</head>
<body>
    <!--Top Horizontal NavBar-->
    <nav class="navbar navbar-expand-lg navbar-light  fixed-top" style="background-color: #0092CA;">
        <a class="navbar-brand" href="#">
            <img src="asserts/images/site-logo.png" height="60px" width="70px" alt="Logo">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="languageDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Language
                    </a>
                    <div class="dropdown-menu" aria-labelledby="languageDropdown">
                        <a class="dropdown-item" href="#">English</a>
                        <a class="dropdown-item" href="#">Spanish</a>
                        <a class="dropdown-item" href="#">French</a>
                    </div>
                </li>
                <li class="nav-item pt-1 pl-3">
                    <div class="dropdown d-flex">
                        <a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img src="asserts/images/person.svg" class="rounded-circle pr-1" alt="Profile Image">
                        </a>
                        <h6 class="pt-1"><%=session.getAttribute("username")%></h6>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <a class="dropdown-item" href="SLogOut">Log Out</a>
                        </div>
                    </div>
                    <!--<a class="nav-link" href="#">
                        <img src="asserts/images/person.svg" class="img-lg rounded-circle" style="border: 1px solid black;">
                        SHIVASANKARAN R L
                    </a>-->
                </li>
            </ul>
        </div>
    </nav>
    


    <div class="container-fluid">
        <div class="row">
           <!-- Vertical Navigation Bar -->
    <div class="bg-dark text-light vh-100 vertical-nav">
        <div class="nav flex-column p-1">
           <a href="DashBoard" class="nav-item nav-link text-light pb-2 pt-5">Dashboard</a>
            <a href="courses" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>  
            <a href="Profile" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>
             <a href="Results" class="nav-item nav-link text-light pb-2 pt-4">Results</a>
            <a href="Chatting" class="nav-item nav-link text-light pb-2 pt-4">Messages</a>
        </div>
    </div>
    <div class="p-5"></div>

            <main role="main" class="col-md-10 ml-sm-auto col-lg-10 px-4" style="padding-top: 8%;">
                <div class="row">
                    <!-- User Info Card -->
                    <div class="col-sm-4">
                        <div class="card d-flex">
                        <%@page import="com.spring.model.Students" %>
                            <div class="card-body text-center">
                                <img src="asserts/images/Andrea(2).jpg" height="250px" width="250px"  class="img-thumbnail  mb-3" alt="User Image">
                                <h5 class="card-title"><%= ((Students)session.getAttribute("user")).getFirstname() %></h5>
                                <h6 class="card-text">Computer Science</h6>
                            </div>
                            <div class="card-body text-center d-inline ml-5" style="margin-left: 10%;">
                                <p class="text-center pr-5">Register Number : 20S140</p>
                                <p class="text-center pr-5">Degree : B.E - CST</p>
                                <p class="text-center pr-5">Batch : 2024</p>
                                <p class="text-center pr-5">College : Karpagam University</p>
                            </div>
                        </div>
                    </div>
                    <div class="card mt-0">
                            <div class="card-body">
                                <h5 class="card-title">Notifications</h5>
                                <ul class="list-unstyled">
                                    <li class="media">
            <div class="media-body">
                <h6 class="mt-0 mb-1">Assignment Due</h6>
                Data Structures assignment due tomorrow.
            </div>
        </li>
        <li class="media mt-2">
            <div class="media-body">
                <h6 class="mt-0 mb-1">Exam Schedule</h6>
                Mid-term exams start next week.
            </div>
        </li>
        <li class="media mt-2">
            <div class="media-body">
                <h6 class="mt-0 mb-1">New Course Material</h6>
                New lecture notes available for Algorithms course.
            </div>
        </li>
        <li class="media mt-2">
            <div class="media-body">
                <h6 class="mt-0 mb-1">Lab Session</h6>
                Don't forget to submit your lab reports by Friday.
            </div>
        </li>
        <li class="media mt-2">
            <div class="media-body">
                <h6 class="mt-0 mb-1">Group Project</h6>
                Meet your group members for the project discussion.
            </div>
        </li>
        
        <li class="media mt-2">
            <div class="media-body">
                <h6 class="mt-0 mb-1">Library Books Due</h6>
                Return borrowed library books by next Monday to avoid fines.
            </div>
        </li>
        <li class="media mt-2">
            <div class="media-body">
                <h6 class="mt-0 mb-1">Club Meeting</h6>
                Attend the Coding Club meeting this Thursday evening.
            </div>
        </li>
                                </ul>
                            </div>
                        </div>
                    <!-- Main Content -->
                    <div class="col-md-12 p-2">
                        <div class="card mb-3">
                            <div class="card-body">
                                <h5 class="card-title">Solved Questions</h5>
                                <div class="d-flex align-items-center">
                                    <div class="circular-progress-bar" style="height: 180px; width: 220px">70%</div>
                                    <div class="progress-bars ml-3 w-100">
                                    <h4>Java</h4>
                                        <div class="progress mb-2">
                                            <div class="progress-bar" role="progressbar" style="width: 70%;" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100">70%</div>
                                        </div>
                                        <h4>Go lang</h4>
                                        <div class="progress mb-2">
                                            <div class="progress-bar" role="progressbar" style="width: 50%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100">50%</div>
                                        </div>
                                        <h4>C</h4>
                                        <div class="progress">
                                            <div class="progress-bar" role="progressbar" style="width: 90%;" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100">90%</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="card mb-3">
                            <div class="card-body">
                                <h5 class="card-title">Task List</h5>
                                <ul class="list-group">
                                    <li class="list-group-item d-flex justify-content-between align-items-center">
                                        Complete Project Report
                                        <span class="badge badge-primary badge-pill">Pending</span>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center">
                                        Prepare for Presentation
                                        <span class="badge badge-success badge-pill">Completed</span>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center">
                                        Group Study Session
                                        <span class="badge badge-warning badge-pill">Upcoming</span>
                                    </li>
                                </ul>
                            </div>
                        </div>
                        <div class="d-flex">
                        <div class="card p-2 " style="width: 35rem;">
                            <div class="card-body">
                              <h5 class="card-title text-center pb-3" style="font-size:25px;font-weight:normal">Coding</h5>
                              <div class="d-inline">
                              <div class="d-flex ">
                              <h4 class="card-title  pr-5" style="font-weight: normal;">Questions Attended</h4>
                              <h3 class="h3 pb-2 ml-5">224</h3>
                              </div>
                              <div class="d-flex ">
                                <h4 class="card-title  pr-5" style="font-weight: normal;">Solved Correctly</h4>
                                <h3 class="h3 pb-2 pl-5  text-success ml-5">34</h3>
                                </div>
                                <div class="d-flex ">
                                    <h4 class="card-title  pr-5" style="font-weight: normal;">Solved Correctly</h4>
                                    <h3 class="h3 pb-2 pl-5  text-primary ml-5">334</h3>
                                </div>
                              </div>
                            </div>
                    </div>
                    <div class="card p-2 pl-2" style="width: 35rem;">
                        <div class="card-body">
                          <h5 class="card-title text-center pb-3 " style="font-size:25px;font-weight:normal">Project</h5>
                          <div class="d-inline">
                          <div class="d-flex ">
                          <h4 class="card-title pr-5" style="font-weight: normal;">Questions Attended</h4>
                          <h3 class="h3 pb-2 ml-5">224</h3>
                          </div>
                          <div class="d-flex ">
                            <h4 class="card-title" style="font-weight: normal;">Solved Correctly</h4>
                            <h3 class="h3 pb-2 pl-5  text-success ml-5">34</h3>
                            </div>
                            <div class="d-flex ">
                                <h4 class="card-title" style="font-weight: normal;">Solved Correctly</h4>
                                <h3 class="h3 pb-2 pl-5  text-primary ml-5">334</h3>
                            </div>
                          </div>
                        </div>
                      </div>
                      <div class="card p-2 pl-2" style="width: 35rem;">
                        <div class="card-body">
                          <h5 class="card-title text-center pb-3" style="font-size:25px;font-weight:normal">MCQ</h5>
                          <div class="d-inline">
                          <div class="d-flex ">
                          <h4 class="card-title  pr-5" style="font-weight: normal;">Questions Attended</h4>
                          <h3 class="h3 pb-2 ml-5">224</h3>
                          </div>
                          <div class="d-flex ">
                            <h4 class="card-title  pr-5" style="font-weight: normal;">Solved Correctly</h4>
                            <h3 class="h3 pb-2 pl-5  text-success ml-5">34</h3>
                            </div>
                            <div class="d-flex ">
                                <h4 class="card-title  pr-5" style="font-weight: normal;">Solved Correctly</h4>
                                <h3 class="h3 pb-2 pl-5  text-primary ml-5">334</h3>
                            </div>
                          </div>
                        </div>
                     </div>
                    </div>
                    </div>
                </div>
                    <!-- Calendar and Image Card -->
                     
                            
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        // Placeholder for calendar functionality
        document.getElementById('calendar').innerHTML = '<p>Calendar goes here</p>';
    </script>
</body>
</html>
    