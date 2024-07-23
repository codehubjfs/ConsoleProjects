<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
        <style>
            .dropdown-menu .dropdown-submenu {
                position: relative;
              }
              .dropdown-menu .dropdown-submenu .dropdown-menu {
                top: 0;
                left: 100%;
                margin-top: -1px;
              }
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
    <link rel="stylesheet" href="Courses.css">
</head>
<body>
    <!-- Top Horizontal Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light  fixed-top" style="background-color: #0092CA;">
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
    <div class="p-5">
    <main role="main" class="container mt-4 col-md-9 ml-sm-auto col-lg-10 pl-5 pt-3">  
        <%@page import="java.util.*,com.spring.model.Courses" %>
        
        <h1>Courses</h1>
      
                <div class="row d-flex flex-wrap align-items-stretch">
                    <!-- <div class="col-sm-4 p-3 ">
                        <div class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">    
                            <div class="card-body">
                                <img src="asserts/images/book-half (1).svg" height="50px" width="50px"  class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                                <h5 class="text-center pb-1">Java</h5>
                                <div class="progress pb-1">
                                    <div class="progress-bar" role="progressbar" style="width: 55%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
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
                                <div class="d-flex pb-3 "> 
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">10 AUG 2025</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex pl-3">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">1 JUN 2026 </p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex display-center">
                                <a href="${pageContext.request.contextPath}/ViewModuleController?courseId=<%=31 %>" class="btn btn-primary">View Course</a>    
                                
                                
                                </div>
                            </div>
                        </div>
                    </div>-->
                    
                    <!--<div class="col-sm-4 p-3 ">
                        <div class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">    
                            <div class="card-body">
                                <img src="asserts/images/book-half (1).svg" height="50px" width="50px"  class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                                <h5 class="text-center pb-1">Python</h5>
                                <div class="progress pb-1">
                                    <div class="progress-bar" role="progressbar" style="width: 75%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
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
                                <div class="d-flex pb-3 "> 
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">10 AUG 2025</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex pl-3">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">1 JUN 2026 </p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex display-center">
                                <a href="../Modules/Modules_Course-1_1.html" class="btn btn-primary">View Course</a>    
                                
                                
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 p-3 ">
                        <div class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">    
                            <div class="card-body">
                                <img src="asserts/images/book-half (1).svg" height="50px" width="50px"  class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                                <h5 class="text-center pb-1">JavaScript</h5>
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
                                <div class="d-flex pb-3 "> 
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">10 AUG 2025</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex pl-3">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">1 JUN 2026 </p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex display-center">
                                <a href="../Modules/Modules_Course-1_1.html" class="btn btn-primary">View Course</a>    
                                
                                
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 p-3 ">
                        <div class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">    
                            <div class="card-body">
                                <img src="asserts/images/book-half (1).svg" height="50px" width="50px"  class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                                <h5 class="text-center pb-1">Go Lang</h5>
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
                                <div class="d-flex pb-3 "> 
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">10 AUG 2025</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex pl-3">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">1 JUN 2026 </p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex display-center">
                                <a href="../Modules/Modules_Course-1_1.html" class="btn btn-primary">View Course</a>    
                                
                                
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 p-3 ">
                        <div class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">    
                            <div class="card-body">
                                <img src="asserts/images/book-half (1).svg" height="50px" width="50px"  class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                                <h5 class="text-center pb-1">Rust</h5>
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
                                <div class="d-flex pb-3 "> 
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">10 AUG 2025</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex pl-3">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">1 JUN 2026 </p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex display-center">
                                <a href="../Modules/Modules_Course-1_1.html" class="btn btn-primary">View Course</a>    
                                
                                
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 p-3 ">
                        <div class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">    
                            <div class="card-body">
                                <img src="asserts/images/book-half (1).svg" height="50px" width="50px"  class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
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
                                <div class="d-flex pb-3 "> 
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">10 AUG 2025</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex pl-3">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">1 JUN 2026 </p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex display-center">
                                <a href="../Modules/Modules_Course-1_1.html" class="btn btn-primary">View Course</a>    
                                
                                
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-4 p-3 ">
                        <div class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">    
                            <div class="card-body">
                                <img src="asserts/images/book-half (1).svg" height="50px" width="50px"  class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
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
                                <div class="d-flex pb-3 "> 
                                <a href="#" class="pr-2">
                                    <div class="d-flex">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">10 AUG 2025</p>
                                    </div>
                                </a>
                                <a href="#">
                                    <div class="d-flex pl-3">
                                    <img src="asserts/images/calendar-date.svg" class="pr-1">
                                    <p class="text pt-3">1 JUN 2026 </p>
                                    </div>
                                </a>
                            </div>
                            <div class="d-flex display-center">
                                <a href="../Modules/Modules_Course-1_1.html" class="btn btn-primary">View Course</a>    
                                
                                
                                </div>
                            </div>
                        </div>
                    </div>-->
                    
                    
                    <% ArrayList <Courses> coursesList=(ArrayList<Courses>) request.getAttribute("coursesList");%>
                    
                    <% for(Courses c:coursesList) {%>
                    	 <div class="col-sm-4 p-3 ">
                    	        <div id="card" class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">;
                    	            <div class="card-body">
                    	                <img src="asserts/images/book-half (1).svg" height="50px" width="50px" class="p-1 mb-4 img-responsive card-img float-left" alt="Card Image 1">
                    	                <h5 class="text-center pb-1"><%= c.getCoursename() %></h5>
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
                    	                <div class="d-flex pb-3 ">
                    	                    <a href="#" class="pr-2">
                    	                        <div class="d-flex">
                    	                            <img src="asserts/images/calendar-date.svg" class="pr-1">
                    	                            <p class="text pt-3"><%= c.getStartDate() %></p>
                    	                        </div>
                    	                    </a>
                    	                    <a href="#">
                    	                        <div class="d-flex pl-3">
                    	                            <img src="asserts/images/calendar-date.svg" class="pr-1">
                    	                            <p class="text pt-3"><%= c.getEndDate() %></p>
                    	                        </div>
                    	                    </a>
                    	                </div>
                    	                <div class="d-flex" style="margin-left: 30%;">
                    	                <a href="modules?courseId=<%= c.getCourseId() %>&startDate=<%= c.getStartDate() %>&endDate=<%= c.getEndDate() %>" class="btn btn-primary">View Topics</a>
                    	    <!--             <a href=${pageContext.request.contextPath}/viewStudentCoursesController" class=\"btn btn-primary\">View Course</a>");-->
                    	    <!--//String contextPath = pageContext.getRequest().getContentType();-->
        					<!--//String servletPath = contextPath + "/viewModuleController";-->
        					<!--//<a href=\"" + servletPath + "\" class=\"btn btn-primary\">View Course</a>");-->
                    	    <!--//                <div class=\"pr-5\"></div>");-->
                    	                </div>
                    	            </div>
                    	        </div>
                    	    </div>
                    <%} %>
                   
                    
                </div>
            </main>
            <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h5 class="modal-title" id="editModalLabel">Edit Instructor</h5>
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                      </button>
                    </div>
                    <div class="modal-body">
                      <form id="editForm">
                        <div class="form-group">
                          <label for="editFirstName">Course Name</label>
                          <input type="text" class="form-control" id="editFirstName" required>
                        </div>
                        <div class="form-group">
                          <label for="editLastName">Instructor UserName</label>
                          <input type="text" class="form-control" id="editLastName" required>
                        </div>
                        <div class="form-group">
                          <label for="editDepartment">Department</label>
                          <input type="text" class="form-control" id="editDepartment" required>
                        </div>
                        <div class="form-group">
                          <label for="editAge">Start Date</label>
                          <input type="date" class="form-control" min="1" id="editAge" required>
                        </div>
                        <div class="form-group">
                          <label for="editDateOfJoining">End Date</label>
                          <input type="date" class="form-control" id="editDateOfJoining" required>
                        </div>
                        <input type="hidden" id="editRowIndex">
                      </form>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                      <button type="button" class="btn btn-primary" onclick="saveChanges()">Save changes</button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</div>
