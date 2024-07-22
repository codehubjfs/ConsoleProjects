<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

</body><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LMS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/style.css">
    <script src="${pageContext.request.contextPath}/asserts/javascript/loginScript.js"></script>
</head>
<body>
    <header>
        <div id="header-img"><img src="asserts/images/image1.png"></div>
        <div id="header-content"><h1>LEAVE MANAGEMENT SYSTEM</h1></div>
    </header>
    <div class="container-fluid p-5">
        <div class="row justify-content-center mb-5">
            <div class="col-md-4 col-sm-12 bg-white rounded shadow-lg">
                <div class="container-image">
                    <img src="${pageContext.request.contextPath}/asserts/images/image1.png" class="rounded">
                </div>
                <h3>Login</h3>
                <form action="login" method="post" onsubmit="return validateForm()">
                    <div class="mb-3">
                        <label for="Username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="Username" name="username" placeholder="Enter Username">
                        <span id="usernameFeedback" style="color: red;"></span>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
                        <span id="passwordFeedback" style="color: red;"></span>
                    </div>
                    <div class="mb-3">
                        <label for="select" class="form-label">User type</label>
                        <select class="form-select" id="select" name="userType">
                            <option disabled selected>Select user type</option>
                            <option value="EMPLOYEE">Employee</option>
                            <option value="MANAGER">Manager</option>
                            <option value="HR">HR</option>
                            <option value="ADMIN">System Admin</option>
                        </select>
                        <span id="usertypeFeedback" style="color: red;"></span>
                    </div>
                    <div class="mb-3">
                        <span id="errorMessage" style="color: red; text-align:center;">
                        	<c:if test="${not empty errorMessage}">
					            ${errorMessage}
					        </c:if>
                        </span>
                    </div>
                    <button type="submit" class="mx-auto btn btn-primary">Login</button>
                    <div id="container-foot">
                        <a href="forgetpassword">Forgot Password</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
    document.getElementById('Username').addEventListener('input', function() {
        validateUsername();
    });

    document.getElementById('password').addEventListener('input', function() {
        validatePassword();
    });

    document.getElementById('select').addEventListener('change', function() {
        validateUsertype();
    });

    function validateUsername() {
        var username = document.getElementById('Username').value;
        if (username.trim() === "") {
            document.getElementById('usernameFeedback').innerHTML = 'Username is required.';
            return false;
        } else {
            document.getElementById('usernameFeedback').innerHTML = '';
            return true;
        }
    }

    function validatePassword() {
        var password = document.getElementById('password').value;
        if (password.trim() === "") {
            document.getElementById('passwordFeedback').innerHTML = 'Password is required.';
            return false;
        } else {
            document.getElementById('passwordFeedback').innerHTML = '';
            return true;
        }
    }

    function validateUsertype() {
        var usertype = document.getElementById('select').value;
        if (usertype === "Select user type") {
            document.getElementById('usertypeFeedback').innerHTML = 'User type is required.';
            return false;
        } else {
            document.getElementById('usertypeFeedback').innerHTML = '';
            return true;
        }
    }

    function validateForm() {
        var isUsernameValid = validateUsername();
        var isPasswordValid = validatePassword();
        var isUsertypeValid = validateUsertype();

        return isUsernameValid && isPasswordValid && isUsertypeValid;
    }
    </script>
</body>
</html>