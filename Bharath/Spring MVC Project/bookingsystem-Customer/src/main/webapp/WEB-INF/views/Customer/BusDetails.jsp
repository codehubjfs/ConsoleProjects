<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Travel with Joy</title>
<link rel="icon" type="image/x-icon" href="images/buslogo.png"
	width="40px">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="Busshow.css">
<style>
body {
	font-family: Arial, sans-serif;
}

#ids {
	background-color: rgb(241, 240, 247);
	margin-bottom: 10px;
	position: fixed;
	top: 0px;
	z-index: 1;
	width: 100%;
}

.navbar-brand span {
	display: inline-block;
}

.space {
	margin-left: 400px;
}

.fse {
	font-size: 17px;
	font-weight: 400;
	color: rgba(43, 80, 182, 0.938) !important;
}

#navlin {
	font-weight: 600;
	padding-left: 10px;
	margin-top: 100px;
}

#navlin a {
	text-decoration: none;
}

.ms-2 {
	margin-top: 20px;
}

.sidebar {
	width: 300px;
	background-color: #f5eee25b;
	color: #232324;
	padding: 20px;
	height: 100vh;
	position: fixed;
	font-weight: 600;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	top: 75px;
	left: 0;
}

.sidebar ul {
	list-style-type: none;
	padding-left: 0;
	margin-top: 20px;
}

.sidebar ul li {
	margin-bottom: 30px;
}

.sidebar ul li a {
	color: #f3fcd3;
	text-decoration: none;
	font-size: 16px;
	display: block;
	font-weight: bold;
}

.main-content {
	margin-left: 320px;
	padding: 20px;
	margin-top: 0px;
}

.breadcrumb {
	margin-top: 20px;
}

.modch {
	line-height: 30px;
}

.buc {
	color: white;
	background-color: rgb(30, 59, 221);
	border-radius: 10px;
	font-weight: bold;
}

.modserch {
	padding-left: 0;
}

.grid-container {
	display: grid;
	grid-template-columns: 1fr;
	background-color: #b8c6d2;
	gap: 1px;
}

.grid-row {
	display: flex;
	flex-wrap: wrap;
	text-decoration: none;
	color: inherit;
	background-color: rgba(255, 255, 255, 0.8);
	border: 0px solid rgba(0, 0, 0, 0.8);
	padding: 10px;
	margin: 2px;
}

.grid-item {
	flex: 1 1 calc(100%/ 7);
	padding: 10px;
	text-align: center;
}

.d-flex-column {
	display: flex;
	flex-direction: column;
	text-align: left;
}

.desc {
	display: flex;
	align-items: center;
	justify-content: center;
}

.fa-star {
	margin-right: 5px;
}

.checked {
	color: gold;
}

.hidden-paragraphs {
	display: none;
	grid-column: span 7;
}

.grid-containers {
	display: grid;
	grid-template-columns: 5fr 5fr;
	background-color: #2196F3;
	padding: 1px;
}

.grid-items {
	background-color: rgba(255, 255, 255, 0.8);
	border: 1px solid rgba(0, 0, 0, 0.8);
	padding: 20px;
	font-size: 15px;
	text-align: left;
}
/* .grids-container{
    display: grid;
    grid-template-columns:1fr 1fr 1fr 1fr 1fr;
    background-color: #2196F3;
    padding: 1px;
}
.grids-items{
    background-color: rgba(255, 255, 255, 0.8);
    border: 1px solid rgba(0, 0, 0, 0.8);
    padding: 20px;
    font-size: 15px;
    text-align: left;
} */
.wid {
	width: 100%;
	background-color: orange;
	color: rgb(66, 65, 65);
	font-weight: 700;
}

.wids {
	background-color: #7b69d6 !important;
}

.details {
	display: flex;
	justify-content: space-between;
}

.bus-container {
	display: grid;
	grid-template-columns: repeat(9, 34px);
	gap: 10px;
	margin-bottom: 20px;
}

.color-box {
	width: 40px;
	height: 39px;
	background-image: url('images/seatstaus2.png'); /* Default image */
	background-repeat: no-repeat;
	border: 1px solid #000;
	cursor: pointer;
}

.color-box.green {
	background-image: url('images/afterseat.png'); /* Image to toggle to */
}

.message {
	display: none;
	color: green;
	margin-top: 10px;
}

.color-box.disabled {
	pointer-events: none;
	opacity: 0.5;
}

.line-break {
	flex-basis: 100%;
	height: 0;
}

.bus-card {
	width: 100%;
	height: auto;
	margin-bottom: 20px;
	background-color: #f1f4f6;
}

