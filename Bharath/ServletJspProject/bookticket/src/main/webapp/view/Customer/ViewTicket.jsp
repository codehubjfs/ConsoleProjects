<!DOCTYPE html>
<html lang="en">
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/customer/style.css">
    <script src="/customer/script.js"></script>
    <link rel="icon" type="image/x-icon" href="../Images/bus.png" width="40px">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>VIew Ticket</title>
</head>
<style>
	body {
    margin: 0;
    font-family: 'Roboto', Arial, sans-serif;
    background-color: #f7f7f7;
    color: #333;
}

.print-ticket-container {
    text-align: center;
    margin: 50px auto;
    padding: 20px;
    width: 60%;
    background-color: #fff;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    border-radius: 10px;
}

.title {
    font-weight: 700;
    font-size: 24px;
    color: #333;
    margin-bottom: 10px;
}

.subtitle {
    font-weight: 400;
    font-size: 18px;
    color: #666;
    margin-bottom: 30px;
}

.highlight {
    color: #e74c3c;
    font-weight: 700;
}

.print-ticket-form {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.form-group {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    margin-bottom: 20px;
    width: 100%;
    max-width: 500px;
}

.form-label {
    font-weight: 700;
    margin-bottom: 10px;
}

.input-container {
    display: flex;
    align-items: center;
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 10px;
    width: 100%;
}

.input-container i {
    margin-right: 10px;
    color: #aaa;
}

.input-container input {
    border: none;
    outline: none;
    width: 100%;
    padding: 5px;
}

.mobile-input {
    display: flex;
    align-items: center;
    width: 510px;
}

.mobile-input select,
.mobile-input input {
    border: 1px solid #ccc;
    border-radius: 5px;
    padding: 10px;
    outline: none;
    margin-right: 10px;
}

.mobile-input input {
    flex-grow: 1;
}

.submit-btn {
    background-color: #e74c3c;
    color: #fff;
    border: none;
    padding: 15px 30px;
    border-radius: 5px;
    cursor: pointer;
}

.submit-btn:hover {
    background-color: #c0392b;
}
   .design {
            color: black;
        }
        .text-dark {
    color: #000; /* Initial color */
    text-decoration: none; /* No underline initially */
}

.text-dark:focus,
.text-dark:active {
    color: blue; /* Blue color when clicked */
    text-decoration: underline; /* Underline when clicked */
}

/* Optional: Add a hover state for better UX */
.text-dark:hover {
    color: blue; /* Blue color on hover */
    text-decoration: underline; /* Underline on hover */
}
     
</style>
</head>
<body>
<body>
  
 <nav class="navbar navbar-expand-lg navbar-light sticky-header" id="ids">
    <div class="container-fluid">
        <img src="../../Images/Joylogo.png" alt="logo" width="50px" height="50px">
        <a class="navbar-brand pt-1 p-3 d-flex-align-items-center fs-4" href="#">
            <span class="text-primary fw-bold mt-4">Joy<span class="text-success ms-2">R</span>ider</span> 
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
                    <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/cancelticket/ticketcancel.html#">Cancel Booking</a>
                </li>
                <li class="nav-item fcolor">
                    <a class="nav-link active fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/cancelticket/Viewticket.html">View Booking</a>
                </li>
                <li class="nav-item fcolor">
                    <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Contactus/Contact.html">Contact us</a>
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
</nav>
    <div class="print-ticket-container">
        <h1 class="title">PRINT TICKET</h1>
        <p class="subtitle">Verify your details, and <span class="highlight">Print</span> your tickets</p>
        <form class="print-ticket-form">
            <div class="form-group">
                <label class="form-label" for="ticket-number">TICKET NUMBER</label>
                <div class="input-container">
                    <i class="fas fa-ticket-alt"></i>
                    <input type="text" id="ticket-number" placeholder="Enter your ticket number">
                </div>
            </div>
            <div class="form-group">
                <label class="form-label" for="mobile-number">MOBILE NUMBER</label>
                <div class="mobile-input">
                    <select>
                        <option value="+91">+91</option>
                    </select>
                    <input type="text" id="mobile-number" placeholder="Enter your mobile number">
                </div>
            </div>
            <button type="submit" class="submit-btn">SUBMIT</button>
        </form>
    </div>
	 <div class="container-fluid px-0">
      <footer class="text-center text-lg-start text-black" style="background-color: rgb(241, 240, 247)">
            <section class="d-flex justify-content-between p-2" style="background-color:rgb(241, 240, 247)">

          <div class="crs fw-5">
            <span class="gets">Get connected with us on social networks:</span>
          </div>
    
          <div class="text-decoration-none">
            <a href="#" class="cs4 me-4 text-decoration-none">
              <img src="../../Images/facebook.png" alt="facebook" width="25px">
            </a>
            <a href="" class="cs4 me-4 text-decoration-none">
              <img src="../../Images/youtube.png" alt="youtube" width="25px">
            </a>
            <a href="" class="cs4 me-4 text-decoration-none">
              <img src="../../Images/google.png" alt="" width="25px">
            </a>
            <a href="" class="cs4 me-4 text-decoration-none">
              <img src="../../Images/insta.png" alt="" width="25px">
            </a>
          </div>
            </section>
<div class="container text-center text-md-start mt-4">
            <div class="row mt-3">
              <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-3">
                <h6 class="text-uppercase fw-bold text-center mb-4">Joy Rider</h6>
                <!-- <hr class="mb-2 mt-0 d-inline-block mx-auto" style="width: 60px; background-color:#7c4dff; height: 2px" /> -->
                <p class="design" id="aboutfot">
                  A brief introduction to Joy Rider, highlighting our mission to provide reliable and convenient bus ticket booking services.
                </p>
              </div>
              <div class="col-md-2 col-lg-2 col-xl-2 mx-5 mb-3">
                <h6 class="text-uppercase fw-bold mb-3">Info</h6>
  
                <p>
                  <a href="#!" class="design text-decoration-none fw-normal" >FAQ</a>
                </p>
                <p>
                  <a href="#!" class="design text-decoration-none fw-normal">Blog</a>
                </p>
                <p>
                  <a href="#!" class="design text-decoration-none fw-normal">Bus Operator registration</a>
                </p>
                <p>
                  <a href="#!" class="design text-decoration-none fw-normal">Customer registration</a>
                </p>
              </div>
            
              <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-3 ">
    
                <h6 class="text-uppercase fw-bold mb-4">Useful links</h6>
                <!-- <hr class="mb-2 mt-0 d-inline-block mx-5 " style="width: 60px; background-color: #7c4dff; height: 2px" /> -->
                <p>
                  <a href="#!" class="design text-decoration-none fw-normal">Your Account</a>
                </p>
                <p>
                  <a href="#!" class="design text-decoration-none fw-normal">Home</a>
                </p>
                <p>
                  <a href="#!"class="design text-decoration-none fw-normal">About us</a>
                </p>
                <p>
                  <a href="#!" class="design text-decoration-none fw-normal">Help</a>
                </p>
              </div>
  
              <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-3">
                <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
                <!-- <hr class="mb-2 mt-0 d-inline-block mx-5" style="width: 60px; background-color: #7c4dff; height: 2px" /> -->
                <p class="fw-normal"><i class="fas fa-home mr-2"></i> Coimbatore, TamilNadu</p>
                <p class="fw-normal"><i class="fas fa-envelope mr-2 "></i>&nbsp;&nbsp;riderinfo@gmail.com</p>
                <p class="fw-normal"><i class="fas fa-phone mr-2"></i> + 91 89988 78899</p>
                <p><i class="fas fa-print mr-2"></i> + 01 234 567 89</p>
              </div>
            </div>
          </div>
        </section>
        <div class="text-center p-2 fw-bold" style="background-color: rgb(241, 240, 247)">
          © 2024 Copyright:
          <a class="text-dark" href="http://127.0.0.1:5500/customer/index.html#">Joyrider.com</a>
        </div>
      </footer>

    
    </div>
  </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
