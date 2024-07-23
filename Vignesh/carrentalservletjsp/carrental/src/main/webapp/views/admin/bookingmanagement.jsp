<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="${ pageContext.request.contextPath}/css/adminBooking.css">
    <script defer type="text/javascript" src="../../javascript/adminBooking.js"></script>
    
    <style> @media (max-width: 1000px) {
            .sidebar {
                width: 100%;
                height: auto;
                position: relative;
            }
            .sidebar a {
                float: left;
            }
            .sidebar a:last-child {
                border-bottom: none;
            }
        }
        @media (min-width: 400px) {
            .sidebar {
                width: 250px;
                height: 100%;
                position: fixed;
            }
        }
        table.stylish-table {
            width: 100%;
            border-collapse: collapse;
            margin: 25px 0;
            font-size: 18px;
            text-align: left;
        }
        
        table.stylish-table thead tr {
            background-color: grey;
            color: #ffffff;
            text-align: left;
        }
        
        table.stylish-table th,
        table.stylish-table td {
            padding: 12px 15px;
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
    <div class="sidebar container-fluid">
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
             
              <li class="breadcrumb-item active" aria-current="page">Booking </li>
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

        <h1 >Booking Management</h1>
       
    
            <table class="stylish-table">
        <thead>
         
                <th>ID</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Status</th>
                
                <th>Rental Rate</th>
                
            
        </thead>
        <tbody>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
            <c:forEach var="booking" items="${listBookings}">
                <tr>
                    <td>${booking.bookingId}</td>
                    <td>${booking.startDate}</td>
                    <td>${booking.endDate}</td>
                    <td>${booking.bookingStatus}</td>
             <!--         <td>${booking.carId}</td>
                    <td>${booking.userId}</td> -->
                    <td>${booking.rentalRate}</td>
                    <td>
                      <!--   <a href="bookingServlet?action=edit&id=${booking.bookingId}">Edit</a>   -->
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    

  
    <script>
       
    </script>
</body>
</html>
