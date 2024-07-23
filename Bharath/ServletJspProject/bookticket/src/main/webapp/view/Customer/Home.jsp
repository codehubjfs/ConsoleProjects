<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpServlet" %>
<%@ page import="jakarta.servlet.http.HttpServletRequest" %>
<%@ page import="jakarta.servlet.ServletException" %>
<%@ page import="java.io.IOException" %>
<!DOCTYPE html>
<html lang="en">
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <script src="script.js"></script>
    <link rel="icon" type="image/x-icon" href="Images/bus.png" width="40px">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <title>Travel with Joy</title>
    
    <style>
      .fontsw{
        font-family:"Tahoma", Comic Sans MS;
      }
      /* Default styles */
body {
    font-family: Arial, sans-serif;
}

#ids {
    background-color: rgb(241, 240, 247);
    margin-bottom: 10px;
    position: sticky;
    top: 0px;
    z-index: 1;
}
/* #ids img {
    width: 50px; 
    height: auto; 
    margin-right: 10px;
    border-radius: 30px;
    padding-top: 0%;
} */
.navbar-brand span {
    display: inline-block;
}

.custom-carousel {
    max-width: 800px;
    margin: 20px auto;
}

.read h2 {
    text-indent: 0px;
    padding-left: 1px;
    color: black;
    font-weight: 400;
}

.read p {
    font-size: 17px !important;
    font-weight: 400 !important;
    font-family: 'Poppins', sans-serif !important;
}

#heu {
    height: 500px;
}

.crs {
    color: rgba(32, 32, 33, 0.938) !important;
    font-weight: 700;
}


.fse {
    font-size: 17px;
    font-weight: 450;
    color: rgba(43, 80, 182, 0.938) !important;
}

.new {
    color: aqua;
}

.space {
    margin-left: 105px;
    
    /* word-spacing: 20px; */
}

.marquee-container {
    overflow: hidden;
    width: 100%; 
    position: relative;
}

.marquee {
    display: flex;
    animation: marquee 5s linear infinite; 
}

.marquee-item {
    width: 200px; 
    height: auto; 
    margin-right: 20px; 
    }

a:hover {
    color: rgb(241, 6, 190) !important;
}

.navbar-nav .nav-link.active {
    background: #243346;
    color: white !important;
    height: auto;
}
.text-dark {
    color: #000; 
    text-decoration: none; 
}

.text-dark:focus,
.text-dark:active {
    color: blue; 
    text-decoration: underline; 
}

.text-dark:hover {
    color: blue;
    text-decoration: underline; 
}


@keyframes marquee {
    0% {
        transform: translateX(100%);
    }
    100% {
        transform: translateX(-100%);
    }
}

.ims {
    background-color: rgb(250, 243, 237);
    color: rgb(23, 20, 18);
    width: 100%;
}

.fs {
    color: rgb(43, 46, 220);
}

.pcolor {
    padding-top: 20px;
    background-color: #2f85c7;
    font-size: 20px;
    margin-left: 10px;
    text-indent: 30px;
    text-align: justify;
}

.word {
    font-size: 20px;
}

.secondhead {
    color: rgb(252, 244, 244);
    font-size: 5px;
}

.secondhead h2 {
    color: rgba(10, 49, 147, 0.938) !important;
    font-size: 25px;
    padding-top: 15px;
    padding-bottom: 15px;
    text-align: center;
    font-weight: 500;
}

.secondhead p {
    color: rgba(127, 138, 158, 0.938) !important;
    font-size: auto !important;
    text-align: justify;
    text-indent: 50px;
    font-weight: 500;
    margin-left: 10px!important;
    margin-right: 10px!important;
}

.design {
    color: #3d3b39 !important;
    font-weight: 600;
}

#aboutfot {
    text-align: justify;
    font-weight: 400;
    padding-left: 70px;
}

h6 {
    padding-left: 50px;
}

.cs4 {
    text-decoration: none;
}

.gets {
    font-weight: 500;
    font-size: 18px;
}

.footer {
    margin: 0 auto;
    padding-left: 10%;
    padding-right: 10%;
}

/* Responsive styles */
@media only screen and (max-width: 768px) {
    /* Adjustments for smaller screens */
    .custom-carousel {
        max-width: 600px;
    }

    .marquee img {
        height: 80px;
    }
}

@media only screen and (max-width: 480px) {
    /* Adjustments for even smaller screens */
    .custom-carousel {
        max-width: 500px;
    }

    .marquee img {
        height: 400px;
    }
}
      
    </style>
</head>

