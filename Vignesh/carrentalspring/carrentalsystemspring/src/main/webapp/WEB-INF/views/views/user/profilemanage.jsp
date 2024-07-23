<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Rental System</title>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            background-color: rgb(0, 0, 0);
            font-family: Arial, sans-serif;
        }

        .navbar {
            transition: background-color 0.5s ease;
        }

        .navbar-transparent {
            background-color: rgba(0, 0, 0, 0);
        }

        .navbar-scrolled {
            background-color: #343a40 !important;
        }

        .navbar-brand,
        .nav-link {
            color: #ffffff;
        }

        .navbar-brand:hover,
        .nav-link:hover {
            color: #d3d3d3;
        }

        .footer {
            background-color: #1c1c1c;
            color: #fff;
            padding: 40px 0;
        }

        .footer h5 {
            font-weight: bold;
            margin-bottom: 20px;
        }

        .footer p {
            margin-bottom: 10px;
        }

        .footer .social-icons a {
            color: #fff;
            margin-right: 10px;
            transition: color 0.3s;
        }

        .footer .social-icons a:hover {
            color: #ff6600;
        }

        .footer .quick-links a {
            color: #fff;
            display: block;
            margin-bottom: 5px;
            text-decoration: none;
            transition: color 0.3s;
        }

        .footer .quick-links a:hover {
            color: #ff6600;
        }

        .back-to-top {
            position: fixed;
            bottom: 20px;
            right: 20px;
            background-color: #ff6600;
            color: #fff;
            padding: 10px;
            border-radius: 50%;
            display: none;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .back-to-top:hover {
            background-color: #e65c00;
        }

        .btn.btn-primary {
            background-color: #ddd;
            color: black;
            box-shadow: none;
            border: none;
            font-size: 20px;
            width: 100%;
            height: 100%;
        }

        .btn.btn-primary:focus {
            box-shadow: none;
        }


        .booking-table {
            margin: 20px;
        }
        .booking-table th, .booking-table td {
            text-align: center;
        }
        .booking-table img {
            max-width: 100px;
        }
        .booking-table {
            margin-top: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            overflow: hidden;
        }
        .booking-table th, .booking-table td {
            text-align: center;
            vertical-align: middle;
        }
        .booking-table thead {
            background-color: #343a40;
            color: #ffffff;
        }
        .booking-table tbody tr:nth-child(odd) {
            background-color: #f2f2f2;
        }
        .booking-table tbody tr:nth-child(even) {
            background-color: #ffffff;
        }
        

        .orange-button {
            display: inline-block;
            padding: 12px 24px;
            background-color: #ff6600;
            color: #fff;
            font-size: 16px;
            font-weight: bold;
            text-align: center;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s, box-shadow 0.3s;
        }

        .orange-button:hover {
            background-color: #e65c00;
        }

        .orange-button:active {
            background-color: #cc5200;
            box-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.2);
        }
    .profile-image {
    border-radius: 50%;
    width: 40px;
    height: 40px;
    margin-right: 10px;
}
.profile-container{
   h4{
      color:white;
   }
   
}


.booking-table th, .booking-table td {
            vertical-align: middle;
            text-align: center;
        }
        .booking-table th {
            background-color: #343a40;
            color: white;
        }
        .booking-table td {
            background-color: #f8f9fa;
        }
        .booking-table tr:nth-child(even) td {
            background-color: #e9ecef;
        }
        .booking-table img {
            max-width: 100%;
            max-height: 100px;
        }
         .booking-table th, .booking-table td {
            vertical-align: middle;
            text-align: center;
            padding: 20px; /* Increase padding for more space */
            min-width: 150px; /* Increase width */
            min-height: 50px; /* Increase height */
        }
        .booking-table th {
            background-color: #343a40;
            color: white;
        }
        .booking-table td {
            background-color: #f8f9fa;
        }
        .booking-table tr:nth-child(even) td {
            background-color: #e9ecef;
        }
        .booking-table img {
            max-width: 50px;
            max-height: 50px;
        }
        /* Increase the overall table width */
        .table-container {
            width: 100%;
        }
        
    </style>
</head>

