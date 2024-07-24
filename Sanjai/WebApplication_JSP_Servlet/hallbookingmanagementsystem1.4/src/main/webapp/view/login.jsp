<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page isELIgnored = "false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assert/css/customerLoginCss.css"/>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assert/css/CustomerHeaderFooter.css"/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-multiselect/0.9.15/css/bootstrap-multiselect.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <title>Login</title>
</head>
<body>
    <div class="modal fade" id="successModal" tabindex="-1" role="dialog" aria-labelledby="successModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="successModalLabel">Login Successful</h5>
                    <button type="button" class="close" style="background-color: #28a745;" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <i class="fas fa-check-circle"></i>
                    <p>You have logged in successfully.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-success" id="goHomeBtn">Go to Home</button>
                </div>
            </div>
        </div>
    </div>
        <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light" id="customNavbar">
            <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/assert/image/Logo.1.1.png" id="company-logo" alt="Company Logo"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left:40% ">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href= '<%= request.getContextPath() %>/index.jsp'>Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/blogs.jsp'>Blogs</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Hall Events
                  </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown" id="Events-DropDown">
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/HallsServlet'>Wedding</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Corporate Party</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Conference</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Concert</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Exhibition</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Product Launch</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Training Session</a>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/facilities.jsp'>Facilities</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/contact.jsp'>Contact</a>
                </li>
                <% if(session.getAttribute("customer")==null){%>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/login.jsp' id="login">Login</a>
                </li>
                <%}
                else{ %>
                <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="userMenu" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                                <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
                            </svg>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="userMenu">
                            <li><a class="dropdown-item ms-0" href="#" id="logout">Logout</a></li>
                            <li><a class="dropdown-item ms-0" href="<%= request.getContextPath() %>/PaymentServlet">My Bookings</a></li>
                             <li><a class="dropdown-item ms-0" href="<%= request.getContextPath() %>/MyRequestsServlet">Booking Request</a></li>
                      	</ul>
                </li>
                <%} %>
              </ul>
            </div>
          </nav>
    </header>
    
    <div class="container" id="loginContainer" style="margin-top: 150px;">
    <div class="row">
        <div class="col-md-3 d-none d-md-block"></div>
        <div class="col-md-5">
            <div class="card">
                <h2 class="text-center" style="color: #4e4332;">Login</h2>
               <form id="loginForm" action="${pageContext.request.contextPath}/LoginServlet" method="post" class="needs-validation" novalidate>
                    <div class="row">
                        <div class="col mb-3">
                            <label for="name" class="form-label">User Name:<sup style="color:red">*</sup></label>
                            <input type="text" class="form-control" name="name" id="name" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col mb-3">
                            <label for="password" class="form-label">Password:<sup  style="color:red">*</sup></label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                    </div>
                    <% if (request.getAttribute("error") != null) { %>
                            <div class="text-danger"><%= request.getAttribute("error") %></div>
                    <% } %>        
                    <button type="button" class="forget-password" style="border:none; background: none; padding: 0;">
                        <a href="javascript:void(0)" class="link-primary">Forget Password?</a>
                    </button>
                    <div class="text-center mb-3">
                        <button type="submit" class="btn btn-primary" id="loginBtn" disabled>Login</button>
                    </div>
                    <div class="new-account">
                        <p>Don't have an account? <a href="${pageContext.request.contextPath}/view/register.jsp" class="link-primary">Create a new account</a></p>
                    </div>
                    <div class="hr-with-text">
                        <span>Are you an Admin?</span>
                    </div>
                    <div class="d-flex justify-content-center">
                       <a href="${pageContext.request.contextPath}view/admin/adminlogin.jsp" style="text-decoration:none;"><button class="btn btn-outline-dark d-flex align-items-center" id="admin-login">
                                Business Sign In
                       </button></a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="container" id="resetPasswordContainer" style="margin-top: 150px; display:none;">
    <div class="row">
        <div class="col-md-3 d-none d-md-block"></div>
        <div class="col-md-5">
            <div class="card">
                <h2 class="" style="color: #4e4332;">Reset your password</h2>
                <form id="resetPasswordForm" class="needs-validation" action="${pageContext.request.contextPath}/ForgetPasswordServlet" method="get" novalidate>
                    <p class="instruction mt-2">If the account exists, we will email you instructions to reset the password.</p>
                    <div class="row">
                        <div class="col mb-3">
                            <label for="email" class="form-label">Email:<sup  style="color:red">*</sup></label>
                            <input type="email" name="email" class="form-control" id="email" required>
                            <div class="invalid-feedback">Please enter the email</div>
                        </div>
                    </div>
                    <div class="text-center mb-3">
                        <button type="button" class="btn btn-light" id="backToLoginBtn">Back to Login</button>
                        <button type="submit" class="btn btn-primary" id="resetPasswordBtn">Reset Password</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
    
    <footer class="text-center pt-2">
        © 2021 Copyright:
        <a class="text-reset fw-bold" href="https://RoyalHalls.com/">RoyalHalls.com</a>
    </footer>
    <script>
    $(document).ready(function() {
        // Disable login button until both username and password fields are filled
        $('#name, #password').on('keyup', function() {
            if ($('#name').val().trim() !== '' && $('#password').val().trim() !== '') {
                $('#loginBtn').prop('disabled', false);
            } else {
                $('#loginBtn').prop('disabled', true);
            }
        });

        // Show modal on successful login
        <% if (request.getAttribute("loginSuccess") != null && (Boolean)request.getAttribute("loginSuccess")) { %>
            $('#successModal').modal('show');
        <% } %>

        // Redirect to home page on clicking the "Go to Home" button
        $('#goHomeBtn').on('click', function() {
            window.location.href = '<%= request.getContextPath() %>/index.jsp'; // Correctly redirect to DashBoardServlet
        });

        // Redirect to admin login page on admin login button click
        $('#admin-login').on('click', function(event) {
            event.preventDefault(); // Prevent form submission
            window.location.href = '<%= request.getContextPath() %>/view/Admin/adminlogin.jsp'; // Correctly redirect to admin login page
        });

        document.querySelector('.dropdown-toggle').addEventListener('click', function() {
            document.querySelector('.dropdown-menu').classList.toggle('show');
        });
    });
    
    
    document.querySelector(".forget-password").addEventListener("click", function(){
        document.getElementById("loginContainer").style.display = "none";
        document.getElementById("resetPasswordContainer").style.display = "block";
    });

    document.getElementById("backToLoginBtn").addEventListener("click", function(){
        document.getElementById("resetPasswordContainer").style.display = "none";
        document.getElementById("loginContainer").style.display = "block";
    });

    (function () {
      'use strict'

      // Fetch all the forms we want to apply custom Bootstrap validation styles to
      var forms = document.querySelectorAll('.needs-validation')

      // Loop over them and prevent submission
      Array.prototype.slice.call(forms)
        .forEach(function (form) {
          form.addEventListener('submit', function (event) {
            if (!form.checkValidity()) {
              event.preventDefault()
              event.stopPropagation()
            }

            form.classList.add('was-validated')
          }, false)
        })
    })()
    </script>
</body>
</html>
