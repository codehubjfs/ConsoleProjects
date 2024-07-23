<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Login</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:400,700">
    <style>
        *, *:before, *:after { box-sizing: border-box; }

        body {
            min-height: 100vh;
            font-family:'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        }

        .container-fluid {
            position: absolute;
            width: 100%;
            height: 100%;
            overflow: hidden;
        }

        .container-fluid:hover .top:before,
        .container-fluid:hover .top:after,
        .container-fluid:hover .bottom:before,
        .container-fluid:hover .bottom:after {
            margin-left: 350px;
            transform-origin: -350px 50%;
            transition-delay: 0s;
        }

        .container-fluid:hover .center {
            opacity: 1;
            transition-delay: 0.2s;
        }

        .top, .bottom {
            position: absolute;
            width: 100%;
            height: 105%;
        }

        .top:before, .top:after,
        .bottom:before, .bottom:after {
            content: '';
            display: block;
            position: absolute;
            width: 200vmax;
            height: 200vmax;
            top: 50%;
            left: 50%;
            margin-top: -100vmax;
            transform-origin: 0 50%;
            transition: all 0.5s cubic-bezier(0.445, 0.05, 0, 1);
            z-index: 10;
            opacity: 0.65;
            transition-delay: 0.2s;
        }

        .top:before { transform: rotate(45deg); background: #e46569; }
        .top:after { transform: rotate(135deg); background: #ecaf81; }
        .bottom:before { transform: rotate(-45deg); background: #60b8d4; }
        .bottom:after { transform: rotate(-135deg); background: #3745b5; }

        .center {
            position: absolute;
            width: 400px;
            height: 400px;
            top: 30%;
            left: 50%;
            margin-left: -200px;
            /* margin-top: 50px; */
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            padding: 30px;
            opacity: 0;
            transition: all 0.5s cubic-bezier(0.445, 0.05, 0, 1);
            transition-delay: 0s;
            color: #333;
        }

        .center input {
            width: 100%;
            padding: 15px;
            margin: 5px;
            border-radius: 1px;
            border: 1px solid #ccc;
            font-family: inherit;
        }

        footer {
            padding-top: 8px;
            margin-top: 30px;
            color: rgb(255, 255, 255);
            text-align: center;
            background-color: #3c3c3c;
            height: 40px;
        }

        h1{
            text-align: center;
            color:#0a1774;
            font-style: italic;
        }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="top"></div>
    <div class="bottom"></div>
    <div class="center">
        <h1>ASSESSMENT HUB</h1>
        <!-- <h2>Login</h2> -->
        <form action= '${pageContext.request.contextPath}/LoginAuthentication' method="get">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>

            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>

            <div class="form-group text-right">
                <a href="/forgot-password" class="forgot-password">Forgot your password?</a>
            </div>

            <div class="form-group">
                <label for="user-type">Login As:</label>
                <select class="form-control" id="user-type" name="user-type" required>
                    <option value="Student">Student</option>
                    <option value="Instructor">Instructor</option>
                    <option value="Admin">Admin</option>
                </select>
            </div>

            <button type="submit" class="btn btn-primary btn-block" id="logButton">Login</button>
        </form>
        <h2>&nbsp;</h2>
    </div>
</div>

<%

%>



<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
