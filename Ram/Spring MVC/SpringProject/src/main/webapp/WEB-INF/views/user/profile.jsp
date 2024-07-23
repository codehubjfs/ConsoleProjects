<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Management</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<!-- Data Table JS -->
	<script src='https://cdn.datatables.net/1.13.5/js/jquery.dataTables.min.js'></script>
	<script src='https://cdn.datatables.net/responsive/2.1.0/js/dataTables.responsive.min.js'></script>
	<script src='https://cdn.datatables.net/1.13.5/js/dataTables.bootstrap5.min.js'></script>
    <style>
    .navbar {
    background-color: #f8f9fa;
}

.nav-link {
    color: #000 !important; /* Ensure the nav-link text is black */
}

.nav-link:hover {
    color: #007bff !important; /* Change color on hover */
}

.navbar-brand {
    font-weight: bold;
    color: #000 !important;
}

.navbar-toggler-icon {
    background-image: url("data:image/svg+xml,%3Csvg viewBox='0 0 30 30' xmlns='http://www.w3.org/2000/svg'%3E%3Cpath stroke='rgba%280, 0, 0, 0.5%29' stroke-width='2' stroke-linecap='round' stroke-miterlimit='10' d='M4 7h22M4 15h22M4 23h22'/%3E%3C/svg%3E");
}

/* Book button styles */
.nav-item .btn-light {
    color: #000;
    border: 1px solid #000;
}

.nav-item .btn-light:hover {
    color: #fff;
    background-color: #007bff;
    border-color: #007bff;
}
       .profile-container {
    margin-top: 50px;
}

.profile-header {
    text-align: center;
    margin-bottom: 30px;
}

.profile-info,
.booking-history {
    margin-bottom: 30px;
}

.booking-table th,
.booking-table td {
    text-align: center;
}

.error-message {
    color: red;
    display: none; /* Initially hide error messages */
}

.card {
    margin-bottom: 20px;
}

.navbar {
    margin-bottom: 20px;
}

.footer {
    background-color: #f8f9fa;
    text-align: center;
    padding: 20px;
}

.footer h5 {
    margin: 0;
}

.footer a {
    color: #343a40;
}

.footer .text-center {
    padding: 10px 0;
    background-color: #343a40;
    color: white;
}

.btn-light {
    background-color: #f8f9fa;
    border: 1px solid #343a40;
}

.btn-light:hover {
    background-color: #e2e6ea;
}

         .error-message {
    color: red;
    display: none; /* Initially hide error messages */
  }
    </style>
</head>

<body>
<%
String user = (String) session.getAttribute("user");

%>

<%@ page import="com.springproject.model.Booking" %>
<%@ page import ="com.springproject.model.RoomType" %>
<%
    HttpSession session1 = request.getSession();
    Booking booking = (Booking) session1.getAttribute("booking");
%>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="main">Hotel Booking</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="main">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="vr">Rooms</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="about">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="contact">Contact</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link btn btn-light text-white" href="vr"><span style="color: black">Book</span></a>
                </li>
            </ul>
        </div>
    </nav>
	<% String msg = (String)session.getAttribute("message");
	
		System.out.println("In Jsp Page : "+msg);
	%>
	<%
	String message = (String)session.getAttribute("msg");
	System.out.println("IN JSP PAYMENT  : "+message);
	%>
  <div class="container profile-container mt-5">
    <c:if test="${not empty message}">
        <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="5000" style="position: absolute; top: 20px; right: 20px;">
            <div class="toast-header">
                <strong class="me-auto">Notification</strong>
                <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="toast-body">
                ${message}
                <%
                session.removeAttribute("message"); 
                %>
            </div>
        </div>
        <script>
            $(document).ready(function() {
                $('.toast').toast('show');
            });
        </script>
    </c:if>
    <!-- Profile Header -->
     <c:if test="${not empty msg}">
        <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="5000" style="position: absolute; top: 20px; right: 20px;">
            <div class="toast-header">
                <strong class="me-auto">Notification</strong>
                <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="toast-body">
                ${msg}
                <%
                session.removeAttribute("msg");
                %>
            </div>
        </div>
        <script>
            $(document).ready(function() {
                $('.toast').toast('show');
            });
        </script>
    </c:if>
    <div class="profile-header mb-4">
        <h1>Profile Management</h1>
    </div>

    <!-- Customer Information Card -->
    <div class="card">
        <div class="card-header">
            <h3>Customer Information</h3>
        </div>
        <div class="card-body">
            <div class="row mb-3">
                <div class="col-sm-4"><strong>First Name</strong></div>
                <div class="col-sm-8">${user.first_name}</div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-4"><strong>Last Name</strong></div>
                <div class="col-sm-8">${user.last_name}</div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-4"><strong>Email</strong></div>
                <div class="col-sm-8">${user.email}</div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-4"><strong>Phone</strong></div>
                <div class="col-sm-8">${user.phone}</div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-4"><strong>Address</strong></div>
                <div class="col-sm-8">${user.address}</div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-4"><strong>State</strong></div>
                <div class="col-sm-8">${user.state}</div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-4"><strong>Gender</strong></div>
                <div class="col-sm-8">${user.gender}</div>
            </div>
            <div class="row mb-3">
                <div class="col-sm-4"><strong>Age</strong></div>
                <div class="col-sm-8">${user.age}</div>
            </div>
        </div>
    </div>
