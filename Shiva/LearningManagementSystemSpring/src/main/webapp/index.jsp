<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Login </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: url('asserts/images/bg.jpg') no-repeat center center fixed;
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
        <h2>Login</h2>
        <form id="loginForm" action="${pageContext.request.contextPath}/studentLogIn" method="post">
            <div class="form-group">
                <label for="login-username">Username</label>
                <input type="text" class="form-control" onchange="validateForm()" id="login-username" name="username" >
                <div id="errmsg" style="color: red;"></div>
            </div>
            <div class="form-group">
                <label for="login-password">Password</label>
                <input type="password" class="form-control" id="login-password" name="password" >
            </div>
            <a href="../views/admin/LogIn.jsp"><button type="submit" class="btn btn-primary  pb-2" style="margin-left:40%" >Login</button></a><br>
           <div style="color:red;text:center;margin-left:15%"><%= request.getAttribute("errmsg")!=null? request.getAttribute("errmsg"):"" %></div>
            <a href="${pageContext.request.contextPath}/adminRedirect" class="float-right">Log In as Admin</a>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
    function validateForm()
    {
    let isusername=document.getElementById("login-username").value;
    if(/\d/.test(isusername))
    {
        const errmsg= document.getElementById("errmsg");
        errmsg.innerText="Do not Enter number"
    }
    else
    	{
    	errmsg.innerText="";
    	}
    }
    </script>
</body>
</html>