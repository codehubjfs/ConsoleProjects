<%@ page language="java" 
    contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8" 
    isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login or Register</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 600px; /* Increased width for better spacing */
            margin: 0 auto;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }
        
        .header {
            background-color: #f0f0f0;
            padding: 10px;
            text-align: left;
            font-family: Arial, sans-serif;
        }
        .logo-text {
            font-size: 24px;
            font-weight: bold;
            color: #333;
        }

        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-img-container {
            float: left;
            width: 40%;
            padding: 30px 30px;
            height: 100%; /* Ensures the image container takes full height */
            background: #f58220; /* Orange background color */
            color: #fff;
            text-align: center;
        }

        

        .form-content {
            float: right;
            width: 60%;
            padding: 20px 30px;
        }

        .form-group {
            margin-bottom: 20px;
        }
        .error-message{
        color:red;
        }
        

        .form-control {
            border-radius: 5px;
        }

        .btn-primary {
            background-color: #f58220; /* Orange background color */
            border-color: #f58220; /* Orange border color */
            width: 100%;
            padding: 10px;
            font-size: 18px;
        }

        .btn-primary:hover {
            background-color: #e76e00; /* Darker orange on hover */
            border-color: #e76e00;
        }
    </style>

</head>

<body>
   <div class="header">
        <span class="logo-text">Go <span style="color:orange">Trip</span></span>
    </div>
    <div class="container mt-5">

        <!--  <div class="form-container">

            <div class="form-img-container">
                <img src="../images/loginimg2.avif" alt="image" class="form-img">
            </div> -->

            <div class="form-content">
                <h2 class="text-center mb-4">Login </h2>

                <!-- Login Form -->
                <form action="${pageContext.request.contextPath}/loginuser"  method="post" id="loginForm">
                    <div class="form-group">
                        <label for="login_email">UserName</label>
                        <input type="text" class="form-control" id="login_email" name="username" placeholder="Enter UserName" >
                    </div>
                    <div class="form-group">
                        <label for="login_password">Password</label>
                        <input type="password" class="form-control" id="login_password" name="password" placeholder="Enter Password" >
                    </div>
                    <c:if test="${not empty errorMessage}">
                    <div class="error-message" style="color:red">
                        ${errorMessage}
                    </div>
                </c:if>
                    <button type="submit" class="btn btn-primary">Login</button>
                    <p class="text-center mt-3 mb-0"><a href="javascript:void(0);" onclick="showRegisterForm();">Don't have an account? Register here.</a></p>
                </form>

                <!-- Registration Form -->
                <form id="registerForm" action="${pageContext.request.contextPath}/register" method="post" style="display: none;">
                    <div class="form-group">
                        <label for="first_name">First Name</label>
                       
                        <input type="text" class="form-control" id="first_name" name="firstName" placeholder="First Name" required>
                        <span id="first-name-error" class="error-message"></span>
                    </div>
                    <div class="form-group">
                        <label for="last_name">Last Name</label>
                        <input type="text" class="form-control" id="last_name" 
                        name="lastName" placeholder="Last Name" required>
                        <span id="last-name-error" class="error-message"></span>
                    </div>
                    <div class="form-group">
                        <label for="first_name">User Name</label>
                        <input type="text" class="form-control" id="first_name" name="username" placeholder="First Name" required>
                    </div>
                    
                    <div class="form-group">
                        <label for="gender">Gender</label>
                        <select class="form-control" id="gender" name="gender" required>
                            
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="phone">Phone</label>
                        <input type="text" class="form-control" 
                        id="phone" name="phoneNumber" placeholder="Enter Phone Number" required>
                         <span id="phone-error" class="error-message"></span>
                    </div>
                    <div class="form-group">
                        <label for="register_email">Email</label>
                        <input type="email" class="form-control" 
                        id="register_email" name="email" placeholder="Enter Email" required>
                        <span id="email-error" class="error-message"></span>
                    </div>
                    <div class="form-group">
                        <label for="register_password">Password</label>
                        <input type="password" class="form-control" id="register_password" name="password" placeholder="Enter Password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
                    <p class="text-center mt-3 mb-0"><a href="javascript:void(0);" onclick="showLoginForm();">Already have an account? Login here.</a></p>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- JavaScript to toggle forms -->
    <script>
        function showRegisterForm() {
            document.getElementById('loginForm').style.display = 'none';
            document.getElementById('registerForm').style.display = 'block';
        }

        function showLoginForm() {
            document.getElementById('registerForm').style.display = 'none';
            document.getElementById('loginForm').style.display = 'block';
        }
        
        
    </script>
     <script>
        function validateFirstName() {
            const firstNameInput = document.getElementById('first_name');
            const errorMessage = document.getElementById('first-name-error');
            const nameRegex = /^[a-zA-Z\s]*$/;
            if (!nameRegex.test(firstNameInput.value)) {
                errorMessage.textContent = 'First Name must contain only letters and spaces.';
                firstNameInput.setCustomValidity('Invalid');
            } else {
                errorMessage.textContent = '';
                firstNameInput.setCustomValidity('');
            }
        }

        function validateLastName() {
            const lastNameInput = document.getElementById('last_name');
            const errorMessage = document.getElementById('last-name-error');
            const nameRegex = /^[a-zA-Z\s]*$/;
            if (!nameRegex.test(lastNameInput.value)) {
                errorMessage.textContent = 'Last Name must contain only letters and spaces.';
                lastNameInput.setCustomValidity('Invalid');
            } else {
                errorMessage.textContent = '';
                lastNameInput.setCustomValidity('');
            }
        }

        function validateEmail() {
            const emailInput = document.getElementById('register_email');
            const errorMessage = document.getElementById('email-error');
            const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(emailInput.value)) {
                errorMessage.textContent = 'Please enter a valid email address.';
                emailInput.setCustomValidity('Invalid');
            } else {
                errorMessage.textContent = '';
                emailInput.setCustomValidity('');
            }
        }
         
        function validatePhone() {
            const phoneInput = document.getElementById('phone');
            const errorMessage = document.getElementById('phone-error');
            const phoneRegex = /^\d{10}$/;
            if (!phoneRegex.test(phoneInput.value)) {
                errorMessage.textContent = 'Phone number must be exactly 10 digits.';
                phoneInput.setCustomValidity('Invalid');
            } else {
                errorMessage.textContent = '';
                phoneInput.setCustomValidity('');
            }
        }
        
        function addValidationListeners() {
        	const firstNameInput = document.getElementById('first_name');
            const lastNameInput = document.getElementById('last_name');
            const emailInput = document.getElementById('register_email');
            const phoneInput = document.getElementById('phone');

            firstNameInput.addEventListener('input', validateFirstName);
            lastNameInput.addEventListener('input', validateLastName);
            emailInput.addEventListener('input', validateEmail);
            phoneInput.addEventListener('input', validatePhone);
        }

        window.addEventListener('DOMContentLoaded', addValidationListeners);
    </script>

</body>

</html>
