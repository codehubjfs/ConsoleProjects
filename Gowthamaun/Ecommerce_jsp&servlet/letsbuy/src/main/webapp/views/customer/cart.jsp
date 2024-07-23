<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/customerstyles.css">
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

<body class="bg-light">
    <div class="main-navbar shadow-sm fixed-top">
        <div class="top-navbar">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-2 my-auto d-none d-sm-none d-md-block d-lg-block">
                        <a href="${pageContext.request.contextPath}/index.jsp">
                            <img src="${pageContext.request.contextPath}/images/logo.png" class="rounded" width="210" height="110" alt="">
                           </a>
                    </div>
                    <div class="col-md-5 my-auto">
                        <form role="search">
                            <div class="input-group">
                                <input type="search" placeholder="Search your product" class="form-control" />
                                <button class="btn btn-serch" type="submit">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </form>
                    </div>
                    <div class="col-md-5 my-auto">
                        <ul class="nav justify-content-center">

                            <!-- <li class="nav-item txt-nav">
                                <a class="nav-link" href="#">
                                    <i class="fa fa-shopping-cart"></i> Cart (0)
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <i class="fa fa-heart"></i> Wishlist (0)
                                </a>
                            </li> -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
                                    data-bs-toggle="dropdown" aria-expanded="false">
                                    <i class="fa fa-user"></i>${user.firstName}
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <li><a class="dropdown-item" href="#"><i class="fa fa-user"></i> Profile</a></li>

                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/CustomerOrdersController"><i class="fa fa-list"></i> My Orders</a></li>
                                  <!--  <li><a class="dropdown-item" href="#"><i class="fa fa-heart"></i> My Wishlist</a>
                                    </li>  --> 
                                    <!-- <li><a class="dropdown-item" href="#"><i class="fa fa-shopping-cart"></i> My
                                            Cart</a></li> -->
                                    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/CustomerLogoutController"><i class="fa fa-sign-out"></i> Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container-fluid body-container">
        <div class="row">
            <div class="col-8">
                <div class="row p-3 bg-white mb-3">
                    <div class="col d-flex justify-content-between align-items-center">
                        <div>
                            <p class="mb-0">Deliver to: <b>${user.firstName}</b></p>
                            <p class="text-secondary mb-0">${user.address}</p>
                            <p class="updation-status"><%= request.getSession().getAttribute("cart-update-status")!=null?request.getSession().getAttribute("cart-update-status"):"" %></p>
                        </div>
                        <div>
                            <button class="btn-change btn rounded">Change</button>
                        </div>
                    </div>
                </div>
                 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
         		 
         		<c:set var="cart" value="${customerCart}"/>
         		<c:forEach var="product" items="${cart.myCart}" varStatus="status">
         			<c:set var="originalPrice" value="${product.value.productPrice + (product.value.productPrice * product.value.discount / 100)}" />
         		
                <div class="row bg-white p-4 card-product">
                    <div class="col d-flex">
                        <div class="col-2">
                            <img src="${pageContext.request.contextPath}/images/Cart-img/realme.webp" width="100" alt="">
                        </div>
                        <div class="col-6">
                            <p class="mb-1">${product.value.subtitle}</p>
                            <p class="text-secondary">Seller: PETILANTE Online</p>
                            <p><span class="text-secondary"><strike><fmt:formatNumber value="${originalPrice*product.value.quantity}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></strike></span><b class="mx-1"><fmt:formatNumber value="${product.value.productPrice*product.value.quantity}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></b><span class="text-success fw-bold">${product.value.discount}% Off</span></p>
                        </div>
                        <div class="col">
                            <p>Delivery by Monday Jun 17 | <span class="text-success">Free</span></p>
                        </div>
                    </div>
                    <div class="row p-2 mt-4 mb-3 ">
                        <div class="col d-flex align-items-center">
                            <div class="col-auto d-flex box-one align-items-center">
                                <div>
                                <form action="${pageContext.request.contextPath}/CartProductIncrementController" method="post">
                                	<input type="hidden"  name="pId" value="${product.key}">
                                	<input type="hidden" name="operation" value="increment">
                                	<button type="submit" class="btn increment-btn">&#10010;</button>
                                </form>
                                    
                                </div>
                                <div>
                                    <input class="mx-1 cart-count  fw-bold" name="count" type="number" min="1" max="10" value="${product.value.quantity }">
                                </div>
                                <div>
	                                <form action="${pageContext.request.contextPath}/CartProductIncrementController" method="post">
	                                	<input type="hidden" name="pId" value="${product.key}">
	                                	<input type="hidden" name="operation" value="decrement">
	                                	<button type="submit" class="btn decrement-btn">&#9866;</button>
	                                </form> 
                                </div>
                            </div>
                            <div class="col-auto mx-4">
                            	
	                                 <button class="btn text-dark confirm-delete">REMOVE</button>
                            	      <input type="hidden" class="product-id" name="pId" value="${product.key}">                         
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
                
           <!--     <div class="row bg-white  p-4 card-product">
                    <div class="col d-flex">
                        <div class="col-2">
                            <img src="${pageContext.request.contextPath}/images/Cart-img/realme.webp" width="100" alt="">
                        </div>
                        <div class="col-6">
                            <p class="mb-1">realme P1 5G (Peacock Green, 128GB)</p>
                            <p class="text-secondary">Seller: PETILANTE Online</p>
                            <p><span class="text-secondary"><strike>$20,999</strike></span><b class="mx-1">$15,999</b><span class="text-success fw-bold">23% Off</span></p>
                        </div>
                        <div class="col">
                            <p>Delivery by Monday Jun 17 | <span class="text-success">Free</span></p>
                        </div>
                    </div>
                    <div class="row p-2">
                        <div class="col d-flex align-items-center">
                            <div class="col-auto d-flex box-one align-items-center">
                                <div>
                                    <button class="btn increment-btn">&#10010;</button>
                                </div>
                                <div>
                                    <input class="mx-1 cart-count  fw-bold" name="count" type="number" min="1" max="10" value="1">
                                </div>
                                <div>
                                    <button class="btn decrement-btn">&#9866;</button>
                                </div>
                            </div>
                            <div class="col-auto mx-4">
                                <button class="btn text-dark confirm-delete">REMOVE</button>
                            </div>
                        </div>
                    </div>
                </div>
                

                <div class="row bg-white  p-4 card-product">
                    <div class="col d-flex">
                        <div class="col-2">
                            <img src="${pageContext.request.contextPath}/images/Cart-img/realme.webp" width="100" alt="">
                        </div>
                        <div class="col-6">
                            <p class="mb-1">realme P1 5G (Peacock Green, 128GB)</p>
                            <p class="text-secondary">Seller: PETILANTE Online</p>
                            <p><span class="text-secondary"><strike>$20,999</strike></span><b class="mx-1">$15,999</b><span class="text-success fw-bold">23% Off</span></p>
                        </div>
                        <div class="col">
                            <p>Delivery by Monday Jun 17 | <span class="text-success">Free</span></p>
                        </div>
                    </div>
                    <div class="row p-2">
                        <div class="col d-flex align-items-center">
                            <div class="col-auto d-flex box-one align-items-center">
                                <div>
                                    <button class="btn increment-btn">&#10010;</button>
                                </div>
                                <div>
                                    <input class="mx-1 cart-count  fw-bold" name="count" type="number" min="1" max="10" value="1">
                                </div>
                                <div>
                                    <button class="btn decrement-btn">&#9866;</button>
                                </div>
                            </div>
                            <div class="col-auto mx-4">
                                <button class="btn text-dark confirm-delete">REMOVE</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row bg-white  p-4 card-product">
                    <div class="col d-flex">
                        <div class="col-2">
                            <img src="${pageContext.request.contextPath}/images/Cart-img/realme.webp" width="100" alt="">
                        </div>
                        <div class="col-6">
                            <p class="mb-1">realme P1 5G (Peacock Green, 128GB)</p>
                            <p class="text-secondary">Seller: PETILANTE Online</p>
                            <p><span class="text-secondary"><strike>$20,999</strike></span><b class="mx-1">$15,999</b><span class="text-success fw-bold">23% Off</span></p>
                        </div>
                        <div class="col">
                            <p>Delivery by Monday Jun 17 | <span class="text-success">Free</span></p>
                        </div>
                    </div>
                    <div class="row p-2">
                        <div class="col d-flex align-items-center">
                            <div class="col-auto d-flex box-one align-items-center">
                                <div>
                                    <button class="btn increment-btn">&#10010;</button>
                                </div>
                                <div>
                                    <input class="mx-1 cart-count  fw-bold" name="count" type="number" min="1" max="10" value="1">
                                </div>
                                <div>
                                    <button class="btn decrement-btn">&#9866;</button>
                                </div>
                            </div>
                            <div class="col-auto mx-4">
                                <button class="btn text-dark confirm-delete">REMOVE</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row bg-white  p-4 card-product">
                    <div class="col d-flex">
                        <div class="col-2">
                            <img src="${pageContext.request.contextPath}/images/Cart-img/realme.webp" width="100" alt="">
                        </div>
                        <div class="col-6">
                            <p class="mb-1">realme P1 5G (Peacock Green, 128GB)</p>
                            <p class="text-secondary">Seller: PETILANTE Online</p>
                            <p><span class="text-secondary"><strike>$20,999</strike></span><b class="mx-1">$15,999</b><span class="text-success fw-bold">23% Off</span></p>
                        </div>
                        <div class="col">
                            <p>Delivery by Monday Jun 17 | <span class="text-success">Free</span></p>
                        </div>
                    </div>
                    <div class="row p-2">
                        <div class="col d-flex align-items-center">
                            <div class="col-auto d-flex box-one align-items-center">
                                <div>
                                    <button class="btn increment-btn">&#10010;</button>
                                </div>
                                <div>
                                    <input class="mx-1 cart-count  fw-bold" name="count" type="number" min="1" max="10" value="1">
                                </div>
                                <div>
                                    <button class="btn decrement-btn">&#9866;</button>
                                </div>
                            </div>
                            <div class="col-auto mx-4">
                                <button class="btn text-dark confirm-delete">REMOVE</button>
                            </div>
                        </div>
                    </div>
                </div>  -->
                <div class="row bg-white p-3 shadow sticky-bottom  z-index container-order">
                    <div class="col d-flex justify-content-end">
                    	<form action="${pageContext.request.contextPath}/ProductMakeOrderController">
                        	<button type="submit" class="btn-cart-order">Place Order</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="col-4">
                <div class="bg-white pt-3 pb-3 position-fixed">
                    <h5 class="text-secondary px-3">PRICE DETAILS</h5>
                    <hr class="px-0 mx-0">
                    <div class="px-3 d-flex justify-content-between">
                        <div>
                            <p>Price (${cart.productsCount } items)</p>
                        </div>
                        <div>
                            <p><fmt:formatNumber value="${cart.totalAmount}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></p>
                        </div>
                    </div>
                    <div class="px-3 d-flex justify-content-between">
                        <div>
                            <p>Discount</p>
                        </div>
                        <div>
                            <p class="text-success">-<fmt:formatNumber value="${cart.discount}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></p>
                        </div>
                    </div>
                    <div class="px-3 d-flex justify-content-between">
                        <div>
                            <p>Delivery Charges</p>
                        </div>
                        <div>
                            <p class="text-success"><strike class="text-secondary"><fmt:formatNumber value="${cart.deliveryCharges}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></strike></span> Free</p>
                        </div>
                    </div>
                    <div class="px-3 d-flex justify-content-between">
                        <div>
                            <p>Secured Packaging Fee</p>
                        </div>
                        <div>
                            <p>&#8377;59</p>
                        </div>
                    </div>
                    <hr class="mx-3 amount-line">
                    <div class="px-3 d-flex justify-content-between mt-1 fw-bold fs-5">
                        <div>
                            <p>Total Amount</p>
                        </div>
                        <div>
                            <p><fmt:formatNumber value="${cart.paidAmount}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/></p>
                        </div>
                    </div>
                    <hr class="mx-3 mt-1 amount-line">
                    <p class="px-3 text-success fw-bold">You will Save <fmt:formatNumber value="${cart.discount}" type="currency" currencySymbol="₹" minFractionDigits="0" maxFractionDigits="0"/> on this Order</p>
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
                <form action="${pageContext.request.contextPath}/CartProductIncrementController" method="post">
	                <div class="modal-body">
	                	<input type="hidden" id="productId" name="pId" value="">
	                	<input type="hidden" name="operation" value="delete">
	                    <p class="text-secondary mt-2">Are you sure you want to remove this item?</p>
	                </div>
	                 <div class="modal-footer">
	                    <button type="button" class="btn btn-outline-secondary" data-bs-dismiss="modal">Close</button>
	                    <button type="submit" class="btn  remove-cart" data-bs-dismiss="modal">Remove</button>
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
    var current_status = document.querySelector('.updation-status');
    if(current_status.innerHTML!==""){
    	if(current_status.innerHTML==="success"){
    		showToast('Product Quantity has been updated Successfully ',false);
    		current_status.innerHTML = "";
    	}else if(current_status.innerHTML!==""){
    		showToast(current_status.innerHTML,true);
    		current_status.innerHTML = "";
    	}
    	
    	
    }

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

        document.querySelectorAll('.increment-btn').forEach(input => {
            input.addEventListener('click',function(event){
                let card = event.target.closest('.card-product');
                let quantityElement = card.querySelector('.cart-count');
                let quantity = parseInt(quantityElement.value,10);
                if(quantity<10){
                    quantityElement.value = quantity+1;
                    showToast('Product Quantity has been updated Successfully ',false);
                    
                }else{
                    console.log('The Max Limit for a order is 10');
                    showToast('The Quantity Limit is 10',true); 
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
                    console.log('The Min Limit for a product is 1');
                    showToast('Minimum Quanity should be 1',true);
                }
            });
        });

        document.querySelectorAll('.confirm-delete').forEach(button =>{
            button.addEventListener('click',function(event){
                var parentProduct = event.target.closest('.card-product');
                let product_id = parentProduct.querySelector('.product-id').value;
                document.getElementById('productId').value = product_id;
                console.log(product_id);
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