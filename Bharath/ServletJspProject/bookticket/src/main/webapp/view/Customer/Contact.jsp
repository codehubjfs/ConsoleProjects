<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="image/bus.png" width="40px">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="Style.css">
    <script src="Script.js"></script>
    <script src="../script.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link rel="icon" type="image/x-icon" href="Images/bus.png" width="40px">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>Travel-Contact us</title>
	<style>
	body {
    font-family: Arial, sans-serif;
    background-color: #415268;
}
#ids{
    background-color: rgb(241, 240, 247);
    margin-bottom: 10px;
    position:sticky;
    top:0px;
    z-index: 1;
}
.navbar-brand span {
    display: inline-block;
}
.fse{
    font-size: 17px;
    font-weight:450;
    color: rgba(43, 80, 182, 0.938)!important;
}
.space{
    margin-left:100px;
    /* word-spacing: 20px; */
}
a:hover{
    color: rgb(241, 6, 190)!important;
}
.navbar-nav .nav-link.active {
    background: #243346;
    color: white !important;
    height: auto;
}
/* Footer */
footer {
    background-color: rgb(241, 240, 247);
    color: black;
}

/* Section: Social media */
footer .social-media {
    background-color: rgb(241, 240, 247);
    padding: 2rem;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

footer .social-media .left {
    margin-left: 2rem;
    font-weight: 500;
}

footer .social-media .right a {
    margin-right: 1rem;
}

footer .social-media .right img {
    width: 25px;
}

/* Footer columns */
footer .footer-columns {
    margin-top: 2rem;
    text-align: center;
}

footer .footer-columns .column {
    margin-bottom: 1.5rem;
}

footer .footer-columns .column h6 {
    text-transform: uppercase;
    font-weight: bold;
    margin-bottom: 1rem;
}

footer .footer-columns .column p, 
footer .footer-columns .column a {
    font-weight: normal;
    text-decoration: none;
    color: inherit;
}

footer .footer-columns .column a:hover {
    text-decoration: underline;
}

footer .footer-columns .contact p {
    font-weight: normal;
}

/* Copyright section */
footer .copyright {
    padding: 1rem;
    font-weight: bold;
    background-color: rgb(241, 240, 247);
}

/* Ensure equal spacing */
footer .container {
    margin-left: auto;
    margin-right: auto;
    padding-left: 15px;
    padding-right: 15px;
}

/* Responsive design */
@media (min-width: 768px) {
    footer .footer-columns {
        text-align: left;
    }
}

.footlast{
    background-color: rgb(241, 240, 247);
}
.formbox{
	position:relative;
	margin-top: 10px;
	width: 450px;
	height: 580px;
    font-size: 15px;
    font-family: Helvetica;
	background: #e7e7ef;
	border-radius: 5px;
    margin-left: 35%;
    border:2px solid #dedede;
    padding-left:20px;
    padding-top: 20px;
    
}
.cencon h4{
    text-align: center;
    font-weight: bolder;
    font-family:'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
    color: rgb(15, 20, 36);
    font-weight:bolder!important;
}
.restar{
    color: red;
}
.box h5{
    text-align: center;
    font-weight: bold;
}
.cs4{
    text-decoration: none;
}
.design{
    color: #3d3b39!important;
    font-weight:600;
}
#aboutfot{
    text-align: justify;
    font-weight: 400;
    padding-left: 70px;
    
}
.success-message {
    display: none;
    color: rgb(230, 240, 230);
    text-align: center;
    font-weight: bold;
    margin-top: 20px;
}
.error-message {
    color: red;
    font-size: 0.875em;
    display: none;
}
#fsv{
    font-weight: 100;
}
	</style>
