<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Rent Dashboard</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
  <!--   <link  rel="stylesheet" href="${ pageContext.request.contextPath}/css/adminUserManagement.css"> -->
     <style>
          body {
            
            color: white;
            font-family: Arial, sans-serif;
        }
        
        .sidebar {
            background-color: #333;
            height: 100vh;
            padding: 20px;
            position: fixed;
            width: 250px;
        }
        .sidebar img {
            width: 50px;
            height: 50px;
            margin-bottom: 20px;
        }
        .sidebar a {
            color: white;
            display: block;
            margin: 10px 0;
            text-decoration: none;
        }
        .sidebar a:hover {
            background-color: #444;
            border-radius: 5px;
            padding: 10px;
        }
        .content {
            margin-left: 270px;
            padding: 20px;
        }
        .header {
            display: flex;
            justify-content: space-between;
            align-items: end;
            margin: 0;
            text-align: right;
        }
        .header .search-box {
            margin: 0;
            width: 450px;
        }
        .header .profile img {
            width: 50px;
            height: 50px;
            border-radius: 50%;
        }
        .card {
            background-color: #bcb5b5;
            border: none;
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 20px;
        }
        .card h6, .card p {
            margin: 0;
        }
        .progress-bar {
            background-color: #444;
        }
        input[type="text"], input[type="date"], input[type="time"], .btn {
            background-color: #444;
            border: none;
            border-radius: 5px;
            color: white;
            padding: 10px;
            margin: 5px 0;
        }
        .btn {
            background-color: rgb(103, 110, 151);
        }
        .bar1 .card img {
            margin-left: 20px;
            border-radius: 10px;
            width: 95%;
        }
        .chart2 img {
            width: 80%;
            margin-left: 51px;
            text-align: center;
            border-radius: 10px;
        }
        .chart2 {
            text-align: center;
        }
        .sidebar a {
            margin-top: 35px;
        }
        .card {
            background-color:rgb(214, 214, 214);
        }
        .name {
            padding-left: 910px;
        }
        .sidebar img {
            border-radius: 10px;
        }
        .nav-pills .nav-link {
            transition: background-color 0.5s ease;
        }
        .nav-pills .nav-link:hover {
            background-color: #edf0f2;
            color: black;
        }
        .full-height {
            height: 100vh;
        }
        .navbar-brand {
            display: flex;
            align-items: center;
        }
        .navbar-brand img {
            margin-right: 10px;
        }
        .features img {
            width: 20px;
            border-radius: 10px;
        }
        .dropdown{
            text-align: right;
        }
        .input-group .form-control{
            background-color:  #CADCFC;
        }
        button.btn{
            background-color:#333; 
            color: whitesmoke;
        }
        
        h1 {
            text-align: center;
            margin-top: 20px;
        }

        .table-container {
            width: 100%;
            margin: 5px auto;
           
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            overflow-x: auto;
        }

        .booking-table {
            width: 100%;
            /* border-collapse: collapse; */
            
        }
        .modal.fade
        {
            color: black;
        }
        .booking-table th,
        .booking-table td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        


        

        .booking-table tbody tr:last-child td {
            border-bottom: none;
        }
        

        .booking-table button {
            padding: 6px 12px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .booking-table button:hover {
            background-color: #0056b3;
        }
       .modal-body p{
            color: black !important;
        }
        .icon-bg {
    background-color: red; 
    padding: 5px; 
    border-radius: 50%; 
}
#profileMenu{
            position: absolute;
            right: 0;
            top: 60px;
            width: 200px;
            z-index: 1000;
            text-align: center;
            color: black;
        }
         body{
         background-image: linear-gradient(to right,#e3e2e2 ,white)
        }
        th{
       background-color:orange;
        }
        td{
        color:black
        }
        h1{
        color:black;
        }
        
        
        
        
       
     </style>
     
     
</head>
<body>
    <div class="sidebar">
        <img src="../../images/logo2.png" alt="Logo"> <span style="text-align: center; padding: 10px;">
            <span style="color: orange;">GO</span> TRIP </span>   
         <a id="dashboardLink" href="${pageContext.request.contextPath}/AdminDashboardServlet">Dashboard</a>
        <a href="${pageContext.request.contextPath}/AdminListCarServlet">Cars</a>
        <a href="${pageContext.request.contextPath}/BookingServlet">Bookings</a>
        <a href="${pageContext.request.contextPath}/UserControllerServlet">Customer</a>
        
        
    </div>
    <div class="content ">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
              <li class="breadcrumb-item"><a href="main.html">Dashboard</a></li>
             
              <li class="breadcrumb-item active" aria-current="page">User Management</li>
            </ol>
          </nav>
        <div class="header row">
            <div class="name col mx-0">
                <!-- <h6>Rose</h6> -->   
            </div>
            <div class="profile col mx-0">
                <a class="d-block" data-bs-toggle="collapse" href="#profileMenu" role="button" aria-expanded="false" aria-controls="profileMenu">
                    <img class="rounded-pill align-self-center" src="../../images/profile.jpg" height="50" width="60" alt="">
                </a>
                <div class="collapse mt-2" id="profileMenu">
                    <div class="card card-body">
                        <div class="row pt-2 pb-2 menuss">
                            <a href="#" class="dropdown-item">Profile</a>
                        </div>
                        <div class="row pt-2 pb-2 menuss">
                            <a href="#" class="dropdown-item">Settings</a>
                        </div>
                        <div class="row pt-2 pb-2 menuss">
                            <a href="loginadmin.html" class="dropdown-item">Logout</a>
                        </div>
                        
                        
                    </div>
                </div>
            </div>
        </div>

        <h1>Customer Management</h1>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div class="table-container" style="width:95%">
            <table class="booking-table" style="width:100%">
              <thead>
            <tr>
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Gender</th>
                <th>Phone Number</th>
                <th>Account Status</th>
                <th>License ID</th>
                <th>Username</th>
                <th></th>
              <!--   <th>Actions</th>  -->
            </tr>
        </thead>  <thead>
                    
                    <c:forEach items="${userList}" var="user">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.gender}</td>
                    <td>${user.phoneNumber}</td>
                    <td>${user.accountStatus}</td>
                    <td>${user.licenseId}</td>
                    <td>${user.username}</td>
                     <td>
                                <button type="button" class="btn btn-warning btn-sm edit-btn" data-bs-toggle="modal" data-bs-target="#editModal" data-id="${user.userId}">Edit</button>
                                <button type="button" class="btn btn-danger btn-sm delete-btn" data-bs-toggle="modal" data-bs-target="#deleteModal" data-id="${user.userId}">Delete</button>
                            </td>
           <!--      <button type="button" class="btn btn-warning btn-sm edit-btn" data-toggle="modal" data-target="#carModal"
                                data-id="${car.car_id}" data-name="${car.car_name}" data-vehicle="${car.vehicle_no}"
                                data-available="${car.available}" data-rate="${car.rental_rate}" data-seat="${car.seat_count}"
                                data-fuel="${car.fuel_type}" data-type="${car.car_type}" data-bags="${car.bags}" data-url="${car.car_image_url}">
                            Edit
                        </button>
                        <a href="CarController?action=delete&id=${car.car_id}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this car?')">Delete</a>
                    </td>--> 
                </tr>
            </c:forEach>
                </thead>
                <tbody>
                   
                   
                   
                </tbody>
            </table>
        </div>
    </div>

    <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="editModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editModalLabel">Edit Account Status</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="editForm" method="post" action="${pageContext.request.contextPath}/UserController">
    <input type="hidden" name="action" value="edit">
    <input type="hidden" name="userId" id="editBookingId">
    <div class="mb-3">
        <label for="editStatus" class="form-label">Account Status</label>
        <select name="accountStatus" class="form-control edit-sts" style="color: black;">
            <option value="Active">Active</option>
            <option value="Inactive">Inactive</option>
            <option value="Blocked">Blocked</option>
        </select>
    </div>
    <button type="submit" class="btn btn-primary btn-eddit">Save changes</button>
