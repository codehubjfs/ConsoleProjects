<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Rental System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script defer type="text/javascript" src="../../javascript/adminIndex.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/userCar.css">
    <style>
        .navbar {
    transition: background-color 0.5s ease;
}

.navbar-transparent {

    background-color: rgba(0, 0, 0, 0);
}

.navbar-scrolled {
    background-color: #343a40 !important;
}

.navbar-brand, .nav-link {
    color: #ffffff;
}

.navbar-brand:hover, .nav-link:hover {
    color: #d3d3d3;
}
        .card img {
            border-radius: 15px 15px 0 0;
        }
        .card-body {
            padding: 15px;
        }
        .card-title {
            font-size: 1.2rem;
            font-weight: bold;
        }
        .card-text {
            display: flex;
            align-items: center;
            margin-top: 5px;
        }
        .card-text i {
            margin-right: 10px;
        }
        .price-badge {
            background-color: #ff6600;
            border-radius: 50px;
            color: #fff;
            font-size: 1.2rem;
            font-weight: bold;
            padding: 5px 15px;
            position: absolute;
            top: 10px;
            left: 10px;
        }
        .card-footer {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 15px;
            background-color: #282828;
            border-top: 1px solid #333;
        }
        .btn {
            background-color: #ff6600;
            border: none;
            border-radius: 20px;
            padding: 10px 20px;
            color: #fff;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.3s;
        }
        .btn:hover {
            background-color: #e65c00;
            transform: translateX(5px);
        }

        .footer {
            background-color: rgb(27,27,27);
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
        .card-body .row {
    display: flex;
    flex-wrap: nowrap;
}
.card-body .col {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}
.background-container {
    background: url('wp4148990-lamborghini-aventador-svj-wallpapers.jpg') no-repeat center center fixed; 
    background-size: cover;
    height: 40%;
    overflow: auto;
}

.content-container {
    background: rgba(0, 0, 0, 0.7); 
    color: white;
    padding: 20px;
    max-width: 1000px;
    margin: 80px auto;
    border-radius: 10px;
    text-align: center;
}




.feature-item, .review-item {
    display: flex;
    align-items: center;
    font-size: 18px;
    background-color: #f7f7f7;
    padding: 10px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

.feature-item i, .review-item i {
    margin-right: 10px;
    color: orange;
}

.review-container {
    max-height: 400px;
    overflow-y: auto;
}

.review-item {
    padding: 15px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    display: flex;
    justify-content: space-between;
}
body {
    font-family: Arial, sans-serif;
}

button {
    padding: 10px 20px;
    font-size: 16px;
    
}

.feature-item, .review-item {
    display: flex;
    align-items: center;
    font-size: 18px;
    background-color: #f7f7f7;
    padding: 10px;
    border-radius: 10px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    margin-bottom: 10px;
}

.feature-item i, .review-item i {
    margin-right: 10px;
    color: orange;
}

.review-container {
    max-height: 400px;
    overflow-y: auto;
}

.like-btn {
    font-size: 16px;

    
}
.review-item {
    margin-bottom: 15px;
}
        .payment-method-selection {
  margin-bottom: 20px;
}

.payment-method {
  margin-bottom: 10px;
}

.payment-fields {
  display: none;
  margin-bottom: 20px;
}
.imgc{
width:100%;
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
    
        
        <img src="${pageContext.request.contextPath}/assert/images/carhome3.jpg" alt="" class="imgc">
        <div class="overlay" >
            <h1 style="text-align:center;">Select Your Car</h1>
            <div class="background-container">
        
        <div class="content-container">
            
            <h3>SUV Cars</h3>
                
            </div>
        </div>
                          <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
                   
             <c:if test="${empty luxuryCars}">
    <div>No Luxury Cars available.</div>
</c:if>
<c:forEach var="car" items="${luxuryCars}">
    <div style="display:inline-flex;">
        <div class="col-md-4">
            <div class="card" style="width:500px;margin-right:100px;margin-left:50px;">
                <img src="${pageContext.request.contextPath}/assert/images/audirs.jpg" alt="Car Image" />
                <div class="price-badge"><c:out value="${car.rental_rate}" /></div>
                <div class="card-body row">
                    <h5 class="card-title col-12 text-center"><c:out value="${car.car_name}" /></h5>
                    <div class="col"><i class="fas fa-users"></i> <c:out value="${car.seat_count}" /></div>
                    <div class="col"><i class="fas fa-suitcase"></i> <c:out value="${car.bags}" /></div>
                    <div class="col"><i class="fas fa-gas-pump"></i> <c:out value="${car.fuel_type}" /></div>
                    <div class="col"><i class="fas fa-car-side"></i> SUV</div>
                </div>
                <div class="card-footer">
                    <button id="detailsBtn" class="btn btn-primary">Details</button>
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#bookingModal-${car.car_id}">Rent Now</button>
                </div>
            </div>
            <br><br>
        </div>
    </div>

    <!-- Booking Modal -->
    <div class="modal fade" id="bookingModal-${car.car_id}" tabindex="-1" aria-labelledby="bookingModalLabel-${car.car_id}" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="bookingForm-${car.car_id}" action="${pageContext.request.contextPath}/rent" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title" id="bookingModalLabel-${car.car_id}">Rent Car - <c:out value="${car.car_name}" /></h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="carId" value="<c:out value='${car.car_id}' />">
                        <input type="hidden" name="carName" value="<c:out value='${car.car_name}' />">
                        <input type="hidden" name="username" value="<c:out value='${sessionScope.username}' />">
                        <div class="mb-3">
                            <label for="startDate-${car.car_id}" class="form-label">Pick-up Date</label>
                            <input type="date" class="form-control" id="startDate-${car.car_id}" name="startDate" required>
                            <div id="startDateError-${car.car_id}" class="invalid-feedback"></div>
                        </div>
                        <div class="mb-3">
                            <label for="endDate-${car.car_id}" class="form-label">Drop-off Date</label>
                            <input type="date" class="form-control" id="endDate-${car.car_id}" name="endDate" required>
                            <div id="endDateError-${car.car_id}" class="invalid-feedback"></div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Book</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</c:forEach>

            
        </div>
    </div>
     <br><br><br><br><br><br><br><br><br><br><br><br>
    
    <div class="background-container">
        
        <div class="content-container">
            
            <h3>Luxury Car</h3>
                
            </div>
        </div>
                     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
              <c:if test="${empty suvCars}">
        <div>No SUV Cars available.</div>
    </c:if>
    <c:forEach var="car" items="${suvCars}">
        <div style="display:inline-flex;">
            <div class="col-md-4">
                <div class="card" style="width:500px;margin-right:100px;margin-left:50px;">
                    <img src="${pageContext.request.contextPath}/assert/images/audirs.jpg" />" 
                    <div class="price-badge"><c:out value="${car.rental_rate}" /></div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center"><c:out value="${car.car_name}" /></h5>
                        <div class="col"><i class="fas fa-users"></i> <c:out value="${car.seat_count}" /></div>
                        <div class="col"><i class="fas fa-suitcase"></i> <c:out value="${car.bags}" /></div>
                        <div class="col"><i class="fas fa-gas-pump"></i> <c:out value="${car.fuel_type}" /></div>
                        <div class="col"><i class="fas fa-car-side"></i> SUV</div>
                    </div>
                    <div class="card-footer">
                    <button id="detailsBtn" class="btn btn-primary">Details</button>
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#bookingModal-${car.car_id}">Rent Now</button>
                </div>
                </div>
                <br><br>
            </div>
        </div>
         <!-- Booking Modal -->
    <div class="modal fade" id="bookingModal-${car.car_id}" tabindex="-1" aria-labelledby="bookingModalLabel-${car.car_id}" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="bookingForm-${car.car_id}" action="${pageContext.request.contextPath}/rent" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title" id="bookingModalLabel-${car.car_id}">Rent Car - <c:out value="${car.car_name}" /></h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="carId" value="<c:out value='${car.car_id}' />">
                        <input type="hidden" name="carName" value="<c:out value='${car.car_name}' />">
                        <input type="hidden" name="username" value="<c:out value='${sessionScope.username}' />">
                        <div class="mb-3">
                            <label for="startDate-${car.car_id}" class="form-label">Pick-up Date</label>
                            <input type="date" class="form-control" id="startDate-${car.car_id}" name="startDate" required>
                        </div>
                        <div class="mb-3">
                            <label for="endDate-${car.car_id}" class="form-label">Drop-off Date</label>
                            <input type="date" class="form-control" id="endDate-${car.car_id}" name="endDate" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Book</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    </c:forEach>

        <div class="background-container">
        
        <div class="content-container">
            
            <h3>Sedan Cars</h3>
                
            </div>
        </div>
        
        
       
        <c:forEach var="car" items="${sedanCars}">
            <div style="display:inline-flex;">
             <div class="col-md-4">
                <div class="card" style="width:500px;margin-right:100px;margin-left:50px;"  data-car-name="${car.car_name}">
                    <img src="${pageContext.request.contextPath}/assert/images/audirs.jpg" />" 
                    <div class="price-badge"><c:out value="${car.rental_rate}" /></div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center"><c:out value="${car.car_name}" /></h5>
                        <div class="col"><i class="fas fa-users"></i> <c:out value="${car.seat_count}" /></div>
                        <div class="col"><i class="fas fa-suitcase"></i>  <c:out value="${car.bags}" /></div>
                        <div class="col"><i class="fas fa-gas-pump"></i> <c:out value="${car.fuel_type}" /></div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                    <button id="detailsBtn" class="btn btn-primary">Details</button>
                    <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#bookingModal-${car.car_id}">Rent Now</button>
                </div>
                </div>
                <br><br>
                
            </div>
            </div>
           <!-- Booking Modal -->
    <div class="modal fade" id="bookingModal-${car.car_id}" tabindex="-1" aria-labelledby="bookingModalLabel-${car.car_id}" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form id="bookingForm-${car.car_id}" action="${pageContext.request.contextPath}/rent" method="post">
                    <div class="modal-header">
                        <h5 class="modal-title" id="bookingModalLabel-${car.car_id}">Rent Car - <c:out value="${car.car_name}" /></h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <input type="hidden" name="carId" value="<c:out value='${car.car_id}' />">
                        <input type="hidden" name="carName" value="<c:out value='${car.car_name}' />">
                        <input type="hidden" name="username" value="<c:out value='${sessionScope.username}' />">
                        <div class="mb-3">
                            <label for="startDate-${car.car_id}" class="form-label">Pick-up Date</label>
                            <input type="date" class="form-control" id="startDate-${car.car_id}" name="startDate" required>
                        </div>
                        <div class="mb-3">
                            <label for="endDate-${car.car_id}" class="form-label">Drop-off Date</label>
                            <input type="date" class="form-control" id="endDate-${car.car_id}" name="endDate" required>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Book</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
        </c:forEach>
        
        <div class="modal fade" id="bookingModal" tabindex="-1" aria-labelledby="bookingModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="bookingModalLabel">Book a Car</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <form id="bookingForm" action="${pageContext.request.contextPath}/rent" method="post">
                           
                                <label for="pickupDate" class="form-label">Pick-up Date</label>
                                <input type="date" class="form-control" id="pickupDate" required>
                            </div>
                            <div class="mb-3">
                                <label for="dropoffDate" class="form-label">Drop-off Date</label>
                                <input type="date" class="form-control" id="dropoffDate" required>
                            </div>
                            
                            <button type="submit" class="btn btn-primary">Book</button>
                        </form>
                        <br> <br>
                    </div>
                </div>
            </div>
        </div>
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <h5>About Us</h5>
                    <p>At Go Trip, we are committed to providing the best car rental experience. Our fleet includes a wide range of vehicles to suit all your travel needs.</p>
                </div>
                <div class="col-lg-4 col-md-6">
                    <h5>Quick Links</h5>
                    <ul class="quick-links list-unstyled">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="cars.html">Cars</a></li>
                        <li><a href="services.html">Services</a></li>
                        <li><a href="aboutus.html">About Us</a></li>
                        <li><a href="contactus.html">Contact Us</a></li>
                    </ul>
                </div>
                <div class="col-lg-4">
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

    <div id="detailsModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="detailsModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="detailsModalLabel">Car Features</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="car-image mb-4">
                        <img src="lambo.jpg" alt="Car Image" class="img-fluid rounded">
                    </div>
                    <h2>Features</h2>
                    <div class="row">
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-cogs"></i> Power Steering</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-music"></i> Music System</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-car"></i> Spare Tyre</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-wind"></i> Air Conditioning</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-smile"></i> Air Freshener</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-wrench"></i> Toolkit</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-plug"></i> Aux Input</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-cable"></i> Aux Cable</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-bluetooth"></i> Bluetooth</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-camera"></i> Reverse Camera</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-charging-station"></i> USB Charger</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-box"></i> Full Boot Space</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-mirror"></i> Electric ORVM</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-window-maximize"></i> Power Windows</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-key"></i> Keyless Entry</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-power-off"></i> Push Button Start</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-car-crash"></i> ADAS</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-car"></i> Anti-lock Braking System (ABS)</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-tachometer-alt"></i> Cruise Control</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-grip-lines"></i> Traction Control</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-microphone"></i> Voice Control</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-wind"></i> Air Purifier</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-chair"></i> Ventilated Front Seats</div>
                        </div>
                        <div class="col-6 mb-2">
                            <div class="feature-item"><i class="fas fa-car-side"></i> 4 Airbags</div>
                        </div>
                    </div>
                    <h2>Customer Reviews</h2>
                    <div class="review-container">
                        <div class="review-item shadow mb-2">
                            <div class="d-flex justify-content-between align-items-center">
                                <div><i class="fas fa-user"></i> "Great car, very comfortable!" - John D.</div>
                              
                            </div>
                        </div>
                        <div class="review-item shadow mb-2">
                            <div class="d-flex justify-content-between align-items-center">
                                <div><i class="fas fa-user"></i> "Smooth ride and excellent features." - Jane S.</div>
                                 
                            </div>
                        </div>
                        <div class="review-item shadow mb-2">
                            <div class="d-flex justify-content-between align-items-center">
                                <div><i class="fas fa-user"></i> "Loved the Bluetooth and reverse camera." - Mike W.</div>
                                
                            </div>
                        </div>
                        <div class="review-item shadow mb-2">
                            <div class="d-flex justify-content-between align-items-center">
                                <div><i class="fas fa-user"></i> "Highly recommend for long trips." - Emily R.</div>
                                
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <!-- Back to Top Button -->
    <div class="back-to-top" id="backToTop">
        <i class="fas fa-arrow-up"></i>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    
    <script>
    function validateForm(carId) {
        const startDateInput = document.getElementById(`startDate-${carId}`);
        const endDateInput = document.getElementById(`endDate-${carId}`);
        const startDateError = document.getElementById(`startDateError-${carId}`);
        const endDateError = document.getElementById(`endDateError-${carId}`);

        // Clear previous error messages
        startDateError.textContent = '';
        endDateError.textContent = '';
        startDateInput.classList.remove('is-invalid');
        endDateInput.classList.remove('is-invalid');
        
        const startDate = new Date(startDateInput.value);
        const endDate = new Date(endDateInput.value);
        const today = new Date();
        today.setHours(0, 0, 0, 0); // Set the time part to 00:00:00 to only compare dates

        let valid = true;

        if (startDate < today) {
            startDateError.textContent = "Pick-up date should be today or in the future.";
            startDateInput.classList.add('is-invalid');
            valid = false;
        }

        if (endDate <= startDate) {
            endDateError.textContent = "Drop-off date should be after the pick-up date.";
            endDateInput.classList.add('is-invalid');
            valid = false;
        }

        return valid;
    }
    </script>
    <script>
    

    
    
    
        document.getElementById('paymentMethod').addEventListener('change', function() {
            const creditCardInfo = document.getElementById('creditCardInfo');
            if (this.value === 'creditCard') {
                creditCardInfo.style.display = 'block';
            } else {
                creditCardInfo.style.display = 'none';
            }
        });

        const currentPage = window.location.href;
if (currentPage.includes('cars.html')) {
    document.getElementById('carlink').classList.add('active');
} else if (currentPage.includes('cars.html')) {
    document.getElementById('carlink').classList.add('active');
}




        document.getElementById('bookingForm').addEventListener('submit', function(event) {
            event.preventDefault();
            if (this.checkValidity()) {
                alert('Booked successfully!');
                const bookingModal = bootstrap.Modal.getInstance(document.getElementById('bookingModal'));
                bookingModal.hide();
            }
        });

        window.addEventListener('scroll', function() {
            const navbar = document.querySelector('.navbar');
            if (window.scrollY > 50) {
                navbar.classList.remove('navbar-transparent');
                navbar.classList.add('navbar-scrolled');
            } else {
                navbar.classList.remove('navbar-scrolled');
                navbar.classList.add('navbar-transparent');
            }
        });

                // JavaScript for like button functionality
document.addEventListener('DOMContentLoaded', function() {
    const likeButtons = document.querySelectorAll('.like-btn');

    likeButtons.forEach(function(button) {
        button.addEventListener('click', function() {
            // Example action (can be customized)
            if (button.classList.contains('btn-outline-primary')) {
                button.classList.remove('btn-outline-primary');
                button.classList.add('btn-primary');
            } else {
                button.classList.remove('btn-primary');
                button.classList.add('btn-outline-primary');
            }
        });
    });
});

// JavaScript for showing modal
document.getElementById('detailsBtn').onclick = function() {
    $('#detailsModal').modal('show');
};



$(document).ready(function() {
    $('#myCar').DataTable({
    	"pageLength": 5,
      //disable sorting on last column
      "columnDefs": [
        { "orderable": false, "targets": 5 }
      ],
      language: {
        //customize pagination prev and next buttons: use arrows instead of words
        'paginate': {
          'previous': '<span class="fa fa-chevron-left"></span>',
          'next': '<span class="fa fa-chevron-right"></span>'
        },
        //customize number of elements to be displayed
        "lengthMenu": 'Display <select class="form-control input-sm">'+
        '<option value="5">5</option>'+
        '<option value="10">10</option>'+
        '<option value="20">20</option>'+
        '<option value="30">30</option>'+
        '<option value="40">40</option>'+
        '<option value="50">50</option>'+
        '<option value="-1">All</option>'+
        '</select> results'
      }
    })  
} );

    </script>
   
    
</body>
</html>

