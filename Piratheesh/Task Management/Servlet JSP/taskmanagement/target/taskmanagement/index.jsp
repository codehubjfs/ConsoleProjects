<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="asserts/CSS/Home/login.css">
</head>

<body>
    <div class="container-fluid p-5 justify-content-center justify-content-between" style="width: 1150px;">
        <div class="row justify-content-center mb-5">
            <div class="col-md-6 col-sm-12 bg-white rounded shadow-lg p-4">
                <div class="text-center">
                    <img src="asserts/Image/Manager/taskmanagement1.jpg" style="height: 50px; width: 50px;" class="rounded mb-3" alt="Logo">
                </div>
                <h3 class="text-center" id="form-title">User Login</h3>
                <form id="loginForm" action="UserValidation" method="post">
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" required>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" placeholder="Enter Password" name="password" required>
                    </div>
                    <div class="mb-3" id="user-role-container">
                        <label for="role" class="form-label">Role</label>
                        <select class="form-select" id="role" name="usertype" required>
                            <option disabled selected>Select Role</option>
                            <option value="Employee">Employee</option>
                            <option value="Manager">Manager</option>
                            <option value="Admin">Admin</option>
                        </select>
                    </div>
                    <% 
                        String error = (String) request.getAttribute("errorMessage"); 
                        if (error != null && !error.isEmpty()) { 
                    %>
                        <div class="error-message1">
                            <%= error %>
                        </div>
                    <% } %>
                    <button type="submit" class="btn btn-primary w-100">Login</button>
                    <div id="container-foot" class="text-end mt-2">
                        <a href="#">Forgot Password</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>

</html>
