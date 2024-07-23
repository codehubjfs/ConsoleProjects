<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
    <title>Admin Registration Success</title>
    <style>
        /* General Body Styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            margin: 0;
            padding-top: 45px; 
        }

        /* Header Styles */
        header {
            background: linear-gradient(to left, #163c83, #0c2e6e, #163c83);
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* Subtle shadow */
            font-weight: bold;
            color: #b8e906;
            font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
            width: 100%;
            position: fixed;
            top: 0;
            z-index: 2;
            height: 70px;
        }


        nav ul {
            list-style-type: none;
            display: flex;
            align-items: center;
            padding: 0 20px;
            height: 100%;
            font-size: 25px; /* Reduced font size for navigation items */
            margin: 0; /* Remove default margin */
        }

        nav ul li {
            margin-right: 20px;
        }

        nav ul li img {
            width: 50px;
            height: auto;
            margin-top:10px;
            margin-right: 10px;
            border-radius: 50%; 
        }

        .right-align {
            margin-left: auto;
            display: flex;
            align-items: center;
            height:50px
        }

        .cent {
            font-size: 15px;
        }

        /* Container Styles */
        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            margin-top: 100px; 
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #007BFF;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background-color: #007BFF;
            color: #fff;
            text-decoration: none;
            border-radius: 4px;
            transition: background-color 0.3s ease;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <header>
        <nav>
            <ul>
                <li><img src="${pageContext.request.contextPath}/Images/image1.png" alt="logo"></li>
                <li>Joy Rider</li>
                <li class="right-align"><img src="${pageContext.request.contextPath}/Images/profile.png" alt="image"></li>
                <li>Charles Harris <div class="cent">Admin</div></li>
            </ul>
        </nav>
    </header>
    <div class="container">
        <h2>Admin Registered Successfully!</h2>
        <p>Your new admin account has been created.</p>
        <a href="AdminIndex.jsp">Go back to Home</a>
    </div>
</body>
</html>
