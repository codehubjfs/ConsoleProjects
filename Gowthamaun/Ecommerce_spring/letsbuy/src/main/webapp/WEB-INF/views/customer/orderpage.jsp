<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/asserts/css/customerstyles.css">
     <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <!-- <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style type="text/css">
    	/* You can add custom styles here if needed */
.card-header {
    background-color: #007bff; /* Bootstrap primary color */
}
.card-header h4 {
    margin: 0;
}
.form-label {
    font-weight: bold;
    margin-bottom: 0;
}
.ml-4 {
    margin-left: 1.5rem;
}
    	
    </style>
</head>

<body class="bg-light">
    <div class="navbar navbar-expand-lg navbar-light bg-white shadow-sm fixed-top" id="main-navv">
        <div class="container-fluid">
            <a class="navbar-brand d-none d-md-block" href="homepage.html">
                <img src="${pageContext.request.contextPath}/asserts/images/logo.png" class="rounded" width="210" height="110" alt="">
            </a>
            <a class="navbar-brand d-md-none" href="homepage.html">
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
                    <li class="nav-item txt-nav">
                        <a class="nav-link" href="CustomerCartController">
                            <i class="fa fa-shopping-cart needed" value="${sessionScope.user.getMyCart().getMyCart().size()}"></i> Cart
                        </a>
                    </li>
                    <li class="nav-item txt-nav">
                        <a class="nav-link" href="forwardHomepage">
                            <i class="fa fa-home"></i> Home
                        </a>
                    </li>
                  <!--   <li class="nav-item">
                        <a class="nav-link" href="#">
                            <i class="fa fa-heart"></i> Wishlist (0)
                        </a>
                    </li> --> 
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            <i class="fa fa-user"></i>${sessionScope.user.getFirstName()}
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#"><i class="fa fa-user"></i> Profile</a></li>
                            <li><a class="dropdown-item" href="CustomerOrdersController"><i class="fa fa-list"></i> My Orders</a></li>
                            <!-- <li><a class="dropdown-item" href="#"><i class="fa fa-heart"></i> My Wishlist</a></li>
                            <li><a class="dropdown-item" href="#"><i class="fa fa-shopping-cart"></i> My Cart</a></li> -->
                            <li><a class="dropdown-item" href="CustomerLogoutController"><i class="fa fa-sign-out"></i> Logout</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    
    <div class="container-fluid body-container">
        <div class="row">
            <div class="col-8">
                <div class="row p-3 bg-white mb-3">
                    <div class="col d-flex justify-content-between align-items-center">
                        <div>
                            <p class="mb-0" >Deliver to: <b id="delivery-to">${user.firstName}</b></p>
                            <p class="text-secondary mb-0" id="delivery-address">${user.address}</p>
                        </div>
                        <div>
                            <button class="btn-change btn rounded" id="addres-chng">Change</button>
                        </div>
                    </div>
                </div>
                 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
         
         
            <c:forEach var="orderpro" items="${orderProducts}">
   <c:set var="originalPrice" value="${orderpro.productPrice / (1 - (orderpro.discount / 100))}" />

    <div class="row bg-white p-4 card-product" data-product-id="${orderpro.productId}" data-price="${orderpro.productPrice}" data-originalPrice="${originalPrice}" data-discount="${orderpro.discount}">
        <div class="col d-flex">
            <div class="col-2">
                <img src="${pageContext.request.contextPath}/asserts/images/Cart-img/realme.webp" width="100" alt="">
            </div>
            <div class="col-6">
                <p class="mb-1">${orderpro.subtitle}</p>
                <p class="text-secondary">SELLER : ${orderpro.vendor.account.userName}</p>
                <p>
                    <span class="text-secondary">
                        <strike class="product-oringinal-price-card"><fmt:formatNumber value="${originalPrice*orderpro.quantity}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></strike>
                    </span>
                    <b class="mx-1 product-price-after-discount-card">
                        <fmt:formatNumber value="${orderpro.productPrice*orderpro.quantity}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/>
                    </b>
                    <span class="text-success fw-bold">${orderpro.discount}% Off</span>
                </p>
            </div>
            <div class="col">
                <p>Delivery by Monday Jun 17 | <span class="text-success">Free</span></p>
            </div>
        </div>
        <div class="row p-2 mt-4 mb-3">
            <div class="col d-flex align-items-center">
                <div class="col-auto d-flex box-one align-items-center">
                    <div>
                        <button class="btn increment-btn">&#10010;</button>
                    </div>
                    <div>
                        <input class="mx-1 cart-count text-center fw-bold" name="count" type="number" min="1" max="10" value="${orderpro.quantity}">
                    </div>
                    <div>
                        <button class="btn decrement-btn">&#9866;</button>
                    </div>
                </div>
                <div class="col-auto mx-4">
                    <button class="btn btn-outline-danger confirm-delete">REMOVE</button>
                </div>
            </div>
        </div>
    </div>
