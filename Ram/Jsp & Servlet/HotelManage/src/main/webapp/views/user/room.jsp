<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Rk Hotel - Accommodations</title>
 
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
 
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/user/room.css">
 <style>
 .hero {
            background-image: url(../../images/cityhotel.jpg);
           /* background-color: #FCEE21 center/cover no-repeat;*/
            height: 100vh;
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
        }
         .hero {
    height: calc(100vh - 70px); /* Adjust the height of the hero section to exclude navbar height */
   /* background: url('./images/r2.jpg') no-repeat center center;*/
    background-color: linear-gradient(to bottom, #ffff00 0%, #ffffcc 100%);
    background-size: cover;
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
    width: 100%;
}

.hero::before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: rgba(0, 0, 0, 0.5); /* Add a semi-transparent overlay */
}

.hero .container {
    position: relative;
    z-index: 1;
}

.hero__text-box {
    color: #fff;
    text-shadow: 0 2px 4px rgba(0, 0, 0, 0.6);
    text-align: center;
    max-width: 600px; /* Limit the width of the text box */
    margin: 0 auto; /* Center the text box horizontally */
}

.hero__text-top {
    font-size: 3rem;
    font-weight: bold;
}

.hero__text-bottom {
    font-size: 5rem;
    font-weight: bold;
}
 
 </style>
	
</head>

  <!-- Header -->
  <header>
    <nav class="navbar navbar-expand-lg navbar-dark">
      <div class="container">
        <a class="navbar-brand" href="main.jsp">Rk Hotel</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="../../index.jsp">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="${pageContext.request.contextPath}/CommonRoomServlet">Rooms</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="about.jsp">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="contact.jsp">Contact</a>
            </li>
     
            
            
     <c:choose>
            <c:when test="${not empty sessionScope.user}">
              
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  <img src="images/admin.jpg" alt="Profile" class="rounded-circle" style="width: 30px; height: 30px;">
                </a>
                <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="${pageContext.request.contextPath}/FetchProfileServlet">View Profile</a>
                  <div class="dropdown-divider"></div>
                  <a class="dropdown-item" href="${pageContext.request.contextPath}/LogoutUserServlet">Logout</a>
                </div>
              </li>
            </c:when>
            <c:otherwise>
              <li class="nav-item">
                <a class="nav-link btn btn-light text-white" href="login.jsp">
                  <span style="color: black">Login / Register</span>
                </a>
              </li>
            </c:otherwise>
          </c:choose>
          </ul>
        </div>
      </div>
    </nav>
    <div id="hero" class="hero">
        <div class="container text-center text-white">
            <h1 class="display-3" style="font-weight: bolder;">Luxury Comfort</h1>
           
        </div>
    </div>
  </header>

  <div class="container">
    <c:if test="${not empty sessionScope.message}">
            <div class="alert alert-${sessionScope.messageType} alert-dismissible fade show" role="alert">
                ${sessionScope.message}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <c:remove var="message" scope="session"/>
            <c:remove var="messageType" scope="session"/>
        </c:if>
    <h2 class="text-center mb-4">Our Rooms</h2>
    <div class="row">
        <!-- Room Card 1 - Single Room -->
        <div class="col-md-6 mb-5">
            <div class="card card-fixed-height">
              <img src="../../images/s3.jpg" class="card-img-top" alt="Single Room">
              <div class="card-body">
                <h5 class="card-title">Single Room</h5>
                <!-- <p class="card-text">Start From RM 80.00 / Night</p> -->
                <button class="btn btn-dark" data-toggle="modal" data-target="#singleRoomModal" >Check Details</button>
             <button class="btn btn-dark" data-toggle="modal" data-target="#bookingFormModal" onclick="fetchAvailableRooms('Single')"
                    <c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            enabled="true"
                        </c:when>
                        <c:otherwise>
                            disabled="true"
                        </c:otherwise>
                    </c:choose>
                >Book</button>
              </div>
            </div>
          </div>
  
  <!-- Room Card 2 - Double Room -->
  <div class="col-md-6 mb-4">
    <div class="card card-fixed-height">
      <img src="../../images/double1.jpg" class="card-img-top" alt="Double Room">
      <div class="card-body">
        <h5 class="card-title">Double Room</h5>
        <!-- <p class="card-text">Start From RM 120.00 / Night</p> -->
        <button class="btn btn-dark" data-toggle="modal" data-target="#doubleRoomModal">Check Details</button>
		<button id="bookButton" class="btn btn-dark" data-toggle="modal" data-target="#bookingFormModal" onclick="fetchAvailableRooms('Double')"
		<c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            enabled="true"
                        </c:when>
                        <c:otherwise>
                            disabled="true"
                        </c:otherwise>
                    </c:choose>
                >Book</button>
		</button>

      </div>
    </div>
  </div>
    </div>

    <div class="row">
  
 <!-- Room Card 3 - Family Room -->
