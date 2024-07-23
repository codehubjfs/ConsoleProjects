
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
    <link rel="stylesheet" href="../../css/userIndex.css">
    
    <style>
    /* Stylish Orange Button */

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
    
    </style>
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
                        <a class="nav-link" href="${pageContext.request.contextPath}/CarTempServlet">Cars</a>
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
                    <li class="nav-item">
                          <a href="loginpage.jsp" class="orange-button nav-link">Login / Register</a>
                   </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="video-container">
        <video autoplay muted loop id="bgVideo">
            <source src="../../images/mylivewallpapers-com-BMW-M5-F90-4K.mp4" type="video/mp4">
        </video>
        <div class="overlay">
            <h1>Have a Safe Journey with Us</h1>
            <p>Go Trip With Your Loved Ones</p>
            <button class="stylish-button" data-bs-toggle="cars.html" data-bs-target="cars.html">
              <a href="cars.jsp" style="text-decoration: none; color: rgb(253, 253, 253);">
                Rent Now </a>            
            </button>
        </div>
    </div>
    <div class="modal fade" id="bookingModal" tabindex="-1" aria-labelledby="bookingModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="bookingModalLabel">Car Rental Booking</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
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
                            <label for="phone" class="form-label">Phone Number</label>
                            <input type="text" class="form-control" id="phone" required>
                        </div>
                        <div class="mb-3">
                            <label for="carType" class="form-label">Car Type</label>
                            <select class="form-select" id="carType" required>
                                <option value="">Select a car type</option>
                                <option value="Luxury">Luxury</option>
                                <option value="Economy">Economy</option>
                                <option value="SUV">SUV</option>
                                <option value="Sports">Sports</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="pickupDate" class="form-label">Pick-up Date</label>
                            <input type="date" class="form-control" id="pickupDate" required>
                        </div>
                        <div class="mb-3">
                            <label for="returnDate" class="form-label">Return Date</label>
                            <input type="date" class="form-control" id="returnDate" required>
                        </div>
                        <button type="submit" class="btn btn-primary">
                             Book</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <section class="hero-section">
        <div class="hero-content">
            <p class="hero-title">We Are More Than</p>
            <p class="hero-subtitle">A Car Rental Company</p>
            <p class="hero-description">At Go Trip, we are committed to providing the best car rental experience.
                Our fleet includes a wide range of vehicles to suit all your travel needs.</p>
            <ul class="hero-list">
                <li class="hero-list-item">
                    <i class="fas fa-check-circle"></i>
                    SUV
                </li>
                <li class="hero-list-item">
                    <i class="fas fa-check-circle"></i>
                    Sedan
                </li>
                <li class="hero-list-item">
                    <i class="fas fa-check-circle"></i>
                    Luxury
                </li>
            </ul>
            <a href="#" class="read-more-btn">
                Read More 
                <i class="fas fa-arrow-right"></i>
            </a>
        </div>
        <div class="hero-image">
            <img src="../../images/aboutcar2.jpg" alt="Car Rental">
            <button class="play-button">
                <i class="fas fa-play"><a href="https://youtu.be/IXH2iEXnPM8?feature=shared"></a> </i>
            </button>
        </div>
    </section>
     <div class="background-container">
        <h2 style="text-align: center; margin-top: 50px; color: white;">Book Auto Rental</h2>
        <div class="content-container">
            
            <div class="rental-form">
                <select style="background-color: rgb(96, 95, 95);">
                    <option value=""  selected >Choose Car Type</option>
                    <option value="">SUV</option>
                    <option value="">Sedan</option>
                    <option value="">Luxury</option>
                    
                </select>
                <!-- <select>
                    <option value="" disabled selected>Pick Up Location</option>
                   
                </select> -->
                <input type="date" placeholder="Start Date" style="text-decoration: none;">
                <input type="date" placeholder="Return Date">
                <select>
                    <option value="" disabled selected>Location</option>
                    
                </select>
                <button><a href="cars.html" style="text-decoration: none; color: white;"> 
                    Rent Now</a></button>
            </div>
        </div>
    </div>

        
      </div>
          