</c:forEach>


                <!-- <div class="row bg-white p-3 shadow mt-2 container-order">
                    <div class="col d-flex justify-content-end">
                        <button class="btn-cart-order">Place Order</button>
                    </div>
                </div> -->
                
                <div class="row bg-white p-3 shadow mt-2 container-order">
                    <div class="col d-flex justify-content-between align-items-center">
                        <p>Order confirmation email will be sent to <b>${user.email}</b></p>
                        <button class="btn-cart-order" data-bs-toggle="collapse" data-bs-target="#paymentOptions">Continue</button>
                    </div>
                </div>
                
                <div class="row mt-2">
        <div class="bg-white p-3">
            <div class="text-dark d-flex justify-content-between align-items-center">
                <h4>Payment Options</h4>
                
            </div>
        
            <div id="paymentOptions" class="collapse">
            <hr>
                <div class="card-body">
                    
                        <div class="form-group border-bottom py-3">
                            <label class="form-label">UPI</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="paymentOption" id="upi" checked>
                                <label class="form-check-label" for="upi">
                                    <img src="#" alt="UPI"> Choose an option
                                </label>
                            </div>
                            <div class="ml-4">
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="upiOption" id="phonePe">
                                    <label class="form-check-label" for="phonePe">PhonePe</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" name="upiOption" id="upiId">
                                    <label class="form-check-label" for="upiId">Your UPI ID</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group border-bottom py-3">
                            <label class="form-label">Wallets</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="paymentOption" id="wallets">
                                <label class="form-check-label" for="wallets">
                                    <img src="#" alt="Paytm"> Paytm
                                </label>
                            </div>
                        </div>
                        <div class="form-group border-bottom py-3">
                            <div class="form-check">
                                <input class="form-check-input" type="radio" data-bs-toggle="collapse" data-bs-target="#cardDetails" name="paymentOption" id="card">
                                <label class="form-label" for="card">Credit / Debit / ATM Card</label>
                            </div>
                            <div class="collapse ml-4" id="cardDetails">
                                <div class="card card-body mt-2">
                                <form id="paymentForm" action="ProductOrderPaymentController" method="post" novalidate>
                                <input id="card-product-quantity" name="order-product-quantity">
                                <input id="order-shipping-address" name="order-address">
                                <input id="order-card-total-amount" name="order-card-amount">
                               
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
                <button type="submit" id="submitButton" class="btn-buy-now p-3 border-0 mt-2" style="width:175px" disabled data-bs-toggle="tooltip" title="Fill all the fields with valid input">PAY<span id="btn-pay-amount"></span></button>
            </div>
        </form>
                                </div>
                            </div>
                        </div>
                        <div class="form-group border-bottom py-3">
                            <label class="form-label">Net Banking</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="paymentOption" id="netBanking">
                                <label class="form-check-label" for="netBanking">This instrument has low success, use UPI or cards for better experience</label>
                            </div>
                        </div>
                        <div class="form-group border-bottom py-3">
                            <label class="form-label">EMI (Easy Installments)</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="paymentOption" id="emi">
                                <label class="form-check-label" for="emi">EMI (Easy Installments)</label>
                            </div>
                        </div>
                        <div class="form-group py-3">
                            <label class="form-label">Cash on Delivery</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="paymentOption" id="cod">
                                <label class="form-check-label" for="cod">Not applicable</label>
                            </div>
                        </div>
                 
                </div>
            </div>
        </div>
    </div>
                

            </div>
            <div class="col-4">
                <div class="bg-white pt-3 pb-3 position-fixed">
    <h5 class="text-secondary px-3">PRICE DETAILS</h5>
    <hr class="px-0 mx-0">
    <div class="px-3 d-flex justify-content-between">
        <div>
            <p id="price-details-item-count">Price (1 items)</p>
        </div>
        <div>
            <p id="price-details-total-price">₹15,999</p>
        </div>
    </div>
    <div class="px-3 d-flex justify-content-between">
        <div>
            <p>Discount</p>
        </div>
        <div>
            <p class="text-success" id="price-details-discount">-₹4,999</p>
        </div>
    </div>
    <div class="px-3 d-flex justify-content-between">
        <div>
            <p>Delivery Charges</p>
        </div>
        <div>
            <p class="text-success"><strike class="text-secondary">₹400</strike> Free</p>
        </div>
    </div>
    <div class="px-3 d-flex justify-content-between">
        <div>
            <p>Secured Packaging Fee</p>
        </div>
        <div>
            <p>₹59</p>
        </div>
    </div>
    <hr class="mx-3 amount-line">
    <div class="px-3 d-flex justify-content-between mt-1 fw-bold fs-5">
        <div>
            <p>Amount Payable</p>
        </div>
        <div>
            <p id="price-details-amount-payable" class="ml-3">₹16,058</p>
        </div>
    </div>
    <hr class="mx-3 mt-1 amount-line">
    <p class="px-3 text-success fw-bold" id="price-details-savings">You will Save ₹4,999 on this Order</p>
