<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>RK Hotel Booking</title>
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="../../css/user/booking.css">
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
<body>

<header>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="main.jsp">RK Hotel</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
      <a class="nav-link" href="../../index.jsp">Home</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="room.jsp">Rooms</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="about.jsp">About</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="contact.jsp">Contact</a>
          </li>
          <li class="nav-item">
            <button class="btn btn-outline-light mx-2" onclick="showCartModal()">
              <i class="fas fa-shopping-cart"></i> Cart <span id="cartItemCount" class="badge badge-danger">0</span>
            </button>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  <div id="hero" class="hero">
    <div class="container text-center text-white">
      <h1>Welcome to RK Hotel</h1>
      <p class="lead">"Unlock Your Dream Room"</p>
    </div>
  </div>
</header>


<main class="container mt-4">
  <h2 class="text-center mb-4" style="font-weight: bolder; color:rgb(255, 143, 0)">Rooms Available</h2>

  <!-- Search and Filter Section -->
  <div class="row mb-4">
    <div class="col-md-6">
      <input type="text" id="searchInput" class="form-control" placeholder="Search by Room Type">
    </div>
    <div class="col-md-3">
      <input type="number" id="minPrice" class="form-control" placeholder="Min Price">
    </div>
    <div class="col-md-3">
      <input type="number" id="maxPrice" class="form-control" placeholder="Max Price">
    </div>
  </div>
  <div class="row mb-4">
    <div class="col text-center">
      <button class="btn btn-primary" onclick="filterRooms()">Filter Rooms</button>
    </div>
  </div>



<!-- ROOM BOOKING STARTS:::	 -->
<%@ page import="java.util.List" %>
<%@ page import="com.hotelmanagement.dao.RoomDAO" %>

  <div class="row">
	     <div class="col-md-3 mb-4">
            <div class="card card-fixed-height">
                <img src="../../images/single.jpg" class="card-img-top" alt="Single Room">
                <div class="card-body">
                    <h5 class="card-title">Single Room</h5>
                    <button class="btn btn-primary btn-fixed-right" onclick="openBookingModal('Single')">View Rooms</button>
                </div>
            </div>
        </div>
        <div class="col-md-3 mb-4">
            <div class="card card-fixed-height">
                <img src="../../images/double1.jpg" class="card-img-top" alt="Double Room">
                <div class="card-body">
                    <h5 class="card-title">Double Room</h5>
                    <button class="btn btn-primary btn-fixed-right" onclick="openBookingModal('Double')">View Rooms</button>
                </div>
            </div>
        </div>
        <div class="col-md-3 mb-4">
            <div class="card card-fixed-height">
                <img src="../../images/fr.webp" class="card-img-top" alt="Family Room">
                <div class="card-body">
                    <h5 class="card-title">Family Room</h5>
                    <button class="btn btn-primary btn-fixed-right" onclick="openBookingModal('Family')">View Rooms</button>
                </div>
            </div>
        </div>
        <div class="col-md-3 mb-4">
            <div class="card card-fixed-height">
                <img src="../../images/cityhotel.jpg" class="card-img-top" alt="Luxury Room">
                <div class="card-body">
                    <h5 class="card-title">Luxury Room</h5>
                    <button class="btn btn-primary btn-fixed-right" onclick="openBookingModal('Luxury')">View Rooms</button>
                </div>
            </div>
        </div>
  </div>