<div id="carouselExampleControls" class="carousel slide " data-bs-ride="carousel">
    <br><br>
    <h2 style="text-align: center; color: white;">What We Offer</h2>
    <br><br>
    <p>HI I AM HERE SEE ME</p>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <div class="container">
          <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <img src="bugati.jpg" class="card-img-top" alt="Car Image">
                    <div class="price-badge">800/day</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Bugatti Mistral W16</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-primary" data-bs-toggle="modal"
                         data-bs-target="#bookingModal">
                          <a href="cars.html" style="text-decoration: none; color: white;">  Rent Now</a></button>
                    </div>
                    <p>HI I AM HERE SEE ME</p>
                </div>
                
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img src="aston.jpg" class="card-img-top" alt="Car Image">
                    <div class="price-badge">900/day</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Aston Martin</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-primary" data-bs-toggle="modal"
                         data-bs-target="#bookingModal">
                          <a href="cars.html" style="text-decoration: none; color: white;">  Rent Now</a></button>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img src="audirs.jpg" class="card-img-top" alt="Car Image">
                    <div class="price-badge">800/day</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Audi RS</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-primary" data-bs-toggle="modal"
                         data-bs-target="#bookingModal">
                          <a href="cars.html" style="text-decoration: none; color: white;">  Rent Now</a></button>
                    </div>
                </div>
            </div>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="container">
          <div class="row">
            <div class="col-md-4">
                <div class="card">
                    <img src="bently.jpg" class="card-img-top" alt="Car Image">
                    <div class="price-badge">900/day</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Bently</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-primary" data-bs-toggle="modal"
                         data-bs-target="#bookingModal">
                          <a href="cars.html" style="text-decoration: none; color: white;">  Rent Now</a></button>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img src="audirs.jpg" class="card-img-top" alt="Car Image">
                    <div class="price-badge">800/day</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Audi RS</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-primary" data-bs-toggle="modal"
                         data-bs-target="#bookingModal">
                          <a href="cars.html" style="text-decoration: none; color: white;">  Rent Now</a></button>
                    </div>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img src="aston.jpg" class="card-img-top" alt="Car Image">
                    <div class="price-badge">900/day</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Aston Martin</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-primary" data-bs-toggle="modal"
                         data-bs-target="#bookingModal">
                          <a href="cars.html" style="text-decoration: none; color: white;">  Rent Now</a></button>
                    </div>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Previous</span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="visually-hidden">Next</span>
    </button>
    <br><br>
  </div>







      
    
    <!-- <div class="about-us">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-10">
                    <div class="card flex-row shadow">
                        <img src="aboutus.jpg" class="card-img-left" alt="About Us Image" style="width: 50%;">
                        <div class="card-body">
                            <h4 class="card-title">About Us</h4>
                            <p class="card-text">At Go Trip, we are dedicated to providing you with the best car rental experience. Our fleet includes a wide range of vehicles to suit all your travel needs, whether you're looking for a luxury sedan, a practical SUV, or a sporty convertible. We pride ourselves on our customer service and aim to make your journey as smooth and enjoyable as possible.</p>
                            <p class="card-text">Founded in 2021, Go Trip has quickly become one of the most trusted car rental services in the
                                 region. Our commitment to quality and customer satisfaction sets us apart from the competition.
                                  Let us help you hit the road with confidence and style. Your adventure starts with Go Trip!</p>
                            <button class="btn btn-primary">Learn More</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> -->
  