</div>
        <!-- Booking History -->
        <div class="booking-history">
            <h3>Booking History</h3>
            <table class="table table-striped table-bordered booking-table" id="myTable">
                <thead class="thead-dark">
                    <tr>
                    <th>Booking ID</th>
                    <th>Room</th>
                    <th>Check-In</th>
                    <th>Check-Out</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="booking" items="${bookings}">
                    <tr>
                        <td>${booking.id}</td>
                        <td>${booking.room}</td>
                        <td>${booking.check_in}</td>
                        <td>${booking.check_out }</td>
                        <td>${booking.booking_status}</td>
                        <td>
						<c:choose>
						<c:when test="${booking.booking_status=='Booked'}">
						 <button class="btn btn-danger btn-sm" onclick="showCancelModal(${booking.id})">Cancel</button>
						</c:when>
						<c:otherwise>
						        <button class="btn btn-danger btn-sm" disabled>Cancel</button>
						</c:otherwise>
						</c:choose>
              
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            </table>
        </div>
    </div>

    <!-- Cancel Booking Modal -->
    <div class="modal fade" id="cancelModal" tabindex="-1" role="dialog" aria-labelledby="cancelModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="cancelModalLabel">Cancel Booking</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure you want to cancel this booking?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <form action="cancelBooking" method="post">
                    <input type="hidden" id="bookingIdToCancel" name="bookingId" value=" ">
                    <button type="submit" class="btn btn-danger">Cancel</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- Modify Booking Modal -->
<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" aria-labelledby="modifyModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modifyModalLabel">Modify Booking</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form id="modifyBookingForm" action="book" method="POST" onsubmit="return validateForm()">
                    <input type="hidden" name="id" id="bookingId">
                    <div class="form-group">
                        <label for="customerName">Customer Name</label>
                        <input type="text" class="form-control" id="customerName" name="customerName" oninput="validateCustomerName()">
                        <div class="error-message" id="customerNameError"></div>
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender</label>
                        <select class="form-control" id="gender" name="gender" onchange="validateGender()">
                            <option value="">Select Gender</option>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Other">Other</option>
                        </select>
                        <div class="error-message" id="genderError"></div>
                    </div>
                    <div class="form-group">
                        <label for="phoneNo">Phone Number</label>
                        <input type="text" class="form-control" id="phoneNo" name="phoneNo" oninput="validatePhoneNo()">
                        <div class="error-message" id="phoneNoError"></div>
                    </div>
                    <div class="form-group">
    <label for="roomName">Room Name</label>
    <select class="form-control" id="roomName" name="roomName">
        <option value="">Select Room Type</option>
        <option value="Single">Single</option>
        <option value="Double">Double</option>
        <option value="Luxury">Luxury</option>
        <option value="Deluxe Room">Deluxe Room</option>
    </select>
</div>
<div class="form-group">
    <label for="roomNumber">Room Number</label>
    <select class="form-control" id="roomNumber" name="roomNumber" >
        <!-- Options will be populated dynamically -->
    </select>