<div class="col-md-6 mb-4">
  <div class="card card-fixed-height">
    <img src="../../images/fr.webp" class="card-img-top" alt="Family Room">
    <div class="card-body">
      <h5 class="card-title">Deluxe Room</h5>
      <!-- <p class="card-text">Start From <i class="fas fa-rupee-sign"></i> 199.00 / Night</p> -->
      <button class="btn btn-dark" data-toggle="modal" data-target="#deluxeRoomModal">Check Details</button>
	<button id="bookButton" class="btn btn-dark" data-toggle="modal" data-target="#bookingFormModal" onclick="fetchAvailableRooms('Deluxe Room')"
	<c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            enabled="true"
                        </c:when>
                        <c:otherwise>
                            disabled="true"
                        </c:otherwise>
                    </c:choose>
                >Book</button>
	</button>
      
    </div>
  </div>
</div>

  <!-- Room Card 4 - Luxury Room -->
  <div class="col-md-6 mb-4">
    <div class="card card-fixed-height">
        <img src="../../images/r3.jpg" class="card-img-top" alt="Luxury Room">
        <div class="card-body">
            <h5 class="card-title">Luxury Room</h5>
            <button class="btn btn-dark" data-toggle="modal" data-target="#luxuryRoomModal">Check Details</button>
            <button id="bookButton" class="btn btn-dark" data-toggle="modal" data-target="#bookingFormModal" onclick="fetchAvailableRooms('Luxury')"
            <c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            enabled="true"
                        </c:when>
                        <c:otherwise>
                            disabled="true"
                        </c:otherwise>
                    </c:choose>
                >Book</button>
            </button>

        </div>
    </div>
  </div>

