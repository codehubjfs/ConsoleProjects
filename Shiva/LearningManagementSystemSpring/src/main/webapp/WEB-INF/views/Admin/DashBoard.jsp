<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="asserts/js/index.js"></script>
    <style>
        .card img{
            cursor: pointer;
            transition: transform 0.2s;
        }
        .card img:hover {
            transform: scale(1.02);
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            animation: shake 0.5s;
            animation-iteration-count:calc();
        }
        @keyframes shake {
            0% { transform: translate(1px, 1px) rotate(0deg); }
            10% { transform: translate(-1px, -2px) rotate(-1deg); }
            20% { transform: translate(-3px, 0px) rotate(1deg); }
            30% { transform: translate(3px, 2px) rotate(0deg); }
            40% { transform: translate(1px, -1px) rotate(1deg); }
            50% { transform: translate(-1px, 2px) rotate(-1deg); }
            60% { transform: translate(-3px, 1px) rotate(0deg); }
            70% { transform: translate(3px, 1px) rotate(-1deg); }
            80% { transform: translate(-1px, -1px) rotate(1deg); }
            90% { transform: translate(1px, 2px) rotate(0deg); }
            100% { transform: translate(1px, -2px) rotate(-1deg); }
          }
        .stat-card {
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
            border-radius: 8px;
            background: #f8f9fa;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            text-align: center;
            margin: 10px;
        }
        .stat-card i {
            font-size: 2rem;
            margin-right: 10px;
        }
        .stat-card .stat-info {
            display: flex;
            flex-direction: column;
        }
        .stat-card .stat-info .stat-number {
            font-size: 1.5rem;
            font-weight: bold;
        }
        .stat-card .stat-info .stat-label {
            font-size: 1rem;
            color: #6c757d;
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
            padding-bottom: 20px;
        }
        .main-content {
            margin-left: 220px; /* width of the vertical navbar + padding */
            padding-top: 20px;
        }
    </style>
