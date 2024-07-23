<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Payment</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
    .navbar-nav .nav-link {
    margin-right: 30px; 
    padding-left:50px!important;
    
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
    </style>
</head>
<body>
 <nav class="navbar navbar-expand-lg navbar-light sticky-header" id="ids">
    <div class="container-fluid">
        <img src="../../Images/Joylogo.png" alt="logo" width="60px" height="50px">
        <a class="navbar-brand pt-1 p-3 d-flex-align-items-center fs-4" href="#">
            <span class="text-primary fw-bold pt-2">Joy<span class="text-success ms-2">R</span>ider</span> 
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mb-auto mb-lg-0 fs-5 space">
                <li class="nav-item fcolor">
                    <a class="nav-link  fse ms-1" aria-current="page" href="Home.jsp">Home</a>
                </li>
                <li class="nav-item fcolor">
                    <a class="nav-link active fse ms-5" aria-current="page" href="About.jsp">About us</a>
                </li>
                <li class="nav-item fcolor">
                    <a class="nav-link fse ms-5" aria-current="page" href="Book.jsp">Booking</a>
                </li>
                <li class="nav-item fcolor" id="cancelLink" style="display: none;">
                  <a class="nav-link fse ms-5" href="cancelticket.jsp">Cancel Booking</a>
              </li>
              <li class="nav-item fcolor" id="viewLink" style="display: none;">
                  <a class="nav-link  fse ms-5" href="viewbooking.jsp">View Booking</a>
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
                  <a class="nav-link fse ms-5" href="Login.jsp" onclick="logout()">Logout</a>
              </li> 
                <li class="nav-item fcolor">
                    <a class="nav-link fse ms-5" aria-current="page" href="Login.jsp">Login/Register</a>
                </li>
                <li class="nav-item fcolor">
                    <img src="Images/account.png" class="mt-1 ms-0" alt="" width="30px">
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <h3 class="text-center mt-4">Payment</h3>
    <div id="timer">
    Please complete payment within <span id="time"></span>
</div>
    
    <div class="payment-container">
        <!-- Payment Form -->
        <div class="payment-form">
            <h4 class="mb-3">Payment Options</h4>
            <ul class="nav nav-tabs" id="paymentTab" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active" id="upi-tab" data-toggle="tab" href="#upi" role="tab" aria-controls="upi" aria-selected="true">UPI</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="card-tab" data-toggle="tab" href="#card" role="tab" aria-controls="card" aria-selected="false">Card</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="gpay-tab" data-toggle="tab" href="#gpay" role="tab" aria-controls="gpay" aria-selected="false">GPay</a>
                </li>
            </ul>
            <div class="tab-content" id="paymentTabContent">
                <!-- UPI Payment -->
                <div class="tab-pane fade show active" id="upi" role="tabpanel" aria-labelledby="upi-tab">
                    <form>
                 
                        <div class="form-group">
                            <label for="upiId">UPI ID</label>
                            <input type="text" class="form-control" name="upinumber" id="upiId" placeholder="Enter UPI ID">
                        </div>
                        <div class="form-group">
                           <!--  <button type="button" class="btn btn-secondary"></button>-->
                            <button type="submit" class="btn btn-primary">Verify & Pay with UPI</button>
                        </div>
                    </form>
                </div>
                <!-- Card Payment -->
                <div class="tab-pane fade" id="card" role="tabpanel" aria-labelledby="card-tab">
                    <form>
                        <div class="form-group">
                            <label for="cardNumber">Card Number</label>
                            <input type="text" class="form-control" id="cardNumber" placeholder="Card Number">
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="expiryDate">Expiry Date</label>
                                <input type="text" class="form-control" id="expiryDate" placeholder="MM/YY">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="cvv">CVV</label>
                                <input type="text" class="form-control" id="cvv" placeholder="CVV">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="cardName">Name on Card</label>
                            <input type="text" class="form-control" id="cardName" placeholder="Name on Card">
                        </div>
                        <div class="form-group">
                            <!-- <button type="button" class="btn btn-secondary">Verify Card</button>-->
                            <button type="submit" class="btn btn-primary">Pay with Card</button>
                        </div>
                    </form>
                </div>
                <!-- GPay Payment -->
                <div class="tab-pane fade" id="gpay" role="tabpanel" aria-labelledby="gpay-tab">
                    <form>
                        <div class="form-group">
                            <label for="gpayNumber">GPay Number</label>
                            <input type="text" class="form-control" id="gpayNumber" placeholder="Enter GPay Number">
                        </div>
                        <div class="form-group">
                            <!-- <button type="button" class="btn btn-secondary"></button>-->
                            <button type="submit" class="btn btn-primary">Verify & Pay with GPay</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="myModalLabel">Time Alert</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Oops! We are unable to proceed with your payment. Please select the bus again
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>
        
        <!-- Booking Details -->
        <div class="booking-details">
            <h4 class="mb-3">Booking Details</h4>
            <!-- Example data, dynamically generate this using JSP -->
            <p><strong>Bus Name:</strong>${ payment.book.bus.busName}</p>
            <p><strong>Bus Type:</strong>${ payment.book.bus.busType} Seater</p>
            <p><strong>Seat No:</strong>
    <c:forEach var="seat" items="${payment.book.selectedSeats}" varStatus="status">
        ${seat}${!status.last ? ', ' : ''}
    </c:forEach>
</p>

            <p class="text-capitalize"><strong>Boarding:</strong> ${ payment.book.bus.arrivalTime}<br>${ payment.book.departure}</p>
            <p class="text-capitalize"><strong>Dropping:</strong> ${ payment.book.bus.departureTime}<br>${ payment.book.arrival}</p>
            <p><strong>Total Fare:</strong> ₹ ${ payment.book.totalPrice}</p>
        </div>
    </div>
</div>
<script>
function startTimer(duration, displayElement) {
    var timer = duration, minutes, seconds;
    var modalDisplayed = false; // Flag to track if modal is already displayed

    setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        displayElement.textContent = minutes + ":" + seconds;

        // Display modal when timer reaches 2 seconds
        if (timer === 2 && !modalDisplayed) {
            $('#myModal').modal('show'); // Show the modal using jQuery (ensure jQuery is included)
            modalDisplayed = true; // Set flag to true to prevent multiple modals
        }

        if (--timer < 0) {
            timer = duration;
            // Redirect to bus page when timer expires
            window.location.href = 'BusDetails.jsp'; // Replace with your actual bus page URL
        }
    }, 1000);
}

// When the payment details page loads
window.onload = function () {
    var fiveMinutes = 60 * 5,
        display = document.querySelector('#time'); // Replace with your timer display element ID or class

    startTimer(fiveMinutes, display);
};
</script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
