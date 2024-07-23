<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
    <link rel="stylesheet" href="Courses.css">
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
                <li class="nav-item pt-1 pl-3">
                    <div class="dropdown d-flex">
                        <a href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <img src="asserts/images/person.svg" class="rounded-circle pr-1" alt="Profile Image">
                        </a>
                        <h6 class="pt-1"><%= session.getAttribute("username") %></h6>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                            <a class="dropdown-item" href="logOut">LogOut</a>
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
            <!-- <a href="index.jsp" class="nav-item nav-link text-light pb-2 pt-5">Dashboard</a>-->
                    <a href="dash" class="nav-item nav-link text-light pb-2 pt-4">DashBoard</a>
                    <a href="redirectCourses" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>
                    <a href="users" class="nav-item nav-link text-light pb-2 pt-4">User Management</a>    
                   <!-- <a href="Profile.jsp" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>-->
                  
        </div>
    </div>
    <div class="p-5">
    <main role="main" class="container mt-4 col-md-9 ml-sm-auto col-lg-10 pl-5 pt-5">      
                <div class="row d-flex flex-wrap align-items-stretch">
                    <a href="viewInstructors">
                    <div class="col-sm-4 p-3 ">
                        <div class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">    
                            <div class="card-body">
                                <img src="asserts/images/person.svg" height="50px" width="50px"  class="p-1 mb-5 img-responsive card-img float-left" alt="Card Image 1">
                               <div class="d-inline ">
                                <h5 class="text-center">Instructors</h5>
                               </div>
                            </div>
                        </div>
                    </div>
                    </a>
                    <a href="viewStudents"> <div class="col-sm-4 p-3 ">
                        <div class="card shadow-sm p-3 d-flex" style="width:350px; display:flex">    
                            <div class="card-body">
                                <img src="asserts/images/person.svg" height="50px" width="50px"  class="p-1 mb-5 img-responsive card-img float-left" alt="Card Image 1">
                               <div class="d-inline ">
                                <h5 class="text-center text-decoration-none">Students</h5>
                               </div>
                            </div>
                        </div>
                    </a>
                    </div>
                </div>
            </main>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</div>
</body>
</html>
    