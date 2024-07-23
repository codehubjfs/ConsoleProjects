<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Profile and Settings</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/viewProfile.css">
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="./main.html"><img src="${pageContext.request.contextPath}/images/logo.jpg" alt="Logo" /></a>
    <span class="navbar-text mx-auto"><span style="font-size: 30px;color:white">Rk Hotel Management</span></span>
    <div class="dropdown profile">
      <img src="${pageContext.request.contextPath}/images/admin.jpg" alt="Profile Picture" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" />
      <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
        <a class="dropdown-item" href="${pageContext.request.contextPath}/ViewProfileServlet">View Profile</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/views/admin/account.jsp">Account Settings</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/views/admin/index.jsp">Sign Out</a>
      </div>
    </div>
  </nav>

  <div class="sidebar">
      <div class="list-group">
        <a href="${pageContext.request.contextPath}/views/admin/dashboard.jsp" class="list-group-item ">DASHBOARD</a>
        <a href="${pageContext.request.contextPath}/ViewBooking" class="list-group-item ">Bookings</a>
        <a href="${pageContext.request.contextPath}/ListStaffServlet" class="list-group-item">Front Desk Staff</a>
        <a href="${pageContext.request.contextPath}/ListKeeperServlet" class="list-group-item">Housekeeper Staff</a>
        <a href="#roomsSubmenu" class="list-group-item dropdown-toggle" data-toggle="collapse">Rooms</a>
        <div class="collapse" id="roomsSubmenu">
          <a href="${pageContext.request.contextPath}/ListRoomsServlet" class="list-group-item pl-5" active>All Rooms</a>
          <a href="${pageContext.request.contextPath}/ListRoomTypeServlet" class="list-group-item pl-5 ">Room Types</a>
        </div>
        <a href="${pageContext.request.contextPath}/views/admin/invoice.jsp" class="list-group-item">Invoice Details</a>
        <a href="${pageContext.request.contextPath}/ViewCustomer" class="list-group-item">Customers</a>
        <hr>
        <a href="${pageContext.request.contextPath}/views/admin/settings.jsp" class="list-group-item">Settings</a>
      </div>
    </div>
  
  <div class="container content">
    <nav aria-label="breadcrumb" style="--bs-breadcrumb-divider: '>';">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/main.html">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">View Profile</li>
      </ol>
    </nav>

    <div id="viewProfilePage" class="mt-5">
      <h2 style="text-align: center;">View Profile</h2>
      <div class="card mb-4">
        <div class="card-header">Profile Details</div>
        <div class="card-body">
          <c:forEach var="admin" items="${admins}">
            <div class="row">
              <div class="col-md-4">
                <img src="${pageContext.request.contextPath}/images/admin.jpg" alt="Profile Picture" class="img-fluid rounded-circle mb-4" width="50%" height="50%">
              </div>
              <div class="col-md-8">

                <p><strong>Name : </strong> ${admin.name}</p>
                <p><strong>Email:</strong> ${admin.email}</p>
                <p><strong>Phone:</strong> ${admin.phoneNo}</p>
                <p><strong>Address:</strong> ${admin.address}</p>
                <p><strong>Role:</strong> Administrator</p>
                <p><strong>Member Since:</strong>September, 2002</p>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS and dependencies -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