</head>
<body>
    <!-- <nav class="navbar navbar-expand-lg navbar-light sticky-header" id="ids">
        <div class="container-fluid">
            <img src="image/logo.png" alt="logo" width="50px" height="50px">
            <a class="navbar-brand pt-1 p-3 d-flex-align-items-center fs-4" href="#">
                <span class="text-primary fw-bold">Joy<span class="text-success ms-2">R</span>ider</span> 
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mb-auto mb-lg-0 fs-5 space">
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-1" aria-current="page" href="http://127.0.0.1:5500/customer/index.html">Home</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Aboutus/About.html">About us</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Booking/Book.html">Booking</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="#">Cancel Booking</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="#">View Booking</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link active  fse ms-5" aria-current="page" href="#">Contact us</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Login/customerlogin.html">Login/Register</a>
                    </li>
                    <li class="nav-item fcolor">
                        <img src="Images/account.png" class="mt-1 ms-0" alt="" width="30px">
                    </li>
                </ul>
            </div>
        </div>
    </nav> -->
    <nav class="navbar navbar-expand-lg navbar-light sticky-header" id="ids">
        <div class="container-fluid">
            <img src="Images/image2.png" alt="logo" width="50px" height="50px">
            <a class="navbar-brand pt-1 p-3 d-flex-align-items-center fs-4" href="#">
                <span class="text-primary fw-bold">Joy<span class="text-success ms-2">R</span>ider</span> 
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mb-auto mb-lg-0 fs-5 space">
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-1" aria-current="page" href="Home.jsp">Home</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="About.jsp">About us</a>
                    </li>
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="Book.jsp">Booking</a>
                    </li>
                    <li class="nav-item fcolor" id="cancelLink" style="display: none;">
                      <a class="nav-link fse ms-5" href="cancelTicket.jsp">Cancel Booking</a>
                  </li>
                  <li class="nav-item fcolor" id="viewLink" style="display: none;">
                      <a class="nav-link  fse ms-5" href="ViewTicket.jsp">View Booking</a>
                  </li>
                  <!-- <li class="nav-item fcolor">
                      <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Login/customerlogin.html">Login/Register</a>
                  </li> -->
                  <!-- <li class="nav-item">
                      <span class="login-status" id="loginStatus"></span>
                  </li> -->
      
                 
                    <li class="nav-item fcolor">
                        <a class="nav-link active fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Contactus/Contact.html">Contact us</a>
                    </li>
                    <li class="nav-item fcolor" id="logoutLink" style="display:none;">
                      <a class="nav-link fse ms-5" href="http://127.0.0.1:5500/sampledemo/Logincheck.html" onclick="logout()">Logout</a>
                  </li> 
                    <li class="nav-item fcolor">
                        <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/sampledemo/Logincheck.html">Login/Register</a>
                    </li>
                    <li class="nav-item fcolor">
                        <img src="Images/account.png" class="mt-1 ms-0" alt="" width="30px">
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <main>
        <div class="cencon">
            <h4><br>Contact Us</h4>
        </div>
        <div class="formbox">
            <div class="box">
                <h5>Send us a message</h5>
                <form id="contactForm" onsubmit="return validateForm()">
                    <label for="fname">First name<span class="restar">*</span></label><br>
                    <input type="text" id="firstName" name="firstName" placeholder="Enter first name">
                    <div id="firstNameError" class="error-message">Please enter a valid first name.</div>
                    <br><br>
                    <label for="lname">Last name<span class="restar">*</span></label><br>
                    <input type="text" id="lastName" name="lastName" placeholder="Enter last name">
                    <div id="lastNameError" class="error-message">Please enter a valid last name.</div>
                    <br><br>
                    <label for="email">Email Id<span class="restar">*</span></label><br>
                    <input type="email" id="email" name="email" placeholder="Enter email id">
                    <div id="emailError" class="error-message">Please enter a valid email address.</div>
                    <br><br>
                    <label for="phone">Phone number<span class="restar">*</span></label><br>
                    <input type="tel" name="phone" id="phone" placeholder="9999999999" pattern="^[6-9]{1}[0-9]{9}$">
                    <div id="phoneError" class="error-message">Please enter a valid phone number.</div>
                    <br><br>
                    <label for="mes">Message</label><br>
                    <textarea name="mes" id="mes" rows="5" cols="30" placeholder="Type your message here"></textarea>
                    
                    <p><span class="restar">* Required</span></p>
                    <button type="submit">Submit</button>
                </form>
                <div class="success-message" id="successMessage">Submitted Successfully!</div>
            </div>
        </div>
    </main>
    <br>
    <div class="container-fluid px-0">
        <footer class="text-center text-lg-start text-black" >
            <section class="d-flex justify-content-between p-2">
                <div class="ms-5 crs fw-5">
                    <span class="gets">Get connected with us on social networks:</span>
                </div>
                <div>
                    <a href="#" class="cs4 me-4">
                        <img src="../../Images/facebook.png" alt="Facebook" width="25px">
                    </a>
                    <a href="#" class="cs4 me-4">
                        <img src="../../Images/youtube.png" alt="YouTube" width="25px">
                    </a>
                    <a href="#" class="cs4 me-4">
                        <img src="../../Images/google.png" alt="Google" width="25px">
                    </a>
                    <a href="#" class="cs4 me-4">
                        <img src="../../Images/insta.png" alt="Instagram" width="25px">
                    </a>
                </div>
            </section>
    
            <section>
                <div class="container text-center text-md-start mt-4">
                    <div class="row mt-3">
                            <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-3">
                            <h6 class="text-uppercase fw-bold text-center mb-4">Joy Rider</h6>
                            <p class="design" id="aboutfot">
                                A brief introduction to Joy Rider, highlighting our mission to provide reliable and convenient bus ticket booking services.
                            </p>
                        </div>
                        <div class="col-md-2 col-lg-2 col-xl-2 mx-5 mb-3">
                            <h6 class="text-uppercase fw-bold mb-3">Info</h6>
                            <p>
                                <a href="#!" class="design text-decoration-none fw-normal">FAQ</a>
                            </p>
                            <p>
                                <a href="#!" class="design text-decoration-none fw-normal">Blog</a>
                            </p>
                            <p>
                                <a href="#!" class="design text-decoration-none fw-normal">Bus Operator Registration</a>
                            </p>
                            <p>
                                <a href="#!" class="design text-decoration-none fw-normal">Customer Registration</a>
                            </p>
                        </div>
                        <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-3">
                            <h6 class="text-uppercase fw-bold mb-4">Useful Links</h6>
                            <p>
                                <a href="#!" class="design text-decoration-none fw-normal">Your Account</a>
                            </p>
                            <p>
                                <a href="#!" class="design text-decoration-none fw-normal">Home</a>
                            </p>
                            <p>
                                <a href="#!" class="design text-decoration-none fw-normal">About Us</a>
                            </p>
                            <p>
                                <a href="#!" class="design text-decoration-none fw-normal">Help</a>
                            </p>
                        </div>
                        <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-3">
                            <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                            <p class="fw-normal" id="fsv"><i class="fas fa-home mr-2"></i> Coimbatore, TamilNadu</p>
                            <p class="fw-normal" id="fsv"><i class="fas fa-envelope mr-2"></i> riderinfo@gmail.com</p>
                            <p class="fw-normal" id="fsv"><i class="fas fa-phone mr-2"></i> + 91 89988 78899</p>
                            <p id="fsv"><i class="fas fa-print mr-2"></i> + 01 234 567 89</p>
                        </div>
                    </div>
                </div>
            </section>
            <div class="text-center p-2 fw-bold" class="footlast">
                © 2024 Copyright:
                <a class="text-dark" href="http://127.0.0.1:5500/customer/index.html#">Joyrider.com</a>
            </div>
        </footer>
    </div>
