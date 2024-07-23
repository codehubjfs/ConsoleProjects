<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .dropdown-menu a{
                padding: 10px;
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
            .main-content {
                margin-left: 220px; /* width of the vertical navbar + padding */
                padding-top: 20px;
            }
    </style>
    <link rel="stylesheet" href="../../asserts/css/Courses.css">
</head>
<body>
    <!-- Top Horizontal Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light  fixed-top" style="background-color: #0092CA;">
        <a class="navbar-brand" href="#">
            <img src="asserts/images/site-logo.png" height="55px" width="70px" alt="Logo">
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
                    <!--<a class="nav-link" href="#">
                        <img src="asserts/images/person.svg" class="img-lg rounded-circle" style="border: 1px solid black;">
                        SHIVASANKARAN R L
                    </a>-->
                </li>
            </ul>
        </div>
    </nav>
    

    <!-- Vertical Navigation Bar -->
    <div class="bg-dark text-light vh-100 vertical-nav"  style="color: darkblue;">
        <div class="nav flex-column p-1">
        <a href="DashBoard" class="nav-item nav-link text-light pb-2 pt-5">Dashboard</a>
            <a href="courses" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>  
            <a href="Profile" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>
             <a href="Results" class="nav-item nav-link text-light pb-2 pt-4">Results</a>
            <a href="Chatting" class="nav-item nav-link text-light pb-2 pt-4">Messages</a>
        </div>
    </div>
    <div class="p-5"> 	
    <main role="main" class="container mt-4 col-md-9 ml-sm-auto col-lg-10 pl-5 pt-3">   
    <%@page import="java.util.*,com.spring.model.ModulesBean" %> 
    <h1 class="header">Modules-<%= session.getAttribute("coursename") %> </h1>   
    <nav aria-label="breadcrumb">
	                    <ol class="breadcrumb">
	                      <li class="breadcrumb-item"><a href="courses">Courses</a></li>
	                      <li class="breadcrumb-item"><a href="#">Modules</a></li>
	                    </ol>
	                  </nav>  
    <div class="row row-cols-1 row-cols-md-2 row-cols-lg-3 g-4">
        <!--<div class="col p-3">
            <div class="card shadow-sm p-3 d-flex" style="display: flex;">    
                <div class="card-body">
                    <img src="asserts/images/book-half (1).svg" height="50px" width="50px" class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                    <h5 class="text-center pb-1">Java</h5>
                    <div class="progress pb-1">
                        <div class="progress-bar" role="progressbar" style="width: 45%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <div class="d-flex"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">14 Assessments</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">13 Assignments</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex pb-3"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">10 AUG 2025</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex pl-3">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">1 JUN 2026</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex" style="margin-left: 30%;">
                        <a href="../Topics.html/Topic_Module_1.html" class="btn btn-primary">View Topics</a>    
                    </div>
                </div>
            </div>
        </div>-->
        <!--<div class="col p-3">
            <div class="card shadow-sm p-3 d-flex" style="display: flex;">    
                <div class="card-body">
                    <img src="asserts/images/book-half (1).svg" height="50px" width="50px" class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                    <h5 class="text-center pb-1">Java</h5>
                    <div class="progress pb-1">
                        <div class="progress-bar" role="progressbar" style="width: 45%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <div class="d-flex"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">14 Assessments</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">13 Assignments</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex pb-3"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">10 AUG 2025</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex pl-3">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">1 JUN 2026</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex" style="margin-left: 30%;">
                        <a href="../Topics.html/Topic_Module_1.html" class="btn btn-primary">View Topics</a>    
                    </div>
                </div>
            </div>
        </div>
        <div class="col p-3">
            <div class="card shadow-sm p-3 d-flex" style="display: flex;">    
                <div class="card-body">
                    <img src="asserts/images/book-half (1).svg" height="50px" width="50px" class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                    <h5 class="text-center pb-1">Java</h5>
                    <div class="progress pb-1">
                        <div class="progress-bar" role="progressbar" style="width: 45%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <div class="d-flex"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">14 Assessments</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">13 Assignments</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex pb-3"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">10 AUG 2025</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex pl-3">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">1 JUN 2026</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex" style="margin-left: 30%;">
                        <a href="../Topics.html/Topic_Module_1.html" class="btn btn-primary">View Topics</a>    
                    </div>
                </div>
            </div>
        </div>
        <div class="col p-3">
            <div class="card shadow-sm p-3 d-flex" style="display: flex;">    
                <div class="card-body">
                    <img src="asserts/images/book-half (1).svg" height="50px" width="50px" class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                    <h5 class="text-center pb-1">Java</h5>
                    <div class="progress pb-1">
                        <div class="progress-bar" role="progressbar" style="width: 45%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <div class="d-flex"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">14 Assessments</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">13 Assignments</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex pb-3"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">10 AUG 2025</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex pl-3">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">1 JUN 2026</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex" style="margin-left: 30%;">
                        <a href="../Topics.html/Topic_Module_1.html" class="btn btn-primary">View Topics</a>    
                    </div>
                </div>
            </div>
        </div>
        <div class="col p-3">
            <div class="card shadow-sm p-3 d-flex" style="display: flex;">    
                <div class="card-body">
                    <img src="asserts/images/book-half (1).svg" height="50px" width="50px" class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                    <h5 class="text-center pb-1">Java</h5>
                    <div class="progress pb-1">
                        <div class="progress-bar" role="progressbar" style="width: 45%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <div class="d-flex"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">14 Assessments</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">13 Assignments</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex pb-3"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">10 AUG 2025</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex pl-3">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">1 JUN 2026</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex" style="margin-left: 30%;">
                        <a href="../Topics.html/Topic_Module_1.html" class="btn btn-primary">View Topics</a>    
                    </div>
                </div>
            </div>
        </div>
        <div class="col p-3">
            <div class="card shadow-sm p-3 d-flex" style="display: flex;">    
                <div class="card-body">
                    <img src="asserts/images/book-half (1).svg" height="50px" width="50px" class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                    <h5 class="text-center pb-1">Java</h5>
                    <div class="progress pb-1">
                        <div class="progress-bar" role="progressbar" style="width: 45%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <div class="d-flex"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">14 Assessments</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">13 Assignments</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex pb-3"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">10 AUG 2025</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex pl-3">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">1 JUN 2026</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex" style="margin-left: 30%;">
                        <a href="../Topics.html/Topic_Module_1.html" class="btn btn-primary">View Topics</a>    
                    </div>
                </div>
            </div>
        </div>
        <div class="col p-3">
            <div class="card shadow-sm p-3 d-flex" style="display: flex;">    
                <div class="card-body">
                    <img src="asserts/images/book-half (1).svg" height="50px" width="50px" class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                    <h5 class="text-center pb-1">Java</h5>
                    <div class="progress pb-1">
                        <div class="progress-bar" role="progressbar" style="width: 45%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                    </div>
                    <div class="d-flex"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">14 Assessments</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex">
                                <img src="asserts/images/file-text.svg" class="pr-1">
                                <p class="text pt-3">13 Assignments</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex pb-3"> 
                        <a href="#" class="pr-2">
                            <div class="d-flex">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">10 AUG 2025</p>
                            </div>
                        </a>
                        <a href="#">
                            <div class="d-flex pl-3">
                                <img src="asserts/images/calendar-date.svg" class="pr-1">
                                <p class="text pt-3">1 JUN 2026</p>
                            </div>
                        </a>
                    </div>
                    <div class="d-flex" style="margin-left: 30%;">
                        <a href="../Topics.html/Topic_Module_1.html" class="btn btn-primary">View Topics</a>    
                    </div>
                </div>
            </div>
        </div>-->
        <%ArrayList <ModulesBean> moduleList=(ArrayList<ModulesBean>) request.getAttribute("moduleList");%>
        <%
        for(ModulesBean m:moduleList)
                {%>
                	<div class="col-sm-4 p-3">
                    <div id="card" class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">
                        <div class="card-body">
                            <img src="asserts/images/book-half (1).svg" height="50px" width="50px" class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                            <h5 class="text-center pb-1"><%= m.getModuleName() %></h5>
                            <div class="progress pb-1">
                                <div class="progress-bar" role="progressbar" style="width: 45%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
                            </div>
                            <div class="d-flex">
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                        <img src="asserts/images/file-text.svg" class="pr-1">
                                        <p class="text pt-3">1 Assessments</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex">
                                        <img src="asserts/images/file-text.svg" class="pr-1">
                                        <p class="text pt-3">0 Assignments</p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex pb-3">
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                        <img src="asserts/images/calendar-date.svg" class="pr-1">
                                        <p class="text pt-3"><%= session.getAttribute("startDate") %></p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex pl-3">
                                        <img src="asserts/images/calendar-date.svg" class="pr-1">
                                        <p class="text pt-3"><%= session.getAttribute("endDate") %></p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex" style="margin-left: 30%;">
                                <a href="${pageContext.request.contextPath}/topics?moduleId=<%= m.getModuleId() %>" class="btn btn-primary">View Topics</a>
                                <div class="pr-5"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <% } %>
        
        
    </div>
</main>
    
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script type="text/javascript" src="Scripts/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="Scripts/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</div>
</body>
</html>