<!-- MODALS -->
<!-- Single Room Modal -->
 <div class="modal fade" id="singleRoomModal" tabindex="-1" role="dialog" aria-labelledby="singleRoomModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="singleRoomModalLabel">Single Room Details</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
               <div class="header">
            <h1>${sessionScope.singleRoom.roomName} Room</h1>
        </div>
        <div class="container mt-5">
            <div id="singleRoomCarousel" class="carousel slide" data-ride="carousel">
                <!-- Carousel Inner Content -->
                <ol class="carousel-indicators">
                    <li data-target="#singleRoomCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#singleRoomCarousel" data-slide-to="1"></li>
                    <li data-target="#singleRoomCarousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="../../images/room1.jpg" class="d-block w-100" alt="Single Room Image 1">
                    </div>
                    <div class="carousel-item">
                        <img src="../../images/r4.jpg" class="d-block w-100" alt="Single Room Image 2">
                    </div>
                    <div class="carousel-item">
                        <img src="../../images/single.jpg" class="d-block w-100" alt="Single Room Image 3">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#singleRoomCarousel" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#singleRoomCarousel" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>

            <!-- Room Rates -->
            <div class="room-rates mt-4">
                <h2>Room Rates</h2>
                <div class="rates">
                    <!-- Room Rates Content -->
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${singleRoom.roomName}</h5>
                            <p class="card-text">Starting from <span style="color: #00264d; font-weight:bolder"><i class="fas fa-rupee-sign"></i> ${singleRoom.rent} </span>per night</p>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Special Features -->
            <div class="special-features mt-4">
                <h2>Special Features</h2>
                <ul>
                    <c:forEach var="feature" items="${fn:split(singleRoom.amenity, ',')}">
                        <li style="margin-bottom: 5px;"><i class="fas fa-check"></i> ${feature}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>


	

                        <!-- Room Amenities -->
                        <div class="room-amenities mt-4">
                            <h2>Room Amenities</h2>
                            <div class="row">
                            
                                <div class="col-sm-4 mb-3">
                                    <div class="card text-center">
                                        <i class="fas fa-wind my-2"></i>
                                        <p>Air Conditioning</p>
                                    </div>
                                </div>
                                <div class="col-sm-4 mb-3">
                                    <div class="card text-center">
                                        <i class="fas fa-tshirt my-2"></i>
                                        <p>Iron/Ironing Board</p>
                                    </div>
                                </div>
                                <div class="col-sm-4 mb-3">
                                    <div class="card text-center">
                                        <i class="fas fa-coffee my-2"></i>
                                        <p>Electric Kettle</p>
                                    </div>
                                </div>
                                <div class="col-sm-4 mb-3">
                                    <div class="card text-center">
                                        <i class="fas fa-phone my-2"></i>
                                        <p>Telephone</p>
                                    </div>
                                </div>
                                <div class="col-sm-4 mb-3">
                                    <div class="card text-center">
                                        <i class="fas fa-bed my-2"></i>
                                        <p>Hypoallergenic Bedding</p>
                                    </div>
                                </div>
                                <div class="col-sm-4 mb-3">
                                    <div class="card text-center">
                                        <i class="fas fa-couch my-2"></i>
                                        <p>Sofa</p>
                                    </div>
                                </div>
                                <div class="col-sm-4 mb-3">
                                    <div class="card text-center">
                                        <i class="fas fa-wine-glass-alt my-2"></i>
                                        <p>Minibar</p>
                                    </div>
                                </div>
                                <div class="col-sm-4 mb-3">
                                    <div class="card text-center">
                                        <i class="fas fa-lock my-2"></i>
                                        <p>Cupboards with Locks</p>
                                    </div>
                                </div>
                                <div class="col-sm-4 mb-3">
                                    <div class="card text-center">
                                        <i class="fas fa-tv my-2"></i>
                                        <p>TV</p>
                                    </div>
                                </div>
                                <div class="col-sm-4 mb-3">
                                    <div class="card text-center">
                                        <i class="fas fa-bath my-2"></i>
                                        <p>Towels</p>
                                    </div>
                                </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-shower my-2"></i>
                  <p>Shower</p>
                </div>
              </div>
            </div>
          </div>

          <!-- Guest Reviews -->
          <div class="mt-4">
            <h2>Guest Reviews</h2>
            <div class="scrolling-wrapper">
              <!-- Guest Reviews Content -->
              <div class="card mr-2 mb-3">
                <div class="card-body">
                  <h5 class="card-title">Perfect for Solo Travelers</h5>
                  <h6 class="card-subtitle mb-2 text-muted">Alex Martin . SOLO . Jan 10, 2024</h6>
                  <p class="card-text">5.0</p>
                  <p class="card-text">The room was just the right size for one person and had all the necessary amenities.</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
              <div class="card mr-2 mb-3">
                <div class="card-body">
                  <h5 class="card-title">Comfortable and Cozy</h5>
                  <h6 class="card-subtitle mb-2 text-muted">Jessica Lee . SOLO . Feb 12, 2024</h6>
                  <p class="card-text">4.5</p>
                  <p class="card-text">The room was comfortable and well-maintained. Great for a short stay.</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
              <div class="card mr-2 mb-3">
                <div class="card-body">
                  <h5 class="card-title">Nice and Quiet</h5>
                  <h6 class="card-subtitle mb-2 text-muted">Robert Green . SOLO . Mar 08, 2024</h6>
                  <p class="card-text">4.0</p>
                  <p class="card-text">Had a peaceful stay, and the room had everything I needed.</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
              <div class="card mb-3">
                <div class="card-body">
                  <h5 class="card-title">Good Value for Money</h5>
                  <h6 class="card-subtitle mb-2 text-muted">Samantha White . SOLO . Apr 25, 2024</h6>
                  <p class="card-text">4.0</p>
                  <p class="card-text">The room was affordable and had all the necessary amenities for a comfortable stay.</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
          
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
			<!-- Booking Form Modal -->
<div class="modal fade" id="bookingFormModal" tabindex="-1" role="dialog" aria-labelledby="bookingFormModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="bookingFormModalLabel">Book a Room</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <!-- Booking Form -->
                <form id="bookingForm" action="${pageContext.request.contextPath}/BookingServlet" method="POST" onsubmit="return validateForm()">
                    <div class="form-group">
                        <label for="customerName">Customer Name</label>
                        <input type="text" class="form-control" id="customerName" name="customerName" required>
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender</label>
                        <select class="form-control" id="gender" name="gender" required>
                            <option value="">Select Gender</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="phoneNo">Phone Number</label>
                        <input type="text" class="form-control" id="phoneNo" name="phoneNo" required>
                    </div>
                    <div class="form-group">
                        <label for="roomNumber">Room Number</label>
                        <select class="form-control" id="roomNumber" name="roomNumber" readonly required>
                            <!-- Options will be populated dynamically -->
                        </select>
                    </div>
					  <div class="form-group">
                        <label for="roomName">Room Name</label>
                        <input type="text" class="form-control" id="roomName" name="roomName" readonly>
                    </div>
                    <input type="hidden" id="roomRent" name="roomRent">
                    <div class="form-group">
                        <label for="checkinDate">Check-in Date</label>
                        <input type="date" class="form-control" id="checkinDate" name="checkinDate" onchange="calculateDaysStayed()" required>
                    </div>
                    <div class="form-group">
                        <label for="checkoutDate">Check-out Date</label>
                        <input type="date" class="form-control" id="checkoutDate" name="checkoutDate" onchange="calculateDaysStayed()" required>
                    </div>
                    <div class="form-group">
                        <label for="daysStayed">Number of Days Stayed</label>
                        <input type="text" class="form-control" id="daysStayed" name="daysStayed" readonly>
                    </div>
                    <button type="submit" class="btn btn-primary"  >Confirm Book</button>
                </form>
            </div>
        </div>
    </div>