</div>
					<input type="hidden" id="bookingId" name="bookingId"> 
                   
                    <input type="hidden" id="roomRent" name="roomRent">
                    <div class="form-group">
                        <label for="checkinDate">Check-in Date</label>
                        <input type="date" class="form-control" id="checkinDate" name="checkinDate" onchange="validateCheckinDate(); calculateDaysStayed()">
                        <div class="error-message" id="checkinDateError"></div>
                    </div>
                    <div class="form-group">
                        <label for="checkoutDate">Check-out Date</label>
                        <input type="date" class="form-control" id="checkoutDate" name="checkoutDate" onchange="validateCheckoutDate(); calculateDaysStayed()">
                        <div class="error-message" id="checkoutDateError"></div>
                    </div>
                    <div class="form-group">
                        <label for="daysStayed">Number of Days Stayed</label>
                        <input type="text" class="form-control" id="daysStayed" name="daysStayed" readonly>
                    </div>
                    <button type="submit" class="btn btn-primary">Confirm Book</button>
                </form>
            </div>
        </div>
    </div>
</div>



    <!-- Footer -->
    <footer class="bg-light text-center text-lg-start">
        <div class="container p-4">
            <div class="row">
                <div class="col-lg-6 col-md-12 mb-4 mb-md-0">
                    <h5 class="text-uppercase">Hotel Booking</h5>
                    <p>Providing the best hotel booking services since 2023.</p>
                </div>
                <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                    <h5 class="text-uppercase">Links</h5>
                    <ul class="list-unstyled mb-0">
                        <li>
                            <a href="main" class="text-dark">Home</a>
                        </li>
                        <li>
                            <a href="vr" class="text-dark">Rooms</a>
                        </li>
                        <li>
                            <a href="about" class="text-dark">About</a>
                        </li>
                        <li>
                            <a href="contact" class="text-dark">Contact</a>
                        </li>
                    </ul>
                </div>
                <div class="col-lg-3 col-md-6 mb-4 mb-md-0">
                    <h5 class="text-uppercase">Follow Us</h5>
                    <ul class="list-unstyled mb-0">
                        <li>
                            <a href="#!" class="text-dark">Facebook</a>
                        </li>
                        <li>
                            <a href="#!" class="text-dark">Twitter</a>
                        </li>
                        <li>
                            <a href="#!" class="text-dark">Instagram</a>
                        </li>
                        <li>
                            <a href="#!" class="text-dark">LinkedIn</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="text-center p-3 bg-dark text-light">
            &copy; 2024 Hotel Booking. All Rights Reserved.
        </div>
    </footer>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- Custom JS -->
<script>
$(document).ready(function() {
    $('#myTable').DataTable({
        "pageLength": 5,
        // Disable sorting on last column
        "columnDefs": [
            { "orderable": false, "targets": 6 }
        ],
        "dom": '<"top"f>rt<"bottom"lp><"clear">',
        language: {
            // Customize pagination prev and next buttons: use arrows instead of words
            'paginate': {
                'previous': '<span class="fa fa-chevron-left"></span>',
                'next': '<span class="fa fa-chevron-right"></span>'
            },
            // Customize number of elements to be displayed
            "lengthMenu": 'Display <select class="form-control input-sm">'+
            '<option value="5">5</option>'+
            '<option value="10">10</option>'+
            '<option value="20">20</option>'+
            '<option value="30">30</option>'+
            '<option value="40">40</option>'+
            '<option value="50">50</option>'+
            '<option value="-1">All</option>'+
            '</select> results'
        }
    });
});

</script>
<script>
    function debugFormSubmission() {
        console.log("Submitting form with booking ID: " + document.getElementById('bookingId').value);
    }
</script>
    <script>
        let bookingIdToCancel;

        function showCancelModal(bookingId) {
            bookingIdToCancel = bookingId;
            $('#cancelModal').modal('show');
        }

        function showModifyModal(bookingId) {
            $('#modifyModal').modal('show');
            // Populate form with booking details
            // For example:
            // $('#modifyRoom').val('Deluxe Suite');
            // $('#modifyCheckIn').val('2024-07-01');
            // $('#modifyCheckOut').val('2024-07-07');
        }

        $('#confirmCancel').on('click', function () {
            // Perform the cancel booking action using bookingIdToCancel
            console.log('Cancel booking ID:', bookingIdToCancel);
            // Close the modal
            $('#cancelModal').modal('hide');
        });

        
    </script>
    <script>
    function showCancelModal(bookingId) {
        console.log("Booking ID to cancel: " + bookingId); // Debugging statement
        document.getElementById('bookingIdToCancel').value = bookingId;
        $('#cancelModal').modal('show');
    }
