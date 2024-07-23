<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .dropdown-menu a {
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
        .error-message {
            color: red;
            font-size: 0.875em;
        }
    </style>
</head>
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
                            <img src="asserts/images/person.svg" class="rounded-circle pr-1 pt-2" alt="Profile Image">
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
        <div class="nav flex-column p-1">
        <a href="DashBoard" class="nav-item nav-link text-light pb-2 pt-5">Dashboard</a>
            <a href="courses" class="nav-item nav-link text-light pb-2 pt-4">Course Management</a>  
            <a href="Profile" class="nav-item nav-link text-light pb-2 pt-4">Profile</a>
             <a href="Results" class="nav-item nav-link text-light pb-2 pt-4">Results</a>
            <a href="Chatting" class="nav-item nav-link text-light pb-2 pt-4">Messages</a>
        </div>
    </div>
   <%@page import="java.util.*,com.spring.controller.StudentController,com.spring.model.Students" %>
   <% Students studentList=(Students) request.getAttribute("studentProfile");%>
    <div class="p-5 mx-auto d-grid container justify-content-center" style="margin-top: 5%;">
        <form id="profileForm" class="ml-5 shadow p-3 mb-5 bg-white rounded" action="editProfile?studentid=<%= studentList.getStudentId()%>">
        <img src="asserts/images/asim.jpg" height="20%" width="14%" style="border-radius:50%;margin-left:40%" class="rounded-circle  mb-3" alt="User Image">      
        <h4 style="text:center">Profile</h4>
        <input type="hidden" name="studentid" value= "<%= studentList.getStudentId() %>">
            <div class="form-group">
                <label for="inputFName">First Name</label>
                <input type="text" class="form-control" id="inputFName" name="firstname" value="<%= studentList.getFirstname() %>">
                <div id="fNameError" class="error-message"></div>
            </div>
            <div class="form-group">
                <label for="inputLName">Last Name</label>
                <input type="text" class="form-control" id="inputLName" name="lastname" value="<%=studentList.getLastname() %>">
                <div id="lNameError" class="error-message"></div>
            </div>
            <div class="form-group">
                <label for="inputDepartment">Department</label>
                <select id="inputDepartment" class="form-control" name="department">
                    <option value="Computer Science">Computer Science</option>
                    <option value="Information Technology">Information Technology</option>
                </select>
                <div id="departmentError" class="error-message"></div>
            </div>
            <div class="form-group">
                <label for="inputDOB">Date of Birth</label>
                <input type="date" class="form-control" id="inputDOB" name="dob" value="<%= studentList.getDob() %>">
                <div id="dobError" class="error-message"></div>
            </div>
            <div class="form-group">
                <label for="inputUsername">Username</label>
                <input type="text" class="form-control" id="inputUsername" name="username" value="<%= studentList.getUsername() %>">
                <div id="usernameError" class="error-message"></div>
            </div>
            <div class="form-group">
                <label for="inputPassword">Password</label>
                <input type="password" class="form-control" id="inputPassword" name="password" value="<%= studentList.getPassword() %>">
                <div id="passwordError" class="error-message"></div>
            </div>
           
            <div class="form-group">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Save Changes
                    </label>
                </div>
            </div>
            <div class="d-flex text-center">
                <button type="submit"  class="btn btn-primary">Submit</button>
                <div class="pl-5" style="padding-left: 20%;"></div>
                <button type="reset" class="btn btn-primary">Reset</button>
                <div class="pl-5" style="padding-left: 40%;"></div>
                <button type="button" class="btn btn-primary">Cancel</button>
                <div class="pl-5" style="padding-left: 40%;"></div>
            </div>
        </form>
    </div>

    <script>
        document.getElementById('profileForm').addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent form submission

            // Clear previous error messages
            //document.querySelectorAll('.error-message').forEach(el => el.innerText = '');

            let isValid = true;

            const firstName = document.getElementById('inputFName').value;
            const lastName = document.getElementById('inputLName').value;
            const department = document.getElementById('inputDepartment').value;
            const dob = document.getElementById('inputDOB').value;
            const username = document.getElementById('inputUsername').value;
            const password = document.getElementById('inputPassword').value;

            const namePattern = /^[A-Za-z]+$/;

            if (!namePattern.test(firstName)) {
                document.getElementById('fNameError').innerText = 'First name should not contain numbers or special characters.';
                isValid = false;
            }

            if (!namePattern.test(lastName)) {
                document.getElementById('lNameError').innerText = 'Last name should not contain numbers or special characters.';
                isValid = false;
            }

            if (department === "") {
                document.getElementById('departmentError').innerText = 'Please select a department.';
                isValid = false;
            }

            if (dob === "") {
                document.getElementById('dobError').innerText = 'Please enter your date of birth.';
                isValid = false;
            }

            if (username === "") {
                document.getElementById('usernameError').innerText = 'Please enter a username.';
                isValid = false;
            }

            if (password === "") {
                document.getElementById('passwordError').innerText = 'Please enter a password.';
                isValid = false;
            }

            // If all validations pass, allow form submission
            if (isValid) {
                this.submit();
            }
        });
        
        
    </script>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
    