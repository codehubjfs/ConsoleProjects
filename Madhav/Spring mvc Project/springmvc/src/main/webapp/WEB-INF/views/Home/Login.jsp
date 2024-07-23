<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.2/font/bootstrap-icons.min.css" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/home/style.css">
		<style>
        .logo {
            display: flex;
            align-items: center;
            margin-left:85px;
            margin-bottom: 30px;
        }
	
        .logo img {
            width: 50px;				
            margin-right: 10px;
        }

        .logo span {
            font-size: 20px;
            font-weight: bold;
        }
        .error-message1 {
           margin-bottom: 10px;
            border-radius: 5px;
            margin-left:85px;
            color:red;
        }
        .error-message {
            color: #dc3545; /* Bootstrap's red color for errors */
            font-size: 0.875em;
            margin-top: 0.25em;
        }
        
       
    </style>
	<body>
	
		
		<div class="container d-flex justify-content-center align-items-center vh-100">
	        <div class="card p-4 shadow-lg animated-card">
	            <div class="logo">
	                <img src="asserts/image/home/logo.svg" alt="Logo"> 
	                <span>Ticket Raise</span>
	            </div>
	            <form action="login" method="post" id="loginForm" >
	            	  <% String emailError = (String) request.getAttribute("emailError"); %>
                		<% String passwordError = (String) request.getAttribute("passwordError"); %>
                
	                <div class="form-group">
	                    <label for="email">Email address</label>
	                    <input type="email" class="form-control" name="email"id="email" aria-describedby="emailHelp" placeholder="Enter email">
	                	 <% if (emailError != null) { %>
                        <div class="error-message"><%= emailError %></div>
                    <% } %>
	                </div>
	                <div class="form-group position-relative">
	                    <label for="password">Password</label>
	                    <input type="password" name="password" class="form-control" id="password" placeholder="Password">
	                    <i class="bi bi-eye-slash password-toggle" id="togglePassword"></i>
	                     <% if (passwordError != null) { %>
                        <div class="error-message"><%= passwordError %></div>
                    <% } %>
	                </div>
	                <div class="form-group">
	                    <label for="role">Role</label>
	                    <select class="form-control" id="role" name="role">
	                        <option value="Admin" >Admin</option>
	                        <option value="Student">Student</option>
	                       
	                        <option value="Warden">Warden</option>
	                         <option Value="Supervisor">Supervisor</option>
	                    </select>
	                </div>
	                 <%-- Display error message if it exists --%>
                <% String error = (String) request.getAttribute("error"); %>
                <% if (error != null && !error.isEmpty()) { %>
                    <div class="error-message1">
                        <%= error %>
                    </div>
                    <% session.removeAttribute("error"); %>
                <% } %> 
	                <button type="submit" class="btn btn-primary btn-block">Login</button>
	                
	                <div class="text-center mt-3">
    					<a href="${pageContext.request.contextPath}/index.jsp">Forgot Password?</a>
					</div>
	            </form>
	            <div id="alertContainer"></div>
	        </div>
    </div>
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
    document.getElementById('togglePassword').addEventListener('click', function() {
        var passwordInput = document.getElementById('password');
        var type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
        passwordInput.setAttribute('type', type);
        this.classList.toggle('bi-eye');
        this.classList.toggle('bi-eye-slash');
    });
    </script>
	</body>
</html>