</body>
<script>
function validateForm() {
    const firstName = document.getElementById('firstName').value.trim();
    const lastName = document.getElementById('lastName').value.trim();
    const email = document.getElementById('email').value.trim();
    const phone = document.getElementById('phone').value.trim();

    let isValid = true;

    if (!firstName) {
        document.getElementById('firstNameError').style.display = 'block';
        isValid = false;
    } else {
        document.getElementById('firstNameError').style.display = 'none';
    }

    if (!lastName) {
        document.getElementById('lastNameError').style.display = 'block';
        isValid = false;
    } else {
        document.getElementById('lastNameError').style.display = 'none';
    }

    const emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;
    if (!email.match(emailPattern)) {
        document.getElementById('emailError').style.display = 'block';
        isValid = false;
    } else {
        document.getElementById('emailError').style.display = 'none';
    }

    const phonePattern = /^[6-9]{1}[0-9]{9}$/;
    if (!phone.match(phonePattern)) {
        document.getElementById('phoneError').style.display = 'block';
        isValid = false;
    } else {
        document.getElementById('phoneError').style.display = 'none';
    }

    if (isValid) {
        document.getElementById('successMessage').style.display = 'block';
        document.getElementById('contactForm').reset(); 
    } else {
        document.getElementById('successMessage').style.display = 'none';
    }

    return false;
}
</script>
</html>    