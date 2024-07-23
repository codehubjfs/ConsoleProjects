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
    <style>
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
    </style>
</head>

<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Hotel Booking</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="./home.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./room.html">Rooms</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./about.html">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./contact.html">Contact</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link btn btn-light text-white" href="./booking.html"><span style="color: black">Book</span></a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container profile-container">
        <!-- Profile Header -->
        <div class="profile-header">
            <h1>Profile Management</h1>
        </div>
        <!-- Customer Information -->
    <div class="container mt-5">
        <h3>Customer Information</h3>
        <table class="table table-bordered">
            <tr>
                <th>First Name</th>
                <td>${user.firstName}</td>
            </tr>
            <tr>
                <th>Last Name</th>
                <td>${user.lastName}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${user.email}</td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>${user.phone}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${user.address}</td>
            </tr>
            <tr>
                <th>State</th>
                <td>${user.state}</td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>${user.gender}</td>
            </tr>
            <tr>
                <th>Age</th>
                <td>${user.age}</td>
            </tr>
        </table>
    </div>
        <!-- Booking History -->
        <div class="booking-history">
            <h3>Booking History</h3>
            <table class="table table-striped table-bordered booking-table">
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
                        <td>${booking.checkIn}</td>
                        <td>${booking.checkOut}</td>
                        <td>${booking.bookingStatus}</td>
                        <td>
                            <button class="btn btn-warning btn-sm" onclick="showModifyModal(${booking.id})">Modify</button>
                            <button class="btn btn-danger btn-sm" onclick="showCancelModal(${booking.id})">Cancel</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            </table>
        </div>
    </div>

    <!-- Cancel Booking Modal -->
    <div class="modal fade" id="cancelModal" tabindex="-1" role="dialog" aria-labelledby="cancelModalLabel"
        aria-hidden="true">
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
                    <button type="button" class="btn btn-danger" id="confirmCancel">Cancel Booking</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modify Booking Modal -->
    <div class="modal fade" id="modifyModal" tabindex="-1" role="dialog" aria-labelledby="modifyModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modifyModalLabel">Modify Booking</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="modifyBookingForm">
                        <div class="form-group">
                            <label for="modifyRoom">Room</label>
                            <input type="text" class="form-control" id="modifyRoom" name="room">
                        </div>
                        <div class="form-group">
                            <label for="modifyCheckIn">Check-In</label>
                            <input type="date" class="form-control" id="modifyCheckIn" name="check_in">
                        </div>
                        <div class="form-group">
                            <label for="modifyCheckOut">Check-Out</label>
                            <input type="date" class="form-control" id="modifyCheckOut" name="check_out">
                        </div>
                        <button type="submit" class="btn btn-primary">Save Changes</button>
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
                            <a href="./home.html" class="text-dark">Home</a>
                        </li>
                        <li>
                            <a href="./room.html" class="text-dark">Rooms</a>
                        </li>
                        <li>
                            <a href="./about.html" class="text-dark">About</a>
                        </li>
                        <li>
                            <a href="./contact.html" class="text-dark">Contact</a>
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

        $('#modifyBookingForm').on('submit', function (e) {
            e.preventDefault();
            // Perform the modify booking action
            const bookingData = $(this).serialize();
            console.log('Modify booking data:', bookingData);
            // Close the modal
            $('#modifyModal').modal('hide');
        });
    </script>
</body>

</html>
