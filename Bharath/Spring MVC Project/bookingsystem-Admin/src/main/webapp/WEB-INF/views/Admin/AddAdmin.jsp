<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Form with Validation</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/AdminStyle.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 500px;
            margin-left: 200px;
            margin-top: 500px;
        }
        .form-container h2 {
            margin-bottom: 20px;
            text-align: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-group input {
            width: calc(100% - 20px);
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .form-group input:focus {
            border-color: #007BFF;
        }
        .form-group .error {
            color: red;
            font-size: 14px;
            min-height: 18px; /* Allocate space for error message */
        }
        .form-group button {
            width: 96%;
            padding: 10px;
            font-size: 16px;
            color: #fff;
            background-color: #007BFF;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 20px;
        }
        .form-group button:hover {
            background-color: #0056b3;
        }
        .error {
            color: red;
            font-size: 0.9em;
            margin-top: 0.5em;
        }
        .success-message {
            display: none;
            text-align: center;
            margin-top: 20px;
            color: green;
        }
        .dmod {
            padding-top: 100px;
            border: 1px solid rebeccapurple;
            padding: 50px 50px 50px 0px;
            margin-top: 10%!important;
            border-radius: 5px;
            margin-left: 500px;
            width: 30%;
        }
     </style>
</head>
<body>
<header>
    <nav>
        <ul>
            <li><img src="${pageContext.request.contextPath}/Images/image1.png" alt="logo"></li>
            <li>Joy Rider</li>
            <li class="right-align"><img src="${pageContext.request.contextPath}/Images/profile.png" alt="image"></li>
            <li>Charles Harris
                <div class="cent">Admin</div>
            </li>
        </ul>
    </nav>
</header>
<div class="sidebar">
    <ul>
        <li class="sidebar-title">ADMINISTRATOR</li>
        <li class="submenu">
            <a href="AdminIndex.jsp" class="active" onclick="toggleSubmenu('dashboardSubmenu')">DASHBOARD</a>
            <ul id="dashboardSubmenu" style="display: none;">
                <li class="space"><a href="#">- Analytics</a></li>
            </ul>
        </li>
        <li class="submenu">
            <a href="Customer.jsp" onclick="toggleSubmenu('userManagementSubmenu')">USER MANAGEMENT</a>
            <ul id="userManagementSubmenu" style="display: none;">
                <li class="space"><a href="#">- Customer List</a></li>
                <li class="spaceup"><a href="#">- Bus Operator List</a></li>
            </ul>
        </li>
        <li class="submenu">
            <a href="Routes.jsp" onclick="toggleSubmenu('routeManagementSubmenu')">ROUTE MANAGEMENT</a>
            <ul id="routeManagementSubmenu" style="display: none;">
                <li class="space"><a href="#">- Route Details</a></li>
            </ul>
        </li>
        <div class="downside">
            <li><a href="AddAdmin.jsp">ADD NEW ADMIN</a></li>
            <li><a href="${pageContext.request.contextPath}/LogoutServlet">LOGOUT</a></li>
        </div>
    </ul>
</div>
<div class="main-content">
    <div class="form-container">
        <h2>Add Admin</h2>
        <form id="registrationForm" action="${pageContext.request.contextPath}/AdminAddController" onsubmit="return validateForm()">
            <div class="form-group">
                <label for="firstname">First Name</label>
                <input type="text" id="firstname" name="firstname" oninput="validateFirstName()">
                <div id="firstnameError" class="error"></div>
            </div>
            <div class="form-group">
                <label for="lastname">Last Name</label>
                <input type="text" id="lastname" name="lastname" oninput="validateLastName()">
                <div id="lastnameError" class="error"></div>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" oninput="validateEmail()">
                <div id="emailError" class="error"></div>
            </div>
            <div class="form-group">
                <label for="username">Username</label>
                <input type="text" id="username" name="username" oninput="validateUsername()">
                <div id="usernameError" class="error"></div>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" oninput="validatePassword()">
                <div id="passwordError" class="error"></div>
            </div>
            <div class="form-group">
                <label for="phonenumber">Phone Number</label>
                <input type="tel" id="phonenumber" name="phonenumber" oninput="validatePhoneNumber()">
                <div id="phonenumberError" class="error"></div>
            </div>
            <div class="form-group">
                <button type="submit">Register</button>
            </div>
        </form>
    </div>

    <script>
    function validateFirstName() {
        var firstname = document.getElementById("firstname").value;
        if (firstname.trim() === "") {
            document.getElementById("firstnameError").innerHTML = "First name is required";
            return false;
        } else if (!/^[a-zA-Z]+$/.test(firstname.trim())) {
            document.getElementById("firstnameError").innerHTML = "First name must contain only alphabetic characters";
            return false;
        } else {
            document.getElementById("firstnameError").innerHTML = "";
            return true;
        }
    }

    function validateLastName() {
        var lastname = document.getElementById("lastname").value;
        if (lastname.trim() === "") {
            document.getElementById("lastnameError").innerHTML = "Last name is required";
            return false;
        } else if (!/^[a-zA-Z]+$/.test(lastname.trim())) {
            document.getElementById("lastnameError").innerHTML = "Last name must contain only alphabetic characters";
            return false;
        } else {
            document.getElementById("lastnameError").innerHTML = "";
            return true;
        }
    }

        function validateEmail() {
            var email = document.getElementById("email").value;
            var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
            if (!emailPattern.test(email)) {
                document.getElementById("emailError").innerHTML = "Enter a valid email address";
                return false;
            } else {
                document.getElementById("emailError").innerHTML = "";
                return true;
            }
        }

        function validateUsername() {
            var username = document.getElementById("username").value;
            if (username.trim() === "") {
                document.getElementById("usernameError").innerHTML = "Username is required";
                return false;
            } else {
                document.getElementById("usernameError").innerHTML = "";
                return true;
            }
        }

        function validatePassword() {
            var password = document.getElementById("password").value;
            if (password.trim() === "") {
                document.getElementById("passwordError").innerHTML = "Password is required";
                return false;
            } else {
                document.getElementById("passwordError").innerHTML = "";
                return true;
            }
        }

        function validatePhoneNumber() {
            var phonenumber = document.getElementById("phonenumber").value;
            var phonePattern = /^[0-9]{10}$/;
            if (!phonePattern.test(phonenumber)) {
                document.getElementById("phonenumberError").innerHTML = "Enter a valid phone number (10 digits)";
                return false;
            } else {
                document.getElementById("phonenumberError").innerHTML = "";
                return true;
            }
        }

        function validateForm() {
            var isValid = true;
            if (!validateFirstName()) isValid = false;
            if (!validateLastName()) isValid = false;
            if (!validateEmail()) isValid = false;
            if (!validateUsername()) isValid = false;
            if (!validatePassword()) isValid = false;
            if (!validatePhoneNumber()) isValid = false;
            return isValid;
        }
    </script>

    </body>
</html>
    