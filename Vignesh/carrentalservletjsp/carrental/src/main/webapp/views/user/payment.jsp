<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Car Rental System</title>
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

        .payment-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 400px;
            margin: 50px auto;
            text-align: left;
        }

        .payment-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .payment-header h2 {
            margin: 0;
        }

        .payment-header .amount {
            font-size: 1.5em;
            font-weight: bold;
        }

        .payment-method {
            margin: 10px 0;
            cursor: pointer;
            display: flex;
            align-items: center;
        }

        .payment-method img {
            width: 30px;
            height: 30px;
            margin-right: 10px;
        }

        .payment-details {
            display: none;
            margin-top: 20px;
        }

        .payment-details input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .payment-details button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .payment-details button:hover {
            background-color: #0056b3;
        }

        .invalid-feedback {
            display: none;
            color: red;
            font-size: 0.875em;
        }

        .invalid-feedback.active {
            display: block;
        }

        .modal-content {
            border-radius: 15px;
            padding: 20px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
        }

        .modal-header {
            border-bottom: none;
            padding-bottom: 0;
        }

        .modal-title {
            font-size: 1.25rem;
            font-weight: bold;
        }

        .modal-body {
            text-align: center;
        }

        .modal-body .icon {
            font-size: 3rem;
            color: #28a745;
            margin-bottom: 10px;
        }

        .modal-footer {
            border-top: none;
            padding-top: 0;
        }

        .modal-footer .btn {
            padding: 10px 20px;
            border-radius: 5px;
            background-color: #007bff;
            color: white;
            font-size: 1rem;
        }

        .modal-footer .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark navbar-transparent fixed-top">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"><span style="color: orange;">GO</span> TRIP<img src="logo.webp" alt=""></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
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

    <div class="payment-container mt-5">
        <div class="payment-header">
            <h2>Select Payment Method</h2>
            <div class="amount">$99.99</div>
        </div>

        <div class="payment-method" onclick="showPaymentDetails('gpay')">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Google_Pay_Logo.svg/512px-Google_Pay_Logo.svg.png" alt="Google Pay">
            <span>Google Pay</span>
        </div>
        <div class="payment-method" onclick="showPaymentDetails('credit-card')">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Credit_card_font_awesome.svg/512px-Credit_card_font_awesome.svg.png" alt="Credit Card">
            <span>Credit Card</span>
        </div>
        <div class="payment-method" onclick="showPaymentDetails('paypal')">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/PayPal_logo.svg/512px-PayPal_logo.svg.png" alt="PayPal">
            <span>PayPal</span>
        </div>
        <div class="payment-method" onclick="showPaymentDetails('netbanking')">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Netbanking_Icon.svg/120px-Netbanking_Icon.svg.png" alt="Net Banking">
            <span>Net Banking</span>
        </div>
        <div class="payment-method" onclick="showPaymentDetails('wallet')">
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Wallet_Icon.svg/512px-Wallet_Icon.svg.png" alt="Wallet">
            <span>Wallet</span>
        </div>

        <div id="gpay" class="payment-details">
            <h3>Google Pay</h3>
            <input type="text" id="gpay-upi" placeholder="Enter UPI ID">
            <div class="invalid-feedback" id="gpay-upi-error">Please enter a valid UPI ID.</div>
            <button onclick="validatePaymentDetails('gpay')">Pay Now</button>
        </div>

        <div id="credit-card" class="payment-details">
            <h3>Credit Card</h3>
            <input type="text" id="credit-card-number" placeholder="Card Number">
            <div class="invalid-feedback" id="credit-card-number-error">Please enter a valid card number.</div>
            <input type="text" id="credit-card-expiry" placeholder="Expiry Date">
            <div class="invalid-feedback" id="credit-card-expiry-error">Please enter a valid expiry date.</div>
            <input type="text" id="credit-card-cvv" placeholder="CVV">
            <div class="invalid-feedback" id="credit-card-cvv-error">Please enter a valid CVV.</div>
            <button onclick="validatePaymentDetails('credit-card')">Pay Now</button>
        </div>

        <div id="paypal" class="payment-details">
            <h3>PayPal</h3>
            <input type="text" id="paypal-email" placeholder="Email">
            <div class="invalid-feedback" id="paypal-email-error">Please enter a valid email.</div>
            <button onclick="validatePaymentDetails('paypal')">Pay Now</button>
        </div>

        <div id="netbanking" class="payment-details">
            <h3>Net Banking</h3>
            <input type="text" id="netbanking-bank" placeholder="Bank Name">
            <div class="invalid-feedback" id="netbanking-bank-error">Please enter a valid bank name.</div>
            <input type="text" id="netbanking-account" placeholder="Account Number">
            <div class="invalid-feedback" id="netbanking-account-error">Please enter a valid account number.</div>
            <input type="text" id="netbanking-ifsc" placeholder="IFSC Code">
            <div class="invalid-feedback" id="netbanking-ifsc-error">Please enter a valid IFSC code.</div>
            <button onclick="validatePaymentDetails('netbanking')">Pay Now</button>
        </div>

        <div id="wallet" class="payment-details">
            <h3>Wallet</h3>
            <input type="text" id="wallet-number" placeholder="Mobile Number">
            <div class="invalid-feedback" id="wallet-number-error">Please enter a valid mobile number.</div>
            <button onclick="validatePaymentDetails('wallet')">Pay Now</button>
        </div>
    </div>

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
    <script>
        function showPaymentDetails(method) {
            document.querySelectorAll('.payment-details').forEach(div => {
                div.style.display = 'none';
            });
            document.getElementById(method).style.display = 'block';
        }

        function validatePaymentDetails(method) {
            let isValid = true;

            if (method === 'gpay') {
                const upi = document.getElementById('gpay-upi');
                const upiError = document.getElementById('gpay-upi-error');
                if (upi.value === '') {
                    upi.classList.add('is-invalid');
                    upiError.classList.add('active');
                    isValid = false;
                } else {
                    upi.classList.remove('is-invalid');
                    upiError.classList.remove('active');
                }
            } else if (method === 'credit-card') {
                const number = document.getElementById('credit-card-number');
                const expiry = document.getElementById('credit-card-expiry');
                const cvv = document.getElementById('credit-card-cvv');
                const numberError = document.getElementById('credit-card-number-error');
                const expiryError = document.getElementById('credit-card-expiry-error');
                const cvvError = document.getElementById('credit-card-cvv-error');
                
                if (number.value === '') {
                    number.classList.add('is-invalid');
                    numberError.classList.add('active');
                    isValid = false;
                } else {
                    number.classList.remove('is-invalid');
                    numberError.classList.remove('active');
                }
                if (expiry.value === '') {
                    expiry.classList.add('is-invalid');
                    expiryError.classList.add('active');
                    isValid = false;
                } else {
                    expiry.classList.remove('is-invalid');
                    expiryError.classList.remove('active');
                }
                if (cvv.value === '') {
                    cvv.classList.add('is-invalid');
                    cvvError.classList.add('active');
                    isValid = false;
                } else {
                    cvv.classList.remove('is-invalid');
                    cvvError.classList.remove('active');
                }
            } else if (method === 'paypal') {
                const email = document.getElementById('paypal-email');
                const emailError = document.getElementById('paypal-email-error');
                if (email.value === '') {
                    email.classList.add('is-invalid');
                    emailError.classList.add('active');
                    isValid = false;
                } else {
                    email.classList.remove('is-invalid');
                    emailError.classList.remove('active');
                }
            } else if (method === 'netbanking') {
                const bank = document.getElementById('netbanking-bank');
                const account = document.getElementById('netbanking-account');
                const ifsc = document.getElementById('netbanking-ifsc');
                const bankError = document.getElementById('netbanking-bank-error');
                const accountError = document.getElementById('netbanking-account-error');
                const ifscError = document.getElementById('netbanking-ifsc-error');
                
                if (bank.value === '') {
                    bank.classList.add('is-invalid');
                    bankError.classList.add('active');
                    isValid = false;
                } else {
                    bank.classList.remove('is-invalid');
                    bankError.classList.remove('active');
                }
                if (account.value === '') {
                    account.classList.add('is-invalid');
                    accountError.classList.add('active');
                    isValid = false;
                } else {
                    account.classList.remove('is-invalid');
                    accountError.classList.remove('active');
                }
                if (ifsc.value === '') {
                    ifsc.classList.add('is-invalid');
                    ifscError.classList.add('active');
                    isValid = false;
                } else {
                    ifsc.classList.remove('is-invalid');
                    ifscError.classList.remove('active');
                }
            } else if (method === 'wallet') {
                const number = document.getElementById('wallet-number');
                const numberError = document.getElementById('wallet-number-error');
                if (number.value === '') {
                    number.classList.add('is-invalid');
                    numberError.classList.add('active');
                    isValid = false;
                } else {
                    number.classList.remove('is-invalid');
                    numberError.classList.remove('active');
                }
            }

            if (isValid) {
                const myModal = new bootstrap.Modal(document.getElementById('paymentSuccessModal'));
                myModal.show();
            }
        }
    </script>
</body>

</html>