</div>


  <!-- Double Room Modal -->
<div class="modal fade" id="doubleRoomModal" tabindex="-1" role="dialog" aria-labelledby="doubleRoomModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="doubleRoomModalLabel">Double Room Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="header">
          <a href="room.jsp">&larr; Back to Rooms</a>
        <h1>${doubleRoom.roomName}</h1>
        </div>
        <div class="container mt-5">
          <div id="doubleRoomCarousel" class="carousel slide" data-ride="carousel">
            <!-- Carousel Inner Content -->
            <ol class="carousel-indicators">
              <li data-target="#doubleRoomCarousel" data-slide-to="0" class="active"></li>
              <li data-target="#doubleRoomCarousel" data-slide-to="1"></li>
              <li data-target="#doubleRoomCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="../../images/double1.jpg" class="d-block w-100" alt="Double Room Image 1">
              </div>
              <div class="carousel-item">
                <img src="../../images/double2.jpg" class="d-block w-100" alt="Double Room Image 2">
              </div>
              <div class="carousel-item">
                <img src="../../images/double.jpeg" class="d-block w-100" alt="Double Room Image 3">
              </div>
            </div>
            <a class="carousel-control-prev" href="#doubleRoomCarousel" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#doubleRoomCarousel" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

          <!-- Room Rates -->
    <div class="room-rates mt-4">
        <h2>Room Rates</h2>
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">${doubleRoom.roomName} Room</h5>
                <p class="card-text">Starting from <span style="color: #00264d; font-weight:bolder"><i class="fas fa-rupee-sign"></i> ${doubleRoom.rent} </span>per night</p>
            </div>
        </div>
    </div>

            <!-- Special Features -->
    <div class="special-features mt-4">
        <h2>Special Features</h2>
        <ul>
            <c:forEach var="feature" items="${fn:split(doubleRoom.amenity, ',')}">
                <li style="margin-bottom: 5px;"><i class="fas fa-check"></i> ${feature}</li>
            </c:forEach>
        </ul>
    </div>

          <!-- Room Amenities -->
          <div class="room-amenities mt-4">
            <h2>Room Amenities</h2>
            <div class="row">
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-wind my-2"></i>
                  <p>Air Conditioning</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-tshirt my-2"></i>
                  <p>Iron/Ironing Board</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-coffee my-2"></i>
                  <p>Electric Kettle</p>
                </div>
              </div>
              <!-- Add more room amenities here if needed -->
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-phone my-2"></i>
                  <p>Telephone</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-bed my-2"></i>
                  <p>Hypoallergenic Bedding</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-couch my-2"></i>
                  <p>Sofa</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-wine-glass-alt my-2"></i>
                  <p>Minibar</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-lock my-2"></i>
                  <p>Cupboards with Locks</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-tv my-2"></i>
                  <p>TV</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-bath my-2"></i>
                  <p>Towels</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-shower my-2"></i>
                  <p>Shower</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-bath my-2"></i>
                  <p>Towels</p>
                </div>
              </div>
            </div>
          </div>

          <!-- Guest Reviews -->
          <div class="mt-4">
            <h2>Guest Reviews</h2>
            <div class="scrolling-wrapper">
              <!-- Guest Reviews Content -->
              <div class="card mr-2 mb-3">
                <div class="card-body">
                  <h5 class="card-title">Perfect for Couples</h5>
                  <h6 class="card-subtitle mb-2 text-muted">Alice Johnson . COUPLE . Jan 15, 2024</h6>
                  <p class="card-text">5.0</p>
                  <p class="card-text">The room was cozy and had everything we needed for a romantic getaway.</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
              <div class="card mr-2 mb-3">
                <div class="card-body">
                  <h5 class="card-title">Wonderful Experience</h5>
                  <h6 class="card-subtitle mb-2 text-muted">David Brown . COUPLE . Feb 10, 2024</h6>
                  <p class="card-text">4.5</p>
                  <p class="card-text">Loved the ambiance and the service. Will visit again!</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
              <div class="card mr-2 mb-3">
                <div class="card-body">
                  <h5 class="card-title">Great Stay</h5>
                  <h6 class="card-subtitle mb-2 text-muted">Emily Clark . COUPLE . Mar 05, 2024</h6>
                  <p class="card-text">4.0</p>
                  <p class="card-text">Comfortable and clean, with all the amenities we needed.</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
              <div class="card mb-3">
                <div class="card-body">
                  <h5 class="card-title">Highly Recommend</h5>
                  <h6 class="card-subtitle mb-2 text-muted">James Wilson . COUPLE . Apr 20, 2024</h6>
                  <p class="card-text">4.0</p>
                  <p class="card-text">Excellent value for money, and a great location.</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>

  
  <!-- Deluxe Room Modal -->