<body>

 
    <nav class="navbar navbar-expand-lg navbar-dark navbar-transparent fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"><span style="color: orange;">GO</span> TRIP<img src="logo.webp" alt=""></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/car" id="home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cars">Cars</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/rental-packages">Rental Package</a>
                    </li>
                    <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/services">Services</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/aboutus">About Us</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${pageContext.request.contextPath}/contactus">Contact Us</a>
        </li>
                    
                    <li class="nav-item" >
                      <!--   <form action=""${pageContext.request.contextPath}/login" style="background-color:black;">
                       <button id="">
                       
                       <h4> <li><img src="${pageContext.request.contextPath}/assert/images/prouser.jpg" alt="${username}'s profile picture" class="profile-image">
                    </li>
                       <a href="${pageContext.request.contextPath}/booking-history" style="text-decoration:none; color:black; border:none;">   ${username}  </a> </h4>
                       
                          <a href="${pageContext.request.contextPath}/login" class="orange-button nav-link"  id="login-register-button">
                          Login / Register</a>
                          </button>
                          
                          </form> -->
                          <c:choose>
    <c:when test="${not empty username}">
        <div class="profile-container">
            <a href="${pageContext.request.contextPath}/booking-history" style="text-decoration:none; color:black; display:flex; align-items:center;">
                <img src="${pageContext.request.contextPath}/assert/images/prouser.jpg" alt="${username}'s profile picture" class="profile-image">
                <h4>${username}</h4>
            </a>
        <!--     <form action="${pageContext.request.contextPath}/logout" method="post" style="margin-left: 5px;">
                <button type="submit" class="orange-button nav-link" id="logout-button">Logout</button>
            </form> -->
        </div>
    </c:when>
    <c:otherwise>
        <form action="${pageContext.request.contextPath}/login">
            <button type="submit" class="orange-button nav-link" id="login-register-button">Login / Register</button>
        </form>
    </c:otherwise>
</c:choose>
                          
                   </li>
                </ul>
            </div>
        </div>
    </nav>
    <br><br><br><br><br>
    <div class="container">
        <h2 class="my-4 text-center" style="color:white;">Booking History</h2>
        <table class="table table-striped booking-table ">
            <thead>
                <tr>
                    <th>Booking ID</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Status</th>
                    <th>Car Name</th>
                    
                    <th>Rental Rate</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="booking" items="${bookingHistory}">
                    <tr>
                        <td><c:out value="${booking.booking_id}" /></td>
                        <td><c:out value="${booking.start_date}" /></td>
                        <td><c:out value="${booking.end_date}" /></td>
                        <td><c:out value="${booking.booking_status}" /></td>
                        <td><c:out value="${booking.car_name}" /></td>
                        
                        <td><c:out value="${booking.rental_rate}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
    <!-- Include Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    

        

    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-4">
                    <h5>About Us</h5>
                    <p>At Go Trip, we are committed to providing the best car rental experience. Our fleet includes a wide range of vehicles to suit all your travel needs.</p>
                </div>
                <div class="col-lg-4 col-md-4">
                    <h5>Quick Links</h5>
                    <ul class="quick-links list-unstyled">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="cars.html">Cars</a></li>
                        <li><a href="services.html">Services</a></li>
                        <li><a href="aboutus.html">About Us</a></li>
                        <li><a href="contactus.html">Contact Us</a></li>
                    </ul>
                </div>
                <div class="col-lg-4 col-md-4">
                    <h5>Contact Us</h5>
                    <p>Email: info@gotrip.com</p>
                    <p>Phone: +1234567890</p>
                    <h5>Follow Us</h5>
                    <ul class="social-icons list-unstyled d-flex">
                        <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                        <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fab fa-instagram"></i></a></li>
                        <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="row mt-4">
                <div class="col-lg-12 text-center">
                    <p>&copy; 2024 Go Trip. All rights reserved.</p>
                </div>
            </div>
        </div>
    </footer>

    <div class="back-to-top" id="backToTop">
        <i class="fas fa-arrow-up"></i>
    </div>

    <!-- Payment Success Modal -->
    <div class="modal fade" id="paymentSuccessModal" tabindex="-1" aria-labelledby="paymentSuccessModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="paymentSuccessModalLabel">Payment Successful</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body text-center">
                    <div class="icon">
                        <i class="fas fa-check-circle"></i>
                    </div>
                    <p>Your payment has been successfully processed. Thank you for your purchase!</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-bs-dismiss="modal">OK</button>
                </div>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
           
   
</body>

</html>
