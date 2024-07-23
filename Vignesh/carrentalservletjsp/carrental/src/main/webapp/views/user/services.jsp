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
    <link rel="stylesheet" href="../../css/userServices.css">
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
                        <a class="nav-link" href="index.jsp" id="home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="cars.jsp">Cars</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="rentalpack.jsp">Rental Package</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="services.jsp">Services</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="aboutus.jsp">About Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="contactus.html">Contact Us</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="video-container" style="height: 70%;">
        <!-- <video autoplay muted loop id="bgVideo">
            <source src="carhome3.jpg" type="video/mp4">
            Your browser does not support HTML5 video.
        </video> -->
        <img src="carhome3.jpg" alt="" >
        <div class="overlay">
            <h1>Services</h1>
            <p>Best Car Rental Services</p>
            <!-- <button class="stylish-button" >
        Rent Now <span class="arrow">→</span> -->
    </button>
        </div>
    </div>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card">
                    <img src="lambo.jpg" class="card-img-top" alt="Luxury Cars">
                    <div class="card-body">
                        <h5 class="card-title">Luxury Cars</h5>
                        <p class="card-text">Experience the thrill of driving top-tier luxury cars.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img src="afford2.jfif" class="card-img-top" alt="Affordable Rentals">
                    <div class="card-body">
                        <h5 class="card-title">Affordable Rentals</h5>
                        <p class="card-text">Quality cars at prices that won't break the bank.</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card " style="text-align: center;">
                    <img src="24support.jpg" class="card-img-top" alt="24/7 Support">
                    <div class="card-body" style="height: 110px; text-align: center;">
                        <h5 class="card-title">24/7 Support</h5>
                        <p class="card-text">We're here for you any time, day or night.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
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

