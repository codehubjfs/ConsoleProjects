<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Rental System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="stylesheet.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script defer type="text/javascript" src="../../javascript/adminIndex.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/userRentalpack.css">
    
    <style >
    
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
    <div class="video-container" style="height: 70%;">  
        <img src="${pageContext.request.contextPath}/assert/images/carhome3.jpg" alt="" class="imgc">
        <div class="overlay">
            <h1 style="text-align:center;">Select Your Rental Package</h1>
            <p>One Day Offers</p>          
        </div>
    </div>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
                   
           <!--     <c:if test="${empty suvCars}">
        <div>No SUV Cars available.</div>
    </c:if>  -->
    <c:forEach var="car" items="${dayPackages}">
        <div style="display:inline-flex;">
            <div class="col-md-4">
                <div class="card" style="width:500px;margin-right:100px;margin-left:50px;">
                    <img src="<c:out value="${car.car_image_url}" />" class="card-img-top" alt="Car Image">
                    <div class="price-badge"><c:out value="${car.rental_rate}" /></div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center"><c:out value="${car.car_name}" /></h5>
                        <div class="col"><i class="fas fa-users"></i> <c:out value="${car.seat_count}" /></div>
                        <div class="col"><i class="fas fa-suitcase"></i> <c:out value="${car.bags}" /></div>
                        <div class="col"><i class="fas fa-gas-pump"></i> <c:out value="${car.fuel_type}" /></div>
                        <div class="col"><i class="fas fa-car-side"></i> <c:out value="${car.car_type}" /></div>
                    </div>
                    <div class="card-footer">
                        <button id="detailsBtn" class="btn btn-primary">Details</button>
                        <button class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#bookingModal">Rent Now</button>
                    </div>
                </div>
                <br><br>
            </div>
        </div>
    </c:forEach>
            
        </div>
    </div>
    <div class="background-container">
        
        <div class="content-container">
            
            <h3>Weekly Offers</h3>
                
            </div>
        </div>
    </div>
     
    <c:forEach var="car" items="${weekPackages}">
        <div style="display:inline-flex;">
            <div class="col-md-4">
                <div class="card" style="width:500px;margin-right:100px;margin-left:50px;">
                    <img src="<c:out value="${car.car_image_url}" />" class="card-img-top" alt="Car Image">
                    <div class="price-badge"><c:out value="${car.rental_rate}" /></div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center"><c:out value="${car.car_name}" /></h5>
                        <div class="col"><i class="fas fa-users"></i> <c:out value="${car.seat_count}" /></div>
                        <div class="col"><i class="fas fa-suitcase"></i> <c:out value="${car.bags}" /></div>
                        <div class="col"><i class="fas fa-gas-pump"></i> <c:out value="${car.fuel_type}" /></div>
                        <div class="col"><i class="fas fa-car-side"></i> <c:out value="${car.car_type}" /></div>
                    </div>
                    <div class="card-footer">
                        <button id="detailsBtn" class="btn btn-primary">Details</button>
                        <button class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#bookingModal">Rent Now</button>
                    </div>
                </div>
                <br><br>
            </div>
        </div>
    </c:forEach>
            
        </div>
    </div>
    <div class="background-container">
        
        <div class="content-container">
            
            <h3>One Month Offers</h3>
                
            </div>
        </div>
         
    <c:forEach var="car" items="${monthPackages}">
        <div style="display:inline-flex;">
            <div class="col-md-4">
                <div class="card" style="width:500px;margin-right:100px;margin-left:50px;">
                    <img src="<c:out value="${car.car_image_url}" />" class="card-img-top" alt="Car Image">
                    <div class="price-badge"><c:out value="${car.rental_rate}" /></div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center"><c:out value="${car.car_name}" /></h5>
                        <div class="col"><i class="fas fa-users"></i> <c:out value="${car.seat_count}" /></div>
                        <div class="col"><i class="fas fa-suitcase"></i> <c:out value="${car.bags}" /></div>
                        <div class="col"><i class="fas fa-gas-pump"></i> <c:out value="${car.fuel_type}" /></div>
                        <div class="col"><i class="fas fa-car-side"></i> <c:out value="${car.car_type}" /></div>
                    </div>
                    <div class="card-footer">
                        <button id="detailsBtn" class="btn btn-primary">Details</button>
                        <button class="btn btn-primary" data-bs-toggle="modal"
                                data-bs-target="#bookingModal">Rent Now</button>
                    </div>
                </div>
                <br><br>
            </div>
        </div>
    </c:forEach>
            
        </div>
    </div>
        <div class="modal fade" id="bookingModal" tabindex="-1" aria-labelledby="bookingModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="bookingModalLabel">Book a Car</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                    </div>
                    <div class="modal-body">
                        <form id="bookingForm">
                            <div class="mb-3">
                                <label for="fullName" class="form-label">Full Name</label>
                                <input type="text" class="form-control" id="fullName" required>
                            </div>
                            <div class="mb-3">
                                <label for="email" class="form-label">Email</label>
                                <input type="email" class="form-control" id="email" required>
                            </div>
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone</label>
                                <input type="tel" class="form-control" id="phone" required>
                            </div>
                            <div class="mb-3">
                                <label for="pickupDate" class="form-label">Pick-up Date</label>
                                <input type="date" class="form-control" id="pickupDate" required>
                            </div>
                            <div class="mb-3">
                                <label for="dropoffDate" class="form-label">Drop-off Date</label>
                                <input type="date" class="form-control" id="dropoffDate" required>
                            </div>
                            <div class="mb-3">
                                <label for="paymentMethod" class="form-label">Payment Method</label>
                                <select class="form-control" id="paymentMethod" required>
                                    <option value="">Select Payment Method</option>
                                    <option value="creditCard">Credit Card</option>
                                    <option value="paypal">PayPal</option>
                                    <option value="bankTransfer">Bank Transfer</option>
                                </select>
                            </div>
                            <div class="mb-3" id="creditCardInfo" style="display: none;">
                                <label for="cardNumber" class="form-label">Card Number</label>
                                <input type="text" class="form-control" id="cardNumber">
                                <label for="cardExpiry" class="form-label">Expiry Date</label>
                                <input type="text" class="form-control" id="cardExpiry">
                                <label for="cardCVC" class="form-label">CVC</label>
                                <input type="text" class="form-control" id="cardCVC">
                            </div>
                            <button type="submit" class="btn btn-primary">Book</button>
                        </form>
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
                        <li><a href="#">Home</a></li>
                        <li><a href="#">Cars</a></li>
                        <li><a href="#">Services</a></li>
                        <li><a href="#">About Us</a></li>
                        <li><a href="#">Contact Us</a></li>
                    </ul>
                </div>
                <div class="col-lg-4">
                    <h5>Contact Us</h5>
                    <p>Email: info@gotrip.com</p>
                    <p>Phone: +1234567890</p>
                    <h5>Follow Us</h5>
                    <ul class="social-icons list-unstyled">
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
    
    <!-- Back to Top Button -->
    <div class="back-to-top" id="backToTop">
        <i class="fas fa-arrow-up"></i>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>

const currentPage = window.location.href;
if (currentPage.includes('rentalpack.html')) {
    document.getElementById('rentpack').classList.add('active');
} else if (currentPage.includes('rentalpack.html')) {
    document.getElementById('rentpack').classList.add('active');
}





        document.getElementById('paymentMethod').addEventListener('change', function() {
            const creditCardInfo = document.getElementById('creditCardInfo');
            if (this.value === 'creditCard') {
                creditCardInfo.style.display = 'block';
            } else {
                creditCardInfo.style.display = 'none';
            }
        });

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
    </script>
   
    
</body>
</html>