</div>

            </div>
        </div>
    </div>
    <footer>
        <hr>
        <div class="col d-flex footer-cart p-4 justify-content-between">
            <div class="policies d-flex ">
                <!-- <p>Policies : </p> -->
                 <div class="">
                    <p>Policies : </p>
                 </div>
                <div class="policy">
                <a href="" class="mx-1 pt-0 mt-0">Returns Policy </a>|
                <a href="" class="mx-1 pt-0 mt-0">Terms of use </a>|
                <a href="" class="mx-1 pt-0 mt-0">Security </a>
                </div>
                
            </div>
            <div class="cart-copyright">
                <p>&#169;LetsBuy.com</p>
            </div>
            <div class="follow-us d-flex">
                <h5 class="mx-2">Follow Us</h5>
                
                  <a href="#"><i class="bi bi-facebook text-secondary"></i></a>
                  <a href="#" class="mx-2"><i class="bi bi-twitter text-secondary"></i></a>
                  <a href="#"><i class="bi bi-instagram text-secondary"></i></a>
                  <a href="#" class="mx-2"><i class="bi bi-linkedin text-secondary"></i></a>
                
            </div>
        </div>
    </footer>

    <!-- Code for the Toast mesaage!! -->

    <div class="toast-container mt-5" id="toast-msg-top">
        <div class="toast  text-white bg-success border-0 p-3" id="success-toast" role="alert" aria-live="assertive" aria-atomic="true">
            <div class="d-flex">
                <div class="toast-body fs-6 msg">
                    Loading....!
                </div>
                <button type="button" class="btn-close btn-close-white me-2 m-auto" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
        </div>
    </div>

    <!-- Code to make toggle to remove confirmation -->

    <div class="modal fade" id="confirmRemove" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmTitle">Confirmation</h5>
                    <button type="button" class="close border-0 bg-white" data-bs-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true" class="fs-2 bg-white">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p class="text-secondary mt-2">Are you sure you want to remove this item?</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="button" class="btn  remove-cart" data-bs-dismiss="modal">Remove</button>
                </div>
            </div>
        </div>
    </div>

    <div class="modal fade" id="addressModal">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Change Shipping Address</h4>
                    <button type="button" class="close" data-bs-dismiss="modal">&times;</button>
                </div>
				<form id="addressForm" novalidate>
                <!-- Modal Body -->
                <div class="modal-body">
    
        <div class="form-group">
            <label for="fullName">Full Name:</label>
            <input type="text" class="form-control" id="fullName" name="fullName" required>
            <div class="invalid-feedback" id="fullname-invalid">Please enter your full name.</div>
        </div>
        <div class="form-group">
            <label for="addressLine1">Address Line 1:</label>
            <input type="text" class="form-control" id="addressLine1" name="addressLine1" required>
            <div class="invalid-feedback" id="address-invalid">Please enter your address.</div>
        </div>
        <div class="form-group">
            <label for="state">State:</label>
            <select class="form-control" id="state" name="state" required>
                <option value="">Select a state</option>
            </select>
            <div class="invalid-feedback" id="state-invalid">Please select your state.</div>
        </div>
        <div class="form-group">
            <label for="city">City:</label>
            <select class="form-control" id="city" name="city" required>
                <option value="">Select a city</option>
            </select>
            <div class="invalid-feedback" id="city-invalid">Please select your city.</div>
        </div>
        
        <div class="form-group">
            <label for="pincode">Pincode:</label>
            <input type="text" class="form-control" id="pincode" name="pincode" required pattern="\d{6}">
            <div class="invalid-feedback" id="pincode-invalid">Please enter a valid 6-digit pincode.</div>
        </div>
        <button type="submit" class="btn btn-primary mt-3" id="submit-btn-addrs" data-bs-dismiss="modal" disabled>Save</button>
    