<footer class="bg-dark text-white pt-4">
    <div class="container text-center">
      <div class="row">
        <div class="col-md-3">
          <h5>About Us</h5>
          <p>We provide a comprehensive learning management system to help educators and students achieve their learning goals.</p>
        </div>
        <div class="col-md-3">
          <h5>Quick Links</h5>
          <ul class="list-unstyled">
            <li><a href="#" class="text-white">Home</a></li>
            <li><a href="#" class="text-white">Courses</a></li>
            <li><a href="#" class="text-white">Blog</a></li>
            <li><a href="#" class="text-white">Contact Us</a></li>
            <li><a href="#" class="text-white">FAQ</a></li>
          </ul>
        </div>
        <div class="col-md-3">
          <h5>Contact Us</h5>
          <ul class="list-unstyled">
            <li><i class="fas fa-map-marker-alt"></i> 123 LMS Street, Education City</li>
            <li><i class="fas fa-phone"></i> +1 234 567 890</li>
            <li><i class="fas fa-envelope"></i> support@lms.com</li>
          </ul>
        </div>
        <div class="col-md-3">
          <h5>Follow Us</h5>
          <a href="#" class="text-white mr-3"><i class="fab fa-facebook-f"></i></a>
          <a href="#" class="text-white mr-3"><i class="fab fa-twitter"></i></a>
          <a href="#" class="text-white mr-3"><i class="fab fa-linkedin-in"></i></a>
          <a href="#" class="text-white mr-3"><i class="fab fa-instagram"></i></a>
        </div>
      </div>
      <div class="text-center py-3">
        <p>&copy; 2024 LMS. All rights reserved.</p>
      </div>
    </div>
  </footer>

</body>
</html>