<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Profile and Settings</title>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/admin/account.css">
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
    <a class="navbar-brand" href="./main.html">
      <img src="./images/logo.jpg" alt="Logo" />
    </a>
    <span class="navbar-text mx-auto">
      <span style="font-size: 30px;color:white">Rk Hotel Management</span>
    </span>
    <div class="dropdown profile">
      <img src="./images/admin.jpg" alt="Profile Picture" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" />
      <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
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
        <a href="${pageContext.request.contextPath}/invoice.jsp" class="list-group-item">Invoice Details</a>
        <a href="${pageContext.request.contextPath}/ViewCustomer" class="list-group-item">Customers</a>
        <hr>
        <a href="${pageContext.request.contextPath}/settings.jsp" class="list-group-item">Settings</a>
      </div>
    </div>

  <div class="container content">
    <nav aria-label="breadcrumb" style="--bs-breadcrumb-divider: '>';">
      <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="./main.html">Home</a></li>
        <li class="breadcrumb-item active" aria-current="page">Account Settings</li>
      </ol>
    </nav>
   

    <div id="accountSettingsPage" class="mt-5">
      <h2 style="text-align: center;">Account Settings</h2>
      <div class="card mb-4">
        <div class="card-header">Edit Account Details</div>
        <div class="card-body">
          <form action="${pageContext.request.contextPath}/EditAccountServlet" method="post">
            <div class="form-group">
              <label for="accountName">Name</label>
              <input type="text" class="form-control" id="accountName" name="name" value="${admin.name}">
            </div>
            <div class="form-group">
              <label for="accountEmail">Email</label>
              <input type="email" class="form-control" id="accountEmail" name="email" value="${admin.email}">
            </div>
            <div class="form-group">
              <label for="accountPhone">Phone</label>
              <input type="text" class="form-control" id="accountPhone" name="phone" value="${admin.phoneNo}">
            </div>
            <div class="form-group">
              <label for="accountAddress">Address</label>
              <input type="text" class="form-control" id="accountAddress" name="address" value="${admin.address}">
            </div>
            <div class="form-group">
              <label for="accountRole">Role</label>
              <input type="text" class="form-control" id="accountRole" value="Administrator" readonly>
            </div>
            <div class="form-group">
              <label for="accountMemberSince">Member Since</label>
              <input type="text" class="form-control" id="accountMemberSince" value="January 1, 2020" readonly>
            </div>
            <button type="submit" class="btn btn-primary">Save Changes</button>
          </form>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap JS and dependencies -->
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

  <!-- Custom JS -->
  <script>
    document.getElementById('viewProfileLink').addEventListener('click', function() {
      document.getElementById('viewProfilePage').style.display = 'block';
      document.getElementById('accountSettingsPage').style.display = 'none';
    });

    document.getElementById('accountSettingsLink').addEventListener('click', function() {
      document.getElementById('viewProfilePage').style.display = 'none';
      document.getElementById('accountSettingsPage').style.display = 'block';
    });
  </script>
</body>
</html>
