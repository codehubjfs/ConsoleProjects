<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<%@ page import="com.hallbookingmanagement.beans.Customer" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hall-Details</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/assert/css/CustomerHeaderFooter.css"/>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js" defer></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" defer></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" defer></script>
    <script type="text/javascript">
        var isLoggedIn = false;
    </script>
    <c:if test="${not empty sessionScope.customer}">
        <script type="text/javascript">
            isLoggedIn = true;
        </script>
    </c:if>
    <script type="text/javascript">
        function checkSession() {
            if (!isLoggedIn) {
                document.getElementById("loginModal").style.display = "block";
            } else {
                // Proceed with the request
            }
        }
    </script>
    <style>
         .map{
            width: 100%;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: coloum;
        }
        .innercard{
            margin-top: 5px;
            margin-bottom:5px;
            margin-left: 5px;
            margin-right: 5px;
            padding: 5px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        }

        .carousel-inner img {
            height: 400px;
            object-fit: cover;
        }
        .carousel-control-prev-icon,
        .carousel-control-next-icon {
            background-color: black;
        }
        .form-container {
            margin-top: 20px;
        }
        .form-control, .btn, .input-group-text {
            border-radius: 0;
        }
        .btn-block {
            width: 100%;
            margin-bottom: 10px;
        }
        .rating img {
            width: 20px;
        }
        .rating p {
            display: inline;
            margin-left: 5px;
            font-size: 1.2rem;
        }

        .map iframe {
            width: 95%;
            height: 400px;
        }
        .feature-card {
            padding: 20px;
            margin-bottom: 20px;
            border: 1px solid #eaeaea;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .feature-card img {
            margin-bottom: 10px;
        }
        .feature-card h3 {
            font-size: 1.2em;
            margin-bottom: 10px;
        }
        .feature-card p {
            margin-bottom: 0;
        }
        .highlights {
            margin-bottom: 30px;
        }
        .highlights hr {
            margin: 0 0 20px;
        }
        
        @media screen and (max-width: 800px) {
            .next {
                display: none !important;
            }
        }



        .details .container {
            max-width: 1200px;
            margin: auto;
            padding: 20px;
        }
        .details .text-center {
            text-align: center;
        }
        .details h1, h2, h3 {
            color: #4e4332;
        }
        .details hr {
            border: 1px solid #4e4332;
        }
        .details ul {
            list-style-type: none;
            padding: 0;
        }
        .details li::before {
            content: "•";
            color: #4e4332;
            font-weight: bold;
            display: inline-block;
            width: 1em;
            margin-left: -1em;
        }
        .details .row {
            display: flex;
            flex-wrap: wrap;
            margin: -10px;
        }
        .details .col-md-12, .col-md-6 {
            padding: 10px;
        }
        .details .col-md-12 {
            flex: 0 0 100%;
        }
        .details .col-md-6 {
            flex: 0 0 50%;
        }
        .details p, ul {
            margin-top: 10px;
            margin-bottom: 10px;
        }
        .details .mb-3 {
            margin-bottom: 1rem;
        }
        .details .mt-3 {
            margin-top: 1rem;
        }
        .details .mt-5 {
            margin-top: 3rem;
        }
        .details .button {
            background-color: #4e4332;
            color: #ffeed3;
            padding: 10px 20px;
            text-decoration: none;
            border-radius: 5px;
            display: inline-block;
            margin-top: 20px;
        }
        details.button:hover {
            background-color: #3b3527;
        }
        #hall-container{
            margin-top: 5%;
        }
    #customNavbar {
        position: fixed !important;
        top: 0;
        position: -webkit-sticky;
        width: 100%;
        z-index: 1000; 
        background-color: #ffffff; 
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    </style>
</head>
<body>
	<div class="modal" id ="loginModal" tabindex="-1">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Login</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <p>To continue booking click the bellow login button.</p>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal closeModal">Close</button>
	        <button type="button" class="btn btn-primary">login</button>
	      </div>
	    </div>
	  </div>
	</div>
    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light" id="customNavbar">
            <a class="navbar-brand" href="#"><img src="${pageContext.request.contextPath}/assert/image/Logo.1.1.png" id="company-logo" alt="Company Logo"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent" style="margin-left:40% ">
              <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                  <a class="nav-link" href= '<%= request.getContextPath() %>/index.jsp'>Home</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/blogs.jsp'>Blogs</a>
                </li>
                <li class="nav-item dropdown">
                  <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Hall Events
                  </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown" id="Events-DropDown">
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/HallsServlet'>Wedding</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Corporate Party</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Conference</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Concert</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Exhibition</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Product Launch</a>
                    <a class="dropdown-item" href='<%= request.getContextPath() %>/view/hall.jsp'>Training Session</a>
                  </div>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/facilities.jsp'>Facilities</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/contact.jsp'>Contact</a>
                </li>
                <% if(session.getAttribute("customer")==null){%>
                <li class="nav-item">
                  <a class="nav-link" href='<%= request.getContextPath() %>/view/login.jsp' id="login">Login</a>
                </li>
                <%}
                else{ %>
                <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="userMenu" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person" viewBox="0 0 16 16">
                                <path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6m2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0m4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4m-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10s-3.516.68-4.168 1.332c-.678.678-.83 1.418-.832 1.664z"/>
                            </svg>
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="userMenu">
                            <li><a class="dropdown-item ms-0" href="#" id="logout">Logout</a></li>
                            <li><a class="dropdown-item ms-0" href="<%= request.getContextPath() %>/PaymentServlet">My Bookings</a></li>
                             <li><a class="dropdown-item ms-0" href="<%= request.getContextPath() %>/MyRequestsServlet">Booking Request</a></li>
                      	</ul>
                </li>
                <%} %>
              </ul>
            </div>
          </nav>
    </header>
    <!--Logout modal-->
		<div class="modal" id="logoutModal" tabindex="-1" aria-labelledby="logoutModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="logoutModalLabel">Confirm Logout</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        <p>Are you sure you want to logout?</p>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
		        <button type="button" class="btn btn-outline-danger" id="confirmLogoutButton">Logout</button>
		      </div>
		    </div>
		  </div>
		</div> 
    <div style="background-color: #c3bbbb6a;">
    <div class="container" id="hall-container">
        <div class="row">
            <div class="col-md-6">
                <h4>${hallDetail.hallName}</h4>
                <img src="${pageContext.request.contextPath}/assert/image/placeholder_186250.png" width="20px"  class="img-fluid" alt="Grand Hall">
                <span>${hallDetail.location}</span>
            </div>
            <div class="col-md-6">
                <div class="d-flex justify-content-between align-items-center">
                    <h4>Price Per Day</h4>
                    <p class="fs-4">&#8377;${hallDetail.price}/day</p>
                    <%
						    Customer customer = (Customer) request.getSession().getAttribute("customer");
						    if (customer != null) {
						%>
						    <p style="display:none"><%= customer.getUserName() %></p>
						<%
						    } else {
						%>
						    <p>No customer information available.</p>
						<%
						    }
						%>
                </div>
                <div class="rating d-inline">
                    <img src="${pageContext.request.contextPath}/assert/image/star_148841.png" alt="Rating Star">
                    <p>4.5</p>
                </div>
            </div>
        </div>
        <div class="row mt-4">
            <div class="col-md-6 p-0 mt-5" style="align-items: center; height:500px;">
                <div class="inner-card">
                <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="${pageContext.request.contextPath}/assert/image/10058.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="${pageContext.request.contextPath}/assert/image/10236.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="${pageContext.request.contextPath}/assert/image/19593.jpg" class="d-block w-100" alt="...">
                        </div>
                        <div class="carousel-item">
                            <img src="${pageContext.request.contextPath}/assert/image/2151481480.jpg" class="d-block w-100" alt="...">
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
                </div>
            </div>
            </div>
            <div class="col-md-6">
                <div class="form-container">
                    <h2 class="text-center mb-4">Check Availability</h2>
                    <form class="row g-3 needs-validation" action="RequestHallServlet" method="get">
                        <div class="col-md-6">
                            <label for="name" class="form-label" >Name <sup style="color:red">*</sup></label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name">
                        </div>
                        <div class="col-md-6">
                            <label for="mobile" class="form-label" >Mobile <sup style="color:red">*</sup></label>
                            <div class="input-group">
                                <span class="input-group-text">+91</span>
                                <input type="text" class="form-control" id="mobile" name="mobile" placeholder="Mobile Number">
                            </div>
                        </div>
                         <div class="col-md-6">
                            <label for="function" class="form-label">Function <sup style="color:red">*</sup></label>
							    <select class="form-control" id="function" name="event" >
							         <c:forEach items="${hallDetail.events}" var="event">
								        <option value="${event.eventName}">${event.eventName}</option>
								    </c:forEach>
							    </select>
                        </div> 
						<div class="col-md-6">
						    <label for="seating" class="form-label">Seating Arrangement <sup style="color:red">*</sup></label>
						    <select class="form-control form-select" id="seating" name="seat">
						        <c:forEach items="${hallDetail.seat}" var="seat">
						            <option value="${seat.arrangementType}">${seat.arrangementType}</option>
						        </c:forEach>
						    </select>
						</div>                        
                        
                       <div class="col-md-6">
                            <label for="date" class="form-label">Date <sup style="color:red">*</sup></label>
                            <input type="date" class="form-control" id="date" min="" name="bookedDate">
                        </div>
                        <div class="col-md-6">
                            <label for="slot" class="form-label">Number of Days <sup style="color:red">*</sup></label>
                            <input type="number" class="form-control" id="numberDays" min="1" placeholder="No of Days.." name="numberDay">
                        </div>
                        <div class="col-md-6">
                            <button type="button" class="btn btn-primary btn-block mt-2">CONTACT</button>
                        </div>
                        <div class="col-md-6">
                            <button type="submit" class="btn btn-success btn-block mt-2" onclick="checkSession()">REQUEST NOW</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <h1 class="text-center">Location of the Hall</h1>
        </div>
    </div>
    <div class="row justify-content-center mt-4">
        <div class="col-12">
            ${hallDetail.locationLink}
        </div>
    </div>
