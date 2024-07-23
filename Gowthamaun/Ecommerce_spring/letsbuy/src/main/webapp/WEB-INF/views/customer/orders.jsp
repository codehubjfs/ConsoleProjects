<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ page import="com.letsbuy.beans.*,java.util.*" %>
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Orders</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/customerstyles.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!-- <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<style>

body {
    background-color: #f8f9fa;
}

.card-header {
    font-weight: bold;
}

.card-body {
    padding: 1rem;
}

#ordersList .card {
    margin-bottom: 1rem;
}

.card-orders-img{
	padding:15px !important;
	max-height:150px !important;
	
}

.ordersa:hover .card-title{
	color:rgb(27, 99, 174) !important;
}

.order-status-text{
	color:rgb(244,119,32) !important;
	font-size:16px !important;
}



/* #main-navv {
    margin-bottom: 5rem; /* Adjust if necessary to prevent content overlap 
} */

</style>
<body>
    <!-- Navbar -->
    <div class="navbar navbar-expand-lg navbar-light bg-white shadow-sm fixed-top" id="main-navv">
        <div class="container-fluid">
            <a class="navbar-brand d-none d-md-block" href="#option-menu">
                <img src="${pageContext.request.contextPath}/asserts/images/logo.png" class="rounded" width="210" height="110" alt="">
            </a>
            <a class="navbar-brand d-md-none" href="#option-menu">
                <img src="${pageContext.request.contextPath}/asserts/images/logo.png" class="rounded" width="100" height="50" alt="">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarContent">
                <div class="d-flex ms-auto me-auto mt-2 mt-lg-0 search-bar-container">
                    <form class="w-100" role="search">
                        <div class="input-group">
                            <input type="search" placeholder="Search your product" class="form-control"/>
                            <button class="btn btn-serch" type="submit">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </form>
                </div>
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item txt-nav invisible" id="login-pg">
                        <a class="nav-link" href="${pageContext.request.contextPath}/views/customer/login.jsp">
                            <i class="fa fa-user"></i> Login
                        </a>
                    </li>
                    
                  <!--  -->  <li class="nav-item invisible" id="seller-pg">
                        <a class="nav-link" href="#">
                            <img src="#"  height="20" width="25" alt=""> Seller
                        </a>
                    </li>
                    <li class="nav-item txt-nav">
                        <a class="nav-link" href="forwardHomepage">
                            <i class="fa fa-home"></i> Home
                        </a>
                    </li>
                    <li class="nav-item txt-nav">
                        <a class="nav-link" href="CustomerCartController">
                            <i class="fa fa-shopping-cart needed" value="${sessionScope.user.getMyCart().getMyCart().size()}" id="nav-cart"></i> Cart
                        </a>
                    </li>
                    
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa fa-user"></i> ${sessionScope.user.getFirstName()}
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#"><i class="fa fa-user"></i> Profile</a></li>
                           <!--  <li><a class="dropdown-item" href="${pageContext.request.contextPath}/views/customer/orderpage.jsp"><i class="fa fa-list"></i> My Orders</a></li>  -->
                            <li><a class="dropdown-item" href="CustomerLogoutController"><i class="fa fa-sign-out"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>

    <!-- Main Content -->
    <div class="container-fluid" style="margin-top: 150px !important;">
        <nav aria-label="breadcrumb">
            <ol class="breadcrumb">
                <li class="breadcrumb-item"><a href="forwardHomepage">Home</a></li>
                <li class="breadcrumb-item"><a href="#">My Account</a></li>
                <li class="breadcrumb-item active" aria-current="page">My Orders</li>
            </ol>
        </nav>
        <div class="row">
            <div class="col-md-3">
                <div class="card">
                    <div class="card-header">
                        Filters
                    </div>
                    <div class="card-body">
                        <form id="filterForm">
                            <div class="form-group">
                                <label for="orderStatus">ORDER STATUS</label>
                                <div id="orderStatus">
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="onTheWay">
                                        <label class="form-check-label" for="onTheWay">On the way</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="delivered">
                                        <label class="form-check-label" for="delivered">Delivered</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="cancelled">
                                        <label class="form-check-label" for="cancelled">Cancelled</label>
                                    </div>
                                    <!-- <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="returned">
                                        <label class="form-check-label" for="returned">Returned</label>
                                    </div> -->
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="orderTime">ORDER TIME</label>
                                <div id="orderTime">
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="last30days">
                                        <label class="form-check-label" for="last30days">Last 30 days</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="year2023">
                                        <label class="form-check-label" for="year2023">2023</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="year2022">
                                        <label class="form-check-label" for="year2022">2022</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="year2021">
                                        <label class="form-check-label" for="year2021">2021</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="year2020">
                                        <label class="form-check-label" for="year2020">2020</label>
                                    </div>
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="older">
                                        <label class="form-check-label" for="older">Older</label>
                                    </div>
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary btn-block">Apply Filters</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="d-flex justify-content-between mb-3">
                    <h4>My Orders</h4>
                    <form class="form-inline">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search your orders here" aria-label="Search">
                        <button class="btn btn-outline-primary my-2 my-sm-0" type="submit">Search Orders</button>
                    </form>
                </div>
                <div id="ordersList">
                    <!-- Order Item 1 -->
                     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
         		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
         		<c:set var="ordersdata" value="${orders}"></c:set>
         		<c:forEach var="order" items="${ordersdata.customerOrders}">
                    	<div class="card" data-orderId="${order.orderId}" data-order-amount="${order.amount}">
                        <div class="row no-gutters px-3">
                            <div class="col-md-1 pt-3 px-2">
                                <img src="${pageContext.request.contextPath}/asserts/images/Mobiles/LargeMiImage/large-mi1.webp" class="card-orders-img" alt="...">
                            </div>
                           
                            <div class="col-md-10">
                                <div class="card-body text-dark">
                                <a href="${pageContext.request.contextPath}/views/customer/mobilepage.jsp" class="ordersa">
                                    <h5 class="card-title text-dark">${order.product.subtitle}</h5>
                                    </a>
                                    <c:set var="description" value="${order.product.description}" />
									<c:set var="commaIndex" value="${fn:indexOf(description, ',')}" />
									<c:if test="${commaIndex != -1}">
									<p class="card-text">${fn:substring(description, 0, commaIndex)}</p>
									</c:if>
                                    <p class="card-text"><strong><fmt:formatNumber value="${order.amount}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></strong></p>
                                    <p class="card-text">Quantity : ${order.product.quantity}</p>
                                    <div class="row justify-content-between">
                                    <div class="col-auto">
                                   <p class="card-text"><small class="text-muted order-status-text">${order.orderStatus} on ${order.orderDate}</small></p>
                                    </div>
                                    <c:if test="${order.orderStatus!='CANCELLED'}">
                                    <div class="col-auto justify-self-end">
                                    <button type="button" class="btn btn-outline-danger btn-order-cancel">cancel</button>
                                    </div>
                                    </c:if>
                                    <c:if test="${order.orderStatus=='CANCELLED'}">
                                   			 
                                    </c:if>
                                   </div>
                                </div>
                            </div>
                        </div>
                    </div>
                   
                 
                    </c:forEach>
                    <!-- Order Item 2 -->
                    
                </div>
            </div>
        </div>
    </div>
      <div class="modal fade" id="cancelModal">
    <div class="modal-dialog">
      <div class="modal-content">

        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Confirm Order Cancellation</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>

        <!-- Modal Body -->
        <div class="modal-body">
          <p id="order-id-modal"></p>
          Are you sure you want to cancel your order?
        </div>

        <!-- Modal Footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#creditCardModal" data-dismiss="modal">Confirm Cancel</button>
        </div>

      </div>
    </div>
  </div>

  <!-- The Credit Card Form Modal -->
  <div class="modal fade" id="creditCardModal">
    <div class="modal-dialog">
      <div class="modal-content">

        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Credit Card Information</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>

        <!-- Modal Body -->
        <div class="modal-body">
          <p>The amount of <span id="order-amount" class="text-danger"></span> will be refunded to the registered Bank Account within 8-10 business days.</p>
          <form id="order-cancel-form" action="OrderRefundController" method="post">
          <input name="orderId" id="order-cancel-id"/>
          <div class="form-group">
                                <label for="paragraphInput">Your Reason for return request</label>
                                <textarea class="form-control" id="paragraphInput" name="returnReason" rows="4"></textarea>
                                <div id="charCount" class="char-count mt-2">0/250 characters</div>
                            </div>
          <!-- 
            <div class="form-group p-2">
                <label for="cardNumber" class="mb-2">Card Number</label>
                <input type="text" class="form-control" name="card-number" id="cardNumber" placeholder="Enter your card number">
                <div class="error-message text-danger" id="cardNumberError"></div>
            </div>
            
            <div class="form-group p-2">
                <label for="cardNumber" class="mb-2">Card Holder Name</label>
                <input type="text" class="form-control" name="card-holder-name" id="cardHolderName" placeholder="Enter the Card holder name">
                <div class="error-message text-danger" id="cardNameError"></div>
            </div>
            <div class="form-group p-2">
                <label for="cardExpiryMonth">Expiry Date</label>
                <div class="d-flex justify-content-between mt-2">
                    <select class="form-control mr-2 w-75 ml-2" id="cardExpiryMonth" name="card-expiry-date-month">
                        <option value="" disabled selected>Month</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                        <option value="04">04</option>
                        <option value="05">05</option>
                        <option value="06">06</option>
                        <option value="07">07</option>
                        <option value="08">08</option>
                        <option value="09">09</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>
                    </select>
                    <select class="form-control mr-2 w-75 ml-4" id="cardExpiryYear" name="card-expiry-date-year">
                        <option value="" disabled selected>Year</option>
                        <option value="2024">2024</option>
                        <option value="2025">2025</option>
                        <option value="2026">2026</option>
                        <option value="2027">2027</option>
                        <option value="2028">2028</option>
                        <option value="2029">2029</option>
                        <option value="2030">2030</option>
                        <option value="2031">2031</option>
                    </select>
                </div>
                <div class="error-message text-danger" id="expiryDateError"></div>
            </div>
            <div class="form-group p-2">
                <label for="cardCVV" class="mb-2">CVV</label>
                <input type="text" name="card-cvv" class="form-control" id="cardCVV" placeholder="CVV">
                <div class="error-message text-danger" id="cardCVVError"></div>
            </div>
            <div class="text-center">
                <button type="submit" id="submitButton" class="btn-buy-now p-3 border-0 mt-2" style="width:175px" disabled data-bs-toggle="tooltip" title="Fill all the fields with valid input">Refund</button>
            </div> -->
            <button type="submit" id="submitButton" class="btn-buy-now p-3 border-0 mt-2" style="width:175px" data-bs-toggle="tooltip" title="Fill all the fields with valid input">Refund</button>
          </form>
        </div>

      </div>
    </div>
  </div>
  <div class="toast-container mt-5" id="toast-msg-top">
        <div class="toast  text-white bg-success border-0 p-3" id="success-toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body fs-6 msg">
                    Loading....!
                </div>
                
            </div>
        </div>
    </div>
    <script type="text/javascript">
    
    /*var login_nav = document.getElementById('login-pg');
	var seller_nav = document.getElementById('seller-pg');
	var profile_nav = document.getElementById('profile-pg');
	var currentUser = document.getElementById('navbarDropdown');
	var cart_nav = document.getElementById('nav-cart');
	console.log(currentUser.textContent);
	
	if(currentUser.textContent.trim()=== ""){
		login_nav.classList.remove('invisible');
		seller_nav.classList.remove('invisible');
		//profile_nav.classList.remove('invisible');
	}else{
		profile_nav.classList.remove('invisible');
		cart_nav.classList.add('needed');
	}*/
    	/*document.querySelectorAll('.card').forEach(order=>{
    		const orderId = order.getAttribute('data-orderId');
    		let button = order.querySelector('.btn-order-cancel');
    		button.addEventListener('click',()=>{
    			console.log(orderId);
    		})
    	});*/
    	const currencyFormatter = new Intl.NumberFormat('en-IN', {
            style: 'currency',
            currency: 'INR',
            minimumFractionDigits: 0,
            maximumFractionDigits: 0
        });
    	let orderInput = document.getElementById('order-cancel-id');
    	let model_data = document.getElementById('order-id-modal');
    	
    	document.querySelectorAll('.btn-order-cancel').forEach(button=>{
    		button.addEventListener('click',()=>{
    			let order = button.closest('.card');
        		let orderId = order.getAttribute('data-orderId');
        		let orderAmount = order.getAttribute('data-order-amount');
        		let cardNumber = order.getAttribute('data-credit-card-number');
        		console.log(cardNumber);
        		//document.getElementById('credit-card-number').textContent = cardNumber;
        		model_data.textContent = orderId;
        		let model = new bootstrap.Modal(document.getElementById('cancelModal'));
        		let order_amount = document.getElementById('order-amount');
        		orderInput.value = orderId;
        		order_amount.textContent = currencyFormatter.format(orderAmount);
        		model.show();
    		});
    		
    		
    	});
    	
    	function showToast(msg,isRed) {
            const toastElement = document.getElementById('success-toast');
            if(isRed){
            toastElement.classList.remove('bg-success');
            toastElement.classList.add('bg-danger');
            }else{
                toastElement.classList.remove('bg-danger');
                toastElement.classList.add('bg-success'); 
            }
            toastElement.querySelector('.msg').innerHTML = msg;
            const toast = new bootstrap.Toast(toastElement);
            toast.show();
        }
    	
    	const textarea = document.getElementById('paragraphInput');
        const charCount = document.getElementById('charCount');
        const maxChars = 250;

        textarea.addEventListener('input', () => {
            const currentLength = textarea.value.length;
            charCount.textContent = currentLength+'/'+maxChars+'characters';
            if (currentLength > maxChars) {
                charCount.classList.add('text-danger');
            } else {
                charCount.classList.remove('text-danger');
            }
        });

        document.getElementById('submitButton').addEventListener('click', (event) => {
            if (textarea.value.length > maxChars) {
                event.preventDefault();
				showToast('Character count is higher than the limit(250)',true);
            }else if(textarea.value.length <10){
            	event.preventDefault();
            	showToast('The reason should be minimum of 10 Characters')
            }
            
        });
    	/* const cardNumberError = document.getElementById('cardNumberError');
         const expiryDateError = document.getElementById('expiryDateError');
         const cardCVVError = document.getElementById('cardCVVError');
         const cardHolderNameError = document.getElementById('cardNameError');
         
    	let order_cancel_form = document.getElementById('order-cancel-form'); 
    	let order_refund_button = order_cancel_form.querySelector('#submitButton');
    	order_cancel_form.addEventListener('input',()=>{
    		let allInputValid = validateCardNumber() && validateCardHolderName() && validateExpiryDate() && validateCVV();
    		if(allInputValid){
    			order_refund_button.removeAttribute('disabled');
    		} else{
    			order_refund_button.setAttribute('disabled','true');
    		}
    		
    		
    	});
    	
    	function validateCardNumber(){
    		let cardNumberValue = order_cancel_form.querySelector('#cardNumber').value;
    		let card_number_regex = /^\d{16}$/;
    		if (card_number_regex.test(cardNumberValue)) {
                cardNumberError.textContent = '';
                return true;
            } else {
                cardNumberError.textContent = 'Card number must be 16 digit number.Numbers only allowed';
                return false;
            }
    	}
    	
    	function validateExpiryDate() {
            const month = order_cancel_form.querySelector('#cardExpiryMonth').value;
            const year = order_cancel_form.querySelector('#cardExpiryYear').value;
            if (month !== "" && year !== "") {
                expiryDateError.textContent = '';
                return true;
            } else {
                expiryDateError.textContent = 'Please select a valid expiry date';
                return false;
            }
        }
    	
    	function validateCVV() {
            const cvvValue = order_cancel_form.querySelector('#cardCVV').value.trim();
            const cvv_regex = /^\d{3}$/;
            if (cvv_regex.test(cvvValue)) {
                cardCVVError.textContent = '';
                return true;
            } else {
                cardCVVError.textContent = 'CVV must be 3 digit number.Numbers only allowed';
                return false;
            }
        }
        
        function validateCardHolderName(){
        	const cardHolderNameValue =  order_cancel_form.querySelector('#cardHolderName').value.trim();
        	const name_regex = /^[a-zA-Z]+$/;
        	if(name_regex.test(cardHolderNameValue)){
        		console.log("inside if");
        		cardHolderNameError.textContent = '';
                 return true;
        	}else{
        		cardHolderNameError.textContent = 'Card Holder Name should contains Alphabets Only.';
                 return false;
        	}
        }*/
    	
    </script>
    
    <footer class="footer mt-5 shadow bg-white">
        <div class="container">
          <div class="row">
            <div class="col-md-3 col-6">
              <h5>Company</h5>
              <ul class="list-unstyled">
                <li><a href="#">About Us</a></li>
                <li><a href="#">Careers</a></li>
                <li><a href="#">Press</a></li>
                <li><a href="#">Blog</a></li>
              </ul>
            </div>
            <div class="col-md-3 col-6">
              <h5>Support</h5>
              <ul class="list-unstyled">
                <li><a href="#">Help Center</a></li>
                <li><a href="#">Safety Information</a></li>
                <li><a href="#">Cancellation Options</a></li>
                <li><a href="#">Contact Us</a></li>
              </ul>
            </div>
            <div class="col-md-3 col-6">
              <h5>Services</h5>
              <ul class="list-unstyled">
                <li><a href="#">Account</a></li>
                <li><a href="#">Order Tracking</a></li>
                <li><a href="#">Wishlist</a></li>
                <li><a href="#">Customer Service</a></li>
              </ul>
            </div>
            <div class="col-md-3 col-6">
              <h5>Follow Us</h5>
              <div class="social-icons">
                <a href="#"><i class="bi bi-facebook"></i></a>
                <a href="#"><i class="bi bi-twitter"></i></a>
                <a href="#"><i class="bi bi-instagram"></i></a>
                <a href="#"><i class="bi bi-linkedin"></i></a>
              </div>
            </div>
          </div>
          <div class="row mt-4">
            <div class="col text-center">
              <p>&copy; 2024 MyEcommerce. All rights reserved.</p>
            </div>
          </div>
        </div>
      </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
