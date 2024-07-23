<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Rental System</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="stylesheet.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script defer type="text/javascript" src="../../javascript/adminIndex.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assert/css/userServices.css">
    
     <style type="text/css">
     
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
          .navbar {
    transition: background-color 0.5s ease;
    color:orange;
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
nav-item{
color:orange;
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
                    <li class="nav-item" >
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
    <br><br><br>
    <div class="video-container" style="height: 70%;">
        <!-- <video autoplay muted loop id="bgVideo">
            <source src="carhome3.jpg" type="video/mp4">
            Your browser does not support HTML5 video.
        </video> -->
        <img src="carhome3.jpg" alt="" >
        <div class="overlay">
            <h1 style="text-align:center;">Services</h1>
            
            <!-- <button class="stylish-button" >
        Rent Now <span class="arrow">→</span> -->
    </button>
        </div>
    </div>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card">
                    <img src="${pageContext.request.contextPath}/assert/images/lambo.jpg" class="card-img-top" alt="Luxury Cars">
                    <div class="card-body">
                        <h5 class="card-title">Luxury Cars</h5>
                        <p class="card-text">Experience the thrill of driving top-tier luxury cars.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img src="${pageContext.request.contextPath}/assert/images/bugati.jpg" class="card-img-top" alt="Affordable Rentals">
                    <div class="card-body">
                        <h5 class="card-title">Affordable Rentals</h5>
                        <p class="card-text">Quality cars at prices that won't break the bank.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card " style="text-align: center;">
                    <img src="${pageContext.request.contextPath}/assert/images/aboutcar2.jpg" class="card-img-top" alt="24/7 Support" style="height:190px; ">
                    <div class="card-body" style="height: 110px; text-align: center;">
                        <h5 class="card-title">24/7 Support</h5>
                        <p class="card-text">We're here for you any time, day or night.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br> <br> <br> <br> <br> <br> <br>
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6">
                    <h5>About Us</h5>
                    <p>At Go Trip, we are committed to providing the best car rental experience.
                     Our fleet includes a wide range of vehicles to suit all your travel needs.</p>
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
    <script>
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


        const currentPage = window.location.href;
if (currentPage.includes('services.html')) {
    document.getElementById('service').classList.add('active');
} else if (currentPage.includes('services.html')) {
    document.getElementById('service').classList.add('active');
}

        
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        // Show or hide the "back to top" button
        window.addEventListener('scroll', function() {
            const backToTop = document.getElementById('backToTop');
            if (window.scrollY > 200) {
                backToTop.style.display = 'block';
            } else {
                backToTop.style.display = 'none';
            }
        });    
        // Scroll to top functionality
        document.getElementById('backToTop').addEventListener('click', function() {
            window.scrollTo({ top: 0, behavior: 'smooth' });
        });
        </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
        </script>
            
</body>
</html>