<div class="modal fade" id="deluxeRoomModal" tabindex="-1" role="dialog" aria-labelledby="deluxeRoomModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="deluxeRoomModalLabel">Deluxe Room Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div class="header">
          <a href="room.jsp">&larr; Back to Rooms</a>
          <h1>${deluxeRoom.roomName}</h1>
        </div>
        <div class="container mt-5">
          <div id="deluxeRoomCarousel" class="carousel slide" data-ride="carousel">
            <!-- Carousel Inner Content -->
            <ol class="carousel-indicators">
              <li data-target="#deluxeRoomCarousel" data-slide-to="0" class="active"></li>
              <li data-target="#deluxeRoomCarousel" data-slide-to="1"></li>
              <li data-target="#deluxeRoomCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img src="../../images/deluxe1.jpg" class="d-block w-100" alt="Deluxe Room Image 1">
              </div>
              <div class="carousel-item">
                <img src="../../images/deluxe2.jpg" class="d-block w-100" alt="Deluxe Room Image 2">
              </div>
              <div class="carousel-item">
                <img src="../../images/deluxe3.jpg" class="d-block w-100" alt="Deluxe Room Image 3">
              </div>
            </div>
            <a class="carousel-control-prev" href="#deluxeRoomCarousel" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#deluxeRoomCarousel" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

          <!-- Room Rates -->
          <div class="room-rates mt-4">
            <h2>Room Rates</h2>
            <div class="rates">
              <!-- Room Rates Content -->
              <div class="card">
                <div class="card-body">
                  <h5 class="card-title">${deluxeRoom.roomName}</h5>
                  <p class="card-text">Starting from <span style="color: #00264d; font-weight:bolder"><i class="fas fa-rupee-sign"></i> ${deluxeRoom.rent} </span>per night</p>
                </div>
              </div>
            </div>
          </div>

          <!-- Special Features -->
          <div class="special-features mt-4">
            <h2>Special Features</h2>
            <ul>
              <c:forEach var="feature" items="${fn:split(deluxeRoom.amenity, ',')}">
                <li style="margin-bottom: 5px;"><i class="fas fa-check"></i> ${feature}</li>
              </c:forEach>
            </ul>
          </div>

          <!-- Room Amenities -->
          <div class="room-amenities mt-4">
            <h2>Room Amenities</h2>
            <div class="row">
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-wind my-2"></i>
                  <p>Air Conditioning</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-tshirt my-2"></i>
                  <p>Iron/Ironing Board</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-coffee my-2"></i>
                  <p>Electric Kettle</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-door-open my-2"></i>
                  <p>Interconnected Room</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-phone my-2"></i>
                  <p>Telephone</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-bed my-2"></i>
                  <p>Hypoallergenic Bedding</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-couch my-2"></i>
                  <p>Sofa</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-wine-glass-alt my-2"></i>
                  <p>Minibar</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-lock my-2"></i>
                  <p>Cupboards with Locks</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-tv my-2"></i>
                  <p>TV</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-bath my-2"></i>
                  <p>Towels</p>
                </div>
              </div>
              <div class="col-sm-4 mb-3">
                <div class="card text-center">
                  <i class="fas fa-shower my-2"></i>
                  <p>Shower</p>
                </div>
              </div>
            </div>
          </div>
          <!-- Guest Reviews -->
          <div class="mt-4">
            <h2>Guest Reviews</h2>
            <div class="scrolling-wrapper">
              <!-- Guest Reviews Content -->
              <div class="card mr-2 mb-3">
                <div class="card-body">
                  <h5 class="card-title">Excellent for Families</h5>
                  <h6 class="card-subtitle mb-2 text-muted">John Doe . FAMILY . Jan 01, 2024</h6>
                  <p class="card-text">5.0</p>
                  <p class="card-text">Spacious and well-maintained, perfect for a family vacation.</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
              <div class="card mr-2 mb-3">
                <div class="card-body">
                  <h5 class="card-title">Comfortable and Clean</h5>
                  <h6 class="card-subtitle mb-2 text-muted">Jane Smith . FAMILY . Feb 01, 2024</h6>
                  <p class="card-text">4.5</p>
                  <p class="card-text">Very comfortable room with good amenities. Highly recommend.</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
              <div class="card mr-2 mb-3">
                <div class="card-body">
                  <h5 class="card-title">Great Experience</h5>
                  <h6 class="card-subtitle mb-2 text-muted">Michael Lee . FAMILY . Mar 01, 2024</h6>
                  <p class="card-text">4.0</p>
                  <p class="card-text">Had a wonderful time, will definitely come back.</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
              <div class="card mb-3">
                <div class="card-body">
                  <h5 class="card-title">Good Value</h5>
                  <h6 class="card-subtitle mb-2 text-muted">Emily Davis . FAMILY . Apr 01, 2024</h6>
                  <p class="card-text">4.0</p>
                  <p class="card-text">Nice and affordable, the kids loved it.</p>
                  <div>
                    <span style="cursor: pointer;" class="heart">&#x2661;</span>
                    <span class="like-text">Like</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="luxuryRoomModal" tabindex="-1" role="dialog" aria-labelledby="luxuryRoomModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
          <div class="modal-header">
              <h5 class="modal-title" id="luxuryRoomModalLabel">Luxury Room Details</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                  <span aria-hidden="true">&times;</span>
              </button>
          </div>
          <div class="modal-body">
              <div class="header mb-4">
                  <a href="room.jsp">&larr; Back to Rooms</a>
                  <h1>${luxuryRoom.roomName}</h1>
              </div>
              <div class="container mt-4">
                <div id="luxuryRoomCarousel" class="carousel slide" data-ride="carousel">
                  <!-- Carousel Inner Content -->
                  <ol class="carousel-indicators">
                      <li data-target="#luxuryRoomCarousel" data-slide-to="0" class="active"></li>
                      <li data-target="#luxuryRoomCarousel" data-slide-to="1"></li>
                      <li data-target="#luxuryRoomCarousel" data-slide-to="2"></li>
                  </ol>
                  <div class="carousel-inner">
                      <div class="carousel-item active">
                          <img src="../../images/double2.jpg" class="d-block w-100" alt="Luxury Room Image 1">
                      </div>
                      <div class="carousel-item">
                          <img src="../../images/double1.jpg" class="d-block w-100" alt="Luxury Room Image 2">
                      </div>
                      <div class="carousel-item">
                          <img src="../../images/cityhotel.jpg" class="d-block w-100" alt="Luxury Room Image 3">
                      </div>
                  </div>
                  <a class="carousel-control-prev" href="#luxuryRoomCarousel" role="button" data-slide="prev">
                      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                      <span class="sr-only">Previous</span>
                  </a>
                  <a class="carousel-control-next" href="#luxuryRoomCarousel" role="button" data-slide="next">
                      <span class="carousel-control-next-icon" aria-hidden="true"></span>
                      <span class="sr-only">Next</span>
                  </a>
                </div>
                <!-- Room Rates -->
                <div class="room-rates mt-4">
                  <h2>Room Rates</h2>
                  <div class="card">
                      <div class="card-body">
                          <h5 class="card-title">${luxuryRoom.roomName}</h5>
                          <p class="card-text">Starting from <span style="color: #00264d; font-weight: bolder;"><i class="fas fa-rupee-sign"></i> ${luxuryRoom.rent} </span>per night</p>
                      </div>
                  </div>
                </div>
                <!-- Special Features -->
                <div class="special-features mt-4">
                  <h2>Special Features</h2>
                  <ul class="list-unstyled">
                    <c:forEach var="feature" items="${fn:split(luxuryRoom.amenity, ',')}">
                      <li class="mb-2"><i class="fas fa-check"></i> ${feature}</li>
                    </c:forEach>
                  </ul>
                </div>

                <!-- Room Amenities -->
                <div class="room-amenities mt-4">
                  <h2>Room Amenities</h2>
                  <div class="row">
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-wind my-2"></i>
                        <p>Air Conditioning</p>
                      </div>
                    </div>
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-tshirt my-2"></i>
                        <p>Iron/Ironing Board</p>
                      </div>
                    </div>
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-coffee my-2"></i>
                        <p>Electric Kettle</p>
                      </div>
                    </div>
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-door-open my-2"></i>
                        <p>Interconnected Room</p>
                      </div>
                    </div>
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-phone my-2"></i>
                        <p>Telephone</p>
                      </div>
                    </div>
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-bed my-2"></i>
                        <p>Hypoallergenic Bedding</p>
                      </div>
                    </div>
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-couch my-2"></i>
                        <p>Sofa</p>
                      </div>
                    </div>
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-wine-glass-alt my-2"></i>
                        <p>Minibar</p>
                      </div>
                    </div>
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-lock my-2"></i>
                        <p>Cupboards with Locks</p>
                      </div>
                    </div>
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-tv my-2"></i>
                        <p>TV</p>
                      </div>
                    </div>
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-bath my-2"></i>
                        <p>Towels</p>
                      </div>
                    </div>
                    <div class="col-sm-4 mb-3">
                      <div class="card text-center">
                        <i class="fas fa-shower my-2"></i>
                        <p>Shower</p>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- Guest Reviews -->
                <div class="guest-reviews mt-4">
                  <h2>Guest Reviews</h2>
                  <div class="scrolling-wrapper">
                    <div class="card mr-2 mb-3">
                      <div class="card-body">
                        <h5 class="card-title">Value for money, nice staff and well maintained and good facilities</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Niranjanamurthy Tk . GROUP . Jun 01, 2024</h6>
                        <p class="card-text">5.0</p>
                        <p class="card-text">Nice and good location with good staff and nice food, complimentary breakfast is too good and well in taste.</p>
                        <div>
                          <span style="cursor: pointer;" class="heart">&#x2661;</span>
                          <span class="like-text">Like</span>
                        </div>
                      </div>
                    </div>
                    <div class="card mr-2 mb-3">
                      <div class="card-body">
                        <h5 class="card-title">Average Stay</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Junaid Khan Junaid Cm . BUSINESS . Jun 01, 2024</h6>
                        <p class="card-text">3.0</p>
                        <p class="card-text">Room AC was not working well. I had been waited for 20 minutes for breakfast that there were no more items.</p>
                        <div style="font-size: medium;">
                          <span style="cursor: pointer;" class="heart">&#x2661;</span>
                          <span class="like-text">Like</span>
                        </div>
                      </div>
                    </div>
                    <div class="card mr-2 mb-3">
                      <div class="card-body">
                        <h5 class="card-title">Good Stay</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Lakshminarayanan Virudhanayagam . COUPLE . May 27, 2024</h6>
                        <p class="card-text">4.0</p>
                        <p class="card-text">The rooms are big and neat, breakfast was good, but the front office staffs need to be trained well for this kind of 5-star hotel. They are not willing to help even for my luggage. I need to call them 4 times to bring it to my room.</p>
                        <div>
                          <span style="cursor: pointer;" class="heart">&#x2661;</span>
                          <span class="like-text">Like</span>
                        </div>
                      </div>
                    </div>
                    <div class="card mb-3">
                      <div class="card-body">
                        <h5 class="card-title">Nice and good location with good staff and nice food</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Mohamed Imran . FAMILY . May 26, 2024</h6>
                        <p class="card-text">5.0</p>
                        <p class="card-text">Nice hotel, friendly staff, totally worth for money.</p>
                        <div>
                          <span style="cursor: pointer;" class="heart">&#x2661;</span>
                          <span class="like-text">Like</span>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
          </div>
          <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          </div>
      </div>
  </div>
