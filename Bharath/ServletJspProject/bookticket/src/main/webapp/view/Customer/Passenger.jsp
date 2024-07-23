<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            max-width: 900px;
            margin-top: 20px;
            padding: 20px;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .bold {
            font-weight: bold;
        }
        .light {
            font-weight: 300;
            color: #555;
        }
        .decorative {
            text-decoration: line-through;
            font-size: 13px;
        }
        .btn-custom {
            background-color: #17a2b8;
            color: white;
        }
        .seats-info {
            display: flex;
            justify-content: space-between;
        }
        .seats-info p {
            margin: 0;
        }
    </style>
</head>
<body>

<div class="container">
     <div class="row">
            <div class="col-md-4">
                <p class="bold">Bus Name</p>
                <p class="light">${book.bus.busName}</p>
            </div>
            <div class="col-md-4">
                <p class="bold">Bus Type</p>
                <p class="light">${book.bus.busType}</p>
            </div>
      		<div class="col-md-4">
    			<p class="bold">Seat No</p>
    			<p class="light">
        			<c:forEach var="seat" items="${book.selectedSeats}" varStatus="status">
            					${seat}<c:if test="${!status.last}">, </c:if>
       				 </c:forEach>
   				 </p>
			</div>
        </div>
        <div class="row">
            <div class="col-md-4">
                <p class="bold">Boarding</p>
                <p class="light">${book.bus.route.source}</p>
            </div>
            <!-- <div class="col-md-4 vertical-align-center">
                <button class="btn btn-custom">${book.bus.route.destination}</button>
            </div>-->
            <div class="col-md-4">
                <p class="bold">Dropping</p>
                <p class="light">${book.bus.route.destination}</p>
            </div>
        </div>
	<br>
	<hr>
<div class="passenger-details">
    <h3 class="text-center">Passenger Details</h3>
    <form action="${pageContext.request.contextPath}/PassengersController" method="post">
        <c:forEach var="seat" items="${book.selectedSeats}" varStatus="status">
            <input type="hidden" name="busid" value="${book.bus.busid}" />
            <input type="hidden" name="routeid" value="${book.bus.route.index}" />
            <input type="hidden" name="selectedSeats" value="${book.selectedSeats}" />
            <div class="form-group">
                <label for="passenger${seat}">Add Passenger for Seat ${seat}</label>
                <input type="text" class="form-control" id="passenger${seat}" name="passengerName${seat}" placeholder="Name" />
                <input type="number" class="form-control mt-2" name="age${seat}" placeholder="Age" />
                <div class="mt-2">
                    <p>Gender</p>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="male${seat}" name="gender${seat}" value="male" />
                        <label class="form-check-label" for="male${seat}">Male</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="female${seat}" name="gender${seat}" value="female" />
                        <label class="form-check-label" for="female${seat}">Female</label>
                    </div>
                </div>
            </div>
        </c:forEach>
        
        <div class="contact-details">
            <h3 class="text-center">Contact Details</h3>
            <p>Get bus updates and ticket details via WhatsApp and Email.</p>
            <div class="form-group">
                <label for="phone">Mobile Number</label>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">+91</span>
                    </div>
                    <input type="text" class="form-control" id="phone" name="mobileNumber" placeholder="Enter Mobile Number" />
                </div>
            </div>
            <div class="form-group">
                <label for="email">Email Address</label>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">@</span>
                    </div>
                    <input type="email" class="form-control" id="email" name="emailAddress" placeholder="Enter Email Address" />
                </div>
            </div>
            <div class="form-group">
                <label for="state">Your State</label>
                <select id="state" class="form-control" name="state">
                    <option value="India">India</option>
                    <!-- Add more options as needed -->
                </select>
                <small class="form-text text-muted">Required for GST purpose on your tax invoice</small>
            </div>
        </div>

        <hr>

        <div class="seats-info">
            <p><span class="decorative">2500</span> ${book.totalPrice}</p>
            <p>Selected Seats:
                <c:forEach var="seat" items="${book.selectedSeats}" varStatus="status">
                    ${seat}<c:if test="${!status.last}">, </c:if>
                </c:forEach>
            </p>
            <button class="btn btn-custom" type="submit">Proceed to Pay</button>
        </div>
    </form>
</div>


<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