<!-- Example Modal Form for Room Booking -->
 <main class="container">
    <div class="row" id="roomContainer"></div>
    
    <!-- Booking Modal -->
    <div class="modal fade" id="bookingModal" tabindex="-1" role="dialog" aria-labelledby="bookingModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="bookingModalLabel">Room Booking</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Booking Form -->
                    <form id="bookingForm" action="#" method="post" onsubmit="return validateBookingForm()">
                        <!-- Basic Booking Details -->
                        <div class="form-group">
                            <label for="guestName">Guest Name</label>
                            <input type="text" class="form-control" id="guestName" name="guestName" required>
                        </div>
                        <div class="form-group">
                            <label for="address">Address</label>
                            <input type="text" class="form-control" id="address" name="address" required>
                        </div>
                        <div class="form-group">
                            <label for="gender">Gender</label>
                            <select class="form-control" id="gender" name="gender" required>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="phoneNumber">Phone Number</label>
                            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" required>
                        </div>
                        <div class="form-group">
                            <label for="checkInDate">Check-in Date</label>
                            <input type="date" class="form-control" id="checkInDate" name="checkInDate" required>
                        </div>
                        <div class="form-group">
                            <label for="checkOutDate">Check-out Date</label>
                            <input type="date" class="form-control" id="checkOutDate" name="checkOutDate" required>
                        </div>
                        <div class="form-group">
                            <label for="numberOfGuests">Number of Guests</label>
                            <input type="number" class="form-control" id="numberOfGuests" name="numberOfGuests" required>
                        </div>

                        <!-- Additional Guest Information -->
                        <div id="additionalGuests">
                            <!-- Dynamic fields will be added here -->
                        </div>

                        <!-- Add Additional Guest Button -->
                        <button type="button" class="btn btn-success mb-3" onclick="addGuestField()">Add Additional Guest</button>

                      <!-- Room Selection -->
                      <%@ page import="java.util.List" %>
					  <%@ page import="com.hotelmanagement.dao.RoomTypeDao" %>
		 			  <%@ page import="com.hotelmanagement.bean.RoomType" %>
                          <form action="${pageContext.request.contextPath}/GetRoomNumbersServlet" method="post">
        <div class="form-group">
            <label for="roomType">Room Type</label>
            <select class="form-control" id="roomType" name="roomType" required onchange="this.form.submit()">
                <!-- Options populated dynamically from database -->
                <% 
                    RoomTypeDao roomTypeDao = new RoomTypeDao();
                    List<RoomType> roomTypes = roomTypeDao.getAllRoomTypes();
                    String selectedRoomType = request.getAttribute("selectedRoomType") != null ? (String) request.getAttribute("selectedRoomType") : "";
                    for(RoomType roomType : roomTypes) {
                        String selected = selectedRoomType.equals(roomType.getRoomName()) ? "selected" : "";
                %>
                    <option value="<%= roomType.getRoomName() %>" <%= selected %>><%= roomType.getRoomName() %></option>
                <% } %>
            </select>
        </div>
                        
                         <%@ page import="com.hotelmanagement.dao.RoomDAO" %>
		 			  <%@ page import="com.hotelmanagement.bean.Room" %>
		 			  <%@ page import="com.hotelmanagement.dao.RoomTypeDao" %>
		 			  <%@ page import="com.hotelmanagement.bean.RoomType" %>
                       <div class="form-group">
            <label for="roomSelection">Room Number</label>
            <select class="form-control" id="roomSelection" name="roomSelection" required>
                <!-- Options populated dynamically based on room type -->
                <%
                    if (request.getAttribute("rooms") != null) {
                        List<Room> rooms = (List<Room>) request.getAttribute("rooms");
                        for (Room room : rooms) {
                %>
                    <option value="<%= room.getRoomId() %>"><%= room.getRoomId() %></option>
                <% 
                        }
                    }
                %>
            </select>
        </div>

                        <!-- Hidden Input for Room ID -->
                        <input type="hidden" id="roomId" name="roomId">

                        <!-- Number of Days Stayed -->
                        <div class="form-group">
                            <label for="noOfDays">Number of Days Stayed</label>
                            <input type="number" class="form-control" id="noOfDays" name="noOfDays" required>
                        </div>

                        <!-- Price Calculation -->
                        <div class="form-group">
                            <label for="price">Price</label>
                            <input type="text" class="form-control" id="price" name="price" readonly>
                        </div>

                        <!-- Submit Button -->
                        <button type="submit" class="btn btn-primary">Confirm Booking</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
</div>

  <div class="row" id="roomContainer"></div>
</main>
  <!-- Confirm Booking Button -->
  <div class="text-center mb-4">
    <button id="confirmBookingButton" class="btn btn-primary" onclick="confirmBooking()" disabled>Confirm Booking</button>
  </div>
  
  <ul class="navbar-nav ml-auto">
    <!-- Other menu items -->
    <li class="nav-item">
      <button class="btn btn-outline-light mx-2" onclick="showCartModal()">
        <i class="fas fa-shopping-cart"></i> Cart <span id="cartItemCount" class="badge badge-danger"></span>
      </button>
    </li>
  </ul>
  
</main>

<!-- MODALS -->
<!-- Room Details Modal -->
<div class="modal fade" id="roomDetailsModal" tabindex="-1" aria-labelledby="roomDetailsModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="roomDetailsModalLabel">Room Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id="roomDetailsContent">
        <!-- Room details will be inserted here dynamically -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


<!-- Cart Modal -->
<div class="modal fade" id="cartModal" tabindex="-1" aria-labelledby="cartModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="cartModalLabel">Your Cart</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <table class="table">
          <thead>
            <tr>
              <th scope="col">Room</th>
              <th scope="col">Price</th>
              <th scope="col">Qty</th>
              <th scope="col">Total</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody id="cartItems">
            <!-- Cart items will be inserted here dynamically -->
          </tbody>
        </table>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="checkout()">Checkout</button>
      </div>
    </div>
  </div>
