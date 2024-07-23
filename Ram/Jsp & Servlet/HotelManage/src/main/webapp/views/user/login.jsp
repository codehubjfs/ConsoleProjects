<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login - RK Hotel Booking App</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Font Awesome for icons -->
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/login.css">
</head>
<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand mx-auto" href="${pageContext.request.contextPath}/index.jsp">RK Hotel</a>
            <!-- Centered logo -->
        </div>
    </nav>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-body">
                       <button class="btn btn-outline-secondary back-button" onclick="window.location.href='${pageContext.request.contextPath}/index.jsp';">
    <i class="fas fa-arrow-left"></i> Home
</button>

                        <h3 class="text-center mb-4">Login to Your Account</h3>
                        <form id="loginForm" action="${pageContext.request.contextPath}/LoginUserServlet" method="post">
                            <div class="form-group">
                                <label for="email">Email</label>
                                <input type="email" id="email" name="email" class="form-control">
                                <div class="error-message text-danger">
                                    <%= request.getAttribute("emailError") != null ? request.getAttribute("emailError") : "" %>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="password" id="password" name="password" class="form-control">
                                <div class="error-message text-danger">
                                    <%= request.getAttribute("passwordError") != null ? request.getAttribute("passwordError") : "" %>
                                </div>
                            </div>
                            <div class="form-group">
                                <a href="#" class="float-right">Forgot Password?</a>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Login</button>
                        </form>
                         <a href="${pageContext.request.contextPath}/views/user/register.jsp" class="btn btn-secondary btn-sm btn-block mt-2 pt-2 pb-2">Register</a>
                       <!--   <button onclick="location.href='views/user/register.jsp'" class="btn btn-secondary btn-block mt-2">Register</button>-->
                        <div class="error-message text-danger text-center mt-3">
                            <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap JavaScript and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Icons for login page -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
    <script src="${pageContext.request.contextPath}/javascript/user/login.js"></script>
</body>
</html>