</form>

                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="viewModal" tabindex="-1" aria-labelledby="viewModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="viewModalLabel">View Booking</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <p><strong>Booking ID:</strong> <span id="viewBookingId"></span></p>
                    <p><strong>Name:</strong> <span id="viewCustomerName"></span></p>
                    <p><strong>Email:</strong> <span id="viewCar"></span></p>
                    <p><strong>Gender:</strong> <span id="viewDate"></span></p>
                    <p><strong>Phone Number:</strong> <span id="viewDuration"></span></p>
                    <p><strong>Account Status:</strong> <span id="viewStatus"></span></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
     <form id="deleteForm" method="post" action="${pageContext.request.contextPath}/UserController">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="userId" id="deleteBookingId">
    <div class="modal-body">
        <p>Are you sure you want to delete booking ID <span id="deleteBookingIdDisplay"></span>?</p>
    </div>
    <div class="modal-footer">
        <button type="button" class="btn btn-secondary mx-2" data-bs-dismiss="modal">Cancel</button>
        <button type="submit" class="btn btn-danger">Delete</button>
    </div>
</form>

            </div>
        </div>
    </div>
    <script>
    document.addEventListener("DOMContentLoaded", function() {
        // Handle Edit button click
        document.querySelectorAll('.edit-btn').forEach(button => {
            button.addEventListener('click', function() {
                const userId = this.getAttribute('data-id');
                // Populate modal fields with the selected user's data
                const userRow = this.closest('tr');
                document.getElementById('editBookingId').value = userId;
                document.querySelector('#editModal .edit-sts').value = userRow.children[6].textContent.trim(); // Account Status
            });
        });

        // Handle Delete button click
        document.querySelectorAll('.delete-btn').forEach(button => {
            button.addEventListener('click', function() {
                const userId = this.getAttribute('data-id');
                document.getElementById('deleteBookingId').value = userId;
                document.getElementById('deleteBookingIdDisplay').textContent = userId;
            });
        });
    });

    </script>

    <script src="../../javascript/adminUserManagement.js">
       
    </script>
</body>
</html>
