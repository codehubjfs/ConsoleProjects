<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.bus.model.CustomersNew"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Payment</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">
<style>
#ids {
	background-color: rgb(241, 240, 247);
	margin-bottom: 10px;
	position: sticky;
	top: 0px;
	z-index: 1;
}
.navbar-nav .nav-link {
	margin-right: 30px;
	padding-left: 50px !important;
}

.payment-container {
	display: flex;
	justify-content: space-between;
	margin-top: 20px;
}

.payment-form, .booking-details {
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #f8f9fa;
	width: 100%;
}

.payment-form {
	max-width: 60%;
}

.booking-details {
	max-width: 35%;
}

.tab-pane {
	padding: 20px;
}

.btn-group {
	display: flex;
	justify-content: space-between;
	margin-top: 10px;
}
.space {
	margin-left: 10px;
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
        <a class="navbar-brand pt-1 p-3 d-flex align-items-center fs-4" href="#">
         
            <img src="${pageContext.request.contextPath}/Images/Joylogo.png" alt="logo" width="60px" height="50px" class="ms-2">
               <span class="text-primary fontsw ms-2 fw-bold pt-2">
                Joy<span class="text-success ms-2">R</span>ider
            </span>
        </a>
    </div>
</nav>
<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="home">Home</a></li>
        <li class="breadcrumb-item"><a href="book">Booking</a></li>
        <li class="breadcrumb-item active" aria-current="page">Payment</li>
    </ol>
</nav>
	<div class="container">
		<div class="payment-container">
			<!-- Payment Form -->
			<div class="payment-form">
				<h4 class="mb-3">Payment Options </h4>
				<ul class="nav nav-tabs" id="paymentTab" role="tablist">
					<li class="nav-item"><a class="nav-link active" id="upi-tab"
						data-toggle="tab" href="#upi" role="tab" aria-controls="upi"
						aria-selected="true">UPI</a></li>
					<li class="nav-item"><a class="nav-link" id="card-tab"
						data-toggle="tab" href="#card" role="tab" aria-controls="card"
						aria-selected="false">Card</a></li>
					<li class="nav-item"><a class="nav-link" id="gpay-tab"
						data-toggle="tab" href="#gpay" role="tab" aria-controls="gpay"
						aria-selected="false">GPay</a></li>
				</ul>
				<div class="tab-content" id="paymentTabContent">
					<!-- UPI Payment -->
					<div class="tab-pane fade show active" id="upi" role="tabpanel"
						aria-labelledby="upi-tab">
						<form action="pay">
							<div class="form-group">
								<label for="upiId">UPI ID</label>
								
								<input type="text" class="form-control" name="upinumber"
									id="upiId" placeholder="Enter UPI ID"> <input
									type="text" name="card" value="upi" style="display: none;">
								<input type="text" name="paymentStatus" value="paid"
									style="display: none;"><input type="number"
									name="customerid"
									value="${Listofbookings[0].customer.customer_id}"
									style="display: none;"><input type="number"
									name="busid" value="${Listofbookings[0].bus.busid}"
									style="display: none;"><input type="number"
									name="amount" value="${Listofbookings[0].totalPrice}"
									style="display: none;">
								<div style="display: none;">
									<c:forEach var="booking" items="${Listofbookings}">${booking.bookingid}</c:forEach>
								</div>

							</div>
							<div class="form-group">
								<button type="submit" class="btn btn-primary">Verify &
									Pay with UPI</button>
							</div>
						</form>
					</div>
					<!-- Card Payment -->
					<div class="tab-pane fade" id="card" role="tabpanel"
						aria-labelledby="card-tab">
						<form>
							<div class="form-group">
								<label for="cardNumber">Card Number</label> <input type="text"
									class="form-control" id="cardNumber" placeholder="Card Number">
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="expiryDate">Expiry Date</label> <input type="text"
										class="form-control" id="expiryDate" placeholder="MM/YY">
								</div>
								<div class="form-group col-md-6">
									<label for="cvv">CVV</label> <input type="text"
										class="form-control" id="cvv" placeholder="CVV">
								</div>
							</div>
							<div class="form-group">
								<label for="cardName">Name on Card</label> <input type="text"
									class="form-control" id="cardName" placeholder="Name on Card">
							</div>
							<div class="form-group">
								<!-- <button type="button" class="btn btn-secondary">Verify Card</button>-->
								<button type="submit" class="btn btn-primary">Pay with
									Card</button>
							</div>
						</form>
					</div>
					<!-- GPay Payment -->
					<div class="tab-pane fade" id="gpay" role="tabpanel"
						aria-labelledby="gpay-tab">
						<form>
							<div class="form-group">
								<label for="gpayNumber">GPay Number</label> <input type="text"
									class="form-control" id="gpayNumber"
									placeholder="Enter GPay Number">
							</div>
							<div class="form-group">
								<!-- <button type="button" class="btn btn-secondary"></button>-->
								<button type="submit" class="btn btn-primary">Verify &
									Pay with GPay</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">Time Alert</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">Oops! We are unable to proceed with
							your payment. Please select the bus again</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</div>
				</div>
			</div>
			<div class="booking-details">
				<h4 class="mb-3">Booking Details</h4>
				
				<!--       <p><strong>Seat No:</strong>
	            ${selectedSeats}
	        </p>-->
	        	<p class="text-capitalize"> <strong>Bus Name:</strong>${Listofbookings[0].bus.busName}</p>
	        	<p class="text-capitalize"><strong>Bus Type:</strong></p>
				<p class="text-capitalize">
					<strong>Boarding:</strong> ${Listofbookings[0].boardingPoint}</p>
				<p class="text-capitalize">
					<strong>Dropping:</strong> ${Listofbookings[0].droppingPoint}</p>
				<p>
					<strong>Total Fare:</strong> ₹ ${Listofbookings[0].totalPrice}
				</p>

				<hr>
			</div>


		</div>
	</div>

	<script>
function startTimer(duration, displayElement) {
    var timer = duration, minutes, seconds;
    var modalDisplayed = false; 

    setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        displayElement.textContent = minutes + ":" + seconds;

     
        if (timer === 2 && !modalDisplayed) {
            $('#myModal').modal('show'); 
            modalDisplayed = true; 
        }

        if (--timer < 0) {
            timer = duration;

            window.location.href = 'BusDetails.jsp';
        }
    }, 1000);
}


window.onload = function () {
    var fiveMinutes = 60 * 5,
        display = document.querySelector('#time'); 
    startTimer(fiveMinutes, display);
};
</script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