<body>
  
 <nav class="navbar navbar-expand-lg navbar-light sticky-header" id="ids">
    <div class="container-fluid">
        <img src="${pageContext.request.contextPath}/Images/Joylogo.png" alt="logo" width="60px" height="50px">
        <a class="navbar-brand pt-1 p-3 d-flex-align-items-center fs-4" href="#">
            <span class="text-primary fontsw fw-bold pt-2">Joy<span class="text-success ms-2">R</span>ider</span> 
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mb-auto mb-lg-0 fs-5 space">
                <li class="nav-item fcolor">
                    <a class="nav-link active fse ms-5" aria-current="page" href="${pageContext.request.contextPath}/view/Customer/Home.jsp">Home</a>
                </li>
                <li class="nav-item fcolor">
                    <a class="nav-link fse ms-5" aria-current="page" href="${pageContext.request.contextPath}/view/Customer/About.jsp">About us</a>
                </li>
                <li class="nav-item fcolor">
                    <a class="nav-link fse ms-5" aria-current="page" href="${pageContext.request.contextPath}/view/Customer/Book.jsp">Booking</a>
                </li>
                <li class="nav-item fcolor" id="cancelLink" style="display: none;">
                  <a class="nav-link fse ms-5" href="${pageContext.request.contextPath}/view/Customer/cancelticket.jsp">Cancel Booking</a>
              </li>
              <li class="nav-item fcolor" id="viewLink" style="display: none;">
                  <a class="nav-link  fse ms-5" href="${pageContext.request.contextPath}/view/Customer/viewbooking.jsp">View Booking</a>
              </li>
              <!-- <li class="nav-item fcolor">
                  <a class="nav-link fse ms-5" aria-current="page" href="http://127.0.0.1:5500/customer/Login/customerlogin.html">Login/Register</a>
              </li> -->
              <!-- <li class="nav-item">
                  <span class="login-status" id="loginStatus"></span>
              </li> -->
  
             
                <li class="nav-item fcolor">
                    <a class="nav-link fse ms-5" aria-current="page" href="Contact.jsp">Contact us</a>
                </li>
                <li class="nav-item fcolor" id="logoutLink" style="display:none;">
                  <a class="nav-link fse ms-5" href="${pageContext.request.contextPath}/view/Customer/Login.jsp" onclick="logout()">Logout</a>
              </li> 
                <li class="nav-item fcolor">
                    <a class="nav-link fse ms-5" aria-current="page" href="${pageContext.request.contextPath}/view/Customer/Login.jsp">Login/Register</a>
                </li>
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="../../Images/account.png" class="mt-1 ms-0" alt="" width="30px">
                    </a>
                         <%
                            HttpSession sessions = request.getSession(false);
                            if (sessions != null && sessions.getAttribute("customers") != null) {
                        %>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Cancel Ticket</a></li>
                        <li><a class="dropdown-item" href="#">View Ticket</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/LogoutServlet">Logout</a></li>
                        <% } %>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">

        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>

        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="${pageContext.request.contextPath}/Images/booked3.jpeg" alt="First slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="${pageContext.request.contextPath}/Images/booked2.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="${pageContext.request.contextPath}/Images/booked1.jpg" alt="Third slide">
            </div>
        </div>

        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <div class="marquee-container">
        <marquee behavior="scroll" direction="left" scrollamount="20">
            <img src="${pageContext.request.contextPath}/Images/Screenshot (208).png" alt="Image 1" width="140px">
            <img src="${pageContext.request.contextPath}/Images/primo.jpg" alt="Image 2" width="243px">
            <img src="${pageContext.request.contextPath}/Images/sara.jpeg" alt="Image 3"  height="113px" width="200px">
            <img src="${pageContext.request.contextPath}/Images/buscom4.jpeg" alt="Image 4" height="113px" width="200px">
            <img src="${pageContext.request.contextPath}/Images/sky.jpeg" alt="Image 5" height="113px" width="200px">
            <img src="${pageContext.request.contextPath}/Images/vkv.png" alt="Image 6" height="113px" width="200px">
        </marquee>
    </div>
    <div class="read">
    <section class="custom-section d-flex justify-content-between p-0 secondhead">
            <div>
              <br>
                <h2>GRAB BUS TICKETS Through OUR WEBSITE</h2>
                <p>Joy Rider is a bus ticketing platform operating since 2024. Millions of passengers trust Joy Rider for booking affordable bus tickets. By bus registration on redBus, you will boost the brand reputation of your travel company. Joy Rider believes in offering transparency to its travel partners for better productivity. You can widen your customer reach with Joy Rider in no time.</p>
                <p>Joy Rider is your premier choice for convenient and reliable bus ticket booking. Whether you are planning a short trip or a long journey, our user-friendly platform makes it easy to book your bus tickets in just a few clicks.With Joy Rider, you can explore various destinations, choose from multiple bus operators, and enjoy a seamless booking experience. Our commitment to providing excellent customer service ensures that your travel plans are hassle-free. Booking your bus tickets has never been easier! Visit our website, enter your travel details, and select from a range of options tailored to your needs. Experience the ease and convenience of online bus ticket booking with Joy Rider. Join our community of happy travelers and make your next journey memorable with Joy Rider.If you provide bus services to multiple cities, you need to open a counter in those cities. Opening ticket counters in many cities is hard. With Joy Rider, you can tap the audience from various cities without the need for physical ticketing counters.Once you complete the joy riderbus registration process, you don’t need to worry about service. All Joy rider partners can receive personalised support from the joy rider team, from selling tickets to payment.
                </p>
            </div>
        </section>
    </div>
    <div class="container-fluid px-0">

      <footer class="text-center text-lg-start text-black" style="background-color: rgb(241, 240, 247)">

        <section class="d-flex justify-content-between p-2" style="background-color:rgb(241, 240, 247)">

          <div class="ms-5 crs fw-5">
            <span class="gets">Get connected with us on social networks:</span>
          </div>
    
          <div>
            <a href="" class="cs4 me-4">
              <img src="${pageContext.request.contextPath}/Images/facebook.png" alt="facebook" width="25px">
            </a>
            <a href="" class="cs4 me-4">
              <img src="${pageContext.request.contextPath}/Images/youtube.png" alt="youtube" width="25px">
            </a>
            <a href="" class="cs4 me-4">
              <img src="${pageContext.request.contextPath}/Images/google.png" alt="google" width="25px">
            </a>
            <a href="" class="cs4 me-4">
              <img src="${pageContext.request.contextPath}/Images/insta.png" alt="insta" width="25px">
            </a>
          </div>

        </section>

        <section class="">
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
        <div class="text-center p-2 fw-bold" style="background-color: rgb(241, 240, 247)">joyRider&copy; 2024 Copyright:
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