</div>
    </div>
  </div>

 
<footer class="footer bg-dark text-white py-4">
  <div class="container-fluid">
    <div class="back-to-top text-center mb-3">
      <a href="#hero" class="text-white">
        <i class="fas fa-chevron-up"></i>
      </a>
    </div>
    <div class="footer__content row text-center text-md-left">
      <div class="col-md-4 mb-3">
        <h4>About</h4>
        <p>
          Rk Hotel offers luxurious rooms with top-notch amenities and
          exceptional service. Experience the best in comfort and
          convenience.
        </p>
      </div>
      <div class="col-md-4 mb-3">
        <h4>Payment Methods</h4>
        <p>Pay any way you choose, we support all major payment options</p>
        <ul class="list-inline payment-methods">
          <li class="list-inline-item">
            <a href="#" class="text-white">
              <i class="fab fa-paypal fa-2x"></i>
            </a>
          </li>
          <li class="list-inline-item">
            <a href="#" class="text-white">
              <i class="fab fa-cc-visa fa-2x"></i>
            </a>
          </li>
          <li class="list-inline-item">
            <a href="#" class="text-white">
              <i class="fab fa-cc-mastercard fa-2x"></i>
            </a>
          </li>
          <li class="list-inline-item">
            <a href="#" class="text-white">
              <i class="fab fa-apple-pay fa-2x"></i>
            </a>
          </li>
        </ul>
      </div>
      <div class="col-md-4 mb-3">
        <h4>Get Social</h4>
        <p>
          Follow us on social media to stay updated with the latest offers
          and news.
        </p>
        <ul class="list-inline social-icons">
          <li class="list-inline-item">
            <a href="#" class="text-white">
              <i class="fab fa-facebook-f fa-2x"></i>
            </a>
          </li>
          <li class="list-inline-item">
            <a href="#" class="text-white">
              <i class="fab fa-twitter fa-2x"></i>
            </a>
          </li>
          <li class="list-inline-item">
            <a href="#" class="text-white">
              <i class="fab fa-instagram fa-2x"></i>
            </a>
          </li>
          <li class="list-inline-item">
            <a href="#" class="text-white">
              <i class="fab fa-tripadvisor fa-2x"></i>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</footer>
  
  
  
    <!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
      document.addEventListener('DOMContentLoaded', function() {
    	  /*
    	  console.log("inside");
    	  fetch('${pageContext.request.contextPath}/AvailableRoomsServlet')
          .then(response => response.json())
          .then(data => {
        	  console.log('Check 1');
              const roomNumberSelect = document.getElementById('roomNumber');
              console.log('Check 2');
              roomNumberSelect.innerHTML = ''; // Clear existing options
              console.log('Check 3');
              
              data.forEach(room => {
            	  console.log('Check 4');
                  const option = document.createElement('option');
                  console.log('Check 5');
                  option.value = room;
                  console.log('Check 6');
                  console.log("room id : "+room);
                  console.log('Check 7');
                  option.text = room;
                  roomNumberSelect.appendChild(option);
              });
              // Set the roomNumber select to read-only after fetching the available rooms
              roomNumberSelect.readOnly = false;
          })
          .catch(error => console.error('Error fetching available rooms:', error)); 
    	  */
        // Get all heart elements
        var hearts = document.querySelectorAll('.heart');
        // Get all dislike elements
        var dislikes = document.querySelectorAll('.dislike');
        
        // Attach click event listener to each heart
        hearts.forEach(function(heart) {
            heart.addEventListener('click', function() {
                // Toggle 'liked' class for heart
                this.classList.toggle('liked');
                // If liked, remove 'disliked' class from dislike
                if (this.classList.contains('liked')) {
                    this.nextElementSibling.classList.remove('disliked');
                }
            });
        });

        
    });
  </script>
  
  <script>
    
  function validateForm() {
	    const customerName = document.getElementById('customerName').value;
	    const gender = document.getElementById('gender').value;
	    const roomNumber = document.getElementById('roomNumber').value;
	    const checkinDate = document.getElementById('checkinDate').value;
	    const checkoutDate = document.getElementById('checkoutDate').value;

	    if (!customerName || !gender || !roomNumber || !checkinDate || !checkoutDate) {
	        alert('All fields are required.');
	        return false;
	    }

	    if (new Date(checkinDate) >= new Date(checkoutDate)) {
	        alert('Check-out date must be after check-in date.');
	        return false;
	    }

	    return true;
	}
