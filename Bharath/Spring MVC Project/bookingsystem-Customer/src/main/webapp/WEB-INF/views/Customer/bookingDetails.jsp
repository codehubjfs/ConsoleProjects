<%@ page import="com.bus.model.CustomersNew" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Details of  Ticket</title>
    <style>
    <style>
	body {
    margin: 0;
    font-family: 'Roboto', Arial, sans-serif;
    background-color: #f7f7f7;
    color: #333;
}
  #ids {
            background-color: rgb(241, 240, 247);
            margin-bottom: 10px;
            position: sticky;
            top: 0px;
            z-index: 1;
        }
.space {
	margin-left: 105px;

	/* word-spacing: 20px; */
}

.text-dark:focus,
.text-dark:active {
    color: blue; 
    text-decoration: underline;
}
.gets {
	font-weight: 500;
	font-size: 18px;
}

.text-dark:hover {
    color: blue; 
    text-decoration: underline;
}
a:hover {
	color: rgb(241, 6, 190) !important;
}

.navbar-nav .nav-link.active {
	background: #243346;
	color: white !important;
	height: auto;
}
 .fse {
	font-size: 17px;
	font-weight: 450;
	color: rgba(43, 80, 182, 0.938) !important;
}
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light sticky-header" id="ids">
    <div class="container-fluid">
        <img src="${pageContext.request.contextPath}/Images/Joylogo.png" alt="logo" width="60px" height="50px">
        <a class="navbar-brand pt-1 p-3 d-flex align-items-center fs-4" href="#">
            <span class="text-primary fontsw fw-bold pt-2">Joy<span class="text-success ms-2">R</span>ider</span>
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto mb-auto mb-lg-0 fs-5 space">
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="home">Home</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="about">About us</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="book">Booking</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="contact">Contact us</a></li>
                	<%
				    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
				    response.setHeader("Pragma", "no-cache"); 
				    response.setDateHeader("Expires", 0); 
				%>
                <%
                    CustomersNew customers = (CustomersNew) session.getAttribute("customersNew");
                    if (customers != null) {
                %>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" href="cancel">Cancel Booking</a></li>
                <li class="nav-item fcolor"><a class="nav-link active fse ms-5" href="view">View Booking</a></li>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" href="logout">Logout</a></li>
                <li class="nav-item fcolor"><span class="nav-link fse ms-5 text-uppercase"><%= customers.getFirstName() %> <%= customers.getLastName() %></span></li>
                <% } else { %>
                <li class="nav-item fcolor"><a class="nav-link fse ms-5" aria-current="page" href="login">Login/Register</a></li>
                <% } %>
            </ul>
        </div>
    </div>
</nav>
<div class="modal-body">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 offset-lg-3">
                <div class="card mt-5">
                    <div class="card-header bg-primary text-white">
                        <h3 class="text-center">Ticket Details</h3>
                    </div>
                    <div class="card-body">
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <th>Boarding Point</th>
                                    <td>${booking.boardingPoint}</td>
                                </tr>
                                <tr>
                                    <th>Dropping Point</th>
                                    <td>${booking.droppingPoint}</td>
                                </tr>
                                <tr>
                                    <th>Total Price</th>
                                    <td>${booking.totalPrice}</td>
                                </tr>
                                <tr>
                                    <th>Selected Seats</th>
                                    <td>${booking.selectedSeats}</td>
                                </tr>
                                <tr>
                                    <th>Status</th>
                                    <td>${booking.bookingStatus}</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

	 <div class="container-fluid px-0">
      <footer class="text-center text-lg-start text-black" style="background-color: rgb(241, 240, 247)">
            <section class="d-flex justify-content-between p-2" style="background-color:rgb(241, 240, 247)">

          <div class="crs fw-5">
            <span class="gets">Get connected with us on social networks:</span>
          </div>
    
          <div>
                    <a href="#" class="cs4 me-4 text-decoration-none">
                        <img src="${pageContext.request.contextPath}/Images/facebook.png" alt="Facebook" width="25px">
                    </a>
                    <a href="#" class="cs4 me-4 text-decoration-none">
                        <img src="${pageContext.request.contextPath}/Images/youtube.png" alt="YouTube" width="25px">
                    </a>
                    <a href="#" class="cs4 me-4 text-decoration-none">
                        <img src="${pageContext.request.contextPath}/Images/google.png" alt="Google" width="25px">
                    </a>
                    <a href="#" class="cs4 me-4 text-decoration-none">
                        <img src="${pageContext.request.contextPath}/Images/insta.png" alt="Instagram" width="25px">
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
                  <a href="#!" class="design text-decoration-none text-dark fw-normal" >FAQ</a>
                </p>
                <p>
                  <a href="#!" class="design text-decoration-none text-dark fw-normal">Blog</a>
                </p>
                <p>
                  <a href="#!" class="design text-decoration-none  text-dark fw-normal">Bus Operator registration</a>
                </p>
                <p>
                  <a href="#!" class="design text-decoration-none text-dark fw-normal">Customer registration</a>
                </p>
              </div>
            
              <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-3 ">
    
                <h6 class="text-uppercase fw-bold mb-4">Useful links</h6>
                <!-- <hr class="mb-2 mt-0 d-inline-block mx-5 " style="width: 60px; background-color: #7c4dff; height: 2px" /> -->
                <p>
                  <a href="#!" class="design text-decoration-none text-dark fw-normal">Your Account</a>
                </p>
                <p>
                  <a href="#!" class="design text-decoration-none text-dark fw-normal">Home</a>
                </p>
                <p>
                  <a href="#!"class="design text-decoration-none text-dark fw-normal">About us</a>
                </p>
                <p>
                  <a href="#!" class="design text-decoration-none text-dark fw-normal">Help</a>
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
