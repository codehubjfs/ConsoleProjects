<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Register</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="..\..\assets\css\seekerregister.css">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .login-container {
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 85vh;
      padding: 20px;
    }
    .login-box {
      width: 100%;
      max-width: 450px;
      padding: 20px;
      border: 1px solid #ccc;
      border-radius: 5px;
      background-color: #fff;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .login-box h4 {
      text-align: center;
      margin-bottom: 20px;
      font-family: sans-serif !important;
      border-bottom: 1px solid #ddd;
      padding-bottom: 10px;
    }
    .form-group {
      position: relative;
      margin-bottom: 20px;
    }
    .form-group label {
      font-weight: bold;
    }
    .form-control {
      padding-left: 2.5rem;
    }
    .form-control.is-invalid {
      border-color: red;
    }
    .form-control.is-valid {
      border-color: green;
    }
    .invalid-feedback,
    .valid-feedback {
      display: none;
    }
    .form-control.is-invalid ~ .invalid-feedback {
      display: block;
    }
    .form-control.is-valid ~ .valid-feedback {
      display: block;
    }
    .sub .forget {
      float: right;
    }
    .hi {
      border: 1px solid black;
      height: auto;
    }
    .signup {
      text-align: left !important;
    }
    .mandatory {
      color: red;
    }
    footer {
      background-color: #f8f9fa;
      padding: 20px 0;
    }
  </style>
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#"><img src="..\..\assets\images\head.2.png" alt="Jobportal"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-center" id="navbarNav">
      <ul class="navbar-nav h6">
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/views/home/home.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/views/home/job.jsp">Find Job</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="${pageContext.request.contextPath}/views/home/about.jsp">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Contact</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link" href="#" id="loginDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Login/Register
          </a>
          <div class="dropdown-menu" aria-labelledby="loginDropdown">
            <a class="dropdown-item" href="employer_login.html">Employer</a>
            <a class="dropdown-item hi" href="${pageContext.request.contextPath}/views/JobSeekers/seekerlogin.jsp" >Job Seekers</a>
            <a class="dropdown-item" href="${pageContext.request.contextPath}/views/Admin/AdminLogin.jsp">Admin</a>
          </div>
        </li>
      </ul>
    </div>
  </nav>
  <div class="login-container">
    <div class="login-box">
      <h4>Register as Candidate</h4>
      
      <form id="registerForm" action="..\..\SeekerRegisterController" method="post">
        <div class="form-group">
          <label for="name">Full Name <span class="mandatory">*</span>: <i class="input-icon fas fa-user"></i></label>
          <input type="text" class="form-control" id="name" name="name">
          
          <div class="invalid-feedback">Please enter your full name.</div>
        </div>
        <div class="form-group">
          <label for="email">Email address <span class="mandatory">*</span>: <i class="input-icon fas fa-envelope"></i></label>
          <input type="email" class="form-control" id="email" name="email">
          <div class="invalid-feedback">Please enter a valid email address.</div>
        </div>
        <div class="form-group">
          <label for="mobile">Mobile Number <span class="mandatory">*</span>: <i class="input-icon fas fa-phone"></i></label>
          <input type="text" class="form-control" id="mobile" name="phone">
          <div class="invalid-feedback">Please enter a valid 10-digit mobile number starting with 6, 7, 8, or 9.</div>
        </div>
        <div class="form-group">
          <label for="password">Password <span class="mandatory">*</span>: <i class="input-icon fas fa-lock"></i></label>
          <input type="password" class="form-control" id="password" name="password">
          <div class="invalid-feedback">Please enter a password with at least 6 characters, 1 special character, 1 uppercase letter, and 1 lowercase letter.</div>
        </div>
        <div class="form-group">
          <label for="confirmPassword">Confirm Password <span class="mandatory">*</span>: <i class="input-icon fas fa-lock"></i></label>
          <input type="password" class="form-control" id="confirmPassword">
          <div class="invalid-feedback">Passwords do not match.</div>
        </div>
        <div class="sub">
          <button type="submit" class="btn btn-primary btn-block">Register</button>
          <button type="reset" class="btn btn-secondary btn-block">Reset</button>
          <br>
          <a href="seekerlogin.jsp"> <i class="fas fa-sign-in-alt"></i> Back to Login</a>
        </div>
      </form>
    </div>
  </div>
  <footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h5>ABOUT US</h5>
                <p>Job portal involves various aspects to engage both job seekers and employers effectively. Here's a breakdown of the types of content you might include.</p>
            </div>
            <div class="col-md-3">
                <h5>CONTACT INFO</h5>
                <p>Address: Salem, Tamil Nadu</p>
                <p>Phone: +91 9788336639</p>
                <p>Email: jobfinder@job.ac.com</p>
            </div>
            <div class="col-md-3">
                <h5>LINKS</h5>
                <p><a href="#">Terms & Conditions</a></p>
                <p><a href="#">Download Job Finder App</a></p>
                <p><a href="#">Vulnerability Disclosure Policy</a></p>
                <p><a href="#">International Jobs</a></p>
                <p><a href="#">Support</a></p>
                <!-- <p>
                  <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-facebook" viewBox="0 0 16 16">
                    <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"/>
                  </svg>
                </p> -->
            </div>
            <div class="col-md-3">
                <h5>FOLLOW US</h5>
                <p>Stay connected through our social media channels:</p>
                <p>
                  <a href="https://www.facebook.com" target="_blank" class="social-icon"><i class="fab fa-facebook-f"></i></a>
                  <a href="https://www.twitter.com" target="_blank" class="social-icon"><i class="fab fa-twitter"></i></a>
                  <a href="https://www.linkedin.com" target="_blank" class="social-icon"><i class="fab fa-linkedin-in"></i></a>
                  <a href="https://www.instagram.com" target="_blank" class="social-icon"><i class="fab fa-instagram"></i></a>
                </p>
            </div>
        </div>
    </div>
  </footer>
  <script>
    document.getElementById('registerForm').addEventListener('submit', function(event) {
      event.preventDefault();
      
      var name = document.getElementById('name');
      var email = document.getElementById('email');
      var mobile = document.getElementById('mobile');
      var password = document.getElementById('password');
      var confirmPassword = document.getElementById('confirmPassword');

      var isValid = true;

      // Full Name validation
      if (name.value.trim() === '') {
        name.classList.add('is-invalid');
        isValid = false;
      } else {
        name.classList.remove('is-invalid');
        name.classList.add('is-valid');
      }

      // Email validation
      if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email.value)) {
        email.classList.add('is-invalid');
        isValid = false;
      } else {
        email.classList.remove('is-invalid');
        email.classList.add('is-valid');
      }

      // Mobile number validation
      if (!/^[6-9]\d{9}$/.test(mobile.value)) {
        mobile.classList.add('is-invalid');
        isValid = false;
      } else {
        mobile.classList.remove('is-invalid');
        mobile.classList.add('is-valid');
      }

      // Password validation
      var passwordPattern = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{6,}$/;
      if (!passwordPattern.test(password.value)) {
        password.classList.add('is-invalid');
        isValid = false;
      } else {
        password.classList.remove('is-invalid');
        password.classList.add('is-valid');
      }

      // Confirm password validation
      if (password.value !== confirmPassword.value) {
        confirmPassword.classList.add('is-invalid');
        isValid = false;
      } else {
        confirmPassword.classList.remove('is-invalid');
        confirmPassword.classList.add('is-valid');
      }

      // Submit the form if all validations are passed
      // Submit the form if all validations are passed
      if (isValid) {
    	  this.submit();
        // Clear the form
        document.getElementById('registerForm').reset();
        // Remove validation classes
        var inputs = document.querySelectorAll('.form-control');
        inputs.forEach(function(input) {
          input.classList.remove('is-valid', 'is-invalid');
        });
      }
    });
  </script>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
  <script src="/js/registration.js"></script>
</body>
</html>
