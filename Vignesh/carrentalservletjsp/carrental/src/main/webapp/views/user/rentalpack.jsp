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
    <link rel="stylesheet" href="../../css/userRentalpack.css">
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
        <img src="carhome3.jpg" alt="">
        <div class="overlay">
            <h1>Select Your Rental Package</h1>
            <p>One Day Offers</p>          
        </div>
    </div>
    <div class="container mt-5">
        <div class="row justify-content-center">
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
                         data-bs-target="#bookingModal">Rent Now</button>
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
                        <button class="btn btn-secondary">Rent Now</button>
                    </div>
                </div>
                
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img src="audia4.jfif" class="card-img-top" alt="Car Image">
                    <div class="price-badge">700/day</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Bugatti Mistral W16</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-secondary">Rent Now</button>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
    <div class="container mt-5" style="padding-bottom: 20px;">
        <div class="row justify-content-center">
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
                        <button class="btn btn-secondary">Rent Now</button>
                    </div>
                </div>
                
            </div>
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
                        <button class="btn btn-secondary">Rent Now</button>
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
                        <button class="btn btn-secondary">Rent Now</button>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
    <div class="background-container">
        
        <div class="content-container">
            
            <h3>Weekly Offers</h3>
                
            </div>
        </div>
    </div>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card">
                    <img src="bugati.jpg" class="card-img-top" alt="Car Image">
                    <div class="price-badge">800/week</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Bugatti Mistral W16</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-secondary">Rent Now</button>
                    </div>
                </div>
                
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img src="aston.jpg" class="card-img-top" alt="Car Image">
                    <div class="price-badge">900/week</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Aston Martin</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-secondary">Rent Now</button>
                    </div>
                </div>
                
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img src="audia4.jfif" class="card-img-top" alt="Car Image">
                    <div class="price-badge">700/week</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Bugatti Mistral W16</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-secondary">Rent Now</button>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
    <div class="container mt-5" style="padding-bottom: 20px;">
        <div class="row justify-content-center">
            <div class="col-md-4">
                <div class="card">
                    <img src="bugati.jpg" class="card-img-top" alt="Car Image">
                    <div class="price-badge">800/week</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Bugatti Mistral W16</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-secondary">Rent Now</button>
                    </div>
                </div>
                
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img src="aston.jpg" class="card-img-top" alt="Car Image">
                    <div class="price-badge">900/week</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Aston Martin</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-secondary">Rent Now</button>
                    </div>
                </div>
                
            </div>
            <div class="col-md-4">
                <div class="card">
                    <img src="audia4.jfif" class="card-img-top" alt="Car Image">
                    <div class="price-badge">700/week</div>
                    <div class="card-body row">
                        <h5 class="card-title col-12 text-center">Bugatti Mistral W16</h5>
                        <div class="col"><i class="fas fa-users"></i> 4</div>
                        <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                        <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                        <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                    </div>
                    <div class="card-footer">
                        <button class="btn btn-primary">Details</button>
                        <button class="btn btn-secondary">Rent Now</button>
                    </div>
                </div>
                
            </div>
        </div>
    </div>
    <div class="background-container">
        
        <div class="content-container">
            
            <h3>One Month Offers</h3>
                
            </div>
        </div>
        <div class="container mt-5" style="padding-bottom: 20px;">
            <div class="row justify-content-center">
                <div class="col-md-4">
                    <div class="card">
                        <img src="bugati.jpg" class="card-img-top" alt="Car Image">
                        <div class="price-badge">800/Month</div>
                        <div class="card-body row">
                            <h5 class="card-title col-12 text-center">Bugatti Mistral W16</h5>
                            <div class="col"><i class="fas fa-users"></i> 4</div>
                            <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                            <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                            <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                        </div>
                        <div class="card-footer">
                            <button class="btn btn-primary">Details</button>
                            <button class="btn btn-secondary">Rent Now</button>
                        </div>
                    </div>
                    
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <img src="aston.jpg" class="card-img-top" alt="Car Image">
                        <div class="price-badge">900/Month</div>
                        <div class="card-body row">
                            <h5 class="card-title col-12 text-center">Aston Martin</h5>
                            <div class="col"><i class="fas fa-users"></i> 4</div>
                            <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                            <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                            <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                        </div>
                        <div class="card-footer">
                            <button class="btn btn-primary">Details</button>
                            <button class="btn btn-secondary">Rent Now</button>
                        </div>
                    </div>
                    
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <img src="audia4.jfif" class="card-img-top" alt="Car Image">
                        <div class="price-badge">700/Month</div>
                        <div class="card-body row">
                            <h5 class="card-title col-12 text-center">Bugatti Mistral W16</h5>
                            <div class="col"><i class="fas fa-users"></i> 4</div>
                            <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                            <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                            <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                        </div>
                        <div class="card-footer">
                            <button class="btn btn-primary">Details</button>
                            <button class="btn btn-secondary">Rent Now</button>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
        <div class="container mt-5" style="padding-bottom: 20px;">
            <div class="row justify-content-center">
                <div class="col-md-4">
                    <div class="card">
                        <img src="bugati.jpg" class="card-img-top" alt="Car Image">
                        <div class="price-badge">800/Month</div>
                        <div class="card-body row">
                            <h5 class="card-title col-12 text-center">Bugatti Mistral W16</h5>
                            <div class="col"><i class="fas fa-users"></i> 4</div>
                            <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                            <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                            <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                        </div>
                        <div class="card-footer">
                            <button class="btn btn-primary">Details</button>
                            <button class="btn btn-secondary">Rent Now</button>
                        </div>
                    </div>
                    
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <img src="aston.jpg" class="card-img-top" alt="Car Image">
                        <div class="price-badge">900/Month</div>
                        <div class="card-body row">
                            <h5 class="card-title col-12 text-center">Aston Martin</h5>
                            <div class="col"><i class="fas fa-users"></i> 4</div>
                            <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                            <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                            <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                        </div>
                        <div class="card-footer">
                            <button class="btn btn-primary">Details</button>
                            <button class="btn btn-secondary">Rent Now</button>
                        </div>
                    </div>
                    
                </div>
                <div class="col-md-4">
                    <div class="card">
                        <img src="audia4.jfif" class="card-img-top" alt="Car Image">
                        <div class="price-badge">700/Month</div>
                        <div class="card-body row">
                            <h5 class="card-title col-12 text-center">Bugatti Mistral W16</h5>
                            <div class="col"><i class="fas fa-users"></i> 4</div>
                            <div class="col"><i class="fas fa-suitcase"></i> 2</div>
                            <div class="col"><i class="fas fa-gas-pump"></i> Petrol</div>
                            <div class="col"><i class="fas fa-car-side"></i> Suv</div>
                        </div>
                        <div class="card-footer">
                            <button class="btn btn-primary">Details</button>
                            <button class="btn btn-secondary">Rent Now</button>
                        </div>
                    </div>
                    
                </div>
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

