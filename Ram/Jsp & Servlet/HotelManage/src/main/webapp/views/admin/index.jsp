<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login - Hotel Booking App</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"> <!-- For Font Awesome Icons -->
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/adminIndex.css">
</head>
<style>
  body {
            background: rgba(0, 0, 0, 0.5) url('../../images/r4.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            backdrop-filter: blur(3px); 
        }
</style>
<body>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div class="center-content">
        <h1>RK Hotel</h1>
    </div>
    <div class="container">
        <h2>Admin Login</h2>
        <form id="loginForm"  action="${pageContext.request.contextPath}/LoginAdminServlet" onsubmit="validateForm(event)" method="post" >
            <div class="form-group">
                <label for="login-username">Username</label>
                <input type="text" class="form-control" id="login-username" name="username">
                <div class="error-message" id="username-error"></div>
            </div>
            <div class="form-group">
                <label for="login-password">Password</label>
                <input type="password" class="form-control" id="login-password" name="password">
                <div class="error-message" id="password-error"></div>
            </div>
            <button type="submit" class="btn btn-primary btn-custom btn-block">Login</button>
            <div class="error-message" id="error"></div>
            <c:if test="${not empty errorMessage}">
                <div class="alert alert-danger" role="alert">${errorMessage}</div>
            </c:if>
        </form>
        <div class="forgot-password">
            <a href="#">Forgot Password?</a>
        </div>
        
    </div>
    <script>
    function validateForm(event) {
        let valid = true;

        const username = document.getElementById('login-username').value.trim();
        const password = document.getElementById('login-password').value.trim();

        const usernameError = document.getElementById('username-error');
        const passwordError = document.getElementById('password-error');
        const generalError = document.getElementById('error');

        usernameError.textContent = '';
        passwordError.textContent = '';
        generalError.textContent = '';

        if (username === '') {
            usernameError.textContent = 'Please enter your username';
            valid = false;
        }

        if (password === '') {
            passwordError.textContent = 'Please enter your password';
            valid = false;
        }

        if (!valid) {
            event.preventDefault();
        }
    }

    </script>
     
    <script src="${pageContext.request.contextPath}/javascript/adminIndex.js"></script>
    
    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
