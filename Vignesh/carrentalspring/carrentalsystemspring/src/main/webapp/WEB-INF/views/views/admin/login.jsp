<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #dfd9d9;
            margin: 0;
            padding: 0;
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
        .d-flex {
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        #outer {
            width: 600px;
            height: 500px;
            border-radius: 10px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-container {
            padding: 20px;
        }
        .input-group {
            margin-bottom: 20px;
        }
        .input-group label {
            display: block;
            margin-bottom: 5px;
            color: #666;
            font-weight: bold;
        }
        .input-group input {
            width: calc(100% - 20px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .input-group input:focus {
            border-color: #007bff;
            outline: none;
        }
        .error {
            color: red;
            font-size: 12px;
            margin-top: 5px;
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        button:hover {
            background-color: #0056b3;
        }
        .bottom-text {
            margin-top: 20px;
            text-align: center;
        }
        .bottom-text p {
            font-size: 14px;
            color: #666;
        }
        .bottom-text a {
            color: #007bff;
            text-decoration: none;
            transition: color 0.3s ease;
        }
        .bottom-text a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="header">
        <span class="logo-text">Go <span style="color:orange">Trip</span></span>
    </div>
    <div class="d-flex">
        <div id="outer">
            <div class="form-container">
                <form action="${pageContext.request.contextPath}/loginusers" method="post" id="loginForm">
                <br>
                    <h2>Admin Login</h2>
                    <br>
                
                    
                    <div class="input-group">
                        <label for="username">Username</label>
                        <input type="text" id="username" name="username" value="${param.username}" required>
                    </div>
                    <br>
                    <div class="input-group">
                        <label for="password">Password</label>
                        <input type="password" id="password" name="password" required>
                    </div>
                    <br>
                    <button type="submit">Login</button>
                    <% if (request.getAttribute("errorMessage") != null) { %>
                        <div class="error"><h6><%= request.getAttribute("errorMessage") %></h6></div>
                    <% } %>
                    <!--
                    <div class="bottom-text">
                        <p>Don't have an account? <a href="signup.html">Sign up</a></p>
                    </div>
                    -->
                </form>
            </div>
        </div>
    </div>
</body>
</html>