<section id="services" class="services" >
    <div class="container">
        <br><br><br>
        <div class="row">
            <br><br><br>
            <h3 style="text-align: center; ">Our Services</h3>
            <br>
            <br>
            <div class="col-lg-4 col-md-6" style="text-align: center;">
                <div class="card1">
                    <img src="lambo.jpg" class="card1-img-top" alt="Luxury Cars">
                    <div class="card1-body">
                        <h5 class="card1-title">Luxury Cars</h5>
                        <p class="card1-text">Experience the thrill of driving top-tier luxury cars.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6" style="text-align: center;">
                <div class="card1">
                    <img src="afford2.jfif" class="card-img-top" alt="Affordable Rentals">
                    <div class="card1-body">
                        <h5 class="card1-title">Affordable Rentals</h5>
                        <p class="card1-text">Quality cars at prices that won't break the bank.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6" style="text-align: center;">
                <div class="card1 " style="text-align: center;">
                    <img src="24support.jpg" class="card1-img-top" alt="24/7 Support">
                    <div class="card-body" style="height: 120px; text-align: center;">
                        <h5 class="card1-title">24/7 Support</h5>
                        <p class="card1-text" style="text-align: center; padding-left: 25px;">We're here for you any time, day or night.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section id="reviews" class="reviews" >
    <div class="container">
        <div class="section-title">
            <h2>Customer Reviews</h2>
            <p>Hear what our customers have to say about their experiences with us.</p>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="review-card shadow">
                    <img src="reviewer1.jfif" class="reviewer-img" alt="Reviewer 1 Image">
                    <div class="review-content">
                        <h4 class="reviewer-name">John Doe</h4>
                        <div class="review-rating">
                            &#9733;&#9733;&#9733;&#9733;&#9734; <!-- 4 stars -->
                        </div>
                        <p class="review-text">Great service! The car was clean and the staff was very helpful. Will definitely rent again.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="review-card shadow" >
                    <img src="reviewer2.jfif" class="reviewer-img" alt="Reviewer 2 Image">
                    <div class="review-content">
                        <h4 class="reviewer-name">Jane Smith</h4>
                        <div class="review-rating">
                            &#9733;&#9733;&#9733;&#9733;&#9733; <!-- 5 stars -->
                        </div>
                        <p class="review-text">Amazing experience! The booking process was seamless and the car was in excellent condition.</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="review-card shadow" style="height: 100%;">
                    <img src="reviewer3.jfif" class="reviewer-img" alt="Reviewer 3 Image">
                    <div class="review-content">
                        <h4 class="reviewer-name">Michael Lee</h4>
                        <div class="review-rating">
                            &#9733;&#9733;&#9733;&#9733;&#9734; <!-- 4 stars -->
                        </div>
                        <p class="review-text">Good service overall. The car was a bit older, but it was clean and ran well.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section id="stats" class="stats" style="background-color: rgb(34,34,34);">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-6">
                <div class="stats-card shadow">
                    <div class="stats-icon">
                        <i class="fas fa-car"></i>
                    </div>
                    <div class="stats-content">
                        <h3>Total Cars</h3>
                        <span class="stats-number">100</span>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="stats-card shadow">
                    <div class="stats-icon">
                        <i class="fas fa-users"></i>
                    </div>
                    <div class="stats-content">
                        <h3>Total Customers</h3>
                        <span class="stats-number">500</span>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="stats-card shadow">
                    <div class="stats-icon">
                        <i class="fas fa-calendar-alt"></i>
                    </div>
                    <div class="stats-content">
                        <h3>Total Bookings</h3>
                        <span class="stats-number">1000</span>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-6">
                <div class="stats-card">
                    <div class="stats-icon">
                        <i class="fas fa-star"></i>
                    </div>
                    <div class="stats-content">
                        <h3>Overall Experience</h3>
                        <span class="stats-number">4.8/5</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<footer class="footer">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-4">
                <h5>About Us</h5>
                <p>At Go Trip, we are committed to providing the best car rental experience.
                     Our fleet includes a wide range of vehicles to suit all your travel needs.</p>
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
                <ul class="social-icons list-unstyled d-flex" >
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


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
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

        
    </script>

<div class="back-to-top" id="backToTop">
    <i class="fas fa-arrow-up"></i>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="">

    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
    </script>
</body>
</html>