.bus-info {
	display: flex;
	flex-direction: column;
}

.bus-details, .bus-schedule, .bus-seats-fare {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 10px;
}

.bus-details .card-title {
	flex-shrink: 0;
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
	margin-right: 10px;
	width: 200px; /* Adjust the width as needed */
}

.card-text {
	margin-left: 100px;
}

.bus-details .card-text {
	display: flex;
	align-items: center;
	flex-grow: 2;
	white-space: nowrap;
}

.bus-details .card-text strong {
	margin-right: 10px;
}

.arrow-span {
	flex-shrink: 0;
	margin: 0 10px;
}

.bus-schedule .bus-type {
	flex-grow: 1;
}

.bus-schedule .fare {
	text-align: right;
}

.bus-actions {
	text-align: right;
}

.collapse {
	margin-top: 10px;
}

.total-seats {
	margin-left: 230px;
}

.bus-schedule .schedule-text {
	display: flex;
	white-space: nowrap;
	flex-grow: 2;
	margin-left: 140px;
}

.bus-schedule .schedule-text strong {
	margin-right: 10px;
}

.seat-selection {
	background-color: #e7f3ff;
	padding: 10px;
	border: 1px solid #b3d7ff;
	border-radius: 5px;
}

.seats {
	display: flex;
	flex-wrap: wrap;
	gap: 1px;
}

.seat {
	width: 25px;
	height: 25px;
	background-color: #fff;
	border: 1px solid #ccc;
	border-radius: 5px;
	display: inline-block;
	cursor: pointer;
	margin: 7px;
}

.seat.selected {
	background-color: #4CAF50;
}

.seat.disabled {
	background-color: #ccc;
	cursor: not-allowed;
}

.booking-form {
	background-color: #e7f3ff;
	padding: 10px;
	border: 1px solid #b3d7ff;
	border-radius: 5px;
}

.booking-summary {
	margin-top: 10px;
}

.booking-summary p {
	margin: 0;
}

.no-buses {
	text-align: center;
	margin-top: 50px;
	padding: 20px;
}

