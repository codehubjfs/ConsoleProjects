<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../../asserts/css/Chatting.css">
    <script src="../../asserts/js/Chatting.js"></script>
</head>

<body>
    <!-- Horizontal Nav Bar -->
    <header class="text-white" style="padding:1%;background-color: #0092CA;">
        <img src="../../asserts/images/site-logo.png" height="50px" width="70px">
        <div class="d-flex float-right pt-2">
            <img src="../../asserts/images/person.svg" alt="Profile Image" class="rounded-circle pr-1 pt-1" height="30px" width="30px">
            <h6 class="ml-3 pt-2">SHIVASANKARAN R L</h6>
        </div>
    </header>

    <div class="container-fluid ">
        <div class="row ">
            <!-- Vertical Nav Bar -->
            <div class="bg-dark text-light vh-100 vertical-nav">
                <div class="nav flex-column p-1">
                    <a href="dash" class="nav-item nav-link text-light pb-2 pt-4">DashBoard</a>
                    <a href="index.jsp" class="nav-item nav-link text-light pb-2 pt-5">Dashboard</a>
                    <a href="Courses.jsp" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>
                    <a href="Users.jsp" class="nav-item nav-link text-light pb-2 pt-4">User Management</a>    
                    <a href="Profile.jsp" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>
                   
                </div>
            </div>

            <!-- Main Content Area -->
            <main role="main" class="col-md-10 ml-sm-auto col-lg-10 px-4 pt-3">
                <div class="row">
                    <div class="col-4">
                        <h2>Instructors List</h2>
                        <ul class="list-group contact-list" style="cursor:pointer;" id="contact-list">
                        </ul>
                    </div>
                    <div class="col-8">
                        <div class="card chat-area">
                            <div class="card-header">
                                <h5 id="chat-contact-name">Select a contact to chat</h5>
                            </div>
                            <div class="card-body chat-box " style="margin-top:30%" id="chat-box">
                            </div>
                            <div class="p4"></div>
                            <div class="card-footer ">
                                <div class="input-group">
                                    <input type="text" id="chat-input" class="form-control" placeholder="Type a message">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" id="send-button">Send</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="scripts.js"></script>
    <footer class="bg-dark text-white text-center py-4">
        <p>&copy; 2024 LMS. All rights reserved.</p>
      </footer>
</body>

</html>
    