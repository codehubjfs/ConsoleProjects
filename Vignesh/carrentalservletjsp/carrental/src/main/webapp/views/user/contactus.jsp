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
    <link rel="stylesheet" href="../../css/userContactus.css">
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
                        <a class="nav-link" href="contactus.jsp">Contact Us</a>
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
            <h1>Contact Us</h1>
            <p>Contact Details</p>
            <!-- <button class="stylish-button" >
        Rent Now <span class="arrow">→</span> -->
    </button>
        </div>
    </div>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-3">
                <div class="card contact-card">
                    <div class="card-body">
                        <h5 class="card-title">Email</h5>
                        <p class="card-text"><i class="fas fa-envelope"></i> info@gotrip.com</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card contact-card">
                    <div class="card-body">
                        <h5 class="card-title">Phone</h5>
                        <p class="card-text"><i class="fas fa-phone"></i> +1234567890</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card contact-card">
                    <div class="card-body">
                        <h5 class="card-title">WhatsApp</h5>
                        <p class="card-text"><i class="fab fa-whatsapp"></i> +1234567890</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card contact-card">
                    <div class="card-body">
                        <h5 class="card-title">Address</h5>
                        <p class="card-text"><i class="fas fa-map-marker-alt"></i> 1 perur, Covai,India</p>
                    </div>
                </div>
            </div>
            <div class="col-md-3">
                <div class="card contact-card">
                    <div class="card-body">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d62670.15731101282!2d76.81555867195131!3d10.972064789139825!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ba85e9cedef11e5%3A0xe9eb7342f2325ca6!2z4K6V4K-L4K614K-I4K6V4K-NIOCuleCviuCuo-CvjeCun-CuvuCun-CvjeCun-CuruCvjQ!5e0!3m2!1sta!2sin!4v1718100391275!5m2!1sta!2sin" width="600" height="450" style="border:0;" allowfullscreen=""
                        loading="lazy" referrerpolicy="no-referrer-when-downgrade" style="width: 80%;"></iframe>
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
                         Our fleet includes a wide range of vehicles to suit all your travel 
                         needs.</p>
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
if (currentPage.includes('contactus.html')) {
    document.getElementById('contacts').classList.add('active');
} else if (currentPage.includes('contactus.html')) {
    document.getElementById('contacts').classList.add('active');
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
        document.getElementById('backToTop').addEventListener('click', function() {
            window.scrollTo({ top: 0, behavior: 'smooth' });
        });
        </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
        </script>
   
    
</body>
</html>

