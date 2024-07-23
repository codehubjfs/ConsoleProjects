<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>CheckOut</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
    
    
    
        body {
            background-color: rgb(0, 0, 0);
            font-family: Arial, sans-serif;
            color: #fff;
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

        .checkOut-card {
            width: 50%;
            margin: auto;
            margin-top: 60px; /* Add margin-top to avoid overlap with navbar */
            background: white;
            border-radius: 1.5rem;
            box-shadow: 4px 3px 20px #3535358c;
            color:black;
        }

        .card-body {
            padding: 2rem;
        }

        .inputbox {
            color: #030303;
            width: 100%;
            padding: 0.5rem;
            border: none;
            border-bottom: 1.5px solid #ccc;
            margin-bottom: 1rem;
            border-radius: 0.3rem;
            font-family: 'Roboto', sans-serif;
            color: #615a5a;
            font-size: 1.1rem;
            font-weight: 500;
            outline: none;
        }

        .expcvv {
            display: flex;
            justify-content: space-between;
            padding-top: 0.6rem;
        }

        .expcvv_text {
            padding-right: 1rem;
        }

        .expcvv_text2 {
            padding: 0 1rem;
        }

        .button {
            background: linear-gradient(135deg, #753370 0%, #298096 100%);
            padding: 15px;
            border: none;
            border-radius: 50px;
            color: white;
            font-weight: 400;
            font-size: 1.2rem;
            margin-top: 10px;
            width: 100%;
            letter-spacing: .11rem;
            outline: none;
        }

        .button:hover {
            transform: scale(1.05) translateY(-3px);
            box-shadow: 3px 3px 6px #38373785;
        }

        @media only screen and (max-width: 1000px) {
            .checkOut-card {
                width: 90%;
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
              <!--   <img src="${pageContext.request.contextPath}/assert/images/prouser.jpg" alt="${username}'s profile picture" class="profile-image">  -->
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

    <div class="mainscreen">
        <div class="checkOut-card">
            <div class="card-body">
                <h1 class="text-center mb-4">Booking Info</h1>
                <form action="${pageContext.request.contextPath}/process-payment" method="POST">
                    <div class="mb-3">
                        <p><strong>Car Name:</strong> ${carName}</p>
                    </div>
                    <div class="mb-3">
                        <p><strong>Username:</strong> ${username}</p>
                    </div>
                    <div class="mb-3">
                        <p><strong>Pick-up Date:</strong> ${startDate}</p>
                    </div>
                    <div class="mb-3">
                        <p><strong>Drop-off Date:</strong> ${endDate}</p>
                    </div>
                    <div class="mb-3">
                        <p><strong>Total Amount:</strong> ${totalAmount}</p>
                    </div>

                    <input type="hidden" name="carName" value="${carName}">
                    <input type="hidden" name="username" value="${username}">
                    <input type="hidden" name="startDate" value="${startDate}">
                    <input type="hidden" name="endDate" value="${endDate}">
                    <input type="hidden" name="totalAmount" value="${totalAmount}">

                    <h2 class="text-center mb-4">Payment Information</h2>
                    <div class="mb-3">
                        <label for="name" class="form-label">Cardholder Name</label>
                        <input type="text" class="form-control" name="name" id="name" required />
                        <span id="name-error" class="error-message" style="color:red;"></span>
                    </div>
                    <div class="mb-3">
                        <label for="card_number" class="form-label">Card Number</label>
                        <input type="number" class="form-control" name="cardNumber" id="cardNumber" required />
                    </div>
                    <div class="mb-3">
                        <label for="card_type" class="form-label">Card Type</label>
                        <select class="form-control" name="card_type" id="card_type" required>
                            <option value="">--Select a Card Type--</option>
                            <option value="Visa">Visa</option>
                            <option value="RuPay">RuPay</option>
                            <option value="MasterCard">MasterCard</option>
                        </select>
                    </div>
                    <div class="mb-3 expcvv">
                        <div class="mb-3">
                            <label for="exp_date" class="form-label">Expiry Date</label>
                            <input type="date" class="form-control" name="exp_date" id="exp_date" required />
                        </div>
                        <div class="mb-3">
                            <label for="cvv" class="form-label">CVV</label>
                            <input type="number" class="form-control" name="cvv" id="cvv" required />
                        </div>
                    </div>
                    <button type="submit" class="button">Confirm Payment</button>
                </form>
            </div>
        </div>
    </div>

   
    <footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <h5>Contact Us</h5>
                    <p>123 Street Name, City, State</p>
                    <p>Phone: (123) 456-7890</p>
                    <p>Email: info@example.com</p>
                    <div class="social-icons">
                        <a href="#"><i class="fa fa-facebook"></i></a>
                        <a href="#"><i class="fa fa-twitter"></i></a>
                        <a href="#"><i class="fa fa-instagram"></i></a>
                    </div>
                </div>
                <div class="col-md-4">
                    <h5>Quick Links</h5>
                    <div class="quick-links">
                        <a href="#">Home</a>
                        <a href="#">Cars</a>
                        <a href="#">Rental Package</a>
                        <a href="#">Services</a>
                        <a href="#">About Us</a>
                        <a href="#">Contact Us</a>
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!-- Back to Top Button -->
    <div class="back-to-top">
        <i class="fa fa-chevron-up"></i>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz4fnFO9JReowSkCVNE5PtVf5M4CK6ULeEzOmHhJZZ9iVO+Y2EwD+bprE9" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-dDDghFBL8e96bOWJnFj5A4TElQm2p5Ch2xG7t2DdQQZB5ftD6DgHtyB/dZC3LeYF" crossorigin="anonymous"></script>
    <script>
        // Back to Top Button Functionality
        const backToTopButton = document.querySelector('.back-to-top');
        window.addEventListener('scroll', () => {
            if (window.scrollY > 300) {
                backToTopButton.style.display = 'block';
            } else {
                backToTopButton.style.display = 'none';
            }
        });
        backToTopButton.addEventListener('click', () => {
            window.scrollTo({ top: 0, behavior: 'smooth' });
        });
    </script>
    <script>
        function validateName(event) {
            const nameInput = event.target;
            const errorMessage = document.getElementById('name-error');
            const nameRegex = /^[a-zA-Z\s]*$/;
            if (!nameRegex.test(nameInput.value)) {
                errorMessage.textContent = 'Cardholder Name must contain only letters and spaces.';
                nameInput.setCustomValidity('Invalid');
            } else {
                errorMessage.textContent = '';
                nameInput.setCustomValidity('');
            }
        }
        window.addEventListener('DOMContentLoaded', (event) => {
            const nameInput = document.getElementById('name');
            nameInput.addEventListener('input', validateName);
        });
    </script>
</body>

</html>