</div>
    <div class="container top-features">
        <div class="row">
            <div class="col-12">
                <h2 class="text-center">Top Features of Hall</h2>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="feature-card text-center">
                    <img src="${pageContext.request.contextPath}/assert/image/teamwork_477804.png" width="30px" alt="Hall Capacity">
                    <h3>Hall Capacity</h3>
                    <p>upto 650</p>
                </div>
            </div>
    
            <div class="col-md-3 col-sm-6">
                <div class="feature-card text-center">
                    <div class="d-block">
                        <img src="${pageContext.request.contextPath}/assert/image/seating_11167804.png" width="30px" alt="Seating Arrangements">
                    </div>
                    <div class="btn-group dropright">
                        <div><button type="button" class="btn btn-secondary dropdown-toggle d-block" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Seating Arrangements
                        </button></div>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="#">Theater Style - 400</a>
                            <a class="dropdown-item" href="#">Classroom Style - 500</a>
                            <a class="dropdown-item" href="#">Banquet Style - 350</a>
                            <a class="dropdown-item" href="#">U-Shape Style - 300</a>
                            <a class="dropdown-item" href="#">Boardroom Style - 400</a>
                            <a class="dropdown-item" href="#">Cabaret Style - 500</a>
                        </div>
                    </div>
                </div>
            </div>
    		<c:forEach items="${hallDetail.amenities}"></c:forEach>
            <div class="col-md-3 col-sm-6">
                <div class="feature-card text-center">
                    <img src="${pageContext.request.contextPath}/assert/image/snowflake_615669.png" width="30px" alt="Air Conditioning">
                    <h3>Air Conditioning</h3>
                    <p>Yes</p>
                </div>
            </div>
    
            <div class="col-md-3 col-sm-6">
                <div class="feature-card text-center">
                    <img src="${pageContext.request.contextPath}/assert/image/elevator_7934234.png" width="30px" alt="Lift Access to Hall">
                    <h3>Lift Access to Hall</h3>
                    <p>No</p>
                </div>
            </div>
        </div>
    
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="feature-card text-center">
                    <img src="${pageContext.request.contextPath}/assert/image/sign-board_16377470.png" width="30px" alt="Rooms">
                    <h3>Rooms</h3>
                    <p>0</p>
                </div>
            </div>
    
            <div class="col-md-3 col-sm-6">
                <div class="feature-card text-center">
                    <img src="${pageContext.request.contextPath}/assert/image/restaurant_281631.png" width="30px" alt="Food Type">
                    <h3>Food Type</h3>
                    <p>Catring Facility</p>
                </div>
            </div>
    
            <div class="col-md-3 col-sm-6">
                <div class="feature-card text-center">
                    <img src="${pageContext.request.contextPath}/assert/image/car-parking_5764368.png" width="30px" alt="Car Parking">
                    <h3>Car Parking</h3>
                    <p>upto 102</p>
                </div>
            </div>
            <div class="col-md-3 col-sm-6">
                <div class="feature-card text-center">
                    <img src="${pageContext.request.contextPath}/assert/image/bike-parking_2983663.png" width="30px" alt="Car Parking">
                    <h3>Bike Parking</h3>
                    <p>upto 250</p>
                </div>
            </div>
        </div>
    </div>

    <div class="container details">
        <h1 class="text-center mt-5">About Le Royal Meridian In Neelambur Coimbatore</h1>
        <hr class="mt-3">
        <div class="row mt-5">
            <div class="col-md-12">
                <h2 class="mb-3">Discover Your Perfect Venue:</h2>
                <p>Nestled along Neelambur, Le Royal Meridian In Neelambur at Coimbatore offers a blend of timeless tradition and modern luxury. We take pride in being the ideal canvas for your cherished events, where memories are crafted with care.</p>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-md-6">
                <h3 class="mb-3">Capacity:</h3>
                <ul>
                    <li><strong>Hall Capacity:</strong> 650 guests can comfortably be accommodated, making it perfect for both intimate gatherings and grand celebrations.</li>
                    <li><strong>Floating Capacity:</strong> With a spacious setup, we can accommodate up to 1500 floating guests, ensuring your event is as grand as you envision.</li>
                </ul>
            </div>
            <div class="col-md-6">
                <h3 class="mb-3">Comfort and Convenience:</h3>
                <ul>
                    <li><strong>Air Conditioning:</strong> Enjoy the comfort of air-conditioned halls, ensuring a pleasant atmosphere for your special occasion.</li>
                    <li><strong>Dining Capacity:</strong> Our dining facilities can host up to 650 guests, serving a delectable culinary experience.</li>
                    <li><strong>Rooms:</strong> We provide well-appointed rooms for your convenience and relaxation.</li>
                    <li><strong>Car Parking:</strong> Parking is hassle-free with ample space for your guests.</li>
                </ul>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-md-12">
                <h3 class="mb-3">Culinary Delights:</h3>
                <p><strong>Food Variety:</strong> At Le Royal Meridian In Neelambur, we cater to diverse palates with a range of vegetarian and non-vegetarian food options, guaranteeing a delightful gastronomic journey.</p>
            </div>
        </div>
    </div>

  <footer class="text-center text-lg-start bg-body-tertiary text-muted">

    <section class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">

      <div class="me-5 d-none d-lg-block">
        <span>Get connected with us on social networks:</span>
      </div>
      <div>
        <a href="" class="me-4 text-reset social-media">
          <img src="${pageContext.request.contextPath}/assert/image/social_12942327.png">
        </a>
        <a href="" class="me-4 text-reset social-media">
          <img src="${pageContext.request.contextPath}/assert/image/twitter-alt_12107622.png">
        </a>
        <a href="" class="me-4 text-reset social-media">
          <img src="${pageContext.request.contextPath}/assert/image/instagram_2111463.png" alt="">
        </a>
        <a href="" class="me-4 text-reset social-media">
          <img src="${pageContext.request.contextPath}/assert/image/youtube_1384060.png" alt="">
        </a>
      </div>
    </section>
    <section class="">
      <div class="container text-center text-md-start mt-5">

        <div class="row mt-3">

          <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
            <h6 class="text-uppercase fw-bold mb-4">
              <i class="fas fa-gem me-3"></i>Royal Halls
            </h6>
            <p>
              Manage all your event details,
              sales and billings and enhance the
              client experience with 20+ online
              booking, event planning.
            </p>
          </div>
          <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
            <h6 class="text-uppercase fw-bold mb-4">Search Planning</h6>
            <p>
              <a href="Hall.html" class="text-reset">Search by Events</a>
            </p>
            <p>
              <a href="Hall.html" class="text-reset">Search by Seating Arrangements</a>
            </p>
            <p>
              <a href="Hall.html" class="text-reset">Search by Price</a>
            </p>
            <p>
              <a href="Hall.html" class="text-reset">Search by Hall</a>
            </p>
          </div>
          <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
            <h6 class="text-uppercase fw-bold mb-4">Useful links :</h6>
            <p>
              <a href="Home1.0.html" class="text-reset">Home</a>
            </p>
            <p>
              <a href="Hall.html" class="text-reset">Venues</a>
            </p>
            <p>
              <a href="facilities.html" class="text-reset">Facilities</a>
            </p>
            <p>
              <a href="contact.html" class="text-reset">Contact</a>
            </p>
          </div>
          <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
            <h6 class="text-uppercase fw-bold mb-4">Contact</h6>
            <p><i class="fas fa-home me-3"></i> Singa, Coimbatore</p>
            <p>
              <i class="fas fa-envelope me-3"></i>
              info@example.com
            </p>
            <p><i class="fas fa-phone me-3"></i> + 01 234 567 88</p>
            <p><i class="fas fa-print me-3"></i> + 01 234 567 89</p>
          </div>
        </div>
      </div>
    </section>
    
     <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  	<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <div class="text-center p-4 copyright">
      © 2021 Copyright:
      <a class="text-reset fw-bold" href="https://RoyalHalls.com/">RoyalHalls.com</a>
    </div>
  </footer>
  <script>
    document.addEventListener('DOMContentLoaded', function() {
        var today = new Date().toISOString().split('T')[0];
        document.getElementById('date').setAttribute('min', today);
    });
    
    document.querySelector(".closeModal").addEventListener("click", function() {
        document.getElementById("loginModal").style.display = "none";
    });

    document.getElementById('confirmLogoutButton').addEventListener('click', function() {
        // Add your logout logic here
        window.location.href = '<%= request.getContextPath() %>/LogoutServlet'; // Replace 'logoutURL' with the actual URL to log out
      });

      // Show the modal when the logout dropdown item is clicked
      document.getElementById('logout').addEventListener('click', function(event) {
        event.preventDefault();
        var logoutModal = new bootstrap.Modal(document.getElementById('logoutModal'));
        logoutModal.show();
      });
</script>
</body>
</html>
