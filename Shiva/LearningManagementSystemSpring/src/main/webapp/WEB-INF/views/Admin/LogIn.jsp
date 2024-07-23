<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: url('../../asserts/images/bg.jpg') no-repeat center center fixed;
            background-size: cover;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            max-width: 400px;
            width: 100%;
            animation: fadeIn 1s;
        }
        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }
        h2 {
            margin-bottom: 20px;
            color: #343a40;
            text-align: center;
        }
        .form-group label {
            color: #495057;
        }
        .form-control {
            border-radius: 0.25rem;
        }
        .btn-primary {
            border-radius: 0.25rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Admin Login</h2>
        <form id="loginForm" action="hello" onsubmit="validateForm()">
            <div class="form-group">
                <label for="login-username">Username</label>
                <input type="text" class="form-control" onchange="validateForm()" id="loginusername" name="username" required>
                <div id="errmsg" style="color: red;"></div>
            </div>
            <div class="form-group">
                <label for="login-password">Password</label>
                <input type="password" class="form-control" id="loginpassword" name="password" required>
            </div>
            <div class="pb-3">
            <a href="index.jsp"><button type="submit" class="btn btn-primary" style:right:50% >Login</button></a>
            </div>
            
        </form>
        <a href="index.jsp" class="primary" >Log In as Student</a>
        <a href="index.jsp" class="float-right">Forgot Password</a>
    </div>

<script>
    function validateForm()
    {
    let isusername=document.getElementById("loginusername").value;
    if(/\d/.test(isusername))
    {
        const errmsg= document.getElementById("errmsg");
        errmsg.innerText="Do not Enter number"
    }	
    }
</script>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>