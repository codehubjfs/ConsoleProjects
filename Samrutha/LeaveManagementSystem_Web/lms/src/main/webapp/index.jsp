<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LMS</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="asserts/css/style.css">
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
                    <img src="asserts/images/image1.png" class="rounded">
                </div>
                <h3>Login</h3>
                <form action="login" method="post" onsubmit="return validateForm()">
                    <div class="mb-3">
                        <label for="Username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="Username" name="username" placeholder="Enter Username" onchange="validateForm()">
                        <span id="usernameFeedback" style="color: red;"></span>
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" onchange="validateForm()">
                        <span id="passwordFeedback" style="color: red;"></span>
                    </div>
                    <div class="mb-3">
                        <label for="select" class="form-label">User type</label>
                        <select class="form-select" id="select" name="userType" onchange="validateForm()">
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
                            <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
                        </span>
                    </div>
                    <button type="submit" class="mx-auto btn btn-primary">Login</button>
                    <div id="container-foot">
                        <a href="<%= request.getContextPath() %>/views/Login/ForgotForm.jsp">Forgot Password</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
</body>
</html>