</script>


<script>

function fetchAvailableRooms(roomType) {
	
	 var rn = document.getElementById('roomName').value = roomType;

    fetch('${pageContext.request.contextPath}/AvailableRoomsServlet?roomType='+roomType)
        .then(response => response.json())
        .then(data => {
        	 // Set the room name in the booking form modal
           
            const roomNumberSelect = document.getElementById('roomNumber');
            roomNumberSelect.innerHTML = ''; // Clear existing options
            data.forEach(room => {
                const option = document.createElement('option');
                option.value = room;
                option.text = room;
                console.log("room id : "+room)
                roomNumberSelect.appendChild(option);
            });
            // Set the roomNumber select to read-only after fetching the available rooms
            roomNumberSelect.readOnly = false;
        })
        .catch(error => console.error('Error fetching available rooms:', error));
}

</script>
<script>
    function calculateDaysStayed() {
        var checkinDate = new Date(document.getElementById('checkinDate').value);
        var checkoutDate = new Date(document.getElementById('checkoutDate').value);

        // Calculate the difference in milliseconds
        var difference = checkoutDate.getTime() - checkinDate.getTime();
        
        // Convert milliseconds to days
        var daysStayed = Math.ceil(difference / (1000 * 3600 * 24));

        // Update the days stayed input
        document.getElementById('daysStayed').value = daysStayed;
    }
</script>
<!-- 
<script>
function fetchAvailableRooms(roomType) {
    fetch('${pageContext.request.contextPath}/AvailableRoomsServlet?roomType=' + roomType)
        .then(response => response.json())
        .then(data => {
            const roomNumberSelect = document.getElementById('roomNumber');
            roomNumberSelect.innerHTML = ''; // Clear existing options
            data.forEach(room => {
                const option = document.createElement('option');
                option.value = room.roomNumber;
                console.log("Room Rent :"+room);
                option.text = `Room ${room.roomNumber} - $${room.roomRent}`;
                
                option.dataset.rent = room.roomRent; // Store rent in data attribute
                console.log("Rent :"+room);
                roomNumberSelect.appendChild(option);
            });
            // Set the roomNumber select to read-only after fetching the available rooms
            roomNumberSelect.readOnly = false;
        })
        .catch(error => console.error('Error fetching available rooms:', error));
}
</script>
 -->

 </script>
  </body>
  </html>
  
    