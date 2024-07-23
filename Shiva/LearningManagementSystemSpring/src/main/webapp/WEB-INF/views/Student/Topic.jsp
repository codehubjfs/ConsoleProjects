<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<style>
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
    .main-content {
        margin-left: 220px; /* width of the vertical navbar + padding */
        padding-top: 20px;
    }
    .gradient-rectangle {
        width: 80%;
        height: 200px; /* Adjust the height as needed */
        background: rgb(2,0,36);
        background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 35%, rgba(0,212,255,1) 100%);
        margin: 0 auto; /* Center the rectangle horizontally */
    }
    .sidebar {
        height: 100vh;
        background: #f8f9fa;
        overflow-y: auto;
    }
    .content {
        padding: 20px;
    }
    .collapse-content {
        display: none;
    }
</style>
<body>
    <!-- Top Horizontal Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" style="background-color: #0092CA;">
        <a class="navbar-brand" href="#">
            <img src="asserts/images/site-logo.png" height="60px" width="70px" alt="Logo">
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
                <li class="nav-item pt-1 pl-3">
                    <div class="dropdown d-flex">
                        <a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img src="asserts/images/person.svg" class="rounded-circle pr-1" alt="Profile Image">
                        </a>
                        <h6 class="pt-1">SHIVASANKARAN R L</h6>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <a class="dropdown-item" href="SLogOut">Log Out</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Vertical Navigation Bar -->
    <div class="bg-dark text-light vh-100 vertical-nav">
        <div class="nav flex-column">
          <a href="DashBoard" class="nav-item nav-link text-light pb-2 pt-5">Dashboard</a>
            <a href="courses" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>  
            <a href="Profile" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>
             <a href="Results" class="nav-item nav-link text-light pb-2 pt-4">Results</a>
            <a href="Chatting" class="nav-item nav-link text-light pb-2 pt-4">Messages</a>
        </div>
    </div>

    <div class="container fixed pt-2 mt-5">
        <div class="container-fluid pt-5 pl-5" style="padding-top: 20%;">
        <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="courses">Courses</a></li>
                            <li class="breadcrumb-item"><a href="topicToModule">Modules</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Topic</li>
                        </ol>
                    </nav>
            <div class="row">
                <div class="col-md-3 sidebar">
                    <h1 class="pb-1">Topics-<%= session.getAttribute("moduleName") %></h1>
                    <%@ page import="java.util.*,com.spring.model.AssessmentBean" %>
                    <%@ page import="java.util.*,com.spring.model.TopicsBean" %>
                    <% ArrayList<TopicsBean> topicList = (ArrayList<TopicsBean>) request.getAttribute("topicList"); 
                       List<AssessmentBean> assessmentList=(List<AssessmentBean>) request.getAttribute("assessmentList");
                    %>
                    <div id="accordion">
                        <% for (TopicsBean m : topicList) { %>
                            <div class="card">
                                <div class="card-header" id="heading<%= m.getTopicId() %>">
                                    <h5 class="mb-0">
                                        <div class="d-flex mx-auto">
                                            <button class="btn btn-link" data-toggle="collapse" data-target="#collapse<%= m.getTopicId() %>" aria-expanded="true" aria-controls="collapse<%= m.getTopicId() %>" style="padding-right: 30%;">
                                                <%= m.getTopicName() %>
                                            </button>
                                        </div>
                                    </h5>
                                </div>
                                <div id="collapse<%= m.getTopicId() %>" class="collapse" aria-labelledby="heading<%= m.getTopicId() %>" data-parent="#accordion">
                                    <div class="card-body">
                                        <img src="asserts/images/file-text.svg" class="pr-1"><a href="#" class="collapse-option" data-target="#topic1-content2">PDF
                                            <div class="float-right"></div>
                                        </a><br>
                                        <img src="asserts/images/camera-video.svg" class="pr-1"><a href="#" class="collapse-option" data-target="#topic1-content3">Video
                                            <div class="float-right"></div>
                                        </a><br>
                                        <%@ page import="jakarta.servlet.RequestDispatcher" %>
                                        <%@ page import="jakarta.servlet.ServletException" %>
                                        <%@ page import="jakarta.servlet.annotation.WebServlet" %>      
                                        <%@ page import="jakarta.servlet.http.HttpServlet" %>
                                        <%@ page import="jakarta.servlet.http.HttpServletRequest" %>
                                        <%@ page import="jakarta.servlet.http.HttpServletResponse" %>
                                        <%@ page import="jakarta.servlet.http.HttpSession" %>
                                        <%@ page import="java.io.IOException" %>
                                        <%@ page import="java.sql.SQLException" %>
                                        <%@ page import="java.util.ArrayList" %>
                                        <%@ page import="com.spring.model.AssessmentBean" %>
                                        <%@ page import="com.spring.service.StudentService" %>
                                       <%
                            		//List<AssessmentBean> assessmentsList=StudentService.studentViewAssessments(m);
                                     List<AssessmentBean>assessmentsList=assessmentList.stream().filter(x->x.getTopicId()==m.getTopicId()).toList();
                            		System.out.println("assessment list "+assessmentList); 
                            		%>
                                        <% for (AssessmentBean a : assessmentsList) { %>
                                           <img src="asserts/images/pencil-square.svg" class="pr-1"> <a href="#" class="collapse-option assessment-link" data-target="#topic1-content1" data-assessment-id="<%= a.getAssessmentId() %>"><%= a.getAssessmentName() %>
                                                <div class="float-right"></div>
                                            </a><br>
                                        <% } %>
                                    </div>
                                </div>
                            </div>
                        <% } %>
                    </div>
                </div>
                <div class="col-md-9 content">
                    <h2>Welcome to Checkmate</h2>
                    <p>
                        Checkmate is an innovative learning platform designed to help students achieve their academic goals through a variety of interactive and engaging resources. Our platform offers:
                    </p>
                    <ul>
                        <li><strong>Comprehensive Courses:</strong> Explore a wide range of courses that cover different subjects and topics, all designed to provide in-depth knowledge and understanding.</li>
                        <li><strong>Interactive Modules:</strong> Engage with interactive modules that make learning more fun and effective, including quizzes, videos, and PDF resources.</li>
                        <li><strong>Personalized Learning:</strong> Tailor your learning experience to your needs with personalized assessments and feedback that help you identify areas for improvement.</li>
                        <li><strong>Community Support:</strong> Connect with peers and instructors through our messaging system and discussion forums to get help and share knowledge.</li>
                        <li><strong>Progress Tracking:</strong> Keep track of your learning progress with detailed analytics and reports that show your strengths and areas that need more focus.</li>
                    </ul>
                    <p>
                        We are committed to providing a supportive and enriching learning environment that empowers you to succeed. Start your learning journey with Checkmate today!
                    </p>
                    <div id="topic1-content1" class="collapse-content">
                        <h3>Quizzes</h3>
                        <div class="card">
                            <div class="card-body">
                                <h5 class="card-title">Take Test - Topic 1</h5>
                                <p class="card-text">This is a test for Topic 1. Please take the test to proceed.</p>
                                <div class="rules">
                                    <h4>Guidelines:</h4>
                                    <ol>
                                        <li>Ensure you have a stable internet connection.</li>
                                        <li>Do not open any other tabs or applications during the test.</li>
                                        <li>Answer all questions within the allocated time.</li>
                                        <li>Do not communicate with others during the test.</li>
                                        <li>Submit your answers before the timer expires.</li>
                                    </ol>
                                </div>
                                <div class="action">
                                    <h4>Disciplinary Actions for Violations:</h4>
                                    <p>Violations of the guidelines may result in the following actions:</p>
                                    <ul>
                                        <li>Warning or disqualification from the test.</li>
                                        <li>Loss of test privileges for future assessments.</li>
                                        <li>Academic penalties as per institution policy.</li>
                                        <li>Investigation and potential academic misconduct report.</li>
                                    </ul>
                                </div>
                                <a href="" id="testid" class="btn btn-primary">Take Test</a>
                            </div>
                        </div>
                    </div>
                    <div id="topic1-content2" class="collapse-content">
                        <!--<h3>PDF</h3>
                        <p>This is the content for PDF.</p>-->
                        <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">PDF - Topic 1</h5>
                            <a href="Lorem_ipsum.pdf"><p class="card-text">This is a PDF for Topic 1.</p></a>
                            <a href="views/student/Lorem_ipsum.pdf" class="btn btn-primary" target="_blank" download="">View PDF</a>
                        </div>
                    </div>
                    </div>
                    <div id="topic1-content3" class="collapse-content">
                        <!-- <h3>Video</h3>
                        <p>This is the content for video.</p>-->
                        <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Video Content</h5>
                            <p class="card-text">Subjected to copyright</p>
                            <video width="100%" controls>
                                <source src="asserts/images/Ptutorial.mp4" type="video/mp4">
                                Your browser does not support the video tag.
                            </video>
                        </div>
                    </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script>
        document.querySelectorAll('.collapse-option').forEach(option => {
            option.addEventListener('click', function (event) {
                event.preventDefault();
                const targetId = option.getAttribute('data-target');
                document.querySelectorAll('.collapse-content').forEach(content => {
                    content.style.display = 'none';
                });
                document.querySelector(targetId).style.display = 'block';
            });
        });

        document.querySelectorAll('.assessment-link').forEach(link => {
            link.addEventListener('click', function () {
                const assessmentId = link.getAttribute('data-assessment-id');
                const testLink = document.getElementById('testid');
                testLink.href = 'test?assessmentId=' + assessmentId;
            });
        });
    </script>
</body>
</html>
