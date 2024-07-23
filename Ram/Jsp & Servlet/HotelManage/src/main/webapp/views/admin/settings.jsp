<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Hotel Management System - Admin</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="../../css/admin/adminSettings.css">
    
  </head>
  <body>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="./main.html"
        ><img src="./images/logo.jpg" alt="Logo"
      /></a>
      <span class="navbar-text mx-auto"
        ><span style="font-size: 30px; color:white">Rk Hotel Management</span></span
      >
      <!-- <form class="form-inline ml-auto mr-2">
        <input
          class="form-control mr-sm-2"
          type="search"
          placeholder="Search"
          aria-label="Search"
        />
        <button class="btn btn-outline-light" type="submit">Search</button>
      </form> -->
      <div class="dropdown profile">
        <img
          src="./images/admin.jpg"
          alt="Profile Picture"
          class="dropdown-toggle"
          data-toggle="dropdown"
          aria-haspopup="true"
          aria-expanded="false"
        />
        <div class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="viewProfile.jsp">View Profile</a>
          <a class="dropdown-item" href="account.jsp">Account Settings</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="index.jsp">Sign Out</a>
        </div>
      </div>
    </nav>

     <!-- Breadcrumbs -->
     <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="index.jsp">Home</a></li>
            <!-- <li class="breadcrumb-item"><a href="./settings.html">Settings</a></li> -->
            <li class="breadcrumb-item active" aria-current="page">Settings</li>
        </ol>
    </nav>

    <div class="sidebar">
      <div class="list-group">
        <a href="${pageContext.request.contextPath}/dashboard.jsp" class="list-group-item ">DASHBOARD</a>
        <a href="${pageContext.request.contextPath}/viewBooking.jsp" class="list-group-item ">Bookings</a>
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
        <a href="${pageContext.request.contextPath}/views/admin/settings.jsp" class="list-group-item">Settings</a>
      </div>
    </div>
  
    <div class="content">
        <div class="container mt-5">
            <!-- Button to trigger modal -->
            <button type="button" class="btn" data-toggle="modal" data-target="#generalSettingsModal" style="background-color: #343a40; color:white">
                General Settings
            </button>

            <!-- Modal -->
            <div class="modal fade" id="generalSettingsModal" tabindex="-1" aria-labelledby="generalSettingsModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="generalSettingsModalLabel">General Settings</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form>
                                <div class="form-group">
                                    <label for="hotelName">Hotel Name</label>
                                    <input type="text" class="form-control" id="hotelName" placeholder="Enter hotel name">
                                </div>
                                <div class="form-group">
                                    <label for="hotelAddress">Hotel Address</label>
                                    <input type="text" class="form-control" id="hotelAddress" placeholder="Enter hotel address">
                                </div>
                                <div class="form-group">
                                    <label for="copyright">Copyright</label>
                                    <input type="text" class="form-control" id="copyright" placeholder="Enter copyright">
                                </div>
                                <div class="form-group">
                                    <label for="mainSite">Main Site</label>
                                    <input type="text" class="form-control" id="mainSite" placeholder="Enter main site URL">
                                </div>
                                <div class="form-group">
                                    <label for="facebook">Facebook</label>
                                    <input type="text" class="form-control" id="facebook" placeholder="Enter Facebook URL">
                                </div>
                                <div class="form-group">
                                    <label for="instagram">Instagram</label>
                                    <input type="text" class="form-control" id="instagram" placeholder="Enter Instagram URL">
                                </div>
                                <button type="submit" class="btn btn-primary">Update</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- Account Settings Card -->
            <div class="card">
                <div class="card-header">
                    Account Settings
                </div>
                <div class="card-body">
                    <table id="accountActivityTable" class="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Browser</th>
                                <th>IP</th>
                                <th>Time</th>
                                <th>Activity</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Chrome</td>
                                <td>192.168.0.1</td>
                                <td>2024-06-05 12:30:00</td>
                                <td>
                                    <button type="button" class="btn btn-danger btn-sm">Deleted</button>
                                </td>
                            </tr>
                            <tr>
                                <td>Edge</td>
                                <td>192.168.0.2</td>
                                <td>2024-06-05 12:30:00</td>
                                <td>
                                    <button type="button" class="btn btn-success btn-sm">Created</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.24/js/dataTables.bootstrap4.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#accountActivityTable').DataTable();
        });
    </script>

  </body>
</html>