</div>

<!-- Booking Details Modal -->
<div class="modal fade" id="bookingDetailsModal" tabindex="-1" aria-labelledby="bookingDetailsModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="bookingDetailsModalLabel">Booking Details</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form id="bookingDetailsForm">
        <div class="modal-body">
          <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" required>
          </div>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" required>
          </div>
          <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" class="form-control" id="phone" required>
          </div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="submit" class="btn btn-primary">Submit</button>
        </div>
      </form>
    </div>
  </div>
</div>
<!-- Booking Confirmation Modal -->
<div class="modal fade" id="confirmBookingModal" tabindex="-1" aria-labelledby="confirmBookingModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="confirmBookingModalLabel">Confirm Booking</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        Are you sure you want to confirm the booking?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" onclick="finalizeBooking()">Confirm</button>
      </div>
    </div>
  </div>
</div>
<script>
  let roomType = '';

  function openBookingModal(type) {
    roomType = type;
    $('#bookingModal').modal('show');
    fetchRoomNumbers(type);
  }
/*
  function fetchRoomNumbers() {
	    var roomType = $('#roomType').val();
	    console.log("Fetching rooms for type: " + roomType); // Debugging statement
	    $.ajax({
	        url: 'RoomServlet',
	        method: 'GET',
	        data: { roomType: roomType },
	        success: function (data) {
	            console.log("Received room data: " + data); // Debugging statement
	            $('#roomSelection').html(data);
	        },
	        error: function (xhr, status, error) {
	            console.log("Error fetching room data: " + error); // Debugging statement
	        }
	    });
	}
	*/
	  function fetchRoomNumbers() {
        var roomTypeName = document.getElementById("roomType").value;
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "GetRoomNumbers?roomTypeName=" + encodeURIComponent(roomTypeName), true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                var roomNumbers = JSON.parse(xhr.responseText);
                var roomSelection = document.getElementById("roomSelection");
                roomSelection.innerHTML = "";
                for (var i = 0; i < roomNumbers.length; i++) {
                    var option = document.createElement("option");
                    option.value = roomNumbers[i].roomId;
                    option.text = roomNumbers[i].roomNo;
                    roomSelection.add(option);
                }
            }
        };
        xhr.send();
    }
  
  /*
  function fetchRoomNumbers(roomType) {
    fetch('RoomServlet?roomType=' + roomType)
      .then(response => response.text())
      .then(data => {
        document.getElementById('roomSelection').innerHTML = data;
      })
      .catch(error => console.error('Error fetching room numbers:', error));
  }
  */

  function addGuestField() {
    const guestIndex = document.querySelectorAll('#additionalGuests .guest-info').length + 1;
    const guestField = `
      <div class="guest-info">
        <hr>
        <h5>Additional Guest ${guestIndex}</h5>
        <div class="form-group">
          <label for="guestName${guestIndex}">Guest Name</label>
          <input type="text" class="form-control" id="guestName${guestIndex}" name="guestName${guestIndex}" required>
        </div>
        <div class="form-group">
          <label for="address${guestIndex}">Address</label>
          <input type="text" class="form-control" id="address${guestIndex}" name="address${guestIndex}" required>
        </div>
        <div class="form-group">
          <label for="gender${guestIndex}">Gender</label>
          <select class="form-control" id="gender${guestIndex}" name="gender${guestIndex}" required>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
          </select>
        </div>
        <div class="form-group">
          <label for="phoneNumber${guestIndex}">Phone Number</label>
          <input type="text" class="form-control" id="phoneNumber${guestIndex}" name="phoneNumber${guestIndex}" required>
        </div>
        <button type="button" class="btn btn-danger mb-3" onclick="removeGuestField(this)">Remove Guest</button>
      </div>
    `;
    document.getElementById('additionalGuests').insertAdjacentHTML('beforeend', guestField);
  }

  function removeGuestField(button) {
    button.parentElement.remove();
  }

  function validateBookingForm() {
    const checkInDate = document.getElementById('checkInDate').value;
    const checkOutDate = document.getElementById('checkOutDate').value;
    const numberOfGuests = parseInt(document.getElementById('numberOfGuests').value);
    const additionalGuests = document.querySelectorAll('#additionalGuests .guest-info').length;
    const today = new Date().toISOString().split('T')[0];

    if (checkInDate < today) {
      alert('Check-in date cannot be in the past.');
      return false;
    }

    if (checkOutDate <= checkInDate) {
      alert('Check-out date must be after the check-in date.');
      return false;
    }

    if (numberOfGuests < 1 || numberOfGuests > additionalGuests + 1) {
      alert('Number of guests must match the number of additional guest fields.');
      return false;
    }

    calculatePrice();
    return true;
  }

  function calculatePrice() {
    const noOfDays = document.getElementById('noOfDays').value;
    let roomPrice = 0;
    if (roomType === 'Single') {
      roomPrice = 100; // Example price, replace with actual logic
    } else if (roomType === 'Double') {
      roomPrice = 150; // Example price, replace with actual logic
    } // Add logic for other room types
    const totalPrice = noOfDays * roomPrice;
    document.getElementById('price').value = totalPrice;
  }
