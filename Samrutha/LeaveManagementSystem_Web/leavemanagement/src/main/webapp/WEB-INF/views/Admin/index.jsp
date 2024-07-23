<%@page import="com.leavemanagement.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/asserts/css/AdminStyle.css"> 
</head>
<body>
<header class="header fixed-top">
        <div class="header-img"><img src="${pageContext.request.contextPath}/asserts/images/image1.png" alt="Logo"></div>
        <a href="eprofile" style="color: white;text-decoration: none;">
	        <div id="header-profile">
	        <div id="header-content"><p style="padding-top:15px; padding-right:5px"><%=session.getAttribute("username") %></p></div>
	        <div id="icon"><img src="${pageContext.request.contextPath}/asserts/images/image2.svg" alt="Icon" style="margin-top:15px;justify-content:center;height:25px"></div>
	        </div>
        </a>
    </header>
    <div class="container-fluid">
        <div class="row">
        	<button class="sidebar-icon" id="sidebar-toggle">ss</button>
            <nav class="col-sm-2 sidebar sidebar-sticky">
                <a class="nav-link active" href="${pageContext.request.contextPath}/admin/adashboard">Dashboard</a>
                <!-- <a class="nav-link" href="${pageContext.request.contextPath}/admin/aprofile">Profile</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/admin/employeeManagement">EmployeeManagement</a>
                <a class="nav-link" href="${pageContext.request.contextPath}/employee/ehistory">History</a>  -->
                <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
            </nav>
            <div class="col-sm-10 content" style="padding-top: 50px">
                <div>
                    <h1>Welcome <%= ((Employee)request.getSession().getAttribute("employee")).getFirstName() %>...!</h1>
                </div>
                <div>
                    <nav aria-label="breadcrumb">
                      <ol class="breadcrumb">
                        <li class="breadcrumb-item active" aria-current="page">Dashboard</li>
                      </ol>
                    </nav>
                </div>
                <hr>
            </div>
        </div>
    </div>
</body>
</html>