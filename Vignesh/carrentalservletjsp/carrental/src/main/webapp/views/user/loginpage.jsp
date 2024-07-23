<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
            overflow: hidden; /* Ensures the image does not overflow */
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
            padding: 20px 30px;
            height: 100%; /* Ensures the image container takes full height */
            background: #f58220; /* Orange background color */
            color: #fff;
            text-align: center;
        }

        .form-img {
            max-height: 100%;
            max-width: 100%;
            display: block;
            margin: 0 auto; /* Centers the image horizontally */
        }

        .form-content {
            float: right;
            width: 60%;
            padding: 20px 30px;
        }

        .form-group {
            margin-bottom: 20px;
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

    <div class="container mt-5">

        <div class="form-container">

            <div class="form-img-container">
                <img src="../images/loginimg2.avif" alt="image" class="form-img">
            </div>

            <div class="form-content">
                <h2 class="text-center mb-4">Login or Register</h2>

                <!-- Login Form -->
                <form action="${pageContext.request.contextPath}/LoginServlet"  method="get" id="loginForm">
                    <div class="form-group">
                        <label for="login_email">Email</label>
                        <input type="text" class="form-control" id="login_email" name="username" placeholder="Enter Email" required>
                    </div>
                    <div class="form-group">
                        <label for="login_password">Password</label>
                        <input type="password" class="form-control" id="login_password" name="password" placeholder="Enter Password" required>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                    <p class="text-center mt-3 mb-0"><a href="javascript:void(0);" onclick="showRegisterForm();">Don't have an account? Register here.</a></p>
                </form>

                <!-- Registration Form -->
                <form id="registerForm" action="register" method="post" style="display: none;">
                    <div class="form-group">
                        <label for="first_name">First Name</label>
                        <input type="text" class="form-control" id="first_name" name="firstName" placeholder="First Name" required>
                    </div>
                    <div class="form-group">
                        <label for="last_name">Last Name</label>
                        <input type="text" class="form-control" id="last_name" name="lastName" placeholder="Last Name" required>
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
                        <input type="text" class="form-control" id="phone" name="phoneNumber" placeholder="Enter Phone Number" required>
                    </div>
                    <div class="form-group">
                        <label for="register_email">Email</label>
                        <input type="email" class="form-control" id="register_email" name="email" placeholder="Enter Email" required>
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

</body>

</html>
