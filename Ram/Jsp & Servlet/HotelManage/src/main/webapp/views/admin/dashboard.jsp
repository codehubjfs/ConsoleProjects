<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Hotel Management System - Admin</title>
    <link
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
      rel="stylesheet"
    />
   <link rel ="stylesheet" href="${pageContext.request.contextPath}/css/admin/dashboard.css"> 
   
   
  </head>
  
 <% 
    HttpSession session1 = request.getSession(false);
    if (session1 == null || session1.getAttribute("username") == null) {
        response.sendRedirect("index.jsp");
    }
%>

  <body>

    <nav class="navbar navbar-expand-lg navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="./dashboard.jsp"
        ><img src="../../images/logo.jpg" alt="Logo"
      /></a>
      <span class="navbar-text mx-auto"
        ><span style="font-size: 30px; color:white ">Rk Hotel Management</span></span
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
          src="../../images/admin.jpg"
          alt="Profile Picture"
          class="dropdown-toggle"
          data-toggle="dropdown"
          aria-haspopup="true"
          aria-expanded="false"
        />
        <div class="dropdown-menu dropdown-menu-right">
          <a class="dropdown-item" href="${pageContext.request.contextPath}/ViewProfileServlet">View Profile</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/views/admin/account.jsp">Account Settings</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/LogoutAdminServlet">Sign Out</a>
        </div>
      </div>
    </nav>
    <div class="sidebar">
      <div class="list-group">
        <a href="${pageContext.request.contextPath}/views/admin/dashboard.jsp" class="list-group-item active">DASHBOARD</a>
        <a href="${pageContext.request.contextPath}/ViewBooking" class="list-group-item ">Bookings</a>
        <a href="${pageContext.request.contextPath}/ListStaffServlet" class="list-group-item">Front Desk Staff</a>
        <a href="${pageContext.request.contextPath}/ListKeeperServlet" class="list-group-item">Housekeeper Staff</a>
        <a href="#roomsSubmenu" class="list-group-item dropdown-toggle" data-toggle="collapse">Rooms</a>
        <div class="collapse" id="roomsSubmenu">
          <a href="${pageContext.request.contextPath}/ListRoomsServlet" class="list-group-item pl-5" >All Rooms</a>
          <a href="${pageContext.request.contextPath}/ListRoomTypeServlet" class="list-group-item pl-5 ">Room Types</a>
        </div>
        <a href="${pageContext.request.contextPath}/invoice.jsp" class="list-group-item">Invoice Details</a>
        <a href="${pageContext.request.contextPath}/ViewCustomer" class="list-group-item">Customers</a>
        <hr>
        <a href="${pageContext.request.contextPath}/settings.jsp" class="list-group-item">Settings</a>
      </div>
    </div>
    <div class="content">
        <div class="container mt-5 pt-5">
            <div class="row">
                <div class="col-12 d-flex justify-content-center align-items-center">
                    <h1 class="font-weight-bold" style="color:rgb(46, 20, 132);">Dashboard Overview</h1>
                </div>
            </div>
            
            <div class="row mt-3">
                <div class="col-md-6">
                    <div class="card h-100">
                        <div class="card-body">
                            <h5 class="card-title font-weight-bold">Total Bookings : <span style="font-weight: bolder; color:darkblue"> 123</span></h5>
                            <!-- <p class="card-text font-weight-bold">123</p> -->
                            <p class="card-text">This Month: <span style="font-weight: bolder ; color:darkblue"> 45</span> </p>
                            <p class="card-text">This Week: <span style="font-weight: bolder ; color:darkblue"> 45</span> </p>
                            <div class="chart-container">
                                <canvas id="bookingBarChart"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card h-100">
                        <div class="card-body">
                            <h5 class="card-title font-weight-bold">Rooms Available : <span style="font-weight: bolder; color:darkblue"> 45</span></h5>
                            <!-- <p class="card-text font-weight-bold">45</p> -->
                        </div>
                        <div class="card-body ">
                            <h5 class="card-title font-weight-bold ">Rooms Booked  </h5>
                            <p class="card-text ">Booked by M: <span style="font-weight: bolder ; color:darkblue"> 20</span> </p>
                            <p class="card-text">Booked by F:<span style="font-weight: bolder ; color:darkblue"> 15</span> </p>
                            <div class="chart-container">
                                <canvas id="roomsBookedChart"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row mt-3">
                <div class="col-md-6">
                    <div class="card h-100">
                        <div class="card-body">
                            <h5 class="card-title">New Customers</h5>
                            <p class="card-text">3 Joined</p>
                            <div class="table-container mt-4">
                                <table class="table">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>Profile Picture</th>
                                            <th>Name</th>
                                            <th>Status</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>
                                                <img src="./images/admin.jpg" alt="Customer 1" class="rounded-circle" width="50"/>
                                            </td>
                                            <td>Ram</td>
                                            <td>Joined</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <img src="./images/admin.jpg" alt="Customer 2" class="rounded-circle" width="50"/>
                                            </td>
                                            <td>Renish</td>
                                            <td>Joined</td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <img src="./images/admin.jpg" alt="Customer 3" class="rounded-circle" width="50"/>
                                            </td>
                                            <td>Rithik</td>
                                            <td>Joined</td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card h-100">
                        <div class="card-body">
                            <h5 class="card-title">Room Booking Chart</h5>
                            <div class="chart-container">
                                <canvas id="roomBookingChart"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="row mt-3">
                <div class="col-12">
                    <div class="card h-100">
                        <div class="card-body">
                            <h5 class="card-title">Booking Statistics</h5>
                            <div class="chart-container">
                                <canvas id="bookingChart"></canvas>
                            </div>
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
    <script>
      $(document).ready(function () {
        const ctx = document.getElementById("bookingChart").getContext("2d");
        const bookingChart = new Chart(ctx, {
          type: "bar",
          data: {
            labels: ["January", "February", "March", "April", "May", "June"],
            datasets: [
              {
                label: "# of Bookings",
                data: [12, 19, 3, 5, 2, 3],
                backgroundColor: [
                  "rgba(255, 99, 132, 0.2)",
                  "rgba(54, 162, 235, 0.2)",
                  "rgba(255, 206, 86, 0.2)",
                  "rgba(75, 192, 192, 0.2)",
                  "rgba(153, 102, 255, 0.2)",
                  "rgba(255, 159, 64, 0.2)",
                ],
                borderColor: [
                  "rgba(255, 99, 132, 1)",
                  "rgba(54, 162, 235, 1)",
                  "rgba(255, 206, 86, 1)",
                  "rgba(75, 192, 192, 1)",
                  "rgba(153, 102, 255, 1)",
                  "rgba(255, 159, 64, 1)",
                ],
                borderWidth: 1,
              },
            ],
          },
          options: {
            scales: {
              yAxes: [
                {
                  ticks: {
                    beginAtZero: true,
                  },
                },
              ],
            },
          },
        });
      });
      var ctx = document.getElementById('bookingBarChart').getContext('2d');
      var bookingBarChart = new Chart(ctx, {
          type: 'bar',
          data: {
              labels: ['Total', 'This Month', 'This Week'],
              datasets: [{
                  label: 'Bookings',
                  data: [123, 45, 10],
                  backgroundColor: ['#007bff', '#28a745', '#ffc107']
              }]
          },
          options: {
              scales: {
                  y: {
                      beginAtZero: true
                  }
              }
          }
      });

      var ctxRooms = document.getElementById('roomsBookedChart').getContext('2d');
      var roomsBookedChart = new Chart(ctxRooms, {
          type: 'bar',
          data: {
              labels: ['Booked by M', 'Booked by F'],
              datasets: [{
                  label: 'Rooms Booked',
                  data: [20, 15],
                  backgroundColor: ['#007bff', '#ffc107']
              }]
          },
          options: {
              scales: {
                  y: {
                      beginAtZero: true
                  }
              }
          }
      });
      
    </script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.7.0/chart.min.js"></script>
<script>
  
    document.addEventListener('DOMContentLoaded', function () {
        var ctx = document.getElementById('roomBookingChart').getContext('2d');
        var roomBookingChart = new Chart(ctx, {
            type: 'pie',
            data: {
                labels: ['Single', 'Double', 'Deluxe', 'Suite'],
                datasets: [{
                    label: 'Room Booking Chart',
                    data: [1913, 859, 482, 138],
                    backgroundColor: [
                        '#007bff',
                        '#28a745',
                        '#ffc107',
                        '#dc3545'
                    ]
                }]
            },
            options: {
                responsive: false, // Disable responsiveness
                maintainAspectRatio: false,
                plugins: {
                    legend: {
                        display: true, // Display legend
                        position: 'bottom', // Position legend at the bottom
                        labels: {
                            font: {
                                size: 10 // Set legend font size
                            }
                        }
                    }
                }
            }
        });
    });
</script>
        
  </body>
</html>