</script>
<script>
function showModifyModal(bookingId) {
    console.log("Booking ID to modify: " + bookingId); // Debugging statement
    document.getElementById('bookingId').value = bookingId;
    $('#modifyModal').modal('show');
}
</script>

<script>
    function showModifyModal(button) {
        // Retrieve booking details from data attributes
        const bookingId = button.getAttribute('data-booking-id');
        const customerName = button.getAttribute('data-customer-name');
        const gender = button.getAttribute('data-gender');
        const phoneNo = button.getAttribute('data-phone-no');
        const roomNumber = button.getAttribute('data-room-number');
        const roomName = button.getAttribute('data-room-name');
        const checkinDate = button.getAttribute('data-checkin-date');
        const checkoutDate = button.getAttribute('data-checkout-date');
        const daysStayed = button.getAttribute('data-days-stayed');
        const name = button.getAttribute('data-room-name')
        
        // Populate the form fields
        document.getElementById('bookingId').value = bookingId;
        document.getElementById('customerName').value = customerName;
        document.getElementById('gender').value = gender;
        document.getElementById('phoneNo').value = phoneNo;
        document.getElementById('roomNumber').value = roomNumber;
        document.getElementById('roomName').value = roomName;
        document.getElementById('checkinDate').value = checkinDate;
        document.getElementById('checkoutDate').value = checkoutDate;
        document.getElementById('daysStayed').value = daysStayed;
        

        // Show the modal
        $('#modifyModal').modal('show');
    }
</script>
<script>
    $(document).ready(function() {
        // Check if msg is not empty
        var msg = '${msg}';
        if (msg) {
            // Show toast
            $('#successToast').toast('show');
        }
    });
</script>
<script>
function showModifyModal(button) {
    // Retrieve booking details from data attributes
    const bookingId = button.getAttribute('data-booking-id');
    console.log(bookingId);
    const customerName = button.getAttribute('data-customer-name');
    const gender = button.getAttribute('data-gender');
    const phoneNo = button.getAttribute('data-phone-no');
    console.log("phone "+phoneNo);
    const roomNumber = button.getAttribute('data-room-number');
    console.log("No"+roomNumber);
    const roomName = button.getAttribute('data-room-name');
    console.log("Room Name "+roomName);
    const checkinDate = button.getAttribute('data-checkin-date');
    const checkoutDate = button.getAttribute('data-checkout-date');
    const daysStayed = button.getAttribute('data-days-stayed');
    

    // Populate the form fields
    document.getElementById('bookingId').value = bookingId;
    document.getElementById('customerName').value = customerName;
    document.getElementById('gender').value = gender;
    document.getElementById('phoneNo').value = phoneNo;
    document.getElementById('roomNumber').value = roomNumber;
    document.getElementById('roomName').value = roomName;
    document.getElementById('checkinDate').value = checkinDate;
    document.getElementById('checkoutDate').value = checkoutDate;
    document.getElementById('daysStayed').value = daysStayed;

 // Set the room number in the roomNumber dropdown
    const roomNumberSelect = document.getElementById('roomNumber');
    roomNumberSelect.value = roomNumber; // Set the selected value
    // Show the modal
    $('#modifyModal').modal('show');
}

// Validation functions
function validateCustomerName() {
    const customerName = document.getElementById('customerName').value.trim();
    const customerNameError = document.getElementById('customerNameError');

    if (customerName === '') {
        customerNameError.innerHTML = 'Customer name is required';
        customerNameError.style.display = 'block';
        return false;
    }

    const nameRegex = /^[a-zA-Z\s]{3,}$/;
    if (!nameRegex.test(customerName)) {
        customerNameError.innerHTML = 'Customer name must contain only alphabets and be at least 3 characters long';
        customerNameError.style.display = 'block';
        return false;
    }

    customerNameError.innerHTML = '';
    customerNameError.style.display = 'none';
    return true;
}

function validateGender() {
    const gender = document.getElementById('gender').value;
    const genderError = document.getElementById('genderError');

    if (gender === '') {
        genderError.innerHTML = 'Gender is required';
        genderError.style.display = 'block';
        return false;
    }

    genderError.innerHTML = '';
    genderError.style.display = 'none';
    return true;
}