</head>
<body>
    <!-- Top Horizontal Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light  fixed-top" style="background-color: #0092CA;">
        <a class="navbar-brand" href="#">
            <img src="asserts/images/site-logo.png" height="50px" width="70px" alt="Logo">
        </a>
        <h1><i>CHECKMATE</i></h1>
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
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <img src="asserts/images/person.svg" class="img-lg rounded-circle" style="border: 1px solid black;">
                        <%= session.getAttribute("username") %>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
    

    <!-- Vertical Navigation Bar -->
    <div class="bg-dark text-light vh-100 vertical-nav">
        <div class="nav flex-column pt-4">
         <a href="dash" class="nav-item nav-link text-light pb-2 pt-4">DashBoard</a>
                    <a href="redirectCourses" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>
                    <a href="users" class="nav-item nav-link text-light pb-2 pt-4">User Management</a>    
                   <!-- <a href="Profile.jsp" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>-->
                   
        </div>
    </div>
    <%@page import="com.spring.model.Student,com.spring.model.Instructor,com.spring.model.Courses,java.util.*" %>
    <div class="main-content">
        <div class="container mt-5 pt-4">
            <div class="row">
                <div class="col-md-3 shadow-lg p-3 pl-4 mb-5 bg-white rounded">
                    <div class="stat-card">
                        <i class="fas fa-user-graduate"></i>
                        <div class="stat-info">
                            <div class="stat-number"><%=((List<Student>) session.getAttribute("sList")).size() %></div>
                            <div class="stat-label">Students</div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 shadow-lg p-3 mb-5 bg-white rounded">
                    <div class="stat-card">
                        <i class="fas fa-chalkboard-teacher"></i>
                        <div class="stat-info">
                            <div class="stat-number"><%=((List<Instructor>) session.getAttribute("instructorList")).size() %></div>
                            <div class="stat-label">Teachers</div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 shadow-lg p-3 mb-5 bg-white rounded">
                    <div class="stat-card">
                        <i class="fas fa-book"></i>
                        <div class="stat-info">
                            <div class="stat-number"><%= ((List<Courses>) session.getAttribute("coursesL")).size() %></div>
                            <div class="stat-label">Courses</div>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 shadow-lg p-3 mb-5 bg-white rounded">
                    <div class="stat-card">
                        <i class="fas fa-book"></i>
                        <div class="stat-info">
                            <div class="stat-number"><%= ((List<Courses>) session.getAttribute("coursesL")).size() %></div>
                            <div class="stat-label">Top Selling Courses</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <h2 class="p-2 text-center">Top Students</h2>
        <div class="d-flex p-2">
            <a href="Student.html" class="pl-2 pr-3">
            <div class="card">
                <div class="card-body">
                    <div class="card-title">
                        <img src="asserts/images/olly.jpg" height="200px" width="250px">
                    </div>
                    <% List<Student> courList=((List<Student>) session.getAttribute("sList")); %>
                    <h6 class="text-center">Muniyamma</h6>
                    <h6 class="text-center">Computer Science</h6>
                </div>
            </div>
            </a>
            <a href="Student.html"  class="pl-2 pr-3">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">
                            <img src="asserts/images/asim.jpg" height="200px" width="250px">
                        </div>
                        <h6 class="text-center">Json Todd</h6>
                        <h6 class="text-center">Information Technology</h6>
                    </div>
                </div>
            </a>
            <a href="Student.html"  class="pl-2 pr-3">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">
                            <img src="asserts/images/wasim-akram.jpg" height="200px" width="250px">
                        </div>
                        <h6 class="text-center">Robert Bosch</h6>
                        <h6 class="text-center">Computer Science And Technology</h6>
                    </div>
                </div>
            </a>
            <a href="Student.html"  class="pl-2 pr-3">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">
                            <img src="asserts/images/Andrea.jpg" height="200px" width="250px">
                        </div>
                        <h6 class="text-center">Andrea</h6>
                        <h6 class="text-center">Computer Science</h6>
                    </div>
                </div>
            </a>
        </div>
        <h2 class="p-2 text-center">Top Teachers</h2>
        <div class="d-flex p-2">
            <a href="Student.html" class="pl-2 pr-3">
            <div class="card">
                <div class="card-body">
                    <div class="card-title">
                        <img src="asserts/images/Andrea(2).jpg" height="200px" width="250px">
                    </div>
                    <h6 class="text-center">Andrea</h6>
                    <h6 class="text-center">Computer Science</h6>
                    <!--<h5 class="text-center">🌟🌟🌟🌟🌟</h5>-->
                </div>
            </div>
            </a>
            <a href="Student.html"  class="pl-2 pr-3">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">
                            <img src="asserts/images/asim.jpg" height="200px" width="250px">
                        </div>
                        <h6 class="text-center">Json Todd</h6>
                        <h6 class="text-center">Information Technology</h6>
                        <!--<h5 class="text-center">🌟🌟🌟🌟🌟</h5>-->
                    </div>
                </div>
            </a>
            <a href="Student.html"  class="pl-2 pr-3">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">
                            <img src="asserts/images/wasim-akram.jpg" height="200px" width="250px">
                        </div>
                        <h6 class="text-center">Robert Bosch</h6>
                        <h6 class="text-center">Computer Science And Technology</h6>
                        <!--<h5 class="text-center">🌟🌟🌟🌟🌟</h5>-->
                    </div>
                </div>
            </a>
            <a href="Student.html"  class="pl-2 pr-3">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">
                            <img src="asserts/images/Andrea.jpg" height="200px" width="250px">
                        </div>
                        <h6 class="text-center">Andrea</h6>
                        <h6 class="text-center">Computer Science</h6>
                        <h5 class="text-center">🌟🌟🌟🌟🌟</h5>
                    </div>
                </div>
            </a>
        </div>
        <div class="d-flex">
            <!--<div class="sidebar">
                <h4 class="text-center">Admin Dashboard</h4>
                <a href="#overview">Overview</a>
                <a href="#graphs">Graphs</a>
                <a href="#top-instructors">Top Instructors</a>
                <a href="#student-rank-list">Student Rank List</a>
            </div>-->
            <div class="content flex-grow-1">
                <div id="graphs">
                    <h2></h2>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Enrollment Statistics</h5>
                                    <canvas id="enrollmentChart" width="400" height="200"></canvas>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title">Performance Metrics</h5>
                                    <canvas id="performanceChart" width="400" height="200"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                
            </div>
        </div>
    
        </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        var ctx1 = document.getElementById('enrollmentChart').getContext('2d');
        var enrollmentChart = new Chart(ctx1, {
            type: 'bar',
            data: {
                labels: ['Jan', 'Feb'],
                datasets: [{
                    label: 'Enrollments',
                    data: [12, 19],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });

        var ctx2 = document.getElementById('performanceChart').getContext('2d');
        var performanceChart = new Chart(ctx2, {
            type: 'line',
            data: {
                labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun'],
                datasets: [{
                    label: 'Performance',
                    data: [65, 59, 80, 81, 56, 55],
                    fill: false,
                    borderColor: 'rgb(75, 192, 192)',
                    tension: 0.1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });
    </script>
    
        
        </body>
        </html>
        <footer class="bg-dark text-white text-center py-4">
            <p>&copy; 2024 LMS. All rights reserved.</p>
          </footer>
</body>
</html>
    