</div>


                <!-- Modal Footer -->
                <div class="modal-footer">
                	<button type="reset" class="btn btn-primary">reset</button>
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                </div>
				</form>
            </div>
        </div>
    </div>

    <!-- <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
        <div id="liveToast" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true">
          <div class="toast-header">
            <img src="..." class="rounded me-2" alt="...">
            <strong class="me-auto">Bootstrap</strong>
            <small>11 mins ago</small>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
          </div>
          <div class="toast-body">
            Hello, world! This is a toast message.
          </div>
        </div>
      </div> -->

    <script>
    
    //JavaScript Code to show the toast//
  
document.addEventListener('DOMContentLoaded', () => {
    const incrementButtons = document.querySelectorAll('.increment-btn');
    const decrementButtons = document.querySelectorAll('.decrement-btn');
    const quantityInputs = document.querySelectorAll('.cart-count');

    const updatePriceDetails = () => {
        let totalPrice = 0;
        let totalDiscount = 0;
        let itemCount = 0;
        let actualPrice = 0;
        let quantityOuter = 0;
        
        const currencyFormatter = new Intl.NumberFormat('en-IN', {
            style: 'currency',
            currency: 'INR',
            minimumFractionDigits: 0,
            maximumFractionDigits: 0
        });

        document.querySelectorAll('.card-product').forEach(product => {
            const price = parseInt(product.getAttribute('data-price'));
            const discount = parseInt(product.getAttribute('data-discount'));
            const quantity = parseInt(product.querySelector('.cart-count').value);
            const originalPrice = parseInt(product.getAttribute('data-originalprice'));
			console.log(price);
            itemCount += quantity;
            totalPrice += (originalPrice * quantity);
            totalDiscount += (originalPrice * discount / 100) * quantity;
            actualPrice +=(price * quantity);
            quantityOuter = quantity;
            console.log(actualPrice);
            //product.querySelector('.product-oringinal-price-card').textContent = currencyFormatter.format(originalPrice*quantity);
            //product.querySelector('.product-price-after-discount-card').textContent = currencyFormatter.format(price*quantity);
        });

        

        document.getElementById('price-details-item-count').textContent = "Price (" + itemCount + " items)";
        document.getElementById('price-details-total-price').textContent = currencyFormatter.format(totalPrice);
        document.getElementById('price-details-discount').textContent = "-" + currencyFormatter.format(totalDiscount);
        document.getElementById('price-details-amount-payable').textContent = " "+currencyFormatter.format(actualPrice + 59);
        document.getElementById('price-details-savings').textContent = "You will Save " + currencyFormatter.format(totalDiscount) + " on Order";
       /* document.getElementById('product-oringinal-price-card').textContent = currencyFormatter.format(totalPrice);
        document.getElementById('product-price-after-discount-card').textContent = currencyFormatter.format(actualPrice); */
        document.getElementById('btn-pay-amount').textContent = "  "+currencyFormatter.format(actualPrice+59);
        document.getElementById('order-card-total-amount').value = (actualPrice+59);
        document.getElementById('card-product-quantity').value = quantityOuter;
        
    };

    incrementButtons.forEach(button => {
        button.addEventListener('click', () => {
            const input = button.parentElement.nextElementSibling.querySelector('.cart-count');
            if (input.value < 10) {
                input.value = parseInt(input.value) + 1;
                updatePriceDetails();
            }
        });
    });

    decrementButtons.forEach(button => {
        button.addEventListener('click', () => {
            const input = button.parentElement.previousElementSibling.querySelector('.cart-count');
            if (input.value > 1) {
                input.value = parseInt(input.value) - 1;
                updatePriceDetails();
            }
        });
    });

    quantityInputs.forEach(input => {
        input.addEventListener('change', () => {
            if (input.value < 1) input.value = 1;
            if (input.value > 10) input.value = 10;
            updatePriceDetails();
        });
    });

    // Initial update
    updatePriceDetails();
});


	/*var order = document.querySelector('.card-product');
	var product_id = order.getAttribute('data-product-id');
	console.log(product_id);*/
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
    
    document.addEventListener('DOMContentLoaded', function() {
    	document.getElementById('order-shipping-address').value = document.getElementById('delivery-address').textContent;
    	//document.getElementById('order-product-Id').value=product_id;
        const form = document.getElementById('paymentForm');
        const cardNumber = document.getElementById('cardNumber');
        const cardExpiryMonth = document.getElementById('cardExpiryMonth');
        const cardExpiryYear = document.getElementById('cardExpiryYear');
        const cardHolderName = document.getElementById('cardHolderName');
        const cardCVV = document.getElementById('cardCVV');
        const submitButton = document.getElementById('submitButton');

        const cardNumberError = document.getElementById('cardNumberError');
        const expiryDateError = document.getElementById('expiryDateError');
        const cardCVVError = document.getElementById('cardCVVError');
        const cardHolderNameError = document.getElementById('cardNameError');
        

        $('[data-toggle="tooltip"]').tooltip();

        function validateCardNumber() {
            const cardNumberValue = cardNumber.value.trim();
            if (/^\d{16}$/.test(cardNumberValue)) {
                cardNumberError.textContent = '';
                return true;
            } else {
                cardNumberError.textContent = 'Card number must be 16 digit number.Numbers only allowed';
                return false;
            }
        }

        function validateExpiryDate() {
            const month = cardExpiryMonth.value;
            const year = cardExpiryYear.value;
            if (month !== "" && year !== "") {
                expiryDateError.textContent = '';
                return true;
            } else {
                expiryDateError.textContent = 'Please select a valid expiry date';
                return false;
            }
        }

        function validateCVV() {
            const cvvValue = cardCVV.value.trim();
            if (/^\d{3}$/.test(cvvValue)) {
                cardCVVError.textContent = '';
                return true;
            } else {
                cardCVVError.textContent = 'CVV must be 3 digit number.Numbers only allowed';
                return false;
            }
        }
        
        function validateCardHolderName(){
        	const cardHolderNameValue =  cardHolderName.value.trim();
        	if(/^[a-zA-Z]+$/.test(cardHolderNameValue)){
        		console.log("inside if");
        		cardHolderNameError.textContent = '';
                 return true;
        	}else{
        		cardHolderNameError.textContent = 'Card Holder Name should contains Alphabets Only.';
                 return false;
        	}
        }
        

        function validateForm() {
            const isCardNumberValid = validateCardNumber();
            const isExpiryDateValid = validateExpiryDate();
            const isCardHolderNameValid = validateCardHolderName();
            const isCVVValid = validateCVV();

            return isCardNumberValid && isExpiryDateValid && isCVVValid && isCardHolderNameValid;
        }

        function toggleSubmitButton() {
            if (validateForm()) {
                submitButton.removeAttribute('disabled');
                submitButton.setAttribute('title', 'Pay now');
                console.log("Sucess");
            } else {
                submitButton.setAttribute('disabled', 'disabled');
                submitButton.setAttribute('title', 'Fill all the fields with valid input');
            }
            $('[data-toggle="tooltip"]').tooltip('dispose').tooltip();
        }

        cardNumber.addEventListener('input', toggleSubmitButton);
        cardExpiryMonth.addEventListener('change', toggleSubmitButton);
        cardExpiryYear.addEventListener('change', toggleSubmitButton);
        cardCVV.addEventListener('input', toggleSubmitButton);
        cardHolderName.addEventListener('input',toggleSubmitButton);

        form.addEventListener('submit', function(event) {
            if (!validateForm()) {
                event.preventDefault();
            }
        });
    });


    
        //JavaScript code for the Manual check of quantity in the cart//

        document.querySelectorAll('.cart-count').forEach(input => {
            input.addEventListener('input', function(event) {
                let card = event.target.closest('.card-product');
                let quantity = event.target.value;
                console.log(quantity); // Log the quantity value directly
                if(quantity>10){
                    event.target.value = parseInt(quantity/10);
                    showToast('The Limit is 10 for a order',true); 
                    console.log('Max is 10');
                }else if(quantity<=0){
                    event.target.value = 1;
                    console.log('Negative values are not allowed');
                }else{
                    console.log('Value is valid')
                }
            });
        });
        
      
        
        
        //JavaScript code for the increment of quantity in the cart//

    /*    document.querySelectorAll('.increment-btn').forEach(input => {
            input.addEventListener('click',function(event){
                let card = event.target.closest('.card-product');
                let quantityElement = card.querySelector('.cart-count');
                let quantity = parseInt(quantityElement.value,10);
                if(quantity<10){
                    quantityElement.value = quantity+1;
                    showToast('Product Quantity has been updated Successfully ',false);
                    
                }else{
                    console.log('The Max Limit for a order is 10');
                    showToast('The Limit is 10 for a order',true); 
                }
            });
        });

        //JavaScript code for the decrement of quantity in the cart//

        document.querySelectorAll('.decrement-btn').forEach(input => {
            input.addEventListener('click',function(event){
                let card = event.target.closest('.card-product');
                let quantityElement = card.querySelector('.cart-count');
                let quantity = parseInt(quantityElement.value,10);
                if(quantity>=2){
                    quantityElement.value = quantity-1;
                    showToast('Product Quantity has been updated Successfully ',false);
                }else{
                    console.log('The Min Limit for a order is 1');
                    showToast('Minimum should be 1',true);
                }
            });
        }); */


        document.getElementById('addres-chng').addEventListener('click', function() {
            var changeAddressModal = new bootstrap.Modal(document.getElementById('addressModal'));
            changeAddressModal.show();
        });
        
        document.addEventListener('DOMContentLoaded', function() {
        	// Configuration object with API URL and API Key
        	var config = {
        	    cUrl: 'https://api.countrystatecity.in/v1',
        	    ckey: 'NHhvOEcyWk50N2Vna3VFTE00bFp3MjFKR0ZEOUhkZlg4RTk1MlJlaA=='
        	};

        	// Selectors for dropdowns
        	var stateSelect = document.querySelector('#state');
        	var citySelect = document.querySelector('#city');
        	console.log("Inside city,state above");
        	loadStates();
        	loadCities();

        	// Function to load states for India
        	function loadStates() {
        		console.log("Inside load states");
        	    let apiEndPoint = config.cUrl+'/countries/IN/states';

        	    fetch(apiEndPoint, {
        	        headers: {
        	            "X-CSCAPI-KEY": config.ckey
        	        }
        	    })
        	    .then(response => response.json())
        	    .then(data => {
        	        // Clear existing options
        	        stateSelect.innerHTML = '<option value="">Select State</option>';

        	        // Populate with new options
        	        data.forEach(state => {
        	            const option = document.createElement('option');
        	            option.value = state.iso2;
        	            option.textContent = state.name;
        	            stateSelect.appendChild(option);
        	        });
        	    })
        	    .catch(error => console.error('Error loading states:', error));

        	    // Disable and reset city dropdown
        	    citySelect.disabled = true;
        	    citySelect.innerHTML = '<option value="">Select City</option>';
        	}

        	// Function to load cities based on selected state for India
        	function loadCities() {
        	    const selectedStateCode = stateSelect.value;
        	    if (!selectedStateCode) return;

        	    let apiEndPoint = config.cUrl+'/countries/IN/states/'+selectedStateCode+'/cities';

        	    fetch(apiEndPoint, {
        	        headers: {
        	            "X-CSCAPI-KEY": config.ckey
        	        }
        	    })
        	    .then(response => response.json())
        	    .then(data => {
        	        // Clear existing options
        	        citySelect.innerHTML = '<option value="">Select City</option>';

        	        // Populate with new options
        	        data.forEach(city => {
        	            const option = document.createElement('option');
        	            option.value = city.name;
        	            option.textContent = city.name;
        	            citySelect.appendChild(option);
        	        });
        	    })
        	    .catch(error => console.error('Error loading cities:', error));

        	    // Enable city dropdown
        	    citySelect.disabled = false;
        	}

        	// Event listeners to trigger loading states and cities
        	stateSelect.addEventListener('change', loadCities);

        	// Load states for India initially

        });

        // Form submission handler
       

        document.getElementById('submit-btn-addrs').addEventListener('click', function(event) {
            event.preventDefault();
            validateForm();
            var form = document.getElementById('addressForm');
            if (form.checkValidity()) {
                displayEnteredData();
                $('#addressModal').modal('hide');
            } else {
                form.classList.add('was-validated');
            }
        });

        document.getElementById('addressForm').addEventListener('input', validateForm);

        function validateForm() {
        	console.log('Inside validater');
            var form = document.getElementById('addressForm');
            var isValid = form.checkValidity();

            // Regex patterns
            var namePattern = /^[A-Za-z\s]{1,50}$/;
            var pincodePattern = /^\d{6}$/;

            // Validate Full Name
            var fullNameInput = document.getElementById('fullName');
            var fullname_invalid = document.getElementById('fullname-invalid');
            if (!namePattern.test(fullNameInput.value)) {
                fullname_invalid.textContent="please enter a valid full name (only alphabets and spaces, up to 50 characters).";
                form.fullName.classList.add("is-invalid");
                isValid = false;
            } else {
            	form.fullName.classList.remove("is-invalid");
            	form.fullName.classList.add("is-valid");
            	fullname_invalid.textContent="";
            }

            // Validate Address Line 1
            var addressLine1Input = document.getElementById('addressLine1');
            var address_invalid = document.getElementById('address-invalid');
            if (addressLine1Input.value.trim() === '') {
                address_invalid.textContent='Please enter your address.';
                form.addressLine1.classList.add("is-invalid");
                isValid = false;
            } else {
            	form.addressLine1.classList.remove("is-invalid");
            	form.addressLine1.classList.add("is-valid");
            	address_invalid.textContent='';
            }

            // Validate Pincode
            var pincodeInput = document.getElementById('pincode');
            var pincode_invalid = document.getElementById('pincode-invalid');
            if (!pincodePattern.test(pincodeInput.value)) {
                //pincodeInput.setCustomValidity('Please enter a valid 6-digit pincode.');
                pincode_invalid.textContent = 'Please enter a valid 6-digit pincode.';
                form.pincode.classList.add('is-invalid');
                isValid = false;
            } else {
            	form.pincode.classList.remove('is-invalid');
            	form.pincode.classList.add('is-valid');
            	pincode_invalid.textContent = "";
            }

            // Enable or disable submit button based on form validity
            var submitBtn = document.getElementById('submit-btn-addrs');
            submitBtn.disabled = !isValid;
        }

        function displayEnteredData() {
            var fullName = document.getElementById('fullName').value;
            var addressLine1 = document.getElementById('addressLine1').value;
            var state = document.getElementById('state').value;
            var city = document.getElementById('city').value;
            var pincode = document.getElementById('pincode').value;

            document.getElementById('delivery-to').innerHTML = fullName;
            document.getElementById('delivery-address').innerHTML = addressLine1 + ', ' + city + ', ' + state + ', ' + pincode;
            document.getElementById('order-shipping-address').value = document.getElementById('delivery-address').textContent;
        }




        // document.getElementById('addres-chng').addEventListener('click',function(event){
            
        //     document.getElementById('save-btn-change-addr').addEventListener('click',function(event){
        //         var chnage_address = new bootstrap.Modal(document.getElementById('addressModal'));
        //         chnage_address.show();
        //     });
        //     var delivername = document.getElementById('delivery-to');
        //     var deliveryaddress = document.getElementById('delivery-address');

        //     var fullname = document.getElementById('fullName');
        //     var addressline = document.getElementById('addressLine1');
        //     var city = document.getElementById('city');
        //     var state = document.getElementById('state');
        //     var pincode = document.getElementById('pincode');
        //     delivername.innerHTML = fullname;
        //     deliveryaddress.innerHTML = (addressline+","+state+","+city+","+pincode);

        // });

        document.querySelectorAll('.confirm-delete').forEach(button =>{
            button.addEventListener('click',function(event){
                var parentProduct = event.target.closest('.card-product');
                var confirmModal = new bootstrap.Modal(document.getElementById('confirmRemove'));
                confirmModal.show();
                document.querySelector('.remove-cart').addEventListener('click',function(){
                    parentProduct.parentNode.removeChild(parentProduct);
                    showToast('Item has been removed from cart Succesfully',false);
                    console.log('Product has been removed Successfully');
                });
                
            })
        });
        
        
    </script>
</body>


</html>