function validatePhoneNo() {
    const phoneNo = document.getElementById('phoneNo').value.trim();
    const phoneNoError = document.getElementById('phoneNoError');

    if (phoneNo === '') {
        phoneNoError.innerHTML = 'Phone number is required';
        phoneNoError.style.display = 'block';
        return false;
    }

    const phoneRegex = /^[6-9]\d{9}$/;
    if (!phoneRegex.test(phoneNo)) {
        phoneNoError.innerHTML = 'Phone number must be 10 digits and start with 9, 8, 7, or 6';
        phoneNoError.style.display = 'block';
        return false;
    }

    phoneNoError.innerHTML = '';
    phoneNoError.style.display = 'none';
    return true;
}

function validateCheckinDate() {
    const checkinDate = document.getElementById('checkinDate').value;
    const checkinDateError = document.getElementById('checkinDateError');

    if (checkinDate === '') {
        checkinDateError.innerHTML = 'Check-in date is required';
        checkinDateError.style.display = 'block';
        return false;
    }

    const today = new Date().toISOString().split('T')[0];
    if (checkinDate < today) {
        checkinDateError.innerHTML = 'Check-in date cannot be a past date';
        checkinDateError.style.display = 'block';
        return false;
    }

    checkinDateError.innerHTML = '';
    checkinDateError.style.display = 'none';
    return true;
}

function validateCheckoutDate() {
    const checkinDate = document.getElementById('checkinDate').value;
    const checkoutDate = document.getElementById('checkoutDate').value;
    const checkoutDateError = document.getElementById('checkoutDateError');

    if (checkoutDate === '') {
        checkoutDateError.innerHTML = 'Check-out date is required';
        checkoutDateError.style.display = 'block';
        return false;
    }

    if (checkoutDate <= checkinDate) {
        checkoutDateError.innerHTML = 'Check-out date must be later than the check-in date';
        checkoutDateError.style.display = 'block';
        return false;
    }

    checkoutDateError.innerHTML = '';
    checkoutDateError.style.display = 'none';
    return true;
}

function calculateDaysStayed() {
    const checkinDate = new Date(document.getElementById('checkinDate').value);
    const checkoutDate = new Date(document.getElementById('checkoutDate').value);
    const daysStayedField = document.getElementById('daysStayed');

    if (checkinDate && checkoutDate && checkoutDate > checkinDate) {
        const timeDiff = Math.abs(checkoutDate - checkinDate);
        const daysStayed = Math.ceil(timeDiff / (1000 * 60 * 60 * 24));
        daysStayedField.value = daysStayed;
    } else {
        daysStayedField.value = '';
    }
}

function validateForm() {
    let isValid = true;

    if (!validateCustomerName()) {
        isValid = false;
    }
    if (!validateGender()) {
        isValid = false;
    }
    if (!validatePhoneNo()) {
        isValid = false;
    }
    if (!validateCheckinDate()) {
        isValid = false;
    }
    if (!validateCheckoutDate()) {
        isValid = false;
    }

    return isValid;
}

// Display initial error messages on form submit attempt
document.getElementById('modifyBookingForm').addEventListener('submit', function(event) {
    if (!validateForm()) {
        event.preventDefault(); // Prevent form submission
        document.getElementById('customerName').focus();
    }
});
</script>


<script>
    function fetchAvailableRooms() {
        // Get the selected room type
        const roomType = document.getElementById('roomName').value;

        // Fetch available rooms for the selected room type
        fetch('${pageContext.request.contextPath}/availableRooms?roomType=' + roomType)
            .then(response => response.json())
            .then(data => {
                const roomNumberSelect = document.getElementById('roomNumber');
                roomNumberSelect.innerHTML = ''; // Clear existing options

                if (data.length > 0) {
                    // Populate the dropdown with available rooms
                    data.forEach(room => {
                        const option = document.createElement('option');
                        option.value = room; // Assuming room contains room number
                        option.text = room;  // Display room number
                        roomNumberSelect.appendChild(option);
                    });
                    
                    // Enable the roomNumber select after fetching the available rooms
                    roomNumberSelect.disabled = false; // Change to disabled instead of readonly
                } else {
                    const option = document.createElement('option');
                    option.value = '';
                    option.text = 'No rooms available';
                    roomNumberSelect.appendChild(option);
                    roomNumberSelect.disabled = true; // Disable if no rooms available
                }
            })
            .catch(error => console.error('Error fetching available rooms:', error));
    }

    // Call fetchAvailableRooms when the roomName dropdown changes
    document.getElementById('roomName').addEventListener('change', fetchAvailableRooms);
</script>
</body>

</html>