</script>
<script>
  // Function to open booking modal and populate data
  function openBookingModal(roomType) {
    // Example: Fetch room details based on roomType (replace with your logic)
    var roomDetails = {
      roomType: roomType,
      // Add more details as needed (e.g., room number, description)
    };

    // Populate modal with room details
    document.getElementById('bookingModalLabel').textContent = `Room Booking - ${roomDetails.roomType}`;
    document.getElementById('roomSelection').innerHTML = `<option value="${roomDetails.roomType}">${roomDetails.roomType}</option>`;
    document.getElementById('roomId').value = roomDetails.roomId; // Set room ID if applicable

    // Open the modal
    $('#bookingModal').modal('show');
  }

  // Function to add additional guest fields dynamically
  function addGuestField() {
    var additionalGuestsDiv = document.getElementById('additionalGuests');
    var guestField = document.createElement('div');
    guestField.innerHTML = `
      <div class="form-group">
        <label for="additionalGuestName">Additional Guest Name</label>
        <input type="text" class="form-control" id="additionalGuestName" name="additionalGuestName" required>
      </div>
      <div class="form-group">
        <label for="additionalGuestAddress">Address</label>
        <input type="text" class="form-control" id="additionalGuestAddress" name="additionalGuestAddress" required>
      </div>
      <div class="form-group">
        <label for="additionalGuestGender">Gender</label>
        <select class="form-control" id="additionalGuestGender" name="additionalGuestGender" required>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
          <option value="Other">Other</option>
        </select>
      </div>
    `;
    additionalGuestsDiv.appendChild(guestField);
  }

  // Example function to populate room selection options (fetch from database)
  function populateRoomSelection() {
    var roomSelection = document.getElementById('roomSelection');
    // Replace with actual data fetching logic
    var rooms = ['Room 101', 'Room 102', 'Room 103'];
    rooms.forEach(room => {
      var option = document.createElement('option');
      option.value = room;
      option.textContent = room;
      roomSelection.appendChild(option);
    });
  }

  // Call function to populate room selection on modal show
  $('#bookingModal').on('show.bs.modal', function () {
    populateRoomSelection();
  });

  // Function to validate booking form
  function validateBookingForm() {
    // Validate check-in and check-out dates, guest name, etc.
    var checkInDate = new Date(document.getElementById('checkInDate').value);
    var checkOutDate = new Date(document.getElementById('checkOutDate').value);
    var today = new Date();

    if (checkInDate < today || checkOutDate < today) {
      alert('Check-in and Check-out dates cannot be in the past.');
      return false;
    }

    if (checkOutDate <= checkInDate) {
      alert('Check-out date must be after Check-in date.');
      return false;
    }

    // Additional validations (e.g., guest name, number of guests)

    return true;
  }
</script>
<script>
  // Function to add additional guest fields dynamically
  function addGuestField() {
    var additionalGuestsDiv = document.getElementById('additionalGuests');
    var newGuestField = document.createElement('div');
    newGuestField.classList.add('form-group');
    newGuestField.innerHTML = `
      <label for="additionalGuestName">Additional Guest Name</label>
      <input type="text" class="form-control" name="additionalGuestName[]" required>
      <button type="button" class="btn btn-danger btn-sm ml-2" onclick="removeGuestField(this)">Remove</button>
    `;
    additionalGuestsDiv.appendChild(newGuestField);
  }

  // Function to remove additional guest fields
  function removeGuestField(buttonElement) {
    buttonElement.parentElement.remove();
  }

  // Function to calculate price based on number of days and room category (you'll need to implement this logic)
  function calculatePrice() {
    var numberOfDays = parseInt(document.getElementById('numberOfDays').value);
    var price = numberOfDays * roomCategoryPrice; // Replace roomCategoryPrice with actual logic to fetch price
    document.getElementById('price').value = price;
  }

  // Event listener for number of days input to calculate price dynamically
  document.getElementById('numberOfDays').addEventListener('input', calculatePrice);
</script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="../../javascript/user/booking.js"></script>

</body>
</html>
    