<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Hotel Management System - Admin</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/admin/dashboard.css">
    <style>
    body {
    background-color: #f4f7fa;
    font-family: 'Arial', sans-serif;
}

.container {
    max-width: 1200px;
    margin: auto;
}

.card {
    border: none;
    border-radius: 10px;
    transition: transform 0.2s, box-shadow 0.2s;
}

.card:hover {
    transform: translateY(-5px);
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
}

.card-title {
    color: #2e1484;
    font-size: 1.5rem;
}

.card-text {
    color: #3b3b3b;
}

.card-body {
    background-color: #ffffff;
    padding: 30px;
    border-radius: 10px;
}

h1 {
    color: #2e1484;
    font-size: 2.5rem;
    margin-bottom: 30px;
}

.row {
    margin-bottom: 20px;
}

@media (max-width: 768px) {
    h1 {
        font-size: 2rem;
    }
    .card-title {
        font-size: 1.2rem;
    }
    .card-text {
        font-size: 1.5rem;
    }
}
    </style>
</head>

<%
    HttpSession session1 = request.getSession(false);
    if (session1 == null || session1.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
%>

<body>
<nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="Dashboard"><img src="${pageContext.request.contextPath}/asserts/images/logo.jpg" alt="Logo"/></a>
    <span class="navbar-text mx-auto"><span style="font-size: 30px; color:white ">Rk Hotel Management</span></span>
    <div class="dropdown profile">
        <img src="${pageContext.request.contextPath}/asserts/images/admin.jpg" alt="Profile Picture" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
        <div class="dropdown-menu dropdown-menu-right">
            <a class="dropdown-item" href="admin">View Profile</a>
            <div class="dropdown-divider"></div>
            <a class="dropdown-item" href="logout">Sign Out</a>
        </div>
    </div>
</nav>
<div class="sidebar">
    <div class="list-group">
        <a href="dashboard" class="list-group-item active">DASHBOARD</a>
        <a href="viewBookings" class="list-group-item ">Bookings</a>
        <a href="ListStaffServlet" class="list-group-item">Front Desk Staff</a>
        <a href="ListKeeperServlet" class="list-group-item">Housekeeper Staff</a>
        <a href="#roomsSubmenu" class="list-group-item dropdown-toggle" data-toggle="collapse">Rooms</a>
        <div class="collapse" id="roomsSubmenu">
            <a href="ShowRoom" class="list-group-item pl-5">All Rooms</a>
            <a href="RoomType" class="list-group-item pl-5">Room Types</a>
        </div>
        <a href="payments" class="list-group-item">Invoice Details</a>
        <a href="Customers" class="list-group-item">Customers</a>
        <hr>
    </div>
</div>
<div class="content">
    <div class="container mt-5 pt-5">
        <div class="row">
            <div class="col-12 text-center mb-4">
                <h1 class="font-weight-bold" style="color:rgb(46, 20, 132);">Dashboard Overview</h1>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <h5 class="card-title font-weight-bold">Total Bookings</h5>
                        <p class="card-text font-weight-bold" style="color:darkblue; font-size: 2rem;">${totalBookings}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <h5 class="card-title font-weight-bold">Rooms Available</h5>
                        <p class="card-text font-weight-bold" style="color:darkblue; font-size: 2rem;">${roomsAvailable}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <h5 class="card-title font-weight-bold">Total Customers</h5>
                        <p class="card-text font-weight-bold" style="color:darkblue; font-size: 2rem;">${totalCustomers}</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <h5 class="card-title font-weight-bold">New Bookings This Month</h5>
                        <p class="card-text font-weight-bold" style="color:darkblue; font-size: 2rem;">${newBookingsThisMonth}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <h5 class="card-title font-weight-bold">Total Staff</h5>
                        <p class="card-text font-weight-bold" style="color:darkblue; font-size: 2rem;">${totalStaff}</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card h-100 shadow-sm">
                    <div class="card-body text-center">
                        <h5 class="card-title font-weight-bold">Requested for Booking</h5>
                        <p class="card-text font-weight-bold" style="color:darkblue; font-size: 2rem;">${getContact}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.3/dist/Chart.min.js"></script>

</body>
</html>