.no-buses img {
	max-width: 200px;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light sticky-header"
		id="ids">
		<div class="container-fluid">
			<img src="${pageContext.request.contextPath}/Images/Joylogo.png"
				alt="logo" width="60px" height="50px"> <a
				class="navbar-brand pt-1 p-3 d-flex align-items-center fs-4"
				href="#"> <span class="text-primary fontsw fw-bold pt-2">Joy<span
					class="text-success ms-2">R</span>ider
			</span>
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto mb-auto mb-lg-0 fs-5 space">
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						aria-current="page" href="home">Home</a></li>
					<li class="nav-item fcolor"><a
						class="nav-link active fse ms-5" aria-current="page" href="about">About
							us</a></li>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						aria-current="page" href="book">Booking</a></li>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						aria-current="page" href="contact">Contact us</a></li>
					<%@ page import="com.bus.model.CustomersNew"%>
						<%
				    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); 
				    response.setHeader("Pragma", "no-cache"); 
				    response.setDateHeader("Expires", 0); 
				%>
					<%
                    CustomersNew customers = (CustomersNew) session.getAttribute("customersNew");
                    if (customers != null) {
                %>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						href="cancel">Cancel Booking</a></li>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						href="view">View Booking</a></li>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						href="logout">Logout</a></li>
					<li class="nav-item fcolor"><span class="nav-link fse ms-5"><%= customers.getFirstName() %>
							<%= customers.getLastName() %></span></li>
					<% } else { %>
					<li class="nav-item fcolor"><a class="nav-link fse ms-5"
						aria-current="page" href="login">Login/Register</a></li>
					<% } %>
				</ul>
			</div>
		</div>
	</nav>

	<aside class="sidebar">
		<ul>
			<li class="menu-title mb-2">Departure Time</li>
			<div class="modch">
				<input type="checkbox" id="depttime" name="depttime" value="Early">
				<label for="depttime"> Early( 12 AM- 6Am)</label><br> <input
					type="checkbox" id="depttime2" name="depttime2" value="Daytime">
				<label for="depttime2"> Day Time( 6 AM- 9AM)</label><br> <input
					type="checkbox" id="depttime3" name="depttime3" value="Late">
				<label for="depttime3"> Late( 9 PM- 12pm)</label><br> <br>
			</div>
			<li class="menu-title mb-2">Bus Type</li>
			<div class="modch">
				<input type="checkbox" id="depttime" name="depttime" value="Early">
				<label for="depttime"> AC</label><br> <input type="checkbox"
					id="depttime2" name="depttime2" value="Daytime"> <label
					for="depttime2"> NON AC</label><br>
			</div>
			<li class="menu-title mt-4 mb-2">Boarding Point</li>
			<div class="modserch">
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search"> <span class="icon me-3"><img
						src="${pageContext.request.contextPath}/Images/search (1).png"
						alt="Bus" width="25px"></span>
				</form>
			</div>
			<li class="menu-title mt-4 mb-2">Dropping Point</li>
			<div class="modserch">
				<form class="d-flex" role="search">
					<input class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search"> <span class="icon me-3"><img
						src="${pageContext.request.contextPath}/Images/search (1).png"
						alt="Bus" width="25px"></span>
				</form>
			</div>
		</ul>
	</aside>

	<div class="main-content">

		<nav aria-label="breadcrumb" id="navlin">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a
					href="home">Home</a></li>
				<li class="breadcrumb-item"><a
					href="book">Booking</a></li>
				<li class="breadcrumb-item active" aria-current="page">Buses</li>
			</ol>
		</nav>



		<div class="container mt-5">
			<div class="row">
				<c:choose>
					<c:when test="${empty buses}">
						<div class="col-12 text-center">
							<p style="color: red; font-size: 25px">No buses available for
								the selected route.</p>
							<img src="${pageContext.request.contextPath}/Images/nobus.png"
								alt="No Buses Available"
								style="width: 500px; height: 350px; border-radius: 10%;">
						</div>
					</c:when>
					<c:otherwise>
						<c:if test="${not empty buses}">
							<div class="row">
								<div class="col-sm-6">
									<div class="route-info text-capitalize">
										<p>
											<strong>Search Results for Route:</strong> ${source} <span
												class="text-lowercase"> to </span> ${destination}
										</p>
									</div>
								</div>
								<div class="col-sm-6  d-flex justify-content-end">
									<div class="route-info">Displaying ${buses.size()} Buses
										on this route</div>
								</div>
							</div>
						</c:if>

						<c:forEach var="bus" items="${buses}">
							<div class="col-12">
								<div class="card bus-card">
									<div class="card-body">
										<div class="bus-info">
											<div class="bus-details">
												<h5 class="card-title text-capitalize">${bus.busName}</h5>
												<p class="card-text">
													<strong>Departure:</strong> ${bus.formattedDepartureDate} <span
														class="arrow-span"> <img
														src="${pageContext.request.contextPath}/Images/arrows.png"
														alt="Arrow" width="90px" height="20px" class="pt-1">
													</span> <strong>Arrival:</strong> ${bus.formattedArrivalDate} <span
														class="total-seats"><strong></strong>
														${bus.busCapacity} Seats available</span>
												</p>
											</div>

											<div class="bus-schedule text-lowercase">
												<span class="bus-type text-capitalize"> <strong></strong>
													${bus.busType}
												</span> <span class="schedule-text"> <strong>Departure
														Time:</strong> ${bus.formattedDepartureTime} &nbsp;&nbsp; <strong>Arrival
														Time:</strong> ${bus.formattedArrivalTime}
												</span> <span class="fare text-capitalize"> <strong>Fare:</strong>&nbsp;&#x20b9;
													<span class="bus-fare" data-fare="${bus.busFare}">${bus.busFare}</span>
												</span>
											</div>

											<div class="bus-actions">
												<button class="btn btn-primary" data-toggle="collapse"
													data-target="#collapse${bus.busid}" aria-expanded="false"
													aria-controls="collapse${bus.busid}">Book Seat</button>
											</div>

											<div id="collapse${bus.busid}" class="collapse">
												<div class="card card-body">
													<div class="row">
														<div class="col-6 seat-selection">
															<h5>Lower Deck</h5>
															<div class="seats">
																<c:forEach var="seatNumber" begin="1"
																	end="${bus.busCapacity}" varStatus="status">
																	<c:if test="${status.count % 11 == 1}">
																		<div class="seats-row">
																	</c:if>

																	<div class="seat" data-seat-number="${seatNumber}">
																		${seatNumber}</div>

																	<c:if test="${status.count % 11 == 0 || status.last}">
															</div>
															</c:if>

															<c:if test="${status.count % 22 == 0 || status.last}">
																<div class="mt-5 mb-5"></div>
															</c:if>
						</c:forEach>
			</div>
		</div>
		<div class="col-6 booking-form">
			<form id="bookingForm${bus.busid}" action="bookSeat">
				<div class="form-group">
					<input type="number" name="customerid"
						value="${customersNew.customer_id}" style="display: none;">
					<input type="number" name="busid" value="${bus.busid}"
						style="display: none;"> <input type="number"
						name="routeid" value="${bus.route.index}" style="display: none;"></input>

					<label for="boardingPoint${bus.busid}">Boarding Point</label> <select
						id="boardingPoint${bus.busid}" class="form-control"
						name="boardingPoint">
						<!--  <c:forEach var="boardingPoint" items="${boardingPoints}">
                                                                <option value="${boardingPoint.id}">${boardingPoint.name}</option>
                                                            </c:forEach>-->
						<option value="avrRoundana">AVR Roundana</option>
					</select> <br>
				</div>
				<div class="form-group">
					<label for="droppingPoint${bus.busid}">Dropping Point</label> <select
						id="droppingPoint${bus.busid}" class="form-control"
						name="droppingPoint">
						<!--  <c:forEach var="droppingPoint" items="${droppingPoints}">
                                                                <option value="${droppingPoint.id}">${droppingPoint.name}</option>
                                                            </c:forEach>-->
						<option value="avinashi">Avinashi</option>
						<option value="chinniyamPalayam">Chinniyam Palayam</option>
						<option value="kmch">KMCH</option>
						<option value="hopesCollege">Hopes College</option>
						<option value="plamedu">Plamedu</option>
						<option value="lakshimiMills">Lakshimi Mills</option>
						<option value="gandhipuran">Gandhipuran</option>
					</select>
				</div>
				<div class="booking-summary" id="bookingSummary${bus.busid}">
					<p>
						<strong>Selected Seats:</strong> <span
							id="selectedSeatsDisplay${bus.busid}"></span>
					</p>
					<p>
						<span class="fare text-capitalize"> <strong>Fare:</strong>&nbsp;&#x20b9;
							<span class="bus-fare" data-fare="${bus.busFare}">${bus.busFare}</span>
						</span>
					</p>
					<p>
						<strong>Total Price:</strong>&nbsp;&#x20b9; <span
							id="totalPriceDisplay${bus.busid}"></span>
					</p>
					<br>
				</div>
				<button type="submit" class="btn btn-success submit-seat-selection"
					data-busid="${bus.busid}">Submit Seat Selection</button>
				<input type="hidden" name="selectedSeats"
					id="selectedSeats${bus.busid}"> <input type="hidden"
					name="totalPrice" id="totalPrice${bus.busid}"> <input
					type="text" name="bookingStatus" value="SeatBooked"
					style="display: none;"></input>
			</form>
		</div>
	</div>

	</div>
	</div>

	</div>
	</div>
	</div>
	</div>
	</c:forEach>
	</c:otherwise>
	</c:choose>
	</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script>
        $(document).ready(function() {
            $('.seat').click(function() {
                if (!$(this).hasClass('disabled')) {
                    var busId = $(this).closest('.collapse').attr('id').replace('collapse', '');
                    var selectedSeatsCount = $('#collapse' + busId + ' .seat.selected').length;

                    if ($(this).hasClass('selected')) {
                        $(this).removeClass('selected');
                    } else {
                        if (selectedSeatsCount < 6) {
                            $(this).addClass('selected');
                        } else {
                            alert('You can select a maximum of 6 seats.');
                        }
                    }

                    updateBookingSummary(busId);
                }
            });

            $('.submit-seat-selection').click(function() {
                var busId = $(this).data('busid');
                var selectedSeats = [];

                $('#collapse' + busId + ' .seat.selected').each(function() {
                    selectedSeats.push($(this).data('seat-number'));
                });

                $('#selectedSeats' + busId).val(selectedSeats.join(','));
                $('#totalPrice' + busId).val(calculateTotalFare(busId));

                $('#selectedSeatsDisplay' + busId).text(selectedSeats.join(','));
                $('#totalPriceDisplay' + busId).text(calculateTotalFare(busId));
            });

            function updateBookingSummary(busId) {
                var selectedSeats = [];

                $('#collapse' + busId + ' .seat.selected').each(function() {
                    selectedSeats.push($(this).data('seat-number'));
                });

                var totalFare = calculateTotalFare(busId);

                $('#selectedSeatsDisplay' + busId).text(selectedSeats.join(','));
                $('#totalPriceDisplay' + busId).text(totalFare);
            }

            function calculateTotalFare(busId) {
                var busFare = parseFloat($('#collapse' + busId + ' .bus-fare').data('fare'));
                var selectedSeatsCount = $('#collapse' + busId + ' .seat.selected').length;
                return busFare * selectedSeatsCount;
            }
        });            
        </script>

</body>
</html>
